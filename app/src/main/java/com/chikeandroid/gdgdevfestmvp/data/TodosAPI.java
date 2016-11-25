package com.chikeandroid.gdgdevfestmvp.data;

import com.chikeandroid.gdgdevfestmvp.data.model.Todo;

import java.util.List;

import retrofit.RestAdapter;
import retrofit.http.GET;
import rx.Observable;

/**
 * Created by Chike on 11/25/2016.
 */

public class TodosAPI {

    private interface TodoService {
        @GET("/todos")
        Observable<List<Todo>> getTodoList();
    }

    private Observable<List<Todo>> todosObservable = new RestAdapter.Builder()
            .setEndpoint("http://jsonplaceholder.typicode.com")
            .build().create(TodoService.class).getTodoList().cache();

    public Observable<List<Todo>> getTodosObservable() {
        return todosObservable;
    }

}
