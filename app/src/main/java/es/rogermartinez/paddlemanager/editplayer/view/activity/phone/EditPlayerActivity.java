package es.rogermartinez.paddlemanager.editplayer.view.activity.phone;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;

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

        setTitle(getString(R.string.add_player));

        if (savedInstanceState == null){
            fragment = new EditPlayerFragment();
            getFragmentManager().beginTransaction().add(R.id.container, fragment).commit();
        }

    }

    @Override
    protected void onStart(){
        super.onStart();
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(EditPlayerActivity.this);
                // Add the buttons
                builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User clicked OK button
                        onBackPressed();
                    }
                });
                builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                    }
                });
                // Set other dialog properties
                builder.setMessage("El jugador no será añadido")
                        .setTitle("¿Seguro?");
                // Create the AlertDialog
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
    }

    @Override
    protected boolean showError(ErrorEvent event) {
        return false;
    }
}
