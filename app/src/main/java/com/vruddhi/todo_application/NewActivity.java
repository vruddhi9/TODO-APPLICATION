package com.vruddhi.todo_application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class NewActivity extends AppCompatActivity {

    private ArrayList<String> activity = new ArrayList<>();
    private EditText itemET;
    private Button addItem;
    private ListView itemsList;
    // Array Adapter is used for managing the Items in the list or grid view
    ArrayAdapter<String>  arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);
        itemET = (EditText) findViewById(R.id.editText);
        addItem = (Button) findViewById(R.id.add);
        itemsList = (ListView) findViewById(R.id.list_item);

        Intent intent = getIntent();
        String text = intent.getStringExtra(MainActivity.EXTRA_STRING);
        TextView textView = findViewById(R.id.textview);
        textView.setText(text);
        arrayAdapter = new ArrayAdapter<String>(getApplicationContext(),R.layout.customlist,activity);

        addItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String task = itemET.getText().toString();
                if (TextUtils.isEmpty(task)){
                    Toast.makeText(NewActivity.this, "Enter the Task", Toast.LENGTH_SHORT).show();
                }
                else{
                    activity.add(task);
                    itemsList.setAdapter(arrayAdapter);
                    arrayAdapter.notifyDataSetChanged();
                }
            }
        });
    }
}