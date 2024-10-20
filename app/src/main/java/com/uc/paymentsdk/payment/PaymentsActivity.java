package com.uc.paymentsdk.payment;

import android.database.sqlite.SQLiteAbortException;
import android.content.ContentValues;
import android.net.Uri;
import android.database.Cursor;
import com.uc.paymentsdk.network.XMLParser;
import org.apache.http.HttpResponse;
import android.view.KeyEvent;
import android.widget.HeaderViewListAdapter;
import android.widget.AdapterView;
import com.uc.paymentsdk.model.TypeFactory;
import android.app.Dialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.content.IntentFilter;
import com.uc.paymentsdk.payment.upoint.UPointInfo;
import android.text.Spanned;
import android.text.Html;
import android.content.pm.PackageManager$NameNotFoundException;
import java.util.regex.Pattern;
import com.uc.paymentsdk.network.chain.SyncPayChannelHandler;
import com.uc.paymentsdk.network.chain.SyncChargeChannelHandler;
import java.util.Iterator;
import java.util.ArrayList;
import android.widget.ListAdapter;
import com.uc.paymentsdk.commons.ui.CustomAdapter;
import com.uc.paymentsdk.model.IType;
import android.widget.ScrollView;
import android.text.method.TransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.graphics.drawable.Drawable;
import com.uc.paymentsdk.network.chain.SyncSmsInfoHandler;
import com.uc.paymentsdk.payment.sms.SimCardNotSupportException;
import android.text.util.Linkify;
import android.widget.RelativeLayout$LayoutParams;
import com.uc.paymentsdk.network.chain.HandlerProxy;
import android.view.ViewGroup$LayoutParams;
import android.view.View;
import android.widget.LinearLayout$LayoutParams;
import android.widget.LinearLayout;
import java.text.DecimalFormat;
import android.graphics.Color;
import android.widget.RelativeLayout;
import com.uc.paymentsdk.network.Api;
import com.uc.paymentsdk.util.Utils;
import com.uc.paymentsdk.util.PrefUtil;
import android.content.Intent;
import android.content.Context;
import com.uc.paymentsdk.payment.upoint.UPointPayInfo;
import android.widget.TextView;
import android.content.BroadcastReceiver;
import com.uc.paymentsdk.payment.sms.SmsInfo;
import android.database.ContentObserver;
import android.widget.ListView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Button;
import com.uc.paymentsdk.network.chain.Handler;
import com.uc.paymentsdk.util.DialogUtil;
import android.widget.AdapterView$OnItemClickListener;
import com.uc.paymentsdk.network.ApiTask;
import android.view.View$OnClickListener;
import android.app.Activity;

public class PaymentsActivity extends Activity implements View$OnClickListener, TaskHandler, AdapterView$OnItemClickListener, WarningDialogListener, OnFinishListener
{
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
    private android.os.Handler mSmsHander;
    private int mSmsId;
    private SmsInfo mSmsInfo;
    private final BroadcastReceiver mSmsReceiver;
    private String mSmsResultInfo;
    private final Runnable mSmsRunnable;
    private int mTimeoutCounter;
    private TextView mTvDiscountTextView;
    private TextView mTvProduct;
    private TextView mTvVipDiscountInfo;
    private TextView mTvVipDiscountTextView;
    private TextView mTvVipDiscountTimeTextView;
    private int mType;
    private UPointPayInfo mUPayInfo;
    
    public PaymentsActivity() {
        super();
        this.mSmsReceiver = new BroadcastReceiver(this) {
            final PaymentsActivity this$0;
            
            PaymentsActivity$1(final PaymentsActivity this$0) {
                this.this$0 = this$0;
                super();
            }
            
            public void onReceive(final Context context, final Intent intent) {
                Label_0362: {
                    switch (this.getResultCode()) {
                        default: {
                            this.this$0.removeDialog(17);
                            PaymentsActivity.access$8(this.this$0, "\u4f59\u989d\u4e0d\u8db3\uff0c\u652f\u4ed8\u5931\u8d25");
                            this.this$0.showDialog(21);
                            if ((mLeftSmsToSendCount == -1 && 5 != mType) || mSmsContent == null) {
                                return;
                            }
                            break Label_0362;
                        }
                        case 1:
                        case 133404: {
                            Label_0107: {
                                return;
                            }
                        }
                        case -1: {
                            if (4 != mType) {
                                break Label_0362;
                            }
                            if (mSmsInfo.isNeedconfirm()) {
                                while (true) {
                                    try {
                                        Thread.sleep(5000L);
                                        this.this$0.removeDialog(17);
                                        this.this$0.buildSmsPaymentConfirmView(mSmsInfo.getSmsConfirmNumber(), mSmsInfo.getSmsConfirmContent());
                                        return;
                                    }
                                    catch (final InterruptedException ex) {
                                        ex.printStackTrace();
                                        continue;
                                    }
                                    break;
                                }
                            }
                            final PaymentsActivity this$0 = this.this$0;
                            PaymentsActivity.access$4(this$0, mLeftSmsToSendCount - 1);
                            this.this$0.removeDialog(17);
                            PrefUtil.setPayedAmount(this.this$0.getApplicationContext(), this.this$0.getPayedAmount());
                            if (mLeftSmsToSendCount >= 1) {
                                this.this$0.buildSmsPaymentView();
                                break;
                            }
                            break Label_0362;
                        }
                        case 2: {
                            Label_0605: {
                                break Label_0605;
                                PaymentsActivity this$2;
                                Block_9_Outer:Label_0456_Outer:
                                while (true) {
                                    try {
                                        this.this$0.unregisterReceiver(mSmsReceiver);
                                        PaymentsActivity.access$8(this.this$0, "\u652f\u4ed8\u5df2\u5b8c\u6210\uff0c\u795d\u60a8\u73a9\u5f97\u5f00\u5fc3\u3002");
                                        this.this$0.showDialog(20);
                                        break;
                                        while (true) {
                                            while (true) {
                                                while (true) {
                                                    Api.postSmsPayment(this.this$0.getApplicationContext(), this.this$0, mPaymentInfo.getCpID(), mPaymentInfo.getmGameID(), mPaymentInfo.getmActionID(), Utils.getSmsPayment(), mPaymentInfo.getmActionID(), mSmsInfo.getSmschannelid(), mSmsInfo.getSmsnumber(), mSmsInfo.getContent(), mSmsInfo.getSmstype());
                                                    return;
                                                    this.this$0.buildSmsPaymentView();
                                                    iftrue(Label_0107:)(mSmsInfo.getSmstype() != 1);
                                                    continue Block_9_Outer;
                                                }
                                                this.this$0.removeDialog(17);
                                                this$2 = this.this$0;
                                                PaymentsActivity.access$4(this$2, mLeftSmsToSendCount - 1);
                                                PrefUtil.setPayedAmount(this.this$0.getApplicationContext(), this.this$0.getPayedAmount());
                                                iftrue(Label_0570:)(mLeftSmsToSendCount < 1);
                                                continue Label_0456_Outer;
                                            }
                                            try {
                                                Label_0570: {
                                                    this.this$0.unregisterReceiver(mSmsReceiver);
                                                }
                                                PaymentsActivity.access$8(this.this$0, "\u652f\u4ed8\u5df2\u5b8c\u6210\uff0c\u795d\u60a8\u73a9\u5f97\u5f00\u5fc3\u3002");
                                                this.this$0.showDialog(20);
                                                continue;
                                                this.this$0.getContentResolver().unregisterContentObserver(mSmsContent);
                                                return;
                                                this.this$0.removeDialog(17);
                                                PaymentsActivity.access$8(this.this$0, "\u5f53\u524d\u624b\u673a\u8bbe\u7f6e\u4e3a\u98de\u884c\u6a21\u5f0f\uff0c\u4e0d\u80fd\u53d1\u9001\u77ed\u4fe1\u3002");
                                                this.this$0.showDialog(21);
                                                iftrue(Label_0107:)((mLeftSmsToSendCount == -1 && 5 != mType) || mSmsContent == null);
                                                this.this$0.getContentResolver().unregisterContentObserver(mSmsContent);
                                            }
                                            catch (final IllegalArgumentException ex2) {}
                                            break;
                                        }
                                    }
                                    catch (final IllegalArgumentException ex3) {
                                        continue;
                                    }
                                    break;
                                }
                            }
                            break;
                        }
                    }
                }
                if (mSmsInfo.getSmstype() == 1) {
                    Api.postSmsPayment(this.this$0.getApplicationContext(), this.this$0, mPaymentInfo.getCpID(), mPaymentInfo.getmGameID(), mPaymentInfo.getmActionID(), Utils.getSmsPayment(), mPaymentInfo.getmActionID(), mSmsInfo.getSmschannelid(), mSmsInfo.getSmsnumber(), mSmsInfo.getContent(), mSmsInfo.getSmstype());
                }
            }
        };
        this.mSmsRunnable = new Runnable(this) {
            final PaymentsActivity this$0;
            
            PaymentsActivity$2(final PaymentsActivity this$0) {
                this.this$0 = this$0;
                super();
            }
            
            @Override
            public void run() {
                if (mSmsContent != null) {
                    this.this$0.getContentResolver().unregisterContentObserver(mSmsContent);
                }
                this.this$0.removeDialog(17);
                Label_0082: {
                    if (!mSmsInfo.needconfirm) {
                        break Label_0082;
                    }
                    PaymentsActivity.access$8(this.this$0, "\u5bf9\u4e0d\u8d77\uff0c\u63a5\u6536\u786e\u8ba4\u77ed\u4fe1\u8d85\u65f6\uff0c\u8bf7\u91cd\u65b0\u5c1d\u8bd5\u652f\u4ed8\uff01");
                    this.this$0.showDialog(21);
                    try {
                    Block_4_Outer:
                        while (true) {
                            this.this$0.unregisterReceiver(mSmsReceiver);
                            return;
                            while (true) {
                                PaymentsActivity.access$8(this.this$0, "\u5bf9\u4e0d\u8d77\uff0c\u77ed\u4fe1\u652f\u4ed8\u5df2\u7ecf\u8d85\u65f6\uff0c\u8bf7\u91cd\u65b0\u652f\u4ed8\uff01");
                                this.this$0.showDialog(21);
                                continue Block_4_Outer;
                                iftrue(Label_0113:)(mLeftSmsToSendCount <= 0);
                                continue;
                            }
                            Label_0113: {
                                PrefUtil.setPayedAmount(this.this$0.getApplicationContext(), this.this$0.getPayedAmount());
                            }
                            PaymentsActivity.access$8(this.this$0, "\u611f\u8c22\u60a8\u7684\u4f7f\u7528\uff0c\u795d\u60a8\u73a9\u5f97\u5f00\u5fc3\uff01");
                            this.this$0.showDialog(20);
                            continue Block_4_Outer;
                        }
                    }
                    catch (final IllegalArgumentException ex) {}
                }
            }
        };
    }
    
    static /* synthetic */ int access$0(final PaymentsActivity paymentsActivity) {
        return paymentsActivity.mType;
    }
    
    static /* synthetic */ SmsInfo access$1(final PaymentsActivity paymentsActivity) {
        return paymentsActivity.mSmsInfo;
    }
    
    static /* synthetic */ ContentObserver access$10(final PaymentsActivity paymentsActivity) {
        return paymentsActivity.mSmsContent;
    }
    
    static /* synthetic */ int access$11(final PaymentsActivity paymentsActivity) {
        return paymentsActivity.mSmsId;
    }
    
    static /* synthetic */ int access$12(final PaymentsActivity paymentsActivity) {
        return paymentsActivity.mLeftSmsToReceiveCount;
    }
    
    static /* synthetic */ android.os.Handler access$13(final PaymentsActivity paymentsActivity) {
        return paymentsActivity.mSmsHander;
    }
    
    static /* synthetic */ Runnable access$14(final PaymentsActivity paymentsActivity) {
        return paymentsActivity.mSmsRunnable;
    }
    
