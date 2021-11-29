package Data;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class JSONReader {

    private List<String> columns;
    private List<List<String>> values;
    private Path path;

    //Class to read and save data from csv
    public JSONReader(String path) {
        this.path = Path.of(path);
    }

    public void read(){

    }
}
