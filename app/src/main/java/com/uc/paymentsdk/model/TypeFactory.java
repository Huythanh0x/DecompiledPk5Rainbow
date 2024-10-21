package com.uc.paymentsdk.model;

import com.uc.paymentsdk.util.Constants;
import com.uc.paymentsdk.util.Utils;
import java.lang.ref.SoftReference;
import java.util.HashMap;

/* loaded from: classes.dex */
public class TypeFactory {
    public static final String TYPE_PAY_SMS = "sms";
    public static final String TYPE_PAY_UPOINT = "upoint";
    private static HashMap<String, SoftReference<IType>> sTypes;

    public static synchronized IType factory(String paramString) {
        IType localObject;
        IType localObject2;
        IType localObject3;
        synchronized (TypeFactory.class) {
            if (sTypes == null) {
                sTypes = new HashMap<>(4);
            }
            if (!sTypes.containsKey(paramString) || (localObject3 = sTypes.get(paramString).get()) == null) {
                if (TYPE_PAY_UPOINT.equals(paramString) || "sms".equals(paramString)) {
                    localObject = new PayType(paramString, getTypeName(paramString), getTypeDesc(paramString), getTypeIconFileName(paramString));
                } else {
                    localObject = new ChargeType(paramString, getTypeName(paramString), getTypeDesc(paramString), getTypeIconFileName(paramString));
                }
                sTypes.put(paramString, new SoftReference<>(localObject));
                localObject2 = localObject;
            } else {
                localObject2 = localObject3;
            }
        }
        return localObject2;
    }

    private static String getTypeDesc(String paramString) {
        if (TYPE_PAY_UPOINT.equals(paramString)) {
            return "用U点购买<br /><small><small><font color='#999999'>10U点价值1元</font></small></small>";
        }
        if ("sms".equals(paramString)) {
            return String.format("发短信直接购买<br /><small><small><font color='#999999'>发送%s元短信，可购买该内容</font></small></small>", Integer.valueOf(Utils.getSmsPayment()));
        }
        throw new IllegalArgumentException("type not supported. " + paramString);
    }

    private static String getTypeName(String paramString) {
        return null;
    }

    private static String getTypeIconFileName(String paramString) {
        boolean bool = Utils.isHdpi();
        if (TYPE_PAY_UPOINT.equals(paramString)) {
            if (bool) {
                return "upoint_logo_hdpi.png";
            }
            return "upoint_logo.png";
        }
        if ("sms".equals(paramString)) {
            if (bool) {
                return Constants.RES_TYPE_SMS_ICON_HDPI;
            }
            return Constants.RES_TYPE_SMS_ICON;
        }
        throw new IllegalArgumentException(Constants.ERROR_TYPE_NOT_SUPPORTED);
    }

    public static void clear() {
        sTypes = null;
    }
}
