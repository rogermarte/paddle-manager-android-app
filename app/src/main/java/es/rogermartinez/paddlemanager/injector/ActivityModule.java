package es.rogermartinez.paddlemanager.injector;

import android.app.Activity;

import com.squareup.otto.Bus;

import dagger.Module;
import dagger.Provides;
import es.rogermartinez.paddlemanager.base.daggerutils.PerActivity;
import es.rogermartinez.paddlemanager.base.domain.DomainErrorHandler;

/**
 * Created by roger on 17/5/16.
 */
@Module
public class ActivityModule {
    private final Activity activity;

    public ActivityModule(Activity activity){
        this.activity = activity;
    }

    @Provides
    @PerActivity
    Activity provideActivity(){
        return activity;
    }

    @Provides
    @PerActivity
    DomainErrorHandler provideDomainErrorHandler(Bus bus) {
        return new DomainErrorHandler(bus);
    }
}
