package Data;

import java.util.ArrayList;
import java.util.List;

public class DataFrame {

    private static List<String> columns;
    private static List<List<String>> values = new ArrayList<>();

    public DataFrame(){

    }

    public static void setColumns(List inColumns){
        columns = inColumns;
    }

    public static void setValues(List<List<String>> inValues){
        values = inValues;
    }

    public static int numOfTags(){
        return columns.size();
    }

    public static String getTagAt(int i){
        return columns.get(i);
    }

    public static void addValue(List<String> inValue){
        values.add(inValue);
    }

    public static String at(int row, String col){
        List srow = values.get(row);
        int fd = columns.indexOf(col);
        return values.get(row).get(columns.indexOf(col));
    }

    public static String iat(int row, int col) {
        return values.get(row).get(col);
    }

    public int columns() {
        return 0;
    }

    public int size() {
        return 0;
    }

    public String sort(String col) {
        return null;
    }

    public String query() {
        return null;
    }
}
