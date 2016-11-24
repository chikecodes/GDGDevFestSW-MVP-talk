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
        if(mView == null) {
            throw new ViewNotFoundException();
        }
        int userId = mView.getUserId();
        mUser = mUserRepository.getUser(userId);
        if(mUser == null) {
            mView.showUserNotFoundMessage();
        } else {
            mView.displayFirstName(mUser.getFirstName());
            mView.displayLastName(mUser.getLastName());
        }
    }

    @Override
    public void saveUser() {
        if(mUser != null) {
            if(mView.getFirstName() == null || mView.getFirstName().trim().equals("") ||
                    mView.getLastName() == null || mView.getLastName().trim().equals("")) {
                mView.showUserNameIsRequired();
            } else {
                mUser.setFirstName(mView.getFirstName());
                mUser.setLastName(mView.getLastName());
                mUserRepository.save(mUser);
                mView.showUserSavedMessage();
            }

        }
    }

    @Override
    public void setView(AddUserFragment view) {
        this.mView = view;
        loadUserDetails();
    }

}
