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

public class ApiTask extends AsyncTask<Void, Void, Object> {
  private static final String TAG = "pay";
  
  private String httpmethod;
  
  private AndroidHttpClient mClient;
  
  private Context mContext;
  
  private TaskHandler mHandler;
  
  private HashMap<String, Object> mParameter;
  
  private int mReuqestAction;
  
  ApiTask(Context paramContext, int paramInt, TaskHandler paramTaskHandler, HashMap<String, Object> paramHashMap, String paramString) {
    this.mContext = paramContext;
    this.mReuqestAction = paramInt;
    this.mHandler = paramTaskHandler;
    this.mParameter = paramHashMap;
    this.mClient = HttpClientFactory.get().getSDKHttpClient(null);
    this.httpmethod = paramString;
  }
  
  protected Object doInBackground(Void[] paramArrayOfVoid) {
    Integer integer;
    try {
      HttpResponse httpResponse;
      String str = Constants.API_URLS[this.mReuqestAction];
      HttpPost httpPost = null;
      HttpGet httpGet = null;
      if (this.httpmethod.equals("post")) {
        httpPost = new HttpPost();
        this(str);
        String str1 = Utils.getQueryString(this.mParameter);
        try {
          ByteArrayEntity byteArrayEntity = new ByteArrayEntity();
          this(str1.getBytes("UTF-8"));
          httpPost.setEntity((HttpEntity)byteArrayEntity);
        } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {}
        httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded");
        httpResponse = this.mClient.execute((HttpUriRequest)httpPost);
      } else {
        String str1;
        String str2 = Utils.getQueryString(this.mParameter);
        httpGet = new HttpGet();
        if (httpResponse.indexOf("?") > 0) {
          StringBuilder stringBuilder = new StringBuilder();
          this(String.valueOf(httpResponse));
          str1 = stringBuilder.append("&").append(str2).toString();
        } else {
          StringBuilder stringBuilder = new StringBuilder();
          this(String.valueOf(str1));
          str1 = stringBuilder.append("?").append(str2).toString();
        } 
        this(str1);
        httpResponse = this.mClient.execute((HttpUriRequest)httpGet);
      } 
      if (httpResponse == null)
        return null; 
      int i = httpResponse.getStatusLine().getStatusCode();
      if (200 != i)
        return Integer.valueOf(i); 
      try {
        if (this.mHandler != null) {
          if (this.mContext instanceof Activity) {
            boolean bool = ((Activity)this.mContext).isFinishing();
            if (bool) {
              if (httpPost != null) {
                httpPost.abort();
              } else if (httpGet != null) {
                httpGet.abort();
              } 
              if (httpResponse != null)
                httpResponse.getEntity().consumeContent(); 
              return httpResponse;
            } 
          } 
          Object object = this.mHandler.onPreHandle(this.mReuqestAction, httpResponse);
          if (httpPost != null) {
            httpPost.abort();
          } else if (httpGet != null) {
            httpGet.abort();
          } 
          if (httpResponse != null)
            httpResponse.getEntity().consumeContent(); 
          return object;
        } 
        if (httpPost != null) {
          httpPost.abort();
        } else if (httpGet != null) {
          httpGet.abort();
        } 
        if (httpResponse != null)
          httpResponse.getEntity().consumeContent(); 
      } finally {
        Exception exception;
      } 
    } catch (ConnectException connectException) {
      integer = Integer.valueOf(-1);
    } catch (SocketTimeoutException socketTimeoutException) {
      integer = Integer.valueOf(-1);
    } catch (SocketException socketException) {
      integer = Integer.valueOf(-1);
    } catch (Exception exception) {
      exception.printStackTrace();
      integer = Integer.valueOf(-3);
    } 
    return integer;
  }
  
  protected void onPostExecute(Object paramObject) {
    if (this.mHandler != null && (!(this.mContext instanceof Activity) || !((Activity)this.mContext).isFinishing())) {
      if (paramObject == null) {
        this.mHandler.onError(this.mReuqestAction, 500);
        return;
      } 
      if (paramObject instanceof Integer) {
        this.mHandler.onError(this.mReuqestAction, ((Integer)paramObject).intValue());
        return;
      } 
      this.mHandler.onSuccess(this.mReuqestAction, paramObject);
    } 
  }
  
  public static interface TaskHandler {
    void onError(int param1Int1, int param1Int2);
    
    Object onPreHandle(int param1Int, HttpResponse param1HttpResponse);
    
    void onSuccess(int param1Int, Object param1Object);
  }
}


/* Location:              /Users/thanh0x/DevTools0x/Rb2.0vip-dex2jar.jar!/com/uc/paymentsdk/network/ApiTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */