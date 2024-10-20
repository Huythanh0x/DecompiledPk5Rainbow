package com.uc.paymentsdk.payment.upoint;

public class UPointInfo
{
    String discount;
    String discountinfo;
    String discounttext;
    String userphone;
    String vipdiscount;
    String vipdiscounttext;
    String vipdiscounttime;
    
    public UPointInfo() {
        super();
        this.discount = "";
        this.discounttext = "";
        this.userphone = "";
        this.vipdiscount = "";
        this.vipdiscounttext = "";
        this.vipdiscounttime = "";
        this.discountinfo = "";
    }
    
    public String getDiscount() {
        return this.discount;
    }
    
    public String getDiscountinfo() {
        return this.discountinfo;
    }
    
    public String getDiscounttext() {
        return this.discounttext;
    }
    
    public String getUserphone() {
        return this.userphone;
    }
    
    public String getVipdiscount() {
        return this.vipdiscount;
    }
    
    public String getVipdiscounttext() {
        return this.vipdiscounttext;
    }
    
    public String getVipdiscounttime() {
        return this.vipdiscounttime;
    }
    
    public void setDiscount(final String discount) {
        this.discount = discount;
    }
    
    public void setDiscountinfo(final String discountinfo) {
        this.discountinfo = discountinfo;
    }
    
    public void setDiscounttext(final String discounttext) {
        this.discounttext = discounttext;
    }
    
    public void setUserphone(final String userphone) {
        this.userphone = userphone;
    }
    
    public void setVipdiscount(final String vipdiscount) {
        this.vipdiscount = vipdiscount;
    }
    
    public void setVipdiscounttext(final String vipdiscounttext) {
        this.vipdiscounttext = vipdiscounttext;
    }
    
    public void setVipdiscounttime(final String vipdiscounttime) {
        this.vipdiscounttime = vipdiscounttime;
    }
}
