
import java.util.Random;
import java.util.Scanner;

class Word {

	public static void main(String[] args) {
		
		String od[] = {"食べ物", "施設","スポーツ","日本の地名","世界の国"};
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("お題のジャンルを選択します。この中から選んでください。");
		System.out.println("食べ物、施設、スポーツ、日本の地名、世界の国、");
		System.out.println("動物、人物、ゲーム、漫画・アニメ、キャラクター、");
		System.out.println("職業、IT用語、その他、ランダム");
		
		System.out.print("やりたいお題のジャンルの番号を入力してください > ");
		int player = sc.nextInt();
		System.out.println("やるジャンルは" + od[player] + "を選択しました");
		System.out.println("1人目だけ画面を見せるようにしてください");
		
		if(od[player] == "食べ物") {
			System.out.println("food");
			String tabeod1[] = {"みかん","ぽんかん"};
			Random rand = new Random();
			int odai = rand.nextInt(tabeod1.length);
			
			System.out.println("1人目のお題は" + tabeod1[odai] + "です");
			System.out.println("2人目だけ画面を見せるようにしてください");
			System.out.println("2人目のお題は" + tabeod1[odai] + "です");
			System.out.println("3人目だけ画面を見せるようにしてください");
			System.out.println("3人目のお題は" + tabeod1[odai] + "です");
			System.out.println("4人目だけ画面を見せるようにしてください");
			System.out.println("4人目のお題は" + tabeod1[odai] + "です");
		}
		else if(od[player] == "施設") {
			System.out.println("place");
			String shiseod1[] = {"美術館","博物館"};
			Random rand = new Random();
			int odai = rand.nextInt(shiseod1.length);
			
			System.out.println("1人目のお題は" + shiseod1[odai] + "です");
			System.out.println("2人目だけ画面を見せるようにしてください");
			System.out.println("2人目のお題は" + shiseod1[odai] + "です");
			System.out.println("3人目だけ画面を見せるようにしてください");
			System.out.println("3人目のお題は" + shiseod1[odai] + "です");
			System.out.println("4人目だけ画面を見せるようにしてください");
			System.out.println("4人目のお題は" + shiseod1[odai] + "です");
		}
		else if(od[player] == "スポーツ") {
			String od2[] = {"サッカー","ハンドボール"};
			Random rand = new Random();
			int odai = rand.nextInt(od2.length);
			
			System.out.println("1人目のお題は" + od2[odai] + "です");
			System.out.println("2人目だけ画面を見せるようにしてください");
		}
		else if(od[player] == "日本の地名") {
			String od3[] = {"新宿","渋谷"};
					Random rand = new Random();
			int odai = rand.nextInt(od3.length);
		
			System.out.println("1人目のお題は" + od3[odai] + "です");
			System.out.println("2人目だけ画面を見せるようにしてください");
		}
	}

}
