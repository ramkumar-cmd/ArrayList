import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class ArrayListPrograms {
    public static void main(String[] args)  {
//        arrayListOperations();
        stringListOperations();

    }
static void stringListOperations(){
     ArrayList<String> inputString = new ArrayList<>();
    inputString.add("Messi");
    inputString.add("Mbappe");
    inputString.add("David Luiz");
    inputString.add("Marcos Thuram");
    inputString.add("Ospina");
    //1.Write a code snippet to convert an ArrayList of strings to uppercase using streams.
    System.out.println(inputString.stream().map(x -> x.toUpperCase()).collect(Collectors.toList()));
    //2.Write a code snippet to sort an ArrayList of strings in alphabetical order using streams.
    System.out.println(inputString.stream().sorted().collect(Collectors.toList()));
    //3Write a code snippet to partition an ArrayList of strings into two lists based on whether the strings start with a vowel using streams.

    // 4. Write a code snippet to group an ArrayList of strings by their length using streams.
    //
    Map<String,Integer> inputMapa = inputString.stream().collect(Collectors.toMap(
            str -> str,
            str-> str.length()
    ));
    //5.Write a code snippet to join all elements of an ArrayList of strings into a single string separated by commas using streams.
    Optional<String> summation = inputString.stream().reduce((x,y) -> x +" "+ y);
    System.out.println(summation.get());
    //6Write a code snippet to count the number of unique words in an ArrayList of strings using streams
    long count = inputString.stream().distinct().count();
    System.out.println(count);
    //7 String input find charector occurence
    String input = "ramkumar vijayakumar";
    Map<Character,Integer> charectorOccurence = new HashMap<>();
    for(int i =0 ;i <input.length();i++)    {
        char inputChar =  input.charAt(i);
        charectorOccurence.computeIfPresent(inputChar,(k,v) -> {
            return v+1;
        });
        charectorOccurence.computeIfAbsent(inputChar,(v) -> {
            return 1;
        });
        //        if(charectorOccurence.containsKey(inputChar))   {
//            charectorOccurence.put(inputChar,charectorOccurence.get(inputChar)+1);
//        } else {
//            charectorOccurence.put(inputChar,1);
//        }

    }
    System.out.println(charectorOccurence);


}

static void arrayListOperations()   {
    List<Integer> input = getArrayListValuesInteger();

    //1.Get the Even number from the Array List
    System.out.println("Even Number"+input.stream().filter((x) -> x%2 ==0).collect(Collectors.toList()));

    //2. Get the largest number
    Optional<Integer> opt =  input.stream().max(Comparator.naturalOrder());
    System.out.println("Largest Number"+opt.get());

    //3.Write a code snippet to sort an ArrayList of integers in descending order using streams
    input.sort(Comparator.reverseOrder());
    System.out.println("Reverse Order"+input);

    //4.Write a code snippet to remove duplicates from an ArrayList of integers using streams
    System.out.println("Distinct Elements"+input.stream().distinct().collect(Collectors.toList()));

    //5.Write a code snippet to sum all the elements in an ArrayList of integers using streams.
    int summation = input.stream().reduce((x,y)-> x+y).get();
    System.out.println("Summation is"+summation);

    //6.Write a code snippet to count the number of elements in an ArrayList that match a given condition using streams
    System.out.println("Count abouve 10 is"+input.stream().filter( x -> x>10 ).count());

    //7.Write a code snippet to find the first element that matches a given condition in an ArrayList using streams.
    System.out.println("Find First is "+input.stream().filter(x-> x>10).sorted().findFirst().get());

    //8.Write a code snippet to find the average of all elements in an ArrayList of integers using streams.
    OptionalDouble avg = input.stream().mapToInt(i -> i).average();
    System.out.println(avg.getAsDouble());

    //9.Write a code snippet to check if all elements in an ArrayList of integers are positive using streams.
    System.out.println(input.stream().allMatch(x->x>0));

    //10.Write a code snippet to create a sublist of the first 5 elements from an ArrayList of integers using streams.
    List<Integer> subList = input.subList(0,3);
    //11.Find Second largest number in an array
    System.out.println(Arrays.asList(2,1,23,4,1,2).stream().sorted().skip(4).findFirst().get());
}
    static List<Integer> getArrayListValuesInteger(){
        List<Integer> inputString = new ArrayList<>();
        inputString.add(12);
        inputString.add(2);
        inputString.add(21);
        inputString.add(10);
    return inputString;
    }
}
