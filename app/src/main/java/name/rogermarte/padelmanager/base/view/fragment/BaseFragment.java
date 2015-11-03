package name.rogermarte.padelmanager.base.view.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.View;

import butterknife.ButterKnife;
import name.rogermarte.padelmanager.base.domain.events.ErrorEvent;
import name.rogermarte.padelmanager.base.view.activity.BaseActivity;

/**
 * Created by roger.martinez on 9/10/15.
 */
public abstract class BaseFragment extends Fragment {

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        ((BaseActivity) this.getActivity()).inject(this);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.inject(this, view);
    }

    public abstract boolean showError(ErrorEvent event);

    @Override
    public void onResume() {
        super.onResume();
    }

}
