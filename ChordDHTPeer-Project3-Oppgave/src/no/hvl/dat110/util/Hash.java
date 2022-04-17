package no.hvl.dat110.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash { 
	
	private static MessageDigest md;
	
	private static BigInteger hashint; 
	
	public static BigInteger hashOf(String entity) {		
		
		// Task: Hash a given string using MD5 and return the result as a BigInteger.
		
		// we use MD5 with 128 bits digest
		
		// compute the hash of the input 'entity'
		
		// convert the hash into hex format
		
		// convert the hex into BigInteger
		
		// return the BigInteger
		
		try {
			md = MessageDigest.getInstance("MD5");
			byte[] messageDigest = md.digest(entity.getBytes());
			String hex = toHex(messageDigest);
			hashint = new BigInteger(hex, 16);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return hashint;
	}
	
	public static BigInteger addressSize() {
		
		// Task: compute the address size of MD5
		
		// get the digest length
		
		// compute the number of bits = digest length * 8
		
		// compute the address size = 2 ^ number of bits
		
		// return the address size
		
		BigInteger two = new BigInteger("2");
		BigInteger result = two.pow(bitSize());
		return result;
	}
	
	public static int bitSize() {
		
		int digestlen = 0;
		
		try {
			md = MessageDigest.getInstance("MD5");
			digestlen = md.getDigestLength();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return digestlen*8;
	}
	
	public static String toHex(byte[] digest) {
		StringBuilder strbuilder = new StringBuilder();
		for(byte b : digest) {
			strbuilder.append(String.format("%02x", b&0xff));
		}
		return strbuilder.toString();
	}

}
