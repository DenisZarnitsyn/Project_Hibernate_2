package Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rental.payment.*;
import inventory.*;
import customer.actor.staff.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class RentalService {

    @Autowired
    private RentalRepository rentalRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    @Transactional
    public void rentInventory(Customer customer, Inventory inventory, Staff staff) {
        Rental rental = new Rental();
        rental.setRentalDate(LocalDateTime.now());
        rental.setInventory(inventory);
        rental.setCustomer(customer);
        rental.setStaff(staff);
        rentalRepository.save(rental);

        Payment payment = new Payment();
        payment.setCustomer(customer);
        payment.setStaff(staff);
        payment.setRental(rental);
        payment.setAmount(BigDecimal.valueOf(0));
        payment.setPaymentDate(LocalDateTime.now());
        paymentRepository.save(payment);
    }
}
