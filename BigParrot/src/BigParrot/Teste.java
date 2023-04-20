package BigParrot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Teste{


    Post post;
    Usuario user;
    String usuario;
    Papagaio papagaio;
    @BeforeEach

    public void init(){
    usuario = "maria";
    post = new Post( usuario,"testando");
    papagaio = new Papagaio();}
    @Test

    public void testPost(){
        Assertions.assertEquals("testando", post.getTexto());
        post.setTexto("Linguagem de Programação");
        Assertions.assertEquals("Linguagem de Programação", post.getTexto());
        Assertions.assertEquals(usuario, post.getNomeUsuario());
    }
    @Test
    public void testExisteUsuario() {
        Papagaio papagainho = new Papagaio();
        String nome = "Mary";
        papagainho.userList.add(new Usuario(nome));
        assertTrue(papagainho.existeUsuario(nome));
        assertFalse(papagaio.existeUsuario("João"));
    }

    @Test
    public void testSeguir2(){
        String testeSeguido = String.valueOf(new Usuario("Quem é seguido"));
        String  testeSeguidor = String.valueOf(new Usuario("Quem segue"));
        papagaio.seguir(testeSeguidor,testeSeguido);
        Assertions.assertTrue(user.getSeguidores().contains(testeSeguidor));
    }


    @Test
    public void testToString() {
        String nomeUsuario = "Maria";
        String texto = "Testando mais uma vez!";
        Post post = new Post(nomeUsuario, texto);

        LocalDateTime dataAtual = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        String resultadoEsperado = nomeUsuario + " --> " + texto + " (" + dataAtual.format(formatter) + ")";

        Assertions.assertEquals(resultadoEsperado, post.toString());
    }


}
