/**
 * Implementation d'une grille.
 */
public class GrilleImpl implements Grille {
    /**
     * grille est la grille à deux dimensions.
     */
    private char[][] grille;
    /**
     * Caractere possible a mettre dans la grille 9X9.
     */
    private static final char[] CHARPOSSIBLE9X9 = new char[]
            {'1', '2', '3', '4', '5', '6', '7', '8', '9' };
    /**
     * Caractere possible a mettre dans la grille 16X16.
     */
    private static final char[] CHARPOSSIBLE16X16 = new char[]
            {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b',
                    'c', 'd', 'e', 'f' };
    /**
     * Caractere possible a mettre dans la grille 25X25.
     */
    private static final char[] CHARPOSSIBLE25X25 = new char[]
            {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b',
            'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o' };
    /**
     * Caractere possible.
     */
    private char[] jeuxDeCaracteres;
    @Override
    public final char[] getJeuxDeCaracteres() {
        char[] jeuxClone = this.jeuxDeCaracteres.clone();
        return jeuxClone;
    }
    /**
     * taille des carrees.
     */
    private int carreSize;
    /**
     * methode qui permet de rendre la taille des carrees.
     * @return la taille du carre
     */
    public final int getCarreSize() {
        return carreSize;
    }
    /**
     * Constructeur.
     * @param grilleDeBase est une grille de type tableau à deux dimensions
     */
    public GrilleImpl(final char[][] grilleDeBase) {
        this(grilleDeBase.length);
        char[][] grilleClone = grilleDeBase.clone();
        for (int i = 0; i < grilleClone.length; i++) {
            if (grilleClone.length == grilleClone[i].length) {
                for (int j = 0; j < grilleClone.length; j++) {
                    setValue(i, j, grilleClone[i][j]);
                }
            } else {
                throw new IllegalArgumentException("dimension non supportee");
            }
        }
    }
    /**
     * Constructeur.
     * @param dim est la dimension de la grille
     */
    public GrilleImpl(final int dim) {
        this.grille = new char[dim][dim];
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                this.grille[i][j] = EMPTY;
            }
        }
        if (grille.length == CHARPOSSIBLE9X9.length) {
            this.jeuxDeCaracteres = CHARPOSSIBLE9X9;
        } else if (grille.length == CHARPOSSIBLE16X16.length) {
            this.jeuxDeCaracteres = CHARPOSSIBLE16X16;
        } else if (grille.length == CHARPOSSIBLE25X25.length) {
            this.jeuxDeCaracteres = CHARPOSSIBLE25X25;
        } else {
            throw new IllegalArgumentException("dimension non supportee");
        }
        this.carreSize = (int) Math.sqrt(grille.length);
    }
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
        for (char s : jeuxDeCaracteres) {
            if (s == c) {
                return true;
            }
        }
        return false;
    }
    /**
     * verifie un caractere.
     * @param c caractere à verifier
     * @return true si c est possible
     */
    public final boolean verifCharInit(final char c) {
        for (char s : jeuxDeCaracteres) {
            if (s == c || c == '@') {
                return true;
            }
        }
        return false;
    }
    @Override
    public final void setValue(final int x, final int y, final char value)
            throws IllegalArgumentException {
        if (!verifGetValue(x) || !verifGetValue(y)) {
            throw new IllegalArgumentException("x et/ou y "
                    + "est(sont) hors des dimensions"
                    + x + " " + y + " " + value);
        } else {
            if (!verifCharInit(value)) {
                throw new IllegalArgumentException("Caractere non autorise "
            + x + " " + y + "=" + value);
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
            System.out.println("verif get value x=" + x);
            return false;
        }
        return true;
    }
    @Override
    public final char getValue(final int x, final int y) {
        if (!verifGetValue(x)) {
            throw new IllegalArgumentException("x est hors borne " + x);
        } else if (!verifGetValue(y)) {
            throw new IllegalArgumentException("y est hors borne " + y);
        } else {
            return this.grille[x][y];
        }
    }
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
        if (verifChar(value)) {
            int r = row - row % carreSize;
            int c = col - col % carreSize;
            for (int i = r; i < r + carreSize; i++) {
                for (int j = c; j < c + carreSize; j++) {
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
     * méthode qui copie une grille.
     */
    public final static Grille copieGrille( Grille g) {
        final Grille gr = g;
        return gr;
    }
    /**
     * méthode d'affichage.
     */
    public final void affiche() {
        for (int l = 0; l < grille.length; l++) {
            for (int c = 0; c < grille.length; c++) {
                System.out.print(" " + grille[l][c]);
            }
            System.out.println();

        }
        System.out.println();
    }
}
