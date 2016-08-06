import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.*;

/**
 * Created by alpha on 16-7-22.
 * 主要讲解java基础类库
 */
public class MainC {
    public static void main(String[] args) {

        /**
         * main方法的args参数
         * */
//        mainArgs(args);
        /**
         * 使用Scanner获取键盘输入
         * */
//        scanner();

        /**
         * System类
         * */
//        system();
        /**
         * HashCode
         * */
//        hashCodes();
        /**
         * Runtime
         * */
//        runtime();

        /**
         * Objects
         * */
//        objectsTool();
        /**
         * Stirng,StringBuffer,StringBuilder
         * */
//        stringBu();
        /**
         * Internationalization
         * */
//        internationalization();
        /**
         * NumberFormat
         * */
//        numberFormat();
        /**
         * DataFormat
         * */
//        dataFormat();
//        simpleDateFormat();

//        dateTimeFormatter();
//        dateTimeFormatter2();
        Zhengze zhengze = new Zhengze();
//        zhengze.regex();
//        zhengze.email();
//        zhengze.replace();
//        zhengze.split();
        zhengze.subStringAndDigit();
    }

    /**
     * DateTimeFormatter解析字符串
     */
    public static void dateTimeFormatter2() {
        String str1 = "2015==04==12 01时06分09秒";
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy==MM==dd HH时mm分ss秒");
        LocalDateTime localDateTime = LocalDateTime.parse(str1, dateTimeFormatter);
        System.out.println(localDateTime);
        String str2 = "2013**四月*****12 20时";
        DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofPattern("yyyy**MMM*****dd HH时");
        LocalDateTime localDateTime1 = LocalDateTime.parse(str2, dateTimeFormatter1);
        System.out.println(localDateTime1);
    }

