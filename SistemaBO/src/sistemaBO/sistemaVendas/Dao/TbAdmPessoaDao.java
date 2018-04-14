/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaBO.sistemaVendas.Dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import sistemaBO.sistemaVendas.Comum.ComumSistemaBO;
import sistemaBO.sistemaVendas.CustomedQuerys.ComumQuery;
import sistemaBO.sistemaVendas.entity.TbAdmPessoa;



/**
 *
 * @author ricardo
 */
public class TbAdmPessoaDao {
    
    final static String NOME_PERSISTENCE_XML =  ComumSistemaBO.nomePersistencia; //  persistence.xml
    
    public static String pesquisarPessoa(Long codigo)  {

       //String nomePersistenceXML =  ComumSistemaBO.nomePersistencia; //  persistence.xml
        
       EntityManagerFactory emf = Persistence.createEntityManagerFactory(NOME_PERSISTENCE_XML);
       
       EntityManager em = emf.createEntityManager();
       
       TbAdmPessoa p = em.find(TbAdmPessoa.class, codigo);
       
       //System.out.println(p.getNome());
       
       return p.getNome();

           
   }

    public static List listaPessoa() {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory(NOME_PERSISTENCE_XML);
       
       EntityManager em = emf.createEntityManager();
       
       //Query query = em.createNamedQuery("TbAdmPessoa.findAll"); 
       
       Query query = em.createQuery(ComumQuery.TODAS_PESSOAS);
        //.createNamedQuery("TbAdmPessoa.findAll"); 
               
       List<TbAdmPessoa> pessoaList = query.getResultList();
       
       return pessoaList;
      // for(TbAdmPessoa p : pessoaList ) {
      //     System.out.println (p.getNome());
      // }

       
       //System.out.println(p.getNome());
   }    
    
    
    
    
    
    
    
    
    
   public static void atualizaPessoa()  {

       EntityManagerFactory emf = Persistence.createEntityManagerFactory(NOME_PERSISTENCE_XML);
       
       EntityManager em = emf.createEntityManager();
   
       
       TbAdmPessoa x = new TbAdmPessoa(6L, " Jao5" );
       em.getTransaction().begin();
       em.persist(x);
       em.getTransaction().commit();
       

   }
    
}
