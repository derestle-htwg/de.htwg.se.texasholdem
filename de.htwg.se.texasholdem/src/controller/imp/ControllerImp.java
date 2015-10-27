package controller.imp;

import model.ModelFactory;
import controller.Controller;

public class ControllerImp implements Controller{
	private ModelFactory modelFactory;
	public ControllerImp(ModelFactory modelFactory){
		
	}
	public void startGame() {
		// TODO Auto-generated method stub
		
	}
	public ModelFactory getModelFactory() {
		return modelFactory;
	}
	public void setModelFactory(ModelFactory modelFactory) {
		this.modelFactory = modelFactory;
	}

}
