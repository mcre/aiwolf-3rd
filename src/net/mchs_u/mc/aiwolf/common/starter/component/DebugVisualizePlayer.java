package net.mchs_u.mc.aiwolf.common.starter.component;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;

import org.aiwolf.common.data.Agent;
import org.aiwolf.common.net.GameInfo;
import org.aiwolf.common.net.GameSetting;

import net.mchs_u.mc.aiwolf.common.AbstractEstimate;
import net.mchs_u.mc.aiwolf.common.EstimatePlayer;

public class DebugVisualizePlayer implements EstimatePlayer {
	private EstimatePlayer player;
	
	private JFrame frame = null;
	private List<EstimateGraph> estimateGraphs = null;

	public DebugVisualizePlayer(EstimatePlayer player) {
		this.player = player;
	}
	
	public String getName() {
		return player.getName();
	}
	
	public void update(GameInfo gameInfo) {
		player.update(gameInfo);
		debugEstimateRefresh();
	}
	
	public void initialize(GameInfo gameInfo, GameSetting gameSetting) {
		player.initialize(gameInfo, gameSetting);
		
		estimateGraphs = new ArrayList<>();
		for(int i = 0; i < 3; i++)
			estimateGraphs.add(new EstimateGraph(gameSetting.getPlayerNum()));
		
		frame = new JFrame("debug");
		frame.setSize(400, 800);
		frame.setLocation(1030, 0);
		
		GridLayout gl = new GridLayout(3,1);
		gl.setVgap(50);
		frame.setLayout(gl);
		
		for(EstimateGraph eg: estimateGraphs)
			frame.add(eg);
		
		frame.setVisible(true);
		
		debugEstimateRefresh();
	}
	
	public void dayStart() {
		player.dayStart();
	}

	public String talk() {
		return player.talk();
	}

	public String whisper() {
		return player.whisper();
	}

	public Agent vote() {
		return player.vote();
	}

	public Agent attack() {
		return player.attack();
	}

	public Agent divine() {
		return player.divine();
	}

	public Agent guard() {
		return player.guard();
	}

	public void finish() {
		player.finish();
		debugEstimateRefresh();
		frame.dispose();
	}
	
	public AbstractEstimate getObjectiveEstimate() {
		return player.getObjectiveEstimate();
	}

	public AbstractEstimate getSubjectiveEstimate() {
		return player.getSubjectiveEstimate();
	}

	public AbstractEstimate getPretendVillagerEstimate() {
		return player.getPretendVillagerEstimate();
	}
	
	private void debugEstimateRefresh(){
		estimateGraphs.get(0).refreshVillagerTeamLikeness(player.getSubjectiveEstimate().getVillagerTeamLikeness());
		estimateGraphs.get(0).refreshWerewolfLikeness(player.getSubjectiveEstimate().getWerewolfLikeness());
		
		estimateGraphs.get(1).refreshVillagerTeamLikeness(player.getObjectiveEstimate().getVillagerTeamLikeness());
		estimateGraphs.get(1).refreshWerewolfLikeness(player.getObjectiveEstimate().getWerewolfLikeness());
		Map<Agent, Double> v = player.getObjectiveEstimate().getVillagerTeamLikeness();
		Map<Agent, Double> w = player.getObjectiveEstimate().getWerewolfLikeness();
		for(Agent a: v.keySet()) {
			System.out.println(a + ", " + (1 - v.get(a) - w.get(a)) + ", " + v.get(a) + ", " + w.get(a));
		}
		
		
		estimateGraphs.get(2).refreshVillagerTeamLikeness(player.getPretendVillagerEstimate().getVillagerTeamLikeness());
		estimateGraphs.get(2).refreshWerewolfLikeness(player.getPretendVillagerEstimate().getWerewolfLikeness());
	}

	@Override
	public Agent getVoteTarget() {
		return player.getVoteTarget();
	}

}
