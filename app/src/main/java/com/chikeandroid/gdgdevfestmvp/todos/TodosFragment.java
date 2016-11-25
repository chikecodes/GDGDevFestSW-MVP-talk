package com.chikeandroid.gdgdevfestmvp.todos;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chikeandroid.gdgdevfestmvp.App;
import com.chikeandroid.gdgdevfestmvp.R;
import com.chikeandroid.gdgdevfestmvp.events.NewTodosEvent;
import com.chikeandroid.gdgdevfestmvp.todos.adapter.TodosListAdapter;

import de.greenrobot.event.EventBus;

import javax.inject.Inject;

/**
 * Created by Chike on 11/25/2016.
 */

public class TodosFragment extends Fragment implements TodosContract.View {

    @Inject
    TodosPresenter mTodosPresenter;

    private RecyclerView mTodosRecyclerView;

    private TodosListAdapter mTodosListAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((App)getActivity().getApplication()).getComponent().inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_todos, container, false);

        mTodosRecyclerView = (RecyclerView) v.findViewById(R.id.todos_recycler_view);

        initRecyclerView();
        mTodosPresenter.loadTodosFromAPI();
        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        mTodosPresenter.setView(this);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        EventBus.getDefault().register(this);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        EventBus.getDefault().unregister(this);
    }

    private void initRecyclerView() {
        mTodosRecyclerView.setHasFixedSize(true);
        mTodosRecyclerView.setLayoutManager(new LinearLayoutManager(mTodosRecyclerView.getContext()));
        mTodosRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mTodosListAdapter = new TodosListAdapter();
        mTodosRecyclerView.setAdapter(mTodosListAdapter);

    }

    public void onEvent(NewTodosEvent event) {
        mTodosListAdapter.addTodos(event.getTodos());
    }


}
