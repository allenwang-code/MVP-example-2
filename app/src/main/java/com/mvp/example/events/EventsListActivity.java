package com.mvp.example.events;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.mvp.example.EventApplication;
import com.mvp.example.R;
import com.mvp.example.base.BaseActivity;
import com.mvp.example.events.model.Event;
import com.mvp.example.events.model.EventsPage;
import com.mvp.example.events.view.EventClickListener;
import com.mvp.example.events.view.EventsRecyclerviewAdapter;
import com.mvp.example.events.view.EventsView;
import com.mvp.example.customview.InfiniteScrollListener;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;



public class EventsListActivity extends BaseActivity implements EventsView, EventClickListener {

    static final String EVENT_NAME_KEY = "event_name";
    static final String EVENT_DESCRIPTION_KEY = "event_html_description";
    static final String EVENT_URL_KEY = "event_url";

    private static final String SEARCH_SORT_TYPE = "date";
    private static final String API_TOKEN = "VBUSKKCQ2VTXKPOP34PX";

    @Inject EventsPresenter presenter;
    @Inject EventsRecyclerviewAdapter eventsAdapter;

    @BindView(R.id.recyclerview_events) RecyclerView recyclerviewEvents;
    @BindView(R.id.progress_bar_events) ProgressBar progressBar;
    @BindView(R.id.card_view_layout_loading_events) CardView loadingEventsCardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((EventApplication) getApplication()).getAppComponent().inject(this);
        setContentView(R.layout.activity_events);
        ButterKnife.bind(this);

        getSupportActionBar().setTitle(getString(R.string.toolbar_events_list_title));

        setupRecyclerView();

        presenter.onViewCreated(this);
        presenter.getEvents(API_TOKEN, "1", SEARCH_SORT_TYPE);
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.onViewResumed(this);
    }

    private void setupRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        eventsAdapter.setEventClickListener(this);
        recyclerviewEvents.setAdapter(eventsAdapter);
        recyclerviewEvents.setLayoutManager(linearLayoutManager);
        recyclerviewEvents.addOnScrollListener(new InfiniteScrollListener(linearLayoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                presenter.getEvents(API_TOKEN, Integer.toString(page + 1), SEARCH_SORT_TYPE);
            }
        });
    }

    @Override
    public void showProgressView() {
        loadingEventsCardView.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressView() {
        loadingEventsCardView.setVisibility(View.GONE);
    }

    @Override
    public void showErrorView() {
        Toast.makeText(this, getString(R.string.error_events_list), Toast.LENGTH_LONG);
    }

    @Override
    public void updateEventsList(EventsPage eventsPage) {
        eventsAdapter.updateEventsList(eventsPage);
    }

    @Override
    public void showEventsListView() {
        recyclerviewEvents.setVisibility(View.VISIBLE);
    }

    @Override
    public void onEventClick(int position) {
        Event event = eventsAdapter.getEvents().get(position);
        Intent intent = new Intent(this, EventActivity.class);
        intent.putExtra(EVENT_NAME_KEY, event.getName().getText());
        intent.putExtra(EVENT_DESCRIPTION_KEY, event.getDescription().getHtml());
        intent.putExtra(EVENT_URL_KEY, event.getUrl());
        startActivity(intent);
    }

    @Override
    protected void onPause() {
        presenter.onViewPaused();
        super.onPause();
    }

}
