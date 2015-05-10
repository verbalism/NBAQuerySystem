package businesslogic;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import vo.MatchVO;
import vo.PlayerAge;
import vo.PlayerPartition;
import vo.PlayerPosition;
import vo.PlayerVO;
import vo.SortType;
import vo.TeamVO;
import vo.TodayPlayerVO;

public class AnalysisBLTest {
	AnalysisBL a;
	public String[]m={"fieldGoalsMade","fieldGoalsAttempted","threePointFieldGoalsMade","threePointFieldGoalsAttempted"
			,"freeThrowsMade","freeThrowsAttempted","offensiveRebounds","defensiveRebounds","rebounds","assists","steals","blocks","turnovers","fouls","points","fieldGoalPercentage",
			"threePointFieldGoalPercentage","freeThrowPercentage","winPercentage","possessions","offensiveRating","defensiveRating","offensiveReboundPercentage","defensiveReboundPercentage",
			"stealPercentage","assistPercentage","gamesPlayedWin"};
	public String[]oppm={"oppFieldGoalsMade","oppFieldGoalsAttempted","oppFreeThrowsAttempted","oppTurnovers","oppSteals","oppAssists","oppOffensiveRebounds","oppDefensiveRebounds","oppPoints"};
	@Before
	public void setUp() throws Exception {
		a=new AnalysisBL();
	}

	@After
	public void tearDown() throws Exception {
		a=null;
	}

	@Test
	public void testSortPlaye1() {
		ArrayList<PlayerVO> o=new ArrayList<PlayerVO>();
		PlayerVO pv=new PlayerVO();
		pv.setRebounds(19);
		PlayerVO pv1=new PlayerVO();
		pv1.setRebounds(18);
		o.add(pv1);
		o.add(pv);
		ArrayList<PlayerVO> h=new ArrayList<PlayerVO>();		
		
		h=a.sortPlayer(o,"rebounds",SortType.Null);
		assertNotNull(h);
	}
	@Test
	public void testSortPlayer2() {
		ArrayList<PlayerVO> o=new ArrayList<PlayerVO>();
		PlayerVO pv=new PlayerVO();
		pv.setRebounds(19);
		PlayerVO pv1=new PlayerVO();
		pv1.setRebounds(18);
		o.add(pv1);
		o.add(pv);
		ArrayList<PlayerVO> h=new ArrayList<PlayerVO>();		
		
		h=a.sortPlayer(o,"gamesPlayed",SortType.Null);
		assertNotNull(h);
	}
	@Test
	public void testSortPlayer3() {
		ArrayList<PlayerVO> o=new ArrayList<PlayerVO>();
		PlayerVO pv=new PlayerVO();
		pv.setRebounds(19);
		PlayerVO pv1=new PlayerVO();
		pv1.setRebounds(18);
		o.add(pv1);
		o.add(pv);
		ArrayList<PlayerVO> h=new ArrayList<PlayerVO>();		
		
		h=a.sortPlayer(o,"gamesStarting",SortType.Null);
		assertNotNull(h);
	}
	@Test
	public void testSortPlayer4() {
		ArrayList<PlayerVO> o=new ArrayList<PlayerVO>();
		PlayerVO pv=new PlayerVO();
		pv.setRebounds(19);
		PlayerVO pv1=new PlayerVO();
		pv1.setRebounds(18);
		o.add(pv1);
		o.add(pv);
		ArrayList<PlayerVO> h=new ArrayList<PlayerVO>();	
		
		h=a.sortPlayer(o,"assists",SortType.Null);
		assertNotNull(h);
	}
	@Test
	public void testSortPlayer5() {
		ArrayList<PlayerVO> o=new ArrayList<PlayerVO>();
		PlayerVO pv=new PlayerVO();
		pv.setRebounds(19);
		PlayerVO pv1=new PlayerVO();
		pv1.setRebounds(18);
		o.add(pv1);
		o.add(pv);
		ArrayList<PlayerVO> h=new ArrayList<PlayerVO>();	
		
		h=a.sortPlayer(o,"minutes",SortType.Null);
		assertNotNull(h);
	}
	@Test
	public void testSortPlayer6() {
		ArrayList<PlayerVO> o=new ArrayList<PlayerVO>();
		PlayerVO pv=new PlayerVO();
		pv.setRebounds(19);
		PlayerVO pv1=new PlayerVO();
		pv1.setRebounds(18);
		o.add(pv1);
		o.add(pv);
		ArrayList<PlayerVO> h=new ArrayList<PlayerVO>();		
		
		h=a.sortPlayer(o,"minutes2",SortType.Null);
		assertNotNull(h);
	}
	@Test
	public void testSortPlayer7() {
		ArrayList<PlayerVO> o=new ArrayList<PlayerVO>();
		PlayerVO pv=new PlayerVO();
		pv.setRebounds(19);
		PlayerVO pv1=new PlayerVO();
		pv1.setRebounds(18);
		o.add(pv1);
		o.add(pv);
		ArrayList<PlayerVO> h=new ArrayList<PlayerVO>();	
		
		h=a.sortPlayer(o,"fieldGoalsPercentage",SortType.Null);
		assertNotNull(h);
	}
	@Test
	public void testSortPlayer8() {
		ArrayList<PlayerVO> o=new ArrayList<PlayerVO>();
		PlayerVO pv=new PlayerVO();
		pv.setRebounds(19);
		PlayerVO pv1=new PlayerVO();
		pv1.setRebounds(18);
		o.add(pv1);
		o.add(pv);
		ArrayList<PlayerVO> h=new ArrayList<PlayerVO>();		
		
		h=a.sortPlayer(o,"threePointFieldGoalsPercentage",SortType.Null);
		assertNotNull(h);
	}
	@Test
	public void testSortPlayer9() {
		ArrayList<PlayerVO> o=new ArrayList<PlayerVO>();
		PlayerVO pv=new PlayerVO();
		pv.setRebounds(19);
		PlayerVO pv1=new PlayerVO();
		pv1.setRebounds(18);
		o.add(pv1);
		o.add(pv);
		ArrayList<PlayerVO> h=new ArrayList<PlayerVO>();		
		
		h=a.sortPlayer(o,"freeThrowsPercentage",SortType.Null);
		assertNotNull(h);
	}
	@Test
	public void testSortPlayer10() {
		ArrayList<PlayerVO> o=new ArrayList<PlayerVO>();
		PlayerVO pv=new PlayerVO();
		pv.setRebounds(19);
		PlayerVO pv1=new PlayerVO();
		pv1.setRebounds(18);
		o.add(pv1);
		o.add(pv);
		ArrayList<PlayerVO> h=new ArrayList<PlayerVO>();
		
		h=a.sortPlayer(o,"offensiveRebounds",SortType.Null);
		assertNotNull(h);
	}
	@Test
	public void testSortPlayer11() {
		ArrayList<PlayerVO> o=new ArrayList<PlayerVO>();
		PlayerVO pv=new PlayerVO();
		pv.setRebounds(19);
		PlayerVO pv1=new PlayerVO();
		pv1.setRebounds(18);
		o.add(pv1);
		o.add(pv);
		ArrayList<PlayerVO> h=new ArrayList<PlayerVO>();	
		
		h=a.sortPlayer(o,"defensiveRebounds",SortType.Null);
		assertNotNull(h);
	}
	@Test
	public void testSortPlayer12() {
		ArrayList<PlayerVO> o=new ArrayList<PlayerVO>();
		PlayerVO pv=new PlayerVO();
		pv.setRebounds(19);
		PlayerVO pv1=new PlayerVO();
		pv1.setRebounds(18);
		o.add(pv1);
		o.add(pv);
		ArrayList<PlayerVO> h=new ArrayList<PlayerVO>();	
		
		h=a.sortPlayer(o,"steals",SortType.Null);
		assertNotNull(h);
	}
	@Test
	public void testSortPlayer13() {
		ArrayList<PlayerVO> o=new ArrayList<PlayerVO>();
		PlayerVO pv=new PlayerVO();
		pv.setRebounds(19);
		PlayerVO pv1=new PlayerVO();
		pv1.setRebounds(18);
		o.add(pv1);
		o.add(pv);
		ArrayList<PlayerVO> h=new ArrayList<PlayerVO>();		
		
		h=a.sortPlayer(o,"blocks",SortType.Null);
		assertNotNull(h);
	}
	@Test
	public void testSortPlayer14() {
		ArrayList<PlayerVO> o=new ArrayList<PlayerVO>();
		PlayerVO pv=new PlayerVO();
		pv.setRebounds(19);
		PlayerVO pv1=new PlayerVO();
		pv1.setRebounds(18);
		o.add(pv1);
		o.add(pv);
		ArrayList<PlayerVO> h=new ArrayList<PlayerVO>();
		
		h=a.sortPlayer(o,"turnovers",SortType.Null);
		assertNotNull(h);
	}
	@Test
	public void testSortPlayer15() {
		ArrayList<PlayerVO> o=new ArrayList<PlayerVO>();
		PlayerVO pv=new PlayerVO();
		pv.setAge("19");
		o.add(pv);
		ArrayList<PlayerVO> h=new ArrayList<PlayerVO>();		
		
		h=a.sortPlayer(o,"fouls",SortType.Null);
		assertNotNull(h);
	}
	@Test
	public void testSortPlayer16() {
		ArrayList<PlayerVO> o=new ArrayList<PlayerVO>();
		PlayerVO pv=new PlayerVO();
		pv.setAge("19");
		o.add(pv);
		ArrayList<PlayerVO> h=new ArrayList<PlayerVO>();		
		
		h=a.sortPlayer(o,"points",SortType.Null);
		assertNotNull(h);
	}
	@Test
	public void testSortPlayer17() {
		ArrayList<PlayerVO> o=new ArrayList<PlayerVO>();
		PlayerVO pv=new PlayerVO();
		pv.setAge("19");
		o.add(pv);
		ArrayList<PlayerVO> h=new ArrayList<PlayerVO>();		
		
		h=a.sortPlayer(o,"efficiency",SortType.Null);
		assertNotNull(h);
	}
	@Test
	public void testSortPlayer18() {
		ArrayList<PlayerVO> o=new ArrayList<PlayerVO>();
		PlayerVO pv=new PlayerVO();
		pv.setAge("19");
		o.add(pv);
		ArrayList<PlayerVO> h=new ArrayList<PlayerVO>();		
		
		h=a.sortPlayer(o,"GmSc",SortType.Null);
		assertNotNull(h);
	}
	@Test
	public void testSortPlayer19() {
		ArrayList<PlayerVO> o=new ArrayList<PlayerVO>();
		PlayerVO pv=new PlayerVO();
		pv.setAge("19");
		o.add(pv);
		ArrayList<PlayerVO> h=new ArrayList<PlayerVO>();		
		
		h=a.sortPlayer(o,"trueShootingPercentage",SortType.Null);
		assertNotNull(h);
	}
	
