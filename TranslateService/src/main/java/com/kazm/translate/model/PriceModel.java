package com.kazm.translate.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.kazm.translate.dict.DocumentTypeEnum;
import com.kazm.translate.dict.LanguageEnum;

@Entity
@Table(name = "price_table", uniqueConstraints = @UniqueConstraint(columnNames = {
		"documentLanguage", "translationLanguage", "documentType" }))
public class PriceModel extends BaseModel {

	private static final long serialVersionUID = 1786202222412502757L;
	@Enumerated(EnumType.STRING)
	private LanguageEnum documentLanguage;
	@Enumerated(EnumType.STRING)
	private LanguageEnum translationLanguage;
	@Enumerated(EnumType.STRING)
	private DocumentTypeEnum documentType;
	private Double price;

	public LanguageEnum getDocumentLanguage() {
		return documentLanguage;
	}

	public void setDocumentLanguage(LanguageEnum documentLanguage) {
		this.documentLanguage = documentLanguage;
	}

	public LanguageEnum getTranslationLanguage() {
		return translationLanguage;
	}

	public void setTranslationLanguage(LanguageEnum translationLanguage) {
		this.translationLanguage = translationLanguage;
	}

	public DocumentTypeEnum getDocumentType() {
		return documentType;
	}

	public void setDocumentType(DocumentTypeEnum documentType) {
		this.documentType = documentType;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

}
