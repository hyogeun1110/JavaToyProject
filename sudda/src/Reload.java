import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;


// 플레이어가 원하는 카드 한장 교
public class Reload {
    public void reloadCard(){
        System.out.println("카드1장을 교체합니다. 교체하지 않을 경우 x를 입력하세요.");
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        Loop : for (int i=0; i<Storage.players.size(); i++){
            Player player = Storage.players.get(i);

            System.out.print(player.getPlayerName() + "의 교체할 카드 : ");
            String reCard = scanner.nextLine();
            if (reCard.equals(player.getFirstCard()) || reCard.equals(player.getSecondCard()) && !reCard.equals("x")) {
                Loop2 : while (true) {
                    if (reCard.equals(player.getFirstCard())) {
                        int num = random.nextInt(20);
                        if (Storage.deckIndex.contains(num)) {
                            continue Loop2;
                        }
                        player.setFirstCard(Storage.deck[num]);
                        break Loop2;
                    }
                    if (reCard.equals(player.getSecondCard())) {
                        int num = random.nextInt(20);
                        if (Storage.deckIndex.contains(num)) {
                            continue Loop2;
                        }
                        player.setSecondCard(Storage.deck[num]);
                        break Loop2;
                    }
                }
            } else if (reCard.equals("x")) {
                continue Loop;
            } else {
                System.out.println("잘못된 입력입니다.");
                i--;
                continue Loop;
            }
        }
        try {
            Shuffle.getInstance().printPlayerCard();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
