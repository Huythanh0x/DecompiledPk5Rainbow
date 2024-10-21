package com.uc.paymentsdk.payment;

import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
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
import com.uc.paymentsdk.payment.sms.SimCardNotSupportException;
import com.uc.paymentsdk.payment.sms.SmsInfo;
import com.uc.paymentsdk.payment.upoint.UPointInfo;
import com.uc.paymentsdk.payment.upoint.UPointPayInfo;
import com.uc.paymentsdk.util.DialogUtil;
import com.uc.paymentsdk.util.PrefUtil;
import com.uc.paymentsdk.util.Utils;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;
import org.apache.http.HttpResponse;

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
  
  private final BroadcastReceiver mSmsReceiver = new BroadcastReceiver() {
      final PaymentsActivity this$0;
      
      public void onReceive(Context param1Context, Intent param1Intent) {
        // Byte code:
        //   0: aload_0
        //   1: invokevirtual getResultCode : ()I
        //   4: lookupswitch default -> 48, -1 -> 108, 1 -> 107, 2 -> 605, 133404 -> 107
        //   48: aload_0
        //   49: getfield this$0 : Lcom/uc/paymentsdk/payment/PaymentsActivity;
        //   52: bipush #17
        //   54: invokevirtual removeDialog : (I)V
        //   57: aload_0
        //   58: getfield this$0 : Lcom/uc/paymentsdk/payment/PaymentsActivity;
        //   61: ldc '余额不足，支付失败'
        //   63: invokestatic access$8 : (Lcom/uc/paymentsdk/payment/PaymentsActivity;Ljava/lang/String;)V
        //   66: aload_0
        //   67: getfield this$0 : Lcom/uc/paymentsdk/payment/PaymentsActivity;
        //   70: bipush #21
        //   72: invokevirtual showDialog : (I)V
        //   75: aload_0
        //   76: getfield this$0 : Lcom/uc/paymentsdk/payment/PaymentsActivity;
        //   79: invokestatic access$3 : (Lcom/uc/paymentsdk/payment/PaymentsActivity;)I
        //   82: iconst_m1
        //   83: if_icmpne -> 97
        //   86: iconst_5
        //   87: aload_0
        //   88: getfield this$0 : Lcom/uc/paymentsdk/payment/PaymentsActivity;
        //   91: invokestatic access$0 : (Lcom/uc/paymentsdk/payment/PaymentsActivity;)I
        //   94: if_icmpne -> 107
        //   97: aload_0
        //   98: getfield this$0 : Lcom/uc/paymentsdk/payment/PaymentsActivity;
        //   101: invokestatic access$10 : (Lcom/uc/paymentsdk/payment/PaymentsActivity;)Landroid/database/ContentObserver;
        //   104: ifnonnull -> 684
        //   107: return
        //   108: iconst_4
        //   109: aload_0
        //   110: getfield this$0 : Lcom/uc/paymentsdk/payment/PaymentsActivity;
        //   113: invokestatic access$0 : (Lcom/uc/paymentsdk/payment/PaymentsActivity;)I
        //   116: if_icmpne -> 397
        //   119: aload_0
        //   120: getfield this$0 : Lcom/uc/paymentsdk/payment/PaymentsActivity;
        //   123: invokestatic access$1 : (Lcom/uc/paymentsdk/payment/PaymentsActivity;)Lcom/uc/paymentsdk/payment/sms/SmsInfo;
        //   126: invokevirtual isNeedconfirm : ()Z
        //   129: ifeq -> 189
        //   132: ldc2_w 5000
        //   135: invokestatic sleep : (J)V
        //   138: aload_0
        //   139: getfield this$0 : Lcom/uc/paymentsdk/payment/PaymentsActivity;
        //   142: bipush #17
        //   144: invokevirtual removeDialog : (I)V
        //   147: aload_0
        //   148: getfield this$0 : Lcom/uc/paymentsdk/payment/PaymentsActivity;
        //   151: invokestatic access$1 : (Lcom/uc/paymentsdk/payment/PaymentsActivity;)Lcom/uc/paymentsdk/payment/sms/SmsInfo;
        //   154: invokevirtual getSmsConfirmContent : ()Ljava/lang/String;
        //   157: astore_2
        //   158: aload_0
        //   159: getfield this$0 : Lcom/uc/paymentsdk/payment/PaymentsActivity;
        //   162: invokestatic access$1 : (Lcom/uc/paymentsdk/payment/PaymentsActivity;)Lcom/uc/paymentsdk/payment/sms/SmsInfo;
        //   165: invokevirtual getSmsConfirmNumber : ()Ljava/lang/String;
        //   168: astore_1
        //   169: aload_0
        //   170: getfield this$0 : Lcom/uc/paymentsdk/payment/PaymentsActivity;
        //   173: aload_1
        //   174: aload_2
        //   175: invokestatic access$2 : (Lcom/uc/paymentsdk/payment/PaymentsActivity;Ljava/lang/String;Ljava/lang/String;)V
        //   178: goto -> 107
        //   181: astore_1
        //   182: aload_1
        //   183: invokevirtual printStackTrace : ()V
        //   186: goto -> 138
        //   189: aload_0
        //   190: getfield this$0 : Lcom/uc/paymentsdk/payment/PaymentsActivity;
        //   193: astore_1
        //   194: aload_1
        //   195: aload_1
        //   196: invokestatic access$3 : (Lcom/uc/paymentsdk/payment/PaymentsActivity;)I
        //   199: iconst_1
        //   200: isub
        //   201: invokestatic access$4 : (Lcom/uc/paymentsdk/payment/PaymentsActivity;I)V
        //   204: aload_0
        //   205: getfield this$0 : Lcom/uc/paymentsdk/payment/PaymentsActivity;
        //   208: bipush #17
        //   210: invokevirtual removeDialog : (I)V
        //   213: aload_0
        //   214: getfield this$0 : Lcom/uc/paymentsdk/payment/PaymentsActivity;
        //   217: invokevirtual getApplicationContext : ()Landroid/content/Context;
        //   220: aload_0
        //   221: getfield this$0 : Lcom/uc/paymentsdk/payment/PaymentsActivity;
        //   224: invokestatic access$5 : (Lcom/uc/paymentsdk/payment/PaymentsActivity;)I
        //   227: invokestatic setPayedAmount : (Landroid/content/Context;I)V
        //   230: aload_0
        //   231: getfield this$0 : Lcom/uc/paymentsdk/payment/PaymentsActivity;
        //   234: invokestatic access$3 : (Lcom/uc/paymentsdk/payment/PaymentsActivity;)I
        //   237: iconst_1
        //   238: if_icmplt -> 362
        //   241: aload_0
        //   242: getfield this$0 : Lcom/uc/paymentsdk/payment/PaymentsActivity;
        //   245: invokestatic access$6 : (Lcom/uc/paymentsdk/payment/PaymentsActivity;)V
        //   248: aload_0
        //   249: getfield this$0 : Lcom/uc/paymentsdk/payment/PaymentsActivity;
        //   252: invokestatic access$1 : (Lcom/uc/paymentsdk/payment/PaymentsActivity;)Lcom/uc/paymentsdk/payment/sms/SmsInfo;
        //   255: invokevirtual getSmstype : ()I
        //   258: iconst_1
        //   259: if_icmpne -> 107
        //   262: aload_0
        //   263: getfield this$0 : Lcom/uc/paymentsdk/payment/PaymentsActivity;
        //   266: invokevirtual getApplicationContext : ()Landroid/content/Context;
        //   269: aload_0
        //   270: getfield this$0 : Lcom/uc/paymentsdk/payment/PaymentsActivity;
        //   273: aload_0
        //   274: getfield this$0 : Lcom/uc/paymentsdk/payment/PaymentsActivity;
        //   277: invokestatic access$9 : (Lcom/uc/paymentsdk/payment/PaymentsActivity;)Lcom/uc/paymentsdk/payment/PaymentInfo;
        //   280: invokevirtual getCpID : ()Ljava/lang/String;
        //   283: aload_0
        //   284: getfield this$0 : Lcom/uc/paymentsdk/payment/PaymentsActivity;
        //   287: invokestatic access$9 : (Lcom/uc/paymentsdk/payment/PaymentsActivity;)Lcom/uc/paymentsdk/payment/PaymentInfo;
        //   290: invokevirtual getmGameID : ()Ljava/lang/String;
        //   293: aload_0
        //   294: getfield this$0 : Lcom/uc/paymentsdk/payment/PaymentsActivity;
        //   297: invokestatic access$9 : (Lcom/uc/paymentsdk/payment/PaymentsActivity;)Lcom/uc/paymentsdk/payment/PaymentInfo;
        //   300: invokevirtual getmActionID : ()Ljava/lang/String;
        //   303: invokestatic getSmsPayment : ()I
        //   306: aload_0
        //   307: getfield this$0 : Lcom/uc/paymentsdk/payment/PaymentsActivity;
        //   310: invokestatic access$9 : (Lcom/uc/paymentsdk/payment/PaymentsActivity;)Lcom/uc/paymentsdk/payment/PaymentInfo;
        //   313: invokevirtual getmActionID : ()Ljava/lang/String;
        //   316: aload_0
        //   317: getfield this$0 : Lcom/uc/paymentsdk/payment/PaymentsActivity;
        //   320: invokestatic access$1 : (Lcom/uc/paymentsdk/payment/PaymentsActivity;)Lcom/uc/paymentsdk/payment/sms/SmsInfo;
        //   323: invokevirtual getSmschannelid : ()Ljava/lang/String;
        //   326: aload_0
        //   327: getfield this$0 : Lcom/uc/paymentsdk/payment/PaymentsActivity;
        //   330: invokestatic access$1 : (Lcom/uc/paymentsdk/payment/PaymentsActivity;)Lcom/uc/paymentsdk/payment/sms/SmsInfo;
        //   333: invokevirtual getSmsnumber : ()Ljava/lang/String;
        //   336: aload_0
        //   337: getfield this$0 : Lcom/uc/paymentsdk/payment/PaymentsActivity;
        //   340: invokestatic access$1 : (Lcom/uc/paymentsdk/payment/PaymentsActivity;)Lcom/uc/paymentsdk/payment/sms/SmsInfo;
        //   343: invokevirtual getContent : ()Ljava/lang/String;
        //   346: aload_0
        //   347: getfield this$0 : Lcom/uc/paymentsdk/payment/PaymentsActivity;
        //   350: invokestatic access$1 : (Lcom/uc/paymentsdk/payment/PaymentsActivity;)Lcom/uc/paymentsdk/payment/sms/SmsInfo;
        //   353: invokevirtual getSmstype : ()I
        //   356: invokestatic postSmsPayment : (Landroid/content/Context;Lcom/uc/paymentsdk/network/ApiTask$TaskHandler;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V
        //   359: goto -> 107
        //   362: aload_0
        //   363: getfield this$0 : Lcom/uc/paymentsdk/payment/PaymentsActivity;
        //   366: aload_0
        //   367: getfield this$0 : Lcom/uc/paymentsdk/payment/PaymentsActivity;
        //   370: invokestatic access$7 : (Lcom/uc/paymentsdk/payment/PaymentsActivity;)Landroid/content/BroadcastReceiver;
        //   373: invokevirtual unregisterReceiver : (Landroid/content/BroadcastReceiver;)V
        //   376: aload_0
        //   377: getfield this$0 : Lcom/uc/paymentsdk/payment/PaymentsActivity;
        //   380: ldc '支付已完成，祝您玩得开心。'
        //   382: invokestatic access$8 : (Lcom/uc/paymentsdk/payment/PaymentsActivity;Ljava/lang/String;)V
        //   385: aload_0
        //   386: getfield this$0 : Lcom/uc/paymentsdk/payment/PaymentsActivity;
        //   389: bipush #20
        //   391: invokevirtual showDialog : (I)V
        //   394: goto -> 248
        //   397: aload_0
        //   398: getfield this$0 : Lcom/uc/paymentsdk/payment/PaymentsActivity;
        //   401: bipush #17
        //   403: invokevirtual removeDialog : (I)V
        //   406: aload_0
        //   407: getfield this$0 : Lcom/uc/paymentsdk/payment/PaymentsActivity;
        //   410: astore_1
        //   411: aload_1
        //   412: aload_1
        //   413: invokestatic access$3 : (Lcom/uc/paymentsdk/payment/PaymentsActivity;)I
        //   416: iconst_1
        //   417: isub
        //   418: invokestatic access$4 : (Lcom/uc/paymentsdk/payment/PaymentsActivity;I)V
        //   421: aload_0
        //   422: getfield this$0 : Lcom/uc/paymentsdk/payment/PaymentsActivity;
        //   425: invokevirtual getApplicationContext : ()Landroid/content/Context;
        //   428: aload_0
        //   429: getfield this$0 : Lcom/uc/paymentsdk/payment/PaymentsActivity;
        //   432: invokestatic access$5 : (Lcom/uc/paymentsdk/payment/PaymentsActivity;)I
        //   435: invokestatic setPayedAmount : (Landroid/content/Context;I)V
        //   438: aload_0
        //   439: getfield this$0 : Lcom/uc/paymentsdk/payment/PaymentsActivity;
        //   442: invokestatic access$3 : (Lcom/uc/paymentsdk/payment/PaymentsActivity;)I
        //   445: iconst_1
        //   446: if_icmplt -> 570
        //   449: aload_0
        //   450: getfield this$0 : Lcom/uc/paymentsdk/payment/PaymentsActivity;
        //   453: invokestatic access$6 : (Lcom/uc/paymentsdk/payment/PaymentsActivity;)V
        //   456: aload_0
        //   457: getfield this$0 : Lcom/uc/paymentsdk/payment/PaymentsActivity;
        //   460: invokestatic access$1 : (Lcom/uc/paymentsdk/payment/PaymentsActivity;)Lcom/uc/paymentsdk/payment/sms/SmsInfo;
        //   463: invokevirtual getSmstype : ()I
        //   466: iconst_1
        //   467: if_icmpne -> 107
        //   470: aload_0
        //   471: getfield this$0 : Lcom/uc/paymentsdk/payment/PaymentsActivity;
        //   474: invokevirtual getApplicationContext : ()Landroid/content/Context;
        //   477: aload_0
        //   478: getfield this$0 : Lcom/uc/paymentsdk/payment/PaymentsActivity;
        //   481: aload_0
        //   482: getfield this$0 : Lcom/uc/paymentsdk/payment/PaymentsActivity;
        //   485: invokestatic access$9 : (Lcom/uc/paymentsdk/payment/PaymentsActivity;)Lcom/uc/paymentsdk/payment/PaymentInfo;
        //   488: invokevirtual getCpID : ()Ljava/lang/String;
        //   491: aload_0
        //   492: getfield this$0 : Lcom/uc/paymentsdk/payment/PaymentsActivity;
        //   495: invokestatic access$9 : (Lcom/uc/paymentsdk/payment/PaymentsActivity;)Lcom/uc/paymentsdk/payment/PaymentInfo;
        //   498: invokevirtual getmGameID : ()Ljava/lang/String;
        //   501: aload_0
        //   502: getfield this$0 : Lcom/uc/paymentsdk/payment/PaymentsActivity;
        //   505: invokestatic access$9 : (Lcom/uc/paymentsdk/payment/PaymentsActivity;)Lcom/uc/paymentsdk/payment/PaymentInfo;
        //   508: invokevirtual getmActionID : ()Ljava/lang/String;
        //   511: invokestatic getSmsPayment : ()I
        //   514: aload_0
        //   515: getfield this$0 : Lcom/uc/paymentsdk/payment/PaymentsActivity;
        //   518: invokestatic access$9 : (Lcom/uc/paymentsdk/payment/PaymentsActivity;)Lcom/uc/paymentsdk/payment/PaymentInfo;
        //   521: invokevirtual getmActionID : ()Ljava/lang/String;
        //   524: aload_0
        //   525: getfield this$0 : Lcom/uc/paymentsdk/payment/PaymentsActivity;
        //   528: invokestatic access$1 : (Lcom/uc/paymentsdk/payment/PaymentsActivity;)Lcom/uc/paymentsdk/payment/sms/SmsInfo;
        //   531: invokevirtual getSmschannelid : ()Ljava/lang/String;
        //   534: aload_0
        //   535: getfield this$0 : Lcom/uc/paymentsdk/payment/PaymentsActivity;
        //   538: invokestatic access$1 : (Lcom/uc/paymentsdk/payment/PaymentsActivity;)Lcom/uc/paymentsdk/payment/sms/SmsInfo;
        //   541: invokevirtual getSmsnumber : ()Ljava/lang/String;
        //   544: aload_0
        //   545: getfield this$0 : Lcom/uc/paymentsdk/payment/PaymentsActivity;
        //   548: invokestatic access$1 : (Lcom/uc/paymentsdk/payment/PaymentsActivity;)Lcom/uc/paymentsdk/payment/sms/SmsInfo;
        //   551: invokevirtual getContent : ()Ljava/lang/String;
        //   554: aload_0
        //   555: getfield this$0 : Lcom/uc/paymentsdk/payment/PaymentsActivity;
        //   558: invokestatic access$1 : (Lcom/uc/paymentsdk/payment/PaymentsActivity;)Lcom/uc/paymentsdk/payment/sms/SmsInfo;
        //   561: invokevirtual getSmstype : ()I
        //   564: invokestatic postSmsPayment : (Landroid/content/Context;Lcom/uc/paymentsdk/network/ApiTask$TaskHandler;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V
        //   567: goto -> 107
        //   570: aload_0
        //   571: getfield this$0 : Lcom/uc/paymentsdk/payment/PaymentsActivity;
        //   574: aload_0
        //   575: getfield this$0 : Lcom/uc/paymentsdk/payment/PaymentsActivity;
        //   578: invokestatic access$7 : (Lcom/uc/paymentsdk/payment/PaymentsActivity;)Landroid/content/BroadcastReceiver;
        //   581: invokevirtual unregisterReceiver : (Landroid/content/BroadcastReceiver;)V
        //   584: aload_0
        //   585: getfield this$0 : Lcom/uc/paymentsdk/payment/PaymentsActivity;
        //   588: ldc '支付已完成，祝您玩得开心。'
        //   590: invokestatic access$8 : (Lcom/uc/paymentsdk/payment/PaymentsActivity;Ljava/lang/String;)V
        //   593: aload_0
        //   594: getfield this$0 : Lcom/uc/paymentsdk/payment/PaymentsActivity;
        //   597: bipush #20
        //   599: invokevirtual showDialog : (I)V
        //   602: goto -> 456
        //   605: aload_0
        //   606: getfield this$0 : Lcom/uc/paymentsdk/payment/PaymentsActivity;
        //   609: bipush #17
        //   611: invokevirtual removeDialog : (I)V
        //   614: aload_0
        //   615: getfield this$0 : Lcom/uc/paymentsdk/payment/PaymentsActivity;
        //   618: ldc '当前手机设置为飞行模式，不能发送短信。'
        //   620: invokestatic access$8 : (Lcom/uc/paymentsdk/payment/PaymentsActivity;Ljava/lang/String;)V
        //   623: aload_0
        //   624: getfield this$0 : Lcom/uc/paymentsdk/payment/PaymentsActivity;
        //   627: bipush #21
        //   629: invokevirtual showDialog : (I)V
        //   632: aload_0
        //   633: getfield this$0 : Lcom/uc/paymentsdk/payment/PaymentsActivity;
        //   636: invokestatic access$3 : (Lcom/uc/paymentsdk/payment/PaymentsActivity;)I
        //   639: iconst_m1
        //   640: if_icmpne -> 654
        //   643: iconst_5
        //   644: aload_0
        //   645: getfield this$0 : Lcom/uc/paymentsdk/payment/PaymentsActivity;
        //   648: invokestatic access$0 : (Lcom/uc/paymentsdk/payment/PaymentsActivity;)I
        //   651: if_icmpne -> 107
        //   654: aload_0
        //   655: getfield this$0 : Lcom/uc/paymentsdk/payment/PaymentsActivity;
        //   658: invokestatic access$10 : (Lcom/uc/paymentsdk/payment/PaymentsActivity;)Landroid/database/ContentObserver;
        //   661: ifnull -> 107
        //   664: aload_0
        //   665: getfield this$0 : Lcom/uc/paymentsdk/payment/PaymentsActivity;
        //   668: invokevirtual getContentResolver : ()Landroid/content/ContentResolver;
        //   671: aload_0
        //   672: getfield this$0 : Lcom/uc/paymentsdk/payment/PaymentsActivity;
        //   675: invokestatic access$10 : (Lcom/uc/paymentsdk/payment/PaymentsActivity;)Landroid/database/ContentObserver;
        //   678: invokevirtual unregisterContentObserver : (Landroid/database/ContentObserver;)V
        //   681: goto -> 107
        //   684: aload_0
        //   685: getfield this$0 : Lcom/uc/paymentsdk/payment/PaymentsActivity;
        //   688: invokevirtual getContentResolver : ()Landroid/content/ContentResolver;
        //   691: aload_0
        //   692: getfield this$0 : Lcom/uc/paymentsdk/payment/PaymentsActivity;
        //   695: invokestatic access$10 : (Lcom/uc/paymentsdk/payment/PaymentsActivity;)Landroid/database/ContentObserver;
        //   698: invokevirtual unregisterContentObserver : (Landroid/database/ContentObserver;)V
        //   701: goto -> 107
        //   704: astore_1
        //   705: goto -> 584
        //   708: astore_1
        //   709: goto -> 376
        // Exception table:
        //   from	to	target	type
        //   132	138	181	java/lang/InterruptedException
        //   362	376	708	java/lang/IllegalArgumentException
        //   570	584	704	java/lang/IllegalArgumentException
      }
    };
  
  private String mSmsResultInfo;
  
  private final Runnable mSmsRunnable = new Runnable() {
      final PaymentsActivity this$0;
      
      public void run() {
        if (PaymentsActivity.this.mSmsContent != null)
          PaymentsActivity.this.getContentResolver().unregisterContentObserver(PaymentsActivity.this.mSmsContent); 
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
        } catch (IllegalArgumentException illegalArgumentException) {}
      }
    };
  
  private int mTimeoutCounter;
  
  private TextView mTvDiscountTextView;
  
  private TextView mTvProduct;
  
  private TextView mTvVipDiscountInfo;
  
  private TextView mTvVipDiscountTextView;
  
  private TextView mTvVipDiscountTimeTextView;
  
  private int mType;
  
  private UPointPayInfo mUPayInfo;
  
  private void buildPaymentView() {
    this.mType = 0;
    this.mTimeoutCounter = 0;
    this.mLeftSmsToReceiveCount = -1;
    this.mLeftSmsToSendCount = -1;
    this.mIsSynced = false;
    this.mIsShowInfo = false;
    this.mSmsHander = null;
    this.mSmsContent = null;
    RelativeLayout relativeLayout = Utils.initSubTitle(getApplicationContext(), this, "购买内容", false);
    TextView textView1 = new TextView(getApplicationContext());
    textView1.setTextSize(16.0F);
    textView1.setTextColor(Color.parseColor("#FF858D8D"));
    textView1.setPadding(10, 10, 0, 10);
    textView1.setText("尊敬的用户，您需要为以下内容支付费用，请阅读以下信息，确认所购内容无误。");
    TextView textView3 = new TextView(getApplicationContext());
    textView3.setTextSize(16.0F);
    textView3.setPadding(20, 0, 20, 0);
    textView3.setText(String.format("所购内容 : %s", new Object[] { this.mPaymentInfo.getPaydesc() }));
    textView3.setTextColor(-12303292);
    String str = (new DecimalFormat("##0.00")).format((this.mPaymentInfo.getMoney() / 10.0F));
    TextView textView2 = new TextView(getApplicationContext());
    textView2.setTextSize(16.0F);
    textView2.setPadding(20, 0, 0, 20);
    textView2.setText(String.format("支付金额: %s元", new Object[] { str }));
    textView2.setTextColor(-12303292);
    LinearLayout linearLayout = new LinearLayout(getApplicationContext());
    linearLayout.setBackgroundColor(-1);
    linearLayout.setOrientation(1);
    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
    linearLayout.addView((View)relativeLayout, (ViewGroup.LayoutParams)layoutParams);
    linearLayout.addView((View)textView1, (ViewGroup.LayoutParams)layoutParams);
    linearLayout.addView((View)textView3, (ViewGroup.LayoutParams)layoutParams);
    linearLayout.addView((View)textView2, (ViewGroup.LayoutParams)layoutParams);
    this.mListView = new ListView(getApplicationContext());
    this.mListView.setBackgroundColor(-1);
    this.mListView.setCacheColorHint(-1);
    this.mListView.addHeaderView((View)linearLayout, null, true);
    this.mListView.setOnItemClickListener(this);
    this.mListView.addFooterView((View)Utils.generateFooterView((Context)this), null, false);
    setContentView((View)this.mListView);
    fillData();
    (new HandlerProxy(getApplicationContext(), this)).handleRequest();
  }
  
  private void buildSmsPaymentConfirmView(String paramString1, String paramString2) {
    this.mType = 5;
    try {
      Utils.CheckSimCardSupprotInfo(getApplicationContext());
      RelativeLayout relativeLayout1 = new RelativeLayout(getApplicationContext());
      relativeLayout1.setBackgroundColor(-1);
      relativeLayout1.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
      RelativeLayout relativeLayout2 = Utils.initSubTitle(getApplicationContext(), this, "购买内容", true);
      relativeLayout2.setId(1);
      relativeLayout2.setLayoutParams((ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -2));
      relativeLayout1.addView((View)relativeLayout2);
      TextView textView = new TextView((Context)this);
      textView.setId(2);
      textView.setTextSize(16.0F);
      textView.setTextColor(-13487566);
      textView.setPadding(10, 10, 0, 0);
      textView.setFocusable(true);
      textView.setClickable(true);
      textView.setLinkTextColor(-24576);
      textView.setText(String.format("再次点击下一步即同意向\n%s发送短信以完成本次短信发送过程。", new Object[] { paramString1, this.mPaymentInfo.getPayname(), Integer.valueOf(Utils.getSmsPayment()) }));
      Linkify.addLinks(textView, 4);
      RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
      layoutParams3.addRule(3, 1);
      textView.setLayoutParams((ViewGroup.LayoutParams)layoutParams3);
      relativeLayout1.addView((View)textView);
      Button button2 = new Button(getApplicationContext());
      button2.setText("下一步");
      button2.setId(5);
      this.mConfirmSmsInfoString = String.valueOf(paramString1) + ",,,," + paramString2;
      button2.setTag(this.mConfirmSmsInfoString);
      button2.setOnClickListener(this);
      RelativeLayout.LayoutParams layoutParams1 = new RelativeLayout.LayoutParams(150, -2);
      layoutParams1.addRule(12, -1);
      layoutParams1.setMargins(10, 20, 10, 10);
      button2.setLayoutParams((ViewGroup.LayoutParams)layoutParams1);
      relativeLayout1.addView((View)button2);
      Button button1 = new Button(getApplicationContext());
      button1.setText("取消");
      button1.setId(6);
      button1.setOnClickListener(this);
      RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(150, -2);
      layoutParams2.addRule(11, -1);
      layoutParams2.addRule(12, -1);
      layoutParams2.setMargins(10, 20, 10, 10);
      button1.setLayoutParams((ViewGroup.LayoutParams)layoutParams2);
      relativeLayout1.addView((View)button1);
      setContentView((View)relativeLayout1);
    } catch (SimCardNotSupportException simCardNotSupportException) {
      this.mSmsResultInfo = simCardNotSupportException.getMessage();
      showDialog(16);
    } 
  }
  
  private void buildSmsPaymentView() {
    int i;
    this.mType = 4;
    this.mSmsId = 0;
    RelativeLayout relativeLayout1 = new RelativeLayout(getApplicationContext());
    relativeLayout1.setBackgroundColor(-1);
    relativeLayout1.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    RelativeLayout relativeLayout2 = Utils.initSubTitle(getApplicationContext(), this, "短信支付", false);
    relativeLayout2.setId(1);
    relativeLayout2.setLayoutParams((ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -2));
    relativeLayout1.addView((View)relativeLayout2);
    TextView textView1 = new TextView((Context)this);
    textView1.setId(2);
    textView1.setTextSize(18.0F);
    textView1.setTextColor(-12303292);
    textView1.setPadding(10, 10, 0, 0);
    textView1.setFocusable(true);
    textView1.setClickable(true);
    textView1.setLinkTextColor(-24576);
    textView1.setText("尊敬的用户，正在获取信息，请稍后......");
    RelativeLayout.LayoutParams layoutParams1 = new RelativeLayout.LayoutParams(-1, -2);
    layoutParams1.addRule(3, 1);
    textView1.setLayoutParams((ViewGroup.LayoutParams)layoutParams1);
    relativeLayout1.addView((View)textView1);
    TextView textView2 = new TextView((Context)this);
    textView2.setId(3);
    textView2.setTextSize(16.0F);
    textView2.setTextColor(-7829368);
    textView2.setPadding(10, 30, 0, 0);
    textView2.setFocusable(true);
    textView2.setClickable(true);
    textView2.setLinkTextColor(-24576);
    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
    layoutParams2.addRule(3, 2);
    textView2.setLayoutParams((ViewGroup.LayoutParams)layoutParams2);
    relativeLayout1.addView((View)textView2);
    Button button2 = new Button(getApplicationContext());
    button2.setText("点播");
    button2.setId(3);
    button2.setOnClickListener(this);
    Button button1 = new Button(getApplicationContext());
    button1.setText("取消");
    button1.setId(4);
    button1.setOnClickListener(this);
    try {
      Utils.CheckSimCardSupprotInfo(getApplicationContext());
      i = Utils.getSmsPayment();
      if (i <= PrefUtil.getPayedAmount(getApplicationContext())) {
        this.mSmsResultInfo = "您已支付完成，将返回您的游戏中。";
        showDialog(20);
        return;
      } 
    } catch (SimCardNotSupportException simCardNotSupportException) {
      this.mSmsResultInfo = simCardNotSupportException.getMessage();
      showDialog(16);
      return;
    } 
    if (!this.mIsSynced) {
      showDialog(19);
      (new SyncSmsInfoHandler(getApplicationContext(), new Handler.OnFinishListener(textView1, textView2, i, button1, button2, (RelativeLayout)simCardNotSupportException) {
            Button cancelBtn;
            
            RelativeLayout contentPanel;
            
            Button okBtn;
            
            int smsPayment;
            
            final PaymentsActivity this$0;
            
            TextView tvInfo2;
            
            TextView waitTV;
            
            public void onFinish() {
              if (Utils.getSmsInfos() == null) {
                PaymentsActivity.this.removeDialog(19);
                PaymentsActivity.this.showDialog(15);
                return;
              } 
              PaymentsActivity.this.mIsSynced = true;
              PaymentsActivity.this.removeDialog(19);
              PaymentsActivity.this.initSmsPayView(this.waitTV, this.tvInfo2, this.smsPayment, this.cancelBtn, this.okBtn, this.contentPanel);
            }
          })).handleRequest();
      return;
    } 
    initSmsPayView(textView1, textView2, i, button1, button2, (RelativeLayout)simCardNotSupportException);
  }
  
  private void buildUPointPayLoginView() {
    String str;
    this.mType = 2;
    RelativeLayout relativeLayout1 = Utils.initSubTitle(getApplicationContext(), this, "请您输入UC帐号", true);
    relativeLayout1.setId(10);
    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
    layoutParams2.addRule(10, -1);
    relativeLayout1.setLayoutParams((ViewGroup.LayoutParams)layoutParams2);
    TextView textView3 = new TextView(getApplicationContext());
    layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
    layoutParams2.addRule(3, 10);
    layoutParams2.setMargins(10, 5, 10, 10);
    textView3.setLayoutParams((ViewGroup.LayoutParams)layoutParams2);
    textView3.setId(1);
    textView3.setCompoundDrawablePadding(10);
    textView3.setTextColor(-13487566);
    if (Utils.isHdpi()) {
      str = "lock_hdpi.png";
    } else {
      str = "lock.png";
    } 
    textView3.setCompoundDrawablesWithIntrinsicBounds(Utils.getDrawableFromFile(str), null, null, null);
    textView3.setText("您好，购买此内容，请先登录UC账号。您可以输入UC帐号或者手机号码进行登录");
    TextView textView1 = Utils.generateBorderView((Context)getApplication());
    textView1.setId(11);
    RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, 1);
    layoutParams3.addRule(3, 1);
    textView1.setLayoutParams((ViewGroup.LayoutParams)layoutParams3);
    RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, -2);
    layoutParams4.setMargins(10, 10, 10, 5);
    TextView textView4 = new TextView(getApplicationContext());
    textView4.setLayoutParams((ViewGroup.LayoutParams)layoutParams4);
    textView4.setId(2);
    textView4.setText("UC账号:");
    textView4.setTextColor(-13487566);
    layoutParams4 = new RelativeLayout.LayoutParams(-1, -2);
    layoutParams4.addRule(3, 2);
    layoutParams4.setMargins(10, 5, 10, 5);
    this.mEtUsername = new EditText(getApplicationContext());
    this.mEtUsername.setLayoutParams((ViewGroup.LayoutParams)layoutParams4);
    this.mEtUsername.setSingleLine();
    this.mEtUsername.setId(3);
    this.mEtUsername.setHint("用户名");
    this.mEtPassword = new EditText(getApplicationContext());
    this.mEtPassword.setId(4);
    this.mEtPassword.setHint("密码");
    this.mEtPassword.setSingleLine();
    this.mEtPassword.setTransformationMethod((TransformationMethod)PasswordTransformationMethod.getInstance());
    layoutParams4 = new RelativeLayout.LayoutParams(-1, -2);
    layoutParams4.addRule(3, 3);
    layoutParams4.setMargins(10, 5, 10, 5);
    this.mEtPassword.setLayoutParams((ViewGroup.LayoutParams)layoutParams4);
    this.mEtSavePass = new CheckBox(getApplicationContext());
    layoutParams4 = new RelativeLayout.LayoutParams(-1, -2);
    layoutParams4.addRule(3, 4);
    layoutParams4.setMargins(10, 5, 10, 5);
    this.mEtSavePass.setId(5);
    this.mEtSavePass.setTextColor(-12303292);
    this.mEtSavePass.setText("保存密码");
    this.mEtSavePass.setLayoutParams((ViewGroup.LayoutParams)layoutParams4);
    if (PrefUtil.getUCUserName(getApplicationContext()) != null) {
      this.mEtUsername.setText(PrefUtil.getUCUserName(getApplicationContext()));
      this.mEtSavePass.setChecked(true);
    } else {
      this.mEtSavePass.setChecked(false);
    } 
    if (PrefUtil.getUCUserPass(getApplicationContext()) != null)
      this.mEtPassword.setText(PrefUtil.getUCUserPass(getApplicationContext())); 
    Button button = new Button(getApplicationContext());
    button.setId(7);
    button.setText("确定购买");
    button.setOnClickListener(this);
    RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, -2);
    layoutParams5.topMargin = 10;
    layoutParams5.addRule(3, 5);
    layoutParams5.addRule(14);
    button.setLayoutParams((ViewGroup.LayoutParams)layoutParams5);
    RelativeLayout relativeLayout3 = new RelativeLayout(getApplicationContext());
    relativeLayout3.setId(7);
    relativeLayout3.setBackgroundColor(-984326);
    RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-1, -2);
    layoutParams6.addRule(3, 11);
    relativeLayout3.setLayoutParams((ViewGroup.LayoutParams)layoutParams6);
    relativeLayout3.addView((View)textView4);
    relativeLayout3.addView((View)this.mEtUsername);
    relativeLayout3.addView((View)this.mEtPassword);
    relativeLayout3.addView((View)this.mEtSavePass);
    relativeLayout3.addView((View)button);
    RelativeLayout relativeLayout2 = new RelativeLayout(getApplicationContext());
    relativeLayout2.setBackgroundColor(-1);
    relativeLayout2.setLayoutParams((ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -1));
    relativeLayout2.addView((View)relativeLayout1);
    relativeLayout2.addView((View)textView3);
    relativeLayout2.addView((View)textView1);
    relativeLayout2.addView((View)relativeLayout3);
    TextView textView2 = Utils.generateBorderView((Context)getApplication());
    RelativeLayout.LayoutParams layoutParams1 = new RelativeLayout.LayoutParams(-1, 1);
    layoutParams1.addRule(3, 7);
    textView2.setLayoutParams((ViewGroup.LayoutParams)layoutParams1);
    relativeLayout2.addView((View)textView2);
    ScrollView scrollView = new ScrollView((Context)getApplication());
    scrollView.setBackgroundColor(-1);
    scrollView.addView((View)relativeLayout2);
    setContentView((View)scrollView);
  }
  
  private void buildUPointPayPassView() {
    String str;
    this.mType = 3;
    RelativeLayout relativeLayout1 = Utils.initSubTitle(getApplicationContext(), this, "请您输入U点支付密码", true);
    relativeLayout1.setId(10);
    RelativeLayout.LayoutParams layoutParams1 = new RelativeLayout.LayoutParams(-1, -2);
    layoutParams1.addRule(10, -1);
    relativeLayout1.setLayoutParams((ViewGroup.LayoutParams)layoutParams1);
    TextView textView2 = new TextView(getApplicationContext());
    layoutParams1 = new RelativeLayout.LayoutParams(-1, -2);
    layoutParams1.addRule(3, 10);
    layoutParams1.setMargins(10, 5, 10, 10);
    textView2.setLayoutParams((ViewGroup.LayoutParams)layoutParams1);
    textView2.setId(1);
    textView2.setCompoundDrawablePadding(10);
    textView2.setTextColor(-13487566);
    if (Utils.isHdpi()) {
      str = "lock_hdpi.png";
    } else {
      str = "lock.png";
    } 
    textView2.setCompoundDrawablesWithIntrinsicBounds(Utils.getDrawableFromFile(str), null, null, null);
    textView2.setText("您好，您的U点设置有支付密码，请收入后点击确认进行支付");
    TextView textView1 = Utils.generateBorderView((Context)getApplication());
    textView1.setId(11);
    RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, 1);
    layoutParams3.addRule(3, 1);
    textView1.setLayoutParams((ViewGroup.LayoutParams)layoutParams3);
    RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, -2);
    layoutParams4.setMargins(10, 10, 10, 5);
    TextView textView3 = new TextView(getApplicationContext());
    textView3.setLayoutParams((ViewGroup.LayoutParams)layoutParams4);
    textView3.setId(2);
    textView3.setText("UC支付密码:");
    textView3.setTextColor(-13487566);
    layoutParams4 = new RelativeLayout.LayoutParams(-1, -2);
    layoutParams4.addRule(3, 2);
    layoutParams4.setMargins(10, 5, 10, 5);
    this.mEtPayPass = new EditText(getApplicationContext());
    this.mEtPayPass.setLayoutParams((ViewGroup.LayoutParams)layoutParams4);
    this.mEtPayPass.setSingleLine();
    this.mEtPayPass.setId(3);
    this.mEtPayPass.setHint("支付密码");
    Button button = new Button(getApplicationContext());
    button.setId(7);
    button.setText("确定购买");
    button.setOnClickListener(this);
    RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, -2);
    layoutParams5.topMargin = 10;
    layoutParams5.addRule(3, 5);
    layoutParams5.addRule(14);
    button.setLayoutParams((ViewGroup.LayoutParams)layoutParams5);
    RelativeLayout relativeLayout3 = new RelativeLayout(getApplicationContext());
    relativeLayout3.setId(7);
    relativeLayout3.setBackgroundColor(-984326);
    RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-1, -2);
    layoutParams6.addRule(3, 11);
    relativeLayout3.setLayoutParams((ViewGroup.LayoutParams)layoutParams6);
    relativeLayout3.addView((View)textView3);
    relativeLayout3.addView((View)this.mEtPayPass);
    relativeLayout3.addView((View)button);
    RelativeLayout relativeLayout2 = new RelativeLayout(getApplicationContext());
    relativeLayout2.setBackgroundColor(-1);
    relativeLayout2.setLayoutParams((ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -1));
    relativeLayout2.addView((View)relativeLayout1);
    relativeLayout2.addView((View)textView2);
    relativeLayout2.addView((View)textView1);
    relativeLayout2.addView((View)relativeLayout3);
    textView1 = Utils.generateBorderView((Context)getApplication());
    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, 1);
    layoutParams2.addRule(3, 7);
    textView1.setLayoutParams((ViewGroup.LayoutParams)layoutParams2);
    relativeLayout2.addView((View)textView1);
    ScrollView scrollView = new ScrollView((Context)getApplication());
    scrollView.setBackgroundColor(-1);
    scrollView.addView((View)relativeLayout2);
    setContentView((View)scrollView);
  }
  
  private void buildUPointPaymentView() {
    this.mType = 1;
    TextView textView1 = new TextView(getApplicationContext());
    textView1.setTextSize(16.0F);
    textView1.setPadding(20, 0, 20, 0);
    textView1.setTextColor(-12303292);
    textView1.setText(String.format("支付名称 : %s", new Object[] { this.mPaymentInfo.getPayname() }));
    this.mTvProduct = new TextView(getApplicationContext());
    this.mTvProduct.setTextSize(16.0F);
    this.mTvProduct.setPadding(20, 0, 20, 0);
    this.mTvProduct.setText("产品名 : ");
    this.mTvProduct.setTextColor(-12303292);
    TextView textView2 = new TextView(getApplicationContext());
    textView2.setTextSize(16.0F);
    textView2.setPadding(20, 0, 20, 20);
    textView2.setText(String.format("所购内容 : %s", new Object[] { this.mPaymentInfo.getPaydesc() }));
    textView2.setTextColor(-12303292);
    TextView textView3 = new TextView(getApplicationContext());
    textView3.setTextSize(16.0F);
    textView3.setPadding(20, 0, 20, 0);
    textView3.setText(String.format("支付数额 : %dU点（价值%s元）", new Object[] { Integer.valueOf(this.mPaymentInfo.getMoney()), (new DecimalFormat("##0.00")).format((this.mPaymentInfo.getMoney() / 10.0F)) }));
    textView3.setTextColor(-13487566);
    this.mTvDiscountTextView = new TextView(getApplicationContext());
    this.mTvDiscountTextView.setTextSize(16.0F);
    this.mTvDiscountTextView.setPadding(20, 0, 20, 0);
    this.mTvDiscountTextView.setText("U点折扣 : ");
    this.mTvDiscountTextView.setTextColor(-13487566);
    this.mTvVipDiscountTextView = new TextView(getApplicationContext());
    this.mTvVipDiscountTextView.setTextSize(16.0F);
    this.mTvVipDiscountTextView.setPadding(20, 0, 20, 0);
    this.mTvVipDiscountTextView.setText("会员折扣 : ");
    this.mTvVipDiscountTextView.setTextColor(-13487566);
    this.mTvVipDiscountTimeTextView = new TextView(getApplicationContext());
    this.mTvVipDiscountTimeTextView.setTextSize(16.0F);
    this.mTvVipDiscountTimeTextView.setPadding(20, 0, 20, 0);
    this.mTvVipDiscountTimeTextView.setText("会员折扣到期时间 : ");
    this.mTvVipDiscountInfo = new TextView(getApplicationContext());
    this.mTvVipDiscountInfo.setTextColor(-13487566);
    this.mTvVipDiscountInfo = new TextView(getApplicationContext());
    this.mTvVipDiscountInfo.setTextSize(16.0F);
    this.mTvVipDiscountInfo.setPadding(20, 0, 20, 0);
    this.mTvVipDiscountInfo.setText("会员折扣信息 : ");
    this.mTvVipDiscountInfo.setTextColor(-13487566);
    this.mBtnPay = new Button(getApplicationContext());
    this.mBtnPay.setText("确认");
    this.mBtnPay.setOnClickListener(this);
    this.mBtnPay.setVisibility(8);
    LinearLayout.LayoutParams layoutParams1 = new LinearLayout.LayoutParams(300, -2);
    layoutParams1.gravity = 1;
    LinearLayout linearLayout2 = new LinearLayout(getApplicationContext());
    linearLayout2.addView((View)this.mBtnPay, (ViewGroup.LayoutParams)layoutParams1);
    linearLayout2.setGravity(1);
    LinearLayout linearLayout1 = new LinearLayout(getApplicationContext());
    linearLayout1.setOrientation(1);
    linearLayout1.setBackgroundColor(-1);
    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
    linearLayout1.addView((View)Utils.initSubTitle(getApplicationContext(), this, "需要支付的内容", true), (ViewGroup.LayoutParams)layoutParams2);
    linearLayout1.addView((View)textView1, (ViewGroup.LayoutParams)layoutParams2);
    linearLayout1.addView((View)this.mTvProduct, (ViewGroup.LayoutParams)layoutParams2);
    linearLayout1.addView((View)textView2, (ViewGroup.LayoutParams)layoutParams2);
    linearLayout1.addView((View)textView3, (ViewGroup.LayoutParams)layoutParams2);
    linearLayout1.addView((View)this.mTvDiscountTextView, (ViewGroup.LayoutParams)layoutParams2);
    linearLayout1.addView((View)this.mTvVipDiscountTextView, (ViewGroup.LayoutParams)layoutParams2);
    linearLayout1.addView((View)this.mTvVipDiscountTimeTextView, (ViewGroup.LayoutParams)layoutParams2);
    linearLayout1.addView((View)this.mTvVipDiscountInfo, (ViewGroup.LayoutParams)layoutParams2);
    linearLayout1.addView((View)linearLayout2, (ViewGroup.LayoutParams)layoutParams2);
    ScrollView scrollView = new ScrollView(getApplicationContext());
    scrollView.setBackgroundColor(-1);
    scrollView.addView((View)linearLayout1);
    setContentView((View)scrollView);
    if (Utils.getUPointInfo() == null) {
      showDialog(14);
      Api.queryUPointDiscount(getApplicationContext(), this, Utils.getPaymentInfo().getCpID(), Utils.getPaymentInfo().getmGameID(), Utils.getPaymentInfo().getMoney());
      return;
    } 
    initUPointPayView(Utils.getUPointInfo());
  }
  
  private void fillData() {
    Iterator<IType> iterator2;
    IType iType;
    ArrayList arrayList = PrefUtil.getAvailablePayType(getApplicationContext(), this.mPaymentInfo.getPaytype());
    IType[] arrayOfIType = new IType[arrayList.size()];
    if ("overage".equals(this.mPaymentInfo.getPaytype())) {
      iterator2 = arrayList.iterator();
      while (true) {
        if (iterator2.hasNext()) {
          IType iType1 = iterator2.next();
          if ("upoint".equals(iType1.getId())) {
            arrayOfIType[0] = iType1;
          } else {
            continue;
          } 
        } 
        this.mListView.setAdapter((ListAdapter)new CustomAdapter(getApplicationContext(), arrayOfIType));
        return;
      } 
    } 
    if ("sms".equals(this.mPaymentInfo.getPaytype())) {
      Iterator<IType> iterator = iterator2.iterator();
      while (true) {
        if (iterator.hasNext()) {
          iType = iterator.next();
          if ("sms".equals(iType.getId())) {
            arrayOfIType[0] = iType;
          } else {
            continue;
          } 
        } 
        this.mListView.setAdapter((ListAdapter)new CustomAdapter(getApplicationContext(), arrayOfIType));
        return;
      } 
    } 
    Iterator<IType> iterator1 = iType.iterator();
    while (true) {
      if (iterator1.hasNext()) {
        IType iType1 = iterator1.next();
        if ("upoint".equals(iType1.getId())) {
          arrayOfIType[0] = iType1;
          continue;
        } 
        if ("sms".equals(iType1.getId()))
          arrayOfIType[arrayOfIType.length - 1] = iType1; 
        continue;
      } 
      this.mListView.setAdapter((ListAdapter)new CustomAdapter(getApplicationContext(), arrayOfIType));
      return;
    } 
  }
  
  private int getPayedAmount() {
    int i = (Utils.getSmsPayment() - PrefUtil.getPayedAmount(getApplicationContext())) / this.mSmsInfo.money;
    return this.mSmsInfo.money * (i - this.mLeftSmsToSendCount);
  }
  
  public static void init(Context paramContext) {
    SyncChargeChannelHandler.init();
    SyncPayChannelHandler.init();
    SyncSmsInfoHandler.init();
  }
  
  private boolean initPayment() {
    boolean bool;
    this.mPaymentInfo = (PaymentInfo)getIntent().getSerializableExtra("com.mappn.sdk.paymentinfo");
    if (this.mPaymentInfo == null)
      throw new IllegalArgumentException("PaymentInfo必须设置"); 
    this.mPaymentInfo.setPaytype("sms");
    int i = this.mPaymentInfo.getMoney();
    if (i <= 0 || i > 10000 || i % 5 != 0) {
      showDialog(0);
      return false;
    } 
    if (this.mPaymentInfo.getPayname() == null)
      throw new IllegalArgumentException("必须指定支付内容名称"); 
    if (this.mPaymentInfo.getPaydesc() == null)
      throw new IllegalArgumentException("必须指定支付内容描述"); 
    if (this.mPaymentInfo.getmGameID() == null)
      throw new IllegalArgumentException("必须指定游戏ID"); 
    if (this.mPaymentInfo.getmGameID().length() != 2)
      throw new IllegalArgumentException("游戏ID必须为两位数字"); 
    if (!Utils.isNumeric(this.mPaymentInfo.getmGameID()))
      throw new IllegalArgumentException("游戏ID必须为两位数字"); 
    if (this.mPaymentInfo.getmActionID() == null)
      throw new IllegalArgumentException("必须指定支付点ID"); 
    if (this.mPaymentInfo.getmActionID().length() != 2)
      throw new IllegalArgumentException("支付点ID必须为两位数字"); 
    if (!Utils.isNumeric(this.mPaymentInfo.getmActionID()))
      throw new IllegalArgumentException("支付点ID必须为两位数字"); 
    if (this.mPaymentInfo.getPayname().length() > 50)
      this.mPaymentInfo.setPayname(this.mPaymentInfo.getPayname().substring(0, 50)); 
    if (this.mPaymentInfo.getPaydesc().length() > 100)
      this.mPaymentInfo.setPaydesc(this.mPaymentInfo.getPaydesc().substring(0, 100)); 
    try {
      String str = Utils.getCpID(getApplicationContext());
      if (!Pattern.matches("^[0-9a-zA-Z]{1,10}$", str)) {
        showDialog(22);
        return false;
      } 
      this.mPaymentInfo.setCpID(str);
      if (this.mPaymentInfo.getUsername() != null)
        PrefUtil.setUCUserName(getApplicationContext(), this.mPaymentInfo.getUsername()); 
      Utils.setPaymentInfo(this.mPaymentInfo);
      bool = true;
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      showDialog(22);
      if (this.mPaymentInfo.getUsername() != null)
        PrefUtil.setUCUserName(getApplicationContext(), this.mPaymentInfo.getUsername()); 
      Utils.setPaymentInfo(this.mPaymentInfo);
      bool = true;
    } catch (NullPointerException nullPointerException) {
      showDialog(22);
    } 
    return bool;
  }
  
  private void initSmsPayView(TextView paramTextView1, TextView paramTextView2, int paramInt, Button paramButton1, Button paramButton2, RelativeLayout paramRelativeLayout) {
    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(150, -2);
    try {
      int i = PrefUtil.getPayedAmount(getApplicationContext());
      if (i == 0) {
        if (this.mSmsInfo == null) {
          this.mSmsInfo = Utils.getSmsInfos().filterSmsInfo(getApplicationContext(), paramInt);
          this.mSmsInfo.setExtInfo(this.mPaymentInfo);
        } 
        i = paramInt / this.mSmsInfo.money;
        int j = i;
        if (paramInt % this.mSmsInfo.money != 0)
          j = i + 1; 
        if (!this.mSmsInfo.isNeedconfirm()) {
          Spanned spanned;
          if (this.mLeftSmsToSendCount == -1) {
            this.mLeftSmsToReceiveCount = j;
            this.mLeftSmsToSendCount = j;
            spanned = Html.fromHtml(String.format("尊敬的用户，感谢您为游戏支付，您需要发送<font color='#FF4500'>[ %d ]</font>条 %d 元的短信，购买<font color='#FF4500'>[%s]</font>，共计<font color='#FF4500'>[ %d ]</font>元，点击<font color='#FF4500'>[点播]</font>开始发送。请注意发送开始后，您不能中断发送，否则购买将不成功。", new Object[] { Integer.valueOf(this.mLeftSmsToSendCount), Integer.valueOf(this.mSmsInfo.money), this.mPaymentInfo.getPayname(), Integer.valueOf(paramInt) }));
            this.mIsShowInfo = true;
          } else {
            spanned = Html.fromHtml(String.format("尊敬的用户，点击<font color='#FF4500'>[确定]</font>按钮，发送第<font color='#FF4500'>[ %d ]</font>条短信。", new Object[] { Integer.valueOf(j - this.mLeftSmsToSendCount + 1) }));
            paramButton1.setVisibility(8);
            paramButton2.setText("确定");
            layoutParams2.addRule(14, -1);
          } 
          paramTextView1.setText((CharSequence)spanned);
          paramTextView2.setText(this.mSmsInfo.getInfobeforesend());
        } else {
          paramTextView1.setText(this.mSmsInfo.getInfobeforesend());
          paramButton1.setVisibility(8);
          paramButton2.setText("确定");
          layoutParams2.addRule(14, -1);
        } 
      } else {
        int j = paramInt - i;
        if (this.mSmsInfo == null) {
          this.mSmsInfo = Utils.getSmsInfos().filterSmsInfo(getApplicationContext(), j);
          this.mSmsInfo.setExtInfo(this.mPaymentInfo);
        } 
        if (!this.mSmsInfo.isNeedconfirm()) {
          Spanned spanned;
          if (this.mLeftSmsToSendCount == -1) {
            int k = j / this.mSmsInfo.money;
            paramInt = k;
            if (j % this.mSmsInfo.money != 0)
              paramInt = k + 1; 
            this.mIsShowInfo = true;
            this.mLeftSmsToSendCount = paramInt;
            this.mLeftSmsToReceiveCount = paramInt;
            spanned = Html.fromHtml(String.format("您以前成功发送过总计 %d 元的短信购买<font color='#FF4500'>[%s]</font>，目前还需发送<font color='#FF4500'>[ %d ]</font>条  %d 元短信继续购买，点击<font color='#FF4500'>[点播]</font>按钮开始发送。", new Object[] { Integer.valueOf(i), this.mPaymentInfo.getPayname(), Integer.valueOf(this.mLeftSmsToSendCount), Integer.valueOf(this.mSmsInfo.money) }));
          } else {
            spanned = Html.fromHtml(String.format("尊敬的用户，点击<font color='#FF4500'>[确定]</font>按钮，开始发送第<font color='#FF4500'>[ %d ]</font>条短信。", new Object[] { Integer.valueOf(j / this.mSmsInfo.money - this.mLeftSmsToSendCount + 1), Integer.valueOf(this.mLeftSmsToSendCount) }));
            paramButton1.setVisibility(8);
            paramButton2.setText("确定");
            layoutParams2.addRule(14, -1);
          } 
          paramTextView1.setText((CharSequence)spanned);
          paramTextView2.setText(this.mSmsInfo.getInfobeforesend());
        } else {
          paramTextView1.setText(this.mSmsInfo.getInfobeforesend());
          paramButton1.setVisibility(8);
          paramButton2.setText("确定");
          layoutParams2.addRule(14, -1);
        } 
      } 
      Linkify.addLinks(paramTextView1, 4);
      Linkify.addLinks(paramTextView2, 4);
    } catch (SimCardNotSupportException simCardNotSupportException) {
      this.mSmsResultInfo = simCardNotSupportException.getMessage();
      showDialog(16);
    } 
    layoutParams2.addRule(12, -1);
    layoutParams2.setMargins(10, 20, 10, 10);
    paramButton2.setLayoutParams((ViewGroup.LayoutParams)layoutParams2);
    paramRelativeLayout.addView((View)paramButton2);
    RelativeLayout.LayoutParams layoutParams1 = new RelativeLayout.LayoutParams(150, -2);
    layoutParams1.addRule(11, -1);
    layoutParams1.addRule(12, -1);
    layoutParams1.setMargins(10, 20, 10, 10);
    paramButton1.setLayoutParams((ViewGroup.LayoutParams)layoutParams1);
    paramRelativeLayout.addView((View)paramButton1);
    setContentView((View)paramRelativeLayout);
  }
  
  private void initUPointPayView(UPointInfo paramUPointInfo) {
    this.mTvDiscountTextView.setText(String.format("U点折扣 : %s折(%sU点)", new Object[] { paramUPointInfo.getDiscount(), paramUPointInfo.getDiscounttext() }));
    if (paramUPointInfo.getVipdiscount() != null && paramUPointInfo.getVipdiscount().length() > 0) {
      this.mTvDiscountTextView.setText(String.format("会员折扣 : %s折(%sU点)", new Object[] { paramUPointInfo.getVipdiscount(), paramUPointInfo.getVipdiscounttext() }));
      this.mTvVipDiscountTimeTextView.setText(String.format("会员折扣到期时间 : ", new Object[] { paramUPointInfo.getVipdiscounttime() }));
      this.mTvVipDiscountInfo.setText("会员折扣到期时间 : " + paramUPointInfo.getDiscountinfo());
    } else {
      this.mTvVipDiscountTextView.setVisibility(8);
      this.mTvVipDiscountTimeTextView.setVisibility(8);
      this.mTvVipDiscountInfo.setVisibility(8);
    } 
    this.mBtnPay.setVisibility(0);
  }
  
  private void pay() {
    showDialog(6);
    Api.pay(getApplicationContext(), this, this.mPaymentInfo, this.mUPayInfo);
  }
  
  private void sendConfirmSms(String paramString) {
    showDialog(17);
    try {
      SmsInfo.sendSms(getApplicationContext(), paramString.split(",,,,")[0], paramString.split(",,,,")[1]);
    } catch (Exception exception) {}
  }
  
  private void sendFirstSms(SmsInfo paramSmsInfo) {
    showDialog(17);
    try {
      paramSmsInfo.sendFirstSms(getApplicationContext());
    } catch (Exception exception) {}
  }
  
  public void confirmEnterPaymentPoint() {
    PrefUtil.increaseArriveCount(getApplicationContext());
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onClick(View paramView) {
    String str1;
    String str2;
    if (paramView == this.mBtnPay) {
      this.mBtnPay.setEnabled(false);
      buildUPointPayLoginView();
    } 
    switch (paramView.getId()) {
      default:
      
      case 3:
        if (this.mIsShowInfo) {
          buildSmsPaymentView();
          this.mIsShowInfo = false;
        } 
        if (this.mSmsInfo != null) {
          registerReceiver(this.mSmsReceiver, new IntentFilter("com.uc.androidsdk.SMS_SENT_ACTION"));
          sendFirstSms(this.mSmsInfo);
        } 
      case 7:
        ((Button)paramView).setEnabled(false);
        str2 = this.mEtUsername.getText().toString();
        str1 = this.mEtPassword.getText().toString();
        if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str1))
          showDialog(28); 
        if (TextUtils.isEmpty(str1))
          showDialog(29); 
        if (TextUtils.isEmpty(str2))
          showDialog(30); 
        this.mUPayInfo = new UPointPayInfo(str2, str1, "", this.mPaymentInfo.getCpID(), this.mPaymentInfo.getmGameID(), this.mPaymentInfo.getMoney(), "");
        pay();
      case 8:
        ((Button)str1).setEnabled(false);
        str1 = this.mEtPayPass.getText().toString();
        if (TextUtils.isEmpty(str1)) {
          showDialog(28);
        } else {
          this.mUPayInfo.setPaypwd(str1);
          pay();
        } 
      case 5:
        if (this.mConfirmSmsInfoString != null && this.mConfirmSmsInfoString.contains(",,,,"))
          sendConfirmSms(this.mConfirmSmsInfoString); 
      case 4:
        buildPaymentView();
      case 6:
        showDialog(23);
      case 9:
        switch (this.mType) {
          default:
            return;
          case 0:
            finish();
          case 1:
            buildPaymentView();
          case 2:
            buildUPointPaymentView();
          case 3:
            buildUPointPayLoginView();
          case 4:
            if (!this.mSmsInfo.isNeedconfirm() && !this.mIsShowInfo) {
              int i = Utils.getSmsPayment() / this.mSmsInfo.money;
              if (this.mLeftSmsToSendCount != -1 && this.mLeftSmsToSendCount != i)
                showDialog(27); 
              buildSmsPaymentView();
            } 
            buildPaymentView();
          case 5:
            break;
        } 
        showDialog(23);
      case 10:
        break;
    } 
    switch (this.mType) {
      default:
        finish();
      case 4:
        if (this.mSmsInfo.isNeedconfirm() || this.mIsShowInfo) {
          int i = Utils.getSmsPayment() / this.mSmsInfo.money;
          if (this.mLeftSmsToSendCount != -1 && this.mLeftSmsToSendCount != i)
            showDialog(27); 
          buildPaymentView();
        } 
      case 5:
        break;
    } 
    showDialog(23);
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    this.mIsValid = initPayment();
    if (this.mIsValid) {
      Utils.init(getApplicationContext());
      Utils.initTitleBar(this);
      buildPaymentView();
      confirmEnterPaymentPoint();
      (new HandlerProxy(getApplicationContext())).handleRequest();
    } 
  }
  
  protected Dialog onCreateDialog(int paramInt) {
    int i;
    switch (paramInt) {
      default:
        return super.onCreateDialog(paramInt);
      case 0:
        return DialogUtil.createOKWarningDialog((Context)this, paramInt, "该应用要求支付的金额不符合要求，不能成功支付。", this);
      case 22:
        return DialogUtil.createOKWarningDialog((Context)this, paramInt, "CPID为字符串和数字任意组合，不能由中文字符、标点符号或空格，长度不超过10个英文字符。", this);
      case 2:
        return DialogUtil.createOKWarningDialogSupportLink((Context)this, paramInt, "什么是U点?", "U点是<a href='http://wap.uc.cn'>UC-优视</a>提供的一种虚拟货币，主要用于购买软件和游戏里的内容（如：道具、关卡、软件、使用时长等）。<br /><br />U点兑换标准：<br />1元可兑换10U点。<br />通过以下链接充值U点：<br /><a href='http://pay.uc.cn'>UC-优视</a>", null);
      case 14:
        return DialogUtil.createIndeterminateProgressDialog((Context)this, paramInt, "连接服务器，请稍等...", false, null);
      case 6:
        return DialogUtil.createIndeterminateProgressDialog((Context)this, paramInt, "正在支付，请勿关闭程序，请稍后......", false, null);
      case 7:
        return DialogUtil.createOKWarningDialog((Context)this, paramInt, "支付不成功，请确定您的账户当中的余额充足并网络连接正常。", null);
      case 8:
        return DialogUtil.createOKWarningDialog((Context)this, paramInt, "支付不成功，请确定您的账户当中的余额充足并网络连接正常。", null);
      case 9:
        return DialogUtil.createOKWarningDialog((Context)this, paramInt, "支付不成功，请确定您的账户当中的余额充足并网络连接正常。", null);
      case 37:
        return DialogUtil.createOKWarningDialog((Context)this, paramInt, "支付不成功，您的支付密码有误，不能支付成功！", null);
      case 10:
        return DialogUtil.createYesNoDialog((Context)this, paramInt, "支付不成功，连接服务器超时，是否重试?", this);
      case 38:
        return DialogUtil.createOKWarningDialog((Context)this, paramInt, "支付不成功，您已经禁止了发送支付短信，请重新尝试支付。", null);
      case 36:
        return DialogUtil.createYesNoDialog((Context)this, paramInt, "您手机时间不正确，为了确保安全支付，是否需要系统自动修正并完成支付?", this);
      case 11:
        return DialogUtil.createOKWarningDialog((Context)this, paramInt, "支付不成功，请确定您的账户当中的余额充足并网络连接正常。\n请联系客服4006-400-401。", null);
      case 13:
        return DialogUtil.createOKWarningDialog((Context)this, paramInt, "U点支付成功，祝您玩的开心", String.format("您的余额为%dU点", new Object[] { this.mNumber, Integer.valueOf(this.mBalance) }), this);
      case 5:
        return DialogUtil.createOKWarningDialog((Context)this, paramInt, "U点不足,不能继续支付！", null);
      case 15:
        return DialogUtil.createOKWarningDialog((Context)this, paramInt, "网络连接错误，请检查网络后再试。", this);
      case 16:
        return DialogUtil.createOKWarningDialog((Context)this, paramInt, this.mSmsResultInfo, this);
      case 17:
        return DialogUtil.createIndeterminateProgressDialog((Context)this, paramInt, "短信发送过程可能持续一分钟，请耐心等待...", false, null);
      case 19:
        return DialogUtil.createIndeterminateProgressDialog((Context)this, paramInt, "正在获取信息，请稍候......", false, null);
      case 20:
        return DialogUtil.createOKWarningDialog((Context)this, paramInt, "购买成功", this.mSmsResultInfo, this);
      case 21:
        return DialogUtil.createOKWarningDialog((Context)this, paramInt, this.mSmsResultInfo, this);
      case 23:
        return DialogUtil.createTwoButtonsDialog((Context)this, paramInt, "您已经取消了购买，将不会获得相应内容。请确认是否取消？", "取消", "不取消", this);
      case 24:
        return DialogUtil.createTwoButtonsDialog((Context)this, paramInt, (CharSequence)Html.fromHtml("购买确认短信未删除，如需购买请再次发送短信或采用其他支付方式，<font color='red'>请勿到短信收件箱进行回复</font>，谢谢！"), "返回购买页", "返回应用", this);
      case 25:
        return DialogUtil.createTwoButtonsDialog((Context)this, paramInt, "购买确认短信已删除，如需购买请再次发送短信或采用其他支付方式，谢谢！", "返回购买页", "返回应用", this);
      case 26:
        return DialogUtil.createOKWarningDialog((Context)this, paramInt, "支付超时，点击确定重新验证支付结果。最多 需要1分钟，请耐心等待...", this);
      case 27:
        i = getPayedAmount();
        return DialogUtil.createTwoButtonsDialog((Context)this, paramInt, String.format("您已经支付过【%d】元短信，现在取消发送将不能成功购买【%s】。如取消发送已付金额不会返还，只能计算到您下次购买【%s】中。请再次确认是否取消这次支付？", new Object[] { Integer.valueOf(PrefUtil.getPayedAmount(getApplicationContext()) + i), this.mPaymentInfo.getPayname(), this.mPaymentInfo.getPayname() }), "返回继续支付", "确认取消", this);
      case 18:
        return DialogUtil.createOKWarningDialog((Context)this, paramInt, "短信发送失败", null);
      case 35:
        return DialogUtil.createIndeterminateProgressDialog((Context)this, paramInt, "U点支付中，请稍候...", false, null);
      case 28:
        return DialogUtil.createOKWarningDialog((Context)this, paramInt, "请输入账号和密码。", null);
      case 29:
        return DialogUtil.createOKWarningDialog((Context)this, paramInt, "密码为空，请输入密码。", null);
      case 30:
        return DialogUtil.createOKWarningDialog((Context)this, paramInt, "用户名为空，请输入用户名。", null);
      case 31:
        return DialogUtil.createOKWarningDialog((Context)this, paramInt, "用户名必须大于3个字。", null);
      case 32:
        return DialogUtil.createOKWarningDialog((Context)this, paramInt, "用户名必须小于17个字。", null);
      case 33:
        return DialogUtil.createOKWarningDialog((Context)this, paramInt, "密码不能为空。", null);
      case 34:
        break;
    } 
    return DialogUtil.createOKWarningDialog((Context)this, paramInt, "登录失败，您的帐号和密码不匹配。", null);
  }
  
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
  
  public void onError(int paramInt1, int paramInt2) {
    switch (paramInt1) {
      default:
        return;
      case 3:
        switch (paramInt2) {
          default:
            this.mBtnPay.setEnabled(true);
            removeDialog(6);
            showDialog(7);
          case 425:
            this.mBtnPay.setEnabled(true);
            removeDialog(6);
            showDialog(8);
          case 219:
            this.mBtnPay.setEnabled(false);
            removeDialog(6);
            showDialog(5);
            buildPaymentView();
          case 500:
            this.mBtnPay.setEnabled(true);
            removeDialog(6);
            showDialog(11);
          case -1:
            break;
        } 
        this.mTimeoutCounter++;
        if (this.mTimeoutCounter < 2)
          Api.pay(getApplicationContext(), this, this.mPaymentInfo, this.mUPayInfo); 
        this.mTimeoutCounter = 0;
        this.mBtnPay.setEnabled(true);
        removeDialog(6);
        showDialog(10);
      case 18:
        break;
    } 
    dismissDialog(14);
    showDialog(15);
    buildPaymentView();
  }
  
  public void onFinish() {
    fillData();
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {
    if (paramInt != 0) {
      String str = ((CustomAdapter)((HeaderViewListAdapter)paramAdapterView.getAdapter()).getWrappedAdapter()).getItem(paramInt - 1).getId();
      if ("upoint".equals(str)) {
        buildUPointPaymentView();
        return;
      } 
      if ("sms".equals(str))
        buildSmsPaymentView(); 
    } 
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent) {
    switch (paramInt) {
      default:
        return super.onKeyDown(paramInt, paramKeyEvent);
      case 4:
        break;
    } 
    switch (this.mType) {
      default:
      
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
          paramInt = Utils.getSmsPayment() / this.mSmsInfo.money;
          if (this.mLeftSmsToSendCount != -1 && this.mLeftSmsToSendCount != paramInt) {
            showDialog(27);
          } else {
            buildPaymentView();
          } 
        } else {
          buildPaymentView();
        } 
        return true;
      case 5:
        break;
    } 
    showDialog(23);
    return true;
  }
  
  public Object onPreHandle(int paramInt, HttpResponse paramHttpResponse) {
    if (5 == paramInt || 8 == paramInt)
      return Boolean.valueOf(true); 
    String str = Utils.getBodyString(paramInt, paramHttpResponse);
    if (TextUtils.isEmpty(str))
      return null; 
    switch (paramInt) {
      default:
        return null;
      case 3:
        try {
          String str1 = XMLParser.parsePayOrder(str);
        } catch (Exception null) {
          exception.printStackTrace();
          break;
        } 
        return exception;
      case 18:
        break;
    } 
    try {
      UPointInfo uPointInfo = XMLParser.parseUPointInfo(str);
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    return exception;
  }
  
  protected void onPrepareDialog(int paramInt, Dialog paramDialog) {
    super.onPrepareDialog(paramInt, paramDialog);
    if (paramDialog.isShowing())
      paramDialog.dismiss(); 
  }
  
  public void onSuccess(int paramInt, Object paramObject) {
    Object object;
    switch (paramInt) {
      default:
        return;
      case 3:
        paramObject = ((String)paramObject).split("#");
        paramInt = Integer.parseInt((String)paramObject[0]);
        object = paramObject[1];
        removeDialog(6);
        if (paramInt == -110) {
          showDialog(7);
          this.mUPayInfo.updateConsumeId();
        } 
        if (paramInt == -102 && object.equals("uc_tm_modify")) {
          paramObject = paramObject[2];
          this.mUPayInfo.setTm((String)paramObject);
          showDialog(36);
        } 
        if (paramInt < 0)
          if (paramInt == -102) {
            if (object.equals("uc_password_error"))
              showDialog(34); 
            if (object.equals("um_account_error"))
              showDialog(5); 
            if (object.equals("um_paypwd_error"))
              showDialog(37); 
            if (object.equals("um_paypwd_error")) {
              if (this.mType == 3)
                showDialog(7); 
              if (this.mEtSavePass.isChecked()) {
                PrefUtil.setUCUserName(getApplicationContext(), this.mEtUsername.getText().toString());
                PrefUtil.setUCUserPass(getApplicationContext(), this.mEtPassword.getText().toString());
              } else {
                PrefUtil.clearUCUserName(getApplicationContext());
                PrefUtil.clearUCUserPass(getApplicationContext());
              } 
              buildUPointPayPassView();
            } 
            if (object.equals("um_system_error")) {
              showDialog(7);
              this.mUPayInfo.updateConsumeId();
            } 
          }  
        if (this.mEtSavePass.isChecked()) {
          PrefUtil.setUCUserName(getApplicationContext(), this.mEtUsername.getText().toString());
          PrefUtil.setUCUserPass(getApplicationContext(), this.mEtPassword.getText().toString());
        } else {
          PrefUtil.clearUCUserName(getApplicationContext());
          PrefUtil.clearUCUserPass(getApplicationContext());
        } 
        showDialog(13);
      case 18:
        break;
    } 
    paramObject = paramObject;
    initUPointPayView((UPointInfo)paramObject);
    Utils.setUPointInfo((UPointInfo)paramObject);
    dismissDialog(14);
  }
  
  public void onWarningDialogCancel(int paramInt) {
    // Byte code:
    //   0: iload_1
    //   1: tableswitch default -> 36, 23 -> 36, 24 -> 37, 25 -> 37, 26 -> 36, 27 -> 88
    //   36: return
    //   37: aload_0
    //   38: getfield mSmsHander : Landroid/os/Handler;
    //   41: ifnull -> 81
    //   44: aload_0
    //   45: getfield mSmsRunnable : Ljava/lang/Runnable;
    //   48: ifnull -> 81
    //   51: aload_0
    //   52: getfield mSmsHander : Landroid/os/Handler;
    //   55: aload_0
    //   56: getfield mSmsRunnable : Ljava/lang/Runnable;
    //   59: invokevirtual removeCallbacks : (Ljava/lang/Runnable;)V
    //   62: aload_0
    //   63: invokevirtual getContentResolver : ()Landroid/content/ContentResolver;
    //   66: aload_0
    //   67: getfield mSmsContent : Landroid/database/ContentObserver;
    //   70: invokevirtual unregisterContentObserver : (Landroid/database/ContentObserver;)V
    //   73: aload_0
    //   74: aload_0
    //   75: getfield mSmsReceiver : Landroid/content/BroadcastReceiver;
    //   78: invokevirtual unregisterReceiver : (Landroid/content/BroadcastReceiver;)V
    //   81: aload_0
    //   82: invokevirtual finish : ()V
    //   85: goto -> 36
    //   88: aload_0
    //   89: getfield mSmsHander : Landroid/os/Handler;
    //   92: ifnull -> 132
    //   95: aload_0
    //   96: getfield mSmsRunnable : Ljava/lang/Runnable;
    //   99: ifnull -> 132
    //   102: aload_0
    //   103: getfield mSmsHander : Landroid/os/Handler;
    //   106: aload_0
    //   107: getfield mSmsRunnable : Ljava/lang/Runnable;
    //   110: invokevirtual removeCallbacks : (Ljava/lang/Runnable;)V
    //   113: aload_0
    //   114: invokevirtual getContentResolver : ()Landroid/content/ContentResolver;
    //   117: aload_0
    //   118: getfield mSmsContent : Landroid/database/ContentObserver;
    //   121: invokevirtual unregisterContentObserver : (Landroid/database/ContentObserver;)V
    //   124: aload_0
    //   125: aload_0
    //   126: getfield mSmsReceiver : Landroid/content/BroadcastReceiver;
    //   129: invokevirtual unregisterReceiver : (Landroid/content/BroadcastReceiver;)V
    //   132: aload_0
    //   133: invokespecial buildPaymentView : ()V
    //   136: goto -> 36
    //   139: astore_2
    //   140: goto -> 132
    //   143: astore_2
    //   144: goto -> 81
    // Exception table:
    //   from	to	target	type
    //   73	81	143	java/lang/IllegalArgumentException
    //   124	132	139	java/lang/IllegalArgumentException
  }
  
  public void onWarningDialogOK(int paramInt) {
    // Byte code:
    //   0: iload_1
    //   1: lookupswitch default -> 124, 0 -> 165, 1 -> 165, 10 -> 125, 13 -> 146, 15 -> 223, 16 -> 223, 20 -> 139, 21 -> 172, 22 -> 165, 23 -> 230, 24 -> 223, 25 -> 172, 26 -> 239, 36 -> 132
    //   124: return
    //   125: aload_0
    //   126: invokespecial pay : ()V
    //   129: goto -> 124
    //   132: aload_0
    //   133: invokespecial pay : ()V
    //   136: goto -> 124
    //   139: aload_0
    //   140: invokevirtual getApplicationContext : ()Landroid/content/Context;
    //   143: invokestatic clearPayedAmount : (Landroid/content/Context;)V
    //   146: aload_0
    //   147: iconst_m1
    //   148: new android/content/Intent
    //   151: dup
    //   152: invokespecial <init> : ()V
    //   155: invokevirtual setResult : (ILandroid/content/Intent;)V
    //   158: aload_0
    //   159: invokevirtual finish : ()V
    //   162: goto -> 124
    //   165: aload_0
    //   166: invokevirtual finish : ()V
    //   169: goto -> 124
    //   172: aload_0
    //   173: getfield mSmsHander : Landroid/os/Handler;
    //   176: ifnull -> 197
    //   179: aload_0
    //   180: getfield mSmsRunnable : Ljava/lang/Runnable;
    //   183: ifnull -> 197
    //   186: aload_0
    //   187: getfield mSmsHander : Landroid/os/Handler;
    //   190: aload_0
    //   191: getfield mSmsRunnable : Ljava/lang/Runnable;
    //   194: invokevirtual removeCallbacks : (Ljava/lang/Runnable;)V
    //   197: aload_0
    //   198: getfield mSmsContent : Landroid/database/ContentObserver;
    //   201: ifnull -> 215
    //   204: aload_0
    //   205: invokevirtual getContentResolver : ()Landroid/content/ContentResolver;
    //   208: aload_0
    //   209: getfield mSmsContent : Landroid/database/ContentObserver;
    //   212: invokevirtual unregisterContentObserver : (Landroid/database/ContentObserver;)V
    //   215: aload_0
    //   216: aload_0
    //   217: getfield mSmsReceiver : Landroid/content/BroadcastReceiver;
    //   220: invokevirtual unregisterReceiver : (Landroid/content/BroadcastReceiver;)V
    //   223: aload_0
    //   224: invokespecial buildPaymentView : ()V
    //   227: goto -> 124
    //   230: aload_0
    //   231: bipush #24
    //   233: invokevirtual showDialog : (I)V
    //   236: goto -> 124
    //   239: iconst_4
    //   240: aload_0
    //   241: getfield mType : I
    //   244: if_icmpne -> 258
    //   247: aload_0
    //   248: aload_0
    //   249: getfield mSmsInfo : Lcom/uc/paymentsdk/payment/sms/SmsInfo;
    //   252: invokespecial sendFirstSms : (Lcom/uc/paymentsdk/payment/sms/SmsInfo;)V
    //   255: goto -> 124
    //   258: aload_0
    //   259: aload_0
    //   260: getfield mConfirmSmsInfoString : Ljava/lang/String;
    //   263: invokespecial sendConfirmSms : (Ljava/lang/String;)V
    //   266: goto -> 124
    //   269: astore_2
    //   270: goto -> 223
    // Exception table:
    //   from	to	target	type
    //   215	223	269	java/lang/IllegalArgumentException
  }
  
  private class SmsContent extends ContentObserver {
    private static final String BODY = "body";
    
    private static final String NUMBER = "address";
    
    private Cursor mCursor;
    
    final PaymentsActivity this$0;
    
    public SmsContent(Handler param1Handler) {
      super(param1Handler);
    }
    
    public void onChange(boolean param1Boolean) {
      super.onChange(param1Boolean);
      Uri uri = Uri.parse("content://sms/inbox");
      PaymentsActivity paymentsActivity = PaymentsActivity.this;
      String str2 = String.valueOf(PaymentsActivity.this.mSmsInfo.getSmsnumber()) + "%%";
      String str1 = String.valueOf(PaymentsActivity.this.mSmsInfo.getSmsConfirmNumber()) + "%%";
      this.mCursor = paymentsActivity.managedQuery(uri, new String[] { "_id", "address", "body" }, " address like ? or address like ? and read=?", new String[] { str2, str1, "0" }, "date desc");
      if (this.mCursor != null) {
        if (this.mCursor.moveToFirst()) {
          if (PaymentsActivity.this.mSmsId > 0 && PaymentsActivity.this.mSmsId > this.mCursor.getInt(0)) {
            this.mCursor.close();
            return;
          } 
          if (PaymentsActivity.this.mLeftSmsToReceiveCount <= 1) {
            PaymentsActivity.this.mSmsHander.removeCallbacks(PaymentsActivity.this.mSmsRunnable);
            PaymentsActivity.this.getContentResolver().unregisterContentObserver(PaymentsActivity.this.mSmsContent);
            try {
              PaymentsActivity.this.unregisterReceiver(PaymentsActivity.this.mSmsReceiver);
            } catch (IllegalArgumentException illegalArgumentException) {}
          } 
          PaymentsActivity.this.mSmsId = this.mCursor.getInt(0);
          ContentValues contentValues = new ContentValues();
          contentValues.put("read", "1");
          try {
            ContentResolver contentResolver = PaymentsActivity.this.getContentResolver();
            StringBuilder stringBuilder = new StringBuilder();
            this();
            contentResolver.update(uri, contentValues, " _id=?", new String[] { stringBuilder.append(PaymentsActivity.access$11(this.this$0)).toString() });
          } catch (SQLiteAbortException sQLiteAbortException) {
            sQLiteAbortException.printStackTrace();
          } 
          str1 = this.mCursor.getString(this.mCursor.getColumnIndex("body"));
          String str = this.mCursor.getString(this.mCursor.getColumnIndex("address"));
          if (4 == PaymentsActivity.this.mType) {
            if (PaymentsActivity.this.mSmsInfo.isNeedconfirm()) {
              PaymentsActivity.this.removeDialog(17);
              String str3 = PaymentsActivity.this.mSmsInfo.parseConfirmSmsConfirmNumber(str1);
              if (PaymentsActivity.this.mSmsInfo.isSuccess(str1) && str3 != null) {
                PaymentsActivity.this.mSmsHander.removeCallbacks(PaymentsActivity.this.mSmsRunnable);
                PaymentsActivity.this.buildSmsPaymentConfirmView(str, str3);
              } else {
                PaymentsActivity.this.removeDialog(17);
                PaymentsActivity.this.mSmsResultInfo = "余额不足，支付失败";
                PaymentsActivity.this.showDialog(21);
              } 
            } else {
              PrefUtil.setPayedAmount(PaymentsActivity.this.getApplicationContext(), PaymentsActivity.this.getPayedAmount());
              if (PaymentsActivity.this.mLeftSmsToReceiveCount > 1) {
                PaymentsActivity paymentsActivity1 = PaymentsActivity.this;
                paymentsActivity1.mLeftSmsToReceiveCount = paymentsActivity1.mLeftSmsToReceiveCount - 1;
              } else {
                if (PaymentsActivity.this.mLeftSmsToReceiveCount <= 1)
                  PaymentsActivity.this.removeDialog(17); 
                PaymentsActivity.this.mSmsResultInfo = "支付已完成，祝您玩得开心。";
                PaymentsActivity.this.showDialog(20);
              } 
              if (PaymentsActivity.this.mSmsInfo.getSmstype() == 1)
                Api.postSmsPayment(PaymentsActivity.this.getApplicationContext(), PaymentsActivity.this, PaymentsActivity.this.mPaymentInfo.getCpID(), PaymentsActivity.this.mPaymentInfo.getmGameID(), PaymentsActivity.this.mPaymentInfo.getmActionID(), Utils.getSmsPayment(), PaymentsActivity.this.mPaymentInfo.getmActionID(), PaymentsActivity.this.mSmsInfo.getSmschannelid(), PaymentsActivity.this.mSmsInfo.getSmsnumber(), PaymentsActivity.this.mSmsInfo.getContent(), PaymentsActivity.this.mSmsInfo.getSmstype()); 
            } 
          } else {
            PaymentsActivity.this.removeDialog(17);
            if (PaymentsActivity.this.mSmsInfo.parseConfirmResultSms(str1)) {
              PrefUtil.setPayedAmount(PaymentsActivity.this.getApplicationContext(), PaymentsActivity.this.getPayedAmount());
              if (PaymentsActivity.this.mLeftSmsToReceiveCount > 1) {
                PaymentsActivity paymentsActivity1 = PaymentsActivity.this;
                paymentsActivity1.mLeftSmsToReceiveCount = paymentsActivity1.mLeftSmsToReceiveCount - 1;
                paymentsActivity1 = PaymentsActivity.this;
                paymentsActivity1.mLeftSmsToSendCount = paymentsActivity1.mLeftSmsToSendCount - 1;
                PaymentsActivity.this.mSmsHander.removeCallbacks(PaymentsActivity.this.mSmsRunnable);
                PaymentsActivity.this.removeDialog(17);
                PaymentsActivity.this.buildSmsPaymentView();
              } else {
                PaymentsActivity.this.mSmsResultInfo = str1.replace("success", "购买成功");
                PaymentsActivity.this.showDialog(20);
              } 
              if (PaymentsActivity.this.mSmsInfo.getSmstype() == 1)
                Api.postSmsPayment(PaymentsActivity.this.getApplicationContext(), PaymentsActivity.this, PaymentsActivity.this.mPaymentInfo.getCpID(), PaymentsActivity.this.mPaymentInfo.getmGameID(), PaymentsActivity.this.mPaymentInfo.getmActionID(), Utils.getSmsPayment(), PaymentsActivity.this.mPaymentInfo.getmActionID(), PaymentsActivity.this.mSmsInfo.getSmschannelid(), PaymentsActivity.this.mSmsInfo.getSmsnumber(), PaymentsActivity.this.mSmsInfo.getContent(), PaymentsActivity.this.mSmsInfo.getSmstype()); 
            } else {
              PaymentsActivity.this.mSmsResultInfo = str1;
              PaymentsActivity.this.showDialog(21);
            } 
          } 
        } 
        this.mCursor.close();
      } 
    }
  }
}


/* Location:              /Users/thanh0x/DevTools0x/Rb2.0vip-dex2jar.jar!/com/uc/paymentsdk/payment/PaymentsActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */