package es.rogermartinez.paddlemanager.listplayers.view.activity.phone;

import android.os.Bundle;

import es.rogermartinez.paddlemanager.R;
import es.rogermartinez.paddlemanager.base.view.activity.DrawerActivity;
import es.rogermartinez.paddlemanager.listplayers.view.fragment.ListPlayersActivityFragment;
import es.rogermartinez.paddlemanager.base.domain.events.ErrorEvent;

public class ListPlayersActivity extends DrawerActivity {

    public static final int CREATE_PLAYER_RESULT_ID = 200;
    private ListPlayersActivityFragment playersFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_players);

        setTitle(getString(R.string.players));

        if (savedInstanceState == null){
            playersFragment = new ListPlayersActivityFragment();
            getFragmentManager().beginTransaction().add(R.id.container, playersFragment).commit();
        }
    }

    @Override
    protected boolean showError(ErrorEvent event) {
        if (playersFragment != null) {
            return playersFragment.showError(event);
        }
        return false;
    }
}
