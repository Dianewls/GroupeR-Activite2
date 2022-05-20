//import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
//import org.junit.jupiter.api.Assertions;

/**
 * Classe pour les tests du solevur.
 */
public class TestSolver {

    /**
     * Grille9x9Aremplir grille de taille 9 de base.
     */
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
    /**
     * Grille9x9Remplie grille de taille 9 resolue.
     */
    private char[][] grille9x9Remplie = {
            {'9', '6', '2', '1', '4', '5', '3', '7', '8'},
            {'1', '8', '5', '6', '7', '3', '4', '2', '9'},
            {'3', '7', '4', '2', '9', '8', '5', '6', '1'},
            {'5', '3', '1', '7', '6', '2', '9', '8', '4'},
            {'6', '4', '9', '3', '8', '1', '2', '5', '7'},
            {'8', '2', '7', '4', '5', '9', '6', '1', '3'},
            {'4', '9', '6', '5', '1', '7', '8', '3', '2'},
            {'2', '1', '8', '9', '3', '6', '7', '4', '5'},
            {'7', '5', '3', '8', '2', '4', '1', '9', '6'}};
    /**
     * Grille9x9Remplie grille de taille 16 
     */
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
      /**
       * Grille16x16Remplie grille de taille 16 resolue.
       */
      private char[][] grille16x16Remplie = {
              {'e', '2', '4', '6', '8', '3', 'b', 'f',
               'a', '1', '9', '0', 'd', 'c', '5', '7'},
              {'9', 'f', 'c', '3', '0', '1', '6', '7',
               'd', '8', '5', 'b', 'e', '4', 'a', '2'},
              {'d', '8', '5', '1', 'e', 'a', '4', '2',
               '3', '6', 'c', '7', '0', 'b', '9', 'f'},
              {'7', '0', 'a', 'b', 'c', 'd', '5', '9',
               'e', 'f', '2', '4', '3', '8', '6', '1'},
              {'b', 'e', '1', 'f', '5', '8', '3', 'a',
               '2', '0', '7', '9', '4', '6', 'c', 'd'},
              {'4', '5', '7', '8', 'f', 'c', 'd', 'e',
               '6', 'b', '3', '1', '2', 'a', '0', '9'},
              {'3', '6', 'd', '9', 'b', '2', '0', '4',
               'f', 'c', 'a', '5', '7', 'e', '1', '8'},
              {'2', 'c', '0', 'a', '9', '7', '1', '6',
               '4', 'd', '8', 'e', 'f', '5', '3', 'b'},
              {'a', '9', '2', '5', 'd', '4', '8', 'b',
               '0', '7', 'f', '3', 'c', '1', 'e', '6'},
              {'8', '4', 'b', 'e', '1', '6', 'c', '0',
               '9', '2', 'd', 'a', '5', 'f', '7', '3'},
              {'1', '3', 'f', '0', '7', '9', 'a', '5',
               'c', 'e', 'b', '6', '8', '2', 'd', '4'},
              {'c', 'd', '6', '7', '2', 'e', 'f', '3',
               '1', '5', '4', '8', '9', '0', 'b', 'a'},
              {'5', 'b', '8', '2', '6', '0', '9', 'd',
               '7', 'a', 'e', 'f', '1', '3', '4', 'c'},
              {'6', 'a', '9', 'c', '4', '5', '7', '1',
               '8', '3', '0', '2', 'b', 'd', 'f', 'e'},
              {'f', '1', 'e', '4', '3', 'b', '2', 'c',
               '5', '9', '6', 'd', 'a', '7', '8', '0'},
              {'0', '7', '3', 'd', 'a', 'f', 'e', '8',
               'b', '4', '1', 'c', '6', '9', '2', '5'}};

