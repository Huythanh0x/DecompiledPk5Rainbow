/*
 * Decompiled with CFR.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.uc.paymentsdk.payment.sms.SimCardNotSupportException
 *  com.uc.paymentsdk.payment.sms.SmsInfo
 */
package com.uc.paymentsdk.payment.sms;

import android.content.Context;
import com.uc.paymentsdk.payment.sms.SimCardNotSupportException;
import com.uc.paymentsdk.payment.sms.SmsInfo;
import java.util.ArrayList;
import java.util.Iterator;

public class SmsInfos {
    public ArrayList<SmsInfo> smsInfos = new ArrayList<E>();

    private static ArrayList<Integer> parsePayment(int n) {
        int n2;
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        int n3 = n;
        do {
            if (n % n3 == 0) {
                arrayList.add(n3);
            }
            n3 = n2 = n3 - 1;
        } while (n2 > 0);
        return arrayList;
    }

    public void add(SmsInfo smsInfo) {
        this.smsInfos.add(smsInfo);
    }

    /*
     * WARNING - void declaration
     * Enabled force condition propagation
     */
    public SmsInfo filterSmsInfo(Context object, int n) throws SimCardNotSupportException {
        void var1_3;
        Object var6_10 = null;
        int n2 = 0;
        int n3 = -1;
        if (this.smsInfos.size() == 1) {
            SmsInfo smsInfo = this.smsInfos.get(0);
            return var1_3;
        }
        int n4 = 0;
        block1: while (true) {
            void var1_8;
            void var6_11;
            if (n4 >= this.smsInfos.size()) {
                if (n3 == -1) throw new SimCardNotSupportException("\u5bf9\u4e0d\u8d77\uff0c\u60a8\u6240\u4f7f\u7528\u7684\u624b\u673a\u8fd0\u8425\u5546\u4e0d\u652f\u6301\u6b64\u77ed\u4fe1\u6fc0\u6d3b\u529f\u80fd\u3002");
                SmsInfo smsInfo = this.smsInfos.get(n3);
                return var1_3;
            }
            SmsInfo smsInfo = this.smsInfos.get(n4);
            void var1_6 = var6_11;
            if (var6_11 == null) {
                void var2_9;
                ArrayList<Integer> arrayList = SmsInfos.parsePayment((int)var2_9);
            }
            Iterator<E> iterator = var1_8.iterator();
            while (true) {
                if (!iterator.hasNext()) {
                    ++n4;
                    void var6_13 = var1_8;
                    continue block1;
                }
                Integer n5 = (Integer)iterator.next();
                if (smsInfo.money != n5 || smsInfo.money <= n2) continue;
                n2 = smsInfo.money;
                n3 = n4;
            }
            break;
        }
    }
}
