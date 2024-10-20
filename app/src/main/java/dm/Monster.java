package dm;

import main.Constants_H;
import main.GameRun;
import main.Key_H;

/* loaded from: classes.dex */
/**
 * The Monster class represents a monster entity in the game. It implements the Key_H interface.
 * This class contains various properties and methods to manage the monster's attributes, effects, and behaviors.
 */
/**
 * The Monster class represents a monster in the game with various attributes and properties.
 * It provides methods to manipulate and check the state of the monster.
 * This class implements the Key_H interface.
 */
public class Monster implements Key_H {
    
    /**
     * The effect currently applied to the monster.
     */
    public byte effect;

    /**
     * The duration of the effect currently applied to the monster.
     */
    public byte effect_time;

    /**
     * An array representing various attributes of the monster.
     */
    public byte[] monster;

    /**
     * An array representing various properties of the monster.
     */
    public short[] monsterPro;

    /**
     * Constructs a new Monster with the specified parameters.
     *
     * @param data The game data.
     * @param enemy_name The name of the enemy.
     * @param enemylevel The level of the enemy.
     * @param enemy_no The number of the enemy.
     */
    public Monster(GameRun data, int enemy_name, int enemylevel, int enemy_no) {
        int random;
        this.monsterPro = new short[8];
        this.monster = new byte[18];
        this.monster[0] = (byte) enemy_name;
        this.monster[2] = (byte) enemylevel;
        byte[] temp_pro = data.monster_pro[enemy_name];
        this.monster[3] = temp_pro[6];
        this.monster[4] = temp_pro[5];
        this.monster[5] = temp_pro[12];
        this.monster[8] = 25;
        this.monster[9] = -1;
        this.monster[10] = -1;
        this.monster[11] = -1;
        this.monster[12] = -1;
        this.monster[13] = -1;
        this.monster[14] = -1;
        this.monster[15] = -1;
        if (enemy_no == -1) {
            this.monster[16] = (byte) ((this.monster[3] * 2) + 4);
            this.monster[17] = 2;
        } else if (enemy_no == 0) {
            byte[] bArr = this.monster;
            int i = (this.monster[3] * 2) + 3;
            Ms.i();
            bArr[16] = (byte) (i + Ms.getRandom(2));
            byte[] bArr2 = this.monster;
            Ms.i();
            bArr2[17] = (byte) Ms.getRandom(3);
        } else if (enemy_no == 1) {
            byte[] bArr3 = this.monster;
            int i2 = (this.monster[3] * 2) + 3;
            Ms.i();
            bArr3[16] = (byte) (i2 + (Ms.getRandom(100) < 70 ? 1 : 0));
            byte[] bArr4 = this.monster;
            Ms.i();
            if (Ms.getRandom(100) < 70) {
                random = 2;
            } else {
                Ms.i();
                random = Ms.getRandom(2);
            }
            bArr4[17] = (byte) random;
        }
        this.monster[6] = (byte) (this.monster[4] > 3 ? 120 : 100);
        this.monsterPro[2] = (short) (temp_pro[0] + ((temp_pro[7] * enemylevel) / 10));
        this.monsterPro[3] = (short) (temp_pro[1] + ((temp_pro[8] * enemylevel) / 10));
        this.monsterPro[1] = this.monsterPro[3];
        this.monsterPro[0] = this.monsterPro[2];
        this.monsterPro[4] = 0;
        setProAFD(temp_pro);
        if (this.monster[3] != -1) {
            data.getMagic(this);
        }
        if (data.monInfoList[enemy_name] == 0) {
            data.monInfoList[enemy_name] = 1;
            byte[] bArr5 = data.monInfoList;
            bArr5[102] = (byte) (bArr5[102] + 1);
            data.say(Constants_H.TXT_104, 0);
        }
        this.effect = (byte) 7;
        this.effect_time = (byte) 0;
    }

    /**
     * Default constructor for the Monster class.
     */
    public Monster() {
        // Default constructor implementation
    }

    /**
     * Sets the properties of the monster based on the provided data.
     *
     * @param data The data to set the properties from.
     */
    public void setProAFD(byte[] data) {
        this.monsterPro[5] = (short) (data[2] + ((data[9] * this.monster[2]) / 10));
        this.monsterPro[6] = (short) (data[3] + ((data[10] * this.monster[2]) / 10));
        this.monsterPro[7] = (short) (data[4] + ((data[11] * this.monster[2]) / 10));
    }

    /**
     * Checks if the monster has the specified effect.
     *
     * @param id The effect ID to check.
     * @return true if the monster has the specified effect, false otherwise.
     */
    public boolean isEffect(int id) {
        return this.effect == id;
    }

