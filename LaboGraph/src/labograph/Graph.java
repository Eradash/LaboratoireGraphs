package labograph;

import java.awt.Point;

public class Graph {
    
    int[][] graph;
    private final int TAILLE;
    
    public Graph(int x){
        graph = new int[x][x];
        TAILLE = x;
    }
    
    public int rechercherLigne(int[] valeur){
        int[] valeursRecherche = getValeurs(valeur);
        int[] valeurGraph;
        boolean ok = false;
        for(int i = 0 ; i < TAILLE && !ok ; i++){
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
    
    public int rechercherCol(int[] valeur){
        int[] valeursRecherche = getValeurs(valeur);
        int[] valeurGraph;
        boolean ok = false;
        for(int i = 0 ; i < TAILLE && !ok ; i++){
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
    
    public int getValeur(int x, int y){
        return graph[x][y];
    }
    
    public int getValeur(Point p){
        return getValeur((int)p.getX(), (int)p.getY());
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
