package es.rogermartinez.paddlemanager.injector;

import android.content.Context;

import com.path.android.jobqueue.JobManager;
import com.squareup.otto.Bus;

import java.util.Map;

import javax.inject.Singleton;

import dagger.Component;
import es.rogermartinez.paddlemanager.base.domain.interactor.MainThread;
import es.rogermartinez.paddlemanager.base.view.activity.BaseActivity;
import es.rogermartinez.paddlemanager.search.domain.model.QueryPlayer;

/**
 * Created by roger on 17/5/16.
 */
@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    void inject(BaseActivity baseActivity);

    // Exposed to sub-graphs
    Context getContext();
    Bus getBusProvider();
    JobManager getJobManager();
    MainThread getMainThread();
    Map<QueryPlayer, QueryPlayer> getSearchPlayersCache();
}
