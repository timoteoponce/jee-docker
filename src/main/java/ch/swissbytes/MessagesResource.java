package ch.swissbytes;

import javax.ejb.*;
import javax.inject.*;
import javax.persistence.*;
import javax.ws.rs.*;
import java.util.*;

@Stateless
@Path("messages")
public class MessagesResource {

    @PersistenceContext
    EntityManager em;

    @GET
    public String index(){
        return "[Hello, my " + adjective() + " " + noun() + "]";
    }

    private String adjective() {
        List<Adjective> items = em.createQuery("SELECT t FROM Adjective t", Adjective.class)
                .getResultList();
        return items.get(idx(items.size())).getName();
    }

    private int idx(int size) {
        return Math.abs( new Random().nextInt() % size);
    }

    private String noun() {
        List<Noun> items = em.createQuery("SELECT t FROM Noun t", Noun.class)
                .getResultList();
        return items.get(idx(items.size())).getName();
    }
}
