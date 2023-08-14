package UserDetails;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserRepository {
    private static final Map<Integer, User> userMap = new HashMap<>();
    private static int userIdCounter = 1;

    public User saveUser(User user) {
        user.setId(userIdCounter++);
        userMap.put(user.getId(), user);
        return user;
    }

    public User getUser(int id) {
        return userMap.get(id);
    }

    public List<User> getAllUsers() {
        return new ArrayList<>(userMap.values());
    }

    public User updateUser(User user) {
        if (userMap.containsKey(user.getId())) {
            userMap.put(user.getId(), user);
            return user;
        }
        return null;
    }

    public boolean deleteUser(int id) {
        return userMap.remove(id) != null;
    }
}
