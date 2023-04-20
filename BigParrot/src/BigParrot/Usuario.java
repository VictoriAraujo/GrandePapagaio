package BigParrot;
import java.util.ArrayList;

public class Usuario {
    ArrayList<Post> postagens = new ArrayList<>();
    private ArrayList<Usuario> seguindo = new ArrayList<>();
    String nome;

    public Usuario(String nome){
        super();
        this.nome = nome;
    }
    public String getNome() {
        return nome;
    }

    public ArrayList<Usuario> getSeguidores(){
        return seguindo;
    }
    public void lerPostagens(){
        for(Post postagens : postagens){
            System.out.println(postagens);
        }
    }
    public void adicionarSeguidor(Usuario seguidor) {
        seguindo.add(seguidor);
        for(Post post : postagens) {
            seguidor.adicionarPost(post);
        }
    }
    public void adicionarPost(Post post) {
        this.postagens.add(post);
        System.out.println("Post adicionado com sucesso ao mural de " + nome );
    }
    public void lerMural(){

        lerPostagens();
    }
    public void verSeguidores(){
        for(Usuario user : seguindo){
            System.out.println("Seguindo"+ user.getNome());
        }
    }
    @Override
    public String toString() {
        return "Usuario [postagens=" + postagens + ", seguindo=" + seguindo + ", nome=" + nome + "]";
    }


}
