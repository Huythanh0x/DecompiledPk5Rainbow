package com.uc.paymentsdk.util.Utils;
import java.lang.Object;
import android.content.Context;
import com.uc.paymentsdk.payment.sms.SimCardNotSupportException;
import java.lang.String;
import android.telephony.TelephonyManager;
import java.io.InputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.StringBuilder;
import java.io.IOException;
import java.lang.System;
import java.text.SimpleDateFormat;
import java.util.Date;
import android.widget.TextView;
import android.widget.LinearLayout;
import android.widget.LinearLayout$LayoutParams;
import android.view.ViewGroup$LayoutParams;
import java.lang.CharSequence;
import android.view.View;
import com.uc.paymentsdk.payment.PaymentInfo;
import java.net.URLEncoder;
import com.uc.paymentsdk.commons.codec.DigestUtils;
import android.content.pm.PackageManager;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import org.apache.http.HttpResponse;
import org.apache.http.HttpEntity;
import org.apache.http.util.EntityUtils;
import java.text.DateFormat;
import java.lang.Double;
import android.graphics.drawable.Drawable;
import res.FileLoader;
import java.lang.Class;
import java.lang.Long;
import java.util.Enumeration;
import java.net.NetworkInterface;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.Set;
import java.util.Iterator;
import java.util.Random;
import com.uc.paymentsdk.util.PrefUtil;
import com.uc.paymentsdk.payment.sms.SmsInfos;
import java.lang.IllegalArgumentException;
import com.uc.paymentsdk.payment.upoint.UPointInfo;
import com.uc.paymentsdk.payment.upoint.UPointPayInfo;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import android.view.WindowManager;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View$OnClickListener;
import android.widget.RelativeLayout;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable$Orientation;
import com.uc.paymentsdk.util.Constants;
import android.widget.ImageView;
import android.widget.RelativeLayout$LayoutParams;
import android.app.Activity;
import android.view.Window;
import android.view.ViewParent;
import android.content.ContentResolver;
import android.provider.Settings$System;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.io.File;
import java.io.FileOutputStream;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.Writer;
import java.lang.Exception;

public class Utils	// class@0000d7 from classes.dex
{
    private static final String TITLE_ICON_BACK = "back";
    private static final String TITLE_ICON_CANCEL = "cancel";
    private static Random rdm;
    private static boolean sIsHdpi;
    private static PaymentInfo sPaymentInfo;
    private static SmsInfos sSmsInfos;
    private static UPointInfo sUPointInfo;
    private static UPointPayInfo sUPointPayInfo;
    private static String sessionidstr;
    private static String upconsumeid;