      /**
       * Grille9x9Remplie grille de taille 25
       */
        char[][] grille25x25Aremplir = {
                {'@','@','@','@','@','@','@','@','@','@','@','@','@','@','@','@','@','@','@','@','@','@','@','@','@'},
                {'@','@','@','@','@','@','@','@','@','@','@','@','@','@','@','@','@','@','@','@','@','@','@','@','@'},
                {'@','@','@','@','@','@','@','@','@','@','@','@','@','@','@','@','@','@','@','@','0','@','9','@','@'},
                {'@','0','@','@','@','b','7','@','@','m','l','6','@','@','@','5','o','3','c','@','@','@','@','n','@'},
                {'@','@','8','@','@','@','@','@','9','h','d','@','0','3','5','@','@','g','@','@','@','c','l','@','i'},
                {'@','d','@','b','@','@','@','@','@','@','@','j','@','8','l','1','0','@','@','@','e','@','@','@','@'},
                {'@','@','i','@','@','f','9','@','@','@','h','@','e','c','@','@','@','@','@','@','@','@','@','2','3'},
                {'o','@','j','k','@','@','@','2','l','3','@','@','@','@','@','@','@','7','@','@','@','@','@','d','@'},
                {'@','@','@','@','@','@','@','n','@','6','@','@','2','0','4','@','f','k','@','@','@','@','@','@','@'},
                {'@','6','@','9','@','@','a','1','e','d','g','@','@','n','@','h','c','5','@','@','k','@','@','@','f'},
                {'@','4','m','o','@','@','@','@','@','@','i','@','@','b','@','9','@','a','h','@','@','e','@','5','@'},
                {'@','a','@','@','@','@','0','j','@','g','@','@','d','4','@','@','i','@','@','n','@','8','@','1','@'},
                {'9','b','e','@','@','@','@','@','m','@','@','@','@','@','6','@','@','@','@','@','3','a','h','@','@'},
                {'@','@','g','5','@','@','l','@','b','1','@','@','@','2','f','0','@','@','o','@','@','m','@','j','@'},
                {'h','j','2','l','0','i','@','@','@','e','@','@','@','@','3','@','@','1','@','5','@','o','@','@','6'},
                {'@','h','@','@','o','@','c','@','f','@','5','@','@','g','@','2','n','e','@','a','@','@','@','@','@'},
                {'@','@','@','3','@','a','@','0','k','@','@','@','j','6','9','o','@','@','@','@','@','@','5','@','@'},
                {'@','c','a','@','5','@','@','d','@','@','@','@','b','@','m','@','8','9','@','@','n','@','@','f','@'},
                {'@','@','@','@','@','@','@','o','@','l','n','@','f','1','8','@','@','@','@','@','@','@','m','@','@'},
                {'@','e','7','0','d','@','m','8','g','b','@','i','@','@','o','c','@','6','@','@','@','@','@','@','h'},
                {'@','@','9','4','b','@','3','@','@','@','@','a','@','@','@','@','5','c','@','@','l','@','@','@','@'},
                {'5','l','@','e','@','k','5','@','7','@','@','o','@','@','@','@','3','i','@','@','@','@','@','9','j'},
                {'@','@','@','@','i','4','6','g','d','@','c','@','n','9','2','@','k','@','@','@','@','@','a','@','o'},
                {'5','@','f','@','6','h','@','9','n','@','j','k','@','i','@','4','a','0','@','g','@','7','@','@','m'},
                {'5','m','5','a','@','@','e','@','@','@','f','@','6','@','7','j','@','@','@','b','@','@','2','g','k'}};
        char[][] grille25x25Remplie = new char[25][25];
    /**
     *  Test pour le constructeur du solver.
     */
    @Test
    public final void testSolver() {
        Grille g = null;
        Solver A = new Solver(g);
    }
    /**
     *  Test methode solve pour la grille 9X9.
     */
    @Test
    public final void testSolve() {
        GrilleImpl grille9=new GrilleImpl(grille9x9Aremplir);
        Solver solver9 = new Solver(grille9);
        assertEquals(true, solver9.solve());
    }
    /**
     *  Test methode solve pour la grille 16X16.
     */
    @Test
    public final void testSolve2() {
      //FIXME mettre une grille presque remplie
        GrilleImpl grille16=new GrilleImpl(grille16x16Aremplir);
        Solver solver16 = new Solver(grille16);
        assertEquals(true, solver16.solve());
    }
    /**
     *  Test methode solve pour la grille 25X25.
     */
    @Test
    public final void testSolve3() {
        final int dim = 25;
        //GrilleImpl grille25=new GrilleImpl(dim);
        //Solver solver25 = new Solver(grille25);
        //assertEquals(false, solver25.solve());
    }
    /**
     *  Test methode affiche.
     */
    @Test
    public final void testaffiche() {
        GrilleImpl grille16=new GrilleImpl(grille16x16Aremplir);
        Solver solver16 = new Solver(grille16);
        solver16.affiche();
    }
    
    
    
  
    

}
