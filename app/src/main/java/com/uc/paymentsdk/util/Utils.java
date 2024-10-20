package com.uc.paymentsdk.util;

import java.io.Writer;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.File;
import java.util.regex.Pattern;
import android.provider.Settings$SettingNotFoundException;
import android.provider.Settings$System;
import android.view.ViewParent;
import android.app.Activity;
import android.widget.RelativeLayout$LayoutParams;
import android.widget.ImageView;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable$Orientation;
import android.widget.RelativeLayout;
import android.view.View$OnClickListener;
import android.content.pm.ApplicationInfo;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.content.pm.PackageManager;
import java.io.OutputStream;
import java.io.DataOutputStream;
import java.io.ByteArrayOutputStream;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Enumeration;
import java.net.SocketException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import res.FileLoader;
import android.graphics.drawable.Drawable;
import java.util.Date;
import org.apache.http.ParseException;
import java.io.IOException;
import org.apache.http.util.EntityUtils;
import org.apache.http.HttpResponse;
import android.content.pm.PackageManager$NameNotFoundException;
import java.io.UnsupportedEncodingException;
import com.uc.paymentsdk.commons.codec.DigestUtils;
import java.net.URLEncoder;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.widget.LinearLayout$LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.io.InputStream;
import android.telephony.TelephonyManager;
import com.uc.paymentsdk.payment.sms.SimCardNotSupportException;
import android.content.Context;
import com.uc.paymentsdk.payment.upoint.UPointPayInfo;
import com.uc.paymentsdk.payment.upoint.UPointInfo;
import com.uc.paymentsdk.payment.sms.SmsInfos;
import com.uc.paymentsdk.payment.PaymentInfo;
import java.util.Random;

