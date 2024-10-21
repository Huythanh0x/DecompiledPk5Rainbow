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
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;

/* loaded from: classes.dex */
public class ApiTask extends AsyncTask<Void, Void, Object> {
    private static final String TAG = "pay";
    private String httpmethod;
    private AndroidHttpClient mClient = HttpClientFactory.get().getSDKHttpClient(null);
    private Context mContext;
    private TaskHandler mHandler;
    private HashMap<String, Object> mParameter;
    private int mReuqestAction;

    /* loaded from: classes.dex */
    public interface TaskHandler {
        void onError(int i, int i2);

        Object onPreHandle(int i, HttpResponse httpResponse);

        void onSuccess(int i, Object obj);
    }

    public ApiTask(Context paramContext, int paramInt, TaskHandler paramTaskHandler, HashMap<String, Object> paramHashMap, String httpMethod) {
        this.mContext = paramContext;
        this.mReuqestAction = paramInt;
        this.mHandler = paramTaskHandler;
        this.mParameter = paramHashMap;
        this.httpmethod = httpMethod;
    }

    @Override // android.os.AsyncTask
    public Object doInBackground(Void[] paramArrayOfVoid) {
        HttpResponse localHttpResponse;
        try {
            String requestUrl = Constants.API_URLS[this.mReuqestAction];
            HttpPost localHttpPost = null;
            HttpGet localHttpGet = null;
            if (this.httpmethod.equals(Constants.POST)) {
                localHttpPost = new HttpPost(requestUrl);
                try {
                    localHttpPost.setEntity(new ByteArrayEntity(Utils.getQueryString(this.mParameter).getBytes("UTF-8")));
                } catch (ArrayIndexOutOfBoundsException e) {
                }
                localHttpPost.addHeader("Content-Type", "application/x-www-form-urlencoded");
                localHttpResponse = this.mClient.execute(localHttpPost);
            } else {
                String querystr = Utils.getQueryString(this.mParameter);
                localHttpGet = new HttpGet(requestUrl.indexOf("?") > 0 ? String.valueOf(requestUrl) + "&" + querystr : String.valueOf(requestUrl) + "?" + querystr);
                localHttpResponse = this.mClient.execute(localHttpGet);
            }
            if (localHttpResponse == null) {
                return null;
            }
            int j = localHttpResponse.getStatusLine().getStatusCode();
            if (200 != j) {
                return Integer.valueOf(j);
            }
            try {
                if (this.mHandler == null) {
                    HttpResponse localObject2 = localHttpResponse;
                    if (localHttpPost != null) {
                        localHttpPost.abort();
                    } else if (localHttpGet != null) {
                        localHttpGet.abort();
                    }
                    if (localHttpResponse != null) {
                        localHttpResponse.getEntity().consumeContent();
                    }
                    return localObject2;
                }
                if ((this.mContext instanceof Activity) && ((Activity) this.mContext).isFinishing()) {
                    HttpResponse localObject22 = localHttpResponse;
                    return localObject22;
                }
                Object localObject23 = this.mHandler.onPreHandle(this.mReuqestAction, localHttpResponse);
                if (localHttpPost != null) {
                    localHttpPost.abort();
                } else if (localHttpGet != null) {
                    localHttpGet.abort();
                }
                if (localHttpResponse != null) {
                    localHttpResponse.getEntity().consumeContent();
                }
                return localObject23;
            } finally {
                if (localHttpPost != null) {
                    localHttpPost.abort();
                } else if (localHttpGet != null) {
                    localHttpGet.abort();
                }
                if (localHttpResponse != null) {
                    localHttpResponse.getEntity().consumeContent();
                }
            }
        } catch (ConnectException e2) {
            return -1;
        } catch (SocketException e3) {
            return -1;
        } catch (SocketTimeoutException e4) {
            return -1;
        } catch (Exception localException) {
            localException.printStackTrace();
            return -3;
        }
    }

    @Override // android.os.AsyncTask
    protected void onPostExecute(Object paramObject) {
        if (this.mHandler != null) {
            if (!(this.mContext instanceof Activity) || !((Activity) this.mContext).isFinishing()) {
                if (paramObject == null) {
                    this.mHandler.onError(this.mReuqestAction, Constants.ERROR_CODE_UNKNOWN);
                } else if (paramObject instanceof Integer) {
                    this.mHandler.onError(this.mReuqestAction, ((Integer) paramObject).intValue());
                } else {
                    this.mHandler.onSuccess(this.mReuqestAction, paramObject);
                }
            }
        }
    }
}
