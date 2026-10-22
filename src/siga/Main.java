package siga;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== SIGA - Aula 12: Strategy e Observer ===");

        Aluno bolsista = new Aluno("2024001", "Maria Silva");
        bolsista.setBolsista(true);

        Aluno egresso = new Aluno("2024003", "Ana Pereira");
        egresso.setEgresso(true);

        double valorBase = 800.00;
        GeradorBoleto gerador = new GeradorBoleto();

        System.out.println("\n1) Strategy: Ana pagando o mesmo valor na matricula e no boleto");
        PoliticaDesconto polBolsista = new DescontoBolsista();
        PoliticaDesconto polEgresso = new DescontoEgresso();

        Matricula m1 = new Matricula(bolsista, "DSM-2A", polBolsista);
        System.out.printf("   %-14s matricula: R$ %.2f%n", bolsista.getNome(), m1.calcularValor(valorBase));
        gerador.emitir(bolsista, valorBase, polBolsista);

        Matricula m2 = new Matricula(egresso, "DSM-2B", polEgresso);
        System.out.printf("   %-14s matricula: R$ %.2f%n", egresso.getNome(), m2.calcularValor(valorBase));
        gerador.emitir(egresso, valorBase, polEgresso);

        System.out.println("\n2) Observer: Quinta reacao (Estatistica) e Falha isolada");
        PublicadorMatricula publicador = new PublicadorMatricula();
        publicador.registrar(new OuvinteEmail());
        publicador.registrar(new OuvintePainel());
        publicador.registrar(new OuvinteCoordenacao()); // Este falhará na turma lotada
        publicador.registrar(new OuvinteAuditoria());
        publicador.registrar(new OuvinteEstatistica()); // Nova reação sem alterar Fachada

        FachadaMatricula fachada = new FachadaMatricula(publicador);
        
        System.out.println("   --- Matricula Turma normal ---");
        fachada.matricular(bolsista, "DSM-2A", false, polBolsista);

        System.out.println("\n   --- Matricula Turma lotada (Aviso falhara, mas auditoria acontece) ---");
        fachada.matricular(egresso, "DSM-2B", true, polEgresso);
    }
}
