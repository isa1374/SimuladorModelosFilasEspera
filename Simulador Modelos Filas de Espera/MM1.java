public class MM1 {
	private double l=0; //lambda--promedio llegada de clientes
	private double m=0; //Mu--promedio de servicio a los clientes 
	private double Wq=0; // tiempo promedio de espera de un cliente 
	
	private double Ls=0; //numero clientes en el sistema en un momento dado 
	private double Ws=0; //tiempo primedio cliente pasa en la cola
	private double Lq=0; //numero clientes en la cola 
	private double P=0; //probabilidad sistema utilización 
	private double Poc=0; //probabilidad sistema ocioso
	private double Pn=0; //probabilidad de n clientes en cola 
	
	
	public MM1(double l, double m){
		this.l=l; 
		this.m=m;
	}
	
	public void CalcularWs(){
		double res;
		double m = getM();
		double p = getP();
		
		res= 1 / (m*(1-p));
		this.Ws=res; 
	}
	public void CalcularLs(){
		double res; 
		double p = getP(); 
		
		res= p / (1-p);
		this.Ls=res; 
	}
	public void CalcularWq(){
		double res; 
		double p =getP();
		double m=getM();
		
		res= p / (m*(1-p));
		this.Wq=res;
	}
	public void CalcularLq(){
		double res; 
		double p=getP(); 
		
		res= Math.pow(p, 2) / (1-p);
		this.Lq=res;
	}
	public void CalcularP(){
		double res; 
		double l= getL(); 
		double m = getM();
			
		res = (l)/(m);
		this.P=res;
		
	}
	public void CalcularPoc(){
		double res; 
		double P= getP(); 
		
		res= (1-P); 
		this.Poc=res;
	}
	public void CalcularPn(double n){
		double res; 
		double p = getP();
		double po=getPoc();
		
		res=Math.pow(p, n)*po;
		this.Pn=res;
	}
	
	public double getL(){
		return this.l; 
	}
	public double getM(){
		return this.m;
	}
	public double getWq(){
		return this.Wq; 
	}
	public double getLq(){
		return this.Lq;
	}
	public double getLs(){
		return this.Ls;
	}
	public double getWs(){
		return this.Ws; 
	}
	public double getP(){
		return this.P; 
	}
	public double getPoc(){
		return this.Poc;
	}
	public double getPn(){
		return this.Pn;
	}
}
