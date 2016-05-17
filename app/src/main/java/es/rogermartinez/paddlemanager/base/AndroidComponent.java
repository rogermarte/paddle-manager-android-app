package es.rogermartinez.paddlemanager.base;

import android.content.Context;

import com.path.android.jobqueue.JobManager;
import com.squareup.otto.Bus;

import java.text.SimpleDateFormat;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Component;
import es.rogermartinez.paddlemanager.base.application.BaseApplication;
import es.rogermartinez.paddlemanager.base.datasource.dao.DatabaseHelper;
import es.rogermartinez.paddlemanager.base.datasource.dao.DatabaseManager;
import es.rogermartinez.paddlemanager.base.domain.DomainErrorHandler;
import es.rogermartinez.paddlemanager.base.domain.GlobalDomainModule;
import es.rogermartinez.paddlemanager.base.utils.module.AndroidModule;

@Singleton
@Component(
        modules = {
                AndroidModule.class,
                GlobalDomainModule.class
        }
)
public interface AndroidComponent {
    void inject(BaseApplication application);

    Context getApplicationContext();
    Bus getBusProvider();
    JobManager getJobManager();
    @Named("zulu_with_millis")
    SimpleDateFormat getSimpleDateFormatZuluWithMillis();
    @Named("zulu")
    SimpleDateFormat getSimpleDateFormatZulu();
    @Named("general")
    SimpleDateFormat getSimpleDateFormatGeneral();
    DomainErrorHandler getDomainErrorHandler();
    DatabaseManager getDbManager();
    DatabaseHelper getDataBaseHelper();
}
