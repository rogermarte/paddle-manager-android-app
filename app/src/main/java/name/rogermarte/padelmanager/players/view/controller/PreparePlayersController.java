package name.rogermarte.padelmanager.players.view.controller;

/**
 * Created by roger.martinez on 9/10/15.
 */
public class PreparePlayersController {

    private View view;

    public void setView(View view) {
        this.view = view;
    }

    public interface View {
        String getName();
    }
}
