package com.example.maciej.udemyfragmentspractice.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.SpannableString;
import android.text.style.LeadingMarginSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.maciej.udemyfragmentspractice.Activities.MainActivity;
import com.example.maciej.udemyfragmentspractice.R;

public class BackstoryFragment extends Fragment implements View.OnClickListener {

    private BackstoryInteractionListener mListener;

    private int source;
    private int power;
    private String backstory;
    private int drawableIcon;
    private int primaryDrawable;
    private String primaryText;
    private int secondaryDrawable;
    private String secondaryText;
    private String title;

    static SpannableString createIndentedText(String text, int marginFirstLine, int marginNextLines) {
        SpannableString result=new SpannableString(text);
        result.setSpan(new LeadingMarginSpan.Standard(marginFirstLine, marginNextLines),0,text.length(),0);
        return result;
    }

    public BackstoryFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
           this.source = getArguments().getInt("source");
           this.power = getArguments().getInt("power");
        }

        switch (source){
            case 1:
                switch (power){
                    case 4:
                        drawableIcon = R.drawable.big_superman_logo;
                        primaryDrawable = R.drawable.turtle_power;
                        secondaryDrawable = R.drawable.thors_hammer;
                        primaryText = "Turtle power";
                        secondaryText = "Lightning";
                        backstory = getString(R.string.backstory1);
                        title = "TURTLE WIZARD";
                        break;
                    case 5:
                        drawableIcon = R.drawable.big_superman_logo;
                        primaryDrawable = R.drawable.thors_hammer;
                        secondaryDrawable = R.drawable.super_man_crest;
                        primaryText = "Lightning";
                        secondaryText = "Flight";
                        backstory = getString(R.string.backstory2);
                        title = "THOR";
                        break;
                    case 6:
                        drawableIcon = R.drawable.big_superman_logo;
                        primaryDrawable = R.drawable.super_man_crest;
                        secondaryDrawable = R.drawable.laser_vision;
                        primaryText = "Flight";
                        secondaryText = "Laser Vision";
                        backstory = getString(R.string.backstory1);
                        title = "SUPERMAN";
                        break;
                    case 7:
                        drawableIcon = R.drawable.big_superman_logo;
                        primaryDrawable = R.drawable.spider_web;
                        secondaryDrawable = R.drawable.super_strength;
                        primaryText = "Web Slinging";
                        secondaryText = "Super Strength";
                        backstory = getString(R.string.backstory2);
                        title = "SPIDERMAN";
                        break;
                    case 8:
                        drawableIcon = R.drawable.big_superman_logo;
                        primaryDrawable = R.drawable.laser_vision;
                        secondaryDrawable = R.drawable.super_strength;
                        primaryText = "Laser Vision";
                        secondaryText = "Super Strength";
                        backstory = getString(R.string.backstory1);
                        title = "CYCLOPS";
                        break;
                    case 9:
                        drawableIcon = R.drawable.big_superman_logo;
                        primaryDrawable = R.drawable.super_strength;
                        secondaryDrawable = R.drawable.thors_hammer;
                        primaryText = "Super Strength";
                        secondaryText = "Lightning";
                        backstory = getString(R.string.backstory2);
                        title = "VILGEFORTZ";
                        break;
                }
                break;
            case 2:
                switch (power){
                    case 4:
                        drawableIcon = R.drawable.big_superman_logo;
                        primaryDrawable = R.drawable.turtle_power;
                        secondaryDrawable = R.drawable.thors_hammer;
                        primaryText = "Turtle power";
                        secondaryText = "Lightning";
                        backstory = getString(R.string.backstory3);
                        title = "OH I\'M SO HIGH";
                        break;
                    case 5:
                        drawableIcon = R.drawable.big_superman_logo;
                        primaryDrawable = R.drawable.thors_hammer;
                        secondaryDrawable = R.drawable.super_man_crest;
                        primaryText = "Lightning";
                        secondaryText = "Flight";
                        backstory = getString(R.string.backstory4);
                        title = "DOCTOR STRANGE";
                        break;
                    case 6:
                        drawableIcon = R.drawable.big_superman_logo;
                        primaryDrawable = R.drawable.super_man_crest;
                        secondaryDrawable = R.drawable.laser_vision;
                        primaryText = "Flight";
                        secondaryText = "Laser Vision";
                        backstory = getString(R.string.backstory3);
                        title = "YOUR ANGRY MOTHER";
                        break;
                    case 7:
                        drawableIcon = R.drawable.big_superman_logo;
                        primaryDrawable = R.drawable.spider_web;
                        secondaryDrawable = R.drawable.super_strength;
                        primaryText = "Web Slinging";
                        secondaryText = "Super Strength";
                        backstory = getString(R.string.backstory4);
                        title = "A LONE WOLF";
                        break;
                    case 8:
                        drawableIcon = R.drawable.big_superman_logo;
                        primaryDrawable = R.drawable.laser_vision;
                        secondaryDrawable = R.drawable.super_strength;
                        primaryText = "Laser Vision";
                        secondaryText = "Super Strength";
                        backstory = getString(R.string.backstory3);
                        title = "TRALALA NO IDEA";
                        break;
                    case 9:
                        drawableIcon = R.drawable.big_superman_logo;
                        primaryDrawable = R.drawable.super_strength;
                        secondaryDrawable = R.drawable.thors_hammer;
                        primaryText = "Super Strength";
                        secondaryText = "Lightning";
                        backstory = getString(R.string.backstory4);
                        title = "PIKACHU AFRTER GYM";
                        break;
                }
                break;
            case 3:
                switch (power){
                    case 4:
                        drawableIcon = R.drawable.big_superman_logo;
                        primaryDrawable = R.drawable.turtle_power;
                        secondaryDrawable = R.drawable.thors_hammer;
                        primaryText = "Turtle power";
                        secondaryText = "Lightning";
                        backstory = getString(R.string.backstory5);
                        title = "DRUNKEN HOBO";
                        break;
                    case 5:
                        drawableIcon = R.drawable.big_superman_logo;
                        primaryDrawable = R.drawable.thors_hammer;
                        secondaryDrawable = R.drawable.super_man_crest;
                        primaryText = "Lightning";
                        secondaryText = "Flight";
                        backstory = getString(R.string.backstory5);
                        title = "STUDENT DURING FINALS";
                        break;
                    case 6:
                        drawableIcon = R.drawable.big_superman_logo;
                        primaryDrawable = R.drawable.super_man_crest;
                        secondaryDrawable = R.drawable.laser_vision;
                        primaryText = "Flight";
                        secondaryText = "Laser Vision";
                        backstory = getString(R.string.backstory5);
                        title = "HARRY POTTER ON ACID";
                        break;
                    case 7:
                        drawableIcon = R.drawable.big_superman_logo;
                        primaryDrawable = R.drawable.spider_web;
                        secondaryDrawable = R.drawable.super_strength;
                        primaryText = "Web Slinging";
                        secondaryText = "Super Strength";
                        backstory = getString(R.string.backstory5);
                        title = "SPIDERMAN 2";
                        break;
                    case 8:
                        drawableIcon = R.drawable.big_superman_logo;
                        primaryDrawable = R.drawable.laser_vision;
                        secondaryDrawable = R.drawable.super_strength;
                        primaryText = "Laser Vision";
                        secondaryText = "Super Strength";
                        backstory = getString(R.string.backstory5);
                        title = "RIDDLER ON STEROIDS";
                        break;
                    case 9:
                        drawableIcon = R.drawable.big_superman_logo;
                        primaryDrawable = R.drawable.super_strength;
                        secondaryDrawable = R.drawable.thors_hammer;
                        primaryText = "Super Strength";
                        secondaryText = "Lightning";
                        backstory = getString(R.string.backstory5);
                        title = "NINJA";
                        break;
                }
                break;
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_backstory, container, false);

        TextView titleView = (TextView)view.findViewById(R.id.titleTextView);
        titleView.setText(title);

        TextView txt = (TextView)view.findViewById(R.id.backstoryText);
        txt.setText(createIndentedText(
                backstory,
                getResources().getDimensionPixelSize(R.dimen.textIndent),
                0 )
        );

        ImageView icon = (ImageView)view.findViewById(R.id.logoImage);
        icon.setImageDrawable(getResources().getDrawable(drawableIcon));

        Button primaryBtn = (Button)view.findViewById(R.id.primaryBtn);
        primaryBtn.setCompoundDrawablesWithIntrinsicBounds(
                primaryDrawable,
                0,
                R.drawable.item_unselected,
                0
        );
        primaryBtn.setText(primaryText);

        Button secondaryBtn = (Button)view.findViewById(R.id.secondaryBtn);
        secondaryBtn.setCompoundDrawablesWithIntrinsicBounds(
                secondaryDrawable,
                0,
                R.drawable.item_unselected,
                0
        );
        secondaryBtn.setText(secondaryText);

        Button startOverBtn = (Button)view.findViewById(R.id.startOverBtn);
        startOverBtn.setOnClickListener(this);

        return view;
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
        if (context instanceof BackstoryInteractionListener) {
            mListener = (BackstoryInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement BackstoryInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View view) {
        MainActivity activity = (MainActivity)getActivity();
        activity.loadMainFragment();
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
    public interface BackstoryInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
