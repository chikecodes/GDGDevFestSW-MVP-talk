package com.chikeandroid.gdgdevfestmvp.adduser;

import com.chikeandroid.gdgdevfestmvp.BasePresenter;
import com.chikeandroid.gdgdevfestmvp.BaseView;

/**
 * Created by Chike on 11/24/2016.
 */

public interface AddUserContract {

    interface View extends BaseView<Presenter> {

        int getUserId();

        void displayFirstName(String name);
        void displayLastName(String name);

        void showUserNotFoundMessage();
        void showUserSavedMessage();

        String getFirstName();
        String getLastName();

        void showUserNameIsRequired();
    }

    interface Presenter extends BasePresenter {

    }
}
