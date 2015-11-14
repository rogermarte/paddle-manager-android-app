package es.rogermartinez.paddlemanager.base.application;

import android.app.Application;

import java.util.Arrays;
import java.util.List;

import dagger.ObjectGraph;
import es.rogermartinez.paddlemanager.base.utils.module.AndroidModule;
import es.rogermartinez.paddlemanager.base.domain.GlobalDomainModule;
import es.rogermartinez.paddlemanager.listplayers.view.ListPlayersViewModule;
import es.rogermartinez.paddlemanager.search.datasource.SearchPlayerDataSourceModule;

/**
 * Created by roger.martinez on 9/10/15.
 */
public class BaseApplication extends Application {
    private ObjectGraph graph;

    @Override
    public void onCreate() {
        super.onCreate();

        graph = ObjectGraph.create(getModules().toArray());
        graph.injectStatics();
    }

    public void inject(Object object) {
        graph.inject(object);
    }

    protected List<Object> getModules() {
        return Arrays.asList(
                new AndroidModule(this),
                new GlobalDomainModule(),
                new ListPlayersViewModule(),
                new SearchPlayerDataSourceModule());
    }
}
