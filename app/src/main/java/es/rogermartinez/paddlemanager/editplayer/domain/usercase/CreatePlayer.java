package es.rogermartinez.paddlemanager.editplayer.domain.usercase;

import es.rogermartinez.paddlemanager.base.domain.model.Player;
import es.rogermartinez.paddlemanager.editplayer.domain.callback.CreatePlayerCallback;

/**
 * Created by roger.martinez on 17/11/15.
 */
public interface CreatePlayer {
    void createPlayer(Player player, CreatePlayerCallback callback);
}
