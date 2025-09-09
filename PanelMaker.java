/*
参考：https://original-game.com/java-janken-game-program/#m_heading-13
【絶対できる！】Javaでのじゃんけんゲームの作り方

PanelMaker.java
*/
package original_game.com;
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//AWT(Abstract Windowing Tools)　読み方：「エーダブリューティー」または「アブストラクト・ウィンドウ・ツールキット」
//
//AWT(Abstract Windowing Tools)は、Java で GUIアプリケーションを作成するためのクラスライブラリです。
//現在では Swing もよく利用されていますが、Swing よりも軽い GUIアプリケーションを作成することが可能です。
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
import java.awt.Color;
import java.awt.Dimension;

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Swing　読み方：「スウィング」
//
//Swing(スィング)は、JDK1.2 でサポートされた AWT よりも新しい GUIコンポーネントです。
//AWT に対して以下のような特徴があります。
//１）OSが変わっても見栄えが変わらない。
//２）AWTよりも重い。
//３）AWT での部品名に J をつけたものが多い。
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
import javax.swing.JPanel;

public class PanelMaker {

	/***********************************************************
	 *パネルを作るメソッド（幅と高さを指定する用）
	 *
	 * @param color
	 * @param width
	 * @param height
	 * @return panel
	 ***********************************************************/
	public static JPanel makePanel(Color color, int width, int height) {
		//JPanelクラスをインスタンス化
		JPanel panel = new JPanel();
		//パネルの色を変更する
		panel.setBackground(color);
		//パネルのサイズを「width、height」に設定
		panel.setPreferredSize(new Dimension(width, height));
		//作ったパネルを返す
		return panel;
	}

	/***********************************************************
	 *パネルを作るメソッド（幅と高さを指定しない用）
	 *
	 * @param color
	 * @return panel
	 ***********************************************************/
	public static JPanel makePanel(Color color) {
		//JPanelクラスをインスタンス化
		JPanel panel = new JPanel();
		//パネルの色を変更する
		panel.setBackground(color);
		//作ったパネルを返す
		return panel;
	}

}
