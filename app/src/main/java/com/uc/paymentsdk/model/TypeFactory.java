package com.uc.paymentsdk.model;

import com.uc.paymentsdk.util.Utils;
import java.lang.ref.SoftReference;
import java.util.HashMap;

public class TypeFactory
{
    public static final String TYPE_PAY_SMS = "sms";
    public static final String TYPE_PAY_UPOINT = "upoint";
    private static HashMap<String, SoftReference<IType>> sTypes;
    
    public TypeFactory() {
        super();
    }
    
    public static void clear() {
        TypeFactory.sTypes = null;
    }
    
    public static IType factory(final String key) {
        synchronized (TypeFactory.class) {
            if (TypeFactory.sTypes == null) {
                TypeFactory.sTypes = new HashMap<String, SoftReference<IType>>(4);
            }
            Label_0060: {
                if (!TypeFactory.sTypes.containsKey(key)) {
                    break Label_0060;
                }
                final IType type = (IType)((SoftReference<IType>)TypeFactory.sTypes.get(key)).get();
                if (type == null) {
                    break Label_0060;
                }
                return type;
            }
            AbstractType referent;
            if ("upoint".equals(key) || "sms".equals(key)) {
                referent = new PayType(key, getTypeName(key), getTypeDesc(key), getTypeIconFileName(key));
            }
            else {
                referent = new ChargeType(key, getTypeName(key), getTypeDesc(key), getTypeIconFileName(key));
            }
            TypeFactory.sTypes.put(key, new SoftReference<IType>((Object)referent));
            return referent;
        }
    }
    
    private static String getTypeDesc(String format) {
        if ("upoint".equals(format)) {
            format = "\u7528U\u70b9\u8d2d\u4e70<br /><small><small><font color='#999999'>10U\u70b9\u4ef7\u503c1\u5143</font></small></small>";
        }
        else {
            if (!"sms".equals(format)) {
                throw new IllegalArgumentException("type not supported. " + format);
            }
            format = String.format("\u53d1\u77ed\u4fe1\u76f4\u63a5\u8d2d\u4e70<br /><small><small><font color='#999999'>\u53d1\u9001%s\u5143\u77ed\u4fe1\uff0c\u53ef\u8d2d\u4e70\u8be5\u5185\u5bb9</font></small></small>", Integer.valueOf(Utils.getSmsPayment()));
        }
        return format;
    }
    
    private static String getTypeIconFileName(String s) {
        final boolean hdpi = Utils.isHdpi();
        if ("upoint".equals(s)) {
            if (hdpi) {
                s = "upoint_logo_hdpi.png";
            }
            else {
                s = "upoint_logo.png";
            }
        }
        else {
            if (!"sms".equals(s)) {
                throw new IllegalArgumentException("type not supported.");
            }
            if (hdpi) {
                s = "sms_logo_hdpi.png";
            }
            else {
                s = "sms_logo.png";
            }
        }
        return s;
    }
    
    private static String getTypeName(final String s) {
        return null;
    }
}
