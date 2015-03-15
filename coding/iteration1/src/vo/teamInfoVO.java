package vo;

public class teamInfoVO {
	private String teamName;//�������
	private int gamesPlayed;//��������
	private int fieldGoalsMade;//Ͷ��������
	private int fieldGoalsAttempted;//Ͷ��������
	private int threePointFieldGoalsMade;//����������
	private int threePointFieldGoalsAttempted;//���ֳ�����
	private int freeThrowsMade;//����������
	private int freeThrowsAttempted;//���������
	private int offensiveRebounds;//����������
	private int defensiveRebounds;//����������
	private int rebounds;//������
	private int assists;//������
	private int steals;//������
	private int blocks;//��ñ��
	private int turnovers;//ʧ����
	private int fouls;//������
	private int points;//�÷���
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
	
	private String fullName;		//���ȫ��
	private String abbreviation;	//��д
	private String city;			//���ڵ�
	private String zone;			//����
	private String subarea;			//����
	private String homeCourt;		//����
	private String createTime;		//����ʱ��

	
	
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
	
	public int getFieldGoalsMade() {
		return fieldGoalsMade;
	}
	public void setFieldGoalsMade(int fieldGoalsMade) {
		this.fieldGoalsMade = fieldGoalsMade;
	}
		
	public int getFieldGoalsAttempted() {
		return fieldGoalsAttempted;
	}
	public void setFieldGoalsAttempted(int fieldGoalsAttempted) {
		this.fieldGoalsAttempted = fieldGoalsAttempted;
	}
	public int getThreePointFieldGoalsMade() {
		return threePointFieldGoalsMade;
	}
	public void setThreePointFieldGoalsMade(int threePointFieldGoalsMade) {
		this.threePointFieldGoalsMade = threePointFieldGoalsMade;
	}
	public int getThreePointFieldGoalsAttempted() {
		return threePointFieldGoalsAttempted;
	}
	public void setThreePointFieldGoalsAttempted(
			int threePointFieldGoalsAttempted) {
		this.threePointFieldGoalsAttempted = threePointFieldGoalsAttempted;
	}
	public int getFreeThrowsMade() {
		return freeThrowsMade;
	}
	public void setFreeThrowsMade(int freeThrowsMade) {
		this.freeThrowsMade = freeThrowsMade;
	}
	public int getFreeThrowsAttempted() {
		return freeThrowsAttempted;
	}
	public void setFreeThrowsAttempted(int freeThrowsAttempted) {
		this.freeThrowsAttempted = freeThrowsAttempted;
	}
	public int getOffensiveRebounds() {
		return offensiveRebounds;
	}
	public void setOffensiveRebounds(int offensiveRebounds) {
		this.offensiveRebounds = offensiveRebounds;
	}
	public int getDefensiveRebounds() {
		return defensiveRebounds;
	}
	public void setDefensiveRebounds(int defensiveRebounds) {
		this.defensiveRebounds = defensiveRebounds;
	}
	public int getRebounds() {
		return rebounds;
	}
	public void setRebounds(int rebounds) {
		this.rebounds = rebounds;
	}
	public int getAssists() {
		return assists;
	}
	public void setAssists(int assists) {
		this.assists = assists;
	}
	public int getSteals() {
		return steals;
	}
	public void setSteals(int steals) {
		this.steals = steals;
	}
	public int getBlocks() {
		return blocks;
	}
	public void setBlocks(int blocks) {
		this.blocks = blocks;
	}
	public int getTurnovers() {
		return turnovers;
	}
	public void setTurnovers(int turnovers) {
		this.turnovers = turnovers;
	}
	public int getFouls() {
		return fouls;
	}
	public void setFouls(int fouls) {
		this.fouls = fouls;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
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


	public String getFullName() {
		return fullName;
	}


	public void setFullName(String fullName) {
		this.fullName = fullName;
	}


	public String getAbbreviation() {
		return abbreviation;
	}


	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getZone() {
		return zone;
	}


	public void setZone(String zone) {
		this.zone = zone;
	}


	public String getSubarea() {
		return subarea;
	}


	public void setSubarea(String subarea) {
		this.subarea = subarea;
	}


	public String getHomeCourt() {
		return homeCourt;
	}


	public void setHomeCourt(String homeCourt) {
		this.homeCourt = homeCourt;
	}


	public String getCreateTime() {
		return createTime;
	}


	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	
	
	
	

}
