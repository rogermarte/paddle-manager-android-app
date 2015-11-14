package es.rogermartinez.paddlemanager.base.view.errors;

import es.rogermartinez.paddlemanager.base.domain.events.ErrorEvent;

/**
 * Created by roger.martinez on 9/10/15.
 */
public interface ViewErrorEvent
{
    void onError(ErrorEvent event);
}
