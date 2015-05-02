package com.kazm.translate.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import com.kazm.translate.dict.DocumentTypeEnum;
import com.kazm.translate.dict.LanguageEnum;
import com.kazm.translate.dict.OrderStatusEnum;

@Entity
@Table(name = "order_table")
public class OrderModel extends BaseModel {

	private static final long serialVersionUID = 1288303601853543842L;
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime startStamp;
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime endStamp;
	@NotNull
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "client_id")
	private UserModel client;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "worker_id")
	private UserModel worker;
	@NotNull
	@Enumerated(EnumType.STRING)
	private LanguageEnum documentLanguage;
	@NotNull
	@Enumerated(EnumType.STRING)
	private LanguageEnum translationLanguage;
	@NotNull
	@Enumerated(EnumType.STRING)
	private DocumentTypeEnum documentType;
	@NotNull
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "document_id")
	private DocumentModel document;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "translation_id")
	private DocumentModel translation;
	@NotNull
	@Enumerated(EnumType.STRING)
	private OrderStatusEnum status;
	@NotNull
	private Double price = 0.0;
	@NotNull
	private Integer words;

	public Integer getWords() {
		return words;
	}

	public void setWords(Integer words) {
		this.words = words;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public UserModel getClient() {
		return client;
	}

	public void setClient(UserModel client) {
		this.client = client;
	}

	public UserModel getWorker() {
		return worker;
	}

	public void setWorker(UserModel worker) {
		this.worker = worker;
	}

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

	public DocumentModel getDocument() {
		return document;
	}

	public void setDocument(DocumentModel document) {
		this.document = document;
	}

	public DocumentModel getTranslation() {
		return translation;
	}

	public void setTranslation(DocumentModel translation) {
		this.translation = translation;
	}

	public OrderStatusEnum getStatus() {
		return status;
	}

	public void setStatus(OrderStatusEnum status) {
		this.status = status;
	}

	public DateTime getStartStamp() {
		return startStamp;
	}

	public void setStartStamp(DateTime startStamp) {
		this.startStamp = startStamp;
	}

	public DateTime getEndStamp() {
		return endStamp;
	}

	public void setEndStamp(DateTime endStamp) {
		this.endStamp = endStamp;
	}

	public DocumentTypeEnum getDocumentType() {
		return documentType;
	}

	public void setDocumentType(DocumentTypeEnum documentType) {
		this.documentType = documentType;
	}

}
