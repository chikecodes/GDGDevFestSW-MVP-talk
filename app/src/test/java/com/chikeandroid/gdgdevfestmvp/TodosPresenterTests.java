package com.chikeandroid.gdgdevfestmvp;


import com.chikeandroid.gdgdevfestmvp.data.TodosAPI;
import com.chikeandroid.gdgdevfestmvp.data.model.Todo;
import com.chikeandroid.gdgdevfestmvp.todos.TodosPresenter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.mock;
import static org.powermock.api.mockito.PowerMockito.spy;
import static org.powermock.api.mockito.PowerMockito.when;

/**
 * Created by Chike on 11/25/2016.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({Observable.class, AndroidSchedulers.class})
public class TodosPresenterTests {

    private TodosPresenter mTodosPresenter;

    @Before
    public void setUp() {
        mTodosPresenter = spy(new TodosPresenter(mock(TodosAPI.class)));
    }

    @Test
    public void testShouldSchedulePostsLoadFromAPIOnBackgroundThread() {

        //create mocks
        Observable<List<Todo>> todosObservable = (Observable<List<Todo>>) mock(Observable.class);

        //define return values
        when(mTodosPresenter.mTodosAPI.getTodosObservable()).thenReturn(todosObservable);
        when(todosObservable.subscribeOn(Schedulers.io())).thenReturn(todosObservable);
        when(todosObservable.observeOn(AndroidSchedulers.mainThread())).thenReturn(todosObservable);

        //call test method
        mTodosPresenter.loadTodosFromAPI();

        //verify if all methods in the chain are called with correct arguments
        verify(mTodosPresenter.mTodosAPI).getTodosObservable();
        verify(todosObservable).subscribeOn(Schedulers.io());
        verify(todosObservable).observeOn(AndroidSchedulers.mainThread());
        verify(todosObservable).subscribe(Matchers.<Subscriber<List<Todo>>>any());
    }
}
