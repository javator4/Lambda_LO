package pl.sda.lambda;


import java.util.*;
import java.util.function.Consumer;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@FunctionalInterface
interface Square{
    int square(int x);
}


public class App
{
    public static void main(String[] args)
    {
        List<String> names = Arrays.asList("Kasia", "Ania", "Zosia", "Bartek");
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        Collections.sort(names, (String s1, String s2) -> s1.compareTo(s2));

        System.out.println(names);

        Collections.sort(SampleData.membersOfTheBeatles, new Comparator<Artist>() {
            @Override
            public int compare(Artist o1, Artist o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        Square s = (int x) -> x * x;
        System.out.println(s.square(2));

        String[] a =
                {"cat", "dog", "mouse", "rat", "pig", "rabbit", "hamster", "parrot"};
        List<String> animals = Arrays.asList(a);
        for (String animal : animals) {
            System.out.print(animal + "; ");
        }

        animals.forEach( (x) -> System.out.println(x));
        animals.forEach(System.out::println);

        List<String> fruits =
                Arrays.asList("apple", "banana", "cherry", "plum", "pear", "pinapple");

       List<String> result = fruits.stream()
                .filter( (x) -> x.startsWith("a"))
                .map( (x) -> x.toUpperCase())
                .collect(Collectors.toList());

       int counter = 0;
       for(Artist members: SampleData.membersOfTheBeatles){
           if(members.getNationality().equals("UK")){
               counter++;
           }
       }

       long number = SampleData.membersOfTheBeatles
               .stream()
               .filter((x) -> x.getNationality()
                       .equals("UK")).count();

       List<String> stringList =  Stream.of("a", "b", "c")
               .map(x -> x.toUpperCase())
               .collect(Collectors.toList());

       List<String> stringList1 = Arrays.asList("a", "b", "c")
               .stream()
               .map(x -> x.toUpperCase())
               .collect(Collectors.toList());

        List<String> dataWithNumbers = Arrays.asList("a", "122as", "a23", "b32ss", "3a");
        for (String data: dataWithNumbers){
            if(Character.isDigit(data.charAt(0))){
                System.out.println(data);
            }
        }

       List<String> resultNumber =
               dataWithNumbers
                       .stream()
                       .filter( (x) -> Character.isDigit(x.charAt(0)))
                       .collect(Collectors.toList());
        resultNumber.forEach( (x) -> System.out.println(x));

       // [[2,3,4], [33,32, 44]] => [2,3,4,33,32,44]

        List<Integer> flat = Stream.of(Arrays.asList(2,3,4), Arrays.asList(33,32,44))
                .flatMap(numbers -> numbers.stream())
                .collect(Collectors.toList());




    }
}
