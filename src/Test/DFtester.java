package Test;


import Data.CSVReader;

public class DFtester {

    public static void main(String[] args) {

        CSVReader read = new CSVReader("cities.csv");

        read.read();

        System.out.println(read.get("State", 1));
    }
}