	@Test
	public void testSortPlayer20() {
		ArrayList<PlayerVO> o=new ArrayList<PlayerVO>();
		PlayerVO pv=new PlayerVO();
		pv.setAge("19");
		o.add(pv);
		ArrayList<PlayerVO> h=new ArrayList<PlayerVO>();		
		
		h=a.sortPlayer(o,"shootingEfficiency",SortType.Null);
		assertNotNull(h);
	}
	@Test
	public void testSortPlayer21() {
		ArrayList<PlayerVO> o=new ArrayList<PlayerVO>();
		PlayerVO pv=new PlayerVO();
		pv.setAge("19");
		o.add(pv);
		ArrayList<PlayerVO> h=new ArrayList<PlayerVO>();		
		
		h=a.sortPlayer(o,"reboundRating",SortType.Null);
		assertNotNull(h);
	}
	@Test
	public void testSortPlayer22() {
		ArrayList<PlayerVO> o=new ArrayList<PlayerVO>();
		PlayerVO pv=new PlayerVO();
		pv.setAge("19");
		o.add(pv);
		ArrayList<PlayerVO> h=new ArrayList<PlayerVO>();		
		
		h=a.sortPlayer(o,"offensiveReboundRating",SortType.Null);
		assertNotNull(h);
	}
	@Test
	public void testSortPlayer23() {
		ArrayList<PlayerVO> o=new ArrayList<PlayerVO>();
		PlayerVO pv=new PlayerVO();
		pv.setAge("19");
		o.add(pv);
		ArrayList<PlayerVO> h=new ArrayList<PlayerVO>();		
		
		h=a.sortPlayer(o,"defensiveReboundRating",SortType.Null);
		assertNotNull(h);
	}
	@Test
	public void testSortPlayer24() {
		ArrayList<PlayerVO> o=new ArrayList<PlayerVO>();
		PlayerVO pv=new PlayerVO();
		pv.setAge("19");
		o.add(pv);
		ArrayList<PlayerVO> h=new ArrayList<PlayerVO>();		
		
		h=a.sortPlayer(o,"assisyRating",SortType.Null);
		assertNotNull(h);
	}
	@Test
	public void testSortPlayer25() {
		ArrayList<PlayerVO> o=new ArrayList<PlayerVO>();
		PlayerVO pv=new PlayerVO();
		pv.setAge("19");
		o.add(pv);
		ArrayList<PlayerVO> h=new ArrayList<PlayerVO>();		
		
		h=a.sortPlayer(o,"stealRating",SortType.Null);
		assertNotNull(h);
	}
	@Test
	public void testSortPlayer26() {
		ArrayList<PlayerVO> o=new ArrayList<PlayerVO>();
		PlayerVO pv=new PlayerVO();
		pv.setAge("19");
		o.add(pv);
		ArrayList<PlayerVO> h=new ArrayList<PlayerVO>();		
		
		h=a.sortPlayer(o,"blockRating",SortType.Null);
		assertNotNull(h);
	}
	@Test
	public void testSortPlayer27() {
		ArrayList<PlayerVO> o=new ArrayList<PlayerVO>();
		PlayerVO pv=new PlayerVO();
		pv.setAge("19");
		o.add(pv);
		ArrayList<PlayerVO> h=new ArrayList<PlayerVO>();		
		
		h=a.sortPlayer(o,"turnoverRating",SortType.Null);
		assertNotNull(h);
	}
	@Test
	public void testSortPlayer28() {
		ArrayList<PlayerVO> o=new ArrayList<PlayerVO>();
		PlayerVO pv=new PlayerVO();
		pv.setAge("19");
		o.add(pv);
		ArrayList<PlayerVO> h=new ArrayList<PlayerVO>();		
		
		h=a.sortPlayer(o,"utilizationRating",SortType.Null);
		assertNotNull(h);
	}
	@Test
	public void testSortPlayer29() {
		ArrayList<PlayerVO> o=new ArrayList<PlayerVO>();
		PlayerVO pv=new PlayerVO();
		pv.setAge("19");
		o.add(pv);
		ArrayList<PlayerVO> h=new ArrayList<PlayerVO>();		
		
		h=a.sortPlayer(o,"pointsReboundsAssists",SortType.Null);
		assertNotNull(h);
	}
	@Test
	public void testSortPlayer30() {
		ArrayList<PlayerVO> o=new ArrayList<PlayerVO>();
		PlayerVO pv=new PlayerVO();
		pv.setAge("19");
		o.add(pv);
		ArrayList<PlayerVO> h=new ArrayList<PlayerVO>();		
		
		h=a.sortPlayer(o,"doubleDouble",SortType.Null);
		assertNotNull(h);
	}
	@Test
	
	public void testSortPlayer31() {
		ArrayList<PlayerVO> o=new ArrayList<PlayerVO>();
		PlayerVO pv=new PlayerVO();
		pv.setAge("19");
		o.add(pv);
		ArrayList<PlayerVO> h=new ArrayList<PlayerVO>();		
		
		h=a.sortPlayer(o,"allTimeOfTeam",SortType.Null);
		assertNotNull(h);
	}
	@Test
	public void testSortPlayer32() {
		ArrayList<PlayerVO> o=new ArrayList<PlayerVO>();
		PlayerVO pv=new PlayerVO();
		pv.setAge("19");
		o.add(pv);
		ArrayList<PlayerVO> h=new ArrayList<PlayerVO>();		
		
		h=a.sortPlayer(o,"allReboundsOfTeam",SortType.Null);
		assertNotNull(h);
	}
	@Test
	public void testSortPlayer33() {
		ArrayList<PlayerVO> o=new ArrayList<PlayerVO>();
		PlayerVO pv=new PlayerVO();
		pv.setAge("19");
		o.add(pv);
		ArrayList<PlayerVO> h=new ArrayList<PlayerVO>();		
		
		h=a.sortPlayer(o,"allOffensiveReboundsOfTeam",SortType.Null);
		assertNotNull(h);
	}
	@Test
	public void testSortPlayer34() {
		ArrayList<PlayerVO> o=new ArrayList<PlayerVO>();
		PlayerVO pv=new PlayerVO();
		pv.setAge("19");
		o.add(pv);
		ArrayList<PlayerVO> h=new ArrayList<PlayerVO>();		
		
		h=a.sortPlayer(o,"alldefensiveReboundsOfTeam",SortType.Null);
		assertNotNull(h);
	}
	@Test
	public void testSortPlayer35() {
		ArrayList<PlayerVO> o=new ArrayList<PlayerVO>();
		PlayerVO pv=new PlayerVO();
		pv.setAge("19");
		o.add(pv);
		ArrayList<PlayerVO> h=new ArrayList<PlayerVO>();		
		
		h=a.sortPlayer(o,"allReboundsOfOpposite",SortType.Null);
		assertNotNull(h);
	}
	@Test
	public void testSortPlayer36() {
		ArrayList<PlayerVO> o=new ArrayList<PlayerVO>();
		PlayerVO pv=new PlayerVO();
		pv.setAge("19");
		o.add(pv);
		ArrayList<PlayerVO> h=new ArrayList<PlayerVO>();		
		
		h=a.sortPlayer(o,"allOffensiveReboundsOfOpposite",SortType.Null);
		assertNotNull(h);
	}
	@Test
	public void testSortPlayer37() {
		ArrayList<PlayerVO> o=new ArrayList<PlayerVO>();
		PlayerVO pv=new PlayerVO();
		pv.setAge("19");
		o.add(pv);
		ArrayList<PlayerVO> h=new ArrayList<PlayerVO>();		
		
		h=a.sortPlayer(o,"alldefensiveReboundsOfOpposite",SortType.Null);
		assertNotNull(h);
	}
	@Test
	public void testSortPlayer38() {
		ArrayList<PlayerVO> o=new ArrayList<PlayerVO>();
		PlayerVO pv=new PlayerVO();
		pv.setAge("19");
		o.add(pv);
		ArrayList<PlayerVO> h=new ArrayList<PlayerVO>();		
		
		h=a.sortPlayer(o,"allFieldGoalsMade",SortType.Null);
		assertNotNull(h);
	}
	@Test
	public void testSortPlayer39() {
		ArrayList<PlayerVO> o=new ArrayList<PlayerVO>();
		PlayerVO pv=new PlayerVO();
		pv.setAge("19");
		o.add(pv);
		ArrayList<PlayerVO> h=new ArrayList<PlayerVO>();		
		
		h=a.sortPlayer(o,"allDefenseOfOpposite",SortType.Null);
		assertNotNull(h);
	}
	@Test
	public void testSortPlayer40() {
		ArrayList<PlayerVO> o=new ArrayList<PlayerVO>();
		PlayerVO pv=new PlayerVO();
		pv.setAge("19");
		o.add(pv);
		ArrayList<PlayerVO> h=new ArrayList<PlayerVO>();		
		
		h=a.sortPlayer(o,"twoPointFieldGoalsAttemptsOfOpposite",SortType.Null);
		assertNotNull(h);
	}
	@Test
	public void testSortPlayer41() {
		ArrayList<PlayerVO> o=new ArrayList<PlayerVO>();
		PlayerVO pv=new PlayerVO();
		pv.setAge("19");
		o.add(pv);
		ArrayList<PlayerVO> h=new ArrayList<PlayerVO>();		
		
		h=a.sortPlayer(o,"twoPointFieldGoalsAttempts",SortType.Null);
		assertNotNull(h);
	}
	@Test
	public void testSortPlayer42() {
		ArrayList<PlayerVO> o=new ArrayList<PlayerVO>();
		PlayerVO pv=new PlayerVO();
		pv.setAge("19");
		o.add(pv);
		ArrayList<PlayerVO> h=new ArrayList<PlayerVO>();		
		
		h=a.sortPlayer(o,"allFieldGoalsAttemptsOfTeam",SortType.Null);
		assertNotNull(h);
	}
	@Test
	public void testSortPlayer43() {
		ArrayList<PlayerVO> o=new ArrayList<PlayerVO>();
		PlayerVO pv=new PlayerVO();
		pv.setAge("19");
		o.add(pv);
		ArrayList<PlayerVO> h=new ArrayList<PlayerVO>();		
		
		h=a.sortPlayer(o,"allFreeGoalsAttemptsOfTeam",SortType.Null);
		assertNotNull(h);
	}
	@Test
	public void testSortPlayer44() {
		ArrayList<PlayerVO> o=new ArrayList<PlayerVO>();
		PlayerVO pv=new PlayerVO();
		pv.setAge("19");
		o.add(pv);
		ArrayList<PlayerVO> h=new ArrayList<PlayerVO>();		
		
		h=a.sortPlayer(o,"AllturnoversOfTeam",SortType.Null);
		assertNotNull(h);
	}
	@Test
	public void testSortPlayer45() {
		ArrayList<PlayerVO> o=new ArrayList<PlayerVO>();
		PlayerVO pv=new PlayerVO();
		pv.setAge("19");
		o.add(pv);
		ArrayList<PlayerVO> h=new ArrayList<PlayerVO>();		
		
		h=a.sortPlayer(o,"allFieldGoalsAttemptsOfOpposite",SortType.Null);
		assertNotNull(h);
	}
	@Test
	public void testSortPlayer46() {
		ArrayList<PlayerVO> o=new ArrayList<PlayerVO>();
		PlayerVO pv=new PlayerVO();
		pv.setAge("19");
		o.add(pv);
		ArrayList<PlayerVO> h=new ArrayList<PlayerVO>();		
		
		h=a.sortPlayer(o,"allFreeGoalsAttemptsOfOpposite",SortType.Null);
		assertNotNull(h);
	}
	@Test
	public void testSortPlayer47() {
		ArrayList<PlayerVO> o=new ArrayList<PlayerVO>();
		PlayerVO pv=new PlayerVO();
		pv.setAge("19");
		o.add(pv);
		ArrayList<PlayerVO> h=new ArrayList<PlayerVO>();		
		
		h=a.sortPlayer(o,"allMissedGoalsOfOpposite",SortType.Null);
		assertNotNull(h);
	}
	@Test
	public void testSortPlayer48() {
		ArrayList<PlayerVO> o=new ArrayList<PlayerVO>();
		PlayerVO pv=new PlayerVO();
		pv.setAge("19");
		o.add(pv);
		ArrayList<PlayerVO> h=new ArrayList<PlayerVO>();		
		
		h=a.sortPlayer(o,"allturnoversOfOpposite",SortType.Null);
		assertNotNull(h);
	}
	@Test
	public void testSortPlayer49() {
		ArrayList<PlayerVO> o=new ArrayList<PlayerVO>();
		PlayerVO pv=new PlayerVO();
		pv.setAge("19");
		o.add(pv);
		ArrayList<PlayerVO> h=new ArrayList<PlayerVO>();		
		
		h=a.sortPlayer(o,"increaseOfPoints",SortType.Null);
		assertNotNull(h);
	}
	@Test
	public void testSortPlayer50() {
		ArrayList<PlayerVO> o=new ArrayList<PlayerVO>();
		PlayerVO pv=new PlayerVO();
		pv.setAge("19");
		o.add(pv);
		ArrayList<PlayerVO> h=new ArrayList<PlayerVO>();		
		
		h=a.sortPlayer(o,"increaseOfRebounds",SortType.Null);
		assertNotNull(h);
	}
	@Test
	public void testSortPlayer51() {
		ArrayList<PlayerVO> o=new ArrayList<PlayerVO>();
		PlayerVO pv=new PlayerVO();
		pv.setAge("19");
		o.add(pv);
		ArrayList<PlayerVO> h=new ArrayList<PlayerVO>();		
		
		h=a.sortPlayer(o,"increaseOfAssists",SortType.Null);
		assertNotNull(h);
	}
	@Test
	public void testSortPlayer52() {
		ArrayList<PlayerVO> o=new ArrayList<PlayerVO>();
		PlayerVO pv=new PlayerVO();
		pv.setAge("19");
		o.add(pv);
		ArrayList<PlayerVO> h=new ArrayList<PlayerVO>();		
		
		h=a.sortPlayer(o,"pointsReboundsAssists",SortType.Null);
		assertNotNull(h);
	}
	
	
	

