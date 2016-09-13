package com.backend.neo.resource;

import com.backend.neo.domain.Person;
import com.backend.neo.services.PersonService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/person")
@Produces(MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
public class PersonResource {

    @Autowired
    private PersonService service;

    // http://localhost:8080/api/search/person/?searchkey=armen
    @CrossOrigin
    @ApiOperation(value = "FindUser", nickname = "FindUser")
    @RequestMapping(method = RequestMethod.GET, value = "/find", params = {"searchkey"})
//    @ApiImplicitParams({
//        @ApiImplicitParam(name = "name", value = "User's name", required = false, dataType = "string", paramType = "query", defaultValue="Armen")
//      })
    @ApiResponses(value = { 
            @ApiResponse(code = 200, message = "Success", response = Person.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")}) 
    public Response findPerson(@RequestParam(value = "searchkey") String searchkey) {
        //System.out.println("Param passed " + searchkey);
        List<Person> person = service.getPerson(searchkey);
        //System.out.println("List size   " + person.size());
        return Response.ok(person).type(javax.ws.rs.core.MediaType.APPLICATION_JSON).build();
    }
    
    @CrossOrigin
    @ApiOperation(value = "Create Person Node", nickname = "PersonNode")
    @RequestMapping(method = RequestMethod.POST, value = "/create")
    @ApiResponses(value = { 
            @ApiResponse(code = 200, message = "Success", response = Person.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")}) 
    public Response createPerson(@RequestParam(value = "firstname") String firstname,@RequestParam(value = "lastname") String lastname) {
        service.savePerson(firstname, lastname);
        return Response.ok(Status.OK).type(javax.ws.rs.core.MediaType.APPLICATION_JSON).build();
    }

}
