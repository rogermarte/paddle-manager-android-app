package name.rogermarte.padelmanager.base.application;

import android.app.Application;

import java.util.Arrays;
import java.util.List;

import dagger.ObjectGraph;
import name.rogermarte.padelmanager.base.domain.GlobalDomainModule;
import name.rogermarte.padelmanager.base.utils.module.AndroidModule;
import name.rogermarte.padelmanager.players.view.PlayersViewModule;

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
        return Arrays.asList(new AndroidModule(this), new GlobalDomainModule(), new PlayersViewModule());
    }
}
