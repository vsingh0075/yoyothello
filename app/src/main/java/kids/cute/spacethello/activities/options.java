package kids.cute.spacethello.activities;

import android.app.Activity;
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
    boolean selectedcoin=false;
    boolean legalmoves=false;
    boolean sound=false;
    Switch legalmove;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
        ToggleButton sunbtn=(ToggleButton)findViewById(R.id.sunbtn);
        sunbtn.setChecked(true);
    }


    public void soundbutton(View view)
    {
        sound=!sound;
       ImageView img=(ImageView)findViewById(R.id.image);
        if(!sound)
        {
            img.setImageResource(R.drawable.silent);

        }
        else
            img.setImageResource(R.drawable.sound);

    }
    public void sunclick(View v)
    {   Toast.makeText(this,"Sun",Toast.LENGTH_LONG).show();
        ToggleButton sunbtn=(ToggleButton)findViewById(R.id.sunbtn);
        sunbtn.setChecked(true);
        ToggleButton moonbtn=(ToggleButton)findViewById(R.id.moonbtn);

        moonbtn.setChecked(false);
        selectedcoin=false;
    }
    public void moonclick(View v)
    {
        ToggleButton moonbtn=(ToggleButton)findViewById(R.id.moonbtn);
        moonbtn.setChecked(true);
        ToggleButton sunbtn=(ToggleButton)findViewById(R.id.sunbtn);
        sunbtn.setChecked(false);
        selectedcoin=true;
    }
    public void switcher_legal_moves(View v)
    {
        legalmove=(Switch)findViewById(R.id.legalmoves);
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
        //Update shared preferences
        //Use intent
    }

    public void back(View view)
    {
        Toast.makeText(this, "Settings Not Saved", Toast.LENGTH_SHORT).show();
        //Do not update shared preferences
        //Use Intent
    }
    public void Resetbtn(View v)
    {    selectedcoin=false;
        legalmoves=false;
         sound=false;

        Toast.makeText(this, "Reset", Toast.LENGTH_SHORT).show();
    }
}
