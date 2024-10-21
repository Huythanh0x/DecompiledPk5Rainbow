package com.uc.paymentsdk.model;

import com.uc.paymentsdk.util.Utils;
import java.lang.ref.SoftReference;
import java.util.HashMap;

public class TypeFactory {
    public static final String TYPE_PAY_SMS = "sms";
    public static final String TYPE_PAY_UPOINT = "upoint";
    private static HashMap sTypes;

    public static void clear() {
        TypeFactory.sTypes = null;
    }

    public static IType factory(String paramString) {
        IType localObject;
        synchronized(TypeFactory.class) {
            if(TypeFactory.sTypes == null) {
                TypeFactory.sTypes = new HashMap(4);
            }
            if(TypeFactory.sTypes.containsKey(paramString)) {
                IType localObject = (IType)((SoftReference)TypeFactory.sTypes.get(paramString)).get();
                if(localObject != null) {
                    return localObject;
                }
                goto label_10;
            }
            else {
            label_10:
                PayType localObject = "upoint".equals(paramString) || "sms".equals(paramString) ? new PayType(paramString, null, TypeFactory.getTypeDesc(paramString), TypeFactory.getTypeIconFileName(paramString)) : new ChargeType(paramString, null, TypeFactory.getTypeDesc(paramString), TypeFactory.getTypeIconFileName(paramString));
                TypeFactory.sTypes.put(paramString, new SoftReference(localObject));
                localObject = localObject;
            }
            return localObject;
        }
    }

    private static String getTypeDesc(String paramString) {
        if("upoint".equals(paramString)) {
            return "用U点购买<br /><small><small><font color=\'#999999\'>10U点价值1元</font></small></small>";
        }
        if(!"sms".equals(paramString)) {
            throw new IllegalArgumentException("type not supported. " + paramString);
        }
        return String.format("发短信直接购买<br /><small><small><font color=\'#999999\'>发送%s元短信，可购买该内容</font></small></small>", Utils.getSmsPayment());
    }

    private static String getTypeIconFileName(String paramString) {
        if("upoint".equals(paramString)) {
            return "upoint_logo.png";
        }
        if(!"sms".equals(paramString)) {
            throw new IllegalArgumentException("type not supported.");
        }
        return "sms_logo.png";
    }

    private static String getTypeName(String paramString) [...] // Inlined contents
}

