public class App {
    public static void main(String[] args) throws Exception {
        Labirinto lab = new Labirinto();
        lab.criaLabirinto("labirinto.txt");
        lab.imprimirLabirinto();
        if (lab.percorreLabirinto()) {
            System.out.println("true");
        }else{
            System.out.println("false");
        }
        lab.imprimirLabirinto();
        
    }
}
