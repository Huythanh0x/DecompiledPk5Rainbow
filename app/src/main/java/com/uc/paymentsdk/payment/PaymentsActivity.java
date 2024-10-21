package com.uc.paymentsdk.payment.PaymentsActivity;
import android.view.View$OnClickListener;
import com.uc.paymentsdk.network.ApiTask$TaskHandler;
import android.widget.AdapterView$OnItemClickListener;
import com.uc.paymentsdk.util.DialogUtil$WarningDialogListener;
import com.uc.paymentsdk.network.chain.Handler$OnFinishListener;
import android.app.Activity;
import com.uc.paymentsdk.payment.PaymentsActivity$1;
import com.uc.paymentsdk.payment.PaymentsActivity$2;
import com.uc.paymentsdk.payment.sms.SmsInfo;
import android.database.ContentObserver;
import android.os.Handler;
import java.lang.Runnable;
import android.widget.TextView;
import android.widget.Button;
import android.widget.RelativeLayout;
import java.lang.String;
import android.content.BroadcastReceiver;
import com.uc.paymentsdk.payment.PaymentInfo;
import android.content.Context;
import com.uc.paymentsdk.util.Utils;
import android.graphics.Color;
import java.lang.CharSequence;
import java.lang.Object;
import java.text.DecimalFormat;
import android.widget.LinearLayout;
import android.widget.LinearLayout$LayoutParams;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.widget.ListView;
import com.uc.paymentsdk.network.chain.HandlerProxy;
import android.widget.RelativeLayout$LayoutParams;
import java.lang.Integer;
import android.text.util.Linkify;
import java.lang.StringBuilder;
import com.uc.paymentsdk.payment.sms.SimCardNotSupportException;
import com.uc.paymentsdk.util.PrefUtil;
import com.uc.paymentsdk.network.chain.SyncSmsInfoHandler;
import com.uc.paymentsdk.payment.PaymentsActivity$3;
import android.graphics.drawable.Drawable;
import android.app.Application;
import android.widget.EditText;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.widget.CheckBox;
import android.widget.ScrollView;
import com.uc.paymentsdk.payment.upoint.UPointInfo;
import com.uc.paymentsdk.network.Api;
import java.util.ArrayList;
import com.uc.paymentsdk.model.IType;
import java.util.Iterator;
import com.uc.paymentsdk.commons.ui.CustomAdapter;
import android.widget.ListAdapter;
import com.uc.paymentsdk.network.chain.SyncChargeChannelHandler;
import com.uc.paymentsdk.network.chain.SyncPayChannelHandler;
import android.content.Intent;
import java.io.Serializable;
import java.lang.IllegalArgumentException;
import java.util.regex.Pattern;
import com.uc.paymentsdk.payment.sms.SmsInfos;
import android.text.Spanned;
import android.text.Html;
import com.uc.paymentsdk.payment.upoint.UPointPayInfo;
import android.content.ContentResolver;
import android.text.Editable;
import android.text.TextUtils;
import android.content.IntentFilter;
import android.os.Bundle;
import android.app.Dialog;
import com.uc.paymentsdk.util.DialogUtil;
import com.uc.paymentsdk.util.DialogUtil$ProgressDialogListener;
import com.uc.paymentsdk.model.TypeFactory;
import android.widget.AdapterView;
import android.widget.Adapter;
import android.widget.HeaderViewListAdapter;
import android.view.KeyEvent;
import org.apache.http.HttpResponse;
import java.lang.Boolean;
import com.uc.paymentsdk.network.XMLParser;
import java.lang.Exception;

public class PaymentsActivity extends Activity implements View$OnClickListener, ApiTask$TaskHandler, AdapterView$OnItemClickListener, DialogUtil$WarningDialogListener, Handler$OnFinishListener	// class@0000b5 from classes.dex
{
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
    private static final long PAY_SMS_TIMEOUT = 0xea60;
    private static final int RETRY_MAX = 2;
    private static final String TERM = ",,,,";
    private static final int TYPE_PAYMENT_LIST = 0;
    private static final int TYPE_PAYMENT_SMS = 4;
    private static final int TYPE_PAYMENT_SMS_CONFIRM = 5;
    private static final int TYPE_PAYMENT_UPOINT_DISCOUNT = 1;
    private static final int TYPE_PAYMENT_UPOINT_LOGIN = 2;
    private static final int TYPE_PAYMENT_UPOINT_PAYPASS = 3;

