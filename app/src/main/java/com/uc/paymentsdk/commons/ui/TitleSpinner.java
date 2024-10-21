package com.uc.paymentsdk.commons.ui;

import android.database.DataSetObserver;
import android.view.ViewGroup;
import android.view.View;
import android.widget.ListAdapter;
import android.app.AlertDialog$Builder;
import android.content.DialogInterface;
import android.util.AttributeSet;
import android.content.Context;
import android.widget.SpinnerAdapter;
import android.content.DialogInterface$OnClickListener;
import android.widget.Button;

public class TitleSpinner extends Button implements DialogInterface$OnClickListener
{
    private SpinnerAdapter mAdapter;
    private int mNextSelectedPosition;
    private DialogInterface$OnClickListener mOnClickListener;
    private CharSequence mPrompt;
    
    public TitleSpinner(final Context context) {
        super(context);
        this.init();
    }
    
    public TitleSpinner(final Context context, final AttributeSet set) {
        super(context, set);
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
    
    public void onClick(final DialogInterface dialogInterface, final int selection) {
        this.setSelection(selection);
        dialogInterface.dismiss();
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(dialogInterface, selection);
        }
    }
    
    public boolean performClick() {
        boolean performClick;
        if (!(performClick = super.performClick())) {
            performClick = true;
            final AlertDialog$Builder alertDialog$Builder = new AlertDialog$Builder(this.getContext());
            if (this.mPrompt != null) {
                alertDialog$Builder.setTitle(this.mPrompt);
            }
            alertDialog$Builder.setSingleChoiceItems((ListAdapter)new DropDownAdapter(this.mAdapter), this.getSelectedItemPosition(), (DialogInterface$OnClickListener)this).show();
        }
        return performClick;
    }
    
    public void setAdapter(final SpinnerAdapter mAdapter) {
        this.mAdapter = mAdapter;
    }
    
    public void setOnClickListener(final DialogInterface$OnClickListener mOnClickListener) {
        this.mOnClickListener = mOnClickListener;
    }
    
    public void setPrompt(final CharSequence mPrompt) {
        this.mPrompt = mPrompt;
    }
    
    public void setSelection(final int mNextSelectedPosition) {
        this.mNextSelectedPosition = mNextSelectedPosition;
        this.setText((CharSequence)this.mAdapter.getItem(mNextSelectedPosition).toString());
    }
    
    private static class DropDownAdapter implements ListAdapter, SpinnerAdapter
    {
        private SpinnerAdapter mAdapter;
        private ListAdapter mListAdapter;
        
        public DropDownAdapter(final SpinnerAdapter mAdapter) {
            super();
            this.mAdapter = mAdapter;
            if (mAdapter instanceof SpinnerAdapter) {
                this.mListAdapter = (ListAdapter)mAdapter;
            }
        }
        
        public boolean areAllItemsEnabled() {
            final ListAdapter mListAdapter = this.mListAdapter;
            return mListAdapter == null || mListAdapter.areAllItemsEnabled();
        }
        
        public int getCount() {
            int count;
            if (this.mAdapter == null) {
                count = 0;
            }
            else {
                count = this.mAdapter.getCount();
            }
            return count;
        }
        
        public View getDropDownView(final int n, View dropDownView, final ViewGroup viewGroup) {
            if (this.mAdapter == null) {
                dropDownView = null;
            }
            else {
                dropDownView = this.mAdapter.getDropDownView(n, dropDownView, viewGroup);
            }
            return dropDownView;
        }
        
        public Object getItem(final int n) {
            Object item;
            if (this.mAdapter == null) {
                item = null;
            }
            else {
                item = this.mAdapter.getItem(n);
            }
            return item;
        }
        
        public long getItemId(final int n) {
            long itemId;
            if (this.mAdapter == null) {
                itemId = -1L;
            }
            else {
                itemId = this.mAdapter.getItemId(n);
            }
            return itemId;
        }
        
        public int getItemViewType(final int n) {
            return 0;
        }
        
        public View getView(final int n, final View view, final ViewGroup viewGroup) {
            return this.getDropDownView(n, view, viewGroup);
        }
        
        public int getViewTypeCount() {
            return 1;
        }
        
        public boolean hasStableIds() {
            return this.mAdapter != null && this.mAdapter.hasStableIds();
        }
        
        public boolean isEmpty() {
            return this.getCount() == 0;
        }
        
        public boolean isEnabled(final int n) {
            final ListAdapter mListAdapter = this.mListAdapter;
            return mListAdapter == null || mListAdapter.isEnabled(n);
        }
        
        public void registerDataSetObserver(final DataSetObserver dataSetObserver) {
            if (this.mAdapter != null) {
                this.mAdapter.registerDataSetObserver(dataSetObserver);
            }
        }
        
        public void unregisterDataSetObserver(final DataSetObserver dataSetObserver) {
            if (this.mAdapter != null) {
                this.mAdapter.unregisterDataSetObserver(dataSetObserver);
            }
        }
    }
}
