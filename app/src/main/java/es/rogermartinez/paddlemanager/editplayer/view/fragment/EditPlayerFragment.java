package es.rogermartinez.paddlemanager.editplayer.view.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.OnClick;
import es.rogermartinez.paddlemanager.R;
import es.rogermartinez.paddlemanager.base.domain.events.ErrorEvent;
import es.rogermartinez.paddlemanager.base.domain.model.Player;
import es.rogermartinez.paddlemanager.base.view.fragment.BaseFragment;
import es.rogermartinez.paddlemanager.editplayer.view.controller.PrepareEditPlayerController;
import fr.ganfra.materialspinner.MaterialSpinner;

/**
 * Created by roger.martinez on 15/11/15.
 */
public class EditPlayerFragment extends BaseFragment implements PrepareEditPlayerController.View {

    @Inject
    PrepareEditPlayerController controller;

    @Bind(R.id.til_player_name)
    TextInputLayout inputLayoutName;

    @Bind(R.id.et_player_name)
    EditText mPlayerName;

    @Bind(R.id.ms_player_level)
    MaterialSpinner mPlayerLevel;

    @Bind(R.id.ms_player_sex)
    MaterialSpinner mPlayerSex;

    @Bind(R.id.ms_player_position)
    MaterialSpinner mPlayerPosition;

    @Bind(R.id.til_player_comment)
    TextInputLayout inputLayoutComment;

    @Bind(R.id.et_player_comment)
    EditText mPlayerComment;

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

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.levels_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        mPlayerLevel.setAdapter(adapter);

        adapter = ArrayAdapter.createFromResource(getActivity(), R.array.sex_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mPlayerSex.setAdapter(adapter);

        adapter = ArrayAdapter.createFromResource(getActivity(), R.array.positions_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mPlayerPosition.setAdapter(adapter);

        controller.setView(this);
        controller.getPlayer();
    }

    @OnClick(R.id.btn_add_player)
    public void createPlayer(){
        if (!hasErrors()) {

            Player player = new Player();
            player.setName(mPlayerName.getText().toString());
            player.setLevel(mPlayerLevel.getSelectedItemPosition());
            player.setSex(mPlayerSex.getSelectedItemPosition());
            player.setPosition(mPlayerPosition.getSelectedItemPosition());
            player.setComment(mPlayerComment.getText().toString());
            controller.createPlayer(player);
        }
    }

    private boolean hasErrors() {
        boolean hasErrors = false;
        if (mPlayerName.getText().length() == 0){
            inputLayoutName.setError(getString(R.string.error_field_name)); // show error
            hasErrors = true;
        } else {
            inputLayoutName.setError(null); // hide error
        }
        if (mPlayerLevel.getSelectedItemPosition() <= 0){
            mPlayerLevel.setError(getString(R.string.error_field_level));
            hasErrors = true;
        } else {
            mPlayerLevel.setError(null);
        }
        if (mPlayerSex.getSelectedItemPosition() <= 0 ) {
            mPlayerSex.setError(getString(R.string.error_field_sex));
        } else {
            mPlayerSex.setError(null);
        }
        if(mPlayerPosition.getSelectedItemPosition() <= 0){
            mPlayerPosition.setError(getString(R.string.error_field_position));
        } else {
            mPlayerPosition.setError(null);
        }
        if (mPlayerComment.getText().length() > inputLayoutComment.getCounterMaxLength()){
            hasErrors = true;
        }

        return hasErrors;
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

    @Override
    public void createPlayerComplete(Player player) {
        if(isAdded()){
            Intent intent = getActivity().getIntent();
            intent.putExtra("PLAYER", player);
            getActivity().setResult(Activity.RESULT_OK, intent);
            getActivity().finish();
        }
    }
}