    static {
       Utils.sessionidstr = "";
       Utils.upconsumeid = "";
    }
    public void Utils(){
       super();
    }
    public static void CheckSimCardSupprotInfo(Context paramContext){
       if (Utils.isAirMode(paramContext)) {
          throw new SimCardNotSupportException("\x5f\x02\x52\x02\x62\x02\x67\x02\x8b\x02\x7f\x02\x4e\x02\x98\x02\x88\x02\x6a\x02\x5f\x02\xff\x02\x4e\x02\x80\x02\x53\x02\x90\x02\x77\x02\x4f\x02\x30\x02");
       }
       paramContext = paramContext.getSystemService("phone");
       if (5 != paramContext.getSimState()) {
          throw new SimCardNotSupportException("\x5b\x02\x4e\x02\x8d\x02\xff\x02\x77\x02\x4f\x02\x53\x02\x90\x02\x4e\x02\x62\x02\x52\x02\x30\x02\x65\x02\x6c\x02\x6f\x02\x6d\x02\x6b\x02\x52\x02\x80\x02\xff\x02\x8b\x02\x63\x02\x51\x02SIM\x53\x02\x54\x02\x51\x02\x8b\x02\x30\x02");
       }
       return;
    }
    public static void clearSmsInfos(){
       Utils.sSmsInfos = null;
    }
    public static void clearUPConsumeid(){
       Utils.upconsumeid = "";
    }
    public static void clearUPointInfo(){
       Utils.sUPointInfo = null;
    }
    public static void clearUPointPayInfo(){
       Utils.sUPointPayInfo = null;
    }
    public static String convertStreamToString(InputStream paramInputStream){
       BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(paramInputStream));
       StringBuilder localStringBuilder = "";
       String str = null;
       try{
          while ((str = localBufferedReader.readLine()) != null) {
             localStringBuilder = localStringBuilder.append(str);
          }
          paramInputStream.close();
       }catch(java.io.IOException e5){
          IOException localIOException2 = e5;
          try{
             localIOException2.printStackTrace();
             paramInputStream.close();
          }catch(java.io.IOException e2){
             e2.printStackTrace();
          }
       }catch(java.io.IOException e2){
          e2.printStackTrace();
          return localStringBuilder;
       }
    }
    public static String createARanConsumeID(int number){
       String rdmstr = "";
       while (rdmstr.length() < number) {
          rdmstr = String.valueOf(rdmstr).append(Utils.getRan(10)).toString();
       }
       if (rdmstr.length() > number) {
          rdmstr.substring(0, number);
       }
       return rdmstr;
    }
    public static String createARanSessionid(int number){
       long timestemp = System.currentTimeMillis();
       long range = 1;
       for (int x = 0; x < number; x++) {
          range = range * 10;
       }
       long rdmint = Utils.getRan(range);
       String rdmstr = String.valueOf(rdmint);
       while (rdmstr.length() < number) {
          rdmstr = String.valueOf(rdmstr).append(Utils.getRan(10)).toString();
       }
       return String.valueOf(timestemp)+rdmstr;
    }
    public static int dateDiffByDay(String starttime,String endtime,String format){
       int i;
       SimpleDateFormat sd = new SimpleDateFormat(format);
       try{
          long nd = 0x5265c00;
          long diff = sd.parse(endtime).getTime() - sd.parse(starttime).getTime();
          long day = diff / nd;
          i = (int)day;
       }catch(java.lang.Exception e8){
          Exception e = e8;
          i = -1;
       }
       return i;
    }
    public static TextView generateBorderView(Context paramContext){
       TextView localTextView = new TextView(paramContext);
       localTextView.setBackgroundResource(0x1080014);
       return localTextView;
    }
    public static LinearLayout generateFooterView(Context paramContext){
       LinearLayout localLinearLayout = new LinearLayout(paramContext);
       localLinearLayout.setOrientation(1);
       TextView lineTextView = Utils.generateBorderView(paramContext);
       LinearLayout$LayoutParams lineLayoutParams = new LinearLayout$LayoutParams(-1, 1);
       lineTextView.setLayoutParams(lineLayoutParams);
       LinearLayout$LayoutParams footLayoutParams = new LinearLayout$LayoutParams(-1, -2);
       TextView footerTextView = new TextView(paramContext);
       footerTextView.setTextSize(16.00f);
       footerTextView.setGravity(17);
       footerTextView.setPadding(0, 20, 0, 20);
       footerTextView.setText("UC\x6e\x02\x62\x02-UC\x4f\x02\x89\x02");
       footerTextView.setTextColor(-12303292);
       localLinearLayout.addView(lineTextView);
       localLinearLayout.addView(footerTextView, footLayoutParams);
       return localLinearLayout;
    }
    public static void generateOrderId(PaymentInfo paramPaymentInfo){
       String str2;
       String str1 = Utils.getIpAddress();
       try{
          str2 = String.valueOf(URLEncoder.encode(paramPaymentInfo.getUsername(), "UTF-8"))+paramPaymentInfo.getAppkey()+URLEncoder.encode(paramPaymentInfo.getPayname(), "UTF-8")+System.currentTimeMillis()+str1;
       }catch(java.io.UnsupportedEncodingException e3){
          UnsupportedEncodingException localUnsupportedEncodingException = e3;
          str2 = "";
       }
       paramPaymentInfo.setOrderID(DigestUtils.md5Hex(str2));
       return;
    }
    public static String getAppkey(Context paramContext){
       ApplicationInfo localApplicationInfo = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128);
       return localApplicationInfo.metaData.get("ucgame_appkey").toString();
    }
    public static String getBodyString(int paramInt,HttpResponse paramHttpResponse){
       String str = null;
       try{
          str = EntityUtils.toString(paramHttpResponse.getEntity(), "UTF-8");
       }catch(org.apache.http.ParseException e1){
       }catch(java.io.IOException e1){
       }
       return str;
    }
    public static String getCpID(Context paramContext){
       ApplicationInfo localApplicationInfo = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128);
       return localApplicationInfo.metaData.get("ucgame_cpid").toString();
    }
    public static String getCurrentTime(boolean isdateonly){
       DateFormat format1 = (isdateonly)? new SimpleDateFormat("yyyy-MM-dd"): new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
       return format1.format(new Date());
    }
    public static double getDouble(String paramString){
       return Double.parseDouble(paramString);
    }
    public static Drawable getDrawableFromFile(String paramString){
       return Drawable.createFromStream(Utils.getFileStream(paramString), paramString);
    }
    private static InputStream getFileStream(String paramString){
       return FileLoader.class.getResourceAsStream(paramString);
    }
    public static int getInt(int paramInt,String paramString){
       return Utils.getInt(paramInt, paramString, 0);
    }
    public static int getInt(int paramInt1,String paramString,int paramInt2){
       int i;
       if (paramString == null) {
          i = paramInt2;
       }else {
          try{
             i = (int)Long.parseLong(paramString.trim(), paramInt1);
          }catch(java.lang.NumberFormatException e0){
             i = paramInt2;
          }
       }
       return i;
    }
    public static int getInt(String paramString){
       return Utils.getInt(10, paramString);
    }
    public static int getInt(String paramString,int paramInt){
       return Utils.getInt(10, paramString, paramInt);
    }
    private static String getIpAddress(){
       String str;
       try{
          Enumeration localEnumeration1 = NetworkInterface.getNetworkInterfaces();
          while (true) {
             if (!localEnumeration1.hasMoreElements()) {
             }else {
                Enumeration localEnumeration2 = localEnumeration1.nextElement().getInetAddresses();
                while (true) {
                   if (localEnumeration2.hasMoreElements()) {
                      InetAddress inetAddress = localEnumeration2.nextElement();
                      if (!inetAddress.isLoopbackAddress()) {
                         str = inetAddress.getHostAddress();
                         break ;
                      }
                   }else {
                      continue ;
                   }
                }
                return str;
             }
          }
       }catch(java.net.SocketException e4){
       }
       str = "";
    }
    public static long getLong(String paramString){
       long l;
       if (paramString == null) {
          l = 0;
       }else {
          try{
             l = Long.parseLong(paramString.trim());
          }catch(java.lang.NumberFormatException e0){
             l = 0;
          }
       }
       return l;
    }
    public static PaymentInfo getPaymentInfo(){
       return Utils.sPaymentInfo;
    }
    public static String getQueryString(HashMap paramHashMap){
       StringBuilder querystring = "";
       Iterator localIterator = paramHashMap.keySet().iterator();
       while (localIterator.hasNext()) {
          String strx = localIterator.next();
          querystring = (querystring.length() < 1)? querystring.append(String.valueOf(strx).append("=").toString()): querystring.append("&".append(strx).append("=").toString());
          querystring = querystring.append(paramHashMap.get(strx));
       }
       return querystring;
    }
    private static long getRan(long range){
       if (Utils.rdm == null) {
          Utils.rdm = new Random();
       }
       long rtn = (Utils.rdm.nextLong() >> 1) % range;
       return rtn;
    }
    public static String getSessionID(Context paramContext){
       String sessionidstr;
       Utils.sessionidstr = PrefUtil.getUserSession(paramContext);
       if (Utils.sessionidstr != null && !Utils.sessionidstr.equals("")) {
          sessionidstr = Utils.sessionidstr;
       }else {
          Utils.sessionidstr = Utils.createARanSessionid(8);
          PrefUtil.setUserSession(paramContext, Utils.sessionidstr);
          sessionidstr = Utils.sessionidstr;
       }
       return sessionidstr;
    }
    public static String getSimNumber(Context paramContext){
       paramContext = paramContext.getSystemService("phone");
       String str = paramContext.getSubscriberId();
       return str;
    }
    public static SmsInfos getSmsInfos(){
       return Utils.sSmsInfos;
    }
    public static int getSmsPayment(){
       return (Utils.getPaymentInfo().getMoney() / 10);
    }
    private static String getTitleIconFileName(String paramString){
       String str;
       boolean bool = Utils.isHdpi();
       if ("back".equals(paramString)) {
          str = (bool)? "back_btn_hdpi.png": "back_btn.png";
       }else if("cancel".equals(paramString)){
          str = (bool)? "cancel_btn_hdpi.png": "cancel_btn.png";
       }else {
          throw new IllegalArgumentException("type not supported.");
       }
       return str;
    }
    public static String getUPConsumeid(String uid,String cpid,String gameid){
       if (Utils.upconsumeid == null || Utils.upconsumeid.equals("")) {
          Utils.upconsumeid = String.valueOf(cpid)+gameid+uid+Utils.createARanConsumeID(10);
       }
       return Utils.upconsumeid;
    }
    public static UPointInfo getUPointInfo(){
       return Utils.sUPointInfo;
    }
    public static UPointPayInfo getUPointPayInfo(){
       return Utils.sUPointPayInfo;
    }
    public static byte[] getUTF8Bytes(String paramString){
       byte[] uobyteArray;
       if (paramString == null) {
          uobyteArray = new byte[0];
       }else {
          try{
             uobyteArray = paramString.getBytes("UTF-8");
          }catch(java.io.UnsupportedEncodingException e5){
             UnsupportedEncodingException localUnsupportedEncodingException = e5;
             try{
                ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
                DataOutputStream localDataOutputStream = new DataOutputStream(localByteArrayOutputStream);
                localDataOutputStream.writeUTF(paramString);
                byte[] arrayOfByte1 = localByteArrayOutputStream.toByteArray();
                localByteArrayOutputStream.close();
                localDataOutputStream.close();
                byte[] arrayOfByte2 = new byte[(arrayOfByte1.length - 2)];
                System.arraycopy(arrayOfByte1, 2, arrayOfByte2, 0, arrayOfByte2.length);
                uobyteArray = arrayOfByte2;
             }catch(java.io.IOException e5){
                uobyteArray = new byte[0];
             }
          }
       }
       return uobyteArray;
    }
    public static String getUTF8String(byte[] paramArrayOfByte){
       String str = (paramArrayOfByte == null)? "": Utils.getUTF8String(paramArrayOfByte, 0, paramArrayOfByte.length);
       return str;
    }
    public static String getUTF8String(byte[] paramArrayOfByte,int paramInt1,int paramInt2){
       String str;
       if (paramArrayOfByte == null) {
          str = "";
       }else {
          try{
             str = new String(paramArrayOfByte, paramInt1, paramInt2, "UTF-8");
          }catch(java.io.UnsupportedEncodingException e0){
             str = "";
          }
       }
       return str;
    }
    public static String getUserAgent(Context paramContext){
       String str = "";
       PackageManager localPackageManager = paramContext.getPackageManager();
       try{
          str = localPackageManager.getApplicationLabel(localPackageManager.getApplicationInfo(paramContext.getPackageName(), 128)).toString();
       }catch(android.content.pm.PackageManager$NameNotFoundException e2){
       }
       return "packageName="+paramContext.getPackageName()+",appName="+str+",channelID=1";
    }
    public static String getXmlFromFile(String paramString){
       return Utils.convertStreamToString(Utils.getFileStream(paramString));
    }
    public static String getXmlRequestBody(HashMap paramHashMap,Context paramContext){
       StringBuilder localStringBuilder = "";
       localStringBuilder = localStringBuilder+"<request";
       if (paramHashMap.containsKey("local_version")) {
          localStringBuilder = localStringBuilder+" local_version=\""+paramHashMap.get("local_version")+"\" ";
          paramHashMap.remove("local_version");
       }
       localStringBuilder = localStringBuilder+">";
       Iterator localIterator = paramHashMap.keySet().iterator();
       while (localIterator.hasNext()) {
          String strx = localIterator.next();
          StringBuilder localStringBuilder1 = localStringBuilder.append("<");
          localStringBuilder1 = localStringBuilder1.append(strx).append(">");
          localStringBuilder = localStringBuilder.append(paramHashMap.get(strx));
          localStringBuilder1 = localStringBuilder.append("</");
          localStringBuilder1 = localStringBuilder1.append(strx).append(">");
       }
       localStringBuilder = localStringBuilder+"</request>";
       return localStringBuilder;
    }
    public static void init(Context context){
       int i;
       int ix = 0;
       try{
          ApplicationInfo localApplicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
          Field localField = localApplicationInfo.getClass().getField("targetSdkVersion");
          if ((i = localField.getInt(localApplicationInfo)) < 4) {
             Utils.sIsHdpi = false;
          }else {
             DisplayMetrics localObject = new DisplayMetrics();
             context.getSystemService("window").getDefaultDisplay().getMetrics(localObject);
             boolean b = ((0x3ff0000000000000 - (double)localObject.density) > 0)? true: ix;
             Utils.sIsHdpi = b;
          }
       }catch(android.content.pm.PackageManager$NameNotFoundException e12){
          PackageManager$NameNotFoundException localNameNotFoundException = e12;
          Utils.sIsHdpi = ix;
       }catch(java.lang.SecurityException e12){
          SecurityException localSecurityException = e12;
          Utils.sIsHdpi = false;
       }catch(java.lang.NoSuchFieldException e12){
          NoSuchFieldException localNoSuchFieldException = e12;
          Utils.sIsHdpi = false;
       }catch(java.lang.IllegalArgumentException e12){
          IllegalArgumentException localIllegalArgumentException = e12;
          Utils.sIsHdpi = false;
       }catch(java.lang.IllegalAccessException e12){
          IllegalAccessException localIllegalAccessException = e12;
          Utils.sIsHdpi = false;
       }
       return;
    }
    public static RelativeLayout initSubTitle(Context paramscenter,View$OnClickListener localTextView,String paramString,boolean iscancel){
       RelativeLayout layout = new RelativeLayout(paramscenter);
       layout.setLayoutParams(new ViewGroup$LayoutParams(-1, -2));
       int[] ointArray = new int[]{Constants.COLOR_SUBTITLE_BACKGROUND1,Constants.COLOR_SUBTITLE_BACKGROUND2};
       GradientDrawable gb = new GradientDrawable(GradientDrawable$Orientation.TOP_BOTTOM, ointArray);
       layout.setBackgroundDrawable(gb);
       ImageView backicon = new ImageView(paramscenter);
       backicon.setImageDrawable(Utils.getDrawableFromFile(Utils.getTitleIconFileName("back")));
       backicon.setId(9);
       RelativeLayout$LayoutParams paramsleft = new RelativeLayout$LayoutParams(-2, -2);
       paramsleft.addRule(9);
       paramsleft.addRule(15);
       backicon.setLayoutParams(paramsleft);
       backicon.setOnClickListener(localTextView);
       paramsleft = 8;
       backicon.setPadding(paramsleft, 0, 0, 0);
       ImageView cancelicon = new ImageView(paramscenter);
       cancelicon.setImageDrawable(Utils.getDrawableFromFile(Utils.getTitleIconFileName("cancel")));
       cancelicon.setId(10);
       RelativeLayout$LayoutParams paramsright = new RelativeLayout$LayoutParams(-2, -2);
       paramsright.addRule(11);
       paramsright.addRule(15);
       cancelicon.setLayoutParams(paramsright);
       cancelicon.setOnClickListener(localTextView);
       listener = null;
       paramsright = null;
       cancelicon.setPadding(listener, paramsright, 10, 0);
       TextView textView = new TextView(paramscenter);
       paramContext = 17;
       textView.setGravity(paramContext);
       textView.setTextColor(Constants.COLOR_TITLE_BACKGROUND);
       textView.setPadding(0, 10, 0, 10);
       textView.setTextSize(23.00f);
       textView.setText(paramString);
       paramString = -2;
       RelativeLayout$LayoutParams layoutParams = new RelativeLayout$LayoutParams(paramString, -2);
       layoutParams.addRule(14);
       textView.setLayoutParams(layoutParams);
       layout.addView(backicon);
       layout.addView(textView);
       if (iscancel) {
          layout.addView(cancelicon);
       }
       return layout;
    }
    public static void initTitleBar(Activity paramActivity){
       View localView1;
       ViewParent localViewParent;
       if ((localView1 = paramActivity.getWindow().findViewById(0x1020016)) != null) {
          if (localView1 instanceof TextView) {
             localView1.setTextSize(13.00f);
          }
          if ((localViewParent = localView1.getParent()) != null && localViewParent instanceof View) {
             View localView2 = localViewParent;
             localView2.setBackgroundColor(0x80a09fc);
          }
       }
       paramActivity.setTitle("UC\x65\x02\x4e\x02");
       return;
    }
    public static boolean isAirMode(Context paramContext){
       boolean b;
       int i = 1;
       try{
          if (Settings$System.getInt(paramContext.getContentResolver(), "airplane_mode_on") == i) {
             b = i;
          label_000e :
             return b;
          }
       }catch(android.provider.Settings$SettingNotFoundException e0){
       }
       b = false;
       goto label_000e ;
    }
    public static boolean isHdpi(){
       return Utils.sIsHdpi;
    }
    public static boolean isNumeric(String str){
       Pattern pattern = Pattern.compile("[0-9]*");
       return pattern.matcher(str).matches();
    }
    public static void loadFile(String paramString1,String paramString2){
       InputStream localInputStream = Utils.getFileStream(paramString1);
       File localFile = new File(paramString2);
       localFile.createNewFile();
       FileOutputStream localFileOutputStream = new FileOutputStream(localFile);
       byte[] arrayOfByte = new byte[1024];
       int i = 0;
       while ((i = localInputStream.read(arrayOfByte)) > 0) {
          localFileOutputStream.write(arrayOfByte, 0, i);
       }
       localFileOutputStream.close();
       localInputStream.close();
       return;
    }
    public static void setPaymentInfo(PaymentInfo paramPaymentInfo){
       Utils.sPaymentInfo = paramPaymentInfo;
    }
    public static void setSmsInfo(SmsInfos paramSmsInfos){
       Utils.sSmsInfos = paramSmsInfos;
    }
    public static void setUPointInfo(UPointInfo sUPointInfo){
       Utils.sUPointInfo = sUPointInfo;
    }
    public static void setUPointPayInfo(UPointPayInfo UPointPayInfo){
       Utils.sUPointPayInfo = UPointPayInfo;
    }
    public static void writeSmsInfoPayment(Context paramContext,String paramString){
       try{
          String str = String.valueOf(System.currentTimeMillis());
          BufferedWriter localBufferedWriter = new BufferedWriter(new FileWriter(String.valueOf(paramContext.getFilesDir().getAbsolutePath())+"/"+str+".smspayment"));
          localBufferedWriter.write(paramString);
          localBufferedWriter.flush();
          localBufferedWriter.close();
       }catch(java.lang.Exception e3){
          Exception localException = e3;
          localException.printStackTrace();
       }
       return;
    }
}
