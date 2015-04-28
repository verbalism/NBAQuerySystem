package vo;

public class PlayerVO {
	private String playerName;//球员名称
	private String number;		//球衣号码
	private String position;	//球队位置
	private String height;		//身高
	private String weight;		//体重
	private String birth;		//生日
	private String age;			//年龄
	private String exp;			//球龄
	private String school;		//毕业学校
	private String teamName;//所属球队
	private int gamesPlayed;//参赛场数
	private int gamesStarting;//先发场数
	private double rebounds;//篮板数
	private double offensiveRebounds;//进攻篮板数
	private double defensiveRebounds;//防守篮板数
	private double assists;//助攻数
	private String minutes;//在场时间
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
	private double doubleDouble; //两双
	private String allTimeOfTeam;//球队所有球员上场时间
	private double allReboundsOfTeam;//球队总篮板
	private double allOffensiveReboundsOfTeam;//球队进攻篮板
	private double alldefensiveReboundsOfTeam;//球队防守篮板
	private double allReboundsOfOpposite;//对手总篮板
	private double allOffensiveReboundsOfOpposite;//对手进攻篮板
	private double alldefensiveReboundsOfOpposite;//对手防守篮板
	private double allFieldGoalsMade;//球队总进球数
	private double allDefenseOfOpposite;//对手进攻次数
	private double twoPointFieldGoalsAttemptsOfOpposite;//对手两分球出手次数
	private double twoPointFieldGoalsAttempts;//球员两分球出手次数
	private double allFieldGoalsAttemptsOfTeam;//球队所有球员出手次数
	private double allFreeGoalsAttemptsOfTeam;//球队所有球员罚球次数
	private double allturnoversOfTeam;//球队所有球员失误次数
	private double allFieldGoalsAttemptsOfOpposite;//对手投篮数
	private double allFreeGoalsAttemptsOfOpposite;//对手罚球数
	private double allMissedGoalsOfOpposite;//对手投失球数
	private double allturnoversOfOpposite;//对手失误次数
	private double increaseOfPoints;//近五场得分提升率
	private double increaseOfRebounds;//近五场篮板提升率
	private double increaseOfAssists;//近五场助攻提升率
	
