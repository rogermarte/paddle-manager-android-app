package es.rogermartinez.paddlemanager.editplayer.domain;

import dagger.Module;
import dagger.Provides;
import es.rogermartinez.paddlemanager.editplayer.domain.usercase.CreatePlayer;
import es.rogermartinez.paddlemanager.editplayer.domain.usercase.DeletePlayer;
import es.rogermartinez.paddlemanager.editplayer.domain.usercase.SelectPlayer;
import es.rogermartinez.paddlemanager.editplayer.domain.usercase.UpdatePlayer;
import es.rogermartinez.paddlemanager.editplayer.domain.usercase.impl.CreatePlayerJob;
import es.rogermartinez.paddlemanager.editplayer.domain.usercase.impl.SelectPlayerJob;
import es.rogermartinez.paddlemanager.editplayer.domain.usercase.impl.UpdatePlayerJob;

/**
 * Created by roger.martinez on 17/11/15.
 */
@Module(complete = false, library = true)
public class EditPlayerDomainModule {
    @Provides
    public SelectPlayer providesSelectPlayer(SelectPlayerJob job){
        return job;
    }

    @Provides
    public UpdatePlayer providesUpdatePlayer(UpdatePlayerJob job){
        return job;
    }

    @Provides
    public CreatePlayer providesCreatePlayer(CreatePlayerJob job){
        return job;
    }

    @Provides
    public DeletePlayer providesDeletePlayer(DeletePlayer job){
        return job;
    }
}
