import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class NewClient implements Runnable  {
	
	Socket client = null;
	public NewClient(Socket client) {
		this.client = client;
	}

	@Override
	public void run() {
		
		System.out.println("Nova conexão com o cliente: " + 
	client.getInetAddress().getHostAddress());		
		try {
			Scanner entrada = new Scanner(client.getInputStream());
			PrintStream recebido = new PrintStream("DataCli.txt");
			
			while (entrada.hasNextLine()){
				
				recebido.println(entrada.nextLine());
			}
			
			entrada.close();
			recebido.close();
		} catch (IOException e) {
			System.out.println("Falha ao enviar os dados" + e);
		}	
	}
}