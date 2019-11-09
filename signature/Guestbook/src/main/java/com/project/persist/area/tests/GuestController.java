package com.project.persist.area.tests;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.project.persist.area.ent.Country;
import com.project.persist.area.ent.Guest;
import com.project.persist.area.ent.MessageResponse;
import com.project.persist.area.ent.Persona;
import com.project.persist.area.ent.VoiceReqFormat;
//import com.project.persist.area.imp.PersonRepo;
import com.project.persist.area.inter.PersonaDAO;
import com.project.persist.area.repo.Address;
import com.project.persist.area.repo.Book;
import com.project.persist.area.repo.Person;

@Controller
public class GuestController {

    @Autowired
    private GuestDao guestDao;

    @Autowired
    private PersonaDAO personaDao;

    //@Autowired
    //private PersonRepo personRepo;

    //@Autowired
    //private AddressRepo addressRepo;
    
    /*@Autowired
    private BookRepo bookRepo;*/

    @RequestMapping(value = "/guest")
    public ModelAndView guestbook(HttpServletRequest request) {
        // Handle a new guest (if any):
        String name = request.getParameter("name");
        if (name != null)
            guestDao.persist(new Guest(name));

        // Prepare the result view (guest.jsp):
        return new ModelAndView("guest.jsp", "guestDao", guestDao);
    }

    @RequestMapping(value = "/countriesx")
    public ModelAndView guestbook2(HttpServletRequest request) {
        // Handle a new guest (if any):
        String name = request.getParameter("name");
        if (name != null)
            guestDao.persist(new Guest(name));

        // Prepare the result view (guest.jsp):
        return new ModelAndView("guest.jsp", "guestDao", guestDao);
    }
    
    /* PATO NATO Esto es lo que agregue ademas de las entities el primero te muestra el formato que envias desde el telefono
     * y el segundo es el servicio en si */
    
    @RequestMapping(value = "/vrf", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public @ResponseBody VoiceReqFormat getVoiceReqFormat() {

        VoiceReqFormat vrf = new VoiceReqFormat();
        
        vrf.setMessage("apagar luces");
        List<String> opm = new ArrayList<String>();
        opm.add("uno");
        opm.add("dos");
        opm.add("tres");
        vrf.setOtherPossibleMessages(opm);    
    
        return vrf;
    }
    
    @RequestMapping(value = "/sendMessage", method = RequestMethod.POST, produces = "application/json; charset=utf-8", consumes="application/json; charset=utf-8")
    public @ResponseBody MessageResponse sendTextMessage(@RequestBody VoiceReqFormat vrf) {

        MessageResponse mr = new MessageResponse();
        
        mr.setStatus("ok");
        
        mr.setOperationDescription("Lo enviado fue: "+ vrf.getMessage() + "  " + vrf.getOtherPossibleMessages().size());

        return mr;
    }
    
    /* PATO NATO */

    @RequestMapping(value = "/countries/{like}", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public @ResponseBody List<Country> getCountries(
            @PathVariable("like") String like) {

        List<Country> ctryList = null;
        ctryList = guestDao.getCountries(like);

        return ctryList;
    }




    @RequestMapping(value = "/personas/startsWith/{like}", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public @ResponseBody List<Persona> getPersonas(
            @PathVariable("like") String like) {

        List<Persona> ctryList = null;
        if (personaDao != null)
        ctryList = personaDao.findStartsWith(like, "apellido");//Persona_.apellido.getName()

        return ctryList;
    }

    @RequestMapping(value = "/personas/all", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public @ResponseBody List<Persona> getAllPersonas() {

        List<Persona> personas = null;
        personas = personaDao.findAll();

        return personas;
    }

    @RequestMapping(value = "/personas", method = RequestMethod.POST, produces = "application/json; charset=utf-8", consumes="application/json; charset=utf-8")
    public @ResponseBody List<Persona> addPersona(@RequestBody Persona p) {

        List<Persona> lista = new ArrayList<Persona>();
        Persona per = new Persona();
        per.setApellido("sapayo");
        lista.add(per);

        personaDao.save(p);

        return lista;
    }

    @RequestMapping(value = "/personas/{id}", method = RequestMethod.PATCH, produces = "application/json; charset=utf-8", consumes="application/json; charset=utf-8")
    public @ResponseBody List<Persona> modifyPersona(@RequestBody Persona p, @PathVariable("id") Integer id) {

        List<Persona> lista = new ArrayList<Persona>();

        lista.add(p);

        personaDao.updateFields(p, id);


        return lista;
    }

    @RequestMapping(value = "/personas/{id}", method = RequestMethod.PUT, produces = "application/json; charset=utf-8", consumes="application/json; charset=utf-8")
    public @ResponseBody List<Persona> replacePersona(@RequestBody Persona p, @PathVariable("id") Integer id) {

        List<Persona> lista = new ArrayList<Persona>();

        lista.add(p);
        p.setId(id);
        personaDao.update(p, id);


        return lista;
    }

    @RequestMapping(value = "/personas/{id}", method = RequestMethod.DELETE, produces = "application/json; charset=utf-8")
    public @ResponseBody List<Persona> deletePersona(@PathVariable("id") Integer id) {

        List<Persona> lista = new ArrayList<Persona>();
        Persona per = new Persona();
        per.setApellido("sapayo");
        lista.add(per);
        personaDao.delete(id);


        return lista;
    }

    @RequestMapping(value = "/mongo/{id}", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    public @ResponseBody Iterable<Person> testmongo(@PathVariable("id") Integer id) {

        Person personAchilles = new Person();
        personAchilles.setPersonId(4l);
        personAchilles.setName("AchillesY");

        Address address = new Address(4,"221b Baker Street","rincon","frede",12345l);
        List<Address> addresses = personAchilles.getAddresses();
        addresses.add(address);
        personAchilles.setAddresses(addresses);

        //addressRepo.save(address);
        //personRepo.save(personAchilles);

        //Iterable<Person> personList = personRepo.findAll();
        //Iterable<Person> personList = personRepo.begindsWith("^Ach");

        return null;//personList;
    }
    
    @RequestMapping(value = "/couch/{id}", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    public @ResponseBody Book testcouch(@PathVariable("id") Integer id) {

      Book book = new Book();
      /*book.setBookId(123);;
      book.setIsbnNumber(2133443554);
      book.setName("Kane And Abel by XYZ");
      bookRepo.save(book);
      
      Book anotherBook = new Book();
      anotherBook.setBookId(456);;
      anotherBook.setIsbnNumber(2133443554);
      anotherBook.setName("The Prodigal Daughter");
      bookRepo.save(anotherBook);
      
      Book retreivedBook = bookRepo.findOne(123l);*/

        return book;
    }

}