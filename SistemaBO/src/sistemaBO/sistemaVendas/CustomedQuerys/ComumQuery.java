/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaBO.sistemaVendas.CustomedQuerys;

/**
 *
 * @author Ricardo
 */
public class ComumQuery {
    
    public static final String TODAS_PESSOAS   = "SELECT t FROM TbAdmPessoa  t";
    public static final String TODOS_PRODUTOS  = "SELECT p FROM TbAdmProduto p";
    
    public static String query_todos_produtos () {
        
        String retorno = "SELECT p FROM TbAdmProduto p ";
        //retorno+= "where (:produto is null or p.codigoProduto = :codigo_produto)  ";
        //retorno+= "where p.codigoProduto = case when :codigo_produto = 0  then p.codigoProduto else :codigo_produto end  ";
        retorno+= "where p.nomeProduto like (case when :nome = '' then p.nomeProduto else :nome end) ";
        
        
                
                
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        

        
        
        return retorno;
    }
    
    
    
}
