package po;

public class PlayerPO {
	private String playerName;//球员名称
	private String teamName;//所属球队
	private int gamesPlayed;//参赛场数
	private int gamesStarting;//先发场数
	private double rebounds;//篮板数
	private double offensiveRebounds;//进攻篮板数
	private double defensiveRebounds;//防守篮板数
	private double assists;//助攻数
	private double minutes;//在场时间
	private double fieldGoalsAttempts;//投篮出手数
	private double fieldGoalsMade;//投篮命中数
	private double fieldGoalsPercentage;//投篮命中率
	private double threePointFieldGoalsAttempts;//三分出手数
	private double threePointFieldGoalsMade;//三分命中数
	private double threePointFieldGoalsPercentage;//三分命中率
	private double freeThrowsAttempts;//罚球出手数
	private double freeThrowsMade;//罚球命中数
	private double freeThrowsPercentage;//罚球命中率
	private double steals;//抢断数
	private double blocks;//盖帽数
	private double turnovers;//失误数
	private double fouls;//犯规数
	private double points;//得分
	private double efficiency;//效率
	private double GmSc;//GmSc效率值
	private double trueShootingPercentage;//真实命中率
	private double shootingEfficiency;//投篮效率
	private double reboundRating;//篮板率
	private double offensiveReboundRating;//进攻篮板率
	private double defensiveReboundRating;//防守篮板率
	private double assisyRating;//助攻率
	private double stealRating;//抢断率
	private double blockRating;//盖帽率
	private double turnoverRating;//失误率
	private double utilizationRating;//使用率
	private String number;		//球衣号码
	private String position;	//球队位置
	private String height;		//身高
	private String weight;		//体重
	private String birth;		//生日
	private String age;			//年龄
	private String exp;			//球龄
	private String school;		//毕业学校
	private double doubleDouble; //两双
	
	
	public PlayerPO(){
		gamesPlayed=0;//参赛场数
		gamesStarting=0;//先发场数
		rebounds=0;//篮板数
		assists=0;//助攻数
		minutes=0;//在场时间
		fieldGoalsAttempts=0;//投篮出手数
		fieldGoalsMade=0;//投篮命中数
		fieldGoalsPercentage=0;//投篮命中率
		threePointFieldGoalsAttempts=0;//三分出手数
		threePointFieldGoalsMade=0;//三分命中数
		threePointFieldGoalsPercentage=0;//三分命中率
		freeThrowsAttempts=0;//罚球出手数
		freeThrowsMade=0;//罚球命中数
		freeThrowsPercentage=0;//罚球命中率
		offensiveRebounds=0;//进攻篮板数
		defensiveRebounds=0;//防守篮板数
		steals=0;//抢断数
		blocks=0;//盖帽数
		turnovers=0;//失误数
		fouls=0;//犯规数
		points=0;//得分
		efficiency=0;//效率
		GmSc=0;//GmSc效率值
		trueShootingPercentage=0;//真实命中率
		shootingEfficiency=0;//投篮效率
		reboundRating=0;//篮板率
		offensiveReboundRating=0;//进攻篮板率
		defensiveReboundRating=0;//防守篮板率
		assisyRating=0;//助攻率
		stealRating=0;//抢断率
		blockRating=0;//盖帽率
		turnoverRating=0;//失误率
		utilizationRating=0;//使用率
		doubleDouble=0;//两双
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public int getGamesPlayed() {
		return gamesPlayed;
	}

	public void setGamesPlayed(int gamesPlayed) {
		this.gamesPlayed = gamesPlayed;
	}

	public int getGamesStarting() {
		return gamesStarting;
	}

	public void setGamesStarting(int gamesStarting) {
		this.gamesStarting = gamesStarting;
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

	public double getMinutes() {
		return minutes;
	}

	public void setMinutes(double minutes) {
		this.minutes = minutes;
	}

	public double getFieldGoalsPercentage() {
		return fieldGoalsPercentage;
	}

	public void setFieldGoalsPercentage(double fieldGoalsPercentage) {
		this.fieldGoalsPercentage = fieldGoalsPercentage;
	}

	public double getThreePointFieldGoalsPercentage() {
		return threePointFieldGoalsPercentage;
	}

	public void setThreePointFieldGoalsPercentage(double threePointFieldGoalsPercentage) {
		this.threePointFieldGoalsPercentage = threePointFieldGoalsPercentage;
	}

	public double getFreeThrowsPercentage() {
		return freeThrowsPercentage;
	}

	public void setFreeThrowsPercentage(double freeThrowsPercentage) {
		this.freeThrowsPercentage = freeThrowsPercentage;
	}

	public double getOffensiveRebounds() {
		return offensiveRebounds;
	}

	public void setOffensiveRebounds(double offenses) {
		this.offensiveRebounds = offenses;
	}

	public double getDefensiveRebounds() {
		return defensiveRebounds;
	}

	public void setDefensiveRebounds(double defenses) {
		this.defensiveRebounds = defenses;
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

	public double getEfficiency() {
		return efficiency;
	}

	public void setEfficiency(double efficiency) {
		this.efficiency = efficiency;
	}

	public double getGmSc() {
		return GmSc;
	}

	public void setGmSc(double gmSc) {
		GmSc = gmSc;
	}

	public double getTrueShootingPercentage() {
		return trueShootingPercentage;
	}

	public void setTrueShootingPercentage(double trueShootingPercentage) {
		this.trueShootingPercentage = trueShootingPercentage;
	}

	public double getShootingEfficiency() {
		return shootingEfficiency;
	}

	public void setShootingEfficiency(double shootingEfficiency) {
		this.shootingEfficiency = shootingEfficiency;
	}

	public double getReboundRating() {
		return reboundRating;
	}

	public void setReboundRating(double reboundRating) {
		this.reboundRating = reboundRating;
	}

	public double getOffensiveReboundRating() {
		return offensiveReboundRating;
	}

	public void setOffensiveReboundRating(double offensiveReboundRating) {
		this.offensiveReboundRating = offensiveReboundRating;
	}

	public double getDefensiveReboundRating() {
		return defensiveReboundRating;
	}

	public void setDefensiveReboundRating(double defensiveReboundRating) {
		this.defensiveReboundRating = defensiveReboundRating;
	}

	public double getAssisyRating() {
		return assisyRating;
	}

	public void setAssisyRating(double assisyRating) {
		this.assisyRating = assisyRating;
	}

	public double getStealRating() {
		return stealRating;
	}

	public void setStealRating(double stealRating) {
		this.stealRating = stealRating;
	}

	public double getBlockRating() {
		return blockRating;
	}

	public void setBlockRating(double blockRating) {
		this.blockRating = blockRating;
	}

	public double getTurnoverRating() {
		return turnoverRating;
	}

	public void setTurnoverRating(double turnoverRating) {
		this.turnoverRating = turnoverRating;
	}

	public double getUtilizationRating() {
		return utilizationRating;
	}

	public void setUtilizationRating(double utilizationRating) {
		this.utilizationRating = utilizationRating;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getExp() {
		return exp;
	}

	public void setExp(String exp) {
		this.exp = exp;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public double getDoubleDouble() {
		return doubleDouble;
	}

	public void setDoubleDouble(double doubleDouble) {
		this.doubleDouble = doubleDouble;
	}

	public double getFieldGoalsAttempts() {
		return fieldGoalsAttempts;
	}

	public void setFieldGoalsAttempts(double fieldGoalsAttempts) {
		this.fieldGoalsAttempts = fieldGoalsAttempts;
	}

	public double getFieldGoalsMade() {
		return fieldGoalsMade;
	}

	public void setFieldGoalsMade(double fieldGoalsMade) {
		this.fieldGoalsMade = fieldGoalsMade;
	}

	public double getThreePointFieldGoalsAttempts() {
		return threePointFieldGoalsAttempts;
	}

	public void setThreePointFieldGoalsAttempts(double threePointFieldGoalsAttempts) {
		this.threePointFieldGoalsAttempts = threePointFieldGoalsAttempts;
	}

	public double getThreePointFieldGoalsMade() {
		return threePointFieldGoalsMade;
	}

	public void setThreePointFieldGoalsMade(double threePointFieldGoalsMade) {
		this.threePointFieldGoalsMade = threePointFieldGoalsMade;
	}

	public double getFreeThrowsAttempts() {
		return freeThrowsAttempts;
	}

	public void setFreeThrowsAttempts(double freeThrowsAttempts) {
		this.freeThrowsAttempts = freeThrowsAttempts;
	}

	public double getFreeThrowsMade() {
		return freeThrowsMade;
	}

	public void setFreeThrowsMade(double freeThrowsMade) {
		this.freeThrowsMade = freeThrowsMade;
	}

}