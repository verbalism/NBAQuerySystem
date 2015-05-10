package data;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import po.BasicTeamPO;

public class BasicTeamDataTest {
	BasicTeamData btd=null;
	@Before
	public void setUp() throws Exception {
		btd=new BasicTeamData();
	}

	@After
	public void tearDown() throws Exception {
		btd=null;
	}

	@Test
	public void testGetTeamOriginal() {
		ArrayList<BasicTeamPO> btp=btd.getTeamOriginal();
		assertNotNull(btp);
	}

	@Test
	public void testGetSingleTeamOriginal() {
		BasicTeamPO btp=new BasicTeamPO();
		String teamName="ATL";
		btp=btd.getSingleTeamOriginal(teamName);
		assertNotNull(btp);
	}

	@Test
	public void testRemoveBlankSpace() {
		String string=new String();
		String s="  abc  ";
		string=btd.removeBlankSpace(s);
		assertNotNull(string);
	}

}
