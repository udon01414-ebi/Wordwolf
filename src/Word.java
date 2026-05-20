import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Word extends JPanel {
	String od[] = { "食べ物", "施設", "スポーツ", "日本の地名", "世界の国",
			"動物", "人物", "ゲーム", "漫画・アニメ", "キャラクター", "職業", "IT用語", "その他" };
	JLabel labels[] = { new JLabel("お題のジャンルを選択します。この中から選んでください。"),
			new JLabel("0:食べ物、1:施設、2:スポーツ、3:日本の地名、4:世界の国、5:動物、6:人物、"),
			new JLabel("7:ゲーム、8:漫画・アニメ、9:キャラクター、10:職業、11:IT用語、12:その他、13:ランダム"),
			new JLabel(""), new JLabel("やりたいお題のジャンルの番号を入力してください") };
	int genreInt;
	JTextField genre;
	static public int wolfPlayer;

	public Word() {
		String input = JOptionPane.showInputDialog("<html>お題のジャンルを選択します。この中から選んでください。<br>"
				+ "0:食べ物、1:施設、2:スポーツ、3:日本の地名<br>"
				+ "4:世界の国、5:動物、6:人物、7:ゲーム<br>"
				+ "8:漫画・アニメ、9:キャラクター、10:職業<br>"
				+ "11:IT用語、12その他、13:ランダム");

		while (true) {
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

				if (count < 0 || count > 13) {
					JOptionPane.showMessageDialog(null, "０～１３で入力をお願いします");
				} else {
					genreCheck(count);
					
					JOptionPane.showMessageDialog(null, "ゲームを開始しますか？（議論時間は" + TimerPanel.timeM + "分" + TimerPanel.timeS + "秒" + "です。）");

					TimerPanel timerPanel = new TimerPanel();
					JFrame frame = new JFrame("ワードウルフ");
					timerPanel.setBorder(new EmptyBorder(50,0,50,0));
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setSize(480, 240);
					frame.add(timerPanel);
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
					
					return;
				}

			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "数字を入力してください");
			}
		}
	}

	private void genreCheck(int genreInt) {
		this.genreInt = genreInt;
		JOptionPane.showMessageDialog(null, "やるジャンルは" + od[genreInt] + "を選択しました");
		genreManager(genreInt);
	}

	private void genreManager(int genreInt) {

		if (od[genreInt].equals("食べ物")) {
			String od0[] = { "みかん", "ぽんかん" };
			wordManager(od0);
		}

		else if (od[genreInt].equals("施設")) {
			String od1[] = { "美術館", "博物館" };
			wordManager(od1);
		} else if (od[genreInt].equals("スポーツ")) {
			String od2[] = { "サッカー", "ハンドボール" };
			wordManager(od2);
		} else if (od[genreInt].equals("日本の地名")) {
			String od3[] = { "新宿", "渋谷" };
			wordManager(od3);
		} else if (od[genreInt].equals("世界の国")) {
			String od4[] = { "フランス", "イタリア" };
			wordManager(od4);
		} else if (od[genreInt].equals("動物")) {
			String od5[] = { "タイガー", "ジャガー" };
			wordManager(od5);
		} else if (od[genreInt].equals("人物")) {
			String od6[] = { "Aさん", "Bさん" };
			wordManager(od6);
		} else if (od[genreInt].equals("ゲーム")) {
			String od7[] = { "メガドライブ", "セガサターン" };
			wordManager(od7);
		} else if (od[genreInt].equals("漫画・アニメ")) {
			String od8[] = { "アニメ1", "アニメ2" };
			wordManager(od8);
		} else if (od[genreInt].equals("キャラクター")) {
			String od9[] = { "ファイン", "レイン" };
			wordManager(od9);
		} else if (od[genreInt].equals("職業")) {
			String od10[] = { "プログラマー", "システムエンジニア" };
			wordManager(od10);
		} else if (od[genreInt].equals("IT用語")) {
			String od11[] = { "ウォーターフォールモデル", "スパイラルモデル" };
			wordManager(od11);
		} else if (od[genreInt].equals("その他")) {
			String od12[] = { "a", "b" };
			wordManager(od12);
		}
	}

	private void wordManager(String[] od) {
		Random rand = new Random();
		int mainIndex = rand.nextInt(od.length);
		int wolfIndex = 1 - mainIndex;

		wolfPlayer = rand.nextInt(User.memberCount) + 1;

		for (int i = 1; i <= User.memberCount;) {
			Object[] options = { "このまま続ける", "前のプレイヤーに戻る" };
			int choice = JOptionPane.showOptionDialog(null, i + "人目だけ画面を見せてください。", "確認", JOptionPane.DEFAULT_OPTION,
					JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

			//このまま続ける
			if (choice == 0) {
				String odai = (i == wolfPlayer ? od[wolfIndex] : od[mainIndex]);

				JOptionPane.showMessageDialog(null, "あなたのお題は：" + odai + " です。" + "\n確認しましたか？");
				i++;
			}

			//前のプレイヤーに戻る
			if (choice == 1 && i > 1) {
				i--;
			}
		}
		
	}
}
