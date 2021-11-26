package jaz.lab06.demo.LoanRepaymentSchedule.Controller;

import jaz.lab06.demo.LoanRepaymentSchedule.Entities.LoanSubmission;
import jaz.lab06.demo.LoanRepaymentSchedule.Entities.Schedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoanController {


//    @PostMapping(path = "/loan/submission")
//    public ResponseEntity<?> addNewLoan(@RequestBody LoanSubmission submission){
//        return new ResponseEntity<>(submission, HttpStatus.OK);
//    }

    @GetMapping(path = "/loan/submission/{id}")
    public ResponseEntity getLoanSubmission(@RequestParam String id ){
        System.out.println("D");
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

}
