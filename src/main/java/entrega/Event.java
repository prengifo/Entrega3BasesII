package main.java.entrega;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Event")
public class Event {
	
	@Id 
	@GeneratedValue
	private Long id;

	@Column(name="title")
    private String title;
	
	@Column(name="date")
    private Date date;

    public Event() {}

    public Event(String title, Date date) {
		super();
		this.title = title;
		this.date = date;
	}

	public Long getId() {
        return id;
    }

    private void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
