import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
/**
 * Parser de grille de sudoku utilisant un BufferedReader.
 */
public final class GrilleParserParLigne {
    /**
     * constructeur.
     */
    private GrilleParserParLigne() {
    }
    /**
     * méthode qui permet de parcourir le fichier.
     * @param grille grille à parcourir
     * @throws IOException exception en cas de problème
     * @param in input
     */
    public static void parse(final InputStream in, final Grille grille)
            throws IOException {
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(in, StandardCharsets.UTF_8))) {
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
    /**
     * méthode qui permet de parcourir le fichier.
     * @param f le fichier
     * @param grille grille à parcourir
     * @throws IOException exception en cas de problème
     */
    public static void parse(final File f, final Grille grille)
            throws IOException {
        try (InputStream in = new FileInputStream(f)) {
          parse(in, grille);
        }
    }
    /**
     * usage: GrilleParserParLigne dimension fichier.
     * <p>
     * exemple: GrilleParserParLigne 16 ma_grille_16x16.txt
     * @param args argument du main
     */
    public static void main(final String[] args) {
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        int dim = Integer.parseInt(args[0]);
        System.out.println("Dimension " + dim);
        GrilleImpl grille = new GrilleImpl(dim);
        try {
            GrilleParserParLigne.parse(new File(args[1]), grille);
            System.out.println(grille.getDimension());
            for (int i = 0; i < dim; i++) {
                for (int j = 0; j < dim; j++) {
                    System.out.print(grille.getValue(i, j) + " ");
                }
                System.out.println();
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
        Solver solver = new Solver(grille);
        solver.solve();
        solver.affiche();
        grille.affiche();
    }
}
