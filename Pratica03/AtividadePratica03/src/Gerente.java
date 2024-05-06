public class Gerente extends Funcionario {
    private double bonusAnual;
    private String equipe;

    public Gerente(String nome, int matricula, String equipe, double bonusAnual) {
        super(nome, matricula, "Gerente");
        this.equipe = equipe;
        this.bonusAnual = bonusAnual;
    }

    @Override
    public double calcularSalario() {
        return 5000; //salário base proposto: 5k
    }

    @Override
    public void trabalhar() {
        System.out.println("Gerente trabalhando...");
    }

    @Override
    public void relatarProgresso() {
        System.out.println("Progresso relatado pelo gerente.");
    }
}
