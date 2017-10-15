/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho01;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Guilherme
 */
public class ControladorPrincipal {
    
    private static ControladorPrincipal instance;
    
    private ControladorFuncionario ctrlFuncionario;
    private ControladorCargo ctrlCargo;
    private ControladorAcesso ctrlAcesso;
    private ControladorRelatorio ctrlRelatorio;
    private TelaPrincipal tela;
    private Scanner sc;
    private Date horarioDoSistema;
    
    private ControladorPrincipal (){
        this.tela = new TelaPrincipal();
        this.ctrlCargo = ControladorCargo.getInstance();
        this.sc = new Scanner(System.in);
        this.horarioDoSistema = new Date();
    }
    
    
    public static ControladorPrincipal getInstance() {
        if(instance == null) {
            instance = new ControladorPrincipal();
        }
        
        return instance;
    }
    
    public void exibeTelaFuncionario() {
        ctrlFuncionario.exibeTelaFuncionario();
    }

    public void exibeTelaCargo() throws CadastroIncorretoException {
        ctrlCargo.exibeTelaCargo();
    }

    public void exibeTelaAcesso() {
        ctrlAcesso.exibeTelaAcesso();
    }

    public void exibeTelaRelatório() {
        ControladorRelatorio.getInstance().exibeTelaRelatorio();
    }
    
    public void exibeTelaPrincipal() throws CadastroIncorretoException {
        tela.exibeTela();
    }
    
    /*public void horarioDoSistema() {
        System.out.println("Seja bem vindo, para iniciar o sistema digite o horario dele: (HH:mm)");
        String horario = sc.nextLine();
        try {
            horarioDoSistema = converterStringEmHora(horario);
        } catch (ParseException ex) {
            new Exception("Horário Inválido");
        }
        setHorarioDoSistema(horarioDoSistema);
        
    }
    */
    public Date getHorarioDoSistema() {
        return horarioDoSistema;
    }
    
    public void setHorarioDoSistema(Date horarioDoSistema) {
        this.horarioDoSistema = horarioDoSistema;
    }
    
    public Date converterStringEmHora(String hora) throws ParseException{
        SimpleDateFormat horaSimples = new SimpleDateFormat("HH:mm");
        Date horaConvertida = new Date();
        try {
            horaConvertida = horaSimples.parse(hora);
        } catch (ParseException e) {
            System.err.println("Horário Inválido");;
        }
        return horaConvertida;
    }
    
    public String converterHoraEmString (Date date) {
        SimpleDateFormat horaSimples = new SimpleDateFormat("HH:mm");
        String horaEmString = horaSimples.format(date);
        return horaEmString;
    }
    
    public void horarioDoSistema() throws Exception {
        System.out.println("Seja bem vindo, para iniciar o sistema digite o horario dele:");
        System.out.println("Ano:");
        int ano = sc.nextInt()-1900;
        System.out.println("Mes:");
        int mes = sc.nextInt();
        System.out.println("Dia:");
        int dia = sc.nextInt();
        System.out.println("Hora:");
        int hora = sc.nextInt();
        System.out.println("Minuto:");
        int minuto = sc.nextInt();
        
        try {
            horarioDoSistema = new Date(ano, mes, dia, hora, minuto);
        } catch (Exception e) {
            new Exception("Horário Inválido");
        }
        setHorarioDoSistema(horarioDoSistema);
        
    }
}
