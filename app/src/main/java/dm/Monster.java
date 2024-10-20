package dm;

import main.GameRun;
import main.Key_H;

public class Monster implements Key_H {
  public byte effect;
  
  public byte effect_time;
  
  public byte[] monster;
  
  public short[] monsterPro;
  
  public Monster() {}
  
  public Monster(GameRun paramGameRun, int paramInt1, int paramInt2, int paramInt3) {
    this.monsterPro = new short[8];
    this.monster = new byte[18];
    this.monster[0] = (byte)paramInt1;
    this.monster[2] = (byte)paramInt2;
    byte[] arrayOfByte2 = paramGameRun.monster_pro[paramInt1];
    this.monster[3] = arrayOfByte2[6];
    this.monster[4] = arrayOfByte2[5];
    this.monster[5] = arrayOfByte2[12];
    this.monster[8] = 25;
    this.monster[9] = -1;
    this.monster[10] = -1;
    this.monster[11] = -1;
    this.monster[12] = -1;
    this.monster[13] = -1;
    this.monster[14] = -1;
    this.monster[15] = -1;
    if (paramInt3 == -1) {
      this.monster[16] = (byte)(this.monster[3] * 2 + 4);
      this.monster[17] = 2;
    } else if (paramInt3 == 0) {
      byte[] arrayOfByte = this.monster;
      paramInt3 = this.monster[3];
      Ms.i();
      arrayOfByte[16] = (byte)(paramInt3 * 2 + 3 + Ms.getRandom(2));
      arrayOfByte = this.monster;
      Ms.i();
      arrayOfByte[17] = (byte)Ms.getRandom(3);
    } else if (paramInt3 == 1) {
      byte[] arrayOfByte = this.monster;
      byte b = this.monster[3];
      Ms.i();
      if (Ms.getRandom(100) < 70) {
        paramInt3 = 1;
      } else {
        paramInt3 = 0;
      } 
      arrayOfByte[16] = (byte)(b * 2 + 3 + paramInt3);
      arrayOfByte = this.monster;
      Ms.i();
      if (Ms.getRandom(100) < 70) {
        paramInt3 = 2;
      } else {
        Ms.i();
        paramInt3 = Ms.getRandom(2);
      } 
      arrayOfByte[17] = (byte)paramInt3;
    } 
    byte[] arrayOfByte3 = this.monster;
    if (this.monster[4] > 3) {
      paramInt3 = 120;
    } else {
      paramInt3 = 100;
    } 
    arrayOfByte3[6] = (byte)paramInt3;
    this.monsterPro[2] = (short)(arrayOfByte2[0] + arrayOfByte2[7] * paramInt2 / 10);
    this.monsterPro[3] = (short)(arrayOfByte2[1] + arrayOfByte2[8] * paramInt2 / 10);
    this.monsterPro[1] = this.monsterPro[3];
    this.monsterPro[0] = this.monsterPro[2];
    this.monsterPro[4] = 0;
    setProAFD(arrayOfByte2);
    if (this.monster[3] != -1)
      paramGameRun.getMagic(this); 
    if (paramGameRun.monInfoList[paramInt1] == 0) {
      paramGameRun.monInfoList[paramInt1] = 1;
      arrayOfByte2 = paramGameRun.monInfoList;
      arrayOfByte2[102] = (byte)(arrayOfByte2[102] + 1);
      paramGameRun.say("宠物图鉴已更新", 0);
    } 
    this.effect = 7;
    this.effect_time = 0;
    byte[] arrayOfByte1 = (byte[])null;
  }
  
