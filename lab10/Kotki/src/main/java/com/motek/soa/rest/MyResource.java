package com.motek.soa.rest;
import com.motek.soa.entity.Kotek;
import com.motek.soa.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("myresource")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response getIt(@QueryParam("name") String name) {
        if(name.equals("Filemon")) {
            return Response.status(327).build();
        }
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Kotek k1 = new Kotek();
        k1.setImie(name);
        session.save(k1);
        session.getTransaction().begin();
        session.getTransaction().commit();
        session.close();
        return Response.ok("Got it!").build();
    }
}