package com.uc.paymentsdk.payment.sms;

import java.util.Iterator;
import android.content.Context;
import java.util.ArrayList;

public class SmsInfos
{
    public ArrayList<SmsInfo> smsInfos;
    
    public SmsInfos() {
        super();
        this.smsInfos = new ArrayList<SmsInfo>();
    }
    
    private static ArrayList<Integer> parsePayment(final int n) {
        final ArrayList list = new ArrayList();
        int i = n;
        do {
            if (n % i == 0) {
                list.add(Integer.valueOf(i));
            }
        } while (--i > 0);
        return list;
    }
    
    public void add(final SmsInfo e) {
        this.smsInfos.add(e);
    }
    
    public SmsInfo filterSmsInfo(final Context context, final int n) throws SimCardNotSupportException {
        ArrayList<Integer> list = null;
        int money = 0;
        int index = -1;
        SmsInfo smsInfo;
        if (this.smsInfos.size() == 1) {
            smsInfo = this.smsInfos.get(0);
        }
        else {
            ArrayList<Integer> payment;
            for (int i = 0; i < this.smsInfos.size(); ++i, list = payment) {
                final SmsInfo smsInfo2 = (SmsInfo)this.smsInfos.get(i);
                if ((payment = list) == null) {
                    payment = parsePayment(n);
                }
                final Iterator<Integer> iterator = payment.iterator();
                while (iterator.hasNext()) {
                    if (smsInfo2.money == Integer.valueOf(iterator.next()) && smsInfo2.money > money) {
                        money = smsInfo2.money;
                        index = i;
                    }
                }
            }
            if (index == -1) {
                throw new SimCardNotSupportException("\u5bf9\u4e0d\u8d77\uff0c\u60a8\u6240\u4f7f\u7528\u7684\u624b\u673a\u8fd0\u8425\u5546\u4e0d\u652f\u6301\u6b64\u77ed\u4fe1\u6fc0\u6d3b\u529f\u80fd\u3002");
            }
            smsInfo = this.smsInfos.get(index);
        }
        return smsInfo;
    }
}
