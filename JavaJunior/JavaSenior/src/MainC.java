import enums.EnumTest;
import enums.Operation;
import enums.Season;

/**
 * Created by alpha on 16-7-19.
 */
public class MainC {
    public static void main(String[] args) {
        /**
         * 执行包装类的方法
         * */
//        UnsignedTest unsignedTest = new UnsignedTest();
        /**
         * 执行单例模式
         * */
//        Singleton singleton = Singleton.getInstance();
//        Singleton singleton1 = Singleton.getInstance();
//        System.out.println(singleton == singleton1);
//
//        Sing sing = Sing.getInstance();
//        Sing sing1 = Sing.getInstance();
//        System.out.println(sing == sing1);
        /**
         * 字符串内存中的存在方式*/
//        ImmutableString immutableString = new ImmutableString();
        /**
         * 抽象方法和抽象类*/
//        Shape tri = new Triangle("三角形", 3, 4, 5);
//        Shape cir = new Circle("圆形", 3);
//        System.out.println(tri.getType());
//        System.out.println(tri.calPerimeter());
//        System.out.println(cir.getType());
//        System.out.println(cir.calPerimeter());
        /**
         * 接口*/
//        System.out.println(Output.MAX_CACHE_LINE);
//        System.out.println(Output.staticTest());
        /**
         * 命令模式*/
//        ProcessArray processArray = new ProcessArray();
//        int[] target = {3, -4, 6, 5};
//        processArray.process(target, new PrintCommand());
//        System.out.println("-----------");
//        processArray.process(target, new AddCommand());

        /**
         * 内部类*/
//        Cow cow = new Cow(300);
//        cow.test();
        /**
         * 使用抽象类实现匿名内部类
         * */
//        AnonymousInner anonymousInner = new AnonymousInner();
//        anonymousInner.test(new Device("电子示波器") {
//            @Override
//            public double getPrice() {
//                return 99;
//            }
//        });
//
//        Device device = new Device() {
//            {
//                System.out.println("匿名内部类初始化块");
//            }
//
//            @Override
//            public double getPrice() {
//                return 199;
//            }
//
//            @Override
//            public String getName() {
//                return "键盘";
//            }
//        };
//
//        anonymousInner.test(device);

        /**
         * 使用接口实现匿名内部类
         * */
//        AnonymousTest anonymousTest = new AnonymousTest();
//        anonymousTest.test(new Product() {
//            @Override
//            public double getPrice() {
//                return 999;
//            }
//
//            @Override
//            public String getName() {
//                return "显示器";
//            }
//        });
        /**
         * Lambda表达式代替匿名内部类*/
//        LambdaQs lambdaQs = new LambdaQs();
//        lambdaQs.eat(()-> System.out.println("苹果的味道不错"));
//        lambdaQs.drive(weather -> {
//            System.out.println("今天天气："+weather);
//            System.out.println("飞机平稳飞行");
//        });
//        lambdaQs.test(((a, b) -> a+b));
        /**
         * Lambda表达式
         * 引用类方法
         * convert()方法执行体就是Lambda表达式的代码块部分
         * */
//        Converter converter = from -> Integer.valueOf(from);
//        Converter converter1 = Integer::valueOf;//方法引用代替Lambda表达式：引用类方法
//        Integer val = converter.convert("99");
//        System.out.println(val);
        /**
         * Lambda表达式
         * 引用某类对象的实例方法
         * */
//        MyTest myTest = ((a, b, c) -> a.substring(b, c));
//
//        MyTest myTest1 = String::substring;
//        String s = myTest1.test("Hello Wood!", 2, 5);
//        System.out.println(s);
        /**
         * Lambda表达式
         * 引用构造器
         * */
//        YourTest yourTest = (String a) -> new JFrame(a);
//        YourTest yourTest1 = JFrame::new;
//        JFrame jFrame = yourTest1.win("我的窗口");
//        System.out.println(jFrame);

        /**
         * Lambda表达式
         * 匿名内部类
         * */
//        LambdaAndInner lambdaAndInner = new LambdaAndInner();
//        lambdaAndInner.test();
        /**
         * Lambda表达式
         * 调用Arrays的类方法
         * */
//        String[] arr1 = new String[]{"Java", "Android", "iOS", "Python", "C"};
//        Arrays.parallelSort(arr1, ((o1, o2) -> o1.length() - o2.length()));
//        System.out.println(Arrays.toString(arr1));
//
//        int[] arr2 = new int[]{2, 4, -2, 6, 7};
//        Arrays.parallelPrefix(arr2, ((left, right) -> left * right));
//        System.out.println(Arrays.toString(arr2));
//
//        long[] arr3 = new long[5];
//        Arrays.parallelSetAll(arr3, operand -> operand * 5);
//        System.out.println(Arrays.toString(arr3));

        /**
         * 枚举
         * */
        for (Season s : Season.values()) {
            System.out.println(s);
        }

        new EnumTest().judge(Season.FALL);

        System.out.println(Operation.PLUS.eval(3, 4));
    }

}
