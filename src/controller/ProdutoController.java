package controller;
import model.beans.Produto;
import model.dao.DaoFactory;
import model.dao.ProdutoDao;
import view.ApresentacaoDeTela;

public class ProdutoController {
	
	
	 public void valFindById() {
		 ApresentacaoDeTela at = new ApresentacaoDeTela();
		 try {
		 
		 Integer id =  at.telaFindById();
		 ProdutoDao produtoDao = DaoFactory.createProdutoDao();
		 Produto produto = produtoDao.findById(id);
		 if(produto == null) {
			 at.mostrarMsg("Produto não encontrado");
		 }else {
			 at.mostrarMsg("Produto Encontrado: " + produto);
		 }
		 
		 }catch (NumberFormatException e) {
			 at.mostrarMsg("Formato Invalido. Digite Novamente");
			 if(at.menuErro() == 0) {
				 valFindById();
			 }
			 
		 }
		
		 
	 }
}
