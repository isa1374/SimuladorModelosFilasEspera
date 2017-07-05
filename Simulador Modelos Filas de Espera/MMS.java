public class MMS {
	private double l; //lambda--promedio llegada de clientes
	private double m; //Mu--promedio de servicio a los clientes 
	private double c; //num servidores disponibles 
	
	private double Wq; // tiempo promedio de espera de un cliente 
	private double Ls; //numero clientes en el sistema en un momento dado 
	private double Ws; //tiempo primedio cliente pasa en la cola
	private double Lq; //numero clientes en la cola 
	private double P; //probabilidad sistema utilización (l/s*m}
	private double Po; // probabilidad de que no haya nadie ne el sistema 
	private double Pn; //probabilidad de n clientes en cola 
	private double S; //servidores ocupados 
	
	public MMS(double l, double m, double c){
		this.l=l;
		this.m=m; 
		this.c=c; 
	}
	
	public void CalcularP(){
		double res; 
		double l= getL();
		double m=getM(); 
		double c=getC();
		
		res= (l/(c*m)); 
		this.P=res; 
	}
	public void CalcularPo(){
		double res; 
		double c =getC(); 
		double l=getL(); 
		double m=getM();
		double r2=0;
		
		for(int i=0; i<c-1; i++){
			r2= r2 + ((1/Factorial(i))* Math.pow((l/m),i)) ;
		}
		
		res= 1/(r2 +  ((1/Factorial(c)) * (Math.pow((l/m), c)) * ((m*c)/ ((m*c)-l))));
		this.Po=res;	
	}
	public void CalcularLq(){
		double res; 
		double l=getL();
		double m=getM();
		double c = getC(); 
		double po=getPo();
		
		res = (((1/Factorial(c-1)) * Math.pow((l/m), c)) * ((l*m)/ Math.pow((c*m)-l, 2)))*po;
		this.Lq=res; 
	}
	public void CalcularS(){
		double res; 
		double c=getC(); 
		double p=getP();
		
		res= c*p; 
		this.S=res; 
	}
	public void CalcularPn(double n){
		double res; 
		double c=getC(); 
		double po=getPo(); 
		double l = getL(); 
		double m = getM(); 
		
		if(n<=c){
			res= ((1/Factorial(n))*(Math.pow((l/m),n)))*po;
		}else{
			res= ((1/Factorial(c))* (Math.pow((l/(c*m)), (n-c))))*po;
		}
		this.Pn=res; 
	}
	public void CalcularWq(){
		double res; 
		double l =getL(); 
		double lq=getLq(); 
		
		res= lq/l;
		this.Wq=res; 
	}
	public void CalcularWs(){
		double res; 
		double ls=getLs();
		double l=getL();
		
		res= ls /l; 
		this.Ws=res;
	}
	public void CalcularLs(){
		double res; 
		double lq=getLq(); 
		double l=getL(); 
		double m=getM(); 
		
		res= lq+ (l/m);
		this.Ls=res; 
	}
	public double Factorial(double num){
		double n=num;
		 if(n==0){
			 return 1; 
		 }else{
			 return (n*Factorial(n-1));
		 }
	}
	
	public double getL(){
		return this.l; 
	}
	public double getM(){
		return this.m;
	}
	public double getC(){
		return this.c; 
	}
	public double getWq(){
		return this.Wq; 
	}
	public double getLs(){
		return this.Ls;
	}
	public double getWs(){
		return this.Ws;
	}
	public double getLq(){
		return this.Lq;
	}
	public double getP(){
		return this.P; 
	}
	public double getPo(){
		return this.Po; 
	}
	public double getPn(){
		return this.Pn;
	}
	public double getS(){
		return this.S; 
	}
}
