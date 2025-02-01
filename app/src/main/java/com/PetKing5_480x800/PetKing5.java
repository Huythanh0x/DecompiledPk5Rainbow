package com.PetKing5_480x800;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.uc.paymentsdk.payment.PaymentInfo;
import com.uc.paymentsdk.payment.PaymentsActivity;
import javax.microedition.lcdui.CwaActivity;
import main.GameRun;
import main.SMSSender;
import main.XConnection;

/* loaded from: classes.dex */
/**
 * The PetKing5 class extends CwaActivity and serves as the main activity for the PetKing5 application.
 * It handles the initialization of various components and manages the payment process through different SMS types.
 * 
 * <p>Key functionalities include:</p>
 * <ul>
 *   <li>Initialization of SMSSender and PaymentsActivity in the constructor.</li>
 *   <li>Setting up the activity in the onCreate method.</li>
 *   <li>Handling different SMS payment types in the setSmshah method.</li>
 *   <li>Processing the result of payment activities in the onActivityResult method.</li>
 * </ul>
 * 
 * <p>Fields:</p>
 * <ul>
 *   <li>ad: An AlertDialog instance.</li>
 *   <li>instance: An XConnection instance.</li>
 *   <li>intent: A static Intent instance.</li>
 *   <li>gr: A static GameRun instance.</li>
 * </ul>
 * 
 * <p>Methods:</p>
 * <ul>
 *   <li>PetKing5(): Constructor that initializes SMSSender and PaymentsActivity.</li>
 *   <li>onDestroy(): Overrides the onDestroy method of CwaActivity and Activity.</li>
 *   <li>onCreate(Bundle savedInstanceState): Overrides the onCreate method of CwaActivity and Activity to set up the activity.</li>
 *   <li>setSmshah(): Handles different SMS payment types and starts the corresponding payment activity.</li>
 *   <li>onActivityResult(int requestCode, int resultCode, Intent data): Processes the result of payment activities and updates the game state accordingly.</li>
 * </ul>
 */
/**
 * The PetKing5 class extends CwaActivity and serves as the main activity for the PetKing5 application.
 * It handles the initialization of various components and manages the payment process through different SMS types.
 */
/**
 * PetKing5 is an activity class that extends CwaActivity and handles various
 * functionalities related to SMS payments and game state management.
 * It initializes necessary components and processes payment results.
 */
public class PetKing5 extends CwaActivity {
    AlertDialog ad;
    XConnection instance;
    public static Intent intent = null;
    public static GameRun gr = null;

    /**
     * Constructor that initializes SMSSender and PaymentsActivity.
     */
    public PetKing5() {
        SMSSender.pk = this;
        PaymentsActivity.init(this);
    }

