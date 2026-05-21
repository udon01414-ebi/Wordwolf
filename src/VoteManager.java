import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class VoteManager extends JPanel{
	int[] voteAmounts;
	String[] playerNames;
	JLabel label = new JLabel();
	JButton Button = new JButton("結果を表示");
	static public int result;

	public VoteManager() {
		voteAmounts = VotePanel.voteAmounts;
		playerNames = User.playerNames;
		add(label);
		add(Button);
		Button.addActionListener(e -> resultActionListener());
		voteResult();
	}

	private void resultActionListener() {
		//勝敗結果パネルのインスタンス化
		ResultPanel resultPanel = new ResultPanel();
		//このパネルの親を取得
		JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(VoteManager.this);
		//フレームに乗ってるものをすべて削除
		frame.getContentPane().removeAll();
		//勝敗結果パネルを追加
		frame.add(resultPanel);
		//レイアウトの指定と計算
		frame.revalidate();
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.repaint();
	}

	private void voteResult() {
		String resultString = "";
		int max = 0;
		for (int i = 0; i < voteAmounts.length; i++) {
			if (voteAmounts[i] > max) {
				max = voteAmounts[i];
			}
		}
		for (int i = 0; i < voteAmounts.length; i++) {
			if (max == voteAmounts[i]) {
				if (resultString == "") {
					resultString = playerNames[i];
				} else {
					resultString = resultString + "と" + playerNames[i];
				}
			}
		}
		label.setText("最も票を集めたのは" + resultString + "でした。");
		
	}

}
