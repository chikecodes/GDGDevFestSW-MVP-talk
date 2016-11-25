package com.chikeandroid.gdgdevfestmvp.users;

/**
 * Created by Chike on 11/25/2016.
 */

public interface UsersContract {

    interface View {

    }

    interface Presenter  {

        void loadUsersFromAPI();
        void setView(UsersFragment view);
    }
}
