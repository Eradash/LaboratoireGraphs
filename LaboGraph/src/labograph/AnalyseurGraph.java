package labograph;

import java.awt.Point;
import java.util.ArrayList;

public class AnalyseurGraph {
    
    private Graph g;
    
    private boolean detecterCycleEuclerien(Graph g){
        for(int i = 0 ; i < g.getTaille() ; i++){
            if(g.getDegre(i)%2 != 0){
                return false;
            }
        }
        return true;
    }
    
    public ArrayList<Point> getCycleEuclerien(Graph g){
        if(detecterCycleEuclerien(g)){
            
        }
        return null;
    }
    
    private boolean detecterIsomorphe(Graph g, Graph _g){
        return false;
    }
    
    public void getFonction(Graph g, Graph _g){
        if(detecterIsomorphe(g, _g)){
            
        }
    }
}
