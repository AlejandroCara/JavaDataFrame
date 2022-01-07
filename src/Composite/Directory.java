package Composite;

import Comparators.CustomComparator;
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
    public List<String> at(int row, String col) {
        List<String> result = new ArrayList<String>();
        for(AComponent component: childs){
            result.addAll(component.at(row, col));
        }
        return result;
    }

    @Override
    public List<String> iat(int row, int col) {
        List<String> result = new ArrayList<String>();
        for(AComponent component: childs){
            result.addAll(component.iat(row, col));
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
