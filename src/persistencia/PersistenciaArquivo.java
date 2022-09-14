package persistencia;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import bancario.tsi.Cliente;

public class PersistenciaArquivo {

	ArrayList<Cliente> clientesCadastrados = new ArrayList<>();

	public PersistenciaArquivo() {
		carregarArquivo();
	}

	public void cadastrarCliente(Cliente c) {
		if (clientesCadastrados.contains(c))
			System.err.println("Cliente já cadastrado!");
		else {
			clientesCadastrados.add(c);
			salvarArquivo();
		}

	}

	public void salvarArquivo() {
		try {
			FileOutputStream fos = new FileOutputStream("dados");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(clientesCadastrados);
			oos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void carregarArquivo() {
		try {
			FileInputStream fis = new FileInputStream("dado");
			ObjectInputStream ois = new ObjectInputStream(fis);
			clientesCadastrados = (ArrayList<Cliente>)ois.readObject();
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
