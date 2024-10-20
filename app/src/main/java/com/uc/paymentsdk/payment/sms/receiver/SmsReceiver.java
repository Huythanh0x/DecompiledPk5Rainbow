package com.uc.paymentsdk.payment.sms.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.gsm.SmsMessage;
import android.util.Log;

public class SmsReceiver extends BroadcastReceiver {
    @Override  // android.content.BroadcastReceiver
    public void onReceive(Context paramContext, Intent paramIntent) {
        Bundle bundle0 = paramIntent.getExtras();
        if(bundle0 != null) {
            Object[] arrayOfObject = (Object[])bundle0.get("pdus");
            for(int i = 0; i < arrayOfObject.length; ++i) {
                Log.i("pay", "receiver number:" + SmsMessage.createFromPdu(((byte[])arrayOfObject[i])).getOriginatingAddress());
                this.abortBroadcast();
            }
        }
    }
}

