import java.util.ArrayList;

import javax.swing.JOptionPane;

public class TesteUsuario {

	public static void main(String[] args) {	
		UsuarioDAO usuDAO1 = new UsuarioDAO();
		
		// Inclus�o de usu�rios
		/*
		usuDAO1.insert(new Usuario (101,"Ana","ana@gmail.com","(11) 5555-0000","Rua abc, 1542"));
		usuDAO1.insert(new Usuario (102,"Beatriz","beatriz@gmail.com","(11) 2222-0000","Rua Xpto, 1542"));
		usuDAO1.insert(new Usuario (103,"Antonio","antonio@gmail.com","(11) 4444-0000","Rua Ykm, 42"));
		usuDAO1.insert(new Usuario (104,"Carlos","carlos@gmail.com","(11) 1111-0000","Rua Arilindo, 21"));
		*/
		
		// Delete usuario, idUsuario = 104
		//usuDAO1.delete(104);
		//usuDAO1.delete(102);
		
		//usuDAO1.update(new Usuario (101,"Ana Maria","ana@gmail.com","(11) 4444-0000","Rua das Flores, 783"));
		//usuDAO1.update(new Usuario (103,"Antonio Rodrigues","antonio@gmail.com","(11) 8888-0000","Rua das Ac�cias, 42"));
		
		// Total de Usuarios
		JOptionPane.showMessageDialog(null,"Total de usu�rios: "+usuDAO1.selectCount());
		
		// Select idUsuario= 101
		JOptionPane.showMessageDialog(null,"Select idUsuario=101 - "+usuDAO1.select(101)+"\n\n");
		JOptionPane.showMessageDialog(null,"Select idUsuario=105 - "+usuDAO1.select(105)+"\n\n");
		JOptionPane.showMessageDialog(null,"Select nome Like 'ana' - "+usuDAO1.select("ana","nome")+"\n\n");
		JOptionPane.showMessageDialog(null,"Select email Like 'ant' - "+usuDAO1.select("ant","email")+"\n\n");
		
		// Lista de usu�rios
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		usuarios = usuDAO1.getUsuarios();
		for (Usuario usuario: usuarios) {
			System.out.println(usuario);
		}
		/*
		 * usuDAO1.insert(new Usuario (101,"Ana","ana@gmail.com","(11) 5555-0000","Rua abc, 1542"));
		usuDAO1.insert(new Usuario (102,"Beatriz","beatriz@gmail.com","(11) 2222-0000","Rua Xpto, 1542"));
		usuDAO1.insert(new Usuario (103,"Antonio","antonio@gmail.com","(11) 4444-0000","Rua Ykm, 42"));
		usuDAO1.insert(new Usuario (104,"Carlos","carlos@gmail.com","(11) 1111-0000","Rua Arilindo, 21"));
	
		
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		usuarios = usuDAO1.getUsuarios();
		for (Usuario usuario: usuarios) {
			System.out.println(usuario);
		}

		Usuario usu1 = new Usuario();
		usu1 = usuDAO1.select(1001);
		System.out.println(usu1);

		
		/*
		Usuario usu1 = new Usuario();
		UsuarioDAO usuDAO1 = new UsuarioDAO();

		usu1 = usuDAO1.select("b","nome");
		System.out.println(usu1);

		usu1 = usuDAO1.select("x","email");
		System.out.println(usu1);
		
		usu1 = usuDAO1.select(1001);
		System.out.println(usu1);

		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		usuarios = usuDAO1.getUsuarios();
		
		System.out.println(usuarios.toString());
		
		/*
		usu1.setIdUsuario(1001);
		usu1.setNome("Al�cio");
		usu1.setEndereco("Rua abc, 123");
		usu1.setTelefone("(11)9999-0182");
		usu1.setEmail("alecio.godoi@gmail.com");
		
		
		usuDAO1.insert(usu1);
		
		//usu1.setEndereco("Rua Jaboat�o, 12 Apto 1038");
		//usuDAO1.update(usu1);
		
		//usuDAO1.delete(usu1.getIdUsuario());
		 
		*/
	}

}
