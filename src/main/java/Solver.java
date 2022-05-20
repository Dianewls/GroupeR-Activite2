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
        t=grille.getJeuxDeCaracteres();
        for (int ligne = 0; ligne < grille.getDimension(); ligne++) {
            for (int colonne = 0; colonne < grille.getDimension(); colonne++) {
                if (grille.getValue(ligne,colonne) == Grille.EMPTY) {
                    //System.out.println("taille de la grille dans solve "+grille.getGrille().length);
                    for (char s : t) {
                        if (grille.possible(ligne, colonne, s)) {
                            grille.setValue(ligne,colonne,s);
                            if (solve()) { //recursive
                                return true;
                            } else {
                                grille.setValue(ligne,colonne,Grille.EMPTY);
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
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
        GrilleImpl gri=new GrilleImpl(grille16x16Aremplir);
        Solver solver = new Solver(gri);
        //boolean b=solver.estValide(0);
        boolean b=solver.solve();
        System.out.println(b);
        gri.affiche(); 
    }
     public final void resolution (final int x, final int y, final char n, char[][] matrice) {
         char[] t; 
         if (grille.getDimension() ==CHARPOSSIBLE9X9.length) { 
             t = CHARPOSSIBLE9X9; 
         } else if(grille.getDimension() == CHARPOSSIBLE16X16.length) { 
             t =CHARPOSSIBLE16X16;
         }else {
             t = CHARPOSSIBLE25X25; 
         } 
         int o=0; 
         for (char s : t){
             if (s==n) {
                 break;
             } 
             o++; 
         }
         for (int i=o; i<t.length; i++) { //for (char s : t) { 
          if ((((GrilleImpl)grille).lignePossible(x,n))&&(((GrilleImpl)grille).colonnePossible(y,n))&&(((GrilleImpl) grille).carrePossible(x,y,n))){
              matrice[x][y]=n; 
          } 
      }
  }
      
      public final char[][] resolution_totale (char [][] matrice) { 
          for (int x=0; x<9;x++) { 
              for (int y=0; y<9; y++) { 
                  resolution(x,y,'0',matrice); 
                  if(matrice[x][y]=='@') { 
                      if (x>0) { 
                          resolution(x-1,y,matrice[x-1][y],matrice);
                          while (!((x!=matrice.length)&&(y!=matrice.length)&&(matrice[x][y]!='0'))) {
                              resolution_totale(matrice); 
                          } 
                      } else { 
                          if (y>0) {
                             resolution(matrice.length-1,y-1,matrice[matrice.length-1][y-1],matrice);
                             while (!((x!=matrice.length)&&(y!=matrice.length)&&(matrice[x][y]!='0'))) {
                                 resolution_totale(matrice);
                             } 
                          } else {
                              System.out.println("Pas de solution");
                             }
                          }
                 }
             } 
         }
        return matrice; 
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
