package main;

import android.util.DisplayMetrics;
import javax.microedition.lcdui.CwaActivity;
import javax.microedition.media.Player;

/* loaded from: classes.dex */
public class Constants_H {
    public static final byte ABOUT_BUTTON = 4;
    public static final byte ABOUT_MENU = 5;
    public static final byte ACTION_ENEMY = 10;
    public static final byte ACTION_ENEMY_ALL = 11;
    public static final byte ACTION_ME = 12;
    public static final byte ACTION_ME_ALL = 13;
    public static final byte ACTION_N = 3;
    public static final byte ADD_EFFECT = -91;
    public static final byte AGILE_AUTO = 9;
    public static final byte ANIMATION_BATTLE = -1;
    public static final byte ANOLE = 21;
    public static final byte ANOLE_SEL = 20;
    public static final byte AUTO_RUN = 10;
    public static final byte AUTO_SAVE = 23;
    public static final byte AUTO_SAVE_1 = 24;
    public static final byte AUTO_SAVE_2 = 25;
    public static final byte A_DIR = 2;
    public static final byte A_DOOR_TYPE = 5;
    public static final byte A_IMAGE = 3;
    public static final byte A_IMAGE_NO = 2;
    public static final byte A_ITEM = 3;
    public static final byte A_ITEM_COUNT = 4;
    public static final byte A_ITEM_STATE = 2;
    public static final byte A_NEXT_E = 3;
    public static final byte A_NEXT_MAP = 4;
    public static final byte A_NPC_DIALOG_NO = 5;
    public static final byte A_NPC_SAVE = 9;
    public static final byte A_NPC_TYPE = 8;
    public static final byte A_X = 0;
    public static final byte A_Y = 1;
    public static final byte BAG_LOOK = 8;
    public static final byte BAG_P = 3;
    public static final byte BATTLE_DIALOG = -4;
    public static final byte BATTLE_EXP = -5;
    public static final byte BATTLE_FOREARM = 0;
    public static final byte BATTLE_HIT = -2;
    public static final byte BATTLE_NUM = 2;
    public static final byte BATTLE_OVER = -15;
    public static final byte BATTLE_STATE = -31;
    public static final String BATTLE_TXT_0 = "攻击";
    public static final String BATTLE_TXT_1 = "道具";
    public static final String BATTLE_TXT_10 = "需要的技能值不够！";
    public static final String BATTLE_TXT_11 = "被动技能无法使用!";
    public static final String BATTLE_TXT_12 = "敌人出现了，战斗吧！";
    public static final String BATTLE_TXT_13 = "考验的时刻来了，训练师！";
    public static final String BATTLE_TXT_14 = "尽情捕捉宠物吧！";
    public static final String BATTLE_TXT_15 = "忠诚度降低，攻击力下降，请及时补充！";
    public static final String BATTLE_TXT_16 = "要做什么？";
    public static final String BATTLE_TXT_17 = "可以进化了";
    public static final String BATTLE_TXT_18 = "忠诚度减少";
    public static final String BATTLE_TXT_2 = "宠物";
    public static final String BATTLE_TXT_3 = "商店";
    public static final String BATTLE_TXT_4 = "逃跑";
    public static final String BATTLE_TXT_5 = "宠物忠诚度为0，请立刻补充！";
    public static final String BATTLE_TXT_6 = "忠诚度过低，宠物不服从主人命令";
    public static final String BATTLE_TXT_7 = "捕获";
    public static final String BATTLE_TXT_8 = "已成功！";
    public static final String BATTLE_TXT_9 = "没有捕获到";
    public static final byte BG_H = 108;
    public static final byte BIKE = 1;
    public static final byte BLACK_SRC = 22;
    public static final int BLACK_WIDTH = 40;
    public static final byte BOAT = 2;
    public static final byte BOAT_RUN = 9;
    public static final byte BROW_NUM = 14;
    public static final byte BUFF_HIT = -3;
    public static final byte BUFF_M = 2;
    public static final byte BUY_ITEM = 18;
    public static final byte BUY_MAP = 22;
    public static final byte B_TYPE = 2;
    public static final byte B_TYPE_PVC = 4;
    public static final byte B_TYPE_PVC_0 = 3;
    public static final byte B_TYPE_PVP = 1;
    public static final byte B_TYPE_PVP_0 = 0;
    public static final byte CAN_NOT_PASS = 1;
    public static final byte CAN_PASS = 0;
    public static final byte CAN_PASS_LEFT = -1;
    public static final byte CAN_PASS_RIGHT = -2;
    public static final byte CATCH_MONSTER = -19;
    public static final byte CC_X = 88;
    public static final byte CELL_HEIGHT = 20;
    public static final byte CELL_WIDTH = 20;
    public static final byte CENTER_X = 46;
    public static final byte CENTER_Y = 29;
    public static final byte CHAR_LINE = 10;
    static byte COL_SELLS = 0;
    public static final byte COMPUTER_MONSTER = 45;
    public static final byte CONFIGURE_MENU = 7;
    public static final byte C_C_MONSTER = 6;
    public static final byte C_HEIGHT_1 = 19;
    public static final byte C_MY_MONSTER = 4;
    public static final byte C_WIDTH_1 = 19;
    public static final byte DONGA = 4;
    public static final byte DOOR = 8;
    public static final String EFFECT_TXT_0 = "石化效果无法行动，受到的伤害减少30%";
    public static final String EFFECT_TXT_1 = "昏睡效果，命中率下降50%";
    public static final String EFFECT_TXT_2 = "撕裂效果，减少当前血量的10%";
    public static final String EFFECT_TXT_3 = "魅惑效果，不能逃跑，增加捕获宠物的几率";
    public static final String EFFECT_TXT_4 = "禁锢效果，不能逃跑，不能换怪，不能使用道具";
    public static final String EFFECT_TXT_5 = "腐蚀效果，每回合受到一定伤害";
    public static final String EFFECT_TXT_6 = "封闭效果，不能使用4级以上技能";
    public static final String EFFECT_TXT_7 = "封闭效果，对幽暗鬼王不起作用";
    public static final byte ENEMY_BE_HIT = -87;
    public static final byte ENEMY_ESCAPE = -86;
    public static final byte ENEMY_SELECT = 1;
    public static final byte ENEMY_STATE_CHANGE = -89;
    public static final byte ENEMY_THROW = 7;
    public static final short ENEMY_X = 377;
    public static final byte ENEMY_Y = 97;
    public static final byte ENMON = 0;
    public static final byte EVOLVE_MAGIC = 31;
    public static final byte EXIT_BUTTON = 5;
    public static final byte EXPUP = 8;
    public static final byte FACE_DOWN = 2;
    public static final byte FACE_LEFT = 3;
    public static final byte FACE_RIGHT = 4;
    public static final byte FACE_UP = 1;
    public static final short FIRST_ROW = 170;
    public static final byte FLASH_STRING = 16;
    public static final byte FONT_H = 25;
    public static final byte FONT_HH = 12;
    public static final byte FONT_H_ = 25;
    public static final byte FONT_W = 25;
    public static final byte FONT_WH = 12;
    public static final byte FONT_W_ = 25;
    public static final byte FORSTER_NUM = 3;
    public static final byte FRAME_CHANGE_C = 0;
    public static final byte FRAME_MAX = 1;
    public static final byte FW = 19;
    public static final int GAME_ERROR = 9999;
    public static final byte GAME_EXIT = 101;
    public static final byte GAME_FLASH = 11;
    public static final byte GAME_INIT = 10;
    public static final byte GAME_LOAD = 0;
    public static final byte GAME_LOADING = 20;
    public static final byte GAME_MENU = 40;
    public static final byte GAME_OVER = 60;
    public static final byte GAME_PAUSE = 70;
    public static final byte GAME_RELEASE = 102;
    public static final byte GAME_RUN = 30;
    public static final String GAME_TXT_0 = "奖品列表";
    public static final String GAME_TXT_1 = "价格：";
    public static final String GAME_TXT_10 = "请选择道具：";
    public static final String GAME_TXT_11 = "不好意思，没有猜对。";
    public static final String GAME_TXT_12 = "需要的参加费：";
    public static final String GAME_TXT_13 = "在限定时间里接尽量多的球到框里，最后根据框里球的分数来换取金钱。";
    public static final String GAME_TXT_14 = "球的分数：";
    public static final String GAME_TXT_15 = "分数：";
    public static final String GAME_TXT_16 = "球总数：";
    public static final String GAME_TXT_17 = "游戏开始";
    public static final String GAME_TXT_18 = "可错次数：";
    public static final String GAME_TXT_19 = "次";
    public static final String GAME_TXT_2 = "所需金额：";
    public static final String GAME_TXT_20 = "游戏失败！！！";
    public static final String GAME_TXT_21 = "胜利次数：";
    public static final String GAME_TXT_22 = "请指出";
    public static final String GAME_TXT_23 = "所在箱子";
    public static final String GAME_TXT_24 = "您真厉害！";
    public static final String GAME_TXT_25 = "说不定下次就能行的。";
    public static final String GAME_TXT_26 = "选择你认为会得第一的一只宠物和押注的大小，注数越大获胜后的奖励越丰厚！";
    public static final String GAME_TXT_27 = "开始游戏#n离开游戏";
    public static final String GAME_TXT_28 = "点击屏幕继续";
    public static final String GAME_TXT_29 = "经验";
    public static final String GAME_TXT_3 = "一注：#n投入100金，#n获胜得120金。#n二注：#n投入300金，#n获胜得350金。#n三注：#n投入1000金，#n获胜得1200金。";
    public static final String GAME_TXT_30 = "宠物档次";
    public static final String GAME_TXT_31 = "兴奋度";
    public static final String GAME_TXT_4 = "请选择押注大小：";
    public static final String GAME_TXT_5 = "请选择押注的宠物：";
    public static final String GAME_TXT_6 = "每喂一个兴奋菇花费10金，可增加一格兴奋度。";
    public static final String GAME_TXT_7 = "游戏规则";
    public static final String GAME_TXT_8 = "一注100金#n二注300金#n三注1000金";
    public static final String GAME_TXT_9 = "兴奋度：";
    public static final byte GAME_WIN = 50;
    public static final byte GETKIND0 = 0;
    public static final byte GETKIND1 = 1;
    public static final byte GETKIND2 = 2;
    public static final byte GETKIND3 = 3;
    public static final byte GET_SELECT = 12;
    public static final byte GET_SELECT_NO = 14;
    public static final byte GET_SELECT_YES = 13;
    public static final byte GO_BATTLE = -30;
    public static final byte GO_NEXTMAP = 6;
    public static final byte GO_RUNINMAP = -11;
    public static final byte GRASS = 7;
    public static final int G_HCENTER_BOTTOM = 33;
    public static final int G_HCENTER_TOP = 17;
    public static final int G_HCENTER_VCENTER = 3;
    public static final int G_LEFT_BOTTOM = 36;
    public static final int G_LEFT_TOP = 20;
    public static final int G_LEFT_VCENTER = 6;
    public static final int G_RIGHT_BOTTOM = 40;
    public static final int G_RIGHT_TOP = 24;
    public static final int G_RIGHT_VCENTER = 10;
    static byte HALF_XCELLS = 0;
    static byte HALF_YCELLS = 0;
    public static final byte HATE = 10;
    public static final byte HATE_ = 3;
    public static final byte HCELL_HEIGHT = 10;
    public static final byte HCELL_WIDTH = 10;
    public static final byte HEAL_MAP = 16;
    public static final int HEIGHT_ = 360;
    public static int HEIGHT_H = 0;
    public static final int HEIGHT_H_ = 180;
    public static int HEIGHT__ = 0;
    public static final byte HELP_BUTTON = 3;
    public static final byte HELP_MENU = 4;
    public static final byte INCREASE = 4;
    public static final byte INCREASE_ = 2;
    public static final byte IN_BATTLE = -1;
    public static final byte IN_BATTLE_CHANGE = -2;
    public static final byte IN_MAP = 1;
    public static final byte IN_NIDUS = 2;
    public static final byte ITEM_COUNT = 1;
    public static final byte ITEM_EQUIP = 10;
    public static final byte ITEM_FOU = 12;
    public static final byte ITEM_ID = 0;
    public static final byte ITEM_MAX = 99;
    public static final byte ITEM_MENU = 5;
    public static final byte ITEM_RST = 16;
    public static final byte ITEM_SEC = 19;
    public static final byte ITEM_SET = 9;
    public static final byte ITEM_THR = 23;
    public static final String ITEM_TXT_0 = "道具";
    public static final String ITEM_TXT_1 = "辅助";
    public static final String ITEM_TXT_2 = "卷轴";
    public static final String ITEM_TXT_3 = "寄存宠物";
    public static final String ITEM_TXT_4 = "道具";
    public static final String ITEM_TXT_5 = "矿石";
    public static final String ITEM_TXT_6 = "徽章";
    public static final String ITEM_TXT_7 = "孵化";
    public static final byte ITEM_TYPE = 4;
    public static final byte KEY_TIME = 10;
    public static final String LEVEL_TXT_0 = "您当前的训练师等级已达到上限！";
    public static final String LEVEL_TXT_1 = "当前训练师等级为#7";
    public static final String LEVEL_TXT_10 = "#0，您商店能存放的宠物#7暴增到";
    public static final String LEVEL_TXT_2 = "#0距离下次升级还需要捕捉#7";
    public static final String LEVEL_TXT_3 = "#0只不同的宠物，努力获得新宠吧。";
    public static final String LEVEL_TXT_4 = "此次您没有捕获到全新的宠物，捕获并不是唯一途径，有些宠物需要通过进化才能获得哦。";
    public static final String LEVEL_TXT_5 = "此次您捕获了";
    public static final String LEVEL_TXT_6 = "个新宠物，这里是王国训练师机构奖励给您的";
    public static final String LEVEL_TXT_7 = "个徽章，希望再接再厉哦。";
    public static final String LEVEL_TXT_8 = "恭喜您的训练师等级已提升为#7";
    public static final String LEVEL_TXT_9 = "#0，您随身可携带宠物数量#7暴增到";
    public static final byte LINE_HEIGHT = 18;
    public static final byte LIST_INFO = 68;
    public static final byte LOAD_GAME = 0;
    public static final byte LOAD_MENU = 1;
    public static final int MAGIC_CLEAN = 170;
    public static final int MAGIC_LEN = 170;
    public static final byte MAIN_MENU = 0;
    public static final byte MAP_COUNT = 70;
    public static final byte MAP_NUM = 68;
    public static final byte MASTERY = 7;
    public static final byte MASTERY_ = 3;
    public static final byte MAX_LEVEL = 60;
    public static final byte MAX_MONSTERS = 95;
    public static final byte MAX_TAKES = 5;
    public static final byte MEET_DOOR = 5;
    public static final byte MEET_ITEM = 3;
    public static final byte MEET_MONSTER = 8;
    public static final byte MEET_NPC = 2;
    public static final byte MEET_ROAD = 4;
    public static final byte ME_STATE_CHANGE = -88;
    public static final byte MINI_BUY = 11;
    public static final byte MINI_GAME = 69;
    public static final byte MINI_MAP = 17;
    public static final byte MINI_NIDUS = 17;
    public static final byte MINI_SELL = 12;
    public static final byte MINI_SKILL = 13;
    public static final byte MISSION = 18;
    public static final String MISSION_TXT_0 = "主线任务";
    public static final String MISSION_TXT_1 = "分支任务";
    public static final String MISSION_TXT_2 = "#4主线任务#0已更新，点击#7工具包内的主线按钮#0可查看任务表。";
    public static final String MISSION_TXT_3 = "#4分支任务#0已更新，点击#7工具包内的支线按钮#0可查看任务表。";
    public static final String MISSION_TXT_4 = "主线完成度：";
    public static final String MISSION_TXT_5 = "分支完成度：";
    public static final String MISSION_TXT_6 = "完成";
    public static final byte MMAP_P = 6;
    public static final byte MMAP_PH = 3;
    public static final String MONEY_TXT_0 = "金";
    public static final String MONEY_TXT_1 = "徽章";
    public static final String MONEY_TXT_10 = "，是否卖出？";
    public static final String MONEY_TXT_11 = "获得徽章：";
    public static final String MONEY_TXT_12 = "这个宝箱是空的。";
    public static final String MONEY_TXT_13 = "失去：";
    public static final String MONEY_TXT_14 = "是否";
    public static final String MONEY_TXT_15 = "购买";
    public static final String MONEY_TXT_16 = "卖出";
    public static final String MONEY_TXT_17 = "现有：";
    public static final String MONEY_TXT_18 = "购买成功";
    public static final String MONEY_TXT_2 = "金钱不足！";
    public static final String MONEY_TXT_3 = "徽章不足！";
    public static final String MONEY_TXT_4 = "背包空间不足。";
    public static final String MONEY_TXT_5 = "数量已到上限";
    public static final String MONEY_TXT_6 = "需要：";
    public static final String MONEY_TXT_7 = "获得：";
    public static final String MONEY_TXT_8 = "数量：";
    public static final String MONEY_TXT_9 = "获得金钱：";
    public static final byte MONSTER_2_LEN = 8;
    public static final byte MONSTER_AGILE = 5;
    public static final byte MONSTER_APPEAR = -50;
    public static final byte MONSTER_ARRAY = 18;
    public static final byte MONSTER_BUFF = 16;
    public static final byte MONSTER_BUFF_1 = 17;
    public static final byte MONSTER_DEF = 7;
    public static final byte MONSTER_EVOLVE = 5;
    public static final byte MONSTER_EXP = 4;
    public static final byte MONSTER_FORCES = 6;
    public static final byte MONSTER_Fealty = 6;
    public static final byte MONSTER_HP = 0;
    public static final byte MONSTER_ID = 0;
    public static final byte MONSTER_INFO = 67;
    public static final byte MONSTER_KIND = 4;
    public static final byte MONSTER_LEVEL = 2;
    public static final byte MONSTER_LEVELUP = -32;
    public static final byte MONSTER_LEVEL_MAX = 60;
    public static final byte MONSTER_MAX_HP = 2;
    public static final byte MONSTER_MAX_MP = 3;
    public static final byte MONSTER_MENU = 4;
    public static final byte MONSTER_MP = 1;
    public static final byte MONSTER_NO = 1;
    public static final byte MONSTER_PRO = 3;
    public static final byte MONSTER_SKILL_ = 8;
    public static final byte MONSTER_SKILL_1 = 9;
    public static final byte MONSTER_SKILL_2 = 10;
    public static final byte MONSTER_SKILL_3 = 11;
    public static final byte MONSTER_SKILL_4 = 12;
    public static final byte MONSTER_SKILL_5 = 13;
    public static final byte MONSTER_SKILL_6 = 14;
    public static final byte MONSTER_SKILL_7 = 15;
    public static final short MONSTER_X = 248;
    public static final byte MONSTER_Y = 111;
    public static final byte MON_NUM = 102;
    public static final byte MOVE = 0;
    public static final byte MOVE_DOWN = 3;
    public static final byte MOVE_LEFT = 5;
    public static final byte MOVE_RIGHT = 5;
    public static final byte MOVE_SPEED10 = 10;
    public static final byte MOVE_SPEED12 = 12;
    public static final byte MOVE_SPEED20 = 20;
    public static final byte MOVE_SPEED5 = 5;
    public static final byte MOVE_SPEED6 = 6;
    public static final byte MOVE_SPEED7 = 7;
    public static final byte MOVE_SPEED8 = 8;
    public static final byte MOVE_UP = 4;
    public static final byte MYMON = 1;
    public static final byte MY_ATTACK = -85;
    public static final byte MY_BAG = 25;
    public static final byte MY_BATTLE = 15;
    public static final byte MY_EFFECT = -93;
    public static final byte MY_MAX = 1;
    public static final byte MY_SAVE = 19;
    public static final byte MY_SELECT = 2;
    public static final byte MY_THROW = 8;
    public static final byte MY_TRUNK = 27;
    public static final byte MY_TRUNK_1 = 26;
    public static final short MY_X = 266;
    public static final short MY_Y = 236;
    public static final byte M_HEIGHT = 19;
    public static final byte M_LENGTH = 8;
    public static final byte M_TYPE = 3;
    public static final byte M_WIDTH = 19;
    public static final String NAME_TXT_0 = "塞其";
    public static final String NAME_TXT_1 = "安琪儿";
    public static final String NAME_TXT_10 = "罗伯特";
    public static final String NAME_TXT_11 = "蓝发女孩";
    public static final String NAME_TXT_12 = "神秘东方男子";
    public static final String NAME_TXT_13 = "南宫云";
    public static final String NAME_TXT_2 = "幽暗鬼王";
    public static final String NAME_TXT_3 = "普罗校长";
    public static final String NAME_TXT_4 = "杰奇校长";
    public static final String NAME_TXT_5 = "普罗";
    public static final String NAME_TXT_6 = "道具阿姐";
    public static final String NAME_TXT_7 = "寄存阿妹";
    public static final String NAME_TXT_8 = "卷轴大叔";
    public static final String NAME_TXT_9 = "矿石大叔";
    public static final byte NEW_GAME_BUTTON = 1;
    public static final byte NEW_GAME_MENU = 2;
    public static final byte NIDUS_NUM = 5;
    public static final byte NO_MOVE = 0;
    public static final byte NPC0_COUNT = 100;
    public static final byte NPC1_COUNT = 5;
    public static final byte NPC2_COUNT = 60;
    public static final byte NPC_BOAT = 8;
    public static final byte NPC_TYPE_ = 0;
    public static final byte NPC_TYPE_DESTROY = 4;
    public static final byte NPC_TYPE_MOVE0 = 5;
    public static final byte NPC_TYPE_MOVE1 = 6;
    public static final byte NPC_TYPE_MOVE2 = 7;
    public static final byte NPC_TYPE_NIDUS = 1;
    public static final byte NPC_TYPE_SHADOW = 2;
    public static final byte NPC_TYPE_SHADOW0 = 3;
    public static final int OFF_HEIGHT_ = 380;
    public static final int OFF_WIDTH_ = 660;
    public static final byte OPTION_BUTTON = 2;
    public static final byte OVER = 100;
    public static final byte PAUSE = 99;
    public static final String PAUSE_TXT_0 = "保存游戏";
    public static final String PAUSE_TXT_1 = "查看宠物";
    public static final String PAUSE_TXT_10 = "关   于";
    public static final String PAUSE_TXT_11 = "退出游戏";
    public static final String PAUSE_TXT_12 = "普通技能";
    public static final String PAUSE_TXT_13 = "天赋技能";
    public static final String PAUSE_TXT_14 = "基本属性";
    public static final String PAUSE_TXT_15 = "进化素材";
    public static final String PAUSE_TXT_16 = "菜单";
    public static final String PAUSE_TXT_17 = "系统";
    public static final String PAUSE_TXT_18 = "是否存盘?";
    public static final String PAUSE_TXT_19 = "游戏暂停，点击屏幕返回。";
    public static final String PAUSE_TXT_2 = "人物背包";
    public static final String PAUSE_TXT_20 = "保存游戏中";
    public static final String PAUSE_TXT_21 = "点击屏幕跳过";
    public static final String PAUSE_TXT_22 = "是";
    public static final String PAUSE_TXT_23 = "否";
    public static final String PAUSE_TXT_24 = "查看任务";
    public static final String PAUSE_TXT_3 = "宠物图鉴";
    public static final String PAUSE_TXT_4 = "返回游戏";
    public static final String PAUSE_TXT_5 = "读取进度";
    public static final String PAUSE_TXT_6 = "声音";
    public static final String PAUSE_TXT_7 = "游戏帮助";
    public static final String PAUSE_TXT_8 = "回主菜单";
    public static final String PAUSE_TXT_9 = "新游戏";
    public static final byte POP_NIDUS = 16;
    public static final String POP_TXT_0 = "技能";
    public static final String POP_TXT_1 = "参战";
    public static final String POP_TXT_10 = "不回复";
    public static final String POP_TXT_11 = "回复";
    public static final String POP_TXT_12 = "继续";
    public static final String POP_TXT_13 = "放弃";
    public static final String POP_TXT_14 = "离开";
    public static final String POP_TXT_15 = "天赋";
    public static final String POP_TXT_16 = "选择蛋";
    public static final String POP_TXT_17 = "查看孵化";
    public static final String POP_TXT_18 = "孵化";
    public static final String POP_TXT_2 = "进化";
    public static final String POP_TXT_3 = "放生";
    public static final String POP_TXT_4 = "返回";
    public static final String POP_TXT_5 = "使用";
    public static final String POP_TXT_6 = "学习";
    public static final String POP_TXT_7 = "存放";
    public static final String POP_TXT_8 = "取出";
    public static final String POP_TXT_9 = "卖宠";
    public static final String PRO_TXT_0 = "生命";
    public static final String PRO_TXT_1 = "能量";
    public static final String PRO_TXT_2 = "档次";
    public static final String PRO_TXT_3 = "力量";
    public static final String PRO_TXT_4 = "防御";
    public static final String PRO_TXT_5 = "敏捷";
    public static final String PRO_TXT_7 = "被动";
    public static final byte P_BACK_MAP = 5;
    public static final byte P_INFO = 3;
    public static final byte P_ITEM = 2;
    public static final byte P_MISSION = 4;
    public static final byte P_SAVE = 0;
    public static final byte P_VIEW = 1;
    public static final byte RESIST = 4;
    public static final byte RESIST_ = 3;
    public static final byte RMS_AMON = 8;
    public static final byte RMS_EVENT_NOW = 12;
    public static final byte RMS_GAME = 2;
    public static final byte RMS_INFO = 6;
    public static final byte RMS_ITEM = 4;
    public static final byte RMS_MAP = 13;
    public static final byte RMS_MAPINFO = 14;
    public static final byte RMS_MAP_CHANGE = 1;
    public static final byte RMS_MISSION = 7;
    public static final byte RMS_MMON = 9;
    public static final String RMS_NAME = "pk5_caihong";
    public static final byte RMS_NIDUS = 3;
    public static final byte RMS_OTHER = 10;
    public static final byte RMS_SMS = 5;
    static byte ROW_CELLS = 0;
    public static final byte ROW_HIGHT = 18;
    public static final byte RUN_IN_MAP = -10;
    public static final byte RUN_LEVEL_UP = 20;
    public static final byte SAVEING = 100;
    public static final short SCREEN_Y = 252;
    public static final short SECOND_ROW = 188;
    public static final byte SEC_SKILL = 3;
    public static final byte SEE_MONSTER = 55;
    public static final byte SELECT_ACTION = -70;
    public static final byte SELECT_ITEM_USE = 14;
    public static final byte SELECT_MONSTER = 4;
    public static final byte SELECT_SKILL = -80;
    public static final byte SHOP_MENU = 6;
    public static final byte SHOWPAUSE = 98;
    public static final byte SHOW_STR = 11;
    public static final byte SKILL_ALL = 8;
    public static final byte SKILL_DAMAGE = 0;
    public static final byte SKILL_MENU = 3;
    public static final byte SKILL_MP = 1;
    public static final byte SKILL_PRO = 6;
    public static final byte SKILL_SET = 14;
    public static final byte SMS_LEVEL = -21;
    public static final byte SMS_PAUSE = -20;
    public static final String SMS_TXT_0 = "购买8000金#n购买80000金#n购买10徽章#n购买50徽章#n宠物升级#n购买神龟#n正版验证#n战斗复活#n短信商城";
    public static final byte SOUND_SET_MENU = 3;
    public static final int SRC_BATTLE_H;
    public static final int SRC_BATTLE_H_ = 196;
    public static final int SRC_BATTLE_H__;
    public static final byte STINGING = 3;
    public static final byte STONE = 5;
    public static final byte STOP_DOWN = 0;
    public static final byte STOP_LEFT = 2;
    public static final byte STOP_RIGHT = 2;
    public static final byte STOP_UP = 1;
    public static final byte SWIM = 3;
    public static final byte S_BACK_MENU = 3;
    public static final byte S_HELP = 2;
    public static final byte S_LOAD = 0;
    public static final byte S_SOUND = 1;
    public static final byte TAKE_ITEM = 5;
    public static final byte TALK = 1;
    public static final byte TALK_BATTLE = -40;
    public static final byte TALK_LINE = 2;
    public static final int TEXT_Y = 170;
    public static final byte THE_MIN = -100;
    public static final byte THE_NPC = 9;
    public static final byte TIME_PER_FRAME = 60;
    public static final byte TISHI_MENU = 6;
    public static final String TXT_0 = "已经死亡，无法使用！";
    public static final String TXT_1 = "不需要使用这个道具";
    public static final String TXT_10 = "习得技能：";
    public static final String TXT_100 = "材料不足，不能孵化";
    public static final String TXT_101 = "孵化所需材料";
    public static final String TXT_102 = "按确定键完成孵化";
    public static final String TXT_103 = "，不能通过该地形";
    public static final String TXT_104 = "宠物图鉴已更新";
    public static final String TXT_105 = "宠物空间已满，无法获得新的宠物，请整理寄存所空出一个空间。";
    public static final String TXT_106 = "经验已满，可以孵化了。";
    public static final String TXT_107 = "奇异兽不仅跑得快而且可以不遇敌，现提供试骑体验，正版验证后需购买！";
    public static final String TXT_11 = "获得经验：";
    static final String TXT_111 = "携带的宠物全都牺牲了!";
    public static final String TXT_12 = "您的宠物已经无法获得经验";
    public static final String TXT_13 = "身上必须携带一只能参战的宠物！";
    public static final String TXT_14 = "失去宠物：";
    public static final String TXT_15 = "可进化";
    public static final String TXT_16 = "次";
    public static final String TXT_17 = "确定进化该宠物？";
    public static final String TXT_18 = "材料不足，不能进化！";
    public static final String TXT_19 = "进化成  ";
    public static final String TXT_2 = "没有异常！";
    public static final String TXT_20 = "未知宠物";
    public static final String TXT_21 = "发现地点";
    public static final String TXT_22 = "进";
    public static final String TXT_23 = "化";
    public static final String TXT_24 = "材料：";
    public static final String TXT_25 = "未知";
    public static final String TXT_26 = "已捕获";
    public static final String TXT_27 = "未捕获";
    public static final String TXT_28 = "发现度 ";
    public static final String TXT_29 = "捕捉种类 ";
    public static final String TXT_3 = "忠诚度已满";
    public static final String TXT_30 = "恭喜您把所有的宠物都收集齐了";
    public static final String TXT_31 = "是否保存游戏?";
    public static final String TXT_32 = "是否读取进度?";
    public static final String TXT_33 = "之前未保存的部分将会丢失，是否继续？";
    public static final String TXT_34 = "无法逃跑！";
    public static final String TXT_35 = "逃跑失败！";
    public static final String TXT_36 = "被怪物";
    public static final String TXT_37 = "禁锢中";
    public static final String TXT_38 = "的电眼魅惑了";
    public static final String TXT_39 = "特殊情况，无法捕获！";
    public static final String TXT_4 = "没有死亡！";
    public static final String TXT_40 = "无法使用道具！";
    public static final String TXT_41 = "无法更换宠物！";
    public static final String TXT_42 = "沉睡之歌效果，怪物强制换场！";
    public static final String TXT_43 = "所能携带的宠物已经达到上限！";
    public static final String TXT_44 = "号学习技能";
    public static final String TXT_45 = "已拥有该技能";
    public static final String TXT_46 = "该技能不能替换！";
    public static final String TXT_47 = "放生的宠物将会消失，是否继续？";
    public static final String TXT_48 = "宠物空间已满";
    public static final String TXT_49 = "获得宠物：";
    public static final String TXT_5 = "当前宠物不能参战";
    public static final String TXT_50 = "携带已满，";
    public static final String TXT_51 = "已转入寄放处";
    public static final String TXT_52 = "您携带的宠物已回复。";
    public static final String TXT_53 = "回复需要金钱";
    public static final String TXT_54 = "是否回复所有宠物？";
    public static final String TXT_55 = "流着泪逃跑了！";
    public static final String TXT_56 = "拼了命的逃跑了！";
    public static final String TXT_57 = "盯了你一眼，逃走了！";
    public static final String TXT_58 = "道具不足！";
    public static final String TXT_59 = "战斗失败了,训练师的梦想不能实现了!";
    public static final String TXT_6 = "目前没有怪兽";
    public static final String TXT_60 = "你要继续游戏，确定吗？";
    public static final String TXT_61 = "获得了";
    public static final String TXT_62 = "已拥有";
    public static final String TXT_63 = "躲避怪物效果";
    public static final String TXT_64 = "等级没有达到15级，不能进化！";
    public static final String TXT_65 = "等级没有达到25级，不能进化！";
    public static final String TXT_66 = "等级没有达到30级，不能进化！";
    public static final String TXT_67 = "是否保存进度？";
    public static final String TXT_68 = "这将清除您之前的所有记录，是否继续？";
    public static final String TXT_69 = "是否打开音乐?";
    public static final String TXT_7 = "闪避";
    public static final String TXT_70 = "需要训练师";
    public static final String TXT_71 = "级才能学习！";
    public static final String TXT_72 = "存储空间不足！";
    public static final String TXT_73 = "金属克野兽，野兽克植物，植物克飞行，飞行克海洋，海洋克金属";
    public static final String TXT_74 = "训练师等级：";
    public static final String TXT_75 = "没有";
    public static final String TXT_76 = "钥匙，钥匙在商店中可以购买。";
    public static final String TXT_77 = "宝箱，宝箱在战斗后一定几率获得。";
    public static final String TXT_78 = "游戏地图";
    public static final String TXT_79 = "该区域没有地图！";
    public static final String TXT_8 = "升到了";
    public static final String TXT_80 = "人物当前位置：";
    public static final String TXT_81 = "保存进度完成";
    public static final String TXT_82 = "坐骑";
    public static final String TXT_83 = "9:骑乘";
    public static final String TXT_84 = "不可进化";
    public static final String TXT_85 = "捕获";
    public static final String TXT_86 = "任务";
    public static final String TXT_87 = "进化";
    public static final String TXT_88 = "异化";
    public static final String TXT_89 = "竞技场";
    public static final String TXT_9 = "级";
    public static final String TXT_90 = "（关闭声音游戏更流畅）";
    public static final String TXT_91 = "不能更换坐骑";
    public static final String TXT_92 = "下坐骑#n植物坐骑#n金属坐骑#n飞行坐骑#n野兽坐骑#n海洋坐骑#n无此坐骑";
    public static final String TXT_93 = "还没有获得该骑宠";
    public static final String TXT_94 = "只能在水里使用";
    public static final String TXT_95 = "此位置目前是空的";
    public static final String TXT_96 = "的宠物蛋";
    public static final String TXT_97 = "孵化中...";
    public static final String TXT_98 = "孵化已完成";
    public static final String TXT_99 = "孵化所已经没有空位了";
    public static final byte TYPE_CARPET = 0;
    public static final byte TYPE_ROAD = 1;
    public static final byte TYPE_SIFANG = 2;
    public static final byte USE_ITEM = 15;
    public static final byte VIEW_COMPUTER = 65;
    public static final byte VIEW_HELP = 7;
    public static final byte VIEW_MONSTER = 35;
    public static final byte VIEW_NIDUS = 66;
    public static final byte WALK = 0;
    public static final byte WATER = 2;
    public static final int WIDTH_ = 640;
    public static int WIDTH_H = 0;
    public static final int WIDTH_H_ = 320;
    public static int WIDTH__ = 0;
    static byte XCELLS = 0;
    static byte YCELLS = 0;
    public static final byte YOUPAUSE = 97;
    public static final byte _ACTION = 7;
    public static final byte _BROW = 6;
    public static final byte _SHOW = 4;
    public static final byte sellPrice = 10;

