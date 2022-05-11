package com.example.intentexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btn_move;
    private EditText et_change;
    private String str;
    private ImageView iv_test;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_change = findViewById(R.id.et_change);        //edit text를 연결

        btn_move = findViewById(R.id.btn_move);                 //버튼의 함수와 실제 버튼을 연결
        btn_move.setOnClickListener(new View.OnClickListener() { //버튼을 누르면
            @Override
            public void onClick(View v) {
                str = et_change.getText().toString();            //변수 str에 et_change값을 가져와 저장. toString()을 사용하여 string 폼으로 만들어주기
                Intent intent = new Intent(MainActivity.this, SubActivity.class);  // Intent 안에 값을 처음엔 현재 위치 두번째에는 이동 할 곳의 위치
                intent.putExtra("str",str);      //str 데이터를 putExtra()함수를 이용하여 전송
                startActivity(intent);  // 실제적으로 엑티비티 이동 시켜줌
            }
        });

        iv_test = (ImageView)findViewById(R.id.iv_test);
        iv_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"이건 좀 헷갈린다",Toast.LENGTH_SHORT).show();
            }
        });
    }
}