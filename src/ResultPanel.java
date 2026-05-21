import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class ResultPanel extends JPanel {
	JLabel label = new JLabel();
	JButton button = new JButton("次へ");
	int[] result;
	int resultLength;

	public ResultPanel() {
		result = VoteManager.result;
		label.setFont(new Font("Serif", Font.BOLD, 15));
		label.setBackground(Color.black);
		label.setForeground(new Color(200, 0, 0));
		add(label);
		for (int i = 0; i < resultLength; i++) {

			if (result[i] == Word.wolfPlayer) {
				label.setText(User.playerNames[result[i]] + "は、ウルフでした！市民の勝ち...？");
				button.setFont(new Font("Serif", Font.BOLD, 15));
				button.setBackground(Color.black);
				button.setForeground(new Color(200, 0, 0));
				add(button);
				button.addActionListener(e -> ActionListener());
				return;
			}
		}
		if (resultLength == 1) {
			label.setText(User.playerNames[result[0]] + "は違った…ウルフの勝ち！！");
		} else {
			label.setText(User.playerNames[result[0]] + "たちは違った...ウルフの勝ち！！");
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
