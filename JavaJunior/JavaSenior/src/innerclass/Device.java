package innerclass;

/**
 * Created by alpha on 16-7-20.
 */
public abstract class Device {
    private String name;

    public Device() {

    }

    public Device(String name) {
        this.name = name;
    }

    public abstract double getPrice();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}