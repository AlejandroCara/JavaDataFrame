package Test;

import Composite.Directory;
import Data.DataFrame;
import Factories.CSVReaderFactory;
import Predicates.EqualThanPredicate;
import Visitor.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class VisitorTester {

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
    public void testMaximumVisitor(){
        Visitor mv = new MaximumVisitor("LatS");
        root.accept(mv);
        Assert.assertEquals("59.0", String.valueOf(((MaximumVisitor)mv).getMax()));
    }

    @Test
    public void testMinimumVisitor(){
        Visitor mv = new MinimumVisitor("LatS");
        root.accept(mv);
        Assert.assertEquals("0.0", String.valueOf(((MinimumVisitor)mv).getMin()));
    }

    @Test
    public void testSumVisitor(){
        Visitor sv = new SumVisitor("LatS");
        root.accept(sv);
        Assert.assertEquals("10593.0", String.valueOf(((SumVisitor)sv).getSum()));
    }

    @Test
    public void testAverageVisitor(){
        Visitor av = new AverageVisitor("LatS");
        root.accept(av);
        Assert.assertEquals("27,372", String.format("%.3f",((AverageVisitor)av).getAvg()));
    }
}
