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
    private Context mContext;
    private IType[] mItems;
    private static Drawable sIcon;

    public CustomAdapter(Context paramContext, IType[] paramArrayOfIType) {
        this.mContext = paramContext;
        this.mItems = paramArrayOfIType;
        if(CustomAdapter.sIcon == null) {
            CustomAdapter.sIcon = Utils.getDrawableFromFile("more.png");
        }
    }

    @Override  // android.widget.Adapter
    public int getCount() {
        return this.mItems == null ? 0 : this.mItems.length;
    }

    public IType getItem(int paramInt) {
        return this.mItems == null ? null : this.mItems[paramInt];
    }

    @Override  // android.widget.Adapter
    public Object getItem(int v) {
        return this.getItem(v);
    }

    @Override  // android.widget.Adapter
    public long getItemId(int paramInt) {
        return (long)paramInt;
    }

    @Override  // android.widget.Adapter
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
        View localCustomTextView = new CustomTextView(this.mContext, paramInt);
        ((CustomTextView)localCustomTextView).setTextColor(-12303292);
        ((CustomTextView)localCustomTextView).setText(Html.fromHtml(this.mItems[paramInt].getDesc()));
        ((CustomTextView)localCustomTextView).setCompoundDrawablePadding(6);
        ((CustomTextView)localCustomTextView).setCompoundDrawablesWithIntrinsicBounds(this.mItems[paramInt].getIcon(), null, CustomAdapter.sIcon, null);
        return localCustomTextView;
    }
}

