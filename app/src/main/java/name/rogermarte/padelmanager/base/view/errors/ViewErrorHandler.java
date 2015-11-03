package name.rogermarte.padelmanager.base.view.errors;

import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;

import name.rogermarte.padelmanager.base.domain.events.ErrorEvent;

/**
 * Created by roger.martinez on 9/10/15.
 */
public class ViewErrorHandler {

    private Bus bus;
    ViewErrorEvent errorEvent;


    public ViewErrorHandler(Bus bus, ViewErrorEvent errorEvent) {
        this.bus = bus;
        this.errorEvent = errorEvent;
    }

    public void register(){
        bus.register(this);
    }

    public void unregister(){
        bus.unregister(this);
    }

    @Subscribe
    public void onErrorEvent(ErrorEvent event) {
        errorEvent.onError(event);
    }


}

