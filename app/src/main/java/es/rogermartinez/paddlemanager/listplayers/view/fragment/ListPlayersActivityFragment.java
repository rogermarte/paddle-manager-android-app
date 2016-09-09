package es.rogermartinez.paddlemanager.listplayers.view.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import javax.inject.Inject;

import butterknife.OnClick;
import es.rogermartinez.paddlemanager.R;
import es.rogermartinez.paddlemanager.base.domain.events.ErrorEvent;
import es.rogermartinez.paddlemanager.base.domain.model.Player;
import es.rogermartinez.paddlemanager.base.view.fragment.BaseFragment;
import es.rogermartinez.paddlemanager.editplayer.view.activity.phone.EditPlayerActivity;
import es.rogermartinez.paddlemanager.injector.ListPlayersComponent;
import es.rogermartinez.paddlemanager.listplayers.view.activity.phone.ListPlayersActivity;
import es.rogermartinez.paddlemanager.listplayers.view.adapter.ListPlayersAdapter;
import es.rogermartinez.paddlemanager.listplayers.view.controller.PrepareListPlayersController;
import es.rogermartinez.paddlemanager.search.domain.model.SearchPlayersResult;

/**
 * A placeholder fragment containing a simple view.
 */
public class ListPlayersActivityFragment extends BaseFragment implements PrepareListPlayersController.View {

    @Inject
    PrepareListPlayersController controller;

    private RecyclerView.Adapter mAdapter;

    List<Player> players;

    public ListPlayersActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_players, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        controller.setView(this);
        controller.search();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getComponent(ListPlayersComponent.class).inject(this);
    }

    @Override
    public boolean showError(ErrorEvent event) {
        return false;
    }

    @Override
    public void seachPlayersComplete(SearchPlayersResult searchPlayersResult) {
        if(isAdded()) {

            players = searchPlayersResult.getPlayers();
            // use this setting to improve performance if you know that changes
            // in content do not change the layout size of the RecyclerView
            RecyclerView mRecyclerView = (RecyclerView) getActivity().findViewById(R.id.rv_players);
            mRecyclerView.setHasFixedSize(true);

            // use a linear layout manager
            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
            mRecyclerView.setLayoutManager(mLayoutManager);

            mRecyclerView.setItemAnimator(new DefaultItemAnimator());
            // specify an adapter (see also next example)
            mAdapter = new ListPlayersAdapter(players);
            mRecyclerView.setAdapter(mAdapter);

            FloatingActionButton fab = (FloatingActionButton) getActivity().findViewById(R.id.fab);

        }
    }
    @OnClick(R.id.fab)
    public void addPlayer(){
        Intent intent = new Intent(getActivity(), EditPlayerActivity.class);
        startActivityForResult(intent, ListPlayersActivity.CREATE_PLAYER_RESULT_ID);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == Activity.RESULT_OK && requestCode == ListPlayersActivity.CREATE_PLAYER_RESULT_ID){
            Player p = (Player)data.getSerializableExtra("PLAYER");
            players.add(p);
            mAdapter.notifyItemInserted(players.size());
        }
    }
}
