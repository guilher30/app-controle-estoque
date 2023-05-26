package controller;

import model.beans.Usuario;
import model.dao.DaoFactory;
import model.dao.UsuarioDao;
import view.ApresentacaoDeTela;

public class UsuarioController {
	public boolean login(String usuario, String senha) {
		ApresentacaoDeTela at = new ApresentacaoDeTela();
		
		UsuarioDao usuarioDao = DaoFactory.createUsuarioDao();
		Usuario u = usuarioDao.login(usuario,senha);
		if(u != null) {
			at.mostrarMsg("Bem vindo Ao sistema, " + u.getNome());
			return true;
		}else {
			at.mostrarMsg("Usuario ou senha incorretos. Tente Novamente");
			return false;
		}
		
	}
}
