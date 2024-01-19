package StreamAPIDemo;

import java.util.List;
import java.util.stream.Stream;

public class StreamDemoNo3 {
    public static void main(String[] args) {
        List<String> names = List.of("dara","Thida","Cheta","Thida","Seyha");
        boolean anyMatch = names.stream()
                .anyMatch(name -> name.endsWith("a"));
        System.out.println(anyMatch);

        boolean allContainA = names.stream()
                .allMatch(p -> p.contains("a"));
        System.out.println(allContainA);

        Stream<String> nameStream = names.stream();
        long count = nameStream.count();
        System.out.println(count);

        
    }
}
