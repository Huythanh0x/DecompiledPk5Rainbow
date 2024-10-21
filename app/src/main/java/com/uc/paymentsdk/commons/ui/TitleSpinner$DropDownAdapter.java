package com.uc.paymentsdk.commons.ui;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.SpinnerAdapter;

class TitleSpinner$DropDownAdapter implements ListAdapter, SpinnerAdapter {
   private SpinnerAdapter mAdapter;
   private ListAdapter mListAdapter;

   public TitleSpinner$DropDownAdapter(SpinnerAdapter var1) {
      super();
      this.mAdapter = var1;
      if (var1 instanceof SpinnerAdapter) {
         this.mListAdapter = (ListAdapter)var1;
      }

   }

   public boolean areAllItemsEnabled() {
      ListAdapter var2 = this.mListAdapter;
      boolean var1;
      if (var2 != null) {
         var1 = var2.areAllItemsEnabled();
      } else {
         var1 = true;
      }

      return var1;
   }

   public int getCount() {
      int var1;
      if (this.mAdapter == null) {
         var1 = 0;
      } else {
         var1 = this.mAdapter.getCount();
      }

      return var1;
   }

   public View getDropDownView(int var1, View var2, ViewGroup var3) {
      if (this.mAdapter == null) {
         var2 = null;
      } else {
         var2 = this.mAdapter.getDropDownView(var1, var2, var3);
      }

      return var2;
   }

   public Object getItem(int var1) {
      Object var2;
      if (this.mAdapter == null) {
         var2 = null;
      } else {
         var2 = this.mAdapter.getItem(var1);
      }

      return var2;
   }

   public long getItemId(int var1) {
      long var2;
      if (this.mAdapter == null) {
         var2 = -1L;
      } else {
         var2 = this.mAdapter.getItemId(var1);
      }

      return var2;
   }

   public int getItemViewType(int var1) {
      return 0;
   }

   public View getView(int var1, View var2, ViewGroup var3) {
      return this.getDropDownView(var1, var2, var3);
   }

   public int getViewTypeCount() {
      return 1;
   }

   public boolean hasStableIds() {
      boolean var1;
      if (this.mAdapter != null && this.mAdapter.hasStableIds()) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public boolean isEmpty() {
      boolean var1;
      if (this.getCount() == 0) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public boolean isEnabled(int var1) {
      ListAdapter var3 = this.mListAdapter;
      boolean var2;
      if (var3 != null) {
         var2 = var3.isEnabled(var1);
      } else {
         var2 = true;
      }

      return var2;
   }

   public void registerDataSetObserver(DataSetObserver var1) {
      if (this.mAdapter != null) {
         this.mAdapter.registerDataSetObserver(var1);
      }

   }

   public void unregisterDataSetObserver(DataSetObserver var1) {
      if (this.mAdapter != null) {
         this.mAdapter.unregisterDataSetObserver(var1);
      }

   }
}
