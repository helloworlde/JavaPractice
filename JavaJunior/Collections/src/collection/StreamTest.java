package collection;

import java.util.stream.IntStream;

/**
 * Created by alpha on 16-7-31.
 * Stream
 */
public class StreamTest {
    public void testStream() {
        IntStream intStream = IntStream.builder()
                .add(1)
                .add(2)
                .add(3)
                .add(4)
                .add(5)
                .build();
        intStream.forEach(System.out::println);
    }
}
