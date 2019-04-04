package com.gary.helloword;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int count = 0;
    private TextView tv;
    private Button btn;
    private Button btnTest;
    RelativeLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }

    void initView(){

        tv =  findViewById(R.id.text);
        btn = findViewById(R.id.btn);
        layout = findViewById(R.id.layout);
        btnTest = findViewById(R.id.btn_test);

        tv.setText(count+"");

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setText(++count+"");

                int rvalue = (int)(Math.random()*255) +1;
                int gvalue = (int)(Math.random()*255) +1;
                int bvalue = (int)(Math.random()*255) +1;

                btn.setBackgroundColor(Color.rgb(rvalue,gvalue,bvalue));
                tv.setBackgroundColor(Color.rgb((int)(Math.random()*255+1),(int)(Math.random()*255+1),(int)(Math.random()*255+1)));
                layout.setBackgroundColor(Color.rgb((int)(Math.random()*255+1),(int)(Math.random()*255+1),(int)(Math.random()*255+1)));

                if(count == 10){
                    //跳转到图片界面
                    Intent intent = new Intent(MainActivity.this,ImageActivity.class);
                    startActivity(intent);
                }
            }
        });

        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setText(++count+"");

                int rvalue = (int)(Math.random()*255) +1;
                int gvalue = (int)(Math.random()*255) +1;
                int bvalue = (int)(Math.random()*255) +1;

                btn.setBackgroundColor(Color.rgb(rvalue,gvalue,bvalue));
                //上一方法更简洁
                tv.setBackgroundColor(Color.rgb((int)(Math.random()*255+1),(int)(Math.random()*255+1),(int)(Math.random()*255+1)));
                layout.setBackgroundColor(Color.rgb((int)(Math.random()*255+1),(int)(Math.random()*255+1),(int)(Math.random()*255+1)));

                if(count == 10){
                    //跳转到图片界面
                    Intent intent = new Intent(MainActivity.this,ImageActivity.class);
                    startActivity(intent);
                }
            }
        });


        btnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,RadioButtonActivity.class);
                startActivity(intent);
            }
        });


    }
}
