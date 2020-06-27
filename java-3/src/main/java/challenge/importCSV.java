package challenge;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class importCSV {

	public static List<Jogador> importPlanilha() throws IOException{
		
		List<Jogador> listaJogadores = new ArrayList<>();
		String path = "/home/leticiabuss/codenation/java-3/src/main/resources/data.csv";
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			
			String line = br.readLine();
			line = br.readLine();
			while (line != null) {
				String[] campo = line.split(",");
				Jogador jogador = new Jogador(campo[0], campo[1], campo[2], campo[3], campo[6], 
						campo[8], campo[14], campo[17], campo[18]);
				
				listaJogadores.add(jogador);
				line = br.readLine();

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return listaJogadores;
	}
}
