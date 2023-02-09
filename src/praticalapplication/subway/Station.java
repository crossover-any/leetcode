package praticalapplication.subway;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * xxx
 *
 * @author: tengxq
 * @since: 2021/7/13 15:30
 */
public class Station {

    /**
     * 地铁站名称
     */
    private String name;

    /**
     * 地铁线路名
     */
    private String LineName;

    /**
     * 在当前线路时，所在站点的前一个站
     */
    private Station prevStation;

    /**
     * 在当前线路时，所在站点的后一个站
     */
    private Station nextStation;

    /**
     * 测试站点到某一个目标站点(key)所经过的所有站集合
     */
    private Map<Station,LinkedHashSet<Station>> ordermap = new HashMap<Station,LinkedHashSet<Station>>();

    public String getLinename() {
        return this.LineName;
    }

    public void setLinename(String lineName) {
        this.LineName = lineName;
    }

    public Station (String name){
        this.name = name;
    }


    public Station() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * 记录当前测试站点到目标站点所经过的所有站点，并储存
     *
     * @param station
     * @return
     */
    public LinkedHashSet<Station> getAllPassedStations(Station station) {
        if(ordermap.get(station) == null){
            LinkedHashSet<Station> set = new LinkedHashSet<Station>();
            set.add(this);
            ordermap.put(station, set);
        }
        return ordermap.get(station);
    }

    public Map<Station, LinkedHashSet<Station>> getOrderMap() {
        return ordermap;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        } else if(obj instanceof Station){
            Station s = (Station) obj;
            if(s.getName().equals(this.getName())){
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return this.getName().hashCode();
    }

    public String getLineName() {
        return LineName;
    }

    public void setLineName(String lineName) {
        LineName = lineName;
    }

    public Station getPrevStation() {
        return prevStation;
    }

    public void setPrevStation(Station prevStation) {
        this.prevStation = prevStation;
    }

    public Station getNextStation() {
        return nextStation;
    }

    public void setNextStation(Station nextStation) {
        this.nextStation = nextStation;
    }
}
