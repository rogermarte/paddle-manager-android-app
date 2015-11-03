package name.rogermarte.padelmanager.players.view;

/**
 * Created by roger.martinez on 3/11/15.
 */

import dagger.Module;
import dagger.Provides;
import name.rogermarte.padelmanager.players.view.activity.phone.PlayersActivity;
import name.rogermarte.padelmanager.players.view.controller.PreparePlayersController;
import name.rogermarte.padelmanager.players.view.fragment.PlayersActivityFragment;

/**
 *
 */
@Module(injects = {PlayersActivity.class, PlayersActivityFragment.class}, complete = false,
        library = true)
public class PlayersViewModule {
    @Provides
    PreparePlayersController providePlayersController(){
        return new PreparePlayersController();
    }
}
