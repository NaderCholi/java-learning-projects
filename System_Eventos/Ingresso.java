public class Ingresso
{
private int id;
private Cliente cliente;
private Evento evento;
private double valorPago;
private boolean status;
public Ingresso(int id, Cliente cliente, Evento evento, double valorPago)
{
    this.id = id;
    this.cliente = cliente;
    this.evento = evento;
    this.valorPago = valorPago;
    this.status = true;
}
//Setters
public void setStatus(boolean status) { this.status = status; }

//Getters
public int getId() { return id; }
public Cliente getCliente() { return cliente; }
public Evento getEvento() { return evento; }
public double getValorPago() { return valorPago; }
public boolean getStatus() { return status; }

}