    /* renamed from: 万能药, reason: contains not printable characters */
    public static final byte f0 = 8;

    /* renamed from: 五彩果实, reason: contains not printable characters */
    public static final byte f1 = 27;

    /* renamed from: 亲和天使, reason: contains not printable characters */
    public static final byte f2 = 41;

    /* renamed from: 健壮体魄, reason: contains not printable characters */
    public static final byte f3 = 2;

    /* renamed from: 兴奋菇, reason: contains not printable characters */
    public static final byte f4 = 12;

    /* renamed from: 兽魂, reason: contains not printable characters */
    public static final byte f5 = 17;

    /* renamed from: 军心涣散, reason: contains not printable characters */
    public static final byte f6 = 26;

    /* renamed from: 初级治疗, reason: contains not printable characters */
    public static final byte f7 = 27;

    /* renamed from: 动作攻击, reason: contains not printable characters */
    public static final byte f8 = 1;

    /* renamed from: 动作死亡, reason: contains not printable characters */
    public static final byte f9 = 2;

    /* renamed from: 动作站立, reason: contains not printable characters */
    public static final byte f10 = 0;

    /* renamed from: 卖出, reason: contains not printable characters */
    public static final byte f11 = 4;

    /* renamed from: 古鲸之心, reason: contains not printable characters */
    public static final byte f12 = 29;

