package main;

import android.util.Log;
import com.PetKing5_480x800.PetKing5;
import dm.Ms;
import dm.Sound;
import dm.Ui;

public class SMSSender implements Key_H {
  public static GameRun gr;
  
  public static boolean isWorking;
  
  public static PetKing5 pk;
  
  public static SMSSender smsSender;
  
  public static byte smsType;
  
  private StringBuffer[] about;
  
  private byte currentPage;
  
  public byte idSmsLevel;
  
  public byte[][] menu;
  
  private String[][] menuTxt;
  
  public byte menu_state;
  
  public PointerKey pkey;
  
  public byte[] sel;
  
  public byte sendSms;
  
  public byte showLine;
  
  public byte[][] smsCount;
  
  public boolean sms_a = true;
  
  public boolean sms_b = false;
  
  public byte tMyState;
  
  private int tState;
  
  private byte totalPage;
  
  public SMSSender(GameRun paramGameRun) {
    byte[] arrayOfByte = new byte[4];
    arrayOfByte[1] = 2;
    arrayOfByte[2] = 4;
    arrayOfByte[3] = 5;
    this.menu = new byte[][] { arrayOfByte, { 6 }, { 7 }, { 8 }, { 2 } };
    this.sel = new byte[2];
    arrayOfByte = new byte[3];
    arrayOfByte[0] = 1;
    arrayOfByte[1] = 1;
    this.smsCount = new byte[][] { { 4, 1, 1 }, { 2, 1, 2 }, { 4, 1, 3 }, { 1, 1, 4 }, { 2, 1, 5 }, arrayOfByte, { 2, 1, 6 }, { 2, 1, 5 } };
    this.sendSms = -1;
    gr = paramGameRun;
    smsSender = this;
    try {
      createSMS();
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
  }
  
  private void createSMS() {
    String[] arrayOfString = { "购买30000金", "" };
    this.menuTxt = new String[][] { { "商城" }, arrayOfString, { "购买5000金", "身为四大家族之首的贵公子，没钱可不行！立刻拥有5000金。" }, { "购买50徽章", "" }, { "购买10徽章", "购买该特殊道具，立刻拥有10徽章，能购买双倍经验，宠物技能，强大的宠物捕获球等各种神奇的道具。" }, { "宠物升5级", "让您随身携带的全部宠物立刻升5级（超过70级宠物不能再升级）" }, { "购买奇异兽", "购买该特殊道具，获得可爱的奇异兽，移动速度可以提高一倍，且不会遇到任何敌人！无限使用，心动不如行动，快购买吧！" }, { "正版验证", "游戏试玩结束，购买此项将开启后续所有游戏内容、地图。同时将免费赠送您5枚徽章（可购买强力道具）" }, { "升级复活", "让您携带的所有宠物全恢复，同时立刻让您携带的宠物提升5级（超过70级宠物不能再升级），让接下来的战斗变的更轻松。" } };
  }
  
  private void draw0() {
    boolean bool1 = true;
    boolean bool3 = true;
    boolean bool2 = true;
    boolean bool4 = true;
    if (this.sendSms > -1) {
      boolean bool5;
      boolean bool6;
      String str1;
      String str2 = "";
      if (this.sendSms == 0) {
        byte b = this.smsCount[smsType][2];
        if (b < 0) {
          b = 0;
        } else {
          b = gr.rmsSms[b];
        } 
        str1 = getSmsTip(b, this.smsCount[smsType][1] - b);
        bool6 = bool4;
        bool5 = bool3;
      } else {
        bool5 = bool3;
        bool6 = bool4;
        str1 = str2;
        if (this.sendSms != 1) {
          bool5 = bool3;
          bool6 = bool4;
          str1 = str2;
          if (this.sendSms != 2) {
            bool5 = bool3;
            bool6 = bool4;
            str1 = str2;
            if (this.sendSms != 3)
              if ((this.sendSms > 3 && this.sendSms < 15) || (this.sendSms > 23 && this.sendSms < 34)) {
                str2 = "购买已成功！";
                bool2 = false;
                bool1 = false;
                bool5 = bool1;
                bool6 = bool2;
                str1 = str2;
                if (this.sendSms > 23) {
                  bool5 = bool1;
                  bool6 = bool2;
                  str1 = str2;
                  if (this.sendSms < 34) {
                    this.sendSms = (byte)(this.sendSms + 1);
                    bool5 = bool1;
                    bool6 = bool2;
                    str1 = str2;
                  } 
                } 
              } else if (this.sendSms == 15) {
                str1 = "自动保存游戏。";
                bool6 = false;
                bool5 = false;
              } else {
                bool5 = bool3;
                bool6 = bool4;
                str1 = str2;
                if (this.sendSms < 23) {
                  str2 = "保存游戏成功。";
                  this.sendSms = (byte)(this.sendSms + 1);
                  bool2 = false;
                  bool1 = false;
                  if (smsType == 5 && this.sendSms == 23) {
                    gr.say("购买已成功！游戏已保存。#n新游戏后此功能不再要求付费。", -1);
                    bool5 = bool1;
                    bool6 = bool2;
                    str1 = str2;
                  } else {
                    bool5 = bool1;
                    bool6 = bool2;
                    str1 = str2;
                    if (smsType == 6) {
                      bool5 = bool1;
                      bool6 = bool2;
                      str1 = str2;
                      if (this.sendSms == 23) {
                        gr.say("购买已成功！获得5枚徽章(背包的卷轴界面可查看）。游戏已保存。#n新游戏后此功能不再要求付费。", 0);
                        bool5 = bool1;
                        bool6 = bool2;
                        str1 = str2;
                      } 
                    } 
                  } 
                } 
              }  
          } 
        } 
      } 
      bool1 = bool5;
      bool2 = bool6;
      if (this.sendSms != 3) {
        bool1 = bool5;
        bool2 = bool6;
        if (this.sendSms != 1) {
          bool1 = bool5;
          bool2 = bool6;
          if (this.sendSms != 2) {
            gr.showString(str1, Constants_H.HEIGHT_H - 50, 0);
            bool2 = bool6;
            bool1 = bool5;
          } 
        } 
      } 
    } 
    Ui.i().drawYesNo(bool1, bool2);
  }
  
  private String getSmsTip(int paramInt1, int paramInt2) {
    return String.valueOf("") + "您已发送" + paramInt1 + "条短信。" + "购买此项，还需发送" + paramInt2 + "条短信。" + "确认发送短信吗？";
  }
  
  private void goWord() {
    this.showLine = 3;
  }
  
  public static SMSSender i(GameRun paramGameRun) {
    if (smsSender == null)
      smsSender = new SMSSender(paramGameRun); 
    return smsSender;
  }
  
  private void outState() {
    if (this.tState != -1) {
      GameRun.run_state = this.tState;
      gr.map.my.state = this.tMyState;
      return;
    } 
    GameRun.run_state = -10;
  }
  
  public void draw() {
    int i;
    int j;
    int k;
    int m;
    if (this.menu_state == 0) {
      i = 640 - 2;
      j = 360 - 1;
      Ui.i().fillRectB();
      Ui.i().drawK2(1, 1, i, j, 0);
      Ui.i().drawK1(320 - 75, 1 + 3, 150, 28 - 4, 4);
      Ui.i().drawString(this.menuTxt[this.menu[this.menu_state][0]][0], 320, 1 + 1, 17, 0, 1);
      Log.e("sk", "draw");
      k = 1 + 5;
      int n = 1 + 29;
      m = i - 10;
      i = n;
      if ((this.menu[this.menu_state]).length > 1) {
        Ui.i().drawK1(k, n, m - 15, 28 * this.showLine, 1);
        Ui.i().sliding(k + 628 - 13, n, 28 * this.showLine, this.sel[0] - 1, (this.menu[this.menu_state]).length - 1, true);
        Ui.i().drawListKY(this.showLine, k, n + 2, m - 15, 2, 28, -1, this.sel[0] - this.sel[1], 4, 2);
        i = this.sel[1];
        while (true) {
          if (i >= this.sel[1] + this.showLine || i >= (this.menu[this.menu_state]).length) {
            i = this.showLine * 28 + 5 + 30;
          } else {
            Ui ui = Ui.i();
            String str = this.menuTxt[this.menu[this.menu_state][i]][0];
            byte b = this.sel[1];
            if (this.sel[0] == i) {
              n = 0;
            } else {
              n = 3;
            } 
            ui.drawString(str, k + 314, (i - b) * 28 + 32, 17, n, 0);
            if (this.pkey.isSelect(k, (i - this.sel[1]) * 28 + 32, 640, 28)) {
              this.sel[0] = (byte)i;
              setSmsType();
            } 
            i++;
            continue;
          } 
          Ui.i().drawK1(k, i, m, j - i + 10, 2);
          draw0();
          return;
        } 
      } 
    } else {
      return;
    } 
    Ui.i().drawK1(k, i, m, j - i + 10, 2);
    draw0();
  }
  
  public byte getSendSms() {
    return this.sendSms;
  }
  
  public byte getSmsSenderMenuState() {
    return this.menu_state;
  }
  
  public int getTstate() {
    return this.tState;
  }
  
  public void go(int paramInt, boolean paramBoolean) {
    if (paramBoolean) {
      this.tState = GameRun.run_state;
      this.tMyState = gr.map.my.state;
    } else {
      this.tState = -1;
    } 
    this.sms_a = true;
    this.sms_b = false;
    GameRun.run_state = -20;
    this.menu_state = (byte)paramInt;
    byte[] arrayOfByte1 = this.sel;
    byte[] arrayOfByte2 = this.sel;
    if ((this.menu[this.menu_state]).length > 1) {
      paramInt = 1;
    } else {
      paramInt = 0;
    } 
    byte b = (byte)paramInt;
    arrayOfByte2[1] = b;
    arrayOfByte1[0] = b;
    smsType = (byte)(this.menu[this.menu_state][this.sel[0]] - 1);
    goWord();
    if (smsType == 5 || smsType == 6 || smsType == 7 || (this.menu_state == 4 && smsType == 1)) {
      this.sendSms = 1;
      return;
    } 
    this.sendSms = -1;
    isWorking = false;
  }
  
  public void goLevel() {
    GameRun.run_state = -21;
    this.idSmsLevel = 0;
    gr.b_c = 0;
    if (this.tState != -31) {
      gr.levelUp_in_battle = null;
      GameRun gameRun = gr;
      byte b1 = gr.max_takes;
      gameRun.levelUp_in_battle = new byte[b1][2];
      gr.proReplace = null;
      gameRun = gr;
      int i = gr.myMonsters.length;
      gameRun.proReplace = new short[i][7];
    } 
    byte b = 0;
    label20: while (true) {
      if (b >= gr.myMon_length)
        return; 
      if ((gr.myMonsters[b]).monster[2] >= 70) {
        gr.healMonster(gr.myMonsters[b]);
        continue;
      } 
      gr.proReplace[b][6] = (gr.myMonsters[b]).monster[2];
      gr.levelUp_in_battle[b][0] = 1;
      gr.levelUp_in_battle[b][1] = -1;
      byte b1 = 0;
      while (true) {
        if (b1 < 5) {
          gr.levelPro(b, false);
          gr.getMagic(gr.myMonsters[b]);
          if (gr.getSkill != -1)
            gr.levelUp_in_battle[b][1] = gr.getSkill; 
          b1 = (byte)(b1 + 1);
          continue;
        } 
        b = (byte)(b + 1);
        continue label20;
      } 
      break;
    } 
  }
  
  public boolean isMyMonLevel() {
    for (byte b = (byte)(gr.myMon_length - 1);; b = (byte)(b - 1)) {
      if (b <= -1)
        return false; 
      if ((gr.myMonsters[b]).monster[2] < 70)
        return true; 
    } 
  }
  
  public void key() {
    if (this.sendSms == -1 && Ms.i().key_Up_Down()) {
      if (!Ms.i().key_delay() && (this.menu[this.menu_state]).length > 1) {
        Ms.i().selectS(this.sel, 1, (this.menu[this.menu_state]).length, this.showLine);
        setSmsType();
      } 
      return;
    } 
    if ((this.sendSms == -1 || this.sendSms == 0) && Ms.i().key_S1()) {
      Ms.i().keyRelease();
      if (smsType == 4 && this.sel[0] != 7 && (gr.myMon_length < 1 || !isMyMonLevel())) {
        this.sendSms = -1;
        gr.say("目前没有可以升级的宠物！", 0);
        return;
      } 
      this.sendSms = 1;
      return;
    } 
    if ((this.sendSms == -1 || this.sendSms == 0 || this.sendSms == 3 || this.sendSms == 24) && Ms.i().key_S2()) {
      Ms.i().keyRelease();
      outState();
      if (smsType == 6) {
        GameRun.run_state = -10;
        isWorking = true;
      } 
      this.sendSms = -1;
    } 
  }
  
  public void keyLevel() {
    if (!Ms.i().key_delay() && gr.b_c == 1 && gr.say_s == 0)
      gr.b_c = 0; 
  }
  
  public void paint() {
    draw();
  }
  
  public void paintLevel() {
    if (gr.b_c == 1)
      gr.drawEvolveUI(0, this.idSmsLevel, true); 
  }
  
  public void run() {
    if (this.sendSms == 1) {
      this.sendSms = 2;
      pk.setSmshah();
    } 
  }
  
  public void runLevel() {
    if (gr.b_c == 0) {
      if (gr.levelUp_in_battle[this.idSmsLevel][0] == 1) {
        gr.levelUp_in_battle[this.idSmsLevel][0] = 0;
        gr.b_c = 1;
        gr.say_s = 52;
        gr.levelPro(this.idSmsLevel, true);
        gr.setStringB("生命;+" + gr.proReplace[this.idSmsLevel][0] + "#n" + "能量" + ";+" + gr.proReplace[this.idSmsLevel][1], Constants_H.WIDTH, 0);
        gr.setStringB("力量;+" + gr.proReplace[this.idSmsLevel][3] + "#n" + "防御" + ";+" + gr.proReplace[this.idSmsLevel][4] + "#n" + "敏捷" + ";+" + gr.proReplace[this.idSmsLevel][5], Constants_H.WIDTH, 1);
        gr.initMonStream(2, gr.mList_id[(gr.myMonsters[this.idSmsLevel]).monster[0]][0], 1);
      } else {
        this.idSmsLevel = (byte)(this.idSmsLevel + 1);
      } 
      if (this.idSmsLevel >= gr.myMon_length) {
        if (this.tState == -1) {
          GameRun.run_state = -20;
          gr.levelUp_in_battle = null;
          gr.proReplace = null;
          return;
        } 
      } else {
        return;
      } 
      GameRun.run_state = this.tState;
      if (this.tState == -31) {
        gr.initMonStream(2, gr.mList_id[(gr.myB.getMon()).monster[0]][0], 1);
        gr.myB.act_num = 0;
        gr.initSkillList(gr.myB.getMon());
        byte b = 0;
        while (true) {
          if (b < gr.myMon_length) {
            gr.proReplace[(gr.myMonsters[b]).monster[1]][6] = (gr.myMonsters[b]).monster[2];
            b = (byte)(b + 1);
            continue;
          } 
          return;
        } 
      } 
      return;
    } 
    if (gr.b_c == 1)
      gr.say_s = (byte)Ms.i().mathSpeedDown(gr.say_s, 4, true); 
  }
  
  public void sendSuccess() {
    GameRun gameRun;
    if (this.sendSms == 4 && this.smsCount[smsType][1] > 1) {
      byte[] arrayOfByte = gr.rmsSms;
      byte b2 = this.smsCount[smsType][2];
      byte b1 = (byte)(arrayOfByte[b2] + 1);
      arrayOfByte[b2] = b1;
      if (b1 != this.smsCount[smsType][1]) {
        this.sendSms = 0;
        Ms.i().rmsOptions(5, gr.rmsSms, 2);
        Ms.i().rmsOptions(5, null, 4);
      } else {
        gr.rmsSms[this.smsCount[smsType][2]] = 0;
      } 
    } 
    switch (smsType) {
      default:
        gr.saveGame();
        if (this.menu_state != 0) {
          this.sendSms = -1;
          if (gr.say_c == 0) {
            outState();
            GameRun.mc.setSmsIsSetRun_state(true);
            GameRun.run_state = -10;
            GameRun.mc.temp_state = GameRun.run_state;
          } 
        } else {
          break;
        } 
        this.sendSms = -1;
        GameRun.run_state = -10;
        GameRun.mc.temp_state = GameRun.run_state;
        return;
      case 1:
        gameRun = gr;
        gameRun.money += 5000;
        gr.say("购买5000金币", -1);
        GameRun.run_state = -10;
        GameRun.mc.temp_state = GameRun.run_state;
      case 2:
        gameRun = gr;
        gameRun.coin += 50;
        gr.say("在卷轴商店中才能看到徽章数量", -1);
        GameRun.run_state = -10;
        GameRun.mc.temp_state = GameRun.run_state;
      case 3:
        gameRun = gr;
        gameRun.coin += 10;
        gr.say("在卷轴商店中才能看到徽章数量", -1);
        GameRun.run_state = -10;
        GameRun.mc.temp_state = GameRun.run_state;
      case 4:
        this.tState = -1;
        gr.say("携带的宠物全部升5级,宠物页面查看新属性", 0, -1);
        GameRun.run_state = -10;
        GameRun.mc.temp_state = GameRun.run_state;
      case 7:
        goLevel();
        GameRun.mc.setSmsIsSetRun_state(true);
        GameRun.run_state = -10;
        GameRun.mc.temp_state = GameRun.run_state;
      case 5:
        gr.rmsSms[0] = 10;
        gr.say("购买后此功能不再要求付费", 0, -1);
        GameRun.run_state = -10;
        GameRun.mc.temp_state = GameRun.run_state;
      case 6:
        gr.rmsSms[this.smsCount[smsType][2]] = 10;
        gameRun = gr;
        gameRun.coin += 5;
        this.sms_b = true;
        gr.say("购买后此功能不再要求付费", 0, -1);
        GameRun.run_state = -10;
        GameRun.mc.temp_state = GameRun.run_state;
    } 
    this.sendSms = -1;
    Sound.i().setMusic(false);
    this.sendSms = -1;
    GameRun.run_state = -10;
    GameRun.mc.temp_state = GameRun.run_state;
  }
  
  public void setSendSms(int paramInt) {
    this.sendSms = (byte)paramInt;
  }
  
  public void setSmsType() {
    smsType = (byte)(this.menu[this.menu_state][this.sel[0]] - 1);
  }
  
  public void setSmsValue(int paramInt) {
    switch (smsType) {
    
    } 
  }
}


/* Location:              /Users/thanh0x/DevTools0x/Rb2.0vip-dex2jar.jar!/main/SMSSender.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */