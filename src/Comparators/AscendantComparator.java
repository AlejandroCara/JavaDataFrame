package Comparators;

import java.util.Comparator;
import java.util.List;

public class AscendantComparator<T extends Comparable<T>> implements Comparator<List<T>> {

    private int column;

    public AscendantComparator(int column){
        this.column = column;
    }

    @Override
    public int compare(List<T> o1, List<T> o2) {
        //System.out.println(o1.get(3));
        int c = o1.get(column).compareTo(o2.get(column));
        if (c != 0) {
            return c;
        }
        return Integer.compare(o1.size(), o2.size());
    }

    /*
    @Override
    public int compare(List<T> o1, List<T> o2) {
        for (int i = 0; i < Math.min(o1.size(), o2.size()); i++) {
            int c = o1.get(i).compareTo(o2.get(i));
            if (c != 0) {
                return c;
            }
        }
        return Integer.compare(o1.size(), o2.size());
    }
    * */

}
