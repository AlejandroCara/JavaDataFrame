package Visitor;

import Comparators.DescendantComparator;
import Composite.AComponent;

public class MinimumVisitor implements Visitor{

    private String label;
    private int min = Integer.MAX_VALUE;

    public MinimumVisitor(String label){
        this.label = label;
    }

    @Override
    public void visit(AComponent e) {
        e.sort(label, new DescendantComparator());
        if(Integer.valueOf(e.at(0, label)) < min){
            min = Integer.valueOf(e.at(0, label));
        }
    }

    public int getMin(){
        return this.min;
    }
}
