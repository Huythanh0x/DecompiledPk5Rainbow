/*
 * Decompiled with CFR.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Dialog
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentFilter
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.database.ContentObserver
 *  android.graphics.Color
 *  android.os.Bundle
 *  android.os.Handler
 *  android.text.Html
 *  android.text.TextUtils
 *  android.text.method.PasswordTransformationMethod
 *  android.text.method.TransformationMethod
 *  android.text.util.Linkify
 *  android.view.KeyEvent
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.AdapterView
 *  android.widget.AdapterView$OnItemClickListener
 *  android.widget.Button
 *  android.widget.CheckBox
 *  android.widget.EditText
 *  android.widget.HeaderViewListAdapter
 *  android.widget.LinearLayout
 *  android.widget.LinearLayout$LayoutParams
 *  android.widget.ListAdapter
 *  android.widget.ListView
 *  android.widget.RelativeLayout
 *  android.widget.RelativeLayout$LayoutParams
 *  android.widget.ScrollView
 *  android.widget.TextView
 *  com.uc.paymentsdk.commons.ui.CustomAdapter
 *  com.uc.paymentsdk.model.IType
 *  com.uc.paymentsdk.model.TypeFactory
 *  com.uc.paymentsdk.network.Api
 *  com.uc.paymentsdk.network.ApiTask$TaskHandler
 *  com.uc.paymentsdk.network.XMLParser
 *  com.uc.paymentsdk.network.chain.Handler$OnFinishListener
 *  com.uc.paymentsdk.network.chain.HandlerProxy
 *  com.uc.paymentsdk.network.chain.SyncChargeChannelHandler
 *  com.uc.paymentsdk.network.chain.SyncPayChannelHandler
 *  com.uc.paymentsdk.network.chain.SyncSmsInfoHandler
 *  com.uc.paymentsdk.payment.PaymentInfo
 *  com.uc.paymentsdk.payment.sms.SimCardNotSupportException
 *  com.uc.paymentsdk.payment.sms.SmsInfo
 *  com.uc.paymentsdk.payment.upoint.UPointInfo
 *  com.uc.paymentsdk.payment.upoint.UPointPayInfo
 *  com.uc.paymentsdk.util.DialogUtil
 *  com.uc.paymentsdk.util.DialogUtil$WarningDialogListener
 *  com.uc.paymentsdk.util.PrefUtil
 *  com.uc.paymentsdk.util.Utils
 *  org.apache.http.HttpResponse
 */
package com.uc.paymentsdk.payment;

import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.database.ContentObserver;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.text.TextUtils;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.text.util.Linkify;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.HeaderViewListAdapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.uc.paymentsdk.commons.ui.CustomAdapter;
import com.uc.paymentsdk.model.IType;
import com.uc.paymentsdk.model.TypeFactory;
import com.uc.paymentsdk.network.Api;
import com.uc.paymentsdk.network.ApiTask;
import com.uc.paymentsdk.network.XMLParser;
import com.uc.paymentsdk.network.chain.Handler;
import com.uc.paymentsdk.network.chain.HandlerProxy;
import com.uc.paymentsdk.network.chain.SyncChargeChannelHandler;
import com.uc.paymentsdk.network.chain.SyncPayChannelHandler;
import com.uc.paymentsdk.network.chain.SyncSmsInfoHandler;
import com.uc.paymentsdk.payment.PaymentInfo;
import com.uc.paymentsdk.payment.sms.SimCardNotSupportException;
import com.uc.paymentsdk.payment.sms.SmsInfo;
import com.uc.paymentsdk.payment.upoint.UPointInfo;
import com.uc.paymentsdk.payment.upoint.UPointPayInfo;
import com.uc.paymentsdk.util.DialogUtil;
import com.uc.paymentsdk.util.PrefUtil;
import com.uc.paymentsdk.util.Utils;
import java.text.DecimalFormat;
import java.util.regex.Pattern;
import org.apache.http.HttpResponse;

