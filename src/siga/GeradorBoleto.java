package siga;

public class GeradorBoleto {
    public double calcularValorDoBoleto(double valorBase, PoliticaDesconto politica) {
        return politica.aplicar(valorBase);
    }

    public void emitir(Aluno aluno, double valorBase, PoliticaDesconto politica) {
        double valor = calcularValorDoBoleto(valorBase, politica);
        System.out.printf("   [boleto] %s: R$ %.2f%n", aluno.getNome(), valor);
    }
}
