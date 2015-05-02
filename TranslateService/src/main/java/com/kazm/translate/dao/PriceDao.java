package com.kazm.translate.dao;

import com.kazm.translate.dict.DocumentTypeEnum;
import com.kazm.translate.dict.LanguageEnum;
import com.kazm.translate.model.PriceModel;

public interface PriceDao extends GenericDao<PriceModel, Long> {

	PriceModel getPrice(LanguageEnum documentLanguage,
			LanguageEnum translationLanguage, DocumentTypeEnum documentType);

}
