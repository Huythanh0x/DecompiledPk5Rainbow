/*
 * Decompiled with CFR.
 * 
 * Could not load the following classes:
 *  android.graphics.drawable.Drawable
 *  com.uc.paymentsdk.model.IType
 *  com.uc.paymentsdk.util.Utils
 */
package com.uc.paymentsdk.model;

import android.graphics.drawable.Drawable;
import com.uc.paymentsdk.model.IType;
import com.uc.paymentsdk.util.Utils;
import java.lang.ref.SoftReference;

public abstract class AbstractType
implements IType {
    private String mDesc;
    private SoftReference<Drawable> mIcon;
    private String mIconFileName;
    private String mId;
    private String mName;

    public AbstractType(String string, String string2, String string3, String string4) {
        this.mId = string;
        this.mName = string2;
        this.mDesc = string3;
        this.mIconFileName = string4;
        this.mIcon = new SoftReference<Drawable>(Utils.getDrawableFromFile((String)string4));
    }

    public String getDesc() {
        return this.mDesc;
    }

    public Drawable getIcon() {
        Drawable drawable;
        Drawable drawable2 = drawable = this.mIcon.get();
        if (drawable == null) {
            drawable2 = Utils.getDrawableFromFile((String)this.mIconFileName);
            this.mIcon = new SoftReference<Drawable>(drawable2);
        }
        return drawable2;
    }

    public String getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }
}
