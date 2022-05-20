public class Solver {
    private Grille grille;
    public Solver(Grille grille) {
        super();
        this.grille = grille;
    }
    /**
     * Cette fonction permet de resoudre une grille.
     * @return true si la grille est resolue et false sinon
     */
    public final boolean solve() {
        char[] t;
        t=grille.getJeuxDeCaracteres();
        int [][]tableCaseVide = trouveCaseVide();
        for (int ligne = 0; ligne < tableCaseVide.length; ligne++) {
            for (char s : t) {
                if (grille.possible(tableCaseVide[ligne][0], tableCaseVide[ligne][1], s)) {
                    grille.setValue(tableCaseVide[ligne][0], tableCaseVide[ligne][1],s);
                    if (solve()) { //recursive
                        return true;
                    } else {
                        grille.setValue(tableCaseVide[ligne][0],tableCaseVide[ligne][1],Grille.EMPTY);
                    }
                }
            }
            return false;
        }
        return true;
    }
    /**
     * Cette fonction permet de trouver les cases à remplir dans une grille.
     * @return un tableau à deux dimensions des coordonnées des cases vides de la grille
     */
    public final int [][] trouveCaseVide() {
        int n=nbreCaseVide();
        int[][] t= new int [n][2];
        int r=0;
        int c=0;
        for (int ligne = 0; ligne < grille.getDimension(); ligne++) {
            for (int colonne = 0; colonne < grille.getDimension(); colonne++) {
                if (grille.getValue(ligne,colonne) == Grille.EMPTY) {
                    t[r][c]=ligne;
                    t[r][c+1]=colonne;
                    r++;
                }
            }
        }
        return t;
    }
    /**
     * Cette fonction permet de trouver le nombre de cases vides dans une grille.
     * @return ce nombre
     */
    public final int nbreCaseVide() {
        int n=0;
        for (int ligne = 0; ligne < grille.getDimension(); ligne++) {
            for (int colonne = 0; colonne < grille.getDimension(); colonne++) {
                if (grille.getValue(ligne,colonne) == Grille.EMPTY) {
                    n++;
                }
            }
        }
        return n;
    }
    public static void main(String[] args) {
        char[][] grille9x9Aremplir = {
                {'@', '6', '@', '@', '4', '5', '3', '7', '@'},
                {'@', '@', '5', '6', '7', '3', '4', '2', '@'},
                {'@', '@', '4', '@', '@', '@', '@', '@', '1'},
                {'5', '@', '@', '7', '@', '2', '@', '@', '4'},
                {'6', '@', '9', '@', '@', '@', '2', '5', '@'},
                {'8', '@', '7', '@', '@', '9', '@', '@', '3'},
                {'4', '9', '@', '5', '1', '7', '8', '@', '@'},
                {'2', '1', '@', '@', '3', '6', '@', '@', '@'},
                {'@', '5', '@', '@', '2', '@', '1', '@', '@'}};   
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
        GrilleImpl gri=new GrilleImpl(grille9x9Aremplir);
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
        System.out.println();
      }
}