    /* renamed from: 和谐攻击, reason: contains not printable characters */
    public static final byte f13 = 9;

    /* renamed from: 噬魂, reason: contains not printable characters */
    public static final byte f14 = 20;

    /* renamed from: 圣灵宽恕, reason: contains not printable characters */
    public static final byte f15 = 13;

    /* renamed from: 地狱之火, reason: contains not printable characters */
    public static final byte f16 = 22;

    /* renamed from: 坐船, reason: contains not printable characters */
    public static final byte f17 = 5;

    /* renamed from: 坚韧石, reason: contains not printable characters */
    public static final byte f18 = 16;

    /* renamed from: 大师球, reason: contains not printable characters */
    public static final byte f19 = 11;

    /* renamed from: 大海意志, reason: contains not printable characters */
    public static final byte f20 = 47;

    /* renamed from: 天怒, reason: contains not printable characters */
    public static final byte f21 = 14;

    /* renamed from: 天空意志, reason: contains not printable characters */
    public static final byte f22 = 45;

    /* renamed from: 天羽, reason: contains not printable characters */
    public static final byte f23 = 23;

    /* renamed from: 学习技能, reason: contains not printable characters */
    public static final byte f24 = 35;

    /* renamed from: 宝箱, reason: contains not printable characters */
    public static final byte f25 = 32;

