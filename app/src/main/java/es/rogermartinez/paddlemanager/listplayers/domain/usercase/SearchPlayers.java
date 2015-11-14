package es.rogermartinez.paddlemanager.listplayers.domain.usercase;

import es.rogermartinez.paddlemanager.search.domain.callback.SearchPlayerCallback;
import es.rogermartinez.paddlemanager.search.domain.model.QueryPlayer;

/**
 * Created by roger.martinez on 13/11/15.
 */
public interface SearchPlayers {
    void search(QueryPlayer queryPlayer, SearchPlayerCallback callback);
}
