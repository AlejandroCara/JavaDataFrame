package Visitor;

import Comparators.AscendantComparator;
import Comparators.DescendantComparator;
import Composite.AComponent;

public class MinimumVisitor implements Visitor{

    private String label;
    private float min = Float.MAX_VALUE;

    public MinimumVisitor(String label){
        this.label = label;
    }

    @Override
    public void visit(AComponent e) {
        e.sort(label, new AscendantComparator());
        float val = Float.valueOf(e.at(0, label).get(0));
        if(val < min){
            min = val;
        }
    }

    public float getMin(){
        return this.min;
    }
}
