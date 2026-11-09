public class Evento
{
private int proximoId;
private String nome;
private String local;
private String data;
private Ingresso[] ingressosVendidos;
private int capacidadeMaxima;
private double preco;
private int quantidadeVendida;
public Evento(String nome, String local, String data, int capacidadeMaxima, double preco)
{
    setNome(nome);
    setLocal(local);
    setData(data);
    setCapacidadeMaxima(capacidadeMaxima);
    setIngressosVendidos(ingressosVendidos);
    setPreco(preco);
    this.quantidadeVendida = 0;
    this.proximoId = 1;
}
//Setters
public void setNome(String nome) { this.nome = nome; }
public void setLocal(String local) { this.local = local; }
public void setData(String data) { this.data = data; }
public void setIngressosVendidos(Ingresso[] ingressosVendidos) { this.ingressosVendidos = new Ingresso[capacidadeMaxima]; }
public void setCapacidadeMaxima(int capacidadeMaxima) { this.capacidadeMaxima = capacidadeMaxima; }
public boolean setPreco(double preco) { if(quantidadeVendida > 0) {return false;} this.preco = preco; return true; }

//Getters
public String getNome() { return nome; }
public String getLocal() { return local; }
public String getData() { return data; }
public Ingresso[] getIngressosVendidos() { return ingressosVendidos; }
public int getCapacidadeMaxima() { return capacidadeMaxima; }
public double getPreco() { return preco; }
public int getQuantidadeVendida() { return quantidadeVendida; }


// Metodos

public boolean venderIngresso(Cliente cliente)
{
    if(quantidadeVendida >= capacidadeMaxima)
    {
        return false;
    }
    for(int i=0;i<quantidadeVendida;i++)
    {
        if(ingressosVendidos[i].getCliente().getCpf().equals(cliente.getCpf()))
        {
            return false;
        }
    }
    double valor = preco;
    if(cliente.getEstudante())
    {
        valor = preco / 2;
    }
    Ingresso ingresso = new Ingresso(proximoId, cliente, this, valor);
    proximoId++;
    ingressosVendidos[quantidadeVendida] = ingresso;
    quantidadeVendida++;
    return true;
}

public boolean cancelarIngresso(Cliente cliente)
{
    for(int i=0; i < quantidadeVendida; i++)
    {
        if(ingressosVendidos[i].getCliente().getCpf().equals(cliente.getCpf())) {ingressosVendidos[i].setStatus(false);
            for(int j = i; j < quantidadeVendida - 1; j++)
            {
                ingressosVendidos[j] = ingressosVendidos[j + 1];
            }
            quantidadeVendida--;
            return true;
        }
    }
    return false;
}
public int vagasRestantes()
{
    return capacidadeMaxima - quantidadeVendida;
}
public double totalArrecadado()
{
    double total = 0;
    for(int i = 0; i<quantidadeVendida;i++)
    {
        total += ingressosVendidos[i].getValorPago();
    }
    return total;
}
}