import abstracts.Shape;
import abstracts.Square;
import abstracts.Triangle;
import data.RandomStr;
import login.users.UserDB;
import objects.Bird;
import objects.Wolf;
import people.People;
import people.Student;
import people.Teacher;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by alpha on 16-7-14.
 */
public class HelloWood {

    public static void main(String arg[]) {
        //测试接口People
        /*testPeople();

        //测试使用构造方法
        测试使用构造方法();
        //断点调试
        hello();
        //调用方法事new对象
        useMethod(new ForTestMethod());
        //测试登陆
        测试登陆();


        //抽象类测试 输出面积
        抽象类测试输出面积();

//        你好();

        //测试随机生成验证码
        测试随机生成验证码();*/
//        added();
//        isSameString();
//        age();
//        for (int i = 0; i < 4; i++) {
//            System.out.println("hhhhhh");
//            continue;
////            break;
//        }
//        测试登陆();
        /**
         * 九九乘法表
         * maltiplication
         */
//        Maltiplication maltiplication = new Maltiplication();
//        maltiplication.maltiplication();
        /**
         *test Arrays Methods
         */
//        ArraysTest arraysTest = new ArraysTest();
//        arraysTest.arraysMethod();

        /**
         * use this
         */
//        This t = new This();
//        t.dog();

        /**
         * Test parameter
         * */
//        Param param = new Param();
//        param.source();
        /**
         * Test Constructor
         * */
//        Wolf wolf = new Wolf();
        /*
        * Test zuhe */
        Bird bird = new Bird();
        bird.breath();
        bird.fly();

        Wolf wolf = new Wolf();
        wolf.breath();
        wolf.run();
    }

    public static void age() {
        int age = 45;
        if (age > 20) {
            System.out.println("young");
        } else if (age > 40) {
            System.out.println("middle");
        } else if (age > 60) {
            System.out.println("old");
        }
    }


    public static void 测试随机生成验证码() {
        RandomStr randomStr = new RandomStr();
        randomStr.outStr();
        isSameString();
    }

    public static void 抽象类测试输出面积() {
        Shape shape;
        Square square = new Square(10, 20);
        Triangle triangle = new Triangle(10, 20);

        shape = square;
        System.out.println(shape.area());
        shape = triangle;
        System.out.println(shape.area());
    }

    public static void 测试登陆() {
        String account, password;
        UserDB userDB = new UserDB();
        try {
            System.out.println("请输入用户名：");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            account = String.valueOf(bufferedReader.readLine());
            System.out.println("请输入密码：");
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            password = String.valueOf(bufferedReader.readLine());
            userDB.set(account, password);
            userDB.connect();
            userDB.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void 测试使用构造方法() {
        ForTestMethod forTestMethod = new ForTestMethod();
        forTestMethod.forTestMethod();
    }

    public static void testPeople() {
        People people;
        people = new Student();
        people.peopleList();
        people = new Teacher();
        people.peopleList();
    }

    public static void added() {
        int a = 0;
        int b = 0;
        for (int i = 0; i < 10; i++) {
            System.out.println("a:" + a++);
            System.out.println("b:" + ++b);
        }
    }

    public static void isSameString() {
        String s0 = new String("你好啊");
        String s1 = new String("你好啊");
//        String s1 = "你好啊";
        String s2 = "你" + "好啊";
        System.out.println(s0 == s1);
        System.out.println(s0 == s2);
        System.out.println("你好啊".equals(s0));
    }

    public static void 你好() {
        int a = 1234_5678;
        int b = 2_2;
        System.out.println(a + "\t" + b);
        char c = '\u1999';
        System.out.println(c);
    }

    public static void useMethod(ForTestMethod forTestMethod) {
        forTestMethod.forTestMethod();
    }

    public static void hello() {
        int k = 0;
        for (int i = 0; i < 10; i++) {
            k++;
        }
    }


}

