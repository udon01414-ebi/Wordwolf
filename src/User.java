import java.awt.Color;
import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class User {
	static {
		UIManager.put("OptionPane.messageFont", new Font("Serif", Font.BOLD, 16));
		UIManager.put("Button.focus", Color.black);
		UIManager.put("OptionPane.background", Color.black);
		UIManager.put("Panel.background", Color.black);
		UIManager.put("OptionPane.messageForeground", Color.red);
		UIManager.put("Button.background", Color.darkGray);
		UIManager.put("Button.foreground", Color.white);
		UIManager.put("OptionPane.messageForeground", new Color(150, 0, 0));
	}

	static public int memberCount;
	static public String[] playerNames; //名前保存

	public void inputMemberCount() {
		JOptionPane.showMessageDialog(
				null,
				"――――――――――――――――――――――\n" +
						"　　みんな同じお題……のはずだけど？\n" +
						"　　どこか話が噛み合わない。\n\n" +
						"　　この中に “少数派ワード” を持つ者がいる。\n" +
						"　　気づかれないように話し、見抜かれないように立ち回れ。\n" +
						"　　あなたの言葉が、勝敗を分ける。\n" +
						"――――――――――――――――――――――");

		while (true) {
			String input = JOptionPane.showInputDialog("何人でプレイしますか❓（MAX１０人）");

			if (input == null) {
				JOptionPane.showMessageDialog(null, "さようなら( ;∀;)また来てね！");
				return;
			}

			if (input.isEmpty()) {
				JOptionPane.showMessageDialog(null, "数字を入力してください");
				continue;
			}

			try {
				int count = Integer.parseInt(input);

				if (count < 3 || count > 10) {
					JOptionPane.showMessageDialog(null, "３〜１０人で入力をお願いします");
				} else {
					User.memberCount = count;
					displayCount();

					boolean success = inputPlayerNames();

					if (!success) {
						JOptionPane.showMessageDialog(null, "人数入力に戻ります");
						continue;
					} else {
						@SuppressWarnings("unused")
						Word word = new Word();
						return;
					}


				}

			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "数字を入力してください");
			}
		}
	}

	public void displayCount() {
		JOptionPane.showMessageDialog(null, User.memberCount + "人でプレイします");
	}

	public boolean inputPlayerNames() {

		while (true) {
			playerNames = new String[memberCount];

			int i = 0;
			while (i < memberCount) {

				String name = JOptionPane.showInputDialog("プレイヤー" + (i + 1) + " の名前を入力してください");

				if (name == null) {

					if (i == 0) {
						JOptionPane.showMessageDialog(null, "キャンセルされました。人数入力に戻ります");
						return false;
					}

					Object[] options = { "このまま続ける", "前のプレイヤーに戻る", "最初の画面に戻る" };
					int choice = JOptionPane.showOptionDialog(
							null,
							"どうしますか？",
							"確認",
							JOptionPane.DEFAULT_OPTION,
							JOptionPane.QUESTION_MESSAGE,
							null,
							options,
							options[0]);

					//このまま続ける（何もせず同じ画面に戻る）
					if (choice == 0) {
						continue;
					}

					//前のプレイヤーに戻る
					if (choice == 1) {
						i--;
						continue;
					}

					//最初の画面に戻る
					if (choice == 2) {
						return false;
					}
				}

				if (name.trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "名前を入力してください");
					continue;
				}

				playerNames[i] = name;
				i++; // 次のプレイヤーへ
			}
			if (displayPlayerNames()) {

				return true;
			}

			int again = JOptionPane.showConfirmDialog(
					null,
					"最初から名前を入力し直しますか？\n「いいえ」で人数入力に戻ります。",
					"確認",
					JOptionPane.YES_NO_OPTION);

			if (again == JOptionPane.YES_OPTION) {

				JOptionPane.showMessageDialog(null, "名前入力を最初からやり直します");
				continue;
			} else {

				return false;
			}
		}
	}

	public boolean displayPlayerNames() {
		StringBuilder sb = new StringBuilder("プレイヤー一覧:\n");
		for (int i = 0; i < playerNames.length; i++) {
			sb.append("プレイヤー").append(i + 1).append("：").append(playerNames[i]).append("\n");
		}

		int result = JOptionPane.showConfirmDialog(
				null,
				sb.toString() + "\nこの内容でよろしいですか？",
				"確認",
				JOptionPane.OK_CANCEL_OPTION);

		return result == JOptionPane.OK_OPTION;
	}

	public static void main(String[] args) {
		User user = new User();
		user.inputMemberCount();
	}
}
