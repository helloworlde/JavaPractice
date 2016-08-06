package stream;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by alpha on 16-8-3.
 * 字符流输出
 * 可以直接输出字符串到文件中
 */
public class FileWriterTest {
    public void test() {
        try (FileWriter fileWriter = new FileWriter("poem.txt")) {
            fileWriter.write("锦瑟 -李商隐\r\n");// \r\n时windows平台的换行符
            fileWriter.write("锦瑟无端五十弦，一弦一柱思华年\r\n");
            fileWriter.write("庄生晓梦迷蝴蝶，望帝春心托杜鹃\r\n");
            fileWriter.write("沧海月明珠有泪，蓝田日暖玉生烟\r\n");
            fileWriter.write("此情可待成追忆，只是当时已惘然\r\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
