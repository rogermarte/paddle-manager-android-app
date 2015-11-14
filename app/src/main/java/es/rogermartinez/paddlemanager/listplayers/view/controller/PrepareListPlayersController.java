package es.rogermartinez.paddlemanager.listplayers.view.controller;

import java.util.List;

import javax.inject.Inject;

import es.rogermartinez.paddlemanager.base.domain.model.Player;
import es.rogermartinez.paddlemanager.listplayers.domain.usercase.SearchPlayers;
import es.rogermartinez.paddlemanager.search.domain.callback.SearchPlayerCallback;
import es.rogermartinez.paddlemanager.search.domain.model.QueryPlayer;
import es.rogermartinez.paddlemanager.search.domain.model.SearchPlayersResult;

/**
 * Created by roger.martinez on 9/10/15.
 */
public class PrepareListPlayersController {

    private View view;

    public void setView(View view) {
        this.view = view;
    }

    private SearchPlayers searchPlayersJob;

    @Inject
    public PrepareListPlayersController(SearchPlayers searchPlayers){
        this.searchPlayersJob = searchPlayers;
    }

    private SearchPlayerCallback searchPlayerCompleteCallback = new SearchPlayerCallback() {
        @Override
        public void onSearchComplete(SearchPlayersResult searchResult) {
            view.seachPlayersComplete(searchResult);
        }
    };

    public void search(){
        searchPlayersJob.search(new QueryPlayer(), searchPlayerCompleteCallback);
    }

    public interface View {
        void seachPlayersComplete(SearchPlayersResult searchPlayersResult);
    }
}
