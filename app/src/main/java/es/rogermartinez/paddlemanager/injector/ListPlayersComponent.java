package es.rogermartinez.paddlemanager.injector;

import dagger.Component;
import es.rogermartinez.paddlemanager.base.daggerutils.PerActivity;
import es.rogermartinez.paddlemanager.base.domain.GlobalDomainModule;
import es.rogermartinez.paddlemanager.listplayers.domain.ListPlayerDomainModule;
import es.rogermartinez.paddlemanager.listplayers.view.ListPlayersViewModule;
import es.rogermartinez.paddlemanager.listplayers.view.controller.PrepareListPlayersController;
import es.rogermartinez.paddlemanager.listplayers.view.fragment.ListPlayersActivityFragment;
import es.rogermartinez.paddlemanager.search.datasource.SearchPlayerDataSourceModule;

/**
 * Created by roger on 17/5/16.
 */
@PerActivity
@Component(
        dependencies = ApplicationComponent.class,
        modules = {
                ActivityModule.class,
                //ListPlayersViewModule.class,
                ListPlayerDomainModule.class,
                SearchPlayerDataSourceModule.class,
                GlobalDomainModule.class}
)
public interface ListPlayersComponent extends ActivityComponent {
    void inject(ListPlayersActivityFragment listPlayersActivityFragment);
}
