package com.example.jazlab06.service;

//import com.example.jazlab06.;
//import com.example.MPRgr3.exception.CarNotFoundException;
import com.example.jazlab06.credit.Credit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreditService {
    CreditRepository creditRepository;

    @Autowired
    public CreditService(CreditService creditRepository) {
        this.creditRepository = creditRepository;

        creditRepository.save(new Credit(1, 1000, 36, "decreasing", 0.07, 30));

    }

    public Credit getCreditFromRepo(long id) {
        Credit credit = creditRepository.findById(id);

        if (credit == null) {
            throw new CreditNotFoundException();
        }

        return credit;
    }

    public long insertCreditIntoRepo(Credit credit) {
        if (creditRepository.existsById(credit.getId())) {
            throw new CreditAlreadyExistsException();
        }
        return creditRepository.save(credit).getId();
    }

    public long removeCreditFromRepo(long id) {
        if (creditRepository.existsById(id)) {
            creditRepository.deleteById(id);

            return id;
        } else {
            throw new CreditNotFoundException();
        }
    }

    public long updateCreditInRepo(Credit credit) {
        Credit repoCredit = creditRepository.findById(credit.getId());

        if (repoCredit != null) {
            repoCredit.setAmount(credit.getAmount());
            repoCredit.setPercentage(credit.getPercentage());
            return creditRepository.save(repoCredit).getId();
        } else {
            throw new CreditNotFoundException();
        }
    }
}