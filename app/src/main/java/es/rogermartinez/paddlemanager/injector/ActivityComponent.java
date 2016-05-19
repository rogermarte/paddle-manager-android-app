package es.rogermartinez.paddlemanager.injector;

import android.app.Activity;

import dagger.Component;
import es.rogermartinez.paddlemanager.base.daggerutils.PerActivity;

/**
 * Created by roger on 17/5/16.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    // Exposed to sub-graphs
    Activity getActivity();
}