    /* renamed from: 宠物的蛋, reason: contains not printable characters */
    public static final byte f26 = 3;

    /* renamed from: 宠物蛋, reason: contains not printable characters */
    public static final byte f27 = 58;

    /* renamed from: 封印球, reason: contains not printable characters */
    public static final byte f28 = 9;

    /* renamed from: 封闭技能, reason: contains not printable characters */
    public static final byte f29 = 30;

    /* renamed from: 封闭效果, reason: contains not printable characters */
    public static final byte f30 = 6;

    /* renamed from: 尖牙利齿, reason: contains not printable characters */
    public static final byte f31 = 32;

    /* renamed from: 巧克力, reason: contains not printable characters */
    public static final byte f32 = 2;

    /* renamed from: 幸运之星, reason: contains not printable characters */
    public static final byte f33 = 39;

    /* renamed from: 异化材料, reason: contains not printable characters */
    public static final byte f34 = 34;

    /* renamed from: 忠诚伙伴, reason: contains not printable characters */
    public static final byte f35 = 40;

    /* renamed from: 怒意狂暴, reason: contains not printable characters */
    public static final byte f36 = 17;

    /* renamed from: 意志坚定, reason: contains not printable characters */
    public static final byte f37 = 8;

    /* renamed from: 意志涣散, reason: contains not printable characters */
    public static final byte f38 = 7;

