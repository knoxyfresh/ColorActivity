package temple.edu.coloractivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

public class PaletteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner myspinner = findViewById(R.id.spinner);
        String colors[] = getResources().getStringArray(R.array.colors);
        String colornames[] = getResources().getStringArray(R.array.colornames);
        ColorAdapter ca = new ColorAdapter(PaletteActivity.this,colornames,colors);

        myspinner.setAdapter(ca);
        myspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(i>0){
                    Intent intent = new Intent(getApplicationContext(), CanvasActivity.class);
                    ColorAdapter adapter = (ColorAdapter) adapterView.getAdapter();
                    String colorname = adapter.getColorName(i);
                    String color = adapter.getItem(i).toString();
                    Log.e("color name",color);
                    intent.putExtra("color",color);
                    intent.putExtra("colorname",colorname);
                    startActivity(intent);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }


}
