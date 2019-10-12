package practica1;

import java.util.ArrayList;
import java.util.Random;

public class polinomio{
    ArrayList <monomio> mon = new ArrayList();
	public polinomio(){
            for(int i=0;i<7;i++){
                this.mon.add(new monomio());
            }
            junta();
            ordena();
	}
        public polinomio(int a){
            Random r= new Random();
            int coeficiente,exponente;
            exponente=r.nextInt(3);
            coeficiente=r.nextInt(4);
            if(coeficiente==0){
            coeficiente=r.nextInt(4);    
            }
            if(exponente==0){
            exponente=r.nextInt(3);    
            }
            this.mon.add(new monomio(coeficiente, exponente));
            if(this.mon.get(0).exponente==2){
                coeficiente=r.nextInt(4);
                if(coeficiente==0){
                    coeficiente=r.nextInt(4);
                }
                this.mon.add(new monomio(coeficiente, 1));
            }
            do{
                coeficiente=r.nextInt(4);
            }while(coeficiente<0); 
            if(r.nextInt(2)==0){
                coeficiente*=-1;
            }
            this.mon.add(new monomio(coeficiente,0));
            
            this.junta();
            this.ordena();
        }
        
        public polinomio(ArrayList <monomio> m){
            for (int i = 0; i < m.size(); i++) {
                this.mon.add(m.get(i));
            }
        }
        
        public void junta(){
            for (int i = 0; i <this.mon.size(); i++) {
                for (int j = 0; j <this.mon.size(); j++) {
                    if(i!=j){
                        if(this.mon.get(i).exponente==this.mon.get(j).exponente){
                            this.mon.get(i).coeficiente+=this.mon.get(j).coeficiente;
                            this.mon.get(j).coeficiente=0;
                        }
                    }
                }
            }
        }

    private void ordena() {
        int aux=0;
        for (int i = 0; i <this.mon.size(); i++) {
                for (int j = aux; j <this.mon.size(); j++) {
                    if(this.mon.get(i).exponente>this.mon.get(j).exponente){
                        int exp=0;
                        int coe=0;
                        coe=this.mon.get(i).coeficiente;
                        exp=this.mon.get(i).exponente;
                        this.mon.get(i).coeficiente=this.mon.get(j).coeficiente;
                        this.mon.get(i).exponente=this.mon.get(j).exponente;
                        this.mon.get(j).coeficiente=coe;
                        this.mon.get(j).exponente=exp;
                    }
                    aux++;
            }
                aux=0;
        }
    }
    public  static polinomio suma(polinomio a, polinomio b){
        polinomio temp=new polinomio();
        for (int i = 0; i <7; i++) {
            temp.mon.get(i).exponente=i;
            temp.mon.get(i).coeficiente=0;
        }
        for (int i = 0; i <temp.mon.size(); i++) {
            for (int j = 0; j <b.mon.size(); j++) {
                if(temp.mon.get(i).exponente==a.mon.get(j).exponente){
                    temp.mon.get(i).coeficiente+=a.mon.get(j).coeficiente;
                }
                if(temp.mon.get(i).exponente==b.mon.get(j).exponente){
                    temp.mon.get(i).coeficiente+=b.mon.get(j).coeficiente;
                }
                
            }
        }
        temp.junta();
        temp.ordena();
        return temp;
        
    }
    public  static polinomio resta(polinomio a, polinomio b){
        polinomio temp=new polinomio();
        for (int i = 0; i <7; i++) {
            temp.mon.get(i).exponente=i;
            temp.mon.get(i).coeficiente=0;
        }
        for (int i = 0; i <temp.mon.size(); i++) {
            for (int j = 0; j <b.mon.size(); j++) {
                if(temp.mon.get(i).exponente==a.mon.get(j).exponente){
                    temp.mon.get(i).coeficiente+=a.mon.get(j).coeficiente;
                }
                if(temp.mon.get(i).exponente==b.mon.get(j).exponente){
                    temp.mon.get(i).coeficiente-=b.mon.get(j).coeficiente;
                }
                
            }
        }
        temp.junta();
        temp.ordena();
        return temp;
        
    }
    public static polinomio multiplica(polinomio a, polinomio b){
        polinomio temp = new polinomio();
        temp.mon.clear();
        for (int i = 0; i < a.mon.size(); i++) {
            for (int j = 0; j <b.mon.size(); j++) {
                 temp.mon.add(monomio.multiplicar(a.mon.get(i),b.mon.get(j)));
            }
        }
        temp.junta();
        temp.ordena();
        polinomio auxiliar = new polinomio();
        auxiliar.mon.clear();
        for (int i = 0; i < temp.mon.size(); i++) {
            if (temp.mon.get(i).coeficiente!=0) {
                auxiliar.mon.add(temp.mon.get(i));
            }
        }
        return auxiliar;
    }
    
    public static polinomio div_res(int indice){
        polinomio temp = new polinomio();
        temp.mon.clear();
        for (int i = 0; i <indice; i++) {
            temp.mon.add(new monomio(i));
        }
        temp.junta();
        temp.ordena();
        return temp;
    }
    
    
    @Override
    public String toString(){
        String s="";
        for (int i = 0; i < this.mon.size(); i++) {
            if(this.mon.get(i).coeficiente!=0){
                if(this.mon.get(i).coeficiente<0){
                    s+="";
                }else{
                    s+="+";
                } 
                s+=this.mon.get(i).coeficiente+"x";
                switch(this.mon.get(i).exponente){
                    case 0:
                    s=s.substring(0,s.length()-1);
                    break;
                    case 2:
                        s+="\u00B2";
                    break;
                    case 3:
                        s+="\u00B3";
                    break;
                    case 4:
                        s+="\u2074";
                    break;
                    case 5:
                        s+="\u2075";
                    break;
                    case 6:
                        s+="\u2076";
                    break;
                    case 7:
                        s+="\u2077";
                    break;
                    case 8:
                        s+="\u2078";
                    break;
                    case 9:
                        s+="\u2079";
                    break;
                    case 10:
                        s+="\u00B9"+"\u2070";
                    break;
                    case 11:
                        s+="\u00B9"+"\u00B9";
                    break;
                    case 12:
                        s+="\u00B9"+"\u00B2";
                    break;
                    
                }
            }
        }
        String aux = s.substring(1, s.length());
        return aux;   
    }
    public static boolean equals(polinomio a, polinomio b){
        boolean estado=true;
        if(!a.toString().equals(b.toString())){
            estado=false;
        }
        return estado;
    }
}
