/*
参考：https://original-game.com/java-janken-game-program/#m_heading-13
【絶対できる！】Javaでのじゃんけんゲームの作り方

Main.java
*/
package original_game.com;
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//AWT(Abstract Windowing Tools)　読み方：「エーダブリューティー」または「アブストラクト・ウィンドウ・ツールキット」
//
//AWT(Abstract Windowing Tools)は、Java で GUIアプリケーションを作成するためのクラスライブラリです。
//現在では Swing もよく利用されていますが、Swing よりも軽い GUIアプリケーションを作成することが可能です。
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Swing　読み方：「スウィング」
//
//Swing(スィング)は、JDK1.2 でサポートされた AWT よりも新しい GUIコンポーネントです。
//AWT に対して以下のような特徴があります。
//　１）OSが変わっても見栄えが変わらない。
//　２）AWTよりも重い。
//　３）AWT での部品名に J をつけたものが多い。
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
import javax.swing.JButton;		//ボタン
import javax.swing.JFrame;		//フレーム
import javax.swing.JLabel;		//ラベル
import javax.swing.JPanel;		//パネル

public class Main {

	//じゃんけんの手の配列を作る
	private static String[] hands = {"グー", "チョキ", "パー"};

	//ラベルの宣言
	private static JLabel contentsLabel;
	private static JLabel headerLabel;


	public static void main(String[] args) {
		/*************************************************
		 *ウィンドウフレームの設定
		 *************************************************/
		//ウィンドウフレームを作成
		JFrame frame = new JFrame("【 RobotWork01 】じゃんけんゲーム");
		{
			frame.setSize(640, 480);                                //ウィンドウフレームサイズ縦640*横480にする
			frame.setLocationRelativeTo(null);                     //ウィンドウフレームが画面の中心に表示されるようにする
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //ウィンドウフレーム上部の✕をクリックしたときに、アプリも終了する
			frame.setResizable(false);								//ゲーム全体のレイアウトが崩れないように、ウィンドウのサイズを変更できないようにする
		}


		/*************************************************
		 *ヘッダーパネルの設定
		 *************************************************/
		{
			//ヘッダーパネルを作成
			JPanel headerPanel = PanelMaker.makePanel(Color.BLACK, 640, 50);
			{
				headerPanel.setLayout(new BorderLayout());                                              //レイアウトマネージャとしてBorderLayoutを指定
				headerLabel = TextMaker.makeText("「さあ、じゃんけんで勝負だ！」", 24, Color.WHITE); //テキストを作成
				headerPanel.add(headerLabel);                                                          //ヘッダーパネルにテキストを追加
			}
			//ウィンドウフレームにコンテンツパネルのヘッダー部分を追加
			frame.add(headerPanel, BorderLayout.NORTH);
		}

		/*************************************************
		 *コンテンツパネルの設定
		 *************************************************/
		{
			//コンテンツパネルを作成
			JPanel contentsPanel = PanelMaker.makePanel(Color.WHITE);
			{
				contentsPanel.setLayout(new BorderLayout());                             //レイアウトマネージャとしてBorderLayoutを指定
				contentsLabel = TextMaker.makeText("じゃんけん……", 54, Color.BLACK);//テキストを作成
				contentsPanel.add(contentsLabel);                                       //コンテンツパネルにラベルを追加
			}
			//ウィンドウフレームにコンテンツパネルのセンター部分を追加
			frame.add(contentsPanel, BorderLayout.CENTER);

		}

		/*************************************************
		 *フッターパネルの設定
		 *************************************************/
		{
			//フッターパネルを作成
			JPanel footerPanel = PanelMaker.makePanel(Color.BLACK, 640, 50);
			footerPanel.setLayout(new GridLayout());

			//じゃんけんの手の配列をループして、全ての手のボタンを追加する
			for (String hand : hands) {

				//ボタンの作成
				JButton button = new JButton(hand);
				{
					button.setFont(new Font("ＭＳ ゴシック", Font.PLAIN, 24));//ボタンのフォントを設定
					button.addActionListener(new ButtonActionListener());      //ボタンが押された時(ButtonActionListenerクラスのactionPerformedメソッドを実行)
				}
				//手のボタンをフッターパネルに追加
				footerPanel.add(button);
			}
			//ウィンドウフレームにコンテンツパネルのフッダー部分を追加
			frame.add(footerPanel, BorderLayout.SOUTH);

			//ウィンドウフレームを表示する
			frame.setVisible(true);
		}

	}

