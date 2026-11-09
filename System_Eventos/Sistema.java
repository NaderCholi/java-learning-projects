public class Sistema
{
    private Cliente[] clientes;
    private int quantidadeClientes;
    private Evento[] eventos;
    private int quantidadeEventos;

    public Sistema()
    {
        clientes = new Cliente[200];
        eventos = new Evento[20];
        quantidadeClientes = 0;
        quantidadeEventos = 0;
    }
    public boolean cadastrarCliente(Cliente cliente)
    {
        if(quantidadeClientes >= clientes.length)
        {
            return false;
        }
        if(buscarCliente(cliente.getCpf()) != -1)
        {
            return false;
        }
        clientes[quantidadeClientes] = cliente;
        quantidadeClientes++;
        return true;
    }  
    public boolean cadastrarEvento(Evento evento)
    {
        if(quantidadeEventos >= eventos.length)
        {
            return false;
        }
        eventos[quantidadeEventos] = evento;
        quantidadeEventos++;
        return true;
    }
    public int buscarCliente(String cpf)
    {
        for(int i=0; i<quantidadeClientes; i++)
        {
            if(clientes[i].getCpf().equals(cpf))
            {
                return i;
            }
        }
        return -1;
    }
    public int buscarEvento(String nome)
    {
        for(int i=0; i<quantidadeEventos; i++)
        {
            if(eventos[i].getNome().equals(nome))
            {
                return i;
            }
        }
        return -1;
    }
    public boolean venderIngresso(String cpf, String nomeEvento)
    {
        int c = buscarCliente(cpf);
        int e = buscarEvento(nomeEvento);
        if(c == -1 || e == -1)
        {
            return false;
        }
        return eventos[e].venderIngresso(clientes[c]);
    }
    public boolean cancelarIngresso(String cpf, String nomeEvento)
    {
        int c = buscarCliente(cpf);
        int e = buscarEvento(nomeEvento);
        if(c == -1 || e == -1)
        {
            return false;
        }
        return eventos[e].cancelarIngresso(clientes[c]);
    }
    public void mostrarIngressosDoCliente(String cpf)
    {
        for(int i=0; i<quantidadeEventos; i++)
        {
            Ingresso[] ingressos = eventos[i].getIngressosVendidos();
            for(int j=0; j<eventos[i].getQuantidadeVendida(); j++)
            {
                if(ingressos[j].getCliente().getCpf().equals(cpf))
                {
                    System.out.println("Evento: " + eventos[i].getNome() + " | Ingresso " + ingressos[j].getId() + " | Valor pago: R$ " + ingressos[j].getValorPago());
                }
            }
        }
    }
    public double totalGeral()
    {
        double total = 0;
        for(int i = 0; i < quantidadeEventos; i++)
        {
            total = total + eventos[i].totalArrecadado();
        }
        return total;
    }
    public int vagasDoEvento(String nomeEvento)
    {
        int e = buscarEvento(nomeEvento);
            if(e == -1)
            {
                return -1;
            }
        return eventos[e].vagasRestantes();
    }
    public double totalDoEvento(String nomeEvento)
    {
        int e = buscarEvento(nomeEvento);
        if(e == -1)
        {
            return -1;
        }
        return eventos[e].totalArrecadado();
    }
}