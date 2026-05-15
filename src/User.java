

import javax.swing.JOptionPane;

public class User {
    private int memberCount;
    static private String[] playerNames; //名前保存

    public void inputMemberCount() {

        while (true) {
            String input = JOptionPane.showInputDialog("何人でプレイしますか❓（MAX１０人）");

            if (input == null) {
                JOptionPane.showMessageDialog(null, "さようなら( ;∀;)また来てね！");
                return;
            }

            if (input.isEmpty()) {
                JOptionPane.showMessageDialog(null, "入力が空です。数字を入力してください");
                continue;
            }

            try {
                int count = Integer.parseInt(input);

                
                if (count < 3 || count > 10) {
                    JOptionPane.showMessageDialog(null, "３〜１０人で入力をお願いします");
                } else {
                    this.memberCount = count;
                    displayCount();

                    boolean success = inputPlayerNames();

                    if (!success) {
                        JOptionPane.showMessageDialog(null, "人数入力に戻ります");
                        continue;
                    }

                    break;
                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "数字を入力してください");
            }
        }
    }

    public void displayCount() {
        JOptionPane.showMessageDialog(null, this.memberCount + "人でプレイします");
    }

    public boolean inputPlayerNames() {
        playerNames = new String[memberCount];

        for (int i = 0; i < memberCount; i++) {
            while (true) {
                String name = JOptionPane.showInputDialog("プレイヤー" + (i + 1) + " の名前を入力してください");

                if (name == null) {
                    if (i == 0) {
                        JOptionPane.showMessageDialog(null, "キャンセルされました。人数入力に戻ります");
                        return false;
                    }

                    JOptionPane.showMessageDialog(null, "キャンセルされました。前のプレイヤーに戻ります");
                    i--;
                    break;
                }

                if (name.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "名前が空です。もう一度入力してください");
                    continue;
                }

                playerNames[i] = name;
                break;
            }
        }

        if (!displayPlayerNames()) {
            return false;
        }

        return true;
    }

    public boolean displayPlayerNames() {
        StringBuilder sb = new StringBuilder("プレイヤー一覧:\n");
        for (int i = 0; i < playerNames.length; i++) {
            sb.append("プレイヤー").append(i + 1).append("：").append(playerNames[i]).append("\n");
        }

        int result = JOptionPane.showConfirmDialog(
                null,
                sb.toString() + "\nこの内容でよろしいですか？",
                "確認",
                JOptionPane.OK_CANCEL_OPTION
        );

        return result == JOptionPane.OK_OPTION;
    }

    public static void main(String[] args) {
        User user = new User();
        user.inputMemberCount();
    }
}
