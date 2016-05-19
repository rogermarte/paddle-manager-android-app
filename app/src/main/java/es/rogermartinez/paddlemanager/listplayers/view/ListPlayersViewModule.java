package es.rogermartinez.paddlemanager.listplayers.view;

/**
 * Created by roger.martinez on 3/11/15.
 */

import dagger.Module;
import dagger.Provides;
import es.rogermartinez.paddlemanager.base.daggerutils.PerActivity;
import es.rogermartinez.paddlemanager.listplayers.domain.usercase.SearchPlayers;
import es.rogermartinez.paddlemanager.listplayers.domain.usercase.impl.SearchPlayersJob;
import es.rogermartinez.paddlemanager.listplayers.view.activity.phone.ListPlayersActivity;
import es.rogermartinez.paddlemanager.listplayers.view.controller.PrepareListPlayersController;
import es.rogermartinez.paddlemanager.listplayers.view.fragment.ListPlayersActivityFragment;

/**
 *
 */
@Module
public class ListPlayersViewModule {
    @Provides
    @PerActivity
    PrepareListPlayersController providePlayersController(SearchPlayers searchPlayers){
        return new PrepareListPlayersController(searchPlayers);
    }
}
