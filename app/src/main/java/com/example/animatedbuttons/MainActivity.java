package com.example.animatedbuttons;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    private ImageButton download;
    private ImageButton upload;
    private ImageButton send;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        download = findViewById(R.id.download_button);
        upload = findViewById(R.id.upload);
        send = findViewById(R.id.send);

        download.setOnClickListener(new DownloadHandle());
        upload.setOnClickListener(new UploadHandle());
        send.setOnClickListener(new SendHandle());
    }

    private class DownloadHandle implements View.OnClickListener {
        @SuppressLint("NewApi")
        @Override
        public void onClick(View button) {
            ((ViewGroup) button.getParent()).removeViewAt(1);
            Animation scaleAnimation = new ScaleAnimation(
                    1f, .3f, 1f, 1f,
                    Animation.RELATIVE_TO_SELF, .5f,
                    Animation.RELATIVE_TO_SELF, .5f);
            scaleAnimation.setFillAfter(true);
            scaleAnimation.setDuration(500);

            button.setBackground(getResources().getDrawable(R.drawable.download_circle));
            button.setForegroundGravity(Gravity.FILL);
            button.setForeground(getResources().getDrawable(R.drawable.loading));

            Animation rotateAnimation = new RotateAnimation(
                    0, 359,
                    Animation.RELATIVE_TO_SELF, 0.5f,
                    Animation.RELATIVE_TO_SELF, 0.5f);
            rotateAnimation.setRepeatCount(1);
            rotateAnimation.setStartOffset(500);
            rotateAnimation.setDuration(1000);

            AnimationSet animations = new AnimationSet(true);
            animations.addAnimation(scaleAnimation);
            animations.addAnimation(rotateAnimation);

            button.startAnimation(animations);

            animations.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {

                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(140, 140);
                    params.bottomMargin = 30;
                    download.setLayoutParams(params);
                    download.setBackground(getResources().getDrawable(R.drawable.download_default));
                    download.setForegroundGravity(Gravity.CENTER);
                    download.setForeground(getResources().getDrawable(R.drawable.download));
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });
        }
    }

    private class SendHandle implements View.OnClickListener {
        @SuppressLint("NewApi")
        @Override
        public void onClick(View button) {
            ((ViewGroup) button.getParent()).removeViewAt(1);
            Animation scaleAnimation = new ScaleAnimation(1f, .3f, 1f, 1f, Animation.RELATIVE_TO_SELF, .5f, Animation.RELATIVE_TO_SELF, .5f);
            scaleAnimation.setFillAfter(true);
            scaleAnimation.setDuration(500);

            button.setBackground(getResources().getDrawable(R.drawable.send_circle));
            button.setForegroundGravity(Gravity.FILL);
            button.setForeground(getResources().getDrawable(R.drawable.refresh));

            Animation rotateAnimation = new RotateAnimation(0, 359, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
            rotateAnimation.setRepeatCount(1);
            rotateAnimation.setStartOffset(500);
            rotateAnimation.setDuration(1000);

            AnimationSet animations = new AnimationSet(true);
            animations.addAnimation(scaleAnimation);
            animations.addAnimation(rotateAnimation);

            button.startAnimation(animations);

            animations.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {

                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(140, 140);
                    params.bottomMargin = 30;
                    send.setLayoutParams(params);
                    send.setBackground(getResources().getDrawable(R.drawable.send_default));
                    send.setForegroundGravity(Gravity.CENTER);
                    send.setForeground(getResources().getDrawable(R.drawable.email));
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });
        }
    }

    private class UploadHandle implements View.OnClickListener {
        @SuppressLint("NewApi")
        @Override
        public void onClick(View button) {
            ((ViewGroup) button.getParent()).removeViewAt(1);
            Animation scaleAnimation = new ScaleAnimation(1f, .3f, 1f, 1f, Animation.RELATIVE_TO_SELF, .5f, Animation.RELATIVE_TO_SELF, .5f);
            scaleAnimation.setFillAfter(true);
            scaleAnimation.setDuration(500);

            button.setBackground(getResources().getDrawable(R.drawable.upload_circle));
            button.setForegroundGravity(Gravity.FILL);
            button.setForeground(getResources().getDrawable(R.drawable.refresh_button));

            Animation rotateAnimation = new RotateAnimation(0, 359, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
            rotateAnimation.setRepeatCount(1);
            rotateAnimation.setStartOffset(500);
            rotateAnimation.setDuration(1000);

            AnimationSet animations = new AnimationSet(true);
            animations.addAnimation(scaleAnimation);
            animations.addAnimation(rotateAnimation);

            button.startAnimation(animations);

            animations.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {

                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(140, 140);
                    params.bottomMargin = 30;
                    upload.setLayoutParams(params);
                    upload.setBackground(getResources().getDrawable(R.drawable.upload_default));
                    upload.setForegroundGravity(Gravity.CENTER);
                    upload.setForeground(getResources().getDrawable(R.drawable.upload));
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });
        }
    }
}
