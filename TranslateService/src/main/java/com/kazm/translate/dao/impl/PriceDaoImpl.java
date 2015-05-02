package com.kazm.translate.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.kazm.translate.dao.PriceDao;
import com.kazm.translate.dict.DocumentTypeEnum;
import com.kazm.translate.dict.LanguageEnum;
import com.kazm.translate.model.PriceModel;

@Repository
public class PriceDaoImpl extends GenericDaoImpl<PriceModel, Long> implements
		PriceDao {

	public PriceDaoImpl() {
		super(PriceModel.class);
	}

	@Override
	@SuppressWarnings("unchecked")
	public PriceModel getPrice(LanguageEnum documentLanguage,
			LanguageEnum translationLanguage, DocumentTypeEnum documentType) {
		String query = "select p from "
				+ getPersistentClass().getSimpleName()
				+ " p where p.documentLanguage = :documentLanguage and p.translationLanguage = :translationLanguage and p.documentType = :documentType";
		List<PriceModel> priceList = getEntityManager().createQuery(query)
				.setParameter("documentLanguage", documentLanguage)
				.setParameter("translationLanguage", translationLanguage)
				.setParameter("documentType", documentType).getResultList();
		if (priceList.isEmpty())
			return null;
		if (priceList.size() > 1)
			return null;
		return priceList.get(0);
	}
}
