package com.uc.paymentsdk.payment.sms.SmsInfos;
import java.lang.Object;
import java.util.ArrayList;
import java.lang.Integer;
import com.uc.paymentsdk.payment.sms.SmsInfo;
import android.content.Context;
import java.util.Iterator;
import com.uc.paymentsdk.payment.sms.SimCardNotSupportException;
import java.lang.String;

public class SmsInfos	// class@0000b8 from classes.dex
{
    public ArrayList smsInfos;

    public void SmsInfos(){
       super();
       this.smsInfos = new ArrayList();
    }
    private static ArrayList parsePayment(int paymoney){
       int ix;
       ArrayList smsSuitPrice = new ArrayList();
       int i = paymoney;
       do {
          if (!(ix = paymoney % i)) {
             smsSuitPrice.add(Integer.valueOf(i));
          }
       } while ((i--) <= 0);
       return smsSuitPrice;
    }
    public void add(SmsInfo paramSmsInfo){
       this.smsInfos.add(paramSmsInfo);
    }
    public SmsInfo filterSmsInfo(Context paramContext,int paymoney){
       SmsInfos smsInfos;
       SmsInfo smsInfo;
       ArrayList smsSuitPriceArr = null;
       int maxMoney = 0;
       int selectIndex = -1;
       if (this.smsInfos.size() == 1) {
          smsInfos = this.smsInfos.get(0);
          smsInfo = this;
       }else {
          int i = 0;
          while (i < this.smsInfos.size()) {
             SmsInfo smsInfo1 = this.smsInfos.get(i);
             if (smsSuitPriceArr == null) {
                smsSuitPriceArr = SmsInfos.parsePayment(paymoney);
             }
             Iterator smsSuitriceIte = smsSuitPriceArr.iterator();
             while (smsSuitriceIte.hasNext()) {
                if (smsInfo1.money == smsSuitriceIte.next().intValue() && smsInfo1.money > maxMoney) {
                   maxMoney = smsInfo1.money;
                   selectIndex = i;
                }
             }
             i++;
          }
          if (selectIndex != -1) {
             smsInfos = this.smsInfos.get(selectIndex);
             smsInfo = this;
          }else {
             throw new SimCardNotSupportException("\x5b\x02\x4e\x02\x8d\x02\xff\x02\x60\x02\x62\x02\x4f\x02\x75\x02\x76\x02\x62\x02\x67\x02\x8f\x02\x84\x02\x55\x02\x4e\x02\x65\x02\x63\x02\x6b\x02\x77\x02\x4f\x02\x6f\x02\x6d\x02\x52\x02\x80\x02\x30\x02");
          }
       }
       return smsInfo;
    }
}
