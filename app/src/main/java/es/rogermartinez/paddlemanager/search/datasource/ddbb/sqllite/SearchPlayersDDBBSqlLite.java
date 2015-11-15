package es.rogermartinez.paddlemanager.search.datasource.ddbb.sqllite;

import java.util.Arrays;

import javax.inject.Inject;

import es.rogermartinez.paddlemanager.search.datasource.ddbb.SearchPlayersDDBB;
import es.rogermartinez.paddlemanager.search.datasource.ddbb.model.PlayerDDBBModel;
import es.rogermartinez.paddlemanager.search.datasource.ddbb.model.PlayersSearchResultDDBBModel;
import es.rogermartinez.paddlemanager.search.domain.model.QueryPlayer;

/**
 * Created by roger.martinez on 13/11/15.
 */
public class SearchPlayersDDBBSqlLite implements SearchPlayersDDBB {

    @Inject
    public SearchPlayersDDBBSqlLite(){

    }

    @Override
    public PlayersSearchResultDDBBModel search(QueryPlayer queryPlayer) {
        PlayerDDBBModel[] players = {
                new PlayerDDBBModel("FB", "Fernando", "Belasteguin", 100),
                new PlayerDDBBModel("JMD", "Juan", "Martin Diaz", 99),
                new PlayerDDBBModel("PL", "Pablo", "Lima", 98),
                new PlayerDDBBModel("PN", "Paquito", "Navarro", 97),
                new PlayerDDBBModel("SG", "Sanyo", "Gutierrez", 96),
                new PlayerDDBBModel("JM", "Juani", "Mieres", 95),
                new PlayerDDBBModel("MDS", "Matias", "Diaz Sangiorgio", 94),
                new PlayerDDBBModel("MS", "Maxi", "Sanchez", 93),
                new PlayerDDBBModel("CG", "Cristian", "Gutierrez", 92),
                new PlayerDDBBModel("ML", "Miguel", "Lamperti", 91),
                new PlayerDDBBModel("FB", "Fernando", "Belasteguin", 100),
                new PlayerDDBBModel("JMD", "Juan", "Martin Diaz", 99),
                new PlayerDDBBModel("PL", "Pablo", "Lima", 98),
                new PlayerDDBBModel("PN", "Paquito", "Navarro", 97),
                new PlayerDDBBModel("SG", "Sanyo", "Gutierrez", 96),
                new PlayerDDBBModel("JM", "Juani", "Mieres", 95),
                new PlayerDDBBModel("MDS", "Matias", "Diaz Sangiorgio", 94),
                new PlayerDDBBModel("MS", "Maxi", "Sanchez", 93),
                new PlayerDDBBModel("CG", "Cristian", "Gutierrez", 92),
                new PlayerDDBBModel("ML", "Miguel", "Lamperti", 91),
                new PlayerDDBBModel("FB", "Fernando", "Belasteguin", 100),
                new PlayerDDBBModel("JMD", "Juan", "Martin Diaz", 99),
                new PlayerDDBBModel("PL", "Pablo", "Lima", 98),
                new PlayerDDBBModel("PN", "Paquito", "Navarro", 97),
                new PlayerDDBBModel("SG", "Sanyo", "Gutierrez", 96),
                new PlayerDDBBModel("JM", "Juani", "Mieres", 95),
                new PlayerDDBBModel("MDS", "Matias", "Diaz Sangiorgio", 94),
                new PlayerDDBBModel("MS", "Maxi", "Sanchez", 93),
                new PlayerDDBBModel("CG", "Cristian", "Gutierrez", 92),
                new PlayerDDBBModel("ML", "Miguel", "Lamperti", 91)
        };
        PlayersSearchResultDDBBModel playersSearchResultDDBBModel = new PlayersSearchResultDDBBModel(Arrays.asList(players));
        return playersSearchResultDDBBModel;
    }
}
