package Visitor;

import Comparators.DescendantComparator;
import Composite.AComponent;

public class AverageVisitor implements Visitor{

    private String label;
    private float avg;

    public AverageVisitor(String label){
        this.label = label;

    }

    @Override
    public void visit(AComponent e) {
        Visitor v = new SumVisitor(label);
        e.accept(v);
        this.avg = ((SumVisitor)v).getSum() / ((SumVisitor)v).getSumSize();
    }

    public float getAvg(){
        return this.avg;
    }
}
