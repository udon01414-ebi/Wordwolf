import java.awt.Font;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class TimerPanel extends JPanel {
	int timeS = 10; //タイマーの秒数管理
	int timeM = 0; //タイマーの分数管理
	//タイマーのラベル
	JLabel timeLabel = new JLabel(timeM + ":" + (timeS < 10 ? "0" + timeS : timeS));

	//1秒おきに実行されるタイマータスク
	class task extends TimerTask {
		public void run() {
			updateTimer();
		}
	};

	//コンストラクタ
	public TimerPanel() {
		//タイマーのフォントサイズ変更
		timeLabel.setFont(new Font("MS ゴシック", Font.PLAIN, 50));

		//タイマーのラベルを画面に追加
		add(timeLabel);

		//1秒おきにtaskクラスを実行
		Timer timer = new Timer();
		timer.schedule(new task(), 1000);
	}

	//1秒おきに実行される内容
	public void updateTimer() {

		//秒数と分数を見て適切にタイマーを減算
		if (timeS <= 0 && timeM >= 1) {
			timeM -= 1;
			timeS += 59;
			updatePanel();
		} else if (timeS > 0) {
			timeS -= 1;
			updatePanel();
		} else { //もしタイマーが0だったら投票画面への遷移メソッドを実行
			runVotePanel();
			return;
		}

		//1秒のタイマーをまた実行
		Timer timer = new Timer();
		timer.schedule(new task(), 1000);
	}

	//パネルのアップデート
	private void updatePanel() {
		//ラベルを現在の分数・秒数に変更して更新
		timeLabel.setText(timeM + ":" + (timeS < 10 ? "0" + timeS : timeS));
		repaint();
	}

	//投票画面への遷移メソッド
	private void runVotePanel() {
		//投票パネルのインスタンス化
		VotePanel votePanel = new VotePanel();
		//このパネルの親を取得
		JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(TimerPanel.this);
		//フレームに乗ってるものをすべて削除
		frame.getContentPane().removeAll();
		//投票パネルを追加
		frame.add(votePanel);
		//レイアウトの指定と計算
		frame.revalidate();
		frame.setSize(600, 400);
		frame.setLocationRelativeTo(null);
		frame.repaint();
	}
}