	@Test
	public void testSortTeam0() {
		
		ArrayList<TeamVO> o=new ArrayList<TeamVO>();
		TeamVO pv=new TeamVO();
		pv.setRebounds(19);
		TeamVO pv1=new TeamVO();
		pv1.setRebounds(18);
		o.add(pv1);
		o.add(pv);
		ArrayList<TeamVO> h=new ArrayList<TeamVO>();		

	
		h=a.sortTeam(o,m[0],SortType.Null);

		assertNotNull(h);
	}
	
	@Test
	public void testSortTeam1() {
		
		ArrayList<TeamVO> o=new ArrayList<TeamVO>();
		TeamVO pv=new TeamVO();
		pv.setRebounds(19);
		TeamVO pv1=new TeamVO();
		pv1.setRebounds(18);
		o.add(pv1);
		o.add(pv);
		ArrayList<TeamVO> h=new ArrayList<TeamVO>();		

	
		h=a.sortTeam(o,m[1],SortType.Null);

		assertNotNull(h);
	}
	@Test
	public void testSortTeam2() {
		
		ArrayList<TeamVO> o=new ArrayList<TeamVO>();
		TeamVO pv=new TeamVO();
		pv.setRebounds(19);
		TeamVO pv1=new TeamVO();
		pv1.setRebounds(18);
		o.add(pv1);
		o.add(pv);
		ArrayList<TeamVO> h=new ArrayList<TeamVO>();		

	
		h=a.sortTeam(o,m[2],SortType.Null);

		assertNotNull(h);
	}
	@Test
	public void testSortTeam3() {
		
		ArrayList<TeamVO> o=new ArrayList<TeamVO>();
		TeamVO pv=new TeamVO();
		pv.setRebounds(19);
		TeamVO pv1=new TeamVO();
		pv1.setRebounds(18);
		o.add(pv1);
		o.add(pv);
		ArrayList<TeamVO> h=new ArrayList<TeamVO>();		

	
		h=a.sortTeam(o,m[3],SortType.Null);

		assertNotNull(h);
	}
	@Test
	public void testSortTeam4() {
		
		ArrayList<TeamVO> o=new ArrayList<TeamVO>();
		TeamVO pv=new TeamVO();
		pv.setRebounds(19);
		TeamVO pv1=new TeamVO();
		pv1.setRebounds(18);
		o.add(pv1);
		o.add(pv);
		ArrayList<TeamVO> h=new ArrayList<TeamVO>();		

	
		h=a.sortTeam(o,m[4],SortType.Null);

		assertNotNull(h);
	}
	@Test
	public void testSortTeam5() {
		
		ArrayList<TeamVO> o=new ArrayList<TeamVO>();
		TeamVO pv=new TeamVO();
		pv.setRebounds(19);
		TeamVO pv1=new TeamVO();
		pv1.setRebounds(18);
		o.add(pv1);
		o.add(pv);
		ArrayList<TeamVO> h=new ArrayList<TeamVO>();		

	
		h=a.sortTeam(o,m[5],SortType.Null);

		assertNotNull(h);
	}
	@Test
	public void testSortTeam6() {
		
		ArrayList<TeamVO> o=new ArrayList<TeamVO>();
		TeamVO pv=new TeamVO();
		pv.setRebounds(19);
		TeamVO pv1=new TeamVO();
		pv1.setRebounds(18);
		o.add(pv1);
		o.add(pv);
		ArrayList<TeamVO> h=new ArrayList<TeamVO>();		

	
		h=a.sortTeam(o,m[6],SortType.Null);

		assertNotNull(h);
	}
	@Test
	public void testSortTeam7() {
		
		ArrayList<TeamVO> o=new ArrayList<TeamVO>();
		TeamVO pv=new TeamVO();
		pv.setRebounds(19);
		TeamVO pv1=new TeamVO();
		pv1.setRebounds(18);
		o.add(pv1);
		o.add(pv);
		ArrayList<TeamVO> h=new ArrayList<TeamVO>();		

	
		h=a.sortTeam(o,m[7],SortType.Null);

		assertNotNull(h);
	}
	@Test
	public void testSortTeam8() {
		
		ArrayList<TeamVO> o=new ArrayList<TeamVO>();
		TeamVO pv=new TeamVO();
		pv.setRebounds(19);
		TeamVO pv1=new TeamVO();
		pv1.setRebounds(18);
		o.add(pv1);
		o.add(pv);
		ArrayList<TeamVO> h=new ArrayList<TeamVO>();		

	
		h=a.sortTeam(o,m[8],SortType.Null);

		assertNotNull(h);
	}
	@Test
	public void testSortTeam9() {
		
		ArrayList<TeamVO> o=new ArrayList<TeamVO>();
		TeamVO pv=new TeamVO();
		pv.setRebounds(19);
		TeamVO pv1=new TeamVO();
		pv1.setRebounds(18);
		o.add(pv1);
		o.add(pv);
		ArrayList<TeamVO> h=new ArrayList<TeamVO>();		

	
		h=a.sortTeam(o,m[9],SortType.Null);

		assertNotNull(h);
	}
	@Test
	public void testSortTeam10() {
		
		ArrayList<TeamVO> o=new ArrayList<TeamVO>();
		TeamVO pv=new TeamVO();
		pv.setRebounds(19);
		TeamVO pv1=new TeamVO();
		pv1.setRebounds(18);
		o.add(pv1);
		o.add(pv);
		ArrayList<TeamVO> h=new ArrayList<TeamVO>();		

	
		h=a.sortTeam(o,m[10],SortType.Null);

		assertNotNull(h);
	}
	@Test
	public void testSortTeam11() {
		
		ArrayList<TeamVO> o=new ArrayList<TeamVO>();
		TeamVO pv=new TeamVO();
		pv.setRebounds(19);
		TeamVO pv1=new TeamVO();
		pv1.setRebounds(18);
		o.add(pv1);
		o.add(pv);
		ArrayList<TeamVO> h=new ArrayList<TeamVO>();		

	
		h=a.sortTeam(o,m[11],SortType.Null);

		assertNotNull(h);
	}
	@Test
	public void testSortTeam12() {
		
		ArrayList<TeamVO> o=new ArrayList<TeamVO>();
		TeamVO pv=new TeamVO();
		pv.setRebounds(19);
		TeamVO pv1=new TeamVO();
		pv1.setRebounds(18);
		o.add(pv1);
		o.add(pv);
		ArrayList<TeamVO> h=new ArrayList<TeamVO>();		

	
		h=a.sortTeam(o,m[12],SortType.Null);

		assertNotNull(h);
	}
	@Test
	public void testSortTeam13() {
		
		ArrayList<TeamVO> o=new ArrayList<TeamVO>();
		TeamVO pv=new TeamVO();
		pv.setRebounds(19);
		TeamVO pv1=new TeamVO();
		pv1.setRebounds(18);
		o.add(pv1);
		o.add(pv);
		ArrayList<TeamVO> h=new ArrayList<TeamVO>();		

	
		h=a.sortTeam(o,m[13],SortType.Null);

		assertNotNull(h);
	}
	@Test
	public void testSortTeam14() {
		
		ArrayList<TeamVO> o=new ArrayList<TeamVO>();
		TeamVO pv=new TeamVO();
		pv.setRebounds(19);
		TeamVO pv1=new TeamVO();
		pv1.setRebounds(18);
		o.add(pv1);
		o.add(pv);
		ArrayList<TeamVO> h=new ArrayList<TeamVO>();		

	
		h=a.sortTeam(o,m[14],SortType.Null);

		assertNotNull(h);
	}
	
