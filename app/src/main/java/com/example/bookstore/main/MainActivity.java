package com.example.bookstore.main;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.bookstore.R;
import com.example.bookstore.base.BaseActivity;
import com.example.bookstore.model.Movie;

import java.util.List;

import butterknife.BindView;

public class MainActivity extends BaseActivity<MainContract.View, MainContract.Presenter>
        implements MainContract.View {

    @BindView(R.id.btnFetchMovies)
    Button btnFetchMovies;

    @Override
    protected MainContract.Presenter setPresenter() {
        return new MainPresenter();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnFetchMovies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO 클릭 시,  Presenter로 다운스트림 발생
                mPresenter.fetchMoives(1);
            }
        });
    }

    @Override
    public void fetchMoivesDone(List<Movie> list) {

    }
}
