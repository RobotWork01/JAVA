参考：https://original-game.com/java-janken-game-program/#m_heading-13<br/>
【絶対できる！】Javaでのじゃんけんゲームの作り方<br/>

> JAVAプログラムファイル名
```
ComputerHand.java
Judge.java
Main.java
PanelMaker.java
TextMaker.java
```
> :grinning:ダウンロードしたい場合
> JankenGame.zipをお好みの場所にダウンロードしてください。

JankenGame.zip:
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


C:\Users\XXXXX\OneDrive\ドキュメント\JAVA\workspace\JankenGame>
```

><b>＜開発時のJAVA実行方法＞</b>
>●javawコマンドでJAVA実行に成功する。
```
C:\Users\XXXXX\OneDrive\ドキュメント\JAVA\workspace\JankenGame\bin\original_game>cd ..
C:\Users\XXXXX\OneDrive\ドキュメント\JAVA\workspace\JankenGame\bin>javaw -Dfile.encoding=UTF-8  original_game.com.Main
```
> ●中身を確認する。（圧縮ファイル「JankenGame.jar」を作成する前）
```
C:\Users\XXXXX\OneDrive\ドキュメント\JAVA\workspace\JankenGame\bin\original_game\com>dir/B
ComputerHand.class
JankenGame.jar
Judge.class
Main$ButtonActionListener.class
Main.class
PanelMaker.class
TextMaker.class
```
> <b>＜配布時にはJarファイル１つに纏めて配布します＞</b>
> ●jarコマンドで１つに纏める（圧縮ファイル「JankenGame.jar」が作成される）
```
C:\Users\XXXXX\OneDrive\ドキュメント\JAVA\workspace\JankenGame\bin\original_game\com>jar cvfm JankenGame.jar META-INF\MANIFEST.MF *.class
マニフェストが追加されました
ComputerHand.classを追加中です(入=506)(出=333)(34%収縮されました)
Judge.classを追加中です(入=734)(出=517)(29%収縮されました)
Main$ButtonActionListener.classを追加中です(入=1630)(出=954)(41%収縮されました)
Main.classを追加中です(入=3283)(出=1874)(42%収縮されました)
PanelMaker.classを追加中です(入=855)(出=499)(41%収縮されました)
TextMaker.classを追加中です(入=904)(出=553)(38%収縮されました)
```

> ●jarコマンドで圧縮ファイルを１度解凍する。（作成した圧縮ファイル「JankenGame.jar」を解凍する）
```
C:\Users\XXXXX\OneDrive\ドキュメント\JAVA\workspace\JankenGame\bin\original_game\com>jar xvf JankenGame.jar
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
```
C:\Users\XXXXX\OneDrive\ドキュメント\JAVA\workspace\JankenGame\bin>tree/F
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
```
C:\Users\XXXXX\OneDrive\ドキュメント\JAVA\workspace\JankenGame\bin>type original_game\com\META-INF\MANIFEST.MF
Manifest-Version: 1.0
Created-By: 11.0.12 (Microsoft)
Main-Class: original_game.com.Main
```

> 今度は、１行追加したマニフェストファイルを加えて もう一度jar ファイル１つに纏める（圧縮ファイル「JankenGame.jar」が再度作成される）
```
C:\Users\XXXXX\OneDrive\ドキュメント\JAVA\workspace\JankenGame\bin>jar cvfm JankenGame.jar original_game\com\META-INF\MANIFEST.MF original_game\com\*.class
マニフェストが追加されました
original_game/com/ComputerHand.classを追加中です(入=506)(出=333)(34%収縮されました)
original_game/com/Judge.classを追加中です(入=734)(出=517)(29%収縮されました)
original_game/com/Main$ButtonActionListener.classを追加中です(入=1630)(出=954)(41%収縮されました)
original_game/com/Main.classを追加中です(入=3283)(出=1874)(42%収縮されました)
original_game/com/PanelMaker.classを追加中です(入=855)(出=499)(41%収縮されました)
original_game/com/TextMaker.classを追加中です(入=904)(出=553)(38%収縮されました)
```

> これで、ようやく、Jarファイルを使用するJAVA実行が成功します。
```
C:\Users\XXXXX\OneDrive\ドキュメント\JAVA\workspace\JankenGame\bin>java -jar JankenGame.jar
```