	@Test
	public void testSortTeam15() {
		
		ArrayList<TeamVO> o=new ArrayList<TeamVO>();
		TeamVO pv=new TeamVO();
		pv.setRebounds(19);
		TeamVO pv1=new TeamVO();
		pv1.setRebounds(18);
		o.add(pv1);
		o.add(pv);
		ArrayList<TeamVO> h=new ArrayList<TeamVO>();		

	
		h=a.sortTeam(o,oppm[0],SortType.Null);

		assertNotNull(h);
	}
	
	@Test
	public void testSortTeam16() {
		
		ArrayList<TeamVO> o=new ArrayList<TeamVO>();
		TeamVO pv=new TeamVO();
		pv.setRebounds(19);
		TeamVO pv1=new TeamVO();
		pv1.setRebounds(18);
		o.add(pv1);
		o.add(pv);
		ArrayList<TeamVO> h=new ArrayList<TeamVO>();		

	
		h=a.sortTeam(o,oppm[1],SortType.Null);

		assertNotNull(h);
	}
	
	@Test
	public void testSortTeam17() {
		
		ArrayList<TeamVO> o=new ArrayList<TeamVO>();
		TeamVO pv=new TeamVO();
		pv.setRebounds(19);
		TeamVO pv1=new TeamVO();
		pv1.setRebounds(18);
		o.add(pv1);
		o.add(pv);
		ArrayList<TeamVO> h=new ArrayList<TeamVO>();		

	
		h=a.sortTeam(o,oppm[2],SortType.Null);

		assertNotNull(h);
	}
	
