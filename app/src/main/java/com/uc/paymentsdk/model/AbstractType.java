package com.uc.paymentsdk.model;

import com.uc.paymentsdk.util.Utils;
import android.graphics.drawable.Drawable;
import java.lang.ref.SoftReference;

public abstract class AbstractType implements IType
{
    private String mDesc;
    private SoftReference<Drawable> mIcon;
    private String mIconFileName;
    private String mId;
    private String mName;
    
    public AbstractType(final String mId, final String mName, final String mDesc, final String mIconFileName) {
        super();
        this.mId = mId;
        this.mName = mName;
        this.mDesc = mDesc;
        this.mIconFileName = mIconFileName;
        this.mIcon = new SoftReference<Drawable>(Utils.getDrawableFromFile(mIconFileName));
    }
    
    @Override
    public String getDesc() {
        return this.mDesc;
    }
    
    @Override
    public Drawable getIcon() {
        Drawable drawableFromFile;
        if ((drawableFromFile = this.mIcon.get()) == null) {
            drawableFromFile = Utils.getDrawableFromFile(this.mIconFileName);
            this.mIcon = new SoftReference<Drawable>(drawableFromFile);
        }
        return drawableFromFile;
    }
    
    @Override
    public String getId() {
        return this.mId;
    }
    
    @Override
    public String getName() {
        return this.mName;
    }
}
