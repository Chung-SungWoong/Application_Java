package com.example.intentexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SubActivity extends AppCompatActivity {

    private TextView tv_sub;
    private Button btn_back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        tv_sub = findViewById(R.id.tv_sub);     // text view 연결
        btn_back = findViewById(R.id.btn_back);

        Intent intent = getIntent();                            // intent 가져옴 선언
        String str = intent.getStringExtra("str");        // MainActivity 에서 넘긴 putExtra()에 담긴 str을 가져옴 (name:str) 은 별명

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(SubActivity.this,MainActivity.class);
                startActivity(intent1);
            }
        });
        tv_sub.setText(str);
    }
}