    static /* synthetic */ void access$15(final PaymentsActivity paymentsActivity, final int mSmsId) {
        paymentsActivity.mSmsId = mSmsId;
    }
    
    static /* synthetic */ void access$16(final PaymentsActivity paymentsActivity, final int mLeftSmsToReceiveCount) {
        paymentsActivity.mLeftSmsToReceiveCount = mLeftSmsToReceiveCount;
    }
    
    static /* synthetic */ void access$17(final PaymentsActivity paymentsActivity, final boolean mIsSynced) {
        paymentsActivity.mIsSynced = mIsSynced;
    }
    
    static /* synthetic */ void access$18(final PaymentsActivity paymentsActivity, final TextView textView, final TextView textView2, final int n, final Button button, final Button button2, final RelativeLayout relativeLayout) {
        paymentsActivity.initSmsPayView(textView, textView2, n, button, button2, relativeLayout);
    }
    
    static /* synthetic */ void access$2(final PaymentsActivity paymentsActivity, final String s, final String s2) {
        paymentsActivity.buildSmsPaymentConfirmView(s, s2);
    }
    
    static /* synthetic */ int access$3(final PaymentsActivity paymentsActivity) {
        return paymentsActivity.mLeftSmsToSendCount;
    }
    
    static /* synthetic */ void access$4(final PaymentsActivity paymentsActivity, final int mLeftSmsToSendCount) {
        paymentsActivity.mLeftSmsToSendCount = mLeftSmsToSendCount;
    }
    
    static /* synthetic */ int access$5(final PaymentsActivity paymentsActivity) {
        return paymentsActivity.getPayedAmount();
    }
    
    static /* synthetic */ void access$6(final PaymentsActivity paymentsActivity) {
        paymentsActivity.buildSmsPaymentView();
    }
    
    static /* synthetic */ BroadcastReceiver access$7(final PaymentsActivity paymentsActivity) {
        return paymentsActivity.mSmsReceiver;
    }
    
    static /* synthetic */ void access$8(final PaymentsActivity paymentsActivity, final String mSmsResultInfo) {
        paymentsActivity.mSmsResultInfo = mSmsResultInfo;
    }
    
    static /* synthetic */ PaymentInfo access$9(final PaymentsActivity paymentsActivity) {
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
        final RelativeLayout initSubTitle = Utils.initSubTitle(this.getApplicationContext(), (View$OnClickListener)this, "\u8d2d\u4e70\u5185\u5bb9", false);
        final TextView textView = new TextView(this.getApplicationContext());
        textView.setTextSize(16.0f);
        textView.setTextColor(Color.parseColor("#FF858D8D"));
        textView.setPadding(10, 10, 0, 10);
        textView.setText((CharSequence)"\u5c0a\u656c\u7684\u7528\u6237\uff0c\u60a8\u9700\u8981\u4e3a\u4ee5\u4e0b\u5185\u5bb9\u652f\u4ed8\u8d39\u7528\uff0c\u8bf7\u9605\u8bfb\u4ee5\u4e0b\u4fe1\u606f\uff0c\u786e\u8ba4\u6240\u8d2d\u5185\u5bb9\u65e0\u8bef\u3002");
        final TextView textView2 = new TextView(this.getApplicationContext());
        textView2.setTextSize(16.0f);
        textView2.setPadding(20, 0, 20, 0);
        textView2.setText((CharSequence)String.format("\u6240\u8d2d\u5185\u5bb9 : %s", this.mPaymentInfo.getPaydesc()));
        textView2.setTextColor(-12303292);
        final String format = new DecimalFormat("##0.00").format(this.mPaymentInfo.getMoney() / 10.0f);
        final TextView textView3 = new TextView(this.getApplicationContext());
        textView3.setTextSize(16.0f);
        textView3.setPadding(20, 0, 0, 20);
        textView3.setText((CharSequence)String.format("\u652f\u4ed8\u91d1\u989d: %s\u5143", format));
        textView3.setTextColor(-12303292);
        final LinearLayout linearLayout = new LinearLayout(this.getApplicationContext());
        linearLayout.setBackgroundColor(-1);
        linearLayout.setOrientation(1);
        final LinearLayout$LayoutParams linearLayout$LayoutParams = new LinearLayout$LayoutParams(-1, -2);
        linearLayout.addView((View)initSubTitle, (ViewGroup$LayoutParams)linearLayout$LayoutParams);
        linearLayout.addView((View)textView, (ViewGroup$LayoutParams)linearLayout$LayoutParams);
        linearLayout.addView((View)textView2, (ViewGroup$LayoutParams)linearLayout$LayoutParams);
        linearLayout.addView((View)textView3, (ViewGroup$LayoutParams)linearLayout$LayoutParams);
        (this.mListView = new ListView(this.getApplicationContext())).setBackgroundColor(-1);
        this.mListView.setCacheColorHint(-1);
        this.mListView.addHeaderView((View)linearLayout, (Object)null, true);
        this.mListView.setOnItemClickListener((AdapterView$OnItemClickListener)this);
        this.mListView.addFooterView((View)Utils.generateFooterView((Context)this), (Object)null, false);
        this.setContentView((View)this.mListView);
        this.fillData();
        new HandlerProxy(this.getApplicationContext(), this).handleRequest();
    }
    
    private void buildSmsPaymentConfirmView(final String obj, final String str) {
        this.mType = 5;
        try {
            Utils.CheckSimCardSupprotInfo(this.getApplicationContext());
            final RelativeLayout contentView = new RelativeLayout(this.getApplicationContext());
            contentView.setBackgroundColor(-1);
            contentView.setLayoutParams(new ViewGroup$LayoutParams(-1, -1));
            final RelativeLayout initSubTitle = Utils.initSubTitle(this.getApplicationContext(), (View$OnClickListener)this, "\u8d2d\u4e70\u5185\u5bb9", true);
            initSubTitle.setId(1);
            initSubTitle.setLayoutParams((ViewGroup$LayoutParams)new RelativeLayout$LayoutParams(-1, -2));
            contentView.addView((View)initSubTitle);
            final TextView textView = new TextView((Context)this);
            textView.setId(2);
            textView.setTextSize(16.0f);
            textView.setTextColor(-13487566);
            textView.setPadding(10, 10, 0, 0);
            textView.setFocusable(true);
            textView.setClickable(true);
            textView.setLinkTextColor(-24576);
            textView.setText((CharSequence)String.format("\u518d\u6b21\u70b9\u51fb\u4e0b\u4e00\u6b65\u5373\u540c\u610f\u5411\n%s\u53d1\u9001\u77ed\u4fe1\u4ee5\u5b8c\u6210\u672c\u6b21\u77ed\u4fe1\u53d1\u9001\u8fc7\u7a0b\u3002", obj, this.mPaymentInfo.getPayname(), Integer.valueOf(Utils.getSmsPayment())));
            Linkify.addLinks(textView, 4);
            final RelativeLayout$LayoutParams layoutParams = new RelativeLayout$LayoutParams(-1, -2);
            layoutParams.addRule(3, 1);
            textView.setLayoutParams((ViewGroup$LayoutParams)layoutParams);
            contentView.addView((View)textView);
            final Button button = new Button(this.getApplicationContext());
            button.setText((CharSequence)"\u4e0b\u4e00\u6b65");
            button.setId(5);
            button.setTag((Object)(this.mConfirmSmsInfoString = String.valueOf(obj) + ",,,," + str));
            button.setOnClickListener((View$OnClickListener)this);
            final RelativeLayout$LayoutParams layoutParams2 = new RelativeLayout$LayoutParams(150, -2);
            layoutParams2.addRule(12, -1);
            layoutParams2.setMargins(10, 20, 10, 10);
            button.setLayoutParams((ViewGroup$LayoutParams)layoutParams2);
            contentView.addView((View)button);
            final Button button2 = new Button(this.getApplicationContext());
            button2.setText((CharSequence)"\u53d6\u6d88");
            button2.setId(6);
            button2.setOnClickListener((View$OnClickListener)this);
            final RelativeLayout$LayoutParams layoutParams3 = new RelativeLayout$LayoutParams(150, -2);
            layoutParams3.addRule(11, -1);
            layoutParams3.addRule(12, -1);
            layoutParams3.setMargins(10, 20, 10, 10);
            button2.setLayoutParams((ViewGroup$LayoutParams)layoutParams3);
            contentView.addView((View)button2);
            this.setContentView((View)contentView);
        }
        catch (final SimCardNotSupportException ex) {
            this.mSmsResultInfo = ex.getMessage();
            this.showDialog(16);
        }
    }
    
    private void buildSmsPaymentView() {
        while (true) {
            this.mType = 4;
            this.mSmsId = 0;
            final RelativeLayout relativeLayout = new RelativeLayout(this.getApplicationContext());
            relativeLayout.setBackgroundColor(-1);
            relativeLayout.setLayoutParams(new ViewGroup$LayoutParams(-1, -1));
            final RelativeLayout initSubTitle = Utils.initSubTitle(this.getApplicationContext(), (View$OnClickListener)this, "\u77ed\u4fe1\u652f\u4ed8", false);
            initSubTitle.setId(1);
            initSubTitle.setLayoutParams((ViewGroup$LayoutParams)new RelativeLayout$LayoutParams(-1, -2));
            relativeLayout.addView((View)initSubTitle);
            final TextView textView = new TextView((Context)this);
            textView.setId(2);
            textView.setTextSize(18.0f);
            textView.setTextColor(-12303292);
            textView.setPadding(10, 10, 0, 0);
            textView.setFocusable(true);
            textView.setClickable(true);
            textView.setLinkTextColor(-24576);
            textView.setText((CharSequence)"\u5c0a\u656c\u7684\u7528\u6237\uff0c\u6b63\u5728\u83b7\u53d6\u4fe1\u606f\uff0c\u8bf7\u7a0d\u540e......");
            final RelativeLayout$LayoutParams layoutParams = new RelativeLayout$LayoutParams(-1, -2);
            layoutParams.addRule(3, 1);
            textView.setLayoutParams((ViewGroup$LayoutParams)layoutParams);
            relativeLayout.addView((View)textView);
            final TextView textView2 = new TextView((Context)this);
            textView2.setId(3);
            textView2.setTextSize(16.0f);
            textView2.setTextColor(-7829368);
            textView2.setPadding(10, 30, 0, 0);
            textView2.setFocusable(true);
            textView2.setClickable(true);
            textView2.setLinkTextColor(-24576);
            final RelativeLayout$LayoutParams layoutParams2 = new RelativeLayout$LayoutParams(-1, -2);
            layoutParams2.addRule(3, 2);
            textView2.setLayoutParams((ViewGroup$LayoutParams)layoutParams2);
            relativeLayout.addView((View)textView2);
            final Button button = new Button(this.getApplicationContext());
            button.setText((CharSequence)"\u70b9\u64ad");
            button.setId(3);
            button.setOnClickListener((View$OnClickListener)this);
            final Button button2 = new Button(this.getApplicationContext());
            button2.setText((CharSequence)"\u53d6\u6d88");
            button2.setId(4);
            button2.setOnClickListener((View$OnClickListener)this);
            int smsPayment;
            try {
                Utils.CheckSimCardSupprotInfo(this.getApplicationContext());
                smsPayment = Utils.getSmsPayment();
                if (smsPayment <= PrefUtil.getPayedAmount(this.getApplicationContext())) {
                    this.mSmsResultInfo = "\u60a8\u5df2\u652f\u4ed8\u5b8c\u6210\uff0c\u5c06\u8fd4\u56de\u60a8\u7684\u6e38\u620f\u4e2d\u3002";
                    this.showDialog(20);
                    return;
                }
            }
            catch (final SimCardNotSupportException ex) {
                this.mSmsResultInfo = ex.getMessage();
                this.showDialog(16);
                return;
            }
            if (!this.mIsSynced) {
                this.showDialog(19);
                new SyncSmsInfoHandler(this.getApplicationContext(), new OnFinishListener(this, textView2, button2, relativeLayout) {
                    Button cancelBtn = button2;
                    RelativeLayout contentPanel = relativeLayout;
                    Button okBtn = button;
                    int smsPayment = smsPayment;
                    final PaymentsActivity this$0;
                    TextView tvInfo2 = textView2;
                    TextView waitTV = textView;
                    
                    PaymentsActivity$3(final PaymentsActivity this$0, final TextView waitTV, final TextView tvInfo2, final int smsPayment, final Button cancelBtn, final Button okBtn, final RelativeLayout contentPanel) {
                        this.this$0 = this$0;
                        super();
                    }
                    
                    @Override
                    public void onFinish() {
                        if (Utils.getSmsInfos() == null) {
                            this.this$0.removeDialog(19);
                            this.this$0.showDialog(15);
                        }
                        else {
                            PaymentsActivity.access$17(this.this$0, true);
                            this.this$0.removeDialog(19);
                            this.this$0.initSmsPayView(this.waitTV, this.tvInfo2, this.smsPayment, this.cancelBtn, this.okBtn, this.contentPanel);
                        }
                    }
                }).handleRequest();
                return;
            }
            this.initSmsPayView(textView, textView2, smsPayment, button2, button, relativeLayout);
        }
    }
    
