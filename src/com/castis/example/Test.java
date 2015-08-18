package com.castis.example;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MenuView view = new MenuView();
		MenuModel model = new MenuModel();
		model.registerObserver(view);
		MenuController controller = new MenuController(model, view);
		view.setVisible(true);
	}

}
