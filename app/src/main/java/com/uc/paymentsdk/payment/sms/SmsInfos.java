package com.uc.paymentsdk.payment.sms;

import android.content.Context;
import java.util.ArrayList;

public class SmsInfos {
    public ArrayList smsInfos;

    public SmsInfos() {
        this.smsInfos = new ArrayList();
    }

    public void add(SmsInfo paramSmsInfo) {
        this.smsInfos.add(paramSmsInfo);
    }

    public SmsInfo filterSmsInfo(Context paramContext, int paymoney) throws SimCardNotSupportException {
        ArrayList smsSuitPriceArr = null;
        int maxMoney = 0;
        int selectIndex = -1;
        if(this.smsInfos.size() == 1) {
            return (SmsInfo)this.smsInfos.get(0);
        }
        for(int i = 0; i < this.smsInfos.size(); ++i) {
            SmsInfo localSmsInfo = (SmsInfo)this.smsInfos.get(i);
            if(smsSuitPriceArr == null) {
                smsSuitPriceArr = SmsInfos.parsePayment(paymoney);
            }
            for(Object object0: smsSuitPriceArr) {
                if(localSmsInfo.money == ((int)(((Integer)object0))) && localSmsInfo.money > maxMoney) {
                    maxMoney = localSmsInfo.money;
                    selectIndex = i;
                }
            }
        }
        if(selectIndex == -1) {
            throw new SimCardNotSupportException("对不起，您所使用的手机运营商不支持此短信激活功能。");
        }
        return (SmsInfo)this.smsInfos.get(selectIndex);
    }

    private static ArrayList parsePayment(int paymoney) {
        ArrayList smsSuitPrice = new ArrayList();
        int i = paymoney;
        do {
            if(paymoney % i == 0) {
                smsSuitPrice.add(Integer.valueOf(i));
            }
            --i;
        }
        while(i > 0);
        return smsSuitPrice;
    }
}

