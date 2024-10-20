package com.uc.paymentsdk.commons.ui;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.database.DataSetObserver;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.SpinnerAdapter;

public class TitleSpinner extends Button implements DialogInterface.OnClickListener {
  private SpinnerAdapter mAdapter;
  
  private int mNextSelectedPosition;
  
  private DialogInterface.OnClickListener mOnClickListener;
  
  private CharSequence mPrompt;
  
  public TitleSpinner(Context paramContext) {
    super(paramContext);
    init();
  }
  
  public TitleSpinner(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  private void init() {
    this.mNextSelectedPosition = -1;
    setGravity(19);
    setBackgroundResource(17301510);
  }
  
  public int getSelectedItemPosition() {
    return this.mNextSelectedPosition;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt) {
    setSelection(paramInt);
    paramDialogInterface.dismiss();
    if (this.mOnClickListener != null)
      this.mOnClickListener.onClick(paramDialogInterface, paramInt); 
  }
  
  public boolean performClick() {
    boolean bool2 = super.performClick();
    boolean bool1 = bool2;
    if (!bool2) {
      bool1 = true;
      AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
      if (this.mPrompt != null)
        builder.setTitle(this.mPrompt); 
      builder.setSingleChoiceItems(new DropDownAdapter(this.mAdapter), getSelectedItemPosition(), this).show();
    } 
    return bool1;
  }
  
  public void setAdapter(SpinnerAdapter paramSpinnerAdapter) {
    this.mAdapter = paramSpinnerAdapter;
  }
  
  public void setOnClickListener(DialogInterface.OnClickListener paramOnClickListener) {
    this.mOnClickListener = paramOnClickListener;
  }
  
  public void setPrompt(CharSequence paramCharSequence) {
    this.mPrompt = paramCharSequence;
  }
  
  public void setSelection(int paramInt) {
    this.mNextSelectedPosition = paramInt;
    setText(this.mAdapter.getItem(paramInt).toString());
  }
  
  private static class DropDownAdapter implements ListAdapter, SpinnerAdapter {
    private SpinnerAdapter mAdapter;
    
    private ListAdapter mListAdapter;
    
    public DropDownAdapter(SpinnerAdapter param1SpinnerAdapter) {
      this.mAdapter = param1SpinnerAdapter;
      if (param1SpinnerAdapter instanceof SpinnerAdapter)
        this.mListAdapter = (ListAdapter)param1SpinnerAdapter; 
    }
    
    public boolean areAllItemsEnabled() {
      ListAdapter listAdapter = this.mListAdapter;
      return (listAdapter != null) ? listAdapter.areAllItemsEnabled() : true;
    }
    
    public int getCount() {
      return (this.mAdapter == null) ? 0 : this.mAdapter.getCount();
    }
    
    public View getDropDownView(int param1Int, View param1View, ViewGroup param1ViewGroup) {
      return (this.mAdapter == null) ? null : this.mAdapter.getDropDownView(param1Int, param1View, param1ViewGroup);
    }
    
    public Object getItem(int param1Int) {
      return (this.mAdapter == null) ? null : this.mAdapter.getItem(param1Int);
    }
    
    public long getItemId(int param1Int) {
      return (this.mAdapter == null) ? -1L : this.mAdapter.getItemId(param1Int);
    }
    
    public int getItemViewType(int param1Int) {
      return 0;
    }
    
    public View getView(int param1Int, View param1View, ViewGroup param1ViewGroup) {
      return getDropDownView(param1Int, param1View, param1ViewGroup);
    }
    
    public int getViewTypeCount() {
      return 1;
    }
    
    public boolean hasStableIds() {
      return (this.mAdapter != null && this.mAdapter.hasStableIds());
    }
    
    public boolean isEmpty() {
      return (getCount() == 0);
    }
    
    public boolean isEnabled(int param1Int) {
      ListAdapter listAdapter = this.mListAdapter;
      return (listAdapter != null) ? listAdapter.isEnabled(param1Int) : true;
    }
    
    public void registerDataSetObserver(DataSetObserver param1DataSetObserver) {
      if (this.mAdapter != null)
        this.mAdapter.registerDataSetObserver(param1DataSetObserver); 
    }
    
    public void unregisterDataSetObserver(DataSetObserver param1DataSetObserver) {
      if (this.mAdapter != null)
        this.mAdapter.unregisterDataSetObserver(param1DataSetObserver); 
    }
  }
}


/* Location:              /Users/thanh0x/DevTools0x/Rb2.0vip-dex2jar.jar!/com/uc/paymentsdk/commons/ui/TitleSpinner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */