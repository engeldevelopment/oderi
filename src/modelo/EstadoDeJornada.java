
package modelo;

public enum EstadoDeJornada {
    
    SIN_INICIAR(0), EN_CURSO(1), CERRADA(2);
    
    private int valor;

    EstadoDeJornada(int valor) {
        this.valor = valor;
    }
    
    public int Valor() {
        return valor;
    }
}
