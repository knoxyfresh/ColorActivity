package temple.edu.coloractivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
        String colors[] = {"white","Red","cyan","yellow","gray","black","green","blue","teal","olive"};
        String colornames[] = {getString(R.string.white),getString(R.string.red),getString(R.string.cyan),getString(R.string.yellow),getString(R.string.gray),getString(R.string.black),getString(R.string.green),getString(R.string.blue),getString(R.string.teal),getString(R.string.olive)};
        ColorAdapter ca = new ColorAdapter(PaletteActivity.this,colornames,colors);

        myspinner.setAdapter(ca);
        myspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(i>0){
                    Intent intent = new Intent(getApplicationContext(), CanvasActivity.class);
                    String color = adapterView.getItemAtPosition(i).toString();
                    Log.e("color name",color);
                    intent.putExtra("color",color);
                    startActivity(intent);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }


}
