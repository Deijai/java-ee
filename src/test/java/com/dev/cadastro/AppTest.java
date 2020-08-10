package com.dev.cadastro;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import com.dev.dao.TelefoneDao;
import com.dev.dao.UsuarioDao;
import com.dev.model.Telefone;
import com.dev.model.Usuario;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
        
        Usuario usuario = new Usuario();
        Telefone telefone =  new Telefone();
        
        UsuarioDao usuarioDao =  new UsuarioDao();
        TelefoneDao telefoneDao =  new TelefoneDao();
        
        
        //usuario.setNome("Jefersson Dias");
        //usuario.setEmail("dias.jefersson@bol.com");
        //usuarioDao.insert(usuario);
        
        //usuarioDao.delete(6L);
        
        //Usuario u = usuarioDao.getUsuario(2L);  
        //System.out.println(u.getNome()+" "+u.getEmail()+" "+u.getTelefone().getNumero()+" "+u.getTelefone().getTipo());
        
        //inserir telefone
        //telefone.setNumero("(61) 37754878");
        //telefone.setTipo("casa");
        //telefone.setIdUsuario(3L);
        
        //telefoneDao.insert(telefone);
        
        //System.out.println(u.getNome()+" "+u.getEmail());
        
        List<Usuario> lista = usuarioDao.listarTodos();
        
        for (Usuario us : lista) {
        	System.out.println(us.getNome()+" "+us.getEmail()+" "+us.getTelefone().getNumero()+" "+us.getTelefone().getTipo());
		}

    }
}
