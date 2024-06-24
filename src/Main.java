import objects.Man;
import objects.innerClass.Address;
import objects.innerClass.Citizen;

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

        System.out.println("-------------------------------");
        Address address = new Address("193230", "St P");
        Citizen citizen = new Citizen("Ram", 28, address);
        Citizen copyCitizen = deepCopy(citizen);

        System.out.println("Original: " + citizen);
        System.out.println("Copy: " + copyCitizen);

        copyCitizen.setName("Vik");
        copyCitizen.setAge(25);
        copyCitizen.getAddress().setCity("Minsk");

        System.out.println("Modification:");
        System.out.println("Original: " + citizen);
        System.out.println("Copy: " + copyCitizen);
    }
}