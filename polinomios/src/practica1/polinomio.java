package practica1;

import java.util.ArrayList;

public class polinomio{
    ArrayList <monomio> mon = new ArrayList();
	public polinomio(){
            for(int i=0;i<8;i++){
                this.mon.add(new monomio());
            }
            System.out.println("");
            junta();
            ordena();
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
    @Override
    public String toString(){
        String s="";
        for (int i = 0; i < this.mon.size(); i++) {
            if(this.mon.get(i).coeficiente!=0){
                s+="+"+this.mon.get(i).coeficiente+"x";
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
                }
            }
        }
        String aux = s.substring(1, s.length());
        return aux;   
    }
}
