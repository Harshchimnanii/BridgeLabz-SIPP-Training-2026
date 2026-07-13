import java.util.Arrays;
import java.util.List;

public class GenericsDemo {

    public static void main(String[] args) {
        Pair<String, Integer> studentScore = new Pair<>("Aisha", 95);
        System.out.println("Pair example: " + studentScore);

        GenericStack<String> stack = new GenericStack<>();
        stack.push("First");
        stack.push("Second");
        System.out.println("Stack peek: " + stack.peek());
        System.out.println("Stack pop: " + stack.pop());

        Integer[] numbers = {4, 8, 2, 11, 7};
        System.out.println("Max number: " + GenericUtils.findMax(numbers));

        String[] words = {"apple", "banana", "orange"};
        System.out.println("Max word: " + GenericUtils.findMax(words));

        Repository<String> stringRepo = new Repository<>();
        stringRepo.add("Item1");
        stringRepo.add("Item2");
        System.out.println("Repository items: " + stringRepo.findAll());

        List<Double> doubles = Arrays.asList(1.5, 2.5, 3.5);
        GenericUtils.printList(doubles);

        List<String> strings = Arrays.asList("hello", "world");
        GenericUtils.printList(strings);
    }
}
