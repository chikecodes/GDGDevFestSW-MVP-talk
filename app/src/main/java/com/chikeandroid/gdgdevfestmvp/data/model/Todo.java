package com.chikeandroid.gdgdevfestmvp.data.model;

/**
 * Created by Chike on 11/25/2016.
 */

public class Todo {

    private final int mUserId;
    private final int mId;
    private final String mTitle;
    private final boolean completed;

    public Todo(int userId, int id, String title, boolean completed) {
        this.mUserId = userId;
        this.mId = id;
        this.mTitle = title;
        this.completed = completed;
    }

    public int getUserId() {
        return mUserId;
    }

    public int getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public boolean isCompleted() {
        return completed;
    }
}
