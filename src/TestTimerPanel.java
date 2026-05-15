import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;

public class TestTimerPanel {

	public static void main(String[] args) {
		TimerPanel timerPanel = new TimerPanel();
		JFrame frame = new JFrame("ワードウルフ");
		timerPanel.setBorder(new EmptyBorder(50,0,50,0));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(480, 240);
		frame.add(timerPanel);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