    /**
     * Overrides the onDestroy method of CwaActivity and Activity.
     * Cleans up resources when the activity is destroyed.
     */
    @Override // javax.microedition.lcdui.CwaActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    /**
     * Overrides the onCreate method of CwaActivity and Activity to set up the activity.
     *
     * @param savedInstanceState The saved instance state bundle.
     */
    @Override // javax.microedition.lcdui.CwaActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        setFullWindow(true);
        super.onCreate(savedInstanceState);
        this.instance = new XConnection();
        setMIDlet(this.instance);
        setContentView();
        intent = getIntent();
    }

    /**
     * Handles different SMS payment types and starts the corresponding payment activity.
     * Depending on the SMS type, it creates an intent with payment information and starts the activity.
     */
    public void setSmshah() {
        switch (SMSSender.smsType) {
            case 1:
                Intent intent2 = new Intent(getApplicationContext(), (Class<?>) PaymentsActivity.class);
                PaymentInfo info = new PaymentInfo("Buy 5000 gold", "22", "01", "As the noble son of the head of the four major families, you can't be without money! Get 5000 gold immediately.", 20);
                intent2.putExtra(PaymentsActivity.EXTRA_KEY_PAYMENTINFO, info);
                startActivityForResult(intent2, 0);
                return;
            case 2:
            default:
                return;
            case 3:
                Intent intent1 = new Intent(getApplicationContext(), (Class<?>) PaymentsActivity.class);
                PaymentInfo info1 = new PaymentInfo("Buy 10 badges", "22", "02", "Buy this special item and immediately have 10 badges, which can be used to purchase double experience, pet skills, powerful pet capture balls, and other magical items.", 20);
                intent1.putExtra(PaymentsActivity.EXTRA_KEY_PAYMENTINFO, info1);
                startActivityForResult(intent1, 0);
                return;
            case 4:
                Intent intent22 = new Intent(getApplicationContext(), (Class<?>) PaymentsActivity.class);
                PaymentInfo info2 = new PaymentInfo("Pet level up 5", "22", "03", "Let all the pets you carry level up by 5 immediately (pets over level 70 cannot level up anymore)", 20);
                intent22.putExtra(PaymentsActivity.EXTRA_KEY_PAYMENTINFO, info2);
                startActivityForResult(intent22, 0);
                return;
            case 5:
                Intent intent3 = new Intent(getApplicationContext(), (Class<?>) PaymentsActivity.class);
                PaymentInfo info3 = new PaymentInfo("Buy strange beast", "22", "04", "Buy this special item to obtain a cute strange beast, which can double your movement speed and you won't encounter any enemies! Unlimited use, take action now, buy it now!", 20);
                intent3.putExtra(PaymentsActivity.EXTRA_KEY_PAYMENTINFO, info3);
                startActivityForResult(intent3, 0);
                return;
            case 6:
                Intent intent4 = new Intent(getApplicationContext(), (Class<?>) PaymentsActivity.class);
                PaymentInfo info4 = new PaymentInfo("Genuine verification", "22", "05", "The game trial is over, buy this item to unlock all subsequent game content and maps. You will also be given 5 badges for free (which can be used to buy powerful items)", 40);
                intent4.putExtra(PaymentsActivity.EXTRA_KEY_PAYMENTINFO, info4);
                startActivityForResult(intent4, 0);
                return;
            case 7:
                Intent intent5 = new Intent(getApplicationContext(), (Class<?>) PaymentsActivity.class);
                PaymentInfo info5 = new PaymentInfo("Upgrade revival", "22", "06", "Restore all the pets you carry, and at the same time immediately upgrade the pets you carry by 5 levels (pets over level 70 cannot level up anymore), making the next battle easier.", 20);
                intent5.putExtra(PaymentsActivity.EXTRA_KEY_PAYMENTINFO, info5);
                startActivityForResult(intent5, 0);
                return;
        }
    }

    /**
     * Processes the result of payment activities and updates the game state accordingly.
     *
     * @param requestCode The request code.
     * @param resultCode The result code.
     * @param data The intent data.
     */
    @Override // android.app.Activity
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0) {
            if (-1 == resultCode) {
                Log.e(new StringBuilder().append(resultCode).toString(), "================resultCode");
                Log.e("Successful", "Successful");
                SMSSender.i(SMSSender.gr).setSendSms(4);
                try {
                    if (SMSSender.smsType == 6) {
                        SMSSender.i(SMSSender.gr).sendSuccess();
                        SMSSender.i(SMSSender.gr).setSendSms(-1);
                        GameRun.run_state = -10;
                        GameRun.mc.temp_state = GameRun.run_state;
                        GameRun.mc.setSmsIsSetRun_state(true);
                        SMSSender.gr.map.setRegState(true);
                    } else {
                        SMSSender.i(SMSSender.gr).sendSuccess();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                data.getStringExtra(PaymentsActivity.EXTRA_KEY_NUMBER);
                data.getStringExtra(PaymentsActivity.EXTRA_KEY_ORDER_ID);
            } else {
                SMSSender.i(SMSSender.gr).setSendSms(-1);
                try {
                    if (SMSSender.smsType == 7) {
                        SMSSender.i(SMSSender.gr).sms_a = true;
                        SMSSender.gr.goGameOver();
                        System.out.println("ccccccccc");
                        GameRun.mc.setSmsIsSetRun_state(true);
                    } else if (SMSSender.smsType == 5) {
                        GameRun.run_state = -10;
                        GameRun.mc.temp_state = GameRun.run_state;
                        SMSSender.gr.map.setRegState(false);
                        GameRun.mc.setSmsIsSetRun_state(true);
                    } else if (SMSSender.smsType == 6) {
                        GameRun.run_state = -10;
                        GameRun.mc.setSmsIsSetRun_state(true);
                        SMSSender.gr.map.setRegState(false);
                    } else if (SMSSender.smsType == 1 && SMSSender.i(SMSSender.gr).getSmsSenderMenuState() != 0) {
                        GameRun.mc.setSmsIsSetRun_state(true);
                        GameRun.run_state = SMSSender.i(SMSSender.gr).getTstate();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
        SMSSender.i(SMSSender.gr);
        SMSSender.isWorking = false;
    }
}
