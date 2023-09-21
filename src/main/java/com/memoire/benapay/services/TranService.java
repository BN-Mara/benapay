package com.memoire.benapay.services;

import java.util.HashMap;
import java.util.Map;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import com.memoire.benapay.model.Transaction;
import com.memoire.benapay.repos.TransRepository;
import com.memoire.benapay.utils.AppDateTime;
import com.memoire.benapay.utils.Utils;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TranService {

    @Autowired
    private TransRepository repository;

    private WebClient webClient;

    public Transaction create(Transaction trans){

        Map<String, String> bodyMap = new HashMap();
        Map<String,Map<String,String>> inMap = new HashMap<>();
        Map<String, String> bodyMap2 = new HashMap();
        Map<String, String> sender = new HashMap();
        Map<String,Object> all = new HashMap<>();
    bodyMap.put("serviceCode", "MERCHPAY");
    bodyMap.put("transactionAmount", "2");
    bodyMap.put( "initiator", "transactor");
    bodyMap.put("currency", "102");
    bodyMap.put("bearerCode", "USSD");
    bodyMap.put( "source", "J-napps");
    bodyMap.put("language", "fr");
    bodyMap.put("externalReferenceId", "EXT12-retry-32");
    bodyMap.put("remarks", "Merch Initiated");
    bodyMap.put("transactionMode", "transactionMode");
    bodyMap2.put("idType", "mobileNumber");
    bodyMap2.put("productId", "12");
    bodyMap2.put("tpin", "1557");
    bodyMap2.put( "idValue", "0901026059");
    bodyMap2.put("mpin", "1234");
    bodyMap2.put("password", "1234");
    bodyMap2.put("pin", "1234");
    sender.put("idType", "mobileNumber");
    sender.put("productId", "12");
    sender.put("idValue", "0910100319");
    sender.put("identificationNo", "77000323231234");
    inMap.put("transactor",bodyMap2);
    inMap.put("sender", sender);
    all.putAll(bodyMap);
    all.putAll(bodyMap2);
    all.putAll(sender);

   


        trans.setReference(generateReference());
        trans.setDateTrans(AppDateTime.now());
        //webClient.post()
        var employeeMono = webClient.post()
      .uri("")
      .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
      .body(BodyInserters.fromValue(bodyMap))
      .retrieve()
      .bodyToMono(String.class);
      System.out.println(employeeMono);
       return repository.save(trans);
    }
    public Iterable<Transaction> get(){
        return repository.findAll();
    }
    public Transaction get(int id){
        var op = repository.findById(id);
        if(op.isPresent()){
            return op.get();
        }
        else{
            return null;
        }
    }

    public Transaction update(Transaction user){
        return repository.save(user);
    }
    private String generateReference(){
        var code = Utils.generateCode();
        if (repository.findByReference(code) != null) {
            generateReference();
        }
        return code;
            
        
    }
}
