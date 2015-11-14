package es.rogermartinez.paddlemanager.base.domain.events;

/**
 * Created by roger.martinez on 9/10/15.
 */
public class ErrorEvent {

    public static final int ACTION_NO_ACTION = 0;
    public static final int ACTION_REDIRECT_TO_LOGIN = 1;
    public static final int ACTIONS_REQUEST_NEW_SCOPES = 2;
    public static Exception exception;

    private String message;
    private int action = ACTION_NO_ACTION;

    public ErrorEvent() {}

    public ErrorEvent(Exception exception) {
        this.exception = exception;
        this.message = exception.getMessage();
    }

    public ErrorEvent(Exception exception, int action) {
        this.exception = exception;
        this.message = exception.getMessage();
        this.action = action;
    }

    public ErrorEvent(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getAction() { return action; }

    public void setAction(int action) { this.action = action; }

    public static Exception getException() {
        return exception;
    }

    public static void setException(Exception exception) {
        ErrorEvent.exception = exception;
    }
}

