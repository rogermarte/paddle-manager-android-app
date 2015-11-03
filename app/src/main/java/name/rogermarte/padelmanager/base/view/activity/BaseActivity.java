package name.rogermarte.padelmanager.base.view.activity;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.support.v7.appcompat.BuildConfig;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toolbar;

import com.balysv.materialmenu.MaterialMenuDrawable;
import com.balysv.materialmenu.MaterialMenuView;
import com.squareup.otto.Bus;

import javax.inject.Inject;

import butterknife.ButterKnife;
import name.rogermarte.padelmanager.R;
import name.rogermarte.padelmanager.base.application.BaseApplication;
import name.rogermarte.padelmanager.base.domain.events.ErrorEvent;
import name.rogermarte.padelmanager.base.view.errors.ViewErrorEvent;
import name.rogermarte.padelmanager.base.view.errors.ViewErrorHandler;

public abstract class BaseActivity extends Activity implements ViewErrorEvent {

    @Inject
    Bus bus;

    protected ViewErrorHandler viewErrorHandler;

    protected MaterialMenuView materialMenuView;
    protected Toolbar toolbar;

    //These two icons should be set at the onCreate() of the childs
    public static MaterialMenuDrawable.IconState oldIcon = null;
    //  public static MaterialMenuDrawable.IconState nextIcon = null;

    /**
     * @return the IconState that this Activity should show by default.
     * Usually it will be MaterialMenuDrawable.IconState.ARROW or MaterialMenuDrawable.IconState.BURGER
     */
    public abstract MaterialMenuDrawable.IconState getDefaultState();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.screen_fade_in, R.anim.screen_fade_out);
        inject(this);

        ButterKnife.setDebug(BuildConfig.DEBUG);
        ButterKnife.inject(this);
        viewErrorHandler = new ViewErrorHandler(bus, this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_base, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    protected void initCustomActionBar() {
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.setHomeButtonEnabled(false);
            actionBar.setDisplayShowHomeEnabled(false);
            actionBar.setDisplayShowTitleEnabled(false);
            actionBar.setDisplayHomeAsUpEnabled(false);
            actionBar.setDisplayShowCustomEnabled(true);
            materialMenuView = (MaterialMenuView) toolbar.findViewById(R.id.action_bar_menu);
            materialMenuView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (view.getId() == R.id.action_bar_menu) {
                        // random state on click
//                    materialButtonState = generateMaterialMenuState(materialButtonState);
//                    materialMenuView.animatePressedState(convertMaterialMenuIntToState(materialButtonState));
//                    return;

                        onBackPressed();
                    }
                }
            });
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
