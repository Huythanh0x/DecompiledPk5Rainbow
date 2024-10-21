package com.uc.paymentsdk.payment;

import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager.NameNotFoundException;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.sqlite.SQLiteAbortException;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.PasswordTransformationMethod;
import android.text.util.Linkify;
import android.view.KeyEvent;
import android.view.View.OnClickListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.HeaderViewListAdapter;
import android.widget.LinearLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.uc.paymentsdk.commons.ui.CustomAdapter;
import com.uc.paymentsdk.model.IType;
import com.uc.paymentsdk.model.TypeFactory;
import com.uc.paymentsdk.network.Api;
import com.uc.paymentsdk.network.ApiTask.TaskHandler;
import com.uc.paymentsdk.network.XMLParser;
import com.uc.paymentsdk.network.chain.Handler.OnFinishListener;
import com.uc.paymentsdk.network.chain.HandlerProxy;
import com.uc.paymentsdk.network.chain.SyncChargeChannelHandler;
import com.uc.paymentsdk.network.chain.SyncPayChannelHandler;
import com.uc.paymentsdk.network.chain.SyncSmsInfoHandler;
import com.uc.paymentsdk.payment.sms.SimCardNotSupportException;
import com.uc.paymentsdk.payment.sms.SmsInfo;
import com.uc.paymentsdk.payment.upoint.UPointInfo;
import com.uc.paymentsdk.payment.upoint.UPointPayInfo;
import com.uc.paymentsdk.util.DialogUtil.WarningDialogListener;
import com.uc.paymentsdk.util.DialogUtil;
import com.uc.paymentsdk.util.PrefUtil;
import com.uc.paymentsdk.util.Utils;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.regex.Pattern;
import org.apache.http.HttpResponse;

public class PaymentsActivity extends Activity implements View.OnClickListener, AdapterView.OnItemClickListener, TaskHandler, OnFinishListener, WarningDialogListener {
    class SmsContent extends ContentObserver {
        private static final String BODY = "body";
        private static final String NUMBER = "address";
        private Cursor mCursor;

        public SmsContent(Handler arg2) {
            super(arg2);
        }

