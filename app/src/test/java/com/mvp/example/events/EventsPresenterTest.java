package com.mvp.example.events;

import com.mvp.example.data.DataManager;
import com.mvp.example.data.remote.APIError;
import com.mvp.example.data.remote.RemoteCallback;
import com.mvp.example.events.model.EventsPage;
import com.mvp.example.events.view.EventsView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class EventsPresenterTest {

    private EventsPresenter presenter;

    @Mock DataManager mockDataManager;
    @Mock EventsView mockView;

    @Captor ArgumentCaptor<RemoteCallback<EventsPage>> eventsPageRemoteCallbackCaptor;
    @Captor ArgumentCaptor<EventsPage> eventsPageCaptor;

    @Before
    public void setUp() {
        presenter = new EventsPresenter(mockDataManager);
        presenter.onViewCreated(mockView);
    }

    @Test
    public void testGetEventsCallsDataManagerAndCorrectViewMethodsOnSuccess() {
        presenter.getEvents("token", "1", "date");

        verify(mockView).showProgressView();
        verify(mockDataManager).getEventsList(anyString(),
                anyString(), anyString(), eventsPageRemoteCallbackCaptor.capture());

        eventsPageRemoteCallbackCaptor.getValue().success(null);

        verify(mockView).hideProgressView();
        verify(mockView).showEventsListView();
        verify(mockView).updateEventsList(eventsPageCaptor.capture());
    }

    @Test
    public void testGetEventsCallsDataManagerAndCorrectViewMethodsOnFailure() {
        presenter.getEvents("token", "1", "date");

        verify(mockView).showProgressView();
        verify(mockDataManager).getEventsList(anyString(), anyString(), anyString(), eventsPageRemoteCallbackCaptor.capture());

        eventsPageRemoteCallbackCaptor.getValue().failure(new APIError(404, "Not Found"));

        verify(mockView).hideProgressView();
        verify(mockView).showErrorView();
    }

}
