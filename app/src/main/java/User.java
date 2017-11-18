/**
 * Created by hoang on 11/18/2017.
 */

public class User {
    public String email;
    public String uid;

    public User() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public User(String uid, String email) {
        this.uid = uid;
        this.email = email;
    }
}
