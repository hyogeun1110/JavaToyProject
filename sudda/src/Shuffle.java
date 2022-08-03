import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Shuffle {
    // 카드 배분하는 배열
    String[][] playerCard = new String[Player.getInstance().getPlayerNum()][2];

    // 카드나눠주기
    public void handOutCard() throws Exception {
        TimeUnit.MILLISECONDS.sleep(750);
        System.out.println("카드를 배분합니다.");
        Random random = new Random();
        for(int i=0; i< playerCard.length; i++){
            int num1 = random.nextInt(20);
            int num2 = random.nextInt(20);
            playerCard[i][0] = Card.deck[num1];
            playerCard[i][1] = Card.deck[num2];
            if (num1 == num2){
                i--;
                continue;
            }
            for(int j=0; j<i; j++){
                if (playerCard[i][0].equals(playerCard[j][0]) || playerCard[i][1].equals(playerCard[j][1])){
                    i--;
                }
            }
        }
        for (int i=0; i< playerCard.length; i++){
            TimeUnit.MILLISECONDS.sleep(1500);
            System.out.print(Player.getInstance().getPlayerName()[i] + " : ");
            TimeUnit.MILLISECONDS.sleep(1000);
            System.out.print(playerCard[i][0] + "  ");
            TimeUnit.MILLISECONDS.sleep(1000);
            System.out.print(playerCard[i][1] + "\n");
        }
    }
}
