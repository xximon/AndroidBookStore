package com.example.bookstore.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.example.bookstore.R;
import com.example.bookstore.base.BaseActivity;
import com.example.bookstore.model.Movie;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MainActivity extends BaseActivity<MainContract.View, MainContract.Presenter>
        implements MainContract.View {

    @BindView(R.id.rvMovie)
    RecyclerView mRecyclerView;

    @BindView(R.id.progressBar)
    ProgressBar mProgressBar;

    MainAdapter adapter;
    List<Movie> movies = new ArrayList<>();

    private int mStartPageNum = 1;

    @Override
    protected MainContract.Presenter setPresenter() {
        return new MainPresenter();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPresenter.fetchMovies(mStartPageNum);

        initRecyclerView();

//        btnFetchMovies.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // TODO 클릭 시,  Presenter로 다운스트림 발생
//                mPresenter.fetchMoives(1);
//            }
//        });
    }

    private void initRecyclerView() {
        adapter = new MainAdapter(movies, mPresenter);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        mRecyclerView.setLayoutManager(gridLayoutManager);
        mRecyclerView.setAdapter(adapter);
    }

    @Override
    public void fetchMoviesDone(List<Movie> list) {
        if (mStartPageNum == 1)
            mProgressBar.setVisibility(View.GONE);

        movies.addAll(list);
        Log.d("MainActivity", "list size " + list.size());
        adapter.notifyDataSetChanged();

        if (mStartPageNum <= 3)
            mPresenter.fetchMovies(mStartPageNum++);

    }
}
