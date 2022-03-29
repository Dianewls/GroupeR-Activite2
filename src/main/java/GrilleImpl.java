
public class GrilleImpl implements Grille{
	/**
	 * 
	 */
	private char[][] grille;
	/**
	 * 
	 */
	private int longueur;
	/**
	 * 
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
	public GrilleImpl() {
		// TODO Auto-generated constructor stub
	}
	
	
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
        if (grille.length == GRILLE9x9SIZE) {
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
	public char getValue(int x, int y) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return 0;
	}
	 /**
	  * Test si une grille est terminee
	  * 
	  * @return true si la grille est complete
	  */
	@Override
	public boolean complete() {
		// TODO Auto-generated method stub
		return false;
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
	public boolean possible(int x, int y, char value) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return false;
	}

}
