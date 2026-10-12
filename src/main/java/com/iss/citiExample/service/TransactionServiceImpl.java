package com.iss.citiExample.service;

import com.iss.citiExample.exceptions.InvalidUserIdException;
import com.iss.citiExample.exceptions.NotFoundException;
import com.iss.citiExample.model.Transaction;
import com.iss.citiExample.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class TransactionServiceImpl implements  TransactionService{

    private final TransactionRepository repository;

    public TransactionServiceImpl(TransactionRepository repository) {
        this.repository = repository;
    }

    public List<Transaction> getClearedTransactions(String userId) {
        List<Transaction> res;

        //do some random logic
        if (userId == null || userId.isEmpty()) {
            throw new InvalidUserIdException("User Id: " + userId);
        }

        List<Transaction> allTransactions = repository.findByCustomerId(userId);

        res = allTransactions
                .stream()
                .filter( t -> "CLEARED".equals(t.getStatus()) ).collect(Collectors.toList());

        return res;
    }



    public Double getTotalOfTransactionCleared(String userId) {

        List<Transaction> transactionsCleared = getClearedTransactions(userId);
        if (transactionsCleared == null) {
            return 0.0;
        }

        return transactionsCleared
                .stream()
                .mapToDouble(Transaction::getAmount).sum();
    }

    /**
     * Random method tho play with queues
     */
    private void ignoreMethod() {
        ArrayDeque<Integer> myQueue = new ArrayDeque<>();
        myQueue.addFirst(1);
        myQueue.addLast(2);
        Boolean contains1 = myQueue.contains(1);

        Integer parameter = 2;
        Predicate<Integer> myPredicate = (i) -> i.equals(parameter);
        Integer resul = 0;

        if (contains1)
            resul = myQueue.removeFirst();

        myQueue.removeIf(myPredicate);
    }
}
