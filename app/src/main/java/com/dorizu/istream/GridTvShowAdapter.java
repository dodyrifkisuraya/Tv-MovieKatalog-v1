package com.dorizu.istream;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class GridTvShowAdapter extends RecyclerView.Adapter<GridTvShowAdapter.GridViewHolder> {

    private ArrayList<TvShow> listTvShow;
    private Context context;

    public GridTvShowAdapter(Context context) {
        this.context = context;
    }

    public ArrayList<TvShow> getListTvShow() {
        return listTvShow;
    }

    public void setListMovie(ArrayList<TvShow> listTvShow) {
        this.listTvShow = listTvShow;
    }

    @NonNull
    @Override
    public GridViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item, viewGroup, false);
        return new GridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GridViewHolder holder, int i) {
        final TvShow objekTvShow =getListTvShow().get(i);
        Glide.with(context)
                .load(objekTvShow.getThunail())
                .apply(new RequestOptions().override(350,550))
                .into(holder.thumnail);
        holder.title.setText(objekTvShow.getJudul());
        holder.tvShow = objekTvShow;
    }

    @Override
    public int getItemCount() {
        return listTvShow.size();
    }

    public class GridViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView thumnail;
        TextView title;
        TvShow tvShow;
        CardView itemCard;

        public GridViewHolder(@NonNull View itemView) {
            super(itemView);
            thumnail = itemView.findViewById(R.id.img_thumnail);
            title = itemView.findViewById(R.id.tv_judul);
            itemCard = itemView.findViewById(R.id.cardview);
            itemCard.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Intent bawaData = new Intent(context, DetailTvShow.class);
            bawaData.putExtra("keyword", tvShow);
            context.startActivity(bawaData);
        }
    }
}
