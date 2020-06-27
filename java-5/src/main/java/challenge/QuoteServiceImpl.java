package challenge;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuoteServiceImpl implements QuoteService {

	@Autowired
	private QuoteRepository repository;

	@Override
	public Quote getQuote() {
		Random random = new Random();
		List<Quote> listaQuote = repository.findAll();
		return listaQuote.get(random.nextInt(listaQuote.size()));
	}

	@Override
	public Quote getQuoteByActor(String actor) {
		List<Quote> listaQuote = repository.findByActor(actor);
		return listaQuote.stream().filter(Quote -> Quote.getActor().equals(actor)).findFirst().orElse(null);
	}

}
