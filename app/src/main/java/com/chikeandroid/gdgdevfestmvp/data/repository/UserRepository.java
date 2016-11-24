package com.chikeandroid.gdgdevfestmvp.data.repository;

import com.chikeandroid.gdgdevfestmvp.data.model.User;

/**
 * Created by Chike on 11/24/2016.
 */

public interface UserRepository {

    User getUser(int id);
    void save(User u);
}
