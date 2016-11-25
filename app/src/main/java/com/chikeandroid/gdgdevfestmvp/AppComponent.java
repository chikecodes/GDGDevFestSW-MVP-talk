package com.chikeandroid.gdgdevfestmvp;

import com.chikeandroid.gdgdevfestmvp.adduser.AddUserFragment;
import com.chikeandroid.gdgdevfestmvp.users.UsersFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Chike on 11/24/2016.
 */

@Singleton
@Component(modules = { AppModule.class })
public interface AppComponent {
    void inject(AddUserFragment target);
    void inject(UsersFragment target);
}
