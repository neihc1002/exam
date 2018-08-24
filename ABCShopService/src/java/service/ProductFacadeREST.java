/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Product;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author duong
 */
@Stateless
@Path("product")
public class ProductFacadeREST {

    @PersistenceContext(unitName = "ABCShopServicePU")
    private EntityManager em;

    @GET
    @Path("get")
    @Produces({MediaType.APPLICATION_XML})
    public List<Product> getAllProduct() {
        List<Product> list = null;
        try {
            list = em.createNamedQuery("Product.findAll").getResultList();
        } catch (Exception e) {
        }
        return list;
    }

    @POST
    @Path("add")
    @Produces({MediaType.TEXT_PLAIN})
    @Consumes({MediaType.APPLICATION_XML})
    public String addProduct(Product product) {
        try {
            em.persist(product);
            return "true";
        } catch (Exception e) {
        }
        return "false";
    }

    @GET
    @Path("sell")
    @Produces({MediaType.APPLICATION_XML, MediaType.TEXT_PLAIN})
    public String sellProduct(@QueryParam("id") int id, @QueryParam("quantity") int quantity) {
        try {
            Product product = em.find(Product.class, id);
            product.setQuantity(product.getQuantity() - quantity);
            em.merge(product);
            return "true";
        } catch (Exception e) {
        }
        return "false";
    }
}
