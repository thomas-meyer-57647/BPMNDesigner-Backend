package com.metho.bpmndesigner.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * a documents contains one or more <code>Page</code>s
 * 
 * long id							the id of the collection
 * LocalDateTime createdAt			the created date
 * UserEntity createdBy				the creator
 * LocalDateTime updatedAt			the last update date
 * UserEntity updatedBy;			the updater
 * String name						the name of the dokument
 * String author					the author of the dokument
 * String version					the version
 * String description				a detail description of the document
 * List<Page> pages					the pages
 *
 */
@Document(collection="documents")
@CompoundIndexes({
    @CompoundIndex(name = "user_documents", def = "{'createdBy.id' : 1, 'name': 1}, {unique: true}")
})
public class DocumentEntity {
	
	@Transient
    public static final String SEQUENCE_NAME = "document_sequence";
	
	@Id
	private long id;									// the id of the collection
	
	@Field("created_at")
	private LocalDateTime createdAt;					// the created date
	
	@DBRef
	@Field("created_by")
	private UserEntity createdBy;						// the creator
	
	@Field("updated_at")	
	private LocalDateTime updatedAt;					// the last update date
	
	@DBRef
	@Field("udated_by")	
	private UserEntity updatedBy;						// the updater
	
	@NotBlank
    @Size(max=100)
	String name;										// the name of the dokument

	@Size(max=100)
	String author;										// the author of the dokument

	@Size(max=100)
	String version;										// the version

	String description;									// a detail description of the document
	
	@NotNull
	List<Page> pages = new ArrayList<Page>();			// the pages
	
	/**
	 * default constructor
	 * 
	 * @return void
	 */
	public DocumentEntity() {
		super();
	}
	
	/**
	 * initialize constructor
	 * 
	 * @return void
	 */
	public DocumentEntity(String name, String author, String version, String description, List<Page> pages) {
		super();
		
		this.name = name;
		this.author = author;
		this.version = version;
		this.description = description;
		this.pages = pages;
	}

	/**
	 * get the id of the document
	 * 
	 * @return long
	 */
	public long getId() {
		return id;
	}
	
	/**
	 * set the id of the document
	 * 
	 * @return long
	 */
	public void setId(long id) {
		this.id = id;
	}
	
	/**
	 * get the first creation date
	 * 
	 * @return long
	 */
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	
	/**
	 * set the first creation date
	 * 
	 * @return long
	 */
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	/**
	 * get the first creator
	 * 
	 * @return User
	 */
	public UserEntity getCreatedBy() {
		return createdBy;
	}
	
	/**
	 * set the first creator
	 * 
	 * @param User
	 * @return void
	 */
	public void setCreatedBy(UserEntity createdBy) {
		this.createdBy = createdBy;
	}
	
	/**
	 * get the last update
	 * 
	 * @return LocalDateTime
	 */
	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}
	
	/**
	 * set the last update
	 * 
	 * @param LocalDateTime
	 * @return void
	 */
	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	/**
	 * get the last updater
	 * 
	 * @return UserEntity
	 */
	public UserEntity getUpdatedBy() {
		return updatedBy;
	}
	
	/**
	 * set the last updater
	 * 
	 * @param UserEntity
	 * @return void
	 */
	public void setUpdatedBy(UserEntity updatedBy) {
		this.updatedBy = updatedBy;
	}

	/**
	 * get the name of the document
	 * 
	 * @return String
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * set the name of the document
	 * 
	 * @param name
	 * @return void
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * get the author of the document
	 * 
	 * @return String
	 */
	public String getAuthor() {
		return author;
	}
	
	/**
	 * set the author of the document
	 * 
	 * @param String
	 * @return void
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	
	/**
	 * get the version of the document
	 * 
	 * @return String
	 */
	public String getVersion() {
		return version;
	}
	
	/**
	 * set the version of the document
	 * 
	 * @param String
	 * @return void
	 */
	public void setVersion(String version) {
		this.version = version;
	}
	
	/**
	 * get the description of the document
	 * 
	 * @return String
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * set the description of the document
	 * 
	 * @param String
	 * @return void
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * get the pages of the document
	 * 
	 * @return List<Page>
	 */
	public List<Page> getPages() {
		return pages;
	}
	
	/**
	 * set the pages of the document
	 * 
	 * @param List<Page>
	 * @return void
	 */
	public void setPages(List<Page> pages) {
		this.pages = pages;
	}
	
	/**
	 * clone the document
	 * 
	 * @return document
	 */
	public DocumentEntity clone() {
		DocumentEntity newDocument = new DocumentEntity();
		
		newDocument.name = this.name;
		newDocument.author = this.author;
		newDocument.version = this.version;
		newDocument.description = this.description;
		
		for(int index=0; index<this.getPages().size(); index++) {
			newDocument.pages.add( this.pages.get(index).clone() );
		}

		return newDocument;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((pages == null) ? 0 : pages.hashCode());
		result = prime * result + ((version == null) ? 0 : version.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DocumentEntity other = (DocumentEntity) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (pages == null) {
			if (other.pages != null)
				return false;
		} else if (!pages.equals(other.pages))
			return false;
		if (version == null) {
			if (other.version != null)
				return false;
		} else if (!version.equals(other.version))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "DocumentEntity [name=" + name + ", author=" + author + ", version=" + version + ", description="
				+ description + ", pages=" + pages + "]";
	}

	
}
