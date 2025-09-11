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
	 * ラベルを作るメソッド
	 *
	 * @param str     キャプション値
	 * @param size    キャプションの文字サイズ
	 * @param color   キャプションの文字色
	 * @return label  作成したラベルを返す
	 **********************************************************/
	public static JLabel makeText(String str, int size, Color color) {
		//ラベルの作成
		JLabel label = new JLabel(str);
		{
			label.setForeground(color);
			label.setFont(new Font("ＭＳ ゴシック", Font.PLAIN, size));
			label.setHorizontalAlignment(JLabel.CENTER); //縦位置を、水平方向の中心にする
			label.setVerticalAlignment(JLabel.CENTER);   //横位置を、垂直方向の中心にする
			return label;
		}
	}

}
