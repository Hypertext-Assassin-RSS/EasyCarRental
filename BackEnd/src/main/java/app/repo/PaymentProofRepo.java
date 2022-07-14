package app.repo;

import app.entity.PaymentProof;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @PROJECT EasyCarRental
 * @Author Rajith Sanjaya
 * @Date 2022 Jul 14
 **/
public interface PaymentProofRepo extends JpaRepository<PaymentProof,String> {
}
