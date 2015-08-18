package com.castis.example;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class MenuView extends JFrame implements Observer {
	private JButton prev = new JButton("이전");
	private JButton next = new JButton("다음");
	private JPanel menuPanel = new JPanel();
	private MenuModel model = new MenuModel();
	private ArrayList<String> title = model.getArrTitle();
	private int startIndex = model.getStartIndex();
	private int endIndex = model.getEndIndex();
	private int totalCount = model.getTotCnt();
	private int pageSize = 5;
	private JLabel[] titleLabel = new JLabel[pageSize];

	public MenuView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 200);
		setLayout(new BorderLayout());
		
		menuPanel.add(prev);
		for (int i = 0; i < pageSize; i++){
			titleLabel[i] = new JLabel(title.get(i));
			titleLabel[i].setEnabled(false);
			titleLabel[startIndex].setEnabled(true);
			menuPanel.add(titleLabel[i]);
		}
		menuPanel.add(next);
		add(menuPanel);
	}

	public void setFocus(int currentIndex){
		for(int i = 0; i <= endIndex; i++){
			if (currentIndex > endIndex){
				titleLabel[i].setEnabled(false);
				titleLabel[endIndex].requestFocusInWindow();
				titleLabel[endIndex].setEnabled(true);
			}else if (currentIndex <= startIndex){
				titleLabel[i].setEnabled(false);
				titleLabel[startIndex].requestFocusInWindow();
				titleLabel[startIndex].setEnabled(true);
			}else{
				titleLabel[i].setEnabled(false);
				titleLabel[currentIndex].requestFocusInWindow();
				titleLabel[currentIndex].setEnabled(true);
			}
		}
	}
	
	public void repaintLabel(int currentIndex){
		int cur = currentIndex - (pageSize - 1);
		if (cur < 0) {
			cur = cur + totalCount;
		}
		for (int i = 0; i <= endIndex; i++) {
			if (cur > (totalCount - 1)){
				cur = startIndex;
			}else if(cur < startIndex){
				cur = (totalCount - 1);
			}
			titleLabel[i].setText(title.get(cur));
			cur+=1;
		}
	}
	
	public void labelInit(){
		for (int i = 0; i < pageSize; i++){
			titleLabel[i].setText(title.get(i));
		}
	}
	
	public void rePaint(int currentIndex) {
		if (currentIndex >= endIndex){
			repaintLabel(currentIndex);
			setFocus(currentIndex);
		}else{
			labelInit();
			setFocus(currentIndex);
		}
		menuPanel.updateUI();
		prev.requestFocus();
	}

	public void setMenuListener(KeyListener listener) {
		prev.addKeyListener(listener);
		next.addKeyListener(listener);
	}
	
	@Override
	public void update(int currentIndex) {
		rePaint(currentIndex);
	}
}
