public class Main {
    public static void main(String[] args) {
        // ユーザーの作成
        User user1 = new User();
        user1.setId("1");
        user1.setName("Taro");
        user1.setAge(25);

        User user2 = new User();
        user2.setId("2");
        user2.setName("Hanako");
        user2.setAge(24);

        User user3 = new User();
        user3.setId("3");
        user3.setName("Jiro");
        user3.setAge(27);

        // マッチングサービスの初期化
        MatchingService matchingService = new MatchingService();
        matchingService.addUser(user1);
        matchingService.addUser(user2);
        matchingService.addUser(user3); // user3をマッチングサービスに追加

        // マッチングのテスト
        System.out.println("User1's matches:");
        for (User matchedUser : matchingService.findMatches(user1)) {
            System.out.println(matchedUser.getName());
        }

        // マッチングのテスト for user3
        System.out.println("User3's matches:");
        for (User matchedUser : matchingService.findMatches(user3)) {
            System.out.println(matchedUser.getName());
        }

        // メッセージサービスの初期化
        MessageService messageService = new MessageService();
        // user1からuser2へメッセージを送信
        messageService.sendMessage(user1.getId(), user2.getId(), "Hello, Hanako!");
        // user3からマッチングしたユーザーへメッセージを送信（ここでは例としてuser1がマッチングしたと仮定）
        messageService.sendMessage(user3.getId(), user1.getId(), "Hello, Taro!");

        // メッセージの表示 for Hanako
        System.out.println("Messages for Hanako:");
        for (String message : messageService.getMessages(user2.getId())) {
            System.out.println(message);
        }

        // メッセージの表示 for Taro
        System.out.println("Messages for Taro:");
        for (String message : messageService.getMessages(user1.getId())) {
            System.out.println(message);
        }
    }
}
