package arrays;

/**
 * Created by alpha on 16-7-17.
 */
public class Maltiplication {

    public void maltiplication() {
        for (int i = 0; i < 10; i++) {
            for (int j = 1; j < i + 1; j++) {
                System.out.print(i + "*" + j + "=" + i * j + "\t");
            }
            System.out.println("\n");
        }
    }
}
