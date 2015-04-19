package com.kazm.translate.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "document")
public class DocumentModel extends BaseModel {

	private static final long serialVersionUID = -1609828738514233905L;
	private String name;
	private String path;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
}
