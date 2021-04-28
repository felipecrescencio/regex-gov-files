import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BuscaNomeEValorRelatorio {
    public static void main(String[] s){
        if(s.length <= 0){
            System.out.println("===========================================================");
            System.out.println("= E necessario passar o nome do arquivo a ser processado.");
            System.out.println("= Exemplo de execucao:");
            System.out.println("= c:\\> java BuscaNomeEValorRelatorio nome_do_arquivo.txt");
            System.out.println("= c:\\> java BuscaNomeEValorRelatorio nome_do_arquivo.txt > nome_do_arquivo_saida.txt");
            System.out.println("===========================================================");

            return;
        }

        BufferedReader reader;
        try {
            Pattern pattern = Pattern.compile("([\\w\\s]{2,})(\\d{2}\\/\\d{2}\\/\\d{4})");

            reader = new BufferedReader(new FileReader(s[0]));
            String line = reader.readLine();
            while (line != null) {
//                if(Pattern.matches("[\\w\\s]{2,} \\d{5}", line)){
//                if(Pattern.matches("[\\w\\s]{2,} \\d{2}\\\\/\\d{2}\\\\/\\d{4}", line)){
                Matcher matcher = pattern.matcher(line);
                if(matcher.find()){
                    String s2ndLine = reader.readLine();
                    String[] valS2line = s2ndLine.split("\\s");
                    if(valS2line.length < 2){
                        line = reader.readLine();
                        continue;
                    }
//                    System.out.printf("%s\t%s\t%s\n", line.substring(0, line.length() - 28), valS2line[0], valS2line[1]);
                    System.out.printf("%s\t%s\t%s\n", matcher.group(1), valS2line[0], valS2line[1]);
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
