package com.uc.paymentsdk.util;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
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
import java.lang.reflect.Field;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Random;
import java.util.regex.Pattern;
import javax.microedition.lcdui.game.GameCanvas;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.util.EntityUtils;
import res.FileLoader;

/* loaded from: classes.dex */
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

    public static int getInt(int paramInt1, String paramString, int paramInt2) {
        if (paramString == null) {
            return paramInt2;
        }
        try {
            return (int) Long.parseLong(paramString.trim(), paramInt1);
        } catch (NumberFormatException e) {
            return paramInt2;
        }
    }

    public static int getInt(int paramInt, String paramString) {
        return getInt(paramInt, paramString, 0);
    }

    public static int getInt(String paramString, int paramInt) {
        return getInt(10, paramString, paramInt);
    }

    public static int getInt(String paramString) {
        return getInt(10, paramString);
    }

    public static double getDouble(String paramString) {
        return Double.parseDouble(paramString);
    }

    public static long getLong(String paramString) {
        if (paramString == null) {
            return 0L;
        }
        try {
            return Long.parseLong(paramString.trim());
        } catch (NumberFormatException e) {
            return 0L;
        }
    }

    public static String getUTF8String(byte[] paramArrayOfByte) {
        return paramArrayOfByte == null ? "" : getUTF8String(paramArrayOfByte, 0, paramArrayOfByte.length);
    }

    public static String getUTF8String(byte[] paramArrayOfByte, int paramInt1, int paramInt2) {
        if (paramArrayOfByte == null) {
            return "";
        }
        try {
            return new String(paramArrayOfByte, paramInt1, paramInt2, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }

    public static byte[] getUTF8Bytes(String paramString) {
        if (paramString == null) {
            return new byte[0];
        }
        try {
            return paramString.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            try {
                ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
                DataOutputStream localDataOutputStream = new DataOutputStream(localByteArrayOutputStream);
                localDataOutputStream.writeUTF(paramString);
                byte[] arrayOfByte1 = localByteArrayOutputStream.toByteArray();
                localByteArrayOutputStream.close();
                localDataOutputStream.close();
                byte[] arrayOfByte2 = new byte[arrayOfByte1.length - 2];
                System.arraycopy(arrayOfByte1, 2, arrayOfByte2, 0, arrayOfByte2.length);
                return arrayOfByte2;
            } catch (IOException e2) {
                return new byte[0];
            }
        }
    }

    public static void initTitleBar(Activity paramActivity) {
        View localView1 = paramActivity.getWindow().findViewById(R.id.title);
        if (localView1 != null) {
            if (localView1 instanceof TextView) {
                ((TextView) localView1).setTextSize(13.0f);
            }
            Object parent = localView1.getParent();
            if (parent != null && (parent instanceof View)) {
                View localView2 = (View) parent;
                localView2.setBackgroundColor(134875644);
            }
        }
        paramActivity.setTitle("UC支付");
    }

    private static String getTitleIconFileName(String paramString) {
        boolean bool = isHdpi();
        if (TITLE_ICON_BACK.equals(paramString)) {
            if (bool) {
                return "back_btn_hdpi.png";
            }
            return "back_btn.png";
        }
        if (TITLE_ICON_CANCEL.equals(paramString)) {
            if (bool) {
                return "cancel_btn_hdpi.png";
            }
            return "cancel_btn.png";
        }
        throw new IllegalArgumentException(Constants.ERROR_TYPE_NOT_SUPPORTED);
    }

    public static RelativeLayout initSubTitle(Context paramContext, View.OnClickListener listener, String paramString, boolean iscancel) {
        RelativeLayout relativeLayout = new RelativeLayout(paramContext);
        relativeLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        GradientDrawable gb = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{Constants.COLOR_SUBTITLE_BACKGROUND1, Constants.COLOR_SUBTITLE_BACKGROUND2});
        relativeLayout.setBackgroundDrawable(gb);
        ImageView backicon = new ImageView(paramContext);
        backicon.setImageDrawable(getDrawableFromFile(getTitleIconFileName(TITLE_ICON_BACK)));
        backicon.setId(9);
        RelativeLayout.LayoutParams paramsleft = new RelativeLayout.LayoutParams(-2, -2);
        paramsleft.addRule(9);
        paramsleft.addRule(15);
        backicon.setLayoutParams(paramsleft);
        backicon.setOnClickListener(listener);
        backicon.setPadding(8, 0, 0, 0);
        ImageView cancelicon = new ImageView(paramContext);
        cancelicon.setImageDrawable(getDrawableFromFile(getTitleIconFileName(TITLE_ICON_CANCEL)));
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
        relativeLayout.addView(backicon);
        relativeLayout.addView(localTextView);
        if (iscancel) {
            relativeLayout.addView(cancelicon);
        }
        return relativeLayout;
    }

    public static String getAppkey(Context paramContext) throws PackageManager.NameNotFoundException {
        ApplicationInfo localApplicationInfo = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128);
        return localApplicationInfo.metaData.get(Constants.APPKEY).toString();
    }

    public static String getCpID(Context paramContext) throws PackageManager.NameNotFoundException {
        ApplicationInfo localApplicationInfo = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128);
        return localApplicationInfo.metaData.get(Constants.CPID).toString();
    }

    public static LinearLayout generateFooterView(Context paramContext) {
        LinearLayout localLinearLayout = new LinearLayout(paramContext);
        localLinearLayout.setOrientation(1);
        TextView lineTextView = generateBorderView(paramContext);
        LinearLayout.LayoutParams lineLayoutParams = new LinearLayout.LayoutParams(-1, 1);
        lineTextView.setLayoutParams(lineLayoutParams);
        LinearLayout.LayoutParams footLayoutParams = new LinearLayout.LayoutParams(-1, -2);
        TextView footerTextView = new TextView(paramContext);
        footerTextView.setTextSize(16.0f);
        footerTextView.setGravity(17);
        footerTextView.setPadding(0, 20, 0, 20);
        footerTextView.setText("UC游戏-UC优视");
        footerTextView.setTextColor(-12303292);
        localLinearLayout.addView(lineTextView);
        localLinearLayout.addView(footerTextView, footLayoutParams);
        return localLinearLayout;
    }

    public static PaymentInfo getPaymentInfo() {
        return sPaymentInfo;
    }

    public static void setPaymentInfo(PaymentInfo paramPaymentInfo) {
        sPaymentInfo = paramPaymentInfo;
    }

    private static InputStream getFileStream(String paramString) {
        return FileLoader.class.getResourceAsStream(paramString);
    }

    public static void loadFile(String paramString1, String paramString2) throws IOException, FileNotFoundException {
        InputStream localInputStream = getFileStream(paramString1);
        File localFile = new File(paramString2);
        localFile.createNewFile();
        FileOutputStream localFileOutputStream = new FileOutputStream(localFile);
        byte[] arrayOfByte = new byte[GameCanvas.GAME_B_PRESSED];
        while (true) {
            int i = localInputStream.read(arrayOfByte);
            if (i > 0) {
                localFileOutputStream.write(arrayOfByte, 0, i);
            } else {
                localFileOutputStream.close();
                localInputStream.close();
                return;
            }
        }
    }

    public static Drawable getDrawableFromFile(String paramString) {
        return Drawable.createFromStream(getFileStream(paramString), paramString);
    }

    public static String getXmlFromFile(String paramString) throws IOException {
        return convertStreamToString(getFileStream(paramString));
    }

    public static TextView generateBorderView(Context paramContext) {
        TextView localTextView = new TextView(paramContext);
        localTextView.setBackgroundResource(R.drawable.divider_horizontal_dark);
        return localTextView;
    }

    public static void generateOrderId(PaymentInfo paramPaymentInfo) {
        String str2;
        String str1 = getIpAddress();
        try {
            str2 = String.valueOf(URLEncoder.encode(paramPaymentInfo.getUsername(), "UTF-8")) + paramPaymentInfo.getAppkey() + URLEncoder.encode(paramPaymentInfo.getPayname(), "UTF-8") + System.currentTimeMillis() + str1;
        } catch (UnsupportedEncodingException e) {
            str2 = "";
        }
        paramPaymentInfo.setOrderID(DigestUtils.md5Hex(str2));
    }

    public static String getXmlRequestBody(HashMap<String, Object> paramHashMap, Context paramContext) {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("<request");
        if (paramHashMap.containsKey("local_version")) {
            localStringBuilder.append(" local_version=\"" + paramHashMap.get("local_version") + "\" ");
            paramHashMap.remove("local_version");
        }
        localStringBuilder.append(">");
        for (String str : paramHashMap.keySet()) {
            localStringBuilder.append("<").append(str).append(">");
            localStringBuilder.append(paramHashMap.get(str));
            localStringBuilder.append("</").append(str).append(">");
        }
        localStringBuilder.append("</request>");
        return localStringBuilder.toString();
    }

    public static String getQueryString(HashMap<String, Object> paramHashMap) {
        StringBuilder querystring = new StringBuilder();
        for (String str : paramHashMap.keySet()) {
            if (querystring.length() < 1) {
                querystring.append(String.valueOf(str) + "=");
            } else {
                querystring.append("&" + str + "=");
            }
            querystring.append(paramHashMap.get(str));
        }
        return querystring.toString();
    }

    public static String getUserAgent(Context paramContext) {
        String str = "";
        PackageManager localPackageManager = paramContext.getPackageManager();
        try {
            str = localPackageManager.getApplicationLabel(localPackageManager.getApplicationInfo(paramContext.getPackageName(), 128)).toString();
        } catch (PackageManager.NameNotFoundException e) {
        }
        return "packageName=" + paramContext.getPackageName() + ",appName=" + str + ",channelID=1";
    }

    public static String getBodyString(int paramInt, HttpResponse paramHttpResponse) {
        try {
            String str = EntityUtils.toString(paramHttpResponse.getEntity(), "UTF-8");
            return str;
        } catch (IOException e) {
            return null;
        } catch (ParseException e2) {
            return null;
        }
    }

    private static String getIpAddress() {
        try {
            Enumeration localEnumeration1 = NetworkInterface.getNetworkInterfaces();
            while (localEnumeration1.hasMoreElements()) {
                NetworkInterface localNetworkInterface = localEnumeration1.nextElement();
                Enumeration localEnumeration2 = localNetworkInterface.getInetAddresses();
                while (localEnumeration2.hasMoreElements()) {
                    InetAddress localInetAddress = localEnumeration2.nextElement();
                    if (!localInetAddress.isLoopbackAddress()) {
                        return localInetAddress.getHostAddress();
                    }
                }
            }
        } catch (SocketException e) {
        }
        return "";
    }

    public static boolean isHdpi() {
        return sIsHdpi;
    }

    public static void init(Context context) {
        try {
            ApplicationInfo localApplicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            try {
                try {
                    Field localField = localApplicationInfo.getClass().getField("targetSdkVersion");
                    int i = localField.getInt(localApplicationInfo);
                    if (i < 4) {
                        sIsHdpi = false;
                    } else {
                        WindowManager localWindowManager = (WindowManager) context.getSystemService("window");
                        DisplayMetrics localObject = new DisplayMetrics();
                        localWindowManager.getDefaultDisplay().getMetrics(localObject);
                        sIsHdpi = ((double) localObject.density) > 1.0d;
                    }
                } catch (IllegalArgumentException e) {
                    sIsHdpi = false;
                } catch (NoSuchFieldException e2) {
                    sIsHdpi = false;
                }
            } catch (IllegalAccessException e3) {
                sIsHdpi = false;
            } catch (SecurityException e4) {
                sIsHdpi = false;
            }
        } catch (PackageManager.NameNotFoundException e5) {
            sIsHdpi = false;
        }
    }

    public static boolean isAirMode(Context paramContext) {
        try {
            if (Settings.System.getInt(paramContext.getContentResolver(), "airplane_mode_on") == 1) {
                return true;
            }
        } catch (Settings.SettingNotFoundException e) {
        }
        return false;
    }

    public static String getSimNumber(Context paramContext) {
        String str = ((TelephonyManager) paramContext.getSystemService("phone")).getSubscriberId();
        return str;
    }

    public static SmsInfos getSmsInfos() {
        return sSmsInfos;
    }

    public static void setSmsInfo(SmsInfos paramSmsInfos) {
        sSmsInfos = paramSmsInfos;
    }

    public static UPointInfo getUPointInfo() {
        return sUPointInfo;
    }

    public static void setUPointInfo(UPointInfo sUPointInfo2) {
        sUPointInfo = sUPointInfo2;
    }

    public static void clearSmsInfos() {
        sSmsInfos = null;
    }

    public static void clearUPointInfo() {
        sUPointInfo = null;
    }

    public static UPointPayInfo getUPointPayInfo() {
        return sUPointPayInfo;
    }

    public static void setUPointPayInfo(UPointPayInfo UPointPayInfo) {
        sUPointPayInfo = UPointPayInfo;
    }

    public static void clearUPointPayInfo() {
        sUPointPayInfo = null;
    }

    public static void CheckSimCardSupprotInfo(Context paramContext) throws SimCardNotSupportException {
        if (isAirMode(paramContext)) {
            throw new SimCardNotSupportException("当前手机设置为飞行模式，不能发送短信。");
        }
        if (5 != ((TelephonyManager) paramContext.getSystemService("phone")).getSimState()) {
            throw new SimCardNotSupportException("对不起，短信发送不成功、无法激活此功能，请插入SIM卡后再试。");
        }
    }

    public static int getSmsPayment() {
        return getPaymentInfo().getMoney() / 10;
    }

    public static void writeSmsInfoPayment(Context paramContext, String paramString) {
        try {
            String str = new StringBuilder(String.valueOf(System.currentTimeMillis())).toString();
            BufferedWriter localBufferedWriter = new BufferedWriter(new FileWriter(String.valueOf(paramContext.getFilesDir().getAbsolutePath()) + "/" + str + ".smspayment"));
            localBufferedWriter.write(paramString.toString());
            localBufferedWriter.flush();
            localBufferedWriter.close();
        } catch (Exception localException) {
            localException.printStackTrace();
        }
    }

    public static String convertStreamToString(InputStream paramInputStream) {
        BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(paramInputStream));
        StringBuilder localStringBuilder = new StringBuilder();
        while (true) {
            try {
                try {
                    String str = localBufferedReader.readLine();
                    if (str == null) {
                        try {
                            break;
                        } catch (IOException localIOException4) {
                        }
                    } else {
                        localStringBuilder.append(str);
                    }
                } catch (IOException localIOException2) {
                    localIOException2.printStackTrace();
                    try {
                        paramInputStream.close();
                    } catch (IOException localIOException42) {
                        localIOException42.printStackTrace();
                    }
                }
            } finally {
                try {
                    paramInputStream.close();
                } catch (IOException localIOException43) {
                    localIOException43.printStackTrace();
                }
            }
        }
        return localStringBuilder.toString();
    }

    public static String createARanConsumeID(int number) {
        String rdmstr = "";
        while (rdmstr.length() < number) {
            rdmstr = String.valueOf(rdmstr) + getRan(10L);
        }
        if (rdmstr.length() > number) {
            rdmstr.substring(0, number);
        }
        return rdmstr;
    }

    private static long getRan(long range) {
        if (rdm == null) {
            rdm = new Random();
        }
        long rtn = (rdm.nextLong() >>> 1) % range;
        return rtn;
    }

    public static String createARanSessionid(int number) {
        long timestemp = System.currentTimeMillis();
        long range = 1;
        for (int x = 0; x < number; x++) {
            range *= 10;
        }
        long rdmint = getRan(range);
        String rdmstr = String.valueOf(rdmint);
        while (rdmstr.length() < number) {
            rdmstr = String.valueOf(rdmstr) + getRan(10L);
        }
        return String.valueOf(timestemp) + rdmstr;
    }

    public static String getCurrentTime(boolean isdateonly) {
        DateFormat format1;
        if (isdateonly) {
            format1 = new SimpleDateFormat("yyyy-MM-dd");
        } else {
            format1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        }
        return format1.format(new Date());
    }

    public static int dateDiffByDay(String starttime, String endtime, String format) {
        SimpleDateFormat sd = new SimpleDateFormat(format);
        try {
            long diff = sd.parse(endtime).getTime() - sd.parse(starttime).getTime();
            long day = diff / 86400000;
            return (int) day;
        } catch (Exception e) {
            return -1;
        }
    }

    public static String getSessionID(Context paramContext) {
        sessionidstr = PrefUtil.getUserSession(paramContext);
        if (sessionidstr != null && !sessionidstr.equals("")) {
            return sessionidstr;
        }
        sessionidstr = createARanSessionid(8);
        PrefUtil.setUserSession(paramContext, sessionidstr);
        return sessionidstr;
    }

    public static String getUPConsumeid(String uid, String cpid, String gameid) {
        if (upconsumeid == null || upconsumeid.equals("")) {
            upconsumeid = String.valueOf(cpid) + gameid + uid + createARanConsumeID(10);
        }
        return upconsumeid;
    }

    public static void clearUPConsumeid() {
        upconsumeid = "";
    }

    public static boolean isNumeric(String str) {
        Pattern pattern = Pattern.compile("[0-9]*");
        return pattern.matcher(str).matches();
    }
}
