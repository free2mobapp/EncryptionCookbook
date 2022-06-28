package uk.co.ksb.EncryptionCookbook;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import uk.co.ksb.EncryptionService;

import java.util.List;

@RestController
@RequestMapping("/server")
public class EmployerController {

    public String AES_KEY="TESTKEY123456789";

    @Autowired
    private EmployerService employerService;

    @PostMapping(value = "/encEmployer",
                produces = MediaType.APPLICATION_JSON_VALUE,
                consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public String encEmployer(@RequestBody Employer employer) {
        String[] ret = new String[2];
        System.out.println("EMployer added - " + employer);

        employerService.saveEmployer(employer);
        System.out.println("EMployer added");
        try {
            ObjectMapper mapper = new ObjectMapper();
            String jsonStr = mapper.writeValueAsString(employer);
            ret = EncryptionService.encrypt(jsonStr, AES_KEY);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "{ \"payload\":\"" + ret[0] + "\", \"iv\": \"" +ret[1] + "\"}";
    }

    @PostMapping(value = "/add-employer",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Employer addEmployer2(@RequestBody EncEmployer encEmployer) throws Exception {
        System.out.println("encrypted Employer added - " + encEmployer);
        // decrypt the encrypted data.
        String decryptedText = EncryptionService.decrypt(encEmployer.getPayload(), AES_KEY, encEmployer.getIv());
        System.out.println("decrypted text " +  decryptedText);
        Employer emp = new Employer();
        employerService.saveEmployer(emp);
        System.out.println("EMployer added");
        return emp;
    }

    @PostMapping(value = "/addEmployer",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Employer decryptAndSaveEmployer(@RequestBody EEmployer encEmployer) throws Exception {
        System.out.println("encrypted Employer added - " + encEmployer);
        // decrypt the encrypted data.
        String decryptedText = EncryptionService.decrypt(encEmployer.getPayload(), AES_KEY, encEmployer.getIv());
        System.out.println("decrypted text " +  decryptedText);
        ObjectMapper mapper = new ObjectMapper();
        Employer emp = mapper.readValue(decryptedText, Employer.class);
        employerService.saveEmployer(emp);
        System.out.println("EMployer added");
        return emp;
    }

    @GetMapping(value = "/employers")
    @ResponseStatus(HttpStatus.OK)
    public List<Employer> getAllEmployers() {
        return employerService.getAllEmployers();
    }

}
