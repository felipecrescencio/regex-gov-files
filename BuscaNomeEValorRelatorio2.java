import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;
import java.util.regex.Pattern;

public class BuscaNomeEValorRelatorio2 {
    private static Stack<File> dirs = new Stack<File>();

    public static void main(String[] s) throws IOException {
//        if(s.length <= 0){
//            System.out.println("===========================================================");
//            System.out.println("= E necessario passar o nome do arquivo a ser processado.");
//            System.out.println("= Exemplo de execucao:");
//            System.out.println("= c:\\> java BuscaNomeEValorRelatorio nome_do_arquivo.txt");
//            System.out.println("= c:\\> java BuscaNomeEValorRelatorio nome_do_arquivo.txt > nome_do_arquivo_saida.txt");
//            System.out.println("===========================================================");
//
//            return;
//        }

        String path = "C:\\tmp";

        File a = new File(path);
        dirs.push(a);

        while(!dirs.empty()){
            File f = dirs.pop();
            lookupFiles(f);
        }
    }

    public static void lookupFiles(File srcDir) throws IOException {
        File[] files = srcDir.listFiles();

        for(int i=0; i < files.length; i++) {
            String fileName = files[i].getName();
            File f = new File(srcDir, fileName);
            if (files[i].isDirectory()) {
                dirs.push(f);
            } else {
                BufferedReader reader;
                try {
                    reader = new BufferedReader(new FileReader(f));
                    String line = reader.readLine();
                    while (line != null) {
//                        if(Pattern.matches("#Include", line)){
                        if(line.toLowerCase().indexOf("#include") >= 0){
//                            System.out.println("########");
//                            System.out.println(f.getCanonicalPath());
//                            System.out.println("--------");
                            System.out.println(line.toLowerCase());
//                            System.out.println("########");
/*
                            String s2ndLine = reader.readLine();
                            String[] valS2line = s2ndLine.split(" ");
                            System.out.printf("%s\t%s\n", line.substring(0, line.length() - 6), valS2line[1]);
 */
                        }

                        // read next line
                        line = reader.readLine();
                    }
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
