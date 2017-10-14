/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho01;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Guilherme
 */
public class TelaCargo {
    
    private ControladorCargo owner;
    private Scanner sc;
    

    public TelaCargo(ControladorCargo owner) {
	this.owner = owner;
	this.sc = new Scanner(System.in);
    }
    
    
   
    
    public void exibeTela() throws CadastroIncorretoException{
        int opcao = 0;        
        do{
            System.out.println("\nMenu dos Funcionarios!");;
            System.out.println("-----------------------------------");
            System.out.println("1 - Cadastrar um novo cargo");
            System.out.println("2 - Alterar o nome do cargo pelo codigo");
            System.out.println("3 - Deletar cargo pelo codigo");
            System.out.println("4 - Lista de todos os cargos"); 
            System.out.println("5 - Buscar cargo pelo codigo"); 
            System.out.println("0 - Encerrar");
            System.out.println("Selecione uma opção:");
            opcao = sc.nextInt();
            trataOpcao(opcao);
        } while(opcao != 0);     
        System.exit(0);
    }
    public void trataOpcao(int opcao) throws CadastroIncorretoException{
        switch(opcao){
        case 1:
            telaCadastraCargo();
        case 2:
            telaAlterarNomeCargo();
            break;
        case 3:
            telaAlterarNomeCargo();
            break;
        case 4:
            this.owner.exibeCargos();
            break;
        case 5:
            telaExibeCargoPeloCodigo();
            break;
        default:
            break;
        }
    }
    public void telaExibeCargoPeloCodigo(){
        System.out.println("\nBem vindo a tela de buscar cargo");
        System.out.println("\nDigite o código do cargo desejado");
        int codigo = this.sc.nextInt();
        Cargo cargoASerExibido = this.owner.buscarCargoPeloCodigo(codigo);
        if (cargoASerExibido == null){
            System.out.println("\nCargo inexistente");
        } else {
            exibeCargo(cargoASerExibido);
        }
    }
           
    public void telaAlterarNomeCargo() {
        try {
            System.out.println("\nBem vindo a tela de alterar nome do cargo");
            System.out.println("\nInsira o codigo do cargo que deseja mudar o nome");
            int codigo = this.sc.nextInt();
            Cargo cargoAAlterarNome = this.owner.buscarCargoPeloCodigo(codigo);
            if (cargoAAlterarNome == null) {
                System.out.println("Cargo inexistente");
            } else{
                System.out.println("\nDigite o novo nome do cargo");
                String novoNomeCargo = this.sc.nextLine();
                this.owner.alterarNomeCargoPeloCodigo(novoNomeCargo, codigo);
            }
            
        } catch (Exception e) {
            System.out.println("\nFormato incorreto de preenchimento");
        }
        
    }
    
    public void telaDeletaCargo() {
	try {
            if (!this.owner.haCargos()) {
		return;
            }
            System.out.println("\nBem vindo a tela de remocao de cargos");
            System.out.println("\nInsira o codigo do cargo a ser deletado");
            int codigo = this.sc.nextInt();
            Cargo cargoARemover = this.owner.buscarCargoPeloCodigo(codigo);
            if (cargoARemover == null) {
                System.out.println("\nCargo inexistente");
            } else {
                this.owner.deletarCargoPeloCodigo(codigo);
            }
        } catch (Exception e) {
            System.out.println("\nFormato incorreto de preenchimento");
            this.sc.nextLine();
            return;
        }

    }
    
    public void mensagemNaoHaCargos() {
		System.out.println("Nao ha cargos cadastrados\n");
	}
    
    
    public void telaCadastraCargo() throws CadastroIncorretoException {
		try {

			ArrayList<Cargo> cargo = new ArrayList<>();
			System.out.println("\nBem vindo a tela de cadastro de cargo");
			System.out.println("\nInsira o nome do cargo");
			String nomeCargo = this.sc.next();
                        
                        System.out.println("\nInsira o nível do cargo");
			System.out.println("0.Livre");
			System.out.println("1.Especial");
                        System.out.println("2.Comum");
                        System.out.println("3.Nulo");

			int selecaoNivel = this.sc.nextInt();
			NivelAcesso NIVELACESSO = NivelAcesso.COMUM;
			while (selecaoNivel != 2) {
				if (selecaoNivel == 1) {
					NIVELACESSO = NivelAcesso.ESPECIAL;
					break;
				} else if (selecaoNivel == 0) {
					NIVELACESSO = NivelAcesso.LIVRE;
					break;
				} else if (selecaoNivel == 3) {
					NIVELACESSO = NivelAcesso.NULO;
					break;
				}
				selecaoNivel = this.sc.nextInt();

			}
			
			String opt = "";

			while (!opt.equals("N") && NIVELACESSO != NivelAcesso.LIVRE && NIVELACESSO != NivelAcesso.NULO) {
				System.out.println("Quer adicionar um horário que o cargo pode realizar?");
				System.out.println("Digite 'S' para Sim");
				System.out.println("Digite 'N' para Não");
				opt = this.sc.next();
				if (opt.equals("N")) {
					break;
				}
				System.out.println("Digite a hora inicial: (Horas:Minutos)");
				opt = this.sc.next();
                                System.out.println("Digite a hora final: (Horas:Minutos)");
                                opt = this.sc.next();
				Veiculo v = this.owner.pegaVeiculo(opt);
				if (v != null) {
					tiposDeVeiculo.add(v);
				} else {
					System.out.println("Veículo Inexistente");
				}
			}

			this.owner.cadastraCargo(nomeCargo, NIVELACESSO);
                        
		} catch (Exception e) {
			System.out.println("Formato Incorreto de Preenchimento");
			this.sc.nextLine();
			return;
		}
    }
    public void exibeCargo(Cargo cargo) {
		System.out.println("-----------------------------");
		System.out.println("Nome do cargo: " + cargo.getNomeCargo() + " \nNumero do codigo: " + cargo.getCodigo());
    }
}
