package name.rogermarte.padelmanager.base.view.errors;

import name.rogermarte.padelmanager.base.domain.events.ErrorEvent;

/**
 * Created by roger.martinez on 9/10/15.
 */
public interface ViewErrorEvent
{
    void onError(ErrorEvent event);
}
