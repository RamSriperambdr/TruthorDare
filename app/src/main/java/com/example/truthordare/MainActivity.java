package com.example.truthordare;

import android.graphics.drawable.Animatable2;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private Button button;
    private Random random = new Random();
    private int lastDirection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int newDirection = random.nextInt(3600)+3600;

                float pivotX = imageView.getWidth()/2;
                float pivotY = imageView.getWidth()/2;

                Animation rotate = new RotateAnimation(lastDirection,newDirection,pivotX,pivotY);
                rotate.setDuration(3000);
                rotate.setFillAfter(true);
                rotate.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        button.setEnabled(false);

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        button.setEnabled(true);

                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });


                lastDirection = newDirection;

                imageView.startAnimation(rotate);
            }
        });
    }






    }

