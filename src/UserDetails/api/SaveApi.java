//package UserDetails.api;
//
//import UserDetails.User;
//
//import javax.ws.rs.*;
//import javax.ws.rs.core.MediaType;
//import javax.ws.rs.core.Response;
//
//@Path("/users")
//public class SaveApi {
//
//    @POST
//    @Consumes(MediaType.APPLICATION_JSON)
//    public Response saveUser(User user) {
//        return Response.status(Response.Status.CREATED).build();
//    }
//}
package UserDetails.api;

import UserDetails.User;
import UserDetails.UserRepository;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/users")
public class SaveApi {
    private UserRepository userRepository = new UserRepository();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response saveUser(User user) {
        User savedUser = userRepository.saveUser(user);
        if (savedUser != null) {
            return Response.status(Response.Status.CREATED).entity(savedUser).build();
        }
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
    }
}
