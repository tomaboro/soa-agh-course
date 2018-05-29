package com.motek.soa.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.net.URISyntaxException;

import static com.motek.soa.rest.MoviesEndpoint.endpointUri;

@Path("other")
public class OtherEndpoint {
    @GET
    public Response sth() {
        URI uri = null;
        try {
            uri = new URI(endpointUri);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return Response.status(305).contentLocation(uri).build();
    }
}
