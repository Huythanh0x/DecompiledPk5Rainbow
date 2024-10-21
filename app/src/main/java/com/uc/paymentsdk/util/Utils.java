package com.uc.paymentsdk.util;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
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
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
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

   public Utils() {
      super();
   }

   public static void CheckSimCardSupprotInfo(Context var0) throws SimCardNotSupportException {
      if (isAirMode(var0)) {
         throw new SimCardNotSupportException("\u5f53\u524d\u624b\u673a\u8bbe\u7f6e\u4e3a\u98de\u884c\u6a21\u5f0f\uff0c\u4e0d\u80fd\u53d1\u9001\u77ed\u4fe1\u3002");
      } else if (5 != ((TelephonyManager)var0.getSystemService("phone")).getSimState()) {
         throw new SimCardNotSupportException("\u5bf9\u4e0d\u8d77\uff0c\u77ed\u4fe1\u53d1\u9001\u4e0d\u6210\u529f\u3001\u65e0\u6cd5\u6fc0\u6d3b\u6b64\u529f\u80fd\uff0c\u8bf7\u63d2\u5165SIM\u5361\u540e\u518d\u8bd5\u3002");
      }
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

   public static String convertStreamToString(InputStream param0) {
      // $FF: Couldn't be decompiled
   }

   public static String createARanConsumeID(int var0) {
      String var1;
      for(var1 = ""; var1.length() < var0; var1 = var1 + getRan(10L)) {
      }

      if (var1.length() > var0) {
         var1.substring(0, var0);
      }

      return var1;
   }

   public static String createARanSessionid(int var0) {
      long var4 = System.currentTimeMillis();
      long var2 = 1L;

      for(int var1 = 0; var1 < var0; ++var1) {
         var2 *= 10L;
      }

      String var6;
      for(var6 = String.valueOf(getRan(var2)); var6.length() < var0; var6 = var6 + getRan(10L)) {
      }

      return var4 + var6;
   }

   public static int dateDiffByDay(String var0, String var1, String var2) {
      SimpleDateFormat var7 = new SimpleDateFormat(var2);

      int var3;
      long var4;
      try {
         var4 = (var7.parse(var1).getTime() - var7.parse(var0).getTime()) / 86400000L;
      } catch (Exception var6) {
         var3 = -1;
         return var3;
      }

      var3 = (int)var4;
      return var3;
   }

   public static TextView generateBorderView(Context var0) {
      TextView var1 = new TextView(var0);
      var1.setBackgroundResource(17301524);
      return var1;
   }

   public static LinearLayout generateFooterView(Context var0) {
      LinearLayout var1 = new LinearLayout(var0);
      var1.setOrientation(1);
      TextView var2 = generateBorderView(var0);
      var2.setLayoutParams(new LinearLayout.LayoutParams(-1, 1));
      LinearLayout.LayoutParams var3 = new LinearLayout.LayoutParams(-1, -2);
      TextView var4 = new TextView(var0);
      var4.setTextSize(16.0F);
      var4.setGravity(17);
      var4.setPadding(0, 20, 0, 20);
      var4.setText("UC\u6e38\u620f-UC\u4f18\u89c6");
      var4.setTextColor(-12303292);
      var1.addView(var2);
      var1.addView(var4, var3);
      return var1;
   }

   public static void generateOrderId(PaymentInfo var0) {
      String var2 = getIpAddress();

      String var1;
      try {
         StringBuilder var4 = new StringBuilder(String.valueOf(URLEncoder.encode(var0.getUsername(), "UTF-8")));
         var1 = var4.append(var0.getAppkey()).append(URLEncoder.encode(var0.getPayname(), "UTF-8")).append(System.currentTimeMillis()).append(var2).toString();
      } catch (UnsupportedEncodingException var3) {
         var1 = "";
      }

      var0.setOrderID(DigestUtils.md5Hex(var1));
   }

   public static String getAppkey(Context var0) throws PackageManager.NameNotFoundException {
      return var0.getPackageManager().getApplicationInfo(var0.getPackageName(), 128).metaData.get("ucgame_appkey").toString();
   }

   public static String getBodyString(int var0, HttpResponse var1) {
      Object var2 = null;

      String var5;
      try {
         var5 = EntityUtils.toString(var1.getEntity(), "UTF-8");
      } catch (ParseException var3) {
         var5 = (String)var2;
      } catch (IOException var4) {
         var5 = (String)var2;
      }

      return var5;
   }

   public static String getCpID(Context var0) throws PackageManager.NameNotFoundException {
      return var0.getPackageManager().getApplicationInfo(var0.getPackageName(), 128).metaData.get("ucgame_cpid").toString();
   }

   public static String getCurrentTime(boolean var0) {
      SimpleDateFormat var1;
      if (var0) {
         var1 = new SimpleDateFormat("yyyy-MM-dd");
      } else {
         var1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
      }

      return var1.format(new Date());
   }

   public static double getDouble(String var0) {
      return Double.parseDouble(var0);
   }

   public static Drawable getDrawableFromFile(String var0) {
      return Drawable.createFromStream(getFileStream(var0), var0);
   }

   private static InputStream getFileStream(String var0) {
      return FileLoader.class.getResourceAsStream(var0);
   }

   public static int getInt(int var0, String var1) {
      return getInt(var0, var1, 0);
   }

   public static int getInt(int var0, String var1, int var2) {
      if (var1 == null) {
         var0 = var2;
      } else {
         long var3;
         try {
            var3 = Long.parseLong(var1.trim(), var0);
         } catch (NumberFormatException var5) {
            var0 = var2;
            return var0;
         }

         var0 = (int)var3;
      }

      return var0;
   }

   public static int getInt(String var0) {
      return getInt(10, var0);
   }

   public static int getInt(String var0, int var1) {
      return getInt(10, var0, var1);
   }

   private static String getIpAddress() {
      // $FF: Couldn't be decompiled
   }

   public static long getLong(String var0) {
      long var1;
      if (var0 == null) {
         var1 = 0L;
      } else {
         try {
            var1 = Long.parseLong(var0.trim());
         } catch (NumberFormatException var3) {
            var1 = 0L;
         }
      }

      return var1;
   }

   public static PaymentInfo getPaymentInfo() {
      return sPaymentInfo;
   }

   public static String getQueryString(HashMap var0) {
      StringBuilder var2 = new StringBuilder();

      String var1;
      for(Iterator var3 = var0.keySet().iterator(); var3.hasNext(); var2.append(var0.get(var1))) {
         var1 = (String)var3.next();
         if (var2.length() < 1) {
            var2.append(var1 + "=");
         } else {
            var2.append("&" + var1 + "=");
         }
      }

      return var2.toString();
   }

   private static long getRan(long var0) {
      if (rdm == null) {
         rdm = new Random();
      }

      return (rdm.nextLong() >>> 1) % var0;
   }

   public static String getSessionID(Context var0) {
      sessionidstr = PrefUtil.getUserSession(var0);
      String var1;
      if (sessionidstr != null && !sessionidstr.equals("")) {
         var1 = sessionidstr;
      } else {
         sessionidstr = createARanSessionid(8);
         PrefUtil.setUserSession(var0, sessionidstr);
         var1 = sessionidstr;
      }

      return var1;
   }

   public static String getSimNumber(Context var0) {
      return ((TelephonyManager)var0.getSystemService("phone")).getSubscriberId();
   }

   public static SmsInfos getSmsInfos() {
      return sSmsInfos;
   }

   public static int getSmsPayment() {
      return getPaymentInfo().getMoney() / 10;
   }

   private static String getTitleIconFileName(String var0) {
      boolean var1 = isHdpi();
      if ("back".equals(var0)) {
         if (var1) {
            var0 = "back_btn_hdpi.png";
         } else {
            var0 = "back_btn.png";
         }
      } else {
         if (!"cancel".equals(var0)) {
            throw new IllegalArgumentException("type not supported.");
         }

         if (var1) {
            var0 = "cancel_btn_hdpi.png";
         } else {
            var0 = "cancel_btn.png";
         }
      }

      return var0;
   }

   public static String getUPConsumeid(String var0, String var1, String var2) {
      if (upconsumeid == null || upconsumeid.equals("")) {
         upconsumeid = var1 + var2 + var0 + createARanConsumeID(10);
      }

      return upconsumeid;
   }

   public static UPointInfo getUPointInfo() {
      return sUPointInfo;
   }

   public static UPointPayInfo getUPointPayInfo() {
      return sUPointPayInfo;
   }

   public static byte[] getUTF8Bytes(String var0) {
      byte[] var6;
      if (var0 == null) {
         var6 = new byte[0];
      } else {
         byte[] var1;
         try {
            var1 = var0.getBytes("UTF-8");
         } catch (UnsupportedEncodingException var5) {
            try {
               ByteArrayOutputStream var3 = new ByteArrayOutputStream();
               DataOutputStream var2 = new DataOutputStream(var3);
               var2.writeUTF(var0);
               var1 = var3.toByteArray();
               var3.close();
               var2.close();
               var6 = new byte[var1.length - 2];
               System.arraycopy(var1, 2, var6, 0, var6.length);
            } catch (IOException var4) {
               var6 = new byte[0];
            }

            return var6;
         }

         var6 = var1;
      }

      return var6;
   }

   public static String getUTF8String(byte[] var0) {
      String var1;
      if (var0 == null) {
         var1 = "";
      } else {
         var1 = getUTF8String(var0, 0, var0.length);
      }

      return var1;
   }

   public static String getUTF8String(byte[] var0, int var1, int var2) {
      String var5;
      if (var0 == null) {
         var5 = "";
      } else {
         String var3;
         try {
            var3 = new String(var0, var1, var2, "UTF-8");
         } catch (UnsupportedEncodingException var4) {
            var5 = "";
            return var5;
         }

         var5 = var3;
      }

      return var5;
   }

   public static String getUserAgent(Context var0) {
      String var1 = "";
      PackageManager var2 = var0.getPackageManager();

      String var4;
      try {
         var4 = var2.getApplicationLabel(var2.getApplicationInfo(var0.getPackageName(), 128)).toString();
      } catch (PackageManager.NameNotFoundException var3) {
         return "packageName=" + var0.getPackageName() + ",appName=" + var1 + ",channelID=1";
      }

      var1 = var4;
      return "packageName=" + var0.getPackageName() + ",appName=" + var1 + ",channelID=1";
   }

   public static String getXmlFromFile(String var0) throws IOException {
      return convertStreamToString(getFileStream(var0));
   }

   public static String getXmlRequestBody(HashMap var0, Context var1) {
      StringBuilder var4 = new StringBuilder();
      var4.append("<request");
      if (var0.containsKey("local_version")) {
         var4.append(" local_version=\"" + var0.get("local_version") + "\" ");
         var0.remove("local_version");
      }

      var4.append(">");
      Iterator var3 = var0.keySet().iterator();

      while(var3.hasNext()) {
         String var2 = (String)var3.next();
         var4.append("<").append(var2).append(">");
         var4.append(var0.get(var2));
         var4.append("</").append(var2).append(">");
      }

      var4.append("</request>");
      return var4.toString();
   }

   public static void init(Context var0) {
      try {
         ApplicationInfo var2 = var0.getPackageManager().getApplicationInfo(var0.getPackageName(), 128);

         try {
            if (var2.getClass().getField("targetSdkVersion").getInt(var2) < 4) {
               sIsHdpi = false;
               return;
            }
         } catch (SecurityException var3) {
            sIsHdpi = false;
            return;
         } catch (NoSuchFieldException var4) {
            sIsHdpi = false;
            return;
         } catch (IllegalArgumentException var5) {
            sIsHdpi = false;
            return;
         } catch (IllegalAccessException var6) {
            sIsHdpi = false;
            return;
         }
      } catch (PackageManager.NameNotFoundException var7) {
         sIsHdpi = false;
         return;
      }

      WindowManager var8 = (WindowManager)var0.getSystemService("window");
      DisplayMetrics var9 = new DisplayMetrics();
      var8.getDefaultDisplay().getMetrics((DisplayMetrics)var9);
      boolean var1;
      if ((double)((DisplayMetrics)var9).density > 1.0) {
         var1 = true;
      } else {
         var1 = false;
      }

      sIsHdpi = var1;
   }

   public static RelativeLayout initSubTitle(Context var0, View.OnClickListener var1, String var2, boolean var3) {
      RelativeLayout var4 = new RelativeLayout(var0);
      var4.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
      var4.setBackgroundDrawable(new GradientDrawable(Orientation.TOP_BOTTOM, new int[]{Constants.COLOR_SUBTITLE_BACKGROUND1, Constants.COLOR_SUBTITLE_BACKGROUND2}));
      ImageView var5 = new ImageView(var0);
      var5.setImageDrawable(getDrawableFromFile(getTitleIconFileName("back")));
      var5.setId(9);
      RelativeLayout.LayoutParams var6 = new RelativeLayout.LayoutParams(-2, -2);
      var6.addRule(9);
      var6.addRule(15);
      var5.setLayoutParams(var6);
      var5.setOnClickListener(var1);
      var5.setPadding(8, 0, 0, 0);
      ImageView var10 = new ImageView(var0);
      var10.setImageDrawable(getDrawableFromFile(getTitleIconFileName("cancel")));
      var10.setId(10);
      RelativeLayout.LayoutParams var7 = new RelativeLayout.LayoutParams(-2, -2);
      var7.addRule(11);
      var7.addRule(15);
      var10.setLayoutParams(var7);
      var10.setOnClickListener(var1);
      var10.setPadding(0, 0, 10, 0);
      TextView var8 = new TextView(var0);
      var8.setGravity(17);
      var8.setTextColor(Constants.COLOR_TITLE_BACKGROUND);
      var8.setPadding(0, 10, 0, 10);
      var8.setTextSize(23.0F);
      var8.setText(var2);
      RelativeLayout.LayoutParams var9 = new RelativeLayout.LayoutParams(-2, -2);
      var9.addRule(14);
      var8.setLayoutParams(var9);
      var4.addView(var5);
      var4.addView(var8);
      if (var3) {
         var4.addView(var10);
      }

      return var4;
   }

   public static void initTitleBar(Activity var0) {
      View var1 = var0.getWindow().findViewById(16908310);
      if (var1 != null) {
         if (var1 instanceof TextView) {
            ((TextView)var1).setTextSize(13.0F);
         }

         ViewParent var2 = var1.getParent();
         if (var2 != null && var2 instanceof View) {
            ((View)var2).setBackgroundColor(134875644);
         }
      }

      var0.setTitle("UC\u652f\u4ed8");
   }

   public static boolean isAirMode(Context var0) {
      boolean var2;
      label16: {
         int var1;
         try {
            var1 = android.provider.Settings.System.getInt(var0.getContentResolver(), "airplane_mode_on");
         } catch (Settings.SettingNotFoundException var3) {
            break label16;
         }

         if (var1 == 1) {
            var2 = true;
            return var2;
         }
      }

      var2 = false;
      return var2;
   }

   public static boolean isHdpi() {
      return sIsHdpi;
   }

   public static boolean isNumeric(String var0) {
      return Pattern.compile("[0-9]*").matcher(var0).matches();
   }

   public static void loadFile(String var0, String var1) throws IOException, FileNotFoundException {
      InputStream var4 = getFileStream(var0);
      File var5 = new File(var1);
      var5.createNewFile();
      FileOutputStream var6 = new FileOutputStream(var5);
      byte[] var3 = new byte[1024];

      while(true) {
         int var2 = var4.read(var3);
         if (var2 <= 0) {
            var6.close();
            var4.close();
            return;
         }

         var6.write(var3, 0, var2);
      }
   }

   public static void setPaymentInfo(PaymentInfo var0) {
      sPaymentInfo = var0;
   }

   public static void setSmsInfo(SmsInfos var0) {
      sSmsInfos = var0;
   }

   public static void setUPointInfo(UPointInfo var0) {
      sUPointInfo = var0;
   }

   public static void setUPointPayInfo(UPointPayInfo var0) {
      sUPointPayInfo = var0;
   }

   public static void writeSmsInfoPayment(Context var0, String var1) {
      try {
         StringBuilder var2 = new StringBuilder(String.valueOf(System.currentTimeMillis()));
         String var7 = var2.toString();
         StringBuilder var4 = new StringBuilder(String.valueOf(var0.getFilesDir().getAbsolutePath()));
         FileWriter var3 = new FileWriter(var4.append("/").append(var7).append(".smspayment").toString());
         BufferedWriter var5 = new BufferedWriter(var3);
         var5.write(var1.toString());
         var5.flush();
         var5.close();
      } catch (Exception var6) {
         var6.printStackTrace();
      }

   }
}
