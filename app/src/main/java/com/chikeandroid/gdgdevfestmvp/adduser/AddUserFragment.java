package com.chikeandroid.gdgdevfestmvp.adduser;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.chikeandroid.gdgdevfestmvp.App;
import com.chikeandroid.gdgdevfestmvp.R;
import com.chikeandroid.gdgdevfestmvp.users.UsersActivity;

import javax.inject.Inject;

/**
 * Created by Chike on 11/24/2016.
 */

public class AddUserFragment extends Fragment implements AddUserContract.View {

    @Inject AddUserPresenter mAddUserPresenter;

    private static final String USER_ID = "user_id";

    private EditText mFirstNameEt;
    private EditText nLastNameEt;

    public AddUserFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((App)getActivity().getApplication()).getComponent().inject(this);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main, container, false);

        mFirstNameEt = (EditText) v.findViewById(R.id.user_first_name);
        nLastNameEt = (EditText) v.findViewById(R.id.user_last_name);
        v.findViewById(R.id.btn_save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAddUserPresenter.saveUser();
            }
        });
        v.findViewById(R.id.btn_users).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAddUserPresenter.onUsersButtonClick();
            }
        });
        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        mAddUserPresenter.setView(this);
    }

    @Override
    public int getUserId() {
        return getArguments() == null ? 0 : getArguments().getInt(USER_ID, 0);
    }

    @Override
    public void displayFirstName(String name) {
        mFirstNameEt.setText(name);
    }

    @Override
    public void displayLastName(String name) {
        nLastNameEt.setText(name);
    }

    @Override
    public void showUserNotFoundMessage() {
        Toast.makeText(getActivity(), R.string.user_not_found, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showUserSavedMessage() {
        Toast.makeText(getActivity(), R.string.user_saved, Toast.LENGTH_SHORT).show();
    }

    @Override
    public String getFirstName() {
        return mFirstNameEt.getText().toString();
    }

    @Override
    public String getLastName() {
        return nLastNameEt.getText().toString();
    }

    @Override
    public void showUserNameIsRequired() {
        Toast.makeText(getActivity(), R.string.user_name_required_message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void launchUsersActivity() {
        Intent i = new Intent(getActivity(), UsersActivity.class);
        startActivity(i);
    }

}
