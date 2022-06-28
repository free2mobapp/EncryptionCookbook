package uk.co.ksb.EncryptionCookbook;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employer {

   @Id
   private Integer id;

   @NotNull
   private String firstname;

   @NotNull
   private String surname;

   public Integer getId() {
      return id;
   }

   public void setId(Integer id) {
      this.id = id;
   }

   public String getFirstname() {
      return firstname;
   }

   public void setFirstname(String firstname) {
      this.firstname = firstname;
   }

   public String getSurname() {
      return surname;
   }

   public void setSurname(String surname) {
      this.surname = surname;
   }

   public Employer(Integer id, String firstname, String surname) {
      this.id = id;
      this.firstname = firstname;
      this.surname = surname;
   }

   public Employer() {
   }
}
