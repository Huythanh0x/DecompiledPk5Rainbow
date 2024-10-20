/*
 * Decompiled with CFR.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.GradientDrawable
 *  android.graphics.drawable.GradientDrawable$Orientation
 *  android.provider.Settings$SettingNotFoundException
 *  android.provider.Settings$System
 *  android.telephony.TelephonyManager
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 *  android.widget.LinearLayout$LayoutParams
 *  android.widget.RelativeLayout
 *  android.widget.RelativeLayout$LayoutParams
 *  android.widget.TextView
 *  com.uc.paymentsdk.commons.codec.DigestUtils
 *  com.uc.paymentsdk.payment.PaymentInfo
 *  com.uc.paymentsdk.payment.sms.SimCardNotSupportException
 *  com.uc.paymentsdk.payment.sms.SmsInfos
 *  com.uc.paymentsdk.payment.upoint.UPointInfo
 *  com.uc.paymentsdk.payment.upoint.UPointPayInfo
 *  com.uc.paymentsdk.util.Constants
 *  com.uc.paymentsdk.util.PrefUtil
 *  org.apache.http.HttpEntity
 *  org.apache.http.HttpResponse
 *  org.apache.http.ParseException
 *  org.apache.http.util.EntityUtils
 *  res.FileLoader
 */
