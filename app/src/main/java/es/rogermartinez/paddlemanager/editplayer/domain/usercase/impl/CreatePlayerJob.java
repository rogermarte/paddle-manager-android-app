package es.rogermartinez.paddlemanager.editplayer.domain.usercase.impl;

import com.path.android.jobqueue.JobManager;
import com.path.android.jobqueue.Params;

import javax.inject.Inject;

import es.rogermartinez.paddlemanager.base.domain.DomainErrorHandler;
import es.rogermartinez.paddlemanager.base.domain.interactor.MainThread;
import es.rogermartinez.paddlemanager.base.domain.interactor.impl.UserCaseJob;
import es.rogermartinez.paddlemanager.base.domain.model.Player;
import es.rogermartinez.paddlemanager.editplayer.datasource.CreatePlayerDataSource;
import es.rogermartinez.paddlemanager.editplayer.domain.callback.CreatePlayerCallback;
import es.rogermartinez.paddlemanager.editplayer.domain.usercase.CreatePlayer;

/**
 * Created by roger.martinez on 17/11/15.
 */
public class CreatePlayerJob extends UserCaseJob implements CreatePlayer {

    private Player player;
    private CreatePlayerCallback callback;
    private CreatePlayerDataSource createPlayerDataSource;

    @Inject
    public CreatePlayerJob(JobManager jobManager, MainThread mainThread,
                           DomainErrorHandler domainErrorHandler, CreatePlayerDataSource createPlayerDataSource){
        super(jobManager, mainThread, new Params(UserCaseJob.DEFAULT_PRIORITY).setRequiresNetwork(false), domainErrorHandler);
        this.createPlayerDataSource = createPlayerDataSource;
    }


    @Override
    public void doRun() throws Throwable {
        createPlayerDataSource.createPlayer(player);
        notifyPlayerCreated();
    }

    public void createPlayer(Player player, CreatePlayerCallback callback){
        this.player = player;
        this.callback = callback;
        jobManager.addJob(this);
    }

    private void notifyPlayerCreated(){
        sendCallback(new Runnable() {
            @Override
            public void run() {
                callback.onCreatePlayerSuccess();
            }
        });
    }
}
