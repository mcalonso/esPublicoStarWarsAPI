package com.Espublico.StarWarsAPI.Mapper;

import java.io.Serializable;

public class ObjectList implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer count;
	private String next;
	private String previous;
	
    public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getNext() {
		return next;
	}

	public void setNext(String next) {
		this.next = next;
	}

	public String getPrevious() {
		return previous;
	}

	public void setPrevious(String previous) {
		this.previous = previous;
	}

	@Override
	public String toString() {
		return "FilmList [count=" + count + ", next=" + next + ", previous=" + previous + "]";
	}
}
