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
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
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
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.uc.paymentsdk.commons.ui.CustomAdapter;
import com.uc.paymentsdk.model.IType;
import com.uc.paymentsdk.model.TypeFactory;
import com.uc.paymentsdk.network.Api;
import com.uc.paymentsdk.network.ApiTask$TaskHandler;
import com.uc.paymentsdk.network.XMLParser;
import com.uc.paymentsdk.network.chain.Handler$OnFinishListener;
import com.uc.paymentsdk.network.chain.HandlerProxy;
import com.uc.paymentsdk.network.chain.SyncChargeChannelHandler;
import com.uc.paymentsdk.network.chain.SyncPayChannelHandler;
import com.uc.paymentsdk.network.chain.SyncSmsInfoHandler;
import com.uc.paymentsdk.payment.sms.SimCardNotSupportException;
import com.uc.paymentsdk.payment.sms.SmsInfo;
import com.uc.paymentsdk.payment.upoint.UPointInfo;
import com.uc.paymentsdk.payment.upoint.UPointPayInfo;
import com.uc.paymentsdk.util.DialogUtil;
import com.uc.paymentsdk.util.DialogUtil$ProgressDialogListener;
import com.uc.paymentsdk.util.DialogUtil$WarningDialogListener;
import com.uc.paymentsdk.util.PrefUtil;
import com.uc.paymentsdk.util.Utils;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;
import org.apache.http.HttpResponse;

