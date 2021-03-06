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
import es.rogermartinez.paddlemanager.base.daggerutils.PerActivity;
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
    @Named("zulu_with_millis")
    @PerActivity
    SimpleDateFormat provideSimpleDateFormatZuluWithMillis() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault());
        // This is to solve problem with list offer in Zulu hour
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT0"));
        return simpleDateFormat;
    }

    @Provides
    @Named("zulu")
    @PerActivity
    SimpleDateFormat provideSimpleDateFormatZulu() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault());
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        return simpleDateFormat;
    }

    @Provides
    @Named("general")
    @PerActivity
    SimpleDateFormat provideSimpleDateFormatGeneral() {
        return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.getDefault());
    }

    @Provides
    @PerActivity
    public DatabaseManager provideDbManager(Context context) {
        return new DatabaseManager(context);
    }

    @Provides
    @PerActivity
    public DatabaseHelper provideDataBaseHelper(DatabaseManager dbManager) {
        return dbManager.getHelper();
    }

}