    private void buildUPointPayLoginView() {
        this.mType = 2;
        final RelativeLayout initSubTitle = Utils.initSubTitle(this.getApplicationContext(), (View$OnClickListener)this, "\u8bf7\u60a8\u8f93\u5165UC\u5e10\u53f7", true);
        initSubTitle.setId(10);
        final RelativeLayout$LayoutParams layoutParams = new RelativeLayout$LayoutParams(-1, -2);
        layoutParams.addRule(10, -1);
        initSubTitle.setLayoutParams((ViewGroup$LayoutParams)layoutParams);
        final TextView textView = new TextView(this.getApplicationContext());
        final RelativeLayout$LayoutParams layoutParams2 = new RelativeLayout$LayoutParams(-1, -2);
        layoutParams2.addRule(3, 10);
        layoutParams2.setMargins(10, 5, 10, 10);
        textView.setLayoutParams((ViewGroup$LayoutParams)layoutParams2);
        textView.setId(1);
        textView.setCompoundDrawablePadding(10);
        textView.setTextColor(-13487566);
        String s;
        if (Utils.isHdpi()) {
            s = "lock_hdpi.png";
        }
        else {
            s = "lock.png";
        }
        textView.setCompoundDrawablesWithIntrinsicBounds(Utils.getDrawableFromFile(s), (Drawable)null, (Drawable)null, (Drawable)null);
        textView.setText((CharSequence)"\u60a8\u597d\uff0c\u8d2d\u4e70\u6b64\u5185\u5bb9\uff0c\u8bf7\u5148\u767b\u5f55UC\u8d26\u53f7\u3002\u60a8\u53ef\u4ee5\u8f93\u5165UC\u5e10\u53f7\u6216\u8005\u624b\u673a\u53f7\u7801\u8fdb\u884c\u767b\u5f55");
        final TextView generateBorderView = Utils.generateBorderView((Context)this.getApplication());
        generateBorderView.setId(11);
        final RelativeLayout$LayoutParams layoutParams3 = new RelativeLayout$LayoutParams(-1, 1);
        layoutParams3.addRule(3, 1);
        generateBorderView.setLayoutParams((ViewGroup$LayoutParams)layoutParams3);
        final RelativeLayout$LayoutParams layoutParams4 = new RelativeLayout$LayoutParams(-1, -2);
        layoutParams4.setMargins(10, 10, 10, 5);
        final TextView textView2 = new TextView(this.getApplicationContext());
        textView2.setLayoutParams((ViewGroup$LayoutParams)layoutParams4);
        textView2.setId(2);
        textView2.setText((CharSequence)"UC\u8d26\u53f7:");
        textView2.setTextColor(-13487566);
        final RelativeLayout$LayoutParams layoutParams5 = new RelativeLayout$LayoutParams(-1, -2);
        layoutParams5.addRule(3, 2);
        layoutParams5.setMargins(10, 5, 10, 5);
        (this.mEtUsername = new EditText(this.getApplicationContext())).setLayoutParams((ViewGroup$LayoutParams)layoutParams5);
        this.mEtUsername.setSingleLine();
        this.mEtUsername.setId(3);
        this.mEtUsername.setHint((CharSequence)"\u7528\u6237\u540d");
        (this.mEtPassword = new EditText(this.getApplicationContext())).setId(4);
        this.mEtPassword.setHint((CharSequence)"\u5bc6\u7801");
        this.mEtPassword.setSingleLine();
        this.mEtPassword.setTransformationMethod((TransformationMethod)PasswordTransformationMethod.getInstance());
        final RelativeLayout$LayoutParams layoutParams6 = new RelativeLayout$LayoutParams(-1, -2);
        layoutParams6.addRule(3, 3);
        layoutParams6.setMargins(10, 5, 10, 5);
        this.mEtPassword.setLayoutParams((ViewGroup$LayoutParams)layoutParams6);
        this.mEtSavePass = new CheckBox(this.getApplicationContext());
        final RelativeLayout$LayoutParams layoutParams7 = new RelativeLayout$LayoutParams(-1, -2);
        layoutParams7.addRule(3, 4);
        layoutParams7.setMargins(10, 5, 10, 5);
        this.mEtSavePass.setId(5);
        this.mEtSavePass.setTextColor(-12303292);
        this.mEtSavePass.setText((CharSequence)"\u4fdd\u5b58\u5bc6\u7801");
        this.mEtSavePass.setLayoutParams((ViewGroup$LayoutParams)layoutParams7);
        if (PrefUtil.getUCUserName(this.getApplicationContext()) != null) {
            this.mEtUsername.setText((CharSequence)PrefUtil.getUCUserName(this.getApplicationContext()));
            this.mEtSavePass.setChecked(true);
        }
        else {
            this.mEtSavePass.setChecked(false);
        }
        if (PrefUtil.getUCUserPass(this.getApplicationContext()) != null) {
            this.mEtPassword.setText((CharSequence)PrefUtil.getUCUserPass(this.getApplicationContext()));
        }
        final Button button = new Button(this.getApplicationContext());
        button.setId(7);
        button.setText((CharSequence)"\u786e\u5b9a\u8d2d\u4e70");
        button.setOnClickListener((View$OnClickListener)this);
        final RelativeLayout$LayoutParams layoutParams8 = new RelativeLayout$LayoutParams(-1, -2);
        layoutParams8.topMargin = 10;
        layoutParams8.addRule(3, 5);
        layoutParams8.addRule(14);
        button.setLayoutParams((ViewGroup$LayoutParams)layoutParams8);
        final RelativeLayout relativeLayout = new RelativeLayout(this.getApplicationContext());
        relativeLayout.setId(7);
        relativeLayout.setBackgroundColor(-984326);
        final RelativeLayout$LayoutParams layoutParams9 = new RelativeLayout$LayoutParams(-1, -2);
        layoutParams9.addRule(3, 11);
        relativeLayout.setLayoutParams((ViewGroup$LayoutParams)layoutParams9);
        relativeLayout.addView((View)textView2);
        relativeLayout.addView((View)this.mEtUsername);
        relativeLayout.addView((View)this.mEtPassword);
        relativeLayout.addView((View)this.mEtSavePass);
        relativeLayout.addView((View)button);
        final RelativeLayout relativeLayout2 = new RelativeLayout(this.getApplicationContext());
        relativeLayout2.setBackgroundColor(-1);
        relativeLayout2.setLayoutParams((ViewGroup$LayoutParams)new RelativeLayout$LayoutParams(-1, -1));
        relativeLayout2.addView((View)initSubTitle);
        relativeLayout2.addView((View)textView);
        relativeLayout2.addView((View)generateBorderView);
        relativeLayout2.addView((View)relativeLayout);
        final TextView generateBorderView2 = Utils.generateBorderView((Context)this.getApplication());
        final RelativeLayout$LayoutParams layoutParams10 = new RelativeLayout$LayoutParams(-1, 1);
        layoutParams10.addRule(3, 7);
        generateBorderView2.setLayoutParams((ViewGroup$LayoutParams)layoutParams10);
        relativeLayout2.addView((View)generateBorderView2);
        final ScrollView contentView = new ScrollView((Context)this.getApplication());
        contentView.setBackgroundColor(-1);
        contentView.addView((View)relativeLayout2);
        this.setContentView((View)contentView);
    }
    
    private void buildUPointPayPassView() {
        this.mType = 3;
        final RelativeLayout initSubTitle = Utils.initSubTitle(this.getApplicationContext(), (View$OnClickListener)this, "\u8bf7\u60a8\u8f93\u5165U\u70b9\u652f\u4ed8\u5bc6\u7801", true);
        initSubTitle.setId(10);
        final RelativeLayout$LayoutParams layoutParams = new RelativeLayout$LayoutParams(-1, -2);
        layoutParams.addRule(10, -1);
        initSubTitle.setLayoutParams((ViewGroup$LayoutParams)layoutParams);
        final TextView textView = new TextView(this.getApplicationContext());
        final RelativeLayout$LayoutParams layoutParams2 = new RelativeLayout$LayoutParams(-1, -2);
        layoutParams2.addRule(3, 10);
        layoutParams2.setMargins(10, 5, 10, 10);
        textView.setLayoutParams((ViewGroup$LayoutParams)layoutParams2);
        textView.setId(1);
        textView.setCompoundDrawablePadding(10);
        textView.setTextColor(-13487566);
        String s;
        if (Utils.isHdpi()) {
            s = "lock_hdpi.png";
        }
        else {
            s = "lock.png";
        }
        textView.setCompoundDrawablesWithIntrinsicBounds(Utils.getDrawableFromFile(s), (Drawable)null, (Drawable)null, (Drawable)null);
        textView.setText((CharSequence)"\u60a8\u597d\uff0c\u60a8\u7684U\u70b9\u8bbe\u7f6e\u6709\u652f\u4ed8\u5bc6\u7801\uff0c\u8bf7\u6536\u5165\u540e\u70b9\u51fb\u786e\u8ba4\u8fdb\u884c\u652f\u4ed8");
        final TextView generateBorderView = Utils.generateBorderView((Context)this.getApplication());
        generateBorderView.setId(11);
        final RelativeLayout$LayoutParams layoutParams3 = new RelativeLayout$LayoutParams(-1, 1);
        layoutParams3.addRule(3, 1);
        generateBorderView.setLayoutParams((ViewGroup$LayoutParams)layoutParams3);
        final RelativeLayout$LayoutParams layoutParams4 = new RelativeLayout$LayoutParams(-1, -2);
        layoutParams4.setMargins(10, 10, 10, 5);
        final TextView textView2 = new TextView(this.getApplicationContext());
        textView2.setLayoutParams((ViewGroup$LayoutParams)layoutParams4);
        textView2.setId(2);
        textView2.setText((CharSequence)"UC\u652f\u4ed8\u5bc6\u7801:");
        textView2.setTextColor(-13487566);
        final RelativeLayout$LayoutParams layoutParams5 = new RelativeLayout$LayoutParams(-1, -2);
        layoutParams5.addRule(3, 2);
        layoutParams5.setMargins(10, 5, 10, 5);
        (this.mEtPayPass = new EditText(this.getApplicationContext())).setLayoutParams((ViewGroup$LayoutParams)layoutParams5);
        this.mEtPayPass.setSingleLine();
        this.mEtPayPass.setId(3);
        this.mEtPayPass.setHint((CharSequence)"\u652f\u4ed8\u5bc6\u7801");
        final Button button = new Button(this.getApplicationContext());
        button.setId(7);
        button.setText((CharSequence)"\u786e\u5b9a\u8d2d\u4e70");
        button.setOnClickListener((View$OnClickListener)this);
        final RelativeLayout$LayoutParams layoutParams6 = new RelativeLayout$LayoutParams(-1, -2);
        layoutParams6.topMargin = 10;
        layoutParams6.addRule(3, 5);
        layoutParams6.addRule(14);
        button.setLayoutParams((ViewGroup$LayoutParams)layoutParams6);
        final RelativeLayout relativeLayout = new RelativeLayout(this.getApplicationContext());
        relativeLayout.setId(7);
        relativeLayout.setBackgroundColor(-984326);
        final RelativeLayout$LayoutParams layoutParams7 = new RelativeLayout$LayoutParams(-1, -2);
        layoutParams7.addRule(3, 11);
        relativeLayout.setLayoutParams((ViewGroup$LayoutParams)layoutParams7);
        relativeLayout.addView((View)textView2);
        relativeLayout.addView((View)this.mEtPayPass);
        relativeLayout.addView((View)button);
        final RelativeLayout relativeLayout2 = new RelativeLayout(this.getApplicationContext());
        relativeLayout2.setBackgroundColor(-1);
        relativeLayout2.setLayoutParams((ViewGroup$LayoutParams)new RelativeLayout$LayoutParams(-1, -1));
        relativeLayout2.addView((View)initSubTitle);
        relativeLayout2.addView((View)textView);
        relativeLayout2.addView((View)generateBorderView);
        relativeLayout2.addView((View)relativeLayout);
        final TextView generateBorderView2 = Utils.generateBorderView((Context)this.getApplication());
        final RelativeLayout$LayoutParams layoutParams8 = new RelativeLayout$LayoutParams(-1, 1);
        layoutParams8.addRule(3, 7);
        generateBorderView2.setLayoutParams((ViewGroup$LayoutParams)layoutParams8);
        relativeLayout2.addView((View)generateBorderView2);
        final ScrollView contentView = new ScrollView((Context)this.getApplication());
        contentView.setBackgroundColor(-1);
        contentView.addView((View)relativeLayout2);
        this.setContentView((View)contentView);
    }
    
