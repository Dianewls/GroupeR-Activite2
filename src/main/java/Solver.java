/**
   * Classe solver de resolution des grilles.
*/
public class Solver {
    /**
     * grille de base.
  */
    private Grille grille;
    /**
     * constructeur.
     */
    public Solver(Grille uneGrille) {
//        super();
//        Grille unegrille = new GrilleImpl(grille.getDimension());
//        for (int i = 0; i < grille.getDimension(); i++) {
//           for (int j = 0; j <grille.getDimension(); j++) {
//               unegrille.setValue(i, j, grille.getValue(i, j));
//               System.out.println(unegrille.getValue(i, j));
//           }  
//        }
//        this.grille = unegrille;
        super();
        this.grille = uneGrille;
    }
    /**
     * Cette fonction permet de resoudre une grille.
     * @return true si la grille est resolue et false sinon
     */
    public final boolean solve() {
        char[] t;
        t = grille.getJeuxDeCaracteres();
        int []tableCaseVide = trouveCaseVide();
        if(tableCaseVide == null) {
            return true;
        }
        for (char s : t) {
            if (grille.possible(tableCaseVide[0], tableCaseVide[1],s)) {
                grille.setValue(tableCaseVide[0], tableCaseVide[1],s);
                if (solve()) { //recursive
                    return true;
                }
            }
        }
        return false;
    }
    /**
     * Cette fonction permet trouver les coordonées des case vide.
     * s'arrête à la prémière case vide de possibilité 1
     */
    public final int [] trouveCaseVide() {
        int[] t = null;
        int nbCaractP = 0;
        for (int ligne = 0; ligne < grille.getDimension(); ligne++) {
            for (int colonne = 0; colonne < grille.getDimension(); colonne++) {
                if (grille.getValue(ligne,colonne) == Grille.EMPTY) {
                    if(t == null) {
                       t = new int [] {ligne,colonne};
                       nbCaractP = nbCaractPossible(ligne, colonne);
                    } else {
                        if (nbCaractP> nbCaractPossible(ligne, colonne)) {
                            t =  new int [] {ligne,colonne};
                            nbCaractP = nbCaractPossible(ligne, colonne);
                        }
                    }
                    if(nbCaractP == 1) {
                        return t;
                    }
                   
                }
            }
        }
        return t;
    }
    /**
     * Cette fonction permet trouver le nombre de caractère possible dans une cellule.
     */
    public final int nbCaractPossible(int i, int j) {
        char[] t;
        int n=0;
        t=grille.getJeuxDeCaracteres();
        for (char s:t) {
            if (grille.possible(i,j,s)) {
                n++;
            }
        }
        return n;
    }
    
    public static void main(String[] args) {
        char[][] grille16x16Aremplir = {
                {'@','1','b','a','f','6','4','5','8','9','e','d','2','3','7','c'},
                {'c','6','3','8','d','2','@','e','7','b','a','1','f','5','4','9'},
                {'9','7','4','2','c','a','1','8','5','f','@','3','6','b','d','e'},
                {'d','5','f','e','9','b','3','7','2','4','c','6','1','@','a','8'},
                {'8','a','@','3','1','e','b','d','4','5','9','7','c','f','6','2'},
                {'b','9','e','c','a','4','8','2','d','6','1','f','3','7','5','@'},
                {'2','f','d','6','5','@','7','3','a','e','8','c','4','1','9','b'},
                {'1','4','5','7','6','c','f','9','b','3','2','@','a','8','e','d'},
                {'5','3','2','1','4','8','6','@','e','d','f','9','7','c','b','a'},
                {'e','b','7','d','2','1','9','a','3','c','5','4','@','6','8','f'},
                {'f','c','a','4','e','7','5','b','@','8','6','2','d','9','1','3'},
                {'6','@','8','9','3','d','c','f','1','7','b','a','e','4','2','5'},
                {'3','e','1','f','8','9','a','4','c','2','7','5','b','d','@','6'},
                {'7','d','9','5','@','f','e','1','6','a','3','b','8','2','c','4'},
                {'4','8','c','b','7','5','2','6','f','@','d','e','9','a','3','1'},
                {'a','2','6','@','b','3','d','c','9','1','4','8','5','e','f','7'}};
        GrilleImpl gri = new GrilleImpl(grille16x16Aremplir);
        Solver solver = new Solver(gri);
        solver.solve();
        gri.affiche(); 
    }
  
    
    /**
     * Cette fonction permet d'afficher une grille.
     */
    public final void affiche() {
        for (int l = 0; l < grille.getDimension(); l++) {
            for (int c = 0; c < grille.getDimension(); c++) {
                System.out.print(" " + grille.getValue(l,c));
            }
            System.out.println();

        }
    }
}
