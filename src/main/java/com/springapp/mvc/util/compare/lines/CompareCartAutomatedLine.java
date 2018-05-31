
package com.springapp.mvc.util.compare.lines;

import com.springapp.mvc.domain.lines.AutomatedLine;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

//@Service 
public class CompareCartAutomatedLine {
    
   List<CompareCartItemAutomatedLine> items;
int numberOfItems;
//double total;
 
        public CompareCartAutomatedLine() {
            items = new ArrayList<CompareCartItemAutomatedLine>();
            numberOfItems = 0;
//            total = 0;
        }
  
        public synchronized void addItem(AutomatedLine automatedLine) {

                        boolean newItem = true;
                        for (CompareCartItemAutomatedLine scItem : items) {
                        if (scItem.getProduct().getId().
                                                        equals(automatedLine.getId())) {
                        newItem = false;
//                        scItem.incrementQuantity();
                }
                }

                if (newItem) {
                CompareCartItemAutomatedLine scItem = new CompareCartItemAutomatedLine(automatedLine);
                items.add(scItem);
                }
        }  
        
     public synchronized void update (AutomatedLine automatedLine, String quantity) {
           
               
 short qty = -1;
                // cast quantity as short
                qty = Short.parseShort(quantity);
                if (qty >= 0) {
                CompareCartItemAutomatedLine item = null;
                for (CompareCartItemAutomatedLine scItem : items) {
                if (scItem.getProduct().getId().
                                                equals(automatedLine.getId())) {
                if (qty != 0) {
                // set item quantity to new value
                scItem.setQuantity(qty);
                } else {
                // if quantity equals 0, save item and break
                item = scItem;
                break;
                }
                }
                }

                if (item != null) {
                // remove from cart

                items.remove(item);
                }
                }
     } 
        
public synchronized int getNumberOfItems() {

numberOfItems = 0;
for (CompareCartItemAutomatedLine scItem : items) {
numberOfItems += scItem.getQuantity();
}
return numberOfItems;
}

    public List<CompareCartItemAutomatedLine> getItems() {
        return items;
    }    
}
