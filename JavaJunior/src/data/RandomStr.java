package data;

/**
 * Created by alpha on 16-7-17.
 * 生成验证码
 */
public class RandomStr {
    public void outStr() {
        String result = "";
        for (int i = 0; i < 6; i++) {
            int val = (int) (Math.random() * 26 + 97);
            result = result + (char) val;
        }
        System.out.println(result);
    }
}
