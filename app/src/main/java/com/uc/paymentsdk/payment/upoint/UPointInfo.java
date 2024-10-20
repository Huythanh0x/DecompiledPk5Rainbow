package com.uc.paymentsdk.payment.upoint.UPointInfo;
import java.lang.Object;
import java.lang.String;

public class UPointInfo	// class@0000ba from classes.dex
{
    String discount;
    String discountinfo;
    String discounttext;
    String userphone;
    String vipdiscount;
    String vipdiscounttext;
    String vipdiscounttime;

    public void UPointInfo(){
       super();
       this.discount = "";
       this.discounttext = "";
       this.userphone = "";
       this.vipdiscount = "";
       this.vipdiscounttext = "";
       this.vipdiscounttime = "";
       this.discountinfo = "";
    }
    public String getDiscount(){
       return this.discount;
    }
    public String getDiscountinfo(){
       return this.discountinfo;
    }
    public String getDiscounttext(){
       return this.discounttext;
    }
    public String getUserphone(){
       return this.userphone;
    }
    public String getVipdiscount(){
       return this.vipdiscount;
    }
    public String getVipdiscounttext(){
       return this.vipdiscounttext;
    }
    public String getVipdiscounttime(){
       return this.vipdiscounttime;
    }
    public void setDiscount(String discount){
       this.discount = discount;
    }
    public void setDiscountinfo(String discountinfo){
       this.discountinfo = discountinfo;
    }
    public void setDiscounttext(String discounttext){
       this.discounttext = discounttext;
    }
    public void setUserphone(String userphone){
       this.userphone = userphone;
    }
    public void setVipdiscount(String vipdiscount){
       this.vipdiscount = vipdiscount;
    }
    public void setVipdiscounttext(String vipdiscounttext){
       this.vipdiscounttext = vipdiscounttext;
    }
    public void setVipdiscounttime(String vipdiscounttime){
       this.vipdiscounttime = vipdiscounttime;
    }
}
