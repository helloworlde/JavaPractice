package test;

/**
 * Created by alpha on 16-7-19.
 */
public class ImmutableString {
    public ImmutableString() {
        String stirng = new String("hello");
        String string2 = new String("hello");
        System.out.println(stirng == string2);
        System.out.println(stirng.equals(string2));
        System.out.println(stirng.hashCode());
        System.out.println(string2.hashCode());
    }
}
