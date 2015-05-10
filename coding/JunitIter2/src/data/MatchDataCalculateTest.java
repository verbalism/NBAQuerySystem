package data;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MatchDataCalculateTest {
	MatchDataCalculate mdc=null;
	@Before
	public void setUp() throws Exception {
		mdc=new MatchDataCalculate();
	}

	@After
	public void tearDown() throws Exception {
		mdc=null;
	}

	@Test
	public void testGetSortedFile() {
		ArrayList <String> s=new ArrayList<String>();
		s=mdc.getSortedFile();
		assertNotNull(s);
	}

}