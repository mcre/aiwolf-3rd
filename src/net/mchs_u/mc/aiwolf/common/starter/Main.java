package net.mchs_u.mc.aiwolf.common.starter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import net.mchs_u.mc.aiwolf.common.starter.component.PlayerDefinition;

public class Main {	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {
		int set = 6;
		int times = 100;
		int playerNum = 15;
		boolean isVisualize = true;
		boolean isLog = false;
		boolean isSaveResult = true;
		
		List<PlayerDefinition> playerDefinitions = new ArrayList<>();
		playerDefinitions.add(new PlayerDefinition(net.mchs_u.mc.aiwolf.baikin04.McrePlayer.class, isVisualize, null, null));
		
		int count = 0;
		while(playerDefinitions.size() < playerNum){
			playerDefinitions.add(new PlayerDefinition(org.aiwolf.sample.player.SampleRoleAssignPlayer.class, false, null, String.format("smpl%02d", count++)));
		}
		
		DirectStarter ds = new DirectStarter(playerDefinitions, times, set, isVisualize, isLog, isSaveResult);
		ds.start();
	}
}