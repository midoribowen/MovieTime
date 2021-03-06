package com.epicodus.movietime.ui;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.epicodus.movietime.R;
import com.epicodus.movietime.adapters.MoviePagerAdapter;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import info.movito.themoviedbapi.model.MovieDb;

public class MovieDetailActivity extends AppCompatActivity {
    @Bind(R.id.viewPager) ViewPager mViewPager;
    private MoviePagerAdapter adapterViewPager;
    ArrayList<MovieDb> mMovies = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        ButterKnife.bind(this);

        Bundle movieBundle = getIntent().getBundleExtra("movieBundle");
        mMovies = (ArrayList<MovieDb>) movieBundle.getSerializable("movies");

        int startingPosition = Integer.parseInt(getIntent().getStringExtra("position"));
        adapterViewPager = new MoviePagerAdapter(getSupportFragmentManager(), mMovies);
        mViewPager.setAdapter(adapterViewPager);
        mViewPager.setCurrentItem(startingPosition);
    }
}
