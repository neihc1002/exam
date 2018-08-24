/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;

/**
 * Jersey REST client generated for REST resource:ProductFacadeREST
 * [product]<br>
 * USAGE:
 * <pre>
 *        NewJerseyClient client = new NewJerseyClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author duong
 */
public class NewJerseyClient {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/ABCShopService/webresources";

    public NewJerseyClient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("product");
    }

    public String addProduct(Object requestEntity) throws ClientErrorException {
        return webTarget.path("add").request(javax.ws.rs.core.MediaType.APPLICATION_XML).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_XML), String.class);
    }

    public String sellProduct_XML(String quantity, String id) throws ClientErrorException {
        WebTarget resource = webTarget;
        if (quantity != null) {
            resource = resource.queryParam("quantity", quantity);
        }
        if (id != null) {
            resource = resource.queryParam("id", id);
        }
        resource = resource.path("sell");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(String.class);
    }

    public String sellProduct_TEXT(String quantity, String id) throws ClientErrorException {
        WebTarget resource = webTarget;
        if (quantity != null) {
            resource = resource.queryParam("quantity", quantity);
        }
        if (id != null) {
            resource = resource.queryParam("id", id);
        }
        resource = resource.path("sell");
        return resource.request(javax.ws.rs.core.MediaType.TEXT_PLAIN).get(String.class);
    }

    public <T> T getAllProduct(GenericType<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("get");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public void close() {
        client.close();
    }
    
}