    /* renamed from: 战斗店, reason: contains not printable characters */
    public static final byte f39 = 0;

    /* renamed from: 战斗道具, reason: contains not printable characters */
    public static final byte f40 = 0;

    /* renamed from: 扑咬, reason: contains not printable characters */
    public static final byte f41 = 15;

    /* renamed from: 技能卷轴, reason: contains not printable characters */
    public static final byte f42 = 2;

    /* renamed from: 撕裂击, reason: contains not printable characters */
    public static final byte f43 = 16;

    /* renamed from: 撕裂效果, reason: contains not printable characters */
    public static final byte f44 = 2;

    /* renamed from: 无效果, reason: contains not printable characters */
    public static final byte f45 = 7;

    /* renamed from: 昏睡效果, reason: contains not printable characters */
    public static final byte f46 = 1;

    /* renamed from: 普通攻击, reason: contains not printable characters */
    public static final byte f47 = 25;

    /* renamed from: 暴风旋阵, reason: contains not printable characters */
    public static final byte f48 = 11;

    /* renamed from: 替身木偶, reason: contains not printable characters */
    public static final byte f49 = 48;

    /* renamed from: 朱果, reason: contains not printable characters */
    public static final byte f50 = 19;

    /* renamed from: 枯黄枝叶, reason: contains not printable characters */
    public static final byte f51 = 3;

