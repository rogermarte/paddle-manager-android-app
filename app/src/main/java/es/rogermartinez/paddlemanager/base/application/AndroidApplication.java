package es.rogermartinez.paddlemanager.base.application;

import android.app.Application;

import com.crashlytics.android.Crashlytics;
import es.rogermartinez.paddlemanager.injector.ApplicationComponent;
import es.rogermartinez.paddlemanager.injector.ApplicationModule;
import es.rogermartinez.paddlemanager.injector.DaggerApplicationComponent;
import io.fabric.sdk.android.Fabric;

public class AndroidApplication extends Application {

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        Fabric.with(this, new Crashlytics());
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
