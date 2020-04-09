package ejercicios.ejercicio1;


import java.time.LocalDate;
import java.util.Objects;

//first_name,last_name,email,gender,birthday,country
//Durant,Phythian,dphythian0@nasa.gov,Male,1998/01/15,Brazil
public class Persona {
    private String firstName;
    private String lastName;
    private String email;
    private String gender;
    private LocalDate birthday;
    private String country;

    public Persona(String firstName, String lastName, String email, String gender, LocalDate birthday, String country) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.birthday = birthday;
        this.country = country;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        //Durant,Phythian,dphythian0@nasa.gov,Male,1998/01/15,Brazil según csv
        //Durant,Phythian,dphythian0@nasa.gov,Male,1998-01-15,Brazil según toString
        return String.format("%s,%s,%s,%s,%d/%d/%d,%s", firstName, lastName, email, gender,
                birthday.getYear(), birthday.getMonthValue(), birthday.getDayOfMonth(), country );
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
        {
            return false;
        }
        if (this.getClass() != obj.getClass())
        {
            return false;
        }
        final Persona other = (Persona) obj;
        return Objects.equals(this.firstName, other.firstName) && Objects.equals(this.lastName, other.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.firstName, this.lastName);
    }

    public static void main(String[] args) {
        Persona persona = new Persona("Durant","Phythian","dphythian0@nasa.gov",
                "Male",LocalDate.parse("1998-01-15"),"Brazil");
        System.out.println(persona);

    }
}
