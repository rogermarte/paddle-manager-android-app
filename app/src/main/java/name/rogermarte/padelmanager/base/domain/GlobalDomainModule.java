package name.rogermarte.padelmanager.base.domain;

import android.content.Context;

import com.path.android.jobqueue.JobManager;

import java.text.SimpleDateFormat;
import java.util.TimeZone;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import name.rogermarte.padelmanager.base.daggerutils.ForApplication;
import name.rogermarte.padelmanager.base.domain.interactor.MainThread;
import name.rogermarte.padelmanager.base.domain.interactor.impl.MainThreadHandler;

/**
 * This module provide global dependencies for all domain objects.
 */
@Module(complete = false,
        library = true)
public class GlobalDomainModule {
    @Provides
    @Singleton
    JobManager provideJobManager(@ForApplication Context context) {
        return new JobManager(context);
    }

    @Provides
    @Singleton
    MainThread provideMainThread(MainThreadHandler mainThreadHandler) {
        return mainThreadHandler;
    }

    @Provides
    @Named("zulu_with_millis")
    SimpleDateFormat provideSimpleDateFormatZuluWithMillis() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        // This is to solve problem with list offer in Zulu hour
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT0"));
        return simpleDateFormat;
    }

    @Provides
    @Named("zulu")
    SimpleDateFormat provideSimpleDateFormatZulu() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        return simpleDateFormat;
    }

    @Provides
    @Named("general")
    SimpleDateFormat provideSimpleDateFormatGeneral() {
        return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
    }
}
