package enums;

/**
 * Created by alpha on 16-7-21.
 */
public class EnumTest {
    public void judge(Season season) {
        switch (season) {
            case SPRING:
                System.out.println("春天");
                break;
            case SUMMER:
                System.out.println("夏天");
                break;
            case FALL:
                System.out.println("秋天");
                break;
            case WINTER:
                System.out.println("冬天");
                break;
        }
    }
}
