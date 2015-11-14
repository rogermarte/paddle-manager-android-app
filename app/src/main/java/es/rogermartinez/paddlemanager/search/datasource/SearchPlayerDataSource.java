package es.rogermartinez.paddlemanager.search.datasource;

import es.rogermartinez.paddlemanager.search.domain.model.QueryPlayer;
import es.rogermartinez.paddlemanager.search.domain.model.SearchPlayersResult;

/**
 * Created by roger.martinez on 13/11/15.
 */
public interface SearchPlayerDataSource {
    SearchPlayersResult search(QueryPlayer queryPlayer);
}
