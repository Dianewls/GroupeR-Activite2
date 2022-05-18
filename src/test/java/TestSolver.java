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
//  /**
//   * grille9 grille de test 9x9.
//   */
//    GrilleImpl grille9=new GrilleImpl(grille9x9Aremplir);
//    Solver solver9 = new Solver(grille9);
//    /**
//     * grille16 grille de test 16x16.
//     */
//    GrilleImpl grille16=new GrilleImpl(grille16x16Aremplir);
//    Solver solver16 = new Solver(grille16);
    /**
     *  Test pour le constructeur du solver
     */
    @Test
    public final void testSolver() {
        Grille g = null;
        Solver A = new Solver(g);
    }
    /**
     *  Test methode solve pour la grille 9X9
     */
    @Test
    public final void testSolve() {
        GrilleImpl grille9=new GrilleImpl(grille9x9Aremplir);
        Solver solver9 = new Solver(grille9);
        assertEquals(true, solver9.solve());
    }
    /**
     *  Test methode solve pour la grille 16X16
     */
    @Test
    public final void testSolve2() {
        GrilleImpl grille16=new GrilleImpl(grille16x16Aremplir);
        Solver solver16 = new Solver(grille16);
        assertEquals(true, solver16.solve());
    }
    /**
     *  Test methode estvalide la grille 16X16
     */
    @Test
    public final void testEstvalide() {
        GrilleImpl grille16=new GrilleImpl(grille16x16Aremplir);
        Solver solver16 = new Solver(grille16);
        assertEquals(true, solver16.solve());
    }
    

}
