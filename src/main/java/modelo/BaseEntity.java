package modelo;

public interface BaseEntity {
    public Integer getId();

    public String getStatus();
    public void setStatus(String status);

    public void print();
    public void printLegenda();

}
