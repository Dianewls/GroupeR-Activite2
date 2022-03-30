import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
/*
 * Classe pour les tests.
 */
public class TestGrilleImpl {
       /*
        * grille de taille 9 de base.
        */
       private char[][] Grille9x9Aremplir = {
               {'@', '6', '@', '@', '4', '5', '3', '7', '@'},
               {'@', '@', '5', '6', '7', '3', '4', '2', '@'},
               {'@', '@', '4', '@', '@', '@', '@', '@', '1'},
               {'5', '@', '@', '7', '@', '2', '@', '@', '4'},
               {'6', '@', '9', '@', '@', '@', '2', '5', '@'},
               {'8', '@', '7', '@', '@', '9', '@', '@', '3'},
               {'4', '9', '@', '5', '1', '7', '8', '@', '@'},
               {'2', '1', '@', '@', '3', '6', '@', '@', '@'},
               {'@', '5', '@', '@', '2', '@', '1', '@', '@'}};
       /*
        * grille de taille 9 resolue.
        */
       private char[][] Grille9x9Remplie = {
               {'9', '6', '2', '1', '4', '5', '3', '7', '8'},
               {'1', '8', '5', '6', '7', '3', '4', '2', '9'},
               {'3', '7', '4', '2', '9', '8', '5', '6', '1'},
               {'5', '3', '1', '7', '6', '2', '9', '8', '4'},
               {'6', '4', '9', '3', '8', '1', '2', '5', '7'},
               {'8', '2', '7', '4', '5', '9', '6', '1', '3'},
               {'4', '9', '6', '5', '1', '7', '8', '3', '2'},
               {'2', '1', '8', '9', '3', '6', '7', '4', '5'},
               {'7', '5', '3', '8', '2', '4', '1', '9', '6'}};
       /*
        * grille de taille 16 de base.
        */
       private char[][] Grille16x16Aremplir = {
               {'@', '2', '@', '@', '8', '@', 'B', '@', '@', '@', '@', '@', '@', '@', '5', '7'},
               {'9', 'F', 'C', '@', '@', '1', '@', '@', '@', '8', '5', 'B', 'E', '4', 'A', '2'},
               {'@', '@', '@', '1', '@', 'A', '4', '2', '@', '@', '@', '7', 'G', 'B', '9', '@'},
               {'@', '@', 'A', 'B', 'C', 'D', '5', '@', '@', '@', '2', '4', '3', '8', '6', '@'},
               {'B', 'E', '@', '@', '5', '@', '@', '@', '2', 'G', '@', '9', '4', '6', 'C', '@'},
               {'@', '@', '7', '@', '@', '@', '@', 'E', '6', 'B', '3', '@', '2', '@', 'G', '@'},
               {'3', '6', '@', '9', '@', '@', '@', '4', 'F', 'C', 'A', '5', '@', '@', '1', '@'},
               {'2', 'C', '@', '@', '@', '@', '1', '6', '4', 'D', '8', 'E', '@', '@', '@', '@'},
               {'@', '@', '2', '5', '@', '@', '8', 'B', 'G', '7', 'F', '@', '@', '1', '@', '@'},
               {'@', '@', 'B', '@', '@', '@', 'C', 'G', '9', '@', '@', '@', '5', 'F', '@', '3'},
               {'1', '3', '@', '@', '7', '9', '@', '@', '@', '@', '@', '@', '8', '2', 'D', '@'},
               {'C', 'D', '6', '7', '2', 'E', '@', '@', '@', '@', '@', '8', '9', '@', '@', 'A'},
               {'5', 'B', '8', '2', '6', '@', '@', 'D', '@', 'A', '@', '@', '1', '3', '@', '@'},
               {'6', '@', '@', 'C', '4', '@', '7', '1', '@', '@', 'G', '@', 'B', '@', 'F', '@'},
               {'@', '1', '@', '4', '3', 'B', '@', '@', '5', '9', '@', 'D', '@', '@', '8', 'G'},
               {'G', '@', '3', 'D', 'A', 'F', '@', '@', 'B', '4', '@', 'C', '@', '@', '2', '@'}};
       /*
        * grille de taille 16 resolue.
        */
       private char[][] Grille16x16Remplie = {
               {'E', '2', '4', '6', '8', '3', 'B', 'F', 'A', '1', '9', 'G', 'D', 'C', '5', '7'},
               {'9', 'F', 'C', '3', 'G', '1', '6', '7', 'D', '8', '5', 'B', 'E', '4', 'A', '2'},
               {'D', '8', '5', '1', 'E', 'A', '4', '2', '3', '6', 'C', '7', 'G', 'B', '9', 'F'},
               {'7', 'G', 'A', 'B', 'C', 'D', '5', '9', 'E', 'F', '2', '4', '3', '8', '6', '1'},
               {'B', 'E', '1', 'F', '5', '8', '3', 'A', '2', 'G', '7', '9', '4', '6', 'C', 'D'},
               {'4', '5', '7', '8', 'F', 'C', 'D', 'E', '6', 'B', '3', '1', '2', 'A', 'G', '9'},
               {'3', '6', 'D', '9', 'B', '2', 'G', '4', 'F', 'C', 'A', '5', '7', 'E', '1', '8'},
               {'2', 'C', 'G', 'A', '9', '7', '1', '6', '4', 'D', '8', 'E', 'F', '5', '3', 'B'},
               {'A', '9', '2', '5', 'D', '4', '8', 'B', 'G', '7', 'F', '3', 'C', '1', 'E', '6'},
               {'8', '4', 'B', 'E', '1', '6', 'C', 'G', '9', '2', 'D', 'A', '5', 'F', '7', '3'},
               {'1', '3', 'F', 'G', '7', '9', 'A', '5', 'C', 'E', 'B', '6', '8', '2', 'D', '4'},
               {'C', 'D', '6', '7', '2', 'E', 'F', '3', '1', '5', '4', '8', '9', 'G', 'B', 'A'},
               {'5', 'B', '8', '2', '6', 'G', '9', 'D', '7', 'A', 'E', 'F', '1', '3', '4', 'C'},
               {'6', 'A', '9', 'C', '4', '5', '7', '1', '8', '3', 'G', '2', 'B', 'D', 'F', 'E'},
               {'F', '1', 'E', '4', '3', 'B', '2', 'C', '5', '9', '6', 'D', 'A', '7', '8', 'G'},
               {'G', '7', '3', 'D', 'A', 'F', 'E', '8', 'B', '4', '1', 'C', '6', '9', '2', '5'}};
       /** 
        * grille de test 9x9.
        * */
       private GrilleImpl Grille9x9Test = new GrilleImpl(Grille9x9Aremplir);
       
