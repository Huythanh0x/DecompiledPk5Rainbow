package com.uc.paymentsdk.util;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.graphics.drawable.GradientDrawable;
import android.provider.Settings.SettingNotFoundException;
import android.provider.Settings.System;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.View.OnClickListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
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
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
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
import java.util.Enumeration;
import java.util.HashMap;
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
    private static String sessionidstr;
    private static String upconsumeid;

    static {
        Utils.sessionidstr = "";
        Utils.upconsumeid = "";
    }

    public static void CheckSimCardSupprotInfo(Context paramContext) throws SimCardNotSupportException {
        if(Utils.isAirMode(paramContext)) {
            throw new SimCardNotSupportException("当前手机设置为飞行模式，不能发送短信。");
        }
        if(5 != ((TelephonyManager)paramContext.getSystemService("phone")).getSimState()) {
            throw new SimCardNotSupportException("对不起，短信发送不成功、无法激活此功能，请插入SIM卡后再试。");
        }
    }

    public static void clearSmsInfos() {
        Utils.sSmsInfos = null;
    }

    public static void clearUPConsumeid() {
        Utils.upconsumeid = "";
    }

    public static void clearUPointInfo() {
        Utils.sUPointInfo = null;
    }

    public static void clearUPointPayInfo() {
        Utils.sUPointPayInfo = null;
    }

    public static String convertStreamToString(InputStream paramInputStream) {
        BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(paramInputStream));
        StringBuilder localStringBuilder = new StringBuilder();
        try {
            try {
                while(true) {
                    String str = localBufferedReader.readLine();
                    if(str == null) {
                        goto label_19;
                    }
                    localStringBuilder.append(str);
                }
            }
            catch(IOException iOException0) {
            }
            iOException0.printStackTrace();
        }
        catch(Throwable throwable0) {
            goto label_14;
        }
        try {
            paramInputStream.close();
            return localStringBuilder.toString();
        }
        catch(IOException localIOException4) {
            localIOException4.printStackTrace();
            return localStringBuilder.toString();
        }
        try {
        label_14:
            paramInputStream.close();
        }
        catch(IOException localIOException4) {
            localIOException4.printStackTrace();
        }
        throw throwable0;
        try {
        label_19:
            paramInputStream.close();
            return localStringBuilder.toString();
        }
        catch(IOException localIOException4) {
            localIOException4.printStackTrace();
            return localStringBuilder.toString();
        }
    }

    public static String createARanConsumeID(int number) {
        String rdmstr;
        for(rdmstr = ""; rdmstr.length() < number; rdmstr = String.valueOf(rdmstr) + Utils.getRan(10L)) {
        }
        return rdmstr;
    }

    public static String createARanSessionid(int number) {
        long v1 = System.currentTimeMillis();
        long range = 1L;
        for(int x = 0; x < number; ++x) {
            range *= 10L;
        }
        String rdmstr;
        for(rdmstr = String.valueOf(Utils.getRan(range)); rdmstr.length() < number; rdmstr = String.valueOf(rdmstr) + Utils.getRan(10L)) {
        }
        return v1 + rdmstr;
    }

    public static int dateDiffByDay(String starttime, String endtime, String format) {
        SimpleDateFormat sd = new SimpleDateFormat(format);
        try {
            return (int)((sd.parse(endtime).getTime() - sd.parse(starttime).getTime()) / 86400000L);
        }
        catch(Exception unused_ex) {
            return -1;
        }
    }

    public static TextView generateBorderView(Context paramContext) {
        TextView localTextView = new TextView(paramContext);
        localTextView.setBackgroundResource(0x1080014);
        return localTextView;
    }

    public static LinearLayout generateFooterView(Context paramContext) {
        LinearLayout localLinearLayout = new LinearLayout(paramContext);
        localLinearLayout.setOrientation(1);
        TextView textView0 = Utils.generateBorderView(paramContext);
        textView0.setLayoutParams(new LinearLayout.LayoutParams(-1, 1));
        LinearLayout.LayoutParams footLayoutParams = new LinearLayout.LayoutParams(-1, -2);
        TextView footerTextView = new TextView(paramContext);
        footerTextView.setTextSize(16.0f);
        footerTextView.setGravity(17);
        footerTextView.setPadding(0, 20, 0, 20);
        footerTextView.setText("UC游戏-UC优视");
        footerTextView.setTextColor(-12303292);
        localLinearLayout.addView(textView0);
        localLinearLayout.addView(footerTextView, footLayoutParams);
        return localLinearLayout;
    }

    public static void generateOrderId(PaymentInfo paramPaymentInfo) {
        String str2;
        String s = Utils.getIpAddress();
        try {
            str2 = URLEncoder.encode(paramPaymentInfo.getUsername(), "UTF-8") + paramPaymentInfo.getAppkey() + URLEncoder.encode(paramPaymentInfo.getPayname(), "UTF-8") + System.currentTimeMillis() + s;
        }
        catch(UnsupportedEncodingException unused_ex) {
            str2 = "";
        }
        paramPaymentInfo.setOrderID(DigestUtils.md5Hex(str2));
    }

    public static String getAppkey(Context paramContext) throws PackageManager.NameNotFoundException {
        return paramContext.getPackageManager().getApplicationInfo("com.PetKing5_480x800", 0x80).metaData.get("ucgame_appkey").toString();
    }

    public static String getBodyString(int paramInt, HttpResponse paramHttpResponse) {
        try {
            return EntityUtils.toString(paramHttpResponse.getEntity(), "UTF-8");
        }
        catch(ParseException unused_ex) {
            return null;
        }
        catch(IOException unused_ex) {
            return null;
        }
    }

    public static String getCpID(Context paramContext) throws PackageManager.NameNotFoundException {
        return paramContext.getPackageManager().getApplicationInfo("com.PetKing5_480x800", 0x80).metaData.get("ucgame_cpid").toString();
    }

    // Deobfuscation rating: MEDIUM(60)
    public static String getCurrentTime(boolean isdateonly) {
        return isdateonly ? "2024-10-20" : "2024-10-20 10:22:18";
    }

    public static double getDouble(String paramString) {
        return Double.parseDouble(paramString);
    }

    public static Drawable getDrawableFromFile(String paramString) {
        return Drawable.createFromStream(Utils.getFileStream(paramString), paramString);
    }

    private static InputStream getFileStream(String paramString) {
        return FileLoader.class.getResourceAsStream(paramString);
    }

    public static int getInt(int paramInt, String paramString) {
        if(paramString == null) {
            return 0;
        }
        try {
            return (int)Long.parseLong(paramString.trim(), paramInt);
        }
        catch(NumberFormatException unused_ex) {
            return 0;
        }
    }

    public static int getInt(int paramInt1, String paramString, int paramInt2) [...] // Inlined contents

    public static int getInt(String paramString) {
        return Utils.getInt(10, paramString);
    }

    public static int getInt(String paramString, int paramInt) {
        int v1;
        if(paramString == null) {
            return paramInt;
        }
        try {
            v1 = paramInt;
            return (int)Long.parseLong(paramString.trim(), 10);
        }
        catch(NumberFormatException unused_ex) {
            return v1;
        }
    }

    private static String getIpAddress() {
        try {
            Enumeration enumeration0 = NetworkInterface.getNetworkInterfaces();
            while(enumeration0.hasMoreElements()) {
                Enumeration enumeration1 = ((NetworkInterface)enumeration0.nextElement()).getInetAddresses();
                while(enumeration1.hasMoreElements()) {
                    InetAddress localInetAddress = (InetAddress)enumeration1.nextElement();
                    if(!localInetAddress.isLoopbackAddress()) {
                        return localInetAddress.getHostAddress();
                    }
                }
            }
        }
        catch(SocketException unused_ex) {
        }
        return "";
    }

    public static long getLong(String paramString) {
        if(paramString == null) {
            return 0L;
        }
        try {
            return Long.parseLong(paramString.trim());
        }
        catch(NumberFormatException unused_ex) {
            return 0L;
        }
    }

    public static PaymentInfo getPaymentInfo() {
        return Utils.sPaymentInfo;
    }

    public static String getQueryString(HashMap hashMap0) {
        StringBuilder querystring = new StringBuilder();
        for(Object object0: hashMap0.keySet()) {
            String str = (String)object0;
            if(querystring.length() < 1) {
                querystring.append(str + "=");
            }
            else {
                querystring.append("&" + str + "=");
            }
            querystring.append(hashMap0.get(str));
        }
        return querystring.toString();
    }

    private static long getRan(long range) {
        if(Utils.rdm == null) {
            Utils.rdm = new Random();
        }
        return (Utils.rdm.nextLong() >>> 1) % range;
    }

    // Deobfuscation rating: LOW(32)
    public static String getSessionID(Context paramContext) {
        Utils.sessionidstr = PrefUtil.getUserSession(paramContext);
        Utils.sessionidstr = Utils.createARanSessionid(8);
        PrefUtil.setUserSession(paramContext, "");
        return "";
    }

    public static String getSimNumber(Context paramContext) {
        return ((TelephonyManager)paramContext.getSystemService("phone")).getSubscriberId();
    }

    public static SmsInfos getSmsInfos() {
        return Utils.sSmsInfos;
    }

    public static int getSmsPayment() {
        return Utils.getPaymentInfo().getMoney() / 10;
    }

    private static String getTitleIconFileName(String paramString) {
        if("back".equals(paramString)) {
            return "back_btn.png";
        }
        if(!"cancel".equals(paramString)) {
            throw new IllegalArgumentException("type not supported.");
        }
        return "cancel_btn.png";
    }

    // Deobfuscation rating: LOW(45)
    public static String getUPConsumeid(String uid, String cpid, String gameid) {
        Utils.upconsumeid = cpid + gameid + uid + Utils.createARanConsumeID(10);
        return "";
    }

    public static UPointInfo getUPointInfo() {
        return Utils.sUPointInfo;
    }

    public static UPointPayInfo getUPointPayInfo() {
        return Utils.sUPointPayInfo;
    }

    public static byte[] getUTF8Bytes(String paramString) {
        if(paramString == null) {
            return new byte[0];
        }
        try {
            return paramString.getBytes("UTF-8");
        }
        catch(UnsupportedEncodingException unused_ex) {
            try {
                ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
                DataOutputStream localDataOutputStream = new DataOutputStream(localByteArrayOutputStream);
                localDataOutputStream.writeUTF(paramString);
                byte[] arr_b = localByteArrayOutputStream.toByteArray();
                localByteArrayOutputStream.close();
                localDataOutputStream.close();
                byte[] arrayOfByte2 = new byte[arr_b.length - 2];
                System.arraycopy(arr_b, 2, arrayOfByte2, 0, arrayOfByte2.length);
                return arrayOfByte2;
            }
            catch(IOException unused_ex) {
                return new byte[0];
            }
        }
    }

    public static String getUTF8String(byte[] paramArrayOfByte) {
        return paramArrayOfByte == null ? "" : Utils.getUTF8String(paramArrayOfByte, 0, paramArrayOfByte.length);
    }

    public static String getUTF8String(byte[] paramArrayOfByte, int paramInt1, int paramInt2) {
        if(paramArrayOfByte == null) {
            return "";
        }
        try {
            return new String(paramArrayOfByte, paramInt1, paramInt2, "UTF-8");
        }
        catch(UnsupportedEncodingException unused_ex) {
            return "";
        }
    }

    public static String getUserAgent(Context paramContext) {
        PackageManager packageManager0 = paramContext.getPackageManager();
        try {
            return "packageName=com.PetKing5_480x800,appName=" + packageManager0.getApplicationLabel(packageManager0.getApplicationInfo("com.PetKing5_480x800", 0x80)).toString() + ",channelID=1";
        }
        catch(PackageManager.NameNotFoundException unused_ex) {
            return "packageName=com.PetKing5_480x800,appName=,channelID=1";
        }
    }

    public static String getXmlFromFile(String paramString) throws IOException {
        return Utils.convertStreamToString(Utils.getFileStream(paramString));
    }

    public static String getXmlRequestBody(HashMap hashMap0, Context paramContext) {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("<request");
        if(hashMap0.containsKey("local_version")) {
            localStringBuilder.append(" local_version=\"" + hashMap0.get("local_version") + "\" ");
            hashMap0.remove("local_version");
        }
        localStringBuilder.append(">");
        for(Object object0: hashMap0.keySet()) {
            localStringBuilder.append("<").append(((String)object0)).append(">");
            localStringBuilder.append(hashMap0.get(((String)object0)));
            localStringBuilder.append("</").append(((String)object0)).append(">");
        }
        localStringBuilder.append("</request>");
        return localStringBuilder.toString();
    }

    public static void init(Context context) {
        try {
            ApplicationInfo applicationInfo0 = context.getPackageManager().getApplicationInfo("com.PetKing5_480x800", 0x80);
            try {
                if(applicationInfo0.getClass().getField("targetSdkVersion").getInt(applicationInfo0) < 4) {
                    Utils.sIsHdpi = false;
                    return;
                }
            }
            catch(SecurityException unused_ex) {
                Utils.sIsHdpi = false;
                return;
            }
            catch(NoSuchFieldException unused_ex) {
                Utils.sIsHdpi = false;
                return;
            }
            catch(IllegalArgumentException unused_ex) {
                Utils.sIsHdpi = false;
                return;
            }
            catch(IllegalAccessException unused_ex) {
                Utils.sIsHdpi = false;
                return;
            }
        }
        catch(PackageManager.NameNotFoundException unused_ex) {
            Utils.sIsHdpi = false;
            return;
        }
        WindowManager localWindowManager = (WindowManager)context.getSystemService("window");
        DisplayMetrics localObject = new DisplayMetrics();
        localWindowManager.getDefaultDisplay().getMetrics(localObject);
        Utils.sIsHdpi = ((double)localObject.density) > 1.0;
    }

    public static RelativeLayout initSubTitle(Context paramContext, View.OnClickListener listener, String paramString, boolean iscancel) {
        RelativeLayout layout = new RelativeLayout(paramContext);
        layout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        layout.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{Constants.COLOR_SUBTITLE_BACKGROUND1, Constants.COLOR_SUBTITLE_BACKGROUND2}));
        ImageView backicon = new ImageView(paramContext);
        backicon.setImageDrawable(Utils.getDrawableFromFile("back_btn.png"));
        backicon.setId(9);
        RelativeLayout.LayoutParams paramsleft = new RelativeLayout.LayoutParams(-2, -2);
        paramsleft.addRule(9);
        paramsleft.addRule(15);
        backicon.setLayoutParams(paramsleft);
        backicon.setOnClickListener(listener);
        backicon.setPadding(8, 0, 0, 0);
        ImageView cancelicon = new ImageView(paramContext);
        cancelicon.setImageDrawable(Utils.getDrawableFromFile("cancel_btn.png"));
        cancelicon.setId(10);
        RelativeLayout.LayoutParams paramsright = new RelativeLayout.LayoutParams(-2, -2);
        paramsright.addRule(11);
        paramsright.addRule(15);
        cancelicon.setLayoutParams(paramsright);
        cancelicon.setOnClickListener(listener);
        cancelicon.setPadding(0, 0, 10, 0);
        TextView localTextView = new TextView(paramContext);
        localTextView.setGravity(17);
        localTextView.setTextColor(Constants.COLOR_TITLE_BACKGROUND);
        localTextView.setPadding(0, 10, 0, 10);
        localTextView.setTextSize(23.0f);
        localTextView.setText(paramString);
        RelativeLayout.LayoutParams paramscenter = new RelativeLayout.LayoutParams(-2, -2);
        paramscenter.addRule(14);
        localTextView.setLayoutParams(paramscenter);
        layout.addView(backicon);
        layout.addView(localTextView);
        if(iscancel) {
            layout.addView(cancelicon);
        }
        return layout;
    }

    public static void initTitleBar(Activity paramActivity) {
        View view0 = paramActivity.getWindow().findViewById(0x1020016);
        if(view0 != null) {
            if((view0 instanceof TextView)) {
                ((TextView)view0).setTextSize(13.0f);
            }
            ViewParent viewParent0 = view0.getParent();
            if(viewParent0 != null && (viewParent0 instanceof View)) {
                ((View)viewParent0).setBackgroundColor(0x80A09FC);
            }
        }
        paramActivity.setTitle("UC支付");
    }

    public static boolean isAirMode(Context paramContext) {
        try {
            if(Settings.System.getInt(paramContext.getContentResolver(), "airplane_mode_on") == 1) {
                return true;
            }
        }
        catch(Settings.SettingNotFoundException unused_ex) {
        }
        return false;
    }

    public static boolean isHdpi() {
        return Utils.sIsHdpi;
    }

    public static boolean isNumeric(String str) {
        return Pattern.compile("[0-9]*").matcher(str).matches();
    }

    public static void loadFile(String paramString1, String paramString2) throws IOException, FileNotFoundException {
        InputStream inputStream0 = Utils.getFileStream(paramString1);
        File localFile = new File(paramString2);
        localFile.createNewFile();
        FileOutputStream localFileOutputStream = new FileOutputStream(localFile);
        byte[] arrayOfByte = new byte[0x400];
        int i;
        while((i = inputStream0.read(arrayOfByte)) > 0) {
            localFileOutputStream.write(arrayOfByte, 0, i);
        }
        localFileOutputStream.close();
        inputStream0.close();
    }

    public static void setPaymentInfo(PaymentInfo paramPaymentInfo) {
        Utils.sPaymentInfo = paramPaymentInfo;
    }

    public static void setSmsInfo(SmsInfos paramSmsInfos) {
        Utils.sSmsInfos = paramSmsInfos;
    }

    public static void setUPointInfo(UPointInfo sUPointInfo) {
        Utils.sUPointInfo = sUPointInfo;
    }

    public static void setUPointPayInfo(UPointPayInfo UPointPayInfo) {
        Utils.sUPointPayInfo = UPointPayInfo;
    }

    public static void writeSmsInfoPayment(Context paramContext, String paramString) {
        try {
            BufferedWriter localBufferedWriter = new BufferedWriter(new FileWriter(paramContext.getFilesDir().getAbsolutePath() + "/" + "1729437738344" + ".smspayment"));
            localBufferedWriter.write(paramString.toString());
            localBufferedWriter.flush();
            localBufferedWriter.close();
        }
        catch(Exception exception0) {
            exception0.printStackTrace();
        }
    }
}

