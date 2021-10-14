/**
 * La clase modela un sencillo pod�metro que registra informaci�n
 * acerca de los pasos, distancia, ..... que una persona
 * ha dado en una semana. 
 * 
 * @author    - Amine Ezzaidi - 
 */
public class Podometro {
    private final char hombre = 'H';
    private final char mujer = 'M';
    private final double ZANCADA_HOMBRE = 0.45;
    private final double ZANCADA_MUJER = 0.41;
    private final int SABADO = 6;
    private final int DOMINGO = 7;

    private String marca;
    private double altura;
    private char sexo;
    private double longitudZancada;
    private int totalPasosLaborales;
    private int totalPasosSabado;
    private int totalPasosDomingo;
    private double totalDistanciaSemana;
    private double totalDistanciaFinDeSemana;
    private int tiempo;
    private int caminatasNoche;
    /**
     * Inicializa el pod�metro con la marca indicada por el par�metro.
     * El resto de atributos se ponen a 0 y el sexo, por defecto, es mujer
     */
    public Podometro(String queMarca) {
        marca = queMarca;
        sexo = 'M';
        altura = 0;
        longitudZancada = 0;
        totalPasosLaborales = 0;
        totalPasosSabado = 0;
        totalPasosDomingo = 0;
        totalDistanciaSemana = 0;
        totalDistanciaFinDeSemana = 0;
        tiempo = 0;
        caminatasNoche = 0;
    }

    /**
     * accesor para la marca
     *  
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Simula la configuraci�n del pod�metro.
     * Recibe como par�metros la altura y el sexo de una persona
     * y asigna estos valores a los atributos correspondiente.
     * Asigna adem�s el valor adecuado al atributo longitudZancada
     * 
     * (leer enunciado)
     *  
     */
    public void configurar(double queAltura, char queSexo) {
        altura = queAltura;
        if (queSexo == 'H') {
            longitudZancada = Math.ceil(altura * ZANCADA_HOMBRE);
            sexo = 'H';
        }
        else{
            longitudZancada = Math.floor(altura * ZANCADA_MUJER);
            sexo = 'M';
        }
    }

    /**
     *  Recibe cuatro par�metros que supondremos correctos:
     *    pasos - el n� de pasos caminados
     *    dia - n� de d�a de la semana en que se ha hecho la caminata 
     *              (1 - Lunes, 2 - Martes - .... - 6 - S�bado, 7 - Domingo)
     *    horaInicio � hora de inicio de la caminata
     *    horaFin � hora de fin de la caminata
     *    
     *    A partir de estos par�metros el m�todo debe realizar ciertos c�lculos
     *    y  actualizar� el pod�metro adecuadamente  
     *   
     *   (leer enunciado del ejercicio)
     */
    public void registrarCaminata(int pasos, int dia, int horaInicio,
    int horaFin) {
        if (horaInicio>=2100) {
            caminatasNoche ++;
        }
        tiempo = tiempo + ((horaFin - horaInicio)*60);
        switch (dia){
            case 1: ;
            case 2: ;
            case 3: ;
            case 4: ;
            case 5:
                totalPasosLaborales = totalPasosLaborales + pasos;
                totalDistanciaSemana = totalDistanciaSemana +
                (totalPasosLaborales * longitudZancada / 10000);
                break;
            case 6:
                totalPasosSabado = totalPasosSabado + pasos;
                totalDistanciaFinDeSemana = totalDistanciaFinDeSemana
                + ((totalPasosSabado + totalPasosDomingo) * longitudZancada /10000);
                break;
            case 7:
                totalPasosDomingo = totalPasosDomingo + pasos;
                totalDistanciaFinDeSemana = totalDistanciaFinDeSemana +
                ((totalPasosDomingo + totalPasosSabado) * longitudZancada / 10000);
                break;
        }
    }   

    /**
     * Muestra en pantalla la configuraci�n del pod�metro
     * (altura, sexo y longitud de la zancada)
     * 
     * (ver enunciado)
     *  
     */
    public void printConfiguracion() {
        
        System.out.println ("Configuracion del podometro\n*********************************" +
            "\nAltura : " + altura / 100 + "\nSexo : " + sexo + "\nLongitud Zancada : " + longitudZancada);

    }

    /**
     * Muestra en pantalla informaci�n acerca de la distancia recorrida,
     * pasos, tiempo total caminado, ....
     * 
     * (leer enunciado)
     *  
     */
    public void printEstad�sticas() { 
        int horas = tiempo;
        int minutos = tiempo;
        String diaMayorNumeroPasos = ;
        System.out.println("Estadisticas\n *******************"
        + "\ndistancia recorrida toda la semana : " + totalDistanciaSemana + " km " +
        "\ndistancia recorrida fin de semana : " + totalDistanciaFinDeSemana + " km "
        + "\nnumero pasos dias laborables ; " + totalPasosLaborales
        + "\nnumero pasos SABADO : " + totalPasosSabado 
        + "\nnumero pasos DOMINGO : " + totalPasosDomingo
        + "\nnumero caminatas realizadas a partir de las 21h : " + caminatasNoche
        + "\ntiempo total caminado en toda la semana : " + horas + minutos
        + "\ndias con mas pasos caminados : " + (diaMayorNumeroPasos));
    }

    /**
     *  Calcula y devuelve un String que representa el nombre del d�a
     *  en el que se ha caminado m�s pasos - "S�BADO"   "DOMINGO" o  "LABORABLES"
     */
    public String diaMayorNumeroPasos() {
        String diaMayorNumeroPasos = "";
        if (totalPasosSabado > totalPasosDomingo ||totalPasosLaborales < totalPasosSabado ){
            diaMaspasos = "SABADO";
        }
        else if (totalPasosDomingo > totalPasosSabado || totalPasosLaborales < totalPasosDomingo){
            diaMaspasos = "DOMINGO";
        }
        else {
            diaMaspasos = "LABORABLES";
        }
        return diaMayorNumeroPasos;

    }

    /**
     * Restablecer los valores iniciales del pod�metro
     * Todos los atributos se ponen a cero salvo el sexo
     * que se establece a MUJER. La marca no var�a
     *  
     */    
    public void reset() {
        sexo = 'M';
        altura = 0;
        longitudZancada = 0;
        totalPasosLaborales = 0;
        totalPasosSabado = 0;
        totalPasosDomingo = 0;
        totalDistanciaSemana = 0;
        totalDistanciaFinDeSemana = 0;
        tiempo = 0;
        caminatasNoche = 0;
    }
}