	public PlayerVO(){
		gamesPlayed=0;//参赛场数
		gamesStarting=0;//先发场数
		rebounds=0;//篮板数
		minutes="0:0";//上场时间
		assists=0;//助攻数
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
		allTimeOfTeam="0:0";//球队所有球员上场时间
		allReboundsOfTeam=0;//球队总篮板
		allOffensiveReboundsOfTeam=0;//球队进攻篮板
		alldefensiveReboundsOfTeam=0;//球队防守篮板
		allReboundsOfOpposite=0;//对手总篮板
		allOffensiveReboundsOfOpposite=0;//对手进攻篮板
		alldefensiveReboundsOfOpposite=0;//对手防守篮板
		allFieldGoalsMade=0;//球队总进球数
		allDefenseOfOpposite=0;//对手进攻次数
		twoPointFieldGoalsAttemptsOfOpposite=0;//对手两分球出手次数
		twoPointFieldGoalsAttempts=0;//球员两分球出手次数
		allFieldGoalsAttemptsOfTeam=0;//球队所有球员出手次数
		allFreeGoalsAttemptsOfTeam=0;//球队所有球员罚球次数
		allturnoversOfTeam=0;//球队所有球员失误次数
		setAllFieldGoalsAttemptsOfOpposite(0);//对手投篮数
		setAllFreeGoalsAttemptsOfOpposite(0);//对手罚球数
		setAllMissedGoalsOfOpposite(0);//对手投失球数
		setAllturnoversOfOpposite(0);//对手失误数
		setIncreaseOfPoints(0);//近五场得分提升率
		setIncreaseOfRebounds(0);//近五场篮板提升率
		setIncreaseOfAssists(0);//近五场助攻提升率
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
		if(teamName==null)
			this.teamName = "";
		else
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

	public String getMinutes() {
		return minutes;
	}

	public void setMinutes(String minutes) {
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

	public String getAllTimeOfTeam() {
		return allTimeOfTeam;
	}

	public void setAllTimeOfTeam(String allTimeOfTeam) {
		this.allTimeOfTeam = allTimeOfTeam;
	}

	public double getAllReboundsOfTeam() {
		return allReboundsOfTeam;
	}

	public void setAllReboundsOfTeam(double allReboundsOfTeam) {
		this.allReboundsOfTeam = allReboundsOfTeam;
	}

	public double getAllOffensiveReboundsOfTeam() {
		return allOffensiveReboundsOfTeam;
	}

	public void setAllOffensiveReboundsOfTeam(double allOffensiveReboundsOfTeam) {
		this.allOffensiveReboundsOfTeam = allOffensiveReboundsOfTeam;
	}

	public double getAlldefensiveReboundsOfTeam() {
		return alldefensiveReboundsOfTeam;
	}

	public void setAlldefensiveReboundsOfTeam(double alldefensiveReboundsOfTeam) {
		this.alldefensiveReboundsOfTeam = alldefensiveReboundsOfTeam;
	}

	public double getAllReboundsOfOpposite() {
		return allReboundsOfOpposite;
	}

	public void setAllReboundsOfOpposite(double allReboundsOfOpposite) {
		this.allReboundsOfOpposite = allReboundsOfOpposite;
	}

	public double getAllOffensiveReboundsOfOpposite() {
		return allOffensiveReboundsOfOpposite;
	}

	public void setAllOffensiveReboundsOfOpposite(
			double allOffensiveReboundsOfOpposite) {
		this.allOffensiveReboundsOfOpposite = allOffensiveReboundsOfOpposite;
	}

	public double getAlldefensiveReboundsOfOpposite() {
		return alldefensiveReboundsOfOpposite;
	}

	public void setAlldefensiveReboundsOfOpposite(
			double alldefensiveReboundsOfOpposite) {
		this.alldefensiveReboundsOfOpposite = alldefensiveReboundsOfOpposite;
	}

	public double getAllFieldGoalsMade() {
		return allFieldGoalsMade;
	}

	public void setAllFieldGoalsMade(double allFieldGoalsMade) {
		this.allFieldGoalsMade = allFieldGoalsMade;
	}

	public double getAllDefenseOfOpposite() {
		return allDefenseOfOpposite;
	}

	public void setAllDefenseOfOpposite(double allDefenseOfOpposite) {
		this.allDefenseOfOpposite = allDefenseOfOpposite;
	}

	public double getTwoPointFieldGoalsAttemptsOfOpposite() {
		return twoPointFieldGoalsAttemptsOfOpposite;
	}

	public void setTwoPointFieldGoalsAttemptsOfOpposite(
			double twoPointFieldGoalsAttemptsOfOpposite) {
		this.twoPointFieldGoalsAttemptsOfOpposite = twoPointFieldGoalsAttemptsOfOpposite;
	}

	public double getTwoPointFieldGoalsAttempts() {
		return twoPointFieldGoalsAttempts;
	}

	public void setTwoPointFieldGoalsAttempts(double twoPointFieldGoalsAttempts) {
		this.twoPointFieldGoalsAttempts = twoPointFieldGoalsAttempts;
	}

	public double getAllFieldGoalsAttemptsOfTeam() {
		return allFieldGoalsAttemptsOfTeam;
	}

	public void setAllFieldGoalsAttemptsOfTeam(double allFieldGoalsAttemptsOfTeam) {
		this.allFieldGoalsAttemptsOfTeam = allFieldGoalsAttemptsOfTeam;
	}

	public double getAllFreeGoalsAttemptsOfTeam() {
		return allFreeGoalsAttemptsOfTeam;
	}

	public void setAllFreeGoalsAttemptsOfTeam(double allFreeGoalsAttemptsOfTeam) {
		this.allFreeGoalsAttemptsOfTeam = allFreeGoalsAttemptsOfTeam;
	}

	public double getAllturnoversOfTeam() {
		return allturnoversOfTeam;
	}

	public void setAllturnoversOfTeam(double allturnoversOfTeam) {
		this.allturnoversOfTeam = allturnoversOfTeam;
	}

	public double getAllFieldGoalsAttemptsOfOpposite() {
		return allFieldGoalsAttemptsOfOpposite;
	}

	public void setAllFieldGoalsAttemptsOfOpposite(
			double allFieldGoalsAttemptsOfOpposite) {
		this.allFieldGoalsAttemptsOfOpposite = allFieldGoalsAttemptsOfOpposite;
	}

	public double getAllFreeGoalsAttemptsOfOpposite() {
		return allFreeGoalsAttemptsOfOpposite;
	}

	public void setAllFreeGoalsAttemptsOfOpposite(
			double allFreeGoalsAttemptsOfOpposite) {
		this.allFreeGoalsAttemptsOfOpposite = allFreeGoalsAttemptsOfOpposite;
	}

	public double getAllMissedGoalsOfOpposite() {
		return allMissedGoalsOfOpposite;
	}

	public void setAllMissedGoalsOfOpposite(double allMissedGoalsOfOpposite) {
		this.allMissedGoalsOfOpposite = allMissedGoalsOfOpposite;
	}

	public double getAllturnoversOfOpposite() {
		return allturnoversOfOpposite;
	}

	public void setAllturnoversOfOpposite(double allturnoversOfOpposite) {
		this.allturnoversOfOpposite = allturnoversOfOpposite;
	}

	public double getIncreaseOfPoints() {
		return increaseOfPoints;
	}

	public void setIncreaseOfPoints(double increaseOfPoints) {
		this.increaseOfPoints = increaseOfPoints;
	}

	public double getIncreaseOfRebounds() {
		return increaseOfRebounds;
	}

	public void setIncreaseOfRebounds(double increaseOfRebounds) {
		this.increaseOfRebounds = increaseOfRebounds;
	}

	public double getIncreaseOfAssists() {
		return increaseOfAssists;
	}

	public void setIncreaseOfAssists(double increaseOfAssists) {
		this.increaseOfAssists = increaseOfAssists;
	}

}