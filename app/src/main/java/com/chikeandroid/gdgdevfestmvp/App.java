package com.chikeandroid.gdgdevfestmvp;

import android.app.Application;

/**
 * Created by Chike on 11/24/2016.
 */

public class App extends Application {

    private AppComponent mComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mComponent = DaggerAppComponent.builder().appModule(new AppModule()).build();
    }

    public AppComponent getComponent() {
        return  mComponent;
    }

}
