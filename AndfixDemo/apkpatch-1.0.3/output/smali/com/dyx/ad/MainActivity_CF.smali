.class public Lcom/dyx/ad/MainActivity_CF;
.super Landroid/support/v7/app/AppCompatActivity;
.source "MainActivity.java"


# static fields
.field private static final FILE_END:Ljava/lang/String; = ".apatch"


# instance fields
.field btnAddBug:Landroid/widget/Button;
    .annotation build Lbutterknife/BindView;
        value = 0x7f0b005e
    .end annotation
.end field

.field btnFixBug:Landroid/widget/Button;
    .annotation build Lbutterknife/BindView;
        value = 0x7f0b005f
    .end annotation
.end field

.field private mPatchDir:Ljava/lang/String;

.field private mUnbinder:Lbutterknife/Unbinder;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 21
    invoke-direct {p0}, Landroid/support/v7/app/AppCompatActivity;-><init>()V

    return-void
.end method

.method private getPatchPath()Ljava/lang/String;
    .locals 2

    .prologue
    .line 84
    iget-object v0, p0, Lcom/dyx/ad/MainActivity_CF;->mPatchDir:Ljava/lang/String;

    const-string v1, "andfix"

    invoke-virtual {v0, v1}, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    const-string v1, ".apatch"

    invoke-virtual {v0, v1}, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private handleAddBug()V
    .locals 2
    .annotation runtime Lcom/alipay/euler/andfix/annotation/MethodReplace;
        clazz = "com.dyx.ad.MainActivity"
        method = "handleAddBug"
    .end annotation

    .prologue
    .line 100
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 101
    .local v0, "datas":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    const-string v1, "a"

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 102
    const/4 v1, 0x0

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    invoke-static {v1}, Lcom/orhanobut/logger/Logger;->d(Ljava/lang/Object;)V

    .line 103
    return-void
.end method

.method private handleFixBug()V
    .locals 3

    .prologue
    .line 72
    :try_start_0
    invoke-static {}, Lcom/dyx/ad/andfix/AndfixPatchManager;->getInstance()Lcom/dyx/ad/andfix/AndfixPatchManager;

    move-result-object v1

    invoke-direct {p0}, Lcom/dyx/ad/MainActivity_CF;->getPatchPath()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/dyx/ad/andfix/AndfixPatchManager;->addAndfixPatch(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 76
    :goto_0
    return-void

    .line 73
    :catch_0
    move-exception v0

    .line 74
    .local v0, "e":Ljava/io/IOException;
    invoke-virtual {v0}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_0
.end method

.method private initData()V
    .locals 3

    .prologue
    .line 45
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p0}, Lcom/dyx/ad/MainActivity_CF;->getExternalCacheDir()Ljava/io/File;

    move-result-object v2

    invoke-virtual {v2}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "/apatch/"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/dyx/ad/MainActivity_CF;->mPatchDir:Ljava/lang/String;

    .line 46
    new-instance v0, Ljava/io/File;

    iget-object v1, p0, Lcom/dyx/ad/MainActivity_CF;->mPatchDir:Ljava/lang/String;

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 47
    .local v0, "mFile":Ljava/io/File;
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 48
    :cond_0
    invoke-virtual {v0}, Ljava/io/File;->mkdir()Z

    .line 50
    :cond_1
    return-void
.end method


# virtual methods
.method protected onCreate(Landroid/os/Bundle;)V
    .locals 1
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 38
    invoke-super {p0, p1}, Landroid/support/v7/app/AppCompatActivity;->onCreate(Landroid/os/Bundle;)V

    .line 39
    const v0, 0x7f04001b

    invoke-virtual {p0, v0}, Lcom/dyx/ad/MainActivity_CF;->setContentView(I)V

    .line 40
    invoke-static {p0}, Lbutterknife/ButterKnife;->bind(Landroid/app/Activity;)Lbutterknife/Unbinder;

    move-result-object v0

    iput-object v0, p0, Lcom/dyx/ad/MainActivity_CF;->mUnbinder:Lbutterknife/Unbinder;

    .line 41
    invoke-direct {p0}, Lcom/dyx/ad/MainActivity_CF;->initData()V

    .line 42
    return-void
.end method

.method protected onDestroy()V
    .locals 1

    .prologue
    .line 54
    invoke-super {p0}, Landroid/support/v7/app/AppCompatActivity;->onDestroy()V

    .line 55
    iget-object v0, p0, Lcom/dyx/ad/MainActivity_CF;->mUnbinder:Lbutterknife/Unbinder;

    invoke-interface {v0}, Lbutterknife/Unbinder;->unbind()V

    .line 56
    return-void
.end method

.method public onViewClicked(Landroid/view/View;)V
    .locals 1
    .param p1, "view"    # Landroid/view/View;
    .annotation build Lbutterknife/OnClick;
        value = {
            0x7f0b005e,
            0x7f0b005f
        }
    .end annotation

    .prologue
    .line 60
    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v0

    packed-switch v0, :pswitch_data_0

    .line 68
    :goto_0
    return-void

    .line 62
    :pswitch_0
    invoke-direct {p0}, Lcom/dyx/ad/MainActivity_CF;->handleAddBug()V

    goto :goto_0

    .line 65
    :pswitch_1
    invoke-direct {p0}, Lcom/dyx/ad/MainActivity_CF;->handleFixBug()V

    goto :goto_0

    .line 60
    :pswitch_data_0
    .packed-switch 0x7f0b005e
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method
