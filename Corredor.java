/*
 * @Author: Jonatas Leon 
 *
 */
 
 public class Corredor implements Runnable{
	private String nome;
	private int numero;
	private int voltaAtual;
	private static int voltasTotal;
	private Corrida corrida;
	
	public Corredor(String nome, int numero, Corrida corrida) {
		this.nome = nome;
		this.numero = numero;
		voltaAtual = 0;
		this.corrida = corrida;
	}
	
	public String getNome() {
		return nome;
	}
	
	public int getNumero() {
		return numero;
	}
	
	public int getVoltaAtual() {
		return voltaAtual;
	}
	
	private synchronized void addVoltasTotal() {
		Corredor.voltasTotal = Corredor.voltasTotal+1;
	}
	
	private synchronized void addVolta() {
		voltaAtual++;
	}
	
	@Override
	public String toString() {
		return numero+" - "+nome;
	}
	
	public void run() {
		for(int i = 0; i < corrida.getVoltas();) {
			try {
				Thread.sleep(1);
				addVolta();
				addVoltasTotal();
				i++;
			}catch (InterruptedException e) {}
		}
		corrida.addColocacao(this);
		if(corrida.getPosicao(corrida.getTotalCorredores()-1) != null) corrida.fimCorrida();
	}
}
