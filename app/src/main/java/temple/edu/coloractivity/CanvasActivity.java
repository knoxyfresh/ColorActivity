package temple.edu.coloractivity;

import android.graphics.Color;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.TextView;

public class CanvasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas);
        String color= "white";
        Bundle extras = getIntent().getExtras();
        if(extras!=null){
            color = extras.getString("color");
            TextView txt = findViewById(R.id.textColor);
            txt.setText(color);
        }
        this.getWindow().getDecorView().setBackgroundColor(Color.parseColor(color));
    }

}
