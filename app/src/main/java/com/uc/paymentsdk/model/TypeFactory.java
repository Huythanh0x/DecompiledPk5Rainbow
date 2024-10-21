package com.uc.paymentsdk.model.TypeFactory;
import java.lang.Object;
import java.lang.String;
import com.uc.paymentsdk.model.IType;
import java.util.HashMap;
import java.lang.ref.SoftReference;
import com.uc.paymentsdk.model.PayType;
import com.uc.paymentsdk.model.ChargeType;
import com.uc.paymentsdk.util.Utils;
import java.lang.Integer;
import java.lang.IllegalArgumentException;
import java.lang.StringBuilder;

public class TypeFactory	// class@000098 from classes.dex
{
    public static final String TYPE_PAY_SMS = "sms";
    public static final String TYPE_PAY_UPOINT = "upoint";
    private static HashMap sTypes;

    public void TypeFactory(){
       super();
    }
    public static void clear(){
       TypeFactory.sTypes = null;
    }
    public static synchronized IType factory(String paramString){
       IType iType;
       IType localObject;
       _monitor_enter(TypeFactory.class);
       if (TypeFactory.sTypes == null) {
          TypeFactory.sTypes = new HashMap(4);
       }
       if (TypeFactory.sTypes.containsKey(paramString) && (iType = TypeFactory.sTypes.get(paramString).get()) != null) {
          localObject = iType;
       }else if(!"upoint".equals(paramString) && !"sms".equals(paramString)){
          iType = new ChargeType(paramString, TypeFactory.getTypeName(paramString), TypeFactory.getTypeDesc(paramString), TypeFactory.getTypeIconFileName(paramString));
       }else {
          iType = new PayType(paramString, TypeFactory.getTypeName(paramString), TypeFactory.getTypeDesc(paramString), TypeFactory.getTypeIconFileName(paramString));
       }
       TypeFactory.sTypes.put(paramString, new SoftReference(iType));
       localObject = iType;
       _monitor_exit(TypeFactory.class);
       return localObject;
    }
    private static String getTypeDesc(String paramString){
       String str;
       if ("upoint".equals(paramString)) {
          str = "\x75\x02U\x70\x02\x8d\x02\x4e\x02<br /><small><small><font color=\'#999999\'>10U\x70\x02\x4e\x02\x50\x021\x51\x02</font></small></small>";
       }else if("sms".equals(paramString)){
          Object[] objArray = new Object[]{Integer.valueOf(Utils.getSmsPayment())};
          str = String.format("\x53\x02\x77\x02\x4f\x02\x76\x02\x63\x02\x8d\x02\x4e\x02<br /><small><small><font color=\'#999999\'>\x53\x02\x90\x02%s\x51\x02\x77\x02\x4f\x02\xff\x02\x53\x02\x8d\x02\x4e\x02\x8b\x02\x51\x02\x5b\x02</font></small></small>", objArray);
       }else {
          throw new IllegalArgumentException("type not supported. "+paramString);
       }
       return str;
    }
    private static String getTypeIconFileName(String paramString){
       String str;
       boolean bool = Utils.isHdpi();
       if ("upoint".equals(paramString)) {
          str = (bool)? "upoint_logo_hdpi.png": "upoint_logo.png";
       }else if("sms".equals(paramString)){
          str = (bool)? "sms_logo_hdpi.png": "sms_logo.png";
       }else {
          throw new IllegalArgumentException("type not supported.");
       }
       return str;
    }
    private static String getTypeName(String paramString){
       return null;
    }
}
