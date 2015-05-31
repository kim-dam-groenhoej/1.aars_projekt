package GuiLayer;

import javax.swing.JOptionPane;

public class RestaurantUI {

	public static void main(String[] args) {
		//RestaurantSelector RS = new RestaurantSelector();
		boolean found = false;
		while(!found){
			String id = (String) JOptionPane.showInputDialog("Restaurantid");
			System.out.println(id);
			int idd = 0;
			try{
				idd = Integer.parseInt(id);
				if(idd > 0){
					PartStepUI ui = new PartStepUI(idd);
					found = true;
				}else{
					JOptionPane.showMessageDialog(null, "Id skal være et tal over 0");
				}
			}
			catch(NumberFormatException ex){
				JOptionPane.showMessageDialog(null, "Id skal være et tal over 0");
			}			
			
		
		}		
	}

}

