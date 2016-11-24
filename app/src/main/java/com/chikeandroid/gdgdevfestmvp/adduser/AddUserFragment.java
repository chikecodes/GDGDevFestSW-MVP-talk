package com.chikeandroid.gdgdevfestmvp.adduser;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chikeandroid.gdgdevfestmvp.R;

/**
 * Created by Chike on 11/24/2016.
 */

public class AddUserFragment extends Fragment implements AddUserContract.View {

    private static final String USER_ID = "user_id";

    public AddUserFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main, container, false);

        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
    }


    @Override
    public int getUserId() {
        return 0;
    }

    @Override
    public void displayFirstName(String name) {

    }

    @Override
    public void displayLastName(String name) {

    }

    @Override
    public void showUserNotFoundMessage() {

    }

    @Override
    public void showUserSavedMessage() {

    }

    @Override
    public String getFirstName() {
        return null;
    }

    @Override
    public String getLastName() {
        return null;
    }

    @Override
    public void showUserNameIsRequired() {

    }

    @Override
    public void setPresenter(AddUserContract.Presenter presenter) {

    }
}
