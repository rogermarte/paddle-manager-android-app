package es.rogermartinez.paddlemanager.base.domain.interactor;

/**
 * Created by roger.martinez on 3/11/15.
 */
public interface MainThread {
    void post(Runnable runnable);
}
