package challenge;

public class CriptografiaCesariana implements Criptografia {

	@Override
	public String criptografar(String texto) {
		validaTexto(texto);
    	
    	return criptografarOuDescriptografarTexto(texto, true);
		
	}

	@Override
	public String descriptografar(String texto) {
		validaTexto(texto);
    	
    	return criptografarOuDescriptografarTexto(texto, false);
	}
	
	private void validaTexto(String texto) {
    	if (texto == null) {
    		throw new NullPointerException();
    	}
    	
    	if (texto.isEmpty()) {
    		throw new IllegalArgumentException();
    	}
    }
    
    private String criptografarOuDescriptografarTexto(String texto, boolean criptografar) {
    	
    	StringBuilder novoTexto = new StringBuilder();
    	String textoMinusculo = texto.toLowerCase();
    	Integer tamTexto = texto.length();
    	
    	int parametroCriptografia = 3;
    	if (!criptografar) {
    		parametroCriptografia = parametroCriptografia * (-1);
    	}
    	
    	for(int i = 0; i < tamTexto; i++) {
    		int tamanhoCifra = textoMinusculo.charAt(i) + parametroCriptografia;
    		
    		if (tamanhoCifra <= 122) {
    			if(textoMinusculo.charAt(i) < 97 || textoMinusculo.charAt(i) > 122) {
    				novoTexto.append(textoMinusculo.charAt(i));
    			}else {
    				novoTexto.append((char) tamanhoCifra);
    			}
    		}else {
    			int novaChave = tamanhoCifra - 122;
    			int textoTabelaASCII = 97 + novaChave;
    			if(textoMinusculo.charAt(i) < 97 || textoMinusculo.charAt(i) > 122) {
    				novoTexto.append(textoMinusculo.charAt(i));
    			}else {
    				novoTexto.append((char) tamanhoCifra);
    			}
    		}
    	}
    	
    	
    	return novoTexto.toString();
    }
	
}
