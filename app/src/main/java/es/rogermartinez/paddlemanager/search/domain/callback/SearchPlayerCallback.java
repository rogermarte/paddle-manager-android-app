package es.rogermartinez.paddlemanager.search.domain.callback;

import es.rogermartinez.paddlemanager.search.domain.model.SearchPlayersResult;

/**
 * Created by roger.martinez on 13/11/15.
 */
public interface SearchPlayerCallback {
    void onSearchComplete(SearchPlayersResult searchResult);
}
