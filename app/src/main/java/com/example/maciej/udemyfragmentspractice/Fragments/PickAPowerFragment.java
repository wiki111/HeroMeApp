package com.example.maciej.udemyfragmentspractice.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.maciej.udemyfragmentspractice.Activities.MainActivity;
import com.example.maciej.udemyfragmentspractice.Constants;
import com.example.maciej.udemyfragmentspractice.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PickAPowerFragment.PickAPowerInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PickAPowerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PickAPowerFragment extends Fragment implements View.OnClickListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private Button turtleBtn;
    private Button lightningBtn;
    private Button flightBtn;
    private Button webBtn;
    private Button laserBtn;
    private Button superBtn;
    private Button backstoryBtn;

    private PickAPowerInteractionListener mListener;

    public PickAPowerFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PickAPowerFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PickAPowerFragment newInstance(String param1, String param2) {
        PickAPowerFragment fragment = new PickAPowerFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
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

        View view = inflater.inflate(R.layout.fragment_pick_apower, container, false);

        turtleBtn = (Button)view.findViewById(R.id.turtleBtn);
        lightningBtn = (Button)view.findViewById(R.id.lightningBtn);
        flightBtn = (Button)view.findViewById(R.id.flightBtn);
        webBtn = (Button)view.findViewById(R.id.webBtn);
        laserBtn = (Button)view.findViewById(R.id.laserBtn);
        superBtn = (Button)view.findViewById(R.id.superBtn);
        backstoryBtn = (Button)view.findViewById(R.id.backstoryBtn);

        backstoryBtn.setEnabled(false);
        backstoryBtn.getBackground().setAlpha(128);
        backstoryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity activity = (MainActivity)getActivity();
                activity.loadBackstoryScreen();
            }
        });

        turtleBtn.setOnClickListener(this);
        lightningBtn.setOnClickListener(this);
        flightBtn.setOnClickListener(this);
        webBtn.setOnClickListener(this);
        laserBtn.setOnClickListener(this);
        superBtn.setOnClickListener(this);

        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof PickAPowerInteractionListener) {
            mListener = (PickAPowerInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnPickAPowerInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View view) {
        backstoryBtn.setEnabled(true);
        backstoryBtn.getBackground().setAlpha(255);

        Button btn = (Button) view;
        turtleBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.turtle_power, 0, R.drawable.item_unselected, 0 );
        lightningBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.thors_hammer, 0, R.drawable.item_unselected, 0 );
        flightBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.super_man_crest, 0, R.drawable.item_unselected, 0);
        webBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.spider_web, 0, R.drawable.item_unselected, 0);
        laserBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.laser_vision, 0, R.drawable.item_unselected, 0);
        superBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.super_strength, 0, R.drawable.item_unselected, 0);

        int leftDrawable = 0;

        if(btn == turtleBtn){
            leftDrawable = R.drawable.turtle_power;
            mListener.onPickAPowerInteraction(Constants.turtle_opt);
        }else if(btn == lightningBtn){
            leftDrawable = R.drawable.thors_hammer;
            mListener.onPickAPowerInteraction(Constants.lightning_opt);
        }else if(btn == flightBtn){
            leftDrawable = R.drawable.super_man_crest;
            mListener.onPickAPowerInteraction(Constants.flight_opt);
        }else if(btn == webBtn){
            leftDrawable = R.drawable.spider_web;
            mListener.onPickAPowerInteraction(Constants.web_opt);
        }else if(btn == laserBtn){
            leftDrawable = R.drawable.laser_vision;
            mListener.onPickAPowerInteraction(Constants.laser_opt);
        }else if(btn == superBtn){
            leftDrawable = R.drawable.super_strength;
            mListener.onPickAPowerInteraction(Constants.super_opt);
        }

        btn.setCompoundDrawablesWithIntrinsicBounds(leftDrawable, 0, R.drawable.item_selected, 0);
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
    public interface PickAPowerInteractionListener {
        // TODO: Update argument type and name
        void onPickAPowerInteraction(int chosenOption);
    }
}
