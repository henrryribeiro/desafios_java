package entities;
import entities_enum.WorkerLevel;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class Worker {// criando a classe Worker

 //colocando os dados da classe
 private String name;
 private WorkerLevel level;
 private Double baseSalary;

 private Department departament; // associando o departamento ao trabalhador
 private List<HourContract> contracts = new ArrayList<>();//criando uma lista de contratos

    //criando o construtor da classe, sem colocar a lista para que não seja alterada
    public Worker(String name, WorkerLevel level, Double baseSalary, Department departament) {
        this.name = name;
        this.level = level;
        this.baseSalary = baseSalary;
        this.departament = departament;
    }
    // criando os getter e setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WorkerLevel getLevel() {
        return level;
    }

    public void setLevel(WorkerLevel level) {
        this.level = level;
    }

    public Double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(Double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public Department getDepartament() {
        return departament;
    }

    public void setDepartament(Department departament) {
        this.departament = departament;
    }

    public List<HourContract> getContracts() {
        return contracts;
    }

    public void addContract(HourContract contract) { // metodo que adiciona contratos a minha lista
        contracts.add(contract);
    }
    public void removeContract(HourContract contract) { // metodo que remove contratos da minha lista
        contracts.remove(contract);
    }
    public double income(int year, int month) { // operação para calcular quanto um funcionario ganhou, baseado em um ano e um mes
        double sum = baseSalary;// variavel soma que recebe o salario base do funcionario
        Calendar cal = Calendar.getInstance();
        for (HourContract c : contracts)  {//looping que verifica se o contrato é deste ano e do mesmo mês, se for adiciona ele na soma
            cal.setTime(c.getDate());// função que pega a data do contrato e define como a data do calendario
            int c_year = cal.get(Calendar.YEAR);// função que pega o ano da data
            int c_month = 1 + cal.get(Calendar.MONTH);//função que pega o mês da data
            if (year == c_year && month == c_month){// condição que verifica se o contrato é deste mês e deste ano
                sum += c.totalValue();
            }
        }
        return sum;
    }
}
