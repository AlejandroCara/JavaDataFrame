package Readers;

import Data.DataFrame;
import Factories.ReaderFactory;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class JSONReader implements ReaderFactory {

    private List<String> columns;
    private List<List<String>> values;
    private Path path;

    //Class to read and save data from csv
    public JSONReader(String path) {
        this.path = Path.of(path);
    }

    public void read2(){
        try {
            BufferedReader br= Files.newBufferedReader(path);
            String firstLine=br.readLine().replace(" \"", "").replace("\"", "");
            if(firstLine!=null) {
                DataFrame.setColumns(Arrays.asList(firstLine.split(";")));
                //columns = Arrays.asList(firstLine.split(","));
                DataFrame.setValues(br.lines()
                        .map(line -> Arrays.asList(line))
                        .collect(Collectors.toList()));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void read(){

        FileReader filereader = null;
        try {
            filereader = new FileReader(String.valueOf(path));
            String jsonString = "";
            BufferedReader bufferedreader = new BufferedReader(filereader);
            JSONObject fds;
            String line = bufferedreader.readLine();
            //While we have read in a valid line
            while (line != null) {
                //Acumular las distintas lineas en un solo string
                line = line.trim();
                jsonString+=line;

                line = bufferedreader.readLine();
            }
            //Transformar el string a jsonArray
            JSONArray arr = new JSONArray(jsonString);
            //Coger el primer elemento para recoger los tags
            JSONObject obj = (JSONObject) arr.get(0);

            //Recoger los tags y setearlos a las columnas
            DataFrame.setColumns(obj.keySet().stream().toList());
            List<String> row ;
            for(int i = 0; i < arr.length(); i++){
                obj = (JSONObject) arr.get(i);
                row = new ArrayList<String>();
                for(int j = 0; j < DataFrame.numOfTags(); j++){
                    row.add(String.valueOf(obj.get(DataFrame.getTagAt(j))));
                }
                DataFrame.addValue(row);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
