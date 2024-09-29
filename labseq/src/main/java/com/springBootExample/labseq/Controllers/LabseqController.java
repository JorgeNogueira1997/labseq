package com.springBootExample.labseq.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class LabseqController {
    private static HashMap<Integer, Long> calculationsStorage = new HashMap<>();;

    private static Long calculateLabseq(Integer n){
        // stopping point/base case for the recursive function:
        if (calculationsStorage.containsKey(n)) {
            return calculationsStorage.get(n);
        }
        // > 3 => l(n) = l(n-4) + l(n-3)
        Long answer = calculateLabseq(n - 4) + calculateLabseq(n - 3);

        calculationsStorage.put(n, answer);

        return answer;
        //return calculateLabseq(n - 4) + calculateLabseq(n - 3);
    }

    // ex. http://localhost:8080/labseq?n=99
    // endpoint: /labseq/n
    @GetMapping("/labseq")
    public static String labseq(Integer n) {
        // Default values:
        calculationsStorage.put(0, 0L); // l(0) = 0
        calculationsStorage.put(1, 1L); // l(1) = 1
        calculationsStorage.put(2, 0L); // l(2) = 0
        calculationsStorage.put(3, 1L); // l(3) = 1

        Integer answer = 0;
        if(n >= 0){
//            if(!calculationsStorage.containsKey(n)){
//                answer = calculateLabseq(n);
//                calculationsStorage.put(n, answer);
//            }
            //System.out.println(calculationsStorage);
            return "Labseq number: " + calculateLabseq(n);

            // Labseq number: -1468691325 .... quando meto n = 10000
            // tive que atualizar de Integer para Long
        }else{
            return "Positive numbers only!";
        }

    }

}
