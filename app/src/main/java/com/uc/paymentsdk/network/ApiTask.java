package com.uc.paymentsdk.network.ApiTask;
import android.os.AsyncTask;
import android.content.Context;
import com.uc.paymentsdk.network.ApiTask$TaskHandler;
import java.util.HashMap;
import java.lang.String;
import com.uc.paymentsdk.network.HttpClientFactory;
import com.uc.paymentsdk.network.AndroidHttpClient;
import java.lang.Object;
import java.lang.Void;
import com.uc.paymentsdk.util.Constants;
import org.apache.http.client.methods.HttpPost;
import com.uc.paymentsdk.util.Utils;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import java.lang.StringBuilder;
import org.apache.http.StatusLine;
import java.lang.Integer;
import android.app.Activity;
import java.lang.Exception;

public class ApiTask extends AsyncTask	// class@0000a0 from classes.dex
{
    private String httpmethod;
    private AndroidHttpClient mClient;
    private Context mContext;
    private ApiTask$TaskHandler mHandler;
    private HashMap mParameter;
    private int mReuqestAction;
    private static final String TAG = "pay";

    void ApiTask(Context paramContext,int paramInt,ApiTask$TaskHandler paramTaskHandler,HashMap paramHashMap,String httpMethod){
       super();
       this.mContext = paramContext;
       this.mReuqestAction = paramInt;
       this.mHandler = paramTaskHandler;
       this.mParameter = paramHashMap;
       this.mClient = HttpClientFactory.get().getSDKHttpClient(null);
       this.httpmethod = httpMethod;
    }
    protected Object doInBackground(Object[] p0){
       return this.doInBackground(p0);
    }
    protected Object doInBackground(Void[] paramArrayOfVoid){
       Integer integer;
       String querystr;
       HttpResponse localObject2;
       int i = -1;
       try{
          String requestUrl = Constants.API_URLS[this.mReuqestAction];
          HttpPost localHttpPost = null;
          HttpGet localHttpGet = null;
          if (this.httpmethod.equals("post")) {
             localHttpPost = new HttpPost(requestUrl);
             querystr = Utils.getQueryString(this.mParameter);
             localHttpPost.setEntity(new ByteArrayEntity(querystr.getBytes("UTF-8")));
          }else {
             querystr = Utils.getQueryString(this.mParameter);
             String str = (requestUrl.indexOf("?") > 0)? String.valueOf(requestUrl).append("&").append(querystr).toString(): String.valueOf(requestUrl).append("?").append(querystr).toString();
             localHttpGet = new HttpGet(str);
             HttpResponse localHttpResponse = this.mClient.execute(localHttpGet);
             try{
                if (localHttpResponse == null) {
                   integer = null;
                }else {
                   int j = localHttpResponse.getStatusLine().getStatusCode();
                   if (200 != j) {
                      integer = Integer.valueOf(j);
                   }else if(this.mHandler != null){
                      if (this.mContext instanceof Activity && this.mContext.isFinishing()) {
                         localObject2 = localHttpResponse;
                         if (localHttpPost != null) {
                            localHttpPost.abort();
                         }else if(localHttpGet != null){
                            localHttpGet.abort();
                         }
                         if (localHttpResponse != null) {
                            localHttpResponse.getEntity().consumeContent();
                         }
                         integer = localObject2;
                      }else {
                         Object localObject21 = this.mHandler.onPreHandle(this.mReuqestAction, localHttpResponse);
                         if (localHttpPost != null) {
                            localHttpPost.abort();
                         }else if(localHttpGet != null){
                            localHttpGet.abort();
                         }
                         if (localHttpResponse != null) {
                            localHttpResponse.getEntity().consumeContent();
                         }
                         integer = localObject2;
                      }
                   }else {
                      localObject2 = localHttpResponse;
                      if (localHttpPost != null) {
                         localHttpPost.abort();
                      }else if(localHttpGet != null){
                         localHttpGet.abort();
                      }
                      if (localHttpResponse != null) {
                         localHttpResponse.getEntity().consumeContent();
                      }
                      integer = localObject2;
                   }
                }
             }catch( e0){
             }catch(java.net.SocketTimeoutException e11){
                SocketTimeoutException localSocketTimeoutException = e11;
                integer = Integer.valueOf(i);
             }catch(java.net.SocketException e11){
                SocketException localSocketException = e11;
                integer = Integer.valueOf(i);
             }
          }
          return integer;
       }catch(java.net.ConnectException e11){
          ConnectException localConnectException = e11;
          integer = Integer.valueOf(i);
       }catch(java.net.SocketTimeoutException e11){
       }catch(java.net.SocketException e11){
       }catch(java.lang.Exception e11){
          Exception localException = e11;
          localException.printStackTrace();
          integer = Integer.valueOf(-3);
       }catch(java.lang.ArrayIndexOutOfBoundsException e11){
       }
    }
    protected void onPostExecute(Object paramObject){
       if (this.mHandler != null && (!this.mContext instanceof Activity || !this.mContext.isFinishing())) {
          if (paramObject == null) {
             this.mHandler.onError(this.mReuqestAction, 500);
          }else if(paramObject instanceof Integer){
             this.mHandler.onError(this.mReuqestAction, paramObject.intValue());
          }else {
             this.mHandler.onSuccess(this.mReuqestAction, paramObject);
          }
       }
       return;
    }
}
