import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Labirinto {
    private char[][] matrizLabirinto;

    public void criaLabirinto(String fileName) {
        try (BufferedReader in = new BufferedReader(new FileReader(fileName))) {
            String linha;
            int linhas = 0;
            int colunas = 0;

            while ((linha = in.readLine()) != null) {
                if (linha.length() > colunas) {
                    colunas = linha.length();
                }
                linhas++;
            }

            matrizLabirinto = new char[linhas][colunas];

            BufferedReader inTwo = new BufferedReader(new FileReader(fileName));

            int i = 0;
            while ((linha = inTwo.readLine()) != null) {
                for (int j = 0; j < linha.length(); j++) {
                    matrizLabirinto[i][j] = linha.charAt(j);
                }
                i++;
            }

            inTwo.close();
        } catch (FileNotFoundException e) {
            // TODO: handle exception
            System.out.println("arquivo " + fileName + " não existe");
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }

    public boolean percorreLabirinto() {
        try {
           if (matrizLabirinto == null) {
                throw new IllegalStateException("Labirinto não foi carregado.");
            }

            if (matrizLabirinto[0][0] == 'x') {
                throw new IllegalArgumentException("A posição inicial [0][0] é uma parede.");
            }
            boolean result =percorreLabirinto(0, 0);
            return result;

        } catch (IllegalStateException | IllegalArgumentException e) {
            System.out.println("ERRO: "+e.getMessage());
        } catch(Exception e){
            System.out.println("ERRO:"+e.getMessage());
        }
        return false;
    }

    private boolean percorreLabirinto(int linha, int coluna) {
        // Fora dos limites
        if (linha < 0 || coluna < 0 || linha >= matrizLabirinto.length || coluna >= matrizLabirinto[0].length) {
            return false;
        }

        char atual = matrizLabirinto[linha][coluna];

        // Posição inválida
        if (atual == 'x' || atual == '.') {
            return false;
        }

        // Encontrou o destino
        if (atual == 'D' || atual == 'd') {
            return true;
        }

        // Marca como visitado
        matrizLabirinto[linha][coluna] = '.';

        // Tenta mover para os 4 lados
        return percorreLabirinto(linha - 1, coluna) || // cima
                percorreLabirinto(linha + 1, coluna) || // baixo
                percorreLabirinto(linha, coluna - 1) || // esquerda
                percorreLabirinto(linha, coluna + 1); // direita
    }

    public void imprimirLabirinto() {
        if (matrizLabirinto == null) {
            System.out.println("Labirinto não foi carregado.");
            return;
        }

        for (char[] linha : matrizLabirinto) {
            for (char c : linha) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

}
