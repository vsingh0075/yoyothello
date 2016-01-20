package kids.cute.spacethello.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import kids.cute.spacethello.R;

public class MainActivity extends Activity {
    public boolean sound;
    SharedPreferences.Editor editor;
    SharedPreferences pref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        set_shared_preferences();
        /*
            Full Screen !!
         */

    }
    public  void set_shared_preferences()
    {
         pref = getApplicationContext().getSharedPreferences("gamesettings", MODE_PRIVATE);
         editor = pref.edit();

        boolean sound=pref.getBoolean("sound",true);
        editor.putBoolean("sound",sound);
        editor.commit();
        ImageView img=(ImageView)findViewById(R.id.sound);
        if(sound)
        {
            img.setImageResource(R.drawable.sound);
            //sound=true;

        }
        else
        {
            img.setImageResource(R.drawable.silent);
            //sound=false;
        }

    }
    public void toggle(View view){
        ImageView img=(ImageView)findViewById(R.id.sound);
        if(sound==false)
        {
            img.setImageResource(R.drawable.sound);
            sound=true;

        } else {
            img.setImageResource(R.drawable.silent);
            sound=false;

        }
        editor.putBoolean("sound",sound);
        editor.commit();
    }
    public void optionsclicked(View v)
    {
        Intent in=new Intent(this,options.class);
        startActivity(in);
    }
    public void SinglePlayer(View view)
    {
       Intent in=new Intent(this,SinglePlayer.class);
        startActivity(in);

    }

}
