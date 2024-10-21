package com.uc.paymentsdk.payment.sms.receiver;

import android.os.Bundle;
import android.util.Log;
import android.telephony.gsm.SmsMessage;
import android.content.Intent;
import android.content.Context;
import android.content.BroadcastReceiver;

public class SmsReceiver extends BroadcastReceiver
{
    public SmsReceiver() {
        super();
    }
    
    public void onReceive(final Context context, final Intent intent) {
        final Bundle extras = intent.getExtras();
        if (extras != null) {
            final Object[] array = (Object[])extras.get("pdus");
            for (int i = 0; i < array.length; ++i) {
                Log.i("pay", "receiver number:" + SmsMessage.createFromPdu((byte[])array[i]).getOriginatingAddress());
                this.abortBroadcast();
            }
        }
    }
}
