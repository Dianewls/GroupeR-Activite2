/**
 * Implementation d'une grille.
 */
public class GrilleImpl implements Grille {
    /**
     * grille est la grille à deux dimensions.
     */
    private char[][] grille;
    /**
     * CARRESIZE9X9 taille du carre d'une grille 9X9.
     */
    private static final int CARRESIZE9X9 = 3;
    /**
     * CARRESIZE16X16 taille du carre d'une grille 16X16.
     */
    private static final int CARRESIZE16X16 = 4;
    /**
     * GRILLE9X9SIZE represente la taille du tableau 9*9.
     */
    private static final int GRILLE9X9SIZE = 9;
    /**
     * GRILLE16X16SIZE taille du tableau 16*16.
     */
    private static final int GRILLE16X16SIZE = 16;
    /**
     * Caractere possible a mettre dans la grille 9X9.
     */
    private static final char[] CHARPOSSIBLE9X9 = new char[]
            {'1', '2', '3', '4', '5', '6', '7', '8', '9' };
    /**
     * Caractere possible a mettre dans la grille 16X16.
     */
    private static final char[] CHARPOSSIBLE16X16 = new char[]
            {'1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B',
            'C', 'D', 'E', 'F', 'G' };
    /**
     * Constructeur.
     * @param unegrille est une grille de type tableau à deux dimensions
     */
    /*
     * public GrilleImpl(final char[][] unegrille) { if (unegrille.length ==
     * GRILLE9X9SIZE || unegrille.length == GRILLE16X16SIZE) { this.grille =
     * unegrille.clone(); } else { throw new
     * IllegalArgumentException("Le tableau doit " +
     * "être de dimension 9x9 ou 16x16"); } }
     */
    
    
    public GrilleImpl(final char[][] unegrille) {
        this.grille=new char[unegrille.length][unegrille.length];
        for(int i=0; i<unegrille.length; i++) {
            for(int j=0; j<unegrille.length; j++) {
                setValue(i,j,unegrille[i][j]);
            }
        }


//         if (unegrille.length == GRILLE9X9SIZE
//                 || unegrille.length == GRILLE16X16SIZE) {
//             this.grille = unegrille.clone();
//         } else {
//             throw new IllegalArgumentException("Le tableau doit "
//         + "être de dimension 9x9 ou 16x16");
//         }
     }

     public GrilleImpl(int dim) {
         this.grille=new char[dim][dim];
     }
    
    
    

    /**
     * @return largeur/hauteur (taille) de la grille
     */
    @Override
    public final int getDimension() {
        return grille.length;
    }

    /**
     * Verify if the character to add is authorized dans grille 9X9 ou 16X16.
     * @param c caractere a verifier
     * @return true si ok ou false si non
     */
    public final boolean verifChar(final char c) {
        if (this.grille.length == GRILLE9X9SIZE) {
            for (char s : CHARPOSSIBLE9X9) {
                if (s == c) {
                    return true;
                }
            }
        }
        if (this.grille.length == GRILLE16X16SIZE) {
            for (char s : CHARPOSSIBLE16X16) {
                if (s == c) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Affecte une valeur a une position dans la grille.
     * @param x     position x dans la grille
     * @param y     position y dans la grille
     * @param value valeur a mettre dans la case
     * @throw IllegalArgumentException si x ou y sont hors bornes (0-8)
     * @throw IllegalArgumentException si la valeur est interdite aux vues des
     *        autres valeurs de la grille
     * @throw IllegalArgumentException si value n'est pas un caractere autorise
     *        ('1',...,'9') pour 9X9 et ('1',...,'F') pour 16X16
     */
    @Override
    public final void setValue(final int x, final int y, final char value)
                    throws IllegalArgumentException {
        if (!verifGetValue(x) || !verifGetValue(y)) {
            throw new IllegalArgumentException("x et/ou y "
        + "est(sont) hors des dimensions");
        } else {
            if (!verifChar(value)) {
                throw new IllegalArgumentException("Caractere non autorise");
            }
        }
        grille[x][y] = value;
    }

    /**
     * verifie si une coordonnée est dans la borne ou pas.
     * @param x coodonnée x dans la grille
     * @return true si x est dans la borne (0...grille.length ou false si non
     */
    public final boolean verifGetValue(final int x) {
        if (x < 0 || x >= this.getDimension()) {
            return false;
        }
        return true;
    }

    /**
     * Recupere une valeur de la grille.
     * @param x position x dans la grille
     * @param y position y dans la grille
     * @return valeur dans la case x,y
     * @throw IllegalArgumentException si x ou y sont hors bornes
     */
    
    @Override
    public final char getValue(final int x, final int y) {
        if (!verifGetValue(x) || !verifGetValue(y)) {
            throw new IllegalArgumentException("x ou y is out of matrice");
        } else {
            return this.grille[x][y];
        }
    }

    /**
     * Test si une grille est terminee.
     * @return true si la grille est complete sinon false
     */
    @Override
    public final boolean complete() {
        for (int i = 0; i < grille.length; i++) {
            for (int j = 0; j < grille.length; j++) {
                if (grille[i][j] == EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Tester si une valeur est possible pour une ligne donnee.
     * @param ligne numero de la ligne
     * @param value valeur qu'on veut ajouter
     * @return true si la valeur est possible pour la ligne et false sinon
     */
    public final boolean lignePossible(final int ligne, final char value) {
        if (verifChar(value)) {
            for (int i = 0; i < grille.length; i++) {
                if (getValue(ligne, i) == value) {
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }

    /**
     * Tester si une valeur est possible par colonne.
     * @param col   numero de la colonne
     * @param value valeur qu'on veut ajouter
     * @return true si la valeur est possible pour la colonne col et false sinon
     */
    public final boolean colonnePossible(final int col, final char value) {
        if (verifChar(value)) {
            for (int i = 0; i < grille.length; i++) {
                if (getValue(i, col) == value) {
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }

    /**
     * verifier si valeur est possible dans 3*3 box.
     * @param value valeur qu'on ajoute
     * @param row   numero de la ligne
     * @param col   numero de la colonne
     * @return true si la valeur est possible dans le carre 3X3 et false si non
     */
    public final boolean carrePossible(
            final int row, final int col, final char value) {
        int carresize = 0;
        if (verifChar(value)) {
            if (grille.length == GRILLE9X9SIZE) {
                carresize = CARRESIZE9X9;
            } else {
                carresize = CARRESIZE16X16;
            }
            int r = row - row % carresize;
            int c = col - col % carresize;
            for (int i = r; i < r + carresize; i++) {
                for (int j = c; j < c + carresize; j++) {
                    if (getValue(i, j) == value) {
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }

    /**
     * Test si une valeur est possible dans la grille.
     * cela par rapport a ce qu'elle
     * contient deja
     * @param x     position x dans la grille
     * @param y     position y dans la grille
     * @param value valeur a mettre dans la case
     * @throw IllegalArgumentException si x ou y sont hors bornes
     * @throw IllegalArgumentException si value n'est pas un caractere autorise
     *        *@return true si la valeur est possible et false si non
     */
    @Override
    public final boolean possible(final int x, final int y, final char value) {
        if (!verifGetValue(x) && !verifGetValue(y)) {
            throw new IllegalArgumentException("x ou y sont hors bornes");
        } else if (getValue(x, y) == EMPTY) {
            if (!verifChar(value)) {
                throw new IllegalArgumentException("valeur non autorisee");
            }
        } else {
            return false;
        }
        return lignePossible(x, value)
                && colonnePossible(y, value)
                && carrePossible(x, y, value);
    }
    /**
     * Cette fonction permet de resoudre une grille.
     * @return true si la grille est resolue et false sinon
     */
    public final boolean solve() {
        char[] t;
        if (grille.length == CHARPOSSIBLE9X9.length) {
            t = CHARPOSSIBLE9X9;
        } else {
            t = CHARPOSSIBLE16X16;
        }
        for (int ligne = 0; ligne < grille.length; ligne++) {
            for (int colonne = 0; colonne < grille.length; colonne++) {
                if (grille[ligne][colonne] == EMPTY) {
                    for (char s : t) {
                        if (possible(ligne, colonne, s)) {
                            grille[ligne][colonne] = s;
                            if (solve()) { //recursive
                                return true;
                            } else {
                                grille[ligne][colonne] = EMPTY;
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
        for (int l = 0; l < getDimension(); l++) {
            for (int c = 0; c < getDimension(); c++) {
                System.out.print(" " + grille[l][c]);
            }
            System.out.println();
        }
        System.out.println();
      }
}
