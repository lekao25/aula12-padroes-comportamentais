package siga;

public class OuvinteAuditoria implements OuvinteMatricula {
    private final RegistroAuditoria auditoria = new RegistroAuditoria();
    
    @Override 
    public void aoMatricular(Matricula matricula, boolean turmaLotada) {
        auditoria.registrar("MATRICULA", matricula.getAluno().getMatricula());
    }
}
