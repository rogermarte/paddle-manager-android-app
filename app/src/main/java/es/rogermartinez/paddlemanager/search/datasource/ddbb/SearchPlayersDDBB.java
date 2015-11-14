package es.rogermartinez.paddlemanager.search.datasource.ddbb;

import es.rogermartinez.paddlemanager.search.datasource.ddbb.model.PlayersSearchResultDDBBModel;
import es.rogermartinez.paddlemanager.search.domain.model.QueryPlayer;

/**
 * Created by roger.martinez on 13/11/15.
 */
public interface SearchPlayersDDBB {
    PlayersSearchResultDDBBModel search(QueryPlayer queryPlayer);
}
