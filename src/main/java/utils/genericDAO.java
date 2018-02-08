package utils;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class genericDAO {

	static EntityManagerFactory emf;
	
	 public static EntityManager getEntityManager(){

         //responsavel pela persistencia
         return emf.createEntityManager();
 }
	 
	 public genericDAO() {
         emf = Persistence.createEntityManagerFactory("agendaPU");
	 }
	 
	 public void salvar(Object objeto) {
		 EntityManager em = getEntityManager();
			try{
	            em.getTransaction().begin();
	            em.persist(objeto);
	            em.getTransaction().commit();
			}catch (Exception ex) {
				ex.printStackTrace();
	            em.getTransaction().rollback();
	            }
			 finally{
	             em.close();
			 }
	 }
	 
	 public Object consultar(int cod, Object objeto) {
			EntityManager em = getEntityManager();
			try{
			objeto = em.find(Object.class, cod);
			}catch (Exception e) {
	            //se der algo de errado vem parar aqui, onde é cancelado
	            em.getTransaction().rollback();
	            }
			 finally{
	             em.close();
			 }
			return objeto;
	 }
	 
     public void atualizar(int cod, Object objeto) {
    	 EntityManager em = getEntityManager();
         try {
                  em.getTransaction().begin();
                  em.merge(objeto);
                  em.getTransaction().commit();
         } catch (Exception ex) {
                  ex.printStackTrace();
                  em.getTransaction().rollback();
         }
     }
     
     public void deletar(int cod, Object objeto) {
    	 EntityManager em = getEntityManager();
         try {
                  em.getTransaction().begin();
                  objeto = em.find(Object.class, cod);
                  em.remove(objeto);
                  em.getTransaction().commit();
         } catch (Exception ex) {
                  ex.printStackTrace();
                  em.getTransaction().rollback();
         }
     }

	 @SuppressWarnings({ "rawtypes" })
	 public List Listar(Object objeto) {
		 EntityManager em = getEntityManager();
		 
		 String query = ("select o from " + objeto.getClass().getName() + " o");
	        try{
	                Query q = em.createQuery(query);

	        return q.getResultList();
	        }
	        finally{
	                em.close();
	        }
	 }}



/** public void atualizar(int cod, Object objeto) {
	 EntityManager em = getEntityManager();	 
	 String query = ("update" + objeto.getClass().getName().toLowerCase() + "set" +
			 objeto.
			 + "where" + cod + "= cod");
} **/

/**	 public void deletar(Long cod, Object objeto) {
	 EntityManager em = getEntityManager();
	 
	 String query = ("delete o from " + objeto.getClass().getName() + " o where o.cod = " + cod);
	 try{
        em.createQuery(query);
	 }catch (Exception e) {
           //se der algo de errado vem parar aqui, onde eh cancelado
           em.getTransaction().rollback();
           }
	 finally{
        em.close();
	 }
	 
} **/


