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
  
  public CustomAdapter(Context paramContext, IType[] paramArrayOfIType) {
    this.mContext = paramContext;
    this.mItems = paramArrayOfIType;
    if (sIcon == null)
      sIcon = Utils.getDrawableFromFile("more.png"); 
  }
  
  public int getCount() {
    return (this.mItems == null) ? 0 : this.mItems.length;
  }
  
  public IType getItem(int paramInt) {
    return (this.mItems == null) ? null : this.mItems[paramInt];
  }
  
  public long getItemId(int paramInt) {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
    CustomTextView customTextView = new CustomTextView(this.mContext, paramInt);
    customTextView.setTextColor(-12303292);
    customTextView.setText((CharSequence)Html.fromHtml(this.mItems[paramInt].getDesc()));
    customTextView.setCompoundDrawablePadding(6);
    customTextView.setCompoundDrawablesWithIntrinsicBounds(this.mItems[paramInt].getIcon(), null, sIcon, null);
    return (View)customTextView;
  }
}


/* Location:              /Users/thanh0x/DevTools0x/Rb2.0vip-dex2jar.jar!/com/uc/paymentsdk/commons/ui/CustomAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */