package com.example.edit_text_and_buttons;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText et_id;
    Button btn_test;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_id = findViewById(R.id.et_id);   //activity_main.xml에 만들어 놓은 editText와 연결
        btn_test = findViewById(R.id.btn_test);  //위와 동일하게 xml에 만들어 놓은 button과 연결

        btn_test.setOnClickListener(new View.OnClickListener() {   // 버튼을 눌렀을 때 일어날 일
            @Override
            public void onClick(View v) {
                et_id.setText("땡! 틀렸습니다");
            }
        });



    }
}