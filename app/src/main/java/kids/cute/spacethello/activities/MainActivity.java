package kids.cute.spacethello.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import kids.cute.spacethello.R;

public class MainActivity extends Activity {
    public int sound=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        /*
            Full Screen !!
         */

    }
    public void toggle(View view){
        ImageView img=(ImageView)findViewById(R.id.sound);
        if(sound==0)
        {
            img.setImageResource(R.drawable.sound);
            sound=1;
        }
        else
        {
            img.setImageResource(R.drawable.silent);
            sound=0;
        }
    }

}
