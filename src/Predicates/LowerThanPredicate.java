package Predicates;

import java.util.List;

public class LowerThanPredicate extends CustomPredicate{

    String value;

    public LowerThanPredicate(String value){
        super();
        this.value = value;
    }


    @Override
    public boolean test(List<String> strings) {
        int r = strings.get(super.columnIndex).trim().compareTo(value.trim());
        //System.out.println(strings.get(column) + " compare to " + value + ": " + strings.get(column).compareTo(value));
        if(r < 0){
            return true;
        }
        return false;
    }
}
