package com.wellsfargo.batch5.pms.service;


import com.wellsfargo.batch5.pms.exception.PortfolioException;
import com.wellsfargo.batch5.pms.model.ConversionCurrency;

public interface ICurrencyService {

    Double convert(ConversionCurrency conversionCurrency) throws PortfolioException;
    
    String getToCurrency() throws PortfolioException;

}
