package Test;


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
        ReaderFactory read = new CSVReader("cities.csv");
        DataFrame df = DataFrame.getInstance();

        read.read();

        //System.out.println(read.get("State", 1));
        System.out.println(df.at(1, "State").trim());
        System.out.println(df.iat(1, 2).trim());
        System.out.println("Columns: " + df.columns());
        System.out.println("Rows: " + df.size());
    }

    public static void testJSON(){
        ReaderFactory read = new JSONReader("cities.json");
        DataFrame df = DataFrame.getInstance();

        read.read();
        System.out.println(df.at(1, "State").trim());
        System.out.println(df.iat(1, 2).trim());
        System.out.println("Columns: " + df.columns());
        System.out.println("Rows: " + df.size());
    }

    public static void testTXT(){
        ReaderFactory read = new TXTReader("cities.txt");
        DataFrame df = DataFrame.getInstance();

        read.read();

        System.out.println(df.at(1, "State").trim());
        System.out.println(df.iat(1, 2).trim());
        System.out.println("Columns: " + df.columns());
        System.out.println("Rows: " + df.size());
    }
}