    private void buildUPointPaymentView() {
        this.mType = 1;
        final TextView textView = new TextView(this.getApplicationContext());
        textView.setTextSize(16.0f);
        textView.setPadding(20, 0, 20, 0);
        textView.setTextColor(-12303292);
        textView.setText((CharSequence)String.format("\u652f\u4ed8\u540d\u79f0 : %s", this.mPaymentInfo.getPayname()));
        (this.mTvProduct = new TextView(this.getApplicationContext())).setTextSize(16.0f);
        this.mTvProduct.setPadding(20, 0, 20, 0);
        this.mTvProduct.setText((CharSequence)"\u4ea7\u54c1\u540d : ");
        this.mTvProduct.setTextColor(-12303292);
        final TextView textView2 = new TextView(this.getApplicationContext());
        textView2.setTextSize(16.0f);
        textView2.setPadding(20, 0, 20, 20);
        textView2.setText((CharSequence)String.format("\u6240\u8d2d\u5185\u5bb9 : %s", this.mPaymentInfo.getPaydesc()));
        textView2.setTextColor(-12303292);
        final TextView textView3 = new TextView(this.getApplicationContext());
        textView3.setTextSize(16.0f);
        textView3.setPadding(20, 0, 20, 0);
        textView3.setText((CharSequence)String.format("\u652f\u4ed8\u6570\u989d : %dU\u70b9\uff08\u4ef7\u503c%s\u5143\uff09", Integer.valueOf(this.mPaymentInfo.getMoney()), new DecimalFormat("##0.00").format(this.mPaymentInfo.getMoney() / 10.0f)));
        textView3.setTextColor(-13487566);
        (this.mTvDiscountTextView = new TextView(this.getApplicationContext())).setTextSize(16.0f);
        this.mTvDiscountTextView.setPadding(20, 0, 20, 0);
        this.mTvDiscountTextView.setText((CharSequence)"U\u70b9\u6298\u6263 : ");
        this.mTvDiscountTextView.setTextColor(-13487566);
        (this.mTvVipDiscountTextView = new TextView(this.getApplicationContext())).setTextSize(16.0f);
        this.mTvVipDiscountTextView.setPadding(20, 0, 20, 0);
        this.mTvVipDiscountTextView.setText((CharSequence)"\u4f1a\u5458\u6298\u6263 : ");
        this.mTvVipDiscountTextView.setTextColor(-13487566);
        (this.mTvVipDiscountTimeTextView = new TextView(this.getApplicationContext())).setTextSize(16.0f);
        this.mTvVipDiscountTimeTextView.setPadding(20, 0, 20, 0);
        this.mTvVipDiscountTimeTextView.setText((CharSequence)"\u4f1a\u5458\u6298\u6263\u5230\u671f\u65f6\u95f4 : ");
        (this.mTvVipDiscountInfo = new TextView(this.getApplicationContext())).setTextColor(-13487566);
        (this.mTvVipDiscountInfo = new TextView(this.getApplicationContext())).setTextSize(16.0f);
        this.mTvVipDiscountInfo.setPadding(20, 0, 20, 0);
        this.mTvVipDiscountInfo.setText((CharSequence)"\u4f1a\u5458\u6298\u6263\u4fe1\u606f : ");
        this.mTvVipDiscountInfo.setTextColor(-13487566);
        (this.mBtnPay = new Button(this.getApplicationContext())).setText((CharSequence)"\u786e\u8ba4");
        this.mBtnPay.setOnClickListener((View$OnClickListener)this);
        this.mBtnPay.setVisibility(8);
        final LinearLayout$LayoutParams linearLayout$LayoutParams = new LinearLayout$LayoutParams(300, -2);
        linearLayout$LayoutParams.gravity = 1;
        final LinearLayout linearLayout = new LinearLayout(this.getApplicationContext());
        linearLayout.addView((View)this.mBtnPay, (ViewGroup$LayoutParams)linearLayout$LayoutParams);
        linearLayout.setGravity(1);
        final LinearLayout linearLayout2 = new LinearLayout(this.getApplicationContext());
        linearLayout2.setOrientation(1);
        linearLayout2.setBackgroundColor(-1);
        final LinearLayout$LayoutParams linearLayout$LayoutParams2 = new LinearLayout$LayoutParams(-1, -2);
        linearLayout2.addView((View)Utils.initSubTitle(this.getApplicationContext(), (View$OnClickListener)this, "\u9700\u8981\u652f\u4ed8\u7684\u5185\u5bb9", true), (ViewGroup$LayoutParams)linearLayout$LayoutParams2);
        linearLayout2.addView((View)textView, (ViewGroup$LayoutParams)linearLayout$LayoutParams2);
        linearLayout2.addView((View)this.mTvProduct, (ViewGroup$LayoutParams)linearLayout$LayoutParams2);
        linearLayout2.addView((View)textView2, (ViewGroup$LayoutParams)linearLayout$LayoutParams2);
        linearLayout2.addView((View)textView3, (ViewGroup$LayoutParams)linearLayout$LayoutParams2);
        linearLayout2.addView((View)this.mTvDiscountTextView, (ViewGroup$LayoutParams)linearLayout$LayoutParams2);
        linearLayout2.addView((View)this.mTvVipDiscountTextView, (ViewGroup$LayoutParams)linearLayout$LayoutParams2);
        linearLayout2.addView((View)this.mTvVipDiscountTimeTextView, (ViewGroup$LayoutParams)linearLayout$LayoutParams2);
        linearLayout2.addView((View)this.mTvVipDiscountInfo, (ViewGroup$LayoutParams)linearLayout$LayoutParams2);
        linearLayout2.addView((View)linearLayout, (ViewGroup$LayoutParams)linearLayout$LayoutParams2);
        final ScrollView contentView = new ScrollView(this.getApplicationContext());
        contentView.setBackgroundColor(-1);
        contentView.addView((View)linearLayout2);
        this.setContentView((View)contentView);
        if (Utils.getUPointInfo() == null) {
            this.showDialog(14);
            Api.queryUPointDiscount(this.getApplicationContext(), this, Utils.getPaymentInfo().getCpID(), Utils.getPaymentInfo().getmGameID(), Utils.getPaymentInfo().getMoney());
        }
        else {
            this.initUPointPayView(Utils.getUPointInfo());
        }
    }
    
    private void fillData() {
        final ArrayList<IType> availablePayType = PrefUtil.getAvailablePayType(this.getApplicationContext(), this.mPaymentInfo.getPaytype());
        final IType[] array = new IType[availablePayType.size()];
        if ("overage".equals(this.mPaymentInfo.getPaytype())) {
            for (final IType type : availablePayType) {
                if ("upoint".equals(type.getId())) {
                    array[0] = type;
                    break;
                }
            }
        }
        else if ("sms".equals(this.mPaymentInfo.getPaytype())) {
            for (final IType type2 : availablePayType) {
                if ("sms".equals(type2.getId())) {
                    array[0] = type2;
                    break;
                }
            }
        }
        else {
            for (final IType type3 : availablePayType) {
                if ("upoint".equals(type3.getId())) {
                    array[0] = type3;
                }
                else {
                    if (!"sms".equals(type3.getId())) {
                        continue;
                    }
                    array[array.length - 1] = type3;
                }
            }
        }
        this.mListView.setAdapter((ListAdapter)new CustomAdapter(this.getApplicationContext(), array));
    }
    
    private int getPayedAmount() {
        return this.mSmsInfo.money * ((Utils.getSmsPayment() - PrefUtil.getPayedAmount(this.getApplicationContext())) / this.mSmsInfo.money - this.mLeftSmsToSendCount);
    }
    
    public static void init(final Context context) {
        SyncChargeChannelHandler.init();
        SyncPayChannelHandler.init();
        SyncSmsInfoHandler.init();
    }
    
    private boolean initPayment() {
        this.mPaymentInfo = (PaymentInfo)this.getIntent().getSerializableExtra("com.mappn.sdk.paymentinfo");
        if (this.mPaymentInfo == null) {
            throw new IllegalArgumentException("PaymentInfo\u5fc5\u987b\u8bbe\u7f6e");
        }
        this.mPaymentInfo.setPaytype("sms");
        final int money = this.mPaymentInfo.getMoney();
        boolean b;
        if (money <= 0 || money > 10000 || money % 5 != 0) {
            this.showDialog(0);
            b = false;
        }
        else {
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
            if (!Utils.isNumeric(this.mPaymentInfo.getmGameID())) {
                throw new IllegalArgumentException("\u6e38\u620fID\u5fc5\u987b\u4e3a\u4e24\u4f4d\u6570\u5b57");
            }
            if (this.mPaymentInfo.getmActionID() == null) {
                throw new IllegalArgumentException("\u5fc5\u987b\u6307\u5b9a\u652f\u4ed8\u70b9ID");
            }
            if (this.mPaymentInfo.getmActionID().length() != 2) {
                throw new IllegalArgumentException("\u652f\u4ed8\u70b9ID\u5fc5\u987b\u4e3a\u4e24\u4f4d\u6570\u5b57");
            }
            if (!Utils.isNumeric(this.mPaymentInfo.getmActionID())) {
                throw new IllegalArgumentException("\u652f\u4ed8\u70b9ID\u5fc5\u987b\u4e3a\u4e24\u4f4d\u6570\u5b57");
            }
            if (this.mPaymentInfo.getPayname().length() > 50) {
                this.mPaymentInfo.setPayname(this.mPaymentInfo.getPayname().substring(0, 50));
            }
            if (this.mPaymentInfo.getPaydesc().length() > 100) {
                this.mPaymentInfo.setPaydesc(this.mPaymentInfo.getPaydesc().substring(0, 100));
            }
            while (true) {
                try {
                    final String cpID = Utils.getCpID(this.getApplicationContext());
                    if (!Pattern.matches("^[0-9a-zA-Z]{1,10}$", cpID)) {
                        this.showDialog(22);
                        b = false;
                    }
                    else {
                        this.mPaymentInfo.setCpID(cpID);
                        if (this.mPaymentInfo.getUsername() != null) {
                            PrefUtil.setUCUserName(this.getApplicationContext(), this.mPaymentInfo.getUsername());
                        }
                        Utils.setPaymentInfo(this.mPaymentInfo);
                        b = true;
                    }
                }
                catch (final PackageManager$NameNotFoundException ex) {
                    this.showDialog(22);
                    continue;
                }
                catch (final NullPointerException ex2) {
                    this.showDialog(22);
                    continue;
                }
                break;
            }
        }
        return b;
    }
    
