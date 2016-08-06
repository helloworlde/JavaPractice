package command;

/**
 * Created by alpha on 16-7-20.
 */
public class AddCommand implements Command {
    @Override
    public void process(int[] target) {
        int sum = 0;
        for (int tar :
                target) {
            sum += tar;
        }
        System.out.println("数组元素和：" + sum);
    }
}
