package com.dorizu.istream;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class TvShowFragment extends Fragment {

    private GridTvShowAdapter gridTvShowAdapter;
    private ArrayList<TvShow> arrayList;

    public TvShowFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view_fragment_tv = inflater.inflate(R.layout.activity_tv_show_fragment, container, false);
        setHasOptionsMenu(true);
        arrayList = new ArrayList<>();
        RecyclerView recyclerView = view_fragment_tv.findViewById(R.id.rv_tv);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),3));
        recyclerView.setHasFixedSize(true);
        arrayList.addAll(TvShowData.getListData());
        gridTvShowAdapter = new GridTvShowAdapter(getContext());
        gridTvShowAdapter.setListMovie(arrayList);
        recyclerView.setAdapter(gridTvShowAdapter);
        return view_fragment_tv;
    }
}
