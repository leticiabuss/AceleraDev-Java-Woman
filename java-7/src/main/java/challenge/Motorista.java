package challenge;

import java.util.Objects;

public class Motorista {

    private final String nome;
    private final int idade;
    private final int pontos;
    private final String habilitacao;


    private Motorista(Builder builder) {

        this.nome = builder.nome;
        this.idade = builder.idade;
        this.pontos = builder.pontos;
        this.habilitacao = builder.habilitacao;
    }
    
    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public int getPontos() {
        return pontos;
    }

    public String getHabilitacao() {
        return habilitacao;
    }

    public static class Builder {

        private String nome;
        private int idade;
        private int pontos;
        private String habilitacao;

        private Builder() {}

        public Builder withNome(String nome) {
            this.nome = nome;
            return this;
        }

        public Builder withIdade(int idade) {
            this.idade = idade;
            if(this.idade < 0)
            	throw new IllegalArgumentException("Precisa informar uma idade!"); 
            return this;
        }

        public Builder withPontos(int pontos) {
            this.pontos = pontos;
            if(this.pontos < 0)
            	throw new IllegalArgumentException("Precisa informar os pontos da carteira!");  
            return this;
        }

        public Builder withHabilitacao(String habilitacao) {
            this.habilitacao = habilitacao;
            return this;
        }


        public Motorista build() {
        	 Objects.requireNonNull(this.nome, "O nome é obrigatorio.");
             Objects.requireNonNull(this.habilitacao, "A habilitação é obrigatória.");
             return new Motorista(this);
        }
        
    }
    
    public static Builder builder() {
        return new Builder();
    }
}

