参考：https://original-game.com/java-janken-game-program/#m_heading-13<br/>
【絶対できる！】Javaでのじゃんけんゲームの作り方<br/>

## $\textcolor{green}{じゃんけんゲーム実行exeファイル}$
参考：<br/>
<a href="https://github.com/RobotWork01/JAVA-_exe/releases/download/1.0.0/JankenGame.exe">じゃんけんゲーム </a>


リンク：<br/>
<a href="https://github.com/RobotWork01/JAVA-_exe/blob/main/JankenGame.exe">https://github.com/RobotWork01/JAVA-_exe/blob/main/JankenGame.exe</a>

## $\textcolor{green}{EclipseをインストールしてJavaの開発環境を整えよう}$
参考：<br/>
<a href="https://tenshoku.mynavi.jp/engineer/guide/articles/Zw4ZcBEAAB8AaS2L">https://tenshoku.mynavi.jp/engineer/guide/articles/Zw4ZcBEAAB8AaS2L</a><br/>
<a href="https://qiita.com/iiko/items/04060864e1560c0a473a">https://qiita.com/iiko/items/04060864e1560c0a473a</a><br/>

## $\textcolor{green}{オールインワンの最新版をダウンロードする。（日本語化した環境）}$
参考：<br/>
<a href="https://willbrains.jp/index.html#/pleiades_distros2025.html">https://willbrains.jp/index.html#/pleiades_distros2025.html</a></br>

## $\textcolor{green}{render.comアカウントの作り方（JAVA実行環境）}$
参考：<br/>
<a href="https://monomonotech.jp/kurage/memo/m250715_render_get_started">https://monomonotech.jp/kurage/memo/m250715_render_get_started</a></br>

## $\textcolor{green}{＜開発時のJAVA実行方法＞}$
javaw -Dfile.encoding=UTF-8  original_game.com.Main

## $\textcolor{green}{JAVAがインストールされているかどうかの確認}$
echo %JAVA_HOME%
```
C:\Program Files\Java\jdk-14.0.2
```

＜確認手順＞
```
もしもJAVAが既にインストールされていると環境変数%JAVA_HOME%が作成済になっています。
コマンドプロンプトにて、echo %JAVA_HOME% [Enter]を入力すると、
インストール済のJAVAが何処にインストールしているのかを確認出来ます。
```

## $\textcolor{green}{JAVAインストール確認}$
java -version

```
java version "14.0.2" 2020-07-14
Java(TM) SE Runtime Environment (build 14.0.2+12-46)
Java HotSpot(TM) 64-Bit Server VM (build 14.0.2+12-46, mixed mode, sharing)
```

## $\textcolor{green}{中身を確認する。（圧縮ファイル「JankenGame.jar」を作成する前）}$

dir/B

```
ComputerHand.class
JankenGame.jar
Judge.class
Main$ButtonActionListener.class
Main.class
PanelMaker.class
TextMaker.class
```

## $\textcolor{green}{＜配布時にはJarファイル１つに纏めて配布します＞}$

jar cvfm JankenGame.jar META-INF\MANIFEST.MF *.class

```
マニフェストが追加されました
ComputerHand.classを追加中です(入=506)(出=333)(34%収縮されました)
Judge.classを追加中です(入=734)(出=517)(29%収縮されました)
Main$ButtonActionListener.classを追加中です(入=1630)(出=954)(41%収縮されました)
Main.classを追加中です(入=3283)(出=1874)(42%収縮されました)
PanelMaker.classを追加中です(入=855)(出=499)(41%収縮されました)
TextMaker.classを追加中です(入=904)(出=553)(38%収縮されました)
```

## $\textcolor{green}{作成した圧縮ファイル「JankenGame.jar」を解凍する}$

jar xvf JankenGame.jar

