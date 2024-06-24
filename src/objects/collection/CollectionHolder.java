package objects.collection;

import java.util.List;
import java.util.Set;

public class CollectionHolder {

    private List<String> stringList;

    private Set<Integer> integerSet;

    public CollectionHolder() {}

    public CollectionHolder(List<String> stringList, Set<Integer> integerSet) {
        this.stringList = stringList;
        this.integerSet = integerSet;
    }

    public List<String> getStringList() {
        return stringList;
    }

    public void setStringList(List<String> stringList) {
        this.stringList = stringList;
    }

    public Set<Integer> getIntegerSet() {
        return integerSet;
    }

    public void setIntegerSet(Set<Integer> integerSet) {
        this.integerSet = integerSet;
    }

    @Override
    public String toString() {
        return "CollectionHolder{" +
                "stringList=" + stringList +
                ", integerSet=" + integerSet +
                '}';
    }
}
