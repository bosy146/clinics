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
//                Intent in = new Intent ( login.this, Detalis.class );
//                in.putExtra ( "name", list1 );
//                startActivity ( in );

                // هنا هتدخلى على الصفحات حسب ال position فى ال list
                switch (position) {
                    case 0:
                        startActivity ( new Intent ( login.this, Detalis.class ) );
                        break;
                    case 1:
                        startActivity ( new Intent ( login.this, Detalis.class ) );
                        break;
                }

            }
        } );
    }

    public void CreateArrayList() {
        list = new ArrayList<> ();
        list.add ( new wordclass ( R.drawable.heart, "منتجع صحى و صاله العاب رياضيه", "1" ) );
        list.add ( new wordclass ( R.drawable.b, "مركز تجميل", "2" ) );
        list.add ( new wordclass ( R.drawable.doctor, "العيادات", "3" ) );
        list.add ( new wordclass ( R.drawable.skeleton, "مركز اشاعات", "4" ) );
        list.add ( new wordclass ( R.drawable.fruit, "منتجات طبيعيه", "5" ) );
        list.add ( new wordclass ( R.drawable.baby, "ساحه اطفال", "6" ) );
        list.add ( new wordclass ( R.drawable.mug, "كافيتريا", "7" ) );
    }
}
