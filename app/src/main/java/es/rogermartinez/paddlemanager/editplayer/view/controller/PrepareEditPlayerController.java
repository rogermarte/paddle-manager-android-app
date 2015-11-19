package es.rogermartinez.paddlemanager.editplayer.view.controller;

import javax.inject.Inject;

import es.rogermartinez.paddlemanager.base.domain.model.Player;
import es.rogermartinez.paddlemanager.editplayer.domain.callback.CreatePlayerCallback;
import es.rogermartinez.paddlemanager.editplayer.domain.usercase.CreatePlayer;

/**
 * Created by roger.martinez on 15/11/15.
 */
public class PrepareEditPlayerController {

    private CreatePlayer job;
    private View view;

    public void setView(View view) {
        this.view = view;
    }

    @Inject
    public PrepareEditPlayerController(CreatePlayer createPlayer){
        this.job = createPlayer;
    }

    public void getPlayer(){
        view.findPlayerComplete(new Player());
    }

    public void createPlayer(final Player player) {
        job.createPlayer(player, new CreatePlayerCallback() {
            @Override
            public void onCreatePlayerSuccess() {
                view.createPlayerComplete(player);
            }
        });
    }

    public interface View {
        void findPlayerComplete(Player player);
        void createPlayerComplete(Player player);
    }


}
