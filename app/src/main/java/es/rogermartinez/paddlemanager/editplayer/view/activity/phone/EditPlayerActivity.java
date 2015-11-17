package es.rogermartinez.paddlemanager.editplayer.view.activity.phone;

import android.os.Bundle;

import com.balysv.materialmenu.MaterialMenuDrawable;

import es.rogermartinez.paddlemanager.R;
import es.rogermartinez.paddlemanager.base.domain.events.ErrorEvent;
import es.rogermartinez.paddlemanager.base.view.activity.BaseActivity;
import es.rogermartinez.paddlemanager.editplayer.view.fragment.EditPlayerFragment;

/**
 * Created by roger.martinez on 15/11/15.
 */
public class EditPlayerActivity extends BaseActivity {

    private EditPlayerFragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_player);

        setTitle(getString(R.string.players));

        if (savedInstanceState == null){
            fragment = new EditPlayerFragment();
            getFragmentManager().beginTransaction().add(R.id.container, fragment).commit();
        }
    }

    @Override
    public MaterialMenuDrawable.IconState getDefaultState() {
        return MaterialMenuDrawable.IconState.ARROW;
    }

    @Override
    protected boolean showError(ErrorEvent event) {
        return false;
    }
}
