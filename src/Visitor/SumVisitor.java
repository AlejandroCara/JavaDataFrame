package Visitor;

import Comparators.DescendantComparator;
import Composite.AComponent;

public class SumVisitor implements Visitor{

    private String label;
    private float sumVal = 0;
    private int sumSize = 0;

    public SumVisitor(String label){
        this.label = label;
    }

    @Override
    public void visit(AComponent e) {
        sumSize+=e.size();
        for(int i = 0; i < e.size(); i++){
            sumVal += Float.valueOf(e.at(i, label).replace(" ", ""));
        }

    }

    public float getSum(){
        return this.sumVal;
    }

    public int getSumSize(){
        return this.sumSize;
    }
}