    /* renamed from: 树瘴石, reason: contains not printable characters */
    public static final byte f52 = 18;

    /* renamed from: 树神之怒, reason: contains not printable characters */
    public static final byte f53 = 4;

    /* renamed from: 植物, reason: contains not printable characters */
    public static final byte f54 = 0;

    /* renamed from: 死亡之触, reason: contains not printable characters */
    public static final byte f55 = 29;

    /* renamed from: 残忍攻击, reason: contains not printable characters */
    public static final byte f56 = 10;

    /* renamed from: 毒液攻击, reason: contains not printable characters */
    public static final byte f57 = 31;

    /* renamed from: 水泡, reason: contains not printable characters */
    public static final byte f58 = 20;

    /* renamed from: 没有天赋, reason: contains not printable characters */
    public static final byte f59 = 0;

    /* renamed from: 浑浊水质, reason: contains not printable characters */
    public static final byte f60 = 11;

    /* renamed from: 海洋, reason: contains not printable characters */
    public static final byte f61 = 4;

    /* renamed from: 深海珊瑚, reason: contains not printable characters */
    public static final byte f62 = 21;

    /* renamed from: 熊之铠甲, reason: contains not printable characters */
    public static final byte f63 = 26;

    /* renamed from: 特殊, reason: contains not printable characters */
    public static final byte f64 = 5;

