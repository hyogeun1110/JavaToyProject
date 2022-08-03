import java.util.Scanner;

public class Player {
    static private int playerNum;
    static private String[] playerName;

    private static Player player;

    private Player(){}

    public static Player getInstance(){
        player = new Player();
        return player;
    }

    // 플레이하는 인원수 set
    public void setPlayerNum(){
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("플레이어 수 : ");
            int num = sc.nextInt();
            if (num > 5) {
                System.out.println("게임가능한 인원수는 5명 이하입니다");
            } else {
                playerNum = num;
                break;
            }
        }
        sc.close();
    }

    // 플레이하는 인원수 get
    public int getPlayerNum() {
        return playerNum;
    }

    public void setPlayerName(){
        playerName = new String[playerNum];
        for (int i=0; i<playerNum; i++){
            playerName[i] = "플레이어" + (i+1) ;
        }
    }

    public String[] getPlayerName(){
        return playerName;
    }

}