public class Utils
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
    
    public Utils() {
        super();
    }
    
    public static void CheckSimCardSupprotInfo(final Context context) throws SimCardNotSupportException {
        if (isAirMode(context)) {
            throw new SimCardNotSupportException("\u5f53\u524d\u624b\u673a\u8bbe\u7f6e\u4e3a\u98de\u884c\u6a21\u5f0f\uff0c\u4e0d\u80fd\u53d1\u9001\u77ed\u4fe1\u3002");
        }
        if (5 != ((TelephonyManager)context.getSystemService("phone")).getSimState()) {
            throw new SimCardNotSupportException("\u5bf9\u4e0d\u8d77\uff0c\u77ed\u4fe1\u53d1\u9001\u4e0d\u6210\u529f\u3001\u65e0\u6cd5\u6fc0\u6d3b\u6b64\u529f\u80fd\uff0c\u8bf7\u63d2\u5165SIM\u5361\u540e\u518d\u8bd5\u3002");
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
    
    public static String convertStreamToString(final InputStream p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: dup            
        //     4: new             Ljava/io/InputStreamReader;
        //     7: dup            
        //     8: aload_0        
        //     9: invokespecial   java/io/InputStreamReader.<init>:(Ljava/io/InputStream;)V
        //    12: invokespecial   java/io/BufferedReader.<init>:(Ljava/io/Reader;)V
        //    15: astore_3       
        //    16: new             Ljava/lang/StringBuilder;
        //    19: dup            
        //    20: invokespecial   java/lang/StringBuilder.<init>:()V
        //    23: astore_1       
        //    24: aload_3        
        //    25: invokevirtual   java/io/BufferedReader.readLine:()Ljava/lang/String;
        //    28: astore_2       
        //    29: aload_2        
        //    30: ifnonnull       42
        //    33: aload_0        
        //    34: invokevirtual   java/io/InputStream.close:()V
        //    37: aload_1        
        //    38: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //    41: areturn        
        //    42: aload_1        
        //    43: aload_2        
        //    44: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    47: pop            
        //    48: goto            24
        //    51: astore_2       
        //    52: aload_2        
        //    53: invokevirtual   java/io/IOException.printStackTrace:()V
        //    56: aload_0        
        //    57: invokevirtual   java/io/InputStream.close:()V
        //    60: goto            37
        //    63: astore_0       
        //    64: aload_0        
        //    65: invokevirtual   java/io/IOException.printStackTrace:()V
        //    68: goto            37
        //    71: astore_1       
        //    72: aload_0        
        //    73: invokevirtual   java/io/InputStream.close:()V
        //    76: aload_1        
        //    77: athrow         
        //    78: astore_0       
        //    79: aload_0        
        //    80: invokevirtual   java/io/IOException.printStackTrace:()V
        //    83: goto            76
        //    86: astore_0       
        //    87: aload_0        
        //    88: invokevirtual   java/io/IOException.printStackTrace:()V
        //    91: goto            37
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  24     29     51     71     Ljava/io/IOException;
        //  24     29     71     86     Any
        //  33     37     86     94     Ljava/io/IOException;
        //  42     48     51     71     Ljava/io/IOException;
        //  42     48     71     86     Any
        //  52     56     71     86     Any
        //  56     60     63     71     Ljava/io/IOException;
        //  72     76     78     86     Ljava/io/IOException;
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static String createARanConsumeID(final int endIndex) {
        String string;
        for (string = ""; string.length() < endIndex; string = String.valueOf(string) + getRan(10L)) {}
        if (string.length() > endIndex) {
            string.substring(0, endIndex);
        }
        return string;
    }
    
    public static String createARanSessionid(final int n) {
        final long currentTimeMillis = System.currentTimeMillis();
        long n2 = 1L;
        for (int i = 0; i < n; ++i) {
            n2 *= 10L;
        }
        String s;
        for (s = String.valueOf(getRan(n2)); s.length() < n; s = String.valueOf(s) + getRan(10L)) {}
        return String.valueOf(currentTimeMillis) + s;
    }
    
    public static int dateDiffByDay(final String source, final String source2, final String pattern) {
        final SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        try {
            return (int)((simpleDateFormat.parse(source2).getTime() - simpleDateFormat.parse(source).getTime()) / 86400000L);
        }
        catch (final Exception ex) {
            return -1;
        }
    }
    
    public static TextView generateBorderView(final Context context) {
        final TextView textView = new TextView(context);
        textView.setBackgroundResource(17301524);
        return textView;
    }
    
    public static LinearLayout generateFooterView(final Context context) {
        final LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        final TextView generateBorderView = generateBorderView(context);
        generateBorderView.setLayoutParams((ViewGroup$LayoutParams)new LinearLayout$LayoutParams(-1, 1));
        final LinearLayout$LayoutParams linearLayout$LayoutParams = new LinearLayout$LayoutParams(-1, -2);
        final TextView textView = new TextView(context);
        textView.setTextSize(16.0f);
        textView.setGravity(17);
        textView.setPadding(0, 20, 0, 20);
        textView.setText((CharSequence)"UC\u6e38\u620f-UC\u4f18\u89c6");
        textView.setTextColor(-12303292);
        linearLayout.addView((View)generateBorderView);
        linearLayout.addView((View)textView, (ViewGroup$LayoutParams)linearLayout$LayoutParams);
        return linearLayout;
    }
    
    public static void generateOrderId(final PaymentInfo paymentInfo) {
        final String ipAddress = getIpAddress();
        while (true) {
            try {
                final String string = String.valueOf(URLEncoder.encode(paymentInfo.getUsername(), "UTF-8")) + paymentInfo.getAppkey() + URLEncoder.encode(paymentInfo.getPayname(), "UTF-8") + System.currentTimeMillis() + ipAddress;
                paymentInfo.setOrderID(DigestUtils.md5Hex(string));
            }
            catch (final UnsupportedEncodingException ex) {
                final String string = "";
                continue;
            }
            break;
        }
    }
    
    public static String getAppkey(final Context context) throws PackageManager$NameNotFoundException {
        return context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.get("ucgame_appkey").toString();
    }
    
    public static String getBodyString(final int n, final HttpResponse httpResponse) {
        final String s = null;
        try {
            return EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
        }
        catch (final IOException ex) {
            return s;
        }
        catch (final ParseException ex2) {
            return s;
        }
    }
    
    public static String getCpID(final Context context) throws PackageManager$NameNotFoundException {
        return context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.get("ucgame_cpid").toString();
    }
    
    public static String getCurrentTime(final boolean b) {
        SimpleDateFormat simpleDateFormat;
        if (b) {
            simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        }
        else {
            simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        }
        return simpleDateFormat.format(new Date());
    }
    
    public static double getDouble(final String s) {
        return Double.parseDouble(s);
    }
    
    public static Drawable getDrawableFromFile(final String s) {
        return Drawable.createFromStream(getFileStream(s), s);
    }
    
    private static InputStream getFileStream(final String name) {
        return FileLoader.class.getResourceAsStream(name);
    }
    
    public static int getInt(final int n, final String s) {
        return getInt(n, s, 0);
    }
    
    public static int getInt(int radix, final String s, final int n) {
        if (s == null) {
            radix = n;
        }
        else {
            try {
                radix = (int)Long.parseLong(s.trim(), radix);
            }
            catch (final NumberFormatException ex) {
                radix = n;
            }
        }
        return radix;
    }
    
    public static int getInt(final String s) {
        return getInt(10, s);
    }
    
    public static int getInt(final String s, final int n) {
        return getInt(10, s, n);
    }
    
    private static String getIpAddress() {
        try {
            final Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                final Enumeration<InetAddress> inetAddresses = ((NetworkInterface)networkInterfaces.nextElement()).getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    final InetAddress inetAddress = (InetAddress)inetAddresses.nextElement();
                    if (!inetAddress.isLoopbackAddress()) {
                        return inetAddress.getHostAddress();
                    }
                }
            }
            return "";
        }
        catch (final SocketException ex) {
            return "";
        }
    }
    
    public static long getLong(final String s) {
        long long1;
        if (s == null) {
            long1 = 0L;
        }
        else {
            try {
                long1 = Long.parseLong(s.trim());
            }
            catch (final NumberFormatException ex) {
                long1 = 0L;
            }
        }
        return long1;
    }
    
    public static PaymentInfo getPaymentInfo() {
        return Utils.sPaymentInfo;
    }
    
    public static String getQueryString(final HashMap<String, Object> hashMap) {
        final StringBuilder sb = new StringBuilder();
        for (final String key : hashMap.keySet()) {
            if (sb.length() < 1) {
                sb.append(String.valueOf(key) + "=");
            }
            else {
                sb.append("&" + key + "=");
            }
            sb.append(hashMap.get((Object)key));
        }
        return sb.toString();
    }
    
    private static long getRan(final long n) {
        if (Utils.rdm == null) {
            Utils.rdm = new Random();
        }
        return (Utils.rdm.nextLong() >>> 1) % n;
    }
    
    public static String getSessionID(final Context context) {
        Utils.sessionidstr = PrefUtil.getUserSession(context);
        String s;
        if (Utils.sessionidstr == null || Utils.sessionidstr.equals("")) {
            PrefUtil.setUserSession(context, Utils.sessionidstr = createARanSessionid(8));
            s = Utils.sessionidstr;
        }
        else {
            s = Utils.sessionidstr;
        }
        return s;
    }
    
    public static String getSimNumber(final Context context) {
        return ((TelephonyManager)context.getSystemService("phone")).getSubscriberId();
    }
    
    public static SmsInfos getSmsInfos() {
        return Utils.sSmsInfos;
    }
    
    public static int getSmsPayment() {
        return getPaymentInfo().getMoney() / 10;
    }
    
    private static String getTitleIconFileName(String s) {
        final boolean hdpi = isHdpi();
        if ("back".equals(s)) {
            if (hdpi) {
                s = "back_btn_hdpi.png";
            }
            else {
                s = "back_btn.png";
            }
        }
        else {
            if (!"cancel".equals(s)) {
                throw new IllegalArgumentException("type not supported.");
            }
            if (hdpi) {
                s = "cancel_btn_hdpi.png";
            }
            else {
                s = "cancel_btn.png";
            }
        }
        return s;
    }
    
    public static String getUPConsumeid(final String str, final String obj, final String str2) {
        if (Utils.upconsumeid == null || Utils.upconsumeid.equals("")) {
            Utils.upconsumeid = String.valueOf(obj) + str2 + str + createARanConsumeID(10);
        }
        return Utils.upconsumeid;
    }
    
    public static UPointInfo getUPointInfo() {
        return Utils.sUPointInfo;
    }
    
    public static UPointPayInfo getUPointPayInfo() {
        return Utils.sUPointPayInfo;
    }
    
    public static byte[] getUTF8Bytes(String bytes) {
        if (bytes == null) {
            bytes = new byte[0];
        }
        else {
            try {
                bytes = ((String)bytes).getBytes("UTF-8");
            }
            catch (final UnsupportedEncodingException ex) {
                try {
                    final ByteArrayOutputStream out = new ByteArrayOutputStream();
                    final DataOutputStream dataOutputStream = new DataOutputStream(out);
                    dataOutputStream.writeUTF((String)bytes);
                    final byte[] byteArray = out.toByteArray();
                    out.close();
                    dataOutputStream.close();
                    bytes = new byte[byteArray.length - 2];
                    System.arraycopy(byteArray, 2, bytes, 0, bytes.length);
                }
                catch (final IOException ex2) {
                    bytes = new byte[0];
                }
            }
        }
        return (byte[])bytes;
    }
    
    public static String getUTF8String(final byte[] array) {
        String utf8String;
        if (array == null) {
            utf8String = "";
        }
        else {
            utf8String = getUTF8String(array, 0, array.length);
        }
        return utf8String;
    }
    
    public static String getUTF8String(final byte[] bytes, final int offset, final int length) {
        String s;
        if (bytes == null) {
            s = "";
        }
        else {
            try {
                s = new String(bytes, offset, length, "UTF-8");
            }
            catch (final UnsupportedEncodingException ex) {
                s = "";
            }
        }
        return s;
    }
    
    public static String getUserAgent(final Context context) {
        String string = "";
        final PackageManager packageManager = context.getPackageManager();
        try {
            string = packageManager.getApplicationLabel(packageManager.getApplicationInfo(context.getPackageName(), 128)).toString();
            return "packageName=" + context.getPackageName() + ",appName=" + string + ",channelID=1";
        }
        catch (final PackageManager$NameNotFoundException ex) {
            return "packageName=" + context.getPackageName() + ",appName=" + string + ",channelID=1";
        }
    }
    
    public static String getXmlFromFile(final String s) throws IOException {
        return convertStreamToString(getFileStream(s));
    }
    
    public static String getXmlRequestBody(final HashMap<String, Object> hashMap, final Context context) {
        final StringBuilder sb = new StringBuilder();
        sb.append("<request");
        if (hashMap.containsKey("local_version")) {
            sb.append(" local_version=\"" + hashMap.get((Object)"local_version") + "\" ");
            hashMap.remove("local_version");
        }
        sb.append(">");
        for (final String str : hashMap.keySet()) {
            sb.append("<").append(str).append(">");
            sb.append(hashMap.get((Object)str));
            sb.append("</").append(str).append(">");
        }
        sb.append("</request>");
        return sb.toString();
    }
    
    public static void init(final Context context) {
        while (true) {
            try {
                final ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
                try {
                    if (applicationInfo.getClass().getField("targetSdkVersion").getInt(applicationInfo) < 4) {
                        Utils.sIsHdpi = false;
                        return;
                    }
                }
                catch (final SecurityException ex) {
                    Utils.sIsHdpi = false;
                }
                catch (final NoSuchFieldException ex2) {
                    Utils.sIsHdpi = false;
                }
                catch (final IllegalArgumentException ex3) {
                    Utils.sIsHdpi = false;
                }
                catch (final IllegalAccessException ex4) {
                    Utils.sIsHdpi = false;
                }
            }
            catch (final PackageManager$NameNotFoundException ex5) {}
            final WindowManager windowManager = (WindowManager)context.getSystemService("window");
            final DisplayMetrics displayMetrics = new DisplayMetrics();
            windowManager.getDefaultDisplay().getMetrics((DisplayMetrics)displayMetrics);
            Utils.sIsHdpi = (((DisplayMetrics)displayMetrics).density > 1.0);
        }
    }
    
    public static RelativeLayout initSubTitle(final Context context, final View$OnClickListener view$OnClickListener, final String text, final boolean b) {
        final RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setLayoutParams(new ViewGroup$LayoutParams(-1, -2));
        relativeLayout.setBackgroundDrawable((Drawable)new GradientDrawable(GradientDrawable$Orientation.TOP_BOTTOM, new int[] { Constants.COLOR_SUBTITLE_BACKGROUND1, Constants.COLOR_SUBTITLE_BACKGROUND2 }));
        final ImageView imageView = new ImageView(context);
        imageView.setImageDrawable(getDrawableFromFile(getTitleIconFileName("back")));
        imageView.setId(9);
        final RelativeLayout$LayoutParams layoutParams = new RelativeLayout$LayoutParams(-2, -2);
        layoutParams.addRule(9);
        layoutParams.addRule(15);
        imageView.setLayoutParams((ViewGroup$LayoutParams)layoutParams);
        imageView.setOnClickListener(view$OnClickListener);
        imageView.setPadding(8, 0, 0, 0);
        final ImageView imageView2 = new ImageView(context);
        imageView2.setImageDrawable(getDrawableFromFile(getTitleIconFileName("cancel")));
        imageView2.setId(10);
        final RelativeLayout$LayoutParams layoutParams2 = new RelativeLayout$LayoutParams(-2, -2);
        layoutParams2.addRule(11);
        layoutParams2.addRule(15);
        imageView2.setLayoutParams((ViewGroup$LayoutParams)layoutParams2);
        imageView2.setOnClickListener(view$OnClickListener);
        imageView2.setPadding(0, 0, 10, 0);
        final TextView textView = new TextView(context);
        textView.setGravity(17);
        textView.setTextColor(Constants.COLOR_TITLE_BACKGROUND);
        textView.setPadding(0, 10, 0, 10);
        textView.setTextSize(23.0f);
        textView.setText((CharSequence)text);
        final RelativeLayout$LayoutParams layoutParams3 = new RelativeLayout$LayoutParams(-2, -2);
        layoutParams3.addRule(14);
        textView.setLayoutParams((ViewGroup$LayoutParams)layoutParams3);
        relativeLayout.addView((View)imageView);
        relativeLayout.addView((View)textView);
        if (b) {
            relativeLayout.addView((View)imageView2);
        }
        return relativeLayout;
    }
    
    public static void initTitleBar(final Activity activity) {
        final View viewById = activity.getWindow().findViewById(16908310);
        if (viewById != null) {
            if (viewById instanceof TextView) {
                ((TextView)viewById).setTextSize(13.0f);
            }
            final ViewParent parent = viewById.getParent();
            if (parent != null && parent instanceof View) {
                ((View)parent).setBackgroundColor(134875644);
            }
        }
        activity.setTitle((CharSequence)"UC\u652f\u4ed8");
    }
    
    public static boolean isAirMode(final Context context) {
        while (true) {
            try {
                if (Settings$System.getInt(context.getContentResolver(), "airplane_mode_on") == 1) {
                    return true;
                }
            }
            catch (final Settings$SettingNotFoundException ex) {}
            return false;
        }
    }
    
    public static boolean isHdpi() {
        return Utils.sIsHdpi;
    }
    
    public static boolean isNumeric(final String input) {
        return Pattern.compile("[0-9]*").matcher(input).matches();
    }
    
    public static void loadFile(final String s, final String pathname) throws IOException, FileNotFoundException {
        final InputStream fileStream = getFileStream(s);
        final File file = new File(pathname);
        file.createNewFile();
        final FileOutputStream fileOutputStream = new FileOutputStream(file);
        final byte[] array = new byte[1024];
        while (true) {
            final int read = fileStream.read(array);
            if (read <= 0) {
                break;
            }
            fileOutputStream.write(array, 0, read);
        }
        fileOutputStream.close();
        fileStream.close();
    }
    
    public static void setPaymentInfo(final PaymentInfo sPaymentInfo) {
        Utils.sPaymentInfo = sPaymentInfo;
    }
    
    public static void setSmsInfo(final SmsInfos sSmsInfos) {
        Utils.sSmsInfos = sSmsInfos;
    }
    
    public static void setUPointInfo(final UPointInfo suPointInfo) {
        Utils.sUPointInfo = suPointInfo;
    }
    
    public static void setUPointPayInfo(final UPointPayInfo suPointPayInfo) {
        Utils.sUPointPayInfo = suPointPayInfo;
    }
    
    public static void writeSmsInfoPayment(final Context context, final String s) {
        try {
            final BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(String.valueOf(context.getFilesDir().getAbsolutePath()) + "/" + new StringBuilder(String.valueOf(System.currentTimeMillis())).toString() + ".smspayment"));
            bufferedWriter.write(s.toString());
            bufferedWriter.flush();
            bufferedWriter.close();
        }
        catch (final Exception ex) {
            ex.printStackTrace();
        }
    }
}