       /** test de la méthode getDimension()*/
       @Test
       public void testGetDimension() {
           assertEquals(9, Grille9x9Test.getDimension());
       }
       
       /**
         * methode qui teste SetValue.
         */
        @Test
        public void testSetValue() {
            Grille9x9Test.setValue(0, 0, '2');
            assertEquals('2',Grille9x9Test.getValue(0, 0));     
        }
        /**
         * methode qui teste SetValue en fonction de la taille de la grille.
         */
        @Test
        public void testSetValue2() {
            Assertions.assertThrows(IllegalArgumentException.class, () -> Grille9x9Test.setValue(1, 15, '8'));
        }
        /**
         * methode qui teste SetValue en fonction des caractères possible dans la grille de la grille.
         */
        @Test
        public void testSetValue3() {
            Assertions.assertThrows(IllegalArgumentException.class, () -> Grille9x9Test.setValue(1, 2, 'z'));       
        }
        /**
         * methode qui teste GetValue selon le contenu.
         */
        @Test
        public void testGetValue()
        {
            assertEquals('@',Grille9x9Test.getValue(0, 0));
        }
        /**
         * methode qui teste GetValue selon le taille de grille.
         */
        @Test
        public void testGetValue2()
        {
           Assertions.assertThrows(IllegalArgumentException.class, () -> Grille9x9Test.getValue(15, 1));
        }
        
        /**
         * methode qui teste Complete().
         */
        @Test
        public void testComplete()
        {
            assertEquals(false,Grille9x9Test.complete());
        }
        /**
         * methode qui teste Possible() pour voir si une valeur existe dans la ligne.
         */
        @Test
        public void testPossible() {
            assertEquals(false,Grille9x9Test.possible(0, 1, '6'));//Valeur 6 existe dans la ligne
         }
        /**
         * methode qui teste Possible() pour voir si une valeur est inserable dans la grille.
         */
        @Test
        public void testPossible2() {
            assertEquals(true, Grille9x9Test.possible(0, 2, '2'));
       }
        /**
         * methode qui teste Possible() pour voir si la Case est non vide.
         */
        @Test
        public void testPossible3() {
          assertEquals(false, Grille9x9Test.possible(0, 1, 'a'));
        }
        /**
         * methode qui teste Possible() pour voir si le caractere est autorise.
         */
        @Test
        public void testPossible4() {
           Assertions.assertThrows(IllegalArgumentException.class, () -> Grille9x9Test.possible(0, 0, 'z'));
        }
        /**
         * methode qui teste Possible() pour voir si c'est hors grille .
         */
        @Test
        public void testPossible5() {
          Assertions.assertThrows(IllegalArgumentException.class, () -> Grille9x9Test.possible(34, 88, 'a'));
        }

        
}
