/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hello;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tmeltse
 */
public class AsherJUnitTest
{
	public AsherJUnitTest()
	{
	}

	@BeforeClass
	public static void setUpClass()
	{
	}

	@AfterClass
	public static void tearDownClass()
	{
	}

	@Before
	public void setUp()
	{
	}

	@After
	public void tearDown()
	{
	}

	@Test
	public void test4Asher()
	{
		try
		{
			URL asher = new URL("http://10.106.161.40:30682");
			URLConnection yc = asher.openConnection();
			try (BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream())))
			{
				String inputLine;
				StringBuilder sb = new StringBuilder();

				while ((inputLine = in.readLine()) != null)
				{
					sb.append(inputLine);
				}

				assertEquals("No match!","Greetings from Spring Boot! - Feature2",sb.toString());
				// bla
			}
		}
		catch (MalformedURLException ex)
		{
			Logger.getLogger(AsherJUnitTest.class.getName()).log(Level.SEVERE, null, ex);
		}
		catch (IOException ex)
		{
			Logger.getLogger(AsherJUnitTest.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
