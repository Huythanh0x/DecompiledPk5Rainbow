package com.uc.paymentsdk.payment.sms.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.gsm.SmsMessage;
import android.util.Log;

/* loaded from: classes.dex */
public class SmsReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context paramContext, Intent paramIntent) {
        Bundle localBundle = paramIntent.getExtras();
        if (localBundle != null) {
            Object[] arrayOfObject = (Object[]) localBundle.get("pdus");
            for (Object obj : arrayOfObject) {
                SmsMessage localSmsMessage = SmsMessage.createFromPdu((byte[]) obj);
                String str = localSmsMessage.getOriginatingAddress();
                Log.i("pay", "receiver number:" + str);
                abortBroadcast();
            }
        }
    }
}
