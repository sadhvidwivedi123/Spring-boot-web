package com.wellsfargo.batch5.pms.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.wellsfargo.batch5.pms.entity.CurrencyEntity;
import com.wellsfargo.batch5.pms.model.CurrencyModel;
import com.wellsfargo.batch5.pms.repo.CurrencyRepo;

@Component
public class CurrencyTask {

    @Autowired
    private CurrencyRepo currencyRepo;
 
    @Scheduled(fixedRate = 5 * 1000 * 60 * 60)
    private void getRatesTask() {
        try {
            RestTemplate restTemplate = new RestTemplate();
            CurrencyModel forObject = restTemplate.getForObject("https://v6.exchangerate-api.com/v6/bfd56aaaf2af6a2659fc6b96/latest/INR", CurrencyModel.class);
            forObject.getConversion_rates().forEach((key, value) -> {
                CurrencyEntity currency = new CurrencyEntity(key, value);
                this.currencyRepo.save(currency);
            });
        } catch (RestClientException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
