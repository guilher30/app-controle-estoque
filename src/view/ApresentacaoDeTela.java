package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controller.ProdutoController;
import model.beans.Categoria;
import model.beans.Produto;

public class ApresentacaoDeTela {

	public Integer telaFindById() {
		Integer id = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do produto que deseja buscar"));
		return id;
	}

	public void mostrarMsg(String msg) {
		JOptionPane.showMessageDialog(null, msg);

	}

	public int menuErro() {

		int opcao = 0;

		opcao = JOptionPane.showOptionDialog(null, "Escolha uma opção:", "Menu", JOptionPane.DEFAULT_OPTION,
				JOptionPane.PLAIN_MESSAGE, null, new Object[] { "Tentar novamente", "Voltar ao menu" }, "default");

		return opcao;
	}

	public int telaFindByCategoria() {
		int opcao = 0;

		while (opcao != 3) {

			String[] opcoes = { "Alimento", "Limpeza", "Bebida", "Voltar" };

			opcao = JOptionPane.showOptionDialog(null, "Escolha uma opção:", "Menu Busca Por Categoria",
					JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);

			switch (opcao) {
			case 0:
				return opcao;
			case 1:
				return opcao;
			case 2:
				return opcao;
			case 3:
				return opcao;
			}
		}
		return opcao;
	}

	public void exibirMensagem(List<Produto> list) {
		for (Produto obj : list) {

			System.out.println(obj);
		}

	}

//	public int menuPrincipal() {
//		int opcao = 0;
//
//		while (opcao <= 2) {
//
//			String[] opcoes = { "Cadastro/Exclusão de Produtos", "Atualizar Produtos", "Realizar Busca",
//					"Encerrar Programa" };
//
//			opcao = JOptionPane.showOptionDialog(null, "Escolha uma opção:", "Menu", JOptionPane.DEFAULT_OPTION,
//					JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);
//
//			switch (opcao) {
//			case 0:
//				// Código para cadastro/exclusão de produtos
//				return opcao;
//			case 1:
//				// Código para atualizar produtos
//				return opcao;
//			
//			case 2:
//				// Código para realizar busca
//				return opcao;
//			
//			case 3:
//				// Encerra o programa
//				JOptionPane.showMessageDialog(null, "Encerrando o programa...");
//				return opcao;
//			}
//		}
//		return opcao;
//
//	}

//	public void menuBuscar() {
//		int opcao = 0;
//		ProdutoController pc = new ProdutoController();
//		while (opcao <= 1) {
//
//			String[] opcoes = { "Buscar por Id", "Buscar por categoria", "Voltar ao Menu Principal" };
//
//			opcao = JOptionPane.showOptionDialog(null, "Escolha uma opção:", "Menu de Busca",
//					JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);
//
//			switch (opcao) {
//			case 0:
//				pc.valFindById();
//				break;
//			case 1:
//				pc.findByCategoria();
//				break;
//			case 2:
//				menuPrincipal();
//			}
//		}
//
//	}

	public Integer telaUpdate(String msg) {
		Integer id = Integer.parseInt(JOptionPane.showInputDialog(msg));
		return id;
	}

	public String menuUpdate() {
		int opcao = 0;
		do {
			opcao = JOptionPane.showOptionDialog(null, "Escolha uma opção:", "Menu", JOptionPane.DEFAULT_OPTION,
					JOptionPane.PLAIN_MESSAGE, null, new Object[] { "Retirar", "Adicionar" }, "default");
			switch (opcao) {
			case 0:
				return "retirar";
			case 1:
				return "adicionar";
			default:
				break;
			}
		} while (opcao != JOptionPane.CLOSED_OPTION);
		return null;
	}

	public void menu() {
		JFrame frame = new JFrame("Menu");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 200);

		JPanel panel = new JPanel();
		frame.add(panel);

		JButton cadastrarButton = new JButton("Cadastrar");
		panel.add(cadastrarButton);

		JButton excluirButton = new JButton("Excluir");
		panel.add(excluirButton);

		JButton pesquisarButton = new JButton("Pesquisar");
		panel.add(pesquisarButton);

		JButton atualizarButton = new JButton("Atualizar");
		panel.add(atualizarButton);

		frame.setVisible(true);

		cadastrarButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();

				JFrame cadastrarFrame = new JFrame("Cadastrar Produto");
				cadastrarFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				cadastrarFrame.setSize(1300, 300);

				JPanel cadastrarPanel = new JPanel();
				cadastrarFrame.add(cadastrarPanel);

				JLabel nomeLabel = new JLabel("Nome:");
				JTextField nomeField = new JTextField(10);
				cadastrarPanel.add(nomeLabel);
				cadastrarPanel.add(nomeField);

				JLabel quantidadeAtualLabel = new JLabel("Quantidade Atual:");
				JTextField quantidadeAtualField = new JTextField(10);
				cadastrarPanel.add(quantidadeAtualLabel);
				cadastrarPanel.add(quantidadeAtualField);

