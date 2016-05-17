package es.rogermartinez.paddlemanager.base.application;

import android.app.Application;

import es.rogermartinez.paddlemanager.base.AndroidComponent;
import es.rogermartinez.paddlemanager.base.DaggerAndroidComponent;
import es.rogermartinez.paddlemanager.base.domain.GlobalDomainModule;
import es.rogermartinez.paddlemanager.base.utils.module.AndroidModule;

public class BaseApplication extends Application {

    private AndroidComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        setupGraph();
    }

    private void setupGraph() {
        component = DaggerAndroidComponent.builder()
                .androidModule(new AndroidModule(this))
                .globalDomainModule(new GlobalDomainModule())
                .build();
        component.inject(this);
    }

}