    public void PaymentsActivity(){
       super();
       this.mSmsReceiver = new PaymentsActivity$1(this);
       this.mSmsRunnable = new PaymentsActivity$2(this);
    }
    static int access$0(PaymentsActivity p0){
       return p0.mType;
    }
    static SmsInfo access$1(PaymentsActivity p0){
       return p0.mSmsInfo;
    }
    static ContentObserver access$10(PaymentsActivity p0){
       return p0.mSmsContent;
    }
    static int access$11(PaymentsActivity p0){
       return p0.mSmsId;
    }
    static int access$12(PaymentsActivity p0){
       return p0.mLeftSmsToReceiveCount;
    }
    static Handler access$13(PaymentsActivity p0){
       return p0.mSmsHander;
    }
    static Runnable access$14(PaymentsActivity p0){
       return p0.mSmsRunnable;
    }
    static void access$15(PaymentsActivity p0,int p1){
       p0.mSmsId = p1;
    }
    static void access$16(PaymentsActivity p0,int p1){
       p0.mLeftSmsToReceiveCount = p1;
    }
    static void access$17(PaymentsActivity p0,boolean p1){
       p0.mIsSynced = p1;
    }
    static void access$18(PaymentsActivity p0,TextView p1,TextView p2,int p3,Button p4,Button p5,RelativeLayout p6){
       p0.initSmsPayView(p1, p2, p3, p4, p5, p6);
    }
    static void access$2(PaymentsActivity p0,String p1,String p2){
       p0.buildSmsPaymentConfirmView(p1, p2);
    }
    static int access$3(PaymentsActivity p0){
       return p0.mLeftSmsToSendCount;
    }
    static void access$4(PaymentsActivity p0,int p1){
       p0.mLeftSmsToSendCount = p1;
    }
    static int access$5(PaymentsActivity p0){
       return p0.getPayedAmount();
    }
    static void access$6(PaymentsActivity p0){
       p0.buildSmsPaymentView();
    }
    static BroadcastReceiver access$7(PaymentsActivity p0){
       return p0.mSmsReceiver;
    }
    static void access$8(PaymentsActivity p0,String p1){
       p0.mSmsResultInfo = p1;
    }
    static PaymentInfo access$9(PaymentsActivity p0){
       return p0.mPaymentInfo;
    }
    private void buildPaymentView(){
       this.mType = 0;
       this.mTimeoutCounter = 0;
       this.mLeftSmsToReceiveCount = -1;
       this.mLeftSmsToSendCount = -1;
       this.mIsSynced = false;
       this.mIsShowInfo = false;
       this.mSmsHander = null;
       this.mSmsContent = null;
       RelativeLayout paytitle = Utils.initSubTitle(this.getApplicationContext(), this, "\x8d\x02\x4e\x02\x51\x02\x5b\x02", 0);
       TextView payContentTextView = new TextView(this.getApplicationContext());
       payContentTextView.setTextSize(16.00f);
       payContentTextView.setTextColor(Color.parseColor("#FF858D8D"));
       payContentTextView.setPadding(10, 10, 0, 10);
       payContentTextView.setText("\x5c\x02\x65\x02\x76\x02\x75\x02\x62\x02\xff\x02\x60\x02\x97\x02\x89\x02\x4e\x02\x4e\x02\x4e\x02\x51\x02\x5b\x02\x65\x02\x4e\x02\x8d\x02\x75\x02\xff\x02\x8b\x02\x96\x02\x8b\x02\x4e\x02\x4e\x02\x4f\x02\x60\x02\xff\x02\x78\x02\x8b\x02\x62\x02\x8d\x02\x51\x02\x5b\x02\x65\x02\x8b\x02\x30\x02");
       TextView payContentDetailTextView = new TextView(this.getApplicationContext());
       payContentDetailTextView.setTextSize(16.00f);
       payContentDetailTextView.setPadding(20, 0, 20, 0);
       Object[] objArray = new Object[]{this.mPaymentInfo.getPaydesc()};
       payContentDetailTextView.setText(String.format("\x62\x02\x8d\x02\x51\x02\x5b\x02 : %s", objArray));
       payContentDetailTextView.setTextColor(-12303292);
       String moneyStr = new DecimalFormat("##0.00").format((double)((float)this.mPaymentInfo.getMoney() / 10.00f));
       TextView payCountTextView = new TextView(this.getApplicationContext());
       payCountTextView.setTextSize(16.00f);
       payCountTextView.setPadding(20, 0, 0, 20);
       objArray = new Object[]{moneyStr};
       payCountTextView.setText(String.format("\x65\x02\x4e\x02\x91\x02\x98\x02: %s\x51\x02", objArray));
       payCountTextView.setTextColor(-12303292);
       LinearLayout linearLayout = new LinearLayout(this.getApplicationContext());
       linearLayout.setBackgroundColor(-1);
       linearLayout.setOrientation(1);
       LinearLayout$LayoutParams localLayoutParams = new LinearLayout$LayoutParams(-1, -2);
       linearLayout.addView(paytitle, localLayoutParams);
       linearLayout.addView(payContentTextView, localLayoutParams);
       linearLayout.addView(payContentDetailTextView, localLayoutParams);
       linearLayout.addView(payCountTextView, localLayoutParams);
       this.mListView = new ListView(this.getApplicationContext());
       this.mListView.setBackgroundColor(-1);
       this.mListView.setCacheColorHint(-1);
       this.mListView.addHeaderView(linearLayout, null, 1);
       this.mListView.setOnItemClickListener(this);
       this.mListView.addFooterView(Utils.generateFooterView(this), null, 0);
       this.setContentView(this.mListView);
       this.fillData();
       new HandlerProxy(this.getApplicationContext(), this).handleRequest();
    }
    private void buildSmsPaymentConfirmView(String smsaddress,String smsconfirmnumber){
       this.mType = 5;
       try{
          Utils.CheckSimCardSupprotInfo(this.getApplicationContext());
          RelativeLayout localRelativeLayout = new RelativeLayout(this.getApplicationContext());
          localRelativeLayout.setBackgroundColor(-1);
          localRelativeLayout.setLayoutParams(new ViewGroup$LayoutParams(-1, -1));
          RelativeLayout title = Utils.initSubTitle(this.getApplicationContext(), this, "\x8d\x02\x4e\x02\x51\x02\x5b\x02", true);
          title.setId(1);
          title.setLayoutParams(new RelativeLayout$LayoutParams(-1, -2));
          localRelativeLayout.addView(title);
          TextView localTextView2 = new TextView(this);
          localTextView2.setId(2);
          localTextView2.setTextSize(16.00f);
          localTextView2.setTextColor(-13487566);
          localTextView2.setPadding(10, 10, 0, 0);
          localTextView2.setFocusable(true);
          localTextView2.setClickable(true);
          localTextView2.setLinkTextColor(-24576);
          Object[] objArray = new Object[]{smsaddress,this.mPaymentInfo.getPayname(),Integer.valueOf(Utils.getSmsPayment())};
          localTextView2.setText(String.format("\x51\x02\x6b\x02\x70\x02\x51\x02\x4e\x02\x4e\x02\x6b\x02\x53\x02\x54\x02\x61\x02\x54\x02\n%s\x53\x02\x90\x02\x77\x02\x4f\x02\x4e\x02\x5b\x02\x62\x02\x67\x02\x6b\x02\x77\x02\x4f\x02\x53\x02\x90\x02\x8f\x02\x7a\x02\x30\x02", objArray));
          Linkify.addLinks(localTextView2, 4);
          RelativeLayout$LayoutParams localLayoutParams1 = new RelativeLayout$LayoutParams(-1, -2);
          localLayoutParams1.addRule(3, 1);
          localTextView2.setLayoutParams(localLayoutParams1);
          localRelativeLayout.addView(localTextView2);
          Button localButton1 = new Button(this.getApplicationContext());
          localButton1.setText("\x4e\x02\x4e\x02\x6b\x02");
          localButton1.setId(5);
          this.mConfirmSmsInfoString = String.valueOf(smsaddress)+",,,,"+smsconfirmnumber;
          localButton1.setTag(this.mConfirmSmsInfoString);
          localButton1.setOnClickListener(this);
          RelativeLayout$LayoutParams localLayoutParams2 = new RelativeLayout$LayoutParams(150, -2);
          localLayoutParams2.addRule(12, -1);
          localLayoutParams2.setMargins(10, 20, 10, 10);
          localButton1.setLayoutParams(localLayoutParams2);
          localRelativeLayout.addView(localButton1);
          Button localButton2 = new Button(this.getApplicationContext());
          localButton2.setText("\x53\x02\x6d\x02");
          localButton2.setId(6);
          localButton2.setOnClickListener(this);
          RelativeLayout$LayoutParams localLayoutParams3 = new RelativeLayout$LayoutParams(150, -2);
          localLayoutParams3.addRule(11, -1);
          localLayoutParams3.addRule(12, -1);
          localLayoutParams3.setMargins(10, 20, 10, 10);
          localButton2.setLayoutParams(localLayoutParams3);
          localRelativeLayout.addView(localButton2);
          this.setContentView(localRelativeLayout);
       }catch(com.uc.paymentsdk.payment.sms.SimCardNotSupportException e9){
          SimCardNotSupportException localSimCardNotSupportException = e9;
          this.mSmsResultInfo = localSimCardNotSupportException.getMessage();
          this.showDialog(16);
       }
       return;
    }
    private void buildSmsPaymentView(){
       int smsPayCount;
       this.mType = 4;
       this.mSmsId = 0;
       RelativeLayout tableLayout = new RelativeLayout(this.getApplicationContext());
       tableLayout.setBackgroundColor(-1);
       tableLayout.setLayoutParams(new ViewGroup$LayoutParams(-1, -1));
       RelativeLayout title = Utils.initSubTitle(this.getApplicationContext(), this, "\x77\x02\x4f\x02\x65\x02\x4e\x02", false);
       title.setId(1);
       title.setLayoutParams(new RelativeLayout$LayoutParams(-1, -2));
       tableLayout.addView(title);
       TextView waitTextView = new TextView(this);
       waitTextView.setId(2);
       waitTextView.setTextSize(18.00f);
       waitTextView.setTextColor(-12303292);
       waitTextView.setPadding(10, 10, 0, 0);
       waitTextView.setFocusable(true);
       waitTextView.setClickable(true);
       waitTextView.setLinkTextColor(-24576);
       waitTextView.setText("\x5c\x02\x65\x02\x76\x02\x75\x02\x62\x02\xff\x02\x6b\x02\x57\x02\x83\x02\x53\x02\x4f\x02\x60\x02\xff\x02\x8b\x02\x7a\x02\x54\x02......");
       RelativeLayout$LayoutParams localLayoutParams1 = new RelativeLayout$LayoutParams(-1, -2);
       localLayoutParams1.addRule(3, 1);
       waitTextView.setLayoutParams(localLayoutParams1);
       tableLayout.addView(waitTextView);
       TextView beforeSendText = new TextView(this);
       beforeSendText.setId(3);
       beforeSendText.setTextSize(16.00f);
       beforeSendText.setTextColor(-7829368);
       beforeSendText.setPadding(10, 30, 0, 0);
       beforeSendText.setFocusable(true);
       beforeSendText.setClickable(true);
       beforeSendText.setLinkTextColor(-24576);
       RelativeLayout$LayoutParams localLayoutParams2 = new RelativeLayout$LayoutParams(-1, -2);
       localLayoutParams2.addRule(3, 2);
       beforeSendText.setLayoutParams(localLayoutParams2);
       tableLayout.addView(beforeSendText);
       Button submitBtn = new Button(this.getApplicationContext());
       submitBtn.setText("\x70\x02\x64\x02");
       submitBtn.setId(3);
       submitBtn.setOnClickListener(this);
       Button cancelButton = new Button(this.getApplicationContext());
       cancelButton.setText("\x53\x02\x6d\x02");
       cancelButton.setId(4);
       try{
          cancelButton.setOnClickListener(this);
          Utils.CheckSimCardSupprotInfo(this.getApplicationContext());
          if ((smsPayCount = Utils.getSmsPayment()) <= PrefUtil.getPayedAmount(this.getApplicationContext())) {
             this.mSmsResultInfo = "\x60\x02\x5d\x02\x65\x02\x4e\x02\x5b\x02\x62\x02\xff\x02\x5c\x02\x8f\x02\x56\x02\x60\x02\x76\x02\x6e\x02\x62\x02\x4e\x02\x30\x02";
             this.showDialog(20);
          }else if(this.mIsSynced == null){
             this.showDialog(19);
             localLayoutParams2 = this.getApplicationContext();
             new SyncSmsInfoHandler(localLayoutParams2, new PaymentsActivity$3(this, waitTextView, beforeSendText, smsPayCount, cancelButton, submitBtn, tableLayout)).handleRequest();
          }else {
             this.initSmsPayView(waitTextView, beforeSendText, smsPayCount, cancelButton, submitBtn, tableLayout);
          }
       }catch(com.uc.paymentsdk.payment.sms.SimCardNotSupportException e0){
          SimCardNotSupportException localSimCardNotSupportException = e0;
          this.mSmsResultInfo = localSimCardNotSupportException.getMessage();
          this.showDialog(16);
       }
       return;
    }
    private void buildUPointPayLoginView(){
       this.mType = 2;
       RelativeLayout title = Utils.initSubTitle(this.getApplicationContext(), this, "\x8b\x02\x60\x02\x8f\x02\x51\x02UC\x5e\x02\x53\x02", 1);
       title.setId(10);
       RelativeLayout$LayoutParams v21 = new RelativeLayout$LayoutParams(-1, -2);
       v21.addRule(10, -1);
       title.setLayoutParams(v21);
       TextView v16 = new TextView(this.getApplicationContext());
       v21 = new RelativeLayout$LayoutParams(-1, -2);
       v15.addRule(3, 10);
       v15.setMargins(10, 5, 10, 10);
       v16.setLayoutParams(v15);
       v16.setId(1);
       v16.setCompoundDrawablePadding(10);
       v16.setTextColor(-13487566);
       String str = (Utils.isHdpi())? "lock_hdpi.png": "lock.png";
       v16.setCompoundDrawablesWithIntrinsicBounds(Utils.getDrawableFromFile(str), 0, 0, 0);
       v16.setText("\x60\x02\x59\x02\xff\x02\x8d\x02\x4e\x02\x6b\x02\x51\x02\x5b\x02\xff\x02\x8b\x02\x51\x02\x76\x02\x5f\x02UC\x8d\x02\x53\x02\x30\x02\x60\x02\x53\x02\x4e\x02\x8f\x02\x51\x02UC\x5e\x02\x53\x02\x62\x02\x80\x02\x62\x02\x67\x02\x53\x02\x78\x02\x8f\x02\x88\x02\x76\x02\x5f\x02");
       TextView lineTextView = Utils.generateBorderView(this.getApplication());
       lineTextView.setId(11);
       v21 = new RelativeLayout$LayoutParams(-1, 1);
       v8.addRule(3, 1);
       lineTextView.setLayoutParams(v8);
       v21 = new RelativeLayout$LayoutParams(-1, -2);
       v6.setMargins(10, 10, 10, 5);
       v16 = new TextView(this.getApplicationContext());
       v5.setLayoutParams(v6);
       v5.setId(2);
       v5.setText("UC\x8d\x02\x53\x02:");
       v5.setTextColor(-13487566);
       v21 = new RelativeLayout$LayoutParams(-1, -2);
       v22.addRule(3, 2);
       v22.setMargins(10, 5, 10, 5);
       this.mEtUsername = new EditText(this.getApplicationContext());
       this.mEtUsername.setLayoutParams(v22);
       this.mEtUsername.setSingleLine();
       this.mEtUsername.setId(3);
       this.mEtUsername.setHint("\x75\x02\x62\x02\x54\x02");
       this.mEtPassword = new EditText(this.getApplicationContext());
       this.mEtPassword.setId(4);
       this.mEtPassword.setHint("\x5b\x02\x78\x02");
       this.mEtPassword.setSingleLine();
       this.mEtPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
       RelativeLayout$LayoutParams userpassParams = new RelativeLayout$LayoutParams(-1, -2);
       userpassParams.addRule(3, 3);
       userpassParams.setMargins(10, 5, 10, 5);
       this.mEtPassword.setLayoutParams(userpassParams);
       this.mEtSavePass = new CheckBox(this.getApplicationContext());
       v21 = new RelativeLayout$LayoutParams(-1, -2);
       v17.addRule(3, 4);
       v17.setMargins(10, 5, 10, 5);
       this.mEtSavePass.setId(5);
       this.mEtSavePass.setTextColor(-12303292);
       this.mEtSavePass.setText("\x4f\x02\x5b\x02\x5b\x02\x78\x02");
       this.mEtSavePass.setLayoutParams(v17);
       if (PrefUtil.getUCUserName(this.getApplicationContext()) != null) {
          this.mEtUsername.setText(PrefUtil.getUCUserName(this.getApplicationContext()));
          this.mEtSavePass.setChecked(true);
       }else {
          this.mEtSavePass.setChecked(false);
       }
       if (PrefUtil.getUCUserPass(this.getApplicationContext()) != null) {
          this.mEtPassword.setText(PrefUtil.getUCUserPass(this.getApplicationContext()));
       }
       Button v18 = new Button(this.getApplicationContext());
       v18.setId(7);
       v18.setText("\x78\x02\x5b\x02\x8d\x02\x4e\x02");
       v18.setOnClickListener(this);
       v21 = new RelativeLayout$LayoutParams(-1, -2);
       v19.topMargin = 10;
       v19.addRule(3, 5);
       v19.addRule(14);
       v18.setLayoutParams(v19);
       RelativeLayout v211 = new RelativeLayout(this.getApplicationContext());
       v7.setId(7);
       v7.setBackgroundColor(-984326);
       v21 = new RelativeLayout$LayoutParams(-1, -2);
       v11.addRule(3, 11);
       v7.setLayoutParams(v11);
       v7.addView(v5);
       v7.addView(this.mEtUsername);
       v7.addView(this.mEtPassword);
       v7.addView(this.mEtSavePass);
       v7.addView(v18);
       v211 = new RelativeLayout(this.getApplicationContext());
       v14.setBackgroundColor(-1);
       v14.setLayoutParams(new RelativeLayout$LayoutParams(-1, -1));
       v14.addView(title);
       v14.addView(v16);
       v14.addView(lineTextView);
       v14.addView(v7);
       TextView lineTextView1 = Utils.generateBorderView(this.getApplication());
       v21 = new RelativeLayout$LayoutParams(-1, 1);
       v12.addRule(3, 7);
       lineTextView1.setLayoutParams(v12);
       v14.addView(lineTextView1);
       ScrollView v212 = new ScrollView(this.getApplication());
       v13.setBackgroundColor(-1);
       v13.addView(v14);
       this.setContentView(v13);
       return;
    }
    private void buildUPointPayPassView(){
       this.mType = 3;
       RelativeLayout title = Utils.initSubTitle(this.getApplicationContext(), this, "\x8b\x02\x60\x02\x8f\x02\x51\x02U\x70\x02\x65\x02\x4e\x02\x5b\x02\x78\x02", 1);
       title.setId(10);
       RelativeLayout$LayoutParams v20 = new RelativeLayout$LayoutParams(-1, -2);
       v20.addRule(10, -1);
       title.setLayoutParams(v20);
       TextView v16 = new TextView(this.getApplicationContext());
       v20 = new RelativeLayout$LayoutParams(-1, -2);
       v15.addRule(3, 10);
       v15.setMargins(10, 5, 10, 10);
       v16.setLayoutParams(v15);
       v16.setId(1);
       v16.setCompoundDrawablePadding(10);
       v16.setTextColor(-13487566);
       String str = (Utils.isHdpi())? "lock_hdpi.png": "lock.png";
       v16.setCompoundDrawablesWithIntrinsicBounds(Utils.getDrawableFromFile(str), 0, 0, 0);
       v16.setText("\x60\x02\x59\x02\xff\x02\x60\x02\x76\x02U\x70\x02\x8b\x02\x7f\x02\x67\x02\x65\x02\x4e\x02\x5b\x02\x78\x02\xff\x02\x8b\x02\x65\x02\x51\x02\x54\x02\x70\x02\x51\x02\x78\x02\x8b\x02\x8f\x02\x88\x02\x65\x02\x4e\x02");
       TextView lineTextView = Utils.generateBorderView(this.getApplication());
       lineTextView.setId(11);
       v20 = new RelativeLayout$LayoutParams(-1, 1);
       v8.addRule(3, 1);
       lineTextView.setLayoutParams(v8);
       v20 = new RelativeLayout$LayoutParams(-1, -2);
       v6.setMargins(10, 10, 10, 5);
       v16 = new TextView(this.getApplicationContext());
       v5.setLayoutParams(v6);
       v5.setId(2);
       v5.setText("UC\x65\x02\x4e\x02\x5b\x02\x78\x02:");
       v5.setTextColor(-13487566);
       RelativeLayout$LayoutParams usernameParams = new RelativeLayout$LayoutParams(-1, -2);
       usernameParams.addRule(3, 2);
       usernameParams.setMargins(10, 5, 10, 5);
       this.mEtPayPass = new EditText(this.getApplicationContext());
       this.mEtPayPass.setLayoutParams(usernameParams);
       this.mEtPayPass.setSingleLine();
       this.mEtPayPass.setId(3);
       this.mEtPayPass.setHint("\x65\x02\x4e\x02\x5b\x02\x78\x02");
       Button v17 = new Button(this.getApplicationContext());
       v17.setId(7);
       v17.setText("\x78\x02\x5b\x02\x8d\x02\x4e\x02");
       v17.setOnClickListener(this);
       v20 = new RelativeLayout$LayoutParams(-1, -2);
       v18.topMargin = 10;
       v18.addRule(3, 5);
       v18.addRule(14);
       v17.setLayoutParams(v18);
       RelativeLayout v201 = new RelativeLayout(this.getApplicationContext());
       v7.setId(7);
       v7.setBackgroundColor(-984326);
       v20 = new RelativeLayout$LayoutParams(-1, -2);
       v11.addRule(3, 11);
       v7.setLayoutParams(v11);
       v7.addView(v5);
       v7.addView(this.mEtPayPass);
       v7.addView(v17);
       v201 = new RelativeLayout(this.getApplicationContext());
       v14.setBackgroundColor(-1);
       v14.setLayoutParams(new RelativeLayout$LayoutParams(-1, -1));
       v14.addView(title);
       v14.addView(v16);
       v14.addView(lineTextView);
       v14.addView(v7);
       TextView lineTextView1 = Utils.generateBorderView(this.getApplication());
       v20 = new RelativeLayout$LayoutParams(-1, 1);
       v12.addRule(3, 7);
       lineTextView1.setLayoutParams(v12);
       v14.addView(lineTextView1);
       ScrollView v202 = new ScrollView(this.getApplication());
       v13.setBackgroundColor(-1);
       v13.addView(v14);
       this.setContentView(v13);
       return;
    }
    private void buildUPointPaymentView(){
       this.mType = 1;
       TextView payTypeNameTextView = new TextView(this.getApplicationContext());
       payTypeNameTextView.setTextSize(16.00f);
       payTypeNameTextView.setPadding(20, 0, 20, 0);
       payTypeNameTextView.setTextColor(-12303292);
       Object[] objArray = new Object[]{this.mPaymentInfo.getPayname()};
       payTypeNameTextView.setText(String.format("\x65\x02\x4e\x02\x54\x02\x79\x02 : %s", objArray));
       this.mTvProduct = new TextView(this.getApplicationContext());
       this.mTvProduct.setTextSize(16.00f);
       this.mTvProduct.setPadding(20, 0, 20, 0);
       this.mTvProduct.setText("\x4e\x02\x54\x02\x54\x02 : ");
       this.mTvProduct.setTextColor(-12303292);
       TextView payContentTextView = new TextView(this.getApplicationContext());
       payContentTextView.setTextSize(16.00f);
       payContentTextView.setPadding(20, 0, 20, 20);
       objArray = new Object[]{this.mPaymentInfo.getPaydesc()};
       payContentTextView.setText(String.format("\x62\x02\x8d\x02\x51\x02\x5b\x02 : %s", objArray));
       payContentTextView.setTextColor(-12303292);
       TextView payCountTextView = new TextView(this.getApplicationContext());
       payCountTextView.setTextSize(16.00f);
       payCountTextView.setPadding(20, 0, 20, 0);
       objArray = new Object[]{Integer.valueOf(this.mPaymentInfo.getMoney()),new DecimalFormat("##0.00").format((double)((float)this.mPaymentInfo.getMoney() / 10.00f))};
       payCountTextView.setText(String.format("\x65\x02\x4e\x02\x65\x02\x98\x02 : %dU\x70\x02\xff\x02\x4e\x02\x50\x02%s\x51\x02\xff\x02", objArray));
       payCountTextView.setTextColor(-13487566);
       this.mTvDiscountTextView = new TextView(this.getApplicationContext());
       this.mTvDiscountTextView.setTextSize(16.00f);
       this.mTvDiscountTextView.setPadding(20, 0, 20, 0);
       this.mTvDiscountTextView.setText("U\x70\x02\x62\x02\x62\x02 : ");
       this.mTvDiscountTextView.setTextColor(-13487566);
       this.mTvVipDiscountTextView = new TextView(this.getApplicationContext());
       this.mTvVipDiscountTextView.setTextSize(16.00f);
       this.mTvVipDiscountTextView.setPadding(20, 0, 20, 0);
       this.mTvVipDiscountTextView.setText("\x4f\x02\x54\x02\x62\x02\x62\x02 : ");
       this.mTvVipDiscountTextView.setTextColor(-13487566);
       this.mTvVipDiscountTimeTextView = new TextView(this.getApplicationContext());
       this.mTvVipDiscountTimeTextView.setTextSize(16.00f);
       this.mTvVipDiscountTimeTextView.setPadding(20, 0, 20, 0);
       this.mTvVipDiscountTimeTextView.setText("\x4f\x02\x54\x02\x62\x02\x62\x02\x52\x02\x67\x02\x65\x02\x95\x02 : ");
       this.mTvVipDiscountInfo = new TextView(this.getApplicationContext());
       this.mTvVipDiscountInfo.setTextColor(-13487566);
       this.mTvVipDiscountInfo = new TextView(this.getApplicationContext());
       this.mTvVipDiscountInfo.setTextSize(16.00f);
       this.mTvVipDiscountInfo.setPadding(20, 0, 20, 0);
       this.mTvVipDiscountInfo.setText("\x4f\x02\x54\x02\x62\x02\x62\x02\x4f\x02\x60\x02 : ");
       this.mTvVipDiscountInfo.setTextColor(-13487566);
       this.mBtnPay = new Button(this.getApplicationContext());
       this.mBtnPay.setText("\x78\x02\x8b\x02");
       this.mBtnPay.setOnClickListener(this);
       this.mBtnPay.setVisibility(8);
       LinearLayout$LayoutParams localLayoutParams3 = new LinearLayout$LayoutParams(300, -2);
       localLayoutParams3.gravity = 1;
       LinearLayout localLinearLayout2 = new LinearLayout(this.getApplicationContext());
       localLinearLayout2.addView(this.mBtnPay, localLayoutParams3);
       localLinearLayout2.setGravity(1);
       LinearLayout localLinearLayout3 = new LinearLayout(this.getApplicationContext());
       localLinearLayout3.setOrientation(1);
       localLinearLayout3.setBackgroundColor(-1);
       LinearLayout$LayoutParams localLayoutParams4 = new LinearLayout$LayoutParams(-1, -2);
       localLinearLayout3.addView(Utils.initSubTitle(this.getApplicationContext(), this, "\x97\x02\x89\x02\x65\x02\x4e\x02\x76\x02\x51\x02\x5b\x02", true), localLayoutParams4);
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
       if (Utils.getUPointInfo() == null) {
          this.showDialog(14);
          Api.queryUPointDiscount(this.getApplicationContext(), this, Utils.getPaymentInfo().getCpID(), Utils.getPaymentInfo().getmGameID(), Utils.getPaymentInfo().getMoney());
       }else {
          this.initUPointPayView(Utils.getUPointInfo());
       }
       return;
    }
    private void fillData(){
       Iterator localIterator;
       IType iType;
       int i = 0;
       ArrayList arrayListofPayType = PrefUtil.getAvailablePayType(this.getApplicationContext(), this.mPaymentInfo.getPaytype());
       IType[] arrayOfPayType = new IType[arrayListofPayType.size()];
       if ("overage".equals(this.mPaymentInfo.getPaytype())) {
          localIterator = arrayListofPayType.iterator();
          while (localIterator.hasNext()) {
             iType = localIterator.next();
             if ("upoint".equals(iType.getId())) {
                arrayOfPayType[i] = iType;
                break ;
             }
          }
       }else if("sms".equals(this.mPaymentInfo.getPaytype())){
          localIterator = arrayListofPayType.iterator();
          while (localIterator.hasNext()) {
             iType = localIterator.next();
             if ("sms".equals(iType.getId())) {
                arrayOfPayType[i] = iType;
                break ;
             }
          }
       }else {
          localIterator = arrayListofPayType.iterator();
          while (localIterator.hasNext()) {
             iType = localIterator.next();
             if ("upoint".equals(iType.getId())) {
                arrayOfPayType[i] = iType;
             }else if("sms".equals(iType.getId())){
                int i1 = arrayOfPayType.length - 1;
                arrayOfPayType[i1] = iType;
             }
          }
       }
       this.mListView.setAdapter(new CustomAdapter(this.getApplicationContext(), arrayOfPayType));
       return;
    }
    private int getPayedAmount(){
       int i = Utils.getSmsPayment() - PrefUtil.getPayedAmount(this.getApplicationContext());
       int j = i / this.mSmsInfo.money;
       return (this.mSmsInfo.money * (j - this.mLeftSmsToSendCount));
    }
    public static void init(Context paramContext){
       SyncChargeChannelHandler.init();
       SyncPayChannelHandler.init();
       SyncSmsInfoHandler.init();
    }
    private boolean initPayment(){
       int i;
       int ix;
       this.mPaymentInfo = this.getIntent().getSerializableExtra("com.mappn.sdk.paymentinfo");
       if (this.mPaymentInfo == null) {
          throw new IllegalArgumentException("PaymentInfo\x5f\x02\x98\x02\x8b\x02\x7f\x02");
       }
       this.mPaymentInfo.setPaytype("sms");
       if ((i = this.mPaymentInfo.getMoney()) > 0 && (i <= 0x2710 && !((i % 5)))) {
          if (this.mPaymentInfo.getPayname() == null) {
             throw new IllegalArgumentException("\x5f\x02\x98\x02\x63\x02\x5b\x02\x65\x02\x4e\x02\x51\x02\x5b\x02\x54\x02\x79\x02");
          }else if(this.mPaymentInfo.getPaydesc() == null){
             throw new IllegalArgumentException("\x5f\x02\x98\x02\x63\x02\x5b\x02\x65\x02\x4e\x02\x51\x02\x5b\x02\x63\x02\x8f\x02");
          }else if(this.mPaymentInfo.getmGameID() == null){
             throw new IllegalArgumentException("\x5f\x02\x98\x02\x63\x02\x5b\x02\x6e\x02\x62\x02ID");
          }else if(this.mPaymentInfo.getmGameID().length() != 2){
             throw new IllegalArgumentException("\x6e\x02\x62\x02ID\x5f\x02\x98\x02\x4e\x02\x4e\x02\x4f\x02\x65\x02\x5b\x02");
          }else if(!Utils.isNumeric(this.mPaymentInfo.getmGameID())){
             throw new IllegalArgumentException("\x6e\x02\x62\x02ID\x5f\x02\x98\x02\x4e\x02\x4e\x02\x4f\x02\x65\x02\x5b\x02");
          }else if(this.mPaymentInfo.getmActionID() == null){
             throw new IllegalArgumentException("\x5f\x02\x98\x02\x63\x02\x5b\x02\x65\x02\x4e\x02\x70\x02ID");
          }else if(this.mPaymentInfo.getmActionID().length() != 2){
             throw new IllegalArgumentException("\x65\x02\x4e\x02\x70\x02ID\x5f\x02\x98\x02\x4e\x02\x4e\x02\x4f\x02\x65\x02\x5b\x02");
          }else if(!Utils.isNumeric(this.mPaymentInfo.getmActionID())){
             throw new IllegalArgumentException("\x65\x02\x4e\x02\x70\x02ID\x5f\x02\x98\x02\x4e\x02\x4e\x02\x4f\x02\x65\x02\x5b\x02");
          }else if(this.mPaymentInfo.getPayname().length() > 50){
             this.mPaymentInfo.setPayname(this.mPaymentInfo.getPayname().substring(0, 50));
          }
          if (this.mPaymentInfo.getPaydesc().length() > 100) {
             this.mPaymentInfo.setPaydesc(this.mPaymentInfo.getPaydesc().substring(0, 100));
          }
          try{
             String str = Utils.getCpID(this.getApplicationContext());
             if (!Pattern.matches("^[0-9a-zA-Z]{1,10}$", str)) {
                this.showDialog(22);
                ix = 0;
             }else {
                this.mPaymentInfo.setCpID(str);
             }
          }catch(android.content.pm.PackageManager$NameNotFoundException e4){
             PackageManager$NameNotFoundException localNameNotFoundException2 = e4;
             this.showDialog(22);
          }catch(java.lang.NullPointerException e4){
             NullPointerException localNullPointerException2 = e4;
             this.showDialog(22);
          }
          if (this.mPaymentInfo.getUsername() != null) {
             PrefUtil.setUCUserName(this.getApplicationContext(), this.mPaymentInfo.getUsername());
          }
          Utils.setPaymentInfo(this.mPaymentInfo);
          ix = true;
       }else {
          this.showDialog(0);
          ix = 0;
       }
       return ix;
    }
    private void initSmsPayView(TextView tvSmsMessage,TextView tvSmsText,int payMoney,Button cancelBtn,Button okBtn,RelativeLayout tableLayout){
       RelativeLayout$LayoutParams okBtnParams;
       int smsTotalToSendCount;
       Object[] objArray;
       int i = 150;
       int i1 = -2;
       try{
          okBtnParams = new RelativeLayout$LayoutParams(i, i1);
          int payedCount = PrefUtil.getPayedAmount(this.getApplicationContext());
          Spanned showtext = null;
          if (!payedCount) {
             if (this.mSmsInfo == null) {
                this.mSmsInfo = Utils.getSmsInfos().filterSmsInfo(this.getApplicationContext(), payMoney);
                this.mSmsInfo.setExtInfo(this.mPaymentInfo);
             }
             smsTotalToSendCount = payMoney / this.mSmsInfo.money;
             if ((payMoney % this.mSmsInfo.money)) {
                smsTotalToSendCount++;
             }
             if (!this.mSmsInfo.isNeedconfirm()) {
                if (this.mLeftSmsToSendCount == -1) {
                   this.mLeftSmsToReceiveCount = smsTotalToSendCount;
                   this.mLeftSmsToSendCount = smsTotalToSendCount;
                   objArray = new Object[]{Integer.valueOf(this.mLeftSmsToSendCount),Integer.valueOf(this.mSmsInfo.money),this.mPaymentInfo.getPayname(),Integer.valueOf(payMoney)};
                   showtext = Html.fromHtml(String.format("\x5c\x02\x65\x02\x76\x02\x75\x02\x62\x02\xff\x02\x61\x02\x8c\x02\x60\x02\x4e\x02\x6e\x02\x62\x02\x65\x02\x4e\x02\xff\x02\x60\x02\x97\x02\x89\x02\x53\x02\x90\x02<font color=\'#FF4500\'>[ %d ]</font>\x67\x02 %d \x51\x02\x76\x02\x77\x02\x4f\x02\xff\x02\x8d\x02\x4e\x02<font color=\'#FF4500\'>[%s]</font>\xff\x02\x51\x02\x8b\x02<font color=\'#FF4500\'>[ %d ]</font>\x51\x02\xff\x02\x70\x02\x51\x02<font color=\'#FF4500\'>[\x70\x02\x64\x02]</font>\x5f\x02\x59\x02\x53\x02\x90\x02\x30\x02\x8b\x02\x6c\x02\x61\x02\x53\x02\x90\x02\x5f\x02\x59\x02\x54\x02\xff\x02\x60\x02\x4e\x02\x80\x02\x4e\x02\x65\x02\x53\x02\x90\x02\xff\x02\x54\x02\x52\x02\x8d\x02\x4e\x02\x5c\x02\x4e\x02\x62\x02\x52\x02\x30\x02", objArray));
                   this.mIsShowInfo = true;
                }else {
                   objArray = new Object[]{Integer.valueOf(((smsTotalToSendCount - this.mLeftSmsToSendCount) + 1))};
                   showtext = Html.fromHtml(String.format("\x5c\x02\x65\x02\x76\x02\x75\x02\x62\x02\xff\x02\x70\x02\x51\x02<font color=\'#FF4500\'>[\x78\x02\x5b\x02]</font>\x63\x02\x94\x02\xff\x02\x53\x02\x90\x02\x7b\x02<font color=\'#FF4500\'>[ %d ]</font>\x67\x02\x77\x02\x4f\x02\x30\x02", objArray));
                   cancelBtn.setVisibility(8);
                   okBtn.setText("\x78\x02\x5b\x02");
                   okBtnParams.addRule(14, -1);
                }
                tvSmsMessage.setText(showtext);
                tvSmsText.setText(this.mSmsInfo.getInfobeforesend());
             }else {
                tvSmsMessage.setText(this.mSmsInfo.getInfobeforesend());
                cancelBtn.setVisibility(8);
                okBtn.setText("\x78\x02\x5b\x02");
                okBtnParams.addRule(14, -1);
             }
          }else {
             payMoney = payMoney - payedCount;
             if (this.mSmsInfo == null) {
                this.mSmsInfo = Utils.getSmsInfos().filterSmsInfo(this.getApplicationContext(), payMoney);
                this.mSmsInfo.setExtInfo(this.mPaymentInfo);
             }
             if (!this.mSmsInfo.isNeedconfirm()) {
                if (this.mLeftSmsToSendCount == -1) {
                   smsTotalToSendCount = payMoney / this.mSmsInfo.money;
                   if ((payMoney % this.mSmsInfo.money)) {
                      smsTotalToSendCount++;
                   }
                   this.mIsShowInfo = true;
                   this.mLeftSmsToSendCount = smsTotalToSendCount;
                   this.mLeftSmsToReceiveCount = smsTotalToSendCount;
                   objArray = new Object[]{Integer.valueOf(payedCount),this.mPaymentInfo.getPayname(),Integer.valueOf(this.mLeftSmsToSendCount),Integer.valueOf(this.mSmsInfo.money)};
                   showtext = Html.fromHtml(String.format("\x60\x02\x4e\x02\x52\x02\x62\x02\x52\x02\x53\x02\x90\x02\x8f\x02\x60\x02\x8b\x02 %d \x51\x02\x76\x02\x77\x02\x4f\x02\x8d\x02\x4e\x02<font color=\'#FF4500\'>[%s]</font>\xff\x02\x76\x02\x52\x02\x8f\x02\x97\x02\x53\x02\x90\x02<font color=\'#FF4500\'>[ %d ]</font>\x67\x02  %d \x51\x02\x77\x02\x4f\x02\x7e\x02\x7e\x02\x8d\x02\x4e\x02\xff\x02\x70\x02\x51\x02<font color=\'#FF4500\'>[\x70\x02\x64\x02]</font>\x63\x02\x94\x02\x5f\x02\x59\x02\x53\x02\x90\x02\x30\x02", objArray));
                }else {
                   objArray = new Object[]{Integer.valueOf((((payMoney / this.mSmsInfo.money) - this.mLeftSmsToSendCount) + 1)),Integer.valueOf(this.mLeftSmsToSendCount)};
                   showtext = Html.fromHtml(String.format("\x5c\x02\x65\x02\x76\x02\x75\x02\x62\x02\xff\x02\x70\x02\x51\x02<font color=\'#FF4500\'>[\x78\x02\x5b\x02]</font>\x63\x02\x94\x02\xff\x02\x5f\x02\x59\x02\x53\x02\x90\x02\x7b\x02<font color=\'#FF4500\'>[ %d ]</font>\x67\x02\x77\x02\x4f\x02\x30\x02", objArray));
                   cancelBtn.setVisibility(8);
                   okBtn.setText("\x78\x02\x5b\x02");
                   okBtnParams.addRule(14, -1);
                }
                tvSmsMessage.setText(showtext);
                tvSmsText.setText(this.mSmsInfo.getInfobeforesend());
             }else {
                tvSmsMessage.setText(this.mSmsInfo.getInfobeforesend());
                cancelBtn.setVisibility(8);
                okBtn.setText("\x78\x02\x5b\x02");
                okBtnParams.addRule(14, -1);
             }
          }
          Linkify.addLinks(tvSmsMessage, 4);
          Linkify.addLinks(tvSmsText, 4);
       }catch(com.uc.paymentsdk.payment.sms.SimCardNotSupportException e9){
          SimCardNotSupportException localSimCardNotSupportException = e9;
          this.mSmsResultInfo = localSimCardNotSupportException.getMessage();
          this.showDialog(16);
       }
       okBtnParams.addRule(12, -1);
       okBtnParams.setMargins(10, 20, 10, 10);
       okBtn.setLayoutParams(okBtnParams);
       tableLayout.addView(okBtn);
       RelativeLayout$LayoutParams cancelBtnParams = new RelativeLayout$LayoutParams(150, -2);
       cancelBtnParams.addRule(11, -1);
       cancelBtnParams.addRule(12, -1);
       cancelBtnParams.setMargins(10, 20, 10, 10);
       cancelBtn.setLayoutParams(cancelBtnParams);
       tableLayout.addView(cancelBtn);
       this.setContentView(tableLayout);
       return;
    }
    private void initUPointPayView(UPointInfo info){
       Object[] objArray = new Object[]{info.getDiscount(),info.getDiscounttext()};
       this.mTvDiscountTextView.setText(String.format("U\x70\x02\x62\x02\x62\x02 : %s\x62\x02\(%sU\x70\x02\)", objArray));
       if (info.getVipdiscount() != null && info.getVipdiscount().length() > 0) {
          objArray = new Object[]{info.getVipdiscount(),info.getVipdiscounttext()};
          this.mTvDiscountTextView.setText(String.format("\x4f\x02\x54\x02\x62\x02\x62\x02 : %s\x62\x02\(%sU\x70\x02\)", objArray));
          objArray = new Object[]{info.getVipdiscounttime()};
          this.mTvVipDiscountTimeTextView.setText(String.format("\x4f\x02\x54\x02\x62\x02\x62\x02\x52\x02\x67\x02\x65\x02\x95\x02 : ", objArray));
          this.mTvVipDiscountInfo.setText("\x4f\x02\x54\x02\x62\x02\x62\x02\x52\x02\x67\x02\x65\x02\x95\x02 : "+info.getDiscountinfo());
       }else {
          this.mTvVipDiscountTextView.setVisibility(8);
          this.mTvVipDiscountTimeTextView.setVisibility(8);
          this.mTvVipDiscountInfo.setVisibility(8);
       }
       this.mBtnPay.setVisibility(0);
       return;
    }
    private void pay(){
       this.showDialog(6);
       Api.pay(this.getApplicationContext(), this, this.mPaymentInfo, this.mUPayInfo);
    }
    private void sendConfirmSms(String paramString){
       try{
          this.showDialog(17);
          SmsInfo.sendSms(this.getApplicationContext(), paramString.split(",,,,")[0], paramString.split(",,,,")[1]);
       label_001e :
          return;
       }catch(java.lang.Exception e1){
          try{
             Exception e = e1;
             if (this.mSmsHander != null && this.mSmsRunnable != null) {
                this.mSmsHander.removeCallbacks(this.mSmsRunnable);
                ContentResolver contentResol = this.getContentResolver();
                PaymentsActivity tmSmsContent = this.mSmsContent;
                contentResol.unregisterContentObserver(tmSmsContent);
                this.unregisterReceiver(this.mSmsReceiver);
             }
          }catch(java.lang.IllegalArgumentException e1){
          }
          this.removeDialog(17);
          this.showDialog(38);
          goto label_001e ;
       }
    }
    private void sendFirstSms(SmsInfo paramSmsInfo){
       try{
          this.showDialog(17);
          paramSmsInfo.sendFirstSms(this.getApplicationContext());
       label_000c :
          return;
       }catch(java.lang.Exception e1){
          try{
             Exception e = e1;
             if (this.mSmsHander != null && this.mSmsRunnable != null) {
                this.mSmsHander.removeCallbacks(this.mSmsRunnable);
                ContentResolver contentResol = this.getContentResolver();
                PaymentsActivity tmSmsContent = this.mSmsContent;
                contentResol.unregisterContentObserver(tmSmsContent);
                this.unregisterReceiver(this.mSmsReceiver);
             }
          }catch(java.lang.IllegalArgumentException e1){
          }
          this.removeDialog(17);
          this.showDialog(38);
          goto label_000c ;
       }
    }
    public void confirmEnterPaymentPoint(){
       PrefUtil.increaseArriveCount(this.getApplicationContext());
    }
    protected void onActivityResult(int paramInt1,int paramInt2,Intent paramIntent){
       super.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
    public void onClick(View paramView){
       int ix = 28;
       int ix1 = 27;
       int ix2 = -1;
       int ix3 = 23;
       boolean b = false;
       if (paramView == this.mBtnPay) {
          this.mBtnPay.setEnabled(b);
          this.buildUPointPayLoginView();
       }else {
          switch (paramView.getId()){
              case 3:
             label_001d :
                if (this.mIsShowInfo != null) {
                   this.buildSmsPaymentView();
                   this.mIsShowInfo = b;
                }else if(this.mSmsInfo != null){
                   this.registerReceiver(this.mSmsReceiver, new IntentFilter("com.uc.androidsdk.SMS_SENT_ACTION"));
                   this.sendFirstSms(this.mSmsInfo);
                }
                break;
              case 4:
                this.buildPaymentView();
                break;
              case 5:
                if (this.mConfirmSmsInfoString != null && this.mConfirmSmsInfoString.contains(",,,,")) {
                   this.sendConfirmSms(this.mConfirmSmsInfoString);
                }
                break;
              case 6:
                this.showDialog(ix3);
                break;
              case 7:
                paramView.setEnabled(b);
                String usernamestr = this.mEtUsername.getText().toString();
                String pwdstr = this.mEtPassword.getText().toString();
                if (TextUtils.isEmpty(usernamestr) && TextUtils.isEmpty(pwdstr)) {
                   this.showDialog(ix);
                }else if(TextUtils.isEmpty(pwdstr)){
                   this.showDialog(29);
                }else if(TextUtils.isEmpty(usernamestr)){
                   this.showDialog(30);
                }else {
                   this.mUPayInfo = new UPointPayInfo(usernamestr, pwdstr, "", this.mPaymentInfo.getCpID(), this.mPaymentInfo.getmGameID(), this.mPaymentInfo.getMoney(), "");
                   this.pay();
                }
                break;
              case 8:
                paramView.setEnabled(b);
                String paypassstr = this.mEtPayPass.getText().toString();
                if (TextUtils.isEmpty(paypassstr)) {
                   this.showDialog(ix);
                   goto label_001d ;
                }else {
                   this.mUPayInfo.setPaypwd(paypassstr);
                   this.pay();
                   goto label_001d ;
                }
                break;
              case 9:
                switch (this.mType){
                    case 0:
                      this.finish();
                      break;
                    case 1:
                      this.buildPaymentView();
                      break;
                    case 2:
                      this.buildUPointPaymentView();
                      break;
                    case 3:
                      this.buildUPointPayLoginView();
                      break;
                    case 4:
                      if (!this.mSmsInfo.isNeedconfirm() && this.mIsShowInfo == null) {
                         int totalToPay = Utils.getSmsPayment();
                         int totalSMS = totalToPay / this.mSmsInfo.money;
                         if (this.mLeftSmsToSendCount != ix2 && this.mLeftSmsToSendCount != totalSMS) {
                            this.showDialog(ix1);
                         }else {
                            this.buildSmsPaymentView();
                         }
                      }else {
                         this.buildPaymentView();
                      }
                      break;
                    case 5:
                      this.showDialog(ix3);
                      break;
                    default:
                }
                break;
              case 10:
                switch (this.mType){
                    case 4:
                      if (this.mSmsInfo.isNeedconfirm() || this.mIsShowInfo != null) {
                         int i = Utils.getSmsPayment();
                         int j = i / this.mSmsInfo.money;
                         if (this.mLeftSmsToSendCount != ix2 && this.mLeftSmsToSendCount != j) {
                            this.showDialog(ix1);
                         }else {
                            this.buildPaymentView();
                         }
                      }
                      break;
                    case 5:
                      this.showDialog(ix3);
                      break;
                    default:
                      this.finish();
                }
                break;
              default:
          }
       }
       return;
    }
    protected void onCreate(Bundle paramBundle){
       super.onCreate(paramBundle);
       this.mIsValid = this.initPayment();
       if (this.mIsValid != null) {
          Utils.init(this.getApplicationContext());
          Utils.initTitleBar(this);
          this.buildPaymentView();
          this.confirmEnterPaymentPoint();
          new HandlerProxy(this.getApplicationContext()).handleRequest();
       }
       return;
    }
    protected Dialog onCreateDialog(int paramInt){
       Dialog uDialog;
       int ix = 2;
       int ix1 = 1;
       boolean b = false;
       DialogUtil$WarningDialogListener warningDialo = null;
       switch (paramInt){
           case 0:
             uDialog = DialogUtil.createOKWarningDialog(this, paramInt, "\x8b\x02\x5e\x02\x75\x02\x89\x02\x6c\x02\x65\x02\x4e\x02\x76\x02\x91\x02\x98\x02\x4e\x02\x7b\x02\x54\x02\x89\x02\x6c\x02\xff\x02\x4e\x02\x80\x02\x62\x02\x52\x02\x65\x02\x4e\x02\x30\x02", this);
             break;
           case 2:
             uDialog = DialogUtil.createOKWarningDialogSupportLink(this, paramInt, "\x4e\x02\x4e\x02\x66\x02U\x70\x02?", "U\x70\x02\x66\x02<a href=\'http://wap.uc.cn\'>UC-\x4f\x02\x89\x02</a>\x63\x02\x4f\x02\x76\x02\x4e\x02\x79\x02\x86\x02\x62\x02\x8d\x02\x5e\x02\xff\x02\x4e\x02\x89\x02\x75\x02\x4e\x02\x8d\x02\x4e\x02\x8f\x02\x4e\x02\x54\x02\x6e\x02\x62\x02\x91\x02\x76\x02\x51\x02\x5b\x02\xff\x02\x59\x02\xff\x02\x90\x02\x51\x02\x30\x02\x51\x02\x53\x02\x30\x02\x8f\x02\x4e\x02\x30\x02\x4f\x02\x75\x02\x65\x02\x95\x02\x7b\x02\xff\x02\x30\x02<br /><br />U\x70\x02\x51\x02\x63\x02\x68\x02\x51\x02\xff\x02<br />1\x51\x02\x53\x02\x51\x02\x63\x0210U\x70\x02\x30\x02<br />\x90\x02\x8f\x02\x4e\x02\x4e\x02\x94\x02\x63\x02\x51\x02\x50\x02U\x70\x02\xff\x02<br /><a href=\'http://pay.uc.cn\'>UC-\x4f\x02\x89\x02</a>", warningDialo);
             break;
           case 5:
             uDialog = DialogUtil.createOKWarningDialog(this, paramInt, "U\x70\x02\x4e\x02\x8d\x02,\x4e\x02\x80\x02\x7e\x02\x7e\x02\x65\x02\x4e\x02\xff\x02", warningDialo);
             break;
           case 6:
             uDialog = DialogUtil.createIndeterminateProgressDialog(this, paramInt, "\x6b\x02\x57\x02\x65\x02\x4e\x02\xff\x02\x8b\x02\x52\x02\x51\x02\x95\x02\x7a\x02\x5e\x02\xff\x02\x8b\x02\x7a\x02\x54\x02......", b, warningDialo);
             break;
           case 7:
             uDialog = DialogUtil.createOKWarningDialog(this, paramInt, "\x65\x02\x4e\x02\x4e\x02\x62\x02\x52\x02\xff\x02\x8b\x02\x78\x02\x5b\x02\x60\x02\x76\x02\x8d\x02\x62\x02\x5f\x02\x4e\x02\x76\x02\x4f\x02\x98\x02\x51\x02\x8d\x02\x5e\x02\x7f\x02\x7e\x02\x8f\x02\x63\x02\x6b\x02\x5e\x02\x30\x02", warningDialo);
             break;
           case 8:
             uDialog = DialogUtil.createOKWarningDialog(this, paramInt, "\x65\x02\x4e\x02\x4e\x02\x62\x02\x52\x02\xff\x02\x8b\x02\x78\x02\x5b\x02\x60\x02\x76\x02\x8d\x02\x62\x02\x5f\x02\x4e\x02\x76\x02\x4f\x02\x98\x02\x51\x02\x8d\x02\x5e\x02\x7f\x02\x7e\x02\x8f\x02\x63\x02\x6b\x02\x5e\x02\x30\x02", warningDialo);
             break;
           case 9:
             uDialog = DialogUtil.createOKWarningDialog(this, paramInt, "\x65\x02\x4e\x02\x4e\x02\x62\x02\x52\x02\xff\x02\x8b\x02\x78\x02\x5b\x02\x60\x02\x76\x02\x8d\x02\x62\x02\x5f\x02\x4e\x02\x76\x02\x4f\x02\x98\x02\x51\x02\x8d\x02\x5e\x02\x7f\x02\x7e\x02\x8f\x02\x63\x02\x6b\x02\x5e\x02\x30\x02", warningDialo);
             break;
           case 10:
             uDialog = DialogUtil.createYesNoDialog(this, paramInt, "\x65\x02\x4e\x02\x4e\x02\x62\x02\x52\x02\xff\x02\x8f\x02\x63\x02\x67\x02\x52\x02\x56\x02\x8d\x02\x65\x02\xff\x02\x66\x02\x54\x02\x91\x02\x8b\x02?", this);
             break;
           case 11:
             uDialog = DialogUtil.createOKWarningDialog(this, paramInt, "\x65\x02\x4e\x02\x4e\x02\x62\x02\x52\x02\xff\x02\x8b\x02\x78\x02\x5b\x02\x60\x02\x76\x02\x8d\x02\x62\x02\x5f\x02\x4e\x02\x76\x02\x4f\x02\x98\x02\x51\x02\x8d\x02\x5e\x02\x7f\x02\x7e\x02\x8f\x02\x63\x02\x6b\x02\x5e\x02\x30\x02\n\x8b\x02\x80\x02\x7c\x02\x5b\x02\x67\x024006-400-401\x30\x02", warningDialo);
             break;
           case 13:
             Object[] objArray = new Object[ix];
             objArray[b] = this.mNumber;
             objArray[ix1] = Integer.valueOf(this.mBalance);
             uDialog = DialogUtil.createOKWarningDialog(this, paramInt, "U\x70\x02\x65\x02\x4e\x02\x62\x02\x52\x02\xff\x02\x79\x02\x60\x02\x73\x02\x76\x02\x5f\x02\x5f\x02", String.format("\x60\x02\x76\x02\x4f\x02\x98\x02\x4e\x02%dU\x70\x02", objArray), this);
             break;
           case 14:
             uDialog = DialogUtil.createIndeterminateProgressDialog(this, paramInt, "\x8f\x02\x63\x02\x67\x02\x52\x02\x56\x02\xff\x02\x8b\x02\x7a\x02\x7b\x02...", b, warningDialo);
             break;
           case 15:
             uDialog = DialogUtil.createOKWarningDialog(this, paramInt, "\x7f\x02\x7e\x02\x8f\x02\x63\x02\x95\x02\x8b\x02\xff\x02\x8b\x02\x68\x02\x67\x02\x7f\x02\x7e\x02\x54\x02\x51\x02\x8b\x02\x30\x02", this);
             break;
           case 16:
             uDialog = DialogUtil.createOKWarningDialog(this, paramInt, this.mSmsResultInfo, this);
             break;
           case 17:
             uDialog = DialogUtil.createIndeterminateProgressDialog(this, paramInt, "\x77\x02\x4f\x02\x53\x02\x90\x02\x8f\x02\x7a\x02\x53\x02\x80\x02\x63\x02\x7e\x02\x4e\x02\x52\x02\x94\x02\xff\x02\x8b\x02\x80\x02\x5f\x02\x7b\x02\x5f\x02...", b, warningDialo);
             break;
           case 18:
             uDialog = DialogUtil.createOKWarningDialog(this, paramInt, "\x77\x02\x4f\x02\x53\x02\x90\x02\x59\x02\x8d\x02", warningDialo);
             break;
           case 19:
             uDialog = DialogUtil.createIndeterminateProgressDialog(this, paramInt, "\x6b\x02\x57\x02\x83\x02\x53\x02\x4f\x02\x60\x02\xff\x02\x8b\x02\x7a\x02\x50\x02......", b, warningDialo);
             break;
           case 20:
             uDialog = DialogUtil.createOKWarningDialog(this, paramInt, "\x8d\x02\x4e\x02\x62\x02\x52\x02", this.mSmsResultInfo, this);
             break;
           case 21:
             uDialog = DialogUtil.createOKWarningDialog(this, paramInt, this.mSmsResultInfo, this);
             break;
           case 22:
             uDialog = DialogUtil.createOKWarningDialog(this, paramInt, "CPID\x4e\x02\x5b\x02\x7b\x02\x4e\x02\x54\x02\x65\x02\x5b\x02\x4e\x02\x61\x02\x7e\x02\x54\x02\xff\x02\x4e\x02\x80\x02\x75\x02\x4e\x02\x65\x02\x5b\x02\x7b\x02\x30\x02\x68\x02\x70\x02\x7b\x02\x53\x02\x62\x02\x7a\x02\x68\x02\xff\x02\x95\x02\x5e\x02\x4e\x02\x8d\x02\x8f\x0210\x4e\x02\x82\x02\x65\x02\x5b\x02\x7b\x02\x30\x02", this);
             break;
           case 23:
             uDialog = DialogUtil.createTwoButtonsDialog(this, paramInt, "\x60\x02\x5d\x02\x7e\x02\x53\x02\x6d\x02\x4e\x02\x8d\x02\x4e\x02\xff\x02\x5c\x02\x4e\x02\x4f\x02\x83\x02\x5f\x02\x76\x02\x5e\x02\x51\x02\x5b\x02\x30\x02\x8b\x02\x78\x02\x8b\x02\x66\x02\x54\x02\x53\x02\x6d\x02\xff\x02", "\x53\x02\x6d\x02", "\x4e\x02\x53\x02\x6d\x02", this);
             break;
           case 24:
             uDialog = DialogUtil.createTwoButtonsDialog(this, paramInt, Html.fromHtml("\x8d\x02\x4e\x02\x78\x02\x8b\x02\x77\x02\x4f\x02\x67\x02\x52\x02\x96\x02\xff\x02\x59\x02\x97\x02\x8d\x02\x4e\x02\x8b\x02\x51\x02\x6b\x02\x53\x02\x90\x02\x77\x02\x4f\x02\x62\x02\x91\x02\x75\x02\x51\x02\x4e\x02\x65\x02\x4e\x02\x65\x02\x5f\x02\xff\x02<font color=\'red\'>\x8b\x02\x52\x02\x52\x02\x77\x02\x4f\x02\x65\x02\x4e\x02\x7b\x02\x8f\x02\x88\x02\x56\x02\x59\x02</font>\xff\x02\x8c\x02\x8c\x02\xff\x02"), "\x8f\x02\x56\x02\x8d\x02\x4e\x02\x98\x02", "\x8f\x02\x56\x02\x5e\x02\x75\x02", this);
             break;
           case 25:
             uDialog = DialogUtil.createTwoButtonsDialog(this, paramInt, "\x8d\x02\x4e\x02\x78\x02\x8b\x02\x77\x02\x4f\x02\x5d\x02\x52\x02\x96\x02\xff\x02\x59\x02\x97\x02\x8d\x02\x4e\x02\x8b\x02\x51\x02\x6b\x02\x53\x02\x90\x02\x77\x02\x4f\x02\x62\x02\x91\x02\x75\x02\x51\x02\x4e\x02\x65\x02\x4e\x02\x65\x02\x5f\x02\xff\x02\x8c\x02\x8c\x02\xff\x02", "\x8f\x02\x56\x02\x8d\x02\x4e\x02\x98\x02", "\x8f\x02\x56\x02\x5e\x02\x75\x02", this);
             break;
           case 26:
             uDialog = DialogUtil.createOKWarningDialog(this, paramInt, "\x65\x02\x4e\x02\x8d\x02\x65\x02\xff\x02\x70\x02\x51\x02\x78\x02\x5b\x02\x91\x02\x65\x02\x9a\x02\x8b\x02\x65\x02\x4e\x02\x7e\x02\x67\x02\x30\x02\x67\x02\x59\x02 \x97\x02\x89\x021\x52\x02\x94\x02\xff\x02\x8b\x02\x80\x02\x5f\x02\x7b\x02\x5f\x02...", this);
             break;
           case 27:
             int i = this.getPayedAmount();
             int j = PrefUtil.getPayedAmount(this.getApplicationContext());
             Object[] objArray1 = new Object[]{Integer.valueOf((j + i)),this.mPaymentInfo.getPayname(),this.mPaymentInfo.getPayname()};
             uDialog = DialogUtil.createTwoButtonsDialog(this, paramInt, String.format("\x60\x02\x5d\x02\x7e\x02\x65\x02\x4e\x02\x8f\x02\x30\x02%d\x30\x02\x51\x02\x77\x02\x4f\x02\xff\x02\x73\x02\x57\x02\x53\x02\x6d\x02\x53\x02\x90\x02\x5c\x02\x4e\x02\x80\x02\x62\x02\x52\x02\x8d\x02\x4e\x02\x30\x02%s\x30\x02\x30\x02\x59\x02\x53\x02\x6d\x02\x53\x02\x90\x02\x5d\x02\x4e\x02\x91\x02\x98\x02\x4e\x02\x4f\x02\x8f\x02\x8f\x02\xff\x02\x53\x02\x80\x02\x8b\x02\x7b\x02\x52\x02\x60\x02\x4e\x02\x6b\x02\x8d\x02\x4e\x02\x30\x02%s\x30\x02\x4e\x02\x30\x02\x8b\x02\x51\x02\x6b\x02\x78\x02\x8b\x02\x66\x02\x54\x02\x53\x02\x6d\x02\x8f\x02\x6b\x02\x65\x02\x4e\x02\xff\x02", objArray1), "\x8f\x02\x56\x02\x7e\x02\x7e\x02\x65\x02\x4e\x02", "\x78\x02\x8b\x02\x53\x02\x6d\x02", this);
             break;
           case 28:
             uDialog = DialogUtil.createOKWarningDialog(this, paramInt, "\x8b\x02\x8f\x02\x51\x02\x8d\x02\x53\x02\x54\x02\x5b\x02\x78\x02\x30\x02", warningDialo);
             break;
           case 29:
             uDialog = DialogUtil.createOKWarningDialog(this, paramInt, "\x5b\x02\x78\x02\x4e\x02\x7a\x02\xff\x02\x8b\x02\x8f\x02\x51\x02\x5b\x02\x78\x02\x30\x02", warningDialo);
             break;
           case 30:
             uDialog = DialogUtil.createOKWarningDialog(this, paramInt, "\x75\x02\x62\x02\x54\x02\x4e\x02\x7a\x02\xff\x02\x8b\x02\x8f\x02\x51\x02\x75\x02\x62\x02\x54\x02\x30\x02", warningDialo);
             break;
           case 31:
             uDialog = DialogUtil.createOKWarningDialog(this, paramInt, "\x75\x02\x62\x02\x54\x02\x5f\x02\x98\x02\x59\x02\x4e\x023\x4e\x02\x5b\x02\x30\x02", warningDialo);
             break;
           case 32:
             uDialog = DialogUtil.createOKWarningDialog(this, paramInt, "\x75\x02\x62\x02\x54\x02\x5f\x02\x98\x02\x5c\x02\x4e\x0217\x4e\x02\x5b\x02\x30\x02", warningDialo);
             break;
           case 33:
             uDialog = DialogUtil.createOKWarningDialog(this, paramInt, "\x5b\x02\x78\x02\x4e\x02\x80\x02\x4e\x02\x7a\x02\x30\x02", warningDialo);
             break;
           case 34:
             uDialog = DialogUtil.createOKWarningDialog(this, paramInt, "\x76\x02\x5f\x02\x59\x02\x8d\x02\xff\x02\x60\x02\x76\x02\x5e\x02\x53\x02\x54\x02\x5b\x02\x78\x02\x4e\x02\x53\x02\x91\x02\x30\x02", warningDialo);
             break;
           case 35:
             uDialog = DialogUtil.createIndeterminateProgressDialog(this, paramInt, "U\x70\x02\x65\x02\x4e\x02\x4e\x02\xff\x02\x8b\x02\x7a\x02\x50\x02...", b, warningDialo);
             break;
           case 36:
             uDialog = DialogUtil.createYesNoDialog(this, paramInt, "\x60\x02\x62\x02\x67\x02\x65\x02\x95\x02\x4e\x02\x6b\x02\x78\x02\xff\x02\x4e\x02\x4e\x02\x78\x02\x4f\x02\x5b\x02\x51\x02\x65\x02\x4e\x02\xff\x02\x66\x02\x54\x02\x97\x02\x89\x02\x7c\x02\x7e\x02\x81\x02\x52\x02\x4f\x02\x6b\x02\x5e\x02\x5b\x02\x62\x02\x65\x02\x4e\x02?", this);
             break;
           case 37:
             uDialog = DialogUtil.createOKWarningDialog(this, paramInt, "\x65\x02\x4e\x02\x4e\x02\x62\x02\x52\x02\xff\x02\x60\x02\x76\x02\x65\x02\x4e\x02\x5b\x02\x78\x02\x67\x02\x8b\x02\xff\x02\x4e\x02\x80\x02\x65\x02\x4e\x02\x62\x02\x52\x02\xff\x02", warningDialo);
             break;
           case 38:
             uDialog = DialogUtil.createOKWarningDialog(this, paramInt, "\x65\x02\x4e\x02\x4e\x02\x62\x02\x52\x02\xff\x02\x60\x02\x5d\x02\x7e\x02\x79\x02\x6b\x02\x4e\x02\x53\x02\x90\x02\x65\x02\x4e\x02\x77\x02\x4f\x02\xff\x02\x8b\x02\x91\x02\x65\x02\x5c\x02\x8b\x02\x65\x02\x4e\x02\x30\x02", warningDialo);
             break;
           default:
             uDialog = super.onCreateDialog(paramInt);
       }
       return uDialog;
    }
    protected void onDestroy(){
       super.onDestroy();
       if (this.mIsValid != null) {
          PrefUtil.logout(this.getApplicationContext());
          Utils.clearSmsInfos();
          Utils.clearUPointInfo();
          TypeFactory.clear();
          Utils.clearUPointPayInfo();
          SyncChargeChannelHandler.init();
          SyncPayChannelHandler.init();
          SyncSmsInfoHandler.init();
       }
       return;
    }
    public void onError(int paramInt1,int paramInt2){
       int i = 6;
       switch (paramInt1){
           case 3:
             switch (paramInt2){
                 case 0xffffffff:
                   this.mTimeoutCounter = this.mTimeoutCounter + 1;
                   if (this.mTimeoutCounter < 2) {
                      Api.pay(this.getApplicationContext(), this, this.mPaymentInfo, this.mUPayInfo);
                   }else {
                      this.mTimeoutCounter = 0;
                      this.mBtnPay.setEnabled(true);
                      this.removeDialog(i);
                      this.showDialog(10);
                   }
                   break;
                 case 219:
                   this.mBtnPay.setEnabled(0);
                   this.removeDialog(i);
                   this.showDialog(5);
                   this.buildPaymentView();
                   break;
                 case 425:
                   this.mBtnPay.setEnabled(true);
                   this.removeDialog(i);
                   this.showDialog(8);
                   break;
                 case 500:
                   this.mBtnPay.setEnabled(true);
                   this.removeDialog(i);
                   this.showDialog(11);
                   break;
                 default:
                   this.mBtnPay.setEnabled(true);
                   this.removeDialog(i);
                   this.showDialog(7);
             }
             break;
           case 18:
             this.dismissDialog(14);
             this.showDialog(15);
             this.buildPaymentView();
             break;
       }
       return;
    }
    public void onFinish(){
       this.fillData();
    }
    public void onItemClick(AdapterView paramAdapterView,View paramView,int paramInt,long paramLong){
       if (paramInt) {
          IType localIType = paramAdapterView.getAdapter().getWrappedAdapter().getItem((paramInt - 1));
          String str = localIType.getId();
          if ("upoint".equals(str)) {
             this.buildUPointPaymentView();
          }else if("sms".equals(str)){
             this.buildSmsPaymentView();
          }
       }
       return;
    }
    public boolean onKeyDown(int paramInt,KeyEvent paramKeyEvent){
       boolean b;
       switch (paramInt){
           case 4:
             switch (this.mType){
                 case 1:
                   this.buildPaymentView();
                   b = true;
                   break;
                 case 2:
                   this.buildUPointPaymentView();
                   b = true;
                   break;
                 case 3:
                   this.buildUPointPayLoginView();
                   b = true;
                   break;
                 case 4:
                   if (!this.mSmsInfo.isNeedconfirm() && this.mIsShowInfo == null) {
                      this.buildPaymentView();
                   }else {
                      int i = Utils.getSmsPayment();
                      int j = i / this.mSmsInfo.money;
                      if (this.mLeftSmsToSendCount != -1 && this.mLeftSmsToSendCount != j) {
                         this.showDialog(27);
                      }else {
                         this.buildPaymentView();
                      }
                   }
                   b = true;
                   break;
                 case 5:
                   this.showDialog(23);
                   b = true;
                   break;
                 default:
             }
             break;
           default:
             b = super.onKeyDown(paramInt, paramKeyEvent);
       }
       return b;
    }
    public Object onPreHandle(int paramInt,HttpResponse paramHttpResponse){
       Boolean uBoolean;
       if (5 != paramInt && 8 != paramInt) {
          String str = Utils.getBodyString(paramInt, paramHttpResponse);
          if (TextUtils.isEmpty(str)) {
             uBoolean = null;
          }else {
             switch (paramInt){
                 case 3:
                   try{
                      uBoolean = XMLParser.parsePayOrder(str);
                   }catch(java.lang.Exception e0){
                      e0.printStackTrace();
                   }
                   try{
                      uBoolean = XMLParser.parseUPointInfo(str);
                   }catch(java.lang.Exception e0){
                      e0.printStackTrace();
                   }
                   break;
                 case 18:
                 default:
                   uBoolean = null;
             }
          }
       }else {
          uBoolean = Boolean.valueOf(true);
       }
       return uBoolean;
    }
    protected void onPrepareDialog(int paramInt,Dialog paramDialog){
       super.onPrepareDialog(paramInt, paramDialog);
       if (paramDialog.isShowing()) {
          paramDialog.dismiss();
       }
       return;
    }
    public void onSuccess(int paramInt,Object paramObject){
       int i = -102;
       switch (paramInt){
           case 3:
             String resultstr = paramObject;
             String[] resultarr = resultstr.split("#");
             int returncodeint = Integer.parseInt(resultarr[0]);
             String errormsg = resultarr[1];
             this.removeDialog(6);
             if (returncodeint == -110) {
                this.showDialog(7);
                this.mUPayInfo.updateConsumeId();
             }else if(returncodeint == i && errormsg.equals("uc_tm_modify")){
                String timestr = resultarr[2];
                this.mUPayInfo.setTm(timestr);
                this.showDialog(36);
             }else if(returncodeint < 0){
                if (returncodeint == i) {
                   if (errormsg.equals("uc_password_error")) {
                      this.showDialog(34);
                   }else if(errormsg.equals("um_account_error")){
                      this.showDialog(5);
                   }else if(errormsg.equals("um_paypwd_error")){
                      this.showDialog(37);
                   }else if(errormsg.equals("um_paypwd_error")){
                      if (this.mType == 3) {
                         this.showDialog(7);
                      }else if(this.mEtSavePass.isChecked()){
                         PrefUtil.setUCUserName(this.getApplicationContext(), this.mEtUsername.getText().toString());
                         PrefUtil.setUCUserPass(this.getApplicationContext(), this.mEtPassword.getText().toString());
                      }else {
                         PrefUtil.clearUCUserName(this.getApplicationContext());
                         PrefUtil.clearUCUserPass(this.getApplicationContext());
                      }
                      this.buildUPointPayPassView();
                   }else if(errormsg.equals("um_system_error")){
                      this.showDialog(7);
                      this.mUPayInfo.updateConsumeId();
                   }
                }
             }else if(this.mEtSavePass.isChecked()){
                PrefUtil.setUCUserName(this.getApplicationContext(), this.mEtUsername.getText().toString());
                PrefUtil.setUCUserPass(this.getApplicationContext(), this.mEtPassword.getText().toString());
             }else {
                PrefUtil.clearUCUserName(this.getApplicationContext());
                PrefUtil.clearUCUserPass(this.getApplicationContext());
             }
             this.showDialog(13);
             break;
           case 18:
             UPointInfo info = paramObject;
             this.initUPointPayView(info);
             Utils.setUPointInfo(info);
             this.dismissDialog(14);
             break;
       }
       return;
    }
    public void onWarningDialogCancel(int paramInt){
       ContentResolver contentResol;
       PaymentsActivity tmSmsContent;
       switch (paramInt){
           case 23:
           case 26:
           case 24:
           case 25:
             try{
                if (this.mSmsHander != null && this.mSmsRunnable != null) {
                   this.mSmsHander.removeCallbacks(this.mSmsRunnable);
                   contentResol = this.getContentResolver();
                   tmSmsContent = this.mSmsContent;
                   contentResol.unregisterContentObserver(tmSmsContent);
                   this.unregisterReceiver(this.mSmsReceiver);
                }
             }catch(java.lang.IllegalArgumentException e0){
             }
             this.finish();
             break;
           case 27:
             try{
                if (this.mSmsHander != null && this.mSmsRunnable != null) {
                   this.mSmsHander.removeCallbacks(this.mSmsRunnable);
                   contentResol = this.getContentResolver();
                   tmSmsContent = this.mSmsContent;
                   contentResol.unregisterContentObserver(tmSmsContent);
                   this.unregisterReceiver(this.mSmsReceiver);
                }
             }catch(java.lang.IllegalArgumentException e0){
             }
             this.buildPaymentView();
             break;
       }
       return;
    }
    public void onWarningDialogOK(int paramInt){
       try{
          switch (paramInt){
              case 0:
              case 22:
              case 1:
                this.finish();
                break;
              case 10:
                this.pay();
                break;
              case 13:
                Intent localIntent = new Intent();
                this.setResult(-1, localIntent);
                this.finish();
                break;
              case 15:
              case 24:
              case 16:
                break;
              case 20:
                PrefUtil.clearPayedAmount(this.getApplicationContext());
                break;
              case 21:
              case 25:
                if (this.mSmsHander != null && this.mSmsRunnable != null) {
                   this.mSmsHander.removeCallbacks(this.mSmsRunnable);
                }
                if (this.mSmsContent != null) {
                   this.getContentResolver().unregisterContentObserver(this.mSmsContent);
                }
                this.unregisterReceiver(this.mSmsReceiver);
                break;
              case 23:
                this.showDialog(24);
                break;
              case 26:
                if (4 == this.mType) {
                   this.sendFirstSms(this.mSmsInfo);
                }else {
                   this.sendConfirmSms(this.mConfirmSmsInfoString);
                }
                break;
              case 36:
                this.pay();
                break;
          }
       label_0003 :
          return;
       }catch(java.lang.IllegalArgumentException e1){
       }
       this.buildPaymentView();
       goto label_0003 ;
    }
}
