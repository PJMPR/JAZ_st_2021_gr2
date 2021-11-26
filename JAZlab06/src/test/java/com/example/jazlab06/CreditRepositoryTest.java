package com.example.jazlab06;

import com.example.jazlab06.credit.Credit;
import com.example.jazlab06.service.CreditRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class CreditRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CreditRepository creditRepository;

    @Test
    public void findByIdReturnsCreditById() {
        Credit credit = new Credit(1, 1000, 36, "decreasing", 0.07,
                30);

        entityManager.persist(credit);
        entityManager.flush();

        Credit foundCredit =  creditRepository.findById(1L);

        assertThat(foundCredit.getMake()).isEqualTo(1000);
    }
}