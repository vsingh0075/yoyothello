package kids.cute.spacethello.activities;

import android.app.Activity;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;

import kids.cute.spacethello.R;

public class options extends Activity {

    int check=1;
    //get values from shared preferences;set accordingly
    SharedPreferences pref;
    SharedPreferences.Editor editor;

    boolean selectedcoin=false;
    boolean legalmoves=false;
    boolean sound=false;
    Switch legalmove;
    ImageView img;
    ToggleButton sunbtn,moonbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);

        img=(ImageView)findViewById(R.id.image_sound);
        legalmove=(Switch)findViewById(R.id.legalmoves);
        sunbtn=(ToggleButton)findViewById(R.id.sunbtn);
        moonbtn=(ToggleButton)findViewById(R.id.moonbtn);
        get_shared_preferences();


    }

    public void get_shared_preferences()
    {
        pref = getApplicationContext().getSharedPreferences("gamesettings", MODE_PRIVATE);
        editor = pref.edit();
        sound =pref.getBoolean("sound",true);
        selectedcoin=pref.getBoolean("selectedcoin",false);
        legalmoves=pref.getBoolean("legalmoves",true);
        editor.putBoolean("sound",sound);
        editor.putBoolean("legalmoves",legalmoves);
        editor.putBoolean("selectedcoin", selectedcoin);
        editor.commit();
        apply_settings();


    }
    public void apply_settings()
    {
        if(sound)
            img.setImageResource(R.drawable.sound);
        else
            img.setImageResource(R.drawable.silent);
        if(legalmoves)
            legalmove.setChecked(true);
        else
            legalmove.setChecked(false);
        if(selectedcoin)
        {
            moonbtn.setChecked(true);

            sunbtn.setChecked(false);
        }
        else
        {
            moonbtn.setChecked(false);

            sunbtn.setChecked(true);
        }
    }
    public void soundbutton(View view)
    {


        if(sound)
        {
            img.setImageResource(R.drawable.silent);

        }
        else
        {
            img.setImageResource(R.drawable.sound);
        }
        sound=!sound;
    }
    public void sunClick(View v)
    {

        sunbtn.setChecked(true);

        moonbtn.setChecked(false);
        selectedcoin=false;
    }
    public void moonClick(View v)
    {

        moonbtn.setChecked(true);

        sunbtn.setChecked(false);
        selectedcoin=true;
    }
    public void switcher_legal_moves(View v)
    {

        if(legalmove.isChecked()) {
            legalmoves = true;
        }
            else{
            legalmoves=false;

        }



    }
    public void applyclicked(View v)
    {
        Toast.makeText(this, "Settings Applied", Toast.LENGTH_SHORT).show();
        editor.putBoolean("legalmoves", legalmoves);
        editor.putBoolean("sound", sound);
        editor.putBoolean("selectedcoin",selectedcoin);
        editor.commit();
        System.exit(0);
        //Update shared preferences
        //Use intent
    }

    public void back(View view)
    {
        Toast.makeText(this, "Settings Not Saved", Toast.LENGTH_SHORT).show();
        editor.clear();
        System.exit(0);
        //Do not update shared preferences
        //Use Intent
    }
    public void Resetbtn(View v)

    {    selectedcoin=false;
        legalmoves=true;
         sound=true;

        img.setImageResource(R.drawable.sound);

        legalmove.setChecked(true);

        sunbtn.setChecked(true);


        moonbtn.setChecked(false);

        Toast.makeText(this, "Reset", Toast.LENGTH_SHORT).show();
    }
}
