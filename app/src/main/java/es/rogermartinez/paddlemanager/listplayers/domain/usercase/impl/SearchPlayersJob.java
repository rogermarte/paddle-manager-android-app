package es.rogermartinez.paddlemanager.listplayers.domain.usercase.impl;

import com.path.android.jobqueue.JobManager;
import com.path.android.jobqueue.Params;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import es.rogermartinez.paddlemanager.base.domain.DomainErrorHandler;
import es.rogermartinez.paddlemanager.base.domain.interactor.MainThread;
import es.rogermartinez.paddlemanager.base.domain.interactor.impl.UserCaseJob;
import es.rogermartinez.paddlemanager.base.domain.model.Player;
import es.rogermartinez.paddlemanager.listplayers.domain.usercase.SearchPlayers;
import es.rogermartinez.paddlemanager.search.datasource.SearchPlayerDataSource;
import es.rogermartinez.paddlemanager.search.domain.callback.SearchPlayerCallback;
import es.rogermartinez.paddlemanager.search.domain.model.QueryPlayer;
import es.rogermartinez.paddlemanager.search.domain.model.SearchPlayersResult;

/**
 * Created by roger.martinez on 13/11/15.
 */
public class SearchPlayersJob extends UserCaseJob implements SearchPlayers {

    private SearchPlayerCallback callback;
    private QueryPlayer queryPlayer;
    private SearchPlayerDataSource searchDataSource;

    @Inject
    SearchPlayersJob(JobManager jobManager, MainThread mainThread,
                     DomainErrorHandler domainErrorHandler, SearchPlayerDataSource searchDataSource
                     ){
        super(jobManager, mainThread, new Params(UserCaseJob.DEFAULT_PRIORITY), domainErrorHandler);
        this.searchDataSource = searchDataSource;
    }

    @Override
    public void search(QueryPlayer queryPlayer, SearchPlayerCallback callback) {
        this.queryPlayer = queryPlayer;
        this.callback = callback;
        jobManager.addJob(this);
    }

    @Override
    public void doRun() throws Throwable {
        SearchPlayersResult result = searchDataSource.search(queryPlayer);
        notifySearchPlayerComplete(result);
    }

    private void notifySearchPlayerComplete(final SearchPlayersResult searchPlayersResult){
        sendCallback(new Runnable() {
            @Override
            public void run() {
                callback.onSearchComplete(searchPlayersResult);
            }
        });
    }
}
