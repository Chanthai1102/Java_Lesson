package StreamAPIDemo;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamDemoNo1 {
    static List<String> names = List.of("dara","Thida","Cheta","Thida","Seyha");
    public static void main(String[] args) {
//        names.stream()
//                .distinct()
//                .forEach(System.out::println);
//        collectDemo();
//        List<Integer> collect = names.stream()
//                .map(String::length)
//                .distinct()
//                .collect(Collectors.toList());
//        System.out.println(collect);
    }



    static  void collectDemo(){
        Set<String> nameSet = names.stream().collect(Collectors.toSet());
        System.out.println(nameSet);
    }
}
