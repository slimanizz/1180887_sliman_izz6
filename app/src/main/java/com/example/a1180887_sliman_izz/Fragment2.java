package com.example.a1180887_sliman_izz;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.jetbrains.annotations.Nullable;

public class Fragment2 extends Fragment {

    private static final String ARG_RESULT = "result";
    private int result;
    private OnFragmentInteractionListener mListener;

    public Fragment2() {
        // Required empty public constructor
    }

    public static Fragment2 newInstance(int result) {
        Fragment2 fragment = new Fragment2();
        Bundle args = new Bundle();
        args.putInt(ARG_RESULT, result);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            result = getArguments().getInt(ARG_RESULT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_2, container, false);

        TextView textViewResult = view.findViewById(R.id.textViewFragment2);
        Button buttonIncrement = view.findViewById(R.id.button_increase);
        Button buttonDecrement = view.findViewById(R.id.button_decrease);

        textViewResult.setText(result);

        buttonIncrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onIncrementButtonClicked(result);
            }
        });

        buttonDecrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onDecrementButtonClicked(result);
            }
        });

        return view;
    }


    public interface OnFragmentInteractionListener {
        void onIncrementButtonClicked(int result);
        void onDecrementButtonClicked(int result);
    }
}
