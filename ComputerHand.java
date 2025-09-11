/*
参考：https://original-game.com/java-janken-game-program/#m_heading-13
【絶対できる！】Javaでのじゃんけんゲームの作り方

ComputerHand.java
*/
package original_game.com;
import java.util.Random;

public class ComputerHand {
	/***********************************************************
	 *コンピュータの手を取得するためのメソッド
	 *
	 * @param  なし
	 * @return hand 0〜2のどれかの数値をランダムに選んで返す
	 ************************************************************/
	public static int getComputerHand() {
		//Randomクラスの作成
		Random random = new Random();
		{
			int hand = random.nextInt(3);
			return hand;
		}
	}

}
