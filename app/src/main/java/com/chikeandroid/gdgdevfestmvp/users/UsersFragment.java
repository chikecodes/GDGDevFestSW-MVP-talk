package com.chikeandroid.gdgdevfestmvp.users;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chikeandroid.gdgdevfestmvp.App;
import com.chikeandroid.gdgdevfestmvp.R;

import javax.inject.Inject;

/**
 * Created by Chike on 11/25/2016.
 */

public class UsersFragment extends Fragment implements UsersContract.View {

    @Inject UsersPresenter mUsersPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((App)getActivity().getApplication()).getComponent().inject(this);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_users, container, false);


        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        mUsersPresenter.setView(this);
    }
}