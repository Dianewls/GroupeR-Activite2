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
    private char[][] grille9x9Aremplir = {
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
     * Grille9x9Remplie grille de taille 16. 
     */
    private char[][] grille16x16Aremplir = {
             {'@', '1', 'b', 'a', 'f', '6', '4', '5', '8', '9', 'e', 'd', '2', '3', '7', 'c'},
             {'c', '6', '3', '8', 'd', '2', '@', 'e', '7', 'b', 'a', '1', 'f', '5', '4', '9'},
             {'9', '7', '4', '2', 'c', 'a', '1', '8', '5', 'f', '@', '3', '6', 'b', 'd', 'e'},
             {'d', '5', 'f', 'e', '9', 'b', '3', '7', '2', '4', 'c', '6', '1', '@', 'a', '8'},
             {'8', 'a', '@', '3', '1', 'e', 'b', 'd', '4', '5', '9', '7', 'c', 'f', '6', '2'},
             {'b', '9', 'e', 'c', 'a', '4', '8', '2', 'd', '6', '1', 'f', '3', '7', '5', '@'},
             {'2', 'f', 'd', '6', '5', '@', '7', '3', 'a', 'e', '8', 'c', '4', '1', '9', 'b'},
             {'1', '4', '5', '7', '6', 'c', 'f', '9', 'b', '3', '2', '@', 'a', '8', 'e', 'd'},
             {'5', '3', '2', '1', '4', '8', '6', '@', 'e', 'd', 'f', '9', '7', 'c', 'b', 'a'},
             {'e', 'b', '7', 'd', '2', '1', '9', 'a', '3', 'c', '5', '4', '@', '6', '8', 'f'},
             {'f', 'c', 'a', '4', 'e', '7', '5', 'b', '@', '8', '6', '2', 'd', '9', '1', '3'},
             {'6', '@', '8', '9', '3', 'd', 'c', 'f', '1', '7', 'b', 'a', 'e', '4', '2', '5'},
             {'3', 'e', '1', 'f', '8', '9', 'a', '4', 'c', '2', '7', '5', 'b', 'd', '@', '6'},
             {'7', 'd', '9', '5', '@', 'f', 'e', '1', '6', 'a', '3', 'b', '8', '2', 'c', '4'},
             {'4', '8', 'c', 'b', '7', '5', '2', '6', 'f', '@', 'd', 'e', '9', 'a', '3', '1'},
             {'a', '2', '6', '@', 'b', '3', 'd', 'c', '9', '1', '4', '8', '5', 'e', 'f', '7'}};
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
         * Grille25x25 grille de taille 25 pour test.
         */
        char[][] grille25x25Remplie = new char[25][25];
        /**
         * Grille9x9Mauvaise grille de taille 9.
         */
        char[][] grille9x9Mauvaise = {
                {'6', '6', '6', '6', '4', '5', '3', '7', '@'},
                {'@', '@', '5', '6', '7', '3', '4', '2', '@'},
                {'@', '@', '4', '@', '@', '@', '@', '@', '1'},
                {'5', '@', '@', '7', '@', '2', '@', '@', '4'},
                {'6', '@', '9', '@', '@', '@', '2', '5', '@'},
                {'8', '@', '7', '@', '@', '9', '@', '@', '3'},
                {'4', '9', '@', '5', '1', '7', '8', '@', '@'},
                {'2', '1', '@', '@', '3', '6', '@', '@', '@'},
                {'@', '5', '@', '@', '2', '@', '1', '@', '@'}};
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
    }
    /**
     *  Test methode solve pour une grille non resolvable.
     */
    @Test
    public final void testSolve4() {
        GrilleImpl grille9=new GrilleImpl(grille9x9Mauvaise);
        Solver solver9 = new Solver(grille9);
        solver9.solve();
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
