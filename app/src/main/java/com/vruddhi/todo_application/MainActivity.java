package com.vruddhi.todo_application;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
public class MainActivity extends AppCompatActivity implements RecyclerViewAdaptor.OnNoteListener {

    private EditText editText;
    private ArrayList<String> schedulde_name = new ArrayList<>();
    private String scheduled;
    public static final String EXTRA_STRING = "CARD VIEW";
    private RecyclerView.Adapter adaptor;
    FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText);
        floatingActionButton = findViewById(R.id.fab);
        recyclerView();
        addschedule();
    }

    public void addschedule(){
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scheduled = editText.getText().toString();
                if (TextUtils.isEmpty(scheduled))
                {
                    Toast.makeText(MainActivity.this, "Enter Schedule", Toast.LENGTH_SHORT).show();
                }
                else{
                    schedulde_name.add(0,scheduled);
                    Toast.makeText(MainActivity.this, "Schedule Added", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void recyclerView(){
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        adaptor = new RecyclerViewAdaptor(schedulde_name, this);
        recyclerView.setAdapter(adaptor);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }


    @Override
    public void onNoteClick(int postion) {
        Intent intent = new Intent(MainActivity.this,NewActivity.class);
        intent.putExtra(EXTRA_STRING,schedulde_name);
        startActivity(intent);
    }
}