  public void evolveMonster(GameRun paramGameRun, int paramInt1, int paramInt2) {
    this.monster[0] = (byte)paramInt1;
    byte[] arrayOfByte2 = paramGameRun.monster_pro[paramInt1];
    this.monster[4] = arrayOfByte2[5];
    byte[] arrayOfByte1 = this.monster;
    arrayOfByte1[5] = (byte)(arrayOfByte1[5] - paramInt2);
    setProAFD(arrayOfByte2);
    this.monsterPro[2] = (short)(arrayOfByte2[0] + arrayOfByte2[7] * this.monster[2] / 10);
    this.monsterPro[3] = (short)(arrayOfByte2[1] + arrayOfByte2[8] * this.monster[2] / 10);
    resetPro(paramGameRun);
    this.monsterPro[1] = this.monsterPro[3];
    arrayOfByte1 = (byte[])null;
    if (paramGameRun.monInfoList[paramInt1] != 2) {
      if (paramGameRun.monInfoList[paramInt1] == 0) {
        arrayOfByte1 = paramGameRun.monInfoList;
        arrayOfByte1[102] = (byte)(arrayOfByte1[102] + 1);
      } 
      paramGameRun.addMonInfoListBH();
      paramGameRun.monInfoList[paramInt1] = 2;
    } 
  }
  
  public boolean isBuffRate(int paramInt) {
    return !(this.monster[16] != paramInt && this.monster[17] != paramInt);
  }
  
  public boolean isEffect(int paramInt) {
    return (this.effect == paramInt);
  }
  
  public boolean isMonEffect(int paramInt) {
    return (this.effect == paramInt && this.effect_time != 0);
  }
  
  public boolean isMonReel(int paramInt) {
    return !(this.monster[14] != paramInt && this.monster[15] != paramInt);
  }
  
  public void resetBoss(int paramInt) {
    this.monster[16] = 4;
    this.monster[17] = 10;
    this.monster[9] = 4;
    this.monster[10] = 9;
    this.monster[11] = 14;
    this.monster[12] = 19;
    this.monster[13] = 24;
    this.monster[14] = 30;
    this.monster[15] = 48;
    this.monster[6] = (byte)paramInt;
  }
  
  public void resetMonster(int paramInt1, int paramInt2, int paramInt3) {
    this.monster[16] = (byte)(this.monster[3] * 2 + 4);
    this.monster[17] = 2;
    this.monster[14] = (byte)paramInt1;
    this.monster[15] = (byte)paramInt2;
    this.monster[6] = (byte)paramInt3;
  }
  
  public void resetMonster(GameRun paramGameRun, int paramInt) {
    if (paramInt > -1) {
      this.monster[5] = (byte)paramInt;
    } else if (paramInt == -1) {
      byte[] arrayOfByte = this.monster;
      Ms.i();
      arrayOfByte[5] = (byte)Ms.getRandom(this.monster[5] + 1);
    } 
    resetPro(paramGameRun);
  }
  
  public void resetPro(GameRun paramGameRun) {
    if (isBuffRate(2)) {
      short[] arrayOfShort = this.monsterPro;
      arrayOfShort[2] = (short)(arrayOfShort[2] + this.monsterPro[2] * paramGameRun.inhesion[2] / 100);
    } else if (isBuffRate(1)) {
      short[] arrayOfShort = this.monsterPro;
      arrayOfShort[2] = (short)(arrayOfShort[2] + this.monsterPro[2] * paramGameRun.inhesion[1] / 100);
    } 
    if (this.monsterPro[2] < 1)
      this.monsterPro[2] = 1; 
    this.monsterPro[0] = this.monsterPro[2];
  }
  
  public void setProAFD(byte[] paramArrayOfbyte) {
    this.monsterPro[5] = (short)(paramArrayOfbyte[2] + paramArrayOfbyte[9] * this.monster[2] / 10);
    this.monsterPro[6] = (short)(paramArrayOfbyte[3] + paramArrayOfbyte[10] * this.monster[2] / 10);
    this.monsterPro[7] = (short)(paramArrayOfbyte[4] + paramArrayOfbyte[11] * this.monster[2] / 10);
  }
}


/* Location:              /Users/thanh0x/DevTools0x/Rb2.0vip-dex2jar.jar!/dm/Monster.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */