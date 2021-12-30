package Composite;

import Comparators.CustomComparator;
import Data.DataFrame;
import Factories.ReaderFactory;
import Predicates.CustomPredicate;

import java.util.List;

public class File implements AComponent{

    DataFrame df;

    public File (DataFrame df){
        this.df = df;
    }

    @Override
    public String at(int row, String col) {
        return df.at(row, col);
    }

    @Override
    public String iat(int row, int col) {
        return df.iat(row, col);
    }

    @Override
    public int columns() {
        return df.columns();
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public <T> void sort(String column, CustomComparator comparator) {

    }

    @Override
    public List<List<String>> query(String column, CustomPredicate predicator) {
        return null;
    }
}
