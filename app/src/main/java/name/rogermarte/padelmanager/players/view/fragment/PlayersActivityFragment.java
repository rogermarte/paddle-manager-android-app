package name.rogermarte.padelmanager.players.view.fragment;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import name.rogermarte.padelmanager.R;
import name.rogermarte.padelmanager.base.domain.events.ErrorEvent;
import name.rogermarte.padelmanager.base.view.fragment.BaseFragment;
import name.rogermarte.padelmanager.players.view.controller.PreparePlayersController;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlayersActivityFragment extends BaseFragment implements PreparePlayersController.View {

    @Inject
    PreparePlayersController controller;

    private View rootView;
    private Context applicationContext = null;

    public PlayersActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_players, container, false);
        applicationContext = getActivity().getApplicationContext();
        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        controller.setView(this);
    }


    @Override
    public boolean showError(ErrorEvent event) {
        return false;
    }

    @Override
    public String getName() {
        return null;
    }
}
