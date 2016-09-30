package com.example.artem.myapplication.ui.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.artem.myapplication.R;
import com.example.artem.myapplication.ui.Config;

/**
 * Created by Artem on 13.09.2016.
 */
public class SecondActivity extends AppCompatActivity{
    Button btn;
    Button btn1;
    EditText editText;

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);//layout
        editText = (EditText) findViewById(R.id.edit_text);
        btn = (Button) findViewById(R.id.back);//поиск по id
        btn1 = (Button) findViewById(R.id.add_data);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this, MainActivity.class);//переход к прошлой активности
                startActivity(intent);
                finish();
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Config.txt = editText.getText().toString();//сохранение результата
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