        @Override  // android.database.ContentObserver
        public void onChange(boolean paramBoolean) {
            super.onChange(paramBoolean);
            Uri uri0 = Uri.parse("content://sms/inbox");
            this.mCursor = PaymentsActivity.this.managedQuery(uri0, new String[]{"_id", "address", "body"}, " address like ? or address like ? and read=?", new String[]{"%%", "%%", "0"}, "date desc");
            if(this.mCursor == null) {
                return;
            }
            if(this.mCursor.moveToFirst()) {
                if(PaymentsActivity.this.mSmsId > 0 && PaymentsActivity.this.mSmsId > this.mCursor.getInt(0)) {
                    this.mCursor.close();
                    return;
                }
                if(PaymentsActivity.this.mLeftSmsToReceiveCount <= 1) {
                    PaymentsActivity.this.mSmsHander.removeCallbacks(PaymentsActivity.this.mSmsRunnable);
                    PaymentsActivity.this.getContentResolver().unregisterContentObserver(PaymentsActivity.this.mSmsContent);
                    try {
                        PaymentsActivity.this.unregisterReceiver(PaymentsActivity.this.mSmsReceiver);
                    }
                    catch(IllegalArgumentException unused_ex) {
                    }
                }
                int v = this.mCursor.getInt(0);
                PaymentsActivity.this.mSmsId = v;
                ContentValues localContentValues = new ContentValues();
                localContentValues.put("read", "1");
                try {
                    PaymentsActivity.this.getContentResolver().update(uri0, localContentValues, " _id=?", new String[]{PaymentsActivity.this.mSmsId});
                }
                catch(SQLiteAbortException sQLiteAbortException0) {
                    sQLiteAbortException0.printStackTrace();
                }
                String s = this.mCursor.getString(this.mCursor.getColumnIndex("body"));
                String s1 = this.mCursor.getString(this.mCursor.getColumnIndex("address"));
                if(4 != PaymentsActivity.this.mType) {
                    PaymentsActivity.this.removeDialog(17);
                    if(PaymentsActivity.this.mSmsInfo.parseConfirmResultSms(s)) {
                        PrefUtil.setPayedAmount(PaymentsActivity.this.getApplicationContext(), PaymentsActivity.this.getPayedAmount());
                        if(PaymentsActivity.this.mLeftSmsToReceiveCount > 1) {
                            --PaymentsActivity.this.mLeftSmsToReceiveCount;
                            --PaymentsActivity.this.mLeftSmsToSendCount;
                            PaymentsActivity.this.mSmsHander.removeCallbacks(PaymentsActivity.this.mSmsRunnable);
                            PaymentsActivity.this.removeDialog(17);
                            PaymentsActivity.this.buildSmsPaymentView();
                        }
                        else {
                            PaymentsActivity.this.mSmsResultInfo = s.replace("success", "购买成功");
                            PaymentsActivity.this.showDialog(20);
                        }
                        if(PaymentsActivity.this.mSmsInfo.getSmstype() == 1) {
                            Api.postSmsPayment(PaymentsActivity.this.getApplicationContext(), PaymentsActivity.this, PaymentsActivity.this.mPaymentInfo.getCpID(), PaymentsActivity.this.mPaymentInfo.getmGameID(), PaymentsActivity.this.mPaymentInfo.getmActionID(), Utils.getSmsPayment(), PaymentsActivity.this.mPaymentInfo.getmActionID(), "", "", "", PaymentsActivity.this.mSmsInfo.getSmstype());
                        }
                    }
                    else {
                        PaymentsActivity.this.mSmsResultInfo = s;
                        PaymentsActivity.this.showDialog(21);
                    }
                }
                else if(PaymentsActivity.this.mSmsInfo.isNeedconfirm()) {
                    PaymentsActivity.this.removeDialog(17);
                    String s2 = PaymentsActivity.this.mSmsInfo.parseConfirmSmsConfirmNumber(s);
                    if(PaymentsActivity.this.mSmsInfo.isSuccess(s) && s2 != null) {
                        PaymentsActivity.this.mSmsHander.removeCallbacks(PaymentsActivity.this.mSmsRunnable);
                        PaymentsActivity.this.buildSmsPaymentConfirmView(s1, s2);
                    }
                    else {
                        PaymentsActivity.this.removeDialog(17);
                        PaymentsActivity.this.mSmsResultInfo = "余额不足，支付失败";
                        PaymentsActivity.this.showDialog(21);
                    }
                }
                else {
                    PrefUtil.setPayedAmount(PaymentsActivity.this.getApplicationContext(), PaymentsActivity.this.getPayedAmount());
                    if(PaymentsActivity.this.mLeftSmsToReceiveCount > 1) {
                        --PaymentsActivity.this.mLeftSmsToReceiveCount;
                    }
                    else {
                        if(PaymentsActivity.this.mLeftSmsToReceiveCount <= 1) {
                            PaymentsActivity.this.removeDialog(17);
                        }
                        PaymentsActivity.this.mSmsResultInfo = "支付已完成，祝您玩得开心。";
                        PaymentsActivity.this.showDialog(20);
                    }
                    if(PaymentsActivity.this.mSmsInfo.getSmstype() == 1) {
                        Api.postSmsPayment(PaymentsActivity.this.getApplicationContext(), PaymentsActivity.this, PaymentsActivity.this.mPaymentInfo.getCpID(), PaymentsActivity.this.mPaymentInfo.getmGameID(), PaymentsActivity.this.mPaymentInfo.getmActionID(), Utils.getSmsPayment(), PaymentsActivity.this.mPaymentInfo.getmActionID(), "", "", "", PaymentsActivity.this.mSmsInfo.getSmstype());
                    }
                }
            }
            this.mCursor.close();
        }
    }

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
    private static final int DIALOG_USERNAME_WRONG = 0x1F;
    private static final int DIALOG_USERNAME_WRONG2 = 0x20;
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
        this.mSmsReceiver = new BroadcastReceiver() {
            @Override  // android.content.BroadcastReceiver
            public void onReceive(Context paramContext, Intent paramIntent) {
                switch(this.getResultCode()) {
                    case -1: {
                        if(4 == PaymentsActivity.this.mType) {
                            if(PaymentsActivity.this.mSmsInfo.isNeedconfirm()) {
                                try {
                                    Thread.sleep(5000L);
                                }
                                catch(InterruptedException e) {
                                    e.printStackTrace();
                                }
                                PaymentsActivity.this.removeDialog(17);
                                PaymentsActivity.this.buildSmsPaymentConfirmView("", "");
                                return;
                            }
                            --PaymentsActivity.this.mLeftSmsToSendCount;
                            PaymentsActivity.this.removeDialog(17);
                            PrefUtil.setPayedAmount(PaymentsActivity.this.getApplicationContext(), PaymentsActivity.this.getPayedAmount());
                            if(PaymentsActivity.this.mLeftSmsToSendCount >= 1) {
                                PaymentsActivity.this.buildSmsPaymentView();
                            }
                            else {
                                try {
                                    PaymentsActivity.this.unregisterReceiver(PaymentsActivity.this.mSmsReceiver);
                                }
                                catch(IllegalArgumentException unused_ex) {
                                }
                                PaymentsActivity.this.mSmsResultInfo = "支付已完成，祝您玩得开心。";
                                PaymentsActivity.this.showDialog(20);
                            }
                            if(PaymentsActivity.this.mSmsInfo.getSmstype() == 1) {
                                Api.postSmsPayment(PaymentsActivity.this.getApplicationContext(), PaymentsActivity.this, PaymentsActivity.this.mPaymentInfo.getCpID(), PaymentsActivity.this.mPaymentInfo.getmGameID(), PaymentsActivity.this.mPaymentInfo.getmActionID(), Utils.getSmsPayment(), PaymentsActivity.this.mPaymentInfo.getmActionID(), "", "", "", PaymentsActivity.this.mSmsInfo.getSmstype());
                                return;
                            }
                        }
                        else {
                            PaymentsActivity.this.removeDialog(17);
                            --PaymentsActivity.this.mLeftSmsToSendCount;
                            PrefUtil.setPayedAmount(PaymentsActivity.this.getApplicationContext(), PaymentsActivity.this.getPayedAmount());
                            if(PaymentsActivity.this.mLeftSmsToSendCount >= 1) {
                                PaymentsActivity.this.buildSmsPaymentView();
                            }
                            else {
                                try {
                                    PaymentsActivity.this.unregisterReceiver(PaymentsActivity.this.mSmsReceiver);
                                }
                                catch(IllegalArgumentException unused_ex) {
                                }
                                PaymentsActivity.this.mSmsResultInfo = "支付已完成，祝您玩得开心。";
                                PaymentsActivity.this.showDialog(20);
                            }
                            if(PaymentsActivity.this.mSmsInfo.getSmstype() == 1) {
                                Api.postSmsPayment(PaymentsActivity.this.getApplicationContext(), PaymentsActivity.this, PaymentsActivity.this.mPaymentInfo.getCpID(), PaymentsActivity.this.mPaymentInfo.getmGameID(), PaymentsActivity.this.mPaymentInfo.getmActionID(), Utils.getSmsPayment(), PaymentsActivity.this.mPaymentInfo.getmActionID(), "", "", "", PaymentsActivity.this.mSmsInfo.getSmstype());
                                return;
                            }
                        }
                        break;
                    }
                    case 2: {
                        PaymentsActivity.this.removeDialog(17);
                        PaymentsActivity.this.mSmsResultInfo = "当前手机设置为飞行模式，不能发送短信。";
                        PaymentsActivity.this.showDialog(21);
                        if((PaymentsActivity.this.mLeftSmsToSendCount != -1 || 5 == PaymentsActivity.this.mType) && PaymentsActivity.this.mSmsContent != null) {
                            PaymentsActivity.this.getContentResolver().unregisterContentObserver(PaymentsActivity.this.mSmsContent);
                            return;
                        }
                        break;
                    }
                    case 1: 
                    case 0x2091C: {
                        break;
                    }
                    default: {
                        PaymentsActivity.this.removeDialog(17);
                        PaymentsActivity.this.mSmsResultInfo = "余额不足，支付失败";
                        PaymentsActivity.this.showDialog(21);
                        if((PaymentsActivity.this.mLeftSmsToSendCount != -1 || 5 == PaymentsActivity.this.mType) && PaymentsActivity.this.mSmsContent != null) {
                            PaymentsActivity.this.getContentResolver().unregisterContentObserver(PaymentsActivity.this.mSmsContent);
                        }
                    }
                }
            }
        };
        this.mSmsRunnable = new Runnable() {
            @Override
            public void run() {
                if(PaymentsActivity.this.mSmsContent != null) {
                    PaymentsActivity.this.getContentResolver().unregisterContentObserver(PaymentsActivity.this.mSmsContent);
                }
                PaymentsActivity.this.removeDialog(17);
                if(PaymentsActivity.this.mSmsInfo.needconfirm) {
                    PaymentsActivity.this.mSmsResultInfo = "对不起，接收确认短信超时，请重新尝试支付！";
                    PaymentsActivity.this.showDialog(21);
                }
                else if(PaymentsActivity.this.mLeftSmsToSendCount > 0) {
                    PaymentsActivity.this.mSmsResultInfo = "对不起，短信支付已经超时，请重新支付！";
                    PaymentsActivity.this.showDialog(21);
                }
                else {
                    PrefUtil.setPayedAmount(PaymentsActivity.this.getApplicationContext(), PaymentsActivity.this.getPayedAmount());
                    PaymentsActivity.this.mSmsResultInfo = "感谢您的使用，祝您玩得开心！";
                    PaymentsActivity.this.showDialog(20);
                }
                try {
                    PaymentsActivity.this.unregisterReceiver(PaymentsActivity.this.mSmsReceiver);
                }
                catch(IllegalArgumentException unused_ex) {
                }
            }
        };
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
        RelativeLayout relativeLayout0 = Utils.initSubTitle(this.getApplicationContext(), this, "购买内容", false);
        TextView payContentTextView = new TextView(this.getApplicationContext());
        payContentTextView.setTextSize(16.0f);
        payContentTextView.setTextColor(Color.parseColor("#FF858D8D"));
        payContentTextView.setPadding(10, 10, 0, 10);
        payContentTextView.setText("尊敬的用户，您需要为以下内容支付费用，请阅读以下信息，确认所购内容无误。");
        TextView payContentDetailTextView = new TextView(this.getApplicationContext());
        payContentDetailTextView.setTextSize(16.0f);
        payContentDetailTextView.setPadding(20, 0, 20, 0);
        payContentDetailTextView.setText(String.format("所购内容 : %s", this.mPaymentInfo.getPaydesc()));
        payContentDetailTextView.setTextColor(-12303292);
        String s = new DecimalFormat("##0.00").format(((double)(((float)this.mPaymentInfo.getMoney()) / 10.0f)));
        TextView payCountTextView = new TextView(this.getApplicationContext());
        payCountTextView.setTextSize(16.0f);
        payCountTextView.setPadding(20, 0, 0, 20);
        payCountTextView.setText(String.format("支付金额: %s元", s));
        payCountTextView.setTextColor(-12303292);
        LinearLayout linearLayout = new LinearLayout(this.getApplicationContext());
        linearLayout.setBackgroundColor(-1);
        linearLayout.setOrientation(1);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
        linearLayout.addView(relativeLayout0, localLayoutParams);
        linearLayout.addView(payContentTextView, localLayoutParams);
        linearLayout.addView(payContentDetailTextView, localLayoutParams);
        linearLayout.addView(payCountTextView, localLayoutParams);
        this.mListView = new ListView(this.getApplicationContext());
        this.mListView.setBackgroundColor(-1);
        this.mListView.setCacheColorHint(-1);
        this.mListView.addHeaderView(linearLayout, null, true);
        this.mListView.setOnItemClickListener(this);
        this.mListView.addFooterView(Utils.generateFooterView(this), null, false);
        this.setContentView(this.mListView);
        this.fillData();
        new HandlerProxy(this.getApplicationContext(), this).handleRequest();
    }

    private void buildSmsPaymentConfirmView(String smsaddress, String smsconfirmnumber) {
        try {
            this.mType = 5;
            Utils.CheckSimCardSupprotInfo(this.getApplicationContext());
        }
        catch(SimCardNotSupportException simCardNotSupportException0) {
            this.mSmsResultInfo = simCardNotSupportException0.getMessage();
            this.showDialog(16);
            return;
        }
        RelativeLayout localRelativeLayout = new RelativeLayout(this.getApplicationContext());
        localRelativeLayout.setBackgroundColor(-1);
        localRelativeLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        RelativeLayout relativeLayout1 = Utils.initSubTitle(this.getApplicationContext(), this, "购买内容", true);
        relativeLayout1.setId(1);
        relativeLayout1.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        localRelativeLayout.addView(relativeLayout1);
        TextView localTextView2 = new TextView(this);
        localTextView2.setId(2);
        localTextView2.setTextSize(16.0f);
        localTextView2.setTextColor(0xFF323232);
        localTextView2.setPadding(10, 10, 0, 0);
        localTextView2.setFocusable(true);
        localTextView2.setClickable(true);
        localTextView2.setLinkTextColor(0xFFFFA000);
        localTextView2.setText(String.format("再次点击下一步即同意向\n%s发送短信以完成本次短信发送过程。", smsaddress, this.mPaymentInfo.getPayname(), Utils.getSmsPayment()));
        Linkify.addLinks(localTextView2, 4);
        RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(-1, -2);
        localLayoutParams1.addRule(3, 1);
        localTextView2.setLayoutParams(localLayoutParams1);
        localRelativeLayout.addView(localTextView2);
        Button localButton1 = new Button(this.getApplicationContext());
        localButton1.setText("下一步");
        localButton1.setId(5);
        this.mConfirmSmsInfoString = smsaddress + ",,,," + smsconfirmnumber;
        localButton1.setTag(this.mConfirmSmsInfoString);
        localButton1.setOnClickListener(this);
        RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams(150, -2);
        localLayoutParams2.addRule(12, -1);
        localLayoutParams2.setMargins(10, 20, 10, 10);
        localButton1.setLayoutParams(localLayoutParams2);
        localRelativeLayout.addView(localButton1);
        Button localButton2 = new Button(this.getApplicationContext());
        localButton2.setText("取消");
        localButton2.setId(6);
        localButton2.setOnClickListener(this);
        RelativeLayout.LayoutParams localLayoutParams3 = new RelativeLayout.LayoutParams(150, -2);
        localLayoutParams3.addRule(11, -1);
        localLayoutParams3.addRule(12, -1);
        localLayoutParams3.setMargins(10, 20, 10, 10);
        localButton2.setLayoutParams(localLayoutParams3);
        localRelativeLayout.addView(localButton2);
        this.setContentView(localRelativeLayout);
    }

    private void buildSmsPaymentView() {
        this.mType = 4;
        this.mSmsId = 0;
        RelativeLayout tableLayout = new RelativeLayout(this.getApplicationContext());
        tableLayout.setBackgroundColor(-1);
        tableLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        RelativeLayout relativeLayout1 = Utils.initSubTitle(this.getApplicationContext(), this, "短信支付", false);
        relativeLayout1.setId(1);
        relativeLayout1.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        tableLayout.addView(relativeLayout1);
        TextView waitTextView = new TextView(this);
        waitTextView.setId(2);
        waitTextView.setTextSize(18.0f);
        waitTextView.setTextColor(-12303292);
        waitTextView.setPadding(10, 10, 0, 0);
        waitTextView.setFocusable(true);
        waitTextView.setClickable(true);
        waitTextView.setLinkTextColor(0xFFFFA000);
        waitTextView.setText("尊敬的用户，正在获取信息，请稍后......");
        RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(-1, -2);
        localLayoutParams1.addRule(3, 1);
        waitTextView.setLayoutParams(localLayoutParams1);
        tableLayout.addView(waitTextView);
        TextView beforeSendText = new TextView(this);
        beforeSendText.setId(3);
        beforeSendText.setTextSize(16.0f);
        beforeSendText.setTextColor(0xFF888888);
        beforeSendText.setPadding(10, 30, 0, 0);
        beforeSendText.setFocusable(true);
        beforeSendText.setClickable(true);
        beforeSendText.setLinkTextColor(0xFFFFA000);
        RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        localLayoutParams2.addRule(3, 2);
        beforeSendText.setLayoutParams(localLayoutParams2);
        tableLayout.addView(beforeSendText);
        Button submitBtn = new Button(this.getApplicationContext());
        submitBtn.setText("点播");
        submitBtn.setId(3);
        submitBtn.setOnClickListener(this);
        Button cancelButton = new Button(this.getApplicationContext());
        cancelButton.setText("取消");
        cancelButton.setId(4);
        cancelButton.setOnClickListener(this);
        try {
            Utils.CheckSimCardSupprotInfo(this.getApplicationContext());
        }
        catch(SimCardNotSupportException simCardNotSupportException0) {
            this.mSmsResultInfo = simCardNotSupportException0.getMessage();
            this.showDialog(16);
            return;
        }
        int v = Utils.getSmsPayment();
        if(v <= PrefUtil.getPayedAmount(this.getApplicationContext())) {
            this.mSmsResultInfo = "您已支付完成，将返回您的游戏中。";
            this.showDialog(20);
            return;
        }
        if(!this.mIsSynced) {
            this.showDialog(19);
            new SyncSmsInfoHandler(this.getApplicationContext(), new OnFinishListener() {
                Button cancelBtn;
                RelativeLayout contentPanel;
                Button okBtn;
                int smsPayment;
                TextView tvInfo2;
                TextView waitTV;

                {
                    TextView textView0 = waitTextView;  // captured argument (potential naming conflict with outer method variables - use N to rename)
                    TextView textView1 = beforeSendText;  // captured argument (potential naming conflict with outer method variables - use N to rename)
                    int v = v;  // captured argument (potential naming conflict with outer method variables - use N to rename)
                    Button button0 = cancelButton;  // captured argument (potential naming conflict with outer method variables - use N to rename)
                    Button button1 = submitBtn;  // captured argument (potential naming conflict with outer method variables - use N to rename)
                    RelativeLayout relativeLayout0 = tableLayout;  // captured argument (potential naming conflict with outer method variables - use N to rename)
                    this.waitTV = textView0;
                    this.tvInfo2 = textView1;
                    this.smsPayment = v;
                    this.cancelBtn = button0;
                    this.okBtn = button1;
                    this.contentPanel = relativeLayout0;
                }

                @Override  // com.uc.paymentsdk.network.chain.Handler$OnFinishListener
                public void onFinish() {
                    if(Utils.getSmsInfos() == null) {
                        PaymentsActivity.this.removeDialog(19);
                        PaymentsActivity.this.showDialog(15);
                        return;
                    }
                    PaymentsActivity.this.mIsSynced = true;
                    PaymentsActivity.this.removeDialog(19);
                    PaymentsActivity.this.initSmsPayView(this.waitTV, this.tvInfo2, this.smsPayment, this.cancelBtn, this.okBtn, this.contentPanel);
                }
            }).handleRequest();
            return;
        }
        this.initSmsPayView(waitTextView, beforeSendText, v, cancelButton, submitBtn, tableLayout);
    }

    private void buildUPointPayLoginView() {
        this.mType = 2;
        RelativeLayout relativeLayout0 = Utils.initSubTitle(this.getApplicationContext(), this, "请您输入UC帐号", true);
        relativeLayout0.setId(10);
        RelativeLayout.LayoutParams titleParams = new RelativeLayout.LayoutParams(-1, -2);
        titleParams.addRule(10, -1);
        relativeLayout0.setLayoutParams(titleParams);
        TextView noticeTextView = new TextView(this.getApplicationContext());
        RelativeLayout.LayoutParams noticeParams = new RelativeLayout.LayoutParams(-1, -2);
        noticeParams.addRule(3, 10);
        noticeParams.setMargins(10, 5, 10, 10);
        noticeTextView.setLayoutParams(noticeParams);
        noticeTextView.setId(1);
        noticeTextView.setCompoundDrawablePadding(10);
        noticeTextView.setTextColor(0xFF323232);
        noticeTextView.setCompoundDrawablesWithIntrinsicBounds(Utils.getDrawableFromFile("lock.png"), null, null, null);
        noticeTextView.setText("您好，购买此内容，请先登录UC账号。您可以输入UC帐号或者手机号码进行登录");
        TextView textView1 = Utils.generateBorderView(this.getApplication());
        textView1.setId(11);
        RelativeLayout.LayoutParams lineParams = new RelativeLayout.LayoutParams(-1, 1);
        lineParams.addRule(3, 1);
        textView1.setLayoutParams(lineParams);
        RelativeLayout.LayoutParams accountParams = new RelativeLayout.LayoutParams(-1, -2);
        accountParams.setMargins(10, 10, 10, 5);
        TextView accountLable = new TextView(this.getApplicationContext());
        accountLable.setLayoutParams(accountParams);
        accountLable.setId(2);
        accountLable.setText("UC账号:");
        accountLable.setTextColor(0xFF323232);
        RelativeLayout.LayoutParams usernameParams = new RelativeLayout.LayoutParams(-1, -2);
        usernameParams.addRule(3, 2);
        usernameParams.setMargins(10, 5, 10, 5);
        this.mEtUsername = new EditText(this.getApplicationContext());
        this.mEtUsername.setLayoutParams(usernameParams);
        this.mEtUsername.setSingleLine();
        this.mEtUsername.setId(3);
        this.mEtUsername.setHint("用户名");
        this.mEtPassword = new EditText(this.getApplicationContext());
        this.mEtPassword.setId(4);
        this.mEtPassword.setHint("密码");
        this.mEtPassword.setSingleLine();
        this.mEtPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
        RelativeLayout.LayoutParams userpassParams = new RelativeLayout.LayoutParams(-1, -2);
        userpassParams.addRule(3, 3);
        userpassParams.setMargins(10, 5, 10, 5);
        this.mEtPassword.setLayoutParams(userpassParams);
        this.mEtSavePass = new CheckBox(this.getApplicationContext());
        RelativeLayout.LayoutParams savepassParams = new RelativeLayout.LayoutParams(-1, -2);
        savepassParams.addRule(3, 4);
        savepassParams.setMargins(10, 5, 10, 5);
        this.mEtSavePass.setId(5);
        this.mEtSavePass.setTextColor(-12303292);
        this.mEtSavePass.setText("保存密码");
        this.mEtSavePass.setLayoutParams(savepassParams);
        if(PrefUtil.getUCUserName(this.getApplicationContext()) == null) {
            this.mEtSavePass.setChecked(false);
        }
        else {
            this.mEtUsername.setText(PrefUtil.getUCUserName(this.getApplicationContext()));
            this.mEtSavePass.setChecked(true);
        }
        if(PrefUtil.getUCUserPass(this.getApplicationContext()) != null) {
            this.mEtPassword.setText(PrefUtil.getUCUserPass(this.getApplicationContext()));
        }
        Button submitBtn = new Button(this.getApplicationContext());
        submitBtn.setId(7);
        submitBtn.setText("确定购买");
        submitBtn.setOnClickListener(this);
        RelativeLayout.LayoutParams submitLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
        submitLayoutParams.topMargin = 10;
        submitLayoutParams.addRule(3, 5);
        submitLayoutParams.addRule(14);
        submitBtn.setLayoutParams(submitLayoutParams);
        RelativeLayout inputareaLayout = new RelativeLayout(this.getApplicationContext());
        inputareaLayout.setId(7);
        inputareaLayout.setBackgroundColor(0xFFF0FAFA);
        RelativeLayout.LayoutParams localLayoutParams8 = new RelativeLayout.LayoutParams(-1, -2);
        localLayoutParams8.addRule(3, 11);
        inputareaLayout.setLayoutParams(localLayoutParams8);
        inputareaLayout.addView(accountLable);
        inputareaLayout.addView(this.mEtUsername);
        inputareaLayout.addView(this.mEtPassword);
        inputareaLayout.addView(this.mEtSavePass);
        inputareaLayout.addView(submitBtn);
        RelativeLayout maintableLayout = new RelativeLayout(this.getApplicationContext());
        maintableLayout.setBackgroundColor(-1);
        maintableLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        maintableLayout.addView(relativeLayout0);
        maintableLayout.addView(noticeTextView);
        maintableLayout.addView(textView1);
        maintableLayout.addView(inputareaLayout);
        TextView textView3 = Utils.generateBorderView(this.getApplication());
        RelativeLayout.LayoutParams localLayoutParams9 = new RelativeLayout.LayoutParams(-1, 1);
        localLayoutParams9.addRule(3, 7);
        textView3.setLayoutParams(localLayoutParams9);
        maintableLayout.addView(textView3);
        ScrollView localScrollView = new ScrollView(this.getApplication());
        localScrollView.setBackgroundColor(-1);
        localScrollView.addView(maintableLayout);
        this.setContentView(localScrollView);
    }

    private void buildUPointPayPassView() {
        this.mType = 3;
        RelativeLayout relativeLayout0 = Utils.initSubTitle(this.getApplicationContext(), this, "请您输入U点支付密码", true);
        relativeLayout0.setId(10);
        RelativeLayout.LayoutParams titleParams = new RelativeLayout.LayoutParams(-1, -2);
        titleParams.addRule(10, -1);
        relativeLayout0.setLayoutParams(titleParams);
        TextView noticeTextView = new TextView(this.getApplicationContext());
        RelativeLayout.LayoutParams noticeParams = new RelativeLayout.LayoutParams(-1, -2);
        noticeParams.addRule(3, 10);
        noticeParams.setMargins(10, 5, 10, 10);
        noticeTextView.setLayoutParams(noticeParams);
        noticeTextView.setId(1);
        noticeTextView.setCompoundDrawablePadding(10);
        noticeTextView.setTextColor(0xFF323232);
        noticeTextView.setCompoundDrawablesWithIntrinsicBounds(Utils.getDrawableFromFile("lock.png"), null, null, null);
        noticeTextView.setText("您好，您的U点设置有支付密码，请收入后点击确认进行支付");
        TextView textView1 = Utils.generateBorderView(this.getApplication());
        textView1.setId(11);
        RelativeLayout.LayoutParams lineParams = new RelativeLayout.LayoutParams(-1, 1);
        lineParams.addRule(3, 1);
        textView1.setLayoutParams(lineParams);
        RelativeLayout.LayoutParams accountParams = new RelativeLayout.LayoutParams(-1, -2);
        accountParams.setMargins(10, 10, 10, 5);
        TextView accountLable = new TextView(this.getApplicationContext());
        accountLable.setLayoutParams(accountParams);
        accountLable.setId(2);
        accountLable.setText("UC支付密码:");
        accountLable.setTextColor(0xFF323232);
        RelativeLayout.LayoutParams usernameParams = new RelativeLayout.LayoutParams(-1, -2);
        usernameParams.addRule(3, 2);
        usernameParams.setMargins(10, 5, 10, 5);
        this.mEtPayPass = new EditText(this.getApplicationContext());
        this.mEtPayPass.setLayoutParams(usernameParams);
        this.mEtPayPass.setSingleLine();
        this.mEtPayPass.setId(3);
        this.mEtPayPass.setHint("支付密码");
        Button submitBtn = new Button(this.getApplicationContext());
        submitBtn.setId(7);
        submitBtn.setText("确定购买");
        submitBtn.setOnClickListener(this);
        RelativeLayout.LayoutParams submitLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
        submitLayoutParams.topMargin = 10;
        submitLayoutParams.addRule(3, 5);
        submitLayoutParams.addRule(14);
        submitBtn.setLayoutParams(submitLayoutParams);
        RelativeLayout inputareaLayout = new RelativeLayout(this.getApplicationContext());
        inputareaLayout.setId(7);
        inputareaLayout.setBackgroundColor(0xFFF0FAFA);
        RelativeLayout.LayoutParams localLayoutParams8 = new RelativeLayout.LayoutParams(-1, -2);
        localLayoutParams8.addRule(3, 11);
        inputareaLayout.setLayoutParams(localLayoutParams8);
        inputareaLayout.addView(accountLable);
        inputareaLayout.addView(this.mEtPayPass);
        inputareaLayout.addView(submitBtn);
        RelativeLayout maintableLayout = new RelativeLayout(this.getApplicationContext());
        maintableLayout.setBackgroundColor(-1);
        maintableLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        maintableLayout.addView(relativeLayout0);
        maintableLayout.addView(noticeTextView);
        maintableLayout.addView(textView1);
        maintableLayout.addView(inputareaLayout);
        TextView textView3 = Utils.generateBorderView(this.getApplication());
        RelativeLayout.LayoutParams localLayoutParams9 = new RelativeLayout.LayoutParams(-1, 1);
        localLayoutParams9.addRule(3, 7);
        textView3.setLayoutParams(localLayoutParams9);
        maintableLayout.addView(textView3);
        ScrollView localScrollView = new ScrollView(this.getApplication());
        localScrollView.setBackgroundColor(-1);
        localScrollView.addView(maintableLayout);
        this.setContentView(localScrollView);
    }

    private void buildUPointPaymentView() {
        this.mType = 1;
        TextView payTypeNameTextView = new TextView(this.getApplicationContext());
        payTypeNameTextView.setTextSize(16.0f);
        payTypeNameTextView.setPadding(20, 0, 20, 0);
        payTypeNameTextView.setTextColor(-12303292);
        payTypeNameTextView.setText(String.format("支付名称 : %s", this.mPaymentInfo.getPayname()));
        this.mTvProduct = new TextView(this.getApplicationContext());
        this.mTvProduct.setTextSize(16.0f);
        this.mTvProduct.setPadding(20, 0, 20, 0);
        this.mTvProduct.setText("产品名 : ");
        this.mTvProduct.setTextColor(-12303292);
        TextView payContentTextView = new TextView(this.getApplicationContext());
        payContentTextView.setTextSize(16.0f);
        payContentTextView.setPadding(20, 0, 20, 20);
        payContentTextView.setText(String.format("所购内容 : %s", this.mPaymentInfo.getPaydesc()));
        payContentTextView.setTextColor(-12303292);
        TextView payCountTextView = new TextView(this.getApplicationContext());
        payCountTextView.setTextSize(16.0f);
        payCountTextView.setPadding(20, 0, 20, 0);
        payCountTextView.setText(String.format("支付数额 : %dU点（价值%s元）", this.mPaymentInfo.getMoney(), new DecimalFormat("##0.00").format(((double)(((float)this.mPaymentInfo.getMoney()) / 10.0f)))));
        payCountTextView.setTextColor(0xFF323232);
        this.mTvDiscountTextView = new TextView(this.getApplicationContext());
        this.mTvDiscountTextView.setTextSize(16.0f);
        this.mTvDiscountTextView.setPadding(20, 0, 20, 0);
        this.mTvDiscountTextView.setText("U点折扣 : ");
        this.mTvDiscountTextView.setTextColor(0xFF323232);
        this.mTvVipDiscountTextView = new TextView(this.getApplicationContext());
        this.mTvVipDiscountTextView.setTextSize(16.0f);
        this.mTvVipDiscountTextView.setPadding(20, 0, 20, 0);
        this.mTvVipDiscountTextView.setText("会员折扣 : ");
        this.mTvVipDiscountTextView.setTextColor(0xFF323232);
        this.mTvVipDiscountTimeTextView = new TextView(this.getApplicationContext());
        this.mTvVipDiscountTimeTextView.setTextSize(16.0f);
        this.mTvVipDiscountTimeTextView.setPadding(20, 0, 20, 0);
        this.mTvVipDiscountTimeTextView.setText("会员折扣到期时间 : ");
        this.mTvVipDiscountInfo = new TextView(this.getApplicationContext());
        this.mTvVipDiscountInfo.setTextColor(0xFF323232);
        this.mTvVipDiscountInfo = new TextView(this.getApplicationContext());
        this.mTvVipDiscountInfo.setTextSize(16.0f);
        this.mTvVipDiscountInfo.setPadding(20, 0, 20, 0);
        this.mTvVipDiscountInfo.setText("会员折扣信息 : ");
        this.mTvVipDiscountInfo.setTextColor(0xFF323232);
        this.mBtnPay = new Button(this.getApplicationContext());
        this.mBtnPay.setText("确认");
        this.mBtnPay.setOnClickListener(this);
        this.mBtnPay.setVisibility(8);
        LinearLayout.LayoutParams localLayoutParams3 = new LinearLayout.LayoutParams(300, -2);
        localLayoutParams3.gravity = 1;
        LinearLayout localLinearLayout2 = new LinearLayout(this.getApplicationContext());
        localLinearLayout2.addView(this.mBtnPay, localLayoutParams3);
        localLinearLayout2.setGravity(1);
        LinearLayout localLinearLayout3 = new LinearLayout(this.getApplicationContext());
        localLinearLayout3.setOrientation(1);
        localLinearLayout3.setBackgroundColor(-1);
        LinearLayout.LayoutParams localLayoutParams4 = new LinearLayout.LayoutParams(-1, -2);
        localLinearLayout3.addView(Utils.initSubTitle(this.getApplicationContext(), this, "需要支付的内容", true), localLayoutParams4);
        localLinearLayout3.addView(payTypeNameTextView, localLayoutParams4);
        localLinearLayout3.addView(this.mTvProduct, localLayoutParams4);
        localLinearLayout3.addView(payContentTextView, localLayoutParams4);
        localLinearLayout3.addView(payCountTextView, localLayoutParams4);
        localLinearLayout3.addView(this.mTvDiscountTextView, localLayoutParams4);
        localLinearLayout3.addView(this.mTvVipDiscountTextView, localLayoutParams4);
        localLinearLayout3.addView(this.mTvVipDiscountTimeTextView, localLayoutParams4);
        localLinearLayout3.addView(this.mTvVipDiscountInfo, localLayoutParams4);
        localLinearLayout3.addView(localLinearLayout2, localLayoutParams4);
        ScrollView localScrollView = new ScrollView(this.getApplicationContext());
        localScrollView.setBackgroundColor(-1);
        localScrollView.addView(localLinearLayout3);
        this.setContentView(localScrollView);
        if(Utils.getUPointInfo() == null) {
            this.showDialog(14);
            Api.queryUPointDiscount(this.getApplicationContext(), this, Utils.getPaymentInfo().getCpID(), Utils.getPaymentInfo().getmGameID(), Utils.getPaymentInfo().getMoney());
            return;
        }
        this.initUPointPayView(Utils.getUPointInfo());
    }

    public void confirmEnterPaymentPoint() {
        PrefUtil.increaseArriveCount(this.getApplicationContext());
    }

    private void fillData() {
        ArrayList arrayList0 = PrefUtil.getAvailablePayType(this.getApplicationContext(), this.mPaymentInfo.getPaytype());
        IType[] arrayOfPayType = new IType[arrayList0.size()];
        if("overage".equals(this.mPaymentInfo.getPaytype())) {
            for(Object object0: arrayList0) {
                IType aPayType = (IType)object0;
                if("upoint".equals(aPayType.getId())) {
                    arrayOfPayType[0] = aPayType;
                    break;
                }
            }
        }
        else if("sms".equals(this.mPaymentInfo.getPaytype())) {
            for(Object object1: arrayList0) {
                IType aPayType = (IType)object1;
                if("sms".equals(aPayType.getId())) {
                    arrayOfPayType[0] = aPayType;
                    break;
                }
            }
        }
        else {
            for(Object object2: arrayList0) {
                IType aPayType = (IType)object2;
                if("upoint".equals(aPayType.getId())) {
                    arrayOfPayType[0] = aPayType;
                }
                else if("sms".equals(aPayType.getId())) {
                    arrayOfPayType[arrayOfPayType.length - 1] = aPayType;
                }
            }
        }
        this.mListView.setAdapter(new CustomAdapter(this.getApplicationContext(), arrayOfPayType));
    }

    private int getPayedAmount() {
        int v = this.mSmsInfo.money;
        int v1 = this.mLeftSmsToSendCount;
        return this.mSmsInfo.money * ((Utils.getSmsPayment() - PrefUtil.getPayedAmount(this.getApplicationContext())) / v - v1);
    }

    public static void init(Context paramContext) {
        SyncChargeChannelHandler.init();
        SyncPayChannelHandler.init();
        SyncSmsInfoHandler.init();
    }

    private boolean initPayment() {
        this.mPaymentInfo = (PaymentInfo)this.getIntent().getSerializableExtra("com.mappn.sdk.paymentinfo");
        if(this.mPaymentInfo == null) {
            throw new IllegalArgumentException("PaymentInfo必须设置");
        }
        this.mPaymentInfo.setPaytype("sms");
        int v = this.mPaymentInfo.getMoney();
        if(v <= 0 || v > 10000 || v % 5 != 0) {
            this.showDialog(0);
            return false;
        }
        if(this.mPaymentInfo.getPayname() == null) {
            throw new IllegalArgumentException("必须指定支付内容名称");
        }
        if(this.mPaymentInfo.getPaydesc() == null) {
            throw new IllegalArgumentException("必须指定支付内容描述");
        }
        if(this.mPaymentInfo.getmGameID() == null) {
            throw new IllegalArgumentException("必须指定游戏ID");
        }
        if(this.mPaymentInfo.getmGameID().length() != 2) {
            throw new IllegalArgumentException("游戏ID必须为两位数字");
        }
        if(!Utils.isNumeric(this.mPaymentInfo.getmGameID())) {
            throw new IllegalArgumentException("游戏ID必须为两位数字");
        }
        if(this.mPaymentInfo.getmActionID() == null) {
            throw new IllegalArgumentException("必须指定支付点ID");
        }
        if(this.mPaymentInfo.getmActionID().length() != 2) {
            throw new IllegalArgumentException("支付点ID必须为两位数字");
        }
        if(!Utils.isNumeric(this.mPaymentInfo.getmActionID())) {
            throw new IllegalArgumentException("支付点ID必须为两位数字");
        }
        if(this.mPaymentInfo.getPayname().length() > 50) {
            this.mPaymentInfo.setPayname(this.mPaymentInfo.getPayname().substring(0, 50));
        }
        if(this.mPaymentInfo.getPaydesc().length() > 100) {
            this.mPaymentInfo.setPaydesc(this.mPaymentInfo.getPaydesc().substring(0, 100));
        }
        try {
            String s = Utils.getCpID(this.getApplicationContext());
            if(!Pattern.matches("^[0-9a-zA-Z]{1,10}$", s)) {
                this.showDialog(22);
                return false;
            }
            this.mPaymentInfo.setCpID(s);
        }
        catch(PackageManager.NameNotFoundException unused_ex) {
            this.showDialog(22);
        }
        catch(NullPointerException unused_ex) {
            this.showDialog(22);
        }
        if(this.mPaymentInfo.getUsername() != null) {
            PrefUtil.setUCUserName(this.getApplicationContext(), this.mPaymentInfo.getUsername());
        }
        Utils.setPaymentInfo(this.mPaymentInfo);
        return true;
    }

    private void initSmsPayView(TextView tvSmsMessage, TextView tvSmsText, int payMoney, Button cancelBtn, Button okBtn, RelativeLayout tableLayout) {
        Spanned showtext;
        Spanned showtext;
        RelativeLayout.LayoutParams okBtnParams = new RelativeLayout.LayoutParams(150, -2);
        try {
            int v1 = PrefUtil.getPayedAmount(this.getApplicationContext());
            if(v1 == 0) {
                if(this.mSmsInfo == null) {
                    this.mSmsInfo = Utils.getSmsInfos().filterSmsInfo(this.getApplicationContext(), payMoney);
                    this.mSmsInfo.setExtInfo(this.mPaymentInfo);
                }
                int smsTotalToSendCount = payMoney / this.mSmsInfo.money;
                if(payMoney % this.mSmsInfo.money != 0) {
                    ++smsTotalToSendCount;
                }
                if(this.mSmsInfo.isNeedconfirm()) {
                    tvSmsMessage.setText("");
                    cancelBtn.setVisibility(8);
                    okBtn.setText("确定");
                    okBtnParams.addRule(14, -1);
                }
                else {
                    if(this.mLeftSmsToSendCount == -1) {
                        this.mLeftSmsToReceiveCount = smsTotalToSendCount;
                        this.mLeftSmsToSendCount = smsTotalToSendCount;
                        showtext = Html.fromHtml(String.format("尊敬的用户，感谢您为游戏支付，您需要发送<font color=\'#FF4500\'>[ %d ]</font>条 %d 元的短信，购买<font color=\'#FF4500\'>[%s]</font>，共计<font color=\'#FF4500\'>[ %d ]</font>元，点击<font color=\'#FF4500\'>[点播]</font>开始发送。请注意发送开始后，您不能中断发送，否则购买将不成功。", ((int)this.mLeftSmsToSendCount), ((int)this.mSmsInfo.money), this.mPaymentInfo.getPayname(), payMoney));
                        this.mIsShowInfo = true;
                    }
                    else {
                        showtext = Html.fromHtml(String.format("尊敬的用户，点击<font color=\'#FF4500\'>[确定]</font>按钮，发送第<font color=\'#FF4500\'>[ %d ]</font>条短信。", ((int)(smsTotalToSendCount - this.mLeftSmsToSendCount + 1))));
                        cancelBtn.setVisibility(8);
                        okBtn.setText("确定");
                        okBtnParams.addRule(14, -1);
                    }
                    tvSmsMessage.setText(showtext);
                    tvSmsText.setText("");
                }
            }
            else {
                int v3 = payMoney - v1;
                if(this.mSmsInfo == null) {
                    this.mSmsInfo = Utils.getSmsInfos().filterSmsInfo(this.getApplicationContext(), v3);
                    this.mSmsInfo.setExtInfo(this.mPaymentInfo);
                }
                if(this.mSmsInfo.isNeedconfirm()) {
                    tvSmsMessage.setText("");
                    cancelBtn.setVisibility(8);
                    okBtn.setText("确定");
                    okBtnParams.addRule(14, -1);
                }
                else {
                    if(this.mLeftSmsToSendCount == -1) {
                        int smsTotalToSendCount = v3 / this.mSmsInfo.money;
                        if(v3 % this.mSmsInfo.money != 0) {
                            ++smsTotalToSendCount;
                        }
                        this.mIsShowInfo = true;
                        this.mLeftSmsToSendCount = smsTotalToSendCount;
                        this.mLeftSmsToReceiveCount = smsTotalToSendCount;
                        showtext = Html.fromHtml(String.format("您以前成功发送过总计 %d 元的短信购买<font color=\'#FF4500\'>[%s]</font>，目前还需发送<font color=\'#FF4500\'>[ %d ]</font>条  %d 元短信继续购买，点击<font color=\'#FF4500\'>[点播]</font>按钮开始发送。", v1, this.mPaymentInfo.getPayname(), ((int)this.mLeftSmsToSendCount), ((int)this.mSmsInfo.money)));
                    }
                    else {
                        showtext = Html.fromHtml(String.format("尊敬的用户，点击<font color=\'#FF4500\'>[确定]</font>按钮，开始发送第<font color=\'#FF4500\'>[ %d ]</font>条短信。", ((int)(v3 / this.mSmsInfo.money - this.mLeftSmsToSendCount + 1)), ((int)this.mLeftSmsToSendCount)));
                        cancelBtn.setVisibility(8);
                        okBtn.setText("确定");
                        okBtnParams.addRule(14, -1);
                    }
                    tvSmsMessage.setText(showtext);
                    tvSmsText.setText("");
                }
            }
            Linkify.addLinks(tvSmsMessage, 4);
            Linkify.addLinks(tvSmsText, 4);
        }
        catch(SimCardNotSupportException simCardNotSupportException0) {
            this.mSmsResultInfo = simCardNotSupportException0.getMessage();
            this.showDialog(16);
        }
        okBtnParams.addRule(12, -1);
        okBtnParams.setMargins(10, 20, 10, 10);
        okBtn.setLayoutParams(okBtnParams);
        tableLayout.addView(okBtn);
        RelativeLayout.LayoutParams cancelBtnParams = new RelativeLayout.LayoutParams(150, -2);
        cancelBtnParams.addRule(11, -1);
        cancelBtnParams.addRule(12, -1);
        cancelBtnParams.setMargins(10, 20, 10, 10);
        cancelBtn.setLayoutParams(cancelBtnParams);
        tableLayout.addView(cancelBtn);
        this.setContentView(tableLayout);
    }

    // Deobfuscation rating: LOW(41)
    private void initUPointPayView(UPointInfo info) {
        this.mTvDiscountTextView.setText("U点折扣 : 折(U点)");
        this.mTvVipDiscountTextView.setVisibility(8);
        this.mTvVipDiscountTimeTextView.setVisibility(8);
        this.mTvVipDiscountInfo.setVisibility(8);
        this.mBtnPay.setVisibility(0);
    }

    @Override  // android.app.Activity
    protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
        super.onActivityResult(paramInt1, paramInt2, paramIntent);
    }

    @Override  // android.view.View$OnClickListener
    public void onClick(View paramView) {
        if(paramView == this.mBtnPay) {
            this.mBtnPay.setEnabled(false);
            this.buildUPointPayLoginView();
            return;
        }
    alab1:
        switch(paramView.getId()) {
            case 3: {
            label_55:
                if(this.mIsShowInfo) {
                    this.buildSmsPaymentView();
                    this.mIsShowInfo = false;
                    return;
                }
                if(this.mSmsInfo != null) {
                    IntentFilter intentFilter0 = new IntentFilter("com.uc.androidsdk.SMS_SENT_ACTION");
                    this.registerReceiver(this.mSmsReceiver, intentFilter0);
                    this.sendFirstSms(this.mSmsInfo);
                    return;
                }
                break;
            }
            case 4: {
                this.buildPaymentView();
                return;
            }
            case 5: {
                if(this.mConfirmSmsInfoString != null && this.mConfirmSmsInfoString.contains(",,,,")) {
                    this.sendConfirmSms(this.mConfirmSmsInfoString);
                    return;
                }
                break;
            }
            case 6: {
                this.showDialog(23);
                return;
            }
            case 7: {
                ((Button)paramView).setEnabled(false);
                String s = this.mEtUsername.getText().toString();
                String s1 = this.mEtPassword.getText().toString();
                if(TextUtils.isEmpty(s) && TextUtils.isEmpty(s1)) {
                    this.showDialog(28);
                    return;
                }
                if(TextUtils.isEmpty(s1)) {
                    this.showDialog(29);
                    return;
                }
                if(TextUtils.isEmpty(s)) {
                    this.showDialog(30);
                    return;
                }
                this.mUPayInfo = new UPointPayInfo(s, s1, "", this.mPaymentInfo.getCpID(), this.mPaymentInfo.getmGameID(), this.mPaymentInfo.getMoney(), "");
                this.pay();
                return;
            }
            case 8: {
                ((Button)paramView).setEnabled(false);
                String s2 = this.mEtPayPass.getText().toString();
                if(TextUtils.isEmpty(s2)) {
                    this.showDialog(28);
                }
                else {
                    this.mUPayInfo.setPaypwd(s2);
                    this.pay();
                }
                goto label_55;
            }
            case 9: {
                switch(this.mType) {
                    case 0: {
                        this.finish();
                        return;
                    }
                    case 1: {
                        this.buildPaymentView();
                        return;
                    }
                    case 2: {
                        this.buildUPointPaymentView();
                        return;
                    }
                    case 3: {
                        this.buildUPointPayLoginView();
                        return;
                    }
                    case 4: {
                        if(!this.mSmsInfo.isNeedconfirm() && !this.mIsShowInfo) {
                            if(this.mLeftSmsToSendCount != -1 && this.mLeftSmsToSendCount != Utils.getSmsPayment() / this.mSmsInfo.money) {
                                this.showDialog(27);
                                return;
                            }
                            this.buildSmsPaymentView();
                            return;
                        }
                        this.buildPaymentView();
                        return;
                    }
                    case 5: {
                        this.showDialog(23);
                        return;
                    }
                    default: {
                        return;
                    }
                }
            }
            case 10: {
                switch(this.mType) {
                    case 4: {
                        if(this.mSmsInfo.isNeedconfirm() || this.mIsShowInfo) {
                            if(this.mLeftSmsToSendCount != -1 && this.mLeftSmsToSendCount != Utils.getSmsPayment() / this.mSmsInfo.money) {
                                this.showDialog(27);
                                return;
                            }
                            this.buildPaymentView();
                            return;
                        }
                        break alab1;
                    }
                    case 5: {
                        this.showDialog(23);
                        return;
                    }
                    default: {
                        this.finish();
                    }
                }
            }
        }
    }

    @Override  // android.app.Activity
    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        this.mIsValid = this.initPayment();
        if(this.mIsValid) {
            Utils.init(this.getApplicationContext());
            Utils.initTitleBar(this);
            this.buildPaymentView();
            this.confirmEnterPaymentPoint();
            new HandlerProxy(this.getApplicationContext()).handleRequest();
        }
    }

    @Override  // android.app.Activity
    protected Dialog onCreateDialog(int paramInt) {
        switch(paramInt) {
            case 0: {
                return DialogUtil.createOKWarningDialog(this, 0, "该应用要求支付的金额不符合要求，不能成功支付。", this);
            }
            case 2: {
                return DialogUtil.createOKWarningDialogSupportLink(this, 2, "什么是U点?", "U点是<a href=\'http://wap.uc.cn\'>UC-优视</a>提供的一种虚拟货币，主要用于购买软件和游戏里的内容（如：道具、关卡、软件、使用时长等）。<br /><br />U点兑换标准：<br />1元可兑换10U点。<br />通过以下链接充值U点：<br /><a href=\'http://pay.uc.cn\'>UC-优视</a>", null);
            }
            case 5: {
                return DialogUtil.createOKWarningDialog(this, 5, "U点不足,不能继续支付！", null);
            }
            case 6: {
                return DialogUtil.createIndeterminateProgressDialog(this, 6, "正在支付，请勿关闭程序，请稍后......", false, null);
            }
            case 7: {
                return DialogUtil.createOKWarningDialog(this, 7, "支付不成功，请确定您的账户当中的余额充足并网络连接正常。", null);
            }
            case 8: {
                return DialogUtil.createOKWarningDialog(this, 8, "支付不成功，请确定您的账户当中的余额充足并网络连接正常。", null);
            }
            case 9: {
                return DialogUtil.createOKWarningDialog(this, 9, "支付不成功，请确定您的账户当中的余额充足并网络连接正常。", null);
            }
            case 10: {
                return DialogUtil.createYesNoDialog(this, 10, "支付不成功，连接服务器超时，是否重试?", this);
            }
            case 11: {
                return DialogUtil.createOKWarningDialog(this, 11, "支付不成功，请确定您的账户当中的余额充足并网络连接正常。\n请联系客服4006-400-401。", null);
            }
            case 13: {
                return DialogUtil.createOKWarningDialog(this, 13, "U点支付成功，祝您玩的开心", String.format("您的余额为%dU点", this.mNumber, ((int)this.mBalance)), this);
            }
            case 14: {
                return DialogUtil.createIndeterminateProgressDialog(this, 14, "连接服务器，请稍等...", false, null);
            }
            case 15: {
                return DialogUtil.createOKWarningDialog(this, 15, "网络连接错误，请检查网络后再试。", this);
            }
            case 16: {
                return DialogUtil.createOKWarningDialog(this, 16, this.mSmsResultInfo, this);
            }
            case 17: {
                return DialogUtil.createIndeterminateProgressDialog(this, 17, "短信发送过程可能持续一分钟，请耐心等待...", false, null);
            }
            case 18: {
                return DialogUtil.createOKWarningDialog(this, 18, "短信发送失败", null);
            }
            case 19: {
                return DialogUtil.createIndeterminateProgressDialog(this, 19, "正在获取信息，请稍候......", false, null);
            }
            case 20: {
                return DialogUtil.createOKWarningDialog(this, 20, "购买成功", this.mSmsResultInfo, this);
            }
            case 21: {
                return DialogUtil.createOKWarningDialog(this, 21, this.mSmsResultInfo, this);
            }
            case 22: {
                return DialogUtil.createOKWarningDialog(this, 22, "CPID为字符串和数字任意组合，不能由中文字符、标点符号或空格，长度不超过10个英文字符。", this);
            }
            case 23: {
                return DialogUtil.createTwoButtonsDialog(this, 23, "您已经取消了购买，将不会获得相应内容。请确认是否取消？", "取消", "不取消", this);
            }
            case 24: {
                return DialogUtil.createTwoButtonsDialog(this, 24, Html.fromHtml("购买确认短信未删除，如需购买请再次发送短信或采用其他支付方式，<font color=\'red\'>请勿到短信收件箱进行回复</font>，谢谢！"), "返回购买页", "返回应用", this);
            }
            case 25: {
                return DialogUtil.createTwoButtonsDialog(this, 25, "购买确认短信已删除，如需购买请再次发送短信或采用其他支付方式，谢谢！", "返回购买页", "返回应用", this);
            }
            case 26: {
                return DialogUtil.createOKWarningDialog(this, 26, "支付超时，点击确定重新验证支付结果。最多 需要1分钟，请耐心等待...", this);
            }
            case 27: {
                int v1 = this.getPayedAmount();
                return DialogUtil.createTwoButtonsDialog(this, 27, String.format("您已经支付过【%d】元短信，现在取消发送将不能成功购买【%s】。如取消发送已付金额不会返还，只能计算到您下次购买【%s】中。请再次确认是否取消这次支付？", ((int)(PrefUtil.getPayedAmount(this.getApplicationContext()) + v1)), this.mPaymentInfo.getPayname(), this.mPaymentInfo.getPayname()), "返回继续支付", "确认取消", this);
            }
            case 28: {
                return DialogUtil.createOKWarningDialog(this, 28, "请输入账号和密码。", null);
            }
            case 29: {
                return DialogUtil.createOKWarningDialog(this, 29, "密码为空，请输入密码。", null);
            }
            case 30: {
                return DialogUtil.createOKWarningDialog(this, 30, "用户名为空，请输入用户名。", null);
            }
            case 0x1F: {
                return DialogUtil.createOKWarningDialog(this, 0x1F, "用户名必须大于3个字。", null);
            }
            case 0x20: {
                return DialogUtil.createOKWarningDialog(this, 0x20, "用户名必须小于17个字。", null);
            }
            case 33: {
                return DialogUtil.createOKWarningDialog(this, 33, "密码不能为空。", null);
            }
            case 34: {
                return DialogUtil.createOKWarningDialog(this, 34, "登录失败，您的帐号和密码不匹配。", null);
            }
            case 35: {
                return DialogUtil.createIndeterminateProgressDialog(this, 35, "U点支付中，请稍候...", false, null);
            }
            case 36: {
                return DialogUtil.createYesNoDialog(this, 36, "您手机时间不正确，为了确保安全支付，是否需要系统自动修正并完成支付?", this);
            }
            case 37: {
                return DialogUtil.createOKWarningDialog(this, 37, "支付不成功，您的支付密码有误，不能支付成功！", null);
            }
            case 38: {
                return DialogUtil.createOKWarningDialog(this, 38, "支付不成功，您已经禁止了发送支付短信，请重新尝试支付。", null);
            }
            default: {
                return super.onCreateDialog(paramInt);
            }
        }
    }

    @Override  // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        if(this.mIsValid) {
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

    @Override  // com.uc.paymentsdk.network.ApiTask$TaskHandler
    public void onError(int paramInt1, int paramInt2) {
        switch(paramInt1) {
            case 3: {
                switch(paramInt2) {
                    case -1: {
                        ++this.mTimeoutCounter;
                        if(this.mTimeoutCounter < 2) {
                            Api.pay(this.getApplicationContext(), this, this.mPaymentInfo, this.mUPayInfo);
                            return;
                        }
                        this.mTimeoutCounter = 0;
                        this.mBtnPay.setEnabled(true);
                        this.removeDialog(6);
                        this.showDialog(10);
                        return;
                    }
                    case 0xDB: {
                        this.mBtnPay.setEnabled(false);
                        this.removeDialog(6);
                        this.showDialog(5);
                        this.buildPaymentView();
                        return;
                    }
                    case 425: {
                        this.mBtnPay.setEnabled(true);
                        this.removeDialog(6);
                        this.showDialog(8);
                        return;
                    }
                    case 500: {
                        this.mBtnPay.setEnabled(true);
                        this.removeDialog(6);
                        this.showDialog(11);
                        return;
                    }
                    default: {
                        this.mBtnPay.setEnabled(true);
                        this.removeDialog(6);
                        this.showDialog(7);
                        return;
                    }
                }
            }
            case 18: {
                this.dismissDialog(14);
                this.showDialog(15);
                this.buildPaymentView();
            }
        }
    }

    @Override  // com.uc.paymentsdk.network.chain.Handler$OnFinishListener
    public void onFinish() {
        this.fillData();
    }

    @Override  // android.widget.AdapterView$OnItemClickListener
    public void onItemClick(AdapterView adapterView0, View paramView, int paramInt, long paramLong) {
        if(paramInt != 0) {
            String s = ((CustomAdapter)((HeaderViewListAdapter)adapterView0.getAdapter()).getWrappedAdapter()).getItem(paramInt - 1).getId();
            if("upoint".equals(s)) {
                this.buildUPointPaymentView();
                return;
            }
            if("sms".equals(s)) {
                this.buildSmsPaymentView();
            }
        }
    }

    @Override  // android.app.Activity
    public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent) {
        if(paramInt != 4) {
            return super.onKeyDown(paramInt, paramKeyEvent);
        }
        switch(this.mType) {
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
                if(this.mSmsInfo.isNeedconfirm() || this.mIsShowInfo) {
                    if(this.mLeftSmsToSendCount != -1 && this.mLeftSmsToSendCount != Utils.getSmsPayment() / this.mSmsInfo.money) {
                        this.showDialog(27);
                        return true;
                    }
                    this.buildPaymentView();
                    return true;
                }
                this.buildPaymentView();
                return true;
            }
            case 5: {
                this.showDialog(23);
                return true;
            }
            default: {
                return super.onKeyDown(4, paramKeyEvent);
            }
        }
    }

    @Override  // com.uc.paymentsdk.network.ApiTask$TaskHandler
    public Object onPreHandle(int paramInt, HttpResponse paramHttpResponse) {
        if(5 == paramInt || 8 == paramInt) {
            return Boolean.valueOf(true);
        }
        String s = Utils.getBodyString(paramInt, paramHttpResponse);
        if(TextUtils.isEmpty(s)) {
            return null;
        }
        switch(paramInt) {
            case 3: {
                try {
                    return XMLParser.parsePayOrder(s);
                }
                catch(Exception e) {
                    e.printStackTrace();
                    break;
                }
            }
            case 18: {
                break;
            }
            default: {
                return null;
            }
        }
        try {
            return XMLParser.parseUPointInfo(s);
        }
        catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override  // android.app.Activity
    protected void onPrepareDialog(int paramInt, Dialog paramDialog) {
        super.onPrepareDialog(paramInt, paramDialog);
        if(paramDialog.isShowing()) {
            paramDialog.dismiss();
        }
    }

    @Override  // com.uc.paymentsdk.network.ApiTask$TaskHandler
    public void onSuccess(int paramInt, Object paramObject) {
        switch(paramInt) {
            case 3: {
                String[] arr_s = ((String)paramObject).split("#");
                int v1 = Integer.parseInt(arr_s[0]);
                String errormsg = arr_s[1];
                this.removeDialog(6);
                if(v1 == -110) {
                    this.showDialog(7);
                    this.mUPayInfo.updateConsumeId();
                    return;
                }
                if(v1 == -102 && errormsg.equals("uc_tm_modify")) {
                    this.mUPayInfo.setTm(arr_s[2]);
                    this.showDialog(36);
                    return;
                }
                if(v1 < 0) {
                    if(v1 == -102) {
                        if(errormsg.equals("uc_password_error")) {
                            this.showDialog(34);
                            return;
                        }
                        if(errormsg.equals("um_account_error")) {
                            this.showDialog(5);
                            return;
                        }
                        if(errormsg.equals("um_paypwd_error")) {
                            this.showDialog(37);
                            return;
                        }
                        if(errormsg.equals("um_paypwd_error")) {
                            if(this.mType == 3) {
                                this.showDialog(7);
                                return;
                            }
                            if(this.mEtSavePass.isChecked()) {
                                PrefUtil.setUCUserName(this.getApplicationContext(), this.mEtUsername.getText().toString());
                                PrefUtil.setUCUserPass(this.getApplicationContext(), this.mEtPassword.getText().toString());
                            }
                            else {
                                PrefUtil.clearUCUserName(this.getApplicationContext());
                                PrefUtil.clearUCUserPass(this.getApplicationContext());
                            }
                            this.buildUPointPayPassView();
                            return;
                        }
                        if(errormsg.equals("um_system_error")) {
                            this.showDialog(7);
                            this.mUPayInfo.updateConsumeId();
                            return;
                        }
                    }
                    return;
                }
                if(this.mEtSavePass.isChecked()) {
                    PrefUtil.setUCUserName(this.getApplicationContext(), this.mEtUsername.getText().toString());
                    PrefUtil.setUCUserPass(this.getApplicationContext(), this.mEtPassword.getText().toString());
                }
                else {
                    PrefUtil.clearUCUserName(this.getApplicationContext());
                    PrefUtil.clearUCUserPass(this.getApplicationContext());
                }
                this.showDialog(13);
                return;
            }
            case 18: {
                this.initUPointPayView(((UPointInfo)paramObject));
                Utils.setUPointInfo(((UPointInfo)paramObject));
                this.dismissDialog(14);
            }
        }
    }

    @Override  // com.uc.paymentsdk.util.DialogUtil$WarningDialogListener
    public void onWarningDialogCancel(int paramInt) {
        switch(paramInt) {
            case 24: 
            case 25: {
                if(this.mSmsHander != null && this.mSmsRunnable != null) {
                    this.mSmsHander.removeCallbacks(this.mSmsRunnable);
                    this.getContentResolver().unregisterContentObserver(this.mSmsContent);
                    try {
                        this.unregisterReceiver(this.mSmsReceiver);
                    }
                    catch(IllegalArgumentException unused_ex) {
                    }
                }
                this.finish();
                return;
            }
            case 27: {
                if(this.mSmsHander != null && this.mSmsRunnable != null) {
                    this.mSmsHander.removeCallbacks(this.mSmsRunnable);
                    this.getContentResolver().unregisterContentObserver(this.mSmsContent);
                    try {
                        this.unregisterReceiver(this.mSmsReceiver);
                    }
                    catch(IllegalArgumentException unused_ex) {
                    }
                }
                this.buildPaymentView();
            }
        }
    }

    @Override  // com.uc.paymentsdk.util.DialogUtil$WarningDialogListener
    public void onWarningDialogOK(int paramInt) {
        switch(paramInt) {
            case 10: {
                this.pay();
                return;
            }
            case 13: {
                this.setResult(-1, new Intent());
                this.finish();
                return;
            }
            case 20: {
                PrefUtil.clearPayedAmount(this.getApplicationContext());
                this.setResult(-1, new Intent());
                this.finish();
                return;
            }
            case 0: 
            case 1: 
            case 22: {
                this.finish();
                return;
            }
            case 23: {
                this.showDialog(24);
                return;
            }
            case 15: 
            case 16: 
            case 24: {
                break;
            }
            case 21: 
            case 25: {
                if(this.mSmsHander != null && this.mSmsRunnable != null) {
                    this.mSmsHander.removeCallbacks(this.mSmsRunnable);
                }
                if(this.mSmsContent != null) {
                    this.getContentResolver().unregisterContentObserver(this.mSmsContent);
                }
                try {
                    this.unregisterReceiver(this.mSmsReceiver);
                }
                catch(IllegalArgumentException unused_ex) {
                }
                break;
            }
            case 26: {
                if(4 == this.mType) {
                    this.sendFirstSms(this.mSmsInfo);
                    return;
                }
                this.sendConfirmSms(this.mConfirmSmsInfoString);
                return;
            }
            case 36: {
                this.pay();
                return;
            }
            default: {
                return;
            }
        }
        this.buildPaymentView();
    }

    private void pay() {
        this.showDialog(6);
        Api.pay(this.getApplicationContext(), this, this.mPaymentInfo, this.mUPayInfo);
    }

    private void sendConfirmSms(String paramString) {
        this.showDialog(17);
        try {
            SmsInfo.sendSms(this.getApplicationContext(), paramString.split(",,,,")[0], paramString.split(",,,,")[1]);
        }
        catch(Exception unused_ex) {
            if(this.mSmsHander != null && this.mSmsRunnable != null) {
                this.mSmsHander.removeCallbacks(this.mSmsRunnable);
                this.getContentResolver().unregisterContentObserver(this.mSmsContent);
                try {
                    this.unregisterReceiver(this.mSmsReceiver);
                }
                catch(IllegalArgumentException unused_ex) {
                }
            }
            this.removeDialog(17);
            this.showDialog(38);
        }
    }

    private void sendFirstSms(SmsInfo paramSmsInfo) {
        this.showDialog(17);
        try {
            paramSmsInfo.sendFirstSms(this.getApplicationContext());
        }
        catch(Exception unused_ex) {
            if(this.mSmsHander != null && this.mSmsRunnable != null) {
                this.mSmsHander.removeCallbacks(this.mSmsRunnable);
                this.getContentResolver().unregisterContentObserver(this.mSmsContent);
                try {
                    this.unregisterReceiver(this.mSmsReceiver);
                }
                catch(IllegalArgumentException unused_ex) {
                }
            }
            this.removeDialog(17);
            this.showDialog(38);
        }
    }
}

