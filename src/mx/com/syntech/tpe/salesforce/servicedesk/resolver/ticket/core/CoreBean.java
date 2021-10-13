package mx.com.syntech.tpe.salesforce.servicedesk.resolver.ticket.core;

import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;
import java.util.SortedMap;
import mx.com.syntech.tpe.salesforce.servicedesk.resolver.ticket.props.AppPropsBean;
import org.apache.log4j.Category;

/**
 *
 * @author Jorge Zavala Navarro
 */
public class CoreBean {

    private static final Category log = Category.getInstance(CoreBean.class);

    protected void verCharSet() {
        // Des´plegar información del charset
        String charSetPredeterminado = Charset.defaultCharset().name();
        log.info("   ::: Charset= " + charSetPredeterminado);
    }
    
    public String getCharsetActual(){
        return Charset.defaultCharset().name();
    }
    
    public String getLanguajeActual(){
        return Locale.getDefault().getLanguage();
    }
        
        

    public void asignarCharSet(String charset) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        log.info("   ::: Charset actual: " + Charset.defaultCharset().name());
        log.info("   ::: File encoding actual: " + System.getProperty("file.encoding"));
        log.info("   ::: Asignando el charset: " + charset);
        System.setProperty("file.encoding", charset);
        
        log.info("   ::: File encoding actual: " + System.getProperty("file.encoding"));

        Field fieldCharset = Charset.class.getDeclaredField("defaultCharset");
        fieldCharset.setAccessible(true);
        fieldCharset.set(null, null);
        log.info("   ::: Charset actual: " + Charset.defaultCharset().name());

    }

    public void listarCharSet() {
        SortedMap<String, Charset> listCharSet = Charset.availableCharsets();
        Collection collCharSet = listCharSet.values();
        Iterator itChartSet = collCharSet.iterator();
        log.info("CHARSETS DISPONIBLES...");
        int contador = 1;
        int porLinea = 10;
        String linea = null;
        
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("## =========================================== ");
        System.out.println("## C H A R S E T S   D I S P O N I B L E S  ");
        System.out.println("## ======================================== ");
        while (itChartSet.hasNext()) {
            // log.info("Charset[" + contador++ + "]: " + ((Charset) itChartSet.next()).name());
            if(contador == 1){
                linea = "## " + ((Charset)itChartSet.next()).name();
            }else{
                linea = linea + ", " + ((Charset)itChartSet.next()).name();
            }
            if(contador == porLinea){
                // Cortamos linea
                System.out.println(linea);
                contador = 0;
                linea = null;
            }
            contador++;
        }
    }

    public void listarLanguajes() {
        Locale[] listLocale = Locale.getAvailableLocales();
        String linea = null;
        int porLinea = 20;
        int contLinea = 1;
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("## =========================================== ");
        System.out.println("## L A N G U A J E S   D I S P O N I B L E S  ");
        System.out.println("## =========================================== ");
        
        for(int i=0; i<listLocale.length; i++){
            if(contLinea==1){
                linea = "## " + listLocale[i].getLanguage();
            }else{
                linea = linea + ", " + listLocale[i].getLanguage();
            }
            
            if(contLinea==porLinea){
                // Cortar la linea
                // Cortamos linea
                System.out.println(linea);
                contLinea = 0;
                linea = null;
            }
            contLinea ++;        
                    
        }
       
    }
    
    public void asignarLanguaje(String languaje) {
        log.info("   ::: Languaje actual: " + Locale.getDefault().getLanguage());
        log.info("   ::: Asignando languaje: " + languaje);
        Locale.setDefault(new Locale(languaje));
        log.info("   ::: Languaje nuevoactual: " + Locale.getDefault().getLanguage());
    }
    
    public void verLanguajeActuial(){
    }
    

    public static void main(String... params) {
        AppPropsBean.getPropsVO();
        CoreBean bean = new CoreBean();
        try {
            // bean.asignarLanguaje("en");

            // bean.asignarCharSet("utf-16");
            

            bean.listarCharSet();
            bean.listarLanguajes();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
