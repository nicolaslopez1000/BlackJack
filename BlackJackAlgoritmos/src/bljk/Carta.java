package bljk;

public class Carta {

	private  Tipo tipo;
	private  Valor valor;
	
	
	public Carta(Tipo ti, Valor val) {
		this.valor = val;
		this.tipo = ti;
		
	}
	
	public Valor getValor(){
		
		return this.valor;
	}
	
	public String toString() {
	 return tipo.toString()+" "+valor.toString();	
	}
		
	
}
