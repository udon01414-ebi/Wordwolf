import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class VotePanel extends JPanel {
	String[] playerNames;	//プレイヤー名管理
	JButton[] voteButtons = new JButton[10];		//投票ボタン
	JButton[] cancelButtons = new JButton[10];	//取消ボタン
	JButton completeButton = new JButton("完了");		//完了ボタン
	JLabel[] playerLabels = new JLabel[10];		//プレイヤー名前のラベル
	int voteAmounts[] = new int[10];		//投票数管理
	JLabel[] voteAmountLabels = new JLabel[10];	//投票数のラベル

	//コンストラクタ
	public VotePanel() {
		//プレイヤー名を取得
		this.playerNames = TestVotePanel.playerNames;
		//レイアウト決定(列数を4列に)
		setLayout(new GridLayout(0, 4));
		//プレイヤー数だけ繰り返して要素をパネルに追加していく
		for (int i = 0; i < playerNames.length; i++) {
			//ラムダ式用
			int ii = i;
			
			//プレイヤー名追加
			playerLabels[i] = new JLabel(playerNames[i]);
			add(playerLabels[i]);
			playerLabels[i].setHorizontalAlignment(JLabel.CENTER);

			//投票数追加
			voteAmountLabels[i] = new JLabel("現在" + voteAmounts[i] + "票");
			add(voteAmountLabels[i]);
			voteAmountLabels[i].setHorizontalAlignment(JLabel.CENTER);
			
			//投票ボタン追加
			voteButtons[i] = new JButton("投票");
			voteButtons[i].setPreferredSize(new Dimension(100, 50));
			add(voteButtons[i]);
			voteButtons[i].addActionListener(e -> voteActionListener(voteButtons[ii], ii));

			//取消ボタン追加
			cancelButtons[i] = new JButton("投票取消");
			cancelButtons[i].setPreferredSize(new Dimension(100, 50));
			add(cancelButtons[i]);
			cancelButtons[i].addActionListener(e -> cancelActionListener(cancelButtons[ii], ii));
		}
		//完了ボタン追加
		add(new JLabel(""));
		add(new JLabel(""));
		add(new JLabel(""));
		completeButton.setEnabled(false);	//初期状態は無効
		add(completeButton);
		completeButton.addActionListener(e -> completeActionListener(completeButton));
	}

	//投票ボタンが押されたら
	public void voteActionListener(JButton voteButton, int i) {
		int count = 0;	//総投票数の管理
		for(int j = 0; j < playerNames.length; j++) {
			count += voteAmounts[j];
		}
		
		//もし総投票数が人数と同じだったらなにもしない
		if (count >= playerNames.length) {
			return;
		}
		
		//投票数を1増やして表示させる
		voteAmounts[i] += 1;
		voteAmountLabels[i].setText("現在" + voteAmounts[i] + "票");
		
		//もし総投票数が人数と同じになったら完了ボタンを有効にする
		if (count + 1 == playerNames.length) {
			completeButton.setEnabled(true);
		}
	}

	//取消ボタンが押されたら
	private void cancelActionListener(JButton cancelButton, int i) {
		//もし投票数が0だったらなにもしない
		if(voteAmounts[i] <= 0) {
			return;
		}
		
		//投票数を1減らして表示させる
		voteAmounts[i] -= 1;
		voteAmountLabels[i].setText("現在" + voteAmounts[i] + "票");
		
		//完了ボタンを無効にする
		completeButton.setEnabled(false);
	}

	//完了ボタンが押されたら
	private void completeActionListener(JButton completeButton) {
		//次のパネルのインスタンス化
		TestNextPanel testNextPanel = new TestNextPanel();
		//このパネルの親を取得
		JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(VotePanel.this);
		//フレームに乗ってるものをすべて削除
		frame.getContentPane().removeAll();
		//次のパネルを追加
		frame.add(testNextPanel);
		//レイアウトの指定と計算
		frame.revalidate();
		frame.setSize(500, 500);
		frame.setLocationRelativeTo(null);
		frame.repaint();
	}
}
