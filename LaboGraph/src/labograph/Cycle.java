package labograph;

import java.util.ArrayList;

public class Cycle {
    
    ArrayList<Integer> cycle = new ArrayList<>();
    
    public Cycle(){
    }
    
    public void ajouterPoint(int point){
        cycle.add(point);
    }
    
    public void ajouterPoint(int point, int index){
        cycle.add(index, point);
    }
    
    public void ajouterCycle(Cycle c, int index){
        cycle.addAll(index, c.cycle);
    }
    
    public int getNext(){
        return cycle.remove(0);
    }
    
    public boolean hasNext(){
        boolean vide = cycle.isEmpty();
        return !vide;
    }
}
