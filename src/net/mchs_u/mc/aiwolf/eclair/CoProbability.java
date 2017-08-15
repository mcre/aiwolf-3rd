package net.mchs_u.mc.aiwolf.eclair;

import java.util.HashMap;
import java.util.Map;

import org.aiwolf.common.data.Agent;
import org.aiwolf.common.data.Role;

import net.mchs_u.mc.aiwolf.common.Probabilities;
import net.mchs_u.mc.aiwolf.common.RoleCombination;

public class CoProbability {
	private Map<String, double[]> map = null;
	private Map<Integer, double[]> defaultMap = null;

	public CoProbability() {
		map = new HashMap<>();
		defaultMap = new HashMap<>();
		
		defaultMap.put( 5, new double[] { 1d/5d,   3d/5d,  1d/5d});
		defaultMap.put(15, new double[] {1d/15d, 11d/15d, 3d/15d});
		
		
		// POSSESSED, VILLAGER, WEREWOLF
		map.put("5,S1M0,S", new double[] {0.4305846, 0.5562893, 0.0131261});
		map.put("5,S2M0,S", new double[] {0.4675835, 0.4828296, 0.0495869});
		map.put("5,S3M0,S", new double[] {0.3323427, 0.3554930, 0.3121643});
		map.put("5,S4M0,S", new double[] {0.2500000, 0.5000000, 0.2500000});
		
		map.put("15,S0M1,M", new double[] {0.0091984, 0.9224704, 0.0683311});
		map.put("15,S0M2,M", new double[] {0.1327434, 0.4882006, 0.3790560});
		map.put("15,S0M3,M", new double[] {0.0869565, 0.3333333, 0.5797101});
		map.put("15,S1M0,S", new double[] {0.4133924, 0.5451024, 0.0415053});
		map.put("15,S1M1,M", new double[] {0.0020735, 0.9449820, 0.0529444});
		map.put("15,S1M1,S", new double[] {0.4048936, 0.5570915, 0.0380149});
		map.put("15,S1M2,M", new double[] {0.0343268, 0.4893560, 0.4763172});
		map.put("15,S1M2,S", new double[] {0.4092602, 0.5566791, 0.0340607});
		map.put("15,S1M3,M", new double[] {0.0186480, 0.3333333, 0.6480186});
		map.put("15,S1M3,S", new double[] {0.4055944, 0.5804196, 0.0139860});
		map.put("15,S1M4,M", new double[] {0.0000000, 0.2500000, 0.7500000});
		map.put("15,S1M4,S", new double[] {0.0000000, 1.0000000, 0.0000000});
		map.put("15,S2M0,S", new double[] {0.4479440, 0.4704724, 0.0815836});
		map.put("15,S2M1,M", new double[] {0.0008060, 0.9392632, 0.0599308});
		map.put("15,S2M1,S", new double[] {0.4394766, 0.4673083, 0.0932151});
		map.put("15,S2M2,M", new double[] {0.0130363, 0.4891089, 0.4978548});
		map.put("15,S2M2,S", new double[] {0.4511551, 0.4832508, 0.0655941});
		map.put("15,S2M3,M", new double[] {0.0057471, 0.3323755, 0.6618774});
		map.put("15,S2M3,S", new double[] {0.4698276, 0.4913793, 0.0387931});
		map.put("15,S2M4,M", new double[] {0.0000000, 0.2500000, 0.7500000});
		map.put("15,S2M4,S", new double[] {0.5000000, 0.5000000, 0.0000000});
		map.put("15,S3M0,S", new double[] {0.3216374, 0.3507472, 0.3276153});
		map.put("15,S3M1,M", new double[] {0.0008001, 0.9573276, 0.0418722});
		map.put("15,S3M1,S", new double[] {0.3188425, 0.3496911, 0.3314664});
		map.put("15,S3M2,M", new double[] {0.0055517, 0.4930604, 0.5013879});
		map.put("15,S3M2,S", new double[] {0.3215360, 0.3668749, 0.3115892});
		map.put("15,S3M3,M", new double[] {0.0000000, 0.3333333, 0.6666667});
		map.put("15,S3M3,S", new double[] {0.3278689, 0.3661202, 0.3060109});
		map.put("15,S4M0,S", new double[] {0.2471042, 0.3117761, 0.4411197});
		map.put("15,S4M1,M", new double[] {0.0000000, 0.9764151, 0.0235849});
		map.put("15,S4M1,S", new double[] {0.2476415, 0.2974646, 0.4548939});
		map.put("15,S4M2,M", new double[] {0.0058140, 0.4941860, 0.5000000});
		map.put("15,S4M2,S", new double[] {0.2470930, 0.3401163, 0.4127907});
		map.put("15,S5M0,S", new double[] {0.1750000, 0.2500000, 0.5750000});
		map.put("15,S5M1,M", new double[] {0.0000000, 0.9629630, 0.0370370});
		map.put("15,S5M1,S", new double[] {0.2000000, 0.3185185, 0.4814815});
		map.put("15,S5M2,M", new double[] {0.0000000, 0.5000000, 0.5000000});
		map.put("15,S5M2,S", new double[] {0.2000000, 0.4000000, 0.4000000});
		map.put("15,S6M1,M", new double[] {0.0000000, 1.0000000, 0.0000000});
		map.put("15,S6M1,S", new double[] {0.1666667, 0.3333333, 0.5000000});
	}
	
	public double[] getProbability(int playerNum, int coSeerNum, int coMediumNum, Role role) {
		if(role != Role.SEER && role != Role.MEDIUM)
			return null;
		String key = playerNum + ",S" + coSeerNum + "M" + coMediumNum + "," + role.toString().charAt(0);
		if(map.containsKey(key))
			return map.get(key);
		return null;
	}
	
	public void calc(Probabilities probs, Agent agent, int playerNum, int coSeerNum, int coMediumNum, Role role) {
		double[] rates = getProbability(playerNum, coSeerNum, coMediumNum, role);
		double[] def = defaultMap.get(playerNum);
		if(rates == null)
			return;
		for(RoleCombination rc: probs.getRoleCombinations()) {
			if(rc.isPossessed(agent))
				probs.update(rc, rates[0] / def[0]);
			if(rc.isVillagerTeam(agent))
				probs.update(rc, rates[1] / def[1]);			
			if(rc.isWerewolf(agent))
				probs.update(rc, rates[2] / def[2]);
		}
	}
}
