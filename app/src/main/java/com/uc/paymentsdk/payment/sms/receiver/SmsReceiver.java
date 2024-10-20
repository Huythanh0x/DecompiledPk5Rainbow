/*
 * Decompiled with CFR.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.telephony.gsm.SmsMessage
 *  android.util.Log
 */
package com.uc.paymentsdk.payment.sms.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.gsm.SmsMessage;
import android.util.Log;

public class SmsReceiver
extends BroadcastReceiver {
    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public void onReceive(Context var1_1, Intent var2_2) {
        var1_1 /* !! */  = var2_2.getExtras();
        if (var1_1 /* !! */  == null) {
            return;
        }
        var2_2 = (Object[])var1_1 /* !! */ .get("pdus");
        var3_3 = 0;
        while (true) {
            if (var3_3 >= var2_2.length) ** continue;
            var1_1 /* !! */  = SmsMessage.createFromPdu((byte[])((byte[])var2_2[var3_3])).getOriginatingAddress();
            Log.i((String)"pay", (String)("receiver number:" + (String)var1_1 /* !! */ ));
            this.abortBroadcast();
            ++var3_3;
        }
    }
}
