package com.uc.paymentsdk.payment.sms;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class SmsInfos {
    public ArrayList<SmsInfo> smsInfos = new ArrayList<>();

    public void add(SmsInfo paramSmsInfo) {
        this.smsInfos.add(paramSmsInfo);
    }

    public SmsInfo filterSmsInfo(Context paramContext, int paymoney) throws SimCardNotSupportException {
        ArrayList<Integer> smsSuitPriceArr = null;
        int maxMoney = 0;
        int selectIndex = -1;
        if (this.smsInfos.size() == 1) {
            return this.smsInfos.get(0);
        }
        for (int i = 0; i < this.smsInfos.size(); i++) {
            SmsInfo localSmsInfo = this.smsInfos.get(i);
            if (smsSuitPriceArr == null) {
                smsSuitPriceArr = parsePayment(paymoney);
            }
            Iterator<Integer> smsSuitriceIte = smsSuitPriceArr.iterator();
            while (smsSuitriceIte.hasNext()) {
                Integer aPrice = smsSuitriceIte.next();
                if (localSmsInfo.money == aPrice.intValue() && localSmsInfo.money > maxMoney) {
                    maxMoney = localSmsInfo.money;
                    selectIndex = i;
                }
            }
        }
        if (selectIndex != -1) {
            return this.smsInfos.get(selectIndex);
        }
        throw new SimCardNotSupportException("对不起，您所使用的手机运营商不支持此短信激活功能。");
    }

    private static ArrayList<Integer> parsePayment(int paymoney) {
        ArrayList<Integer> smsSuitPrice = new ArrayList<>();
        int i = paymoney;
        do {
            if (paymoney % i == 0) {
                smsSuitPrice.add(Integer.valueOf(i));
            }
            i--;
        } while (i > 0);
        return smsSuitPrice;
    }
}
