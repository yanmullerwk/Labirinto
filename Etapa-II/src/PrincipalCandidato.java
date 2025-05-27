import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class PrincipalCandidato {
    public static void main(String[] args) {
        Random ran = new Random();

        String[] names = {"Antonio", "Roberto", "Gabriela","Leonardo", "Eunice", "Ana", "Ariel"};
        String[] parties = {"CCCP", "PP", "AL","DJA","AK"};

        Candidato[] candidatos = new Candidato[ran.nextInt(100)+1];
        System.out.println("*************************TAMANHO "+candidatos.length);
        

        for(int i=0; i<candidatos.length;i++){
            String randomName = names[ran.nextInt(names.length)];
            String randomParty = parties[ran.nextInt(parties.length)];
            int randomNumber = ran.nextInt(500);
            candidatos[i] = new Candidato(randomName, randomParty, randomNumber);
        }
        
        ordenaCandidatoPorNome(candidatos);
        ordenaCandidatosPorPartido(candidatos);
        ordenaCandidatosPorVotos(candidatos);


        for (Candidato candidato : candidatos) {
            System.out.println(candidato);
        }
    }
    public static void ordenaCandidatoPorNome(Candidato[] candidatos){
        for (int i = 1; i < candidatos.length; i++) {
            Candidato chave = candidatos[i];
            int j = i - 1;
            while (
                j >= 0 && (candidatos[j].getFirstName().compareTo(chave.getFirstName()) > 0 ||
                (candidatos[j].getFirstName().equals(chave.getFirstName())))) {
                candidatos[j + 1] = candidatos[j];
                j--;
            }
            candidatos[j + 1] = chave;
        }
    }

    public static void ordenaCandidatosPorVotos(Candidato[] candidatos) {
        for (int i = 0; i < candidatos.length - 1; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < candidatos.length; j++) {
                if (candidatos[j].getIntencoesVotos() > candidatos[maxIdx].getIntencoesVotos()) {
                    maxIdx = j;
                }
            }
            Candidato temp = candidatos[i];
            candidatos[i] = candidatos[maxIdx];
            candidatos[maxIdx] = temp;
        }
    }

    public static void ordenaCandidatosPorPartido(Candidato[] candidatos) {
        for (int i = 1; i < candidatos.length; i++) {
            Candidato chave = candidatos[i];
            int j = i - 1;
            while (j >= 0 && candidatos[j].getPartido().compareTo(chave.getPartido()) > 0) {
                candidatos[j + 1] = candidatos[j];
                j--;
            }
            candidatos[j + 1] = chave;
        }
    }
}
