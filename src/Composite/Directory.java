package Composite;

import Comparators.CustomComparator;
import Data.DataFrame;
import Predicates.CustomPredicate;
import Visitor.Visitor;

import java.util.ArrayList;
import java.util.List;

public class Directory implements AComponent{

    private List<AComponent> childs = new ArrayList<AComponent>();
    private String name;

    public Directory(String name){
        this.name = name;
    }

    public void addChild(AComponent c){
        this.childs.add(c);
    }

    @Override
    public String at(int row, String col) {
        String result = "";
        for(AComponent component: childs){
            result += component.at(row, col) + "\n";
        }
        return result;
    }

    @Override
    public String iat(int row, int col) {
        String result = "";
        for(AComponent component: childs){
            result += component.iat(row, col) + "\n";
        }
        return result;
    }

    @Override
    public int columns() {
        int result = 0;
        for(AComponent component: childs){
            result += component.columns();
        }
        return result;
    }

    @Override
    public int size() {
        int result = 0;
        for(AComponent component: childs){
            result += component.size();
        }
        return result;
    }

    @Override
    public <T> void sort(String column, CustomComparator comparator) {
        for(AComponent component: childs){
            component.sort(column, comparator);
        }
    }

    @Override
    public List<List<String>> query(String column, CustomPredicate predicator) {
        List<List<String>> result = new ArrayList<>();
        List<List<String>> tmp;
        for(AComponent component: childs){
            tmp = component.query(column, predicator);
            for(List<String> line: tmp){
                result.add(line);
            }
        }
        return result;
    }

    public void accept(Visitor v){
        for(AComponent component: childs){
            component.accept(v);
        }
    }
}