public class PaymentsActivity
extends Activity
implements View.OnClickListener,
ApiTask.TaskHandler,
AdapterView.OnItemClickListener,
DialogUtil.WarningDialogListener,
Handler.OnFinishListener {
    private static final String CONTENT_SMS_INBOX = "content://sms/";
    private static final int DIALOG_500 = 11;
    private static final int DIALOG_ACCOUNT_WRONG = 34;
    private static final int DIALOG_CONNECTING = 14;
    private static final int DIALOG_CONNECTING_FAILED = 15;
    private static final int DIALOG_INSUFFICIENT_BALANCE = 5;
    private static final int DIALOG_PASSWORD_IS_EMPTY = 29;
    private static final int DIALOG_PASSWORD_OR_USERNAME_IS_EMPTY = 28;
    private static final int DIALOG_PASSWORD_WRONG = 33;
    private static final int DIALOG_PAY_DES = 3;
    private static final int DIALOG_PAY_ERROR_INPUT = 8;
    private static final int DIALOG_PAY_FAILED = 7;
    private static final int DIALOG_PAY_INVALID_ACCOUNT = 9;
    private static final int DIALOG_PAY_NEED_TO_CONFIRM_PAY_RESULT = 10;
    private static final int DIALOG_PAY_SMS_BACK_CONFIRM = 24;
    private static final int DIALOG_PAY_SMS_DELETE_BACK_CONFIRM = 25;
    private static final int DIALOG_PAY_SMS_DELETE_CONFIRM = 23;
    private static final int DIALOG_PAY_SMS_ERROR = 16;
    private static final int DIALOG_PAY_SMS_FAILED = 21;
    private static final int DIALOG_PAY_SMS_RETRY = 26;
    private static final int DIALOG_PAY_SMS_RETRY_MULTIPLE = 27;
    private static final int DIALOG_PAY_SMS_SENDING = 17;
    private static final int DIALOG_PAY_SMS_SEND_FAILED = 18;
    private static final int DIALOG_PAY_SMS_SUCCESS = 20;
    private static final int DIALOG_PAY_SMS_SYNC = 19;
    private static final int DIALOG_PAY_SUCCESS = 13;
    private static final int DIALOG_PROGRESS_BAR = 6;
    private static final int DIALOG_SMS_FAIL = 38;
    private static final int DIALOG_START_ERROR_APPKEY_INVALID = 1;
    private static final int DIALOG_START_ERROR_CPID_INVALID = 22;
    private static final int DIALOG_START_ERROR_PAYMENT_INVALID = 0;
    private static final int DIALOG_TIP = 2;
    private static final int DIALOG_UPOINT_PAYING = 35;
    private static final int DIALOG_UPOINT_PAYPASS_WRONG = 37;
    private static final int DIALOG_UPOINT_TIMESTAMP_WRONG = 36;
    private static final int DIALOG_USERNAME_IS_EMPTY = 30;
    private static final int DIALOG_USERNAME_WRONG = 31;
    private static final int DIALOG_USERNAME_WRONG2 = 32;
    public static final String EXTRA_KEY_NUMBER = "number";
    public static final String EXTRA_KEY_ORDER_ID = "orderId";
    public static final String EXTRA_KEY_PAYMENTINFO = "com.mappn.sdk.paymentinfo";
    public static final int ID_BACK = 9;
    public static final int ID_CANCEL = 10;
    private static final int ID_PAYMENT_TIP = 0;
    private static final int ID_PAY_SMS_CANCEL = 4;
    private static final int ID_PAY_SMS_CONFIRM = 5;
    private static final int ID_PAY_SMS_CONFIRM_CANCEL = 6;
    private static final int ID_PAY_SMS_OK = 3;
    private static final int ID_PAY_UPOINT = 7;
    private static final int ID_PAY_UPOINT_PAYPASS = 8;
    private static final long PAY_SMS_TIMEOUT = 60000L;
    private static final int RETRY_MAX = 2;
    private static final String TERM = ",,,,";
    private static final int TYPE_PAYMENT_LIST = 0;
    private static final int TYPE_PAYMENT_SMS = 4;
    private static final int TYPE_PAYMENT_SMS_CONFIRM = 5;
    private static final int TYPE_PAYMENT_UPOINT_DISCOUNT = 1;
    private static final int TYPE_PAYMENT_UPOINT_LOGIN = 2;
    private static final int TYPE_PAYMENT_UPOINT_PAYPASS = 3;
    private int mBalance;
    private Button mBtnPay;
    private String mConfirmSmsInfoString;
    private EditText mEtPassword;
    private EditText mEtPayPass;
    private CheckBox mEtSavePass;
    private EditText mEtUsername;
    private boolean mIsShowInfo;
    private boolean mIsSynced;
    private boolean mIsValid;
    private int mLeftSmsToReceiveCount;
    private int mLeftSmsToSendCount;
    private ListView mListView;
    private String mNumber;
    private PaymentInfo mPaymentInfo;
    private ContentObserver mSmsContent;
    private Handler mSmsHander;
    private int mSmsId;
    private SmsInfo mSmsInfo;
    private final BroadcastReceiver mSmsReceiver = new /* Unavailable Anonymous Inner Class!! */;
    private String mSmsResultInfo;
    private final Runnable mSmsRunnable = new /* Unavailable Anonymous Inner Class!! */;
    private int mTimeoutCounter;
    private TextView mTvDiscountTextView;
    private TextView mTvProduct;
    private TextView mTvVipDiscountInfo;
    private TextView mTvVipDiscountTextView;
    private TextView mTvVipDiscountTimeTextView;
    private int mType;
    private UPointPayInfo mUPayInfo;

    static /* synthetic */ int access$0(PaymentsActivity paymentsActivity) {
        return paymentsActivity.mType;
    }

    static /* synthetic */ SmsInfo access$1(PaymentsActivity paymentsActivity) {
        return paymentsActivity.mSmsInfo;
    }

    static /* synthetic */ ContentObserver access$10(PaymentsActivity paymentsActivity) {
        return paymentsActivity.mSmsContent;
    }

    static /* synthetic */ int access$11(PaymentsActivity paymentsActivity) {
        return paymentsActivity.mSmsId;
    }

    static /* synthetic */ int access$12(PaymentsActivity paymentsActivity) {
        return paymentsActivity.mLeftSmsToReceiveCount;
    }

    static /* synthetic */ Handler access$13(PaymentsActivity paymentsActivity) {
        return paymentsActivity.mSmsHander;
    }

    static /* synthetic */ Runnable access$14(PaymentsActivity paymentsActivity) {
        return paymentsActivity.mSmsRunnable;
    }

    static /* synthetic */ void access$15(PaymentsActivity paymentsActivity, int n) {
        paymentsActivity.mSmsId = n;
    }

    static /* synthetic */ void access$16(PaymentsActivity paymentsActivity, int n) {
        paymentsActivity.mLeftSmsToReceiveCount = n;
    }

    static /* synthetic */ void access$17(PaymentsActivity paymentsActivity, boolean bl) {
        paymentsActivity.mIsSynced = bl;
    }

    static /* synthetic */ void access$18(PaymentsActivity paymentsActivity, TextView textView, TextView textView2, int n, Button button, Button button2, RelativeLayout relativeLayout) {
        paymentsActivity.initSmsPayView(textView, textView2, n, button, button2, relativeLayout);
    }

    static /* synthetic */ void access$2(PaymentsActivity paymentsActivity, String string, String string2) {
        paymentsActivity.buildSmsPaymentConfirmView(string, string2);
    }

    static /* synthetic */ int access$3(PaymentsActivity paymentsActivity) {
        return paymentsActivity.mLeftSmsToSendCount;
    }

    static /* synthetic */ void access$4(PaymentsActivity paymentsActivity, int n) {
        paymentsActivity.mLeftSmsToSendCount = n;
    }

    static /* synthetic */ int access$5(PaymentsActivity paymentsActivity) {
        return paymentsActivity.getPayedAmount();
    }

    static /* synthetic */ void access$6(PaymentsActivity paymentsActivity) {
        paymentsActivity.buildSmsPaymentView();
    }

    static /* synthetic */ BroadcastReceiver access$7(PaymentsActivity paymentsActivity) {
        return paymentsActivity.mSmsReceiver;
    }

    static /* synthetic */ void access$8(PaymentsActivity paymentsActivity, String string) {
        paymentsActivity.mSmsResultInfo = string;
    }

    static /* synthetic */ PaymentInfo access$9(PaymentsActivity paymentsActivity) {
        return paymentsActivity.mPaymentInfo;
    }

    private void buildPaymentView() {
        this.mType = 0;
        this.mTimeoutCounter = 0;
        this.mLeftSmsToReceiveCount = -1;
        this.mLeftSmsToSendCount = -1;
        this.mIsSynced = false;
        this.mIsShowInfo = false;
        this.mSmsHander = null;
        this.mSmsContent = null;
        RelativeLayout relativeLayout = Utils.initSubTitle((Context)this.getApplicationContext(), (View.OnClickListener)this, (String)"\u8d2d\u4e70\u5185\u5bb9", (boolean)false);
        TextView textView = new TextView(this.getApplicationContext());
        textView.setTextSize(16.0f);
        textView.setTextColor(Color.parseColor((String)"#FF858D8D"));
        textView.setPadding(10, 10, 0, 10);
        textView.setText((CharSequence)"\u5c0a\u656c\u7684\u7528\u6237\uff0c\u60a8\u9700\u8981\u4e3a\u4ee5\u4e0b\u5185\u5bb9\u652f\u4ed8\u8d39\u7528\uff0c\u8bf7\u9605\u8bfb\u4ee5\u4e0b\u4fe1\u606f\uff0c\u786e\u8ba4\u6240\u8d2d\u5185\u5bb9\u65e0\u8bef\u3002");
        TextView textView2 = new TextView(this.getApplicationContext());
        textView2.setTextSize(16.0f);
        textView2.setPadding(20, 0, 20, 0);
        textView2.setText((CharSequence)String.format("\u6240\u8d2d\u5185\u5bb9 : %s", this.mPaymentInfo.getPaydesc()));
        textView2.setTextColor(-12303292);
        String string = new DecimalFormat("##0.00").format((float)this.mPaymentInfo.getMoney() / 10.0f);
        TextView textView3 = new TextView(this.getApplicationContext());
        textView3.setTextSize(16.0f);
        textView3.setPadding(20, 0, 0, 20);
        textView3.setText((CharSequence)String.format("\u652f\u4ed8\u91d1\u989d: %s\u5143", string));
        textView3.setTextColor(-12303292);
        string = new LinearLayout(this.getApplicationContext());
        string.setBackgroundColor(-1);
        string.setOrientation(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        string.addView((View)relativeLayout, (ViewGroup.LayoutParams)layoutParams);
        string.addView((View)textView, (ViewGroup.LayoutParams)layoutParams);
        string.addView((View)textView2, (ViewGroup.LayoutParams)layoutParams);
        string.addView((View)textView3, (ViewGroup.LayoutParams)layoutParams);
        this.mListView = new ListView(this.getApplicationContext());
        this.mListView.setBackgroundColor(-1);
        this.mListView.setCacheColorHint(-1);
        this.mListView.addHeaderView((View)string, null, true);
        this.mListView.setOnItemClickListener((AdapterView.OnItemClickListener)this);
        this.mListView.addFooterView((View)Utils.generateFooterView((Context)this), null, false);
        this.setContentView((View)this.mListView);
        this.fillData();
        new HandlerProxy(this.getApplicationContext(), (Handler.OnFinishListener)this).handleRequest();
    }

    /*
     * Enabled force condition propagation
     */
    private void buildSmsPaymentConfirmView(String string, String string2) {
        this.mType = 5;
        try {
            Utils.CheckSimCardSupprotInfo((Context)this.getApplicationContext());
        }
        catch (SimCardNotSupportException simCardNotSupportException) {
            this.mSmsResultInfo = simCardNotSupportException.getMessage();
            this.showDialog(16);
            return;
        }
        RelativeLayout relativeLayout = new RelativeLayout(this.getApplicationContext());
        relativeLayout.setBackgroundColor(-1);
        relativeLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        RelativeLayout relativeLayout2 = Utils.initSubTitle((Context)this.getApplicationContext(), (View.OnClickListener)this, (String)"\u8d2d\u4e70\u5185\u5bb9", (boolean)true);
        relativeLayout2.setId(1);
        relativeLayout2.setLayoutParams((ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -2));
        relativeLayout.addView((View)relativeLayout2);
        relativeLayout2 = new TextView((Context)this);
        relativeLayout2.setId(2);
        relativeLayout2.setTextSize(16.0f);
        relativeLayout2.setTextColor(-13487566);
        relativeLayout2.setPadding(10, 10, 0, 0);
        relativeLayout2.setFocusable(true);
        relativeLayout2.setClickable(true);
        relativeLayout2.setLinkTextColor(-24576);
        relativeLayout2.setText((CharSequence)String.format("\u518d\u6b21\u70b9\u51fb\u4e0b\u4e00\u6b65\u5373\u540c\u610f\u5411\n%s\u53d1\u9001\u77ed\u4fe1\u4ee5\u5b8c\u6210\u672c\u6b21\u77ed\u4fe1\u53d1\u9001\u8fc7\u7a0b\u3002", string, this.mPaymentInfo.getPayname(), Utils.getSmsPayment()));
        Linkify.addLinks((TextView)relativeLayout2, (int)4);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(3, 1);
        relativeLayout2.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
        relativeLayout.addView((View)relativeLayout2);
        relativeLayout2 = new Button(this.getApplicationContext());
        relativeLayout2.setText((CharSequence)"\u4e0b\u4e00\u6b65");
        relativeLayout2.setId(5);
        this.mConfirmSmsInfoString = String.valueOf(string) + TERM + string2;
        relativeLayout2.setTag((Object)this.mConfirmSmsInfoString);
        relativeLayout2.setOnClickListener((View.OnClickListener)this);
        string = new RelativeLayout.LayoutParams(150, -2);
        string.addRule(12, -1);
        string.setMargins(10, 20, 10, 10);
        relativeLayout2.setLayoutParams((ViewGroup.LayoutParams)string);
        relativeLayout.addView((View)relativeLayout2);
        string = new Button(this.getApplicationContext());
        string.setText((CharSequence)"\u53d6\u6d88");
        string.setId(6);
        string.setOnClickListener((View.OnClickListener)this);
        string2 = new RelativeLayout.LayoutParams(150, -2);
        string2.addRule(11, -1);
        string2.addRule(12, -1);
        string2.setMargins(10, 20, 10, 10);
        string.setLayoutParams((ViewGroup.LayoutParams)string2);
        relativeLayout.addView((View)string);
        this.setContentView((View)relativeLayout);
    }

    /*
     * Enabled force condition propagation
     */
    private void buildSmsPaymentView() {
        this.mType = 4;
        this.mSmsId = 0;
        RelativeLayout relativeLayout = new RelativeLayout(this.getApplicationContext());
        relativeLayout.setBackgroundColor(-1);
        relativeLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        RelativeLayout relativeLayout2 = Utils.initSubTitle((Context)this.getApplicationContext(), (View.OnClickListener)this, (String)"\u77ed\u4fe1\u652f\u4ed8", (boolean)false);
        relativeLayout2.setId(1);
        relativeLayout2.setLayoutParams((ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -2));
        relativeLayout.addView((View)relativeLayout2);
        relativeLayout2 = new TextView((Context)this);
        relativeLayout2.setId(2);
        relativeLayout2.setTextSize(18.0f);
        relativeLayout2.setTextColor(-12303292);
        relativeLayout2.setPadding(10, 10, 0, 0);
        relativeLayout2.setFocusable(true);
        relativeLayout2.setClickable(true);
        relativeLayout2.setLinkTextColor(-24576);
        relativeLayout2.setText((CharSequence)"\u5c0a\u656c\u7684\u7528\u6237\uff0c\u6b63\u5728\u83b7\u53d6\u4fe1\u606f\uff0c\u8bf7\u7a0d\u540e......");
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(3, 1);
        relativeLayout2.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
        relativeLayout.addView((View)relativeLayout2);
        layoutParams = new TextView((Context)this);
        layoutParams.setId(3);
        layoutParams.setTextSize(16.0f);
        layoutParams.setTextColor(-7829368);
        layoutParams.setPadding(10, 30, 0, 0);
        layoutParams.setFocusable(true);
        layoutParams.setClickable(true);
        layoutParams.setLinkTextColor(-24576);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.addRule(3, 2);
        layoutParams.setLayoutParams((ViewGroup.LayoutParams)layoutParams2);
        relativeLayout.addView((View)layoutParams);
        Button button = new Button(this.getApplicationContext());
        button.setText((CharSequence)"\u70b9\u64ad");
        button.setId(3);
        button.setOnClickListener((View.OnClickListener)this);
        layoutParams2 = new Button(this.getApplicationContext());
        layoutParams2.setText((CharSequence)"\u53d6\u6d88");
        layoutParams2.setId(4);
        layoutParams2.setOnClickListener((View.OnClickListener)this);
        try {
            Utils.CheckSimCardSupprotInfo((Context)this.getApplicationContext());
        }
        catch (SimCardNotSupportException simCardNotSupportException) {
            this.mSmsResultInfo = simCardNotSupportException.getMessage();
            this.showDialog(16);
            return;
        }
        int n = Utils.getSmsPayment();
        if (n <= PrefUtil.getPayedAmount((Context)this.getApplicationContext())) {
            this.mSmsResultInfo = "\u60a8\u5df2\u652f\u4ed8\u5b8c\u6210\uff0c\u5c06\u8fd4\u56de\u60a8\u7684\u6e38\u620f\u4e2d\u3002";
            this.showDialog(20);
            return;
        }
        if (!this.mIsSynced) {
            this.showDialog(19);
            new SyncSmsInfoHandler(this.getApplicationContext(), (Handler.OnFinishListener)new /* Unavailable Anonymous Inner Class!! */).handleRequest();
            return;
        }
        this.initSmsPayView((TextView)relativeLayout2, (TextView)layoutParams, n, (Button)layoutParams2, button, relativeLayout);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private void buildUPointPayLoginView() {
        this.mType = 2;
        var2_1 = Utils.initSubTitle((Context)this.getApplicationContext(), (View.OnClickListener)this, (String)"\u8bf7\u60a8\u8f93\u5165UC\u5e10\u53f7", (boolean)true);
        var2_1.setId(10);
        var1_2 /* !! */  = new RelativeLayout.LayoutParams(-1, -2);
        var1_2 /* !! */ .addRule(10, -1);
        var2_1.setLayoutParams((ViewGroup.LayoutParams)var1_2 /* !! */ );
        var3_3 = new TextView(this.getApplicationContext());
        var1_2 /* !! */  = new RelativeLayout.LayoutParams(-1, -2);
        var1_2 /* !! */ .addRule(3, 10);
        var1_2 /* !! */ .setMargins(10, 5, 10, 10);
        var3_3.setLayoutParams((ViewGroup.LayoutParams)var1_2 /* !! */ );
        var3_3.setId(1);
        var3_3.setCompoundDrawablePadding(10);
        var3_3.setTextColor(-13487566);
        if (Utils.isHdpi()) {
            var1_2 /* !! */  = "lock_hdpi.png";
lbl17:
            // 2 sources

            while (true) {
                var3_3.setCompoundDrawablesWithIntrinsicBounds(Utils.getDrawableFromFile((String)var1_2 /* !! */ ), null, null, null);
                var3_3.setText((CharSequence)"\u60a8\u597d\uff0c\u8d2d\u4e70\u6b64\u5185\u5bb9\uff0c\u8bf7\u5148\u767b\u5f55UC\u8d26\u53f7\u3002\u60a8\u53ef\u4ee5\u8f93\u5165UC\u5e10\u53f7\u6216\u8005\u624b\u673a\u53f7\u7801\u8fdb\u884c\u767b\u5f55");
                var1_2 /* !! */  = Utils.generateBorderView((Context)this.getApplication());
                var1_2 /* !! */ .setId(11);
                var4_4 = new RelativeLayout.LayoutParams(-1, 1);
                var4_4.addRule(3, 1);
                var1_2 /* !! */ .setLayoutParams((ViewGroup.LayoutParams)var4_4);
                var5_5 = new RelativeLayout.LayoutParams(-1, -2);
                var5_5.setMargins(10, 10, 10, 5);
                var4_4 = new TextView(this.getApplicationContext());
                var4_4.setLayoutParams((ViewGroup.LayoutParams)var5_5);
                var4_4.setId(2);
                var4_4.setText((CharSequence)"UC\u8d26\u53f7:");
                var4_4.setTextColor(-13487566);
                var5_5 = new RelativeLayout.LayoutParams(-1, -2);
                var5_5.addRule(3, 2);
                var5_5.setMargins(10, 5, 10, 5);
                this.mEtUsername = new EditText(this.getApplicationContext());
                this.mEtUsername.setLayoutParams((ViewGroup.LayoutParams)var5_5);
                this.mEtUsername.setSingleLine();
                this.mEtUsername.setId(3);
                this.mEtUsername.setHint((CharSequence)"\u7528\u6237\u540d");
                this.mEtPassword = new EditText(this.getApplicationContext());
                this.mEtPassword.setId(4);
                this.mEtPassword.setHint((CharSequence)"\u5bc6\u7801");
                this.mEtPassword.setSingleLine();
                this.mEtPassword.setTransformationMethod((TransformationMethod)PasswordTransformationMethod.getInstance());
                var5_5 = new RelativeLayout.LayoutParams(-1, -2);
                var5_5.addRule(3, 3);
                var5_5.setMargins(10, 5, 10, 5);
                this.mEtPassword.setLayoutParams((ViewGroup.LayoutParams)var5_5);
                this.mEtSavePass = new CheckBox(this.getApplicationContext());
                var5_5 = new RelativeLayout.LayoutParams(-1, -2);
                var5_5.addRule(3, 4);
                var5_5.setMargins(10, 5, 10, 5);
                this.mEtSavePass.setId(5);
                this.mEtSavePass.setTextColor(-12303292);
                this.mEtSavePass.setText((CharSequence)"\u4fdd\u5b58\u5bc6\u7801");
                this.mEtSavePass.setLayoutParams((ViewGroup.LayoutParams)var5_5);
                if (PrefUtil.getUCUserName((Context)this.getApplicationContext()) != null) {
                    this.mEtUsername.setText((CharSequence)PrefUtil.getUCUserName((Context)this.getApplicationContext()));
                    this.mEtSavePass.setChecked(true);
lbl60:
                    // 2 sources

                    while (true) {
                        if (PrefUtil.getUCUserPass((Context)this.getApplicationContext()) != null) {
                            this.mEtPassword.setText((CharSequence)PrefUtil.getUCUserPass((Context)this.getApplicationContext()));
                        }
                        var6_6 = new Button(this.getApplicationContext());
                        var6_6.setId(7);
                        var6_6.setText((CharSequence)"\u786e\u5b9a\u8d2d\u4e70");
                        var6_6.setOnClickListener((View.OnClickListener)this);
                        var5_5 = new RelativeLayout.LayoutParams(-1, -2);
                        var5_5.topMargin = 10;
                        var5_5.addRule(3, 5);
                        var5_5.addRule(14);
                        var6_6.setLayoutParams((ViewGroup.LayoutParams)var5_5);
                        var5_5 = new RelativeLayout(this.getApplicationContext());
                        var5_5.setId(7);
                        var5_5.setBackgroundColor(-984326);
                        var7_7 = new RelativeLayout.LayoutParams(-1, -2);
                        var7_7.addRule(3, 11);
                        var5_5.setLayoutParams((ViewGroup.LayoutParams)var7_7);
                        var5_5.addView((View)var4_4);
                        var5_5.addView((View)this.mEtUsername);
                        var5_5.addView((View)this.mEtPassword);
                        var5_5.addView((View)this.mEtSavePass);
                        var5_5.addView((View)var6_6);
                        var4_4 = new RelativeLayout(this.getApplicationContext());
                        var4_4.setBackgroundColor(-1);
                        var4_4.setLayoutParams((ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -1));
                        var4_4.addView((View)var2_1);
                        var4_4.addView((View)var3_3);
                        var4_4.addView((View)var1_2 /* !! */ );
                        var4_4.addView((View)var5_5);
                        var1_2 /* !! */  = Utils.generateBorderView((Context)this.getApplication());
                        var2_1 = new RelativeLayout.LayoutParams(-1, 1);
                        var2_1.addRule(3, 7);
                        var1_2 /* !! */ .setLayoutParams((ViewGroup.LayoutParams)var2_1);
                        var4_4.addView((View)var1_2 /* !! */ );
                        var1_2 /* !! */  = new ScrollView((Context)this.getApplication());
                        var1_2 /* !! */ .setBackgroundColor(-1);
                        var1_2 /* !! */ .addView((View)var4_4);
                        this.setContentView((View)var1_2 /* !! */ );
                        return;
                    }
                }
                break;
            }
        } else {
            var1_2 /* !! */  = "lock.png";
            ** continue;
        }
        this.mEtSavePass.setChecked(false);
        ** while (true)
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private void buildUPointPayPassView() {
        this.mType = 3;
        var2_1 = Utils.initSubTitle((Context)this.getApplicationContext(), (View.OnClickListener)this, (String)"\u8bf7\u60a8\u8f93\u5165U\u70b9\u652f\u4ed8\u5bc6\u7801", (boolean)true);
        var2_1.setId(10);
        var1_2 /* !! */  = new RelativeLayout.LayoutParams(-1, -2);
        var1_2 /* !! */ .addRule(10, -1);
        var2_1.setLayoutParams((ViewGroup.LayoutParams)var1_2 /* !! */ );
        var3_3 = new TextView(this.getApplicationContext());
        var1_2 /* !! */  = new RelativeLayout.LayoutParams(-1, -2);
        var1_2 /* !! */ .addRule(3, 10);
        var1_2 /* !! */ .setMargins(10, 5, 10, 10);
        var3_3.setLayoutParams((ViewGroup.LayoutParams)var1_2 /* !! */ );
        var3_3.setId(1);
        var3_3.setCompoundDrawablePadding(10);
        var3_3.setTextColor(-13487566);
        if (Utils.isHdpi()) {
            var1_2 /* !! */  = "lock_hdpi.png";
lbl17:
            // 2 sources

            while (true) {
                var3_3.setCompoundDrawablesWithIntrinsicBounds(Utils.getDrawableFromFile((String)var1_2 /* !! */ ), null, null, null);
                var3_3.setText((CharSequence)"\u60a8\u597d\uff0c\u60a8\u7684U\u70b9\u8bbe\u7f6e\u6709\u652f\u4ed8\u5bc6\u7801\uff0c\u8bf7\u6536\u5165\u540e\u70b9\u51fb\u786e\u8ba4\u8fdb\u884c\u652f\u4ed8");
                var1_2 /* !! */  = Utils.generateBorderView((Context)this.getApplication());
                var1_2 /* !! */ .setId(11);
                var4_4 = new RelativeLayout.LayoutParams(-1, 1);
                var4_4.addRule(3, 1);
                var1_2 /* !! */ .setLayoutParams((ViewGroup.LayoutParams)var4_4);
                var5_5 = new RelativeLayout.LayoutParams(-1, -2);
                var5_5.setMargins(10, 10, 10, 5);
                var4_4 = new TextView(this.getApplicationContext());
                var4_4.setLayoutParams((ViewGroup.LayoutParams)var5_5);
                var4_4.setId(2);
                var4_4.setText((CharSequence)"UC\u652f\u4ed8\u5bc6\u7801:");
                var4_4.setTextColor(-13487566);
                var5_5 = new RelativeLayout.LayoutParams(-1, -2);
                var5_5.addRule(3, 2);
                var5_5.setMargins(10, 5, 10, 5);
                this.mEtPayPass = new EditText(this.getApplicationContext());
                this.mEtPayPass.setLayoutParams((ViewGroup.LayoutParams)var5_5);
                this.mEtPayPass.setSingleLine();
                this.mEtPayPass.setId(3);
                this.mEtPayPass.setHint((CharSequence)"\u652f\u4ed8\u5bc6\u7801");
                var6_6 = new Button(this.getApplicationContext());
                var6_6.setId(7);
                var6_6.setText((CharSequence)"\u786e\u5b9a\u8d2d\u4e70");
                var6_6.setOnClickListener((View.OnClickListener)this);
                var5_5 = new RelativeLayout.LayoutParams(-1, -2);
                var5_5.topMargin = 10;
                var5_5.addRule(3, 5);
                var5_5.addRule(14);
                var6_6.setLayoutParams((ViewGroup.LayoutParams)var5_5);
                var5_5 = new RelativeLayout(this.getApplicationContext());
                var5_5.setId(7);
                var5_5.setBackgroundColor(-984326);
                var7_7 = new RelativeLayout.LayoutParams(-1, -2);
                var7_7.addRule(3, 11);
                var5_5.setLayoutParams((ViewGroup.LayoutParams)var7_7);
                var5_5.addView((View)var4_4);
                var5_5.addView((View)this.mEtPayPass);
                var5_5.addView((View)var6_6);
                var4_4 = new RelativeLayout(this.getApplicationContext());
                var4_4.setBackgroundColor(-1);
                var4_4.setLayoutParams((ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -1));
                var4_4.addView((View)var2_1);
                var4_4.addView((View)var3_3);
                var4_4.addView((View)var1_2 /* !! */ );
                var4_4.addView((View)var5_5);
                var2_1 = Utils.generateBorderView((Context)this.getApplication());
                var1_2 /* !! */  = new RelativeLayout.LayoutParams(-1, 1);
                var1_2 /* !! */ .addRule(3, 7);
                var2_1.setLayoutParams((ViewGroup.LayoutParams)var1_2 /* !! */ );
                var4_4.addView((View)var2_1);
                var1_2 /* !! */  = new ScrollView((Context)this.getApplication());
                var1_2 /* !! */ .setBackgroundColor(-1);
                var1_2 /* !! */ .addView((View)var4_4);
                this.setContentView((View)var1_2 /* !! */ );
                return;
            }
        }
        var1_2 /* !! */  = "lock.png";
        ** while (true)
    }

    /*
     * Enabled force condition propagation
     */
    private void buildUPointPaymentView() {
        this.mType = 1;
        TextView textView = new TextView(this.getApplicationContext());
        textView.setTextSize(16.0f);
        textView.setPadding(20, 0, 20, 0);
        textView.setTextColor(-12303292);
        textView.setText((CharSequence)String.format("\u652f\u4ed8\u540d\u79f0 : %s", this.mPaymentInfo.getPayname()));
        this.mTvProduct = new TextView(this.getApplicationContext());
        this.mTvProduct.setTextSize(16.0f);
        this.mTvProduct.setPadding(20, 0, 20, 0);
        this.mTvProduct.setText((CharSequence)"\u4ea7\u54c1\u540d : ");
        this.mTvProduct.setTextColor(-12303292);
        TextView textView2 = new TextView(this.getApplicationContext());
        textView2.setTextSize(16.0f);
        textView2.setPadding(20, 0, 20, 20);
        textView2.setText((CharSequence)String.format("\u6240\u8d2d\u5185\u5bb9 : %s", this.mPaymentInfo.getPaydesc()));
        textView2.setTextColor(-12303292);
        TextView textView3 = new TextView(this.getApplicationContext());
        textView3.setTextSize(16.0f);
        textView3.setPadding(20, 0, 20, 0);
        textView3.setText((CharSequence)String.format("\u652f\u4ed8\u6570\u989d : %dU\u70b9\uff08\u4ef7\u503c%s\u5143\uff09", this.mPaymentInfo.getMoney(), new DecimalFormat("##0.00").format((float)this.mPaymentInfo.getMoney() / 10.0f)));
        textView3.setTextColor(-13487566);
        this.mTvDiscountTextView = new TextView(this.getApplicationContext());
        this.mTvDiscountTextView.setTextSize(16.0f);
        this.mTvDiscountTextView.setPadding(20, 0, 20, 0);
        this.mTvDiscountTextView.setText((CharSequence)"U\u70b9\u6298\u6263 : ");
        this.mTvDiscountTextView.setTextColor(-13487566);
        this.mTvVipDiscountTextView = new TextView(this.getApplicationContext());
        this.mTvVipDiscountTextView.setTextSize(16.0f);
        this.mTvVipDiscountTextView.setPadding(20, 0, 20, 0);
        this.mTvVipDiscountTextView.setText((CharSequence)"\u4f1a\u5458\u6298\u6263 : ");
        this.mTvVipDiscountTextView.setTextColor(-13487566);
        this.mTvVipDiscountTimeTextView = new TextView(this.getApplicationContext());
        this.mTvVipDiscountTimeTextView.setTextSize(16.0f);
        this.mTvVipDiscountTimeTextView.setPadding(20, 0, 20, 0);
        this.mTvVipDiscountTimeTextView.setText((CharSequence)"\u4f1a\u5458\u6298\u6263\u5230\u671f\u65f6\u95f4 : ");
        this.mTvVipDiscountInfo = new TextView(this.getApplicationContext());
        this.mTvVipDiscountInfo.setTextColor(-13487566);
        this.mTvVipDiscountInfo = new TextView(this.getApplicationContext());
        this.mTvVipDiscountInfo.setTextSize(16.0f);
        this.mTvVipDiscountInfo.setPadding(20, 0, 20, 0);
        this.mTvVipDiscountInfo.setText((CharSequence)"\u4f1a\u5458\u6298\u6263\u4fe1\u606f : ");
        this.mTvVipDiscountInfo.setTextColor(-13487566);
        this.mBtnPay = new Button(this.getApplicationContext());
        this.mBtnPay.setText((CharSequence)"\u786e\u8ba4");
        this.mBtnPay.setOnClickListener((View.OnClickListener)this);
        this.mBtnPay.setVisibility(8);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(300, -2);
        layoutParams.gravity = 1;
        LinearLayout linearLayout = new LinearLayout(this.getApplicationContext());
        linearLayout.addView((View)this.mBtnPay, (ViewGroup.LayoutParams)layoutParams);
        linearLayout.setGravity(1);
        layoutParams = new LinearLayout(this.getApplicationContext());
        layoutParams.setOrientation(1);
        layoutParams.setBackgroundColor(-1);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.addView((View)Utils.initSubTitle((Context)this.getApplicationContext(), (View.OnClickListener)this, (String)"\u9700\u8981\u652f\u4ed8\u7684\u5185\u5bb9", (boolean)true), (ViewGroup.LayoutParams)layoutParams2);
        layoutParams.addView((View)textView, (ViewGroup.LayoutParams)layoutParams2);
        layoutParams.addView((View)this.mTvProduct, (ViewGroup.LayoutParams)layoutParams2);
        layoutParams.addView((View)textView2, (ViewGroup.LayoutParams)layoutParams2);
        layoutParams.addView((View)textView3, (ViewGroup.LayoutParams)layoutParams2);
        layoutParams.addView((View)this.mTvDiscountTextView, (ViewGroup.LayoutParams)layoutParams2);
        layoutParams.addView((View)this.mTvVipDiscountTextView, (ViewGroup.LayoutParams)layoutParams2);
        layoutParams.addView((View)this.mTvVipDiscountTimeTextView, (ViewGroup.LayoutParams)layoutParams2);
        layoutParams.addView((View)this.mTvVipDiscountInfo, (ViewGroup.LayoutParams)layoutParams2);
        layoutParams.addView((View)linearLayout, (ViewGroup.LayoutParams)layoutParams2);
        textView = new ScrollView(this.getApplicationContext());
        textView.setBackgroundColor(-1);
        textView.addView((View)layoutParams);
        this.setContentView((View)textView);
        if (Utils.getUPointInfo() == null) {
            this.showDialog(14);
            Api.queryUPointDiscount((Context)this.getApplicationContext(), (ApiTask.TaskHandler)this, (String)Utils.getPaymentInfo().getCpID(), (String)Utils.getPaymentInfo().getmGameID(), (int)Utils.getPaymentInfo().getMoney());
            return;
        }
        this.initUPointPayView(Utils.getUPointInfo());
    }

    /*
     * Unable to fully structure code
     */
    private void fillData() {
        block6: {
            block5: {
                var2_1 = PrefUtil.getAvailablePayType((Context)this.getApplicationContext(), (String)this.mPaymentInfo.getPaytype());
                var1_2 = new IType[var2_1.size()];
                if (!"overage".equals(this.mPaymentInfo.getPaytype())) break block5;
                var3_3 = var2_1.iterator();
                do {
                    if (var3_3.hasNext()) continue;
lbl7:
                    // 5 sources

                    while (true) {
                        this.mListView.setAdapter((ListAdapter)new CustomAdapter(this.getApplicationContext(), var1_2));
                        return;
                    }
                } while (!"upoint".equals((var2_1 = (IType)var3_3.next()).getId()));
                var1_2[0] = var2_1;
                ** GOTO lbl7
            }
            if (!"sms".equals(this.mPaymentInfo.getPaytype())) break block6;
            var2_1 = var2_1.iterator();
            do {
                if (!var2_1.hasNext()) ** GOTO lbl7
            } while (!"sms".equals((var3_4 = (IType)var2_1.next()).getId()));
            var1_2[0] = var3_4;
            ** GOTO lbl7
        }
        var2_1 = var2_1.iterator();
        while (true) {
            if (var2_1.hasNext()) ** break;
            ** continue;
            var3_5 = (IType)var2_1.next();
            if ("upoint".equals(var3_5.getId())) {
                var1_2[0] = var3_5;
                continue;
            }
            if (!"sms".equals(var3_5.getId())) continue;
            var1_2[var1_2.length - 1] = var3_5;
        }
    }

    private int getPayedAmount() {
        int n = (Utils.getSmsPayment() - PrefUtil.getPayedAmount((Context)this.getApplicationContext())) / this.mSmsInfo.money;
        return this.mSmsInfo.money * (n - this.mLeftSmsToSendCount);
    }

    public static void init(Context context) {
        SyncChargeChannelHandler.init();
        SyncPayChannelHandler.init();
        SyncSmsInfoHandler.init();
    }

    /*
     * Unable to fully structure code
     */
    private boolean initPayment() {
        this.mPaymentInfo = (PaymentInfo)this.getIntent().getSerializableExtra("com.mappn.sdk.paymentinfo");
        if (this.mPaymentInfo == null) {
            throw new IllegalArgumentException("PaymentInfo\u5fc5\u987b\u8bbe\u7f6e");
        }
        this.mPaymentInfo.setPaytype("sms");
        var1_1 = this.mPaymentInfo.getMoney();
        if (var1_1 <= 0 || var1_1 > 10000 || var1_1 % 5 != 0) {
            this.showDialog(0);
            var2_2 = false;
lbl9:
            // 3 sources

            return var2_2;
        }
        if (this.mPaymentInfo.getPayname() == null) {
            throw new IllegalArgumentException("\u5fc5\u987b\u6307\u5b9a\u652f\u4ed8\u5185\u5bb9\u540d\u79f0");
        }
        if (this.mPaymentInfo.getPaydesc() == null) {
            throw new IllegalArgumentException("\u5fc5\u987b\u6307\u5b9a\u652f\u4ed8\u5185\u5bb9\u63cf\u8ff0");
        }
        if (this.mPaymentInfo.getmGameID() == null) {
            throw new IllegalArgumentException("\u5fc5\u987b\u6307\u5b9a\u6e38\u620fID");
        }
        if (this.mPaymentInfo.getmGameID().length() != 2) {
            throw new IllegalArgumentException("\u6e38\u620fID\u5fc5\u987b\u4e3a\u4e24\u4f4d\u6570\u5b57");
        }
        if (!Utils.isNumeric((String)this.mPaymentInfo.getmGameID())) {
            throw new IllegalArgumentException("\u6e38\u620fID\u5fc5\u987b\u4e3a\u4e24\u4f4d\u6570\u5b57");
        }
        if (this.mPaymentInfo.getmActionID() == null) {
            throw new IllegalArgumentException("\u5fc5\u987b\u6307\u5b9a\u652f\u4ed8\u70b9ID");
        }
        if (this.mPaymentInfo.getmActionID().length() != 2) {
            throw new IllegalArgumentException("\u652f\u4ed8\u70b9ID\u5fc5\u987b\u4e3a\u4e24\u4f4d\u6570\u5b57");
        }
        if (!Utils.isNumeric((String)this.mPaymentInfo.getmActionID())) {
            throw new IllegalArgumentException("\u652f\u4ed8\u70b9ID\u5fc5\u987b\u4e3a\u4e24\u4f4d\u6570\u5b57");
        }
        if (this.mPaymentInfo.getPayname().length() > 50) {
            this.mPaymentInfo.setPayname(this.mPaymentInfo.getPayname().substring(0, 50));
        }
        if (this.mPaymentInfo.getPaydesc().length() > 100) {
            this.mPaymentInfo.setPaydesc(this.mPaymentInfo.getPaydesc().substring(0, 100));
        }
        try {
            block18: {
                var3_3 = Utils.getCpID((Context)this.getApplicationContext());
                if (Pattern.matches("^[0-9a-zA-Z]{1,10}$", var3_3)) break block18;
                this.showDialog(22);
                var2_2 = false;
                ** GOTO lbl9
            }
            this.mPaymentInfo.setCpID(var3_3);
        }
        catch (PackageManager.NameNotFoundException var3_4) {
            this.showDialog(22);
        }
        catch (NullPointerException var3_5) {
            this.showDialog(22);
            ** continue;
        }
lbl39:
        // 3 sources

        while (true) {
            if (this.mPaymentInfo.getUsername() != null) {
                PrefUtil.setUCUserName((Context)this.getApplicationContext(), (String)this.mPaymentInfo.getUsername());
            }
            Utils.setPaymentInfo((PaymentInfo)this.mPaymentInfo);
            var2_2 = true;
            ** continue;
            break;
        }
    }

    /*
     * Exception decompiling
     */
    private void initSmsPayView(TextView var1_1, TextView var2_3, int var3_4, Button var4_5, Button var5_6, RelativeLayout var6_7) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * java.lang.IllegalStateException: Backjump on non jumping statement @NONE, blocks:[] lbl55 : TryStatement: try { 2[TRYBLOCK]
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

    /*
     * Unable to fully structure code
     */
    private void initUPointPayView(UPointInfo var1_1) {
        this.mTvDiscountTextView.setText((CharSequence)String.format("U\u70b9\u6298\u6263 : %s\u6298(%sU\u70b9)", new Object[]{var1_1.getDiscount(), var1_1.getDiscounttext()}));
        if (var1_1.getVipdiscount() != null && var1_1.getVipdiscount().length() > 0) {
            this.mTvDiscountTextView.setText((CharSequence)String.format("\u4f1a\u5458\u6298\u6263 : %s\u6298(%sU\u70b9)", new Object[]{var1_1.getVipdiscount(), var1_1.getVipdiscounttext()}));
            this.mTvVipDiscountTimeTextView.setText((CharSequence)String.format("\u4f1a\u5458\u6298\u6263\u5230\u671f\u65f6\u95f4 : ", new Object[]{var1_1.getVipdiscounttime()}));
            this.mTvVipDiscountInfo.setText((CharSequence)("\u4f1a\u5458\u6298\u6263\u5230\u671f\u65f6\u95f4 : " + var1_1.getDiscountinfo()));
lbl6:
            // 2 sources

            while (true) {
                this.mBtnPay.setVisibility(0);
                return;
            }
        }
        this.mTvVipDiscountTextView.setVisibility(8);
        this.mTvVipDiscountTimeTextView.setVisibility(8);
        this.mTvVipDiscountInfo.setVisibility(8);
        ** while (true)
    }

    private void pay() {
        this.showDialog(6);
        Api.pay((Context)this.getApplicationContext(), (ApiTask.TaskHandler)this, (PaymentInfo)this.mPaymentInfo, (UPointPayInfo)this.mUPayInfo);
    }

    /*
     * Unable to fully structure code
     */
    private void sendConfirmSms(String var1_1) {
        this.showDialog(17);
        try {
            SmsInfo.sendSms((Context)this.getApplicationContext(), (String)var1_1.split(",,,,")[0], (String)var1_1.split(",,,,")[1]);
lbl4:
            // 2 sources

            return;
        }
        catch (Exception var1_2) {
            if (this.mSmsHander != null && this.mSmsRunnable != null) {
                this.mSmsHander.removeCallbacks(this.mSmsRunnable);
                this.getContentResolver().unregisterContentObserver(this.mSmsContent);
                this.unregisterReceiver(this.mSmsReceiver);
            }
lbl12:
            // 4 sources

            while (true) {
                this.removeDialog(17);
                this.showDialog(38);
                ** continue;
                break;
            }
            catch (IllegalArgumentException var1_3) {
                ** continue;
            }
        }
    }

    /*
     * Unable to fully structure code
     */
    private void sendFirstSms(SmsInfo var1_1) {
        this.showDialog(17);
        try {
            var1_1.sendFirstSms(this.getApplicationContext());
lbl4:
            // 2 sources

            return;
        }
        catch (Exception var1_2) {
            if (this.mSmsHander != null && this.mSmsRunnable != null) {
                this.mSmsHander.removeCallbacks(this.mSmsRunnable);
                this.getContentResolver().unregisterContentObserver(this.mSmsContent);
                this.unregisterReceiver(this.mSmsReceiver);
            }
lbl12:
            // 4 sources

            while (true) {
                this.removeDialog(17);
                this.showDialog(38);
                ** continue;
                break;
            }
            catch (IllegalArgumentException var1_3) {
                ** continue;
            }
        }
    }

    public void confirmEnterPaymentPoint() {
        PrefUtil.increaseArriveCount((Context)this.getApplicationContext());
    }

    protected void onActivityResult(int n, int n2, Intent intent) {
        super.onActivityResult(n, n2, intent);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public void onClick(View var1_1) {
        if (var1_1 /* !! */  == this.mBtnPay) {
            this.mBtnPay.setEnabled(false);
            this.buildUPointPayLoginView();
lbl4:
            // 27 sources

            return;
        }
        switch (var1_1 /* !! */ .getId()) {
            default: {
                ** GOTO lbl4
            }
lbl9:
            // 3 sources

            case 3: {
                if (!this.mIsShowInfo) break;
                this.buildSmsPaymentView();
                this.mIsShowInfo = false;
                ** GOTO lbl4
            }
            case 7: {
                ((Button)var1_1 /* !! */ ).setEnabled(false);
                var3_2 = this.mEtUsername.getText().toString();
                var1_1 /* !! */  = this.mEtPassword.getText().toString();
                if (!TextUtils.isEmpty((CharSequence)var3_2) || !TextUtils.isEmpty((CharSequence)var1_1 /* !! */ )) ** GOTO lbl21
                this.showDialog(28);
                ** GOTO lbl4
lbl21:
                // 1 sources

                if (!TextUtils.isEmpty((CharSequence)var1_1 /* !! */ )) ** GOTO lbl24
                this.showDialog(29);
                ** GOTO lbl4
lbl24:
                // 1 sources

                if (!TextUtils.isEmpty((CharSequence)var3_2)) ** GOTO lbl27
                this.showDialog(30);
                ** GOTO lbl4
lbl27:
                // 1 sources

                this.mUPayInfo = new UPointPayInfo(var3_2, (String)var1_1 /* !! */ , "", this.mPaymentInfo.getCpID(), this.mPaymentInfo.getmGameID(), this.mPaymentInfo.getMoney(), "");
                this.pay();
                ** GOTO lbl4
            }
            case 8: {
                ((Button)var1_1 /* !! */ ).setEnabled(false);
                var1_1 /* !! */  = this.mEtPayPass.getText().toString();
                if (!TextUtils.isEmpty((CharSequence)var1_1 /* !! */ )) ** GOTO lbl36
                this.showDialog(28);
                ** GOTO lbl9
lbl36:
                // 1 sources

                this.mUPayInfo.setPaypwd((String)var1_1 /* !! */ );
                this.pay();
                ** GOTO lbl9
            }
        }
        if (this.mSmsInfo == null) ** GOTO lbl4
        this.registerReceiver(this.mSmsReceiver, new IntentFilter("com.uc.androidsdk.SMS_SENT_ACTION"));
        this.sendFirstSms(this.mSmsInfo);
        ** GOTO lbl4
        {
            case 5: {
                if (this.mConfirmSmsInfoString == null || !this.mConfirmSmsInfoString.contains(",,,,")) ** GOTO lbl4
                this.sendConfirmSms(this.mConfirmSmsInfoString);
                ** GOTO lbl4
            }
            case 4: {
                this.buildPaymentView();
                ** GOTO lbl4
            }
            case 6: {
                this.showDialog(23);
                ** GOTO lbl4
            }
            case 9: {
                switch (this.mType) {
                    default: {
                        ** GOTO lbl4
                    }
                    case 0: {
                        this.finish();
                        ** GOTO lbl4
                    }
                    case 1: {
                        this.buildPaymentView();
                        ** GOTO lbl4
                    }
                    case 2: {
                        this.buildUPointPaymentView();
                        ** GOTO lbl4
                    }
                    case 3: {
                        this.buildUPointPayLoginView();
                        ** GOTO lbl4
                    }
                    case 4: {
                        if (this.mSmsInfo.isNeedconfirm() || this.mIsShowInfo) ** GOTO lbl78
                        var2_3 = Utils.getSmsPayment() / this.mSmsInfo.money;
                        if (this.mLeftSmsToSendCount == -1 || this.mLeftSmsToSendCount == var2_3) ** GOTO lbl76
                        this.showDialog(27);
                        ** GOTO lbl4
lbl76:
                        // 1 sources

                        this.buildSmsPaymentView();
                        ** GOTO lbl4
lbl78:
                        // 1 sources

                        this.buildPaymentView();
                        ** GOTO lbl4
                    }
                    case 5: 
                }
                this.showDialog(23);
                ** GOTO lbl4
            }
            ** case 10:
        }
lbl84:
        // 1 sources

        switch (this.mType) {
            default: {
                this.finish();
                ** GOTO lbl4
            }
            case 4: {
                if (!this.mSmsInfo.isNeedconfirm() && !this.mIsShowInfo) ** GOTO lbl4
                var2_4 = Utils.getSmsPayment() / this.mSmsInfo.money;
                if (this.mLeftSmsToSendCount == -1 || this.mLeftSmsToSendCount == var2_4) ** GOTO lbl94
                this.showDialog(27);
                ** GOTO lbl4
lbl94:
                // 1 sources

                this.buildPaymentView();
                ** GOTO lbl4
            }
            case 5: 
        }
        this.showDialog(23);
        ** while (true)
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mIsValid = this.initPayment();
        if (this.mIsValid) {
            Utils.init((Context)this.getApplicationContext());
            Utils.initTitleBar((Activity)this);
            this.buildPaymentView();
            this.confirmEnterPaymentPoint();
            new HandlerProxy(this.getApplicationContext()).handleRequest();
        }
    }

    /*
     * Enabled force condition propagation
     */
    protected Dialog onCreateDialog(int n) {
        switch (n) {
            default: {
                return super.onCreateDialog(n);
            }
            case 0: {
                return DialogUtil.createOKWarningDialog((Context)this, (int)n, (CharSequence)"\u8be5\u5e94\u7528\u8981\u6c42\u652f\u4ed8\u7684\u91d1\u989d\u4e0d\u7b26\u5408\u8981\u6c42\uff0c\u4e0d\u80fd\u6210\u529f\u652f\u4ed8\u3002", (DialogUtil.WarningDialogListener)this);
            }
            case 22: {
                return DialogUtil.createOKWarningDialog((Context)this, (int)n, (CharSequence)"CPID\u4e3a\u5b57\u7b26\u4e32\u548c\u6570\u5b57\u4efb\u610f\u7ec4\u5408\uff0c\u4e0d\u80fd\u7531\u4e2d\u6587\u5b57\u7b26\u3001\u6807\u70b9\u7b26\u53f7\u6216\u7a7a\u683c\uff0c\u957f\u5ea6\u4e0d\u8d85\u8fc710\u4e2a\u82f1\u6587\u5b57\u7b26\u3002", (DialogUtil.WarningDialogListener)this);
            }
            case 2: {
                return DialogUtil.createOKWarningDialogSupportLink((Context)this, (int)n, (String)"\u4ec0\u4e48\u662fU\u70b9?", (String)"U\u70b9\u662f<a href='http://wap.uc.cn'>UC-\u4f18\u89c6</a>\u63d0\u4f9b\u7684\u4e00\u79cd\u865a\u62df\u8d27\u5e01\uff0c\u4e3b\u8981\u7528\u4e8e\u8d2d\u4e70\u8f6f\u4ef6\u548c\u6e38\u620f\u91cc\u7684\u5185\u5bb9\uff08\u5982\uff1a\u9053\u5177\u3001\u5173\u5361\u3001\u8f6f\u4ef6\u3001\u4f7f\u7528\u65f6\u957f\u7b49\uff09\u3002<br /><br />U\u70b9\u5151\u6362\u6807\u51c6\uff1a<br />1\u5143\u53ef\u5151\u636210U\u70b9\u3002<br />\u901a\u8fc7\u4ee5\u4e0b\u94fe\u63a5\u5145\u503cU\u70b9\uff1a<br /><a href='http://pay.uc.cn'>UC-\u4f18\u89c6</a>", null);
            }
            case 14: {
                return DialogUtil.createIndeterminateProgressDialog((Context)this, (int)n, (String)"\u8fde\u63a5\u670d\u52a1\u5668\uff0c\u8bf7\u7a0d\u7b49...", (boolean)false, null);
            }
            case 6: {
                return DialogUtil.createIndeterminateProgressDialog((Context)this, (int)n, (String)"\u6b63\u5728\u652f\u4ed8\uff0c\u8bf7\u52ff\u5173\u95ed\u7a0b\u5e8f\uff0c\u8bf7\u7a0d\u540e......", (boolean)false, null);
            }
            case 7: {
                return DialogUtil.createOKWarningDialog((Context)this, (int)n, (CharSequence)"\u652f\u4ed8\u4e0d\u6210\u529f\uff0c\u8bf7\u786e\u5b9a\u60a8\u7684\u8d26\u6237\u5f53\u4e2d\u7684\u4f59\u989d\u5145\u8db3\u5e76\u7f51\u7edc\u8fde\u63a5\u6b63\u5e38\u3002", null);
            }
            case 8: {
                return DialogUtil.createOKWarningDialog((Context)this, (int)n, (CharSequence)"\u652f\u4ed8\u4e0d\u6210\u529f\uff0c\u8bf7\u786e\u5b9a\u60a8\u7684\u8d26\u6237\u5f53\u4e2d\u7684\u4f59\u989d\u5145\u8db3\u5e76\u7f51\u7edc\u8fde\u63a5\u6b63\u5e38\u3002", null);
            }
            case 9: {
                return DialogUtil.createOKWarningDialog((Context)this, (int)n, (CharSequence)"\u652f\u4ed8\u4e0d\u6210\u529f\uff0c\u8bf7\u786e\u5b9a\u60a8\u7684\u8d26\u6237\u5f53\u4e2d\u7684\u4f59\u989d\u5145\u8db3\u5e76\u7f51\u7edc\u8fde\u63a5\u6b63\u5e38\u3002", null);
            }
            case 37: {
                return DialogUtil.createOKWarningDialog((Context)this, (int)n, (CharSequence)"\u652f\u4ed8\u4e0d\u6210\u529f\uff0c\u60a8\u7684\u652f\u4ed8\u5bc6\u7801\u6709\u8bef\uff0c\u4e0d\u80fd\u652f\u4ed8\u6210\u529f\uff01", null);
            }
            case 10: {
                return DialogUtil.createYesNoDialog((Context)this, (int)n, (CharSequence)"\u652f\u4ed8\u4e0d\u6210\u529f\uff0c\u8fde\u63a5\u670d\u52a1\u5668\u8d85\u65f6\uff0c\u662f\u5426\u91cd\u8bd5?", (DialogUtil.WarningDialogListener)this);
            }
            case 38: {
                return DialogUtil.createOKWarningDialog((Context)this, (int)n, (CharSequence)"\u652f\u4ed8\u4e0d\u6210\u529f\uff0c\u60a8\u5df2\u7ecf\u7981\u6b62\u4e86\u53d1\u9001\u652f\u4ed8\u77ed\u4fe1\uff0c\u8bf7\u91cd\u65b0\u5c1d\u8bd5\u652f\u4ed8\u3002", null);
            }
            case 36: {
                return DialogUtil.createYesNoDialog((Context)this, (int)n, (CharSequence)"\u60a8\u624b\u673a\u65f6\u95f4\u4e0d\u6b63\u786e\uff0c\u4e3a\u4e86\u786e\u4fdd\u5b89\u5168\u652f\u4ed8\uff0c\u662f\u5426\u9700\u8981\u7cfb\u7edf\u81ea\u52a8\u4fee\u6b63\u5e76\u5b8c\u6210\u652f\u4ed8?", (DialogUtil.WarningDialogListener)this);
            }
            case 11: {
                return DialogUtil.createOKWarningDialog((Context)this, (int)n, (CharSequence)"\u652f\u4ed8\u4e0d\u6210\u529f\uff0c\u8bf7\u786e\u5b9a\u60a8\u7684\u8d26\u6237\u5f53\u4e2d\u7684\u4f59\u989d\u5145\u8db3\u5e76\u7f51\u7edc\u8fde\u63a5\u6b63\u5e38\u3002\n\u8bf7\u8054\u7cfb\u5ba2\u670d4006-400-401\u3002", null);
            }
            case 13: {
                return DialogUtil.createOKWarningDialog((Context)this, (int)n, (CharSequence)"U\u70b9\u652f\u4ed8\u6210\u529f\uff0c\u795d\u60a8\u73a9\u7684\u5f00\u5fc3", (CharSequence)String.format("\u60a8\u7684\u4f59\u989d\u4e3a%dU\u70b9", this.mNumber, this.mBalance), (DialogUtil.WarningDialogListener)this);
            }
            case 5: {
                return DialogUtil.createOKWarningDialog((Context)this, (int)n, (CharSequence)"U\u70b9\u4e0d\u8db3,\u4e0d\u80fd\u7ee7\u7eed\u652f\u4ed8\uff01", null);
            }
            case 15: {
                return DialogUtil.createOKWarningDialog((Context)this, (int)n, (CharSequence)"\u7f51\u7edc\u8fde\u63a5\u9519\u8bef\uff0c\u8bf7\u68c0\u67e5\u7f51\u7edc\u540e\u518d\u8bd5\u3002", (DialogUtil.WarningDialogListener)this);
            }
            case 16: {
                return DialogUtil.createOKWarningDialog((Context)this, (int)n, (CharSequence)this.mSmsResultInfo, (DialogUtil.WarningDialogListener)this);
            }
            case 17: {
                return DialogUtil.createIndeterminateProgressDialog((Context)this, (int)n, (String)"\u77ed\u4fe1\u53d1\u9001\u8fc7\u7a0b\u53ef\u80fd\u6301\u7eed\u4e00\u5206\u949f\uff0c\u8bf7\u8010\u5fc3\u7b49\u5f85...", (boolean)false, null);
            }
            case 19: {
                return DialogUtil.createIndeterminateProgressDialog((Context)this, (int)n, (String)"\u6b63\u5728\u83b7\u53d6\u4fe1\u606f\uff0c\u8bf7\u7a0d\u5019......", (boolean)false, null);
            }
            case 20: {
                return DialogUtil.createOKWarningDialog((Context)this, (int)n, (CharSequence)"\u8d2d\u4e70\u6210\u529f", (CharSequence)this.mSmsResultInfo, (DialogUtil.WarningDialogListener)this);
            }
            case 21: {
                return DialogUtil.createOKWarningDialog((Context)this, (int)n, (CharSequence)this.mSmsResultInfo, (DialogUtil.WarningDialogListener)this);
            }
            case 23: {
                return DialogUtil.createTwoButtonsDialog((Context)this, (int)n, (CharSequence)"\u60a8\u5df2\u7ecf\u53d6\u6d88\u4e86\u8d2d\u4e70\uff0c\u5c06\u4e0d\u4f1a\u83b7\u5f97\u76f8\u5e94\u5185\u5bb9\u3002\u8bf7\u786e\u8ba4\u662f\u5426\u53d6\u6d88\uff1f", (CharSequence)"\u53d6\u6d88", (CharSequence)"\u4e0d\u53d6\u6d88", (DialogUtil.WarningDialogListener)this);
            }
            case 24: {
                return DialogUtil.createTwoButtonsDialog((Context)this, (int)n, (CharSequence)Html.fromHtml((String)"\u8d2d\u4e70\u786e\u8ba4\u77ed\u4fe1\u672a\u5220\u9664\uff0c\u5982\u9700\u8d2d\u4e70\u8bf7\u518d\u6b21\u53d1\u9001\u77ed\u4fe1\u6216\u91c7\u7528\u5176\u4ed6\u652f\u4ed8\u65b9\u5f0f\uff0c<font color='red'>\u8bf7\u52ff\u5230\u77ed\u4fe1\u6536\u4ef6\u7bb1\u8fdb\u884c\u56de\u590d</font>\uff0c\u8c22\u8c22\uff01"), (CharSequence)"\u8fd4\u56de\u8d2d\u4e70\u9875", (CharSequence)"\u8fd4\u56de\u5e94\u7528", (DialogUtil.WarningDialogListener)this);
            }
            case 25: {
                return DialogUtil.createTwoButtonsDialog((Context)this, (int)n, (CharSequence)"\u8d2d\u4e70\u786e\u8ba4\u77ed\u4fe1\u5df2\u5220\u9664\uff0c\u5982\u9700\u8d2d\u4e70\u8bf7\u518d\u6b21\u53d1\u9001\u77ed\u4fe1\u6216\u91c7\u7528\u5176\u4ed6\u652f\u4ed8\u65b9\u5f0f\uff0c\u8c22\u8c22\uff01", (CharSequence)"\u8fd4\u56de\u8d2d\u4e70\u9875", (CharSequence)"\u8fd4\u56de\u5e94\u7528", (DialogUtil.WarningDialogListener)this);
            }
            case 26: {
                return DialogUtil.createOKWarningDialog((Context)this, (int)n, (CharSequence)"\u652f\u4ed8\u8d85\u65f6\uff0c\u70b9\u51fb\u786e\u5b9a\u91cd\u65b0\u9a8c\u8bc1\u652f\u4ed8\u7ed3\u679c\u3002\u6700\u591a \u9700\u89811\u5206\u949f\uff0c\u8bf7\u8010\u5fc3\u7b49\u5f85...", (DialogUtil.WarningDialogListener)this);
            }
            case 27: {
                int n2 = this.getPayedAmount();
                return DialogUtil.createTwoButtonsDialog((Context)this, (int)n, (CharSequence)String.format("\u60a8\u5df2\u7ecf\u652f\u4ed8\u8fc7\u3010%d\u3011\u5143\u77ed\u4fe1\uff0c\u73b0\u5728\u53d6\u6d88\u53d1\u9001\u5c06\u4e0d\u80fd\u6210\u529f\u8d2d\u4e70\u3010%s\u3011\u3002\u5982\u53d6\u6d88\u53d1\u9001\u5df2\u4ed8\u91d1\u989d\u4e0d\u4f1a\u8fd4\u8fd8\uff0c\u53ea\u80fd\u8ba1\u7b97\u5230\u60a8\u4e0b\u6b21\u8d2d\u4e70\u3010%s\u3011\u4e2d\u3002\u8bf7\u518d\u6b21\u786e\u8ba4\u662f\u5426\u53d6\u6d88\u8fd9\u6b21\u652f\u4ed8\uff1f", PrefUtil.getPayedAmount((Context)this.getApplicationContext()) + n2, this.mPaymentInfo.getPayname(), this.mPaymentInfo.getPayname()), (CharSequence)"\u8fd4\u56de\u7ee7\u7eed\u652f\u4ed8", (CharSequence)"\u786e\u8ba4\u53d6\u6d88", (DialogUtil.WarningDialogListener)this);
            }
            case 18: {
                return DialogUtil.createOKWarningDialog((Context)this, (int)n, (CharSequence)"\u77ed\u4fe1\u53d1\u9001\u5931\u8d25", null);
            }
            case 35: {
                return DialogUtil.createIndeterminateProgressDialog((Context)this, (int)n, (String)"U\u70b9\u652f\u4ed8\u4e2d\uff0c\u8bf7\u7a0d\u5019...", (boolean)false, null);
            }
            case 28: {
                return DialogUtil.createOKWarningDialog((Context)this, (int)n, (CharSequence)"\u8bf7\u8f93\u5165\u8d26\u53f7\u548c\u5bc6\u7801\u3002", null);
            }
            case 29: {
                return DialogUtil.createOKWarningDialog((Context)this, (int)n, (CharSequence)"\u5bc6\u7801\u4e3a\u7a7a\uff0c\u8bf7\u8f93\u5165\u5bc6\u7801\u3002", null);
            }
            case 30: {
                return DialogUtil.createOKWarningDialog((Context)this, (int)n, (CharSequence)"\u7528\u6237\u540d\u4e3a\u7a7a\uff0c\u8bf7\u8f93\u5165\u7528\u6237\u540d\u3002", null);
            }
            case 31: {
                return DialogUtil.createOKWarningDialog((Context)this, (int)n, (CharSequence)"\u7528\u6237\u540d\u5fc5\u987b\u5927\u4e8e3\u4e2a\u5b57\u3002", null);
            }
            case 32: {
                return DialogUtil.createOKWarningDialog((Context)this, (int)n, (CharSequence)"\u7528\u6237\u540d\u5fc5\u987b\u5c0f\u4e8e17\u4e2a\u5b57\u3002", null);
            }
            case 33: {
                return DialogUtil.createOKWarningDialog((Context)this, (int)n, (CharSequence)"\u5bc6\u7801\u4e0d\u80fd\u4e3a\u7a7a\u3002", null);
            }
            case 34: 
        }
        return DialogUtil.createOKWarningDialog((Context)this, (int)n, (CharSequence)"\u767b\u5f55\u5931\u8d25\uff0c\u60a8\u7684\u5e10\u53f7\u548c\u5bc6\u7801\u4e0d\u5339\u914d\u3002", null);
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.mIsValid) {
            PrefUtil.logout((Context)this.getApplicationContext());
            Utils.clearSmsInfos();
            Utils.clearUPointInfo();
            TypeFactory.clear();
            Utils.clearUPointPayInfo();
            SyncChargeChannelHandler.init();
            SyncPayChannelHandler.init();
            SyncSmsInfoHandler.init();
        }
    }

    /*
     * Unable to fully structure code
     */
    public void onError(int var1_1, int var2_2) {
        switch (var1_1) lbl-1000:
        // 7 sources

        {
            default: lbl-1000:
            // 2 sources

            {
                return;
            }
            case 3: {
                switch (var2_2) {
                    default: {
                        this.mBtnPay.setEnabled(true);
                        this.removeDialog(6);
                        this.showDialog(7);
                        ** GOTO lbl-1000
                    }
                    case 425: {
                        this.mBtnPay.setEnabled(true);
                        this.removeDialog(6);
                        this.showDialog(8);
                        ** GOTO lbl-1000
                    }
                    case 219: {
                        this.mBtnPay.setEnabled(false);
                        this.removeDialog(6);
                        this.showDialog(5);
                        this.buildPaymentView();
                        ** GOTO lbl-1000
                    }
                    case 500: {
                        this.mBtnPay.setEnabled(true);
                        this.removeDialog(6);
                        this.showDialog(11);
                        ** GOTO lbl-1000
                    }
                    case -1: 
                }
                ++this.mTimeoutCounter;
                if (this.mTimeoutCounter >= 2) ** GOTO lbl33
                Api.pay((Context)this.getApplicationContext(), (ApiTask.TaskHandler)this, (PaymentInfo)this.mPaymentInfo, (UPointPayInfo)this.mUPayInfo);
                ** GOTO lbl-1000
lbl33:
                // 1 sources

                this.mTimeoutCounter = 0;
                this.mBtnPay.setEnabled(true);
                this.removeDialog(6);
                this.showDialog(10);
                ** GOTO lbl-1000
            }
            case 18: 
        }
        this.dismissDialog(14);
        this.showDialog(15);
        this.buildPaymentView();
        ** while (true)
    }

    public void onFinish() {
        this.fillData();
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public void onItemClick(AdapterView<?> var1_1, View var2_2, int var3_3, long var4_4) {
        block2: {
            if (var3_3 == 0) lbl-1000:
            // 4 sources

            {
                return;
            }
            if (!"upoint".equals(var1_1 /* !! */  = ((CustomAdapter)((HeaderViewListAdapter)var1_1 /* !! */ .getAdapter()).getWrappedAdapter()).getItem(var3_3 - 1).getId())) break block2;
            this.buildUPointPaymentView();
            ** GOTO lbl-1000
        }
        if (!"sms".equals(var1_1 /* !! */ )) ** GOTO lbl-1000
        this.buildSmsPaymentView();
        ** while (true)
    }

    /*
     * Enabled force condition propagation
     */
    public boolean onKeyDown(int n, KeyEvent keyEvent) {
        switch (n) {
            default: {
                return super.onKeyDown(n, keyEvent);
            }
            case 4: 
        }
        switch (this.mType) {
            default: {
                return super.onKeyDown(n, keyEvent);
            }
            case 1: {
                this.buildPaymentView();
                return true;
            }
            case 2: {
                this.buildUPointPaymentView();
                return true;
            }
            case 3: {
                this.buildUPointPayLoginView();
                return true;
            }
            case 4: {
                if (this.mSmsInfo.isNeedconfirm() || this.mIsShowInfo) {
                    n = Utils.getSmsPayment() / this.mSmsInfo.money;
                    if (this.mLeftSmsToSendCount != -1 && this.mLeftSmsToSendCount != n) {
                        this.showDialog(27);
                        return true;
                    }
                    this.buildPaymentView();
                    return true;
                }
                this.buildPaymentView();
                return true;
            }
            case 5: 
        }
        this.showDialog(23);
        return true;
    }

    /*
     * Enabled force condition propagation
     */
    public Object onPreHandle(int n, HttpResponse object) {
        if (5 == n) return true;
        if (8 == n) {
            return true;
        }
        String string = Utils.getBodyString((int)n, (HttpResponse)object);
        if (TextUtils.isEmpty((CharSequence)string)) {
            return null;
        }
        switch (n) {
            default: {
                return null;
            }
            case 3: {
                try {
                    return XMLParser.parsePayOrder((String)string);
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
            case 18: 
        }
        try {
            return XMLParser.parseUPointInfo((String)string);
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }

    protected void onPrepareDialog(int n, Dialog dialog) {
        super.onPrepareDialog(n, dialog);
        if (dialog.isShowing()) {
            dialog.dismiss();
        }
    }

    /*
     * Unable to fully structure code
     */
    public void onSuccess(int var1_1, Object var2_2) {
        switch (var1_1) lbl-1000:
        // 12 sources

        {
            default: lbl-1000:
            // 2 sources

            {
                return;
            }
            case 3: {
                var3_3 = ((String)var2_2).split("#");
                var1_1 = Integer.parseInt(var3_3[0]);
                var2_2 = var3_3[1];
                this.removeDialog(6);
                if (var1_1 != -110) ** GOTO lbl14
                this.showDialog(7);
                this.mUPayInfo.updateConsumeId();
                ** GOTO lbl-1000
lbl14:
                // 1 sources

                if (var1_1 != -102 || !var2_2.equals("uc_tm_modify")) ** GOTO lbl19
                var2_2 = var3_3[2];
                this.mUPayInfo.setTm((String)var2_2);
                this.showDialog(36);
                ** GOTO lbl-1000
lbl19:
                // 1 sources

                if (var1_1 >= 0) ** GOTO lbl47
                if (var1_1 != -102) ** GOTO lbl-1000
                if (!var2_2.equals("uc_password_error")) ** GOTO lbl24
                this.showDialog(34);
                ** GOTO lbl-1000
lbl24:
                // 1 sources

                if (!var2_2.equals("um_account_error")) ** GOTO lbl27
                this.showDialog(5);
                ** GOTO lbl-1000
lbl27:
                // 1 sources

                if (!var2_2.equals("um_paypwd_error")) ** GOTO lbl30
                this.showDialog(37);
                ** GOTO lbl-1000
lbl30:
                // 1 sources

                if (!var2_2.equals("um_paypwd_error")) ** GOTO lbl43
                if (this.mType != 3) ** GOTO lbl34
                this.showDialog(7);
                ** GOTO lbl-1000
lbl34:
                // 1 sources

                if (!this.mEtSavePass.isChecked()) ** GOTO lbl40
                PrefUtil.setUCUserName((Context)this.getApplicationContext(), (String)this.mEtUsername.getText().toString());
                PrefUtil.setUCUserPass((Context)this.getApplicationContext(), (String)this.mEtPassword.getText().toString());
lbl37:
                // 2 sources

                while (true) {
                    this.buildUPointPayPassView();
                    ** GOTO lbl-1000
                    break;
                }
lbl40:
                // 1 sources

                PrefUtil.clearUCUserName((Context)this.getApplicationContext());
                PrefUtil.clearUCUserPass((Context)this.getApplicationContext());
                ** continue;
lbl43:
                // 1 sources

                if (!var2_2.equals("um_system_error")) ** GOTO lbl-1000
                this.showDialog(7);
                this.mUPayInfo.updateConsumeId();
                ** GOTO lbl-1000
lbl47:
                // 1 sources

                if (!this.mEtSavePass.isChecked()) ** GOTO lbl53
                PrefUtil.setUCUserName((Context)this.getApplicationContext(), (String)this.mEtUsername.getText().toString());
                PrefUtil.setUCUserPass((Context)this.getApplicationContext(), (String)this.mEtPassword.getText().toString());
lbl50:
                // 2 sources

                while (true) {
                    this.showDialog(13);
                    ** GOTO lbl-1000
                    break;
                }
lbl53:
                // 1 sources

                PrefUtil.clearUCUserName((Context)this.getApplicationContext());
                PrefUtil.clearUCUserPass((Context)this.getApplicationContext());
                ** continue;
            }
            case 18: 
        }
        var2_2 = (UPointInfo)var2_2;
        this.initUPointPayView((UPointInfo)var2_2);
        Utils.setUPointInfo((UPointInfo)var2_2);
        this.dismissDialog(14);
        ** while (true)
    }

    /*
     * Unable to fully structure code
     */
    public void onWarningDialogCancel(int var1_1) {
        switch (var1_1) lbl-1000:
        // 2 sources

        {
            default: lbl-1000:
            // 2 sources

            {
                return;
            }
            case 24: 
            case 25: {
                if (this.mSmsHander != null && this.mSmsRunnable != null) {
                    this.mSmsHander.removeCallbacks(this.mSmsRunnable);
                    this.getContentResolver().unregisterContentObserver(this.mSmsContent);
                    this.unregisterReceiver(this.mSmsReceiver);
                }
lbl11:
                // 4 sources

                while (true) {
                    this.finish();
                    ** GOTO lbl-1000
                    break;
                }
            }
            case 27: 
        }
        if (this.mSmsHander != null && this.mSmsRunnable != null) {
            this.mSmsHander.removeCallbacks(this.mSmsRunnable);
            this.getContentResolver().unregisterContentObserver(this.mSmsContent);
            this.unregisterReceiver(this.mSmsReceiver);
        }
lbl20:
        // 4 sources

        while (true) {
            this.buildPaymentView();
            ** continue;
            break;
        }
        catch (IllegalArgumentException var2_2) {
            ** continue;
        }
        catch (IllegalArgumentException var2_3) {
            ** continue;
        }
    }

    /*
     * Unable to fully structure code
     */
    public void onWarningDialogOK(int var1_1) {
        block18: {
            switch (var1_1) lbl-1000:
            // 7 sources

            {
                default: lbl-1000:
                // 3 sources

                {
                    return;
                }
                case 10: {
                    this.pay();
                    ** GOTO lbl-1000
                }
                case 36: {
                    this.pay();
                    ** GOTO lbl-1000
                }
                case 20: {
                    PrefUtil.clearPayedAmount((Context)this.getApplicationContext());
                }
                case 13: {
                    this.setResult(-1, new Intent());
                    this.finish();
                    ** GOTO lbl-1000
                }
                case 0: 
                case 1: 
                case 22: {
                    this.finish();
                    ** GOTO lbl-1000
                }
                case 21: 
                case 25: {
                    if (this.mSmsHander != null && this.mSmsRunnable != null) {
                        this.mSmsHander.removeCallbacks(this.mSmsRunnable);
                    }
                    if (this.mSmsContent != null) {
                        this.getContentResolver().unregisterContentObserver(this.mSmsContent);
                    }
                    this.unregisterReceiver(this.mSmsReceiver);
                }
                case 15: 
                case 16: 
                case 24: lbl-1000:
                // 2 sources

                {
                    while (true) {
                        this.buildPaymentView();
                        ** GOTO lbl-1000
                        break;
                    }
                }
                case 23: {
                    this.showDialog(24);
                    ** GOTO lbl-1000
                }
                case 26: 
            }
            if (4 != this.mType) break block18;
            this.sendFirstSms(this.mSmsInfo);
            ** GOTO lbl-1000
        }
        this.sendConfirmSms(this.mConfirmSmsInfoString);
        ** while (true)
        catch (IllegalArgumentException var2_2) {
            ** continue;
        }
    }
}
