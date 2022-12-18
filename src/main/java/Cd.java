import jakarta.xml.bind.annotation.XmlElement;

/**
 * @author sudhir on 19-Sep-2020
 */
public class Cd {
    @XmlElement
    private String title;
    @XmlElement
    private String artist;
    @XmlElement
    private String country;
    @XmlElement
    private String company;
    @XmlElement
    private String price;
    @XmlElement
    private String year;

    public void setCdAttributes(String[] cdAttributes) {
        this.title = cdAttributes[0];
        this.artist = cdAttributes[1];
        this.country = cdAttributes[2];
        this.company = cdAttributes[3];
        this.price = cdAttributes[4];
        this.year = cdAttributes[5];
    }
}
