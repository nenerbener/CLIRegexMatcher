package com.nenerbener;

import joptsimple.util.RegexMatcher;
import joptsimple.ValueConversionException;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;
import static org.junit.rules.ExpectedException.*;

import java.util.regex.PatternSyntaxException;
	
public class CLIRegexMatcher {
	/**
	 * driver class to test RegexMatcherTest
	 * @param args args[0] = regex pattern, args[1] is URL
	 */
	public static void main(String[] args) {
		//		CLIRegexMatcher crm = new CLIRegexMatcher();
		try {
//			RegexMatcher rm = new RegexMatcher("^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]",0);
			RegexMatcher rm = new RegexMatcher(args[0],0);
			System.out.println("url: " + args[1]);
			try {
				String str = rm.convert(args[1]);
				System.out.println("conversion: " + str);
			} catch (ValueConversionException e) {
				System.out.println(e.getMessage());
			}

		} catch (PatternSyntaxException e) {
			System.out.println(e.getMessage());
		}
	}
}
