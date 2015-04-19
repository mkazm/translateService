package com.kazm.translate.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

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
	@ManyToOne
	@JoinColumn(name = "client_id")
	private UserModel client;
	@ManyToOne
	@JoinColumn(name = "worker_id")
	private UserModel worker;
	@Enumerated(EnumType.STRING)
	private LanguageEnum documentLanguage;
	@Enumerated(EnumType.STRING)
	private LanguageEnum translationLanguage;
	@ManyToOne
	@JoinColumn(name = "document_id")
	private DocumentModel document;
	@ManyToOne
	@JoinColumn(name = "translation_id")
	private DocumentModel translation;
	private OrderStatusEnum status;

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

}
