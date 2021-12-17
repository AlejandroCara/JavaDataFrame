package Test;


import Comparators.AscendantComparator;
import Comparators.DescendantComparator;
import Data.DataFrame;
import Factories.ReaderFactory;
import Readers.CSVReader;
import Readers.JSONReader;
import Readers.TXTReader;

public class DFtester {

    public static void main(String[] args) {
        testCSV();
        //testJSON();
        //testTXT();

    }

    public static void testCSV(){
        ReaderFactory reader = new CSVReader("cities.csv");
        DataFrame df = reader.read();
        String column = "LatS";
        int indexOfColumn;

        System.out.println(df.at(1, "State").trim());
        System.out.println(df.iat(1, 2).trim());
        System.out.println("Columns: " + df.columns());
        System.out.println("Rows: " + df.size());
        indexOfColumn = df.getColumns().indexOf(column);
        df.sort(column, new DescendantComparator(indexOfColumn));
        df.list();
    }

    public static void testJSON(){
        ReaderFactory reader = new JSONReader("cities.json");
        DataFrame df = reader.read();
        String column = "LatS";
        int indexOfColumn;

        System.out.println(df.at(1, "State").trim());
        System.out.println(df.iat(1, 2).trim());
        System.out.println("Columns: " + df.columns());
        System.out.println("Rows: " + df.size());
        indexOfColumn = df.getColumns().indexOf(column);
        df.sort(column, new AscendantComparator(indexOfColumn));
        df.list();
    }

    public static void testTXT(){
        ReaderFactory reader = new TXTReader("cities.txt");
        DataFrame df = reader.read();
        String column = "LatS";
        int indexOfColumn;

        System.out.println(df.at(1, "State").trim());
        System.out.println(df.iat(1, 2).trim());
        System.out.println("Columns: " + df.columns());
        System.out.println("Rows: " + df.size());
        indexOfColumn = df.getColumns().indexOf(column);
        df.sort(column, new AscendantComparator(indexOfColumn));
        df.list();
    }
}
