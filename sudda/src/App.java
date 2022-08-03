public class App {
    public static void main(String[] args) {
        System.out.println("게임을 시작합니다.");

        Player.getInstance().setPlayerNum();  // 플레이어 수
        Player.getInstance().setPlayerName();  // 플레이어 이름 지정
        try {
            new Shuffle().handOutCard();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
