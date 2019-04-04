package com.gary.helloword;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class RadioButtonActivity extends Activity {

    RadioButton male;
    RadioButton female;
    RadioGroup radioGroup;


    CheckBox all;
    CheckBox box1;
    CheckBox box2;

    ProgressBar progress1;
    ProgressBar progressHor;

    int progress = 0;
    private Handler mHandler;

    SeekBar seekBar;
    TextView textSeekBar;

    RatingBar ratingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.radiobutton);
        initView();

        initDoor();

    }


    void initDoor(){


        new Door(){
            @Override
            public void OpenDoor() {
                super.OpenDoor();
            }

            @Override
            public void lockDoor() {
                super.lockDoor();
            }
        };


        Door door = new Door(new Door.DoorCallback() {
            @Override
            public void openDoor() {
                Log.e("test","openDoor");
            }

            @Override
            public void lockDoor() {
                Log.e("test","lockDoor");
            }
        });




    }



    void initView(){
        male = findViewById(R.id.male);
        female = findViewById(R.id.female);
        radioGroup = findViewById(R.id.radiogroup);

        male.setChecked(true);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                switch (checkedId){
                    case R.id.female:
                        Toast.makeText(getApplicationContext(),"NV",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.male:
                        Toast.makeText(getApplicationContext(),"Nan",Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });



        all = findViewById(R.id.all);
        all.setVisibility(View.GONE);
        box1 = findViewById(R.id.box1);
        box2 = findViewById(R.id.box2);


        all.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    box1.setChecked(true);
                    box2.setChecked(true);
                }else{
                    box1.setChecked(false);
                    box2.setChecked(false);
                }
            }
        });



        progress1 = findViewById(R.id.progress1);
        progress1.setVisibility(View.VISIBLE);
        progress1.setVisibility(View.GONE);
        progress1.setVisibility(View.INVISIBLE);


        progressHor = findViewById(R.id.hor_progress);

        new Thread(){
                @Override
                public void run() {
                    super.run();
                }
        }.start();

        //定时执行任务
        mHandler =  new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if(progressHor.getProgress() != progressHor.getMax()) {
                    progressHor.setProgress(++progress);
                    mHandler.sendMessageDelayed(new Message(), 100);
                    Log.e("test123",progressHor.getProgress()+"--------"+progressHor.getMax());

                }

            }
        };


        Message msg = new Message();
        msg.arg1 = progress;
        mHandler.sendMessageDelayed(msg,100);





        seekBar = findViewById(R.id.seekbar);
        textSeekBar = findViewById(R.id.text_seekbar);
        textSeekBar.setText("当前进度值："+seekBar.getProgress()+"/"+seekBar.getMax());


        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textSeekBar.setText("当前进度值："+progress+"/"+seekBar.getMax());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        ratingBar = findViewById(R.id.ratingbar);

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                textSeekBar.setText("当前rating评分"+rating+"/"+ratingBar.getNumStars());
            }
        });


        ratingBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });





    }
}
