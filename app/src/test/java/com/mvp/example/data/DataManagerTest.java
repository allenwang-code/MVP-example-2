package com.mvp.example.data;

import com.mvp.example.data.remote.RemoteCallback;
import com.mvp.example.events.model.EventsPage;
import com.mvp.example.events.service.EventBriteService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import retrofit2.Call;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DataManagerTest {

    private DataManager dataManager;

    @Mock EventBriteService mockEventBriteService;
    @Mock RemoteCallback<EventsPage> mockRemoteCallback;
    @Mock Call<EventsPage> mockCall;

    @Captor ArgumentCaptor<RemoteCallback<EventsPage>> eventsPageRemoteCallbackCaptor;

    @Before
    public void setup() {
        dataManager = new DataManager(mockEventBriteService);
    }

    @Test
    public void testGetEventsListCallsCorrectEventBriteServiceMethod() {
        when(mockEventBriteService.getEventsList(anyString(), anyString(), anyString())).thenReturn(mockCall);
        dataManager.getEventsList("token", "1", "date", mockRemoteCallback);
        verify(mockCall).enqueue(eventsPageRemoteCallbackCaptor.capture());
    }

}
