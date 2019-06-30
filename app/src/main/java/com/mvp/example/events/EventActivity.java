package com.mvp.example.events;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.webkit.WebView;
import android.widget.Button;

import com.mvp.example.R;
import com.mvp.example.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.mvp.example.events.EventsListActivity.EVENT_DESCRIPTION_KEY;
import static com.mvp.example.events.EventsListActivity.EVENT_NAME_KEY;
import static com.mvp.example.events.EventsListActivity.EVENT_URL_KEY;



public class EventActivity extends BaseActivity {

    private static final String MIME_TYPE = "text/html";
    private static final String ENCODING = "UTF-8";

    private String eventHtmlDescription;
    private String eventUrl;

    @BindView(R.id.webview_event_description) WebView eventDescriptionWebView;
    @BindView(R.id.btn_event_see_more) Button eventButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String eventName = intent.getStringExtra(EVENT_NAME_KEY);
        eventHtmlDescription = intent.getStringExtra(EVENT_DESCRIPTION_KEY);
        eventUrl = intent.getStringExtra(EVENT_URL_KEY);

        getSupportActionBar().setTitle(eventName);

        setEventDescription();
    }

    private void setEventDescription() {
        eventDescriptionWebView.loadDataWithBaseURL("",
                eventHtmlDescription,
                MIME_TYPE,
                ENCODING,
                "");
    }

    @OnClick(R.id.btn_event_see_more)
    public void onSeeMore() {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(eventUrl));
        startActivity(intent);
    }

}
