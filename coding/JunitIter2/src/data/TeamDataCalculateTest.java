package data;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import po.MatchPO;
import po.TeamPO;

public class TeamDataCalculateTest {
	TeamDataCalculate tdc=new TeamDataCalculate();
	@Before
	public void setUp() throws Exception {
		tdc=new TeamDataCalculate();
	}

	@After
	public void tearDown() throws Exception {
		tdc=null;
	}

	@Test
	public void testJudgeEmptyFile() {
		boolean b=tdc.judgeEmptyFile("Data//teamInfoPO.txt");
		assertNotNull(b);
	}


	@Test
	public void testReadTeamInfo() {
		ArrayList<TeamPO> tp=tdc.readTeamInfo();
		assertNotNull(tp);
	}

	@Test
	public void testCalculateFieldGoalsMade() {
		int i;
		ArrayList<MatchPO> mp=new ArrayList<MatchPO>();
		i=tdc.calculateFieldGoalsMade("CHA",mp);
		assertNotNull(i);
	}

	@Test
	public void testCalculateOppositeFieldGoalsMade() {
		int i;
		ArrayList<MatchPO> mp=new ArrayList<MatchPO>();
		i=tdc.calculateOppositeFieldGoalsMade("CHA",mp);
		assertNotNull(i);
	}

	@Test
	public void testCalculateFieldGoalsAttempted() {
		int i;
		ArrayList<MatchPO> mp=new ArrayList<MatchPO>();
		i=tdc.calculateFieldGoalsAttempted("CHA",mp);
		assertNotNull(i);
	}

	@Test
	public void testCalculateOppositeFieldGoalsAttempted() {
		int i;
		ArrayList<MatchPO> mp=new ArrayList<MatchPO>();
		i=tdc.calculateOppositeFieldGoalsAttempted("CHA",mp);
		assertNotNull(i);
	}

	@Test
	public void testCalculateThreePointFieldGoalsMade() {
		int i;
		ArrayList<MatchPO> mp=new ArrayList<MatchPO>();
		i=tdc.calculateThreePointFieldGoalsMade("CHA",mp);
		assertNotNull(i);
	}

	@Test
	public void testCalculateThreePointFieldGoalsAttempted() {
		int i;
		ArrayList<MatchPO> mp=new ArrayList<MatchPO>();
		i=tdc.calculateThreePointFieldGoalsAttempted("CHA",mp);
		assertNotNull(i);
	}

	@Test
	public void testCalculateFreeThrowsMade() {
		int i;
		ArrayList<MatchPO> mp=new ArrayList<MatchPO>();
		i=tdc.calculateFreeThrowsMade("CHA",mp);
		assertNotNull(i);
	}

	@Test
	public void testCalculateFreeThrowsAttempted() {
		int i;
		ArrayList<MatchPO> mp=new ArrayList<MatchPO>();
		i=tdc.calculateFreeThrowsAttempted("CHA",mp);
		assertNotNull(i);
	}

	@Test
	public void testCalculateOppositeFreeThrowsAttempted() {
		int i;
		ArrayList<MatchPO> mp=new ArrayList<MatchPO>();
		i=tdc.calculateOppositeFreeThrowsAttempted("CHA",mp);
		assertNotNull(i);
	}

	@Test
	public void testCalculateOffensiveRebounds() {
		int i;
		ArrayList<MatchPO> mp=new ArrayList<MatchPO>();
		i=tdc.calculateOffensiveRebounds("CHA",mp);
		assertNotNull(i);
	}

	@Test
	public void testCalculateOppositeOffensiveRebounds() {
		int i;
		ArrayList<MatchPO> mp=new ArrayList<MatchPO>();
		i=tdc.calculateOppositeOffensiveRebounds("CHA",mp);
		assertNotNull(i);
	}

	@Test
	public void testCalculateDefensiveRebounds() {
		int i;
		ArrayList<MatchPO> mp=new ArrayList<MatchPO>();
		i=tdc.calculateDefensiveRebounds("CHA",mp);
		assertNotNull(i);
	}

	@Test
	public void testCalculateOppositeDefensiveRebounds() {
		int i;
		ArrayList<MatchPO> mp=new ArrayList<MatchPO>();
		i=tdc.calculateOppositeDefensiveRebounds("CHA",mp);
		assertNotNull(i);
	}

	@Test
	public void testCalculateAssists() {
		int i;
		ArrayList<MatchPO> mp=new ArrayList<MatchPO>();
		i=tdc.calculateAssists("CHA",mp);
		assertNotNull(i);
	}

	@Test
	public void testCalculateSteals() {
		int i;
		ArrayList<MatchPO> mp=new ArrayList<MatchPO>();
		i=tdc.calculateSteals("CHA",mp);
		assertNotNull(i);
	}

	@Test
	public void testCalculateBlocks() {
		int i;
		ArrayList<MatchPO> mp=new ArrayList<MatchPO>();
		i=tdc.calculateBlocks("CHA",mp);
		assertNotNull(i);
	}

	@Test
	public void testCalculateTurnovers() {
		int i;
		ArrayList<MatchPO> mp=new ArrayList<MatchPO>();
		i=tdc.calculateTurnovers("CHA",mp);
		assertNotNull(i);
	}

	@Test
	public void testCalculateOppositeTurnovers() {
		int i;
		ArrayList<MatchPO> mp=new ArrayList<MatchPO>();
		i=tdc.calculateOppositeTurnovers("CHA",mp);
		assertNotNull(i);
	}

	@Test
	public void testCalculateFouls() {
		int i;
		ArrayList<MatchPO> mp=new ArrayList<MatchPO>();
		i=tdc.calculateFouls("CHA",mp);
		assertNotNull(i);
	}

	@Test
	public void testCalculatePoints() {
		int i;
		ArrayList<MatchPO> mp=new ArrayList<MatchPO>();
		i=tdc.calculatePoints("CHA",mp);
		assertNotNull(i);
	}

	@Test
	public void testCalculateOppositePoints() {
		int i;
		ArrayList<MatchPO> mp=new ArrayList<MatchPO>();
		i=tdc.calculateOppositePoints("CHA",mp);
		assertNotNull(i);
	}

	@Test
	public void testCalculateWins() {
		int i;
		ArrayList<MatchPO> mp=new ArrayList<MatchPO>();
		i=tdc.calculateWins("CHA",mp);
		assertNotNull(i);
	}

}