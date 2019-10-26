package com.example.bookstore.logic.remote;

import android.util.Log;

import com.example.bookstore.logic.DataSource;
import com.example.bookstore.logic.Repository;
import com.example.bookstore.logic.remote.services.MovieApiService;
import com.example.bookstore.model.Movie;
import com.example.bookstore.model.ResponseMovie;

import org.reactivestreams.Publisher;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;

public class RemoteDataSourceImpl implements DataSource {
    private String _TAG = "Remote";
    Repository repository;

    @Override
    public void setRepository(Repository repository) {
        this.repository = repository;
    }

    @Override
    public Single<List<Movie>> fetchMovies(int pageNum) {
        // Repository 를 리턴
        // TODO 서버연동 및 데이터 변환
        // TODO 레트로핏 연동 / GSON / RxJava
        MovieApiService service =
                NetRetrofit.getInstance().getRetrofit().create(MovieApiService.class);
        return service.fetchMovies()
//                .flatMap(new Function<ResponseMovie, SingleSource<?>>() {
//                    @Override
//                    public SingleSource<?> apply(ResponseMovie responseMovie) throws Exception {
//                        List<Movie> list = responseMovie.getData().getMovies();
//                        return Flowable.fromIterable(list).flatMap(new Function<Movie, Publisher<?>>() {
//                            @Override
//                            public Publisher<?> apply(Movie movie) throws Exception {
//                                return service.fetchMovie(movie.getId());
//                            }
//                        })
//                    }
//                })
                .map(new Function<ResponseMovie, List<Movie>>() {
                    @Override
                    public List<Movie> apply(ResponseMovie responseMovie) throws Exception {
                        Log.d(_TAG,"responseMovie::: " + responseMovie.toString());
                        return responseMovie.getData().getMovies();
                    }
                });
    }
}