	@Test
	public void testSortTeam18() {
		
		ArrayList<TeamVO> o=new ArrayList<TeamVO>();
		TeamVO pv=new TeamVO();
		pv.setRebounds(19);
		TeamVO pv1=new TeamVO();
		pv1.setRebounds(18);
		o.add(pv1);
		o.add(pv);
		ArrayList<TeamVO> h=new ArrayList<TeamVO>();		

	
		h=a.sortTeam(o,oppm[3],SortType.Null);

		assertNotNull(h);
	}
	
	@Test
	public void testSortTeam19() {
		
		ArrayList<TeamVO> o=new ArrayList<TeamVO>();
		TeamVO pv=new TeamVO();
		pv.setRebounds(19);
		TeamVO pv1=new TeamVO();
		pv1.setRebounds(18);
		o.add(pv1);
		o.add(pv);
		ArrayList<TeamVO> h=new ArrayList<TeamVO>();		

	
		h=a.sortTeam(o,oppm[4],SortType.Null);

		assertNotNull(h);
	}
	
	@Test
	public void testSortTeam20() {
		
		ArrayList<TeamVO> o=new ArrayList<TeamVO>();
		TeamVO pv=new TeamVO();
		pv.setRebounds(19);
		TeamVO pv1=new TeamVO();
		pv1.setRebounds(18);
		o.add(pv1);
		o.add(pv);
		ArrayList<TeamVO> h=new ArrayList<TeamVO>();		

	
		h=a.sortTeam(o,oppm[5],SortType.Null);

		assertNotNull(h);
	}
	
	@Test
	public void testSortTeam21() {
		
		ArrayList<TeamVO> o=new ArrayList<TeamVO>();
		TeamVO pv=new TeamVO();
		pv.setRebounds(19);
		TeamVO pv1=new TeamVO();
		pv1.setRebounds(18);
		o.add(pv1);
		o.add(pv);
		ArrayList<TeamVO> h=new ArrayList<TeamVO>();		

	
		h=a.sortTeam(o,oppm[6],SortType.Null);

		assertNotNull(h);
	}
	
	@Test
	public void testSortTeam22() {
		
		ArrayList<TeamVO> o=new ArrayList<TeamVO>();
		TeamVO pv=new TeamVO();
		pv.setRebounds(19);
		TeamVO pv1=new TeamVO();
		pv1.setRebounds(18);
		o.add(pv1);
		o.add(pv);
		ArrayList<TeamVO> h=new ArrayList<TeamVO>();		

	
		h=a.sortTeam(o,oppm[7],SortType.Null);

		assertNotNull(h);
	}
	
	@Test
	public void testSortTeam23() {
		
		ArrayList<TeamVO> o=new ArrayList<TeamVO>();
		TeamVO pv=new TeamVO();
		pv.setRebounds(19);
		TeamVO pv1=new TeamVO();
		pv1.setRebounds(18);
		o.add(pv1);
		o.add(pv);
		ArrayList<TeamVO> h=new ArrayList<TeamVO>();		

	
		h=a.sortTeam(o,oppm[8],SortType.Null);

		assertNotNull(h);
	}
	
