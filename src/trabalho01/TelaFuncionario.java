/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho01;


import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;
/**
 *
 * @author Guilherme
 */
public class TelaFuncionario {

    private Scanner sc;
    private ControladorFuncionario owner;
    private static TelaFuncionario instance;
    
    
    public TelaFuncionario(){
        this.sc = new Scanner(System.in);
        this.owner = ControladorFuncionario.getInstance();
    }
    
    public static TelaFuncionario getInstance() {
        if(instance == null) {
            instance = new TelaFuncionario();
        }
        return instance;
    }
    
    public void exibeTela() {
        int opcao = 0;        
        do{
            System.out.println("\nMenu dos Funcionarios!");;
            System.out.println("-----------------------------------");
            System.out.println("1 - Cadastrar um novo funcionario");
            System.out.println("2 - Alterar o cargo de um funcionario pela sua matricula");
            System.out.println("3 - Deletar funcionario pela matricula");
            System.out.println("4 - Lista de todos os funcionarios");            
            System.out.println("0 - Voltar");
            System.out.println("Selecione uma opção:");
            opcao = sc.nextInt();
            trataOpcao(opcao);
        } while(opcao != 0);     
        System.exit(0);
        
    }
    
    public void trataOpcao(int opcao){
        switch(opcao){
        case 1:
            cadastraFuncionario();
            break;
        case 2:
            alteraCargoFuncionario();
            break;
        case 3:
            deletarFuncionario();
            break;
        case 4:
            owner.getFuncionarios();
            break;
        default:
            break;
        }
    }
    
    public void cadastraFuncionario() throws ParseException{
        System.out.println("Digite o nome do Funcionario");
            String nome = sc.nextLine();
            
            System.out.println("Digite a data de nascimento do Funcionario"+
                                "\n__/__/____");
            String dataNascimento = sc.nextLine();
            owner.converterData(dataNascimento);
            
            System.out.println("Digite o telefone do Funcionario");
            int telefone = sc.nextInt();
            
            System.out.println("Digite o salario do Funcionario");
            double salario = sc.nextDouble();
            
            System.out.println("Digite o codigo do cargo do Funcionario");
            ControladorCargo.getInstance().exibeCargos();
            int codigo = sc.nextInt();
            Cargo cargo = ControladorCargo.getInstance().buscarCargoPeloCodigo(codigo);
            if(cargo == null){
                new Exception ("Codigo invalido");
            }
                        
            System.out.println("Digite o cpf do Funcionario");
            int cpf = sc.nextInt();
            
            owner.cadastrarFuncionario(nome, dataNascimento, telefone, salario, cargo, cpf);
    }
    
    public void alteraCargoFuncionario() throws CadastroIncorretoException{
        System.out.println("Digite a matricula do Funcionario que deseja alterar o Cargo");
        int matricula = sc.nextInt();
        Funcionario func = owner.buscarFuncionarioPelaMatricula(matricula);
        if(func != null){
            System.out.println("Digite o codigo do cargo do Funcionario");
            ControladorCargo.getInstance().exibeCargos();
            int codigo = sc.nextInt();
            Cargo cargo = ControladorCargo.getInstance().buscarCargoPeloCodigo(codigo);
                if(cargo == null){
                    new Exception ("Codigo invalido");
                }else{
                    owner.alterarCargoFuncionarioPelaMatricula(matricula, cargo);
                }  
        }else if(func == null){
                new CadastroIncorretoException("Esse funcionario não existe no nosso sistema");
        }
    }
    
    public void deletarFuncionario() throws CadastroIncorretoException{
        System.out.println("Digite a matricula do Funcionario que deseja deletar");
        int matricula = sc.nextInt();
        Funcionario func = owner.buscarFuncionarioPelaMatricula(matricula);
        if(func != null){
            owner.deletarFuncionarioPelaMatricula(func);
        }else if(func == null){
            new CadastroIncorretoException("Esse funcionario não existe no nosso sistema");
        }
    }
}
    

