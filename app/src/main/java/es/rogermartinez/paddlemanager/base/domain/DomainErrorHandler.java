package es.rogermartinez.paddlemanager.base.domain;

import com.squareup.otto.Bus;

import es.rogermartinez.paddlemanager.base.domain.events.ErrorEvent;

/**
 * Created by roger.martinez on 13/11/15.
 */
public class DomainErrorHandler {

    private Bus bus;

    public DomainErrorHandler(Bus bus) {
        this.bus = bus;
    }

    public void notifyError(ErrorEvent errorObject) throws Throwable {
        bus.post(errorObject);
    }




}
