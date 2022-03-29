
public class GrilleImpl implements Grille{
	/**
	 * grille est la grille qui est un tableau à deux dimensions.
	 */
	private char[][] grille;
	/**
	 * longueur répresente la longueur.
	 */
	private int longueur;
	/**
	 * largeur répresente la largeur.
	 */
	private int largeur;
	 /**
     * @var GRILLE9x9SIZE taille du tableau 9*9.
     */
    private static final int GRILLE9x9SIZE = 9;
    /**
     * @var SIZEE taille du tableau 16*16.
     */
    private static final int GRILLE16x16SIZE = 16;
    /**
     * Caractere possible a mettre dans la grille.
     * pour une grille 9x9 : 1..9
     * pour une grille 16x16: 0..9-a..f
     */
    private static final char[] CHARPOSSIBLE = new char[]
            {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
	
    /**
     * Constructeur.
     * @param unegrille qui est un tableau à deux dimensions
     */
	 public GrilleImpl(char[][] unegrille) {
		super();
		if (unegrille.length == GRILLE9x9SIZE || unegrille.length == GRILLE16x16SIZE) {
			this.grille = unegrille;
		}else {
			 throw new IllegalArgumentException("Le tableau doit être de dimension 9x9 ou 16x16");
		}
	}

	/**
	  * @return largeur/hauteur de la grille
	  */
	@Override
	public int getDimension() {
		return grille.length;
	}
	 /**
	  * Affecte une valeur dans la grille
	  * 
	  * @param x       position x dans la grille
	  * @param y       position y dans la grille
	  * @param value
	  *            valeur a mettre dans la case
	  * @throw IllegalArgumentException si x ou y sont hors bornes (0-8)
	  * @throw IllegalArgumentException si la valeur est interdite aux vues des
	  *        autres valeurs de la grille
	  * @throw IllegalArgumentException si value n'est pas un caractere autorise
	  *        ('1',...,'9')
	  */
	@Override
	public void setValue(int x, int y, char value) throws IllegalArgumentException {
		if (x < 0 || x > this.getDimension()
                || y < 0 || y > this.getDimension()) {
            throw new IllegalArgumentException("x et/ou y est(sont) hors des dimensions");
        } else {
            if (!belong(value)) {
                throw new IllegalArgumentException("Caractere non autorise");
            }
        }
        grille[x][y] = value;
	}
	 /**
     * Verify if the character to add is authorized.
     * @param c caractere a verifier
     * @return true or false
     */
    public final boolean belong(final char c) {
        if (grille.length == GRILLE9x9SIZE || grille.length == GRILLE16x16SIZE) {
            for (char s : CHARPOSSIBLE) {
                if (s == c) {
                    return true;
                }
            }
        }
        return false;
    }
	/**
	  * Recupere une valeur de la grille
	  * 
	  * @param x      position x dans la grille
	  * @param y      position y dans la grille
	  * @return valeur dans la case x,y
	  * @throw IllegalArgumentException si x ou y sont hors bornes (0-8)
	  */
	@Override
	public final char getValue (final int x, final int y) {
	    if (x < 0 || x > this.getDimension() || y < 0 || y > this.getDimension()) {
            throw new IllegalArgumentException("x ou y is out of matrice");
        } else {
            return this.grille[x][y];
        }
	}
	 /**
	  * Test si une grille est terminee
	  * 
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
	  * Test si une valeur est possible dans la grille par rapport a ce qu'elle
	  * contient deja
	  * 
	  * @param x     position x dans la grille
	  * @param y     position y dans la grille
	  * @param value
	  *            valeur a mettre dans la case
	  * @throw IllegalArgumentException si x ou y sont hors bornes (0-8)
	  * @throw IllegalArgumentException si value n'est pas un caractere autorise
	  *        ('1',...,'9',..)
	  */
	@Override
	public final boolean possible(final int x, final int y, final char value) {
	    if ((x >= 0 || x < grille.length) && (y >= 0 || y < grille.length)) {
            if (getValue(x, y) == EMPTY) {
                if (!belong(value)) {
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
	/**
     * Tester si une valeur est possible pour une ligne donnee.
     * @param x numero de la ligne
     * @param y valeur qu'on veut ajouter
     * @return true si la valeur est possible pour la ligne
     */
    public final boolean lignePossible(final int ligne, final char value) {
        for (int i = 0; i < grille.length; i++) {
            if (getValue(ligne, i) == value  && belong(value)) {
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
            if (getValue(i, col) == value && belong(value)) {
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
    public final boolean carrePossible(final int row, final int col, final char value) { //3 est la taille d'un carré de sudoku de taille 9x9
        int r = row - row % 3;
        int c = col - col % 3;
        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                if (grille[i][j] == value && belong(value)) {
                    return true;
                }
            }
        }
        return false;
    }

}
