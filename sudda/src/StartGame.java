import java.util.Scanner;

public class StartGame {
    private int playerNum;

    private static StartGame startGame;

    private StartGame(){}

    public static StartGame getInstance(){
        if (startGame == null) {
            startGame = new StartGame();
        }
        return startGame;
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

    // 플레이어 이름 set
    public void setPlayerName(){
        for (int i=0; i<playerNum; i++){
            Player player = new Player();
            player.setPlayerName("플레이어" + (i+1));
            Storage.players.add(player);
        }
    }
}
