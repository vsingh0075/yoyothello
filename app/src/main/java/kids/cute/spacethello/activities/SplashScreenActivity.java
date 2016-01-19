package kids.cute.spacethello.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

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
        /*
            Full Screen !!
         */

    }
    public void func(View view)
    {
        Intent in=new Intent(this,MainActivity.class);
        startActivity(in);

    }
}
