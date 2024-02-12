import java.util.Arrays;
import java.util.Collection;
import java.util.stream.*;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        // Solve the problem statements below in a "traditional" way using the
        // collections defined here:
        Collection<Integer> coll = Arrays.asList(1, 2, 3, 4, 5);
        Collection <String> coll2 = Arrays.asList("a", "b", "hey", "yes");

        // Problem 1)  Sum the squares of all even numbers in "coll" and
        // save in an integer variable called "answer"

        //imperative style
        int answer = 0;
        for (Integer i : coll) {
            if (i%2 == 0){
                answer += i*i;
            }
        }
        System.out.println(answer);

        Integer answer2 = coll.stream()
            .filter(x -> x%2 ==0)
            .map(x -> x*x)
            .reduce(0, (x,y) -> x+y);

        System.out.println(answer2);
            

        // Problem 2) Save only the strings in "coll2" that are more than
        // one character long. The result should be saved in a List of Strings called
        // "longWords"

        // Problem 3) Using "coll2", make a String that combines all entries with ","
        // (so, create a String with "a, b, hey, yes" in this example and print it)

        // Problem 4) Using "coll2", identify the number of words which are longer
        // than one character and save that number in an integer called "longWordsCount"

        // Problem 5) Using "coll2", sum the length of all the words in the Collection
        // Store the result in "longWordsSum" and print it

        // We will now go over functional programming slides and revisit/rework these
        // problems using functional concepts
    }

}
