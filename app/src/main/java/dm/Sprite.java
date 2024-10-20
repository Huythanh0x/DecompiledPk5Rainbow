package dm.Sprite;
import java.lang.Object;
import javax.microedition.lcdui.Image;

public class Sprite	// class@0000e4 from classes.dex
{
    private byte[][][] action_byte;
    private short[][][] action_short;
    private byte[][][] frame_byte;
    private short[][][] frame_short;
    public Image img;
    private byte[][] module_byte;
    private short[][] module_short;
    private boolean type;

    public void Sprite(){
       super();
       this.type = true;
       this.module_byte = null;
       this.frame_byte = null;
       this.action_byte = null;
       this.module_short = null;
       this.frame_short = null;
       this.action_short = null;
       this.nullIMFA();
    }
    public static Sprite Create(Image _img,byte[][] _module,byte[][][] _frame,byte[][][] _action){
       Sprite sp = new Sprite();
       sp.type = true;
       sp.img = _img;
       sp.module_byte = _module;
       sp.frame_byte = _frame;
       sp.action_byte = _action;
       return sp;
    }
    public static Sprite Create(Image _img,short[][] _module,short[][][] _frame,short[][][] _action){
       Sprite sp = new Sprite();
       sp.type = false;
       sp.img = _img;
       sp.module_short = _module;
       sp.frame_short = _frame;
       sp.action_short = _action;
       return sp;
    }
    public void Set(Image _img,byte[][] _module,byte[][][] _frame,byte[][][] _action){
       this.nullIMFA();
       this.type = true;
       this.img = _img;
       this.module_byte = _module;
       this.frame_byte = _frame;
       this.action_byte = _action;
    }
    public void Set(Image _img,short[][] _module,short[][][] _frame,short[][][] _action){
       this.nullIMFA();
       this.type = false;
       this.img = _img;
       this.module_short = _module;
       this.frame_short = _frame;
       this.action_short = _action;
    }
    public int aLength(){
       int len = (this.type != null)? this.action_byte.length: this.action_short.length;
       return len;
    }
    public int aLength(int i){
       int len = (this.type != null)? this.action_byte[i].length: this.action_short[i].length;
       return len;
    }
    public int action(int i,int j,int k){
       byte b = (this.type != null)? this.action_byte[i][j][k]: this.action_short[i][j][k];
       return b;
    }
    public int fLength(int i){
       int len = (this.type != null)? this.frame_byte[i].length: this.frame_short[i].length;
       return len;
    }
    public int frame(int i,int j,int k){
       byte b = (this.type != null)? this.frame_byte[i][j][k]: this.frame_short[i][j][k];
       return b;
    }
    public int module(int i,int j){
       byte b = (this.type != null)? this.module_byte[i][j]: this.module_short[i][j];
       return b;
    }
    public void nullIMFA(){
       this.img = null;
       this.module_byte = null;
       this.frame_byte = null;
       this.action_byte = null;
       this.module_short = null;
       this.frame_short = null;
       this.action_short = null;
    }
}
