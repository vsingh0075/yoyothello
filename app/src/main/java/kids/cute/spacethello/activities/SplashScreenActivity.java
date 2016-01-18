package kids.cute.spacethello.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;


import kids.cute.spacethello.R;

/**
 * Created by vikrant on 1/17/16.
 */
public class SplashScreenActivity extends Activity {

    private final long SPLASH_DURATION=3000;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.splash_screen_activity_layout);
        context=this;

        ImageView imgView = (ImageView)findViewById(R.id.jupiter_image);
        imgView.requestLayout();
        imgView.getLayoutParams().height = 400;
        imgView.getLayoutParams().width = 400;
        imgView.setBackgroundResource(R.drawable.animate);
        AnimationDrawable animationDrawable = (AnimationDrawable) imgView.getBackground();
        animationDrawable.start();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(context,MainActivity.class);
                startActivity(i);
            }
        },SPLASH_DURATION);

    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
        /*
            Full Screen !!
         */

    }
}
