import java.awt.*;

import java.awt.event.*;

import javax.swing.*;

public class Combos extends JPanel implements ActionListener{ //makin' some notes over a year after creating this
	
	String[] typeList = {"Normal", "Fighting", "Flying", "Poison", "Ground", "Rock", "Bug", "Ghost", "Steel", "Fire", 
			"Water", "Grass", "Electric", "Psychic", "Ice", "Dragon", "Dark", "Fairy", "(none)"};
	int[] nVals=new int[18],wVals=new int[18],wVals2=new int[18],rVals=new int[18],rVals2=new int[18],iVals=new int[18];
	//    neutral           weak              very weak          resistant         very resistant     immune           
	JComboBox type2 = new JComboBox(typeList);
	JComboBox type1 = new JComboBox(typeList);
	
	public Combos(){
		super(new GridLayout(21,6));
		int[][]mats = {nVals, wVals, wVals2, rVals, rVals2, iVals};
		int i=18;
		for(int[] mat:mats){ //Gives each interaction a list of positions to put its labels (tells it which column to use)
			for(int j=i,k=0;k<18;j+=6,k++) //e.g. neutral ineraction uses column 1, which is panels 18, 24, etc.
				mat[k]=j;
			i++;
		}
	}
	
	private void setUpPanels(){
		for(int i=0;i<126;i++)
			add(new JLabel(" "));
		type1.setSelectedIndex(18); //18 is (none)
		type2.setSelectedIndex(18);
		type1.addActionListener(this);
		type2.addActionListener(this);
		set(new JLabel("Type 1:"),1);
		set(type1,2);
		set(new JLabel("Type 2:"),3);
		set(type2,4);
		set(new JLabel("1x"),12);
		set(new JLabel("2x"),13);
		set(new JLabel("4x"),14);
		set(new JLabel(".5x"),15);
		set(new JLabel(".25x"),16);
		set(new JLabel("0x"),17);
		for(int i=18;i<24;i++)
			set(new JLabel("none"),i);
	}
	
	public void run(){
		JFrame frame = new JFrame("Type Combination Charts");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setUpPanels();
		frame.add(this);
		frame.pack();
	    frame.setLocation(430, 100);
	    this.setVisible(true);
		frame.setVisible(true);
	}
	
	private Component set(Component comp, int index){ //was this seriously not already a method?
		remove(index);
		add(comp, index);
		return comp;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) { //the only action is selecting a new type
		updatePanel();
	}

	private void updatePanel() {
		for(int i=18;i<126;i++){ //clear all the listed types
			JLabel lbl = (JLabel)getComponent(i);
			lbl.setText(" ");
		}
		int t1 = type1.getSelectedIndex();
		int t2 = type2.getSelectedIndex();
		String ts; //"type string"
		int[] mat;
		for(int i=0;i<18;i++){ //for each attacking type
			double ef=0;
			if(t1 == 18 && t2 == 18){ //if both types are (none), all columns should list no types
				for(int j=18;j<24;j++){
					set(new JLabel("none"),j);
				}
			}
			else if(t2 == 18){ //if one type is (none) and I try to feed it to that last else, the program crashes
				ef = Types.chart[i][t1]; //because (none) is not in the type chart
			}
			else if(t1 == 18){ //turn a combination with only a secondary into a combination with only a primary
				type1.setSelectedIndex(t2); //by sending it to the next if statement
			}
			else{ //normal
				ef = Types.chart[i][t1]*Types.chart[i][t2];
			}
			if(t1 == t2 && t1 != 18){ //turn a combination with two of the same type into a combination with only a primary
				type2.setSelectedIndex(18); //The other case gets sent here because if it doesn't
				ef = Types.chart[i][t1];    //then Fairy is displayed twice for some reason.
			}
			int eff = (int) (ef*100); //switch doesn't like doubles I guess
			switch(i){ //what type are we looking at?
			case 0: ts = "Normal";
			break;
			case 1: ts = "Fighting";
			break;
			case 2: ts = "Flying";
			break;
			case 3: ts = "Poison";
			break;
			case 4: ts = "Ground";
			break;
			case 5: ts = "Rock";
			break;
			case 6: ts = "Bug";
			break;
			case 7: ts = "Ghost";
			break;
			case 8: ts = "Steel";
			break;
			case 9: ts = "Fire";
			break;
			case 10: ts = "Water";
			break;
			case 11: ts = "Grass";
			break;
			case 12: ts = "Electric";
			break;
			case 13: ts = "Psychic";
			break;
			case 14: ts = "Ice";
			break;
			case 15: ts = "Dragon";
			break;
			case 16: ts = "Dark";
			break;
			case 17: ts = "Fairy";
			break;
			default: ts = "what";
			break;
			}
			switch(eff){ //based on effectiveness, what column are we going to?
			case 100: mat = nVals; //each global array corresponds to a column, which was set up in the constructor
			break;
			case 200: mat = wVals; //Why did I call it mat? It's an array.
			break;
			case 400: mat = wVals2; //oh well
			break;
			case 50: mat = rVals;
			break;
			case 25: mat = rVals2;
			break;
			case 0: mat = iVals;
			break;
			default: mat = null;
			break;
			}
			for(int j=0;j<18;j++){ //put it in the column
				JLabel lbl = (JLabel)getComponent(mat[j]);
				if(lbl.getText().equals("none")) //stop searching the column if both types are (none)
					j=18;
				if(lbl.getText().equals(" ")){ //write the type to the first empty spot in the column, then stop searching
					set(new JLabel(ts),mat[j]);
					j=18;
				}
			}
		}
		for(int i=18;i<24;i++){ //hit each empty column with a "none"
			JLabel lbl = (JLabel)getComponent(i);
			if(lbl.getText().equals(" "))
				set(new JLabel("none"),i);
		}
	}

}
