package com.chikeandroid.gdgdevfestmvp.data.model;

/**
 * Created by Chike on 11/25/2016.
 */

public class Todo {

    private final int userId;
    private final int id;
    private final String title;
    private final boolean completed;

    public Todo(int userId, int id, String title, boolean completed) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.completed = completed;
    }

    public int getUserId() {
        return userId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCompleted() {
        return completed;
    }
}
