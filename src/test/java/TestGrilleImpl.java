import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

/**
 * Classe pour les tests.
 */
public class TestGrilleImpl {

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
        * Grille16x16Aremplir grille de taille 16 de base.
        */
       private char[][] grille16x16Aremplir = {
               {'@', '2', '@', '@', '8', '@', 'b', '@',
                '@', '@', '@', '@', '@', '@', '5', '7'},
               {'9', 'f', 'c', '@', '@', '1', '@', '@',
                '@', '8', '5', 'b', 'e', '4', 'a', '2'},
               {'@', '@', '@', '1', '@', 'a', '4', '2',
                '@', '@', '@', '7', '0', 'b', '9', '@'},
               {'@', '@', 'a', 'b', 'c', 'd', '5', '@',
                '@', '@', '2', '4', '3', '8', '6', '@'},
               {'b', 'e', '@', '@', '5', '@', '@', '@',
                '2', '0', '@', '9', '4', '6', 'c', '@'},
               {'@', '@', '7', '@', '@', '@', '@', 'e',
                '6', 'b', '3', '@', '2', '@', '0', '@'},
               {'3', '6', '@', '9', '@', '@', '@', '4',
                'f', 'c', 'a', '5', '@', '@', '1', '@'},
               {'2', 'c', '@', '@', '@', '@', '1', '6',
                '4', 'd', '8', 'e', '@', '@', '@', '@'},
               {'@', '@', '2', '5', '@', '@', '8', 'b',
                '0', '7', 'f', '@', '@', '1', '@', '@'},
               {'@', '@', 'b', '@', '@', '@', 'c', '0',
                '9', '@', '@', '@', '5', 'f', '@', '3'},
               {'1', '3', '@', '@', '7', '9', '@', '@',
                '@', '@', '@', '@', '8', '2', 'd', '@'},
               {'c', 'd', '6', '7', '2', 'e', '@', '@',
                '@', '@', '@', '8', '9', '@', '@', 'a'},
               {'5', 'b', '8', '2', '6', '@', '@', 'd',
                '@', 'a', '@', '@', '1', '3', '@', '@'},
               {'6', '@', '@', 'c', '4', '@', '7', '1',
                '@', '@', '0', '@', 'b', '@', 'f', '@'},
               {'@', '1', '@', '4', '3', 'b', '@', '@',
                '5', '9', '@', 'd', '@', '@', '8', '0'},
               {'0', '@', '3', 'd', 'a', 'f', '@', '@',
                'b', '4', '@', 'c', '@', '@', '2', '@'}};
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
        * grille9x9Test grille de test 9x9.
        */
       private GrilleImpl grille9x9Test = new GrilleImpl(grille9x9Aremplir);
       /**
        * grille16x16Test grille de test 16x16.
        */
       private GrilleImpl grille16x16Test = new GrilleImpl(grille16x16Aremplir);
       /**
        * grille9x9TestRemplie grille de test 9x9 remplie.
        */
       private GrilleImpl grille9x9TestRemplie =
               new GrilleImpl(grille9x9Remplie);
       /**
        * grille9x9TestRemplie grille de test 9x9 remplie.
        */
       private GrilleImpl grille16x16TestRemplie =
               new GrilleImpl(grille16x16Remplie);
       /**
        * methode qui teste le constructeur avec une grille 7X8.
        */
       @Test
       public final void grillConstruteurTestKo() {
         Assertions.assertThrows(IllegalArgumentException.class,
                 () -> new GrilleImpl(grille7x8Aremplir));
       }
       /**
        * test de la méthode getDimension() pour une girllr 9X9.
        */
       @Test
       public final void testGetDimension9X9() {
           final int dimGrille = 9;
           assertEquals(dimGrille, grille9x9Test.getDimension());
       }
       /**
        * test de la méthode getDimension() pour une grille 16X16.
        */
       @Test
       public final void testGetDimension16X16() {
           final int dimGrille = 16;
           assertEquals(dimGrille, grille16x16Test.getDimension());
       }
       /**
        * methode qui teste VerifChar pour une grille 9x9.
        */
       @Test
       public final void testVerifChar1() {
           assertEquals(true, grille9x9Test.verifChar('1'));
       }
       /**
        * methode qui teste VerifChar pour une grille 16x16.
        */
       @Test
       public final void testVerifChar2() {
           assertEquals(true, grille16x16Test.verifChar('a'));
       }
       /**
         * methode qui teste SetValue pour une grille 9x9.
         */
        @Test
        public final void testSetValue() {
            grille9x9Test.setValue(0, 0, '2');
            assertEquals('2', grille9x9Test.getValue(0, 0));
        }
        /**
         * methode qui teste SetValue pour une grille 16x16.
         */
        @Test
        public final void testSetValueBis() {
            grille16x16Test.setValue(0, 0, 'e');
            assertEquals('e', grille16x16Test.getValue(0, 0));
        }
        /**
         * methode qui teste la fonction SetValue
         * lorsque la colonne est hors borne.
         */
        @Test
        public final void testSetValue2() {
            final int col = 15;
            Assertions.assertThrows(IllegalArgumentException.class,
                    () -> grille9x9Test.setValue(1, col, '8'));
        }
        /**
         * methode qui teste la fonction SetValue
         * lorsque la ligne est hors borne.
         */
        @Test
        public final void testSetValue3() {
            final int ligne = 34;
            Assertions.assertThrows(IllegalArgumentException.class,
                    () -> grille9x9Test.setValue(ligne, 0, '8'));
        }
        /**
         * methode qui teste SetValue .
         * lorque le caractere donné est un caractère non possible
         * de la grille 9X9.
         */
        @Test
        public final void testSetValue4() {
            Assertions.assertThrows(IllegalArgumentException.class,
                    () -> grille9x9Test.setValue(1, 2, 'z'));
        }
        /**
         * methode qui teste SetValue .
         * lorque le caractere donné est un caractère non possible
         * de la grille 16X16.
         */
        @Test
        public final void testSetValue5() {
            Assertions.assertThrows(IllegalArgumentException.class,
                    () -> grille16x16Test.setValue(1, 2, 'z'));
        }
        /**
         * methode qui teste la fonction GetValue selon le contenu.
         * grille 9X9
         */
        @Test
        public final void testGetValue() {
            assertEquals('@', grille9x9Test.getValue(0, 0));
        }
        /**
         * methode qui teste la fonction GetValue selon le contenu.
         * grille 16X16
         */
        @Test
        public final void testGetValue2() {
            assertEquals('@', grille16x16Test.getValue(0, 0));
        }
        /**
         * methode qui teste la fonction GetValue
         * lorsque la colonne est hors borne.
         * grille 9X9
         */
        @Test
        public final void testGetValue3() {
           final int col = 15;
           Assertions.assertThrows(IllegalArgumentException.class,
                   () -> grille9x9Test.getValue(col, 1));
        }
        /**
         * methode qui teste la fonction GetValue
         * lorsque la ligne est hors borne.
         * grille 9X9
         */
        @Test
        public final void testGetValue4() {
           final int ligne = 34;
           Assertions.assertThrows(IllegalArgumentException.class,
                   () -> grille9x9Test.getValue(0, ligne));
        }
        /**
         * methode qui teste la fonction GetValue
         * lorsque la colonne est hors borne.
         * grille 16X16
         */
        @Test
        public final void testGetValue5() {
           final int col = 19;
           Assertions.assertThrows(IllegalArgumentException.class,
                   () -> grille16x16Test.getValue(col, 1));
        }
        /**
         * methode qui teste la fonction GetValue
         * lorsque la ligne est hors borne.
         * grille 16X16
         */
        @Test
        public final void testGetValue6() {
           final int ligne = 34;
           Assertions.assertThrows(IllegalArgumentException.class,
                   () -> grille16x16Test.getValue(0, ligne));
        }
        /**
         * methode qui teste Complete()
         * le cas où la grille 9X9 n'est pas complète.
         */
        @Test
        public final void testComplete1() {
            assertEquals(false, grille9x9Test.complete());
        }
        /**
         * methode qui teste Complete()
         * le cas où la grille 9X9 est complète.
         */
        @Test
        public final void testComplete2() {
            assertEquals(true, grille9x9TestRemplie.complete());
        }
        /**
         * methode qui teste Complete()
         * le cas où la grille 16X16 n'est pas complète.
         */
        @Test
        public final void testComplete3() {
            assertEquals(false, grille16x16Test.complete());
        }
        /**
         * methode qui teste Complete()
         * le cas où la grille 16X16 est complète.
         */
        @Test
        public final void testComplete4() {
            assertEquals(true, grille16x16TestRemplie.complete());
        }
        /**
         * methode qui teste verifGetValue()
         * le cas où une coordonnée de la grille 9X9 est hors borne.
         */
        @Test
        public final void testVerifGetValue1() {
            final int value = -3;
            assertEquals(false, grille9x9Test.verifGetValue(value));
        }
        /**
         * methode qui teste verifGetValue()
         * le cas où une coordonnée de la grille 9X9 est dans la borne.
         */
        @Test
        public final void testVerifGetValue2() {
            final int value = 3;
            assertEquals(true, grille9x9Test.verifGetValue(value));
        }
        /**
         * methode qui teste verifGetValue()
         * le cas où une coordonnée de la grille 16X16 est hors borne.
         */
        @Test
        public final void testVerifGetValue3() {
            final int value = -3;
            assertEquals(false, grille16x16Test.verifGetValue(value));
        }
        /**
         * methode qui teste verifGetValue()
         * le cas où une coordonnée de la grille 16X16 est dans la borne.
         */
        @Test
        public final void testVerifGetValue4() {
            final int value = 4;
            assertEquals(true, grille16x16Test.verifGetValue(value));
        }
        /**
         * methode qui teste lignePossible().
         * pour voir si une valeur existe dans la ligne
         * grille 9X9
         */
        @Test
        public final void testLignePossible() {
            assertEquals(false, grille9x9Test.lignePossible(0, '6'));
         }
        /**
         * methode qui teste lignePossible().
         * pour voir si une valeur n'existe pas dans la ligne
         * grille 9X9
         */
        @Test
        public final void testLignePossible1() {
            assertEquals(true, grille9x9Test.lignePossible(0, '9'));
         }
        /**
         * methode qui teste lignePossible().
         * pour voir si une valeur n'existe pas dans la ligne
         * grille 16X16
         */
        @Test
        public final void testLignePossible2() {
            assertEquals(true, grille16x16Test.lignePossible(0, '6'));
         }
        /**
         * methode qui teste lignePossible().
         * pour voir si une valeur existe dans la ligne
         * grille 16X16
         */
        @Test
        public final void testLignePossible3() {
            assertEquals(false, grille16x16Test.lignePossible(0, '2'));
         }
        /**
         * methode qui teste lignePossible().
         * pour voir si une valeur donnée est impossible dans la ligne
         * grille 9X9
         */
        @Test
        public final void testLignePossible4() {
            assertEquals(false, grille9x9Test.lignePossible(0, 'z'));
         }
        /**
         * methode qui teste lignePossible().
         * pour voir si une valeur donnée est impossible dans la ligne
         * grille 16X16
         */
        @Test
        public final void testLignePossible5() {
            assertEquals(false, grille16x16Test.lignePossible(0, 'z'));
         }
        /**
         * methode qui teste colonnePossible().
         * pour voir si une valeur n'existe pas dans la colonne
         * grille 9X9
         */
        @Test
        public final void testColonnePossible() {
            assertEquals(false, grille9x9Test.colonnePossible(0, '6'));
         }
        /**
         * methode qui teste colonnePossible().
         * pour voir si une valeur existe dans la colonne
         * grille 9X9
         */
        @Test
        public final void testColonnePossible1() {
            assertEquals(true, grille9x9Test.colonnePossible(0, '1'));
         }
        /**
         * methode qui teste colonnePossible().
         * pour voir si une valeur n'existe pas dans la colonne
         * grille 16X16
         */
        @Test
        public final void testColonnePossible2() {
            assertEquals(true, grille16x16Test.colonnePossible(0, 'e'));
         }
        /**
         * methode qui teste colonnePossible().
         * pour voir si une valeur existe dans la colonne
         * grille 16X16
         */
        @Test
        public final void testColonnePossible3() {
            assertEquals(false, grille16x16Test.colonnePossible(0, '9'));
         }
        /**
         * methode qui teste colonnePossible().
         * pour voir si une valeur donnée est impossible dans la colonne
         * grille 9X9
         */
        @Test
        public final void testColonnePossible4() {
            assertEquals(false, grille9x9Test.colonnePossible(0, 'z'));
         }
        /**
         * methode qui teste colonnePossible().
         * pour voir si une valeur donnée est impossible dans la colonne
         * grille 16X16
         */
        @Test
        public final void testColonnePossible5() {
            assertEquals(false, grille16x16Test.colonnePossible(0, 'z'));
         }
        /**
         * methode qui teste carrePossible().
         * pour voir si une valeur donnée est possible pour le carre
         * grille 9X9
         */
        @Test
        public final void testCarrePossible1() {
            final int ligneP = 5;
            final int colP = 0;
            assertEquals(true, grille9x9Test.carrePossible(ligneP, colP, '1'));
         }
        /**
         * methode qui teste carrePossible().
         * pour voir si une valeur donnée est impossible pour le carre
         * grille 9X9
         */
        @Test
        public final void testCarrePossible2() {
            final int colP = 0;
            final int ligneP = 5;
            assertEquals(false, grille9x9Test.carrePossible(ligneP, colP, '8'));
         }
        /**
         * methode qui teste carrePossible().
         * pour voir si une valeur donnée est possible pour le carre
         * grille 16X16
         */
        @Test
        public final void testCarrePossible3() {
            final int ligneP = 5;
            final int colP = 0;
            assertEquals(true, grille16x16Test.carrePossible(
                    ligneP, colP, '4'));
         }
        /**
         * methode qui teste carrePossible().
         * pour voir si une valeur donnée est impossible pour le carre
         * grille 16X16
         */
        @Test
        public final void testCarrePossible4() {
            final int colP = 0;
            final int ligneP = 5;
            assertEquals(false, grille16x16Test.carrePossible(
                    ligneP, colP, '7'));
         }
        /**
         * methode qui teste carrePossible().
         * pour voir si un caractère est impossible pour le carre
         * grille 9X9
         */
        @Test
        public final void testCarrePossible5() {
            final int colP = 0;
            final int ligneP = 5;
            assertEquals(false, grille9x9Test.carrePossible(ligneP, colP, 'z'));
         }
        /**
         * methode qui teste carrePossible().
         * pour voir si un caractère est impossible pour le carre
         * grille 16X16
         */
        @Test
        public final void testCarrePossible6() {
            final int colP = 0;
            final int ligneP = 5;
            assertEquals(false, grille16x16Test.carrePossible(
                    ligneP, colP, 'z'));
         }
        /**
         * methode qui teste carrePossible().
         * pour voir si la ligne est hors borne
         * grille 9X9
         */
        @Test
        public final void testCarrePossible7() {
            final int ligne1 = 88;
            Assertions.assertThrows(IllegalArgumentException.class,
                    () -> grille9x9Test.possible(ligne1, 0, '2'));
         }
        /**
         * methode qui teste carrePossible().
         * pour voir si la ligne est hors borne
         * grille 16X16
         */
        @Test
        public final void testCarrePossible8() {
            final int ligne1 = 88;
            Assertions.assertThrows(IllegalArgumentException.class,
                    () -> grille16x16Test.carrePossible(ligne1, 0, 'a'));
        }
        /**
         * methode qui teste carrePossible().
         * pour voir si la colonne est hors borne
         * grille 9X9
         */
        @Test
        public final void testCarrePossible9() {
            final int col1 = 88;
            //assertEquals(false, grille9x9Test.carrePossible(0, col1, '2'));
            Assertions.assertThrows(IllegalArgumentException.class,
                    () -> grille9x9Test.carrePossible(0, col1, '2'));
         }
        /**
         * methode qui teste carrePossible().
         * pour voir si la colonne est hors borne
         * grille 16X16
         */
        @Test
        public final void testCarrePossible10() {
            final int col1 = 88;
            //assertEquals(false, grille16x16Test.carrePossible(0, col1, 'A'));
            Assertions.assertThrows(IllegalArgumentException.class,
                    () -> grille16x16Test.carrePossible(0, col1, 'a'));
         }
        /**
         * methode qui teste Possible().
         * pour voir si une valeur est impossible,
         * grille 9X9
         */
        @Test
        public final void testPossible1() {
            assertEquals(false, grille9x9Test.possible(0, 1, '6'));
         }
        /**
         * methode qui teste Possible().
         * pour voir si une valeur est impossible,
         * grille 16X16
         */
        @Test
        public final void testPossible2() {
            assertEquals(false, grille16x16Test.possible(0, 1, '6'));
        }
        /**
         * methode qui teste Possible().
         * pour voir si une valeur est possible
         * grille 9X9
         */
        @Test
        public final void testPossible3() {
            assertEquals(true, grille9x9Test.possible(0, 0, '9'));
         }
        /**
         * methode qui teste Possible().
         * pour voir si une valeur est possible
         * grille 9X9
         */
        @Test
        public final void testPossible4() {
            assertEquals(false, grille16x16Test.possible(0, 0, '9'));
         }
        /**
         * methode qui teste Possible()
         * pour voir si le caractere est non autorise.
         * grille 9X9
         */
        @Test
        public final void testPossible5() {
           Assertions.assertThrows(IllegalArgumentException.class,
                   () -> grille9x9Test.possible(0, 0, 'z'));
        }
        /**
         * methode qui teste Possible()
         * pour voir si le caractere est non autorise.
         * grille 16X16
         */
        @Test
        public final void testPossible6() {
           Assertions.assertThrows(IllegalArgumentException.class,
                   () -> grille16x16Test.possible(0, 0, 'z'));
        }
        /**
         * methode qui teste Possible()
         * pour voir si la colonne est hors borne.
         * grille 9X9
         */
        @Test
        public final void testPossible7() {
           final int col1 = 88;
          Assertions.assertThrows(IllegalArgumentException.class,
                  () -> grille9x9Test.possible(0, col1, '9'));
        }
        /**
         * methode qui teste Possible()
         * pour voir si la colonne est hors borne.
         * grille 16X16
         */
        @Test
        public final void testPossible8() {
           final int col1 = 88;
          Assertions.assertThrows(IllegalArgumentException.class,
                  () -> grille16x16Test.possible(0, col1, '9'));
        }
        /**
         * methode qui teste Possible()
         * pour voir si la ligne est hors borne.
         * * grille 9X9
         */
        @Test
        public final void testPossible9() {
            final int ligne1 = 88;
          Assertions.assertThrows(IllegalArgumentException.class,
                  () -> grille9x9Test.possible(ligne1, 0, '9'));
        }
        /**
         * methode qui teste Possible()
         * pour voir si la ligne est hors borne.
         * * grille 16X16
         */
        @Test
        public final void testPossible10() {
            final int ligne1 = 88;
          Assertions.assertThrows(IllegalArgumentException.class,
                  () -> grille16x16Test.possible(ligne1, 0, '9'));
        }
        /**
         * methode qui teste Possible()
         * pour voir si les ligne et colonne sont hors bornes.
         * grille 9X9
         */
        @Test
        public final void testPossible11() {
            final int ligne1 = 88;
            final int col1 = 88;
          Assertions.assertThrows(IllegalArgumentException.class,
                  () -> grille9x9Test.possible(ligne1, col1, '9'));
        }
        /**
         * methode qui teste Possible()
         * pour voir si les ligne et colonne sont hors bornes.
         * grille 16X16
         */
        @Test
        public final void testPossible12() {
            final int ligne1 = 88;
            final int col1 = 88;
          Assertions.assertThrows(IllegalArgumentException.class,
                  () -> grille16x16Test.possible(ligne1, col1, '9'));
        }
        /**
         * methode qui teste Possible().
         * pour voir si une valeur est possible.
         * grille 9X9
         */
        @Test
        public final void testPossible13() {
            final int ligne = 3;
              assertEquals(false, grille9x9Test.possible(ligne, 2, '6'));
        }
        /**
         * methode qui teste Possible().
         * pour voir si une valeur est possible.
         * grille 16X16
         */
        @Test
        public final void testPossible14() {
            final int ligne = 3;
              assertEquals(false, grille16x16Test.possible(ligne, 2, '6'));
        }
        /**
         * methode qui teste Possible().
         * pour voir si une valeur est possible.
         * grille 9X9
         */
        @Test
        public final void testPossible15() {
            final int ligne = 1;
              assertEquals(false, grille9x9Test.possible(ligne, 1, '1'));
        }
        /**
         * methode qui teste Possible().
         * pour voir si une valeur est possible.
         * grille 9X9
         */
        @Test
        public final void testPossible16() {
            final int ligne = 5;
              assertEquals(false, grille9x9Test.possible(ligne, 1, '3'));
        }
       /**
        *  Test solveur() pour la grille 9X9
        */
       @Test
       public final void testSolve9X9() {
           GrilleImpl grille9x9 = new GrilleImpl(grille9x9Aremplir);
           GrilleImpl grille9x9TestRemplie =new GrilleImpl(grille9x9Remplie);
           Solver solver = new Solver(grille9x9TestRemplie);
           //assertEquals(true, grille9x9.solve());
          // assertEquals(true, solver.solve());
           assertEquals(true, grille9x9TestRemplie.complete());
       }
       /**
        *  Test solveur pour la grille 16X16
        */
       @Test
       public final void testSolve16X16() {
           GrilleImpl grille16x16Test = new GrilleImpl(grille16x16Aremplir);
           Solver solver = new Solver(grille16x16Test);
           GrilleImpl grille16x16TestRemplie = new GrilleImpl(grille16x16Remplie);
           //assertEquals(true, solver.solve());
           assertEquals(true, grille16x16TestRemplie.complete());
       }
       

}
