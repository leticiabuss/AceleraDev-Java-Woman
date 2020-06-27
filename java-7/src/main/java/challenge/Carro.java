package challenge;

import java.util.Objects;

public class Carro {

    private final Motorista motorista;
    private final String placa;
    private final Cor cor;

    private Carro(Builder builder) {
    	this.motorista = builder.motorista;
    	this.placa = builder.placa;
    	this.cor = builder.cor;
    }

    public static final class Builder{
    	private Motorista motorista;
        private String placa;
        private Cor cor;
        
        public Builder() {}
        
        public Builder withPlaca(String placa) {
        	this.placa = placa;
        	return this;
        }
        
        public Builder withCor(Cor cor) {
        	this.cor = cor;
        	return this;
        }
        
        public Builder withMotorista(Motorista motorista) {
        	this.motorista = motorista;
        	return this;
        }
        
        public Carro build() {
            Objects.requireNonNull(this.placa, "A placa não foi preenchida.");
            Objects.requireNonNull(this.cor, "A cor não foi preenchida.");
            return new Carro(this);
        }
    }
    public String getPlaca() {
        return placa;
    }

    public Cor getCor() {
        return cor;
    }

    public Motorista getMotorista() {
        return motorista;
    }

    public static Builder builder() {
        return new Builder();
    }
}