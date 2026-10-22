package siga;

public class OuvinteEstatistica implements OuvinteMatricula {
    @Override 
    public void aoMatricular(Matricula matricula, boolean turmaLotada) {
        System.out.println("   [estatistica] ocupacao computada para " + matricula.getCodigoTurma());
    }
}
