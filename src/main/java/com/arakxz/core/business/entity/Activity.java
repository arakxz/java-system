package com.arakxz.core.business.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;

@Entity
@Table(name = "activities")
public class Activity {

    public static final int STATUS_OPEN = 1;
    public static final int STATUS_IN_PROCESS = 2;
    public static final int STATUS_CLOSED = 3;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @ManyToOne(
            fetch = FetchType.LAZY,
            optional = false
    )
    @JoinColumn(
            name = "id_author",
            nullable = false
    )
    private User author;
    
    
    @ManyToOne(
            fetch = FetchType.LAZY,
            optional = true
    )
    @JoinColumn(
            name = "id_calendar",
            nullable = true
    )
    private Calendar calendar;
    
    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;
    
    @Column(nullable = false)
    private Date created;
    
    @OneToMany(
    		cascade = CascadeType.ALL,
    		fetch = FetchType.LAZY,
            mappedBy = "activity"
    )
    private List<File> files;
    
    @ManyToOne(
            fetch = FetchType.LAZY,
            optional = true
    )
    @JoinColumn(
            name = "id_responsible",
            nullable = true
    )
    private User responsible;
    
    @Column(nullable = false)
    private int status;
    
    @Column(nullable = false)
    private String title;
    
    public Activity() {
        
    }

    @PrePersist
    protected void onCreate() {        
        this.created = new Date();
        this.status = STATUS_OPEN;
    }

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the author
	 */
	public User getAuthor() {
		return author;
	}

	/**
	 * @param author the author to set
	 */
	public void setAuthor(User author) {
		this.author = author;
	}

	/**
	 * @return the calendar
	 */
	public Calendar getCalendar() {
		return calendar;
	}

	/**
	 * @param calendar the calendar to set
	 */
	public void setCalendar(Calendar calendar) {
		this.calendar = calendar;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return the created
	 */
	public Date getCreated() {
		return created;
	}

	/**
	 * @param created the created to set
	 */
	public void setCreated(Date created) {
		this.created = created;
	}

	/**
	 * @return the files
	 */
	public List<File> getFiles() {
		return files;
	}

	/**
	 * @param files the files to set
	 */
	public void setFiles(List<File> files) {
		this.files = files;
	}

	/**
	 * @return the responsible
	 */
	public User getResponsible() {
		return responsible;
	}

	/**
	 * @param responsible the responsible to set
	 */
	public void setResponsible(User responsible) {
		this.responsible = responsible;
	}

	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

}
