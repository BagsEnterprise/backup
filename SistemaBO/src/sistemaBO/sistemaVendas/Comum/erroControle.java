/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaBO.sistemaVendas.Comum;

/**
 *
 * @author Ricardo
 */
public class erroControle {
    
    public static int     codErro;
    public static String  DescricaoErro = ComumSistemaBO.MENSAGEM_SUCESSO ;
    
    
    public static enum tipoAlertaDescricao {
         Erro (1), Informacao(1), Alerta (2) , Questao (3),  MensagemPlana (4);
         
         //ERROR_MESSAGE, INFORMATION_MESSAGE, WARNING_MESSAGE, QUESTION_MESSAGE, or PLAIN_MESSAGE
         
         public int tipoAlertaValor; 
 
         
         tipoAlertaDescricao(int valor) 
         {
             tipoAlertaValor = valor; 
         }

         public int getValor(){
		return tipoAlertaValor;
	}


         
    }
    
    public static tipoAlertaDescricao tipoAlerta;
    
    
    
    
    
}


