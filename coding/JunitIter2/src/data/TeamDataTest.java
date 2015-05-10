package data;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import po.TeamPO;

public class TeamDataTest {
	TeamData tm=null;
	@Before
	public void setUp() throws Exception {
		tm=new TeamData();
	}

	@After
	public void tearDown() throws Exception {
		tm=null;
	}

	@Test
	public void testGetSingleTeamInfo() {
		TeamPO tp=tm.getSingleTeamInfo("CHA");
		assertNotNull(tp);
	}

	@Test
	public void testGetAllTeamInfo() {
		ArrayList<TeamPO> tp=tm.getAllTeamInfo();
		assertNotNull(tp);
	}

}
