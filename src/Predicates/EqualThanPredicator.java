package Predicates;

import java.util.List;
import java.util.function.Predicate;

public class EqualThanPredicator extends CustomPredicate {

    String value;

    public EqualThanPredicator(String value){
        super();
        this.value = value;
    }


    @Override
    public boolean test(List<String> strings) {
        int r = strings.get(super.columnIndex).trim().compareTo(value.trim());
        //System.out.println(strings.get(column) + " compare to " + value + ": " + strings.get(column).compareTo(value));
        if(r == 0){
            return true;
        }
        return false;
    }
}


/*
public class EqualThanPredicator implements Predicate<List<String>> {

    int column;
    String value;

    public EqualThanPredicator(int column, String value){
        this.column = column;
        this.value = value;
    }



    @Override
    public boolean test(List<String> strings) {
        int r = strings.get(column).trim().compareTo(value.trim());
        System.out.println(strings.get(column) + " compare to " + value + ": " + strings.get(column).compareTo(value));
        if(r == 0){
            return true;
        }
        return false;
    }
}

* */
