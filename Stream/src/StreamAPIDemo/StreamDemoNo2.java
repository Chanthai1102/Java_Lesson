package StreamAPIDemo;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemoNo2 {
    public static void main(String[] args) {
        List<Student> students = List.of(
                new Student("Dara", 24,List.of("Eng","Math")),
                new Student("Thai", 26,List.of("Kh","Math")),
                new Student("Chan", 27,List.of("Eng","Phy")),
                new Student("Chanthai", 29,List.of("Eng","Math"))
        );
//        List<List<String>> collect = students.stream()
//                .map(st -> st.getSubjects())
//                .collect(Collectors.toList());
        List<String> flatMap = students.stream()
                .flatMap(stu -> stu.getSubjects().stream())
                .distinct()
                .collect(Collectors.toList());

        System.out.println(flatMap);

        //Stream<List<String>>
    }
}
