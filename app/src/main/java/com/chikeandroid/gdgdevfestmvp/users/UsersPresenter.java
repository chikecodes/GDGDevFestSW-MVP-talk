package com.chikeandroid.gdgdevfestmvp.users;

/**
 * Created by Chike on 11/25/2016.
 */

public class UsersPresenter implements UsersContract.Presenter {

    private UsersFragment mView;

    @Override
    public void loadUsersFromAPI() {

    }

    @Override
    public void setView(UsersFragment view) {
        mView = view;
    }
}
