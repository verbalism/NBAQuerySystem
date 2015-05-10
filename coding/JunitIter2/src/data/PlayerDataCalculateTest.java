package data;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import po.MatchPO;
import po.MatchPlayer;
import po.MatchTeam;

public class PlayerDataCalculateTest {
	PlayerDataCalculate pdc=null;
	@Before
	public void setUp() throws Exception {
		pdc=new PlayerDataCalculate();
	}

	@After
	public void tearDown() throws Exception {
		pdc=null;
	}

	@Test
	public void testCalculateTeam() {
		String s=new String();
		MatchData md=new MatchData();
		MatchPO mp=md.getSingleMatchInfo("HOU", "01-08");
		s=pdc.CalculateTeam("Aaron Brooks",mp);
		assertNotNull(s);
	}

	@Test
	public void testCalculateGamesStarting() {
		int i;
		ArrayList<MatchPO> mp=new ArrayList<MatchPO>();
		i=pdc.CalculateGamesStarting("Aaron Brooks",mp);
		assertNotNull(i);
	}

	@Test
	public void testCalculateRebounds() {
		double d;
		ArrayList<MatchPlayer> mp=new ArrayList<MatchPlayer>();
		d=pdc.CalculateRebounds(mp);
		assertNotNull(d);
	}

	@Test
	public void testCalculateAssists() {
		double d;
		ArrayList<MatchPlayer> mp=new ArrayList<MatchPlayer>();
		d=pdc.CalculateAssists(mp);
		assertNotNull(d);
	}

	@Test
	public void testCalculateMinutes() {
		String s;
		ArrayList<MatchPlayer> mp=new ArrayList<MatchPlayer>();
		s=pdc.CalculateMinutes(mp);
		assertNotNull(s);
	}

	@Test
	public void testCalTime() {
		String s;
		String a="",b="";
		s=pdc.calTime(a,b);
		assertNotNull(s);
	}

	@Test
	public void testGetTime() {
		double d=0;
		d=pdc.getTime("");
		assertNotNull(d);
	}

	@Test
	public void testCalculateFieldGoalsMade() {
		double d;
		ArrayList<MatchPlayer> mp=new ArrayList<MatchPlayer>();
		d=pdc.CalculateFieldGoalsMade(mp);
		assertNotNull(d);
	}

	@Test
	public void testCalculateThreePointFieldGoalsMade() {
		double d;
		ArrayList<MatchPlayer> mp=new ArrayList<MatchPlayer>();
		d=pdc.CalculateThreePointFieldGoalsMade(mp);
		assertNotNull(d);
	}

	@Test
	public void testCalculateFreeThrowsMade() {
		double d;
		ArrayList<MatchPlayer> mp=new ArrayList<MatchPlayer>();
		d=pdc.CalculateFreeThrowsMade(mp);
		assertNotNull(d);
	}

	@Test
	public void testCalculateFieldGoalsPercentage() {
		double d;
		ArrayList<MatchPlayer> mp=new ArrayList<MatchPlayer>();
		d=pdc.CalculateFieldGoalsPercentage(mp);
		assertNotNull(d);
	}

	@Test
	public void testCalculateThreePointFieldGoalsPercentage() {
		double d;
		ArrayList<MatchPlayer> mp=new ArrayList<MatchPlayer>();
		d=pdc.CalculateThreePointFieldGoalsPercentage(mp);
		assertNotNull(d);
	}

	@Test
	public void testCalculateFreeThrowsPercentage() {
		double d;
		ArrayList<MatchPlayer> mp=new ArrayList<MatchPlayer>();
		d=pdc.CalculateFreeThrowsPercentage(mp);
		assertNotNull(d);
	}

	@Test
	public void testCalculateOffensiveRebounds() {
		double d;
		ArrayList<MatchPlayer> mp=new ArrayList<MatchPlayer>();
		d=pdc.CalculateOffensiveRebounds(mp);
		assertNotNull(d);
	}

	@Test
	public void testCalculateDefensiveRebounds() {
		double d;
		ArrayList<MatchPlayer> mp=new ArrayList<MatchPlayer>();
		d=pdc.CalculateDefensiveRebounds(mp);
		assertNotNull(d);
	}

