
public class Resolution {

    public static void main(String[] args) {
        
     
       char[][] grille9x9Aremplir = {
               {'@', '6', '@', '@', '4', '5', '3', '7', '@' },
               {'@', '@', '5', '6', '7', '3', '4', '2', '@' },
               {'@', '@', '4', '@', '@', '@', '@', '@', '1' },
               {'5', '@', '@', '7', '@', '2', '@', '@', '4' },
               {'6', '@', '9', '@', '@', '@', '2', '5', '@' },
               {'8', '@', '7', '@', '@', '9', '@', '@', '3' },
               {'4', '9', '@', '5', '1', '7', '8', '@', '@' },
               {'2', '1', '@', '@', '3', '6', '@', '@', '@' },
               {'@', '5', '@', '@', '2', '@', '1', '@', '@' } };
    
       GrilleImpl grille9x9Test = new GrilleImpl(grille9x9Aremplir);
       grille9x9Test.solve();
       grille9x9Test.affiche(); 
    }
}
