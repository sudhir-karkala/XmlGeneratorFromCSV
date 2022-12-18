import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sudhir on 19-Sep-2020
 */
@XmlRootElement(name = "catalog")
public class Catalog {
    @XmlElement(name = "cd")
    private List<Cd> cdList;

    public void addCdToCatalog(Cd cd) {
        if (cdList == null) {
            cdList = new ArrayList<>();
        }
        cdList.add(cd);
    }
}
