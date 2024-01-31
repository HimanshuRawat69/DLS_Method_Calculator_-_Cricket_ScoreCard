package com.example.cricacad.ui.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.cricacad.DlsActivity;
import com.example.cricacad.R;
import com.example.cricacad.ScoreCard;
import com.example.cricacad.ScorecardTossScreenDetails;
import com.example.cricacad.databinding.FragmentDashboardBinding;

public class DashboardFragment extends Fragment {
    ImageView rain,scorecard;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DashboardViewModel dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);

        // Inflate the binding
        com.example.cricacad.databinding.FragmentDashboardBinding binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot(); // Use binding.getRoot() to get the root view

        rain = root.findViewById(R.id.imageView14); // Corrected to use root.findViewById
        scorecard=root.findViewById(R.id.imageView15);

        rain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), DlsActivity.class);
                startActivity(intent);
            }
        });

        scorecard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ScorecardTossScreenDetails.class);
                startActivity(intent);
            }
        });
        return root;
    }
}
