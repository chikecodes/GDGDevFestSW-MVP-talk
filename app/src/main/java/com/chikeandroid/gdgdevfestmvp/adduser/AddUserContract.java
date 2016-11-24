package com.chikeandroid.gdgdevfestmvp.adduser;

/**
 * Created by Chike on 11/24/2016.
 */

public interface AddUserContract {

    interface View {

        int getUserId();

        void displayFirstName(String name);
        void displayLastName(String name);

        void showUserNotFoundMessage();
        void showUserSavedMessage();

        String getFirstName();
        String getLastName();

        void showUserNameIsRequired();
    }

    interface Presenter  {

        void loadUserDetails();
        void saveUser();
        void setView(AddUserFragment view);
    }
}
