package es.rogermartinez.paddlemanager.listplayers.domain;

import dagger.Module;
import dagger.Provides;
import es.rogermartinez.paddlemanager.base.daggerutils.PerActivity;
import es.rogermartinez.paddlemanager.listplayers.domain.usercase.SearchPlayers;
import es.rogermartinez.paddlemanager.listplayers.domain.usercase.impl.SearchPlayersJob;

/**
 * Created by roger.martinez on 17/11/15.
 */
@Module
public class ListPlayerDomainModule {
    @Provides
    @PerActivity
    SearchPlayers provideSearchPlayers(SearchPlayersJob searchPlayersJob){
        return searchPlayersJob;
    }

}
