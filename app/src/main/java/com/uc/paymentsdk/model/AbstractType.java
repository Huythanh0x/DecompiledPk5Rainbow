package com.uc.paymentsdk.model;

import android.graphics.drawable.Drawable;
import com.uc.paymentsdk.util.Utils;
import java.lang.ref.SoftReference;

public abstract class AbstractType implements IType {
  private String mDesc;
  
  private SoftReference<Drawable> mIcon;
  
  private String mIconFileName;
  
  private String mId;
  
  private String mName;
  
  public AbstractType(String paramString1, String paramString2, String paramString3, String paramString4) {
    this.mId = paramString1;
    this.mName = paramString2;
    this.mDesc = paramString3;
    this.mIconFileName = paramString4;
    this.mIcon = new SoftReference<Drawable>(Utils.getDrawableFromFile(paramString4));
  }
  
  public String getDesc() {
    return this.mDesc;
  }
  
  public Drawable getIcon() {
    Drawable drawable2 = this.mIcon.get();
    Drawable drawable1 = drawable2;
    if (drawable2 == null) {
      drawable1 = Utils.getDrawableFromFile(this.mIconFileName);
      this.mIcon = new SoftReference<Drawable>(drawable1);
    } 
    return drawable1;
  }
  
  public String getId() {
    return this.mId;
  }
  
  public String getName() {
    return this.mName;
  }
}


/* Location:              /Users/thanh0x/DevTools0x/Rb2.0vip-dex2jar.jar!/com/uc/paymentsdk/model/AbstractType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */