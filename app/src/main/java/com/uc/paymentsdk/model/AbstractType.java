package com.uc.paymentsdk.model.AbstractType;
import com.uc.paymentsdk.model.IType;
import java.lang.String;
import java.lang.Object;
import java.lang.ref.SoftReference;
import android.graphics.drawable.Drawable;
import com.uc.paymentsdk.util.Utils;

public abstract class AbstractType implements IType	// class@000094 from classes.dex
{
    private String mDesc;
    private SoftReference mIcon;
    private String mIconFileName;
    private String mId;
    private String mName;

    public void AbstractType(String typeId,String typeName,String typeDesc,String typeIconFileName){
       super();
       this.mId = typeId;
       this.mName = typeName;
       this.mDesc = typeDesc;
       this.mIconFileName = typeIconFileName;
       this.mIcon = new SoftReference(Utils.getDrawableFromFile(typeIconFileName));
    }
    public String getDesc(){
       return this.mDesc;
    }
    public Drawable getIcon(){
       Drawable uDrawable;
       if ((uDrawable = this.mIcon.get()) == null) {
          uDrawable = Utils.getDrawableFromFile(this.mIconFileName);
          this.mIcon = new SoftReference(localDrawable);
       }
       return localDrawable;
    }
    public String getId(){
       return this.mId;
    }
    public String getName(){
       return this.mName;
    }
}
