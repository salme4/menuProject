package com.castis.example;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MenuController implements KeyListener {
	private MenuModel model;
	private MenuView view;
	private int startIndex; 
	private int endIndex;
	private int totalCount;
	private int prevIndex;
	private int nextIndex;
	
	public MenuController(MenuModel model, MenuView view) {
		// TODO Auto-generated constructor stub
		this.model = model;
		this.view = view;
		this.view.setMenuListener(this);
		this.startIndex = model.getStartIndex();
		this.totalCount = model.getTotCnt();
	}

	
	public void moveToRight(){
		System.out.println("다음");
		if(model.getCurrentIndex() >= totalCount-1){
			//curretIndex 초기화
			model.setCurrentIndex(startIndex);
			indexStateChange(1);
		}else{
			model.pulsCurIndex();
			indexStateChange(1);
		}
	}
	
	public void moveToLeft(){
		System.out.println("이전");
		if(model.getCurrentIndex() <= startIndex){
			//curretIndex 초기화
			model.setCurrentIndex(totalCount - 1);
			indexStateChange(0);
		}else{
			model.minusCurIndex();
			indexStateChange(0);
		}
	}
	
	public void indexStateChange(int gubun){
		model.indexState(gubun);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int location = e.getKeyLocation();
		
		if (KeyEvent.VK_LEFT == e.getKeyCode()){
			moveToLeft();
		}else if(KeyEvent.VK_RIGHT == e.getKeyCode()){
			moveToRight();
		}else{
			return;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
