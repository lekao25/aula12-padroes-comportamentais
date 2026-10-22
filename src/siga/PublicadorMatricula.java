package siga;

import java.util.ArrayList;
import java.util.List;

public class PublicadorMatricula {
    private final List<OuvinteMatricula> ouvintes = new ArrayList<>();

    public void registrar(OuvinteMatricula ouvinte) { ouvintes.add(ouvinte); }
    public void remover(OuvinteMatricula ouvinte) { ouvintes.remove(ouvinte); }

    public void publicar(Matricula matricula, boolean turmaLotada) {
        // Cópia da lista evita erros se ouvintes forem adicionados ou removidos no meio do laço
        List<OuvinteMatricula> copia = new ArrayList<>(ouvintes);
        for (OuvinteMatricula ouvinte : copia) {
            try {
                ouvinte.aoMatricular(matricula, turmaLotada);
            } catch (Exception e) {
                System.out.println("   [erro no ouvinte] " + e.getMessage());
            }
        }
    }
}
