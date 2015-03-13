package vo;

public class teamInfoVO {
	private String teamName;//�������
	private int gamesPlayed;//��������
	private double fieldGoalsMade;//Ͷ��������
	private double fieldGoalsAttempted;//Ͷ��������
	private double threePointFieldGoalsMade;//����������
	private double threePointFieldGoalsAttempted;//���ֳ�����
	private double freeThrowsMade;//����������
	private double freeThrowsAttempted;//���������
	private double offensiveRebounds;//����������
	private double defensiveRebounds;//����������
	private double rebounds;//������
	private double assists;//������
	private double steals;//������
	private double blocks;//��ñ��
	private double turnovers;//ʧ����
	private double fouls;//������
	private double points;//ʧ����
	private double fieldGoalPercentage;//Ͷ��������
	private double threePointFieldGoalPercentage;//����������
	private double freeThrowPercentage;//����������
	private double winPercentage;//ʤ��
	private double possessions;//�����غ�
	private double offensiveRating;//����Ч��
	private double defensiveRating;//����Ч��
	private double offensiveReboundPercentage;//��������Ч��
	private double defensiveReboundPercentage;//��������Ч��
	private double stealPercentage;//����Ч��
	private double assisyPercentage;//������
	
	
	public teamInfoVO(){
		
	}
	
	
	public void setTeamName(String tn){
		teamName=tn;
	}
	public String getTeamName(){
		return teamName;
	}
	
	public void setgamesPlayed(int gp){
		gamesPlayed=gp;
	}
	public int getgamesPlayed(){
		return gamesPlayed;
	}
	
	public double getFieldGoalsMade() {
		return fieldGoalsMade;
	}
	public void setFieldGoalsMade(double fieldGoalsMade) {
		this.fieldGoalsMade = fieldGoalsMade;
	}
		
	public double getFieldGoalsAttempted() {
		return fieldGoalsAttempted;
	}
	public void setFieldGoalsAttempted(double fieldGoalsAttempted) {
		this.fieldGoalsAttempted = fieldGoalsAttempted;
	}
	public double getThreePointFieldGoalsMade() {
		return threePointFieldGoalsMade;
	}
	public void setThreePointFieldGoalsMade(double threePointFieldGoalsMade) {
		this.threePointFieldGoalsMade = threePointFieldGoalsMade;
	}
	public double getThreePointFieldGoalsAttempted() {
		return threePointFieldGoalsAttempted;
	}
	public void setThreePointFieldGoalsAttempted(
			double threePointFieldGoalsAttempted) {
		this.threePointFieldGoalsAttempted = threePointFieldGoalsAttempted;
	}
	public double getFreeThrowsMade() {
		return freeThrowsMade;
	}
	public void setFreeThrowsMade(double freeThrowsMade) {
		this.freeThrowsMade = freeThrowsMade;
	}
	public double getFreeThrowsAttempted() {
		return freeThrowsAttempted;
	}
	public void setFreeThrowsAttempted(double freeThrowsAttempted) {
		this.freeThrowsAttempted = freeThrowsAttempted;
	}
	public double getOffensiveRebounds() {
		return offensiveRebounds;
	}
	public void setOffensiveRebounds(double offensiveRebounds) {
		this.offensiveRebounds = offensiveRebounds;
	}
	public double getDefensiveRebounds() {
		return defensiveRebounds;
	}
	public void setDefensiveRebounds(double defensiveRebounds) {
		this.defensiveRebounds = defensiveRebounds;
	}
	public double getRebounds() {
		return rebounds;
	}
	public void setRebounds(double rebounds) {
		this.rebounds = rebounds;
	}
	public double getAssists() {
		return assists;
	}
	public void setAssists(double assists) {
		this.assists = assists;
	}
	public double getSteals() {
		return steals;
	}
	public void setSteals(double steals) {
		this.steals = steals;
	}
	public double getBlocks() {
		return blocks;
	}
	public void setBlocks(double blocks) {
		this.blocks = blocks;
	}
	public double getTurnovers() {
		return turnovers;
	}
	public void setTurnovers(double turnovers) {
		this.turnovers = turnovers;
	}
	public double getFouls() {
		return fouls;
	}
	public void setFouls(double fouls) {
		this.fouls = fouls;
	}
	public double getPoints() {
		return points;
	}
	public void setPoints(double points) {
		this.points = points;
	}
	public double getFieldGoalPercentage() {
		return fieldGoalPercentage;
	}
	public void setFieldGoalPercentage(double fieldGoalPercentage) {
		this.fieldGoalPercentage = fieldGoalPercentage;
	}
	public double getThreePointFieldGoalPercentage() {
		return threePointFieldGoalPercentage;
	}
	public void setThreePointFieldGoalPercentage(
			double threePointFieldGoalPercentage) {
		this.threePointFieldGoalPercentage = threePointFieldGoalPercentage;
	}
	public double getFreeThrowPercentage() {
		return freeThrowPercentage;
	}
	public void setFreeThrowPercentage(double freeThrowPercentage) {
		this.freeThrowPercentage = freeThrowPercentage;
	}
	public double getWinPercentage() {
		return winPercentage;
	}
	public void setWinPercentage(double winPercentage) {
		this.winPercentage = winPercentage;
	}
	public double getPossessions() {
		return possessions;
	}
	public void setPossessions(double possessions) {
		this.possessions = possessions;
	}
	public double getOffensiveRating() {
		return offensiveRating;
	}
	public void setOffensiveRating(double offensiveRating) {
		this.offensiveRating = offensiveRating;
	}
	public double getDefensiveRating() {
		return defensiveRating;
	}
	public void setDefensiveRating(double defensiveRating) {
		this.defensiveRating = defensiveRating;
	}
	public double getOffensiveReboundPercentage() {
		return offensiveReboundPercentage;
	}
	public void setOffensiveReboundPercentage(double offensiveReboundPercentage) {
		this.offensiveReboundPercentage = offensiveReboundPercentage;
	}
	public double getDefensiveReboundPercentage() {
		return defensiveReboundPercentage;
	}
	public void setDefensiveReboundPercentage(double defensiveReboundPercentage) {
		this.defensiveReboundPercentage = defensiveReboundPercentage;
	}
	public double getStealPercentage() {
		return stealPercentage;
	}
	public void setStealPercentage(double stealPercentage) {
		this.stealPercentage = stealPercentage;
	}
	public double getAssisyPercentage() {
		return assisyPercentage;
	}
	public void setAssisyPercentage(double assisyPercentage) {
		this.assisyPercentage = assisyPercentage;
	}
	
	
	
	

}
