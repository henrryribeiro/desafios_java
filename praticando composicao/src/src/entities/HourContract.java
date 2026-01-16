package entities;

import java.util.Date;

public class HourContract { // criando a classe contrato por hora


    private Date date;   //colocando os atributos da classe
    private Double valuePerHour;
    private Integer hours;

    public HourContract(Date date, Double value, Integer hours) {
        this.date = date;
        this.valuePerHour = value;
        this.hours = hours;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getValuePerHour() {
        return valuePerHour;
    }

    public void setValuePerHour(Double valuePerHour) {
        this.valuePerHour = valuePerHour;
    }

    public Integer getHours() {
        return hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    public double totalValue() { // essa operação multiplica o valor por hora pela quantidade de horas
        return valuePerHour * hours;
    }
}