```
  META-INF/が作成されました
 META-INF/MANIFEST.MFが展開されました
 ComputerHand.classが展開されました
 Judge.classが展開されました
 Main$ButtonActionListener.classが展開されました
 Main.classが展開されました
 PanelMaker.classが展開されました
 TextMaker.classが展開されました
```

## $\textcolor{green}{treeコマンドでフォルダとファイル構成（中身）を確認する。（マニフェストファイルが作成されていることを確認する）}$

tree/F

```
フォルダー パスの一覧:  ボリューム Windows
ボリューム シリアル番号は B825-1DF9 です
C:.
│  JankenGame.jar
│
└─original_game
    └─com
        │  ComputerHand.class
        │  JankenGame.jar
        │  Judge.class
        │  Main$ButtonActionListener.class
        │  Main.class
        │  PanelMaker.class
        │  TextMaker.class
        │
        └─META-INF
                MANIFEST.MF
```

## $\textcolor{green}{マニフェストファイル（META-INF\MANIFEST.MF）に次の 1行を追加します。}$

type original_game\com\META-INF\MANIFEST.MF

```
Manifest-Version: 1.0
Created-By: 11.0.12 (Microsoft)
Main-Class: original_game.com.Main
```

## $\textcolor{green}{今度は、１行追加したマニフェストファイルを加えて もう一度jar ファイル１つに纏める（圧縮ファイル「JankenGame.jar」が再度作成される）}$

jar cvfm JankenGame.jar original_game\com\META-INF\MANIFEST.MF original_game\com\*.class

```
マニフェストが追加されました
original_game/com/ComputerHand.classを追加中です(入=506)(出=333)(34%収縮されました)
original_game/com/Judge.classを追加中です(入=734)(出=517)(29%収縮されました)
original_game/com/Main$ButtonActionListener.classを追加中です(入=1630)(出=954)(41%収縮されました)
original_game/com/Main.classを追加中です(入=3283)(出=1874)(42%収縮されました)
original_game/com/PanelMaker.classを追加中です(入=855)(出=499)(41%収縮されました)
original_game/com/TextMaker.classを追加中です(入=904)(出=553)(38%収縮されました)
```

## $\textcolor{green}{これで、ようやく、Jarファイルを使用するJAVA実行が成功します。}$

```
java -jar JankenGame.jar
```

## $\textcolor{green}{じゃんけんゲームJAVAプログラムファイル名一覧 }$

```
ComputerHand.java
Judge.java　
Main.java
PanelMaker.java
TextMaker.java
```

