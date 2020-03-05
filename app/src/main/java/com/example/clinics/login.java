package com.example.clinics;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class login extends AppCompatActivity {
    private RecyclerView mRecyclerView;

    private wordadapter mAdapter;
    private LinearLayoutManager mlayoutManager;

    private ArrayList<wordclass> list;

    /// hiiiiii 3/5

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_login );
        CreateArrayList ();
        mRecyclerView = findViewById ( R.id.recyclerView );
        mlayoutManager = new LinearLayoutManager ( this );
        mAdapter = new wordadapter ( list );
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager ( mlayoutManager );
        mRecyclerView.setAdapter ( mAdapter );
    }

    public void CreateArrayList() {
        list = new ArrayList<> ();
        list.add ( new wordclass ( R.drawable.heart, "text1", "text" ) );
        list.add ( new wordclass ( R.drawable.eye, "text2", "text" ) );
        list.add ( new wordclass ( R.drawable.b, "text3", "text" ) );
    }
}
