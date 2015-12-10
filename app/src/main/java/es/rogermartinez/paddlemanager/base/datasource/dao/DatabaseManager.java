package es.rogermartinez.paddlemanager.base.datasource.dao;

import android.content.Context;

import com.j256.ormlite.android.apptools.OpenHelperManager;

public class DatabaseManager {
    private final Context context;
    private DatabaseHelper databaseHelper = null;

    public DatabaseManager(Context context) {
        this.context = context;
    }

    //gets a helper once one is created ensures it doesnt create a new one
    public DatabaseHelper getHelper()
    {
        if (databaseHelper == null) {
            databaseHelper =
                    OpenHelperManager.getHelper(context, DatabaseHelper.class);
        }
        return databaseHelper;
    }

    //releases the helper once usages has ended
    public void releaseHelper(DatabaseHelper helper)
    {
        if (databaseHelper != null) {
            OpenHelperManager.releaseHelper();
            databaseHelper = null;
        }
    }
}
