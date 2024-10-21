package com.uc.paymentsdk.commons.ui;

import android.text.Html;
import android.view.ViewGroup;
import android.view.View;
import com.uc.paymentsdk.util.Utils;
import com.uc.paymentsdk.model.IType;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.BaseAdapter;

public class CustomAdapter extends BaseAdapter
{
    private static Drawable sIcon;
    private Context mContext;
    private IType[] mItems;
    
    public CustomAdapter(final Context mContext, final IType[] mItems) {
        super();
        this.mContext = mContext;
        this.mItems = mItems;
        if (CustomAdapter.sIcon == null) {
            CustomAdapter.sIcon = Utils.getDrawableFromFile("more.png");
        }
    }
    
    public int getCount() {
        int length;
        if (this.mItems == null) {
            length = 0;
        }
        else {
            length = this.mItems.length;
        }
        return length;
    }
    
    public IType getItem(final int n) {
        IType type;
        if (this.mItems == null) {
            type = null;
        }
        else {
            type = this.mItems[n];
        }
        return type;
    }
    
    public /* bridge */ Object getItem(final int n) {
        return this.getItem(n);
    }
    
    public long getItemId(final int n) {
        return n;
    }
    
    public View getView(final int n, final View view, final ViewGroup viewGroup) {
        final CustomTextView customTextView = new CustomTextView(this.mContext, n);
        customTextView.setTextColor(-12303292);
        customTextView.setText((CharSequence)Html.fromHtml(this.mItems[n].getDesc()));
        customTextView.setCompoundDrawablePadding(6);
        customTextView.setCompoundDrawablesWithIntrinsicBounds(this.mItems[n].getIcon(), (Drawable)null, CustomAdapter.sIcon, (Drawable)null);
        return (View)customTextView;
    }
}
