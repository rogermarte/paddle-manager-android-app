package es.rogermartinez.paddlemanager.editplayer.view;

import dagger.Module;
import dagger.Provides;
import es.rogermartinez.paddlemanager.editplayer.domain.usercase.CreatePlayer;
import es.rogermartinez.paddlemanager.editplayer.view.activity.phone.EditPlayerActivity;
import es.rogermartinez.paddlemanager.editplayer.view.controller.PrepareEditPlayerController;
import es.rogermartinez.paddlemanager.editplayer.view.fragment.EditPlayerFragment;

/**
 * Created by roger.martinez on 15/11/15.
 */
@Module(injects = {EditPlayerActivity.class, EditPlayerFragment.class}, complete = false,
        library = true)
public class EditPlayerViewModule {

    @Provides
    public PrepareEditPlayerController provideEditPlayerController(CreatePlayer createPlayer){
        return new PrepareEditPlayerController(createPlayer);
    }
}
