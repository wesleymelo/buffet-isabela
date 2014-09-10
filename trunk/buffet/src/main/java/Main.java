
import com.mycompany.buffet.beans.Produto;
import com.mycompany.buffet.dao.ProdutoDAO;
import com.mycompany.buffet.util.PersistenceUtil;
import java.math.BigDecimal;

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
        
        ProdutoDAO dao = new ProdutoDAO(PersistenceUtil.getEntityManager());
        
        dao.save(produto);
    }
    
}