## :grinning: $\textcolor{green}{じゃんけんゲームJAVAプログラム一式をダウンロードしたい場合}$
[JankenGame.zip](https://github.com/RobotWork01/JAVA/blob/main/JankenGame.zip)をお好みの場所にダウンロードしてください。

:monocle_face: JankenGame.zipのフォルダ、ファイル構成は次のとおりです :tipping_hand_woman:

```
C:\Users\XXXXX\OneDrive\ドキュメント\JAVA\workspace\JankenGame>tree/F
フォルダー パスの一覧:  ボリューム Windows
ボリューム シリアル番号は B825-1DF9 です
C:.
│  .classpath
│  .project
│
├─.settings
│      org.eclipse.jdt.core.prefs
│
├─bin
│  │  JankenGame.jar
│  │
│  └─original_game
│      └─com
│          │  ComputerHand.class
│          │  JankenGame.jar
│          │  Judge.class
│          │  Main$ButtonActionListener.class
│          │  Main.class
│          │  PanelMaker.class
│          │  TextMaker.class
│          │
│          └─META-INF
│                  MANIFEST.MF
│
└─src
    └─original_game
        └─com
                ComputerHand.java
                Dockerfile
                Judge.java
                Main.java
                PanelMaker.java
                render.yaml
                TextMaker.java

```

><b>＜開発時のJAVA実行方法＞</b>
> javawコマンドでJAVA実行する。

```
javaw -Dfile.encoding=UTF-8  original_game.com.Main
```

> 中身を確認する。（圧縮ファイル「JankenGame.jar」を作成する前）

dir/B

```
ComputerHand.class
JankenGame.jar
Judge.class
Main$ButtonActionListener.class
Main.class
PanelMaker.class
TextMaker.class
```

> <b>＜配布時にはJarファイル１つに纏めて配布します＞</b>
> jarコマンドで１つに纏める（圧縮ファイル「JankenGame.jar」が作成される）

jar cvfm JankenGame.jar META-INF\MANIFEST.MF *.class

```
マニフェストが追加されました
ComputerHand.classを追加中です(入=506)(出=333)(34%収縮されました)
Judge.classを追加中です(入=734)(出=517)(29%収縮されました)
Main$ButtonActionListener.classを追加中です(入=1630)(出=954)(41%収縮されました)
Main.classを追加中です(入=3283)(出=1874)(42%収縮されました)
PanelMaker.classを追加中です(入=855)(出=499)(41%収縮されました)
TextMaker.classを追加中です(入=904)(出=553)(38%収縮されました)
```

> jarコマンドで圧縮ファイルを１度解凍する。（作成した圧縮ファイル「JankenGame.jar」を解凍する）

jar xvf JankenGame.jar

```
 META-INF/が作成されました
 META-INF/MANIFEST.MFが展開されました
 ComputerHand.classが展開されました
 Judge.classが展開されました
 Main$ButtonActionListener.classが展開されました
 Main.classが展開されました
 PanelMaker.classが展開されました
 TextMaker.classが展開されました
```

> treeコマンドでフォルダとファイル構成（中身）を確認する。（マニフェストファイルが作成されていることを確認する）

tree/F

```
フォルダー パスの一覧:  ボリューム Windows
ボリューム シリアル番号は B825-1DF9 です
C:.
│  JankenGame.jar
│
└─original_game
    └─com
        │  ComputerHand.class
        │  JankenGame.jar
        │  Judge.class
        │  Main$ButtonActionListener.class
        │  Main.class
        │  PanelMaker.class
        │  TextMaker.class
        │
        └─META-INF
                MANIFEST.MF
```

> マニフェストファイル（META-INF\MANIFEST.MF）に次の 1行を追加します。

type original_game\com\META-INF\MANIFEST.MF

```
Manifest-Version: 1.0
Created-By: 11.0.12 (Microsoft)
Main-Class: original_game.com.Main
```

> 今度は、１行追加したマニフェストファイルを加えて もう一度jar ファイル１つに纏める（圧縮ファイル「JankenGame.jar」が再度作成される）

jar cvfm JankenGame.jar original_game\com\META-INF\MANIFEST.MF original_game\com\*.class

```
マニフェストが追加されました
original_game/com/ComputerHand.classを追加中です(入=506)(出=333)(34%収縮されました)
original_game/com/Judge.classを追加中です(入=734)(出=517)(29%収縮されました)
original_game/com/Main$ButtonActionListener.classを追加中です(入=1630)(出=954)(41%収縮されました)
original_game/com/Main.classを追加中です(入=3283)(出=1874)(42%収縮されました)
original_game/com/PanelMaker.classを追加中です(入=855)(出=499)(41%収縮されました)
original_game/com/TextMaker.classを追加中です(入=904)(出=553)(38%収縮されました)
```

> これで、ようやく、Jarファイルを使用するJAVA実行が成功します。 :tea: :sushi:

```
java -jar JankenGame.jar
```
参考：<br/>
Eclipse導入からJavaプログラムをexeファイルで実行するまで<br/>
<a href="https://qiita.com/Tanakadesu/items/79c4a0744f2874207213">https://qiita.com/Tanakadesu/items/79c4a0744f2874207213</a>
<img width="1152" height="869" alt="image" src="https://github.com/user-attachments/assets/2a2408de-52ac-49bd-8ca7-09d19a559a0f" />

