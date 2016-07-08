package es.rogermartinez.paddlemanager.listplayers.view.adapter;

import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import es.rogermartinez.paddlemanager.R;
import es.rogermartinez.paddlemanager.base.domain.model.Player;

/**
 * Created by roger.martinez on 13/11/15.
 */
public class ListPlayersAdapter extends RecyclerView.Adapter<ListPlayersAdapter.ViewHolder> {
    private List<Player> mDataset;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        // each data item is just a string in this case
        public TextView mTVPlayerName;
        public TextView mTVPlayerLevel;
        public ViewHolder(View view) {
            super(view);
            view.setOnClickListener(this);
            mTVPlayerName = (TextView)view.findViewById(R.id.tv_player_name);
            mTVPlayerLevel = (TextView)view.findViewById(R.id.tv_player_level);
        }

        @Override
        public void onClick(View view) {
            Log.d("AD", "onClick " + getAdapterPosition() + " " + getItemId());
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public ListPlayersAdapter(List<Player> myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ListPlayersAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.player_list_item, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        Player player = mDataset.get(position);
        holder.mTVPlayerName.setText(player.getName());
        Resources resources = holder.itemView.getContext().getResources();
        String[] levels = resources.getStringArray(R.array.levels_array);
        String[] sexs = resources.getStringArray(R.array.sex_array);
        String[] positions = resources.getStringArray(R.array.positions_array);

        String secondaryContent = "";
        secondaryContent += String.valueOf(sexs[player.getSex()-1]);
        secondaryContent += " | ";
        secondaryContent += String.valueOf(positions[player.getPosition()-1]);
        secondaryContent += " | ";
        secondaryContent += String.valueOf(levels[player.getLevel()-1]);

        holder.mTVPlayerLevel.setText(secondaryContent);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
