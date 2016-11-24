package com.chikeandroid.gdgdevfestmvp.adduser;

import com.chikeandroid.gdgdevfestmvp.data.model.User;
import com.chikeandroid.gdgdevfestmvp.data.repository.UserRepository;

/**
 * Created by Chike on 11/24/2016.
 */

public class AddUserPresenter implements AddUserContract.Presenter {

    private AddUserFragment mView;
    private UserRepository mUserRepository;
    private User mUser;

    public AddUserPresenter(UserRepository userRepository) {
        this.mUserRepository = userRepository;
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
