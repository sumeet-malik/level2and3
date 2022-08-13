package CodeForStrategy;

import CodeForStrategy.Kicks.*;
import CodeForStrategy.Punches.*;
import CodeForStrategy.Wrestle.*;

public class Fighter {
	IKickingBehaviour kb;
	IPunchingBehaviour pb;
	IWrestlingBehaviour wb;
	
	Fighter(){
		this.kb = new RoundHouseKick();
		this.wb = new ChokeMove();
		this.pb = new HookPunch();
	}
	
	void fight() {
		pb.punch();
		kb.kick();
		wb.wrestle();
	}
}
