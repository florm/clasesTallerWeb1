package ar.edu.unlam.tallerweb1;

import ar.edu.unlam.tallerweb1.modelo.CajaFuerte;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class CajaFuerteTest {

    /*
    * 1. No escribas codigo productivo sin un test que falle antes
    * 2. Hace el codigo lo mas simple posible como para que pase a verde
    * 3. Cuando el test pase, mejora codigo
    * */


    public static final int CODIGO_CORRECTO = 1234;
    private static final int CODIGO_INCORRECTO = 12345;

    @Test
    public void alCrearLaCajaFuerteDebeEstarAbierta() {
        //preparacion --> given

        //ejecucion --> when
        CajaFuerte cajaFuerte = whenCreoLaCajaFuerte();
        //comprobacion --> then
        thenLaCajaFuerteEstaAbierta(cajaFuerte);
    }

    @Test
    public void alCerrarLaCajaFuerteConUnCodigoDebeEstarCerrada() {
        //preparacion --> given
        CajaFuerte cajaFuerte = givenCreoUnaCajaFuerte();
        //ejecucion --> when
        whenCierroLaCajaFuerte(cajaFuerte, CODIGO_CORRECTO);
        //comprobacion --> then
        thenLaCajaFuerteEstaCerrada(cajaFuerte);
    }

    @Test
    public void alAbrirLaCajaFuerteConUnCodigoCorrectoDebeEstarAbierta() {
        //preparacion --> given
        CajaFuerte cajaFuerte = givenCreoUnaCajaFuerte();
        givenLaCajaFuerteEstaCerradaConCodigo(cajaFuerte, CODIGO_CORRECTO);
        //ejecucion --> when
        whenAbroLaCajaFuerte(cajaFuerte, CODIGO_CORRECTO);
        //comprobacion --> then
        thenLaCajaFuerteEstaAbierta(cajaFuerte);
    }

    @Test
    public void alAbrirLaCajaFuerteConUnCodigoIncorrectoDebeEstarCerrada() {
        //preparacion --> given
        CajaFuerte cajaFuerte = givenCreoUnaCajaFuerte();
        givenLaCajaFuerteEstaCerradaConCodigo(cajaFuerte, CODIGO_CORRECTO);
        //ejecucion --> when
        whenAbroLaCajaFuerte(cajaFuerte, CODIGO_INCORRECTO);
        //comprobacion --> then
        thenLaCajaFuerteEstaCerrada(cajaFuerte);
    }

    @Test
    public void alAbrirLaCajaFuerteConUnCodigoIncorrectoTresVecesConsecutivasDebeEstarBloqueada() {
        //preparacion --> given
        CajaFuerte cajaFuerte = givenCreoUnaCajaFuerte();
        givenLaCajaFuerteEstaCerradaConCodigo(cajaFuerte, CODIGO_CORRECTO);
        givenAbroLaCajaFuerteConCodigoIncorrectoTresVeces(cajaFuerte, CODIGO_INCORRECTO);
        //ejecucion --> when
        whenAbroLaCajaFuerte(cajaFuerte, CODIGO_INCORRECTO);
        //comprobacion --> then
        thenLaCajaFuerteEstaBloqueada(cajaFuerte);
        thenLaCajaFuerteEstaCerrada(cajaFuerte);
    }

    @Test
    public void alAbrirLaCajaFuerteConUnCodigoIncorrectoTresVecesNoConsecutivasNoDebeEstarBloqueada() {
        //preparacion --> given
        CajaFuerte cajaFuerte = givenCreoUnaCajaFuerte();
        givenLaCajaFuerteEstaCerradaConCodigo(cajaFuerte, CODIGO_CORRECTO);
        givenAbroLaCajaFuerteConCodigoIncorrectoDosVeces(cajaFuerte, CODIGO_INCORRECTO);
        givenAbrolaCajaFuerteConCodigoCorrecto(cajaFuerte, CODIGO_CORRECTO);
        givenLaCajaFuerteEstaCerradaConCodigo(cajaFuerte, CODIGO_CORRECTO);
        //ejecucion --> when
        whenAbroLaCajaFuerte(cajaFuerte, CODIGO_INCORRECTO);
        //comprobacion --> then
        thenLaCajaFuerteNoEstaBloqueada(cajaFuerte);
        thenLaCajaFuerteEstaCerrada(cajaFuerte);
    }

    private void thenLaCajaFuerteNoEstaBloqueada(CajaFuerte cajaFuerte) {
        assertThat(cajaFuerte.estaBloqueada()).isFalse();
    }

    private void givenAbrolaCajaFuerteConCodigoCorrecto(CajaFuerte cajaFuerte, int codigoCorrecto) {
        cajaFuerte.abrir(codigoCorrecto);
    }

    private void givenAbroLaCajaFuerteConCodigoIncorrectoDosVeces(CajaFuerte cajaFuerte, int codigoIncorrecto) {
        cajaFuerte.abrir(codigoIncorrecto);
        cajaFuerte.abrir(codigoIncorrecto);
    }

    private void thenLaCajaFuerteEstaBloqueada(CajaFuerte cajaFuerte) {
        assertThat(cajaFuerte.estaBloqueada()).isTrue();
    }

    private void givenAbroLaCajaFuerteConCodigoIncorrectoTresVeces(CajaFuerte cajaFuerte, int codigoIncorrecto) {
        cajaFuerte.abrir(codigoIncorrecto);
        cajaFuerte.abrir(codigoIncorrecto);
        cajaFuerte.abrir(codigoIncorrecto);
    }

    private void givenLaCajaFuerteEstaCerradaConCodigo(CajaFuerte cajaFuerte, int codigo) {
        cajaFuerte.cerrar(codigo);
    }

    private void whenAbroLaCajaFuerte(CajaFuerte cajaFuerte, int codigoCorrecto) {
        cajaFuerte.abrir(codigoCorrecto);
    }

    private void whenCierroLaCajaFuerte(CajaFuerte cajaFuerte, int codigo) {
        cajaFuerte.cerrar(codigo);
    }

    private CajaFuerte givenCreoUnaCajaFuerte() {
        return crearCajaFuerte();
    }

    private void thenLaCajaFuerteEstaCerrada(CajaFuerte cajaFuerte) {
        assertThat(cajaFuerte.estaCerrada()).isTrue();
    }

    private CajaFuerte whenCreoLaCajaFuerte() {
        return crearCajaFuerte();
    }

    private void thenLaCajaFuerteEstaAbierta(CajaFuerte cajaFuerte) {
        assertThat(cajaFuerte.estaAbierta()).isTrue();
    }

    private CajaFuerte crearCajaFuerte() {
        return new CajaFuerte();
    }

}
