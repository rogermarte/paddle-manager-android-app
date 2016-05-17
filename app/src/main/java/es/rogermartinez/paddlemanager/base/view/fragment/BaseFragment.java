package es.rogermartinez.paddlemanager.base.view.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.View;

import butterknife.ButterKnife;
import es.rogermartinez.paddlemanager.base.daggerutils.HasComponent;
import es.rogermartinez.paddlemanager.base.domain.events.ErrorEvent;
import es.rogermartinez.paddlemanager.base.view.activity.BaseActivity;

/**
 * Created by roger.martinez on 9/10/15.
 */
public abstract class BaseFragment extends Fragment {

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
    }

    public abstract boolean showError(ErrorEvent event);

    @Override
    public void onResume() {
        super.onResume();
    }

    @SuppressWarnings("unchecked")
    protected <C> C getComponent(Class<C> componentType) {
        return componentType.cast(((HasComponent<C>) getActivity()).getComponent());
    }

}
