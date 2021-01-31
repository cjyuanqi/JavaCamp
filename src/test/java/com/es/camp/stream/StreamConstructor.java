package com.es.camp.stream;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamConstructor {

    @Test
    public void streamForValue() {
        // 由数值直接构建流
        Stream<Integer> stream = Stream.of(1, 3, 4, 5, 8);
        stream.forEach(System.out::println);
    }

    @Test
    public void streamFromArray() {
        // 通过数组构建流
        int[] numbers = {1,2,3,4,5};
        IntStream stream = Arrays.stream(numbers);
        stream.forEach(System.out::println);
    }

    /**
     * 通过文件获取流
     * @throws IOException
     */
    @Test
    public void streamFromFile() throws IOException {
        String path = "/Users/chenjun/Work/projects/" +
                "JavaCamp/src/test/java/com/es/camp/stream" +
                "/StreamOperator.java";

        Stream<String> lines = Files.lines(Paths.get(path));
        lines.forEach(System.out::println);
    }



    @Test
    public void streamFromFunction() {
        // 从函数获取 stream 流
        Stream<Double> stream = Stream.generate(Math::random);
        stream.limit(100)
                .forEach(System.out::println);
    }


}
