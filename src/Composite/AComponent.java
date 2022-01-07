package Composite;

import Comparators.CustomComparator;
import Data.DataFrame;
import Predicates.CustomPredicate;
import Visitor.Visitor;

import java.util.List;

public interface AComponent {
    public List<String> at(int row, String col);
    public List<String> iat(int row, int col);
    public int columns();
    public int size();
    public <T> void sort(String column, CustomComparator comparator);
    public List<List<String>> query(String column, CustomPredicate predicator);
    public void accept(Visitor v);
}
