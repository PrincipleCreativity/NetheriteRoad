package com.groupzts.netheriteroad.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class Log {
    private static final Logger LOGGER = LogManager.getLogger(Reference.MOD_ID);

    public static Logger get() {
        return LOGGER;
    }

    private Log() {
    }
}