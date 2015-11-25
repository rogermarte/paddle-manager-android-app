package es.rogermartinez.paddlemanager.base.view.activity;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.appcompat.BuildConfig;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.squareup.otto.Bus;

import javax.inject.Inject;

import butterknife.ButterKnife;
import es.rogermartinez.paddlemanager.R;
import es.rogermartinez.paddlemanager.base.application.BaseApplication;
import es.rogermartinez.paddlemanager.base.domain.events.ErrorEvent;
import es.rogermartinez.paddlemanager.base.view.errors.ViewErrorEvent;
import es.rogermartinez.paddlemanager.base.view.errors.ViewErrorHandler;

public abstract class BaseActivity extends AppCompatActivity implements ViewErrorEvent {

    @Inject
    Bus bus;

    protected ViewErrorHandler viewErrorHandler;

    protected Toolbar toolbar;
    protected View toolbarShadow;

    /**
     * @return the IconState that this Activity should show by default.
     * Usually it will be MaterialMenuDrawable.IconState.ARROW or MaterialMenuDrawable.IconState.BURGER
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.screen_fade_in, R.anim.screen_fade_out);
        inject(this);

        ButterKnife.setDebug(BuildConfig.DEBUG);
        ButterKnife.bind(this);
        viewErrorHandler = new ViewErrorHandler(bus, this);

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStart() {
        super.onStart();
        findToolbarComponentAndSetColors();
        initCustomActionBar();
    }

    boolean toolbarColorAndShadorHasBeenSet = false;

    private void findToolbarComponentAndSetColors() {
        if (!toolbarColorAndShadorHasBeenSet) {
            toolbarColorAndShadorHasBeenSet = true;
            toolbar = (Toolbar) findViewById(R.id.toolbar);
            //toolbarShadow = findViewById(R.id.toolbarShadow);
            if (toolbar != null) {
                if (!hasAlphableToolbar()) {
                    toolbar.setBackgroundColor(getResources().getColor(R.color.action_bar_background));
                    // getColor(R.color.action_bar_background));
                    //if (toolbarShadow != null) {
                    //    toolbarShadow.getBackground().setAlpha(ALPHA_MAX_VALUE);
                    //}
                } else {
                    toolbarShadow.getBackground().setAlpha(0);
                }
                setSupportActionBar(toolbar);
            }
        }
    }

    protected boolean hasAlphableToolbar() {
        return false;
    }

    protected void initCustomActionBar() {
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.setHomeButtonEnabled(false);
            actionBar.setDisplayShowHomeEnabled(false);
            actionBar.setDisplayShowTitleEnabled(false);
            actionBar.setDisplayHomeAsUpEnabled(false);
            actionBar.setDisplayShowCustomEnabled(true);
        }
    }

    @Override
    public void setTitle(CharSequence title) {
        TextView customTitle = (TextView) findViewById(R.id.customTitle);
        if (customTitle != null) {
            customTitle.setText(title);
        }
    }

    public void inject(Object object) {
        // Perform injection so that when this call returns all dependencies will be available
        // for use.
        ((BaseApplication) getApplication()).inject(object);
    }

    public void onError(ErrorEvent event) {
        boolean redirectToLogin = ErrorEvent.ACTION_REDIRECT_TO_LOGIN == event.getAction();
        boolean needsScopes = ErrorEvent.ACTIONS_REQUEST_NEW_SCOPES == event.getAction();
        //TODO Errores

    }
    protected abstract boolean showError(ErrorEvent event);
}
