package com.uc.paymentsdk.network;

import android.util.Log;

private static class LoggingConfiguration
{
    private final int level;
    private final String tag;
    
    private LoggingConfiguration(final String tag, final int level) {
        super();
        this.tag = tag;
        this.level = level;
    }
    
    LoggingConfiguration(final String s, final int n, final LoggingConfiguration loggingConfiguration) {
        this(s, n);
    }
    
    static /* synthetic */ boolean access$0(final LoggingConfiguration loggingConfiguration) {
        return loggingConfiguration.isLoggable();
    }
    
    static /* synthetic */ void access$1(final LoggingConfiguration loggingConfiguration, final String s) {
        loggingConfiguration.println(s);
    }
    
    private boolean isLoggable() {
        return Log.isLoggable(this.tag, this.level);
    }
    
    private void println(final String s) {
        Log.println(this.level, this.tag, s);
    }
}
