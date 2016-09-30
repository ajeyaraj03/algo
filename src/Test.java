import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by ajeya.hb on 04/02/16.
 */

public class Test {

    public static void main(String[] args) {



        //Person asd = new Person();

        List<String> inputs = new ArrayList<>();
        inputs.add("Ajeya");
        inputs.add("Rama");
        System.out.println(1 ^ 2);

        List<String> output = inputs.stream().map(data -> {
            String abc = null;
//            if(data == "Ajeya")
//                abc = "Ajeya";
            return abc;
        }).collect(Collectors.toList());

//        List<String> output = inputs.stream().map(data -> data
//        ).collect(Collectors.toList());

        System.out.println(output);

//       System.out.println( Stream.of("d2", "a2", "b1", "b3", "c")
//                .filter(s -> {
//                    System.out.println("filter: " + s);
//                    return s.startsWith("b");
//                }) instanceof java.util.List );
//        inputs.stream().map(s -> s.toUpperCase())
//                .forEach(s -> System.out.println("forEach: " + s));
    }
}
