package dm;

public class Battle {
  public byte act_num = 1;
  
  public byte action;
  
  public boolean b_renascence = false;
  
  public byte baoji;
  
  public byte bg_id;
  
  public short[] cThrow = new short[4];
  
  public byte[] ceff = new byte[6];
  
  public short cexp;
  
  public short chp;
  
  public byte[] countS = new byte[10];
  
  public byte dead;
  
  public byte fs_level;
  
  public short[][] hit = new short[3][5];
  
  public Monster[] mon;
  
  public byte now_id;
  
  public byte rate_off;
  
  public byte skill;
  
  public byte throw_state = -1;
  
  public Battle(Monster[] paramArrayOfMonster) {
    this.mon = paramArrayOfMonster;
  }
  
  public void addHit(int paramInt1, int paramInt2, int paramInt3) {
    this.hit[paramInt3][0] = (short)paramInt2;
    short[] arrayOfShort = this.hit[paramInt3];
    arrayOfShort[1] = (short)(arrayOfShort[1] + paramInt1);
    this.hit[paramInt3][2] = 0;
    this.hit[paramInt3][3] = 0;
    this.hit[paramInt3][4] = 0;
  }
  
  public Monster getMon() {
    return this.mon[this.now_id];
  }
  
  public void initHit() {
    for (byte b = 0;; b = (byte)(b + 1)) {
      if (b >= this.hit.length)
        return; 
      this.hit[b][1] = 0;
    } 
  }
}


/* Location:              /Users/thanh0x/DevTools0x/Rb2.0vip-dex2jar.jar!/dm/Battle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */