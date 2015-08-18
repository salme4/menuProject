package com.castis.example;

import java.util.ArrayList;

public class MenuModel {
	private int data;
	private ArrayList<Observer> list = new ArrayList<Observer>();
	private ArrayList<String> arrTitle = new ArrayList<String>();
	private int startIndex = 0;
	private int endIndex = 4;
	private int currentIndex;
	private int totalCount;
	private int gubun;
	
	public MenuModel() {
		// TODO Auto-generated constructor stub
		arrTitle.add("테스트1");
		arrTitle.add("테스트2");
		arrTitle.add("테스트3");
		arrTitle.add("테스트4");
		arrTitle.add("테스트5");
		arrTitle.add("테스트6");
		arrTitle.add("테스트7");
		arrTitle.add("테스트8");
		this.totalCount = arrTitle.size();
	}
	
	public int getTotCnt() {
		return totalCount;
	}
	
	public int getEndIndex() {
		return endIndex;
	}
	
	public void setEndIndex(int endIndex) {
		this.endIndex = endIndex;
	}
	
	public int getCurrentIndex() {
		return this.currentIndex;
	}
	public void setCurrentIndex(int currentIndex) {
		this.currentIndex = currentIndex;
	}
	public int getStartIndex() {
		return startIndex;
	}
	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}
	
	public ArrayList<String> getArrTitle() {
		return arrTitle;
	}
	public void indexState(int gubun){
		notifyObservers(gubun);
	}
	
	public void pulsCurIndex(){
		this.currentIndex = this.currentIndex + 1;
		System.out.println(currentIndex);
	}
	
	public void minusCurIndex(){
		this.currentIndex = this.currentIndex - 1;
	}
	
	public void registerObserver(Observer o){
		list.add(o);
	}
	
	
	public void notifyObservers(int gubun) {
		for(Observer o : list){
			System.out.println("currentIndex" + currentIndex);
			this.gubun = gubun;
			o.update(currentIndex);
		}
	}
}
