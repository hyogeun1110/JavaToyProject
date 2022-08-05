import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Shuffle {
    private static Shuffle shuffle;

    private Shuffle(){}

    public static Shuffle getInstance(){
        if(shuffle == null) {
            shuffle = new Shuffle();
        }
        return shuffle;
    }

    // 카드나눠주기
    public void handOutCard() throws Exception {
        TimeUnit.MILLISECONDS.sleep(750);
        System.out.println("카드를 배분합니다.");
        Random random = new Random();
        Loop1 : for(int i=0; i<StartGame.getInstance().getPlayerNum(); i++) {
            int num1 = random.nextInt(20);
            int num2 = random.nextInt(20);
            Storage.players.get(i).setFirstCard(Storage.deck[num1]);
            Storage.players.get(i).setSecondCard(Storage.deck[num2]);
            if (num1 == num2) {
                i--;
                continue Loop1;
            }
            if (Storage.deckIndex.contains(num1) || Storage.deckIndex.contains(num2))
            {
                i--;
                continue Loop1;
            }
            Storage.deckIndex.add(num1);
            Storage.deckIndex.add(num2);
        }
        printPlayerCard();
    }

    //플레이어의 카드 출력
    public void printPlayerCard() throws Exception{
        for (int i=0; i< StartGame.getInstance().getPlayerNum(); i++) {
            TimeUnit.MILLISECONDS.sleep(1300);
            System.out.print(Storage.players.get(i).getPlayerName() + " : ");
            TimeUnit.MILLISECONDS.sleep(1000);
            System.out.print(Storage.players.get(i).getFirstCard() + "  ");
            TimeUnit.MILLISECONDS.sleep(1000);
            System.out.print(Storage.players.get(i).getSecondCard() + "\n");
        }
    }
}
