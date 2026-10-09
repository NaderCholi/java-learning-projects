public class ContaBancaria {
    private String titular;
    private long idConta;
    private double saldo;

    public ContaBancaria(String titular, long idConta, double saldo) {
        this.titular = titular;
        this.idConta = idConta;
        this.saldo = Math.max(saldo, 0.0);
    }

    public String getTitular() {
        return titular;
    }

    public long getIdConta() {
        return idConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
        }
    }

    public void sacar(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
        }
    }

    public void exibirConta() {
        System.out.println("O titular da conta " + getIdConta()
                + " é: " + getTitular()
                + " e seu saldo atual é: " + getSaldo());
    }
}