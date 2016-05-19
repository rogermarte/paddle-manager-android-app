package es.rogermartinez.paddlemanager.listplayers.view.activity.phone;

import android.os.Bundle;

import es.rogermartinez.paddlemanager.R;
import es.rogermartinez.paddlemanager.base.daggerutils.HasComponent;
import es.rogermartinez.paddlemanager.base.view.activity.DrawerActivity;
import es.rogermartinez.paddlemanager.injector.DaggerListPlayersComponent;
import es.rogermartinez.paddlemanager.injector.ListPlayersComponent;
import es.rogermartinez.paddlemanager.listplayers.view.fragment.ListPlayersActivityFragment;
import es.rogermartinez.paddlemanager.base.domain.events.ErrorEvent;

public class ListPlayersActivity extends DrawerActivity implements HasComponent<ListPlayersComponent> {

    public static final int CREATE_PLAYER_RESULT_ID = 200;
    private ListPlayersActivityFragment playersFragment;

    private ListPlayersComponent listPlayersComponent;

    private void initializeInjector(){
        this.listPlayersComponent = DaggerListPlayersComponent.builder()
                .applicationComponent(getApplicationComponent())

                .activityModule(getActivityModule())
                .build();
    }

    @Override
    public ListPlayersComponent getComponent(){
        return listPlayersComponent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_players);

        initializeInjector();

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
