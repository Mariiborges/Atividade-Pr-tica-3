public class Estagiario extends Funcionario {
    private int horasTrabalhadas;
    private String supervisor;

    public Estagiario(String nome, int matricula, int horasTrabalhadas, String supervisor) {
        super(nome, matricula, "Estagiario");
        this.horasTrabalhadas = horasTrabalhadas;
        this.supervisor = supervisor;
    }

    @Override
    public double calcularSalario() {
        return horasTrabalhadas * 10;//valor hora definido: 10 reais
    }

    @Override
    public void trabalhar() {
        System.out.println("Estagiário trabalhando...");
    }

    @Override
    public void relatarProgresso() {
        System.out.println("Progresso relatado pelo estagiário.");
    }
}