    /**
     * Checks if the monster has the specified effect and the effect time is not zero.
     *
     * @param id The effect ID to check.
     * @return true if the monster has the specified effect and the effect time is not zero, false otherwise.
     */
    public boolean isMonEffect(int id) {
        return this.effect == id && this.effect_time != 0;
    }

    /**
     * Checks if the monster has the specified reel.
     *
     * @param reel The reel to check.
     * @return true if the monster has the specified reel, false otherwise.
     */
    public boolean isMonReel(int reel) {
        return this.monster[14] == reel || this.monster[15] == reel;
    }

    /**
     * Checks if the monster has the specified buff rate.
     *
     * @param effect_id The effect ID to check.
     * @return true if the monster has the specified buff rate, false otherwise.
     */
    public boolean isBuffRate(int effect_id) {
        return this.monster[16] == effect_id || this.monster[17] == effect_id;
    }

    /**
     * Resets the monster's attributes based on the provided game data and evolve parameter.
     *
     * @param data The game data.
     * @param evolve The evolve parameter.
     */
    public void resetMonster(GameRun data, int evolve) {
        if (evolve > -1) {
            this.monster[5] = (byte) evolve;
        } else if (evolve == -1) {
            byte[] bArr = this.monster;
            Ms.i();
            bArr[5] = (byte) Ms.getRandom(this.monster[5] + 1);
        }
        resetPro(data);
    }

    /**
     * Resets the monster's properties based on the provided game data.
     *
     * @param data The game data.
     */
    public void resetPro(GameRun data) {
        if (isBuffRate(2)) {
            short[] sArr = this.monsterPro;
            sArr[2] = (short) (sArr[2] + ((this.monsterPro[2] * data.inhesion[2]) / 100));
        } else if (isBuffRate(1)) {
            short[] sArr2 = this.monsterPro;
            sArr2[2] = (short) (sArr2[2] + ((this.monsterPro[2] * data.inhesion[1]) / 100));
        }
        if (this.monsterPro[2] < 1) {
            this.monsterPro[2] = 1;
        }
        this.monsterPro[0] = this.monsterPro[2];
    }

    /**
     * Resets the monster's attributes based on the provided skill and fealty parameters.
     *
     * @param skill6 The skill6 parameter.
     * @param skill7 The skill7 parameter.
     * @param fealty The fealty parameter.
     */
    public void resetMonster(int skill6, int skill7, int fealty) {
        this.monster[16] = (byte) ((this.monster[3] * 2) + 4);
        this.monster[17] = 2;
        this.monster[14] = (byte) skill6;
        this.monster[15] = (byte) skill7;
        this.monster[6] = (byte) fealty;
    }

    /**
     * Resets the monster's attributes for a boss monster based on the provided fealty parameter.
     *
     * @param fealty The fealty parameter.
     */
    public void resetBoss(int fealty) {
        this.monster[16] = 4;
        this.monster[17] = 10;
        this.monster[9] = 4;
        this.monster[10] = 9;
        this.monster[11] = 14;
        this.monster[12] = 19;
        this.monster[13] = 24;
        this.monster[14] = 30;
        this.monster[15] = 48;
        this.monster[6] = (byte) fealty;
    }

    /**
     * Evolves the monster based on the provided game data, enemy name, and evolve parameter.
     *
     * @param data The game data.
     * @param enemy_name The name of the enemy.
     * @param evolve The evolve parameter.
     */
    public void evolveMonster(GameRun data, int enemy_name, int evolve) {
        this.monster[0] = (byte) enemy_name;
        byte[] temp_pro = data.monster_pro[enemy_name];
        this.monster[4] = temp_pro[5];
        byte[] bArr = this.monster;
        bArr[5] = (byte) (bArr[5] - evolve);
        setProAFD(temp_pro);
        this.monsterPro[2] = (short) (temp_pro[0] + ((temp_pro[7] * this.monster[2]) / 10));
        this.monsterPro[3] = (short) (temp_pro[1] + ((temp_pro[8] * this.monster[2]) / 10));
        resetPro(data);
        this.monsterPro[1] = this.monsterPro[3];
        if (data.monInfoList[enemy_name] != 2) {
            if (data.monInfoList[enemy_name] == 0) {
                byte[] bArr2 = data.monInfoList;
                bArr2[102] = (byte) (bArr2[102] + 1);
            }
            data.addMonInfoListBH();
            data.monInfoList[enemy_name] = 2;
        }
    }
}
