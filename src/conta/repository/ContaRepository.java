package conta.repository;
import conta.Conta;

public interface ContaRepository {

    void salvar(Conta conta);
    void excluir(int numero);
    Conta consultar(int numero);
    Conta[] consultarTodas();
}