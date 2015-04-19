package com.kazm.translate.dao.impl;

import org.springframework.stereotype.Repository;

import com.kazm.translate.dao.DocumentDao;
import com.kazm.translate.model.DocumentModel;

@Repository
public class DocumentDaoImpl extends GenericDaoImpl<DocumentModel, Long>
		implements DocumentDao {

	public DocumentDaoImpl() {
		super(DocumentModel.class);
	}

}
