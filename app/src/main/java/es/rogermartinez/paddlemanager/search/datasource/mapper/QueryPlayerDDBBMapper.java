package es.rogermartinez.paddlemanager.search.datasource.mapper;

import es.rogermartinez.paddlemanager.search.datasource.dao.model.SearchPlayerDDBBModel;
import es.rogermartinez.paddlemanager.search.domain.model.QueryPlayer;

/**
 * Created by roger.martinez on 13/11/15.
 */
public class QueryPlayerDDBBMapper {

    public SearchPlayerDDBBModel update(SearchPlayerDDBBModel searchPlayerDDBBModel, QueryPlayer queryPlayer){
        searchPlayerDDBBModel.setName(queryPlayer.getName());
        searchPlayerDDBBModel.setSurname(queryPlayer.getSurname());
        return searchPlayerDDBBModel;
    }

    public SearchPlayerDDBBModel convert(QueryPlayer queryPlayer){
        return update(new SearchPlayerDDBBModel(), queryPlayer);
    }

    public QueryPlayer convert(SearchPlayerDDBBModel searchPlayerDDBBModel){
        QueryPlayer queryPlayer = new QueryPlayer();
        queryPlayer.setName(searchPlayerDDBBModel.getName());
        queryPlayer.setSurname(searchPlayerDDBBModel.getSurname());
        return queryPlayer;
    }
}
