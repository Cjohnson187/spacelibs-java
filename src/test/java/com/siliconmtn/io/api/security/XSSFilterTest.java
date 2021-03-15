package com.siliconmtn.io.api.security;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.BufferedReader;
import java.io.Reader;
import java.io.StringReader;

import javax.servlet.FilterChain;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

// Junit 5
import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title</b>: XSSFilterTest.java
 * <b>Project</b>: spacelibs-java
 * <b>Description: </b> Test class that handles the validation utility and all associated
 * validators, DTO's, and factories.
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author Eric Damschroder
 * @version 3.0
 * @since Mar 9, 2021
 * @updates:
 ****************************************************************************/

public class XSSFilterTest {

	/**
	 * Ensure that the filter can run without throwing any errors when provided with data
	 * @throws Exception
	 */
	@Test
	public void testXSSFilter() throws Exception {
		
		XSSFilter xss = new XSSFilter();

        HttpServletRequest request = mock(HttpServletRequest.class);
        XSSRequestWrapper wrappedRequest = mock(XSSRequestWrapper.class);
        ServletResponse response = mock(ServletResponse.class);
        FilterChain chain = mock(FilterChain.class);
        
        
        String test = "<span>test</span>";
        Reader inputString = new StringReader(test);
        BufferedReader reader = new BufferedReader(inputString);
        
        when(request.getReader()).thenReturn(reader);
        when(wrappedRequest.getReader()).thenReturn(reader);

        xss.doFilter(request, response, chain);
        
	}

	/**
	 * Ensure that the filter can run without throwing any errors when given nothing
	 * @throws Exception
	 */
	@Test
	public void testEmptyXSSFilter() throws Exception {
		
		XSSFilter xss = new XSSFilter();

        HttpServletRequest request = mock(HttpServletRequest.class);
        XSSRequestWrapper wrappedRequest = mock(XSSRequestWrapper.class);
        ServletResponse response = mock(ServletResponse.class);
        FilterChain chain = mock(FilterChain.class);
        
        
        String test = "";
        Reader inputString = new StringReader(test);
        BufferedReader reader = new BufferedReader(inputString);
        
        when(request.getReader()).thenReturn(reader);
        when(wrappedRequest.getReader()).thenReturn(reader);

        xss.doFilter(request, response, chain);
        
	}
	
}
