package innerclass;

/**
 * Created by alpha on 16-7-20.
 */
public class Cow {
    private double weight;

    public Cow() {

    }

    public Cow(double weight) {
        this.weight = weight;
    }

    public void test() {
        CowLeg cowLeg = new CowLeg("黑白相见", 1.12);
        cowLeg.info();
    }

    private class CowLeg {
        private double length;
        private String color;

        public CowLeg() {

        }

        public CowLeg(String color, double length) {
            this.color = color;
            this.length = length;
        }

        public double getLength() {
            return length;
        }

        public void setLength(double length) {
            this.length = length;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public void info() {
            System.out.println("当前牛腿颜色：" + color + ",高：" + length);
            System.out.println("牛重：" + weight);
        }
    }

}
