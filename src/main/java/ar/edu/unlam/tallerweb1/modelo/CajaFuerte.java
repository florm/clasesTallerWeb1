package ar.edu.unlam.tallerweb1.modelo;

public class CajaFuerte {

    private Boolean abierta = true;
    private int codigoApertura;
    private boolean bloqueada = false;
    private int contadorIntentosErroneos = 0;

    public boolean estaAbierta() {
        return abierta;
    }

    public boolean estaCerrada() {
        return !abierta;
    }

    public void cerrar(int codigoApetura) {
        this.codigoApertura = codigoApetura;
        abierta = false;
    }

    public void abrir(int codigo) {
        if(this.codigoApertura == codigo){
            abierta = true;
            contadorIntentosErroneos = 0;
        }
        else{
            contadorIntentosErroneos ++;
            if(contadorIntentosErroneos == 3)
                bloqueada = true;
        }
    }

    public boolean estaBloqueada() {
        return bloqueada;
    }
}
