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
		 *フレームの設定
		 *************************************************/
		JFrame frame = new JFrame("じゃんけんゲーム");						//JFrameクラスをインスタンス化
		{
			frame.setSize(640, 480);															//ウィンドウサイズの設定では640*480にしています。
			frame.setLocationRelativeTo(null);										//ウィンドウが画面の中心に表示されるようにしています。
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//ウィンドウ上部の✕をクリックしたときに、アプリも終了するようにしています。
			frame.setResizable(false);														//ゲーム全体のレイアウトが崩れないように、ウィンドウのサイズを変更できないようにしています。
		}


		/*************************************************
		 *ヘッダーパネルの設定
		 *************************************************/
		{
			JPanel headerPanel = PanelMaker.makePanel(Color.BLACK, 640, 50);										//ヘッダーパネルを作成
			headerPanel.setLayout(new BorderLayout());																					//ヘッダーパネルに、レイアウトマネージャとしてBorderLayoutを指定
			headerLabel = TextMaker.makeText("「さあ、じゃんけんで勝負だ！」", 24, Color.WHITE);		//テキストを作成
			headerPanel.add(headerLabel);																												//ヘッダーパネルにテキストを追加
			frame.add(headerPanel, BorderLayout.NORTH);																					//ウィンドウにヘッダーパネルを追加
		}

		/*************************************************
		 *コンテンツパネルの設定
		 *************************************************/
		{
			JPanel contentsPanel = PanelMaker.makePanel(Color.WHITE);								//コンテンツパネルを作成
			contentsPanel.setLayout(new BorderLayout());														//レイアウトマネージャとしてBorderLayoutを指定
			contentsLabel = TextMaker.makeText("じゃんけん……", 54, Color.BLACK);			//テキストを作成
			contentsPanel.add(contentsLabel);																				//コンテンツパネルにテキストを追加
			frame.add(contentsPanel, BorderLayout.CENTER);													//ウィンドウにコンテンツパネルを追加
		}

		/*************************************************
		 *フッターパネルの設定
		 *************************************************/
		{
			JPanel footerPanel = PanelMaker.makePanel(Color.BLACK, 640, 50);				//フッターパネルを作成
			footerPanel.setLayout(new GridLayout());																//フッターパネルに、レイアウトマネージャとしてGridLayoutを指定
			for (String hand : hands) {																							//じゃんけんの手の配列
				JButton button = new JButton(hand);																		//JButtonクラスをインスタンス化
				button.setFont(new Font("ＭＳ ゴシック", Font.PLAIN, 24));							//ボタンのフォントを設定
				button.addActionListener(new ButtonActionListener());									//ボタンが押されたら、ButtonActionListenerクラスのactionPerformedメソッドを実行
				footerPanel.add(button);																							//手のボタンをフッターパネルに追加
			}
			frame.add(footerPanel, BorderLayout.SOUTH);															//ウィンドウにフッターパネルを追加
			frame.setVisible(true);																									//非表示だったウィンドウを表示しています。
		}

	}

	/*********************************************************************
	 *パネルを作るメソッド（幅と高さを指定する用）
	 *
	 * @param  color
	 * @param  width
	 * @param  height
	 * @return panel
	 *********************************************************************/
	public static JPanel makePanel(Color color, int width, int height) {
		JPanel panel = new JPanel();														//JPanelクラスをインスタンス化
		{
			panel.setBackground(color);														//パネルの色を変更する
			panel.setPreferredSize(new Dimension(width, height));	//パネルのサイズを「width、height」に設定
			return panel;																					//作ったパネルを返す
		}
	}

	/********************************************************************
	 *パネルを作るメソッド（幅と高さを指定しない用）
	 *
	 * @param  color
	 * @return panel
	 ********************************************************************/
	public static JPanel makePanel(Color color) {
		JPanel panel = new JPanel();								//JPanelクラスをインスタンス化
		{
			panel.setBackground(color);								//パネルの色を変更する
			return panel;															//作ったパネルを返す
		}
	}

	/*******************************************************************
	 *テキストを作るメソッド
	 *
	 * @param  str
	 * @param  size
	 * @param  color
	 * @return label
	 *******************************************************************/
	public static JLabel makeText(String str, int size, Color color) {
		JLabel label = new JLabel(str);							//JLabelクラスをインスタンス化
		{
			label.setForeground(color);																	//テキストの文字を白にする
			label.setFont(new Font("ＭＳ ゴシック", Font.PLAIN, size));	//テキストのフォントを設定
			label.setHorizontalAlignment(JLabel.CENTER);								//テキストの位置を、水平方向の中心にする
			label.setVerticalAlignment(JLabel.CENTER);									//テキストの位置を、垂直方向の中心にする
			return label;																								//作ったテキストを返す
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
			/*------------------------------------------------------------*
			 *コンピュータの手（数値）を取得してcomputerHandNumに設定する
			 *------------------------------------------------------------*/
			int computerHandNum = ComputerHand.getComputerHand();			//コンピュータの手（数値）をランダムに取得
			{
				String computerHand = hands[computerHandNum];						//数値からコンピュータの手を取り出して代入
				contentsLabel.setText("コンピュータは、"+computerHand);	//コンテンツパネルのテキストに、コンピュータの手を指定
			}

			/*------------------------------------------------------------*
			 *プレイヤーが出した手の数値を探してplayerHandNumに設定する
			 *------------------------------------------------------------*/
			int playerHandNum=0;//プレイヤーが出した手に対応した数値を入れるための変数
			{
				for (int i=0; i<hands.length; i++) {						//じゃんけんの手の配列
					if (hands[i] == e.getActionCommand()) {
						playerHandNum=i;
						break;
					}
				}
				//コンテンツパネルのテキストに、プレイヤーの手を追加
				String playerHand = hands[playerHandNum];
				contentsLabel.setText("<html>"+contentsLabel.getText()+"<br>あなたは、"+playerHand+"</html>");
			}

			/*------------------------------------------------------------*
			 *プレイヤーとコンピュータの手を比べて、結果のセリフを取得
			 *------------------------------------------------------------*/
			String serif = Judge.getResultText(playerHandNum, computerHandNum);
			headerLabel.setText(serif);//ヘッダーにセリフを表示

		}

	}

}
