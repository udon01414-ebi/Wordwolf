import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Word extends JPanel {
	String od[] = { "食べ物", "施設・店", "スポーツ", "日本の地名", "世界の国",
			"動物", "人物", "ゲーム", "漫画・アニメ", "キャラクター", "職業", "IT用語", "その他" };
	JLabel labels[] = { new JLabel("お題のジャンルを選択します。この中から選んでください。"),
			new JLabel("0:食べ物、1:施設、2:スポーツ、3:日本の地名、4:世界の国、5:動物、6:人物、"),
			new JLabel("7:ゲーム、8:漫画・アニメ、9:キャラクター、10:職業、11:IT用語、12:その他、13:ランダム"),
			new JLabel(""), new JLabel("やりたいお題のジャンルの番号を入力してください") };
	int genreInt;
	JTextField genre;
	static public int wolfPlayer;
	Random rand = new Random();
	static public String odai;

	public Word() {
		while (true) {
			String input = JOptionPane.showInputDialog("<html>お題のジャンルを選択します。この中から選んでください。<br>"
					+ "0:食べ物、1:施設、2:スポーツ、3:日本の地名<br>"
					+ "4:世界の国、5:動物、6:人物、7:ゲーム<br>"
					+ "8:漫画・アニメ、9:キャラクター、10:職業<br>"
					+ "11:IT用語、12その他");

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
						JOptionPane.showMessageDialog(null, "０～１２で入力をお願いします");
					} else {
						genreCheck(count);

						JOptionPane.showMessageDialog(null,
								"ゲームを開始しますか？（議論時間は" + TimerPanel.timeM + "分" + TimerPanel.timeS + "秒" + "です。）");

						TimerPanel timerPanel = new TimerPanel();
						JFrame frame = new JFrame("ワードウルフ");
						timerPanel.setBorder(new EmptyBorder(50, 0, 50, 0));
						frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						frame.setSize(480, 240);
						frame.add(timerPanel);
						frame.setLocationRelativeTo(null);
						frame.setVisible(true);

						return;
					}

				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "数字を入力してください");
					continue;
				}
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
			String odai0[] = { "みかん", "ぽんかん", "りんご", "なし", "うどん", "そば", "ラーメン", "冷やし中華", "スパゲティー", "カルボナーラ",
					"ぶどう", "マスカット", "チャーハン", "エビピラフ", "たこ焼き", "お好み焼き", "ハンバーグ", "ステーキ", "ラムネ", "サイダー", "ビール", "ワイン" };
			int a = rand.nextInt(odai0.length / 2) * 2;
			String od0[] = { odai0[a], odai0[a + 1] };
			wordManager(od0);
		} else if (od[genreInt].equals("施設・店")) {
			String odai1[] = { "美術館", "博物館", "学校", "病院", "遊園地", "ゲームセンター", "動物園", "水族館", "温泉", "サウナ", "両国国技館", "日本武道館",
					"ドン・キホーテ", "業務スーパー", "マックスバリュー", "まいばすけっと", "スターバックス", "ドトール", "ユニクロ", "GU", "羽田空港", "成田空港",
					"ディズニーランド", "サンリオピューロランド", "ひらかたパーク", "ユニバーサルスタジオジャパン" };
			int a = rand.nextInt(odai1.length / 2) * 2;
			String od1[] = { odai1[a], odai1[a + 1] };
			wordManager(od1);
		} else if (od[genreInt].equals("スポーツ")) {
			String odai2[] = { "サッカー", "ハンドボール", "野球", "クリケット", "卓球", "テニス", "バトミントン", "ピックルボール", "バレーボール", "ビーチバレー",
					"ゴルフ", "ビリヤード", "ハンドボール", "水球", "スケルトン", "ボブスレー", "スキー", "スノーボード", "プロレス", "ボクシング",
					"ホッケー", "アイスホッケー", "柔道", "レスリング", "ラグビー", "アメリカンフットボール", "フェンシング", "剣道", "フルマラソン", "ハーフマラソン",
					"駅伝", "リレー", "フィギュアスケート", "新体操", "ダーツ", "アーチェリー", "スピードスケート", "ショートトラック", "カーリング", "ボッチャ",
					"競輪", "オートレース", "カーレース", "F1" };
			int a = rand.nextInt(odai2.length / 2) * 2;
			String od2[] = { odai2[a], odai2[a + 1] };
			wordManager(od2);
		} else if (od[genreInt].equals("日本の地名")) {
			String odai3[] = { "新宿", "渋谷", "池袋", "新宿", "原宿", "新大久保", "錦糸町", "押上", "亀戸", "平井", "小岩", "新小岩", "葛西", "西葛西",
					"北千住", "南千住",
					"清澄白河", "門前仲町", "上野", "日暮里", "立川", "八王子", "町田", "相模原", "横浜", "川崎", "大宮", "浦和", "川越", "越谷", "浦安",
					"市川", "船橋", "木更津" };
			int a = rand.nextInt(odai3.length / 2) * 2;
			String od3[] = { odai3[a], odai3[a + 1] };
			wordManager(od3);
		} else if (od[genreInt].equals("世界の国")) {
			String odai4[] = { "フランス", "イタリア", "ドイツ", "ベルギー", "スペイン", "ポルトガル", "フィンランド", "スウェーデン", "イギリス", "アイルランド",
					"オランダ", "ポーランド", "アメリカ", "カナダ", "ブラジル", "アルゼンチン", "ベネズエラ", "コロンビア", "オーストラリア", "ニュージーランド" };
			int a = rand.nextInt(odai4.length / 2) * 2;
			String od4[] = { odai4[a], odai4[a + 1] };
			wordManager(od4);
		} else if (od[genreInt].equals("動物")) {
			String odai5[] = { "タイガー(トラ)", "ジャガー", "ヒョウ", "チーター", "パンダ", "コアラ", "イルカ", "シャチ", "ペンギン", "アザラシ", "うさぎ",
					"ハムスター", "キリン", "ゾウ",
					"サル", "ゴリラ", "オオカミ", "キツネ", "カラス", "ハト", "タコ", "イカ" };
			int a = rand.nextInt(odai5.length / 2) * 2;
			String od5[] = { odai5[a], odai5[a + 1] };
			wordManager(od5);
		} else if (od[genreInt].equals("人物")) {
			String odai6[] = { "Aさん", "Bさん" };
			int a = rand.nextInt(odai6.length / 2) * 2;
			String od6[] = { odai6[a], odai6[a + 1] };
			wordManager(od6);
		} else if (od[genreInt].equals("ゲーム")) {
			String odai7[] = { "メガドライブ", "セガサターン", "プレイステーション", "XBOX", "ファミコン", "スーパーファミコン", "ゲームボーイ", "ゲームボーイアドバンス",
					"ニンテンドーDS", "ニンテンドー3DS", "Wii", "WiiU", "マリオカート", "ソニックレーシング", "グランツーリスモ", "リッジレーサー", "マリオパーティ",
					"桃太郎電鉄",
					"将棋", "チェス", "オセロ", "囲碁" };
			int a = rand.nextInt(odai7.length / 2) * 2;
			String od7[] = { odai7[a], odai7[a + 1] };
			wordManager(od7);
		} else if (od[genreInt].equals("漫画・アニメ")) {
			String odai8[] = { "アニメ1", "アニメ2" };
			int a = rand.nextInt(odai8.length / 2) * 2;
			String od8[] = { odai8[a], odai8[a + 1] };
			wordManager(od8);
		} else if (od[genreInt].equals("キャラクター")) {
			String odai9[] = { "ファイン", "レイン" };
			int a = rand.nextInt(odai9.length / 2) * 2;
			String od9[] = { odai9[a], odai9[a + 1] };
			wordManager(od9);
		} else if (od[genreInt].equals("職業")) {
			String odai10[] = { "プログラマー", "システムエンジニア", "アプリケーションエンジニア", "インフラエンジニア", "医者", "看護師", "警察官", "消防士", "教師",
					"保育士",
					"歌手", "声優", "DJ", "音楽プロデューサー", "専門学生", "大学生" };
			int a = rand.nextInt(odai10.length / 2) * 2;
			String od10[] = { odai10[a], odai10[a + 1] };
			wordManager(od10);
		} else if (od[genreInt].equals("IT用語")) {
			String odai11[] = { "ウォーターフォールモデル", "スパイラルモデル", "ホワイトボックステスト", "ブラックボックステスト", "スタブ", "ドライバ",
					"クロスサイトスクリプティング", "ソーシャルエンジニアリング" };
			int a = rand.nextInt(odai11.length / 2) * 2;
			String od11[] = { odai11[a], odai11[a + 1] };
			wordManager(od11);
		} else if (od[genreInt].equals("その他")) {
			String odai12[] = { "a", "b" };
			int a = rand.nextInt(odai12.length / 2) * 2;
			String od12[] = { odai12[a], odai12[a + 1] };
			wordManager(od12);
		}
	}

	@SuppressWarnings("static-access")
	private void wordManager(String[] od) {
		int mainIndex = rand.nextInt(2);
		int wolfIndex = 1 - mainIndex;

		wolfPlayer = rand.nextInt(User.memberCount) + 1;

		for (int i = 1; i <= User.memberCount;) {
			Object[] options = { "このまま続ける", "前のプレイヤーに戻る" };
			int choice = JOptionPane.showOptionDialog(null, i + "人目だけ画面を見せてください。", "確認", JOptionPane.DEFAULT_OPTION,
					JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

			//このまま続ける
			if (choice == 0) {
				this.odai = od[mainIndex];
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
