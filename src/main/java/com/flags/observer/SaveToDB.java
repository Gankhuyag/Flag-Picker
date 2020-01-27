package com.flags.observer;

import java.util.List;

import com.flags.model.Continent;

public class SaveToDB implements ICommand {
   private List<Continent> conti;

    @Override
    public void execute() {
     //   shoppingCart.add();
    }

    @Override
    public void undo() {
       // shoppingCart.remove();
    }

    @Override
    public void redo() {
       // shoppingCart.add();
    }

	public List<Continent> getConti() {
		return conti;
	}

	public void setConti(List<Continent> conti) {
		this.conti = conti;
	}

	public SaveToDB(List<Continent> conti) {
		super();
		this.conti = conti;
	}

	     
   /* public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public AddToCart(ShoppingCart shoppingCart) {
        super();
        this.shoppingCart = shoppingCart;
    }*/
}
