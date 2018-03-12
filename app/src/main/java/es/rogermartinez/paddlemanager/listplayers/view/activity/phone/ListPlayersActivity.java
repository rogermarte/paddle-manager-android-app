package es.rogermartinez.paddlemanager.listplayers.view.activity.phone;

import android.content.Intent;
import android.os.Bundle;

import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import es.rogermartinez.paddlemanager.R;
import es.rogermartinez.paddlemanager.base.daggerutils.HasComponent;
import es.rogermartinez.paddlemanager.base.view.activity.DrawerActivity;
import es.rogermartinez.paddlemanager.injector.DaggerListPlayersComponent;
import es.rogermartinez.paddlemanager.injector.ListPlayersComponent;
import es.rogermartinez.paddlemanager.listplayers.view.fragment.ListPlayersActivityFragment;
import es.rogermartinez.paddlemanager.base.domain.events.ErrorEvent;

import android.support.annotation.NonNull;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Collections;

public class ListPlayersActivity extends DrawerActivity implements HasComponent<ListPlayersComponent> {


    public static final int RC_SIGN_IN = 123;

    public static final int CREATE_PLAYER_RESULT_ID = 200;
    private ListPlayersActivityFragment playersFragment;

    private ListPlayersComponent listPlayersComponent;

    private FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;
    private String mUsername;

    private void initializeInjector() {
        this.listPlayersComponent = DaggerListPlayersComponent.builder()
                .applicationComponent(getApplicationComponent())

                .activityModule(getActivityModule())
                .build();
    }

    @Override
    public ListPlayersComponent getComponent() {
        return listPlayersComponent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_players);

        initializeInjector();

        mFirebaseAuth = FirebaseAuth.getInstance();

        setTitle(getString(R.string.players));

        if (savedInstanceState == null) {
            playersFragment = new ListPlayersActivityFragment();
            getFragmentManager().beginTransaction().add(R.id.container, playersFragment).commit();
        }

        mAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    onSignedInItitialize(user.getDisplayName());
                } else {
                    onSignedOutCleanup();
                    startActivityForResult(
                            AuthUI.getInstance()
                                    .createSignInIntentBuilder()
                                    .setIsSmartLockEnabled(false)
                                    .setAvailableProviders(
                                            Collections.singletonList(new AuthUI.IdpConfig.GoogleBuilder().build()))
                                    .build(),
                            RC_SIGN_IN);
                }
            }
        };
    }

    private void onSignedInItitialize(String username) {
        mUsername = username;
    }

    private void onSignedOutCleanup() {
        mUsername = "annon";
    }

    @Override
    protected boolean showError(ErrorEvent event) {
        if (playersFragment != null) {
            return playersFragment.showError(event);
        }
        return false;
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mAuthStateListener != null) {
            mFirebaseAuth.removeAuthStateListener(mAuthStateListener);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        mFirebaseAuth.addAuthStateListener(mAuthStateListener);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_SIGN_IN) {
            if (resultCode == RESULT_OK) {
                Toast.makeText(this, "Signed in!", Toast.LENGTH_SHORT).show();
            } else if (resultCode == RESULT_CANCELED) {
                Toast.makeText(this, "Signed canceled!", Toast.LENGTH_SHORT).show();
                finish();
            }
        }
    }
}
