package Test;

import Composite.Directory;
import Data.DataFrame;
import Factories.CSVReaderFactory;
import Factories.JSONReaderFactory;
import Factories.TXTReaderFactory;
import Predicates.EqualThanPredicate;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CompositeTester {

    private Directory root;

    @Before
    public void loadData(){
        root = new Directory("Data");
        DataFrame df;
        df = new DataFrame();
        df.readDataFromFile(new CSVReaderFactory("cities.csv"));
        root.addChild(df);
        df = new DataFrame();
        df.readDataFromFile(new CSVReaderFactory("cities.csv"));
        root.addChild(df);
        Directory subdir = new Directory("Subdirectory");
        root.addChild(subdir);
        df = new DataFrame();
        df.readDataFromFile(new CSVReaderFactory("cities.csv"));
        subdir.addChild(df);
    }

    @Test
    public void testAt(){
        List test = new ArrayList<String>();
        test.add("SD");
        test.add("SD");
        test.add("SD");
        Assert.assertEquals(test, root.at(1, "State"));
    }

    @Test
    public void testIat(){
        List test = new ArrayList<String>();
        test.add("SD");
        test.add("SD");
        test.add("SD");
        Assert.assertEquals(test, root.iat(1, 9));
    }

    @Test
    public void testSize(){
        Assert.assertEquals(387, root.size());
    }

    @Test
    public void testQuery(){
        List test = new ArrayList<String>();
        test.add("SD");
        test.add("SD");
        test.add("SD");
        List<List<String>> values = root.query("State", new EqualThanPredicate("SD"));
        Assert.assertEquals("SD", values.get(0).get(9).trim());
    }

}
