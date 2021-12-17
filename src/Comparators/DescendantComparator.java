package Comparators;

import java.util.Comparator;
import java.util.List;

public class DescendantComparator<T extends Comparable<T>> implements Comparator<List<T>> {

    private int column;

    public DescendantComparator(int column){
        this.column = column;
    }

    @Override
    public int compare(List<T> o1, List<T> o2) {
        //System.out.println(o1.get(3));
        int c = o2.get(column).compareTo(o1.get(column));
        if (c != 0) {
            return c;
        }
        return Integer.compare(o1.size(), o2.size());
    }
}
