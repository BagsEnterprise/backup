package sistemaBO.sistemaVendas.Dao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ricardo
 */

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import sistemaBO.sistemaVendas.Comum.ComumSistemaBO;

import sistemaBO.sistemaVendas.Comum.erroControle;
import sistemaBO.sistemaVendas.CustomedQuerys.ComumQuery;
import sistemaBO.sistemaVendas.entity.TbAdmProduto;



public class TbAdmProdutoDao extends erroControle {

    final static String NOME_PERSISTENCE_XML =  ComumSistemaBO.nomePersistencia; //  persistence.xml
    
    
    public static TbAdmProduto pesquisar(Long codigo)  {

       //String nomePersistenceXML =  ComumSistemaBO.nomePersistencia; //  persistence.xml
        
       EntityManagerFactory emf = Persistence.createEntityManagerFactory(NOME_PERSISTENCE_XML);
       
       EntityManager em = emf.createEntityManager();
       
       TbAdmProduto p = em.find(TbAdmProduto.class, codigo);
       
       //System.out.println(p.getNome());

       return p;
           
   }
    
   public static void atualizar(TbAdmProduto x) {

       
       if (!(validaEntrada(x)))
           return; 
       
       EntityManagerFactory emf = Persistence.createEntityManagerFactory(NOME_PERSISTENCE_XML);
       
       EntityManager em = emf.createEntityManager();
       
       TbAdmProduto y = em.find(TbAdmProduto.class, x.getCodigoProduto());
       
       if (y == null) {
           y = new TbAdmProduto();
       }

        y.setCodigoProduto  (x.getCodigoProduto   ());
        y.setCodigoBarras   (x.getCodigoBarras    ());
        y.setNomeProduto    (x.getNomeProduto     ());
        y.setPrecoCusto     (x.getPrecoCusto      ());
        y.setPrecoVenda     (x.getPrecoVenda      ());

        try
       {
       
       em.getTransaction().begin();
       em.persist(y);
       em.getTransaction().commit();
       }
       catch(Exception e)
       {
           e.printStackTrace();
           codErro  = 9200;
           DescricaoErro =  codErro +  " - " + ComumSistemaBO.MENSAGEM_ERRO_BANCO_DADOS + " \n\n\n " + e.getMessage();
           
           tipoAlerta = tipoAlertaDescricao.Alerta;
       }
       

   }    
   
   private static boolean validaEntrada (TbAdmProduto x) {
       boolean retorno = true;

       codErro = 0;

       tipoAlerta = tipoAlertaDescricao.Informacao;
       DescricaoErro = ComumSistemaBO.MENSAGEM_SUCESSO;
       

       if (x.getCodigoProduto() == 0L ) {
           codErro  = 1200;
           DescricaoErro =  codErro +  " - " + ComumSistemaBO.MENSAGEM_CODIGO_PRODUTO_VAZIO;
           tipoAlerta = tipoAlertaDescricao.Alerta;
           return false;
       }
       
       if (x.getCodigoBarras().length() == 0 ) {
           codErro  = 1300;
           DescricaoErro =  codErro +  " - " + ComumSistemaBO.MENSAGEM_CODIGO_BARRAS_PRODUTO_VAZIO;
           tipoAlerta = tipoAlertaDescricao.Alerta;
           return  false;
       }       
       
       if (x.getPrecoCusto()  == null ) {
           codErro  = 1400;
           DescricaoErro =  codErro +  " - " + ComumSistemaBO.MENSAGEM_PRECO_CUSTO_PRODUTO_VAZIO;
           tipoAlerta = tipoAlertaDescricao.Alerta;
           return  false;
       }              

       if (x.getPrecoVenda()== null ) {
           codErro  = 1500;
           DescricaoErro =  codErro +  " - " + ComumSistemaBO.MENSAGEM_PRECO_CUSTO_PRODUTO_VAZIO;
           tipoAlerta = tipoAlertaDescricao.Alerta;
           return  false;
       }                     
       
       
       if (x.getNomeProduto().length() == 0 ) {
           codErro  = 1610;
           DescricaoErro =  codErro +  " - " + ComumSistemaBO.MENSAGEM_NOME_PRODUTO_VAZIO;
           tipoAlerta = tipoAlertaDescricao.Alerta;
           return  false;
       }

       return retorno;
       
   }
   
    
   
    public static List pesquisaDinamica(String nome) {

       EntityManagerFactory emf = Persistence.createEntityManagerFactory(NOME_PERSISTENCE_XML);
       String queryString = ComumQuery.query_todos_produtos();
       
       
       EntityManager em = emf.createEntityManager();
       
       //Query query = em.createNamedQuery("TbAdmPessoa.findAll"); 
       
       Query query = em.createQuery(queryString)
                       .setParameter("nome", "%" + nome + "%");
        //.createNamedQuery("TbAdmPessoa.findAll"); 
               
       List<TbAdmProduto> list = query.getResultList();
       
       return list;
       
   }    
    
}