    /* renamed from: 狂暴嘶吼, reason: contains not printable characters */
    public static final byte f65 = 19;

    /* renamed from: 猛砸, reason: contains not printable characters */
    public static final byte f66 = 5;

    /* renamed from: 生命石, reason: contains not printable characters */
    public static final byte f67 = 7;

    /* renamed from: 疾风速降, reason: contains not printable characters */
    public static final byte f68 = 12;

    /* renamed from: 白金, reason: contains not printable characters */
    public static final byte f69 = 25;

    /* renamed from: 石化效果, reason: contains not printable characters */
    public static final byte f70 = 0;

    /* renamed from: 破碎外壳, reason: contains not printable characters */
    public static final byte f71 = 5;

    /* renamed from: 禁锢效果, reason: contains not printable characters */
    public static final byte f72 = 4;

    /* renamed from: 离空石, reason: contains not printable characters */
    public static final byte f73 = 22;

    /* renamed from: 粉碎螺旋, reason: contains not printable characters */
    public static final byte f74 = 8;

    /* renamed from: 精原石, reason: contains not printable characters */
    public static final byte f75 = 24;

    /* renamed from: 精神攻击, reason: contains not printable characters */
    public static final byte f76 = 34;

    /* renamed from: 纯净水质, reason: contains not printable characters */
    public static final byte f77 = 12;

    /* renamed from: 经验丰富, reason: contains not printable characters */
    public static final byte f78 = 37;

    /* renamed from: 经验多多, reason: contains not printable characters */
    public static final byte f79 = 36;

    /* renamed from: 缠绕, reason: contains not printable characters */
    public static final byte f80 = 0;

    /* renamed from: 聚能石, reason: contains not printable characters */
    public static final byte f81 = 4;

    /* renamed from: 肆虐冲锋, reason: contains not printable characters */
    public static final byte f82 = 18;

    /* renamed from: 能量壁垒, reason: contains not printable characters */
    public static final byte f83 = 35;

    /* renamed from: 能量石, reason: contains not printable characters */
    public static final byte f84 = 3;

    /* renamed from: 腐蚀效果, reason: contains not printable characters */
    public static final byte f85 = 5;

