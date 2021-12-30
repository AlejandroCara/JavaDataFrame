package Visitor;

import Comparators.DescendantComparator;
import Composite.AComponent;

public class SumVisitor implements Visitor{

    private String label;
    private int sumVal = 0;
    private int sumSize = 0;

    public SumVisitor(String label){
        this.label = label;
    }

    @Override
    public void visit(AComponent e) {
        e.sort(label, new DescendantComparator());
        sumSize+=e.size();
        for(int i = 0; i < e.size(); i++){
            sumVal += Integer.valueOf(e.at(i, label));
        }

    }

    public int getSum(){
        return this.sumVal;
    }

    public int getSumSize(){
        return this.sumSize;
    }
}
