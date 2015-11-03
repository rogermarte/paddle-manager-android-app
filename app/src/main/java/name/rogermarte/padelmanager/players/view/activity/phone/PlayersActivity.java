package name.rogermarte.padelmanager.players.view.activity.phone;

import android.app.FragmentManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.balysv.materialmenu.MaterialMenuDrawable;

import name.rogermarte.padelmanager.R;
import name.rogermarte.padelmanager.base.domain.events.ErrorEvent;
import name.rogermarte.padelmanager.base.view.activity.BaseActivity;
import name.rogermarte.padelmanager.players.view.fragment.PlayersActivityFragment;

public class PlayersActivity extends BaseActivity {

    private PlayersActivityFragment playersFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_players);
        if (savedInstanceState == null){
            playersFragment = new PlayersActivityFragment();
            getFragmentManager().beginTransaction().add(R.id.container, playersFragment).commit();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public MaterialMenuDrawable.IconState getDefaultState() {
        return MaterialMenuDrawable.IconState.ARROW;
    }

    @Override
    protected boolean showError(ErrorEvent event) {
        if (playersFragment != null) {
            return playersFragment.showError(event);
        }
        return false;
    }
}
