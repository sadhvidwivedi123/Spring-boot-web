package com.wellsfargo.batch5.pms.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellsfargo.batch5.pms.entity.CurrencyEntity;
import com.wellsfargo.batch5.pms.exception.PortfolioException;
import com.wellsfargo.batch5.pms.model.ConversionCurrency;
import com.wellsfargo.batch5.pms.repo.CurrencyRepo;

@Service
public class CurrencyServiceImpl implements ICurrencyService{
	
	@Autowired
    private CurrencyRepo currencyRepo;
	
	public String toCurrency;

	public CurrencyServiceImpl(CurrencyRepo currencyRepo) {
		this.currencyRepo = currencyRepo;
	}

	@Override
	public Double convert(ConversionCurrency conversionCurrency) throws PortfolioException {
        Optional<CurrencyEntity> toOptional = this.currencyRepo.findById(conversionCurrency.getTo().toUpperCase());
        Optional<CurrencyEntity> fromOptional = this.currencyRepo.findById(conversionCurrency.getFrom().toUpperCase());
        if(toOptional.isPresent() && fromOptional.isPresent()) {
            if(conversionCurrency.getValue() < 0) {
                return null;
            }
            toCurrency = conversionCurrency.getTo();
            CurrencyEntity to = toOptional.get();
            Double toValue = to.getValueInINR();
            Double result = toValue * conversionCurrency.getValue();
            return result;
        }
        return null;
    }

	@Override
	public String getToCurrency() throws PortfolioException {
        if(toCurrency==null) {
        	return "INR";
        } else {
        	return toCurrency;
        }
	}
	

}
