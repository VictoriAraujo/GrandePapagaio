package BigParrot;

import java.util.ArrayList;

public class Papagaio {
    ArrayList<Usuario> userList = new ArrayList<>();

    public Usuario getUsuario(String nome) throws UsuarioInexistenteException {

        for (Usuario user : userList) {
            if (user.nome.equals(nome.strip())) {
                return user;
            }
        }

        throw new UsuarioInexistenteException("O usuário não existe");
    }


    public void listarUsuarios() {
        for (Usuario user : userList) {
            System.out.println("->" + user.getNome());
        }
    }

    public void postar(String nomeUsuario, String texto) {
        Post post = new Post(nomeUsuario, texto);
        if (!existeUsuario(nomeUsuario)) {
            Usuario user = new Usuario(nomeUsuario);
            user.adicionarPost(post);
            this.userList.add(user);
        } else {
            for (Usuario u : userList) {
                if (u.getNome().equals(nomeUsuario)) {
                    u.adicionarPost(post);
                }
            }
        }

    }

    public boolean existeUsuario(String nomeUsuario) {
        for (Usuario u : userList)
            if (u.getNome().equals(nomeUsuario))
                return true;
        return false;
    }

    public void verMural(String nome) {
        try {
            Usuario usuario = getUsuario(nome);
            usuario.lerMural();
        } catch (UsuarioInexistenteException e) {
            System.out.println("Usuário " + nome + " não foi encontrado");
        }
    }

    public void seguir(String seguidor, String seguido) {
        if (!existeUsuario(seguidor)) {
            Usuario user = new Usuario(seguidor);
            this.userList.add(user);
        }

        if (existeUsuario(seguido)) {
            for (Usuario u : userList) {
                if (u.getNome().equals(seguido)) {
                    for (Usuario v : userList) {
                        if (v.getNome().equals(seguidor)) {
                            u.adicionarSeguidor(v);
                        }
                    }
                }
            }
        }
    }
}