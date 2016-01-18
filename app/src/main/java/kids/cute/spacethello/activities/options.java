package kids.cute.spacethello.activities;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import kids.cute.spacethello.R;

public class options extends Activity {
    int sound=1;
    int check=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);

    }
    public void buttonclick(View view)
    {
        view.setSelected(!view.isSelected());
        Toast.makeText(this, "message", Toast.LENGTH_SHORT).show();
    }
    public void legalmoves(View checkbox)
    {
       // if(checkbox.isSelected())
        check++;
            if(check%2==0)
                Toast.makeText(this,"Selected",Toast.LENGTH_SHORT).show();
    }

    public void soundbutton(View view)
    {
        sound++;
       ImageView img=(ImageView)findViewById(R.id.image);
        if(sound%2==0)
         img.setImageResource(R.drawable.silent);
        else
            img.setImageResource(R.drawable.sound);

    }
    public void back(View view)
    {
        Toast.makeText(this, "Back", Toast.LENGTH_SHORT).show();
    }
}
