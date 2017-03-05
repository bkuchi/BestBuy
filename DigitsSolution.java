
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author kuchi
 */
public class DigitsSolution {

    public static void main(String[] args) {
        System.out.println(solution(9,9,9,9));
        System.out.println(solution(2,9,3,4));
    }

    public static String solution(int A, int B, int C, int D) {
        List<Integer> list = new ArrayList<Integer>() {
            {
                add(A);
                add(B);
                add(C);
                add(D);
            }
        };
        int digit1, digit2, digit3, digit4;
        String output = "Not Possible";
        try {
            digit1 = highest(list, i -> i < 3);
            digit2 = highest(list, i -> digit1 < 2 || i < 4);
            digit3 = highest(list, i -> i < 6);
            digit4 = highest(list, i -> true);
            output = "" + digit1 + digit2 + ":" + digit3 + digit4;
        } catch (InvalidInputException iie) {
            System.out.println();
        }
        return output;
    }

    public static int highest(List<Integer> values, Predicate<Integer> test) throws InvalidInputException {
        Optional optional = values.stream()
                .filter(test)
                .max(Comparator.naturalOrder());
        int max = 0;
        if (optional.isPresent()) {
            max = (int) optional.get();

            values.remove(Integer.valueOf(max));
            return max;
        }
        throw new InvalidInputException();
    }

    private static class InvalidInputException extends Exception {

        public InvalidInputException() {
        }
    }

}
