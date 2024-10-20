package com.uc.paymentsdk.network;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import java.util.HashMap;

public class ApiTask extends AsyncTask {
   private static final String TAG = "pay";
   private String httpmethod;
   private AndroidHttpClient mClient;
   private Context mContext;
   private ApiTask$TaskHandler mHandler;
   private HashMap mParameter;
   private int mReuqestAction;

   ApiTask(Context var1, int var2, ApiTask$TaskHandler var3, HashMap var4, String var5) {
      super();
      this.mContext = var1;
      this.mReuqestAction = var2;
      this.mHandler = var3;
      this.mParameter = var4;
      this.mClient = HttpClientFactory.get().getSDKHttpClient((String)null);
      this.httpmethod = var5;
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected Object doInBackground(Object[] var1) {
      return this.doInBackground((Void[])var1);
   }

   protected Object doInBackground(Void[] param1) {
      // $FF: Couldn't be decompiled
   }

   protected void onPostExecute(Object var1) {
      if (this.mHandler != null && (!(this.mContext instanceof Activity) || !((Activity)this.mContext).isFinishing())) {
         if (var1 == null) {
            this.mHandler.onError(this.mReuqestAction, 500);
         } else if (var1 instanceof Integer) {
            this.mHandler.onError(this.mReuqestAction, (Integer)var1);
         } else {
            this.mHandler.onSuccess(this.mReuqestAction, var1);
         }
      }

   }
}
