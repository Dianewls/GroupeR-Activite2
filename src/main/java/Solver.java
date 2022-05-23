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
     * @param uneGrille la grille qu'on test
     */
    public Solver(final Grille uneGrille) {
        this.grille = GrilleImpl.copieGrille(uneGrille);
    }
    /**
     * Cette fonction permet de resoudre une grille.
     * @return true si la grille est resolue et false sinon
     */
    public final boolean solve() {
        char[] t;
        t = grille.getJeuxDeCaracteres();
        int[]tableCaseVide = trouveCaseVide();
        if (tableCaseVide == null) {
            return true;
        }
        for (char s : t) {
            if (grille.possible(tableCaseVide[0], tableCaseVide[1], s)) {
                grille.setValue(tableCaseVide[0], tableCaseVide[1], s);
                if (solve()) { //recursive
                    return true;
                }else {
                    grille.setValue(tableCaseVide[0],
                                    tableCaseVide[1], Grille.EMPTY);
                }
            }
        }
        return false;
    }
    /**
     * Cette fonction permet trouver les coordonées des case vide.
     * s'arrête à la prémière case vide de possibilité 1
     * @return un tableau aves les coordonnées des cases vide
     */
    public final int[] trouveCaseVide() {
        int[] t = null;
        int nbCaractP = 0;
        for (int ligne = 0; ligne < grille.getDimension(); ligne++) {
            for (int colonne = 0; colonne < grille.getDimension(); colonne++) {
                if (grille.getValue(ligne, colonne) == Grille.EMPTY) {
                    if (t == null) {
                       t = new int[] {ligne, colonne};
                       nbCaractP = nbCaractPossible(ligne, colonne);
                    } else {
                        if (nbCaractP > nbCaractPossible(ligne, colonne)) {
                            t =  new int[] {ligne, colonne};
                            nbCaractP = nbCaractPossible(ligne, colonne);
                        }
                    }
                    if (nbCaractP == 1) {
                        return t;
                    }
                }
            }
        }
        return t;
    }
    /**
     * Cette fonction permet trouver le nombre.
     * de caractère possible dans une cellule
     * @return le nombre de caractère possible
     * @param i ligne
     * @param j ligne
     */
    public final int nbCaractPossible(final int i, final int j) {
        char[] t;
        int n = 0;
        t = grille.getJeuxDeCaracteres();
        for (char s:t) {
            if (grille.possible(i, j, s)) {
                n++;
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
                System.out.print(" " + grille.getValue(l, c));
            }
            System.out.println();
        }
    }
}
