package com.example.sharedexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText et_save;
    String shared = "file";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_save = (EditText)findViewById(R.id.et_save);

        SharedPreferences sharedPreferences= getSharedPreferences(shared, 0);   //sharedpreference 라는 함수 안에 결과값 저장
        String value = sharedPreferences.getString("chung","");    //프로그램이 destroy되었다가 다시 열었을 때 저장되어있던 value값을 불러와
        et_save.setText(value);                                                 //editText쪽에 그 값을 보야주어라
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();

        SharedPreferences sharedPreferences = getSharedPreferences(shared, 0);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        String value = et_save.getText().toString();   //value 안에 editorText값을 string 형태로 저장
        editor.putString("chung",value);
        editor.commit();


    }
}