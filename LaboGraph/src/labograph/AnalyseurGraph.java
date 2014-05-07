package labograph;

import java.awt.Point;
import java.util.ArrayList;

public class AnalyseurGraph {
    
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
    
    public int[] getFonction(Graph g, Graph _g){
        int taille = g.getTaille();
        
        //Échanges en ligne
        for(int i = 0 ; i < taille ; i++){
            int[] ligne = g.getLigne(i);
            int index = _g.rechercherLigne(ligne, i);
            if(index== -1){
                return null;
            } else {
                _g.echangerligne(index, i);
                System.out.println("F("+i+") = "+index);
            }
        }

        System.out.println("\n\nDébut de la recherche en colonne\n\n");
        
        //Échanges en colonne
        for(int i = 0 ; i < taille ; i++){
            int[] colonne = g.getCol(i);
            int index = _g.rechercherCol(colonne, i);
            if(index == -1){
                return null;
            } else {
                _g.echangerCol(index, i);
                System.out.println("F("+i+") = "+index);
            }
        }
        return null;
    }
}
