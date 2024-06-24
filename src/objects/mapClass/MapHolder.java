package objects.mapClass;

import java.util.Map;

public class MapHolder {

    private Map<String, Integer> map;

    public MapHolder() {}

    public MapHolder(Map<String, Integer> map) {
        this.map = map;
    }

    public Map<String, Integer> getMap() {
        return map;
    }

    public void setMap(Map<String, Integer> map) {
        this.map = map;
    }

    @Override
    public String toString() {
        return "MapHolder{" +
                "map=" + map +
                '}';
    }


}
