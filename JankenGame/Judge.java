/*
参考：https://original-game.com/java-janken-game-program/#m_heading-13
【絶対できる！】Javaでのじゃんけんゲームの作り方

Judge.java
*/
package original_game.com;
public class Judge {
	/***********************************************************
	 *プレイヤー（あなた）とコンピュータの
	 *　じゃんけんの結果のテキストを取得するメソッド
	 *
	 * @param playerHand
	 * @param computerHand
	 * @return resultText    じゃんけん結果のテキストを返す
	 **********************************************************/
	public static String getResultText(int playerHand, int computerHand) {
		//じゃんけんの結果のテキストを代入する変数を初期化
		String resultText = "";

		//じゃんけんの結果を出すための計算
		int result = (playerHand - computerHand + 3) % 3;

		//あいこのとき
		if (result == 0) {
			//resultText = "あいこかよ！";
			resultText = "あいこでしょ！";
		}

		//プレイヤーの負けのとき
		else if (result == 1) {
			//resultText = "お前の負けかよ！";
			resultText = "コンピュータの勝ち(^▽^)！";
		}

		//プレイヤーが勝ちのとき
		else if (result == 2) {
			//resultText = "お前の勝ちかよ！";
			resultText = "コンピュータの負け(TへT)！";
		}

		//結果のテキストを返す
		return resultText;
	}

}
