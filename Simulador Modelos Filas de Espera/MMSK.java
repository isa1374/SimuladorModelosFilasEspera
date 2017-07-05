
public class MMSK {
	double l; //llegadas 
	double m; //servicios 
	double s; //# servidores 
	double k; //# num maximo de personas en fila 
	
	double p; 
	double po; 
	double pn; 
	double lq; 
	double wq; 
	double ws; 
	double ls; 
	double pk; 
	double Lmr; 

	
	public MMSK(double l, double m, double s, double k){
		this.l=l; 
		this.m=m; 
		this.s=s; 
		this.k=k; 
	}
	
	public void CalcularP(){
		double res; 
		double l=getL();
		double m=getM(); 
		double s=getS();
		
		res=(l/(s*m));
		this.p=res; 
	}
	public void CalcularPo(){
		double res; 
		double r1=0; 
		double r2=0; 
		double l=getL(); 
		double m=getM(); 
		double k=getK(); 
		double s=getS(); 
		
		for(int i=1; i<s; i++){
			r1= r1 + (Math.pow((l/m), i)/Factorial(i));
		}
		for(int p=(int)(s+1); p<k; p++){
			r2= r2 + Math.pow((l/(s*m)), (p-s));
		}
		
		res= 1/(1 + r1 + 
				(Math.pow((l/m), s) / Factorial(s)) + 
				r2); 
		this.po=res;
	}
	public void CalcularPn(double n){
		double res; 
		double m=getM(); 
		double l=getL(); 
		double s=getS(); 
		double k=getK();
		double po=getPo();
		if(n>=1 && n<=s){
			res= (Math.pow((l/m), n)*po)/ Factorial(n);
		}else if(n>s && n<=k){
			res= (Math.pow((l/m), n)* po)/(Factorial(s)* Math.pow(s, (n-s)));
		}else{
			res= 0; 
		}
		this.pn=res; 
	}
	public void CalcularLq(){
		double res; 
		double p= getP();
		double po=getPo();
		double l=getL(); 
		double m=getM();
		double s=getS(); 
		double k=getK();
		
		if(l==(s*m)){
			res= ((1/2)*((Math.pow((l/m), s)*po) *   (k - s + (Math.pow((k-s),2)))))
					/ Factorial(s);
		}else{
			res= ((Math.pow((l/m), s)*po)* 
					(p*(1 - Math.pow(p, (k-s)) - ((k-s)*Math.pow(p, (k-s))*(1-p)))))
					/(Factorial(s) *Math.pow((1-p), 2));
		}
		this.lq=res;
	}
	public void CalcularWq(){
		double res; 
		double lq=getLq(); 
		double lmr; 
		
		CalcularLmr();
		lmr=getLmr(); 
		
		res= lq/lmr; 
		this.wq=res; 
	}
	public void CalcularWs(){
		double res; 
		double ls=getLs(); 
		double lmr; 
		
		CalcularLmr(); 
		lmr=getLmr(); 
		
		res= ls/lmr; 
		this.ws=res; 
	}
	public void CalcularLs(){
		double res; 
		double lq=getLq(); 
		double k=getK();
		double pk;
		double m=getM();
		
		
		CalcularPk(k);
		pk=getPk();
		res= lq+((l* (1-pk))/m);
		this.ls=res; 
	}
	public void CalcularPk(double n){
		double res; 
		double m=getM(); 
		double l=getL(); 
		double s=getS(); 
		double k=getK();
		double po=getPo();
		if(n>=1 && n<=s){
			res= (Math.pow((l/m), n)*po)/ Factorial(n);
		}else if(n>s && n<=k){
			res= (Math.pow((l/m), n)* po)/(Factorial(s)* Math.pow(s, (n-s)));
		}else{
			res= 0; 
		}
		this.pk=res; 
	}
	public void CalcularLmr(){
		double res; 
		double k=getK(); 
		double pk; 
		double l=getL(); 
		
		CalcularPk(k); 
		pk=getPk(); 
		
		res= l*(1-pk); 
		this.Lmr=res; 
	}
	
	public double Factorial(double num){
		double n=num;
		 if(n==0){
			 return 1; 
		 }else{
			 return (n*Factorial(n-1));
		 }
	}
	
	public double getLmr(){
		return this.Lmr;
	}
	public double getPk(){
		return this.pk; 
	}
	public double getWs(){
		return this.ws;
	}
	public double getWq(){
		return this.wq; 
	}
	public double getLs(){
		return this.ls;
	}
	public double getLq(){
		return this.lq; 
	}
	public double getPn(){
		return this.pn; 
	}
	public double getPo(){
		return this.po;
	}
	public double getP(){
		return this.p; 
	}
	public double getL(){
		return this.l;
	}
	public double getM(){
		return this.m; 
	}
	public double getS(){
		return this.s; 
	}
	public double getK(){
		return this.k;
	}
}