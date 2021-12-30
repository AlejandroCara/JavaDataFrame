package Visitor;

import Comparators.DescendantComparator;
import Composite.AComponent;

public class MaximumVisitor implements Visitor{

    private String label;
    private int max = Integer.MIN_VALUE;

    public MaximumVisitor(String label){
        this.label = label;
    }

    @Override
    public void visit(AComponent e) {
        e.sort(label, new DescendantComparator());
        if(Integer.valueOf(e.at(0, label)) > max){
            max = Integer.valueOf(e.at(0, label));
        }
    }

    public int getMax(){
        return this.max;
    }
}
