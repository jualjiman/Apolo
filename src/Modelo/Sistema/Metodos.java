/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo.Sistema;

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Locale;
/**
 *
 * @author PACO
 */
public class Metodos {

    public static boolean isPasswordCorrect(String posible,String verdadera)
    {
         boolean respuesta = false;
         if(posible.equals(verdadera))
             respuesta = true;
         
         return respuesta;
    }

    public static Calendar StringToCalendarFH(String fechatexto){
        //"2012-09-13 17:04:31.169"

        Calendar fecharetorno = Calendar.getInstance();
        if(fechatexto != null){
            int año,mes,dia,hora,minuto;

            año = Integer.parseInt(fechatexto.substring(0,4));
            año = año + 1900;
            mes = Integer.parseInt(fechatexto.substring(5,7));
            mes = mes -1;
            dia = Integer.parseInt(fechatexto.substring(8,10));

            hora = Integer.parseInt(fechatexto.substring(11,13));
            minuto = Integer.parseInt(fechatexto.substring(14,16));

            fecharetorno.set(año,mes,dia,hora,minuto);
        }
        else
            fecharetorno = null;
        
        return fecharetorno;
    }
    
    public static Calendar StringToCalendarF(String fechatexto){
        //"2012-09-13 17:04:31.169"

        Calendar fecharetorno = Calendar.getInstance();
        if(fechatexto != null){
            int año,mes,dia;

            año = Integer.parseInt(fechatexto.substring(0,4));
            mes = Integer.parseInt(fechatexto.substring(5,7));
            dia = Integer.parseInt(fechatexto.substring(8,10));

            fecharetorno.set((año - 1900),(mes-1),dia);
        }
        else
            fecharetorno = null;
        
        return fecharetorno;
    }
    
    public static String CalendarToString(Calendar fecha){
        java.text.SimpleDateFormat sdf =  new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(fecha.getTime());
    }

    public static String FormatoMoneda(String cont){ 
        String[] scont = cont.split("\\.");
        String salida = cont;

        if(cont.equals("."))
            salida = "0.00";
        else if(cont.equals(""))
            salida = "0.00";
        else if(cont.startsWith("."))
            salida = "0" + cont;
        else if(cont.endsWith("."))
            salida = cont + "00";
        else if(scont.length == 1)
            salida = cont + ".00";
        else if(scont.length == 2){
            if(scont[1].length() == 1)
                salida = scont[0] + "." + scont[1] + "0";
            else if(scont[1].length() > 2){
                scont[1] = scont[1].substring(0, 2); 
                salida = scont[0] + "." + scont[1];
            }
        }
        return salida;
    }

    public static String FormatoUnidadMedidaMili(String cont){ 
        String[] scont = cont.split("\\.");
        String salida = cont;

        if(cont.equals("."))
            salida = "0.000";
        else if(cont.equals(""))
            salida = "0.000";
        else if(cont.startsWith("."))
            salida = "0" + cont;
        else if(cont.endsWith("."))
            salida = cont + "000";
        else if(scont.length == 1)
            salida = cont + ".000";
        else if(scont.length == 2){
            if(scont[1].length() == 1)
                salida = scont[0] + "." + scont[1] + "00";
            else if(scont[1].length() == 2)
                salida = scont[0] + "." + scont[1] + "0";
            else if(scont[1].length() > 3){
                scont[1] = scont[1].substring(0, 3); 
                salida = scont[0] + "." + scont[1];
            }
        }
        return salida;
    }

    public static String FormatoUnidadSinDecimales(String cont){ 
        String[] scont = cont.split("\\.");
        String salida = cont;


        if(scont.length == 2){
            salida = scont[0];
        }
        return salida;
    }

    public static String PrimeraMayuscula(String entrada,boolean demas_minusculas){
        String salida = "";
        try{
            if(entrada.length() > 0){
                String s1 = entrada.substring(0,1);
                String s2 = entrada.substring(1);
                salida = s1.toUpperCase() + (demas_minusculas?s2.toLowerCase():s2);
            }
        return salida;
        }catch(Exception e){return "";} 
    }

    public static String PrimeraTodasMayuscula(String entrada){//devuelve la cadena con la primera letra mayuscula en todas las palabras
        String salida = "";
        String s1,s2;
        try{
            if(entrada.length() > 0){
                String[] palabras = entrada.split(" ");

                for(int i = 0;i < palabras.length; i++){
                    s1 = palabras[i].substring(0,1);
                    s2 = palabras[i].substring(1);
                    salida+= s1.toUpperCase() + s2.toLowerCase();
                    if(i+1 < palabras.length)
                        salida+=" ";
                }
            }
        return salida;
        }catch(Exception e){return "";} 
    }


    public static String Mayusculas(String entrada){//devuelve la cadena con la primera letra mayuscula en todas las palabras
        try{
            return entrada.toUpperCase();
        }catch(Exception e){return "";} 
    }

    public static float Redondear(float numero,int digitos)
    {
        double num,dnum;
        String snum;
        float fnum;
        int cifras=(int) Math.pow(10,digitos);
        snum = String.valueOf(numero);
        num = Double.parseDouble(snum);
        dnum = Math.rint(num * cifras) / cifras;
        snum = String.valueOf(dnum);
        fnum = Float.parseFloat(snum);
        return fnum;
    } 
    
    public static String FormatoMiles(String valor)
    { 
        Locale loc = new Locale("es","MX");
        double val = Double.parseDouble(valor); 
        Locale.setDefault(loc); 
        DecimalFormat num = new DecimalFormat("#,###.00"); 
        return num.format(val);
    }
    
    public static String FormatoFecha(Calendar fecha){
        String dia;
        String mes;
        String anno;
        String sfecha = "";
        
        dia = String.valueOf(fecha.get(Calendar.DATE));
        mes = String.valueOf(fecha.get(Calendar.MONTH) + 1);
        anno = String.valueOf(fecha.get(Calendar.YEAR));
        
        dia = dia.length() == 1? "0" + dia : dia;
        mes = mes.length() == 1? "0" + mes : mes;
        
        sfecha = dia + "/" + mes + "/" + anno;
        
        return sfecha;
    }
}


