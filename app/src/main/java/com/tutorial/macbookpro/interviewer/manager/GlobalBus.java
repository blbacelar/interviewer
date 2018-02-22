package com.tutorial.macbookpro.interviewer.manager;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by macbookpro on 2017-10-16.
 */

public class GlobalBus {
    private static EventBus sBus;

    public static EventBus getBus() {

        if (sBus == null) {
            sBus = EventBus.getDefault();
        }

        return sBus;
    }
}
