package po;

public class TeamPO {
	private String teamName;//球队名称
	private int gamesPlayed;//比赛场数
	private double fieldGoalsMade;//投篮命中数
	private double fieldGoalsAttempted;//投篮出手数
	private double threePointFieldGoalsMade;//三分命中数
	private double threePointFieldGoalsAttempted;//三分出手数
	private double freeThrowsMade;//罚球命中数
	private double freeThrowsAttempted;//罚球出手数
	private double offensiveRebounds;//进攻篮板数
	private double defensiveRebounds;//防守篮板数
	private double rebounds;//篮板数
	private double assists;//助攻数
	private double steals;//抢断数
	private double blocks;//盖帽数
	private double turnovers;//失误数
	private double fouls;//犯规数
	private double points;//得分数
	private double fieldGoalPercentage;//投篮命中率
	private double threePointFieldGoalPercentage;//三分命中率
	private double freeThrowPercentage;//罚球命中率
	private double winPercentage;//胜率
	private double possessions;//进攻回合
	private double offensiveRating;//进攻效率
	private double defensiveRating;//防守效率
	private double offensiveReboundPercentage;//进攻篮板效率
	private double defensiveReboundPercentage;//防守篮板效率
	private double stealPercentage;//抢断效率
	private double assistPercentage;//助攻率

	
	private String fullName;		//球队全名
	private String city;			//所在地
	private String zone;			//赛区
	private String subarea;			//分区
	private String homeCourt;		//主场
	private String createTime;		//创建时间
	private double gamesPlayedWin;

	public TeamPO(){
		teamName="";
		gamesPlayed=0;
		fieldGoalsMade=0;
		fieldGoalsAttempted=0;
		threePointFieldGoalsMade=0;
		threePointFieldGoalsAttempted=0;
		freeThrowsMade=0;
		freeThrowsAttempted=0;
		offensiveRebounds=0;
		defensiveRebounds=0;
		rebounds=0;
		 assists=0;
		steals=0;
		blocks=0;
		turnovers=0;
		fouls=0;
		points=0;
		fieldGoalPercentage=0;
		threePointFieldGoalPercentage=0;
		freeThrowPercentage=0;
		winPercentage=0;
		possessions=0;
		offensiveRating=0;
		defensiveRating=0;
		offensiveReboundPercentage=0;
		defensiveReboundPercentage=0;
		stealPercentage=0;
		assistPercentage=0;

		
		fullName="";		
		city="";			
		zone="";			
		subarea="";			
		homeCourt="";		
		createTime="";		
		setGamesPlayedWin(0);
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


	public double getGamesPlayedWin() {
		return gamesPlayedWin;
	}


	public void setGamesPlayedWin(double gamesPlayedWin) {
		this.gamesPlayedWin = gamesPlayedWin;
	}

}
