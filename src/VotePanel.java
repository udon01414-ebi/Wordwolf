import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class VotePanel extends JPanel{
	String playerNames[];
	JButton voteButton;
	public VotePanel() {
		TestVotePanel.playerNames = this.playerNames;
		setLayout(new GridLayout(((playerNames.length + 1) / 2), 4));
		for(int i = 0; i < playerNames.length; i++) {
			
		}
	}
}
