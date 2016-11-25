package com.chikeandroid.gdgdevfestmvp.todos;

/**
 * Created by Chike on 11/25/2016.
 */

public class TodosPresenter implements TodosContract.Presenter {

    private TodosFragment mView;

    @Override
    public void loadUsersFromAPI() {

    }

    @Override
    public void setView(TodosFragment view) {
        mView = view;
    }
}
