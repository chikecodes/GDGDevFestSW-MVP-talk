package com.chikeandroid.gdgdevfestmvp;

import com.chikeandroid.gdgdevfestmvp.adduser.AddUserFragment;
import com.chikeandroid.gdgdevfestmvp.adduser.AddUserPresenter;
import com.chikeandroid.gdgdevfestmvp.data.model.User;
import com.chikeandroid.gdgdevfestmvp.data.repository.UserRepository;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by Chike on 11/24/2016.
 */

public class PresenterTests {

    UserRepository mMockUserRepository;
    AddUserFragment mMockView;
    AddUserPresenter mAddUserPresenter;
    User mUser;

    @Before
    public void setup() {

        mMockUserRepository = mock(UserRepository.class);

        mUser = new User();
        mUser.setId(1);
        mUser.setFirstName("Elliot");
        mUser.setFirstName("Alderson");
        when(mMockUserRepository.getUser(anyInt())).thenReturn(mUser);

        mMockView = mock(AddUserFragment.class);

        mAddUserPresenter = new AddUserPresenter(mMockUserRepository);
    }

    @Test
    public void shouldLoadUserDetailsWhenViewIsSet() {
        mAddUserPresenter.setView(mMockView);
        verify(mMockUserRepository, times(1)).getUser(anyInt());
        verify(mMockView, times(1)).displayFirstName(anyString());
        verify(mMockView, times(1)).displayLastName(anyString());
    }
}
