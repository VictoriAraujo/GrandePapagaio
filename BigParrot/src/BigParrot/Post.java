package BigParrot;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Post {

    private String nomeUsuario;
    private String texto;
    private LocalDateTime data;

    public Post (String nomeUsuario, String texto){
        super();
        this.nomeUsuario = nomeUsuario;
        this.texto = texto;
        this.data = LocalDateTime.now();
    }
    public String getTexto(){
        return texto;
    }


    public void setTexto(String texto){
        this.texto = texto;
    }
    public String getNomeUsuario() {

        return nomeUsuario;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return getNomeUsuario()+ " --> " + texto + " (" + data.format(formatter)+")";
    }
}
