public class Candidato {
    private String firstName;
    private String partido;
    private int intencoesVotos;
    public Candidato(String firstName, String partido, int intencoesVotos) {
        this.firstName = firstName;
        this.partido = partido;
        this.intencoesVotos = intencoesVotos;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirsName(String firstName) {
        this.firstName = firstName;
    }
    public String getPartido() {
        return partido;
    }
    public void setPartido(String partido) {
        this.partido = partido;
    }
    public int getIntencoesVotos() {
        return intencoesVotos;
    }
    public void setIntencoesVotos(int intencoesVotos) {
        this.intencoesVotos = intencoesVotos;
    }

    @Override
    public String toString() {
        return "CANDIDATO{nome: " + getFirstName() + ", partido: " + getPartido()
                + ", intenções de voto: " + getIntencoesVotos() + "}";
    }

    
}