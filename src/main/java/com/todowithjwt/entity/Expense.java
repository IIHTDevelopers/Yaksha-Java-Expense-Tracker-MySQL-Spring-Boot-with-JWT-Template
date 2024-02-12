package com.todowithjwt.entity;

import java.util.Date;

public class Expense {

	private Long id;

	private String name;

	private Double amount;

	private String category;

	private Date date;

	private String note;

	private User user;

	public Expense() {
		super();
	}

	public Expense(Long id, String name, Double amount, String category, Date date, String note, User user) {
		super();
		this.id = id;
		this.name = name;
		this.amount = amount;
		this.category = category;
		this.date = date;
		this.note = note;
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Override
	public String toString() {
		return "Expense [id=" + id + ", name=" + name + ", amount=" + amount + ", category=" + category + ", date="
				+ date + ", note=" + note + ", user=" + user + "]";
	}
}
