import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by alpha on 16-7-23.
 */
public class Zhengze {
    /**
     * 截取电话号码
     */
    public void regex() {

        String string = "This is first Number 13233332222" +
                "This is second Number 13522223331" +
                "联系方式：18633442211";
        Matcher matcher = Pattern.compile("((13\\d)|(18\\d))\\d{8}").matcher(string);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }

    /**
     * 验证电子邮件
     */
    public void email() {
        String[] mails = {
                "hhhhhh@qq.com",
                "zhangsan@gmail.com",
                "li@mail.com",
                "HelloWood@google.com"
        };
        String mailRegex = "\\w{3,20}@\\w+\\.(com|org|cn|gov)";
        Pattern pattern = Pattern.compile(mailRegex);
        Matcher matcher = null;
        for (String mail :
                mails) {
            if (matcher == null) {
                matcher = pattern.matcher(mail);
            } else {
                matcher.reset(mail);
            }
            String result = mail + (matcher.matches() ? "是" : "不是") + "有效的邮件地址";
            System.out.println(result);
        }
    }

    /**
     * replace
     */
    public void replace() {
        String[] strings = {
                "Java has regular expressions in 1.4",
                "regular expressions now expressing in java",
                "java represses oracular expressing"
        };
        Pattern pattern = Pattern.compile("re\\w*");
        Matcher matcher = null;
        for (int i = 0; i < strings.length; i++) {
            if (matcher == null) {
                matcher = pattern.matcher(strings[i]);
            } else {
                matcher.reset(strings[i]);
            }
            System.out.println(matcher.replaceAll("哈哈哈"));

        }
    }

    /**
     * replace,split
     */
    public void split() {
        String[] strings = {
                "Java has regular expressions in 1.4",
                "regular expressions now expressing in java",
                "java represses oracular expressing",
                "小米Note 恍恍惚惚 红红火火 哈哈哈"
        };
        for (String str :
                strings) {
//            System.out.println(str.replaceFirst("re\\w*","哈哈---"));
            System.out.println(Arrays.toString(str.split(" ")));
        }
    }


    /**
     * 截取字符串中的数字或字符并存入数组中
     */
    public void subStringAndDigit() {
        int[] num = new int[10];
        int i = 0;
        int j = 0;
        String[] strings = new String[10];
        String string = "A1B2C3D4E5F6G7H8I9J0abc";
        Matcher matcherInt = Pattern.compile("\\d").matcher(string);
        while (matcherInt.find()) {
//            System.out.println(matcherInt.group());
            num[i++] = Integer.parseInt(matcherInt.group());
        }
        Matcher matcherString = Pattern.compile("[A-Z]").matcher(string);
        while (matcherString.find()) {
//            System.out.println(matcherString.group());
            strings[j++] = matcherString.group();
        }
//        System.out.println(num[4]);
        System.out.println(Arrays.toString(strings));
        Arrays.parallelSort(num);

        System.out.println(Arrays.toString(num));
    }
}
