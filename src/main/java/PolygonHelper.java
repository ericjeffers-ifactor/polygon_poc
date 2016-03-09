
import com.vividsolutions.jts.geom.*;
import org.geotools.geometry.DirectPosition2D;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.*;

/**
 * Created by ericjeffers on 3/8/16.
 */
public class PolygonHelper {

    private static final Logger logger = LoggerFactory.getLogger(PolygonHelper.class);

    public Polygon createPolygon(Coordinate[] coords) {
        GeometryFactory geometryFactory = new GeometryFactory();

        LinearRing ring = geometryFactory.createLinearRing( coords );
        LinearRing holes[] = null; // use LinearRing[] to represent holes
        Polygon polygon = geometryFactory.createPolygon(ring, holes );

        return polygon;
    }

    public boolean polyContains(Polygon poly, Coordinate coord, int numDecPlaces) {
        double scale = Math.pow(10, numDecPlaces);
        PrecisionModel pm = new PrecisionModel(scale);
        GeometryFactory gf = new GeometryFactory(pm);

        Geometry testPoint = gf.createPoint(coord);
        return poly.contains(testPoint);
    }


}
