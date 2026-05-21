import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GyakutenPanel extends JPanel{
	JLabel label = new JLabel("<html>ウルフは市民のワードを当てたら逆転勝利！！<br>予想を入力してください<html>");
	JTextField textField = new JTextField();
	JButton button = new JButton("完了");
	public GyakutenPanel() {
		add(label);
		add(textField);
		add(button);
		button.addActionListener(e -> actionListener());
	}
	private void actionListener() {
		String text = textField.getText();
		if (text == "") {
			JOptionPane.showMessageDialog(null, "予想を入力してください");
			return;
		} else {
			if (text == Word.odai) {
				JOptionPane.showMessageDialog(null, "正解！お題は" + Word.odai + "でした。ウルフの逆転勝利！！");
			} else {
				JOptionPane.showMessageDialog(null,  "不正解！お題は!" + Word.odai + "でした。市民の勝利！！");
			}
		}
	}
}
