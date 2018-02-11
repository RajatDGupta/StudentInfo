package com.neeraj.studentinfo.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import com.neeraj.studentinfo.R;
import com.neeraj.studentinfo.data.model.Student;
import com.neeraj.studentinfo.data.sqlite.DatabaseHandler;
import com.neeraj.studentinfo.prsenter.Adapter;
import com.neeraj.studentinfo.view.IViewProgress;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener ,IViewProgress{


    FloatingActionButton fab;
    Toolbar toolbar;
    DatabaseHandler databaseHandler;
    RecyclerView recyclerView;
    Adapter adapter;
    RecyclerView.LayoutManager mLayoutManager;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initUi();
        mapListerener();

        toolbar.setTitle("Result Activity");
        progressDialog=new ProgressDialog(this);
        progressDialog.setMessage("Loading");
        setRecyclerView();

    }

    private void setRecyclerView() {
        recyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        databaseHandler=new DatabaseHandler(this);
        int size= databaseHandler.fetchValue().size();
        if( size>0){
        adapter=new Adapter((ArrayList<Student>) databaseHandler.fetchValue(),this);
        }

        recyclerView.setAdapter(adapter);
    }

    private void mapListerener() {
        fab.setOnClickListener(this);
    }

    private void initUi() {
        fab = findViewById(R.id.fab);
        toolbar =  findViewById(R.id.toolbar);
        recyclerView=findViewById(R.id.recyclerView);

    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
         case R.id.fab:
             startActivity(new Intent(this,DataInsertActivity.class));
             break;
     }
    }


    @Override
    public void showProgress() {

        //progressDialog.show();
    }

    @Override
    public void hideProgrss()
    {
     // progressDialog.hide();
    }
}
