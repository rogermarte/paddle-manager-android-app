package es.rogermartinez.paddlemanager.listplayers.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.os.Debug;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import es.rogermartinez.paddlemanager.R;
import es.rogermartinez.paddlemanager.base.domain.events.ErrorEvent;
import es.rogermartinez.paddlemanager.base.view.fragment.BaseFragment;
import es.rogermartinez.paddlemanager.listplayers.view.adapter.ListPlayersAdapter;
import es.rogermartinez.paddlemanager.listplayers.view.controller.PrepareListPlayersController;
import es.rogermartinez.paddlemanager.search.domain.model.SearchPlayersResult;

/**
 * A placeholder fragment containing a simple view.
 */
public class ListPlayersActivityFragment extends BaseFragment implements PrepareListPlayersController.View {

    @Inject
    PrepareListPlayersController controller;

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;


    private View rootView;
    private Context applicationContext = null;

    public ListPlayersActivityFragment() {
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
        controller.search();
    }


    @Override
    public boolean showError(ErrorEvent event) {
        return false;
    }

    @Override
    public void seachPlayersComplete(SearchPlayersResult searchPlayersResult) {
        if(isAdded()) {
            // use this setting to improve performance if you know that changes
            // in content do not change the layout size of the RecyclerView
            mRecyclerView = (RecyclerView)getActivity().findViewById(R.id.rv_players);
            mRecyclerView.setHasFixedSize(true);

            // use a linear layout manager
            mLayoutManager = new LinearLayoutManager(getActivity());
            mRecyclerView.setLayoutManager(mLayoutManager);

            // specify an adapter (see also next example)
            mAdapter = new ListPlayersAdapter(searchPlayersResult.getPlayers());
            mRecyclerView.setAdapter(mAdapter);
        }
    }
}
