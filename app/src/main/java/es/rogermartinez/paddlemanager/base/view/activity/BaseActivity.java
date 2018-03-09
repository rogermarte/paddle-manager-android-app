package es.rogermartinez.paddlemanager.base.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.squareup.otto.Bus;

import javax.inject.Inject;

import butterknife.ButterKnife;
import es.rogermartinez.paddlemanager.BuildConfig;
import es.rogermartinez.paddlemanager.R;
import es.rogermartinez.paddlemanager.base.application.AndroidApplication;
import es.rogermartinez.paddlemanager.base.domain.events.ErrorEvent;
import es.rogermartinez.paddlemanager.base.view.errors.ViewErrorEvent;
import es.rogermartinez.paddlemanager.base.view.errors.ViewErrorHandler;
import es.rogermartinez.paddlemanager.injector.ActivityModule;
import es.rogermartinez.paddlemanager.injector.ApplicationComponent;

public abstract class BaseActivity extends AppCompatActivity implements ViewErrorEvent {

    @Inject
    Bus bus;

    protected ViewErrorHandler viewErrorHandler;

    protected Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getApplicationComponent().inject(this);
        overridePendingTransition(R.anim.screen_fade_in, R.anim.screen_fade_out);
        ButterKnife.setDebug(BuildConfig.DEBUG);
        ButterKnife.bind(this);
        viewErrorHandler = new ViewErrorHandler(bus, this);
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
    }


    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStart() {
        super.onStart();
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    public void onError(ErrorEvent event) {
        boolean redirectToLogin = ErrorEvent.ACTION_REDIRECT_TO_LOGIN == event.getAction();
        boolean needsScopes = ErrorEvent.ACTIONS_REQUEST_NEW_SCOPES == event.getAction();
        //TODO Errores

    }
    protected abstract boolean showError(ErrorEvent event);

    protected ApplicationComponent getApplicationComponent() {
        return ((AndroidApplication)getApplication()).getApplicationComponent();
    }

    protected ActivityModule getActivityModule() {
        return new ActivityModule(this);
    }
}
