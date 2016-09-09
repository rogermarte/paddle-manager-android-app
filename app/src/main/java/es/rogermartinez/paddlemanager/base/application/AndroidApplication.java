package es.rogermartinez.paddlemanager.base.application;

import android.app.Application;

import es.rogermartinez.paddlemanager.injector.ApplicationComponent;
import es.rogermartinez.paddlemanager.injector.ApplicationModule;
import es.rogermartinez.paddlemanager.injector.DaggerApplicationComponent;

public class AndroidApplication extends Application {

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initializeInjector();
    }

    private void initializeInjector() {
        this.applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return this.applicationComponent;
    }

}
