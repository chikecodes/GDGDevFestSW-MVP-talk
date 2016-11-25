package com.chikeandroid.gdgdevfestmvp;

import com.chikeandroid.gdgdevfestmvp.adduser.AddUserPresenter;
import com.chikeandroid.gdgdevfestmvp.data.TodosAPI;
import com.chikeandroid.gdgdevfestmvp.data.repository.InMemoryUserRepository;
import com.chikeandroid.gdgdevfestmvp.data.repository.UserRepository;
import com.chikeandroid.gdgdevfestmvp.todos.TodosPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Chike on 11/24/2016.
 */
@Module
public class AppModule {

    @Provides
    @Singleton
    public UserRepository provideUserRepository() {
        return new InMemoryUserRepository();
    }

    @Provides
    public AddUserPresenter provideAddUserPresenter(UserRepository userRepository) {
        return new AddUserPresenter(userRepository);
    }

    @Provides
    public TodosPresenter provideUsersPresenter() {
        return new TodosPresenter();
    }

    @Provides
    @Singleton
    TodosAPI provideTodosApi() {
        return new TodosAPI();
    }

}
