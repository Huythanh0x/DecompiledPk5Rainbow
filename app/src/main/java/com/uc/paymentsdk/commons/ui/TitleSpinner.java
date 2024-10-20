package com.uc.paymentsdk.commons.ui;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface;
import android.database.DataSetObserver;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.SpinnerAdapter;

public class TitleSpinner extends Button implements DialogInterface.OnClickListener {
    static class DropDownAdapter implements ListAdapter, SpinnerAdapter {
        private SpinnerAdapter mAdapter;
        private ListAdapter mListAdapter;

        public DropDownAdapter(SpinnerAdapter paramSpinnerAdapter) {
            this.mAdapter = paramSpinnerAdapter;
            if((paramSpinnerAdapter instanceof SpinnerAdapter)) {
                this.mListAdapter = (ListAdapter)paramSpinnerAdapter;
            }
        }

        @Override  // android.widget.ListAdapter
        public boolean areAllItemsEnabled() {
            return this.mListAdapter == null ? true : this.mListAdapter.areAllItemsEnabled();
        }

        @Override  // android.widget.Adapter
        public int getCount() {
            return this.mAdapter == null ? 0 : this.mAdapter.getCount();
        }

        @Override  // android.widget.SpinnerAdapter
        public View getDropDownView(int paramInt, View paramView, ViewGroup paramViewGroup) {
            return this.mAdapter == null ? null : this.mAdapter.getDropDownView(paramInt, paramView, paramViewGroup);
        }

        @Override  // android.widget.Adapter
        public Object getItem(int paramInt) {
            return this.mAdapter == null ? null : this.mAdapter.getItem(paramInt);
        }

        @Override  // android.widget.Adapter
        public long getItemId(int paramInt) {
            return this.mAdapter == null ? -1L : this.mAdapter.getItemId(paramInt);
        }

        @Override  // android.widget.Adapter
        public int getItemViewType(int paramInt) {
            return 0;
        }

        @Override  // android.widget.Adapter
        public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
            return this.getDropDownView(paramInt, paramView, paramViewGroup);
        }

        @Override  // android.widget.Adapter
        public int getViewTypeCount() {
            return 1;
        }

        @Override  // android.widget.Adapter
        public boolean hasStableIds() {
            return this.mAdapter != null && this.mAdapter.hasStableIds();
        }

        @Override  // android.widget.Adapter
        public boolean isEmpty() {
            return this.getCount() == 0;
        }

        @Override  // android.widget.ListAdapter
        public boolean isEnabled(int paramInt) {
            return this.mListAdapter == null ? true : this.mListAdapter.isEnabled(paramInt);
        }

        @Override  // android.widget.Adapter
        public void registerDataSetObserver(DataSetObserver paramDataSetObserver) {
            if(this.mAdapter != null) {
                this.mAdapter.registerDataSetObserver(paramDataSetObserver);
            }
        }

        @Override  // android.widget.Adapter
        public void unregisterDataSetObserver(DataSetObserver paramDataSetObserver) {
            if(this.mAdapter != null) {
                this.mAdapter.unregisterDataSetObserver(paramDataSetObserver);
            }
        }
    }

    private SpinnerAdapter mAdapter;
    private int mNextSelectedPosition;
    private DialogInterface.OnClickListener mOnClickListener;
    private CharSequence mPrompt;

    public TitleSpinner(Context paramContext) {
        super(paramContext);
        this.init();
    }

    public TitleSpinner(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
        this.init();
    }

    public int getSelectedItemPosition() {
        return this.mNextSelectedPosition;
    }

    private void init() {
        this.mNextSelectedPosition = -1;
        this.setGravity(19);
        this.setBackgroundResource(0x1080006);
    }

    @Override  // android.content.DialogInterface$OnClickListener
    public void onClick(DialogInterface paramDialogInterface, int paramInt) {
        this.setSelection(paramInt);
        paramDialogInterface.dismiss();
        if(this.mOnClickListener != null) {
            this.mOnClickListener.onClick(paramDialogInterface, paramInt);
        }
    }

    @Override  // android.view.View
    public boolean performClick() {
        boolean bool = super.performClick();
        if(!bool) {
            bool = true;
            AlertDialog.Builder localBuilder = new AlertDialog.Builder(this.getContext());
            if(this.mPrompt != null) {
                localBuilder.setTitle(this.mPrompt);
            }
            localBuilder.setSingleChoiceItems(new DropDownAdapter(this.mAdapter), this.getSelectedItemPosition(), this).show();
        }
        return bool;
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
        this.setText(this.mAdapter.getItem(paramInt).toString());
    }
}

