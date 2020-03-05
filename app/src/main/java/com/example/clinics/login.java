package com.example.clinics;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
        mRecyclerView.setHasFixedSize ( true );
        mRecyclerView.setLayoutManager ( mlayoutManager );
        mRecyclerView.setAdapter ( mAdapter );
        mAdapter.SetOnItemClickListener ( new wordadapter.OnItemClickListener () {
            @Override
            public void onItemClick(int position) {
                String list1 = list.get ( position ).getmTextV1 ();
                Intent in = new Intent ( login.this, Detalis.class );
                in.putExtra ( "name", list1 );
                startActivity ( in );


            }
        } );
    }

    public void CreateArrayList() {
        list = new ArrayList<> ();
        list.add ( new wordclass ( R.drawable.heart, "العيادات", "1" ) );
        list.add ( new wordclass ( R.drawable.eye, "العيون", "2" ) );
        list.add ( new wordclass ( R.drawable.b, "التجميل", "3" ) );
    }
}
