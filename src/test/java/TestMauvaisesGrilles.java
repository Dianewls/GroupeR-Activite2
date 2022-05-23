import org.junit.Test;
import org.junit.jupiter.api.Assertions;

/**
 * Classe pour les tests.
 */
public class TestMauvaisesGrilles {
    /**
     * grille3x2 de test.
     */
       private char[][] grille3x2Aremplir = {
           {'@', '1'},
           {'@', '@'},
           {'@', '@'}};
      /**
       * grille3x2 de test.
      */
       private char[][] grille2x3Aremplir = {{'@', '@', '1'}, {'2', '@', '@'}};
       /**
        * grille9x8 de test.
        */
      private char[][] grille9x8Aremplir = {
           {'@', '6', '@', '@', '4', '5', '3', '7'},
           {'@', '@', '5', '6', '7', '3', '4', '2'},
           {'@', '@', '4', '@', '@', '@', '@', '@'},
           {'5', '@', '@', '7', '@', '2', '@', '@'},
           {'6', '@', '9', '@', '@', '@', '2', '5'},
           {'8', '@', '7', '@', '@', '9', '@', '@'},
           {'4', '9', '@', '5', '1', '7', '8', '@'},
           {'2', '1', '@', '@', '3', '6', '@', '@'},
           {'@', '5', '@', '@', '2', '@', '1', '@'}};
      /**
       * mauvaise grille9x98 de test.
       */
       private char[][] grille9x98Aremplir = {
               {'@', '6', '@', '@', '4', '5', '3', '7', '@'},
               {'@', '@', '5', '6', '7', '3', '4', '2'},
               {'@', '@', '4', '@', '@', '@', '@', '@'},
               {'5', '@', '@', '7', '@', '2', '@', '@'},
               {'6', '@', '9', '@', '@', '@', '2', '5'},
               {'8', '@', '7', '@', '@', '9', '@', '@'},
               {'4', '9', '@', '5', '1', '7', '8', '@'},
               {'2', '1', '@', '@', '3', '6', '@', '@'},
               {'@', '5', '@', '@', '2', '@', '1', '@'}};
       /**
        * Grille7x8Aremplir grille de taille non valide.
        */
       private char[][] grille7x8Aremplir = {
           {'@', '6', '@', '@', '4', '5', '3', '7'},
           {'@', '@', '5', '6', '7', '3', '4', '2'},
           {'@', '@', '4', '@', '@', '@', '@', '@'},
           {'5', '@', '@', '7', '@', '2', '@', '@'},
           {'6', '@', '9', '@', '@', '@', '2', '5'},
           {'8', '@', '7', '@', '@', '9', '@', '@'},
           {'@', '5', '@', '@', '2', '@', '1', '@'}};
   /**
    * methode qui teste le constructeur avec une grille 9X98.
    */
    @Test
    public final void testGrilleDimensionsTordues9x98() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new GrilleImpl(grille9x98Aremplir));
    }
    /**
     * methode qui teste le constructeur avec une grille 7X8.
     */
    @Test
    public final void grillConstruteurTestKo() {
      Assertions.assertThrows(IllegalArgumentException.class,
              () -> new GrilleImpl(grille7x8Aremplir));
    }
    /**
     * methode qui teste le constructeur avec une grille 2X3.
     */
     @Test
     public final void testGrilleDimensionsTordues2x3() {
         Assertions.assertThrows(IllegalArgumentException.class,
                 () -> new GrilleImpl(grille2x3Aremplir));
     }
     /**
      * methode qui teste le constructeur avec une grille 3X2.
      */
     @Test
     public final void testGrilleDimensionsTordues3x2() {
         Assertions.assertThrows(IllegalArgumentException.class,
                 () -> new GrilleImpl(grille3x2Aremplir));
     }
     /**
      * methode qui teste le constructeur avec une grille 9X8.
      */
     @Test
     public final void testGrilleDimensionsTordues9x8() {
         Assertions.assertThrows(IllegalArgumentException.class,
                 () -> new GrilleImpl(grille9x8Aremplir));
     }


}
