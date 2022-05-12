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
//    public final boolean solve() {
//        char[] t;
//        if (grille.getGrille().length == CHARPOSSIBLE9X9.length) {
//            t = CHARPOSSIBLE9X9;
//        } else if (grille.getGrille().length == CHARPOSSIBLE16X16.length) {
//            t = CHARPOSSIBLE16X16;
//        }else {
//            t = CHARPOSSIBLE25X25;
//        }
//        for (int ligne = 0; ligne < grille.getGrille().length; ligne++) {
//            for (int colonne = 0; colonne < grille.getGrille().length; colonne++) {
//                if (grille.getGrille()[ligne][colonne] == grille.EMPTY) {
//                    //System.out.println("taille de la grille dans solve "+grille.getGrille().length);
//                    for (char s : t) {
//                        if (grille.possible(ligne, colonne, s)) {
//                            grille.getGrille()[ligne][colonne] = s;
//                            if (solve()) { //recursive
//                                return true;
//                            } else {
//                                grille.getGrille()[ligne][colonne] = grille.EMPTY;
//                            }
//                        }
//                    }
//                    return false;
//                }
//            }
//        }
//        return true;
//    }
    
    
     public final void resolution (final int x, final int y, final char n, char[][] matrice) {
         char[] t; 
         if (grille.getGrille().length ==CHARPOSSIBLE9X9.length) { 
             t = CHARPOSSIBLE9X9; 
         } else if(grille.getGrille().length == CHARPOSSIBLE16X16.length) { 
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
     
    
    public static void resolution (int x, int y, int n, int[][] matrice)
    {
 
    for (int i=n; n<10; i++)
        {
        //if ((!doublon_ligne(x,n,0,9, matrice))&&(!doublon_colonne(y,n,0,9, matrice))&&(!doublon_carre(x,y,n,matrice)))
            {
            matrice[x][y]=n;
            }
        }
    }
 
    public static void resolution_totale (int[][] matrice)
    {
    for (int x=0; x<9; x++)
        {
        for (int y=0; y<9; y++)
            {
            resolution(x,y,1,matrice);
            if (matrice[x][y]==0)
                {
                if (x>0)
                    {
                    resolution(x-1,y,matrice[x-1][y]+1,matrice);
                    while (!((x!=9)&&(y!=9)&&(matrice[x][y]!=0)))
                        {
                        resolution_totale(matrice);
                        }
                    }
                else
                    {
                    if (y>0)
                        {
                        resolution(8,y-1,matrice[8][y-1]+1,matrice);
                        while (!((x!=9)&&(y!=9)&&(matrice[x][y]!=0)))
                            {
                            resolution_totale(matrice);
                            }
                        }
                    else
                        {
                        System.out.println("Pas de solution");
                        }
                    }
                }
 
 
            }
        }
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
