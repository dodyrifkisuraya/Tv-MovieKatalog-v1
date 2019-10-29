package com.dorizu.istream;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class DetailTvShow extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_movie);

        TvShow tvTangkap = getIntent().getParcelableExtra("keyword");

        ImageView thimnail = findViewById(R.id.img_thumnail);
        TextView judul = findViewById(R.id.judul);
        TextView rilis =  findViewById(R.id.tgl_rilis);
        TextView durasi =  findViewById(R.id.durasi);
        TextView genre = findViewById(R.id.tv_genre);
        TextView deskripsi =  findViewById(R.id.diskripsi);
        TextView director =  findViewById(R.id.director);
        TextView bahasa =  findViewById(R.id.bahasa);
        ImageView back =  findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent backHome = new Intent(DetailTvShow.this, MainActivity.class);
                startActivity(backHome);
            }
        });

        Glide.with(this)
                .load(tvTangkap.getThunail())
                .apply(new RequestOptions().override(350, 550))
                .into(thimnail);
        judul.setText(tvTangkap.getJudul());
        rilis.setText(tvTangkap.getTanggalRilis());
        durasi.setText(tvTangkap.getDurasi());
        genre.setText(tvTangkap.getGenre());
        deskripsi.setText(tvTangkap.getOverview());
        director.setText(tvTangkap.getDirector());
        bahasa.setText(tvTangkap.getBahasa());
    }
}