import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class MessageService {
    private Map<String, List<String>> messages; // ユーザーIDとメッセージのリスト

    public MessageService() {
        this.messages = new HashMap<>();
    }

    public void sendMessage(String senderId, String receiverId, String message) {
        messages.computeIfAbsent(receiverId, k -> new ArrayList<>()).add(message);
    }

    public List<String> getMessages(String userId) {
        return messages.getOrDefault(userId, new ArrayList<>());
    }
}
