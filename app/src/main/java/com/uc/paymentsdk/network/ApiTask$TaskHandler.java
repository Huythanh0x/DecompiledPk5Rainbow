/*
 * Decompiled with CFR.
 * 
 * Could not load the following classes:
 *  org.apache.http.HttpResponse
 */
package com.uc.paymentsdk.network;

import org.apache.http.HttpResponse;

public static interface ApiTask.TaskHandler {
    public void onError(int var1, int var2);

    public Object onPreHandle(int var1, HttpResponse var2);

    public void onSuccess(int var1, Object var2);
}
