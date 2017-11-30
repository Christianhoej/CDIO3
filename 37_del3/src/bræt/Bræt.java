package bræt;


import java.awt.Color; 

import gui_fields.GUI_Chance;
import gui_fields.GUI_Field;
import gui_fields.GUI_Jail;
import gui_fields.GUI_Refuge;
import gui_fields.GUI_Start;
import gui_fields.GUI_Street;
import gui_main.GUI;
//import desktop_fields.*;
/**
 * Opretter spillepladen til Matador Junior
 * @author Gruppe 37
 *
 */



public class Bræt {	
	private GUI_Field[] fields = new GUI_Field[24];
	private AbstractFelter[] felter = new AbstractFelter[24];
	/**
	 * Laver alle felterne til spillepladen
	 * @return Felterne til spillepladen i et array
	 */
	
	public GUI_Field[] lavBræt() {
				
		fields[0] = new GUI_Start();
		fields[0].setTitle("Start");
		fields[0].setDescription("");
		fields[0].setSubText("");
		fields[0].setBackGroundColor(Color.RED);
		
		fields[1] = new GUI_Street();
		fields[1].setTitle("Burgerbaren");
		fields[1].setDescription("");
		fields[1].setSubText("");
		fields[1].setBackGroundColor(new Color(153,102,0)); // Light brown
		
		fields[2] = new GUI_Street();
		fields[2].setTitle("Pizzariaet");
		fields[2].setDescription("");
		fields[2].setSubText("");
		fields[2].setBackGroundColor(new Color(153,102,0)); // Light brown

		fields[3] = new GUI_Chance();
		
		fields[4] = new GUI_Street();
		fields[4].setTitle("Slikbutikken");
		fields[4].setDescription("");
		fields[4].setSubText("");
		fields[4].setBackGroundColor(new Color(51, 204, 255)); 
		
		fields[5] = new GUI_Street();
		fields[5].setTitle("Iskiosken");
		fields[5].setDescription("");
		fields[5].setSubText("");
		fields[5].setBackGroundColor(new Color(51, 204, 255));
		
		fields[6] = new GUI_Jail();
		fields[6].setSubText("På besøg");
		
		fields[7] = new GUI_Street();
		fields[7].setTitle("Museet");
		fields[7].setDescription("");
		fields[7].setSubText("");
		fields[7].setBackGroundColor(new Color(204, 0, 100)); // Red wine red
		
		fields[8] = new GUI_Street();
		fields[8].setTitle("Biblioteket");
		fields[8].setDescription("");
		fields[8].setSubText("");
		fields[8].setBackGroundColor(new Color(204, 0, 100)); // Red wine red
		
		fields[9] = new GUI_Chance();

		fields[10] = new GUI_Street();
		fields[10].setTitle("Skaterparken");
		fields[10].setDescription("");
		fields[10].setSubText("");
		fields[10].setBackGroundColor(Color.YELLOW);
		
		fields[11] = new GUI_Street();
		fields[11].setTitle("Swimmingpool");
		fields[11].setDescription("");
		fields[11].setSubText("");
		fields[11].setBackGroundColor(Color.YELLOW);
		
		fields[12] = new GUI_Refuge();
		fields[12].setDescription("Tag en pause");
		fields[12].setSubText("Gratis parkering");
		fields[12].setBackGroundColor(Color.white); //Very light red;
		
		fields[13] = new GUI_Street();
		fields[13].setTitle("Spillehallen");
		fields[13].setDescription("");
		fields[13].setSubText("");
		fields[13].setBackGroundColor(new Color(204, 0, 0)); //Dark red;
		
		fields[14] = new GUI_Street();
		fields[14].setTitle("Biografen");
		fields[14].setDescription("");
		fields[14].setSubText("");
		fields[14].setBackGroundColor(new Color(204, 0, 0)); //Dark red;
		
		fields[15] = new GUI_Chance();
		
		fields[16] = new GUI_Street();
		fields[16].setTitle("Lejetøjsbutikken");
		fields[16].setDescription("");
		fields[16].setSubText("");
		fields[16].setBackGroundColor(new Color(255, 153,0)); //Gold
	
		fields[17] = new GUI_Street();
		fields[17].setTitle("Dyrehaven");
		fields[17].setDescription("");
		fields[17].setSubText("");
		fields[17].setBackGroundColor(new Color(255, 153,0)); //Gold
		
		fields[18] = new GUI_Jail();
		fields[18].setTitle("Gå i fængsel");
		fields[18].setDescription("");
		fields[18].setSubText("Gå i fængsel");
		
		fields[19] = new GUI_Street();
		fields[19].setTitle("Bowlinghallen");
		fields[19].setDescription("");
		fields[19].setSubText("");
		fields[19].setBackGroundColor(new Color(0, 153, 0)); //Green
		
		fields[20] = new GUI_Street();
		fields[20].setTitle("Zoo");
		fields[20].setDescription("");
		fields[20].setSubText("");
		fields[20].setBackGroundColor(new Color(0, 153, 0)); //Green
		
		fields[21] = new GUI_Chance();
		
		fields[22] = new GUI_Street();
		fields[22].setTitle("Vandlandet");
		fields[22].setDescription("");
		fields[22].setSubText("");
		fields[22].setBackGroundColor(Color.BLUE); //Very light blue
		
		fields[23] = new GUI_Street();
		fields[23].setTitle("Stranpromaden");
		fields[23].setDescription("");
		fields[23].setSubText("");
		fields[23].setBackGroundColor(Color.BLUE); //Very light blue
			
		return fields;
	}
	
	public void samlFelter(GUI gui){
		felter[0] = new Start(0, gui); 
		felter[1] = new Ejendom(1, gui); 
		felter[2] = new Ejendom(2, gui);
		felter[3] = new Chance(3, gui);
		felter[4] = new Ejendom(4, gui);
		felter[5] = new Ejendom(5, gui);
		felter[6] = new Passiv(6, gui); 
		felter[7] = new Ejendom(7, gui);
		felter[8] = new Ejendom(8, gui);
		felter[9] = felter[3];
		felter[10] = new Ejendom(10, gui); 
		felter[11] = new Ejendom(11, gui); 
		felter[12] = new Passiv(12, gui); 
		felter[13] = new Ejendom(13, gui);
		felter[14] = new Ejendom(14, gui);
		felter[15] = felter[3];
		felter[16] = new Ejendom(16, gui);
		felter[17] = new Ejendom(17, gui);
		felter[18] = new Fængsel(18, gui);
		felter[19] = new Ejendom(19, gui);
		felter[20] = new Ejendom(20, gui);
		felter[21] = felter[3]; 
		felter[22] = new Ejendom(22, gui);
		felter[23] = new Ejendom(23, gui);
		
	}
	
	public AbstractFelter[] getSamlFelter(){
		return felter;
	}
}
