//package UserDetails.api;
//
//import UserDetails.User;
//
//import javax.ws.rs.*;
//import javax.ws.rs.core.MediaType;
//import javax.ws.rs.core.Response;
//
//@Path("/users")
//public class UpdateApi {
//
//    @PUT
//    @Path("/{id}")
//    @Consumes(MediaType.APPLICATION_JSON)
//    public Response updateUser(@PathParam("id") int id, User updatedUser) {
//        return Response.status(Response.Status.OK).build();
//    }
//}

package UserDetails.api;

import UserDetails.User;
import UserDetails.UserRepository;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/users")
public class UpdateApi {
    private UserRepository userRepository = new UserRepository();

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateUser(@PathParam("id") int id, User updatedUser) {
        User existingUser = userRepository.getUser(id);
        if (existingUser != null) {
            updatedUser.setId(id);
            userRepository.updateUser(updatedUser);
            return Response.noContent().build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}
