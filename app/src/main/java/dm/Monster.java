package dm;

import main.GameRun;
import main.Key_H;

public class Monster implements Key_H
{
    public byte effect;
    public byte effect_time;
    public byte[] monster;
    public short[] monsterPro;
    
    public Monster() {
        super();
    }
    
    public Monster(final GameRun gameRun, final int n, final int n2, int random) {
        super();
        this.monsterPro = new short[8];
        (this.monster = new byte[18])[0] = (byte)n;
        this.monster[2] = (byte)n2;
        final byte[] proAFD = gameRun.monster_pro[n];
        this.monster[3] = proAFD[6];
        this.monster[4] = proAFD[5];
        this.monster[5] = proAFD[12];
        this.monster[8] = 25;
        this.monster[9] = -1;
        this.monster[10] = -1;
        this.monster[11] = -1;
        this.monster[12] = -1;
        this.monster[13] = -1;
        this.monster[14] = -1;
        this.monster[15] = -1;
        if (random == -1) {
            this.monster[16] = (byte)(this.monster[3] * 2 + 4);
            this.monster[17] = 2;
        }
        else if (random == 0) {
            final byte[] monster = this.monster;
            random = this.monster[3];
            Ms.i();
            monster[16] = (byte)(random * 2 + 3 + Ms.getRandom(2));
            final byte[] monster2 = this.monster;
            Ms.i();
            monster2[17] = (byte)Ms.getRandom(3);
        }
        else if (random == 1) {
            final byte[] monster3 = this.monster;
            final byte b = this.monster[3];
            Ms.i();
            if (Ms.getRandom(100) < 70) {
                random = 1;
            }
            else {
                random = 0;
            }
            monster3[16] = (byte)(b * 2 + 3 + random);
            final byte[] monster4 = this.monster;
            Ms.i();
            if (Ms.getRandom(100) < 70) {
                random = 2;
            }
            else {
                Ms.i();
                random = Ms.getRandom(2);
            }
            monster4[17] = (byte)random;
        }
        final byte[] monster5 = this.monster;
        if (this.monster[4] > 3) {
            random = 120;
        }
        else {
            random = 100;
        }
        monster5[6] = (byte)random;
        this.monsterPro[2] = (short)(proAFD[0] + proAFD[7] * n2 / 10);
        this.monsterPro[3] = (short)(proAFD[1] + proAFD[8] * n2 / 10);
        this.monsterPro[1] = this.monsterPro[3];
        this.monsterPro[0] = this.monsterPro[2];
        this.monsterPro[4] = 0;
        this.setProAFD(proAFD);
        if (this.monster[3] != -1) {
            gameRun.getMagic(this);
        }
        if (gameRun.monInfoList[n] == 0) {
            gameRun.monInfoList[n] = 1;
            final byte[] monInfoList = gameRun.monInfoList;
            ++monInfoList[102];
            gameRun.say("\u5ba0\u7269\u56fe\u9274\u5df2\u66f4\u65b0", 0);
        }
        this.effect = 7;
        this.effect_time = 0;
        final byte[] array = (byte[])null;
    }
    
    public void evolveMonster(final GameRun gameRun, final int n, final int n2) {
        this.monster[0] = (byte)n;
        final byte[] proAFD = gameRun.monster_pro[n];
        this.monster[4] = proAFD[5];
        final byte[] monster = this.monster;
        monster[5] -= (byte)n2;
        this.setProAFD(proAFD);
        this.monsterPro[2] = (short)(proAFD[0] + proAFD[7] * this.monster[2] / 10);
        this.monsterPro[3] = (short)(proAFD[1] + proAFD[8] * this.monster[2] / 10);
        this.resetPro(gameRun);
        this.monsterPro[1] = this.monsterPro[3];
        final byte[] array = (byte[])null;
        if (gameRun.monInfoList[n] != 2) {
            if (gameRun.monInfoList[n] == 0) {
                final byte[] monInfoList = gameRun.monInfoList;
                ++monInfoList[102];
            }
            gameRun.addMonInfoListBH();
            gameRun.monInfoList[n] = 2;
        }
    }
    
    public boolean isBuffRate(final int n) {
        return this.monster[16] == n || this.monster[17] == n;
    }
    
    public boolean isEffect(final int n) {
        return this.effect == n;
    }
    
    public boolean isMonEffect(final int n) {
        return this.effect == n && this.effect_time != 0;
    }
    
    public boolean isMonReel(final int n) {
        return this.monster[14] == n || this.monster[15] == n;
    }
    
    public void resetBoss(final int n) {
        this.monster[16] = 4;
        this.monster[17] = 10;
        this.monster[9] = 4;
        this.monster[10] = 9;
        this.monster[11] = 14;
        this.monster[12] = 19;
        this.monster[13] = 24;
        this.monster[14] = 30;
        this.monster[15] = 48;
        this.monster[6] = (byte)n;
    }
    
    public void resetMonster(final int n, final int n2, final int n3) {
        this.monster[16] = (byte)(this.monster[3] * 2 + 4);
        this.monster[17] = 2;
        this.monster[14] = (byte)n;
        this.monster[15] = (byte)n2;
        this.monster[6] = (byte)n3;
    }
    
    public void resetMonster(final GameRun gameRun, final int n) {
        if (n > -1) {
            this.monster[5] = (byte)n;
        }
        else if (n == -1) {
            final byte[] monster = this.monster;
            Ms.i();
            monster[5] = (byte)Ms.getRandom(this.monster[5] + 1);
        }
        this.resetPro(gameRun);
    }
    
    public void resetPro(final GameRun gameRun) {
        if (this.isBuffRate(2)) {
            final short[] monsterPro = this.monsterPro;
            monsterPro[2] += (short)(this.monsterPro[2] * gameRun.inhesion[2] / 100);
        }
        else if (this.isBuffRate(1)) {
            final short[] monsterPro2 = this.monsterPro;
            monsterPro2[2] += (short)(this.monsterPro[2] * gameRun.inhesion[1] / 100);
        }
        if (this.monsterPro[2] < 1) {
            this.monsterPro[2] = 1;
        }
        this.monsterPro[0] = this.monsterPro[2];
    }
    
    public void setProAFD(final byte[] array) {
        this.monsterPro[5] = (short)(array[2] + array[9] * this.monster[2] / 10);
        this.monsterPro[6] = (short)(array[3] + array[10] * this.monster[2] / 10);
        this.monsterPro[7] = (short)(array[4] + array[11] * this.monster[2] / 10);
    }
}
