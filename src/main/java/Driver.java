import java.io.File;

/**
 * Given a csv file, convert it to xml format
 *
 * @author sudhir on 19-Sep-2020
 */
public class Driver {
    public static void main(String[] args) {
        String path = "src" + File.separator + "main" + File.separator + "resources";
        Catalog catalog = IOUtility.readFromCSV(path, "cd-catalog.csv");
        IOUtility.convertCSVToXML(catalog);
    }
}