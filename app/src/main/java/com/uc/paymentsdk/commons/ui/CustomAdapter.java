package com.uc.paymentsdk.commons.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Html;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.uc.paymentsdk.model.IType;
import com.uc.paymentsdk.util.Constants;
import com.uc.paymentsdk.util.Utils;

/* loaded from: classes.dex */
public class CustomAdapter extends BaseAdapter {
    private static Drawable sIcon;
    private Context mContext;
    private IType[] mItems;

    public CustomAdapter(Context paramContext, IType[] paramArrayOfIType) {
        this.mContext = paramContext;
        this.mItems = paramArrayOfIType;
        if (sIcon == null) {
            sIcon = Utils.getDrawableFromFile(Constants.RES_LIST_ITEM_MORE_ICON);
        }
    }

    @Override // android.widget.Adapter
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
        CustomTextView localCustomTextView = new CustomTextView(this.mContext, paramInt);
        localCustomTextView.setTextColor(-12303292);
        localCustomTextView.setText(Html.fromHtml(this.mItems[paramInt].getDesc()));
        localCustomTextView.setCompoundDrawablePadding(6);
        localCustomTextView.setCompoundDrawablesWithIntrinsicBounds(this.mItems[paramInt].getIcon(), (Drawable) null, sIcon, (Drawable) null);
        return localCustomTextView;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.mItems == null) {
            return 0;
        }
        return this.mItems.length;
    }

    @Override // android.widget.Adapter
    public IType getItem(int paramInt) {
        if (this.mItems == null) {
            return null;
        }
        return this.mItems[paramInt];
    }

    @Override // android.widget.Adapter
    public long getItemId(int paramInt) {
        return paramInt;
    }
}
