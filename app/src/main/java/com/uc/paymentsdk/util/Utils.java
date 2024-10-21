package com.uc.paymentsdk.util;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.uc.paymentsdk.commons.codec.DigestUtils;
import com.uc.paymentsdk.payment.PaymentInfo;
import com.uc.paymentsdk.payment.sms.SimCardNotSupportException;
import com.uc.paymentsdk.payment.sms.SmsInfos;
import com.uc.paymentsdk.payment.upoint.UPointInfo;
import com.uc.paymentsdk.payment.upoint.UPointPayInfo;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import java.util.regex.Pattern;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.util.EntityUtils;
import res.FileLoader;

public class Utils {
  private static final String TITLE_ICON_BACK = "back";
  
  private static final String TITLE_ICON_CANCEL = "cancel";
  
  private static Random rdm;
  
  private static boolean sIsHdpi;
  
  private static PaymentInfo sPaymentInfo;
  
  private static SmsInfos sSmsInfos;
  
  private static UPointInfo sUPointInfo;
  
  private static UPointPayInfo sUPointPayInfo;
  
  private static String sessionidstr = "";
  
  private static String upconsumeid = "";
  
  public static void CheckSimCardSupprotInfo(Context paramContext) throws SimCardNotSupportException {
    if (isAirMode(paramContext))
      throw new SimCardNotSupportException("当前手机设置为飞行模式，不能发送短信。"); 
    if (5 != ((TelephonyManager)paramContext.getSystemService("phone")).getSimState())
      throw new SimCardNotSupportException("对不起，短信发送不成功、无法激活此功能，请插入SIM卡后再试。"); 
  }
  
  public static void clearSmsInfos() {
    sSmsInfos = null;
  }
  
  public static void clearUPConsumeid() {
    upconsumeid = "";
  }
  
  public static void clearUPointInfo() {
    sUPointInfo = null;
  }
  
  public static void clearUPointPayInfo() {
    sUPointPayInfo = null;
  }
  