	@Test
	public void testSortTeam24() {
		
		ArrayList<TeamVO> o=new ArrayList<TeamVO>();
		TeamVO pv=new TeamVO();
		pv.setRebounds(19);
		TeamVO pv1=new TeamVO();
		pv1.setRebounds(18);
		o.add(pv1);
		o.add(pv);
		ArrayList<TeamVO> h=new ArrayList<TeamVO>();		

	
		h=a.sortTeam(o,m[15],SortType.Null);

		assertNotNull(h);
	}
	
	@Test
	public void testSortTeam25() {
		
		ArrayList<TeamVO> o=new ArrayList<TeamVO>();
		TeamVO pv=new TeamVO();
		pv.setRebounds(19);
		TeamVO pv1=new TeamVO();
		pv1.setRebounds(18);
		o.add(pv1);
		o.add(pv);
		ArrayList<TeamVO> h=new ArrayList<TeamVO>();		

	
		h=a.sortTeam(o,m[16],SortType.Null);

		assertNotNull(h);
	}
	@Test
	public void testSortTeam26() {
		
		ArrayList<TeamVO> o=new ArrayList<TeamVO>();
		TeamVO pv=new TeamVO();
		pv.setRebounds(19);
		TeamVO pv1=new TeamVO();
		pv1.setRebounds(18);
		o.add(pv1);
		o.add(pv);
		ArrayList<TeamVO> h=new ArrayList<TeamVO>();		

	
		h=a.sortTeam(o,m[17],SortType.Null);

		assertNotNull(h);
	}
	@Test
	public void testSortTeam27() {
		
		ArrayList<TeamVO> o=new ArrayList<TeamVO>();
		TeamVO pv=new TeamVO();
		pv.setRebounds(19);
		TeamVO pv1=new TeamVO();
		pv1.setRebounds(18);
		o.add(pv1);
		o.add(pv);
		ArrayList<TeamVO> h=new ArrayList<TeamVO>();		

	
		h=a.sortTeam(o,m[18],SortType.Null);

		assertNotNull(h);
	}
	@Test
	public void testSortTeam28() {
		
		ArrayList<TeamVO> o=new ArrayList<TeamVO>();
		TeamVO pv=new TeamVO();
		pv.setRebounds(19);
		TeamVO pv1=new TeamVO();
		pv1.setRebounds(18);
		o.add(pv1);
		o.add(pv);
		ArrayList<TeamVO> h=new ArrayList<TeamVO>();		

	
		h=a.sortTeam(o,m[19],SortType.Null);

		assertNotNull(h);
	}
	
	@Test
	public void testSortTeam29() {
		
		ArrayList<TeamVO> o=new ArrayList<TeamVO>();
		TeamVO pv=new TeamVO();
		pv.setRebounds(19);
		TeamVO pv1=new TeamVO();
		pv1.setRebounds(18);
		o.add(pv1);
		o.add(pv);
		ArrayList<TeamVO> h=new ArrayList<TeamVO>();		

	
		h=a.sortTeam(o,m[20],SortType.Null);

		assertNotNull(h);
	}
	
	@Test
	public void testSortTeam30() {
		
		ArrayList<TeamVO> o=new ArrayList<TeamVO>();
		TeamVO pv=new TeamVO();
		pv.setRebounds(19);
		TeamVO pv1=new TeamVO();
		pv1.setRebounds(18);
		o.add(pv1);
		o.add(pv);
		ArrayList<TeamVO> h=new ArrayList<TeamVO>();		

	
		h=a.sortTeam(o,m[21],SortType.Null);

		assertNotNull(h);
	}
	@Test
	public void testSortTeam31() {
		
		ArrayList<TeamVO> o=new ArrayList<TeamVO>();
		TeamVO pv=new TeamVO();
		pv.setRebounds(19);
		TeamVO pv1=new TeamVO();
		pv1.setRebounds(18);
		o.add(pv1);
		o.add(pv);
		ArrayList<TeamVO> h=new ArrayList<TeamVO>();		

	
		h=a.sortTeam(o,m[22],SortType.Null);

		assertNotNull(h);
	}
	@Test
	public void testSortTeam32() {
		
		ArrayList<TeamVO> o=new ArrayList<TeamVO>();
		TeamVO pv=new TeamVO();
		pv.setRebounds(19);
		TeamVO pv1=new TeamVO();
		pv1.setRebounds(18);
		o.add(pv1);
		o.add(pv);
		ArrayList<TeamVO> h=new ArrayList<TeamVO>();		

	
		h=a.sortTeam(o,m[23],SortType.Null);

		assertNotNull(h);
	}
	@Test
	public void testSortTeam33() {
		
		ArrayList<TeamVO> o=new ArrayList<TeamVO>();
		TeamVO pv=new TeamVO();
		pv.setRebounds(19);
		TeamVO pv1=new TeamVO();
		pv1.setRebounds(18);
		o.add(pv1);
		o.add(pv);
		ArrayList<TeamVO> h=new ArrayList<TeamVO>();		

	
		h=a.sortTeam(o,m[24],SortType.Null);

		assertNotNull(h);
	}
	@Test
	public void testSortTeam34() {
		
		ArrayList<TeamVO> o=new ArrayList<TeamVO>();
		TeamVO pv=new TeamVO();
		pv.setRebounds(19);
		TeamVO pv1=new TeamVO();
		pv1.setRebounds(18);
		o.add(pv1);
		o.add(pv);
		ArrayList<TeamVO> h=new ArrayList<TeamVO>();		

	
		h=a.sortTeam(o,m[25],SortType.Null);

		assertNotNull(h);
	}
	
	@Test
	public void testSortTeam35() {
		
		ArrayList<TeamVO> o=new ArrayList<TeamVO>();
		TeamVO pv=new TeamVO();
		pv.setRebounds(19);
		TeamVO pv1=new TeamVO();
		pv1.setRebounds(18);
		o.add(pv1);
		o.add(pv);
		ArrayList<TeamVO> h=new ArrayList<TeamVO>();		

	
		h=a.sortTeam(o,m[26],SortType.Null);

		assertNotNull(h);
	}
	@Test
	
