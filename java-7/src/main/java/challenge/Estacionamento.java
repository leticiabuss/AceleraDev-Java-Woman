package challenge;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class Estacionamento {
	
	private final Integer NUMERO_DE_VAGAS = 10;
	private final Integer IDADE_MINIMA_MOTORISTA = 18;
	private final Integer PONTUAÇÃO_MAXIMA_DA_CARTEIRA = 20;
	private final Integer IDADE_EXCESSAO_IDOSOS = 55;
	
	List<Carro> listaVagas = new ArrayList<>(NUMERO_DE_VAGAS);
	
	public void verifyRequiredItems(Carro carro) {
    	   	 		
    	 	//Validações do motorista
    		if(carro.getMotorista() == null) 
    			throw new EstacionamentoException("O carro não pode ser autônomo, informe um motorista!"); 
    				
    		if(carro.getMotorista().getIdade() < IDADE_MINIMA_MOTORISTA) 
    			throw new EstacionamentoException("A idade do motorista deve ser superior a 18 anos"); 
    		
    		if(carro.getMotorista().getPontos() > PONTUAÇÃO_MAXIMA_DA_CARTEIRA)
    			throw new EstacionamentoException("A pontuação da carteira não deve ser superior a 20 pontos"); 
    		
    		if(carro.getMotorista().getHabilitacao()== null)
    			throw new EstacionamentoException("O motorista precisa ter habilitação, informe a habilitação");
	}
	
    public void estacionar(Carro carro) {
    	verifyRequiredItems(carro);
        Boolean estacionou = false;
        if(listaVagas.size() < NUMERO_DE_VAGAS) {
        	listaVagas.add(carro);
        	estacionou = true;
        }else if(listaVagas.size() >= NUMERO_DE_VAGAS) {
        	for(Carro carros : listaVagas) {
        		if(carros.getMotorista().getIdade() < IDADE_EXCESSAO_IDOSOS) {
        			listaVagas.remove(carros);
        			listaVagas.add(carro);
                    estacionou = true;
                    break;
        		}
  		   	}
        	if(estacionou != true) {
        		throw new EstacionamentoException("Não há vagas");
        	}
        }
    }
    public int carrosEstacionados() {
    	return listaVagas.size();
    }

    public boolean carroEstacionado(Carro carro) {
        return listaVagas.contains(carro);
    }
}
