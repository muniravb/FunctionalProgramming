import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Main {

    public static boolean isGreaterThan3(int num) {
        System.out.println("isGreaterThan3 " + num);
        return num > 3;
    }

    public static boolean isEven(int num) {
        System.out.println("isEven " + num);
        return num % 2 == 0;
    }

    public static int doubleValue(int num) {
        System.out.println("doubleValue " + num);
        return (num * 2);
    }
    // print twice the value of the first even number greater than 3
    // within a list of Integers
    public static int doubleSlowly(int num) {
        try { Thread.sleep(1000); }catch(Exception ex) {	}
        System.out.println("doubleSlowly " + num);
        return num * 2;
    }

    public static void main(String[] args) {
        List<Integer> values = Arrays.asList(1, 2, 3, 5, 7, 4, 6, 8, 9, 10);

        // Relatively efficient solution of "traditional way" - telling
        // computer HOW to solve this problem step by step (including break)
        int targetValue = -1;
        for(int i: values) {
            if(isGreaterThan3(i) && isEven(i)) {
                targetValue = doubleValue(i);
                break;
            }
        }
        System.out.println(targetValue);

        // "functional way" - note that we are telling the computer WHAT
        // we want it to do without stating HOW to do it -
        // the compiler can make the solution efficient -
        // it is not on us to do so.
        //
        // *** Also note that methods are passed as arguments and these make
        // very clear instruction sets for other programmers to read. This approach
        // is often preferred over lambda expressions due to clarity
        Optional<Integer> value = values.stream()
                .filter(Main::isGreaterThan3)
                .filter(Main::isEven)
                .map(Main::doubleValue)
                .findFirst();
        if(value.isPresent()) {
            System.out.println(value.get());
        }

        // NOTE: if nothing is done with the value, the compiler does not
        // waste time calculating the value
        final Stream<Integer> temp = values.stream()
                .filter(Main::isGreaterThan3)
                .filter(Main::isEven)
                .map(Main::doubleValue);
//	    System.out.println(temp.findFirst().get());

        // Great example of ease of parallelism. Let's assume that our function
        // is very complex and takes about a second to run (simulated in doubleSlowly)
        // streaming takes a LONG time - 10 seconds. Try replacing ".stream" with ".parallelStream"
        System.out.println(values.parallelStream().mapToInt(Main::doubleSlowly).sum());

    }

}
