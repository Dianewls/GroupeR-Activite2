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
