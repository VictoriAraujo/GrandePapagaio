package BigParrot;
import java.util.Scanner;
public class Main {

    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        Papagaio papagaio = new Papagaio();

        boolean sair = false;
        String prompt =
                "------------------------------\n" +
                        "        Z É  C A R I O C A         \n" +
                        "------------------------------\n" +
                        "COMANDOS:\n" +
                        "- Postar: <nomedousuario> -> <post>\n" +
                        "- Ler: mural <nomedousuario>\n" +
                        "- Seguir: <nomedousuario> segue <outrousuario>\n" +
                        "*Novos usuarios sao criados ao postar e ao seguir\n";
        System.out.println(prompt);
        while (!sair) {
            String input = scan.nextLine();
            String[] inputDividido = input.split(" ");

            if (inputDividido.length == 2) {
                if (inputDividido[0].equals("mural")) {
                    String nomeUsuario = inputDividido[1];
                    papagaio.verMural(nomeUsuario);
                }

            } else if (inputDividido.length >= 3) {
                if (inputDividido[1].equals("segue")) {
                    String nomeSeguidor = inputDividido[0];
                    String nomeSeguindo = inputDividido[2];
                    papagaio.seguir(nomeSeguidor, nomeSeguindo);

                } else if (inputDividido[1].equals("->")) {
                    String usuario = inputDividido[0];
                    String mensagem = " ";
                    for (int i = 2; i < inputDividido.length; i++) {
                        String espaço = " ";
                        String parteMensagem = inputDividido[i] + espaço;
                        mensagem = mensagem + parteMensagem;
                    }
                    papagaio.postar(usuario, mensagem);
                }

            } else {
                if (input.equals("sair")) {
                    sair = true;
                }

            }
        }
    }
}
