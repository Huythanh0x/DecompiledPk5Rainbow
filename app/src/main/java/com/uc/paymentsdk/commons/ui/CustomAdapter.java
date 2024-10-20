/*
 * Decompiled with CFR.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.text.Html
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.BaseAdapter
 *  com.uc.paymentsdk.commons.ui.CustomTextView
 *  com.uc.paymentsdk.model.IType
 *  com.uc.paymentsdk.util.Utils
 */
package com.uc.paymentsdk.commons.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Html;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.uc.paymentsdk.commons.ui.CustomTextView;
import com.uc.paymentsdk.model.IType;
import com.uc.paymentsdk.util.Utils;

public class CustomAdapter
extends BaseAdapter {
    private static Drawable sIcon;
    private Context mContext;
    private IType[] mItems;

    public CustomAdapter(Context context, IType[] iTypeArray) {
        this.mContext = context;
        this.mItems = iTypeArray;
        if (sIcon == null) {
            sIcon = Utils.getDrawableFromFile((String)"more.png");
        }
    }

    /*
     * Enabled force condition propagation
     */
    public int getCount() {
        if (this.mItems != null) return this.mItems.length;
        return 0;
    }

    /*
     * Enabled force condition propagation
     */
    public IType getItem(int n) {
        if (this.mItems != null) return this.mItems[n];
        return null;
    }

    public long getItemId(int n) {
        return n;
    }

    public View getView(int n, View view, ViewGroup viewGroup) {
        view = new CustomTextView(this.mContext, n);
        view.setTextColor(-12303292);
        view.setText((CharSequence)Html.fromHtml((String)this.mItems[n].getDesc()));
        view.setCompoundDrawablePadding(6);
        view.setCompoundDrawablesWithIntrinsicBounds(this.mItems[n].getIcon(), null, sIcon, null);
        return view;
    }
}