    private void initSmsPayView(final TextView textView, final TextView textView2, int mLeftSmsToReceiveCount, final Button button, final Button button2, final RelativeLayout contentView) {
        while (true) {
            final RelativeLayout$LayoutParams layoutParams = new RelativeLayout$LayoutParams(150, -2);
            while (true) {
                int payedAmount = 0;
                Label_0418: {
                    while (true) {
                        try {
                            payedAmount = PrefUtil.getPayedAmount(this.getApplicationContext());
                            if (payedAmount != 0) {
                                break Label_0418;
                            }
                            if (this.mSmsInfo == null) {
                                (this.mSmsInfo = Utils.getSmsInfos().filterSmsInfo(this.getApplicationContext(), mLeftSmsToReceiveCount)).setExtInfo(this.mPaymentInfo);
                            }
                            int n2;
                            final int n = n2 = mLeftSmsToReceiveCount / this.mSmsInfo.money;
                            if (mLeftSmsToReceiveCount % this.mSmsInfo.money != 0) {
                                n2 = n + 1;
                            }
                            if (!this.mSmsInfo.isNeedconfirm()) {
                                Spanned text;
                                if (this.mLeftSmsToSendCount == -1) {
                                    this.mLeftSmsToReceiveCount = n2;
                                    this.mLeftSmsToSendCount = n2;
                                    text = Html.fromHtml(String.format("\u5c0a\u656c\u7684\u7528\u6237\uff0c\u611f\u8c22\u60a8\u4e3a\u6e38\u620f\u652f\u4ed8\uff0c\u60a8\u9700\u8981\u53d1\u9001<font color='#FF4500'>[ %d ]</font>\u6761 %d \u5143\u7684\u77ed\u4fe1\uff0c\u8d2d\u4e70<font color='#FF4500'>[%s]</font>\uff0c\u5171\u8ba1<font color='#FF4500'>[ %d ]</font>\u5143\uff0c\u70b9\u51fb<font color='#FF4500'>[\u70b9\u64ad]</font>\u5f00\u59cb\u53d1\u9001\u3002\u8bf7\u6ce8\u610f\u53d1\u9001\u5f00\u59cb\u540e\uff0c\u60a8\u4e0d\u80fd\u4e2d\u65ad\u53d1\u9001\uff0c\u5426\u5219\u8d2d\u4e70\u5c06\u4e0d\u6210\u529f\u3002", Integer.valueOf(this.mLeftSmsToSendCount), Integer.valueOf(this.mSmsInfo.money), this.mPaymentInfo.getPayname(), Integer.valueOf(mLeftSmsToReceiveCount)));
                                    this.mIsShowInfo = true;
                                }
                                else {
                                    text = Html.fromHtml(String.format("\u5c0a\u656c\u7684\u7528\u6237\uff0c\u70b9\u51fb<font color='#FF4500'>[\u786e\u5b9a]</font>\u6309\u94ae\uff0c\u53d1\u9001\u7b2c<font color='#FF4500'>[ %d ]</font>\u6761\u77ed\u4fe1\u3002", Integer.valueOf(n2 - this.mLeftSmsToSendCount + 1)));
                                    button.setVisibility(8);
                                    button2.setText((CharSequence)"\u786e\u5b9a");
                                    layoutParams.addRule(14, -1);
                                }
                                textView.setText((CharSequence)text);
                                textView2.setText((CharSequence)this.mSmsInfo.getInfobeforesend());
                                Linkify.addLinks(textView, 4);
                                Linkify.addLinks(textView2, 4);
                                layoutParams.addRule(12, -1);
                                layoutParams.setMargins(10, 20, 10, 10);
                                button2.setLayoutParams((ViewGroup$LayoutParams)layoutParams);
                                contentView.addView((View)button2);
                                final RelativeLayout$LayoutParams layoutParams2 = new RelativeLayout$LayoutParams(150, -2);
                                layoutParams2.addRule(11, -1);
                                layoutParams2.addRule(12, -1);
                                layoutParams2.setMargins(10, 20, 10, 10);
                                button.setLayoutParams((ViewGroup$LayoutParams)layoutParams2);
                                contentView.addView((View)button);
                                this.setContentView((View)contentView);
                                return;
                            }
                        }
                        catch (final SimCardNotSupportException ex) {
                            this.mSmsResultInfo = ex.getMessage();
                            this.showDialog(16);
                            continue;
                        }
                        break;
                    }
                    textView.setText((CharSequence)this.mSmsInfo.getInfobeforesend());
                    button.setVisibility(8);
                    button2.setText((CharSequence)"\u786e\u5b9a");
                    layoutParams.addRule(14, -1);
                    continue;
                }
                final int n3 = mLeftSmsToReceiveCount - payedAmount;
                if (this.mSmsInfo == null) {
                    (this.mSmsInfo = Utils.getSmsInfos().filterSmsInfo(this.getApplicationContext(), n3)).setExtInfo(this.mPaymentInfo);
                }
                if (!this.mSmsInfo.isNeedconfirm()) {
                    Spanned text2;
                    if (this.mLeftSmsToSendCount == -1) {
                        final int n4 = mLeftSmsToReceiveCount = n3 / this.mSmsInfo.money;
                        if (n3 % this.mSmsInfo.money != 0) {
                            mLeftSmsToReceiveCount = n4 + 1;
                        }
                        this.mIsShowInfo = true;
                        this.mLeftSmsToSendCount = mLeftSmsToReceiveCount;
                        this.mLeftSmsToReceiveCount = mLeftSmsToReceiveCount;
                        text2 = Html.fromHtml(String.format("\u60a8\u4ee5\u524d\u6210\u529f\u53d1\u9001\u8fc7\u603b\u8ba1 %d \u5143\u7684\u77ed\u4fe1\u8d2d\u4e70<font color='#FF4500'>[%s]</font>\uff0c\u76ee\u524d\u8fd8\u9700\u53d1\u9001<font color='#FF4500'>[ %d ]</font>\u6761  %d \u5143\u77ed\u4fe1\u7ee7\u7eed\u8d2d\u4e70\uff0c\u70b9\u51fb<font color='#FF4500'>[\u70b9\u64ad]</font>\u6309\u94ae\u5f00\u59cb\u53d1\u9001\u3002", Integer.valueOf(payedAmount), this.mPaymentInfo.getPayname(), Integer.valueOf(this.mLeftSmsToSendCount), Integer.valueOf(this.mSmsInfo.money)));
                    }
                    else {
                        text2 = Html.fromHtml(String.format("\u5c0a\u656c\u7684\u7528\u6237\uff0c\u70b9\u51fb<font color='#FF4500'>[\u786e\u5b9a]</font>\u6309\u94ae\uff0c\u5f00\u59cb\u53d1\u9001\u7b2c<font color='#FF4500'>[ %d ]</font>\u6761\u77ed\u4fe1\u3002", Integer.valueOf(n3 / this.mSmsInfo.money - this.mLeftSmsToSendCount + 1), Integer.valueOf(this.mLeftSmsToSendCount)));
                        button.setVisibility(8);
                        button2.setText((CharSequence)"\u786e\u5b9a");
                        layoutParams.addRule(14, -1);
                    }
                    textView.setText((CharSequence)text2);
                    textView2.setText((CharSequence)this.mSmsInfo.getInfobeforesend());
                    continue;
                }
                textView.setText((CharSequence)this.mSmsInfo.getInfobeforesend());
                button.setVisibility(8);
                button2.setText((CharSequence)"\u786e\u5b9a");
                layoutParams.addRule(14, -1);
                continue;
            }
        }
    }
    
    private void initUPointPayView(final UPointInfo uPointInfo) {
        this.mTvDiscountTextView.setText((CharSequence)String.format("U\u70b9\u6298\u6263 : %s\u6298(%sU\u70b9)", uPointInfo.getDiscount(), uPointInfo.getDiscounttext()));
        if (uPointInfo.getVipdiscount() != null && uPointInfo.getVipdiscount().length() > 0) {
            this.mTvDiscountTextView.setText((CharSequence)String.format("\u4f1a\u5458\u6298\u6263 : %s\u6298(%sU\u70b9)", uPointInfo.getVipdiscount(), uPointInfo.getVipdiscounttext()));
            this.mTvVipDiscountTimeTextView.setText((CharSequence)String.format("\u4f1a\u5458\u6298\u6263\u5230\u671f\u65f6\u95f4 : ", uPointInfo.getVipdiscounttime()));
            this.mTvVipDiscountInfo.setText((CharSequence)("\u4f1a\u5458\u6298\u6263\u5230\u671f\u65f6\u95f4 : " + uPointInfo.getDiscountinfo()));
        }
        else {
            this.mTvVipDiscountTextView.setVisibility(8);
            this.mTvVipDiscountTimeTextView.setVisibility(8);
            this.mTvVipDiscountInfo.setVisibility(8);
        }
        this.mBtnPay.setVisibility(0);
    }
    
    private void pay() {
        this.showDialog(6);
        Api.pay(this.getApplicationContext(), this, this.mPaymentInfo, this.mUPayInfo);
    }
    
    private void sendConfirmSms(final String s) {
        this.showDialog(17);
        try {
            SmsInfo.sendSms(this.getApplicationContext(), s.split(",,,,")[0], s.split(",,,,")[1]);
        }
        catch (final Exception ex) {
            Label_0075: {
                if (this.mSmsHander == null || this.mSmsRunnable == null) {
                    break Label_0075;
                }
                this.mSmsHander.removeCallbacks(this.mSmsRunnable);
                this.getContentResolver().unregisterContentObserver(this.mSmsContent);
                try {
                    this.unregisterReceiver(this.mSmsReceiver);
                    this.removeDialog(17);
                    this.showDialog(38);
                }
                catch (final IllegalArgumentException ex2) {}
            }
        }
    }
    
    private void sendFirstSms(final SmsInfo smsInfo) {
        this.showDialog(17);
        try {
            smsInfo.sendFirstSms(this.getApplicationContext());
        }
        catch (final Exception ex) {
            Label_0060: {
                if (this.mSmsHander == null || this.mSmsRunnable == null) {
                    break Label_0060;
                }
                this.mSmsHander.removeCallbacks(this.mSmsRunnable);
                this.getContentResolver().unregisterContentObserver(this.mSmsContent);
                try {
                    this.unregisterReceiver(this.mSmsReceiver);
                    this.removeDialog(17);
                    this.showDialog(38);
                }
                catch (final IllegalArgumentException ex2) {}
            }
        }
    }
    
    public void confirmEnterPaymentPoint() {
        PrefUtil.increaseArriveCount(this.getApplicationContext());
    }
    
    protected void onActivityResult(final int n, final int n2, final Intent intent) {
        super.onActivityResult(n, n2, intent);
    }
    
