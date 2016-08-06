package login.interfaces;

/**
 * Created by alpha on 16-7-15.
 */
public interface UserInfo {
    final String ACCOUNT = "root";
    final String PASSWORD = "123456";

    abstract void connect();
}
