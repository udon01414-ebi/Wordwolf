
import java.util.Random;
import java.util.Scanner;

class Word {

	public static void main(String[] args) {
		
		String od[] = {"食べ物", "施設","スポーツ","日本の地名","世界の国",
		"動物", "人物", "ゲーム","漫画・アニメ", "キャラクター","職業","IT用語","その他"};
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("お題のジャンルを選択します。この中から選んでください。");
		System.out.println("0:食べ物、1:施設、2:スポーツ、3:日本の地名、4:世界の国、");
		System.out.println("5:動物、6:人物、7:ゲーム、8:漫画・アニメ、9:キャラクター、");
		System.out.println("10:職業、11:IT用語、12:その他、13:ランダム");
		
		System.out.print("やりたいお題のジャンルの番号を入力してください > ");
		int player = sc.nextInt();
		System.out.println("やるジャンルは" + od[player] + "を選択しました");
		System.out.println("1人目だけ画面を見せるようにしてください");
		

		if(od[player].equals("食べ物")) {
			String tabeod0[] = {"みかん","ぽんかん"};
			Random rand = new Random();

		// どっちがお題か決める
			int mainIndex = rand.nextInt(2);
			int wolfIndex = 1 - mainIndex;

		// ワードウルフ（何人目か）
			int wolfPlayer = rand.nextInt(4) + 1;

			for(int i = 1; i <= 4; i++) {
				System.out.println(i + "人目だけ画面を見せてください。Enterで表示");
        	sc.nextLine(); // 待つ

        	if(i == wolfPlayer) {
            System.out.println("あなたのお題は：" + tabeod0[wolfIndex] + " です。");
        	} else {
            System.out.println("あなたのお題は：" + tabeod0[mainIndex] + " です。");
        	}

        	System.out.println("見終わったらEnterで次へ");
        	sc.nextLine(); // 待つ

        // 画面を流す（簡易クリア）
        	for(int j = 0; j < 30; j++) System.out.println();
    }
}

		else if(od[player].equals("施設")) {
			System.out.println("place");
			String od1[] = {"美術館","博物館"};
			Random rand = new Random();
			
			int mainIndex = rand.nextInt(2);
			int wolfIndex = 1 - mainIndex;

			int wolfPlayer = rand.nextInt(4) + 1;
			
			for(int i = 1; i <= 4; i++) {
				System.out.println(i + "人目だけ画面を見せてください。Enterで表示");
        	sc.nextLine(); // 待つ
        	if(i == wolfPlayer) {
            System.out.println("あなたのお題は：" + od1[wolfIndex] + " です。");
            } else {
            System.out.println("あなたのお題は：" + od1[mainIndex] + " です。");
            }

        	System.out.println("見終わったらEnterで次へ");
        	sc.nextLine(); // 待つ

        // 画面を流す（簡易クリア）
        	for(int j = 0; j < 30; j++) System.out.println();
    }
		}
		else if(od[player].equals("スポーツ")) {
			String od2[] = {"サッカー","ハンドボール"};
			Random rand = new Random();
			int mainIndex = rand.nextInt(2);
			int wolfIndex = 1 - mainIndex;

			int wolfPlayer = rand.nextInt(4) + 1;
			
			for(int i = 1; i <= 4; i++) {
				System.out.println(i + "人目だけ画面を見せてください。Enterで表示");
        	sc.nextLine(); // 待つ
        	if(i == wolfPlayer) {
                System.out.println("あなたのお題は：" + od2[wolfIndex] + " です。");
                } else {
                System.out.println("あなたのお題は：" + od2[mainIndex] + " です。");
                }

        	System.out.println("見終わったらEnterで次へ");
        	sc.nextLine(); // 待つ

        // 画面を流す（簡易クリア）
        	for(int j = 0; j < 30; j++) System.out.println();
			}
		}
		else if(od[player].equals("日本の地名")) {
			String od3[] = {"新宿","渋谷"};
			Random rand = new Random();
			int mainIndex = rand.nextInt(2);
			int wolfIndex = 1 - mainIndex;

			int wolfPlayer = rand.nextInt(4) + 1;
		
			for(int i = 1; i <= 4; i++) {
				System.out.println(i + "人目だけ画面を見せてください。Enterで表示");
        	sc.nextLine(); // 待つ
        	if(i == wolfPlayer) {
                System.out.println("あなたのお題は：" + od3[wolfIndex] + " です。");
                } else {
                System.out.println("あなたのお題は：" + od3[mainIndex] + " です。");
                }

        	System.out.println("見終わったらEnterで次へ");
        	sc.nextLine(); // 待つ

        // 画面を流す（簡易クリア）
        	for(int j = 0; j < 30; j++) System.out.println();
			}
		}
		else if(od[player].equals("世界の国")) {
			String od4[] = {"フランス","イタリア"};
			Random rand = new Random();
			
			int mainIndex = rand.nextInt(2);
			int wolfIndex = 1 - mainIndex;

			int wolfPlayer = rand.nextInt(4) + 1;
		
			for(int i = 1; i <= 4; i++) {
				System.out.println(i + "人目だけ画面を見せてください。Enterで表示");
        	sc.nextLine(); // 待つ
        	if(i == wolfPlayer) {
                System.out.println("あなたのお題は：" + od4[wolfIndex] + " です。");
                } else {
                System.out.println("あなたのお題は：" + od4[mainIndex] + " です。");
                }

        	System.out.println("見終わったらEnterで次へ");
        	sc.nextLine(); // 待つ

        // 画面を流す（簡易クリア）
        	for(int j = 0; j < 30; j++) System.out.println();
			}
		}
		else if(od[player].equals("動物")) {
			String od5[] = {"タイガー","ジャガー"};
			Random rand = new Random();
			
			int mainIndex = rand.nextInt(2);
			int wolfIndex = 1 - mainIndex;

			int wolfPlayer = rand.nextInt(4) + 1;
		
			for(int i = 1; i <= 4; i++) {
				System.out.println(i + "人目だけ画面を見せてください。Enterで表示");
        	sc.nextLine(); // 待つ
        	if(i == wolfPlayer) {
                System.out.println("あなたのお題は：" + od5[wolfIndex] + " です。");
                } else {
                System.out.println("あなたのお題は：" + od5[mainIndex] + " です。");
                }

        	System.out.println("見終わったらEnterで次へ");
        	sc.nextLine(); // 待つ

        // 画面を流す（簡易クリア）
        	for(int j = 0; j < 30; j++) System.out.println();
			}
		}
		else if(od[player].equals("人物")) {
			String od6[] = {"Aさん","Bさん"};
			Random rand = new Random();
			
			int mainIndex = rand.nextInt(2);
			int wolfIndex = 1 - mainIndex;

			int wolfPlayer = rand.nextInt(4) + 1;
		
			for(int i = 1; i <= 4; i++) {
				System.out.println(i + "人目だけ画面を見せてください。Enterで表示");
        	sc.nextLine(); // 待つ
        	if(i == wolfPlayer) {
                System.out.println("あなたのお題は：" + od6[wolfIndex] + " です。");
                } else {
                System.out.println("あなたのお題は：" + od6[mainIndex] + " です。");
                }

        	System.out.println("見終わったらEnterで次へ");
        	sc.nextLine(); // 待つ

        // 画面を流す（簡易クリア）
        	for(int j = 0; j < 30; j++) System.out.println();
			}
		}
		else if(od[player].equals("ゲーム")) {
			String od7[] = {"メガドライブ","セガサターン"};
			Random rand = new Random();
			int mainIndex = rand.nextInt(2);
			int wolfIndex = 1 - mainIndex;

			int wolfPlayer = rand.nextInt(4) + 1;
		
			for(int i = 1; i <= 4; i++) {
				System.out.println(i + "人目だけ画面を見せてください。Enterで表示");
        	sc.nextLine(); // 待つ
        	if(i == wolfPlayer) {
                System.out.println("あなたのお題は：" + od7[wolfIndex] + " です。");
                } else {
                System.out.println("あなたのお題は：" + od7[mainIndex] + " です。");
                }

        	System.out.println("見終わったらEnterで次へ");
        	sc.nextLine(); // 待つ

        // 画面を流す（簡易クリア）
        	for(int j = 0; j < 30; j++) System.out.println();
			}
		}
		else if(od[player].equals("漫画・アニメ")) {
			String od8[] = {"アニメ1","アニメ2"};
			Random rand = new Random();
			
			int mainIndex = rand.nextInt(2);
			int wolfIndex = 1 - mainIndex;

			int wolfPlayer = rand.nextInt(4) + 1;
		
			for(int i = 1; i <= 4; i++) {
				System.out.println(i + "人目だけ画面を見せてください。Enterで表示");
        	sc.nextLine(); // 待つ
        	if(i == wolfPlayer) {
                System.out.println("あなたのお題は：" + od8[wolfIndex] + " です。");
                } else {
                System.out.println("あなたのお題は：" + od8[mainIndex] + " です。");
                }

        	System.out.println("見終わったらEnterで次へ");
        	sc.nextLine(); // 待つ

        // 画面を流す（簡易クリア）
        	for(int j = 0; j < 30; j++) System.out.println();
			}
		}
		else if(od[player].equals("キャラクター")) {
			String od9[] = {"ファイン","レイン"};
			Random rand = new Random();
			
			int mainIndex = rand.nextInt(2);
			int wolfIndex = 1 - mainIndex;

			int wolfPlayer = rand.nextInt(4) + 1;
		
			for(int i = 1; i <= 4; i++) {
				System.out.println(i + "人目だけ画面を見せてください。Enterで表示");
	        	sc.nextLine(); // 待つ
	        	if(i == wolfPlayer) {
	                System.out.println("あなたのお題は：" + od9[wolfIndex] + " です。");
	                } else {
	                System.out.println("あなたのお題は：" + od9[mainIndex] + " です。");
	                }

	        	System.out.println("見終わったらEnterで次へ");
	        	sc.nextLine(); // 待つ

	        // 画面を流す（簡易クリア）
	        	for(int j = 0; j < 30; j++) System.out.println();
				}
		}
		else if(od[player].equals("職業")) {
			String od10[] = {"プログラマー","システムエンジニア"};
			Random rand = new Random();
			
			int mainIndex = rand.nextInt(2);
			int wolfIndex = 1 - mainIndex;

			int wolfPlayer = rand.nextInt(4) + 1;
		
			for(int i = 1; i <= 4; i++) {
				System.out.println(i + "人目だけ画面を見せてください。Enterで表示");
        	sc.nextLine(); // 待つ
        	if(i == wolfPlayer) {
                System.out.println("あなたのお題は：" + od10[wolfIndex] + " です。");
                } else {
                System.out.println("あなたのお題は：" + od10[mainIndex] + " です。");
                }

        	System.out.println("見終わったらEnterで次へ");
        	sc.nextLine(); // 待つ

        // 画面を流す（簡易クリア）
        	for(int j = 0; j < 30; j++) System.out.println();
			}
		}
		else if(od[player].equals("IT用語")) {
			String od11[] = {"ウォーターフォールモデル","スパイラルモデル"};
			Random rand = new Random();
			
			int mainIndex = rand.nextInt(2);
			int wolfIndex = 1 - mainIndex;

			int wolfPlayer = rand.nextInt(4) + 1;
		
			for(int i = 1; i <= 4; i++) {
				System.out.println(i + "人目だけ画面を見せてください。Enterで表示");
        	sc.nextLine(); // 待つ
        	if(i == wolfPlayer) {
                System.out.println("あなたのお題は：" + od11[wolfIndex] + " です。");
                } else {
                System.out.println("あなたのお題は：" + od11[mainIndex] + " です。");
                }

        	System.out.println("見終わったらEnterで次へ");
        	sc.nextLine(); // 待つ

        // 画面を流す（簡易クリア）
        	for(int j = 0; j < 30; j++) System.out.println();
			}
		}
		else if(od[player].equals("その他")) {
			String od12[] = {"a","b"};
			Random rand = new Random();
			
			int mainIndex = rand.nextInt(2);
			int wolfIndex = 1 - mainIndex;

			int wolfPlayer = rand.nextInt(4) + 1;
		
			for(int i = 1; i <= 4; i++) {
				System.out.println(i + "人目だけ画面を見せてください。Enterで表示");
	        	sc.nextLine(); // 待つ
	        	if(i == wolfPlayer) {
	                System.out.println("あなたのお題は：" + od12[wolfIndex] + " です。");
	                } else {
	                System.out.println("あなたのお題は：" + od12[mainIndex] + " です。");
	                }

	        	System.out.println("見終わったらEnterで次へ");
	        	sc.nextLine(); // 待つ

	        // 画面を流す（簡易クリア）
	        	for(int j = 0; j < 30; j++) System.out.println();
				}
		}
		
		
	}

}
