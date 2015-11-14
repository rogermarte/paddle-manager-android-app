package es.rogermartinez.paddlemanager.base.domain.interactor.impl;

import android.os.Handler;
import android.os.Looper;

import javax.inject.Inject;

import es.rogermartinez.paddlemanager.base.domain.interactor.MainThread;

/**
 * Created by roger.martinez on 3/11/15.
 */
public class MainThreadHandler implements MainThread {
    private Handler handler;

    @Inject
    MainThreadHandler() {
        this.handler = new Handler(Looper.getMainLooper());
    }

    @Override
    public void post(Runnable runnable) {
        handler.post(runnable);
    }
}
