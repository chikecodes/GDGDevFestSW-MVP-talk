package com.chikeandroid.gdgdevfestmvp.todos;

import com.chikeandroid.gdgdevfestmvp.data.TodosAPI;
import com.chikeandroid.gdgdevfestmvp.data.model.Todo;
import com.chikeandroid.gdgdevfestmvp.events.NewTodosEvent;

import de.greenrobot.event.EventBus;

import java.util.List;

import javax.inject.Inject;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Chike on 11/25/2016.
 */

public class TodosPresenter implements TodosContract.Presenter {

    public TodosAPI mTodosAPI;
    private TodosFragment mView;

    @Inject
    public TodosPresenter(TodosAPI todosAPI) {
        mTodosAPI = todosAPI;
    }

    @Override
    public void loadTodosFromAPI() {
        mTodosAPI.getTodosObservable().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<Todo>>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(List<Todo> newTodos) {
                        EventBus.getDefault().post(new NewTodosEvent(newTodos));
                    }
                });
    }

    @Override
    public void setView(TodosFragment view) {
        mView = view;
    }
}
