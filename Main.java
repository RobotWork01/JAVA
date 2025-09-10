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
		JFrame frame = new JFrame("じゃんけんゲーム");
		{
			frame.setSize(640, 480);
			frame.setLocationRelativeTo(null);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setResizable(false);
		}


		/*************************************************
		 *ヘッダーパネルの設定
		 *************************************************/
		{
			JPanel headerPanel = PanelMaker.makePanel(Color.BLACK, 640, 50);
			headerPanel.setLayout(new BorderLayout());
			headerLabel = TextMaker.makeText("「さあ、じゃんけんで勝負だ！」", 24, Color.WHITE);
			headerPanel.add(headerLabel);
			frame.add(headerPanel, BorderLayout.NORTH);
		}

		/*************************************************
		 *コンテンツパネルの設定
		 *************************************************/
		{
			JPanel contentsPanel = PanelMaker.makePanel(Color.WHITE);
			contentsPanel.setLayout(new BorderLayout());
			contentsLabel = TextMaker.makeText("じゃんけん……", 54, Color.BLACK);
			contentsPanel.add(contentsLabel);
			frame.add(contentsPanel, BorderLayout.CENTER);
		}

		/*************************************************
		 *フッターパネルの設定
		 *************************************************/
		{
			JPanel footerPanel = PanelMaker.makePanel(Color.BLACK, 640, 50);
			footerPanel.setLayout(new GridLayout());
			for (String hand : hands) {
				JButton button = new JButton(hand);
				button.setFont(new Font("ＭＳ ゴシック", Font.PLAIN, 24));
				button.addActionListener(new ButtonActionListener());
				footerPanel.add(button);
			}
			frame.add(footerPanel, BorderLayout.SOUTH);
			frame.setVisible(true);
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
	 * @param  color
	 * @return panel
	 ********************************************************************/
	public static JPanel makePanel(Color color) {
		JPanel panel = new JPanel();
		{
			panel.setBackground(color);
			return panel;
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
		JLabel label = new JLabel(str);
		{
			label.setForeground(color);
			label.setFont(new Font("ＭＳ ゴシック", Font.PLAIN, size));
			label.setHorizontalAlignment(JLabel.CENTER);
			label.setVerticalAlignment(JLabel.CENTER);
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
			/*------------------------------------------------------------*
			 *コンピュータの手（数値）を取得してcomputerHandNumに設定する
			 *------------------------------------------------------------*/
			int computerHandNum = ComputerHand.getComputerHand();
			{
				String computerHand = hands[computerHandNum];
				contentsLabel.setText("コンピュータは、"+computerHand);
			}

			/*------------------------------------------------------------*
			 *プレイヤーが出した手の数値を探してplayerHandNumに設定する
			 *------------------------------------------------------------*/
			int playerHandNum=0;//プレイヤーが出した手に対応した数値を入れるための変数
			{
				for (int i=0; i<hands.length; i++) {
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
