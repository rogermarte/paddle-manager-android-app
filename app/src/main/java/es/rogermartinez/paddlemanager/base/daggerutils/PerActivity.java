package es.rogermartinez.paddlemanager.base.daggerutils;

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by roger on 17/5/16.
 */
@Scope
@Retention(RUNTIME)
public @interface PerActivity {
}
