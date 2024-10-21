package com.uc.paymentsdk.commons.ui;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.SpinnerAdapter;

public class TitleSpinner extends Button implements DialogInterface.OnClickListener {
   private SpinnerAdapter mAdapter;
   private int mNextSelectedPosition;
   private DialogInterface.OnClickListener mOnClickListener;
   private CharSequence mPrompt;

   public TitleSpinner(Context var1) {
      super(var1);
      this.init();
   }

   public TitleSpinner(Context var1, AttributeSet var2) {
      super(var1, var2);
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

   public void onClick(DialogInterface var1, int var2) {
      this.setSelection(var2);
      var1.dismiss();
      if (this.mOnClickListener != null) {
         this.mOnClickListener.onClick(var1, var2);
      }

   }

   public boolean performClick() {
      boolean var2 = super.performClick();
      boolean var1 = var2;
      if (!var2) {
         var1 = true;
         AlertDialog.Builder var3 = new AlertDialog.Builder(this.getContext());
         if (this.mPrompt != null) {
            var3.setTitle(this.mPrompt);
         }

         var3.setSingleChoiceItems(new TitleSpinner$DropDownAdapter(this.mAdapter), this.getSelectedItemPosition(), this).show();
      }

      return var1;
   }

   public void setAdapter(SpinnerAdapter var1) {
      this.mAdapter = var1;
   }

   public void setOnClickListener(DialogInterface.OnClickListener var1) {
      this.mOnClickListener = var1;
   }

   public void setPrompt(CharSequence var1) {
      this.mPrompt = var1;
   }

   public void setSelection(int var1) {
      this.mNextSelectedPosition = var1;
      this.setText(this.mAdapter.getItem(var1).toString());
   }
}
