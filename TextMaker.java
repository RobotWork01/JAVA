/*
参考：https://original-game.com/java-janken-game-program/#m_heading-13
【絶対できる！】Javaでのじゃんけんゲームの作り方

TextMaker.java
*/
package original_game.com;
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//AWT(Abstract Windowing Tools)　読み方：「エーダブリューティー」または「アブストラクト・ウィンドウ・ツールキット」
//
//AWT(Abstract Windowing Tools)は、Java で GUIアプリケーションを作成するためのクラスライブラリです。
//現在では Swing もよく利用されていますが、Swing よりも軽い GUIアプリケーションを作成することが可能です。
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
import java.awt.Color;
import java.awt.Font;

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Swing　読み方：「スウィング」
//
//Swing(スィング)は、JDK1.2 でサポートされた AWT よりも新しい GUIコンポーネントです。
//AWT に対して以下のような特徴があります。
//１）OSが変わっても見栄えが変わらない。
//２）AWTよりも重い。
//３）AWT での部品名に J をつけたものが多い。
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
import javax.swing.JLabel;

public class TextMaker {

	/***********************************************************
	 * テキストを作るメソッド
	 *
	 * @param str
	 * @param size
	 * @param color
	 * @return label
	 **********************************************************/
	public static JLabel makeText(String str, int size, Color color) {
		JLabel label = new JLabel(str);							//JLabelクラスをインスタンス化
		label.setForeground(color);									//テキストの文字を白にする
		label.setFont(new Font("ＭＳ ゴシック", Font.PLAIN, size));//テキストのフォントを設定
		label.setHorizontalAlignment(JLabel.CENTER);				//テキストの位置を、水平方向の中心にする
		label.setVerticalAlignment(JLabel.CENTER);					//テキストの位置を、垂直方向の中心にする
		return label;												//作ったテキストを返す
	}

}
