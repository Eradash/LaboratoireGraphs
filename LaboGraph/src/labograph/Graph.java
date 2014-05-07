package labograph;

import java.awt.Point;

public class Graph {
    
    int[][] graph;
    Graph cycle;
    private final int TAILLE;
    
    public Graph(int TAILLE){
        graph = new int[TAILLE][TAILLE];
        this.TAILLE = TAILLE;
        cycle = new Graph(TAILLE);
    }
    
    public Graph(int[][] graph, int TAILLE){
        this.TAILLE = TAILLE;
        this.graph = graph;
    }
    
    public void setPoint(int x, int y, int valeur){
        graph[x][y] = valeur;
    }
    
    public int getTaille(){
        return TAILLE;
    }
    
    private void retirerArc(int pt1, int pt2){
        graph[pt1][pt2]--;
        graph[pt2][pt1]--;
    }
    
    public int rechercherLigne(int[] valeur, int index){
        int[] valeursRecherche = getValeurs(valeur);
        int[] valeurGraph;
        boolean ok = false;
        for(int i = index ; i < TAILLE && !ok ; i++){
            int[] ligneGraph = new int[TAILLE];
            for(int j = 0 ; j < TAILLE ; j++){
                ligneGraph[j] = graph[i][j];
            }
            valeurGraph = getValeurs(ligneGraph);
            for(int j = 0 ; j < valeurGraph.length ; j++){
                if(valeurGraph[j] != valeursRecherche[j]){
                    break;
                }
                return i;
            }
        }
        return -1;
    }
    
    public int rechercherCol(int[] valeurs, int index){
        int[] valeursRecherche = getValeurs(valeurs);
        int[] valeurGraph;
        for(int i = index ; i < TAILLE; i++){
            int[] ligneGraph = new int[TAILLE];
            for(int j = 0 ; j < TAILLE ; j++){
                ligneGraph[j] = graph[j][i];
            }
            valeurGraph = getValeurs(ligneGraph);
            for(int j = 0 ; j < valeurGraph.length ; j++){
                if(valeurGraph[j] != valeursRecherche[j]){
                    break;
                }
                return i;
            }
        }
        return -1;
    }
    
    public int[] getValeurs(int[] valeur){
        int[] valeurs = new int[valeur.length];
        for(int i : valeur){
            valeurs[i]++;
        }
        return valeurs;
    }
    
    public int getDegre(int point){
        int degre = 0;
        for(int j = 0 ; j < TAILLE ; j++){
            degre += graph[point][j];
        }
        return degre;
    }
    
    public int getValeur(int x, int y){
        return graph[x][y];
    }
    
    public int getValeur(Point p){
        return getValeur((int)p.getX(), (int)p.getY());
    }
    
    public Graph retirerBranchesCycle(Cycle c){
        int pt1 = c.getNext();
        int pt2;
        while(c.hasNext()){
            pt2 = c.getNext();
            cycle.retirerArc(pt1, pt2);
            pt1 = pt2;
        }
        return cycle;
    }
    
    public void echangerligne(int ligne1, int ligne2){
        for(int i = 0 ; i < TAILLE ; i++){
            int temp = graph[ligne1][i];
            graph[ligne1][i] = graph[ligne2][i];
            graph[ligne2][i] = temp;
        }
    }
    
    public boolean echangerColonne(int colonne1, int colonne2){
        for(int i = 0 ; i < TAILLE ; i++){
            int temp = graph[i][colonne1];
            graph[i][colonne1] = graph[i][colonne2];
            graph[i][colonne2] = temp;
        }
        return true;
    }
    
    public boolean comparer(Graph g){
        for(int i = 0 ; i < TAILLE ; i ++){
            for(int j = 0 ; j < TAILLE ; j++){
                if(this.getValeur(i, j) != g.getValeur(j, j)){
                    return false;
                }
            }
        }
        return true;
    }
}
