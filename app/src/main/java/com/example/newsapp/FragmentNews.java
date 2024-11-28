package com.example.newsapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class FragmentNews extends Fragment {

    private static final String ARG_CATEGORY = "category";

    private String category;

    public static FragmentNews newInstance(String category) {
        FragmentNews fragment = new FragmentNews();
        Bundle args = new Bundle();
        args.putString(ARG_CATEGORY, category);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news, container, false);

        if (getArguments() != null) {
            category = getArguments().getString(ARG_CATEGORY);
        }

        // Set up RecyclerView
        RecyclerView recyclerView = view.findViewById(R.id.recycler_news);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Get list of news based on category
        List<NewsItem> newsList = getNewsForCategory(category);
        NewsAdapter adapter = new NewsAdapter(newsList);
        recyclerView.setAdapter(adapter);

        return view;
    }

    private List<NewsItem> getNewsForCategory(String category) {
        List<NewsItem> newsList = new ArrayList<>();
        if (category.equals("Politik")) {
            newsList.add(new NewsItem(R.drawable.image_politics, "Berita politik terbaru"));
        } else if (category.equals("Kesehatan")) {
            newsList.add(new NewsItem(R.drawable.image_health, "Berita kesehatan terbaru"));
        } else if (category.equals("Teknologi")) {
            newsList.add(new NewsItem(R.drawable.image_technology, "Berita teknologi terbaru"));
        }
        return newsList;
    }
}
