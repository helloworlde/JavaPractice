package command;

/**
 * Created by alpha on 16-7-20.
 */
public class PrintCommand implements Command {
    @Override
    public void process(int[] target) {
        for (int tar : target) {
            System.out.println("迭代输出数组元素：" + tar);
        }
    }
}
