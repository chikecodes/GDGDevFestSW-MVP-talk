package com.chikeandroid.gdgdevfestmvp.todos;

/**
 * Created by Chike on 11/25/2016.
 */

public interface TodosContract {

    interface View {

    }

    interface Presenter  {

        void loadTodosFromAPI();
        void setView(TodosFragment view);
    }
}
