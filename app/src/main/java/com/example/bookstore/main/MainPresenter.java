package com.example.bookstore.main;

import com.example.bookstore.base.BasePresenterImpl;
import com.example.bookstore.logic.Repository;
import com.example.bookstore.logic.RepositoryImpl;

import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MainPresenter extends BasePresenterImpl<MainContract.View>
        implements MainContract.Presenter {

    Repository repository;

    MainPresenter() {
        this.repository = new RepositoryImpl();
        this.repository.setPresenter(this);
    }

    @Override
    public void fetchMoives(int pageNum) {
        //TODO Repoisitory에 데이터를 가져오도록 명령.
        // TODO RxJava 로 View로 업스트림을 올리게 됨.
        this.repository.fetchMovies(pageNum)
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer() {
                    @Override
                    public void accept(Object o) throws Exception {

                    }
                });
    }
}
