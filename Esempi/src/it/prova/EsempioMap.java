package it.prova;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class EsempioMap {
	public static void main(String[] args) {
		Map<String,String> prova = new TreeMap<String,String>();
		prova.put("a", "bella");
		prova.put("A", "fsfa");
		prova.put("bfh", "ciao");
		prova.put("cacccvcccccccc","ciao");
		prova.put("","che dici");
		prova.put("!", "ooo");
		prova.put(" cb","hgg");
		prova.put("c","fh");
		prova.put(" b", "gj");
		prova.put("z", "gh");

		System.out.println(prova);
		String s = "bfh";
		
		
		System.out.println(s.hashCode());
		s= "cc";
		System.out.println(s.hashCode());

	}
}
