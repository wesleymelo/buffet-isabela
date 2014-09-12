
import com.mycompany.buffet.beans.Produto;
import com.mycompany.buffet.dao.ProdutoDAO;
import com.mycompany.buffet.util.PersistenceUtil;
import java.math.BigDecimal;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Edilayne
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Produto produto = new Produto(1L, "Bolo de Fubá", new BigDecimal("130.99"));

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("expressoPU");
        EntityManager em = emf.createEntityManager();
                
        ProdutoDAO dao = new ProdutoDAO(em);
        
        dao.save(produto);
        
        em.close();
        emf.close();

    }
    
}
