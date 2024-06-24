import objects.Man;

import java.util.Arrays;

import static util.CopyUtils.deepCopy;

public class Main {
    public static void main(String[] args) {
        Man man = new Man("Elon", 52, Arrays.asList("Tesla", "SpaceX"));
        Man manCopy = deepCopy(man);

        System.out.println("Original: " + man);
        System.out.println("Copy: " + manCopy);

        manCopy.setName("Pavel");
        manCopy.setAge(39);
        manCopy.getFavoriteBooks().add("Telegram");

        System.out.println("Modification:");
        System.out.println("Original: " + man);
        System.out.println("Copy: " + manCopy);
    }
}