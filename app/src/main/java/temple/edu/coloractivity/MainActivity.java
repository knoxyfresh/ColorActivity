package temple.edu.coloractivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity implements FragmentChooser.ColorListener {

    FragmentChooser chooser;
    FragmentColor showcolor;
    FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fm = getSupportFragmentManager();
        chooser = new FragmentChooser();
        showcolor = new FragmentColor();
        fm.beginTransaction().replace(R.id.frameTop,chooser).commit();

        //Spinner myspinner = findViewById(R.id.spinner);
        /*String colors[] = getResources().getStringArray(R.array.colors);
        String colornames[] = getResources().getStringArray(R.array.colornames);
        ColorAdapter ca = new ColorAdapter(MainActivity.this,colornames,colors);

        myspinner.setAdapter(ca);
        myspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(i>0){

                    ColorAdapter adapter = (ColorAdapter) adapterView.getAdapter();
                    String colorname = adapter.getColorName(i);
                    String color = adapter.getItem(i).toString();
                    Log.e("color name",color);

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });*/


    }
    @Override
    public void onColorSelected(int color){
        Log.wtf("OY",Integer.toString(color));
//        Bundle bundle = new Bundle();
//        bundle.putInt("color",color);
//        showcolor.setArguments(bundle);
        showcolor = FragmentColor.newInstance(color);
        fm.beginTransaction()
                .replace(R.id.frameBottom, showcolor)
                .addToBackStack(null)
                .commit();

    }
}