    public void onClick(final View view) {
        Label_0020: {
            if (view == this.mBtnPay) {
                this.mBtnPay.setEnabled(false);
                this.buildUPointPayLoginView();
            }
            else {
                final String string3;
                switch (view.getId()) {
                    case 8:
                        Label_0075: {
                            ((Button)view).setEnabled(false);
                            string3 = this.mEtPayPass.getText().toString();
                            if (TextUtils.isEmpty((CharSequence)string3)) {
                                this.showDialog(28);
                                break Label_0075;
                            }
                            this.mUPayInfo.setPaypwd(string3);
                            this.pay();
                            break Label_0075;
                        }
                    case 3: {
                        if (this.mIsShowInfo) {
                            this.buildSmsPaymentView();
                            this.mIsShowInfo = false;
                            break;
                        }
                        if (this.mSmsInfo != null) {
                            this.registerReceiver(this.mSmsReceiver, new IntentFilter("com.uc.androidsdk.SMS_SENT_ACTION"));
                            this.sendFirstSms(this.mSmsInfo);
                            break;
                        }
                        break;
                    }
                    case 7: {
                        ((Button)view).setEnabled(false);
                        final String string = this.mEtUsername.getText().toString();
                        final String string2 = this.mEtPassword.getText().toString();
                        if (TextUtils.isEmpty((CharSequence)string) && TextUtils.isEmpty((CharSequence)string2)) {
                            this.showDialog(28);
                            break;
                        }
                        if (TextUtils.isEmpty((CharSequence)string2)) {
                            this.showDialog(29);
                            break;
                        }
                        if (TextUtils.isEmpty((CharSequence)string)) {
                            this.showDialog(30);
                            break;
                        }
                        this.mUPayInfo = new UPointPayInfo(string, string2, "", this.mPaymentInfo.getCpID(), this.mPaymentInfo.getmGameID(), this.mPaymentInfo.getMoney(), "");
                        this.pay();
                        break;
                    }
                    case 5: {
                        if (this.mConfirmSmsInfoString != null && this.mConfirmSmsInfoString.contains(",,,,")) {
                            this.sendConfirmSms(this.mConfirmSmsInfoString);
                            break;
                        }
                        break;
                    }
                    case 4: {
                        this.buildPaymentView();
                        break;
                    }
                    case 6: {
                        this.showDialog(23);
                        break;
                    }
                    case 9: {
                        switch (this.mType) {
                            default: {
                                break Label_0020;
                            }
                            case 0: {
                                this.finish();
                                break Label_0020;
                            }
                            case 1: {
                                this.buildPaymentView();
                                break Label_0020;
                            }
                            case 2: {
                                this.buildUPointPaymentView();
                                break Label_0020;
                            }
                            case 3: {
                                this.buildUPointPayLoginView();
                                break Label_0020;
                            }
                            case 4: {
                                if (this.mSmsInfo.isNeedconfirm() || this.mIsShowInfo) {
                                    this.buildPaymentView();
                                    break Label_0020;
                                }
                                final int n = Utils.getSmsPayment() / this.mSmsInfo.money;
                                if (this.mLeftSmsToSendCount != -1 && this.mLeftSmsToSendCount != n) {
                                    this.showDialog(27);
                                    break Label_0020;
                                }
                                this.buildSmsPaymentView();
                                break Label_0020;
                            }
                            case 5: {
                                this.showDialog(23);
                                break Label_0020;
                            }
                        }
                        break;
                    }
                    case 10: {
                        switch (this.mType) {
                            default: {
                                this.finish();
                                break Label_0020;
                            }
                            case 4: {
                                if (!this.mSmsInfo.isNeedconfirm() && !this.mIsShowInfo) {
                                    break Label_0020;
                                }
                                final int n2 = Utils.getSmsPayment() / this.mSmsInfo.money;
                                if (this.mLeftSmsToSendCount != -1 && this.mLeftSmsToSendCount != n2) {
                                    this.showDialog(27);
                                    break Label_0020;
                                }
                                this.buildPaymentView();
                                break Label_0020;
                            }
                            case 5: {
                                this.showDialog(23);
                                break Label_0020;
                            }
                        }
                        break;
                    }
                }
            }
        }
    }
    
