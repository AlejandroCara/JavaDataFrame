package Test;


import Data.DataFrame;
import Factories.ReaderFactory;
import Readers.CSVReader;
import Readers.JSONReader;

public class DFtester {

    public static void main(String[] args) {

        //testCSV();
        testJSON();

    }

    public static void testCSV(){
        ReaderFactory read = new CSVReader("cities.csv");

        read.read();

        //System.out.println(read.get("State", 1));
        System.out.println(DataFrame.at(1, "State").trim());
        System.out.println(DataFrame.iat(1, 2).trim());
    }

    public static void testJSON(){
        ReaderFactory read = new JSONReader("cities.json");

        read.read();
        System.out.println(DataFrame.at(1, "State").trim());
        System.out.println(DataFrame.iat(1, 2).trim());
    }
}
