package br.com.codenation;

import static java.util.stream.Collectors.toList;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import br.com.codenation.desafio.annotation.Desafio;
import br.com.codenation.desafio.app.MeuTimeInterface;
import br.com.codenation.desafio.exceptions.CapitaoNaoInformadoException;
import br.com.codenation.desafio.exceptions.IdentificadorUtilizadoException;
import br.com.codenation.desafio.exceptions.JogadorNaoEncontradoException;
import br.com.codenation.desafio.exceptions.TimeNaoEncontradoException;

public class DesafioMeuTimeApplication implements MeuTimeInterface {
	
	private Map<Long, Time> timesCadastrados = new HashMap<>();
	private Map<Long, Jogador> jogadoresCadastrados = new HashMap<>();
	
	@Desafio("incluirTime")
	public void incluirTime(Long id, String nome, LocalDate dataCriacao, String corUniformePrincipal, String corUniformeSecundario) throws IdentificadorUtilizadoException{
		if(timesCadastrados.containsKey(id))
			throw new IdentificadorUtilizadoException();
		
		timesCadastrados.put(id, new Time(id, nome, dataCriacao, corUniformePrincipal, corUniformeSecundario));
	}

	@Desafio("incluirJogador")
	public void incluirJogador(Long id, Long idTime, String nome, LocalDate dataNascimento, Integer nivelHabilidade, BigDecimal salario) throws TimeNaoEncontradoException,IdentificadorUtilizadoException{
		if(!timesCadastrados.containsKey(idTime))
			throw new TimeNaoEncontradoException();
		if(jogadoresCadastrados.containsKey(id))
			throw new IdentificadorUtilizadoException();
		
		jogadoresCadastrados.put(id, new Jogador(id, idTime, nome, dataNascimento, nivelHabilidade, salario));
		
	}

	@Desafio("definirCapitao")
	public void definirCapitao(Long idJogador) throws JogadorNaoEncontradoException{
		if(!jogadoresCadastrados.containsKey(idJogador))
			throw new JogadorNaoEncontradoException();
		
		Jogador jogador = jogadoresCadastrados.get(idJogador);
		
		if (!timesCadastrados.containsKey(jogador.getIdTime()))
			throw new TimeNaoEncontradoException();
		timesCadastrados.get(jogador.getIdTime()).setCapitao(jogador);
	}

	@Desafio("buscarCapitaoDoTime")
	public Long buscarCapitaoDoTime(Long idTime) throws CapitaoNaoInformadoException,TimeNaoEncontradoException{
		Time time = timesCadastrados.get(idTime);
		if(!timesCadastrados.containsKey(idTime))
			throw new TimeNaoEncontradoException();
		if(time.getCapitao() == null)
			throw new CapitaoNaoInformadoException();
		return timesCadastrados.get(idTime).getCapitao().getId();
	}

	@Desafio("buscarNomeJogador")
	public String buscarNomeJogador(Long idJogador) throws JogadorNaoEncontradoException {
		if(!jogadoresCadastrados.containsKey(idJogador))
			throw new JogadorNaoEncontradoException();
		
		return jogadoresCadastrados.get(idJogador).getNome();
	}

	@Desafio("buscarNomeTime")
	public String buscarNomeTime(Long idTime) throws TimeNaoEncontradoException{
		if(!timesCadastrados.containsKey(idTime))
			throw new TimeNaoEncontradoException();
		
		return timesCadastrados.get(idTime).getNome();
	}

	@Desafio("buscarJogadoresDoTime")
	public List<Long> buscarJogadoresDoTime(Long idTime) {
		if(!timesCadastrados.containsKey(idTime))
			throw new TimeNaoEncontradoException();
		
		return jogadoresCadastrados.entrySet().stream().map((Map.Entry<Long, Jogador> entradaJogador) -> entradaJogador.getValue())
				.filter((Jogador -> Jogador.getIdTime().equals(idTime)))
					.map(Jogador::getId).sorted()
					.collect(toList());
	}

	@Desafio("buscarMelhorJogadorDoTime")
	public Long buscarMelhorJogadorDoTime(Long idTime) {
		if(!timesCadastrados.containsKey(idTime))
			throw new TimeNaoEncontradoException();
	
	return jogadoresCadastrados.entrySet().stream().map((Map.Entry<Long, Jogador> entradaJogador) -> entradaJogador.getValue())
			.filter((Jogador -> Jogador.getIdTime().equals(idTime))).sorted(Comparator.comparing(Jogador::getNivelHabilidade).reversed())
			.map(Jogador::getId).findFirst().orElse(null);
	}

	@Desafio("buscarJogadorMaisVelho")
	public Long buscarJogadorMaisVelho(Long idTime) {
		if(!timesCadastrados.containsKey(idTime))
			throw new TimeNaoEncontradoException();
	
		return jogadoresCadastrados.entrySet().stream().map((Map.Entry<Long, Jogador> entradaJogador) -> entradaJogador.getValue())
				.filter((Jogador -> Jogador.getIdTime().equals(idTime)))
				.sorted(Comparator.comparing(Jogador::getDataNascimento)
				.thenComparing(Jogador::getId)).map(Jogador::getId).findFirst().orElse(null);
	}
	
	@Desafio("buscarTimes")
	public List<Long> buscarTimes() {
		
		return timesCadastrados.entrySet().stream().map((Map.Entry<Long, Time> times) -> times.getValue())
				.map(Time::getId).sorted().collect(Collectors.toList());
	}

	@Desafio("buscarJogadorMaiorSalario")
	public Long buscarJogadorMaiorSalario(Long idTime) {
		if(!timesCadastrados.containsKey(idTime))
			throw new TimeNaoEncontradoException();
	
		return jogadoresCadastrados.entrySet().stream().map((Map.Entry<Long, Jogador> entradaJogador) -> entradaJogador.getValue())
				.filter((Jogador -> Jogador.getIdTime().equals(idTime)))
				.sorted(Comparator.comparing(Jogador::getSalario).reversed()
				.thenComparing(Jogador::getId)).map(Jogador::getId).findFirst().orElse(null);
	}

	@Desafio("buscarSalarioDoJogador")
	public BigDecimal buscarSalarioDoJogador(Long idJogador) {
		if(!jogadoresCadastrados.containsKey(idJogador))
			throw new JogadorNaoEncontradoException();
		
		return jogadoresCadastrados.get(idJogador).getSalario();
	}

	@Desafio("buscarTopJogadores")
	public List<Long> buscarTopJogadores(Integer top) {
		
		return jogadoresCadastrados.entrySet().stream().map((Map.Entry<Long, Jogador> entradaJogador) -> entradaJogador.getValue())
				.sorted(Comparator.comparing(Jogador::getNivelHabilidade).reversed())
				.map(Jogador::getId).limit(top).collect(Collectors.toList());
	}

	@Desafio("buscarCorCamisaTimeDeFora")
	public String buscarCorCamisaTimeDeFora(Long timeDaCasa, Long timeDeFora) {	
		if (!timesCadastrados.containsKey(timeDaCasa) || !timesCadastrados.containsKey(timeDeFora))
			throw new TimeNaoEncontradoException();
		String corCamisaTimeCasa = timesCadastrados.get(timeDaCasa).getCorUniformePrincipal();
		String corCamisaTimeFora = timesCadastrados.get(timeDeFora).getCorUniformePrincipal();
		
		if( corCamisaTimeCasa == corCamisaTimeFora) {
			corCamisaTimeFora = timesCadastrados.get(timeDeFora).getCorUniformeSecundario();
			return corCamisaTimeFora;
		}else {
			return corCamisaTimeFora;
		}
	}

}
