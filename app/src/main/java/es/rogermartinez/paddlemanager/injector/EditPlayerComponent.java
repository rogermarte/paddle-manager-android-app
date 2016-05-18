package es.rogermartinez.paddlemanager.injector;

import dagger.Component;
import es.rogermartinez.paddlemanager.base.daggerutils.PerActivity;
import es.rogermartinez.paddlemanager.base.domain.GlobalDomainModule;
import es.rogermartinez.paddlemanager.editplayer.datasource.EditPlayerDatasourceModule;
import es.rogermartinez.paddlemanager.editplayer.domain.EditPlayerDomainModule;
import es.rogermartinez.paddlemanager.editplayer.view.fragment.EditPlayerFragment;
import es.rogermartinez.paddlemanager.search.datasource.SearchPlayerDataSourceModule;

/**
 * Created by roger on 17/5/16.
 */
@PerActivity
@Component(
        dependencies = ApplicationComponent.class,
        modules = {
                ActivityModule.class,
                EditPlayerDomainModule.class,
                EditPlayerDatasourceModule.class,
                SearchPlayerDataSourceModule.class,
                GlobalDomainModule.class
        }
)
public interface EditPlayerComponent extends ActivityComponent {
    void inject(EditPlayerFragment editPlayerFragment);
}
