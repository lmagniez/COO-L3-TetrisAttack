package com.Model;

import com.Observer.Observer;

public class ModelJeux extends AbstractModel{

	private Observer jeux1j;
	
	public ModelJeux(Observer j) {
		jeux1j=j;
	}
	
	public void updateTime(int minute, int seconde) {
		String Sminute,Sseconde;
		
		if(minute==0)Sminute="00";
		else if(minute<10)Sminute="0"+minute;
		else Sminute=Integer.toString(minute);
		
		if(seconde==0)Sseconde="00";
		else if(seconde<10)Sseconde="0"+seconde;
		else Sseconde=Integer.toString(seconde);
		
		jeux1j.updateTimer(Sminute,Sseconde);
	}
	


}
