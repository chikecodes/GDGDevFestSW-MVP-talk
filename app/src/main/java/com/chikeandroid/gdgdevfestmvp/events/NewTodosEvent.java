package com.chikeandroid.gdgdevfestmvp.events;

import com.chikeandroid.gdgdevfestmvp.data.model.Todo;

import java.util.List;

/**
 * Created by Chike on 11/25/2016.
 */

public class NewTodosEvent {

    List<Todo> mTodos;

    public List<Todo> getTodos() {
        return mTodos;
    }

    public NewTodosEvent(List<Todo> todos) {
        this.mTodos = todos;
    }
}
