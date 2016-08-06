package login.users;

import login.interfaces.SetInfo;
import login.interfaces.ShowResult;
import login.interfaces.UserInfo;

/**
 * Created by alpha on 16-7-15.
 */
public class UserDB implements ShowResult, UserInfo, SetInfo {
    String userAccount;
    String userPassword;
    String resultMessage;

    @Override
    public void set(String acc, String pass) {
        this.userAccount = acc;
        this.userPassword = pass;
    }

    @Override
    public void show() {
        System.out.println(resultMessage);
    }

    @Override
    public void connect() {
        if (userAccount.equals(UserInfo.ACCOUNT) && userPassword.equals(UserInfo.PASSWORD)) {
            resultMessage = "登陆成功";
        } else {
            resultMessage = "登陆失败，请检查账户和密码";
        }
    }
}