	@Test
	public void testCalculateSteals() {
		double d;
		ArrayList<MatchPlayer> mp=new ArrayList<MatchPlayer>();
		d=pdc.CalculateSteals(mp);
		assertNotNull(d);
	}

	@Test
	public void testCalculateBlocks() {
		double d;
		ArrayList<MatchPlayer> mp=new ArrayList<MatchPlayer>();
		d=pdc.CalculateBlocks(mp);
		assertNotNull(d);
	}

	@Test
	public void testCalculateTurnovers() {
		double d;
		ArrayList<MatchPlayer> mp=new ArrayList<MatchPlayer>();
		d=pdc.CalculateTurnovers(mp);
		assertNotNull(d);
	}

	@Test
	public void testCalculateFouls() {
		double d;
		ArrayList<MatchPlayer> mp=new ArrayList<MatchPlayer>();
		d=pdc.CalculateFouls(mp);
		assertNotNull(d);
	}

	@Test
	public void testCalculatePoints() {
		double d;
		ArrayList<MatchPlayer> mp=new ArrayList<MatchPlayer>();
		d=pdc.CalculatePoints(mp);
		assertNotNull(d);
	}

	@Test
	public void testCalculateFieldGoalAttempts() {
		double d;
		ArrayList<MatchPlayer> mp=new ArrayList<MatchPlayer>();
		d=pdc.CalculateFieldGoalAttempts(mp);
		assertNotNull(d);
	}

	@Test
	public void testCalculateThreePointAttempts() {
		double d;
		ArrayList<MatchPlayer> mp=new ArrayList<MatchPlayer>();
		d=pdc.CalculateThreePointAttempts(mp);
		assertNotNull(d);
	}

	@Test
	public void testCalculateFreeThrowAttempts() {
		double d;
		ArrayList<MatchPlayer> mp=new ArrayList<MatchPlayer>();
		d=pdc.CalculateFreeThrowAttempts(mp);
		assertNotNull(d);
	}

	@Test
	public void testCalculateEfficiency() {
		double d;
		ArrayList<MatchPlayer> mp=new ArrayList<MatchPlayer>();
		d=pdc.CalculateEfficiency(mp);
		assertNotNull(d);
	}

	@Test
	public void testCalculateGmSc() {
		double d;
		ArrayList<MatchPlayer> mp=new ArrayList<MatchPlayer>();
		d=pdc.CalculateGmSc(mp);
		assertNotNull(d);
	}

	@Test
	public void testCalculateTrueShootingPercentage() {
		double d;
		ArrayList<MatchPlayer> mp=new ArrayList<MatchPlayer>();
		d=pdc.CalculateTrueShootingPercentage(mp);
		assertNotNull(d);
	}

	@Test
	public void testCalculateShootingEfficiency() {
		double d;
		ArrayList<MatchPlayer> mp=new ArrayList<MatchPlayer>();
		d=pdc.CalculateShootingEfficiency(mp);
		assertNotNull(d);
	}

	@Test
	public void testCalculateReboundRating() {
		double d;
		ArrayList<MatchPlayer> mp=new ArrayList<MatchPlayer>();
		ArrayList<MatchTeam> mt1=new ArrayList<MatchTeam>();
		ArrayList<MatchTeam> mt2=new ArrayList<MatchTeam>();
		d=pdc.CalculateReboundRating(mt1,mt2,mp);
		assertNotNull(d);
	}

	@Test
	public void testCalculateOffensiveReboundRating() {
		double d;
		ArrayList<MatchPlayer> mp=new ArrayList<MatchPlayer>();
		ArrayList<MatchTeam> mt1=new ArrayList<MatchTeam>();
		ArrayList<MatchTeam> mt2=new ArrayList<MatchTeam>();
		d=pdc.CalculateOffensiveReboundRating(mt1,mt2,mp);
		assertNotNull(d);
	}

