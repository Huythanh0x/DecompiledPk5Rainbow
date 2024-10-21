/*
 * Decompiled with CFR.
 * 
 * Could not load the following classes:
 *  com.uc.paymentsdk.model.ChargeType
 *  com.uc.paymentsdk.model.IType
 *  com.uc.paymentsdk.model.PayType
 *  com.uc.paymentsdk.util.Utils
 */
package com.uc.paymentsdk.model;

import com.uc.paymentsdk.model.ChargeType;
import com.uc.paymentsdk.model.IType;
import com.uc.paymentsdk.model.PayType;
import com.uc.paymentsdk.util.Utils;
import java.lang.ref.SoftReference;
import java.util.HashMap;

public class TypeFactory {
    public static final String TYPE_PAY_SMS = "sms";
    public static final String TYPE_PAY_UPOINT = "upoint";
    private static HashMap<String, SoftReference<IType>> sTypes;

    public static void clear() {
        sTypes = null;
    }

    /*
     * Unable to fully structure code
     */
    public static IType factory(String var0) {
        block9: {
            // MONITORENTER : com.uc.paymentsdk.model.TypeFactory.class
            if (TypeFactory.sTypes == null) {
                var1_2 = new HashMap(4);
                TypeFactory.sTypes = var1_2;
            }
            if (!TypeFactory.sTypes.containsKey(var0) || (var1_2 = TypeFactory.sTypes.get(var0).get()) == null) break block9;
            var0 = var1_2;
lbl8:
            // 2 sources

            return var0;
        }
        try {
            if ("upoint".equals(var0) || "sms".equals(var0)) {
                var1_2 = new PayType(var0, TypeFactory.getTypeName(var0), TypeFactory.getTypeDesc(var0), TypeFactory.getTypeIconFileName(var0));
lbl14:
                // 2 sources

                while (true) {
                    var2_3 = TypeFactory.sTypes;
                    var3_4 = new SoftReference<IType>(var1_2);
                    var2_3.put(var0, var3_4);
                    var0 = var1_2;
                    ** continue;
                    break;
                }
            }
            var1_2 = new ChargeType(var0, TypeFactory.getTypeName(var0), TypeFactory.getTypeDesc(var0), TypeFactory.getTypeIconFileName(var0));
            ** continue;
        }
        catch (Throwable var0_1) {
            throw var0_1;
        }
        finally {
            // MONITOREXIT : com.uc.paymentsdk.model.TypeFactory.class
        }
    }

    /*
     * Enabled force condition propagation
     */
    private static String getTypeDesc(String string) {
        if (TYPE_PAY_UPOINT.equals(string)) {
            return "\u7528U\u70b9\u8d2d\u4e70<br /><small><small><font color='#999999'>10U\u70b9\u4ef7\u503c1\u5143</font></small></small>";
        }
        if (!TYPE_PAY_SMS.equals(string)) throw new IllegalArgumentException("type not supported. " + string);
        return String.format("\u53d1\u77ed\u4fe1\u76f4\u63a5\u8d2d\u4e70<br /><small><small><font color='#999999'>\u53d1\u9001%s\u5143\u77ed\u4fe1\uff0c\u53ef\u8d2d\u4e70\u8be5\u5185\u5bb9</font></small></small>", Utils.getSmsPayment());
    }

    /*
     * Enabled force condition propagation
     */
    private static String getTypeIconFileName(String string) {
        boolean bl = Utils.isHdpi();
        if (TYPE_PAY_UPOINT.equals(string)) {
            if (!bl) return "upoint_logo.png";
            return "upoint_logo_hdpi.png";
        }
        if (!TYPE_PAY_SMS.equals(string)) throw new IllegalArgumentException("type not supported.");
        if (!bl) return "sms_logo.png";
        return "sms_logo_hdpi.png";
    }

    private static String getTypeName(String string) {
        return null;
    }
}
