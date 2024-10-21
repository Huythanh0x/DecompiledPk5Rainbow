package com.uc.paymentsdk.commons.ui.TitleSpinner;
import android.content.DialogInterface$OnClickListener;
import android.widget.Button;
import android.content.Context;
import android.util.AttributeSet;
import android.content.DialogInterface;
import android.app.AlertDialog$Builder;
import java.lang.CharSequence;
import com.uc.paymentsdk.commons.ui.TitleSpinner$DropDownAdapter;
import android.widget.SpinnerAdapter;
import android.widget.ListAdapter;
import android.app.AlertDialog;
import java.lang.Object;
import java.lang.String;

public class TitleSpinner extends Button implements DialogInterface$OnClickListener	// class@000093 from classes.dex
{
    private SpinnerAdapter mAdapter;
    private int mNextSelectedPosition;
    private DialogInterface$OnClickListener mOnClickListener;
    private CharSequence mPrompt;

    public void TitleSpinner(Context paramContext){
       super(paramContext);
       this.init();
    }
    public void TitleSpinner(Context paramContext,AttributeSet paramAttributeSet){
       super(paramContext, paramAttributeSet);
       this.init();
    }
    private void init(){
       this.mNextSelectedPosition = -1;
       this.setGravity(19);
       this.setBackgroundResource(0x1080006);
    }
    public int getSelectedItemPosition(){
       return this.mNextSelectedPosition;
    }
    public void onClick(DialogInterface paramDialogInterface,int paramInt){
       this.setSelection(paramInt);
       paramDialogInterface.dismiss();
       if (this.mOnClickListener != null) {
          this.mOnClickListener.onClick(paramDialogInterface, paramInt);
       }
       return;
    }
    public boolean performClick(){
       boolean bool;
       if (!(bool = super.performClick())) {
          bool = true;
          AlertDialog$Builder localBuilder = new AlertDialog$Builder(this.getContext());
          if (this.mPrompt != null) {
             localBuilder.setTitle(this.mPrompt);
          }
          localBuilder.setSingleChoiceItems(new TitleSpinner$DropDownAdapter(this.mAdapter), this.getSelectedItemPosition(), this).show();
       }
       return bool;
    }
    public void setAdapter(SpinnerAdapter paramSpinnerAdapter){
       this.mAdapter = paramSpinnerAdapter;
    }
    public void setOnClickListener(DialogInterface$OnClickListener paramOnClickListener){
       this.mOnClickListener = paramOnClickListener;
    }
    public void setPrompt(CharSequence paramCharSequence){
       this.mPrompt = paramCharSequence;
    }
    public void setSelection(int paramInt){
       this.mNextSelectedPosition = paramInt;
       this.setText(this.mAdapter.getItem(paramInt).toString());
    }
}
