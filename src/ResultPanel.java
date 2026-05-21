import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class ResultPanel extends JPanel{
	JLabel label = new JLabel();
	JButton button = new JButton("次へ");
	int result;
	
	public ResultPanel() {
		result = VoteManager.result;
		add(label);
		if (result == Word.wolfPlayer) {
			label.setText(User.playerNames[result] + "は、ウルフでした！市民の勝ち...？");
			add(button);
			button.addActionListener(e -> ActionListener());
		} else {
			label.setText(User.playerNames[result] + "は違った…ウルフの勝ち！！");
		}
		
	}

	private void ActionListener() {
		//勝敗結果パネルのインスタンス化
		GyakutenPanel gyakutenPanel = new GyakutenPanel();
		//このパネルの親を取得
		JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(ResultPanel.this);
		//フレームに乗ってるものをすべて削除
		frame.getContentPane().removeAll();
		//勝敗結果パネルを追加
		frame.add(gyakutenPanel);
		//レイアウトの指定と計算
		frame.revalidate();
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.repaint();
	}
}
