public class MaquinaExpendedoraMejorada {

    // El precio del billete
    private int precioBillete;
    // La cantidad de dinero que lleva metida el cliente actual
    private int balanceClienteActual;
    // El total de dinero almacenado en la maquina desde su ultimo vaciado
    private int totalDineroAcumulado;
    // El origen del billete
    private String estacionOrigen;
    // El destino del billete
    private String estacionDestino;
    // Indica si la m�quina tiene o no premio 
    private boolean maquinaConPremio;
    //la cantidad maxima de billetes que se pueden vender
    private int numMaximoDeBilletes;

    /**
     * Crea una maquina expendedora de billetes de tren con el 
     * precio del billete y el origen y destino dados. Se asume que el precio
     * del billete que se recibe es mayor que 0.
     */
    public MaquinaExpendedoraMejorada(int precioDelBillete, String origen, String destino, boolean maquinaConPremio, int numMaximoDeBilletes) {
        precioBillete = precioDelBillete;
        balanceClienteActual = 0;
        totalDineroAcumulado = 0;
        estacionOrigen = origen;
        estacionDestino = destino;
        this.maquinaConPremio = maquinaConPremio;
        this.numMaximoDeBilletes = numMaximoDeBilletes;
    }

    /**
     * Devuelve el precio del billete
     */
    public int getPrecioBillete() {
        return precioBillete;
    }

    /**
     * Devuelve la cantidad de dinero que el cliente actual lleva introducida
     */
    public int getBalanceClienteActual() {
        return balanceClienteActual;
    }

    /**
     * Simula la introduccion de dinero por parte del cliente actual
     */
    public void introducirDinero(int cantidadIntroducida) {
        if(cantidadIntroducida > 0) {
            if(numMaximoDeBilletes > 0){
                balanceClienteActual = balanceClienteActual + cantidadIntroducida;
            }
            else{
                System.out.println("ERROR! N�mero m�ximo de billetes vendidos.");
            }
        }
        else {
            System.out.println(cantidadIntroducida + " no es una cantidad de dinero valida.");
        }        
    }

    /**
     * Imprime un billete para el cliente actual
     */
    public void imprimirBillete() {
        if(balanceClienteActual >= precioBillete) {
            if(numMaximoDeBilletes > 0){
                // Simula la impresion de un billete
                System.out.println("##################");
                System.out.println("# Billete de tren:");
                System.out.println("# De " + estacionOrigen + " a " + estacionDestino);
                System.out.println("# " + precioBillete + " euros.");
                System.out.println("##################");
                System.out.println();
                numMaximoDeBilletes --;
                if(maquinaConPremio && numMaximoDeBilletes > 0){
                    // Simula la impresion de un billete de regalo
                    System.out.println("##################");
                    System.out.println("# Billete de tren:");
                    System.out.println("# De " + estacionOrigen + " a " + estacionDestino);
                    System.out.println("Gratis! Billete de regalo.");
                    System.out.println("##################");
                    System.out.println(); 
                    numMaximoDeBilletes --;
                    // Actualiza el total de dinero acumulado en la maquina
                    totalDineroAcumulado = totalDineroAcumulado + precioBillete;
                    // Reduce el balance del cliente actual dejandole seguir utilizando la maquina
                    balanceClienteActual = balanceClienteActual - precioBillete;
                }
            }
            else{
                System.out.println("ERROR! N�mero m�ximo de billetes vendidos.");
            }
        }
        else {
            System.out.println("Necesitas introducir " + (precioBillete - balanceClienteActual) + " euros mas!"); 
        } 
    }

    /**
     * Cancela la operacion de compra del cliente actual y le
     * devuelve al cliente el dinero que ha introducido hasta el momento
     */
    public int cancelarOperacionYDevolverDinero()
    {
        int cantidadDeDineroADevolver;
        cantidadDeDineroADevolver = balanceClienteActual;
        balanceClienteActual = 0;
        return cantidadDeDineroADevolver;
    } 

    public int vaciarDineroDeLaMaquina(){
        int dineroExtraido = 0;
        if(balanceClienteActual == 0){
            dineroExtraido = totalDineroAcumulado;
            totalDineroAcumulado = 0;
        }
        else{
            System.out.println("Error, operaci�n en curso!");
            dineroExtraido = -1;
        }
        return dineroExtraido;
    }
}
