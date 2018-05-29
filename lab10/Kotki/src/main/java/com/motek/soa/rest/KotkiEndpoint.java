package com.motek.soa.rest;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.motek.soa.entity.Kotek;
import com.motek.soa.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.List;

@Path("kotki")
public class KotkiEndpoint {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        List<Kotek> kotki = session.createQuery("FROM Kotek").list();
        String json = new Gson().toJson(kotki);
        session.close();
        return Response.ok(json).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCat(@PathParam("id") Integer id) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Kotek kotek = (Kotek) session.get(Kotek.class, id);
        session.close();
        if (kotek == null) return Response.status(Response.Status.NOT_FOUND).build();
        return Response.ok(kotek.toJson()).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addCat(String json) {
        Kotek kotek;
        try {
            kotek = Kotek.parseJson(json);
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.save(kotek);
        session.beginTransaction().commit();
        session.close();
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response modifyCat(@PathParam("id") Integer id, String json) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Kotek kotek;
        try {
            kotek = Kotek.parseJson(json);
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        Kotek kotekTmp = (Kotek) session.get(Kotek.class, id);
        if (kotekTmp == null) return Response.status(Response.Status.NOT_FOUND).build();
        kotek.setId(id);
        session.update(kotek);
        session.beginTransaction().commit();
        session.close();
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    public Response removeCat(@PathParam("id") Integer id) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Kotek kotek = (Kotek) session.get(Kotek.class, id);
        if (kotek == null) return Response.status(Response.Status.NOT_FOUND).build();
        session.delete(kotek);
        session.beginTransaction().commit();
        session.close();
        return Response.ok().build();
    }

    @DELETE
    public Response removeAll() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.createQuery("DELETE FROM Kotek").executeUpdate();
        session.beginTransaction().commit();
        session.close();
        return Response.ok().build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addCats(String json) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Gson gson = new Gson();
        Type listType = new TypeToken<List<Kotek>>() {
        }.getType();
        List<Kotek> noweKotki;
        try {
            noweKotki = gson.fromJson(json, listType);
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        for (Kotek kotek : noweKotki) {
            session.save(kotek);
        }
        session.beginTransaction().commit();
        session.close();
        return Response.ok().build();
    }

}
