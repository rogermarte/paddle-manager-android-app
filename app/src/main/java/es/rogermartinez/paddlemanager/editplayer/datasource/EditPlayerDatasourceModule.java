package es.rogermartinez.paddlemanager.editplayer.datasource;

import dagger.Module;
import dagger.Provides;
import es.rogermartinez.paddlemanager.editplayer.datasource.db.impl.CreatePlayerDataSourceImpl;

/**
 * Created by roger.martinez on 17/11/15.
 */
@Module(complete = false, library = true)
public class EditPlayerDatasourceModule {
    @Provides
    public CreatePlayerDataSource providesCreatePlayerDataSource(CreatePlayerDataSourceImpl dataSource){
        return dataSource;
    }
}
