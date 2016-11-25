package com.chikeandroid.gdgdevfestmvp.todos.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chikeandroid.gdgdevfestmvp.R;
import com.chikeandroid.gdgdevfestmvp.data.model.Todo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chike on 11/25/2016.
 */

public class TodosListAdapter extends RecyclerView.Adapter<TodosListAdapter.ViewHolder> {

    private List<Todo> mTodos;

    public TodosListAdapter() {
        this.mTodos = new ArrayList<>();
    }

    public void addTodos(List<Todo> newTodos) {
        mTodos.addAll(newTodos);
        notifyDataSetChanged();
    }
    @Override
    public TodosListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.todo_row_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(TodosListAdapter.ViewHolder holder, int position) {
        holder.todoTitle.setText(mTodos.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return mTodos.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView todoTitle;

        public ViewHolder(View view) {
            super(view);
            todoTitle = (TextView) view.findViewById(R.id.todo_title);
        }
    }
}
