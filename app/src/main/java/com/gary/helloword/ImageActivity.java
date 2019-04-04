package com.gary.helloword;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class ImageActivity  extends AppCompatActivity {

    RelativeLayout relativeLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate( savedInstanceState);
        setContentView(R.layout.activity_image);
        relativeLayout = findViewById(R.id.rl);
        ImageView imageView = new ImageView(ImageActivity.this);
        imageView.setImageResource(R.mipmap.ic_launcher);
        relativeLayout.addView(imageView);

    }
}
