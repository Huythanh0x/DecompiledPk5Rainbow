package com.uc.paymentsdk.commons.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Html;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.uc.paymentsdk.model.IType;
import com.uc.paymentsdk.util.Utils;

public class CustomAdapter extends BaseAdapter {
   private static Drawable sIcon;
   private Context mContext;
   private IType[] mItems;

   public CustomAdapter(Context var1, IType[] var2) {
      super();
      this.mContext = var1;
      this.mItems = var2;
      if (sIcon == null) {
         sIcon = Utils.getDrawableFromFile("more.png");
      }

   }

   public int getCount() {
      int var1;
      if (this.mItems == null) {
         var1 = 0;
      } else {
         var1 = this.mItems.length;
      }

      return var1;
   }

   public IType getItem(int var1) {
      IType var2;
      if (this.mItems == null) {
         var2 = null;
      } else {
         var2 = this.mItems[var1];
      }

      return var2;
   }

   // $FF: synthetic method
   // $FF: bridge method
   public Object getItem(int var1) {
      return this.getItem(var1);
   }

   public long getItemId(int var1) {
      return (long)var1;
   }

   public View getView(int var1, View var2, ViewGroup var3) {
      CustomTextView var4 = new CustomTextView(this.mContext, var1);
      var4.setTextColor(-12303292);
      var4.setText(Html.fromHtml(this.mItems[var1].getDesc()));
      var4.setCompoundDrawablePadding(6);
      var4.setCompoundDrawablesWithIntrinsicBounds(this.mItems[var1].getIcon(), (Drawable)null, sIcon, (Drawable)null);
      return var4;
   }
}
