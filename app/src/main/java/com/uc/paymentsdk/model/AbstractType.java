package com.uc.paymentsdk.model;

import android.graphics.drawable.Drawable;
import com.uc.paymentsdk.util.Utils;
import java.lang.ref.SoftReference;

public abstract class AbstractType implements IType {
   private String mDesc;
   private SoftReference mIcon;
   private String mIconFileName;
   private String mId;
   private String mName;

   public AbstractType(String var1, String var2, String var3, String var4) {
      super();
      this.mId = var1;
      this.mName = var2;
      this.mDesc = var3;
      this.mIconFileName = var4;
      this.mIcon = new SoftReference(Utils.getDrawableFromFile(var4));
   }

   public String getDesc() {
      return this.mDesc;
   }

   public Drawable getIcon() {
      Drawable var2 = (Drawable)this.mIcon.get();
      Drawable var1 = var2;
      if (var2 == null) {
         var1 = Utils.getDrawableFromFile(this.mIconFileName);
         this.mIcon = new SoftReference(var1);
      }

      return var1;
   }

   public String getId() {
      return this.mId;
   }

   public String getName() {
      return this.mName;
   }
}
