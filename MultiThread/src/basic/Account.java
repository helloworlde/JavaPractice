package basic;

/**
 * Created by alpha on 16-8-12.
 */
public class Account {
    private ThreadLocal<String> name = new ThreadLocal<>();

    public Account(String name) {
        this.name.set(name);
        System.out.println("----"+this.name.get());
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }
}
