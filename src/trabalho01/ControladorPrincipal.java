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
    
    private Scanner sc;
    private Date horarioDoSistema;
    
    private ControladorPrincipal (){
        this.sc = new Scanner(System.in);
        this.horarioDoSistema = new Date();
    }
    
    public static ControladorPrincipal getInstance() {
        if(instance == null) {
            instance = new ControladorPrincipal();
        }
        
        return instance;
    }
    
    /**
     * Exibe a tela de funcionarios
     * @throws ParseException
     * @throws CadastroIncorretoException
     * @throws FuncionarioComCargoException
     * @throws Exception 
     */
    public void exibeTelaFuncionario() throws ParseException, CadastroIncorretoException, FuncionarioComCargoException, Exception {
        ControladorFuncionario.getInstance().exibeTelaFuncionario();
    }

    /**
     * Exibe a tela de cargos
     * @throws CadastroIncorretoException
     * @throws FuncionarioComCargoException
     * @throws ParseException
     * @throws Exception 
     */
    public void exibeTelaCargo() throws CadastroIncorretoException, FuncionarioComCargoException, ParseException, Exception {
        ControladorCargo.getInstance().exibeTelaCargo();
    }

    /**
     * Exibe a tela de acesso
     * @throws ParseException
     * @throws CadastroIncorretoException
     * @throws FuncionarioComCargoException
     * @throws Exception 
     */
    public void exibeTelaAcesso() throws ParseException, CadastroIncorretoException, FuncionarioComCargoException, Exception {
        ControladorAcesso.getInstance().exibeTelaAcesso();
    }

    /**
     * Exibe a tela de relatório
     * @throws CadastroIncorretoException
     * @throws ParseException
     * @throws FuncionarioComCargoException
     * @throws Exception 
     */
    public void exibeTelaRelatório() throws CadastroIncorretoException, ParseException, FuncionarioComCargoException, Exception {
        ControladorRelatorio.getInstance().exibeTelaRelatorio();
    }
    
    /**
     * Exibe a tela principal
     * @throws CadastroIncorretoException
     * @throws ParseException
     * @throws FuncionarioComCargoException
     * @throws Exception 
     */
    public void exibeTelaPrincipal() throws CadastroIncorretoException, ParseException, FuncionarioComCargoException, Exception {
        TelaPrincipal.getInstance().exibeTela();
    }
    
    public Date getHorarioDoSistema() {
        return horarioDoSistema;
    }
    
    public void setHorarioDoSistema(Date horarioDoSistema) {
        this.horarioDoSistema = horarioDoSistema;
    }
    
    /**
     * Converte um string em hora do tipo Date
     * @param hora
     * @return retorna um Date
     * @throws ParseException 
     */
    public Date converterStringEmHora(String hora) throws ParseException{
        SimpleDateFormat horaSimples = new SimpleDateFormat("HH:mm");
        Date horaConvertida = new Date();
        try {
            horaConvertida = horaSimples.parse(hora);
        } catch (ParseException e) {
            throw new ParseException("horario errado", 12);

        }
        return horaConvertida;
    }
    
    /**
     * Converte Date em uma hora do tipo string
     * @param date
     * @return retorna uma hora formatada em string
     */
    public String converterHoraEmString (Date date) {
        SimpleDateFormat horaSimples = new SimpleDateFormat("HH:mm");
        String horaEmString = horaSimples.format(date);
        return horaEmString;
    }
    
    /**
     * Metodo utilizado para controlar o horário do sistema
     * @throws Exception 
     */
    public void horarioDoSistema() throws Exception {
        
        System.out.println("\nDigite o horário do sistema:");
        System.out.println("Ano:");
        while (!sc.hasNextInt()) sc.next();
        int ano = sc.nextInt()-1900;
        System.out.println("Mes:");
        while (!sc.hasNextInt()) sc.next();
        int mes = sc.nextInt();
        System.out.println("Dia:");
        while (!sc.hasNextInt()) sc.next();
        int dia = sc.nextInt();
        System.out.println("Hora:");
        while (!sc.hasNextInt()) sc.next();
        int hora = sc.nextInt();
        System.out.println("Minuto:");
        while (!sc.hasNextInt()) sc.next();
        int minuto = sc.nextInt();
        
        try {
            horarioDoSistema = new Date(ano, mes, dia, hora, minuto);
        } catch (Exception e) {
            new Exception("Horário Inválido");
        }
        setHorarioDoSistema(horarioDoSistema);
        
    }
}
