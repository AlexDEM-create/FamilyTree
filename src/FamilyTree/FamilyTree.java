package FamilyTree;

import Human.Human;

import java.io.Serializable;
import java.util.*;
import java.util.function.Consumer;

public class FamilyTree implements Serializable, Iterable<Human> {
    private List<Human> humanList;

    public FamilyTree(){
         humanList = new ArrayList<>();
    }

    public boolean addHumantoTree (Human human) {
        if (!humanList.contains(human)){
            humanList.add(human);
            addhumantoParents(human);
            addhumantoChild(human);
        }
            return true;
    }

    private boolean addhumantoChild(Human human) {
        for(Human child: human.getChildrenList()){
            child.addParents(human);
        }
        return true;
    }

    private void addhumantoParents(Human human) {
        for(Human parent: human.getParents()){
            parent.addChildren(human);
        }
    }

    @Override
    public String toString() {
        return getInfo();
    }
    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("В семейном дереве сейчас: ");
        sb.append(humanList.size()).append(" Чел."+"\n");
        for (Human human: humanList) {
            sb.append(human);
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public Iterator<Human> iterator() {
        return humanList.iterator();
    }

    @Override
    public Spliterator<Human> spliterator() {
        return Iterable.super.spliterator();
    }

    @Override
    public void forEach(Consumer<? super Human> action) {
        Iterable.super.forEach(action);
    }

    public void sortByDateOfBirth(){
        Collections.sort(humanList, new Human.DateOfBirthComparator());

    }

    public void sortByName(){
        Collections.sort(humanList, new Human.NameComparator());

    }
}


