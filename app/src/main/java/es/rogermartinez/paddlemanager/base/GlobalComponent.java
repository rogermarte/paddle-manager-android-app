package es.rogermartinez.paddlemanager.base;

import dagger.Component;
import dagger.Provides;
import es.rogermartinez.paddlemanager.base.application.BaseApplication;
import es.rogermartinez.paddlemanager.base.domain.GlobalDomainModule;
import es.rogermartinez.paddlemanager.base.utils.module.AndroidModule;
import es.rogermartinez.paddlemanager.editplayer.datasource.CreatePlayerDataSource;
import es.rogermartinez.paddlemanager.editplayer.datasource.EditPlayerDatasourceModule;
import es.rogermartinez.paddlemanager.editplayer.datasource.db.impl.CreatePlayerDataSourceImpl;
import es.rogermartinez.paddlemanager.editplayer.domain.EditPlayerDomainModule;
import es.rogermartinez.paddlemanager.editplayer.domain.usercase.CreatePlayer;
import es.rogermartinez.paddlemanager.editplayer.domain.usercase.DeletePlayer;
import es.rogermartinez.paddlemanager.editplayer.domain.usercase.SelectPlayer;
import es.rogermartinez.paddlemanager.editplayer.domain.usercase.UpdatePlayer;
import es.rogermartinez.paddlemanager.editplayer.domain.usercase.impl.CreatePlayerJob;
import es.rogermartinez.paddlemanager.editplayer.domain.usercase.impl.SelectPlayerJob;
import es.rogermartinez.paddlemanager.editplayer.domain.usercase.impl.UpdatePlayerJob;
import es.rogermartinez.paddlemanager.editplayer.view.EditPlayerViewModule;
import es.rogermartinez.paddlemanager.listplayers.domain.ListPlayerDomainModule;
import es.rogermartinez.paddlemanager.listplayers.domain.usercase.SearchPlayers;
import es.rogermartinez.paddlemanager.listplayers.domain.usercase.impl.SearchPlayersJob;
import es.rogermartinez.paddlemanager.listplayers.view.ListPlayersViewModule;
import es.rogermartinez.paddlemanager.listplayers.view.activity.phone.ListPlayersActivity;
import es.rogermartinez.paddlemanager.listplayers.view.controller.PrepareListPlayersController;
import es.rogermartinez.paddlemanager.listplayers.view.fragment.ListPlayersActivityFragment;
import es.rogermartinez.paddlemanager.search.datasource.SearchPlayerDataSourceModule;

@Component(
        dependencies = {
                AndroidModule.class
        },
        modules = {
                EditPlayerDatasourceModule.class,
                EditPlayerDomainModule.class,
                EditPlayerViewModule.class,
                ListPlayerDomainModule.class,
                ListPlayersViewModule.class,
                SearchPlayerDataSourceModule.class
        }
)
public interface GlobalComponent extends AndroidComponent {

    void inject(ListPlayersActivityFragment listPlayersActivityFragment);
}
