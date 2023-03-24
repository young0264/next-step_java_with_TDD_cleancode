package nextstep.fp;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamStudy {

    public static long countWords() throws IOException {
        String contents = new String(Files.readAllBytes(Paths
                .get("src/main/resources/fp/war-and-peace.txt")), StandardCharsets.UTF_8);
        List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));

//        long count = 0;
//        for (String w : words) {
//            if (w.length() > 12) count++;
//        }
//        return count;
        return words.stream()
                .filter(x -> x.length() > 12)
                .count();
    }

    public static void printLongestWordTop100() throws IOException {
        String contents = new String(Files.readAllBytes(Paths
                .get("src/main/resources/fp/war-and-peace.txt")), StandardCharsets.UTF_8);
        List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));
        // TODO 이 부분에 구현한다. 12자가넘고, 긴순서대로, 중복허용x, 100개의 단어만을 소문자로 출력
        List<String> collect = words.stream()
                .filter(x -> x.length() > 12)
                .sorted(Comparator.reverseOrder())
                .distinct()
                .limit(100)
                .map(x -> x.toLowerCase())
                .collect(Collectors.toList());
        for (String c: collect) {
            System.out.println(c);
        }
    }

    public static List<Integer> doubleNumbers(List<Integer> numbers) {
        return numbers.stream().map(x -> 2 * x).collect(Collectors.toList());
    }

    public static long sumAll(List<Integer> numbers) {
        return numbers.stream().reduce(0, (x, y) -> x + y);
    }

    public static long sumOverThreeAndDouble(List<Integer> numbers) {
        return  numbers.stream()
                .filter(x -> x > 3)
                .map(x -> x * 2)
                .reduce(0, Integer::sum);
    }
}