/*
 * Decompiled with CFR.
 * 
 * Could not load the following classes:
 *  android.database.DataSetObserver
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.ListAdapter
 *  android.widget.SpinnerAdapter
 */
package com.uc.paymentsdk.commons.ui;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.SpinnerAdapter;

private static class TitleSpinner.DropDownAdapter
implements ListAdapter,
SpinnerAdapter {
    private SpinnerAdapter mAdapter;
    private ListAdapter mListAdapter;

    public TitleSpinner.DropDownAdapter(SpinnerAdapter spinnerAdapter) {
        this.mAdapter = spinnerAdapter;
        if (spinnerAdapter instanceof SpinnerAdapter) {
            this.mListAdapter = (ListAdapter)spinnerAdapter;
        }
    }

    /*
     * Enabled force condition propagation
     */
    public boolean areAllItemsEnabled() {
        ListAdapter listAdapter = this.mListAdapter;
        if (listAdapter == null) return true;
        return listAdapter.areAllItemsEnabled();
    }

    /*
     * Enabled force condition propagation
     */
    public int getCount() {
        if (this.mAdapter != null) return this.mAdapter.getCount();
        return 0;
    }

    /*
     * Enabled force condition propagation
     */
    public View getDropDownView(int n, View view, ViewGroup viewGroup) {
        if (this.mAdapter != null) return this.mAdapter.getDropDownView(n, view, viewGroup);
        return null;
    }

    /*
     * Enabled force condition propagation
     */
    public Object getItem(int n) {
        if (this.mAdapter != null) return this.mAdapter.getItem(n);
        return null;
    }

    /*
     * Enabled force condition propagation
     */
    public long getItemId(int n) {
        if (this.mAdapter != null) return this.mAdapter.getItemId(n);
        return -1L;
    }

    public int getItemViewType(int n) {
        return 0;
    }

    public View getView(int n, View view, ViewGroup viewGroup) {
        return this.getDropDownView(n, view, viewGroup);
    }

    public int getViewTypeCount() {
        return 1;
    }

    /*
     * Enabled force condition propagation
     */
    public boolean hasStableIds() {
        if (this.mAdapter == null) return false;
        if (!this.mAdapter.hasStableIds()) return false;
        return true;
    }

    /*
     * Enabled force condition propagation
     */
    public boolean isEmpty() {
        if (this.getCount() != 0) return false;
        return true;
    }

    /*
     * Enabled force condition propagation
     */
    public boolean isEnabled(int n) {
        ListAdapter listAdapter = this.mListAdapter;
        if (listAdapter == null) return true;
        return listAdapter.isEnabled(n);
    }

    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        if (this.mAdapter != null) {
            this.mAdapter.registerDataSetObserver(dataSetObserver);
        }
    }

    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        if (this.mAdapter != null) {
            this.mAdapter.unregisterDataSetObserver(dataSetObserver);
        }
    }
}