	public void testGetTopFiftyPlayer1() {
		ArrayList<PlayerVO> h=new ArrayList<PlayerVO>();
		h=a.getTopFiftyPlayer(PlayerPosition.Center,PlayerPartition.Pacific, "a");
		assertNotNull(h);
	}
	
@Test
	
	public void testGetTopFiftyPlayer2() {
		ArrayList<PlayerVO> h=new ArrayList<PlayerVO>();
		h=a.getTopFiftyPlayer(PlayerPosition.Guard, PlayerPartition.West, "a");
		assertNotNull(h);
	}
	
@Test

	public void testGetTopFiftyPlaye3r() {
		ArrayList<PlayerVO> h=new ArrayList<PlayerVO>();
		h=a.getTopFiftyPlayer(PlayerPosition.Forward, PlayerPartition.Atlantic, "a");
		assertNotNull(h);
	}

@Test

	public void testGetTopFiftyPlayer4() {
		ArrayList<PlayerVO> h=new ArrayList<PlayerVO>();
		h=a.getTopFiftyPlayer(PlayerPosition.All,PlayerPartition.Central, "a");
		assertNotNull(h);
	}

@Test

	public void testGetTopFiftyPlayer5() {
		ArrayList<PlayerVO> h=new ArrayList<PlayerVO>();
		h=a.getTopFiftyPlayer(PlayerPosition.All, PlayerPartition.Southeast, "a");
		assertNotNull(h);
	}

@Test

	public void testGetTopFiftyPlayer6() {
		ArrayList<PlayerVO> h=new ArrayList<PlayerVO>();
		h=a.getTopFiftyPlayer(PlayerPosition.All, PlayerPartition.Southwest, "a");
		assertNotNull(h);
	}

@Test

	public void testGetTopFiftyPlayer7() {
		ArrayList<PlayerVO> h=new ArrayList<PlayerVO>();
		h=a.getTopFiftyPlayer(PlayerPosition.All, PlayerPartition.Northwest, "a");
		assertNotNull(h);
	}

@Test

	public void testGetTopFiftyPlayer8() {
		ArrayList<PlayerVO> h=new ArrayList<PlayerVO>();
		h=a.getTopFiftyPlayer(PlayerPosition.All,PlayerPartition.East, "a");
		assertNotNull(h);
	}

	


	@Test
	public void testGetSeasonHotSpotPlayer() {
		ArrayList<PlayerVO> h=new ArrayList<PlayerVO>();
		h=a.getSeasonHotSpotPlayer("a");
		assertNotNull(h);
	}

	@Test
	public void testGetSeasonHotSpotTeam() {
		 ArrayList<TeamVO> h=new ArrayList<TeamVO>();
		 h=a.getSeasonHotSpotTeam("a");
		 assertNotNull(h);
	}

	@Test
	public void testGetProgressivePlayer() {
		ArrayList<PlayerVO> h=new ArrayList<PlayerVO>();
		h=a.getProgressivePlayer("a");
		 assertNotNull(h);
	}


	@Test
	public void testGetTopNPlayers() {
		String[]keyword={"a","b"};
		SortType[]sortType={SortType.Ascending};
		ArrayList<PlayerVO> h=new ArrayList<PlayerVO>();
		h= a.getTopNPlayers(3, PlayerPosition.Center,PlayerPartition.Atlantic, PlayerAge.from23to25,keyword,sortType);
		assertNotNull(h);
	}
	@Test
	public void testGetTopNPlayers1() {
		String[]keyword={"a","b"};
		SortType[]sortType={SortType.Ascending};
		ArrayList<PlayerVO> h=new ArrayList<PlayerVO>();
		h= a.getTopNPlayers(3, PlayerPosition.Forward,PlayerPartition.Central, PlayerAge.from26to30,keyword,sortType);
		assertNotNull(h);
	}
	@Test
	public void testGetTopNPlayers2() {
		String[]keyword={"a","b"};
		SortType[]sortType={SortType.Ascending};
		ArrayList<PlayerVO> h=new ArrayList<PlayerVO>();
		h= a.getTopNPlayers(3, PlayerPosition.Guard,PlayerPartition.East, PlayerAge.lessthan23,keyword,sortType);
		assertNotNull(h);
	}
	
	@Test
	public void testGetTopNPlayers3() {
		String[]keyword={"a","b"};
		SortType[]sortType={SortType.Ascending};
		ArrayList<PlayerVO> h=new ArrayList<PlayerVO>();
		h= a.getTopNPlayers(3, PlayerPosition.Guard,PlayerPartition.Northwest, PlayerAge.lessthan23,keyword,sortType);
		assertNotNull(h);
	}
	

	@Test
	public void testGetTopNPlayers4() {
		String[]keyword={"a","b"};
		SortType[]sortType={SortType.Ascending};
		ArrayList<PlayerVO> h=new ArrayList<PlayerVO>();
		h= a.getTopNPlayers(3, PlayerPosition.Guard,PlayerPartition.Pacific, PlayerAge.lessthan23,keyword,sortType);
		assertNotNull(h);
	}
	
	@Test
	public void testGetTopNPlayers5() {
		String[]keyword={"a","b"};
		SortType[]sortType={SortType.Ascending};
		ArrayList<PlayerVO> h=new ArrayList<PlayerVO>();
		h= a.getTopNPlayers(3, PlayerPosition.Guard,PlayerPartition.Southeast, PlayerAge.lessthan23,keyword,sortType);
		assertNotNull(h);
	}


	@Test
	public void testMySort() {
		ArrayList<PlayerVO> h=new ArrayList<PlayerVO>();
		ArrayList<PlayerVO> h1=new ArrayList<PlayerVO>();
		
		h1=a.getTopFiftyPlayer(PlayerPosition.Forward, PlayerPartition.Atlantic, "rebound");
		String[]keyword={"rebounds","assists","minutes2"};
		SortType[]sortType={SortType.Ascending};
		h=a.mySort( h1,keyword,sortType,24);
		assertNotNull(h);
	}
	@Test
	 public void testgetTodayHotSpotPlayer(){
		ArrayList<TodayPlayerVO> h=new ArrayList<TodayPlayerVO>();
		h=a.getTodayHotSpotPlayer("rebound");
		
	} 
	
}
