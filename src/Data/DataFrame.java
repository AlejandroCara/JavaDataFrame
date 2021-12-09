package Data;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;

public class DataFrame {

    private static DataFrame df = new DataFrame();

    private List<String> columns;
    private List<List<String>> values = new ArrayList<>();

    private DataFrame(){}

    public static DataFrame getInstance(){return df;}

    public static void setColumns(List inColumns){
        df.columns = inColumns;
    }

    public static void setValues(List<List<String>> inValues){
        df.values = inValues;
    }

    public static int numOfTags(){
        return df.columns.size();
    }

    public static String getTagAt(int i){
        return df.columns.get(i);
    }

    public static void addValue(List<String> inValue){
        df.values.add(inValue);
    }

    public static String at(int row, String col){
        List srow = df.values.get(row);
        int fd = df.columns.indexOf(col);
        return df.values.get(row).get(df.columns.indexOf(col));
    }

    public static String iat(int row, int col) {
        return df.values.get(row).get(col);
    }

    public static int columns() {
        return df.columns.size();
    }

    public static int size() {
        return df.values.size();
    }

    public static String sort(String col) {
        return null;
    }

    public static String query(String label) {
        return null;
    }
}
