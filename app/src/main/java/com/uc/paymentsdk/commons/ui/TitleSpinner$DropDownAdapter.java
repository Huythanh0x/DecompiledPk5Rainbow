package com.uc.paymentsdk.commons.ui;

import android.database.DataSetObserver;
import android.view.ViewGroup;
import android.view.View;
import android.widget.SpinnerAdapter;
import android.widget.ListAdapter;

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
