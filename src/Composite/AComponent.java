package Composite;

import Comparators.CustomComparator;
import Data.DataFrame;
import Predicates.CustomPredicate;

import java.util.List;

public interface AComponent {
    public String at(int row, String col);
    public String iat(int row, int col);
    public int columns();
    public int size();
    public <T> void sort(String column, CustomComparator comparator);
    public List<List<String>> query(String column, CustomPredicate predicator);

}