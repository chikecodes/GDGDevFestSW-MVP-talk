package com.chikeandroid.gdgdevfestmvp.data.repository;

import com.chikeandroid.gdgdevfestmvp.data.model.User;

/**
 * Created by Chike on 11/24/2016.
 */

public class InMemoryUserRepository implements UserRepository{

    private User mUser;

    @Override
    public User getUser(int id) {
        // Normally this would go to a DB/etc and fetch the user with an ID.
        // Here though, we're just doing something in memory, so we're kind of just
        // faking it out.
        if (mUser == null) {
            mUser = new User();
            mUser.setId(id);
            mUser.setFirstName("Chike");
            mUser.setLastName("Mgbemena");
        }
        return mUser;
    }

    @Override
    public void save(User u) {
        if(this.mUser == null) {
            this.mUser = getUser(0); // create the in memory user.
        }
        this.mUser.setId(u.getId());
        this.mUser.setFirstName(u.getFirstName());
        this.mUser.setLastName(u.getLastName());
    }
}
