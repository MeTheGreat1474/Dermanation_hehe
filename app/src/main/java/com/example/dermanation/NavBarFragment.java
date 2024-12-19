package com.example.dermanation;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.appcompat.widget.AppCompatButton;

public class NavBarFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_nav_bar, container, false);

        AppCompatButton helpButton = view.findViewById(R.id.BTHelp);
        AppCompatButton reportButton = view.findViewById(R.id.BTReport);
        AppCompatButton supportButton = view.findViewById(R.id.BTSupport);

        helpButton.setBackgroundColor(Color.GRAY);
        reportButton.setBackgroundColor(Color.GRAY);
        supportButton.setBackgroundColor(Color.GRAY);

        if (getActivity() instanceof Help){
            helpButton.setBackgroundColor(getResources().getColor(R.color.pink));
        } else if (getActivity() instanceof Report){
            reportButton.setBackgroundColor(getResources().getColor(R.color.pink));
        } else if (getActivity() instanceof Support){
            supportButton.setBackgroundColor(getResources().getColor(R.color.pink));
        }

        return view;
    }
}