	/*********************************************************************
	 *パネルを作るメソッド（幅と高さを指定する用）
	 *
	 * @param  color  パネルの色
	 * @param  width  パネルの幅
	 * @param  height パネルの高さ
	 * @return panel  作ったパネルを返す
	 *********************************************************************/
	public static JPanel makePanel(Color color, int width, int height) {
		//パネルの作成
		JPanel panel = new JPanel();
		{
			panel.setBackground(color);
			panel.setPreferredSize(new Dimension(width, height));
			return panel;
		}
	}

	/********************************************************************
	 *パネルを作るメソッド（幅と高さを指定しない用）
	 *
	 * @param  color  パネルの色
	 * @return panel  作ったパネルを返す
	 ********************************************************************/
	public static JPanel makePanel(Color color) {
		//パネルの作成
		JPanel panel = new JPanel();
		{
			panel.setBackground(color);
			return panel;
		}
	}

	/*******************************************************************
	 *ラベルを作るメソッド
	 *
	 * @param  str        キャプションの値
	 * @param  size       キャプションの文字サイズ
	 * @param  color      キャプションの文字色
	 * @return label      作成したラベルを返す
	 *******************************************************************/
	public static JLabel makeText(String str, int size, Color color) {
		//ラベルの作成
		JLabel label = new JLabel(str);
		{
			label.setForeground(color);
			label.setFont(new Font("ＭＳ ゴシック", Font.PLAIN, size));
			label.setHorizontalAlignment(JLabel.CENTER);//縦位置を、水平方向の中心にする
			label.setVerticalAlignment(JLabel.CENTER);  //横位置を、垂直方向の中心にする
			return label;
		}
	}

	/*******************************************************************
	 *ボタンが押されたときのためのクラス
	 *******************************************************************/
	public static class ButtonActionListener implements ActionListener {

		/***********************************************************
		 *ボタンが押されたときに呼ばれるメソッド
		 *
		 * @param  ActionEvent e
		 * @return なし
		 ************************************************************/
		public void actionPerformed(ActionEvent e) {
			/*----------------------------------*
			 *コンピュータの手（じゃんけん）
			 *----------------------------------*/
			//コンピュータの手（数値）をランダムに取得
			int computerHandNum = ComputerHand.getComputerHand();
			{
				//じゃんけんの手の配列より、文字列を取得
				String computerHand = hands[computerHandNum];
				contentsLabel.setText("コンピュータは、"+computerHand);
			}

			/*----------------------------------*
			 *プレイヤーが出した手（じゃんけん）
			 *----------------------------------*/
			//プレイヤーが出した手に対応した数値を入れるための変数
			int playerHandNum=0;
			{
				//じゃんけんの手の配列の中をループする
				for (int i=0; i<hands.length; i++) {
					//押したボタンのキャプションとじゃんけんの手の配列の中を比較する
					if (hands[i] == e.getActionCommand()) {
						playerHandNum=i;
						break;
					}
				}
				//ラベルに、プレイヤー(あなた)の手を追加
				String playerHand = hands[playerHandNum];
				contentsLabel.setText("<html>"+contentsLabel.getText()+"<br>あなたは、"+playerHand+"</html>");
			}

			/*--------------------------------------------*
			 *じゃんけん結果のセリフをヘッダーに表示する
			 *--------------------------------------------*/
			String serif = Judge.getResultText(playerHandNum, computerHandNum);
			headerLabel.setText(serif);

		}

	}

}
