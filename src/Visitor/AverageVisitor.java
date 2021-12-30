package Visitor;

import Comparators.DescendantComparator;
import Composite.AComponent;

public class AverageVisitor implements Visitor{

    private String label;
    private int avg;

    public AverageVisitor(String label){
        this.label = label;
    }

    @Override
    public void visit(AComponent e) {

    }

    public int getAvg(){
        return this.avg;
    }
}
