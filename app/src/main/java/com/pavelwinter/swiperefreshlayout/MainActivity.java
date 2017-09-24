package com.pavelwinter.swiperefreshlayout;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


    public class MainActivity extends AppCompatActivity{

        private SwipeRefreshLayout mSwipeRefreshLayout;
        private ListView mListView;

        private List<String> mList;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_container);

            mSwipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_bright,android.R.color.holo_orange_light,
                    android.R.color.holo_green_light,android.R.color.transparent);

            mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                @Override
                public void onRefresh() {
                    mList.clear();

                    for(int i=0;i<20;i++) {

                        mList.add(String.valueOf(new Date().getTime()));
                    }
                   mListView.invalidateViews();
                   mSwipeRefreshLayout.setRefreshing(false);
                }
            });

            mListView = (ListView)findViewById(R.id.listView);

            mList = new ArrayList<>();
            ListAdapter mAdapter = new ArrayAdapter<>(
                    this, android.R.layout.simple_list_item_1, mList);
            mListView.setAdapter(mAdapter);
        }
    }