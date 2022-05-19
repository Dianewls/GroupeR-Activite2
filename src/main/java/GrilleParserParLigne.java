import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * Parser de grille de sudoku utilisant un BufferedReader
 */
public class GrilleParserParLigne {

    public static void parse(InputStream in, Grille grille) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8))) {
            int dimension = grille.getDimension();
            String line;
            int lineCount = 0;
            while ((line = reader.readLine()) != null) {
                for (int i = 0; i < dimension; i++) {
                    grille.setValue(lineCount, i, line.charAt(i));
                }
                lineCount++;
            }
        }
    }

    public static void parse(File f, Grille grille) throws IOException {
	try (InputStream in = new FileInputStream(f)) {
          parse(in, grille);
	}
    }

    /**
     * usage: GrilleParserParLigne dimension fichier
     * <p>
     * exemple: GrilleParserParLigne 16 ma_grille_16x16.txt
     */
    public static void main(String[] args) {
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        int dim = Integer.parseInt(args[0]);
        System.out.println("Dimension "+dim);
        GrilleImpl grille = new GrilleImpl(dim);
        char [][] matrice = grille.getGrille();
        try {
           
            GrilleParserParLigne.parse(new File(args[1]), grille);
            System.out.println(grille.getDimension());
            for (int i = 0; i < dim; i++) {
                for (int j = 0; j < dim; j++) {
                    //matrice[i][j]=grille.getValue(i, j);
                    System.out.print(grille.getValue(i, j) + " ");
                }
                System.out.println();
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
        Solver solver = new Solver(grille);
        boolean b=solver.solve();
        System.out.println(b);
        solver.affiche(); 
    }

}
