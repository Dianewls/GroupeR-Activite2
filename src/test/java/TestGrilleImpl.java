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
            {'@', '6', '@', '@', '4', '5', '3', '7', '@' },
            {'@', '@', '5', '6', '7', '3', '4', '2', '@' },
            {'@', '@', '4', '@', '@', '@', '@', '@', '1' },
            {'5', '@', '@', '7', '@', '2', '@', '@', '4' },
            {'6', '@', '9', '@', '@', '@', '2', '5', '@' },
            {'8', '@', '7', '@', '@', '9', '@', '@', '3' },
            {'4', '9', '@', '5', '1', '7', '8', '@', '@' },
            {'2', '1', '@', '@', '3', '6', '@', '@', '@' },
            {'@', '5', '@', '@', '2', '@', '1', '@', '@' } };
    /**
     * Grille9x9Remplie grille de taille 9 resolue.
     */
    private char[][] grille9x9Remplie = {
            {'9', '6', '2', '1', '4', '5', '3', '7', '8' },
            {'1', '8', '5', '6', '7', '3', '4', '2', '9' },
            {'3', '7', '4', '2', '9', '8', '5', '6', '1' },
            {'5', '3', '1', '7', '6', '2', '9', '8', '4' },
            {'6', '4', '9', '3', '8', '1', '2', '5', '7' },
            {'8', '2', '7', '4', '5', '9', '6', '1', '3' },
            {'4', '9', '6', '5', '1', '7', '8', '3', '2' },
            {'2', '1', '8', '9', '3', '6', '7', '4', '5' },
            {'7', '5', '3', '8', '2', '4', '1', '9', '6' } };
    /**
     * Grille16x16Aremplir grille de taille 16 de base.
     */
    private char[][] grille16x16Aremplir = {
            {'@', '2', '@', '@', '8', '@', 'B', '@',
              '@', '@', '@', '@', '@', '@', '5', '7' },
            {'9', 'F', 'C', '@', '@', '1', '@', '@',
              '@', '8', '5', 'B', 'E', '4', 'A', '2' },
            {'@', '@', '@', '1', '@', 'A', '4', '2',
              '@', '@', '@', '7', 'G', 'B', '9', '@' },
            {'@', '@', 'A', 'B', 'C', 'D', '5', '@',
              '@', '@', '2', '4', '3', '8', '6', '@' },
            {'B', 'E', '@', '@', '5', '@', '@', '@',
              '2', 'G', '@', '9', '4', '6', 'C', '@' },
            {'@', '@', '7', '@', '@', '@', '@', 'E',
              '6', 'B', '3', '@', '2', '@', 'G', '@' },
            {'3', '6', '@', '9', '@', '@', '@', '4',
              'F', 'C', 'A', '5', '@', '@', '1', '@' },
            {'2', 'C', '@', '@', '@', '@', '1', '6',
              '4', 'D', '8', 'E', '@', '@', '@', '@' },
            {'@', '@', '2', '5', '@', '@', '8', 'B',
              'G', '7', 'F', '@', '@', '1', '@', '@' },
            {'@', '@', 'B', '@', '@', '@', 'C', 'G',
              '9', '@', '@', '@', '5', 'F', '@', '3' },
            {'1', '3', '@', '@', '7', '9', '@', '@',
              '@', '@', '@', '@', '8', '2', 'D', '@' },
            {'C', 'D', '6', '7', '2', 'E', '@', '@',
              '@', '@', '@', '8', '9', '@', '@', 'A' },
            {'5', 'B', '8', '2', '6', '@', '@', 'D',
              '@', 'A', '@', '@', '1', '3', '@', '@' },
            {'6', '@', '@', 'C', '4', '@', '7', '1',
              '@', '@', 'G', '@', 'B', '@', 'F', '@' },
            {'@', '1', '@', '4', '3', 'B', '@', '@',
              '5', '9', '@', 'D', '@', '@', '8', 'G' },
            {'G', '@', '3', 'D', 'A', 'F', '@', '@',
              'B', '4', '@', 'C', '@', '@', '2', '@' } };
    /**
     * Grille16x16Remplie grille de taille 16 resolue.
     */
    private char[][] grille16x16Remplie = {
            {'E', '2', '4', '6', '8', '3', 'B', 'F',
              'A', '1', '9', 'G', 'D', 'C', '5', '7' },
            {'9', 'F', 'C', '3', 'G', '1', '6', '7',
              'D', '8', '5', 'B', 'E', '4', 'A', '2' },
            {'D', '8', '5', '1', 'E', 'A', '4', '2',
              '3', '6', 'C', '7', 'G', 'B', '9', 'F' },
            {'7', 'G', 'A', 'B', 'C', 'D', '5', '9',
              'E', 'F', '2', '4', '3', '8', '6', '1' },
            {'B', 'E', '1', 'F', '5', '8', '3', 'A',
              '2', 'G', '7', '9', '4', '6', 'C', 'D' },
            {'4', '5', '7', '8', 'F', 'C', 'D', 'E',
              '6', 'B', '3', '1', '2', 'A', 'G', '9' },
            {'3', '6', 'D', '9', 'B', '2', 'G', '4',
              'F', 'C', 'A', '5', '7', 'E', '1', '8' },
            {'2', 'C', 'G', 'A', '9', '7', '1', '6',
              '4', 'D', '8', 'E', 'F', '5', '3', 'B' },
            {'A', '9', '2', '5', 'D', '4', '8', 'B',
              'G', '7', 'F', '3', 'C', '1', 'E', '6' },
            {'8', '4', 'B', 'E', '1', '6', 'C', 'G',
              '9', '2', 'D', 'A', '5', 'F', '7', '3' },
            {'1', '3', 'F', 'G', '7', '9', 'A', '5',
              'C', 'E', 'B', '6', '8', '2', 'D', '4' },
            {'C', 'D', '6', '7', '2', 'E', 'F', '3',
              '1', '5', '4', '8', '9', 'G', 'B', 'A' },
            {'5', 'B', '8', '2', '6', 'G', '9', 'D',
              '7', 'A', 'E', 'F', '1', '3', '4', 'C' },
            {'6', 'A', '9', 'C', '4', '5', '7', '1',
              '8', '3', 'G', '2', 'B', 'D', 'F', 'E' },
            {'F', '1', 'E', '4', '3', 'B', '2', 'C',
              '5', '9', '6', 'D', 'A', '7', '8', 'G' },
            {'G', '7', '3', 'D', 'A', 'F', 'E', '8',
              'B', '4', '1', 'C', '6', '9', '2', '5' } };
    /**
     * Grille16x16Aremplir grille de taille 16 de base.
     */
    private char[][] grille16x16Aremplir1 = {
            {'@', '@', '7', '@', '6', '@', '@', '3', 'G',
              '@', '@', '5', '@', '1', '@', '@' },
            {'@', '@', 'F', 'D', '@', '5', '9', 'G', '7',
              '3', '8', '@', '6', '4', '@', '@' },
            {'5', 'E', '@', '3', '@', '@', '@', '@', '@',
              '@', '@', '@', '7', '@', 'C', 'B' },
            {'@', '1', 'G', 'A', 'E', '@', 'C', '@', '@',
              'D', '@', 'B', '9', '5', '8', '@' },
            {'A', '@', '@', 'C', '4', '6', '@', '@', '@',
              '@', 'G', 'E', 'B', '@', '@', '5' },
            {'@', 'F', '@', '@', '3', '1', '@', '@', '@',
              '@', 'B', '7', '@', '@', '6', '@' },
            {'@', '6', '@', '1', '@', '@', '@', 'F', 'A',
              '@', '@', '@', '3', '@', '7', '@' },
            {'3', '7', '@', '@', '@', '@', '5', 'B', '9',
              'F', '@', '@', '@', '@', '4', '8' },
            {'F', 'C', '@', '@', '@', '@', '1', 'D', 'B',
              'G', '@', '@', '@', '@', '2', '6' },
            {'@', 'D', '@', 'G', '@', '@', '@', '2', 'C',
              '@', '@', '@', '5', '@', '3', '@' },
            {'@', 'B', '@', '@', 'F', 'G', '@', '@', '@',
              '@', 'D', '4', '@', '@', 'A', '@' },
            {'9', '@', '@', '5', 'B', 'E', '@', '@', '@',
              '@', 'F', '6', 'D', '@', '@', '1' },
            {'@', '3', 'C', '6', 'A', '@', 'B', '@', '@',
              '8', '@', 'G', '2', 'F', '5', '@' },
            {'D', 'A', '@', 'B', '@', '@', '@', '@', '@',
              '@', '@', '@', 'G', '@', '1', 'C' },
            {'@', '@', 'E', 'F', '@', '3', '4', '9', '5',
              'C', '1', '@', '8', '6', '@', '@' },
            {'@', '@', '1', '@', 'C', '@', '@', '6',
              'D', '@', '@', 'F', '@', '7', '@', '@' } };
    /**
     * Grille16x16Aremplir grille de taille 16 de base.
     */
    private char[][] grille16x16Remplie1 = {
            {'C', '8', '7', '9', '6', 'B', 'A', '3',
              'G', '4', 'E', '5', 'F', '1', 'D', '2' },
            {'B', '2', 'F', 'D', '1', '5', '9', 'G',
              '7', '3', '8', 'C', '6', '4', 'E', 'A' },
            {'5', 'E', '4', '3', 'D', 'F', '2', '8',
              '1', '6', 'A', '9', '7', 'G', 'C', 'B' },
            {'6', '1', 'G', 'A', 'E', '7', 'C', '4',
              'F', 'D', '2', 'B', '9', '5', '8', '3' },
            {'A', '9', 'D', 'C', '4', '6', '8', '7',
              '3', '1', 'G', 'E', 'B', '2', 'F', '5' },
            {'G', 'F', '5', '8', '3', '1', 'D', 'A',
              '4', '2', 'B', '7', 'E', 'C', '6', '9' },
            {'4', '6', 'B', '1', '2', '9', 'E', 'F',
              'A', '5', 'C', '8', '3', 'D', '7', 'G' },
            {'3', '7', '2', 'E', 'G', 'C', '5', 'B',
              '9', 'F', '6', 'D', '1', 'A', '4', '8' },
            {'F', 'C', '8', '7', '9', 'A', '1', 'D',
              'B', 'G', '5', '3', '4', 'E', '2', '6' },
            {'E', 'D', 'A', 'G', '8', '4', '6', '2',
              'C', '9', '7', '1', '5', 'B', '3', 'F' },
            {'1', 'B', '6', '2', 'F', 'G', '3', '5',
              '8', 'E', 'D', '4', 'C', '9', 'A', '7' },
            {'9', '4', '3', '5', 'B', 'E', '7', 'C',
              '2', 'A', 'F', '6', 'D', '8', 'G', '1' },
            {'7', '3', 'C', '6', 'A', 'D', 'B', '1',
              'E', '8', '9', 'G', '2', 'F', '5', '4' },
            {'D', 'A', '9', 'B', '5', '8', 'F', 'E',
              '6', '7', '4', '2', 'G', '3', '1', 'C' },
            {'2', 'G', 'E', 'F', '7', '3', '4', '9',
              '5', 'C', '1', 'A', '8', '6', 'B', 'D' },
            {'8', '5', '1', '4', 'C', '2', 'G', '6',
              'D', 'B', '3', 'F', 'A', '7', '9', 'E' } };
    /**
     * Grille7x8Aremplir grille de taille non valide.
     */
    private char[][] grille7x8Aremplir = {
            {'@', '6', '@', '@', '4', '5', '3', '7' },
            {'@', '@', '5', '6', '7', '3', '4', '2' },
            {'@', '@', '4', '@', '@', '@', '@', '@' },
            {'5', '@', '@', '7', '@', '2', '@', '@' },
            {'6', '@', '9', '@', '@', '@', '2', '5' },
            {'8', '@', '7', '@', '@', '9', '@', '@' },
            {'@', '5', '@', '@', '2', '@', '1', '@' } };
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
        assertEquals(true, grille16x16Test.verifChar('A'));
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
        grille16x16Test.setValue(0, 0, 'E');
        assertEquals('E', grille16x16Test.getValue(0, 0));
    }

    /**
     * methode qui teste la fonction SetValue lorsque la colonne est hors borne.
     */
    @Test
    public final void testSetValue2() {
        final int col = 15;
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> grille9x9Test.setValue(1, col, '8'));
    }

    /**
     * methode qui teste la fonction SetValue lorsque la ligne est hors borne.
     */
    @Test
    public final void testSetValue3() {
        final int ligne = 34;
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> grille9x9Test.setValue(ligne, 0, '8'));
    }

    /**
     * methode qui teste SetValue .
     * lorque le caractere donné est un caractère non
     * possible de la grille 9X9.
     */
    @Test
    public final void testSetValue4() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> grille9x9Test.setValue(1, 2, 'z'));
    }

    /**
     * methode qui teste SetValue .
     * lorque le caractere donné est un caractère non
     * possible de la grille 16X16.
     */
    @Test
    public final void testSetValue5() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> grille16x16Test.setValue(1, 2, 'z'));
    }

    /**
     * methode qui teste la fonction GetValue selon le contenu. grille 9X9
     */
    @Test
    public final void testGetValue() {
        assertEquals('@', grille9x9Test.getValue(0, 0));
    }

    /**
     * methode qui teste la fonction GetValue selon le contenu. grille 16X16
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
     * methode qui teste la fonction GetValue.
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
     * methode qui teste la fonction GetValue.
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
     * methode qui teste la fonction GetValue.
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
     * methode qui teste Complete().
     * le cas où la grille 9X9 n'est pas complète.
     */
    @Test
    public final void testComplete1() {
        assertEquals(false, grille9x9Test.complete());
    }

    /**
     * methode qui teste Complete().
     * le cas où la grille 9X9 est complète.
     */
    @Test
    public final void testComplete2() {
        assertEquals(true, grille9x9TestRemplie.complete());
    }

    /**
     * methode qui teste Complete().
     * le cas où la grille 16X16 n'est pas complète.
     */
    @Test
    public final void testComplete3() {
        assertEquals(false, grille16x16Test.complete());
    }

    /**
     * methode qui teste Complete().
     * le cas où la grille 16X16 est complète.
     */
    @Test
    public final void testComplete4() {
        assertEquals(true, grille16x16TestRemplie.complete());
    }

    /**
     * methode qui teste verifGetValue().
     * le cas où une coordonnée de la grille 9X9
     * est hors borne.
     */
    @Test
    public final void testVerifGetValue1() {
        final int value = -3;
        assertEquals(false, grille9x9Test.verifGetValue(value));
    }

    /**
     * methode qui teste verifGetValue().
     * le cas où une coordonnée de la grille 9X9
     * est dans la borne.
     */
    @Test
    public final void testVerifGetValue2() {
        final int value = 3;
        assertEquals(true, grille9x9Test.verifGetValue(value));
    }

    /**
     * methode qui teste verifGetValue().
     * le cas où une coordonnée de la grille 16X16
     * est hors borne.
     */
    @Test
    public final void testVerifGetValue3() {
        final int value = -3;
        assertEquals(false, grille16x16Test.verifGetValue(value));
    }

    /**
     * methode qui teste verifGetValue().
     * le cas où une coordonnée de la grille 16X16
     * est dans la borne.
     */
    @Test
    public final void testVerifGetValue4() {
        final int value = 4;
        assertEquals(true, grille16x16Test.verifGetValue(value));
    }

    /**
     * methode qui teste lignePossible().
     * pour voir si une valeur existe dans la
     * ligne grille 9X9
     */
    @Test
    public final void testLignePossible() {
        assertEquals(false, grille9x9Test.lignePossible(0, '6'));
    }

    /**
     * methode qui teste lignePossible().
     * pour voir si une valeur n'existe pas dans
     * la ligne grille 9X9
     */
    @Test
    public final void testLignePossible1() {
        assertEquals(true, grille9x9Test.lignePossible(0, '9'));
    }

    /**
     * methode qui teste lignePossible().
     * pour voir si une valeur n'existe pas dans
     * la ligne grille 16X16
     */
    @Test
    public final void testLignePossible2() {
        assertEquals(true, grille16x16Test.lignePossible(0, '6'));
    }

    /**
     * methode qui teste lignePossible().
     * pour voir si une valeur existe dans la
     * ligne grille 16X16
     */
    @Test
    public final void testLignePossible3() {
        assertEquals(false, grille16x16Test.lignePossible(0, '2'));
    }

    /**
     * methode qui teste lignePossible().
     * pour voir si une valeur donnée est
     * impossible dans la ligne grille 9X9
     */
    @Test
    public final void testLignePossible4() {
        assertEquals(false, grille9x9Test.lignePossible(0, 'Z'));
    }

    /**
     * methode qui teste lignePossible().
     * pour voir si une valeur donnée est
     * impossible dans la ligne grille 16X16
     */
    @Test
    public final void testLignePossible5() {
        assertEquals(false, grille16x16Test.lignePossible(0, 'Z'));
    }

    /**
     * methode qui teste colonnePossible().
     * pour voir si une valeur n'existe pas
     * dans la colonne grille 9X9
     */
    @Test
    public final void testColonnePossible() {
        assertEquals(false, grille9x9Test.colonnePossible(0, '6'));
    }

    /**
     * methode qui teste colonnePossible().
     * pour voir si une valeur existe dans la
     * colonne grille 9X9
     */
    @Test
    public final void testColonnePossible1() {
        assertEquals(true, grille9x9Test.colonnePossible(0, '1'));
    }

    /**
     * methode qui teste colonnePossible().
     * pour voir si une valeur n'existe pas
     * dans la colonne grille 16X16
     */
    @Test
    public final void testColonnePossible2() {
        assertEquals(true, grille16x16Test.colonnePossible(0, 'E'));
    }

    /**
     * methode qui teste colonnePossible().
     * pour voir si une valeur existe dans la
     * colonne grille 16X16
     */
    @Test
    public final void testColonnePossible3() {
        assertEquals(false, grille16x16Test.colonnePossible(0, '9'));
    }

    /**
     * methode qui teste colonnePossible().
     * pour voir si une valeur donnée est
     * impossible dans la colonne grille 9X9
     */
    @Test
    public final void testColonnePossible4() {
        assertEquals(false, grille9x9Test.colonnePossible(0, 'z'));
    }

    /**
     * methode qui teste colonnePossible().
     * pour voir si une valeur donnée est
     * impossible dans la colonne grille 16X16
     */
    @Test
    public final void testColonnePossible5() {
        assertEquals(false, grille16x16Test.colonnePossible(0, 'z'));
    }

    /**
     * methode qui teste carrePossible().
     * pour voir si une valeur donnée est
     * possible pour le carre grille 9X9
     */
    @Test
    public final void testCarrePossible1() {
        final int ligneP = 5;
        final int colP = 0;
        assertEquals(true, grille9x9Test.carrePossible(ligneP, colP, '1'));
    }

    /**
     * methode qui teste carrePossible().
     * pour voir si une valeur donnée est
     * impossible pour le carre grille 9X9
     */
    @Test
    public final void testCarrePossible2() {
        final int colP = 0;
        final int ligneP = 5;
        assertEquals(false, grille9x9Test.carrePossible(ligneP, colP, '8'));
    }

    /**
     * methode qui teste carrePossible().
     * pour voir si une valeur donnée est
     * possible pour le carre grille 16X16
     */
    @Test
    public final void testCarrePossible3() {
        final int ligneP = 5;
        final int colP = 0;
        assertEquals(true, grille16x16Test.carrePossible(ligneP, colP, '4'));
    }

    /**
     * methode qui teste carrePossible().
     * pour voir si une valeur donnée est
     * impossible pour le carre grille 16X16
     */
    @Test
    public final void testCarrePossible4() {
        final int colP = 0;
        final int ligneP = 5;
        assertEquals(false, grille16x16Test.carrePossible(ligneP, colP, '7'));
    }

    /**
     * methode qui teste carrePossible().
     * pour voir si un caractère est impossible
     * pour le carre grille 9X9
     */
    @Test
    public final void testCarrePossible5() {
        final int colP = 0;
        final int ligneP = 5;
        assertEquals(false, grille9x9Test.carrePossible(ligneP, colP, 'z'));
    }

    /**
     * methode qui teste carrePossible().
     * pour voir si un caractère est impossible
     * pour le carre grille 16X16
     */
    @Test
    public final void testCarrePossible6() {
        final int colP = 0;
        final int ligneP = 5;
        assertEquals(false, grille16x16Test.carrePossible(ligneP, colP, 'z'));
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
                () -> grille16x16Test.carrePossible(ligne1, 0, 'A'));
    }

    /**
     * methode qui teste carrePossible().
     * pour voir si la colonne est hors borne
     * grille 9X9
     */
    @Test
    public final void testCarrePossible9() {
        final int col1 = 88;
        // assertEquals(false, grille9x9Test.carrePossible(0, col1, '2'));
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
        // assertEquals(false, grille16x16Test.carrePossible(0, col1, 'A'));
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> grille16x16Test.carrePossible(0, col1, 'A'));
    }

    /**
     * methode qui teste Possible().
     * pour voir si une valeur est impossible, grille
     * 9X9
     */
    @Test
    public final void testPossible1() {
        assertEquals(false, grille9x9Test.possible(0, 1, '6'));
    }

    /**
     * methode qui teste Possible().
     * pour voir si une valeur est impossible, grille
     * 16X16
     */
    @Test
    public final void testPossible2() {
        assertEquals(false, grille16x16Test.possible(0, 1, '6'));
    }

    /**
     * methode qui teste Possible().
     * pour voir si une valeur est possible grille 9X9
     */
    @Test
    public final void testPossible3() {
        assertEquals(true, grille9x9Test.possible(0, 0, '9'));
    }

    /**
     * methode qui teste Possible().
     * pour voir si une valeur est possible grille 9X9
     */
    @Test
    public final void testPossible4() {
        assertEquals(false, grille16x16Test.possible(0, 0, '9'));
    }

    /**
     * methode qui teste Possible().
     * pour voir si le caractere est non autorise.
     * grille 9X9
     */
    @Test
    public final void testPossible5() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> grille9x9Test.possible(0, 0, 'z'));
    }

    /**
     * methode qui teste Possible().
     * pour voir si le caractere est non autorise.
     * grille 16X16
     */
    @Test
    public final void testPossible6() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> grille16x16Test.possible(0, 0, 'z'));
    }

    /**
     * methode qui teste Possible().
     * pour voir si la colonne est hors borne. grille
     * 9X9
     */
    @Test
    public final void testPossible7() {
        final int col1 = 88;
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> grille9x9Test.possible(0, col1, '9'));
    }

    /**
     * methode qui teste Possible().
     * pour voir si la colonne est hors borne. grille
     * 16X16
     */
    @Test
    public final void testPossible8() {
        final int col1 = 88;
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> grille16x16Test.possible(0, col1, '9'));
    }

    /**
     * methode qui teste Possible().
     * pour voir si la ligne est hors borne. * grille
     * 9X9
     */
    @Test
    public final void testPossible9() {
        final int ligne1 = 88;
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> grille9x9Test.possible(ligne1, 0, '9'));
    }

    /**
     * methode qui teste Possible().
     * pour voir si la ligne est hors borne. * grille
     * 16X16
     */
    @Test
    public final void testPossible10() {
        final int ligne1 = 88;
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> grille16x16Test.possible(ligne1, 0, '9'));
    }

    /**
     * methode qui teste Possible()
     * pour voir si les ligne et colonne sont hors
     * bornes. grille 9X9
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
     * pour voir si les ligne et colonne sont hors
     * bornes. grille 16X16
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
     * pour voir si une valeur est possible. grille
     * 9X9
     */
    @Test
    public final void testPossible13() {
        final int ligne = 3;
        assertEquals(false, grille9x9Test.possible(ligne, 2, '6'));
    }

    /**
     * methode qui teste Possible().
     * pour voir si une valeur est possible. grille
     * 16X16
     */
    @Test
    public final void testPossible14() {
        final int ligne = 3;
        assertEquals(false, grille16x16Test.possible(ligne, 2, '6'));
    }

    /**
     * methode qui teste Possible().
     * pour voir si une valeur est possible. grille
     * 9X9
     */
    @Test
    public final void testPossible15() {
        final int ligne = 1;
        assertEquals(false, grille9x9Test.possible(ligne, 1, '1'));
    }

    /**
     * methode qui teste Possible().
     * pour voir si une valeur est possible. grille
     * 9X9
     */
    @Test
    public final void testPossible16() {
        final int ligne = 5;
        assertEquals(false, grille9x9Test.possible(ligne, 1, '3'));
    }
    /**
     *  Test solveur() pour la grille 9X9.
     */
    @Test
    public final void testSolve9X9() {
        GrilleImpl grille9x9Test1 = new GrilleImpl(grille9x9Aremplir);
        System.out.print("TRUE");
        assertEquals(true, grille9x9Test1.solve());
        assertEquals(true, grille9x9Test1.complete());
        grille9x9Test.affiche();
    }
    /**
     *  Test solveur pour la grille 16X16.
     */
    @Test
    public final void testSolve16X16() {
        GrilleImpl grille16x16Test1 = new GrilleImpl(grille16x16Aremplir1);
        assertEquals(true, grille16x16Test1.solve());
        assertEquals(true, grille16x16Test1.complete());
        grille16x16Test1.affiche();
    }
}
