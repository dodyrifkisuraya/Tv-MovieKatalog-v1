package com.dorizu.istream;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class MovieFragment extends Fragment{

    private GridMovieAdapter gridMovieAdapter;
    private ArrayList<Movie> arrayList;

    public MovieFragment() {
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view_fragment_movie = inflater.inflate(R.layout.movie_fragment, container, false);
        setHasOptionsMenu(true);
        arrayList = new ArrayList<>();
        RecyclerView recyclerView = view_fragment_movie.findViewById(R.id.rv_movie);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),3));
        recyclerView.setHasFixedSize(true);
        arrayList.addAll(MovieData.getListData());
        gridMovieAdapter = new GridMovieAdapter(getContext());
        gridMovieAdapter.setListMovie(arrayList);
        recyclerView.setAdapter(gridMovieAdapter);
        return view_fragment_movie;
    }


}
