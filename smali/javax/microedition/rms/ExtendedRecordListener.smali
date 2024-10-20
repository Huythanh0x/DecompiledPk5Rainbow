.class public interface abstract Ljavax/microedition/rms/ExtendedRecordListener;
.super Ljava/lang/Object;
.implements Ljavax/microedition/rms/RecordListener;
.source "ExtendedRecordListener.java"

.field public final static RECORDSTORE_CLOSE:I = 9

.field public final static RECORDSTORE_DELETE:I = 10

.field public final static RECORDSTORE_OPEN:I = 8

.field public final static RECORD_ADD:I = 1

.field public final static RECORD_CHANGE:I = 3

.field public final static RECORD_DELETE:I = 4

.field public final static RECORD_READ:I = 2

.method public abstract recordEvent(IJLjavax/microedition/rms/RecordStore;I)V
.end method

.method public abstract recordStoreEvent(IJLjava/lang/String;)V
.end method
