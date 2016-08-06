package tests;

public class First implements C {

    public static int b, c;

    @Override
    public int getC() {
        return c;
    }

    @Override
    public void setC(int i) {
        this.c = i;
    }
}
