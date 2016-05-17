package es.rogermartinez.paddlemanager.injector;

/*
 * Copyright (C) 2013 Square, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import android.content.Context;

import com.path.android.jobqueue.JobManager;
import com.squareup.otto.Bus;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import es.rogermartinez.paddlemanager.base.application.AndroidApplication;
import es.rogermartinez.paddlemanager.base.daggerutils.ForApplication;
import es.rogermartinez.paddlemanager.base.domain.interactor.MainThread;
import es.rogermartinez.paddlemanager.base.domain.interactor.impl.MainThreadHandler;
import es.rogermartinez.paddlemanager.base.utils.module.MainThreadBus;
import es.rogermartinez.paddlemanager.search.domain.model.QueryPlayer;

/**
 * A module for Android-specific dependencies which require a {@link android.content.Context} or
 * {@link android.app.Application} to create.
 */
@Module
public class ApplicationModule {
    private final AndroidApplication application;

    public ApplicationModule(AndroidApplication application) {
        this.application = application;
    }

    @Singleton
    @Provides
    Context provideApplicationContext() {
        return application;
    }

    @Singleton
    @Provides
    Bus provideBusProvider() {	return new MainThreadBus(); }

    @Singleton
    @Provides
    JobManager provideJobManager() {
        return new JobManager(application);
    }

    @Singleton
    @Provides
    MainThread provideMainThread(MainThreadHandler mainThreadHandler) {
        return mainThreadHandler;
    }

    @Singleton
    @Provides
    public Map<QueryPlayer, QueryPlayer> provideSearchPlayersCache() {
        return new ConcurrentHashMap<QueryPlayer, QueryPlayer>();
    }
}