public class PaymentsActivity extends Activity implements View.OnClickListener, ApiTask$TaskHandler, AdapterView.OnItemClickListener, DialogUtil$WarningDialogListener, Handler$OnFinishListener {
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
   private final BroadcastReceiver mSmsReceiver = new PaymentsActivity$1(this);
   private String mSmsResultInfo;
   private final Runnable mSmsRunnable = new PaymentsActivity$2(this);
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
   }

   // $FF: synthetic method
   static int access$0(PaymentsActivity var0) {
      return var0.mType;
   }

   // $FF: synthetic method
   static SmsInfo access$1(PaymentsActivity var0) {
      return var0.mSmsInfo;
   }

   // $FF: synthetic method
   static ContentObserver access$10(PaymentsActivity var0) {
      return var0.mSmsContent;
   }

   // $FF: synthetic method
   static int access$11(PaymentsActivity var0) {
      return var0.mSmsId;
   }

   // $FF: synthetic method
   static int access$12(PaymentsActivity var0) {
      return var0.mLeftSmsToReceiveCount;
   }

   // $FF: synthetic method
   static Handler access$13(PaymentsActivity var0) {
      return var0.mSmsHander;
   }

   // $FF: synthetic method
   static Runnable access$14(PaymentsActivity var0) {
      return var0.mSmsRunnable;
   }

   // $FF: synthetic method
   static void access$15(PaymentsActivity var0, int var1) {
      var0.mSmsId = var1;
   }

   // $FF: synthetic method
   static void access$16(PaymentsActivity var0, int var1) {
      var0.mLeftSmsToReceiveCount = var1;
   }

   // $FF: synthetic method
   static void access$17(PaymentsActivity var0, boolean var1) {
      var0.mIsSynced = var1;
   }

   // $FF: synthetic method
   static void access$18(PaymentsActivity var0, TextView var1, TextView var2, int var3, Button var4, Button var5, RelativeLayout var6) {
      var0.initSmsPayView(var1, var2, var3, var4, var5, var6);
   }

   // $FF: synthetic method
   static void access$2(PaymentsActivity var0, String var1, String var2) {
      var0.buildSmsPaymentConfirmView(var1, var2);
   }

   // $FF: synthetic method
   static int access$3(PaymentsActivity var0) {
      return var0.mLeftSmsToSendCount;
   }

   // $FF: synthetic method
   static void access$4(PaymentsActivity var0, int var1) {
      var0.mLeftSmsToSendCount = var1;
   }

   // $FF: synthetic method
   static int access$5(PaymentsActivity var0) {
      return var0.getPayedAmount();
   }

   // $FF: synthetic method
   static void access$6(PaymentsActivity var0) {
      var0.buildSmsPaymentView();
   }

   // $FF: synthetic method
   static BroadcastReceiver access$7(PaymentsActivity var0) {
      return var0.mSmsReceiver;
   }

   // $FF: synthetic method
   static void access$8(PaymentsActivity var0, String var1) {
      var0.mSmsResultInfo = var1;
   }

   // $FF: synthetic method
   static PaymentInfo access$9(PaymentsActivity var0) {
      return var0.mPaymentInfo;
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
      RelativeLayout var3 = Utils.initSubTitle(this.getApplicationContext(), this, "\u8d2d\u4e70\u5185\u5bb9", false);
      TextView var1 = new TextView(this.getApplicationContext());
      var1.setTextSize(16.0F);
      var1.setTextColor(Color.parseColor("#FF858D8D"));
      var1.setPadding(10, 10, 0, 10);
      var1.setText("\u5c0a\u656c\u7684\u7528\u6237\uff0c\u60a8\u9700\u8981\u4e3a\u4ee5\u4e0b\u5185\u5bb9\u652f\u4ed8\u8d39\u7528\uff0c\u8bf7\u9605\u8bfb\u4ee5\u4e0b\u4fe1\u606f\uff0c\u786e\u8ba4\u6240\u8d2d\u5185\u5bb9\u65e0\u8bef\u3002");
      TextView var4 = new TextView(this.getApplicationContext());
      var4.setTextSize(16.0F);
      var4.setPadding(20, 0, 20, 0);
      var4.setText(String.format("\u6240\u8d2d\u5185\u5bb9 : %s", this.mPaymentInfo.getPaydesc()));
      var4.setTextColor(-12303292);
      String var5 = (new DecimalFormat("##0.00")).format((double)((float)this.mPaymentInfo.getMoney() / 10.0F));
      TextView var2 = new TextView(this.getApplicationContext());
      var2.setTextSize(16.0F);
      var2.setPadding(20, 0, 0, 20);
      var2.setText(String.format("\u652f\u4ed8\u91d1\u989d: %s\u5143", var5));
      var2.setTextColor(-12303292);
      LinearLayout var7 = new LinearLayout(this.getApplicationContext());
      var7.setBackgroundColor(-1);
      var7.setOrientation(1);
      LinearLayout.LayoutParams var6 = new LinearLayout.LayoutParams(-1, -2);
      var7.addView(var3, var6);
      var7.addView(var1, var6);
      var7.addView(var4, var6);
      var7.addView(var2, var6);
      this.mListView = new ListView(this.getApplicationContext());
      this.mListView.setBackgroundColor(-1);
      this.mListView.setCacheColorHint(-1);
      this.mListView.addHeaderView(var7, (Object)null, true);
      this.mListView.setOnItemClickListener(this);
      this.mListView.addFooterView(Utils.generateFooterView(this), (Object)null, false);
      this.setContentView(this.mListView);
      this.fillData();
      (new HandlerProxy(this.getApplicationContext(), this)).handleRequest();
   }

   private void buildSmsPaymentConfirmView(String var1, String var2) {
      this.mType = 5;

      try {
         Utils.CheckSimCardSupprotInfo(this.getApplicationContext());
      } catch (SimCardNotSupportException var6) {
         this.mSmsResultInfo = var6.getMessage();
         this.showDialog(16);
         return;
      }

      RelativeLayout var3 = new RelativeLayout(this.getApplicationContext());
      var3.setBackgroundColor(-1);
      var3.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
      RelativeLayout var4 = Utils.initSubTitle(this.getApplicationContext(), this, "\u8d2d\u4e70\u5185\u5bb9", true);
      var4.setId(1);
      var4.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
      var3.addView(var4);
      TextView var10 = new TextView(this);
      var10.setId(2);
      var10.setTextSize(16.0F);
      var10.setTextColor(-13487566);
      var10.setPadding(10, 10, 0, 0);
      var10.setFocusable(true);
      var10.setClickable(true);
      var10.setLinkTextColor(-24576);
      var10.setText(String.format("\u518d\u6b21\u70b9\u51fb\u4e0b\u4e00\u6b65\u5373\u540c\u610f\u5411\n%s\u53d1\u9001\u77ed\u4fe1\u4ee5\u5b8c\u6210\u672c\u6b21\u77ed\u4fe1\u53d1\u9001\u8fc7\u7a0b\u3002", var1, this.mPaymentInfo.getPayname(), Utils.getSmsPayment()));
      Linkify.addLinks(var10, 4);
      RelativeLayout.LayoutParams var5 = new RelativeLayout.LayoutParams(-1, -2);
      var5.addRule(3, 1);
      var10.setLayoutParams(var5);
      var3.addView(var10);
      Button var11 = new Button(this.getApplicationContext());
      var11.setText("\u4e0b\u4e00\u6b65");
      var11.setId(5);
      this.mConfirmSmsInfoString = var1 + ",,,," + var2;
      var11.setTag(this.mConfirmSmsInfoString);
      var11.setOnClickListener(this);
      RelativeLayout.LayoutParams var7 = new RelativeLayout.LayoutParams(150, -2);
      var7.addRule(12, -1);
      var7.setMargins(10, 20, 10, 10);
      var11.setLayoutParams(var7);
      var3.addView(var11);
      Button var8 = new Button(this.getApplicationContext());
      var8.setText("\u53d6\u6d88");
      var8.setId(6);
      var8.setOnClickListener(this);
      RelativeLayout.LayoutParams var9 = new RelativeLayout.LayoutParams(150, -2);
      var9.addRule(11, -1);
      var9.addRule(12, -1);
      var9.setMargins(10, 20, 10, 10);
      var8.setLayoutParams(var9);
      var3.addView(var8);
      this.setContentView(var3);
   }

   private void buildSmsPaymentView() {
      this.mType = 4;
      this.mSmsId = 0;
      RelativeLayout var2 = new RelativeLayout(this.getApplicationContext());
      var2.setBackgroundColor(-1);
      var2.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
      RelativeLayout var3 = Utils.initSubTitle(this.getApplicationContext(), this, "\u77ed\u4fe1\u652f\u4ed8", false);
      var3.setId(1);
      var3.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
      var2.addView(var3);
      TextView var8 = new TextView(this);
      var8.setId(2);
      var8.setTextSize(18.0F);
      var8.setTextColor(-12303292);
      var8.setPadding(10, 10, 0, 0);
      var8.setFocusable(true);
      var8.setClickable(true);
      var8.setLinkTextColor(-24576);
      var8.setText("\u5c0a\u656c\u7684\u7528\u6237\uff0c\u6b63\u5728\u83b7\u53d6\u4fe1\u606f\uff0c\u8bf7\u7a0d\u540e......");
      RelativeLayout.LayoutParams var4 = new RelativeLayout.LayoutParams(-1, -2);
      var4.addRule(3, 1);
      var8.setLayoutParams(var4);
      var2.addView(var8);
      TextView var9 = new TextView(this);
      var9.setId(3);
      var9.setTextSize(16.0F);
      var9.setTextColor(-7829368);
      var9.setPadding(10, 30, 0, 0);
      var9.setFocusable(true);
      var9.setClickable(true);
      var9.setLinkTextColor(-24576);
      RelativeLayout.LayoutParams var5 = new RelativeLayout.LayoutParams(-1, -2);
      var5.addRule(3, 2);
      var9.setLayoutParams(var5);
      var2.addView(var9);
      Button var6 = new Button(this.getApplicationContext());
      var6.setText("\u70b9\u64ad");
      var6.setId(3);
      var6.setOnClickListener(this);
      Button var10 = new Button(this.getApplicationContext());
      var10.setText("\u53d6\u6d88");
      var10.setId(4);
      var10.setOnClickListener(this);

      try {
         Utils.CheckSimCardSupprotInfo(this.getApplicationContext());
      } catch (SimCardNotSupportException var7) {
         this.mSmsResultInfo = var7.getMessage();
         this.showDialog(16);
         return;
      }

      int var1 = Utils.getSmsPayment();
      if (var1 <= PrefUtil.getPayedAmount(this.getApplicationContext())) {
         this.mSmsResultInfo = "\u60a8\u5df2\u652f\u4ed8\u5b8c\u6210\uff0c\u5c06\u8fd4\u56de\u60a8\u7684\u6e38\u620f\u4e2d\u3002";
         this.showDialog(20);
      } else if (!this.mIsSynced) {
         this.showDialog(19);
         (new SyncSmsInfoHandler(this.getApplicationContext(), new PaymentsActivity$3(this, var8, var9, var1, var10, var6, var2))).handleRequest();
      } else {
         this.initSmsPayView(var8, var9, var1, var10, var6, var2);
      }

   }

   private void buildUPointPayLoginView() {
      this.mType = 2;
      RelativeLayout var2 = Utils.initSubTitle(this.getApplicationContext(), this, "\u8bf7\u60a8\u8f93\u5165UC\u5e10\u53f7", true);
      var2.setId(10);
      RelativeLayout.LayoutParams var1 = new RelativeLayout.LayoutParams(-1, -2);
      var1.addRule(10, -1);
      var2.setLayoutParams(var1);
      TextView var3 = new TextView(this.getApplicationContext());
      var1 = new RelativeLayout.LayoutParams(-1, -2);
      var1.addRule(3, 10);
      var1.setMargins(10, 5, 10, 10);
      var3.setLayoutParams(var1);
      var3.setId(1);
      var3.setCompoundDrawablePadding(10);
      var3.setTextColor(-13487566);
      String var8;
      if (Utils.isHdpi()) {
         var8 = "lock_hdpi.png";
      } else {
         var8 = "lock.png";
      }

      var3.setCompoundDrawablesWithIntrinsicBounds(Utils.getDrawableFromFile(var8), (Drawable)null, (Drawable)null, (Drawable)null);
      var3.setText("\u60a8\u597d\uff0c\u8d2d\u4e70\u6b64\u5185\u5bb9\uff0c\u8bf7\u5148\u767b\u5f55UC\u8d26\u53f7\u3002\u60a8\u53ef\u4ee5\u8f93\u5165UC\u5e10\u53f7\u6216\u8005\u624b\u673a\u53f7\u7801\u8fdb\u884c\u767b\u5f55");
      TextView var10 = Utils.generateBorderView(this.getApplication());
      var10.setId(11);
      RelativeLayout.LayoutParams var4 = new RelativeLayout.LayoutParams(-1, 1);
      var4.addRule(3, 1);
      var10.setLayoutParams(var4);
      RelativeLayout.LayoutParams var5 = new RelativeLayout.LayoutParams(-1, -2);
      var5.setMargins(10, 10, 10, 5);
      TextView var12 = new TextView(this.getApplicationContext());
      var12.setLayoutParams(var5);
      var12.setId(2);
      var12.setText("UC\u8d26\u53f7:");
      var12.setTextColor(-13487566);
      var5 = new RelativeLayout.LayoutParams(-1, -2);
      var5.addRule(3, 2);
      var5.setMargins(10, 5, 10, 5);
      this.mEtUsername = new EditText(this.getApplicationContext());
      this.mEtUsername.setLayoutParams(var5);
      this.mEtUsername.setSingleLine();
      this.mEtUsername.setId(3);
      this.mEtUsername.setHint("\u7528\u6237\u540d");
      this.mEtPassword = new EditText(this.getApplicationContext());
      this.mEtPassword.setId(4);
      this.mEtPassword.setHint("\u5bc6\u7801");
      this.mEtPassword.setSingleLine();
      this.mEtPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
      var5 = new RelativeLayout.LayoutParams(-1, -2);
      var5.addRule(3, 3);
      var5.setMargins(10, 5, 10, 5);
      this.mEtPassword.setLayoutParams(var5);
      this.mEtSavePass = new CheckBox(this.getApplicationContext());
      var5 = new RelativeLayout.LayoutParams(-1, -2);
      var5.addRule(3, 4);
      var5.setMargins(10, 5, 10, 5);
      this.mEtSavePass.setId(5);
      this.mEtSavePass.setTextColor(-12303292);
      this.mEtSavePass.setText("\u4fdd\u5b58\u5bc6\u7801");
      this.mEtSavePass.setLayoutParams(var5);
      if (PrefUtil.getUCUserName(this.getApplicationContext()) != null) {
         this.mEtUsername.setText(PrefUtil.getUCUserName(this.getApplicationContext()));
         this.mEtSavePass.setChecked(true);
      } else {
         this.mEtSavePass.setChecked(false);
      }

      if (PrefUtil.getUCUserPass(this.getApplicationContext()) != null) {
         this.mEtPassword.setText(PrefUtil.getUCUserPass(this.getApplicationContext()));
      }

      Button var6 = new Button(this.getApplicationContext());
      var6.setId(7);
      var6.setText("\u786e\u5b9a\u8d2d\u4e70");
      var6.setOnClickListener(this);
      var5 = new RelativeLayout.LayoutParams(-1, -2);
      var5.topMargin = 10;
      var5.addRule(3, 5);
      var5.addRule(14);
      var6.setLayoutParams(var5);
      RelativeLayout var14 = new RelativeLayout(this.getApplicationContext());
      var14.setId(7);
      var14.setBackgroundColor(-984326);
      RelativeLayout.LayoutParams var7 = new RelativeLayout.LayoutParams(-1, -2);
      var7.addRule(3, 11);
      var14.setLayoutParams(var7);
      var14.addView(var12);
      var14.addView(this.mEtUsername);
      var14.addView(this.mEtPassword);
      var14.addView(this.mEtSavePass);
      var14.addView(var6);
      RelativeLayout var13 = new RelativeLayout(this.getApplicationContext());
      var13.setBackgroundColor(-1);
      var13.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
      var13.addView(var2);
      var13.addView(var3);
      var13.addView(var10);
      var13.addView(var14);
      var10 = Utils.generateBorderView(this.getApplication());
      RelativeLayout.LayoutParams var9 = new RelativeLayout.LayoutParams(-1, 1);
      var9.addRule(3, 7);
      var10.setLayoutParams(var9);
      var13.addView(var10);
      ScrollView var11 = new ScrollView(this.getApplication());
      var11.setBackgroundColor(-1);
      var11.addView(var13);
      this.setContentView(var11);
   }

   private void buildUPointPayPassView() {
      this.mType = 3;
      RelativeLayout var2 = Utils.initSubTitle(this.getApplicationContext(), this, "\u8bf7\u60a8\u8f93\u5165U\u70b9\u652f\u4ed8\u5bc6\u7801", true);
      var2.setId(10);
      RelativeLayout.LayoutParams var1 = new RelativeLayout.LayoutParams(-1, -2);
      var1.addRule(10, -1);
      var2.setLayoutParams(var1);
      TextView var3 = new TextView(this.getApplicationContext());
      var1 = new RelativeLayout.LayoutParams(-1, -2);
      var1.addRule(3, 10);
      var1.setMargins(10, 5, 10, 10);
      var3.setLayoutParams(var1);
      var3.setId(1);
      var3.setCompoundDrawablePadding(10);
      var3.setTextColor(-13487566);
      String var8;
      if (Utils.isHdpi()) {
         var8 = "lock_hdpi.png";
      } else {
         var8 = "lock.png";
      }

      var3.setCompoundDrawablesWithIntrinsicBounds(Utils.getDrawableFromFile(var8), (Drawable)null, (Drawable)null, (Drawable)null);
      var3.setText("\u60a8\u597d\uff0c\u60a8\u7684U\u70b9\u8bbe\u7f6e\u6709\u652f\u4ed8\u5bc6\u7801\uff0c\u8bf7\u6536\u5165\u540e\u70b9\u51fb\u786e\u8ba4\u8fdb\u884c\u652f\u4ed8");
      TextView var10 = Utils.generateBorderView(this.getApplication());
      var10.setId(11);
      RelativeLayout.LayoutParams var4 = new RelativeLayout.LayoutParams(-1, 1);
      var4.addRule(3, 1);
      var10.setLayoutParams(var4);
      RelativeLayout.LayoutParams var5 = new RelativeLayout.LayoutParams(-1, -2);
      var5.setMargins(10, 10, 10, 5);
      TextView var12 = new TextView(this.getApplicationContext());
      var12.setLayoutParams(var5);
      var12.setId(2);
      var12.setText("UC\u652f\u4ed8\u5bc6\u7801:");
      var12.setTextColor(-13487566);
      var5 = new RelativeLayout.LayoutParams(-1, -2);
      var5.addRule(3, 2);
      var5.setMargins(10, 5, 10, 5);
      this.mEtPayPass = new EditText(this.getApplicationContext());
      this.mEtPayPass.setLayoutParams(var5);
      this.mEtPayPass.setSingleLine();
      this.mEtPayPass.setId(3);
      this.mEtPayPass.setHint("\u652f\u4ed8\u5bc6\u7801");
      Button var6 = new Button(this.getApplicationContext());
      var6.setId(7);
      var6.setText("\u786e\u5b9a\u8d2d\u4e70");
      var6.setOnClickListener(this);
      var5 = new RelativeLayout.LayoutParams(-1, -2);
      var5.topMargin = 10;
      var5.addRule(3, 5);
      var5.addRule(14);
      var6.setLayoutParams(var5);
      RelativeLayout var14 = new RelativeLayout(this.getApplicationContext());
      var14.setId(7);
      var14.setBackgroundColor(-984326);
      RelativeLayout.LayoutParams var7 = new RelativeLayout.LayoutParams(-1, -2);
      var7.addRule(3, 11);
      var14.setLayoutParams(var7);
      var14.addView(var12);
      var14.addView(this.mEtPayPass);
      var14.addView(var6);
      RelativeLayout var13 = new RelativeLayout(this.getApplicationContext());
      var13.setBackgroundColor(-1);
      var13.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
      var13.addView(var2);
      var13.addView(var3);
      var13.addView(var10);
      var13.addView(var14);
      TextView var9 = Utils.generateBorderView(this.getApplication());
      var1 = new RelativeLayout.LayoutParams(-1, 1);
      var1.addRule(3, 7);
      var9.setLayoutParams(var1);
      var13.addView(var9);
      ScrollView var11 = new ScrollView(this.getApplication());
      var11.setBackgroundColor(-1);
      var11.addView(var13);
      this.setContentView(var11);
   }

   private void buildUPointPaymentView() {
      this.mType = 1;
      TextView var1 = new TextView(this.getApplicationContext());
      var1.setTextSize(16.0F);
      var1.setPadding(20, 0, 20, 0);
      var1.setTextColor(-12303292);
      var1.setText(String.format("\u652f\u4ed8\u540d\u79f0 : %s", this.mPaymentInfo.getPayname()));
      this.mTvProduct = new TextView(this.getApplicationContext());
      this.mTvProduct.setTextSize(16.0F);
      this.mTvProduct.setPadding(20, 0, 20, 0);
      this.mTvProduct.setText("\u4ea7\u54c1\u540d : ");
      this.mTvProduct.setTextColor(-12303292);
      TextView var2 = new TextView(this.getApplicationContext());
      var2.setTextSize(16.0F);
      var2.setPadding(20, 0, 20, 20);
      var2.setText(String.format("\u6240\u8d2d\u5185\u5bb9 : %s", this.mPaymentInfo.getPaydesc()));
      var2.setTextColor(-12303292);
      TextView var5 = new TextView(this.getApplicationContext());
      var5.setTextSize(16.0F);
      var5.setPadding(20, 0, 20, 0);
      var5.setText(String.format("\u652f\u4ed8\u6570\u989d : %dU\u70b9\uff08\u4ef7\u503c%s\u5143\uff09", this.mPaymentInfo.getMoney(), (new DecimalFormat("##0.00")).format((double)((float)this.mPaymentInfo.getMoney() / 10.0F))));
      var5.setTextColor(-13487566);
      this.mTvDiscountTextView = new TextView(this.getApplicationContext());
      this.mTvDiscountTextView.setTextSize(16.0F);
      this.mTvDiscountTextView.setPadding(20, 0, 20, 0);
      this.mTvDiscountTextView.setText("U\u70b9\u6298\u6263 : ");
      this.mTvDiscountTextView.setTextColor(-13487566);
      this.mTvVipDiscountTextView = new TextView(this.getApplicationContext());
      this.mTvVipDiscountTextView.setTextSize(16.0F);
      this.mTvVipDiscountTextView.setPadding(20, 0, 20, 0);
      this.mTvVipDiscountTextView.setText("\u4f1a\u5458\u6298\u6263 : ");
      this.mTvVipDiscountTextView.setTextColor(-13487566);
      this.mTvVipDiscountTimeTextView = new TextView(this.getApplicationContext());
      this.mTvVipDiscountTimeTextView.setTextSize(16.0F);
      this.mTvVipDiscountTimeTextView.setPadding(20, 0, 20, 0);
      this.mTvVipDiscountTimeTextView.setText("\u4f1a\u5458\u6298\u6263\u5230\u671f\u65f6\u95f4 : ");
      this.mTvVipDiscountInfo = new TextView(this.getApplicationContext());
      this.mTvVipDiscountInfo.setTextColor(-13487566);
      this.mTvVipDiscountInfo = new TextView(this.getApplicationContext());
      this.mTvVipDiscountInfo.setTextSize(16.0F);
      this.mTvVipDiscountInfo.setPadding(20, 0, 20, 0);
      this.mTvVipDiscountInfo.setText("\u4f1a\u5458\u6298\u6263\u4fe1\u606f : ");
      this.mTvVipDiscountInfo.setTextColor(-13487566);
      this.mBtnPay = new Button(this.getApplicationContext());
      this.mBtnPay.setText("\u786e\u8ba4");
      this.mBtnPay.setOnClickListener(this);
      this.mBtnPay.setVisibility(8);
      LinearLayout.LayoutParams var4 = new LinearLayout.LayoutParams(300, -2);
      var4.gravity = 1;
      LinearLayout var3 = new LinearLayout(this.getApplicationContext());
      var3.addView(this.mBtnPay, var4);
      var3.setGravity(1);
      LinearLayout var8 = new LinearLayout(this.getApplicationContext());
      var8.setOrientation(1);
      var8.setBackgroundColor(-1);
      LinearLayout.LayoutParams var6 = new LinearLayout.LayoutParams(-1, -2);
      var8.addView(Utils.initSubTitle(this.getApplicationContext(), this, "\u9700\u8981\u652f\u4ed8\u7684\u5185\u5bb9", true), var6);
      var8.addView(var1, var6);
      var8.addView(this.mTvProduct, var6);
      var8.addView(var2, var6);
      var8.addView(var5, var6);
      var8.addView(this.mTvDiscountTextView, var6);
      var8.addView(this.mTvVipDiscountTextView, var6);
      var8.addView(this.mTvVipDiscountTimeTextView, var6);
      var8.addView(this.mTvVipDiscountInfo, var6);
      var8.addView(var3, var6);
      ScrollView var7 = new ScrollView(this.getApplicationContext());
      var7.setBackgroundColor(-1);
      var7.addView(var8);
      this.setContentView(var7);
      if (Utils.getUPointInfo() == null) {
         this.showDialog(14);
         Api.queryUPointDiscount(this.getApplicationContext(), this, Utils.getPaymentInfo().getCpID(), Utils.getPaymentInfo().getmGameID(), Utils.getPaymentInfo().getMoney());
      } else {
         this.initUPointPayView(Utils.getUPointInfo());
      }

   }

   private void fillData() {
      ArrayList var2 = PrefUtil.getAvailablePayType(this.getApplicationContext(), this.mPaymentInfo.getPaytype());
      IType[] var1 = new IType[var2.size()];
      if ("overage".equals(this.mPaymentInfo.getPaytype())) {
         Iterator var3 = var2.iterator();

         while(var3.hasNext()) {
            IType var4 = (IType)var3.next();
            if ("upoint".equals(var4.getId())) {
               var1[0] = var4;
               break;
            }
         }
      } else {
         Iterator var5;
         IType var6;
         if ("sms".equals(this.mPaymentInfo.getPaytype())) {
            var5 = var2.iterator();

            while(var5.hasNext()) {
               var6 = (IType)var5.next();
               if ("sms".equals(var6.getId())) {
                  var1[0] = var6;
                  break;
               }
            }
         } else {
            var5 = var2.iterator();

            while(var5.hasNext()) {
               var6 = (IType)var5.next();
               if ("upoint".equals(var6.getId())) {
                  var1[0] = var6;
               } else if ("sms".equals(var6.getId())) {
                  var1[var1.length - 1] = var6;
               }
            }
         }
      }

      this.mListView.setAdapter(new CustomAdapter(this.getApplicationContext(), var1));
   }

   private int getPayedAmount() {
      int var1 = (Utils.getSmsPayment() - PrefUtil.getPayedAmount(this.getApplicationContext())) / this.mSmsInfo.money;
      return this.mSmsInfo.money * (var1 - this.mLeftSmsToSendCount);
   }

   public static void init(Context var0) {
      SyncChargeChannelHandler.init();
      SyncPayChannelHandler.init();
      SyncSmsInfoHandler.init();
   }

   private boolean initPayment() {
      this.mPaymentInfo = (PaymentInfo)this.getIntent().getSerializableExtra("com.mappn.sdk.paymentinfo");
      if (this.mPaymentInfo == null) {
         throw new IllegalArgumentException("PaymentInfo\u5fc5\u987b\u8bbe\u7f6e");
      } else {
         this.mPaymentInfo.setPaytype("sms");
         int var1 = this.mPaymentInfo.getMoney();
         boolean var2;
         if (var1 > 0 && var1 <= 10000 && var1 % 5 == 0) {
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

            label92: {
               try {
                  String var3 = Utils.getCpID(this.getApplicationContext());
                  if (Pattern.matches("^[0-9a-zA-Z]{1,10}$", var3)) {
                     this.mPaymentInfo.setCpID(var3);
                     break label92;
                  }

                  this.showDialog(22);
               } catch (PackageManager.NameNotFoundException var4) {
                  this.showDialog(22);
                  break label92;
               } catch (NullPointerException var5) {
                  this.showDialog(22);
                  break label92;
               }

               var2 = false;
               return var2;
            }

            if (this.mPaymentInfo.getUsername() != null) {
               PrefUtil.setUCUserName(this.getApplicationContext(), this.mPaymentInfo.getUsername());
            }

            Utils.setPaymentInfo(this.mPaymentInfo);
            var2 = true;
         } else {
            this.showDialog(0);
            var2 = false;
         }

         return var2;
      }
   }

   private void initSmsPayView(TextView var1, TextView var2, int var3, Button var4, Button var5, RelativeLayout var6) {
      RelativeLayout.LayoutParams var11 = new RelativeLayout.LayoutParams(150, -2);

      label142: {
         SimCardNotSupportException var10000;
         label146: {
            int var8;
            boolean var10001;
            try {
               var8 = PrefUtil.getPayedAmount(this.getApplicationContext());
            } catch (SimCardNotSupportException var27) {
               var10000 = var27;
               var10001 = false;
               break label146;
            }

            int var7;
            Spanned var10;
            if (var8 == 0) {
               label147: {
                  try {
                     if (this.mSmsInfo == null) {
                        this.mSmsInfo = Utils.getSmsInfos().filterSmsInfo(this.getApplicationContext(), var3);
                        this.mSmsInfo.setExtInfo(this.mPaymentInfo);
                     }
                  } catch (SimCardNotSupportException var24) {
                     var10000 = var24;
                     var10001 = false;
                     break label146;
                  }

                  try {
                     var8 = var3 / this.mSmsInfo.money;
                  } catch (SimCardNotSupportException var21) {
                     var10000 = var21;
                     var10001 = false;
                     break label146;
                  }

                  var7 = var8;

                  label109: {
                     try {
                        if (var3 % this.mSmsInfo.money == 0) {
                           break label109;
                        }
                     } catch (SimCardNotSupportException var23) {
                        var10000 = var23;
                        var10001 = false;
                        break label146;
                     }

                     var7 = var8 + 1;
                  }

                  label104: {
                     label148: {
                        try {
                           if (this.mSmsInfo.isNeedconfirm()) {
                              break label104;
                           }

                           if (this.mLeftSmsToSendCount == -1) {
                              this.mLeftSmsToReceiveCount = var7;
                              this.mLeftSmsToSendCount = var7;
                              var10 = Html.fromHtml(String.format("\u5c0a\u656c\u7684\u7528\u6237\uff0c\u611f\u8c22\u60a8\u4e3a\u6e38\u620f\u652f\u4ed8\uff0c\u60a8\u9700\u8981\u53d1\u9001<font color='#FF4500'>[ %d ]</font>\u6761 %d \u5143\u7684\u77ed\u4fe1\uff0c\u8d2d\u4e70<font color='#FF4500'>[%s]</font>\uff0c\u5171\u8ba1<font color='#FF4500'>[ %d ]</font>\u5143\uff0c\u70b9\u51fb<font color='#FF4500'>[\u70b9\u64ad]</font>\u5f00\u59cb\u53d1\u9001\u3002\u8bf7\u6ce8\u610f\u53d1\u9001\u5f00\u59cb\u540e\uff0c\u60a8\u4e0d\u80fd\u4e2d\u65ad\u53d1\u9001\uff0c\u5426\u5219\u8d2d\u4e70\u5c06\u4e0d\u6210\u529f\u3002", this.mLeftSmsToSendCount, this.mSmsInfo.money, this.mPaymentInfo.getPayname(), var3));
                              this.mIsShowInfo = true;
                              break label148;
                           }
                        } catch (SimCardNotSupportException var22) {
                           var10000 = var22;
                           var10001 = false;
                           break label146;
                        }

                        try {
                           var10 = Html.fromHtml(String.format("\u5c0a\u656c\u7684\u7528\u6237\uff0c\u70b9\u51fb<font color='#FF4500'>[\u786e\u5b9a]</font>\u6309\u94ae\uff0c\u53d1\u9001\u7b2c<font color='#FF4500'>[ %d ]</font>\u6761\u77ed\u4fe1\u3002", var7 - this.mLeftSmsToSendCount + 1));
                           var4.setVisibility(8);
                           var5.setText("\u786e\u5b9a");
                           var11.addRule(14, -1);
                        } catch (SimCardNotSupportException var20) {
                           var10000 = var20;
                           var10001 = false;
                           break label146;
                        }
                     }

                     try {
                        var1.setText(var10);
                        var2.setText(this.mSmsInfo.getInfobeforesend());
                        break label147;
                     } catch (SimCardNotSupportException var19) {
                        var10000 = var19;
                        var10001 = false;
                        break label146;
                     }
                  }

                  try {
                     var1.setText(this.mSmsInfo.getInfobeforesend());
                     var4.setVisibility(8);
                     var5.setText("\u786e\u5b9a");
                     var11.addRule(14, -1);
                  } catch (SimCardNotSupportException var18) {
                     var10000 = var18;
                     var10001 = false;
                     break label146;
                  }
               }
            } else {
               label150: {
                  int var9 = var3 - var8;

                  try {
                     if (this.mSmsInfo == null) {
                        this.mSmsInfo = Utils.getSmsInfos().filterSmsInfo(this.getApplicationContext(), var9);
                        this.mSmsInfo.setExtInfo(this.mPaymentInfo);
                     }
                  } catch (SimCardNotSupportException var17) {
                     var10000 = var17;
                     var10001 = false;
                     break label146;
                  }

                  label151: {
                     label152: {
                        label153: {
                           try {
                              if (this.mSmsInfo.isNeedconfirm()) {
                                 break label152;
                              }

                              if (this.mLeftSmsToSendCount != -1) {
                                 break label153;
                              }

                              var7 = var9 / this.mSmsInfo.money;
                           } catch (SimCardNotSupportException var26) {
                              var10000 = var26;
                              var10001 = false;
                              break label146;
                           }

                           var3 = var7;

                           label121: {
                              try {
                                 if (var9 % this.mSmsInfo.money == 0) {
                                    break label121;
                                 }
                              } catch (SimCardNotSupportException var25) {
                                 var10000 = var25;
                                 var10001 = false;
                                 break label146;
                              }

                              var3 = var7 + 1;
                           }

                           try {
                              this.mIsShowInfo = true;
                              this.mLeftSmsToSendCount = var3;
                              this.mLeftSmsToReceiveCount = var3;
                              var10 = Html.fromHtml(String.format("\u60a8\u4ee5\u524d\u6210\u529f\u53d1\u9001\u8fc7\u603b\u8ba1 %d \u5143\u7684\u77ed\u4fe1\u8d2d\u4e70<font color='#FF4500'>[%s]</font>\uff0c\u76ee\u524d\u8fd8\u9700\u53d1\u9001<font color='#FF4500'>[ %d ]</font>\u6761  %d \u5143\u77ed\u4fe1\u7ee7\u7eed\u8d2d\u4e70\uff0c\u70b9\u51fb<font color='#FF4500'>[\u70b9\u64ad]</font>\u6309\u94ae\u5f00\u59cb\u53d1\u9001\u3002", var8, this.mPaymentInfo.getPayname(), this.mLeftSmsToSendCount, this.mSmsInfo.money));
                              break label151;
                           } catch (SimCardNotSupportException var16) {
                              var10000 = var16;
                              var10001 = false;
                              break label146;
                           }
                        }

                        try {
                           var10 = Html.fromHtml(String.format("\u5c0a\u656c\u7684\u7528\u6237\uff0c\u70b9\u51fb<font color='#FF4500'>[\u786e\u5b9a]</font>\u6309\u94ae\uff0c\u5f00\u59cb\u53d1\u9001\u7b2c<font color='#FF4500'>[ %d ]</font>\u6761\u77ed\u4fe1\u3002", var9 / this.mSmsInfo.money - this.mLeftSmsToSendCount + 1, this.mLeftSmsToSendCount));
                           var4.setVisibility(8);
                           var5.setText("\u786e\u5b9a");
                           var11.addRule(14, -1);
                           break label151;
                        } catch (SimCardNotSupportException var15) {
                           var10000 = var15;
                           var10001 = false;
                           break label146;
                        }
                     }

                     try {
                        var1.setText(this.mSmsInfo.getInfobeforesend());
                        var4.setVisibility(8);
                        var5.setText("\u786e\u5b9a");
                        var11.addRule(14, -1);
                        break label150;
                     } catch (SimCardNotSupportException var13) {
                        var10000 = var13;
                        var10001 = false;
                        break label146;
                     }
                  }

                  try {
                     var1.setText(var10);
                     var2.setText(this.mSmsInfo.getInfobeforesend());
                  } catch (SimCardNotSupportException var14) {
                     var10000 = var14;
                     var10001 = false;
                     break label146;
                  }
               }
            }

            try {
               Linkify.addLinks(var1, 4);
               Linkify.addLinks(var2, 4);
               break label142;
            } catch (SimCardNotSupportException var12) {
               var10000 = var12;
               var10001 = false;
            }
         }

         SimCardNotSupportException var28 = var10000;
         this.mSmsResultInfo = var28.getMessage();
         this.showDialog(16);
      }

      var11.addRule(12, -1);
      var11.setMargins(10, 20, 10, 10);
      var5.setLayoutParams(var11);
      var6.addView(var5);
      RelativeLayout.LayoutParams var29 = new RelativeLayout.LayoutParams(150, -2);
      var29.addRule(11, -1);
      var29.addRule(12, -1);
      var29.setMargins(10, 20, 10, 10);
      var4.setLayoutParams(var29);
      var6.addView(var4);
      this.setContentView(var6);
   }

   private void initUPointPayView(UPointInfo var1) {
      this.mTvDiscountTextView.setText(String.format("U\u70b9\u6298\u6263 : %s\u6298(%sU\u70b9)", var1.getDiscount(), var1.getDiscounttext()));
      if (var1.getVipdiscount() != null && var1.getVipdiscount().length() > 0) {
         this.mTvDiscountTextView.setText(String.format("\u4f1a\u5458\u6298\u6263 : %s\u6298(%sU\u70b9)", var1.getVipdiscount(), var1.getVipdiscounttext()));
         this.mTvVipDiscountTimeTextView.setText(String.format("\u4f1a\u5458\u6298\u6263\u5230\u671f\u65f6\u95f4 : ", var1.getVipdiscounttime()));
         this.mTvVipDiscountInfo.setText("\u4f1a\u5458\u6298\u6263\u5230\u671f\u65f6\u95f4 : " + var1.getDiscountinfo());
      } else {
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

   private void sendConfirmSms(String var1) {
      this.showDialog(17);

      try {
         SmsInfo.sendSms(this.getApplicationContext(), var1.split(",,,,")[0], var1.split(",,,,")[1]);
      } catch (Exception var3) {
         if (this.mSmsHander != null && this.mSmsRunnable != null) {
            this.mSmsHander.removeCallbacks(this.mSmsRunnable);
            this.getContentResolver().unregisterContentObserver(this.mSmsContent);

            try {
               this.unregisterReceiver(this.mSmsReceiver);
            } catch (IllegalArgumentException var2) {
            }
         }

         this.removeDialog(17);
         this.showDialog(38);
      }

   }

   private void sendFirstSms(SmsInfo var1) {
      this.showDialog(17);

      try {
         var1.sendFirstSms(this.getApplicationContext());
      } catch (Exception var3) {
         if (this.mSmsHander != null && this.mSmsRunnable != null) {
            this.mSmsHander.removeCallbacks(this.mSmsRunnable);
            this.getContentResolver().unregisterContentObserver(this.mSmsContent);

            try {
               this.unregisterReceiver(this.mSmsReceiver);
            } catch (IllegalArgumentException var2) {
            }
         }

         this.removeDialog(17);
         this.showDialog(38);
      }

   }

   public void confirmEnterPaymentPoint() {
      PrefUtil.increaseArriveCount(this.getApplicationContext());
   }

   protected void onActivityResult(int var1, int var2, Intent var3) {
      super.onActivityResult(var1, var2, var3);
   }

   public void onClick(View var1) {
      if (var1 == this.mBtnPay) {
         this.mBtnPay.setEnabled(false);
         this.buildUPointPayLoginView();
      } else {
         int var2;
         String var4;
         switch (var1.getId()) {
            case 4:
               this.buildPaymentView();
               break;
            case 5:
               if (this.mConfirmSmsInfoString != null && this.mConfirmSmsInfoString.contains(",,,,")) {
                  this.sendConfirmSms(this.mConfirmSmsInfoString);
               }
               break;
            case 6:
               this.showDialog(23);
               break;
            case 7:
               ((Button)var1).setEnabled(false);
               String var3 = this.mEtUsername.getText().toString();
               var4 = this.mEtPassword.getText().toString();
               if (TextUtils.isEmpty(var3) && TextUtils.isEmpty(var4)) {
                  this.showDialog(28);
               } else if (TextUtils.isEmpty(var4)) {
                  this.showDialog(29);
               } else if (TextUtils.isEmpty(var3)) {
                  this.showDialog(30);
               } else {
                  this.mUPayInfo = new UPointPayInfo(var3, var4, "", this.mPaymentInfo.getCpID(), this.mPaymentInfo.getmGameID(), this.mPaymentInfo.getMoney(), "");
                  this.pay();
               }
               break;
            case 8:
               ((Button)var1).setEnabled(false);
               var4 = this.mEtPayPass.getText().toString();
               if (TextUtils.isEmpty(var4)) {
                  this.showDialog(28);
               } else {
                  this.mUPayInfo.setPaypwd(var4);
                  this.pay();
               }
            case 3:
               if (this.mIsShowInfo) {
                  this.buildSmsPaymentView();
                  this.mIsShowInfo = false;
               } else if (this.mSmsInfo != null) {
                  this.registerReceiver(this.mSmsReceiver, new IntentFilter("com.uc.androidsdk.SMS_SENT_ACTION"));
                  this.sendFirstSms(this.mSmsInfo);
               }
               break;
            case 9:
               switch (this.mType) {
                  case 0:
                     this.finish();
                     return;
                  case 1:
                     this.buildPaymentView();
                     return;
                  case 2:
                     this.buildUPointPaymentView();
                     return;
                  case 3:
                     this.buildUPointPayLoginView();
                     return;
                  case 4:
                     if (!this.mSmsInfo.isNeedconfirm() && !this.mIsShowInfo) {
                        var2 = Utils.getSmsPayment() / this.mSmsInfo.money;
                        if (this.mLeftSmsToSendCount != -1 && this.mLeftSmsToSendCount != var2) {
                           this.showDialog(27);
                        } else {
                           this.buildSmsPaymentView();
                        }

                        return;
                     } else {
                        this.buildPaymentView();
                        return;
                     }
                  case 5:
                     this.showDialog(23);
                     return;
                  default:
                     return;
               }
            case 10:
               switch (this.mType) {
                  case 4:
                     if (this.mSmsInfo.isNeedconfirm() || this.mIsShowInfo) {
                        var2 = Utils.getSmsPayment() / this.mSmsInfo.money;
                        if (this.mLeftSmsToSendCount != -1 && this.mLeftSmsToSendCount != var2) {
                           this.showDialog(27);
                        } else {
                           this.buildPaymentView();
                        }
                     }
                     break;
                  case 5:
                     this.showDialog(23);
                     break;
                  default:
                     this.finish();
               }
         }
      }

   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.mIsValid = this.initPayment();
      if (this.mIsValid) {
         Utils.init(this.getApplicationContext());
         Utils.initTitleBar(this);
         this.buildPaymentView();
         this.confirmEnterPaymentPoint();
         (new HandlerProxy(this.getApplicationContext())).handleRequest();
      }

   }

   protected Dialog onCreateDialog(int var1) {
      Dialog var3;
      switch (var1) {
         case 0:
            var3 = DialogUtil.createOKWarningDialog(this, var1, "\u8be5\u5e94\u7528\u8981\u6c42\u652f\u4ed8\u7684\u91d1\u989d\u4e0d\u7b26\u5408\u8981\u6c42\uff0c\u4e0d\u80fd\u6210\u529f\u652f\u4ed8\u3002", this);
            break;
         case 1:
         case 3:
         case 4:
         case 12:
         default:
            var3 = super.onCreateDialog(var1);
            break;
         case 2:
            var3 = DialogUtil.createOKWarningDialogSupportLink(this, var1, "\u4ec0\u4e48\u662fU\u70b9?", "U\u70b9\u662f<a href='http://wap.uc.cn'>UC-\u4f18\u89c6</a>\u63d0\u4f9b\u7684\u4e00\u79cd\u865a\u62df\u8d27\u5e01\uff0c\u4e3b\u8981\u7528\u4e8e\u8d2d\u4e70\u8f6f\u4ef6\u548c\u6e38\u620f\u91cc\u7684\u5185\u5bb9\uff08\u5982\uff1a\u9053\u5177\u3001\u5173\u5361\u3001\u8f6f\u4ef6\u3001\u4f7f\u7528\u65f6\u957f\u7b49\uff09\u3002<br /><br />U\u70b9\u5151\u6362\u6807\u51c6\uff1a<br />1\u5143\u53ef\u5151\u636210U\u70b9\u3002<br />\u901a\u8fc7\u4ee5\u4e0b\u94fe\u63a5\u5145\u503cU\u70b9\uff1a<br /><a href='http://pay.uc.cn'>UC-\u4f18\u89c6</a>", (DialogUtil$WarningDialogListener)null);
            break;
         case 5:
            var3 = DialogUtil.createOKWarningDialog(this, var1, "U\u70b9\u4e0d\u8db3,\u4e0d\u80fd\u7ee7\u7eed\u652f\u4ed8\uff01", (DialogUtil$WarningDialogListener)null);
            break;
         case 6:
            var3 = DialogUtil.createIndeterminateProgressDialog(this, var1, "\u6b63\u5728\u652f\u4ed8\uff0c\u8bf7\u52ff\u5173\u95ed\u7a0b\u5e8f\uff0c\u8bf7\u7a0d\u540e......", false, (DialogUtil$ProgressDialogListener)null);
            break;
         case 7:
            var3 = DialogUtil.createOKWarningDialog(this, var1, "\u652f\u4ed8\u4e0d\u6210\u529f\uff0c\u8bf7\u786e\u5b9a\u60a8\u7684\u8d26\u6237\u5f53\u4e2d\u7684\u4f59\u989d\u5145\u8db3\u5e76\u7f51\u7edc\u8fde\u63a5\u6b63\u5e38\u3002", (DialogUtil$WarningDialogListener)null);
            break;
         case 8:
            var3 = DialogUtil.createOKWarningDialog(this, var1, "\u652f\u4ed8\u4e0d\u6210\u529f\uff0c\u8bf7\u786e\u5b9a\u60a8\u7684\u8d26\u6237\u5f53\u4e2d\u7684\u4f59\u989d\u5145\u8db3\u5e76\u7f51\u7edc\u8fde\u63a5\u6b63\u5e38\u3002", (DialogUtil$WarningDialogListener)null);
            break;
         case 9:
            var3 = DialogUtil.createOKWarningDialog(this, var1, "\u652f\u4ed8\u4e0d\u6210\u529f\uff0c\u8bf7\u786e\u5b9a\u60a8\u7684\u8d26\u6237\u5f53\u4e2d\u7684\u4f59\u989d\u5145\u8db3\u5e76\u7f51\u7edc\u8fde\u63a5\u6b63\u5e38\u3002", (DialogUtil$WarningDialogListener)null);
            break;
         case 10:
            var3 = DialogUtil.createYesNoDialog(this, var1, "\u652f\u4ed8\u4e0d\u6210\u529f\uff0c\u8fde\u63a5\u670d\u52a1\u5668\u8d85\u65f6\uff0c\u662f\u5426\u91cd\u8bd5?", this);
            break;
         case 11:
            var3 = DialogUtil.createOKWarningDialog(this, var1, "\u652f\u4ed8\u4e0d\u6210\u529f\uff0c\u8bf7\u786e\u5b9a\u60a8\u7684\u8d26\u6237\u5f53\u4e2d\u7684\u4f59\u989d\u5145\u8db3\u5e76\u7f51\u7edc\u8fde\u63a5\u6b63\u5e38\u3002\n\u8bf7\u8054\u7cfb\u5ba2\u670d4006-400-401\u3002", (DialogUtil$WarningDialogListener)null);
            break;
         case 13:
            var3 = DialogUtil.createOKWarningDialog(this, var1, "U\u70b9\u652f\u4ed8\u6210\u529f\uff0c\u795d\u60a8\u73a9\u7684\u5f00\u5fc3", String.format("\u60a8\u7684\u4f59\u989d\u4e3a%dU\u70b9", this.mNumber, this.mBalance), this);
            break;
         case 14:
            var3 = DialogUtil.createIndeterminateProgressDialog(this, var1, "\u8fde\u63a5\u670d\u52a1\u5668\uff0c\u8bf7\u7a0d\u7b49...", false, (DialogUtil$ProgressDialogListener)null);
            break;
         case 15:
            var3 = DialogUtil.createOKWarningDialog(this, var1, "\u7f51\u7edc\u8fde\u63a5\u9519\u8bef\uff0c\u8bf7\u68c0\u67e5\u7f51\u7edc\u540e\u518d\u8bd5\u3002", this);
            break;
         case 16:
            var3 = DialogUtil.createOKWarningDialog(this, var1, this.mSmsResultInfo, this);
            break;
         case 17:
            var3 = DialogUtil.createIndeterminateProgressDialog(this, var1, "\u77ed\u4fe1\u53d1\u9001\u8fc7\u7a0b\u53ef\u80fd\u6301\u7eed\u4e00\u5206\u949f\uff0c\u8bf7\u8010\u5fc3\u7b49\u5f85...", false, (DialogUtil$ProgressDialogListener)null);
            break;
         case 18:
            var3 = DialogUtil.createOKWarningDialog(this, var1, "\u77ed\u4fe1\u53d1\u9001\u5931\u8d25", (DialogUtil$WarningDialogListener)null);
            break;
         case 19:
            var3 = DialogUtil.createIndeterminateProgressDialog(this, var1, "\u6b63\u5728\u83b7\u53d6\u4fe1\u606f\uff0c\u8bf7\u7a0d\u5019......", false, (DialogUtil$ProgressDialogListener)null);
            break;
         case 20:
            var3 = DialogUtil.createOKWarningDialog(this, var1, "\u8d2d\u4e70\u6210\u529f", this.mSmsResultInfo, this);
            break;
         case 21:
            var3 = DialogUtil.createOKWarningDialog(this, var1, this.mSmsResultInfo, this);
            break;
         case 22:
            var3 = DialogUtil.createOKWarningDialog(this, var1, "CPID\u4e3a\u5b57\u7b26\u4e32\u548c\u6570\u5b57\u4efb\u610f\u7ec4\u5408\uff0c\u4e0d\u80fd\u7531\u4e2d\u6587\u5b57\u7b26\u3001\u6807\u70b9\u7b26\u53f7\u6216\u7a7a\u683c\uff0c\u957f\u5ea6\u4e0d\u8d85\u8fc710\u4e2a\u82f1\u6587\u5b57\u7b26\u3002", this);
            break;
         case 23:
            var3 = DialogUtil.createTwoButtonsDialog(this, var1, "\u60a8\u5df2\u7ecf\u53d6\u6d88\u4e86\u8d2d\u4e70\uff0c\u5c06\u4e0d\u4f1a\u83b7\u5f97\u76f8\u5e94\u5185\u5bb9\u3002\u8bf7\u786e\u8ba4\u662f\u5426\u53d6\u6d88\uff1f", "\u53d6\u6d88", "\u4e0d\u53d6\u6d88", this);
            break;
         case 24:
            var3 = DialogUtil.createTwoButtonsDialog(this, var1, Html.fromHtml("\u8d2d\u4e70\u786e\u8ba4\u77ed\u4fe1\u672a\u5220\u9664\uff0c\u5982\u9700\u8d2d\u4e70\u8bf7\u518d\u6b21\u53d1\u9001\u77ed\u4fe1\u6216\u91c7\u7528\u5176\u4ed6\u652f\u4ed8\u65b9\u5f0f\uff0c<font color='red'>\u8bf7\u52ff\u5230\u77ed\u4fe1\u6536\u4ef6\u7bb1\u8fdb\u884c\u56de\u590d</font>\uff0c\u8c22\u8c22\uff01"), "\u8fd4\u56de\u8d2d\u4e70\u9875", "\u8fd4\u56de\u5e94\u7528", this);
            break;
         case 25:
            var3 = DialogUtil.createTwoButtonsDialog(this, var1, "\u8d2d\u4e70\u786e\u8ba4\u77ed\u4fe1\u5df2\u5220\u9664\uff0c\u5982\u9700\u8d2d\u4e70\u8bf7\u518d\u6b21\u53d1\u9001\u77ed\u4fe1\u6216\u91c7\u7528\u5176\u4ed6\u652f\u4ed8\u65b9\u5f0f\uff0c\u8c22\u8c22\uff01", "\u8fd4\u56de\u8d2d\u4e70\u9875", "\u8fd4\u56de\u5e94\u7528", this);
            break;
         case 26:
            var3 = DialogUtil.createOKWarningDialog(this, var1, "\u652f\u4ed8\u8d85\u65f6\uff0c\u70b9\u51fb\u786e\u5b9a\u91cd\u65b0\u9a8c\u8bc1\u652f\u4ed8\u7ed3\u679c\u3002\u6700\u591a \u9700\u89811\u5206\u949f\uff0c\u8bf7\u8010\u5fc3\u7b49\u5f85...", this);
            break;
         case 27:
            int var2 = this.getPayedAmount();
            var3 = DialogUtil.createTwoButtonsDialog(this, var1, String.format("\u60a8\u5df2\u7ecf\u652f\u4ed8\u8fc7\u3010%d\u3011\u5143\u77ed\u4fe1\uff0c\u73b0\u5728\u53d6\u6d88\u53d1\u9001\u5c06\u4e0d\u80fd\u6210\u529f\u8d2d\u4e70\u3010%s\u3011\u3002\u5982\u53d6\u6d88\u53d1\u9001\u5df2\u4ed8\u91d1\u989d\u4e0d\u4f1a\u8fd4\u8fd8\uff0c\u53ea\u80fd\u8ba1\u7b97\u5230\u60a8\u4e0b\u6b21\u8d2d\u4e70\u3010%s\u3011\u4e2d\u3002\u8bf7\u518d\u6b21\u786e\u8ba4\u662f\u5426\u53d6\u6d88\u8fd9\u6b21\u652f\u4ed8\uff1f", PrefUtil.getPayedAmount(this.getApplicationContext()) + var2, this.mPaymentInfo.getPayname(), this.mPaymentInfo.getPayname()), "\u8fd4\u56de\u7ee7\u7eed\u652f\u4ed8", "\u786e\u8ba4\u53d6\u6d88", this);
            break;
         case 28:
            var3 = DialogUtil.createOKWarningDialog(this, var1, "\u8bf7\u8f93\u5165\u8d26\u53f7\u548c\u5bc6\u7801\u3002", (DialogUtil$WarningDialogListener)null);
            break;
         case 29:
            var3 = DialogUtil.createOKWarningDialog(this, var1, "\u5bc6\u7801\u4e3a\u7a7a\uff0c\u8bf7\u8f93\u5165\u5bc6\u7801\u3002", (DialogUtil$WarningDialogListener)null);
            break;
         case 30:
            var3 = DialogUtil.createOKWarningDialog(this, var1, "\u7528\u6237\u540d\u4e3a\u7a7a\uff0c\u8bf7\u8f93\u5165\u7528\u6237\u540d\u3002", (DialogUtil$WarningDialogListener)null);
            break;
         case 31:
            var3 = DialogUtil.createOKWarningDialog(this, var1, "\u7528\u6237\u540d\u5fc5\u987b\u5927\u4e8e3\u4e2a\u5b57\u3002", (DialogUtil$WarningDialogListener)null);
            break;
         case 32:
            var3 = DialogUtil.createOKWarningDialog(this, var1, "\u7528\u6237\u540d\u5fc5\u987b\u5c0f\u4e8e17\u4e2a\u5b57\u3002", (DialogUtil$WarningDialogListener)null);
            break;
         case 33:
            var3 = DialogUtil.createOKWarningDialog(this, var1, "\u5bc6\u7801\u4e0d\u80fd\u4e3a\u7a7a\u3002", (DialogUtil$WarningDialogListener)null);
            break;
         case 34:
            var3 = DialogUtil.createOKWarningDialog(this, var1, "\u767b\u5f55\u5931\u8d25\uff0c\u60a8\u7684\u5e10\u53f7\u548c\u5bc6\u7801\u4e0d\u5339\u914d\u3002", (DialogUtil$WarningDialogListener)null);
            break;
         case 35:
            var3 = DialogUtil.createIndeterminateProgressDialog(this, var1, "U\u70b9\u652f\u4ed8\u4e2d\uff0c\u8bf7\u7a0d\u5019...", false, (DialogUtil$ProgressDialogListener)null);
            break;
         case 36:
            var3 = DialogUtil.createYesNoDialog(this, var1, "\u60a8\u624b\u673a\u65f6\u95f4\u4e0d\u6b63\u786e\uff0c\u4e3a\u4e86\u786e\u4fdd\u5b89\u5168\u652f\u4ed8\uff0c\u662f\u5426\u9700\u8981\u7cfb\u7edf\u81ea\u52a8\u4fee\u6b63\u5e76\u5b8c\u6210\u652f\u4ed8?", this);
            break;
         case 37:
            var3 = DialogUtil.createOKWarningDialog(this, var1, "\u652f\u4ed8\u4e0d\u6210\u529f\uff0c\u60a8\u7684\u652f\u4ed8\u5bc6\u7801\u6709\u8bef\uff0c\u4e0d\u80fd\u652f\u4ed8\u6210\u529f\uff01", (DialogUtil$WarningDialogListener)null);
            break;
         case 38:
            var3 = DialogUtil.createOKWarningDialog(this, var1, "\u652f\u4ed8\u4e0d\u6210\u529f\uff0c\u60a8\u5df2\u7ecf\u7981\u6b62\u4e86\u53d1\u9001\u652f\u4ed8\u77ed\u4fe1\uff0c\u8bf7\u91cd\u65b0\u5c1d\u8bd5\u652f\u4ed8\u3002", (DialogUtil$WarningDialogListener)null);
      }

      return var3;
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

   public void onError(int var1, int var2) {
      switch (var1) {
         case 3:
            switch (var2) {
               case -1:
                  ++this.mTimeoutCounter;
                  if (this.mTimeoutCounter < 2) {
                     Api.pay(this.getApplicationContext(), this, this.mPaymentInfo, this.mUPayInfo);
                  } else {
                     this.mTimeoutCounter = 0;
                     this.mBtnPay.setEnabled(true);
                     this.removeDialog(6);
                     this.showDialog(10);
                  }

                  return;
               case 219:
                  this.mBtnPay.setEnabled(false);
                  this.removeDialog(6);
                  this.showDialog(5);
                  this.buildPaymentView();
                  return;
               case 425:
                  this.mBtnPay.setEnabled(true);
                  this.removeDialog(6);
                  this.showDialog(8);
                  return;
               case 500:
                  this.mBtnPay.setEnabled(true);
                  this.removeDialog(6);
                  this.showDialog(11);
                  return;
               default:
                  this.mBtnPay.setEnabled(true);
                  this.removeDialog(6);
                  this.showDialog(7);
                  return;
            }
         case 18:
            this.dismissDialog(14);
            this.showDialog(15);
            this.buildPaymentView();
      }

   }

   public void onFinish() {
      this.fillData();
   }

   public void onItemClick(AdapterView var1, View var2, int var3, long var4) {
      if (var3 != 0) {
         String var6 = ((CustomAdapter)((HeaderViewListAdapter)var1.getAdapter()).getWrappedAdapter()).getItem(var3 - 1).getId();
         if ("upoint".equals(var6)) {
            this.buildUPointPaymentView();
         } else if ("sms".equals(var6)) {
            this.buildSmsPaymentView();
         }
      }

   }

   public boolean onKeyDown(int var1, KeyEvent var2) {
      boolean var3;
      switch (var1) {
         case 4:
            switch (this.mType) {
               case 1:
                  this.buildPaymentView();
                  var3 = true;
                  return var3;
               case 2:
                  this.buildUPointPaymentView();
                  var3 = true;
                  return var3;
               case 3:
                  this.buildUPointPayLoginView();
                  var3 = true;
                  return var3;
               case 4:
                  if (!this.mSmsInfo.isNeedconfirm() && !this.mIsShowInfo) {
                     this.buildPaymentView();
                  } else {
                     var1 = Utils.getSmsPayment() / this.mSmsInfo.money;
                     if (this.mLeftSmsToSendCount != -1 && this.mLeftSmsToSendCount != var1) {
                        this.showDialog(27);
                     } else {
                        this.buildPaymentView();
                     }
                  }

                  var3 = true;
                  return var3;
               case 5:
                  this.showDialog(23);
                  var3 = true;
                  return var3;
            }
         default:
            var3 = super.onKeyDown(var1, var2);
            return var3;
      }
   }

   public Object onPreHandle(int var1, HttpResponse var2) {
      Object var6;
      if (5 != var1 && 8 != var1) {
         String var3 = Utils.getBodyString(var1, var2);
         if (TextUtils.isEmpty(var3)) {
            var6 = null;
         } else {
            switch (var1) {
               case 3:
                  try {
                     var6 = XMLParser.parsePayOrder(var3);
                     break;
                  } catch (Exception var5) {
                     var5.printStackTrace();
                  }
               case 18:
                  try {
                     var6 = XMLParser.parseUPointInfo(var3);
                     break;
                  } catch (Exception var4) {
                     var4.printStackTrace();
                  }
               default:
                  var6 = null;
            }
         }
      } else {
         var6 = true;
      }

      return var6;
   }

   protected void onPrepareDialog(int var1, Dialog var2) {
      super.onPrepareDialog(var1, var2);
      if (var2.isShowing()) {
         var2.dismiss();
      }

   }

   public void onSuccess(int var1, Object var2) {
      switch (var1) {
         case 3:
            String[] var3 = ((String)var2).split("#");
            var1 = Integer.parseInt(var3[0]);
            String var5 = var3[1];
            this.removeDialog(6);
            if (var1 == -110) {
               this.showDialog(7);
               this.mUPayInfo.updateConsumeId();
            } else if (var1 == -102 && var5.equals("uc_tm_modify")) {
               var5 = var3[2];
               this.mUPayInfo.setTm(var5);
               this.showDialog(36);
            } else if (var1 < 0) {
               if (var1 == -102) {
                  if (var5.equals("uc_password_error")) {
                     this.showDialog(34);
                  } else if (var5.equals("um_account_error")) {
                     this.showDialog(5);
                  } else if (var5.equals("um_paypwd_error")) {
                     this.showDialog(37);
                  } else if (var5.equals("um_paypwd_error")) {
                     if (this.mType == 3) {
                        this.showDialog(7);
                     } else {
                        if (this.mEtSavePass.isChecked()) {
                           PrefUtil.setUCUserName(this.getApplicationContext(), this.mEtUsername.getText().toString());
                           PrefUtil.setUCUserPass(this.getApplicationContext(), this.mEtPassword.getText().toString());
                        } else {
                           PrefUtil.clearUCUserName(this.getApplicationContext());
                           PrefUtil.clearUCUserPass(this.getApplicationContext());
                        }

                        this.buildUPointPayPassView();
                     }
                  } else if (var5.equals("um_system_error")) {
                     this.showDialog(7);
                     this.mUPayInfo.updateConsumeId();
                  }
               }
            } else {
               if (this.mEtSavePass.isChecked()) {
                  PrefUtil.setUCUserName(this.getApplicationContext(), this.mEtUsername.getText().toString());
                  PrefUtil.setUCUserPass(this.getApplicationContext(), this.mEtPassword.getText().toString());
               } else {
                  PrefUtil.clearUCUserName(this.getApplicationContext());
                  PrefUtil.clearUCUserPass(this.getApplicationContext());
               }

               this.showDialog(13);
            }
            break;
         case 18:
            UPointInfo var4 = (UPointInfo)var2;
            this.initUPointPayView(var4);
            Utils.setUPointInfo(var4);
            this.dismissDialog(14);
      }

   }

   public void onWarningDialogCancel(int var1) {
      switch (var1) {
         case 23:
         case 26:
         default:
            break;
         case 24:
         case 25:
            if (this.mSmsHander != null && this.mSmsRunnable != null) {
               this.mSmsHander.removeCallbacks(this.mSmsRunnable);
               this.getContentResolver().unregisterContentObserver(this.mSmsContent);

               try {
                  this.unregisterReceiver(this.mSmsReceiver);
               } catch (IllegalArgumentException var4) {
               }
            }

            this.finish();
            break;
         case 27:
            if (this.mSmsHander != null && this.mSmsRunnable != null) {
               this.mSmsHander.removeCallbacks(this.mSmsRunnable);
               this.getContentResolver().unregisterContentObserver(this.mSmsContent);

               try {
                  this.unregisterReceiver(this.mSmsReceiver);
               } catch (IllegalArgumentException var3) {
               }
            }

            this.buildPaymentView();
      }

   }

   public void onWarningDialogOK(int var1) {
      switch (var1) {
         case 0:
         case 1:
         case 22:
            this.finish();
            break;
         case 10:
            this.pay();
            break;
         case 20:
            PrefUtil.clearPayedAmount(this.getApplicationContext());
         case 13:
            this.setResult(-1, new Intent());
            this.finish();
            break;
         case 21:
         case 25:
            if (this.mSmsHander != null && this.mSmsRunnable != null) {
               this.mSmsHander.removeCallbacks(this.mSmsRunnable);
            }

            if (this.mSmsContent != null) {
               this.getContentResolver().unregisterContentObserver(this.mSmsContent);
            }

            try {
               this.unregisterReceiver(this.mSmsReceiver);
            } catch (IllegalArgumentException var3) {
            }
         case 15:
         case 16:
         case 24:
            this.buildPaymentView();
            break;
         case 23:
            this.showDialog(24);
            break;
         case 26:
            if (4 == this.mType) {
               this.sendFirstSms(this.mSmsInfo);
            } else {
               this.sendConfirmSms(this.mConfirmSmsInfoString);
            }
            break;
         case 36:
            this.pay();
      }

   }
}
