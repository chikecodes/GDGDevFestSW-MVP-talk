package com.chikeandroid.gdgdevfestmvp.adduser;

/**
 * Created by Chike on 11/24/2016.
 */

public class AddUserPresenter implements AddUserContract.Presenter {

    private AddUserFragment mView;

    public AddUserPresenter() {

    }

    @Override
    public void loadUserDetails() {

    }

    @Override
    public void saveUser() {

    }

    @Override
    public void setView(AddUserFragment view) {
        this.mView = view;
    }

}
