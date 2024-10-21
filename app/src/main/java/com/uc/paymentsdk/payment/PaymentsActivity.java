package com.uc.paymentsdk.payment;

import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.sqlite.SQLiteAbortException;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.PasswordTransformationMethod;
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
import com.uc.paymentsdk.payment.sms.SimCardNotSupportException;
import com.uc.paymentsdk.payment.sms.SmsInfo;
import com.uc.paymentsdk.payment.upoint.UPointInfo;
import com.uc.paymentsdk.payment.upoint.UPointPayInfo;
import com.uc.paymentsdk.util.Constants;
import com.uc.paymentsdk.util.DialogUtil;
import com.uc.paymentsdk.util.PrefUtil;
import com.uc.paymentsdk.util.Utils;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;
import javax.microedition.media.Player;
import main.Constants_H;
import org.apache.http.HttpResponse;

/* loaded from: classes.dex */
public class PaymentsActivity extends Activity implements View.OnClickListener, ApiTask.TaskHandler, AdapterView.OnItemClickListener, DialogUtil.WarningDialogListener, Handler.OnFinishListener {
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
    private static final long PAY_SMS_TIMEOUT = 60000;
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
    private String mSmsResultInfo;
    private int mTimeoutCounter;
    private TextView mTvDiscountTextView;
    private TextView mTvProduct;
    private TextView mTvVipDiscountInfo;
    private TextView mTvVipDiscountTextView;
    private TextView mTvVipDiscountTimeTextView;
    private int mType;
    private UPointPayInfo mUPayInfo;
    private final BroadcastReceiver mSmsReceiver = new BroadcastReceiver() { // from class: com.uc.paymentsdk.payment.PaymentsActivity.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context paramContext, Intent paramIntent) {
            switch (getResultCode()) {
                case -1:
                    if (4 == PaymentsActivity.this.mType) {
                        if (PaymentsActivity.this.mSmsInfo.isNeedconfirm()) {
                            try {
                                Thread.sleep(5000L);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            PaymentsActivity.this.removeDialog(17);
                            String smsConfirmText = PaymentsActivity.this.mSmsInfo.getSmsConfirmContent();
                            String smsaddress = PaymentsActivity.this.mSmsInfo.getSmsConfirmNumber();
                            PaymentsActivity.this.buildSmsPaymentConfirmView(smsaddress, smsConfirmText);
                            return;
                        }
                        PaymentsActivity.this.mLeftSmsToSendCount--;
                        PaymentsActivity.this.removeDialog(17);
                        PrefUtil.setPayedAmount(PaymentsActivity.this.getApplicationContext(), PaymentsActivity.this.getPayedAmount());
                        if (PaymentsActivity.this.mLeftSmsToSendCount < 1) {
                            try {
                                PaymentsActivity.this.unregisterReceiver(PaymentsActivity.this.mSmsReceiver);
                            } catch (IllegalArgumentException e2) {
                            }
                            PaymentsActivity.this.mSmsResultInfo = "支付已完成，祝您玩得开心。";
                            PaymentsActivity.this.showDialog(20);
                        } else {
                            PaymentsActivity.this.buildSmsPaymentView();
                        }
                        if (PaymentsActivity.this.mSmsInfo.getSmstype() == 1) {
                            Api.postSmsPayment(PaymentsActivity.this.getApplicationContext(), PaymentsActivity.this, PaymentsActivity.this.mPaymentInfo.getCpID(), PaymentsActivity.this.mPaymentInfo.getmGameID(), PaymentsActivity.this.mPaymentInfo.getmActionID(), Utils.getSmsPayment(), PaymentsActivity.this.mPaymentInfo.getmActionID(), PaymentsActivity.this.mSmsInfo.getSmschannelid(), PaymentsActivity.this.mSmsInfo.getSmsnumber(), PaymentsActivity.this.mSmsInfo.getContent(), PaymentsActivity.this.mSmsInfo.getSmstype());
                            return;
                        }
                        return;
                    }
                    PaymentsActivity.this.removeDialog(17);
                    PaymentsActivity.this.mLeftSmsToSendCount--;
                    PrefUtil.setPayedAmount(PaymentsActivity.this.getApplicationContext(), PaymentsActivity.this.getPayedAmount());
                    if (PaymentsActivity.this.mLeftSmsToSendCount < 1) {
                        try {
                            PaymentsActivity.this.unregisterReceiver(PaymentsActivity.this.mSmsReceiver);
                        } catch (IllegalArgumentException e3) {
                        }
                        PaymentsActivity.this.mSmsResultInfo = "支付已完成，祝您玩得开心。";
                        PaymentsActivity.this.showDialog(20);
                    } else {
                        PaymentsActivity.this.buildSmsPaymentView();
                    }
                    if (PaymentsActivity.this.mSmsInfo.getSmstype() == 1) {
                        Api.postSmsPayment(PaymentsActivity.this.getApplicationContext(), PaymentsActivity.this, PaymentsActivity.this.mPaymentInfo.getCpID(), PaymentsActivity.this.mPaymentInfo.getmGameID(), PaymentsActivity.this.mPaymentInfo.getmActionID(), Utils.getSmsPayment(), PaymentsActivity.this.mPaymentInfo.getmActionID(), PaymentsActivity.this.mSmsInfo.getSmschannelid(), PaymentsActivity.this.mSmsInfo.getSmsnumber(), PaymentsActivity.this.mSmsInfo.getContent(), PaymentsActivity.this.mSmsInfo.getSmstype());
                        return;
                    }
                    return;
                case 1:
                case 133404:
                    return;
                case 2:
                    PaymentsActivity.this.removeDialog(17);
                    PaymentsActivity.this.mSmsResultInfo = "当前手机设置为飞行模式，不能发送短信。";
                    PaymentsActivity.this.showDialog(21);
                    if ((PaymentsActivity.this.mLeftSmsToSendCount != -1 || 5 == PaymentsActivity.this.mType) && PaymentsActivity.this.mSmsContent != null) {
                        PaymentsActivity.this.getContentResolver().unregisterContentObserver(PaymentsActivity.this.mSmsContent);
                        return;
                    }
                    return;
                default:
                    PaymentsActivity.this.removeDialog(17);
                    PaymentsActivity.this.mSmsResultInfo = Constants.TEXT_PAY_SMS_FAILED_INSUFFENT_BALANCE;
                    PaymentsActivity.this.showDialog(21);
                    if ((PaymentsActivity.this.mLeftSmsToSendCount != -1 || 5 == PaymentsActivity.this.mType) && PaymentsActivity.this.mSmsContent != null) {
                        PaymentsActivity.this.getContentResolver().unregisterContentObserver(PaymentsActivity.this.mSmsContent);
                        return;
                    }
                    return;
            }
        }
    };
    private final Runnable mSmsRunnable = new Runnable() { // from class: com.uc.paymentsdk.payment.PaymentsActivity.2
        @Override // java.lang.Runnable
        public void run() {
            if (PaymentsActivity.this.mSmsContent != null) {
                PaymentsActivity.this.getContentResolver().unregisterContentObserver(PaymentsActivity.this.mSmsContent);
            }
            PaymentsActivity.this.removeDialog(17);
            if (PaymentsActivity.this.mSmsInfo.needconfirm) {
                PaymentsActivity.this.mSmsResultInfo = "对不起，接收确认短信超时，请重新尝试支付！";
                PaymentsActivity.this.showDialog(21);
            } else if (PaymentsActivity.this.mLeftSmsToSendCount > 0) {
                PaymentsActivity.this.mSmsResultInfo = "对不起，短信支付已经超时，请重新支付！";
                PaymentsActivity.this.showDialog(21);
            } else {
                PrefUtil.setPayedAmount(PaymentsActivity.this.getApplicationContext(), PaymentsActivity.this.getPayedAmount());
                PaymentsActivity.this.mSmsResultInfo = "感谢您的使用，祝您玩得开心！";
                PaymentsActivity.this.showDialog(20);
            }
            try {
                PaymentsActivity.this.unregisterReceiver(PaymentsActivity.this.mSmsReceiver);
            } catch (IllegalArgumentException e) {
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        this.mIsValid = initPayment();
        if (this.mIsValid) {
            Utils.init(getApplicationContext());
            Utils.initTitleBar(this);
            buildPaymentView();
            confirmEnterPaymentPoint();
            new HandlerProxy(getApplicationContext()).handleRequest();
        }
    }

    public void confirmEnterPaymentPoint() {
        PrefUtil.increaseArriveCount(getApplicationContext());
    }

    private boolean initPayment() {
        String str;
        this.mPaymentInfo = (PaymentInfo) getIntent().getSerializableExtra(EXTRA_KEY_PAYMENTINFO);
        if (this.mPaymentInfo == null) {
            throw new IllegalArgumentException("PaymentInfo必须设置");
        }
        this.mPaymentInfo.setPaytype("sms");
        int i = this.mPaymentInfo.getMoney();
        if (i <= 0 || i > 10000 || i % 5 != 0) {
            showDialog(0);
            return false;
        }
        if (this.mPaymentInfo.getPayname() == null) {
            throw new IllegalArgumentException("必须指定支付内容名称");
        }
        if (this.mPaymentInfo.getPaydesc() == null) {
            throw new IllegalArgumentException("必须指定支付内容描述");
        }
        if (this.mPaymentInfo.getmGameID() == null) {
            throw new IllegalArgumentException("必须指定游戏ID");
        }
        if (this.mPaymentInfo.getmGameID().length() != 2) {
            throw new IllegalArgumentException("游戏ID必须为两位数字");
        }
        if (!Utils.isNumeric(this.mPaymentInfo.getmGameID())) {
            throw new IllegalArgumentException("游戏ID必须为两位数字");
        }
        if (this.mPaymentInfo.getmActionID() == null) {
            throw new IllegalArgumentException("必须指定支付点ID");
        }
        if (this.mPaymentInfo.getmActionID().length() != 2) {
            throw new IllegalArgumentException("支付点ID必须为两位数字");
        }
        if (!Utils.isNumeric(this.mPaymentInfo.getmActionID())) {
            throw new IllegalArgumentException("支付点ID必须为两位数字");
        }
        if (this.mPaymentInfo.getPayname().length() > 50) {
            this.mPaymentInfo.setPayname(this.mPaymentInfo.getPayname().substring(0, 50));
        }
        if (this.mPaymentInfo.getPaydesc().length() > 100) {
            this.mPaymentInfo.setPaydesc(this.mPaymentInfo.getPaydesc().substring(0, 100));
        }
        try {
            str = Utils.getCpID(getApplicationContext());
        } catch (PackageManager.NameNotFoundException e) {
            showDialog(22);
        } catch (NullPointerException e2) {
            showDialog(22);
        }
        if (!Pattern.matches(Constants.CPID_PATTERN, str)) {
            showDialog(22);
            return false;
        }
        this.mPaymentInfo.setCpID(str);
        if (this.mPaymentInfo.getUsername() != null) {
            PrefUtil.setUCUserName(getApplicationContext(), this.mPaymentInfo.getUsername());
        }
        Utils.setPaymentInfo(this.mPaymentInfo);
        return true;
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int paramInt, Dialog paramDialog) {
        super.onPrepareDialog(paramInt, paramDialog);
        if (paramDialog.isShowing()) {
            paramDialog.dismiss();
        }
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int paramInt) {
        switch (paramInt) {
            case 0:
                return DialogUtil.createOKWarningDialog(this, paramInt, "该应用要求支付的金额不符合要求，不能成功支付。", this);
            case 1:
            case 3:
            case 4:
            case 12:
            default:
                return super.onCreateDialog(paramInt);
            case 2:
                return DialogUtil.createOKWarningDialogSupportLink(this, paramInt, "什么是U点?", "U点是<a href='http://wap.uc.cn'>UC-优视</a>提供的一种虚拟货币，主要用于购买软件和游戏里的内容（如：道具、关卡、软件、使用时长等）。<br /><br />U点兑换标准：<br />1元可兑换10U点。<br />通过以下链接充值U点：<br /><a href='http://pay.uc.cn'>UC-优视</a>", null);
            case 5:
                return DialogUtil.createOKWarningDialog(this, paramInt, "U点不足,不能继续支付！", null);
            case 6:
                return DialogUtil.createIndeterminateProgressDialog(this, paramInt, "正在支付，请勿关闭程序，请稍后......", false, null);
            case 7:
                return DialogUtil.createOKWarningDialog(this, paramInt, "支付不成功，请确定您的账户当中的余额充足并网络连接正常。", null);
            case 8:
                return DialogUtil.createOKWarningDialog(this, paramInt, "支付不成功，请确定您的账户当中的余额充足并网络连接正常。", null);
            case 9:
                return DialogUtil.createOKWarningDialog(this, paramInt, "支付不成功，请确定您的账户当中的余额充足并网络连接正常。", null);
            case 10:
                return DialogUtil.createYesNoDialog(this, paramInt, "支付不成功，连接服务器超时，是否重试?", this);
            case 11:
                return DialogUtil.createOKWarningDialog(this, paramInt, "支付不成功，请确定您的账户当中的余额充足并网络连接正常。\n请联系客服4006-400-401。", null);
            case 13:
                return DialogUtil.createOKWarningDialog(this, paramInt, "U点支付成功，祝您玩的开心", String.format("您的余额为%dU点", this.mNumber, Integer.valueOf(this.mBalance)), this);
            case 14:
                return DialogUtil.createIndeterminateProgressDialog(this, paramInt, "连接服务器，请稍等...", false, null);
            case 15:
                return DialogUtil.createOKWarningDialog(this, paramInt, "网络连接错误，请检查网络后再试。", this);
            case 16:
                return DialogUtil.createOKWarningDialog(this, paramInt, this.mSmsResultInfo, this);
            case 17:
                return DialogUtil.createIndeterminateProgressDialog(this, paramInt, "短信发送过程可能持续一分钟，请耐心等待...", false, null);
            case 18:
                return DialogUtil.createOKWarningDialog(this, paramInt, "短信发送失败", null);
            case 19:
                return DialogUtil.createIndeterminateProgressDialog(this, paramInt, "正在获取信息，请稍候......", false, null);
            case 20:
                return DialogUtil.createOKWarningDialog(this, paramInt, Constants_H.MONEY_TXT_18, this.mSmsResultInfo, this);
            case 21:
                return DialogUtil.createOKWarningDialog(this, paramInt, this.mSmsResultInfo, this);
            case 22:
                return DialogUtil.createOKWarningDialog(this, paramInt, Constants.ERROR_START_CPID_INVALID, this);
            case 23:
                return DialogUtil.createTwoButtonsDialog(this, paramInt, "您已经取消了购买，将不会获得相应内容。请确认是否取消？", "取消", "不取消", this);
            case 24:
                return DialogUtil.createTwoButtonsDialog(this, paramInt, Html.fromHtml(Constants.TEXT_PAY_SMS_BACK_CONFIRM), Constants.TEXT_BACK_TO_PAYPOINT, Constants.TEXT_EXIT, this);
            case DIALOG_PAY_SMS_DELETE_BACK_CONFIRM /* 25 */:
                return DialogUtil.createTwoButtonsDialog(this, paramInt, Constants.TEXT_PAY_SMS_DELETE_BACK_CONFIRM, Constants.TEXT_BACK_TO_PAYPOINT, Constants.TEXT_EXIT, this);
            case 26:
                return DialogUtil.createOKWarningDialog(this, paramInt, "支付超时，点击确定重新验证支付结果。最多 需要1分钟，请耐心等待...", this);
            case DIALOG_PAY_SMS_RETRY_MULTIPLE /* 27 */:
                int i = getPayedAmount();
                int j = PrefUtil.getPayedAmount(getApplicationContext());
                return DialogUtil.createTwoButtonsDialog(this, paramInt, String.format(Constants.TEXT_PAY_SMS_CHANCEL_CONFIRM, Integer.valueOf(j + i), this.mPaymentInfo.getPayname(), this.mPaymentInfo.getPayname()), Constants.TEXT_BACK_TO_PAY, Constants.TEXT_CONFIRM_TO_CANCEL, this);
            case DIALOG_PASSWORD_OR_USERNAME_IS_EMPTY /* 28 */:
                return DialogUtil.createOKWarningDialog(this, paramInt, Constants.ERROR_PASSWORD_OR_USERNAME_IS_EMPTY, null);
            case DIALOG_PASSWORD_IS_EMPTY /* 29 */:
                return DialogUtil.createOKWarningDialog(this, paramInt, Constants.ERROR_PASSWORD_IS_EMPTY, null);
            case DIALOG_USERNAME_IS_EMPTY /* 30 */:
                return DialogUtil.createOKWarningDialog(this, paramInt, Constants.ERROR_USERNAME_IS_EMPTY, null);
            case DIALOG_USERNAME_WRONG /* 31 */:
                return DialogUtil.createOKWarningDialog(this, paramInt, Constants.ERROR_REGISTER_USERNAME_WRONG, null);
            case 32:
                return DialogUtil.createOKWarningDialog(this, paramInt, Constants.ERROR_REGISTER_UNSERNAME_WRONG2, null);
            case 33:
                return DialogUtil.createOKWarningDialog(this, paramInt, Constants.ERROR_REGISTER_PASSWORD_WRONG, null);
            case DIALOG_ACCOUNT_WRONG /* 34 */:
                return DialogUtil.createOKWarningDialog(this, paramInt, "登录失败，您的帐号和密码不匹配。", null);
            case DIALOG_UPOINT_PAYING /* 35 */:
                return DialogUtil.createIndeterminateProgressDialog(this, paramInt, "U点支付中，请稍候...", false, null);
            case 36:
                return DialogUtil.createYesNoDialog(this, paramInt, "您手机时间不正确，为了确保安全支付，是否需要系统自动修正并完成支付?", this);
            case DIALOG_UPOINT_PAYPASS_WRONG /* 37 */:
                return DialogUtil.createOKWarningDialog(this, paramInt, "支付不成功，您的支付密码有误，不能支付成功！", null);
            case DIALOG_SMS_FAIL /* 38 */:
                return DialogUtil.createOKWarningDialog(this, paramInt, "支付不成功，您已经禁止了发送支付短信，请重新尝试支付。", null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getPayedAmount() {
        int i = Utils.getSmsPayment() - PrefUtil.getPayedAmount(getApplicationContext());
        int j = i / this.mSmsInfo.money;
        return this.mSmsInfo.money * (j - this.mLeftSmsToSendCount);
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
        RelativeLayout paytitle = Utils.initSubTitle(getApplicationContext(), this, "购买内容", false);
        TextView payContentTextView = new TextView(getApplicationContext());
        payContentTextView.setTextSize(16.0f);
        payContentTextView.setTextColor(Color.parseColor("#FF858D8D"));
        payContentTextView.setPadding(10, 10, 0, 10);
        payContentTextView.setText("尊敬的用户，您需要为以下内容支付费用，请阅读以下信息，确认所购内容无误。");
        TextView payContentDetailTextView = new TextView(getApplicationContext());
        payContentDetailTextView.setTextSize(16.0f);
        payContentDetailTextView.setPadding(20, 0, 20, 0);
        payContentDetailTextView.setText(String.format("所购内容 : %s", this.mPaymentInfo.getPaydesc()));
        payContentDetailTextView.setTextColor(-12303292);
        String moneyStr = new DecimalFormat("##0.00").format(this.mPaymentInfo.getMoney() / 10.0f);
        TextView payCountTextView = new TextView(getApplicationContext());
        payCountTextView.setTextSize(16.0f);
        payCountTextView.setPadding(20, 0, 0, 20);
        payCountTextView.setText(String.format("支付金额: %s元", moneyStr));
        payCountTextView.setTextColor(-12303292);
        LinearLayout linearLayout = new LinearLayout(getApplicationContext());
        linearLayout.setBackgroundColor(-1);
        linearLayout.setOrientation(1);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
        linearLayout.addView(paytitle, localLayoutParams);
        linearLayout.addView(payContentTextView, localLayoutParams);
        linearLayout.addView(payContentDetailTextView, localLayoutParams);
        linearLayout.addView(payCountTextView, localLayoutParams);
        this.mListView = new ListView(getApplicationContext());
        this.mListView.setBackgroundColor(-1);
        this.mListView.setCacheColorHint(-1);
        this.mListView.addHeaderView(linearLayout, null, true);
        this.mListView.setOnItemClickListener(this);
        this.mListView.addFooterView(Utils.generateFooterView(this), null, false);
        setContentView(this.mListView);
        fillData();
        new HandlerProxy(getApplicationContext(), this).handleRequest();
    }

    private void buildUPointPaymentView() {
        this.mType = 1;
        TextView payTypeNameTextView = new TextView(getApplicationContext());
        payTypeNameTextView.setTextSize(16.0f);
        payTypeNameTextView.setPadding(20, 0, 20, 0);
        payTypeNameTextView.setTextColor(-12303292);
        payTypeNameTextView.setText(String.format("支付名称 : %s", this.mPaymentInfo.getPayname()));
        this.mTvProduct = new TextView(getApplicationContext());
        this.mTvProduct.setTextSize(16.0f);
        this.mTvProduct.setPadding(20, 0, 20, 0);
        this.mTvProduct.setText("产品名 : ");
        this.mTvProduct.setTextColor(-12303292);
        TextView payContentTextView = new TextView(getApplicationContext());
        payContentTextView.setTextSize(16.0f);
        payContentTextView.setPadding(20, 0, 20, 20);
        payContentTextView.setText(String.format("所购内容 : %s", this.mPaymentInfo.getPaydesc()));
        payContentTextView.setTextColor(-12303292);
        TextView payCountTextView = new TextView(getApplicationContext());
        payCountTextView.setTextSize(16.0f);
        payCountTextView.setPadding(20, 0, 20, 0);
        payCountTextView.setText(String.format("支付数额 : %dU点（价值%s元）", Integer.valueOf(this.mPaymentInfo.getMoney()), new DecimalFormat("##0.00").format(this.mPaymentInfo.getMoney() / 10.0f)));
        payCountTextView.setTextColor(-13487566);
        this.mTvDiscountTextView = new TextView(getApplicationContext());
        this.mTvDiscountTextView.setTextSize(16.0f);
        this.mTvDiscountTextView.setPadding(20, 0, 20, 0);
        this.mTvDiscountTextView.setText("U点折扣 : ");
        this.mTvDiscountTextView.setTextColor(-13487566);
        this.mTvVipDiscountTextView = new TextView(getApplicationContext());
        this.mTvVipDiscountTextView.setTextSize(16.0f);
        this.mTvVipDiscountTextView.setPadding(20, 0, 20, 0);
        this.mTvVipDiscountTextView.setText("会员折扣 : ");
        this.mTvVipDiscountTextView.setTextColor(-13487566);
        this.mTvVipDiscountTimeTextView = new TextView(getApplicationContext());
        this.mTvVipDiscountTimeTextView.setTextSize(16.0f);
        this.mTvVipDiscountTimeTextView.setPadding(20, 0, 20, 0);
        this.mTvVipDiscountTimeTextView.setText("会员折扣到期时间 : ");
        this.mTvVipDiscountInfo = new TextView(getApplicationContext());
        this.mTvVipDiscountInfo.setTextColor(-13487566);
        this.mTvVipDiscountInfo = new TextView(getApplicationContext());
        this.mTvVipDiscountInfo.setTextSize(16.0f);
        this.mTvVipDiscountInfo.setPadding(20, 0, 20, 0);
        this.mTvVipDiscountInfo.setText("会员折扣信息 : ");
        this.mTvVipDiscountInfo.setTextColor(-13487566);
        this.mBtnPay = new Button(getApplicationContext());
        this.mBtnPay.setText("确认");
        this.mBtnPay.setOnClickListener(this);
        this.mBtnPay.setVisibility(8);
        LinearLayout.LayoutParams localLayoutParams3 = new LinearLayout.LayoutParams(Player.PREFETCHED, -2);
        localLayoutParams3.gravity = 1;
        LinearLayout localLinearLayout2 = new LinearLayout(getApplicationContext());
        localLinearLayout2.addView(this.mBtnPay, localLayoutParams3);
        localLinearLayout2.setGravity(1);
        LinearLayout localLinearLayout3 = new LinearLayout(getApplicationContext());
        localLinearLayout3.setOrientation(1);
        localLinearLayout3.setBackgroundColor(-1);
        LinearLayout.LayoutParams localLayoutParams4 = new LinearLayout.LayoutParams(-1, -2);
        localLinearLayout3.addView(Utils.initSubTitle(getApplicationContext(), this, "需要支付的内容", true), localLayoutParams4);
        localLinearLayout3.addView(payTypeNameTextView, localLayoutParams4);
        localLinearLayout3.addView(this.mTvProduct, localLayoutParams4);
        localLinearLayout3.addView(payContentTextView, localLayoutParams4);
        localLinearLayout3.addView(payCountTextView, localLayoutParams4);
        localLinearLayout3.addView(this.mTvDiscountTextView, localLayoutParams4);
        localLinearLayout3.addView(this.mTvVipDiscountTextView, localLayoutParams4);
        localLinearLayout3.addView(this.mTvVipDiscountTimeTextView, localLayoutParams4);
        localLinearLayout3.addView(this.mTvVipDiscountInfo, localLayoutParams4);
        localLinearLayout3.addView(localLinearLayout2, localLayoutParams4);
        ScrollView localScrollView = new ScrollView(getApplicationContext());
        localScrollView.setBackgroundColor(-1);
        localScrollView.addView(localLinearLayout3);
        setContentView(localScrollView);
        if (Utils.getUPointInfo() == null) {
            showDialog(14);
            Api.queryUPointDiscount(getApplicationContext(), this, Utils.getPaymentInfo().getCpID(), Utils.getPaymentInfo().getmGameID(), Utils.getPaymentInfo().getMoney());
        } else {
            initUPointPayView(Utils.getUPointInfo());
        }
    }

    private void initUPointPayView(UPointInfo info) {
        this.mTvDiscountTextView.setText(String.format("U点折扣 : %s折(%sU点)", info.getDiscount(), info.getDiscounttext()));
        if (info.getVipdiscount() != null && info.getVipdiscount().length() > 0) {
            this.mTvDiscountTextView.setText(String.format("会员折扣 : %s折(%sU点)", info.getVipdiscount(), info.getVipdiscounttext()));
            this.mTvVipDiscountTimeTextView.setText(String.format("会员折扣到期时间 : ", info.getVipdiscounttime()));
            this.mTvVipDiscountInfo.setText("会员折扣到期时间 : " + info.getDiscountinfo());
        } else {
            this.mTvVipDiscountTextView.setVisibility(8);
            this.mTvVipDiscountTimeTextView.setVisibility(8);
            this.mTvVipDiscountInfo.setVisibility(8);
        }
        this.mBtnPay.setVisibility(0);
    }

    private void buildUPointPayLoginView() {
        this.mType = 2;
        RelativeLayout title = Utils.initSubTitle(getApplicationContext(), this, "请您输入UC帐号", true);
        title.setId(10);
        RelativeLayout.LayoutParams titleParams = new RelativeLayout.LayoutParams(-1, -2);
        titleParams.addRule(10, -1);
        title.setLayoutParams(titleParams);
        TextView noticeTextView = new TextView(getApplicationContext());
        RelativeLayout.LayoutParams noticeParams = new RelativeLayout.LayoutParams(-1, -2);
        noticeParams.addRule(3, 10);
        noticeParams.setMargins(10, 5, 10, 10);
        noticeTextView.setLayoutParams(noticeParams);
        noticeTextView.setId(1);
        noticeTextView.setCompoundDrawablePadding(10);
        noticeTextView.setTextColor(-13487566);
        noticeTextView.setCompoundDrawablesWithIntrinsicBounds(Utils.getDrawableFromFile(Utils.isHdpi() ? Constants.RES_LOCK_HDPI : Constants.RES_LOCK), (Drawable) null, (Drawable) null, (Drawable) null);
        noticeTextView.setText("您好，购买此内容，请先登录UC账号。您可以输入UC帐号或者手机号码进行登录");
        TextView lineTextView = Utils.generateBorderView(getApplication());
        lineTextView.setId(11);
        RelativeLayout.LayoutParams lineParams = new RelativeLayout.LayoutParams(-1, 1);
        lineParams.addRule(3, 1);
        lineTextView.setLayoutParams(lineParams);
        RelativeLayout.LayoutParams accountParams = new RelativeLayout.LayoutParams(-1, -2);
        accountParams.setMargins(10, 10, 10, 5);
        TextView accountLable = new TextView(getApplicationContext());
        accountLable.setLayoutParams(accountParams);
        accountLable.setId(2);
        accountLable.setText("UC账号:");
        accountLable.setTextColor(-13487566);
        RelativeLayout.LayoutParams usernameParams = new RelativeLayout.LayoutParams(-1, -2);
        usernameParams.addRule(3, 2);
        usernameParams.setMargins(10, 5, 10, 5);
        this.mEtUsername = new EditText(getApplicationContext());
        this.mEtUsername.setLayoutParams(usernameParams);
        this.mEtUsername.setSingleLine();
        this.mEtUsername.setId(3);
        this.mEtUsername.setHint("用户名");
        this.mEtPassword = new EditText(getApplicationContext());
        this.mEtPassword.setId(4);
        this.mEtPassword.setHint("密码");
        this.mEtPassword.setSingleLine();
        this.mEtPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
        RelativeLayout.LayoutParams userpassParams = new RelativeLayout.LayoutParams(-1, -2);
        userpassParams.addRule(3, 3);
        userpassParams.setMargins(10, 5, 10, 5);
        this.mEtPassword.setLayoutParams(userpassParams);
        this.mEtSavePass = new CheckBox(getApplicationContext());
        RelativeLayout.LayoutParams savepassParams = new RelativeLayout.LayoutParams(-1, -2);
        savepassParams.addRule(3, 4);
        savepassParams.setMargins(10, 5, 10, 5);
        this.mEtSavePass.setId(5);
        this.mEtSavePass.setTextColor(-12303292);
        this.mEtSavePass.setText("保存密码");
        this.mEtSavePass.setLayoutParams(savepassParams);
        if (PrefUtil.getUCUserName(getApplicationContext()) != null) {
            this.mEtUsername.setText(PrefUtil.getUCUserName(getApplicationContext()));
            this.mEtSavePass.setChecked(true);
        } else {
            this.mEtSavePass.setChecked(false);
        }
        if (PrefUtil.getUCUserPass(getApplicationContext()) != null) {
            this.mEtPassword.setText(PrefUtil.getUCUserPass(getApplicationContext()));
        }
        Button submitBtn = new Button(getApplicationContext());
        submitBtn.setId(7);
        submitBtn.setText("确定购买");
        submitBtn.setOnClickListener(this);
        RelativeLayout.LayoutParams submitLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
        submitLayoutParams.topMargin = 10;
        submitLayoutParams.addRule(3, 5);
        submitLayoutParams.addRule(14);
        submitBtn.setLayoutParams(submitLayoutParams);
        RelativeLayout inputareaLayout = new RelativeLayout(getApplicationContext());
        inputareaLayout.setId(7);
        inputareaLayout.setBackgroundColor(Constants.COLOR_LISTVIEW_ITEM_BACKGROUND);
        RelativeLayout.LayoutParams localLayoutParams8 = new RelativeLayout.LayoutParams(-1, -2);
        localLayoutParams8.addRule(3, 11);
        inputareaLayout.setLayoutParams(localLayoutParams8);
        inputareaLayout.addView(accountLable);
        inputareaLayout.addView(this.mEtUsername);
        inputareaLayout.addView(this.mEtPassword);
        inputareaLayout.addView(this.mEtSavePass);
        inputareaLayout.addView(submitBtn);
        RelativeLayout relativeLayout = new RelativeLayout(getApplicationContext());
        relativeLayout.setBackgroundColor(-1);
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        relativeLayout.addView(title);
        relativeLayout.addView(noticeTextView);
        relativeLayout.addView(lineTextView);
        relativeLayout.addView(inputareaLayout);
        TextView lineTextView1 = Utils.generateBorderView(getApplication());
        RelativeLayout.LayoutParams localLayoutParams9 = new RelativeLayout.LayoutParams(-1, 1);
        localLayoutParams9.addRule(3, 7);
        lineTextView1.setLayoutParams(localLayoutParams9);
        relativeLayout.addView(lineTextView1);
        ScrollView scrollView = new ScrollView(getApplication());
        scrollView.setBackgroundColor(-1);
        scrollView.addView(relativeLayout);
        setContentView(scrollView);
    }

    private void buildUPointPayPassView() {
        this.mType = 3;
        RelativeLayout title = Utils.initSubTitle(getApplicationContext(), this, "请您输入U点支付密码", true);
        title.setId(10);
        RelativeLayout.LayoutParams titleParams = new RelativeLayout.LayoutParams(-1, -2);
        titleParams.addRule(10, -1);
        title.setLayoutParams(titleParams);
        TextView noticeTextView = new TextView(getApplicationContext());
        RelativeLayout.LayoutParams noticeParams = new RelativeLayout.LayoutParams(-1, -2);
        noticeParams.addRule(3, 10);
        noticeParams.setMargins(10, 5, 10, 10);
        noticeTextView.setLayoutParams(noticeParams);
        noticeTextView.setId(1);
        noticeTextView.setCompoundDrawablePadding(10);
        noticeTextView.setTextColor(-13487566);
        noticeTextView.setCompoundDrawablesWithIntrinsicBounds(Utils.getDrawableFromFile(Utils.isHdpi() ? Constants.RES_LOCK_HDPI : Constants.RES_LOCK), (Drawable) null, (Drawable) null, (Drawable) null);
        noticeTextView.setText("您好，您的U点设置有支付密码，请收入后点击确认进行支付");
        TextView lineTextView = Utils.generateBorderView(getApplication());
        lineTextView.setId(11);
        RelativeLayout.LayoutParams lineParams = new RelativeLayout.LayoutParams(-1, 1);
        lineParams.addRule(3, 1);
        lineTextView.setLayoutParams(lineParams);
        RelativeLayout.LayoutParams accountParams = new RelativeLayout.LayoutParams(-1, -2);
        accountParams.setMargins(10, 10, 10, 5);
        TextView accountLable = new TextView(getApplicationContext());
        accountLable.setLayoutParams(accountParams);
        accountLable.setId(2);
        accountLable.setText("UC支付密码:");
        accountLable.setTextColor(-13487566);
        RelativeLayout.LayoutParams usernameParams = new RelativeLayout.LayoutParams(-1, -2);
        usernameParams.addRule(3, 2);
        usernameParams.setMargins(10, 5, 10, 5);
        this.mEtPayPass = new EditText(getApplicationContext());
        this.mEtPayPass.setLayoutParams(usernameParams);
        this.mEtPayPass.setSingleLine();
        this.mEtPayPass.setId(3);
        this.mEtPayPass.setHint("支付密码");
        Button submitBtn = new Button(getApplicationContext());
        submitBtn.setId(7);
        submitBtn.setText("确定购买");
        submitBtn.setOnClickListener(this);
        RelativeLayout.LayoutParams submitLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
        submitLayoutParams.topMargin = 10;
        submitLayoutParams.addRule(3, 5);
        submitLayoutParams.addRule(14);
        submitBtn.setLayoutParams(submitLayoutParams);
        RelativeLayout inputareaLayout = new RelativeLayout(getApplicationContext());
        inputareaLayout.setId(7);
        inputareaLayout.setBackgroundColor(Constants.COLOR_LISTVIEW_ITEM_BACKGROUND);
        RelativeLayout.LayoutParams localLayoutParams8 = new RelativeLayout.LayoutParams(-1, -2);
        localLayoutParams8.addRule(3, 11);
        inputareaLayout.setLayoutParams(localLayoutParams8);
        inputareaLayout.addView(accountLable);
        inputareaLayout.addView(this.mEtPayPass);
        inputareaLayout.addView(submitBtn);
        RelativeLayout relativeLayout = new RelativeLayout(getApplicationContext());
        relativeLayout.setBackgroundColor(-1);
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        relativeLayout.addView(title);
        relativeLayout.addView(noticeTextView);
        relativeLayout.addView(lineTextView);
        relativeLayout.addView(inputareaLayout);
        TextView lineTextView1 = Utils.generateBorderView(getApplication());
        RelativeLayout.LayoutParams localLayoutParams9 = new RelativeLayout.LayoutParams(-1, 1);
        localLayoutParams9.addRule(3, 7);
        lineTextView1.setLayoutParams(localLayoutParams9);
        relativeLayout.addView(lineTextView1);
        ScrollView scrollView = new ScrollView(getApplication());
        scrollView.setBackgroundColor(-1);
        scrollView.addView(relativeLayout);
        setContentView(scrollView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buildSmsPaymentView() {
        this.mType = 4;
        this.mSmsId = 0;
        RelativeLayout relativeLayout = new RelativeLayout(getApplicationContext());
        relativeLayout.setBackgroundColor(-1);
        relativeLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        RelativeLayout title = Utils.initSubTitle(getApplicationContext(), this, "短信支付", false);
        title.setId(1);
        title.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        relativeLayout.addView(title);
        TextView waitTextView = new TextView(this);
        waitTextView.setId(2);
        waitTextView.setTextSize(18.0f);
        waitTextView.setTextColor(-12303292);
        waitTextView.setPadding(10, 10, 0, 0);
        waitTextView.setFocusable(true);
        waitTextView.setClickable(true);
        waitTextView.setLinkTextColor(Constants.COLOR_LINK_TEXT);
        waitTextView.setText("尊敬的用户，正在获取信息，请稍后......");
        RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(-1, -2);
        localLayoutParams1.addRule(3, 1);
        waitTextView.setLayoutParams(localLayoutParams1);
        relativeLayout.addView(waitTextView);
        TextView beforeSendText = new TextView(this);
        beforeSendText.setId(3);
        beforeSendText.setTextSize(16.0f);
        beforeSendText.setTextColor(-7829368);
        beforeSendText.setPadding(10, DIALOG_USERNAME_IS_EMPTY, 0, 0);
        beforeSendText.setFocusable(true);
        beforeSendText.setClickable(true);
        beforeSendText.setLinkTextColor(Constants.COLOR_LINK_TEXT);
        RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        localLayoutParams2.addRule(3, 2);
        beforeSendText.setLayoutParams(localLayoutParams2);
        relativeLayout.addView(beforeSendText);
        Button submitBtn = new Button(getApplicationContext());
        submitBtn.setText("点播");
        submitBtn.setId(3);
        submitBtn.setOnClickListener(this);
        Button cancelButton = new Button(getApplicationContext());
        cancelButton.setText("取消");
        cancelButton.setId(4);
        cancelButton.setOnClickListener(this);
        try {
            Utils.CheckSimCardSupprotInfo(getApplicationContext());
            int smsPayCount = Utils.getSmsPayment();
            if (smsPayCount <= PrefUtil.getPayedAmount(getApplicationContext())) {
                this.mSmsResultInfo = "您已支付完成，将返回您的游戏中。";
                showDialog(20);
            } else if (!this.mIsSynced) {
                showDialog(19);
                new SyncSmsInfoHandler(getApplicationContext(), new Handler.OnFinishListener(waitTextView, beforeSendText, smsPayCount, cancelButton, submitBtn, relativeLayout) { // from class: com.uc.paymentsdk.payment.PaymentsActivity.3
                    Button cancelBtn;
                    RelativeLayout contentPanel;
                    Button okBtn;
                    int smsPayment;
                    TextView tvInfo2;
                    TextView waitTV;

                    {
                        this.waitTV = waitTextView;
                        this.tvInfo2 = beforeSendText;
                        this.smsPayment = smsPayCount;
                        this.cancelBtn = cancelButton;
                        this.okBtn = submitBtn;
                        this.contentPanel = relativeLayout;
                    }

                    @Override // com.uc.paymentsdk.network.chain.Handler.OnFinishListener
                    public void onFinish() {
                        if (Utils.getSmsInfos() != null) {
                            PaymentsActivity.this.mIsSynced = true;
                            PaymentsActivity.this.removeDialog(19);
                            PaymentsActivity.this.initSmsPayView(this.waitTV, this.tvInfo2, this.smsPayment, this.cancelBtn, this.okBtn, this.contentPanel);
                        } else {
                            PaymentsActivity.this.removeDialog(19);
                            PaymentsActivity.this.showDialog(15);
                        }
                    }
                }).handleRequest();
            } else {
                initSmsPayView(waitTextView, beforeSendText, smsPayCount, cancelButton, submitBtn, relativeLayout);
            }
        } catch (SimCardNotSupportException localSimCardNotSupportException) {
            this.mSmsResultInfo = localSimCardNotSupportException.getMessage();
            showDialog(16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initSmsPayView(TextView tvSmsMessage, TextView tvSmsText, int payMoney, Button cancelBtn, Button okBtn, RelativeLayout tableLayout) {
        Spanned showtext;
        Spanned showtext2;
        RelativeLayout.LayoutParams okBtnParams = new RelativeLayout.LayoutParams(150, -2);
        try {
            int payedCount = PrefUtil.getPayedAmount(getApplicationContext());
            if (payedCount == 0) {
                if (this.mSmsInfo == null) {
                    this.mSmsInfo = Utils.getSmsInfos().filterSmsInfo(getApplicationContext(), payMoney);
                    this.mSmsInfo.setExtInfo(this.mPaymentInfo);
                }
                int smsTotalToSendCount = payMoney / this.mSmsInfo.money;
                if (payMoney % this.mSmsInfo.money != 0) {
                    smsTotalToSendCount++;
                }
                if (!this.mSmsInfo.isNeedconfirm()) {
                    if (this.mLeftSmsToSendCount == -1) {
                        this.mLeftSmsToReceiveCount = smsTotalToSendCount;
                        this.mLeftSmsToSendCount = smsTotalToSendCount;
                        showtext2 = Html.fromHtml(String.format("尊敬的用户，感谢您为游戏支付，您需要发送<font color='#FF4500'>[ %d ]</font>条 %d 元的短信，购买<font color='#FF4500'>[%s]</font>，共计<font color='#FF4500'>[ %d ]</font>元，点击<font color='#FF4500'>[点播]</font>开始发送。请注意发送开始后，您不能中断发送，否则购买将不成功。", Integer.valueOf(this.mLeftSmsToSendCount), Integer.valueOf(this.mSmsInfo.money), this.mPaymentInfo.getPayname(), Integer.valueOf(payMoney)));
                        this.mIsShowInfo = true;
                    } else {
                        showtext2 = Html.fromHtml(String.format("尊敬的用户，点击<font color='#FF4500'>[确定]</font>按钮，发送第<font color='#FF4500'>[ %d ]</font>条短信。", Integer.valueOf((smsTotalToSendCount - this.mLeftSmsToSendCount) + 1)));
                        cancelBtn.setVisibility(8);
                        okBtn.setText("确定");
                        okBtnParams.addRule(14, -1);
                    }
                    tvSmsMessage.setText(showtext2);
                    tvSmsText.setText(this.mSmsInfo.getInfobeforesend());
                } else {
                    tvSmsMessage.setText(this.mSmsInfo.getInfobeforesend());
                    cancelBtn.setVisibility(8);
                    okBtn.setText("确定");
                    okBtnParams.addRule(14, -1);
                }
            } else {
                int payMoney2 = payMoney - payedCount;
                if (this.mSmsInfo == null) {
                    this.mSmsInfo = Utils.getSmsInfos().filterSmsInfo(getApplicationContext(), payMoney2);
                    this.mSmsInfo.setExtInfo(this.mPaymentInfo);
                }
                if (!this.mSmsInfo.isNeedconfirm()) {
                    if (this.mLeftSmsToSendCount == -1) {
                        int smsTotalToSendCount2 = payMoney2 / this.mSmsInfo.money;
                        if (payMoney2 % this.mSmsInfo.money != 0) {
                            smsTotalToSendCount2++;
                        }
                        this.mIsShowInfo = true;
                        this.mLeftSmsToSendCount = smsTotalToSendCount2;
                        this.mLeftSmsToReceiveCount = smsTotalToSendCount2;
                        showtext = Html.fromHtml(String.format("您以前成功发送过总计 %d 元的短信购买<font color='#FF4500'>[%s]</font>，目前还需发送<font color='#FF4500'>[ %d ]</font>条  %d 元短信继续购买，点击<font color='#FF4500'>[点播]</font>按钮开始发送。", Integer.valueOf(payedCount), this.mPaymentInfo.getPayname(), Integer.valueOf(this.mLeftSmsToSendCount), Integer.valueOf(this.mSmsInfo.money)));
                    } else {
                        showtext = Html.fromHtml(String.format("尊敬的用户，点击<font color='#FF4500'>[确定]</font>按钮，开始发送第<font color='#FF4500'>[ %d ]</font>条短信。", Integer.valueOf(((payMoney2 / this.mSmsInfo.money) - this.mLeftSmsToSendCount) + 1), Integer.valueOf(this.mLeftSmsToSendCount)));
                        cancelBtn.setVisibility(8);
                        okBtn.setText("确定");
                        okBtnParams.addRule(14, -1);
                    }
                    tvSmsMessage.setText(showtext);
                    tvSmsText.setText(this.mSmsInfo.getInfobeforesend());
                } else {
                    tvSmsMessage.setText(this.mSmsInfo.getInfobeforesend());
                    cancelBtn.setVisibility(8);
                    okBtn.setText("确定");
                    okBtnParams.addRule(14, -1);
                }
            }
            Linkify.addLinks(tvSmsMessage, 4);
            Linkify.addLinks(tvSmsText, 4);
        } catch (SimCardNotSupportException localSimCardNotSupportException) {
            this.mSmsResultInfo = localSimCardNotSupportException.getMessage();
            showDialog(16);
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
        setContentView(tableLayout);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buildSmsPaymentConfirmView(String smsaddress, String smsconfirmnumber) {
        this.mType = 5;
        try {
            Utils.CheckSimCardSupprotInfo(getApplicationContext());
            RelativeLayout relativeLayout = new RelativeLayout(getApplicationContext());
            relativeLayout.setBackgroundColor(-1);
            relativeLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            RelativeLayout title = Utils.initSubTitle(getApplicationContext(), this, "购买内容", true);
            title.setId(1);
            title.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
            relativeLayout.addView(title);
            TextView localTextView2 = new TextView(this);
            localTextView2.setId(2);
            localTextView2.setTextSize(16.0f);
            localTextView2.setTextColor(-13487566);
            localTextView2.setPadding(10, 10, 0, 0);
            localTextView2.setFocusable(true);
            localTextView2.setClickable(true);
            localTextView2.setLinkTextColor(Constants.COLOR_LINK_TEXT);
            localTextView2.setText(String.format("再次点击下一步即同意向\n%s发送短信以完成本次短信发送过程。", smsaddress, this.mPaymentInfo.getPayname(), Integer.valueOf(Utils.getSmsPayment())));
            Linkify.addLinks(localTextView2, 4);
            RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(-1, -2);
            localLayoutParams1.addRule(3, 1);
            localTextView2.setLayoutParams(localLayoutParams1);
            relativeLayout.addView(localTextView2);
            Button localButton1 = new Button(getApplicationContext());
            localButton1.setText("下一步");
            localButton1.setId(5);
            this.mConfirmSmsInfoString = String.valueOf(smsaddress) + TERM + smsconfirmnumber;
            localButton1.setTag(this.mConfirmSmsInfoString);
            localButton1.setOnClickListener(this);
            RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams(150, -2);
            localLayoutParams2.addRule(12, -1);
            localLayoutParams2.setMargins(10, 20, 10, 10);
            localButton1.setLayoutParams(localLayoutParams2);
            relativeLayout.addView(localButton1);
            Button localButton2 = new Button(getApplicationContext());
            localButton2.setText("取消");
            localButton2.setId(6);
            localButton2.setOnClickListener(this);
            RelativeLayout.LayoutParams localLayoutParams3 = new RelativeLayout.LayoutParams(150, -2);
            localLayoutParams3.addRule(11, -1);
            localLayoutParams3.addRule(12, -1);
            localLayoutParams3.setMargins(10, 20, 10, 10);
            localButton2.setLayoutParams(localLayoutParams3);
            relativeLayout.addView(localButton2);
            setContentView(relativeLayout);
        } catch (SimCardNotSupportException localSimCardNotSupportException) {
            this.mSmsResultInfo = localSimCardNotSupportException.getMessage();
            showDialog(16);
        }
    }

    private void fillData() {
        ArrayList<IType> arrayListofPayType = PrefUtil.getAvailablePayType(getApplicationContext(), this.mPaymentInfo.getPaytype());
        IType[] arrayOfPayType = new IType[arrayListofPayType.size()];
        if (PaymentInfo.PAYTYPE_OVERAGE.equals(this.mPaymentInfo.getPaytype())) {
            Iterator<IType> localIterator = arrayListofPayType.iterator();
            while (true) {
                if (!localIterator.hasNext()) {
                    break;
                }
                IType aPayType = localIterator.next();
                if (TypeFactory.TYPE_PAY_UPOINT.equals(aPayType.getId())) {
                    arrayOfPayType[0] = aPayType;
                    break;
                }
            }
        } else if ("sms".equals(this.mPaymentInfo.getPaytype())) {
            Iterator<IType> localIterator2 = arrayListofPayType.iterator();
            while (true) {
                if (!localIterator2.hasNext()) {
                    break;
                }
                IType aPayType2 = localIterator2.next();
                if ("sms".equals(aPayType2.getId())) {
                    arrayOfPayType[0] = aPayType2;
                    break;
                }
            }
        } else {
            Iterator<IType> localIterator3 = arrayListofPayType.iterator();
            while (localIterator3.hasNext()) {
                IType aPayType3 = localIterator3.next();
                if (TypeFactory.TYPE_PAY_UPOINT.equals(aPayType3.getId())) {
                    arrayOfPayType[0] = aPayType3;
                } else if ("sms".equals(aPayType3.getId())) {
                    arrayOfPayType[arrayOfPayType.length - 1] = aPayType3;
                }
            }
        }
        this.mListView.setAdapter((ListAdapter) new CustomAdapter(getApplicationContext(), arrayOfPayType));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View paramView) {
        if (paramView == this.mBtnPay) {
            this.mBtnPay.setEnabled(false);
            buildUPointPayLoginView();
            return;
        }
        switch (paramView.getId()) {
            case 3:
                break;
            case 4:
                buildPaymentView();
                return;
            case 5:
                if (this.mConfirmSmsInfoString != null && this.mConfirmSmsInfoString.contains(TERM)) {
                    sendConfirmSms(this.mConfirmSmsInfoString);
                    return;
                }
                return;
            case 6:
                showDialog(23);
                return;
            case 7:
                ((Button) paramView).setEnabled(false);
                String usernamestr = this.mEtUsername.getText().toString();
                String pwdstr = this.mEtPassword.getText().toString();
                if (TextUtils.isEmpty(usernamestr) && TextUtils.isEmpty(pwdstr)) {
                    showDialog(DIALOG_PASSWORD_OR_USERNAME_IS_EMPTY);
                    return;
                }
                if (TextUtils.isEmpty(pwdstr)) {
                    showDialog(DIALOG_PASSWORD_IS_EMPTY);
                    return;
                } else if (TextUtils.isEmpty(usernamestr)) {
                    showDialog(DIALOG_USERNAME_IS_EMPTY);
                    return;
                } else {
                    this.mUPayInfo = new UPointPayInfo(usernamestr, pwdstr, "", this.mPaymentInfo.getCpID(), this.mPaymentInfo.getmGameID(), this.mPaymentInfo.getMoney(), "");
                    pay();
                    return;
                }
            case 8:
                ((Button) paramView).setEnabled(false);
                String paypassstr = this.mEtPayPass.getText().toString();
                if (TextUtils.isEmpty(paypassstr)) {
                    showDialog(DIALOG_PASSWORD_OR_USERNAME_IS_EMPTY);
                    break;
                } else {
                    this.mUPayInfo.setPaypwd(paypassstr);
                    pay();
                    break;
                }
            case 9:
                switch (this.mType) {
                    case 0:
                        finish();
                        return;
                    case 1:
                        buildPaymentView();
                        return;
                    case 2:
                        buildUPointPaymentView();
                        return;
                    case 3:
                        buildUPointPayLoginView();
                        return;
                    case 4:
                        if (!this.mSmsInfo.isNeedconfirm() && !this.mIsShowInfo) {
                            int totalToPay = Utils.getSmsPayment();
                            int totalSMS = totalToPay / this.mSmsInfo.money;
                            if (this.mLeftSmsToSendCount != -1 && this.mLeftSmsToSendCount != totalSMS) {
                                showDialog(DIALOG_PAY_SMS_RETRY_MULTIPLE);
                                return;
                            } else {
                                buildSmsPaymentView();
                                return;
                            }
                        }
                        buildPaymentView();
                        return;
                    case 5:
                        showDialog(23);
                        return;
                    default:
                        return;
                }
            case 10:
                switch (this.mType) {
                    case 4:
                        if (this.mSmsInfo.isNeedconfirm() || this.mIsShowInfo) {
                            int i = Utils.getSmsPayment();
                            int j = i / this.mSmsInfo.money;
                            if (this.mLeftSmsToSendCount != -1 && this.mLeftSmsToSendCount != j) {
                                showDialog(DIALOG_PAY_SMS_RETRY_MULTIPLE);
                                return;
                            } else {
                                buildPaymentView();
                                return;
                            }
                        }
                        return;
                    case 5:
                        showDialog(23);
                        return;
                    default:
                        finish();
                        return;
                }
            default:
                return;
        }
        if (this.mIsShowInfo) {
            buildSmsPaymentView();
            this.mIsShowInfo = false;
        } else if (this.mSmsInfo != null) {
            registerReceiver(this.mSmsReceiver, new IntentFilter(SmsInfo.ACTION_SMS_SENT));
            sendFirstSms(this.mSmsInfo);
        }
    }

    private void sendFirstSms(SmsInfo paramSmsInfo) {
        showDialog(17);
        try {
            paramSmsInfo.sendFirstSms(getApplicationContext());
        } catch (Exception e) {
            if (this.mSmsHander != null && this.mSmsRunnable != null) {
                this.mSmsHander.removeCallbacks(this.mSmsRunnable);
                getContentResolver().unregisterContentObserver(this.mSmsContent);
                try {
                    unregisterReceiver(this.mSmsReceiver);
                } catch (IllegalArgumentException e2) {
                }
            }
            removeDialog(17);
            showDialog(DIALOG_SMS_FAIL);
        }
    }

    private void sendConfirmSms(String paramString) {
        showDialog(17);
        try {
            SmsInfo.sendSms(getApplicationContext(), paramString.split(TERM)[0], paramString.split(TERM)[1]);
        } catch (Exception e) {
            if (this.mSmsHander != null && this.mSmsRunnable != null) {
                this.mSmsHander.removeCallbacks(this.mSmsRunnable);
                getContentResolver().unregisterContentObserver(this.mSmsContent);
                try {
                    unregisterReceiver(this.mSmsReceiver);
                } catch (IllegalArgumentException e2) {
                }
            }
            removeDialog(17);
            showDialog(DIALOG_SMS_FAIL);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:1:0x0000. Please report as an issue. */
    @Override // com.uc.paymentsdk.util.DialogUtil.WarningDialogListener
    public void onWarningDialogOK(int paramInt) {
        switch (paramInt) {
            case 0:
            case 1:
            case 22:
                finish();
                return;
            case 10:
                pay();
                return;
            case 13:
                Intent localIntent = new Intent();
                setResult(-1, localIntent);
                finish();
                return;
            case 15:
            case 16:
            case 24:
                buildPaymentView();
                return;
            case 20:
                PrefUtil.clearPayedAmount(getApplicationContext());
                Intent localIntent2 = new Intent();
                setResult(-1, localIntent2);
                finish();
                return;
            case 21:
            case DIALOG_PAY_SMS_DELETE_BACK_CONFIRM /* 25 */:
                if (this.mSmsHander != null && this.mSmsRunnable != null) {
                    this.mSmsHander.removeCallbacks(this.mSmsRunnable);
                }
                if (this.mSmsContent != null) {
                    getContentResolver().unregisterContentObserver(this.mSmsContent);
                }
                try {
                    unregisterReceiver(this.mSmsReceiver);
                } catch (IllegalArgumentException e) {
                }
                buildPaymentView();
                return;
            case 23:
                showDialog(24);
                return;
            case 26:
                if (4 == this.mType) {
                    sendFirstSms(this.mSmsInfo);
                    return;
                } else {
                    sendConfirmSms(this.mConfirmSmsInfoString);
                    return;
                }
            case 36:
                pay();
                return;
            default:
                return;
        }
    }

    @Override // com.uc.paymentsdk.util.DialogUtil.WarningDialogListener
    public void onWarningDialogCancel(int paramInt) {
        switch (paramInt) {
            case 23:
            case 26:
            default:
                return;
            case 24:
            case DIALOG_PAY_SMS_DELETE_BACK_CONFIRM /* 25 */:
                if (this.mSmsHander != null && this.mSmsRunnable != null) {
                    this.mSmsHander.removeCallbacks(this.mSmsRunnable);
                    getContentResolver().unregisterContentObserver(this.mSmsContent);
                    try {
                        unregisterReceiver(this.mSmsReceiver);
                    } catch (IllegalArgumentException e) {
                    }
                }
                finish();
                return;
            case DIALOG_PAY_SMS_RETRY_MULTIPLE /* 27 */:
                if (this.mSmsHander != null && this.mSmsRunnable != null) {
                    this.mSmsHander.removeCallbacks(this.mSmsRunnable);
                    getContentResolver().unregisterContentObserver(this.mSmsContent);
                    try {
                        unregisterReceiver(this.mSmsReceiver);
                    } catch (IllegalArgumentException e2) {
                    }
                }
                buildPaymentView();
                return;
        }
    }

    private void pay() {
        showDialog(6);
        Api.pay(getApplicationContext(), this, this.mPaymentInfo, this.mUPayInfo);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
        super.onActivityResult(paramInt1, paramInt2, paramIntent);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        if (this.mIsValid) {
            PrefUtil.logout(getApplicationContext());
            Utils.clearSmsInfos();
            Utils.clearUPointInfo();
            TypeFactory.clear();
            Utils.clearUPointPayInfo();
            SyncChargeChannelHandler.init();
            SyncPayChannelHandler.init();
            SyncSmsInfoHandler.init();
        }
    }

    public static void init(Context paramContext) {
        SyncChargeChannelHandler.init();
        SyncPayChannelHandler.init();
        SyncSmsInfoHandler.init();
    }

    @Override // com.uc.paymentsdk.network.ApiTask.TaskHandler
    public void onSuccess(int paramInt, Object paramObject) {
        switch (paramInt) {
            case 3:
                String resultstr = (String) paramObject;
                String[] resultarr = resultstr.split("#");
                int returncodeint = Integer.parseInt(resultarr[0]);
                String errormsg = resultarr[1];
                removeDialog(6);
                if (returncodeint == -110) {
                    showDialog(7);
                    this.mUPayInfo.updateConsumeId();
                    return;
                }
                if (returncodeint == -102 && errormsg.equals("uc_tm_modify")) {
                    String timestr = resultarr[2];
                    this.mUPayInfo.setTm(timestr);
                    showDialog(36);
                    return;
                }
                if (returncodeint < 0) {
                    if (returncodeint == -102) {
                        if (errormsg.equals("uc_password_error")) {
                            showDialog(DIALOG_ACCOUNT_WRONG);
                            return;
                        }
                        if (errormsg.equals("um_account_error")) {
                            showDialog(5);
                            return;
                        }
                        if (errormsg.equals("um_paypwd_error")) {
                            showDialog(DIALOG_UPOINT_PAYPASS_WRONG);
                            return;
                        }
                        if (errormsg.equals("um_paypwd_error")) {
                            if (this.mType == 3) {
                                showDialog(7);
                                return;
                            }
                            if (this.mEtSavePass.isChecked()) {
                                PrefUtil.setUCUserName(getApplicationContext(), this.mEtUsername.getText().toString());
                                PrefUtil.setUCUserPass(getApplicationContext(), this.mEtPassword.getText().toString());
                            } else {
                                PrefUtil.clearUCUserName(getApplicationContext());
                                PrefUtil.clearUCUserPass(getApplicationContext());
                            }
                            buildUPointPayPassView();
                            return;
                        }
                        if (errormsg.equals("um_system_error")) {
                            showDialog(7);
                            this.mUPayInfo.updateConsumeId();
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (this.mEtSavePass.isChecked()) {
                    PrefUtil.setUCUserName(getApplicationContext(), this.mEtUsername.getText().toString());
                    PrefUtil.setUCUserPass(getApplicationContext(), this.mEtPassword.getText().toString());
                } else {
                    PrefUtil.clearUCUserName(getApplicationContext());
                    PrefUtil.clearUCUserPass(getApplicationContext());
                }
                showDialog(13);
                return;
            case 18:
                UPointInfo info = (UPointInfo) paramObject;
                initUPointPayView(info);
                Utils.setUPointInfo(info);
                dismissDialog(14);
                return;
            default:
                return;
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x001a. Please report as an issue. */
    @Override // com.uc.paymentsdk.network.ApiTask.TaskHandler
    public Object onPreHandle(int paramInt, HttpResponse paramHttpResponse) {
        if (5 == paramInt || 8 == paramInt) {
            return true;
        }
        String str = Utils.getBodyString(paramInt, paramHttpResponse);
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        switch (paramInt) {
            case 3:
                try {
                    return XMLParser.parsePayOrder(str);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            case 18:
                try {
                    return XMLParser.parseUPointInfo(str);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            default:
                return null;
        }
    }

    @Override // com.uc.paymentsdk.network.ApiTask.TaskHandler
    public void onError(int paramInt1, int paramInt2) {
        switch (paramInt1) {
            case 3:
                switch (paramInt2) {
                    case -1:
                        this.mTimeoutCounter++;
                        if (this.mTimeoutCounter < 2) {
                            Api.pay(getApplicationContext(), this, this.mPaymentInfo, this.mUPayInfo);
                            return;
                        }
                        this.mTimeoutCounter = 0;
                        this.mBtnPay.setEnabled(true);
                        removeDialog(6);
                        showDialog(10);
                        return;
                    case Constants.ERROR_CODE_INSUFFICIENT_BALANCE /* 219 */:
                        this.mBtnPay.setEnabled(false);
                        removeDialog(6);
                        showDialog(5);
                        buildPaymentView();
                        return;
                    case Constants.ERROR_CODE_ARG_OUT_OF_SCROPE /* 425 */:
                        this.mBtnPay.setEnabled(true);
                        removeDialog(6);
                        showDialog(8);
                        return;
                    case Constants.ERROR_CODE_UNKNOWN /* 500 */:
                        this.mBtnPay.setEnabled(true);
                        removeDialog(6);
                        showDialog(11);
                        return;
                    default:
                        this.mBtnPay.setEnabled(true);
                        removeDialog(6);
                        showDialog(7);
                        return;
                }
            case 18:
                dismissDialog(14);
                showDialog(15);
                buildPaymentView();
                return;
            default:
                return;
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {
        if (paramInt != 0) {
            IType localIType = ((CustomAdapter) ((HeaderViewListAdapter) paramAdapterView.getAdapter()).getWrappedAdapter()).getItem(paramInt - 1);
            String str = localIType.getId();
            if (TypeFactory.TYPE_PAY_UPOINT.equals(str)) {
                buildUPointPaymentView();
            } else if ("sms".equals(str)) {
                buildSmsPaymentView();
            }
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0001. Please report as an issue. */
    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent) {
        switch (paramInt) {
            case 4:
                switch (this.mType) {
                    case 1:
                        buildPaymentView();
                        return true;
                    case 2:
                        buildUPointPaymentView();
                        return true;
                    case 3:
                        buildUPointPayLoginView();
                        return true;
                    case 4:
                        if (this.mSmsInfo.isNeedconfirm() || this.mIsShowInfo) {
                            int i = Utils.getSmsPayment();
                            int j = i / this.mSmsInfo.money;
                            if (this.mLeftSmsToSendCount != -1 && this.mLeftSmsToSendCount != j) {
                                showDialog(DIALOG_PAY_SMS_RETRY_MULTIPLE);
                            } else {
                                buildPaymentView();
                            }
                        } else {
                            buildPaymentView();
                        }
                        return true;
                    case 5:
                        showDialog(23);
                        return true;
                }
            default:
                return super.onKeyDown(paramInt, paramKeyEvent);
        }
    }

    @Override // com.uc.paymentsdk.network.chain.Handler.OnFinishListener
    public void onFinish() {
        fillData();
    }

    /* loaded from: classes.dex */
    private class SmsContent extends ContentObserver {
        private static final String BODY = "body";
        private static final String NUMBER = "address";
        private Cursor mCursor;

        public SmsContent(android.os.Handler arg2) {
            super(arg2);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean paramBoolean) {
            super.onChange(paramBoolean);
            Uri localUri = Uri.parse("content://sms/inbox");
            this.mCursor = PaymentsActivity.this.managedQuery(localUri, new String[]{"_id", NUMBER, BODY}, " address like ? or address like ? and read=?", new String[]{String.valueOf(PaymentsActivity.this.mSmsInfo.getSmsnumber()) + "%%", String.valueOf(PaymentsActivity.this.mSmsInfo.getSmsConfirmNumber()) + "%%", "0"}, "date desc");
            if (this.mCursor != null) {
                if (this.mCursor.moveToFirst()) {
                    if (PaymentsActivity.this.mSmsId <= 0 || PaymentsActivity.this.mSmsId <= this.mCursor.getInt(0)) {
                        if (PaymentsActivity.this.mLeftSmsToReceiveCount <= 1) {
                            PaymentsActivity.this.mSmsHander.removeCallbacks(PaymentsActivity.this.mSmsRunnable);
                            PaymentsActivity.this.getContentResolver().unregisterContentObserver(PaymentsActivity.this.mSmsContent);
                            try {
                                PaymentsActivity.this.unregisterReceiver(PaymentsActivity.this.mSmsReceiver);
                            } catch (IllegalArgumentException e) {
                            }
                        }
                        PaymentsActivity.this.mSmsId = this.mCursor.getInt(0);
                        ContentValues localContentValues = new ContentValues();
                        localContentValues.put("read", "1");
                        try {
                            PaymentsActivity.this.getContentResolver().update(localUri, localContentValues, " _id=?", new String[]{new StringBuilder().append(PaymentsActivity.this.mSmsId).toString()});
                        } catch (SQLiteAbortException localSQLiteAbortException) {
                            localSQLiteAbortException.printStackTrace();
                        }
                        String smscontent = this.mCursor.getString(this.mCursor.getColumnIndex(BODY));
                        String smsaddress = this.mCursor.getString(this.mCursor.getColumnIndex(NUMBER));
                        if (4 == PaymentsActivity.this.mType) {
                            if (PaymentsActivity.this.mSmsInfo.isNeedconfirm()) {
                                PaymentsActivity.this.removeDialog(17);
                                String smsconfirmnumber = PaymentsActivity.this.mSmsInfo.parseConfirmSmsConfirmNumber(smscontent);
                                if (PaymentsActivity.this.mSmsInfo.isSuccess(smscontent) && smsconfirmnumber != null) {
                                    PaymentsActivity.this.mSmsHander.removeCallbacks(PaymentsActivity.this.mSmsRunnable);
                                    PaymentsActivity.this.buildSmsPaymentConfirmView(smsaddress, smsconfirmnumber);
                                } else {
                                    PaymentsActivity.this.removeDialog(17);
                                    PaymentsActivity.this.mSmsResultInfo = Constants.TEXT_PAY_SMS_FAILED_INSUFFENT_BALANCE;
                                    PaymentsActivity.this.showDialog(21);
                                }
                            } else {
                                PrefUtil.setPayedAmount(PaymentsActivity.this.getApplicationContext(), PaymentsActivity.this.getPayedAmount());
                                if (PaymentsActivity.this.mLeftSmsToReceiveCount <= 1) {
                                    if (PaymentsActivity.this.mLeftSmsToReceiveCount <= 1) {
                                        PaymentsActivity.this.removeDialog(17);
                                    }
                                    PaymentsActivity.this.mSmsResultInfo = "支付已完成，祝您玩得开心。";
                                    PaymentsActivity.this.showDialog(20);
                                } else {
                                    PaymentsActivity.this.mLeftSmsToReceiveCount--;
                                }
                                if (PaymentsActivity.this.mSmsInfo.getSmstype() == 1) {
                                    Api.postSmsPayment(PaymentsActivity.this.getApplicationContext(), PaymentsActivity.this, PaymentsActivity.this.mPaymentInfo.getCpID(), PaymentsActivity.this.mPaymentInfo.getmGameID(), PaymentsActivity.this.mPaymentInfo.getmActionID(), Utils.getSmsPayment(), PaymentsActivity.this.mPaymentInfo.getmActionID(), PaymentsActivity.this.mSmsInfo.getSmschannelid(), PaymentsActivity.this.mSmsInfo.getSmsnumber(), PaymentsActivity.this.mSmsInfo.getContent(), PaymentsActivity.this.mSmsInfo.getSmstype());
                                }
                            }
                        } else {
                            PaymentsActivity.this.removeDialog(17);
                            boolean bool = PaymentsActivity.this.mSmsInfo.parseConfirmResultSms(smscontent);
                            if (!bool) {
                                PaymentsActivity.this.mSmsResultInfo = smscontent;
                                PaymentsActivity.this.showDialog(21);
                            } else {
                                PrefUtil.setPayedAmount(PaymentsActivity.this.getApplicationContext(), PaymentsActivity.this.getPayedAmount());
                                if (PaymentsActivity.this.mLeftSmsToReceiveCount <= 1) {
                                    PaymentsActivity.this.mSmsResultInfo = smscontent.replace(Constants.SMS_SUCCESS, Constants_H.MONEY_TXT_18);
                                    PaymentsActivity.this.showDialog(20);
                                } else {
                                    PaymentsActivity.this.mLeftSmsToReceiveCount--;
                                    PaymentsActivity.this.mLeftSmsToSendCount--;
                                    PaymentsActivity.this.mSmsHander.removeCallbacks(PaymentsActivity.this.mSmsRunnable);
                                    PaymentsActivity.this.removeDialog(17);
                                    PaymentsActivity.this.buildSmsPaymentView();
                                }
                                if (PaymentsActivity.this.mSmsInfo.getSmstype() == 1) {
                                    Api.postSmsPayment(PaymentsActivity.this.getApplicationContext(), PaymentsActivity.this, PaymentsActivity.this.mPaymentInfo.getCpID(), PaymentsActivity.this.mPaymentInfo.getmGameID(), PaymentsActivity.this.mPaymentInfo.getmActionID(), Utils.getSmsPayment(), PaymentsActivity.this.mPaymentInfo.getmActionID(), PaymentsActivity.this.mSmsInfo.getSmschannelid(), PaymentsActivity.this.mSmsInfo.getSmsnumber(), PaymentsActivity.this.mSmsInfo.getContent(), PaymentsActivity.this.mSmsInfo.getSmstype());
                                }
                            }
                        }
                    } else {
                        this.mCursor.close();
                        return;
                    }
                }
                this.mCursor.close();
            }
        }
    }
}
