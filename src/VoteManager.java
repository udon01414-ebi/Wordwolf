import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class VoteManager {

    int playerCount;
    int wolfIndex;
    String[] playerNames;

    int[] votes;
    int currentVote = 0;

    JLabel label;
    JTextField input;
    JButton button;

    public VoteManager(int playerCount, int wolfIndex, String[] playerNames,
                       JLabel label, JTextField input, JButton button) {

        this.playerCount = playerCount;
        this.wolfIndex = wolfIndex;
        this.playerNames = playerNames;

        this.label = label;
        this.input = input;
        this.button = button;

        votes = new int[playerCount];
    }
	
	public void strartVote() {
		label.setText(playerNames[0]+"の番：誰が怪しい？");
		input.setText("");
		input.setVisible(true);
		button.setEnabled(true);
		
		   button.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                handleVote();
	            }
	        });
	    }

	 
	    public void handleVote() {
	    	try {
	    		int v = Integer.parseInt(input.getText());
	    		votes[v - 1]++;
	    	}catch(Exception e) {
	    		label.setText("正しい番号を入力してください");
	    		return;
	    	}
	    	
	    	currentVote++;
	    	
	    	if(currentVote<playerCount) {
	    		label.setText(playerNames[currentVote]+"の番；投票してください");
	    		input.setText("");
	    		
	    	} else {
	            showResult();
	        }
	    }
	    public void showResult() {
	    	int max = 0;
	    	int result =0;
	    	
	    	for(int i= 0; i<playerCount; i++) {
	    		if(votes[i]> max) {
	    			max = votes[i];
	    			result = i;
	    		}
	    	}
	    	if(result == wolfIndex) {
	    		label.setText(playerNames[result]+"は、ウルフでした！市民の勝ち！！");
	    	}else {
	    		label.setText(playerNames[result]+"は違った…ウルフの勝ち！！");
	    	}
	    	
	    	input.setVisible(false);
	    	button.setEnabled(false);
	    }

}
