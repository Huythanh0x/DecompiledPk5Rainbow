package com.uc.paymentsdk.network;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import com.uc.paymentsdk.util.Constants;
import com.uc.paymentsdk.util.Utils;
import java.net.ConnectException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.HashMap;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ByteArrayEntity;

public class ApiTask extends AsyncTask {
    public interface TaskHandler {
        void onError(int arg1, int arg2);

        Object onPreHandle(int arg1, HttpResponse arg2);

        void onSuccess(int arg1, Object arg2);
    }

    private static final String TAG = "pay";
    private String httpmethod;
    private AndroidHttpClient mClient;
    private Context mContext;
    private TaskHandler mHandler;
    private HashMap mParameter;
    private int mReuqestAction;

    ApiTask(Context paramContext, int paramInt, TaskHandler paramTaskHandler, HashMap hashMap0, String httpMethod) {
        this.mContext = paramContext;
        this.mReuqestAction = paramInt;
        this.mHandler = paramTaskHandler;
        this.mParameter = hashMap0;
        this.mClient = HttpClientFactory.get().getSDKHttpClient(null);
        this.httpmethod = httpMethod;
    }

    @Override  // android.os.AsyncTask
    protected Object doInBackground(Object[] arr_object) {
        return this.doInBackground(((Void[])arr_object));
    }

    protected Object doInBackground(Void[] paramArrayOfVoid) {
        Object object0;
        HttpResponse httpResponse0;
        try {
            String requestUrl = Constants.API_URLS[this.mReuqestAction];
            HttpPost localHttpPost = null;
            HttpGet localHttpGet = null;
            if(this.httpmethod.equals("post")) {
                localHttpPost = new HttpPost(requestUrl);
                String s2 = Utils.getQueryString(this.mParameter);
                try {
                    localHttpPost.setEntity(((HttpEntity)new ByteArrayEntity(s2.getBytes("UTF-8"))));
                }
                catch(ArrayIndexOutOfBoundsException unused_ex) {
                }
                localHttpPost.addHeader("Content-Type", "application/x-www-form-urlencoded");
                httpResponse0 = this.mClient.execute(((HttpUriRequest)localHttpPost));
            }
            else {
                String s1 = Utils.getQueryString(this.mParameter);
                localHttpGet = new HttpGet((requestUrl.indexOf("?") <= 0 ? requestUrl + "?" + s1 : requestUrl + "&" + s1));
                httpResponse0 = this.mClient.execute(((HttpUriRequest)localHttpGet));
            }
            if(httpResponse0 == null) {
                return null;
            }
            int v = httpResponse0.getStatusLine().getStatusCode();
            if(200 != v) {
                return v;
            }
            try {
                if(this.mHandler != null) {
                    if(!(this.mContext instanceof Activity) || !((Activity)this.mContext).isFinishing()) {
                        object0 = this.mHandler.onPreHandle(this.mReuqestAction, httpResponse0);
                        goto label_30;
                    }
                    goto label_37;
                }
                goto label_44;
            }
            catch(Throwable throwable0) {
                if(localHttpPost != null) {
                    localHttpPost.abort();
                }
                else if(localHttpGet != null) {
                    localHttpGet.abort();
                }
                httpResponse0.getEntity().consumeContent();
                throw throwable0;
            }
        label_30:
            if(localHttpPost != null) {
                localHttpPost.abort();
            }
            else if(localHttpGet != null) {
                localHttpGet.abort();
            }
            httpResponse0.getEntity().consumeContent();
            return object0;
        label_37:
            if(localHttpPost != null) {
                localHttpPost.abort();
            }
            else if(localHttpGet != null) {
                localHttpGet.abort();
            }
            httpResponse0.getEntity().consumeContent();
            return httpResponse0;
        label_44:
            if(localHttpPost != null) {
                localHttpPost.abort();
            }
            else if(localHttpGet != null) {
                localHttpGet.abort();
            }
            httpResponse0.getEntity().consumeContent();
            return httpResponse0;
        }
        catch(ConnectException unused_ex) {
            return (int)-1;
        }
        catch(SocketTimeoutException unused_ex) {
            return (int)-1;
        }
        catch(SocketException unused_ex) {
            return (int)-1;
        }
        catch(Exception exception0) {
            exception0.printStackTrace();
            return (int)-3;
        }
    }

    @Override  // android.os.AsyncTask
    protected void onPostExecute(Object paramObject) {
        if(this.mHandler != null && (!(this.mContext instanceof Activity) || !((Activity)this.mContext).isFinishing())) {
            if(paramObject == null) {
                this.mHandler.onError(this.mReuqestAction, 500);
                return;
            }
            if((paramObject instanceof Integer)) {
                this.mHandler.onError(this.mReuqestAction, ((Integer)paramObject).intValue());
                return;
            }
            this.mHandler.onSuccess(this.mReuqestAction, paramObject);
        }
    }
}

