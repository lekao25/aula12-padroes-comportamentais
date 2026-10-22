package siga;

public class OuvintePainel implements OuvinteMatricula {
    private final PainelVagas painel = new PainelVagas();
    
    @Override 
    public void aoMatricular(Matricula matricula, boolean turmaLotada) {
        painel.atualizar(matricula.getCodigoTurma());
    }
}
