package challenge;
import static challenge.importCSV.importPlanilha;
import static java.util.stream.Collectors.toList;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {	
	
			
		List<Jogador> listaJogadores = new ArrayList<>();
	
		// Quantas nacionalidades (coluna `nationality`) diferentes existem no arquivo?
		public int q1() throws IOException{
			
			listaJogadores = importPlanilha();
			System.out.println(listaJogadores.toString());
			return (int)listaJogadores.stream().map(Jogador::getNationality).distinct().count();			 
		}
	
		// Quantos clubes (coluna `club`) diferentes existem no arquivo?
		// Obs: Existem jogadores sem clube.
		public int q2() throws IOException{
			listaJogadores = importPlanilha();
			return (int)listaJogadores.stream().filter(Jogador -> !Jogador.getClub().isEmpty()).map(Jogador::getClub).distinct().count();
		}
	
		// Liste o nome completo (coluna `full_name`) dos 20 primeiros jogadores.
		public List<String> q3() throws IOException{
			listaJogadores = importPlanilha();
			return listaJogadores.stream().map(Jogador::getFull_name).limit(20).collect(toList());
					
		}
	
		// Quem são os top 10 jogadores que possuem as maiores cláusulas de rescisão?
		// (utilize as colunas `full_name` e `eur_release_clause`)
		public List<String> q4() throws IOException{
			listaJogadores = importPlanilha();
			return listaJogadores.stream().filter(Jogador -> !Jogador.getEur_release_clause().isEmpty())
					.sorted(Comparator.comparingDouble((Jogador j) -> Double.parseDouble(j.getEur_release_clause())).reversed())
					.map(Jogador::getFull_name).limit(10).collect(toList());
		}
	
		// Quem são os 10 jogadores mais velhos (use como critério de desempate o campo `eur_wage`)?
		// (utilize as colunas `full_name` e `birth_date`)
		public List<String> q5() throws IOException{
			listaJogadores = importPlanilha();
			return listaJogadores.stream().sorted(Comparator.comparing(Jogador::getBirth_date).thenComparing(Jogador::getEur_wage))
					.map(Jogador::getFull_name).limit(10).collect(toList());
		}
	
		// Conte quantos jogadores existem por idade. Para isso, construa um mapa onde as chaves são as idades e os valores a contagem.
		// (utilize a coluna `age`)
		public Map<Integer, Integer> q6() throws IOException{
			listaJogadores = importPlanilha();
			Map<Integer, Integer> listaIdade = new HashMap<>();
			for(Jogador jogador: listaJogadores) {
				Integer idade = Integer.parseInt(jogador.getAge());
				if(!listaIdade.containsKey(idade)) 	
					listaIdade.put(idade, 0);
				
				Integer quantidade = listaIdade.get(idade);
				listaIdade.put(idade, quantidade+1);
			}
		
			
			return listaIdade;
		}
	

}
