
public class GrilleImpl implements Grille {
	private int longueur;
	private int largeur;
	
	 /**
	  * @return largeur/hauteur de la grille
	  */
	@Override
	public int getDimension() {
		// TODO Auto-generated method stub
		return 0;
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
		// TODO Auto-generated method stub
		
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
