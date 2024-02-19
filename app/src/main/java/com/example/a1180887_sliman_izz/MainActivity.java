package com.example.a1180887_sliman_izz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements Fragment1.OnFragmentInteractionListener, Fragment2.OnFragmentInteractionListener {
    final FragmentManager fragmentManager = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Fragment1 secondFragment = new Fragment1();
    }
    // Implement methods for communication between fragments
    @Override
    public void onCalculateButtonClicked(int number) {
        int squared= (int) Math.pow(number,2);
        Fragment2 fragment2 = Fragment2.newInstance(squared);
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.main, fragment2,"frag2");
        transaction.commit();
    }

    @Override
    public void onIncrementButtonClicked(int result) {
        Fragment1 fragment1 = (Fragment1) fragmentManager.findFragmentById(R.id.fragmentContainerView);
        if (fragment1 != null) {
            fragment1.updateResultText(result + 1);
        }
    }

    @Override
    public void onDecrementButtonClicked(int result) {
        // Update Fragment 1's TextView with decremented result
        Fragment1 fragment1 = (Fragment1) fragmentManager.findFragmentById(R.id.fragmentContainerView);
        if (fragment1 != null) {
            fragment1.updateResultText(result - 1);
        }
    }
}
