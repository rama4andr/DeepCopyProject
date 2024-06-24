import objects.Man;
import objects.arrayClass.ArrayHolder;
import objects.collection.CollectionHolder;
import objects.innerClass.Address;
import objects.innerClass.Citizen;
import objects.mapClass.MapHolder;
import objects.recoursiveClass.Node;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

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
        System.out.println("-------------------------------");

        ArrayHolder arrayHolder = new ArrayHolder(new int[]{2, 4, 1}, new String[]{"B", "B", "C"});
        ArrayHolder copyArray = deepCopy(arrayHolder);

        System.out.println("Original: " + arrayHolder);
        System.out.println("Copy: " + copyArray);

        copyArray.getIntArray()[0] = 1;
        copyArray.getIntArray()[1] = 2;
        copyArray.getIntArray()[2] = 3;
        copyArray.getStringArray()[0] = "A";

        System.out.println("Modification:");
        System.out.println("Original: " + arrayHolder);
        System.out.println("Copy: " + copyArray);
        System.out.println("-------------------------------");

        CollectionHolder collectionHolder = new CollectionHolder(
                Arrays.asList("1", "2", "Three"), new HashSet<>(Arrays.asList(4, 5, 6))
        );
        CollectionHolder copyCollection = deepCopy(collectionHolder);

        System.out.println("Original: " + collectionHolder);
        System.out.println("Copy: " + copyCollection);

        copyCollection.getStringList().set(0, "One");
        copyCollection.getIntegerSet().add(8);

        System.out.println("Modification:");
        System.out.println("Original: " + collectionHolder);
        System.out.println("Copy: " + copyCollection);
        System.out.println("-------------------------------");

        HashMap<String, Integer> stringIntegerHashMap = new HashMap<>();
        stringIntegerHashMap.put("key1", 1);
        stringIntegerHashMap.put("key2", 4);
        MapHolder mapHolder = new MapHolder(stringIntegerHashMap);
        MapHolder mapCopy = deepCopy(mapHolder);

        System.out.println("Original: " + mapHolder);
        System.out.println("Copy: " + mapCopy);

        mapCopy.getMap().put("key3", 2);

        System.out.println("Modification:");
        System.out.println("Original: " + mapHolder);
        System.out.println("Copy: " + mapCopy);
        System.out.println("-------------------------------");

        Node node3 = new Node("Node 3", null);
        Node node2 = new Node("Node 2", node3);
        Node node1 = new Node("Node 1", node2);
        Node nodeCopy = deepCopy(node1);

        System.out.println("Original: " + node1);
        System.out.println("Copy: " + nodeCopy);

        nodeCopy.getNext().setValue("Copied node");

        System.out.println("Modification:");
        System.out.println("Original: " + node1);
        System.out.println("Copy: " + nodeCopy);
    }
}