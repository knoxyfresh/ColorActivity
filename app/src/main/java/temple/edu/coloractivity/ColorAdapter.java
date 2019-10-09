package temple.edu.coloractivity;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ColorAdapter extends BaseAdapter {

    Context context;
    String colors[];
    String colornames[];

    public ColorAdapter(Context context, String[] colornames, String[] colors){
        this.context=context;
        this.colors=colors;
        this.colornames=colornames;
    }

    @Override
    public int getCount() {
        return colors.length;
    }

    @Override
    public Object getItem(int i) {
        return colors[i];
    }
    public String getColorName(int i){return colornames[i];}


    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        TextView textView = new TextView(context);
        String colorval = colors[i];
        textView.setBackgroundColor(Color.parseColor(colorval));
        textView.setText(colornames[i]);
        textView.setTextSize(22);
        textView.setPadding(5,5,5,5);
        return textView;
    }
}