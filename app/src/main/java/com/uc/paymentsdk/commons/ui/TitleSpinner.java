/*
 * Decompiled with CFR.
 * 
 * Could not load the following classes:
 *  android.app.AlertDialog$Builder
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  android.widget.Button
 *  android.widget.ListAdapter
 *  android.widget.SpinnerAdapter
 *  com.uc.paymentsdk.commons.ui.TitleSpinner$DropDownAdapter
 */
package com.uc.paymentsdk.commons.ui;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.SpinnerAdapter;
import com.uc.paymentsdk.commons.ui.TitleSpinner;

public class TitleSpinner
extends Button
implements DialogInterface.OnClickListener {
    private SpinnerAdapter mAdapter;
    private int mNextSelectedPosition;
    private DialogInterface.OnClickListener mOnClickListener;
    private CharSequence mPrompt;

    public TitleSpinner(Context context) {
        super(context);
        this.init();
    }

    public TitleSpinner(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.init();
    }

    private void init() {
        this.mNextSelectedPosition = -1;
        this.setGravity(19);
        this.setBackgroundResource(17301510);
    }

    public int getSelectedItemPosition() {
        return this.mNextSelectedPosition;
    }

    public void onClick(DialogInterface dialogInterface, int n) {
        this.setSelection(n);
        dialogInterface.dismiss();
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(dialogInterface, n);
        }
    }

    public boolean performClick() {
        boolean bl;
        boolean bl2 = bl = super.performClick();
        if (!bl) {
            bl2 = true;
            AlertDialog.Builder builder = new AlertDialog.Builder(this.getContext());
            if (this.mPrompt != null) {
                builder.setTitle(this.mPrompt);
            }
            builder.setSingleChoiceItems((ListAdapter)new DropDownAdapter(this.mAdapter), this.getSelectedItemPosition(), (DialogInterface.OnClickListener)this).show();
        }
        return bl2;
    }

    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        this.mAdapter = spinnerAdapter;
    }

    public void setOnClickListener(DialogInterface.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void setPrompt(CharSequence charSequence) {
        this.mPrompt = charSequence;
    }

    public void setSelection(int n) {
        this.mNextSelectedPosition = n;
        this.setText(this.mAdapter.getItem(n).toString());
    }
}
