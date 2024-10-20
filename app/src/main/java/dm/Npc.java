package dm;

import main.Key_H;

/* loaded from: classes.dex */
/**
 * The Npc class represents a non-player character (NPC) in the game.
 * It implements the Key_H interface and contains various attributes and methods
 * to manage the state and behavior of the NPC.
 * 
 * <p>Attributes include coordinates, speed, state, and various flags indicating
 * the NPC's current status and actions. Methods are provided to manipulate these
 * attributes and perform actions such as setting coordinates, speed, and actions.</p>
 * 
 * <p>Example usage:</p>
 * <pre>
 * {@code
 * Npc npc = new Npc();
 * npc.setSpeedXY(5, 10);
 * npc.setXY(1, 2, 0, 0);
 * }
 * </pre>
 */
public class Npc implements Key_H {
    public byte brow_action;
    public byte brow_time;
    public byte[] other;
    public byte speed_x;
    public byte speed_y;
    public byte state;
    public byte timeMove;
    public short x;
    public short y;
    public boolean b_check = true;
    public boolean b_auto = false;
    public boolean bdir = false;
    public byte npc_num = 0;
    public byte frame_c = -1;
    public byte frame_num = 1;
    public byte lastAction = Byte.MAX_VALUE;
    public byte speed = 5;
    public byte brow_type = -1;
    public byte ix = -1;
    public byte iy = -1;
    public byte dir = 3;
    public byte now_time = 0;
    public byte now_action = 0;

    /**
     * Default constructor for the Npc class.
     */
    public Npc() {
    }

    /**
     * Constructor for the Npc class with a specified length for the 'other' array.
     *
     * @param len the length of the 'other' array
     */
    public Npc(int len) {
        this.other = new byte[len];
    }

    /**
     * Sets the x and y coordinates of the NPC based on the 'other' array.
     */
    public void setXY_npc() {
        setXY(this.other[0], this.other[1], 0, 0);
    }

    /**
     * Sets the 'ix' and 'iy' values in the 'other' array based on the current coordinates.
     */
    public void setIxIy_npc() {
        this.other[0] = getIx();
        this.other[1] = getIy();
    }

    /**
     * Sets the action number based on the mode and direction.
     *
     * @param mode the mode to set the action number
     */
    public void setActionNo(boolean mode) {
        if (!this.bdir) {
            if (this.dir == 2) {
                this.other[7] = mode ? (byte) 3 : (byte) 0;
            } else if (this.dir == 1) {
                this.other[7] = mode ? (byte) 4 : (byte) 1;
            } else {
                this.other[7] = mode ? (byte) 5 : (byte) 2;
            }
            byte[] bArr = this.other;
            bArr[7] = (byte) (bArr[7] + (this.npc_num * 6));
        }
    }

    /**
     * Sets the NPC number based on the length.
     *
     * @param length the length to set the NPC number
     */
    public void setNpcNum(int length) {
        this.npc_num = (byte) (this.other[7] / 6);
        if ((this.npc_num + 1) * 6 > length) {
            this.npc_num = (byte) 0;
        }
    }

    /**
     * Sets the speed of the NPC along the x and y axes.
     *
     * @param _speed_x the speed along the x-axis
     * @param _speed_y the speed along the y-axis
     */
    public void setSpeedXY(int _speed_x, int _speed_y) {
        this.speed_x = (byte) _speed_x;
        this.speed_y = (byte) _speed_y;
    }

    /**
     * Sets the 'ix' and 'iy' values.
     *
     * @param _ix the x-coordinate index
     * @param _iy the y-coordinate index
     */
    public void setIXY(int _ix, int _iy) {
        this.ix = (byte) _ix;
        this.iy = (byte) _iy;
    }

    /**
     * Sets the last action and direction of the NPC.
     *
     * @param _bdir       the direction flag
     * @param _lastAction the last action performed
     */
    public void setLastAction(boolean _bdir, int _lastAction) {
        this.bdir = _bdir;
        this.lastAction = (byte) _lastAction;
    }

    /**
     * Sets the x and y coordinates based on the given indices and offsets.
     *
     * @param ix   the x-coordinate index
     * @param iy   the y-coordinate index
     * @param offx the x-coordinate offset
     * @param offy the y-coordinate offset
     */
    public void setXY(int ix, int iy, int offx, int offy) {
        this.x = (short) ((ix * 20) + offx);
        this.y = (short) ((iy * 20) + offy);
    }

    /**
     * Gets the x-coordinate index.
     *
     * @return the x-coordinate index
     */
    public byte getIx() {
        return (byte) (this.x / 20);
    }

    /**
     * Gets the y-coordinate index.
     *
     * @return the y-coordinate index
     */
    public byte getIy() {
        return (byte) (this.y / 20);
    }

    /**
     * Gets the x-coordinate offset.
     *
     * @return the x-coordinate offset
     */
    public byte getIx_off() {
        return (byte) (this.x % 20);
    }

    /**
     * Gets the y-coordinate offset.
     *
     * @return the y-coordinate offset
     */
    public byte getIy_off() {
        return (byte) (this.y % 20);
    }
}
