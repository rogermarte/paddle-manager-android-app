package es.rogermartinez.paddlemanager.base.domain.interactor.impl;

/**
 * Created by roger.martinez on 13/11/15.
 */

import com.path.android.jobqueue.Job;
import com.path.android.jobqueue.JobManager;
import com.path.android.jobqueue.Params;

import java.util.concurrent.atomic.AtomicInteger;

import es.rogermartinez.paddlemanager.base.domain.DomainErrorHandler;
import es.rogermartinez.paddlemanager.base.domain.events.GeneralErrorEvent;
import es.rogermartinez.paddlemanager.base.domain.interactor.MainThread;


/**
 * @see "https://github.com/path/android-priority-jobqueue/wiki/Job-Configuration"
 */

public abstract class UserCaseJob extends Job {
    protected static final int LOW_PRIORITY = 1;
    protected static final int DEFAULT_PRIORITY = 2;
    protected static final int HIGH_PRIORITY = 3;

    protected static final String GROUP_HIDE_APPLICATION = "hide_application";

    public static final AtomicInteger COUNTER = new AtomicInteger(0);

    private final MainThread mainThread;
    protected JobManager jobManager;
    protected DomainErrorHandler domainErrorHandler;


    protected UserCaseJob(JobManager jobManager, MainThread mainThread, Params params, DomainErrorHandler domainErrorHandler) {
        super(params);
        this.jobManager = jobManager;
        this.mainThread = mainThread;
        this.domainErrorHandler = domainErrorHandler;
    }

    protected void sendCallback(Runnable callback) {
        mainThread.post(callback);
    }

    @Override
    public void onAdded() {
        COUNTER.incrementAndGet();
    }

    @Override
    public void onRun() throws Throwable {
        try {
            //calls abstract method implemented in child UserJob.
            doRun();
            COUNTER.decrementAndGet();
        } catch (Exception e) {
            //CrashlyticsWrapper.logException(e);

            // TODO manage errors
            domainErrorHandler.notifyError(new GeneralErrorEvent(e));
        }
    }

    public abstract void doRun() throws Throwable;

    @Override
    protected void onCancel() {
        COUNTER.decrementAndGet();
    }

    @Override
    protected boolean shouldReRunOnThrowable(Throwable throwable) {
        return false;
    }
}

