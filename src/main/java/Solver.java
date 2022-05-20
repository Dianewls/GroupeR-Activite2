public class Solver {
    private Grille grille;
    /**
     * Caractere possible a mettre dans la grille 9X9.
     */
    private static final char[] CHARPOSSIBLE9X9 = new char[]
            {'1', '2', '3', '4', '5', '6', '7', '8', '9' };
    /**
     * Caractere possible a mettre dans la grille 16X16.
     */
    private static final char[] CHARPOSSIBLE16X16 = new char[]
            {'0', '1','2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b',
            'c', 'd', 'e', 'f' };
    /**
     * Caractere possible a mettre dans la grille 25X25.
     */
    private static final char[] CHARPOSSIBLE25X25 = new char[]
            {'0', '1','2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b',
            'c', 'd', 'e', 'f','g','h','i','j','k','l','m','n','o' };
    public Solver(GrilleImpl grille) {
        super();
        this.grille = grille;
    }
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
        for (int ligne = 0; ligne < grille.getGrille().length; ligne++) {
            for (int colonne = 0; colonne < grille.getGrille().length; colonne++) {
                if (grille.getGrille()[ligne][colonne] == grille.EMPTY) {
                    //System.out.println("taille de la grille dans solve "+grille.getGrille().length);
                    for (char s : t) {
                        if (grille.possible(ligne, colonne, s)) {
                            grille.getGrille()[ligne][colonne] = s;
                            if (solve()) { //recursive
                                return true;
                            } else {
                                grille.getGrille()[ligne][colonne] = grille.EMPTY;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    /**
     * Cette fonction permet d'afficher une grille.
     */
    public final void affiche() {
        for (int l = 0; l < grille.getGrille().length; l++) {
            for (int c = 0; c < grille.getGrille().length; c++) {
                System.out.print(" " + grille.getGrille()[l][c]);
            }
            System.out.println();
          
        }
        System.out.println();
      }
}
