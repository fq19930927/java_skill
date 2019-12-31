package com.example.java_skill.jdk8.stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 流的构建
 *
 * @author fuqiang
 * @version StreamTest, v0.1 2019/12/31 10:14 上午
 */
public class StreamBuildTest {

    /**
     * 由数值构建流
     */
    public void streamFromValue() {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5);
        stream.forEach(System.out::println);
    }

    /**
     * 通过数组构建流
     */
    public void streamFromArray() {
        int[] nums = {1, 2, 3, 4, 5};
        IntStream stream = Arrays.stream(nums);
        stream.forEach(System.out::println);
    }

    /**
     * 由文件构建流
     *
     * @throws IOException
     */
    public void streamFromFile() throws IOException {
        Stream<String> stream = Files.lines(Paths.get("/code/java_skill/src/main/java/com/example/java_skill/jdk8/stream/StreamBuildTest.java"));
        stream.forEach(System.out::println);
    }

    /**
     * 通过函数构建流
     */
    public void streamFromFunction() {
        Stream<Integer> stream = Stream.iterate(0, n -> n + 2);
        Stream<Double> stream2 = Stream.generate(Math::random);
        stream.limit(100).forEach(System.out::println);
    }

    public static void main(String[] args) {
        new StreamBuildTest().streamFromFunction();
    }
}
