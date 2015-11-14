package es.rogermartinez.paddlemanager.listplayers.domain.model;

import java.util.List;

/**
 * Created by roger.martinez on 9/11/15.
 */
public class ListPlayersListResult {
    private int currentPage;
    private int pageSize;
    private int totalResults;
    private List<ListPlayersListModel> players;

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public List<ListPlayersListModel> getPlayers() {
        return players;
    }

    public void setPlayers(List<ListPlayersListModel> players) {
        this.players = players;
    }
}
