public class MG1 {
	double l; 
	double m; 
	double o; //varianza o cuadrada 
	
	double p; 
	double po; 
	double pn; 
	double lq; 
	double wq; 
	double ls; 
	double ws; 
	
	public MG1(double l, double m, double o){
		this.m=m; 
		this.l=l; 
		this.o=o; 
	}
	
	public void CalcularP(){
		double res; 
		double l=getL(); 
		double m=getM(); 
		
		res=l/m;
		this.p=res; 
	}
	public void CalcularPo(){
		double res; 
		double p=getP(); 
		
		res= 1-p; 
		this.po=res; 
	}
	public void CalcularPn(double n){
		double res; 
		double p=getP(); 
		double po=getPo(); 
		
		res= Math.pow(p, n)*po;
		this.pn=res; 
	}
	public void CalcularLq(){
		double res; 
		double l=getL(); 
		double o=getO(); 
		double p=getP(); 
		
		if(o==0){
			res= Math.pow(p,2) / (2* (1-p)); 
		}else {
			res= ((Math.pow(l,2) * o) + Math.pow(p, 2)) / 
					(2*(1-p));
		}
		this.lq=res; 
	}
	public void CalcularWq(){
		double res; 
		double l=getL(); 
		double lq=getLq(); 
		
		res= lq/l; 
		this.wq=res; 
	}
	public void CalcularLs(){
		double res; 
		double p= getP(); 
		double lq=getLq(); 
		
		res= p+lq; 
		this.ls=res; 
	}
	public void CalcularWs(){
		double res; 
		double wq=getWq();
		double m=getM(); 
		
		res= wq+ (1/m);
		this.ws=res; 
	}

	public double getL(){
		return this.l; 
	}
	public double getM(){
		return this.m; 
	}
	public double  getO(){
		return this.o; 
	}
	public double getP(){
		return this.p; 
	}
	public double getPo(){
		return this.po; 
	}
	public double getPn(){
		return this.pn;
	}
	public double getLq(){
		return this.lq;
	}
	public double getWq(){
		return this.wq; 
	}
	public double getLs(){
		return this.ls; 
	}
	public double getWs(){
		return this.ws;
	}
}