    protected void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        this.mIsValid = this.initPayment();
        if (this.mIsValid) {
            Utils.init(this.getApplicationContext());
            Utils.initTitleBar(this);
            this.buildPaymentView();
            this.confirmEnterPaymentPoint();
            new HandlerProxy(this.getApplicationContext()).handleRequest();
        }
    }
    
    protected Dialog onCreateDialog(final int n) {
        Dialog dialog = null;
        switch (n) {
            default: {
                dialog = super.onCreateDialog(n);
                break;
            }
            case 0: {
                dialog = DialogUtil.createOKWarningDialog(this, n, (CharSequence)"\u8be5\u5e94\u7528\u8981\u6c42\u652f\u4ed8\u7684\u91d1\u989d\u4e0d\u7b26\u5408\u8981\u6c42\uff0c\u4e0d\u80fd\u6210\u529f\u652f\u4ed8\u3002", (DialogUtil.WarningDialogListener)this);
                break;
            }
            case 22: {
                dialog = DialogUtil.createOKWarningDialog(this, n, (CharSequence)"CPID\u4e3a\u5b57\u7b26\u4e32\u548c\u6570\u5b57\u4efb\u610f\u7ec4\u5408\uff0c\u4e0d\u80fd\u7531\u4e2d\u6587\u5b57\u7b26\u3001\u6807\u70b9\u7b26\u53f7\u6216\u7a7a\u683c\uff0c\u957f\u5ea6\u4e0d\u8d85\u8fc710\u4e2a\u82f1\u6587\u5b57\u7b26\u3002", (DialogUtil.WarningDialogListener)this);
                break;
            }
            case 2: {
                dialog = DialogUtil.createOKWarningDialogSupportLink(this, n, "\u4ec0\u4e48\u662fU\u70b9?", "U\u70b9\u662f<a href='http://wap.uc.cn'>UC-\u4f18\u89c6</a>\u63d0\u4f9b\u7684\u4e00\u79cd\u865a\u62df\u8d27\u5e01\uff0c\u4e3b\u8981\u7528\u4e8e\u8d2d\u4e70\u8f6f\u4ef6\u548c\u6e38\u620f\u91cc\u7684\u5185\u5bb9\uff08\u5982\uff1a\u9053\u5177\u3001\u5173\u5361\u3001\u8f6f\u4ef6\u3001\u4f7f\u7528\u65f6\u957f\u7b49\uff09\u3002<br /><br />U\u70b9\u5151\u6362\u6807\u51c6\uff1a<br />1\u5143\u53ef\u5151\u636210U\u70b9\u3002<br />\u901a\u8fc7\u4ee5\u4e0b\u94fe\u63a5\u5145\u503cU\u70b9\uff1a<br /><a href='http://pay.uc.cn'>UC-\u4f18\u89c6</a>", (DialogUtil.WarningDialogListener)null);
                break;
            }
            case 14: {
                dialog = DialogUtil.createIndeterminateProgressDialog(this, n, "\u8fde\u63a5\u670d\u52a1\u5668\uff0c\u8bf7\u7a0d\u7b49...", false, (DialogUtil.ProgressDialogListener)null);
                break;
            }
            case 6: {
                dialog = DialogUtil.createIndeterminateProgressDialog(this, n, "\u6b63\u5728\u652f\u4ed8\uff0c\u8bf7\u52ff\u5173\u95ed\u7a0b\u5e8f\uff0c\u8bf7\u7a0d\u540e......", false, (DialogUtil.ProgressDialogListener)null);
                break;
            }
            case 7: {
                dialog = DialogUtil.createOKWarningDialog(this, n, (CharSequence)"\u652f\u4ed8\u4e0d\u6210\u529f\uff0c\u8bf7\u786e\u5b9a\u60a8\u7684\u8d26\u6237\u5f53\u4e2d\u7684\u4f59\u989d\u5145\u8db3\u5e76\u7f51\u7edc\u8fde\u63a5\u6b63\u5e38\u3002", (DialogUtil.WarningDialogListener)null);
                break;
            }
            case 8: {
                dialog = DialogUtil.createOKWarningDialog(this, n, (CharSequence)"\u652f\u4ed8\u4e0d\u6210\u529f\uff0c\u8bf7\u786e\u5b9a\u60a8\u7684\u8d26\u6237\u5f53\u4e2d\u7684\u4f59\u989d\u5145\u8db3\u5e76\u7f51\u7edc\u8fde\u63a5\u6b63\u5e38\u3002", (DialogUtil.WarningDialogListener)null);
                break;
            }
            case 9: {
                dialog = DialogUtil.createOKWarningDialog(this, n, (CharSequence)"\u652f\u4ed8\u4e0d\u6210\u529f\uff0c\u8bf7\u786e\u5b9a\u60a8\u7684\u8d26\u6237\u5f53\u4e2d\u7684\u4f59\u989d\u5145\u8db3\u5e76\u7f51\u7edc\u8fde\u63a5\u6b63\u5e38\u3002", (DialogUtil.WarningDialogListener)null);
                break;
            }
            case 37: {
                dialog = DialogUtil.createOKWarningDialog(this, n, (CharSequence)"\u652f\u4ed8\u4e0d\u6210\u529f\uff0c\u60a8\u7684\u652f\u4ed8\u5bc6\u7801\u6709\u8bef\uff0c\u4e0d\u80fd\u652f\u4ed8\u6210\u529f\uff01", (DialogUtil.WarningDialogListener)null);
                break;
            }
            case 10: {
                dialog = DialogUtil.createYesNoDialog(this, n, (CharSequence)"\u652f\u4ed8\u4e0d\u6210\u529f\uff0c\u8fde\u63a5\u670d\u52a1\u5668\u8d85\u65f6\uff0c\u662f\u5426\u91cd\u8bd5?", (DialogUtil.WarningDialogListener)this);
                break;
            }
            case 38: {
                dialog = DialogUtil.createOKWarningDialog(this, n, (CharSequence)"\u652f\u4ed8\u4e0d\u6210\u529f\uff0c\u60a8\u5df2\u7ecf\u7981\u6b62\u4e86\u53d1\u9001\u652f\u4ed8\u77ed\u4fe1\uff0c\u8bf7\u91cd\u65b0\u5c1d\u8bd5\u652f\u4ed8\u3002", (DialogUtil.WarningDialogListener)null);
                break;
            }
            case 36: {
                dialog = DialogUtil.createYesNoDialog(this, n, (CharSequence)"\u60a8\u624b\u673a\u65f6\u95f4\u4e0d\u6b63\u786e\uff0c\u4e3a\u4e86\u786e\u4fdd\u5b89\u5168\u652f\u4ed8\uff0c\u662f\u5426\u9700\u8981\u7cfb\u7edf\u81ea\u52a8\u4fee\u6b63\u5e76\u5b8c\u6210\u652f\u4ed8?", (DialogUtil.WarningDialogListener)this);
                break;
            }
            case 11: {
                dialog = DialogUtil.createOKWarningDialog(this, n, (CharSequence)"\u652f\u4ed8\u4e0d\u6210\u529f\uff0c\u8bf7\u786e\u5b9a\u60a8\u7684\u8d26\u6237\u5f53\u4e2d\u7684\u4f59\u989d\u5145\u8db3\u5e76\u7f51\u7edc\u8fde\u63a5\u6b63\u5e38\u3002\n\u8bf7\u8054\u7cfb\u5ba2\u670d4006-400-401\u3002", (DialogUtil.WarningDialogListener)null);
                break;
            }
            case 13: {
                dialog = DialogUtil.createOKWarningDialog(this, n, (CharSequence)"U\u70b9\u652f\u4ed8\u6210\u529f\uff0c\u795d\u60a8\u73a9\u7684\u5f00\u5fc3", (CharSequence)String.format("\u60a8\u7684\u4f59\u989d\u4e3a%dU\u70b9", this.mNumber, Integer.valueOf(this.mBalance)), (DialogUtil.WarningDialogListener)this);
                break;
            }
            case 5: {
                dialog = DialogUtil.createOKWarningDialog(this, n, (CharSequence)"U\u70b9\u4e0d\u8db3,\u4e0d\u80fd\u7ee7\u7eed\u652f\u4ed8\uff01", (DialogUtil.WarningDialogListener)null);
                break;
            }
            case 15: {
                dialog = DialogUtil.createOKWarningDialog(this, n, (CharSequence)"\u7f51\u7edc\u8fde\u63a5\u9519\u8bef\uff0c\u8bf7\u68c0\u67e5\u7f51\u7edc\u540e\u518d\u8bd5\u3002", (DialogUtil.WarningDialogListener)this);
                break;
            }
            case 16: {
                dialog = DialogUtil.createOKWarningDialog(this, n, (CharSequence)this.mSmsResultInfo, (DialogUtil.WarningDialogListener)this);
                break;
            }
            case 17: {
                dialog = DialogUtil.createIndeterminateProgressDialog(this, n, "\u77ed\u4fe1\u53d1\u9001\u8fc7\u7a0b\u53ef\u80fd\u6301\u7eed\u4e00\u5206\u949f\uff0c\u8bf7\u8010\u5fc3\u7b49\u5f85...", false, (DialogUtil.ProgressDialogListener)null);
                break;
            }
            case 19: {
                dialog = DialogUtil.createIndeterminateProgressDialog(this, n, "\u6b63\u5728\u83b7\u53d6\u4fe1\u606f\uff0c\u8bf7\u7a0d\u5019......", false, (DialogUtil.ProgressDialogListener)null);
                break;
            }
            case 20: {
                dialog = DialogUtil.createOKWarningDialog(this, n, (CharSequence)"\u8d2d\u4e70\u6210\u529f", (CharSequence)this.mSmsResultInfo, (DialogUtil.WarningDialogListener)this);
                break;
            }
            case 21: {
                dialog = DialogUtil.createOKWarningDialog(this, n, (CharSequence)this.mSmsResultInfo, (DialogUtil.WarningDialogListener)this);
                break;
            }
            case 23: {
                dialog = DialogUtil.createTwoButtonsDialog(this, n, (CharSequence)"\u60a8\u5df2\u7ecf\u53d6\u6d88\u4e86\u8d2d\u4e70\uff0c\u5c06\u4e0d\u4f1a\u83b7\u5f97\u76f8\u5e94\u5185\u5bb9\u3002\u8bf7\u786e\u8ba4\u662f\u5426\u53d6\u6d88\uff1f", (CharSequence)"\u53d6\u6d88", (CharSequence)"\u4e0d\u53d6\u6d88", (DialogUtil.WarningDialogListener)this);
                break;
            }
            case 24: {
                dialog = DialogUtil.createTwoButtonsDialog(this, n, (CharSequence)Html.fromHtml("\u8d2d\u4e70\u786e\u8ba4\u77ed\u4fe1\u672a\u5220\u9664\uff0c\u5982\u9700\u8d2d\u4e70\u8bf7\u518d\u6b21\u53d1\u9001\u77ed\u4fe1\u6216\u91c7\u7528\u5176\u4ed6\u652f\u4ed8\u65b9\u5f0f\uff0c<font color='red'>\u8bf7\u52ff\u5230\u77ed\u4fe1\u6536\u4ef6\u7bb1\u8fdb\u884c\u56de\u590d</font>\uff0c\u8c22\u8c22\uff01"), (CharSequence)"\u8fd4\u56de\u8d2d\u4e70\u9875", (CharSequence)"\u8fd4\u56de\u5e94\u7528", (DialogUtil.WarningDialogListener)this);
                break;
            }
            case 25: {
                dialog = DialogUtil.createTwoButtonsDialog(this, n, (CharSequence)"\u8d2d\u4e70\u786e\u8ba4\u77ed\u4fe1\u5df2\u5220\u9664\uff0c\u5982\u9700\u8d2d\u4e70\u8bf7\u518d\u6b21\u53d1\u9001\u77ed\u4fe1\u6216\u91c7\u7528\u5176\u4ed6\u652f\u4ed8\u65b9\u5f0f\uff0c\u8c22\u8c22\uff01", (CharSequence)"\u8fd4\u56de\u8d2d\u4e70\u9875", (CharSequence)"\u8fd4\u56de\u5e94\u7528", (DialogUtil.WarningDialogListener)this);
                break;
            }
            case 26: {
                dialog = DialogUtil.createOKWarningDialog(this, n, (CharSequence)"\u652f\u4ed8\u8d85\u65f6\uff0c\u70b9\u51fb\u786e\u5b9a\u91cd\u65b0\u9a8c\u8bc1\u652f\u4ed8\u7ed3\u679c\u3002\u6700\u591a \u9700\u89811\u5206\u949f\uff0c\u8bf7\u8010\u5fc3\u7b49\u5f85...", (DialogUtil.WarningDialogListener)this);
                break;
            }
            case 27: {
                dialog = DialogUtil.createTwoButtonsDialog(this, n, (CharSequence)String.format("\u60a8\u5df2\u7ecf\u652f\u4ed8\u8fc7\u3010%d\u3011\u5143\u77ed\u4fe1\uff0c\u73b0\u5728\u53d6\u6d88\u53d1\u9001\u5c06\u4e0d\u80fd\u6210\u529f\u8d2d\u4e70\u3010%s\u3011\u3002\u5982\u53d6\u6d88\u53d1\u9001\u5df2\u4ed8\u91d1\u989d\u4e0d\u4f1a\u8fd4\u8fd8\uff0c\u53ea\u80fd\u8ba1\u7b97\u5230\u60a8\u4e0b\u6b21\u8d2d\u4e70\u3010%s\u3011\u4e2d\u3002\u8bf7\u518d\u6b21\u786e\u8ba4\u662f\u5426\u53d6\u6d88\u8fd9\u6b21\u652f\u4ed8\uff1f", Integer.valueOf(PrefUtil.getPayedAmount(this.getApplicationContext()) + this.getPayedAmount()), this.mPaymentInfo.getPayname(), this.mPaymentInfo.getPayname()), (CharSequence)"\u8fd4\u56de\u7ee7\u7eed\u652f\u4ed8", (CharSequence)"\u786e\u8ba4\u53d6\u6d88", (DialogUtil.WarningDialogListener)this);
                break;
            }
            case 18: {
                dialog = DialogUtil.createOKWarningDialog(this, n, (CharSequence)"\u77ed\u4fe1\u53d1\u9001\u5931\u8d25", (DialogUtil.WarningDialogListener)null);
                break;
            }
            case 35: {
                dialog = DialogUtil.createIndeterminateProgressDialog(this, n, "U\u70b9\u652f\u4ed8\u4e2d\uff0c\u8bf7\u7a0d\u5019...", false, (DialogUtil.ProgressDialogListener)null);
                break;
            }
            case 28: {
                dialog = DialogUtil.createOKWarningDialog(this, n, (CharSequence)"\u8bf7\u8f93\u5165\u8d26\u53f7\u548c\u5bc6\u7801\u3002", (DialogUtil.WarningDialogListener)null);
                break;
            }
            case 29: {
                dialog = DialogUtil.createOKWarningDialog(this, n, (CharSequence)"\u5bc6\u7801\u4e3a\u7a7a\uff0c\u8bf7\u8f93\u5165\u5bc6\u7801\u3002", (DialogUtil.WarningDialogListener)null);
                break;
            }
            case 30: {
                dialog = DialogUtil.createOKWarningDialog(this, n, (CharSequence)"\u7528\u6237\u540d\u4e3a\u7a7a\uff0c\u8bf7\u8f93\u5165\u7528\u6237\u540d\u3002", (DialogUtil.WarningDialogListener)null);
                break;
            }
            case 31: {
                dialog = DialogUtil.createOKWarningDialog(this, n, (CharSequence)"\u7528\u6237\u540d\u5fc5\u987b\u5927\u4e8e3\u4e2a\u5b57\u3002", (DialogUtil.WarningDialogListener)null);
                break;
            }
            case 32: {
                dialog = DialogUtil.createOKWarningDialog(this, n, (CharSequence)"\u7528\u6237\u540d\u5fc5\u987b\u5c0f\u4e8e17\u4e2a\u5b57\u3002", (DialogUtil.WarningDialogListener)null);
                break;
            }
            case 33: {
                dialog = DialogUtil.createOKWarningDialog(this, n, (CharSequence)"\u5bc6\u7801\u4e0d\u80fd\u4e3a\u7a7a\u3002", (DialogUtil.WarningDialogListener)null);
                break;
            }
            case 34: {
                dialog = DialogUtil.createOKWarningDialog(this, n, (CharSequence)"\u767b\u5f55\u5931\u8d25\uff0c\u60a8\u7684\u5e10\u53f7\u548c\u5bc6\u7801\u4e0d\u5339\u914d\u3002", (DialogUtil.WarningDialogListener)null);
                break;
            }
        }
        return dialog;
    }
    
    protected void onDestroy() {
        super.onDestroy();
        if (this.mIsValid) {
            PrefUtil.logout(this.getApplicationContext());
            Utils.clearSmsInfos();
            Utils.clearUPointInfo();
            TypeFactory.clear();
            Utils.clearUPointPayInfo();
            SyncChargeChannelHandler.init();
            SyncPayChannelHandler.init();
            SyncSmsInfoHandler.init();
        }
    }
    
    public void onError(final int n, final int n2) {
        Label_0028: {
            switch (n) {
                case 3: {
                    switch (n2) {
                        default: {
                            this.mBtnPay.setEnabled(true);
                            this.removeDialog(6);
                            this.showDialog(7);
                            break Label_0028;
                        }
                        case 425: {
                            this.mBtnPay.setEnabled(true);
                            this.removeDialog(6);
                            this.showDialog(8);
                            break Label_0028;
                        }
                        case 219: {
                            this.mBtnPay.setEnabled(false);
                            this.removeDialog(6);
                            this.showDialog(5);
                            this.buildPaymentView();
                            break Label_0028;
                        }
                        case 500: {
                            this.mBtnPay.setEnabled(true);
                            this.removeDialog(6);
                            this.showDialog(11);
                            break Label_0028;
                        }
                        case -1: {
                            ++this.mTimeoutCounter;
                            if (this.mTimeoutCounter < 2) {
                                Api.pay(this.getApplicationContext(), this, this.mPaymentInfo, this.mUPayInfo);
                                break Label_0028;
                            }
                            this.mTimeoutCounter = 0;
                            this.mBtnPay.setEnabled(true);
                            this.removeDialog(6);
                            this.showDialog(10);
                            break Label_0028;
                        }
                    }
                    break;
                }
                case 18: {
                    this.dismissDialog(14);
                    this.showDialog(15);
                    this.buildPaymentView();
                    break;
                }
            }
        }
    }
    
    public void onFinish() {
        this.fillData();
    }
    
    public void onItemClick(final AdapterView<?> adapterView, final View view, final int n, final long n2) {
        if (n != 0) {
            final String id = ((CustomAdapter)((HeaderViewListAdapter)adapterView.getAdapter()).getWrappedAdapter()).getItem(n - 1).getId();
            if ("upoint".equals(id)) {
                this.buildUPointPaymentView();
            }
            else if ("sms".equals(id)) {
                this.buildSmsPaymentView();
            }
        }
    }
    
    public boolean onKeyDown(int n, final KeyEvent keyEvent) {
        Label_0020: {
            switch (n) {
                case 4: {
                    switch (this.mType) {
                        default: {
                            break Label_0020;
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
                                }
                                else {
                                    this.buildPaymentView();
                                }
                            }
                            else {
                                this.buildPaymentView();
                            }
                            return true;
                        }
                        case 5: {
                            this.showDialog(23);
                            return true;
                        }
                    }
                    break;
                }
            }
        }
        return super.onKeyDown(n, keyEvent);
    }
    
    public Object onPreHandle(final int n, final HttpResponse httpResponse) {
        Object o;
        if (5 == n || 8 == n) {
            o = Boolean.valueOf(true);
        }
        else {
            final String bodyString = Utils.getBodyString(n, httpResponse);
            if (TextUtils.isEmpty((CharSequence)bodyString)) {
                o = null;
            }
            else {
                switch (n) {
                    case 3: {
                        try {
                            o = XMLParser.parsePayOrder(bodyString);
                            return o;
                        }
                        catch (final Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                    case 18: {
                        try {
                            o = XMLParser.parseUPointInfo(bodyString);
                            return o;
                        }
                        catch (final Exception ex2) {
                            ex2.printStackTrace();
                            break;
                        }
                        break;
                    }
                }
                o = null;
            }
        }
        return o;
    }
    
    protected void onPrepareDialog(final int n, final Dialog dialog) {
        super.onPrepareDialog(n, dialog);
        if (dialog.isShowing()) {
            dialog.dismiss();
        }
    }
    
    public void onSuccess(int int1, final Object o) {
        switch (int1) {
            case 3: {
                final String[] split = ((String)o).split("#");
                int1 = Integer.parseInt(split[0]);
                final String s = split[1];
                this.removeDialog(6);
                if (int1 == -110) {
                    this.showDialog(7);
                    this.mUPayInfo.updateConsumeId();
                    break;
                }
                if (int1 == -102 && s.equals("uc_tm_modify")) {
                    this.mUPayInfo.setTm(split[2]);
                    this.showDialog(36);
                    break;
                }
                if (int1 >= 0) {
                    if (this.mEtSavePass.isChecked()) {
                        PrefUtil.setUCUserName(this.getApplicationContext(), this.mEtUsername.getText().toString());
                        PrefUtil.setUCUserPass(this.getApplicationContext(), this.mEtPassword.getText().toString());
                    }
                    else {
                        PrefUtil.clearUCUserName(this.getApplicationContext());
                        PrefUtil.clearUCUserPass(this.getApplicationContext());
                    }
                    this.showDialog(13);
                    break;
                }
                if (int1 != -102) {
                    break;
                }
                if (s.equals("uc_password_error")) {
                    this.showDialog(34);
                    break;
                }
                if (s.equals("um_account_error")) {
                    this.showDialog(5);
                    break;
                }
                if (s.equals("um_paypwd_error")) {
                    this.showDialog(37);
                    break;
                }
                if (s.equals("um_paypwd_error")) {
                    if (this.mType == 3) {
                        this.showDialog(7);
                        break;
                    }
                    if (this.mEtSavePass.isChecked()) {
                        PrefUtil.setUCUserName(this.getApplicationContext(), this.mEtUsername.getText().toString());
                        PrefUtil.setUCUserPass(this.getApplicationContext(), this.mEtPassword.getText().toString());
                    }
                    else {
                        PrefUtil.clearUCUserName(this.getApplicationContext());
                        PrefUtil.clearUCUserPass(this.getApplicationContext());
                    }
                    this.buildUPointPayPassView();
                    break;
                }
                else {
                    if (s.equals("um_system_error")) {
                        this.showDialog(7);
                        this.mUPayInfo.updateConsumeId();
                        break;
                    }
                    break;
                }
                break;
            }
            case 18: {
                final UPointInfo uPointInfo = (UPointInfo)o;
                this.initUPointPayView(uPointInfo);
                Utils.setUPointInfo(uPointInfo);
                this.dismissDialog(14);
                break;
            }
        }
    }
    
    public void onWarningDialogCancel(final int n) {
        while (true) {
            switch (n) {
                case 24:
                case 25: {
                    if (this.mSmsHander != null && this.mSmsRunnable != null)
                    break Label_0081;
                }
                case 27: {
                    Label_0088: {
                        break Label_0088;
                        this.mSmsHander.removeCallbacks(this.mSmsRunnable);
                        this.getContentResolver().unregisterContentObserver(this.mSmsContent);
                        try {
                            this.unregisterReceiver(this.mSmsReceiver);
                            this.finish();
                            break;
                            while (true) {
                                this.mSmsHander.removeCallbacks(this.mSmsRunnable);
                                this.getContentResolver().unregisterContentObserver(this.mSmsContent);
                                try {
                                    this.unregisterReceiver(this.mSmsReceiver);
                                    Label_0132: {
                                        this.buildPaymentView();
                                    }
                                }
                                catch (final IllegalArgumentException ex) {}
                                iftrue(Label_0132:)(this.mSmsHander == null || this.mSmsRunnable == null);
                                continue;
                            }
                        }
                        catch (final IllegalArgumentException ex2) {
                            continue;
                        }
                    }
                    break;
                }
            }
            break;
        }
    }
    
    public void onWarningDialogOK(final int n) {
    Label_0239_Outer:
        while (true) {
            while (true) {
                switch (n) {
                    case 10: {
                        this.pay();
                        break;
                    }
                    case 36: {
                        this.pay();
                        break;
                    }
                    case 20: {
                        PrefUtil.clearPayedAmount(this.getApplicationContext());
                    }
                    case 13: {
                        this.setResult(-1, new Intent());
                        this.finish();
                        break;
                    }
                    case 0:
                    case 1:
                    case 22: {
                        this.finish();
                        break;
                    }
                    case 21:
                    case 25: {
                        if (this.mSmsHander != null && this.mSmsRunnable != null) {
                            this.mSmsHander.removeCallbacks(this.mSmsRunnable);
                        }
                        if (this.mSmsContent != null) {
                            this.getContentResolver().unregisterContentObserver(this.mSmsContent);
                        }
                        break Label_0239_Outer;
                    }
                    case 15:
                    case 16:
                    case 24: {
                        while (true) {
                            break Label_0223;
                            try {
                                this.unregisterReceiver(this.mSmsReceiver);
                                this.buildPaymentView();
                                break;
                                while (true) {
                                    this.sendFirstSms(this.mSmsInfo);
                                    break;
                                    this.showDialog(24);
                                    break;
                                    Label_0258: {
                                        this.sendConfirmSms(this.mConfirmSmsInfoString);
                                    }
                                    break;
                                    iftrue(Label_0258:)(4 != this.mType);
                                    continue Label_0239_Outer;
                                }
                            }
                            catch (final IllegalArgumentException ex) {
                                continue Label_0239_Outer;
                            }
                            break;
                        }
                        break;
                    }
                    case 23: {
                        continue Label_0239_Outer;
                    }
                    case 26: {
                        continue;
                    }
                }
                break;
            }
            break;
        }
    }
    
    private class SmsContent extends ContentObserver
    {
        private static final String BODY = "body";
        private static final String NUMBER = "address";
        private Cursor mCursor;
        final PaymentsActivity this$0;
        
        public SmsContent(final PaymentsActivity this$0, final android.os.Handler handler) {
            this.this$0 = this$0;
            super(handler);
        }
        
        public void onChange(final boolean b) {
            super.onChange(b);
            Object o = Uri.parse("content://sms/inbox");
            this.mCursor = this.this$0.managedQuery((Uri)o, new String[] { "_id", "address", "body" }, " address like ? or address like ? and read=?", new String[] { String.valueOf(mSmsInfo.getSmsnumber()) + "%%", String.valueOf(mSmsInfo.getSmsConfirmNumber()) + "%%", "0" }, "date desc");
            if (this.mCursor != null) {
            Label_0467:
                while (true) {
                    if (!this.mCursor.moveToFirst()) {
                        break Label_0467;
                    }
                    if (mSmsId > 0 && mSmsId > this.mCursor.getInt(0)) {
                        this.mCursor.close();
                        return;
                    }
                    while (true) {
                        if (mLeftSmsToReceiveCount > 1) {
                            break Label_0248;
                        }
                        mSmsHander.removeCallbacks(mSmsRunnable);
                        this.this$0.getContentResolver().unregisterContentObserver(mSmsContent);
                        try {
                            this.this$0.unregisterReceiver(mSmsReceiver);
                            while (true) {
                                PaymentsActivity.access$15(this.this$0, this.mCursor.getInt(0));
                                final ContentValues contentValues = new ContentValues();
                                contentValues.put("read", "1");
                                String string = null;
                                Label_0716: {
                                    Label_0517: {
                                        while (true) {
                                            try {
                                                this.this$0.getContentResolver().update((Uri)o, contentValues, " _id=?", new String[] { new StringBuilder().append(mSmsId).toString() });
                                                string = this.mCursor.getString(this.mCursor.getColumnIndex("body"));
                                                o = this.mCursor.getString(this.mCursor.getColumnIndex("address"));
                                                if (4 != mType) {
                                                    break Label_0716;
                                                }
                                                if (!mSmsInfo.isNeedconfirm()) {
                                                    break Label_0517;
                                                }
                                                this.this$0.removeDialog(17);
                                                final String confirmSmsConfirmNumber = mSmsInfo.parseConfirmSmsConfirmNumber(string);
                                                if (mSmsInfo.isSuccess(string) && confirmSmsConfirmNumber != null) {
                                                    mSmsHander.removeCallbacks(mSmsRunnable);
                                                    this.this$0.buildSmsPaymentConfirmView((String)o, confirmSmsConfirmNumber);
                                                    this.mCursor.close();
                                                    break;
                                                }
                                            }
                                            catch (final SQLiteAbortException o) {
                                                ((SQLiteAbortException)o).printStackTrace();
                                                continue;
                                            }
                                            break;
                                        }
                                        this.this$0.removeDialog(17);
                                        PaymentsActivity.access$8(this.this$0, "\u4f59\u989d\u4e0d\u8db3\uff0c\u652f\u4ed8\u5931\u8d25");
                                        this.this$0.showDialog(21);
                                        continue Label_0467;
                                    }
                                    PrefUtil.setPayedAmount(this.this$0.getApplicationContext(), this.this$0.getPayedAmount());
                                    if (mLeftSmsToReceiveCount > 1) {
                                        o = this.this$0;
                                        PaymentsActivity.access$16((PaymentsActivity)o, mLeftSmsToReceiveCount - 1);
                                    }
                                    else {
                                        if (mLeftSmsToReceiveCount <= 1) {
                                            this.this$0.removeDialog(17);
                                        }
                                        PaymentsActivity.access$8(this.this$0, "\u652f\u4ed8\u5df2\u5b8c\u6210\uff0c\u795d\u60a8\u73a9\u5f97\u5f00\u5fc3\u3002");
                                        this.this$0.showDialog(20);
                                    }
                                    if (mSmsInfo.getSmstype() == 1) {
                                        Api.postSmsPayment(this.this$0.getApplicationContext(), this.this$0, mPaymentInfo.getCpID(), mPaymentInfo.getmGameID(), mPaymentInfo.getmActionID(), Utils.getSmsPayment(), mPaymentInfo.getmActionID(), mSmsInfo.getSmschannelid(), mSmsInfo.getSmsnumber(), mSmsInfo.getContent(), mSmsInfo.getSmstype());
                                        continue Label_0467;
                                    }
                                    continue Label_0467;
                                }
                                this.this$0.removeDialog(17);
                                if (!mSmsInfo.parseConfirmResultSms(string)) {
                                    PaymentsActivity.access$8(this.this$0, string);
                                    this.this$0.showDialog(21);
                                    continue Label_0467;
                                }
                                PrefUtil.setPayedAmount(this.this$0.getApplicationContext(), this.this$0.getPayedAmount());
                                if (mLeftSmsToReceiveCount > 1) {
                                    o = this.this$0;
                                    PaymentsActivity.access$16((PaymentsActivity)o, mLeftSmsToReceiveCount - 1);
                                    o = this.this$0;
                                    PaymentsActivity.access$4((PaymentsActivity)o, mLeftSmsToSendCount - 1);
                                    mSmsHander.removeCallbacks(mSmsRunnable);
                                    this.this$0.removeDialog(17);
                                    this.this$0.buildSmsPaymentView();
                                }
                                else {
                                    PaymentsActivity.access$8(this.this$0, string.replace((CharSequence)"success", (CharSequence)"\u8d2d\u4e70\u6210\u529f"));
                                    this.this$0.showDialog(20);
                                }
                                if (mSmsInfo.getSmstype() == 1) {
                                    Api.postSmsPayment(this.this$0.getApplicationContext(), this.this$0, mPaymentInfo.getCpID(), mPaymentInfo.getmGameID(), mPaymentInfo.getmActionID(), Utils.getSmsPayment(), mPaymentInfo.getmActionID(), mSmsInfo.getSmschannelid(), mSmsInfo.getSmsnumber(), mSmsInfo.getContent(), mSmsInfo.getSmstype());
                                    continue Label_0467;
                                }
                                continue Label_0467;
                            }
                        }
                        catch (final IllegalArgumentException ex) {
                            continue;
                        }
                        break;
                    }
                    break;
                }
            }
        }
    }
}
