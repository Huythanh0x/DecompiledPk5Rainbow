package com.uc.paymentsdk.commons.ui.CustomAdapter;
import android.widget.BaseAdapter;
import android.content.Context;
import com.uc.paymentsdk.model.IType;
import java.lang.String;
import android.graphics.drawable.Drawable;
import com.uc.paymentsdk.util.Utils;
import java.lang.Object;
import android.view.View;
import android.view.ViewGroup;
import com.uc.paymentsdk.commons.ui.CustomTextView;
import android.text.Spanned;
import android.text.Html;
import java.lang.CharSequence;

public class CustomAdapter extends BaseAdapter	// class@000090 from classes.dex
{
    private Context mContext;
    private IType[] mItems;
    private static Drawable sIcon;

    public void CustomAdapter(Context paramContext,IType[] paramArrayOfIType){
       super();
       this.mContext = paramContext;
       this.mItems = paramArrayOfIType;
       if (CustomAdapter.sIcon == null) {
          CustomAdapter.sIcon = Utils.getDrawableFromFile("more.png");
       }
       return;
    }
    public int getCount(){
       int i = (this.mItems == null)? 0: this.mItems.length;
       return i;
    }
    public IType getItem(int paramInt){
       IType iType = (this.mItems == null)? null: this.mItems[paramInt];
       return iType;
    }
    public Object getItem(int p0){
       return this.getItem(p0);
    }
    public long getItemId(int paramInt){
       return (long)paramInt;
    }
    public View getView(int paramInt,View paramView,ViewGroup paramViewGroup){
       CustomTextView localCustomTextView = new CustomTextView(this.mContext, paramInt);
       localCustomTextView.setTextColor(-12303292);
       localCustomTextView.setText(Html.fromHtml(this.mItems[paramInt].getDesc()));
       localCustomTextView.setCompoundDrawablePadding(6);
       localCustomTextView.setCompoundDrawablesWithIntrinsicBounds(this.mItems[paramInt].getIcon(), null, CustomAdapter.sIcon, null);
       return localCustomTextView;
    }
}
