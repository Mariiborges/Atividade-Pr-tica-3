public class Desenvolvedor extends Funcionario {
    private String[] tecnologias;

    public Desenvolvedor(String nome, int matricula, String[] tecnologias) {
        super(nome, matricula, "Desenvolvedor");
        this.tecnologias = tecnologias;
    }

    @Override
    public double calcularSalario() {
        
        return 6000 + (tecnologias.length * 1000); //Salário base definido: 6k + 1k por cada tecnologia dominada
    }

    @Override
    public void trabalhar() {
        System.out.println("Desenvolvedor trabalhando...");
    }

    @Override
    public void relatarProgresso() {
        System.out.println("Progresso relatado pelo desenvolvedor.");
    }
}
