package ch.swissbytes;

import javax.ws.rs.*;

@Path("messages")
public class MessagesResource {

    @GET
    public String index(){
        return "[Hello ,docker]";
    }
}
