package es.rogermartinez.paddlemanager.editplayer.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;

import javax.inject.Inject;

import butterknife.Bind;
import es.rogermartinez.paddlemanager.R;
import es.rogermartinez.paddlemanager.base.domain.events.ErrorEvent;
import es.rogermartinez.paddlemanager.base.domain.model.Player;
import es.rogermartinez.paddlemanager.base.view.fragment.BaseFragment;
import es.rogermartinez.paddlemanager.editplayer.view.controller.PrepareEditPlayerController;

/**
 * Created by roger.martinez on 15/11/15.
 */
public class EditPlayerFragment extends BaseFragment implements PrepareEditPlayerController.View {

    @Inject
    PrepareEditPlayerController controller;

    @Bind(R.id.et_player_name)
    EditText mPlayerName;

    @Bind(R.id.et_player_surname)
    EditText mPlayerSurname;

    @Bind(R.id.et_player_level)
    EditText mPlayerLevel;

    @Bind(R.id.r_player_level_both)
    RadioButton mPlayerLevelBoth;
    @Bind(R.id.r_player_level_left)
    RadioButton mPlayerLevelLeft;
    @Bind(R.id.r_player_level_right)
    RadioButton mPlayerLevelRight;

    private View rootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_edit_player, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        controller.setView(this);
        controller.getPlayer();
    }

    @Override
    public boolean showError(ErrorEvent event) {
        return false;
    }

    @Override
    public void findPlayerComplete(Player player) {
        if (isAdded()){

        }
    }
}