package com.uc.paymentsdk.util;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.view.View;
import android.view.ViewGroup;
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
import com.uc.paymentsdk.util.Constants;
import com.uc.paymentsdk.util.PrefUtil;
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
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import java.util.regex.Pattern;
import org.apache.http.HttpEntity;
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
        sessionidstr = "";
        upconsumeid = "";
    }

    public static void CheckSimCardSupprotInfo(Context context) throws SimCardNotSupportException {
        if (Utils.isAirMode(context)) {
            throw new SimCardNotSupportException("\u5f53\u524d\u624b\u673a\u8bbe\u7f6e\u4e3a\u98de\u884c\u6a21\u5f0f\uff0c\u4e0d\u80fd\u53d1\u9001\u77ed\u4fe1\u3002");
        }
        if (5 != ((TelephonyManager)context.getSystemService("phone")).getSimState()) {
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

    /*
     * Exception decompiling
     */
    public static String convertStreamToString(InputStream var0) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [11[UNCONDITIONALDOLOOP]], but top level block is 2[TRYBLOCK]
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:435)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:850)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doClass(Driver.java:84)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:78)
         *     at the.bytecode.club.bytecodeviewer.decompilers.impl.CFRDecompiler.decompile(CFRDecompiler.java:91)
         *     at the.bytecode.club.bytecodeviewer.decompilers.impl.CFRDecompiler.decompileToZip(CFRDecompiler.java:122)
         *     at the.bytecode.club.bytecodeviewer.resources.ResourceDecompiling.decompileSaveAll(ResourceDecompiling.java:262)
         *     at the.bytecode.club.bytecodeviewer.resources.ResourceDecompiling.lambda$decompileSaveAll$0(ResourceDecompiling.java:111)
         *     at java.base/java.lang.Thread.run(Thread.java:840)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    public static String createARanConsumeID(int n) {
        String string = "";
        while (true) {
            if (string.length() >= n) {
                if (string.length() > n) {
                    string.substring(0, n);
                }
                return string;
            }
            string = String.valueOf(string) + Utils.getRan(10L);
        }
    }

    /*
     * Unable to fully structure code
     */
    public static String createARanSessionid(int var0) {
        var4_1 = System.currentTimeMillis();
        var2_2 = 1L;
        var1_3 = 0;
        block0: while (true) {
            if (var1_3 >= var0) {
                var6_4 = String.valueOf(Utils.getRan(var2_2));
lbl7:
                // 2 sources

                while (true) {
                    if (var6_4.length() < var0) break block0;
                    return String.valueOf(var4_1) + var6_4;
                }
            }
            var2_2 *= 10L;
            ++var1_3;
        }
        var6_4 = String.valueOf(var6_4) + Utils.getRan(10L);
        ** while (true)
    }

    /*
     * Enabled force condition propagation
     */
    public static int dateDiffByDay(String string, String string2, String object) {
        long l;
        object = new SimpleDateFormat((String)object);
        try {
            l = (((DateFormat)object).parse(string2).getTime() - ((DateFormat)object).parse(string).getTime()) / 86400000L;
        }
        catch (Exception exception) {
            return -1;
        }
        return (int)l;
    }

    public static TextView generateBorderView(Context context) {
        context = new TextView(context);
        context.setBackgroundResource(17301524);
        return context;
    }

    public static LinearLayout generateFooterView(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        TextView textView = Utils.generateBorderView(context);
        textView.setLayoutParams((ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, 1));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        context = new TextView(context);
        context.setTextSize(16.0f);
        context.setGravity(17);
        context.setPadding(0, 20, 0, 20);
        context.setText((CharSequence)"UC\u6e38\u620f-UC\u4f18\u89c6");
        context.setTextColor(-12303292);
        linearLayout.addView((View)textView);
        linearLayout.addView((View)context, (ViewGroup.LayoutParams)layoutParams);
        return linearLayout;
    }

    /*
     * Unable to fully structure code
     */
    public static void generateOrderId(PaymentInfo var0) {
        var2_1 = Utils.getIpAddress();
        try {
            var1_2 = new StringBuilder(String.valueOf(URLEncoder.encode(var0.getUsername(), "UTF-8")));
            var1_2 = var1_2.append(var0.getAppkey()).append(URLEncoder.encode(var0.getPayname(), "UTF-8")).append(System.currentTimeMillis()).append(var2_1).toString();
        }
        catch (UnsupportedEncodingException var1_3) {
            var1_2 = "";
            ** continue;
        }
lbl8:
        // 2 sources

        while (true) {
            var0.setOrderID(DigestUtils.md5Hex((String)var1_2));
            return;
        }
    }

    public static String getAppkey(Context context) throws PackageManager.NameNotFoundException {
        return context.getPackageManager().getApplicationInfo((String)context.getPackageName(), (int)128).metaData.get("ucgame_appkey").toString();
    }

    /*
     * WARNING - void declaration
     * Enabled force condition propagation
     */
    public static String getBodyString(int n, HttpResponse object) {
        void var1_3;
        Object var2_8 = null;
        try {
            String string = EntityUtils.toString((HttpEntity)object.getEntity(), (String)"UTF-8");
            return var1_3;
        }
        catch (IOException iOException) {
            Object var1_5 = var2_8;
            return var1_3;
        }
        catch (ParseException parseException) {
            Object var1_7 = var2_8;
            return var1_3;
        }
    }

    public static String getCpID(Context context) throws PackageManager.NameNotFoundException {
        return context.getPackageManager().getApplicationInfo((String)context.getPackageName(), (int)128).metaData.get("ucgame_cpid").toString();
    }

    /*
     * Enabled force condition propagation
     */
    public static String getCurrentTime(boolean bl) {
        SimpleDateFormat simpleDateFormat;
        if (bl) {
            simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            return simpleDateFormat.format(new Date());
        }
        simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return simpleDateFormat.format(new Date());
    }

    public static double getDouble(String string) {
        return Double.parseDouble(string);
    }

    public static Drawable getDrawableFromFile(String string) {
        return Drawable.createFromStream((InputStream)Utils.getFileStream(string), (String)string);
    }

    private static InputStream getFileStream(String string) {
        return FileLoader.class.getResourceAsStream(string);
    }

    public static int getInt(int n, String string) {
        return Utils.getInt(n, string, 0);
    }

    /*
     * Enabled force condition propagation
     */
    public static int getInt(int n, String string, int n2) {
        long l;
        if (string == null) {
            return n2;
        }
        try {
            l = Long.parseLong(string.trim(), n);
        }
        catch (NumberFormatException numberFormatException) {
            return n2;
        }
        return (int)l;
    }

    public static int getInt(String string) {
        return Utils.getInt(10, string);
    }

    public static int getInt(String string, int n) {
        return Utils.getInt(10, string, n);
    }

    /*
     * Enabled force condition propagation
     */
    private static String getIpAddress() {
        try {
            InetAddress inetAddress;
            Enumeration<NetworkInterface> enumeration = NetworkInterface.getNetworkInterfaces();
            block2: while (true) {
                boolean bl;
                if (!(bl = enumeration.hasMoreElements())) {
                    return "";
                }
                Enumeration<InetAddress> enumeration2 = enumeration.nextElement().getInetAddresses();
                do {
                    if (!enumeration2.hasMoreElements()) continue block2;
                } while ((inetAddress = (InetAddress)enumeration2.nextElement()).isLoopbackAddress());
                break;
            }
            return inetAddress.getHostAddress();
        }
        catch (SocketException socketException) {
            return "";
        }
    }

    /*
     * Enabled force condition propagation
     */
    public static long getLong(String string) {
        if (string == null) {
            return 0L;
        }
        try {
            return Long.parseLong(string.trim());
        }
        catch (NumberFormatException numberFormatException) {
            return 0L;
        }
    }

    public static PaymentInfo getPaymentInfo() {
        return sPaymentInfo;
    }

    /*
     * Unable to fully structure code
     */
    public static String getQueryString(HashMap<String, Object> var0) {
        var2_1 = new StringBuilder();
        var3_2 = var0.keySet().iterator();
        block0: while (true) {
            if (!var3_2.hasNext()) {
                return var2_1.toString();
            }
            var1_3 = var3_2.next();
            if (var2_1.length() >= 1) break;
            var2_1.append(String.valueOf(var1_3) + "=");
lbl10:
            // 2 sources

            while (true) {
                var2_1.append(var0.get(var1_3));
                continue block0;
                break;
            }
            break;
        }
        var2_1.append("&" + var1_3 + "=");
        ** while (true)
    }

    private static long getRan(long l) {
        if (rdm == null) {
            rdm = new Random();
        }
        return (rdm.nextLong() >>> 1) % l;
    }

    /*
     * WARNING - void declaration
     * Enabled force condition propagation
     */
    public static String getSessionID(Context object) {
        void var0_2;
        sessionidstr = PrefUtil.getUserSession((Context)object);
        if (sessionidstr == null || sessionidstr.equals("")) {
            sessionidstr = Utils.createARanSessionid(8);
            PrefUtil.setUserSession((Context)object, (String)sessionidstr);
            String string = sessionidstr;
            return var0_2;
        }
        String string = sessionidstr;
        return var0_2;
    }

    public static String getSimNumber(Context context) {
        return ((TelephonyManager)context.getSystemService("phone")).getSubscriberId();
    }

    public static SmsInfos getSmsInfos() {
        return sSmsInfos;
    }

    public static int getSmsPayment() {
        return Utils.getPaymentInfo().getMoney() / 10;
    }

    /*
     * Enabled force condition propagation
     */
    private static String getTitleIconFileName(String string) {
        boolean bl = Utils.isHdpi();
        if (TITLE_ICON_BACK.equals(string)) {
            if (!bl) return "back_btn.png";
            return "back_btn_hdpi.png";
        }
        if (!TITLE_ICON_CANCEL.equals(string)) throw new IllegalArgumentException("type not supported.");
        if (!bl) return "cancel_btn.png";
        return "cancel_btn_hdpi.png";
    }

    public static String getUPConsumeid(String string, String string2, String string3) {
        if (upconsumeid == null || upconsumeid.equals("")) {
            upconsumeid = String.valueOf(string2) + string3 + string + Utils.createARanConsumeID(10);
        }
        return upconsumeid;
    }

    public static UPointInfo getUPointInfo() {
        return sUPointInfo;
    }

    public static UPointPayInfo getUPointPayInfo() {
        return sUPointPayInfo;
    }

    /*
     * Unable to fully structure code
     */
    public static byte[] getUTF8Bytes(String var0) {
        if (var0 == null) {
            var0 = new byte[0];
lbl3:
            // 4 sources

            return var0;
        }
        try {
            var1_2 = var0.getBytes("UTF-8");
        }
        catch (UnsupportedEncodingException var1_3) {
            try {
                var3_5 = new ByteArrayOutputStream();
                var2_6 = new DataOutputStream(var3_5);
                var2_6.writeUTF((String)var0);
                var1_4 = var3_5.toByteArray();
                var3_5.close();
                var2_6.close();
                var0 = new byte[var1_4.length - 2];
                System.arraycopy(var1_4, 2, var0, 0, ((Object)var0).length);
                ** GOTO lbl3
            }
            catch (IOException var0_1) {
                var0 = new byte[0];
                ** continue;
            }
        }
        var0 = var1_2;
        ** GOTO lbl3
    }

    /*
     * WARNING - void declaration
     * Enabled force condition propagation
     */
    public static String getUTF8String(byte[] object) {
        void var0_2;
        if (object == null) {
            return var0_2;
        }
        String string = Utils.getUTF8String(object, 0, ((byte[])object).length);
        return var0_2;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public static String getUTF8String(byte[] var0, int var1_2, int var2_3) {
        if (var0 /* !! */  == null) {
            var0 /* !! */  = (byte[])"";
lbl3:
            // 3 sources

            return var0 /* !! */ ;
        }
        try {
            var3_4 = new String(var0 /* !! */ , var1_2, var2_3, "UTF-8");
        }
        catch (UnsupportedEncodingException var0_1) {
            var0 /* !! */  = (byte[])"";
            ** continue;
        }
        var0 /* !! */  = (byte[])var3_4;
        ** GOTO lbl3
    }

    /*
     * Enabled force condition propagation
     */
    public static String getUserAgent(Context context) {
        String string = "";
        PackageManager packageManager = context.getPackageManager();
        try {
            String string2;
            string = string2 = packageManager.getApplicationLabel(packageManager.getApplicationInfo(context.getPackageName(), 128)).toString();
            return "packageName=" + context.getPackageName() + ",appName=" + string + ",channelID=1";
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            return "packageName=" + context.getPackageName() + ",appName=" + string + ",channelID=1";
        }
    }

    public static String getXmlFromFile(String string) throws IOException {
        return Utils.convertStreamToString(Utils.getFileStream(string));
    }

    public static String getXmlRequestBody(HashMap<String, Object> hashMap, Context object) {
        object = new StringBuilder();
        ((StringBuilder)object).append("<request");
        if (hashMap.containsKey("local_version")) {
            ((StringBuilder)object).append(" local_version=\"" + hashMap.get("local_version") + "\" ");
            hashMap.remove("local_version");
        }
        ((StringBuilder)object).append(">");
        Iterator<String> iterator = hashMap.keySet().iterator();
        while (true) {
            if (!iterator.hasNext()) {
                ((StringBuilder)object).append("</request>");
                return ((StringBuilder)object).toString();
            }
            String string = iterator.next();
            ((StringBuilder)object).append("<").append(string).append(">");
            ((StringBuilder)object).append(hashMap.get(string));
            ((StringBuilder)object).append("</").append(string).append(">");
        }
    }

    /*
     * Exception decompiling
     */
    public static void init(Context var0) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * java.lang.IllegalStateException: Backjump on non jumping statement @NONE, blocks:[0, 5] lbl14 : TryStatement: try { 2[TRYBLOCK]
         * 
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.Cleaner$1.call(Cleaner.java:44)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.Cleaner$1.call(Cleaner.java:22)
         *     at org.benf.cfr.reader.util.graph.GraphVisitorDFS.process(GraphVisitorDFS.java:68)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.Cleaner.removeUnreachableCode(Cleaner.java:54)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:550)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doClass(Driver.java:84)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:78)
         *     at the.bytecode.club.bytecodeviewer.decompilers.impl.CFRDecompiler.decompile(CFRDecompiler.java:91)
         *     at the.bytecode.club.bytecodeviewer.decompilers.impl.CFRDecompiler.decompileToZip(CFRDecompiler.java:122)
         *     at the.bytecode.club.bytecodeviewer.resources.ResourceDecompiling.decompileSaveAll(ResourceDecompiling.java:262)
         *     at the.bytecode.club.bytecodeviewer.resources.ResourceDecompiling.lambda$decompileSaveAll$0(ResourceDecompiling.java:111)
         *     at java.base/java.lang.Thread.run(Thread.java:840)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    public static RelativeLayout initSubTitle(Context context, View.OnClickListener onClickListener, String string, boolean bl) {
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        relativeLayout.setBackgroundDrawable((Drawable)new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{Constants.COLOR_SUBTITLE_BACKGROUND1, Constants.COLOR_SUBTITLE_BACKGROUND2}));
        ImageView imageView = new ImageView(context);
        imageView.setImageDrawable(Utils.getDrawableFromFile(Utils.getTitleIconFileName(TITLE_ICON_BACK)));
        imageView.setId(9);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(9);
        layoutParams.addRule(15);
        imageView.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
        imageView.setOnClickListener(onClickListener);
        imageView.setPadding(8, 0, 0, 0);
        layoutParams = new ImageView(context);
        layoutParams.setImageDrawable(Utils.getDrawableFromFile(Utils.getTitleIconFileName(TITLE_ICON_CANCEL)));
        layoutParams.setId(10);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(11);
        layoutParams2.addRule(15);
        layoutParams.setLayoutParams((ViewGroup.LayoutParams)layoutParams2);
        layoutParams.setOnClickListener(onClickListener);
        layoutParams.setPadding(0, 0, 10, 0);
        context = new TextView(context);
        context.setGravity(17);
        context.setTextColor(Constants.COLOR_TITLE_BACKGROUND);
        context.setPadding(0, 10, 0, 10);
        context.setTextSize(23.0f);
        context.setText((CharSequence)string);
        onClickListener = new RelativeLayout.LayoutParams(-2, -2);
        onClickListener.addRule(14);
        context.setLayoutParams((ViewGroup.LayoutParams)onClickListener);
        relativeLayout.addView((View)imageView);
        relativeLayout.addView((View)context);
        if (bl) {
            relativeLayout.addView((View)layoutParams);
        }
        return relativeLayout;
    }

    public static void initTitleBar(Activity activity) {
        View view = activity.getWindow().findViewById(16908310);
        if (view != null) {
            if (view instanceof TextView) {
                ((TextView)view).setTextSize(13.0f);
            }
            if ((view = view.getParent()) != null && view instanceof View) {
                view.setBackgroundColor(134875644);
            }
        }
        activity.setTitle((CharSequence)"UC\u652f\u4ed8");
    }

    /*
     * Enabled force condition propagation
     */
    public static boolean isAirMode(Context context) {
        try {
            int n = Settings.System.getInt((ContentResolver)context.getContentResolver(), (String)"airplane_mode_on");
            if (n != 1) return false;
            return true;
        }
        catch (Settings.SettingNotFoundException settingNotFoundException) {
            // empty catch block
        }
        return false;
    }

    public static boolean isHdpi() {
        return sIsHdpi;
    }

    public static boolean isNumeric(String string) {
        return Pattern.compile("[0-9]*").matcher(string).matches();
    }

    public static void loadFile(String object, String object2) throws IOException, FileNotFoundException {
        object = Utils.getFileStream((String)object);
        object2 = new File((String)object2);
        ((File)object2).createNewFile();
        object2 = new FileOutputStream((File)object2);
        byte[] byArray = new byte[1024];
        while (true) {
            int n;
            if ((n = ((InputStream)object).read(byArray)) <= 0) {
                ((FileOutputStream)object2).close();
                ((InputStream)object).close();
                return;
            }
            ((FileOutputStream)object2).write(byArray, 0, n);
        }
    }

    public static void setPaymentInfo(PaymentInfo paymentInfo) {
        sPaymentInfo = paymentInfo;
    }

    public static void setSmsInfo(SmsInfos smsInfos) {
        sSmsInfos = smsInfos;
    }

    public static void setUPointInfo(UPointInfo uPointInfo) {
        sUPointInfo = uPointInfo;
    }

    public static void setUPointPayInfo(UPointPayInfo uPointPayInfo) {
        sUPointPayInfo = uPointPayInfo;
    }

    /*
     * Enabled force condition propagation
     */
    public static void writeSmsInfoPayment(Context context, String string) {
        try {
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(System.currentTimeMillis()));
            String string2 = stringBuilder.toString();
            StringBuilder stringBuilder2 = new StringBuilder(String.valueOf(context.getFilesDir().getAbsolutePath()));
            FileWriter fileWriter = new FileWriter(stringBuilder2.append("/").append(string2).append(".smspayment").toString());
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(string.toString());
            bufferedWriter.flush();
            bufferedWriter.close();
            return;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return;
        }
    }
}
