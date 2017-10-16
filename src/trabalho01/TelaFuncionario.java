/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho01;


import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
/**
 *
 * @author Guilherme
 */
public class TelaFuncionario {

    private Scanner sc;
    private static TelaFuncionario instance;
    
    
    public TelaFuncionario(){
        this.sc = new Scanner(System.in);
    }
    
    public static TelaFuncionario getInstance() {
        if(instance == null) {
            instance = new TelaFuncionario();
        }
        return instance;
    }
    
    /**
     * Exibe tela funcionario
     * @throws ParseException
     * @throws CadastroIncorretoException
     * @throws FuncionarioComCargoException
     * @throws Exception 
     */
    public void exibeTela() throws ParseException, CadastroIncorretoException, FuncionarioComCargoException, Exception {
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
            while (!sc.hasNextInt()) sc.next();
            opcao = sc.nextInt();
            trataOpcao(opcao);
        } while(opcao != -1);     
        
    }
    
    /**
     * Trata opção da tela
     * @param opcao
     * @throws ParseException
     * @throws CadastroIncorretoException
     * @throws FuncionarioComCargoException
     * @throws Exception 
     */
    public void trataOpcao(int opcao) throws ParseException, CadastroIncorretoException, FuncionarioComCargoException, Exception{
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
            listarFuncionarios();
            break;
        case 0:
            ControladorPrincipal.getInstance().exibeTelaPrincipal();
            break;
        default:
            break;
        }
    }
    
    /**
     * Lista os funcionários
     * @throws CadastroIncorretoException 
     */
    private void listarFuncionarios() throws CadastroIncorretoException {
        ArrayList<Funcionario> funcionarios = ControladorFuncionario.getInstance().getFuncionarios();
        if (funcionarios.isEmpty())
            System.out.println("Não existe nenhum funcionário cadastrado");
        for (Funcionario funcRef : funcionarios) {
            System.out.println("Matricula: " + funcRef.getMatricula()+" Cargo: "+funcRef.getCargo().getNomeCargo()+" Nome: "+funcRef.getNome());
        }
    }
    
    /**
     * Cadastra um funcionário
     * @throws ParseException
     * @throws CadastroIncorretoException
     * @throws FuncionarioComCargoException
     * @throws Exception 
     */
    public void cadastraFuncionario() throws ParseException, CadastroIncorretoException, FuncionarioComCargoException, Exception{
        try {    
            if(!ControladorCargo.getInstance().getCargos().isEmpty()) {
                System.out.println("Digite o nome do Funcionario");
                sc.nextLine();
                String nome = sc.nextLine();

                System.out.println("Digite a data de nascimento do Funcionario"+
                                    "\n__/__/____");
                String dataNascimento = sc.nextLine();
                ControladorFuncionario.getInstance().converterData(dataNascimento);

                System.out.println("Digite o telefone do Funcionario");
                while (!sc.hasNextDouble()) sc.next();
                double telefone = sc.nextDouble();

                System.out.println("Digite o salario do Funcionario");
                while (!sc.hasNextDouble()) sc.next();
                double salario = sc.nextDouble();

                ControladorCargo.getInstance().exibeCargos();
                System.out.println("Escolha o cargo do funcionário utilizando um dos códigos acima");
                
                
                while (!sc.hasNextInt()) sc.next();
                int codigo = sc.nextInt();
                Cargo cargo = ControladorCargo.getInstance().buscarCargoPeloCodigo(codigo);
                System.out.println("Digite o cpf do Funcionario");
                while (!sc.hasNextDouble()) sc.next();
                double cpf = sc.nextDouble();

                ControladorFuncionario.getInstance().cadastrarFuncionario(nome, dataNascimento, telefone, salario, cargo, cpf);

                System.out.println("Funcionário cadastrado com sucesso");
            } else {
                System.out.println("Não há cargos cadastrados");
                exibeTela();
            } 
        } catch (Exception e) {
            System.out.println("Formato Incorreto de Preenchimento");
            return;
        }   
    }
    
    /**
     * Altera o cargo de um funcionário
     * @throws CadastroIncorretoException
     * @throws Exception 
     */
    public void alteraCargoFuncionario() throws CadastroIncorretoException, Exception{
        System.out.println("Digite a matricula do Funcionario que deseja alterar o Cargo");
        while (!sc.hasNextInt()) sc.next();
        int matricula = sc.nextInt();
        Funcionario func = ControladorFuncionario.getInstance().buscarFuncionarioPelaMatricula(matricula);
        if(func != null){
            ControladorCargo.getInstance().exibeCargos();
            System.out.println("Digite o codigo do novo cargo do Funcionario");
            while (!sc.hasNextInt()) sc.next();
            int codigo = sc.nextInt();
            Cargo cargo = ControladorCargo.getInstance().buscarCargoPeloCodigo(codigo);
                if(cargo != null){
                    ControladorFuncionario.getInstance().alterarCargoFuncionarioPelaMatricula(matricula, cargo);
                    System.out.println("Cargo alterado com sucesso ");
                }else{
                    new Exception ("Codigo invalido");
                }  
        }else if(func == null){
                new CadastroIncorretoException("Esse funcionario não existe no nosso sistema");
        }
    }
    
    /**
     * Deleta um funcionário
     * @throws CadastroIncorretoException 
     */
    public void deletarFuncionario() throws CadastroIncorretoException, Exception{
        System.out.println("Digite a matricula do Funcionario que deseja deletar");
        while (!sc.hasNextInt()) sc.next();
        int matricula = sc.nextInt();
        Funcionario func = ControladorFuncionario.getInstance().buscarFuncionarioPelaMatricula(matricula);
        try {
            ControladorFuncionario.getInstance().deletarFuncionarioPelaMatricula(func);
        } catch (Exception e){
            new CadastroIncorretoException("Esse funcionario não existe no nosso sistema");
            return;
        }
    }
    
    /**
     * Imprime uma mensagem de funcionário bloqueado
     */
    public void mensagemFuncionarioBloqueado() {
        System.out.println("Após três acessos negados esse funcionário foi bloqueado");
    }

    /**
     * Imprime uma mensagem de funcionário deletado com sucesso
     */
    public void mensagemFuncionarioDeletadoComSucesso() {
        System.out.println("\nFuncionário deletado com sucesso");
    }

    /**
     * Imprime a mensagem de matrícula inválida
     */
    public void mensagemMatriculaInvalida() {
        System.out.println("Matrícula Invalida");
    }
}
    

