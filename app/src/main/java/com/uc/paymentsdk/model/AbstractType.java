package com.uc.paymentsdk.model;

import android.graphics.drawable.Drawable;
import com.uc.paymentsdk.util.Utils;
import java.lang.ref.SoftReference;

/* loaded from: classes.dex */
public abstract class AbstractType implements IType {
    private String mDesc;
    private SoftReference<Drawable> mIcon;
    private String mIconFileName;
    private String mId;
    private String mName;

    public AbstractType(String typeId, String typeName, String typeDesc, String typeIconFileName) {
        this.mId = typeId;
        this.mName = typeName;
        this.mDesc = typeDesc;
        this.mIconFileName = typeIconFileName;
        this.mIcon = new SoftReference<>(Utils.getDrawableFromFile(typeIconFileName));
    }

    @Override // com.uc.paymentsdk.model.IType
    public String getId() {
        return this.mId;
    }

    @Override // com.uc.paymentsdk.model.IType
    public String getDesc() {
        return this.mDesc;
    }

    @Override // com.uc.paymentsdk.model.IType
    public Drawable getIcon() {
        Drawable localDrawable = this.mIcon.get();
        if (localDrawable == null) {
            Drawable localDrawable2 = Utils.getDrawableFromFile(this.mIconFileName);
            this.mIcon = new SoftReference<>(localDrawable2);
            return localDrawable2;
        }
        return localDrawable;
    }

    @Override // com.uc.paymentsdk.model.IType
    public String getName() {
        return this.mName;
    }
}
