package es.rogermartinez.paddlemanager.base.domain.events;

/**
 * Created by roger.martinez on 13/11/15.
 */
public class GeneralErrorEvent extends ErrorEvent {


    public GeneralErrorEvent(String error) {
        super(error);
    }
    public GeneralErrorEvent(Exception exception) {
        super(exception);
    }
}
