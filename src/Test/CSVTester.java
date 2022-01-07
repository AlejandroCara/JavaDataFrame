package Test;

import Data.DataFrame;
import Factories.CSVReaderFactory;
import Predicates.EqualThanPredicate;
import org.junit.*;

import java.util.List;

public class CSVTester {

    private DataFrame df;

    @Before
    public void loadData(){
        df = new DataFrame();
        df.readDataFromFile(new CSVReaderFactory("cities.csv"));
    }

    @Test
    public void testRead(){
        Assert.assertNotNull(df.getValues());
    }

    @Test
    public void testAt(){

        Assert.assertEquals("SD", df.at(1, "State").get(0));
    }

    @Test
    public void testIat(){
        Assert.assertEquals("SD", df.iat(1, 9).get(0));
    }

    @Test
    public void testColumns(){
        Assert.assertEquals(10, df.columns());
    }

    @Test
    public void testSize(){
        Assert.assertEquals(129, df.size());
    }

    @Test
    public void testQuery(){
        List<List<String>> values = df.query("State", new EqualThanPredicate("SD"));
        Assert.assertEquals("SD", values.get(0).get(9).trim());
    }

}
