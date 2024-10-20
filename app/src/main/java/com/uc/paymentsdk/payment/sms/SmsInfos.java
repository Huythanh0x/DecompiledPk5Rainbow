package com.uc.paymentsdk.payment.sms;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;

public class SmsInfos {
  public ArrayList<SmsInfo> smsInfos = new ArrayList<SmsInfo>();
  
  private static ArrayList<Integer> parsePayment(int paramInt) {
    ArrayList<Integer> arrayList = new ArrayList();
    int i = paramInt;
    while (true) {
      if (paramInt % i == 0)
        arrayList.add(Integer.valueOf(i)); 
      int j = i - 1;
      i = j;
      if (j <= 0)
        return arrayList; 
    } 
  }
  
  public void add(SmsInfo paramSmsInfo) {
    this.smsInfos.add(paramSmsInfo);
  }
  
  public SmsInfo filterSmsInfo(Context paramContext, int paramInt) throws SimCardNotSupportException {
    Context context = null;
    int i = 0;
    byte b1 = -1;
    if (this.smsInfos.size() == 1)
      return this.smsInfos.get(0); 
    byte b = 0;
    label25: while (true) {
      if (b >= this.smsInfos.size()) {
        if (b1 != -1)
          return this.smsInfos.get(b1); 
      } else {
        ArrayList<Integer> arrayList;
        SmsInfo smsInfo = this.smsInfos.get(b);
        paramContext = context;
        if (context == null)
          arrayList = parsePayment(paramInt); 
        Iterator<Integer> iterator = arrayList.iterator();
        while (true) {
          ArrayList<Integer> arrayList1;
          if (!iterator.hasNext()) {
            b++;
            arrayList1 = arrayList;
            continue label25;
          } 
          Integer integer = arrayList1.next();
          if (smsInfo.money == integer.intValue() && smsInfo.money > i) {
            i = smsInfo.money;
            b1 = b;
          } 
        } 
        break;
      } 
      throw new SimCardNotSupportException("对不起，您所使用的手机运营商不支持此短信激活功能。");
    } 
  }
}


/* Location:              /Users/thanh0x/DevTools0x/Rb2.0vip-dex2jar.jar!/com/uc/paymentsdk/payment/sms/SmsInfos.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */