/**
 * Implementation d'une grille.
 */
public class GrilleImpl implements Grille {
    /**
     * grille est la grille de type tableau à deux dimensions.
     */
    private char[][] grille;
    /**
     * CARRESIZE taille du carre d'une grille 9X9.
     */
    private static final int CARRESIZE = 3;
    /**
     * GRILLE9X9SIZE represente la taille du tableau 9*9.
     */
    private static final int GRILLE9X9SIZE = 9;
    /**
     * GRILLE16X16SIZE taille du tableau 16*16.
     */
    private static final int GRILLE16X16SIZE = 16;
    /**
     * Caractere possible a mettre dans la grille.
     * pour une grille 9x9 : 1..9
     * pour une grille 16x16: 0..9-a..f
     */
    private static final char[] CHARPOSSIBLE = new char[]
            {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
    /**
     * Constructeur.
     * @param unegrille est une grille de type tableau à deux dimensions
     */
    public GrilleImpl(final char[][] unegrille) {
        super();
        if (unegrille.length == GRILLE9X9SIZE
                || unegrille.length == GRILLE16X16SIZE) {
            this.grille = unegrille.clone();
        } else {
            throw new IllegalArgumentException("Le tableau doit "
                    + "être de dimension 9x9 ou 16x16");
        }
    }

    /**
     * @return largeur/hauteur de la grille
     */
    @Override
    public final int getDimension() {
        return grille.length;
    }
    /**
     * Verify if the character to add is authorized.
     * @param c caractere a verifier
     * @return true or false
     */
    public final boolean verifChar(final char c) {
        if (grille.length == GRILLE9X9SIZE
                || grille.length == GRILLE16X16SIZE) {
            for (char s : CHARPOSSIBLE) {
                if (s == c) {
                    return true;
                }
            }
        }
        return false;
    }
    /**
     * Affecte une valeur dans la grille.
     * @param x       position x dans la grille
     * @param y       position y dans la grille
     * @param value   valeur a mettre dans la case
     * @throw IllegalArgumentException
     *        si x ou y sont hors bornes (0-8)
     * @throw IllegalArgumentException
     *        si la valeur est interdite aux vues des
     *        autres valeurs de la grille
     * @throw IllegalArgumentException
     *        si value n'est pas un caractere autorise
     *        ('1',...,'9')
     */
    @Override
    public final void setValue(final int x, final int y, final char value)
            throws IllegalArgumentException {
        if (x < 0 || x > this.getDimension()
                || y < 0 || y > this.getDimension()) {
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
     * Recupere une valeur de la grille.
     * @param x      position x dans la grille
     * @param y      position y dans la grille
     * @return valeur dans la case x,y
     * @throw IllegalArgumentException si x ou y sont hors bornes (0-8)
     */
    @Override
    public final char getValue(final int x, final int y) {
        if (x < 0 || x > this.getDimension()
                || y < 0 || y > this.getDimension()) {
            throw new IllegalArgumentException("x ou y is out of matrice");
        } else {
            return this.grille[x][y];
        }
    }
    /**
     * Test si une grille est terminee.
     * @return true si la grille est complete
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
     * @return true si la valeur est possible pour la ligne
     */
    public final boolean lignePossible(final int ligne, final char value) {
        for (int i = 0; i < grille.length; i++) {
            if (getValue(ligne, i) == value  && verifChar(value)) {
                return true;
            }
        }
        return false;
    }
    /**
     * Tester si une valeur est possible par colonne.
     * @param col numero de la colonne
     * @param value valeur qu'on veut ajouter
     * @return true si la valeur est possible pour la colonne col
     */
    public final boolean colonnePossible(final int col, final char value) {
        for (int i = 0; i < grille.length; i++) {
            if (getValue(i, col) == value && verifChar(value)) {
                return true;
            }
        }
        return false;
    }
    /**
     * verifier si valeur est possible dans 3*3 box.
     *@param value valeur qu'on ajoute
     *@param row numero de la ligne
     *@param col numero de la colonne
     *
     *@return true s'elle est possible,  sinon false
     */
    public final boolean carrePossible(final int row, final int col,
            final char value) {
        int r = row - row % CARRESIZE;
        int c = col - col % CARRESIZE;
        for (int i = r; i < r + CARRESIZE; i++) {
            for (int j = c; j < c + CARRESIZE; j++) {
                if (grille[i][j] == value && verifChar(value)) {
                    return true;
                }
            }
        }
        return false;
    }
    /**
     * Test si une valeur est possible dans la grille.
     * cela par rapport a ce qu'elle contient deja
     * @param x     position x dans la grille
     * @param y     position y dans la grille
     * @param value valeur a mettre dans la case
     * @throw IllegalArgumentException si x ou y sont hors bornes (0-8)
     * @throw IllegalArgumentException si value n'est pas un caractere autorise
     *        ('1',...,'9',..)
     */
    @Override
    public final boolean possible(final int x, final int y, final char value) {
        if ((x >= 0 || x < grille.length) && (y >= 0 || y < grille.length)) {
            if (getValue(x, y) == EMPTY) {
                if (!verifChar(value)) {
                    throw new IllegalArgumentException("valeur non autorisee");
                }
            } else {
                return false;
            }
        } else {
            throw new IllegalArgumentException("x ou y sont hors bornes");
        }
        return !lignePossible(x, value)
                &&  !colonnePossible(y, value)
                &&  !carrePossible(x, y, value);
    }

}
