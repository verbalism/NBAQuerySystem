package po;

public class TeamPO {
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
	private double points;//�÷���
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
	private double assistPercentage;//������

	
	private String fullName;		//���ȫ��
	private String city;			//���ڵ�
	private String zone;			//����
	private String subarea;			//����
	private String homeCourt;		//����
	private String createTime;		//����ʱ��
	
	
	/*private int gamesPlayedWin;//Ӯ�õı���
	private double oppFieldGoalsMade;//����Ͷ��������
	private double oppFieldGoalsAttempted;//����Ͷ����
	private double oppFreeThrowsAttempted;//���ַ�����
	private double oppTurnovers;//����ʧ����
	private double oppSteals;//����������
	private double oppAssists;//����������
	private double oppOffensiveRebounds;//���ֽ���������
	private double oppDefensiveRebounds;//���ַ���������
	private double oppPoints;//���ֵ÷���
	private double oppPossessions;
	*/
	public TeamPO(){
		
	}
	
	
	public void setTeamName(String tn){
		teamName=tn;
	}
	public String getTeamName(){
		return teamName;
	}
	
	
	public int getGamesPlayed() {
		return gamesPlayed;
	}


	public void setGamesPlayed(int gamesPlayed) {
		this.gamesPlayed = gamesPlayed;
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
	public double getAssistPercentage() {
		return assistPercentage;
	}
	public void setAssistPercentage(double assisyPercentage) {
		this.assistPercentage = assisyPercentage;
	}


	public String getFullName() {
		return fullName;
	}


	public void setFullName(String fullName) {
		this.fullName = fullName;
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


	/*public int getGamesPlayedWin() {
		return gamesPlayedWin;
	}


	public void setGamesPlayedWin(int gamesPlayedWin) {
		this.gamesPlayedWin = gamesPlayedWin;
	}


	public double getOppFieldGoalsMade() {
		return oppFieldGoalsMade;
	}


	public void setOppFieldGoalsMade(double oppFieldGoalsMade) {
		this.oppFieldGoalsMade = oppFieldGoalsMade;
	}


	public double getOppFieldGoalsAttempted() {
		return oppFieldGoalsAttempted;
	}


	public void setOppFieldGoalsAttempted(double oppFieldGoalsAttempted) {
		this.oppFieldGoalsAttempted = oppFieldGoalsAttempted;
	}


	public double getOppFreeThrowsAttempted() {
		return oppFreeThrowsAttempted;
	}


	public void setOppFreeThrowsAttempted(double oppFreeThrowsAttempted) {
		this.oppFreeThrowsAttempted = oppFreeThrowsAttempted;
	}


	public double getOppTurnovers() {
		return oppTurnovers;
	}


	public void setOppTurnovers(double oppTurnovers) {
		this.oppTurnovers = oppTurnovers;
	}


	public double getOppSteals() {
		return oppSteals;
	}


	public void setOppSteals(double oppSteals) {
		this.oppSteals = oppSteals;
	}


	public double getOppAssists() {
		return oppAssists;
	}


	public void setOppAssists(double oppAssists) {
		this.oppAssists = oppAssists;
	}


	public double getOppOffensiveRebounds() {
		return oppOffensiveRebounds;
	}


	public void setOppOffensiveRebounds(double oppOffensiveRebounds) {
		this.oppOffensiveRebounds = oppOffensiveRebounds;
	}


	public double getOppDefensiveRebounds() {
		return oppDefensiveRebounds;
	}


	public void setOppDefensiveRebounds(double oppDefensiveRebounds) {
		this.oppDefensiveRebounds = oppDefensiveRebounds;
	}


	public double getOppPoints() {
		return oppPoints;
	}


	public void setOppPoints(double oppPoints) {
		this.oppPoints = oppPoints;
	}


	public double getOppPossessions() {
		return oppPossessions;
	}


	public void setOppPossessions(double oppPossessions) {
		this.oppPossessions = oppPossessions;
	}
	*/
	
	
	
}
