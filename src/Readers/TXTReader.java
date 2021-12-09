package Readers;

import Data.DataFrame;
import Factories.ReaderFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.stream.Collectors;

public class TXTReader implements ReaderFactory {

    private Path path;

    public TXTReader(String path) {
        this.path = Path.of(path);
    }

    public void read(){
        try {
            BufferedReader br= Files.newBufferedReader(path);
            String firstLine=br.readLine().replace(" \"", "").replace("\"", "");
            if(firstLine!=null) {
                DataFrame.setColumns(Arrays.asList(firstLine.split(";")));
                //columns = Arrays.asList(firstLine.split(","));
                DataFrame.setValues(br.lines()
                        .map(line -> Arrays.asList(line.split(";")))
                        .collect(Collectors.toList()));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
