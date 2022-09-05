package app.mygame;

import java.awt.*;
import java.net.URL;

import io.quickchart.QuickChart;

public class HistoryView {
	
	

	public void displaychart() {
		// TODO Auto-generated method stub
		QuickChart chart = new QuickChart();
		chart.setWidth(500);
		chart.setHeight(300);
		chart.setConfig("{"
				+"      type: 'pie',"
				+"      data:  {"
				+"      labels: ['Level1', 'Level2'],"
				+"       datasets: [{"
				+"           label: 'Dataset 1',"
				+"           data: [8, 4],"
				+"       }]"
				+"    }"
				+"}"
		);
		
		try {
			Desktop.getDesktop().browse(new URL(chart.getUrl()).toURI());
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		

	}

}
