package praticalapplication.subway;

import java.util.ArrayList;
import java.util.List;

/**
 * xxx
 *
 * @author: tengxq
 * @since: 2021/7/13 15:37
 */
public class Line {

    public static List<Station> line = new ArrayList<>();

    public static List<Station> getLine() {
        return line;
    }

    public static void setLine(List<Station> line) {
        Line.line = line;
    }
}
