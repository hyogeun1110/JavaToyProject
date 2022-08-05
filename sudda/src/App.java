public class App {
    public static void main(String[] args) {
        System.out.println("게임을 시작합니다.");

        StartGame.getInstance().setPlayerNum(); // 플레이어 수
        StartGame.getInstance().setPlayerName(); // 플레이어 이름

        try {
            Shuffle.getInstance().handOutCard(); // 카드 분배
            new Reload().reloadCard();  // 카드1장 교체
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
