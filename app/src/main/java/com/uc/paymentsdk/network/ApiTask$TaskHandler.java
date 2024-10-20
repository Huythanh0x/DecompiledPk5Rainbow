package com.uc.paymentsdk.network.ApiTask$TaskHandler;
import org.apache.http.HttpResponse;
import java.lang.Object;

public interface abstract ApiTask$TaskHandler	// class@00009f from classes.dex
{

    void onError(int p0,int p1);
    Object onPreHandle(int p0,HttpResponse p1);
    void onSuccess(int p0,Object p1);
}
