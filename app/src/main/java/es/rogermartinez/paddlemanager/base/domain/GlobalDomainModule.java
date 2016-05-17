package es.rogermartinez.paddlemanager.base.domain;

import android.content.Context;

import com.path.android.jobqueue.JobManager;
import com.squareup.otto.Bus;

import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import es.rogermartinez.paddlemanager.base.daggerutils.ForApplication;
import es.rogermartinez.paddlemanager.base.datasource.dao.DatabaseHelper;
import es.rogermartinez.paddlemanager.base.datasource.dao.DatabaseManager;
import es.rogermartinez.paddlemanager.base.domain.interactor.MainThread;
import es.rogermartinez.paddlemanager.base.domain.interactor.impl.MainThreadHandler;

/**
 * This module provide global dependencies for all domain objects.
 */
@Module
public class GlobalDomainModule {
    @Provides
    JobManager provideJobManager(Context context) {
        return new JobManager(context);
    }

    @Provides
    MainThread provideMainThread(MainThreadHandler mainThreadHandler) {
        return mainThreadHandler;
    }

    @Provides
    @Named("zulu_with_millis")
    SimpleDateFormat provideSimpleDateFormatZuluWithMillis() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault());
        // This is to solve problem with list offer in Zulu hour
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT0"));
        return simpleDateFormat;
    }

    @Provides
    @Named("zulu")
    SimpleDateFormat provideSimpleDateFormatZulu() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault());
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        return simpleDateFormat;
    }

    @Provides
    @Named("general")
    SimpleDateFormat provideSimpleDateFormatGeneral() {
        return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.getDefault());
    }

    @Provides
    DomainErrorHandler provideDomainErrorHandler(Bus bus) {
        return new DomainErrorHandler(bus);
    }

    @Provides
    public DatabaseManager provideDbManager(Context context) {
        return new DatabaseManager(context);
    }

    @Provides
    public DatabaseHelper provideDataBaseHelper(DatabaseManager dbManager) {
        return dbManager.getHelper();
    }

}
