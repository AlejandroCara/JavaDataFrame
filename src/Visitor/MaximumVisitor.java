package Visitor;

import Comparators.DescendantComparator;
import Composite.AComponent;

public class MaximumVisitor implements Visitor{

    private String label;
    private float max = Float.MIN_VALUE;

    public MaximumVisitor(String label){
        this.label = label;
    }

    @Override
    public void visit(AComponent e) {
        e.sort(label, new DescendantComparator());
        float val = Float.valueOf(e.at(0, label).get(0));
        if(val > max){
            max = val;
        }
    }

    public float getMax(){
        return this.max;
    }
}
