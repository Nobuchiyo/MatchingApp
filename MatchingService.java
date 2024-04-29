import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class MatchingService {
    private List<User> users;

    public MatchingService() {
        this.users = new ArrayList<>();
    }

    public void addUser(User user) {
        users.add(user);
    }

    public List<User> findMatches(User currentUser) {
        List<User> potentialMatches = new ArrayList<>(users); // 全ユーザーのコピーを作成
        Collections.shuffle(potentialMatches); // リストをランダムにシャッフル
        potentialMatches.removeIf(user -> user.getId().equals(currentUser.getId())); // 自分自身を除外

        // ここで、必要に応じてマッチングロジックをさらに調整できます

        return potentialMatches;
    }
}