    /* renamed from: 自然康复, reason: contains not printable characters */
    public static final byte f86 = 4;

    /* renamed from: 自然风暴, reason: contains not printable characters */
    public static final byte f87 = 3;

    /* renamed from: 花粉纷飞, reason: contains not printable characters */
    public static final byte f88 = 1;

    /* renamed from: 花草意志, reason: contains not printable characters */
    public static final byte f89 = 43;

    /* renamed from: 荆棘陷阱, reason: contains not printable characters */
    public static final byte f90 = 2;

    /* renamed from: 虎之气概, reason: contains not printable characters */
    public static final byte f91 = 30;

    /* renamed from: 虚弱体魄, reason: contains not printable characters */
    public static final byte f92 = 1;

    /* renamed from: 蜜心糖, reason: contains not printable characters */
    public static final byte f93 = 13;

    /* renamed from: 训练店, reason: contains not printable characters */
    public static final byte f94 = 2;

    /* renamed from: 辅助店, reason: contains not printable characters */
    public static final byte f95 = 1;

    /* renamed from: 辅助道具, reason: contains not printable characters */
    public static final byte f96 = 1;

    /* renamed from: 逃命专家, reason: contains not printable characters */
    public static final byte f97 = 42;

    /* renamed from: 避怪丸, reason: contains not printable characters */
    public static final byte f98 = 14;

    /* renamed from: 重生之心, reason: contains not printable characters */
    public static final byte f99 = 38;

    /* renamed from: 野兽, reason: contains not printable characters */
    public static final byte f100 = 3;

    /* renamed from: 野兽意志, reason: contains not printable characters */
    public static final byte f101 = 44;

    /* renamed from: 金之辉耀, reason: contains not printable characters */
    public static final byte f102 = 31;

    /* renamed from: 金属, reason: contains not printable characters */
    public static final byte f103 = 1;

    /* renamed from: 金属外壳, reason: contains not printable characters */
    public static final byte f104 = 6;

    /* renamed from: 金属意志, reason: contains not printable characters */
    public static final byte f105 = 46;

    /* renamed from: 钢筋铁骨, reason: contains not printable characters */
    public static final byte f106 = 33;

    /* renamed from: 钥匙, reason: contains not printable characters */
    public static final byte f107 = 33;

    /* renamed from: 铁水浇灌, reason: contains not printable characters */
    public static final byte f108 = 7;

    /* renamed from: 铁浮屠, reason: contains not printable characters */
    public static final byte f109 = 6;

    /* renamed from: 银杏果, reason: contains not printable characters */
    public static final byte f110 = 5;

    /* renamed from: 随身店, reason: contains not printable characters */
    public static final byte f111 = 3;

    /* renamed from: 霸皇战意, reason: contains not printable characters */
    public static final byte f112 = 9;

    /* renamed from: 飞翔斩, reason: contains not printable characters */
    public static final byte f113 = 10;

    /* renamed from: 飞行, reason: contains not printable characters */
    public static final byte f114 = 2;

    /* renamed from: 饮料, reason: contains not printable characters */
    public static final byte f115 = 0;

    /* renamed from: 饼干, reason: contains not printable characters */
    public static final byte f116 = 1;

    /* renamed from: 香水, reason: contains not printable characters */
    public static final byte f117 = 15;

    /* renamed from: 骑宠无, reason: contains not printable characters */
    public static final byte f118 = -1;

    /* renamed from: 骑宠植物, reason: contains not printable characters */
    public static final byte f119 = 0;

    /* renamed from: 骑宠水生, reason: contains not printable characters */
    public static final byte f120 = 4;

    /* renamed from: 骑宠野兽, reason: contains not printable characters */
    public static final byte f121 = 3;

    /* renamed from: 骑宠金属, reason: contains not printable characters */
    public static final byte f122 = 1;

    /* renamed from: 骑宠飞行, reason: contains not printable characters */
    public static final byte f123 = 2;

    /* renamed from: 高级治疗, reason: contains not printable characters */
    public static final byte f124 = 28;

    /* renamed from: 高级球, reason: contains not printable characters */
    public static final byte f125 = 10;

    /* renamed from: 魅惑效果, reason: contains not printable characters */
    public static final byte f126 = 3;

    /* renamed from: 黄金果实, reason: contains not printable characters */
    public static final byte f127 = 28;

    /* renamed from: 黄金糖, reason: contains not printable characters */
    public static final byte f128 = 6;

    /* renamed from: 黯之罪罚, reason: contains not printable characters */
    public static final byte f129 = 23;

    /* renamed from: 黯灭波, reason: contains not printable characters */
    public static final byte f130 = 21;

    /* renamed from: 黯魔素身, reason: contains not printable characters */
    public static final byte f131 = 24;
    public static int WIDTH = Player.STARTED;
    public static int HEIGHT = 240;
    public static final short SCREEN_X = (short) WIDTH;
    public static final int OFF_WIDTH = WIDTH + 20;
    public static final int OFF_HEIGHT = HEIGHT + 20;

    static {
        WIDTH__ = 533;
        HEIGHT__ = WIDTH_H_;
        WIDTH_H = WIDTH >> 1;
        HEIGHT_H = HEIGHT >> 1;
        SRC_BATTLE_H = HEIGHT_H + 16;
        SRC_BATTLE_H__ = (HEIGHT__ / 2) + 16;
        XCELLS = (byte) (WIDTH / 20);
        YCELLS = (byte) (HEIGHT / 20);
        HALF_XCELLS = (byte) (XCELLS >> 1);
        HALF_YCELLS = (byte) (YCELLS >> 1);
        ROW_CELLS = (byte) (XCELLS + 1);
        COL_SELLS = (byte) (YCELLS + 1);
        DisplayMetrics dm2 = new DisplayMetrics();
        CwaActivity.getInstance().getWindowManager().getDefaultDisplay().getMetrics(dm2);
        WIDTH__ = dm2.widthPixels;
        HEIGHT__ = dm2.heightPixels;
        WIDTH_H = WIDTH >> 1;
        HEIGHT_H = HEIGHT >> 1;
        XCELLS = (byte) (WIDTH / 20);
        YCELLS = (byte) (HEIGHT / 20);
        HALF_XCELLS = (byte) (XCELLS >> 1);
        HALF_YCELLS = (byte) (YCELLS >> 1);
        ROW_CELLS = (byte) (XCELLS + 1);
        COL_SELLS = (byte) (YCELLS + 1);
    }
}
