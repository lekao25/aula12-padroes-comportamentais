package siga;

public class OuvinteEmail implements OuvinteMatricula {
    private final NotificadorEmail notificador = new NotificadorEmail();
    
    @Override 
    public void aoMatricular(Matricula matricula, boolean turmaLotada) {
        notificador.enviarConfirmacao(matricula);
    }
}