				JLabel quantidadeMinimaLabel = new JLabel("Quantidade Mínima:");
				JTextField quantidadeMinimaField = new JTextField(10);
				cadastrarPanel.add(quantidadeMinimaLabel);
				cadastrarPanel.add(quantidadeMinimaField);

				JLabel quantidadeMaximaLabel = new JLabel("Quantidade Máxima:");
				JTextField quantidadeMaximaField = new JTextField(10);
				cadastrarPanel.add(quantidadeMaximaLabel);
				cadastrarPanel.add(quantidadeMaximaField);

				JLabel categoriaLabel = new JLabel("Categoria:");
				String[] categorias = { "Alimento", "Limpeza", "Bebida" };
				JComboBox<String> categoriaComboBox = new JComboBox<>(categorias);
				cadastrarPanel.add(categoriaLabel);
				cadastrarPanel.add(categoriaComboBox);

				JButton cadastrarButton = new JButton("Cadastrar");
				cadastrarPanel.add(cadastrarButton);

				JButton voltarButton = new JButton("Voltar");
				cadastrarPanel.add(voltarButton);

				voltarButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						cadastrarFrame.dispose();
						frame.setVisible(true);
					}
				});

				cadastrarButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						String nome = nomeField.getText();
						int quantidadeAtual = Integer.parseInt(quantidadeAtualField.getText());
						int quantidadeMinima = Integer.parseInt(quantidadeMinimaField.getText());
						int quantidadeMaxima = Integer.parseInt(quantidadeMaximaField.getText());
						String categoria = (String) categoriaComboBox.getSelectedItem();
						Categoria cat = null;
						
						if(categoria.equalsIgnoreCase("Alimento"))
						cat = new Categoria(1, categoria);
						else if(categoria.equalsIgnoreCase("Limpeza")){
							cat = new Categoria(2, categoria);
						}
						else if(categoria.equalsIgnoreCase("Bebida")) {
							cat = new Categoria(3, categoria);
						}
						Produto prod = new Produto(null, nome, quantidadeAtual,  quantidadeMinima, quantidadeMaxima, new Date(), cat);
						ProdutoController pc = new ProdutoController();
						pc.insert(prod);

						cadastrarFrame.dispose();
						frame.setVisible(true);
					}
				});

				cadastrarFrame.setVisible(true);
			}
		});

		excluirButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();

				JFrame excluirFrame = new JFrame("Excluir Produto");
				excluirFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				excluirFrame.setSize(300, 200);

				JPanel excluirPanel = new JPanel();
				excluirFrame.add(excluirPanel);

				JLabel idLabel = new JLabel("ID:");
				JTextField idField = new JTextField(10);
				excluirPanel.add(idLabel);
				excluirPanel.add(idField);

				JButton excluirButton = new JButton("Excluir");
				excluirPanel.add(excluirButton);

				JButton voltarButton = new JButton("Voltar");
				excluirPanel.add(voltarButton);

				voltarButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						excluirFrame.dispose();
						frame.setVisible(true);
					}
				});

				excluirButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						int id = Integer.parseInt(idField.getText());
						ProdutoController pc = new ProdutoController();
						pc.deleteById(id);
						
						excluirFrame.dispose();
						frame.setVisible(true);
					}
				});

				excluirFrame.setVisible(true);
			}
		});

		pesquisarButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();

				JFrame pesquisarFrame = new JFrame("Pesquisar Produto");
				pesquisarFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				pesquisarFrame.setSize(300, 150);

				JPanel pesquisarPanel = new JPanel();
				pesquisarFrame.add(pesquisarPanel);

				JButton buscarPorIdButton = new JButton("Buscar por ID");
				pesquisarPanel.add(buscarPorIdButton);

				JButton buscarPorCategoriaButton = new JButton("Buscar por Categoria");
				pesquisarPanel.add(buscarPorCategoriaButton);

				JButton buscarTodosButton = new JButton("Buscar Todos");
				pesquisarPanel.add(buscarTodosButton);

				JButton voltarButton = new JButton("Voltar");
				pesquisarPanel.add(voltarButton);

				voltarButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						pesquisarFrame.dispose();
						frame.setVisible(true);
					}
				});

				buscarPorIdButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						pesquisarFrame.dispose();

						JFrame buscarPorIdFrame = new JFrame("Buscar por ID");
						buscarPorIdFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						buscarPorIdFrame.setSize(300, 100);

						JPanel buscarPorIdPanel = new JPanel();
						buscarPorIdFrame.add(buscarPorIdPanel);

						JLabel idLabel = new JLabel("ID:");
						JTextField idField = new JTextField(10);
						buscarPorIdPanel.add(idLabel);
						buscarPorIdPanel.add(idField);

						JButton pesquisarButton = new JButton("Pesquisar");
						buscarPorIdPanel.add(pesquisarButton);

						JButton voltarButton = new JButton("Voltar");
						buscarPorIdPanel.add(voltarButton);

						voltarButton.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								buscarPorIdFrame.dispose();
								pesquisarFrame.setVisible(true);
							}
						});

						pesquisarButton.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								int id = Integer.parseInt(idField.getText());

								ProdutoController pc = new ProdutoController();
								pc.findById(id);
								buscarPorIdFrame.dispose();
								pesquisarFrame.setVisible(true);
							}
						});

						buscarPorIdFrame.setVisible(true);
					}
				});

				buscarPorCategoriaButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						pesquisarFrame.dispose();

						JFrame buscarPorCategoriaFrame = new JFrame("Buscar por Categoria");
						buscarPorCategoriaFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						buscarPorCategoriaFrame.setSize(300, 150);

						JPanel buscarPorCategoriaPanel = new JPanel();
						buscarPorCategoriaFrame.add(buscarPorCategoriaPanel);

						JLabel categoriaLabel = new JLabel("Categoria:");
						String[] categorias = { "Alimento", "Limpeza", "Bebida" };
						JComboBox<String> categoriaComboBox = new JComboBox<>(categorias);
						buscarPorCategoriaPanel.add(categoriaLabel);
						buscarPorCategoriaPanel.add(categoriaComboBox);

						JButton pesquisarButton = new JButton("Pesquisar");
						buscarPorCategoriaPanel.add(pesquisarButton);

						JButton voltarButton = new JButton("Voltar");
						buscarPorCategoriaPanel.add(voltarButton);

						voltarButton.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								buscarPorCategoriaFrame.dispose();
								pesquisarFrame.setVisible(true);
							}
						});

						pesquisarButton.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								String categoria = (String) categoriaComboBox.getSelectedItem();
								Categoria cat = new Categoria(null, categoria);

								ProdutoController pc = new ProdutoController();
								pc.findByCategoria(cat);
								pc.findByCategoria(null);
								buscarPorCategoriaFrame.dispose();
								pesquisarFrame.setVisible(true);
							}
						});

						buscarPorCategoriaFrame.setVisible(true);
					}
				});

				buscarTodosButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						pesquisarFrame.dispose();

						JFrame buscarTodosFrame = new JFrame("Buscar Todos");
						buscarTodosFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						buscarTodosFrame.setSize(1000, 1000);

						JPanel buscarTodosPanel = new JPanel();
						buscarTodosFrame.add(buscarTodosPanel);

						JTextArea resultadoArea = new JTextArea(40, 60);
						JScrollPane scrollPane = new JScrollPane(resultadoArea);
						buscarTodosPanel.add(scrollPane);

						JButton pesquisarButton = new JButton("Pesquisar");
						buscarTodosPanel.add(pesquisarButton);

						JButton voltarButton = new JButton("Voltar");
						buscarTodosPanel.add(voltarButton);

						voltarButton.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								buscarTodosFrame.dispose();
								pesquisarFrame.setVisible(true);
							}
						});

						pesquisarButton.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								ProdutoController pc = new ProdutoController();
								String resultado = pc.findAll();

								resultadoArea.setText(resultado);
							}
						});

						buscarTodosFrame.setVisible(true);
					}
				});

				pesquisarFrame.setVisible(true);
			}
		});

		atualizarButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();

				JFrame atualizarFrame = new JFrame("Atualizar Produto");
				atualizarFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				atualizarFrame.setSize(550, 300);

				JPanel atualizarPanel = new JPanel();
				atualizarFrame.add(atualizarPanel);

				JLabel idLabel = new JLabel("ID:");
				JTextField idField = new JTextField(10);
				atualizarPanel.add(idLabel);
				atualizarPanel.add(idField);

				JLabel quantidadeLabel = new JLabel("Quantidade:");
				JTextField quantidadeField = new JTextField(10);
				atualizarPanel.add(quantidadeLabel);
				atualizarPanel.add(quantidadeField);

				JLabel operacaoLabel = new JLabel("Operação:");
				String[] operacoes = { "Adicionar", "Remover" };
				JComboBox<String> operacaoComboBox = new JComboBox<>(operacoes);
				atualizarPanel.add(operacaoLabel);
				atualizarPanel.add(operacaoComboBox);

				JButton atualizarButton = new JButton("Atualizar");
				atualizarPanel.add(atualizarButton);

				JButton voltarButton = new JButton("Voltar");
				atualizarPanel.add(voltarButton);

				voltarButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						atualizarFrame.dispose();
						frame.setVisible(true);
					}
				});

				atualizarButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						int id = Integer.parseInt(idField.getText());
						int quantidade = Integer.parseInt(quantidadeField.getText());
						String operacao = (String) operacaoComboBox.getSelectedItem();
						
						ProdutoController pc = new ProdutoController();
						pc.update(id, quantidade, operacao);

						atualizarFrame.dispose();
						frame.setVisible(true);
					}
				});

				atualizarFrame.setVisible(true);
			}
		});
	}

// Função para buscar todos os produtos
	public static String buscarTodos() {
		// Simulação da busca de todos os produtos
		String resultado = "Produto 1\nProduto 2\nProduto 3";
		return resultado;
	}

}
