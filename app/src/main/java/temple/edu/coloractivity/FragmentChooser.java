package temple.edu.coloractivity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;


public class FragmentChooser extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ColorAdapter coloradapter;
    Context Parent;


    public FragmentChooser() {
        // Required empty public constructor
    }

    public static FragmentChooser newInstance(String[] colors, String[] names) {
        FragmentChooser fragment = new FragmentChooser();
        Bundle args = new Bundle();
        args.putStringArray("colors", colors);
        args.putStringArray("colornames", names);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        this.Parent = context;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_fragment_chooser, container, false);
//        final String[] colors = getResources().getStringArray(R.array.colors);
//        String[] colornames = getResources().getStringArray(R.array.colornames);
        String[] colornames = getArguments().getStringArray("colornames");
        String[] colors = getArguments().getStringArray("colors");
        coloradapter = new ColorAdapter(getContext(),colornames,colors);
        Spinner myspinner = rootView.findViewById(R.id.spinner);
        myspinner.setAdapter(coloradapter);
        myspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                if(i!=0){
                    ColorAdapter ca= (ColorAdapter)adapterView.getAdapter();
                    int color= Color.parseColor(ca.getItem(i).toString());
                    ((ColorListener)Parent).onColorSelected(color);
//                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
//        return inflater.inflate(R.layout.fragment_fragment_chooser, container, false);
        return rootView;
    }


    // This interface can be implemented by the Activity, parent Fragment,
    // or a separate test implementation.
    public interface ColorListener {
        public void onColorSelected(int color);
    }


}