  public static String convertStreamToString(InputStream paramInputStream) {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(paramInputStream));
    null = new StringBuilder();
    try {
      while (true) {
        String str = bufferedReader.readLine();
        if (str == null)
          return null.toString(); 
        null.append(str);
      } 
    } catch (IOException iOException1) {
      iOException1.printStackTrace();
      return null.toString();
    } finally {
      try {
        iOException.close();
      } catch (IOException iOException1) {
        iOException1.printStackTrace();
      } 
    } 
  }
  
  public static String createARanConsumeID(int paramInt) {
    for (String str = "";; str = String.valueOf(str) + getRan(10L)) {
      if (str.length() >= paramInt) {
        if (str.length() > paramInt)
          str.substring(0, paramInt); 
        return str;
      } 
    } 
  }
  
  public static String createARanSessionid(int paramInt) {
    long l2 = System.currentTimeMillis();
    long l1 = 1L;
    for (byte b = 0;; b++) {
      if (b >= paramInt) {
        for (String str = String.valueOf(getRan(l1));; str = String.valueOf(str) + getRan(10L)) {
          if (str.length() >= paramInt)
            return String.valueOf(l2) + str; 
        } 
        break;
      } 
      l1 *= 10L;
    } 
  }
  
  public static int dateDiffByDay(String paramString1, String paramString2, String paramString3) {
    byte b;
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(paramString3);
    try {
      long l = (simpleDateFormat.parse(paramString2).getTime() - simpleDateFormat.parse(paramString1).getTime()) / 86400000L;
      b = (int)l;
    } catch (Exception exception) {
      b = -1;
    } 
    return b;
  }
  
  public static TextView generateBorderView(Context paramContext) {
    TextView textView = new TextView(paramContext);
    textView.setBackgroundResource(17301524);
    return textView;
  }
  
  public static LinearLayout generateFooterView(Context paramContext) {
    LinearLayout linearLayout = new LinearLayout(paramContext);
    linearLayout.setOrientation(1);
    TextView textView2 = generateBorderView(paramContext);
    textView2.setLayoutParams((ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, 1));
    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
    TextView textView1 = new TextView(paramContext);
    textView1.setTextSize(16.0F);
    textView1.setGravity(17);
    textView1.setPadding(0, 20, 0, 20);
    textView1.setText("UC游戏-UC优视");
    textView1.setTextColor(-12303292);
    linearLayout.addView((View)textView2);
    linearLayout.addView((View)textView1, (ViewGroup.LayoutParams)layoutParams);
    return linearLayout;
  }
  
  public static void generateOrderId(PaymentInfo paramPaymentInfo) {
    String str1;
    String str2 = getIpAddress();
    try {
      StringBuilder stringBuilder = new StringBuilder();
      this(String.valueOf(URLEncoder.encode(paramPaymentInfo.getUsername(), "UTF-8")));
      str1 = stringBuilder.append(paramPaymentInfo.getAppkey()).append(URLEncoder.encode(paramPaymentInfo.getPayname(), "UTF-8")).append(System.currentTimeMillis()).append(str2).toString();
    } catch (UnsupportedEncodingException unsupportedEncodingException) {
      str1 = "";
    } 
    paramPaymentInfo.setOrderID(DigestUtils.md5Hex(str1));
  }
  
  public static String getAppkey(Context paramContext) throws PackageManager.NameNotFoundException {
    return (paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128)).metaData.get("ucgame_appkey").toString();
  }
  
  public static String getBodyString(int paramInt, HttpResponse paramHttpResponse) {
    ParseException parseException1;
    ParseException parseException2 = null;
    try {
      String str = EntityUtils.toString(paramHttpResponse.getEntity(), "UTF-8");
    } catch (ParseException null) {
      parseException1 = parseException2;
    } catch (IOException iOException) {
      parseException1 = parseException2;
    } 
    return (String)parseException1;
  }
  
  public static String getCpID(Context paramContext) throws PackageManager.NameNotFoundException {
    return (paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128)).metaData.get("ucgame_cpid").toString();
  }
  
  public static String getCurrentTime(boolean paramBoolean) {
    if (paramBoolean) {
      SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
      return simpleDateFormat1.format(new Date());
    } 
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    return simpleDateFormat.format(new Date());
  }
  
  public static double getDouble(String paramString) {
    return Double.parseDouble(paramString);
  }
  
  public static Drawable getDrawableFromFile(String paramString) {
    return Drawable.createFromStream(getFileStream(paramString), paramString);
  }
  
  private static InputStream getFileStream(String paramString) {
    return FileLoader.class.getResourceAsStream(paramString);
  }
  
  public static int getInt(int paramInt, String paramString) {
    return getInt(paramInt, paramString, 0);
  }
  
  public static int getInt(int paramInt1, String paramString, int paramInt2) {
    if (paramString == null)
      return paramInt2; 
    try {
      long l = Long.parseLong(paramString.trim(), paramInt1);
      paramInt1 = (int)l;
    } catch (NumberFormatException numberFormatException) {
      paramInt1 = paramInt2;
    } 
    return paramInt1;
  }
  
  public static int getInt(String paramString) {
    return getInt(10, paramString);
  }
  
  public static int getInt(String paramString, int paramInt) {
    return getInt(10, paramString, paramInt);
  }
  
  private static String getIpAddress() {
    try {
      Enumeration<NetworkInterface> enumeration = NetworkInterface.getNetworkInterfaces();
      while (true) {
        boolean bool = enumeration.hasMoreElements();
        if (bool) {
          Enumeration<InetAddress> enumeration1 = ((NetworkInterface)enumeration.nextElement()).getInetAddresses();
          while (enumeration1.hasMoreElements()) {
            InetAddress inetAddress = enumeration1.nextElement();
            if (!inetAddress.isLoopbackAddress())
              return inetAddress.getHostAddress(); 
          } 
          continue;
        } 
        String str1 = "";
        continue;
      } 
    } catch (SocketException socketException) {}
    String str = "";
    // Byte code: goto -> 18
  }
  
  public static long getLong(String paramString) {
    long l;
    if (paramString == null)
      return 0L; 
    try {
      l = Long.parseLong(paramString.trim());
    } catch (NumberFormatException numberFormatException) {
      l = 0L;
    } 
    return l;
  }
  
  public static PaymentInfo getPaymentInfo() {
    return sPaymentInfo;
  }
  
  public static String getQueryString(HashMap<String, Object> paramHashMap) {
    StringBuilder stringBuilder = new StringBuilder();
    Iterator<String> iterator = paramHashMap.keySet().iterator();
    while (true) {
      if (!iterator.hasNext())
        return stringBuilder.toString(); 
      String str = iterator.next();
      if (stringBuilder.length() < 1) {
        stringBuilder.append(String.valueOf(str) + "=");
      } else {
        stringBuilder.append("&" + str + "=");
      } 
      stringBuilder.append(paramHashMap.get(str));
    } 
  }
  
  private static long getRan(long paramLong) {
    if (rdm == null)
      rdm = new Random(); 
    return (rdm.nextLong() >>> 1L) % paramLong;
  }
  
  public static String getSessionID(Context paramContext) {
    sessionidstr = PrefUtil.getUserSession(paramContext);
    if (sessionidstr == null || sessionidstr.equals("")) {
      sessionidstr = createARanSessionid(8);
      PrefUtil.setUserSession(paramContext, sessionidstr);
      return sessionidstr;
    } 
    return sessionidstr;
  }
  
  public static String getSimNumber(Context paramContext) {
    return ((TelephonyManager)paramContext.getSystemService("phone")).getSubscriberId();
  }
  
  public static SmsInfos getSmsInfos() {
    return sSmsInfos;
  }
  
  public static int getSmsPayment() {
    return getPaymentInfo().getMoney() / 10;
  }
  
  private static String getTitleIconFileName(String paramString) {
    boolean bool = isHdpi();
    if ("back".equals(paramString))
      return bool ? "back_btn_hdpi.png" : "back_btn.png"; 
    if ("cancel".equals(paramString))
      return bool ? "cancel_btn_hdpi.png" : "cancel_btn.png"; 
    throw new IllegalArgumentException("type not supported.");
  }
  
  public static String getUPConsumeid(String paramString1, String paramString2, String paramString3) {
    if (upconsumeid == null || upconsumeid.equals(""))
      upconsumeid = String.valueOf(paramString2) + paramString3 + paramString1 + createARanConsumeID(10); 
    return upconsumeid;
  }
  
  public static UPointInfo getUPointInfo() {
    return sUPointInfo;
  }
  
  public static UPointPayInfo getUPointPayInfo() {
    return sUPointPayInfo;
  }
  
  public static byte[] getUTF8Bytes(String paramString) {
    byte[] arrayOfByte;
    if (paramString == null)
      return new byte[0]; 
    try {
      byte[] arrayOfByte1 = paramString.getBytes("UTF-8");
      arrayOfByte = arrayOfByte1;
    } catch (UnsupportedEncodingException unsupportedEncodingException) {}
    return arrayOfByte;
  }
  
  public static String getUTF8String(byte[] paramArrayOfbyte) {
    return (paramArrayOfbyte == null) ? "" : getUTF8String(paramArrayOfbyte, 0, paramArrayOfbyte.length);
  }
  
  public static String getUTF8String(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    String str;
    if (paramArrayOfbyte == null)
      return ""; 
    try {
      String str1 = new String();
      this(paramArrayOfbyte, paramInt1, paramInt2, "UTF-8");
      str = str1;
    } catch (UnsupportedEncodingException unsupportedEncodingException) {
      str = "";
    } 
    return str;
  }
  
  public static String getUserAgent(Context paramContext) {
    String str = "";
    PackageManager packageManager = paramContext.getPackageManager();
    try {
      String str1 = packageManager.getApplicationLabel(packageManager.getApplicationInfo(paramContext.getPackageName(), 128)).toString();
      str = str1;
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {}
    return "packageName=" + paramContext.getPackageName() + ",appName=" + str + ",channelID=1";
  }
  
  public static String getXmlFromFile(String paramString) throws IOException {
    return convertStreamToString(getFileStream(paramString));
  }
  
  public static String getXmlRequestBody(HashMap<String, Object> paramHashMap, Context paramContext) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("<request");
    if (paramHashMap.containsKey("local_version")) {
      stringBuilder.append(" local_version=\"" + paramHashMap.get("local_version") + "\" ");
      paramHashMap.remove("local_version");
    } 
    stringBuilder.append(">");
    Iterator<String> iterator = paramHashMap.keySet().iterator();
    while (true) {
      if (!iterator.hasNext()) {
        stringBuilder.append("</request>");
        return stringBuilder.toString();
      } 
      String str = iterator.next();
      stringBuilder.append("<").append(str).append(">");
      stringBuilder.append(paramHashMap.get(str));
      stringBuilder.append("</").append(str).append(">");
    } 
  }
  
  public static void init(Context paramContext) {
    try {
      ApplicationInfo applicationInfo = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128);
      try {
        if (applicationInfo.getClass().getField("targetSdkVersion").getInt(applicationInfo) < 4) {
          sIsHdpi = false;
          return;
        } 
      } catch (SecurityException securityException) {
        sIsHdpi = false;
        return;
      } catch (NoSuchFieldException noSuchFieldException) {
        sIsHdpi = false;
        return;
      } catch (IllegalArgumentException illegalArgumentException) {
        sIsHdpi = false;
        return;
      } catch (IllegalAccessException illegalAccessException) {}
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      sIsHdpi = false;
      return;
    } 
    sIsHdpi = false;
  }
  
  public static RelativeLayout initSubTitle(Context paramContext, View.OnClickListener paramOnClickListener, String paramString, boolean paramBoolean) {
    RelativeLayout relativeLayout = new RelativeLayout(paramContext);
    relativeLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    relativeLayout.setBackgroundDrawable((Drawable)new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[] { Constants.COLOR_SUBTITLE_BACKGROUND1, Constants.COLOR_SUBTITLE_BACKGROUND2 }));
    ImageView imageView1 = new ImageView(paramContext);
    imageView1.setImageDrawable(getDrawableFromFile(getTitleIconFileName("back")));
    imageView1.setId(9);
    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
    layoutParams2.addRule(9);
    layoutParams2.addRule(15);
    imageView1.setLayoutParams((ViewGroup.LayoutParams)layoutParams2);
    imageView1.setOnClickListener(paramOnClickListener);
    imageView1.setPadding(8, 0, 0, 0);
    ImageView imageView2 = new ImageView(paramContext);
    imageView2.setImageDrawable(getDrawableFromFile(getTitleIconFileName("cancel")));
    imageView2.setId(10);
    RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
    layoutParams3.addRule(11);
    layoutParams3.addRule(15);
    imageView2.setLayoutParams((ViewGroup.LayoutParams)layoutParams3);
    imageView2.setOnClickListener(paramOnClickListener);
    imageView2.setPadding(0, 0, 10, 0);
    TextView textView = new TextView(paramContext);
    textView.setGravity(17);
    textView.setTextColor(Constants.COLOR_TITLE_BACKGROUND);
    textView.setPadding(0, 10, 0, 10);
    textView.setTextSize(23.0F);
    textView.setText(paramString);
    RelativeLayout.LayoutParams layoutParams1 = new RelativeLayout.LayoutParams(-2, -2);
    layoutParams1.addRule(14);
    textView.setLayoutParams((ViewGroup.LayoutParams)layoutParams1);
    relativeLayout.addView((View)imageView1);
    relativeLayout.addView((View)textView);
    if (paramBoolean)
      relativeLayout.addView((View)imageView2); 
    return relativeLayout;
  }
  
  public static void initTitleBar(Activity paramActivity) {
    View view = paramActivity.getWindow().findViewById(16908310);
    if (view != null) {
      if (view instanceof TextView)
        ((TextView)view).setTextSize(13.0F); 
      ViewParent viewParent = view.getParent();
      if (viewParent != null && viewParent instanceof View)
        ((View)viewParent).setBackgroundColor(134875644); 
    } 
    paramActivity.setTitle("UC支付");
  }
  
  public static boolean isAirMode(Context paramContext) {
    try {
      int i = Settings.System.getInt(paramContext.getContentResolver(), "airplane_mode_on");
      if (i == 1)
        return true; 
    } catch (android.provider.Settings.SettingNotFoundException settingNotFoundException) {}
    return false;
  }
  
  public static boolean isHdpi() {
    return sIsHdpi;
  }
  
  public static boolean isNumeric(String paramString) {
    return Pattern.compile("[0-9]*").matcher(paramString).matches();
  }
  
  public static void loadFile(String paramString1, String paramString2) throws IOException, FileNotFoundException {
    InputStream inputStream = getFileStream(paramString1);
    File file = new File(paramString2);
    file.createNewFile();
    FileOutputStream fileOutputStream = new FileOutputStream(file);
    byte[] arrayOfByte = new byte[1024];
    while (true) {
      int i = inputStream.read(arrayOfByte);
      if (i <= 0) {
        fileOutputStream.close();
        inputStream.close();
        return;
      } 
      fileOutputStream.write(arrayOfByte, 0, i);
    } 
  }
  
  public static void setPaymentInfo(PaymentInfo paramPaymentInfo) {
    sPaymentInfo = paramPaymentInfo;
  }
  
  public static void setSmsInfo(SmsInfos paramSmsInfos) {
    sSmsInfos = paramSmsInfos;
  }
  
  public static void setUPointInfo(UPointInfo paramUPointInfo) {
    sUPointInfo = paramUPointInfo;
  }
  
  public static void setUPointPayInfo(UPointPayInfo paramUPointPayInfo) {
    sUPointPayInfo = paramUPointPayInfo;
  }
  
  public static void writeSmsInfoPayment(Context paramContext, String paramString) {
    try {
      StringBuilder stringBuilder1 = new StringBuilder();
      this(String.valueOf(System.currentTimeMillis()));
      String str = stringBuilder1.toString();
      BufferedWriter bufferedWriter = new BufferedWriter();
      FileWriter fileWriter = new FileWriter();
      StringBuilder stringBuilder2 = new StringBuilder();
      this(String.valueOf(paramContext.getFilesDir().getAbsolutePath()));
      this(stringBuilder2.append("/").append(str).append(".smspayment").toString());
      this(fileWriter);
      bufferedWriter.write(paramString.toString());
      bufferedWriter.flush();
      bufferedWriter.close();
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
  }
}


/* Location:              /Users/thanh0x/DevTools0x/Rb2.0vip-dex2jar.jar!/com/uc/paymentsdk/util/Utils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */