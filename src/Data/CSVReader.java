package Data;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CSVReader {

    private List<String> columns;
    private List<List<String>> values;
    private Path path;

    //Class to read and save data from csv
    public CSVReader(String path){
        this.path = Path.of(path);
    }

    public void read(){
        try(BufferedReader br= Files.newBufferedReader(path)) {
            String firstLine=br.readLine().replace(" \"", "").replace("\"", "");
            if(firstLine!=null) {
                columns = Arrays.asList(firstLine.split(","));
                values = br.lines()
                        .map(line -> Arrays.asList(line.split(",")))
                        .collect(Collectors.toList());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void list(){
        for(int i = 0; i < columns.size(); i++){
            System.out.println("Column" + columns.get(i));
            for(int j = 0; j < values.size(); j++){
                System.out.println("Value (i: " + i + "; j: " + j + "): " + values.get(j).get(i));
            }
        }
        System.out.println("");
    }

    public String get(String col, int row){
                        //row             column
        return values.get(row).get(columns.indexOf(col));
    }
}
