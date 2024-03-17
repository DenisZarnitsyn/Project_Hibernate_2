package Service;

import country.city.address.*;
import customer.actor.staff.Customer;
import customer.actor.staff.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class CustomerService {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Transactional
    public Customer createCustomerWithAddress(Byte storeId, String firstName, String lastName, String email, String street, Short cityId, Short countryId) {
        Address address = new Address();
        address.setStreetName(street);
        address.setCityId(cityId);
        Address savedAddress = addressRepository.save(address);

        Customer customer = new Customer();
        customer.setStoreId(storeId);
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.setEmail(email);
        customer.setAddress(savedAddress);
        customer.setActive(true);
        customer.setCreateDate(LocalDateTime.now());
        customer.setLastUpdate(LocalDateTime.now());

        return customerRepository.save(customer);
    }
}