    /**
     * DateTimeFormatter格式化
     */
    public static void dateTimeFormatter() {
        DateTimeFormatter[] formatters = new DateTimeFormatter[]{
                DateTimeFormatter.ISO_LOCAL_DATE,
                DateTimeFormatter.ISO_LOCAL_TIME,
                DateTimeFormatter.ISO_LOCAL_DATE_TIME,
                DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM),
                DateTimeFormatter.ofLocalizedTime(FormatStyle.LONG),
                DateTimeFormatter.ofPattern("Gyyyy年 MMMdd HH:mm:ss")
        };
        LocalDateTime dateTime = LocalDateTime.now();
        for (int i = 0; i < formatters.length; i++) {
            System.out.println(dateTime.format(formatters[i]));
            System.out.println(formatters[i].format(dateTime));
        }
    }

    /**
     * SimpleDateFormat
     */
    public static void simpleDateFormat() {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("Gyyyy年中的第D天");
        String dateStr = simpleDateFormat.format(date);
        System.out.println(dateStr);
        String str = "16###三月##21";
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("y###MMM##d");
        try {
            System.out.println(simpleDateFormat1.parse(str));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static void dataFormat() {
        Date date = new Date();
        Locale[] locales = {Locale.CHINA, Locale.US};
        DateFormat[] dateFormats = new DateFormat[16];
        for (int i = 0; i < locales.length; i++) {
            dateFormats[i * 8] = DateFormat.getDateInstance(DateFormat.SHORT, locales[i]);
            dateFormats[i * 8 + 1] = DateFormat.getDateInstance(DateFormat.MEDIUM, locales[i]);
            dateFormats[i * 8 + 2] = DateFormat.getDateInstance(DateFormat.LONG, locales[i]);
            dateFormats[i * 8 + 3] = DateFormat.getDateInstance(DateFormat.FULL, locales[i]);
            dateFormats[i * 8 + 4] = DateFormat.getTimeInstance(DateFormat.SHORT, locales[i]);
            dateFormats[i * 8 + 5] = DateFormat.getTimeInstance(DateFormat.MEDIUM, locales[i]);
            dateFormats[i * 8 + 6] = DateFormat.getTimeInstance(DateFormat.LONG, locales[i]);
            dateFormats[i * 8 + 7] = DateFormat.getTimeInstance(DateFormat.FULL, locales[i]);
        }
        for (int i = 0; i < locales.length; i++) {
            String tip = i == 0 ? "------中国格式-------" : "------美国格式------";
            System.out.println(tip);
            System.out.println("日期：SHORT  ：" + dateFormats[i * 8].format(date));
            System.out.println("日期：MEDIUM ：" + dateFormats[i * 8 + 1].format(date));
            System.out.println("日期：LONG   ：" + dateFormats[i * 8 + 2].format(date));
            System.out.println("日期：FULL   ：" + dateFormats[i * 8 + 3].format(date));
            System.out.println("时间：SHORT  ：" + dateFormats[i * 8 + 4].format(date));
            System.out.println("时间：MEDIUM ：" + dateFormats[i * 8 + 5].format(date));
            System.out.println("时间：LONG   ：" + dateFormats[i * 8 + 6].format(date));
            System.out.println("时间：FULL   ：" + dateFormats[i * 8 + 7].format(date));
        }
    }

    public static void mainArgs(String[] args) {
        System.out.println(args.length);
        for (String arg :
                args) {
            System.out.println(arg);
        }
    }

    public static void scanner() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入：");
        while (scanner.hasNext()) {
            System.out.println("输入内容" + scanner.next());
        }

        try {
            Scanner readFile = new Scanner(new File("MainC.java"));
            System.out.println("MainC.java内容如下：");
            while (readFile.hasNextLine()) {
                System.out.println(readFile.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void system() {
        Map<String, String> env = System.getenv();
        for (String name :
                env.keySet()) {
            System.out.println(name + ":\t" + env.get(name));
        }
        System.out.println("\n");
        System.out.println(System.getenv("HOME"));
        Properties properties = System.getProperties();
        try {
            properties.store(new FileOutputStream("properties.txt"), "System Properties");
            System.out.println(System.getProperty("os.name"));
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }

    public static void hashCodes() {
        String s1 = new String("hello");
        String s2 = new String("hello");
        System.out.println(s1 == s2);
        System.out.println(s1.hashCode() == s2.hashCode());
        System.out.println(System.identityHashCode(s1) == System.identityHashCode(s2));
    }

    public static void runtime() {
        Runtime runtime = Runtime.getRuntime();
        System.out.println("处理器数量：" + runtime.availableProcessors());
        System.out.println("空闲内存数：" + runtime.freeMemory());
        System.out.println("总内存数：" + runtime.totalMemory());
        System.out.println("可用最大内存：" + runtime.maxMemory());
    }

    public static void objectsTool() {
        String s = "hello";
        System.out.println(Objects.hashCode(s));
        System.out.println(Objects.toString(s));
        System.out.println(Objects.requireNonNull(s, "空指针异常"));
    }

    public static void stringBu() {
        String s1 = new String("helloWood");
        String s2 = new String("hello");//返回长度差
        String s3 = new String("helloWod");//返回'o'-'d'的差
        System.out.println(s1.compareTo(s2));
        System.out.println(s1.compareTo(s3));
    }

    public static void internationalization() {
        Locale[] locales = Locale.getAvailableLocales();
        for (int i = 0; i < locales.length; i++) {
            System.out.println(locales[i].getDisplayCountry() + "=" +
                    locales[i].getCountry() + " " +
                    locales[i].getDisplayLanguage() + "=" +
                    locales[i].getLanguage());
        }
    }

    public static void numberFormat() {
        double db = 1234000.567;
        Locale[] locales = {Locale.CHINA, Locale.JAPAN, Locale.US, Locale.GERMAN};
        NumberFormat[] numberFormat = new NumberFormat[12];
        System.out.println(numberFormat.length);
        for (int i = 0; i < locales.length; i++) {
            numberFormat[i * 3] = NumberFormat.getNumberInstance(locales[i]);
            numberFormat[i * 3 + 1] = NumberFormat.getPercentInstance(locales[i]);
            numberFormat[i * 3 + 2] = NumberFormat.getCurrencyInstance(locales[i]);
        }
        for (int i = 0; i < locales.length; i++) {
            String tip =
                    i == 0 ? "------中国格式-------" :
                            i == 1 ? "-------日本格式-------" :
                                    i == 2 ? "------美国格式------" :
                                            "------德国格式------";
            System.out.println(tip);
            System.out.println("通用数值格式：" + numberFormat[i * 3].format(db));
            System.out.println("百分比数值格式：" + numberFormat[i * 3 + 1].format(db));
            System.out.println("货比数值格式：" + numberFormat[i * 3 + 2].format(db));
        }
    }
}
