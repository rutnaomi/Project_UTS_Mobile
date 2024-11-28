package com.example.newsapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class FragmentHome extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout and assign it to 'view'
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        // Find CardViews using correct IDs
        View cardPolitik = view.findViewById(R.id.card_politik);
        View cardKesehatan = view.findViewById(R.id.card_kesehatan);
        View cardTeknologi = view.findViewById(R.id.card_teknologi);

        // Set click listeners
        cardPolitik.setOnClickListener(v -> openNewsFragment("Politik"));
        cardKesehatan.setOnClickListener(v -> openNewsFragment("Kesehatan"));
        cardTeknologi.setOnClickListener(v -> openNewsFragment("Teknologi"));

        // Return the view
        return view;
    }

    private void openNewsFragment(String category) {
        // Create a new instance of FragmentNews and pass the category
        FragmentNews fragmentNews = FragmentNews.newInstance(category);
        FragmentTransaction transaction = requireFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragmentNews);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
