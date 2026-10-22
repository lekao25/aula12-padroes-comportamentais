package siga;

public class OuvinteCoordenacao implements OuvinteMatricula {
    private final AvisoCoordenacao aviso = new AvisoCoordenacao();
    
    @Override 
    public void aoMatricular(Matricula matricula, boolean turmaLotada) {
        if (turmaLotada) {
            aviso.enviar(matricula.getCodigoTurma());
        }
    }
}