	@Test
	public void testCalculateDefensiveReboundRating() {
		double d;
		ArrayList<MatchPlayer> mp=new ArrayList<MatchPlayer>();
		ArrayList<MatchTeam> mt1=new ArrayList<MatchTeam>();
		ArrayList<MatchTeam> mt2=new ArrayList<MatchTeam>();
		d=pdc.CalculateDefensiveReboundRating(mt1,mt2,mp);
		assertNotNull(d);
	}

	@Test
	public void testCalculateAssisyRating() {
		double d;
		ArrayList<MatchPlayer> mp=new ArrayList<MatchPlayer>();
		ArrayList<MatchTeam> mt1=new ArrayList<MatchTeam>();
		d=pdc.CalculateAssisyRating(mt1,mp);
		assertNotNull(d);
	}

	@Test
	public void testCalculateStealRating() {
		double d;
		ArrayList<MatchPlayer> mp=new ArrayList<MatchPlayer>();
		ArrayList<MatchTeam> mt1=new ArrayList<MatchTeam>();
		ArrayList<MatchTeam> mt2=new ArrayList<MatchTeam>();
		d=pdc.CalculateStealRating(mt1,mt2,mp);
		assertNotNull(d);
	}

	@Test
	public void testCalculateBlockRating() {
		double d;
		ArrayList<MatchPlayer> mp=new ArrayList<MatchPlayer>();
		ArrayList<MatchTeam> mt1=new ArrayList<MatchTeam>();
		ArrayList<MatchTeam> mt2=new ArrayList<MatchTeam>();
		d=pdc.CalculateBlockRating(mt1,mt2,mp);
		assertNotNull(d);
	}

	@Test
	public void testCalculateTurnoverRating() {
		double d;
		ArrayList<MatchPlayer> mp=new ArrayList<MatchPlayer>();
		d=pdc.CalculateTurnoverRating(mp);
		assertNotNull(d);
	}

	@Test
	public void testCalculateUtilizationRating() {
		double d;
		ArrayList<MatchPlayer> mp=new ArrayList<MatchPlayer>();
		ArrayList<MatchTeam> mt1=new ArrayList<MatchTeam>();
		d=pdc.CalculateUtilizationRating(mt1,mp);
		assertNotNull(d);
	}

	@Test
	public void testCalculateDoubleDouble() {
		double d;
		ArrayList<MatchPlayer> mp=new ArrayList<MatchPlayer>();
		d=pdc.CalculateDoubleDouble(mp);
		assertNotNull(d);
	}

	@Test
	public void testCalculateIncreaseOfPoints() {
		double d;
		ArrayList<MatchPlayer> mp=new ArrayList<MatchPlayer>();
		d=pdc.CalculateIncreaseOfPoints(mp);
		assertNotNull(d);
	}

	@Test
	public void testCalculateIncreaseOfAssists() {
		double d;
		ArrayList<MatchPlayer> mp=new ArrayList<MatchPlayer>();
		d=pdc.CalculateIncreaseOfAssists(mp);
		assertNotNull(d);
	}

	@Test
	public void testCalculateIncreaseOfRebounds() {
		double d;
		ArrayList<MatchPlayer> mp=new ArrayList<MatchPlayer>();
		d=pdc.CalculateIncreaseOfRebounds(mp);
		assertNotNull(d);
	}


	@Test
	public void testGetFullName() {
		String s;
		ArrayList<String> st=new ArrayList<String>();
		st.add("ATL");
		st.add("BKN");
		st.add("BOS");
		st.add("CHA");
		st.add("CHI");
		st.add("CLE");
		st.add("DAL");
		st.add("DEN");
		st.add("DET");
		st.add("GSW");
		st.add("HOU");
		st.add("IND");
		st.add("LAC");
		st.add("LAL");
		st.add("MEM");
		st.add("MIA");
		st.add("MIL");
		st.add("MIN");
		st.add("NOP");
		st.add("NYK");
		st.add("OKC");
		st.add("ORL");
		st.add("PHI");
		st.add("PHX");
		st.add("POR");
		st.add("SAC");
		st.add("TOR");
		st.add("UTA");
		st.add("WAS");
		for(int i=0;i<st.size();i++){
			s=pdc.getFullName(st.get(i));
			assertNotNull(s);
		}
	}
}
