package modelo;

public interface BaseEntityAssociativa {

    public Boolean keyExists();
    public String getStatus();
    public void setStatus(String status);
    public void print();
}
