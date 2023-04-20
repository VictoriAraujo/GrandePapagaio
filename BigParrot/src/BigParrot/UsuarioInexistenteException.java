package BigParrot;
public class UsuarioInexistenteException extends Exception {
    private String nome;

    public UsuarioInexistenteException(String msg) {
        super(msg);
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
