package temple.edu.coloractivity;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FragmentColor.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FragmentColor#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentColor extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "color";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam2;
    private int colorint=0;
    private OnFragmentInteractionListener mListener;

    public FragmentColor() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
//     * @param param1 Parameter 1.
//     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentColor.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentColor newInstance(int color) {
        FragmentColor fragment = new FragmentColor();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1,color);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            colorint = getArguments().getInt(ARG_PARAM1);
//
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }else{
//            Log.w("OY","Color not found bye!");
//        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
            View v = inflater.inflate(R.layout.fragment_fragment_color, container, false);
        // Inflate the layout for this fragment
        if (getArguments() != null) {
            colorint = getArguments().getInt(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
            v.setBackgroundColor(colorint);
        }else{
            Log.w("OY","Color not found bye!");
        }
            return v;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);


//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//           // throw new RuntimeException(context.toString()
//                   // + " must implement OnFragmentInteractionListener");
//        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
