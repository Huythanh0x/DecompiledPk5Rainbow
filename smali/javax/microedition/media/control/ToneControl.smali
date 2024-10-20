.class public Ljavax/microedition/media/control/ToneControl;
.super Ljava/lang/Object;
.source "ToneControl.java"

# interfaces
.implements Ljavax/microedition/media/Control;


# static fields
.field public static BLOCK_END:B

.field public static BLOCK_START:B

.field public static C4:B

.field public static PLAY_BLOCK:B

.field public static REPEAT:B

.field public static RESOLUTION:B

.field public static SET_VOLUME:B

.field public static SILENCE:B

.field public static TEMPO:B

.field public static VERSION:B


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 10
    const/4 v0, -0x6

    sput-byte v0, Ljavax/microedition/media/control/ToneControl;->BLOCK_END:B

    .line 11
    const/4 v0, -0x5

    sput-byte v0, Ljavax/microedition/media/control/ToneControl;->BLOCK_START:B

    .line 12
    const/16 v0, 0x3c

    sput-byte v0, Ljavax/microedition/media/control/ToneControl;->C4:B

    .line 13
    const/4 v0, -0x7

    sput-byte v0, Ljavax/microedition/media/control/ToneControl;->PLAY_BLOCK:B

    .line 14
    const/16 v0, -0x9

    sput-byte v0, Ljavax/microedition/media/control/ToneControl;->REPEAT:B

    .line 15
    const/4 v0, -0x4

    sput-byte v0, Ljavax/microedition/media/control/ToneControl;->RESOLUTION:B

    .line 16
    const/4 v0, -0x8

    sput-byte v0, Ljavax/microedition/media/control/ToneControl;->SET_VOLUME:B

    .line 17
    const/4 v0, -0x1

    sput-byte v0, Ljavax/microedition/media/control/ToneControl;->SILENCE:B

    .line 18
    const/4 v0, -0x3

    sput-byte v0, Ljavax/microedition/media/control/ToneControl;->TEMPO:B

    .line 19
    const/4 v0, -0x2

    sput-byte v0, Ljavax/microedition/media/control/ToneControl;->VERSION:B

    .line 8
    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 8
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
