package sit.int202.classicmodelweb;

import at.favre.lib.crypto.bcrypt.BCrypt;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import sit.int202.classicmodelweb.entities.Customer;
import sit.int202.classicmodelweb.entities.Office;
import sit.int202.classicmodelweb.repositories.CustomerRepository;
import sit.int202.classicmodelweb.repositories.OfficeRepository;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
////            EntityManagerFactory emf =  Persistence.createEntityManagerFactory("default");
////            EntityManager em = emf.createEntityManager();
////            Office office = em.find(Office.class, "2");
//        OfficeRepository officeRepository = new OfficeRepository();
//        Office office1 = officeRepository.find("1");
//
//        if (office1.getCity().equalsIgnoreCase("bangkok")) {
//            office1.setCity("Vientiane");
//        } else {
//            office1.setCity("Bangkok");
//        }
//
//        officeRepository.update(office1);
//
////        addNewOffice(officeRepository);
////        officeRepository.delete("9");
////        for (Office office : officeRepository.findAll()) {
//        for (Office office : officeRepository.findByCountry("J")) {
//
//            System.out.println(office.getId() + " : " + office.getCity() + " - " + office.getCountry());
//            System.out.println("----------------------------------------");
//            office.getEmployeeList().forEach(e -> {
//                System.out.printf("%5d %-9s %-15s %s\n",
//                        e.getId(), e.getFirstName(), e.getLastName(), e.getEmail());
//            });
//        }
////            em.close();

        CustomerRepository customerRepository = new CustomerRepository();
        Customer customer = customerRepository.findByName("Jean King");
        System.out.println(customer);
        String password = "1234";
        BCrypt.Result result = BCrypt.verifyer().verify(password.toCharArray(), customer.getPassword());
        System.out.println("password is : " + (result.verified ? "matched":"not matched"));
    }

    private static void addNewOffice(OfficeRepository officeRepository) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter office code: ");
        String officeCode = sc.next();
        System.out.print("Enter city : ");
        String city = sc.next();
        Office office = new Office();
        office.setId(officeCode);
        office.setCity(city);
        office.setAddressLine1("126 Pracha-utit");
        office.setPhone("0123456789");
        office.setPostalCode("10140");
        office.setTerritory("NA");
        office.setCountry("TH");
        officeRepository.save(office);
    }
}