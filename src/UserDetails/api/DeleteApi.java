//package UserDetails.api;
//
//import UserDetails.User;
//
//import javax.ws.rs.*;
//import javax.ws.rs.core.MediaType;
//import javax.ws.rs.core.Response;
//
//@Path("/users")
//public class DeleteApi {
//
//    @DELETE
//    @Path("/{id}")
//    public Response deleteUser(@PathParam("id") int id) {
//        return Response.status(Response.Status.NO_CONTENT).build();
//    }
//}

package UserDetails.api;

import UserDetails.UserRepository;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/users")
public class DeleteApi {
    private UserRepository userRepository = new UserRepository();

    @DELETE
    @Path("/{id}")
    public Response deleteUser(@PathParam("id") int id) {
        boolean deleted = userRepository.deleteUser(id);
        if (deleted) {
            return Response.noContent().build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}
