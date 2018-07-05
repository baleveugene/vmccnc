package com.springapp.mvc.util.compare.lines;


import com.springapp.mvc.domain.lines.AutomatedLine;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
//@Service
public class CompareCartItemAutomatedLine {
    
AutomatedLine automatedLine;
short quantity;


public CompareCartItemAutomatedLine(AutomatedLine automatedLine) {
this.automatedLine =  automatedLine;
quantity = 1;
}

public AutomatedLine  getProduct() {
return  automatedLine;
}


public short getQuantity() {
return quantity;
}


public void setQuantity(short quantity) {
this.quantity = quantity;
}


public void incrementQuantity() {
quantity++;
}


public void decrementQuantity() {
quantity--;
}


public double getTotal() {
double amount = 0;
//amount = (this.getQuantity() *  hmc.getCost().doubleValue());
amount = (this.getQuantity() *  automatedLine.getPrice());
return amount;
}  

    @Override
    public String toString() {
        return "CompareCartItem{" + "hmc=" + automatedLine + ", quantity=" + quantity + '}';
    }



}
