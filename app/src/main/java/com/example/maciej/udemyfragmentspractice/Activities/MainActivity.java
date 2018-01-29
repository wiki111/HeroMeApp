package com.example.maciej.udemyfragmentspractice.Activities;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.os.Bundle;

import com.example.maciej.udemyfragmentspractice.Fragments.BackstoryFragment;
import com.example.maciej.udemyfragmentspractice.Fragments.MainFragment;
import com.example.maciej.udemyfragmentspractice.Fragments.PickAPowerFragment;
import com.example.maciej.udemyfragmentspractice.R;

public class MainActivity extends AppCompatActivity implements MainFragment.MainFragmentInteractionListener, PickAPowerFragment.PickAPowerInteractionListener, BackstoryFragment.BackstoryInteractionListener{

    private int sourceOption;
    private int powerOption;
    private FragmentManager manager;
    private Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = getSupportFragmentManager();
        loadMainFragment();

    }

    public void loadMainFragment(){
        if(fragment == null){
            fragment = new MainFragment();
            manager.beginTransaction().add(R.id.fragmentContainer, fragment).commit();
        }else{
            manager.beginTransaction().replace(R.id.fragmentContainer, new MainFragment()).commit();
        }
    }

    public void loadPickAPowerScreen(){
        PickAPowerFragment pickAPowerFragment = new PickAPowerFragment();
        this.getSupportFragmentManager().beginTransaction().replace(
                R.id.fragmentContainer, pickAPowerFragment
        ).addToBackStack(null).commit();
    }

    public void loadBackstoryScreen(){
        BackstoryFragment backstoryFragment = new BackstoryFragment();
        Bundle args = new Bundle();
        args.putInt("source", sourceOption);
        args.putInt("power", powerOption);
        backstoryFragment.setArguments(args);
        this.getSupportFragmentManager().beginTransaction().replace(
                R.id.fragmentContainer, backstoryFragment
        ).addToBackStack(null).commit();
    }

    @Override
    public void onMainFragmentInteraction(int chosenOption) {
        sourceOption = chosenOption;
    }

    @Override
    public void onPickAPowerInteraction(int chosenOption) {
        powerOption = chosenOption;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
