package com.uc.paymentsdk.commons.ui.TitleSpinner$DropDownAdapter;
import android.widget.ListAdapter;
import android.widget.SpinnerAdapter;
import java.lang.Object;
import android.view.View;
import android.view.ViewGroup;
import android.database.DataSetObserver;

class TitleSpinner$DropDownAdapter implements ListAdapter, SpinnerAdapter	// class@000092 from classes.dex
{
    private SpinnerAdapter mAdapter;
    private ListAdapter mListAdapter;

    public void TitleSpinner$DropDownAdapter(SpinnerAdapter paramSpinnerAdapter){
       super();
       this.mAdapter = paramSpinnerAdapter;
       if (paramSpinnerAdapter instanceof SpinnerAdapter) {
          this.mListAdapter = paramSpinnerAdapter;
       }
       return;
    }
    public boolean areAllItemsEnabled(){
       ListAdapter localListAdapter;
       boolean b = ((localListAdapter = this.mListAdapter) != null)? localListAdapter.areAllItemsEnabled(): true;
       return b;
    }
    public int getCount(){
       int i = (this.mAdapter == null)? 0: this.mAdapter.getCount();
       return i;
    }
    public View getDropDownView(int paramInt,View paramView,ViewGroup paramViewGroup){
       View view = (this.mAdapter == null)? null: this.mAdapter.getDropDownView(paramInt, paramView, paramViewGroup);
       return view;
    }
    public Object getItem(int paramInt){
       Object obj = (this.mAdapter == null)? null: this.mAdapter.getItem(paramInt);
       return obj;
    }
    public long getItemId(int paramInt){
       long l = (this.mAdapter == null)? -1: this.mAdapter.getItemId(paramInt);
       return l;
    }
    public int getItemViewType(int paramInt){
       return 0;
    }
    public View getView(int paramInt,View paramView,ViewGroup paramViewGroup){
       return this.getDropDownView(paramInt, paramView, paramViewGroup);
    }
    public int getViewTypeCount(){
       return 1;
    }
    public boolean hasStableIds(){
       boolean b = (this.mAdapter != null && this.mAdapter.hasStableIds())? true: false;
       return b;
    }
    public boolean isEmpty(){
       boolean b = (!this.getCount())? true: false;
       return b;
    }
    public boolean isEnabled(int paramInt){
       ListAdapter localListAdapter;
       boolean b = ((localListAdapter = this.mListAdapter) != null)? localListAdapter.isEnabled(paramInt): true;
       return b;
    }
    public void registerDataSetObserver(DataSetObserver paramDataSetObserver){
       if (this.mAdapter != null) {
          this.mAdapter.registerDataSetObserver(paramDataSetObserver);
       }
       return;
    }
    public void unregisterDataSetObserver(DataSetObserver paramDataSetObserver){
       if (this.mAdapter != null) {
          this.mAdapter.unregisterDataSetObserver(paramDataSetObserver);
       }
       return;
    }
}
