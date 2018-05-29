package com.motek.soa.rest;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.motek.soa.entity.Movie;
import com.motek.soa.entity.Movie;
import com.motek.soa.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;


@Path("movies")
public class MoviesEndpoint {
    public static final String endpointUri = "http://localhost:8080/Kotki_war_exploded/rest/movies";

    @GET
    @Path("/info")
    @Produces(MediaType.TEXT_PLAIN)
    public Response getInfo() {
        return Response.ok(endpointUri).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllFiltered(@QueryParam("tytul") String title) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        List<Movie> movies;
        if(title == null) {
            movies = session.createQuery("FROM Movie").list();
        }else {
            movies = session.createQuery("FROM Movie WHERE title LIKE '%" + title + "%'").list();
        }
        String json = new Gson().toJson(movies);
        session.close();
        return Response.ok(json).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMovie(@PathParam("id") Integer id) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Movie movie = (Movie) session.get(Movie.class, id);
        session.close();
        if (movie == null) return Response.status(Response.Status.NOT_FOUND).build();
        return Response.ok(movie.toJson()).build();
    }

    @GET
    @Path("/uri-list")
    @Produces("text/uri-list")
    public Response getAllUri() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        List<Movie> movies = session.createQuery("FROM Movie").list();
        StringBuilder responseStr = new StringBuilder();
        for(Movie movie: movies) {
            responseStr.append(movie.getUri()).append("\n");
        }
        session.close();
        return Response.ok(responseStr.toString()).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addMovie(String json) {
        Movie movie;
        try {
            movie = Movie.parseJson(json);
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        if (session.get(Movie.class,movie.getId()) != null) return Response.status(Response.Status.CONFLICT).build();
        session.save(movie);
        session.beginTransaction().commit();
        session.close();
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response modifyMovie(@PathParam("id") Integer id, String json) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Movie movie;
        try {
            movie = Movie.parseJsonWithoutId(json);
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        movie.setId(id);
        Movie movieTmp = (Movie) session.get(Movie.class, id);
        if (movieTmp == null) return Response.status(Response.Status.NOT_FOUND).build();
        movie.setId(id);
        session.update(movie);
        session.beginTransaction().commit();
        session.close();
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    public Response removeMovie(@PathParam("id") Integer id) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Movie movie = (Movie) session.get(Movie.class, id);
        if (movie == null) return Response.status(Response.Status.NOT_FOUND).build();
        session.delete(movie);
        session.beginTransaction().commit();
        session.close();
        return Response.ok().build();
    }

    @DELETE
    public Response removeAll() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.createQuery("DELETE FROM Movie").executeUpdate();
        session.beginTransaction().commit();
        session.close();
        return Response.ok().build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addMovies(String json) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Gson gson = new Gson();
        Type listType = new TypeToken<List<Movie>>() {
        }.getType();
        List<Movie> noweMovies;
        try {
            noweMovies = gson.fromJson(json, listType);
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        for (Movie movie : noweMovies) {
            movie.setId();
            session.save(movie);
        }
        session.beginTransaction().commit();
        session.close();
        return Response.ok().build();
    }
}
