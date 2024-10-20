/*
 * Decompiled with CFR.
 * 
 * Could not load the following classes:
 *  android.util.Log
 */
package com.uc.paymentsdk.network;

import android.util.Log;

private static class AndroidHttpClient.LoggingConfiguration {
    private final int level;
    private final String tag;

    private AndroidHttpClient.LoggingConfiguration(String string, int n) {
        this.tag = string;
        this.level = n;
    }

    /* synthetic */ AndroidHttpClient.LoggingConfiguration(String string, int n, AndroidHttpClient.LoggingConfiguration loggingConfiguration) {
        this(string, n);
    }

    static /* synthetic */ boolean access$0(AndroidHttpClient.LoggingConfiguration loggingConfiguration) {
        return loggingConfiguration.isLoggable();
    }

    static /* synthetic */ void access$1(AndroidHttpClient.LoggingConfiguration loggingConfiguration, String string) {
        loggingConfiguration.println(string);
    }

    private boolean isLoggable() {
        return Log.isLoggable((String)this.tag, (int)this.level);
    }

    private void println(String string) {
        Log.println((int)this.level, (String)this.tag, (String)string);
    }
}
