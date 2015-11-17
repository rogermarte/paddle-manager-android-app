package es.rogermartinez.paddlemanager.editplayer.view.controller;

import es.rogermartinez.paddlemanager.base.domain.model.Player;

/**
 * Created by roger.martinez on 15/11/15.
 */
public class PrepareEditPlayerController {

    private View view;

    public void setView(View view) {
        this.view = view;
    }

    public void getPlayer(){
        view.findPlayerComplete(new Player());
    }

    public interface View {
        void findPlayerComplete(Player player);
    }
}
