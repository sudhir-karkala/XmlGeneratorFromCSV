import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Utility class with methods for reading from csv into java object and generating xml output.
 *
 * @author sudhir on 19-Sep-2020
 */
public class IOUtility {
    public static Catalog readFromCSV(String path, String fileName) {
        Path filePath = Paths.get(path, fileName);
        Catalog catalog = new Catalog();
        try (BufferedReader reader = Files.newBufferedReader(filePath.toAbsolutePath(), StandardCharsets.UTF_8)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] cdAttributes = line.split(",");
                Cd newCd = new Cd();
                newCd.setCdAttributes(cdAttributes);
                catalog.addCdToCatalog(newCd);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return catalog;
    }

    public static void convertCSVToXML(Catalog catalog) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Catalog.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            try (OutputStream os = Files.newOutputStream(Paths.get("src/main/resources" + File.separatorChar + "cd-catalog.xml"))) {
                marshaller.marshal(catalog, os);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}