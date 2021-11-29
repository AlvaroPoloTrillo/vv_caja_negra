package com.practica.cajanegra;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.cajanegra.AbstractSingleLinkedListImpl;
import com.cajanegra.EmptyCollectionException;
import com.cajanegra.SingleLinkedListImpl;

class ReturnElements {

	private  static SingleLinkedListImpl<String> lista0 ;
	private  static SingleLinkedListImpl<String> lista1 ;
	private  static SingleLinkedListImpl<String> lista2 ;
	private  static SingleLinkedListImpl<String> lista3 ;
	private  static SingleLinkedListImpl<String> lista4 ;
	private  static SingleLinkedListImpl<String> lista5 ;
	private  static SingleLinkedListImpl<String> lista6 ;

	private  static SingleLinkedListImpl<String> listaVacia ;
	
	@BeforeEach
	public void setUp() {
		lista0 = new SingleLinkedListImpl<String>("A","B","C","@");
		lista1 = new SingleLinkedListImpl<String>("A","B","C","A");
		lista2 = new SingleLinkedListImpl<String>("A","B","C","B");
		lista3 = new SingleLinkedListImpl<String>("A","B","C","M");
		lista4 = new SingleLinkedListImpl<String>("A","B","C","Y");
		lista5 = new SingleLinkedListImpl<String>("A","B","C","Z");
		lista6 = new SingleLinkedListImpl<String>("A","B","C","[");
		listaVacia = new SingleLinkedListImpl<String>();
	}

	
	
	
	@DisplayName("Probando removeLast()")
	@ParameterizedTest
	@MethodSource("ArgumentosRemoveLast")
	void testRemoveLast(String letter, SingleLinkedListImpl<String> list)  {
		try {
		assertEquals(letter,list.removeLast());
		}catch(EmptyCollectionException e1) {
			assertThrows(EmptyCollectionException.class, ()-> { 
				list.removeLast();
			});
		}
	}
	
	static Stream<Arguments> ArgumentosRemoveLast(){
		
		return Stream.of(
					Arguments.of("@",lista0),
					Arguments.of("A",lista1),
					Arguments.of("B",lista2),
					Arguments.of("M",lista3),
					Arguments.of("Y",lista4),
					Arguments.of("Z",lista5),
					Arguments.of("[",lista6),
					Arguments.of("R",listaVacia)
					
				);
	}
	
	
	// ---------------------------------------
	
	
	@DisplayName("Probando removeLast(T elem)")
	@ParameterizedTest
	@MethodSource("ArgumentosRemoveLastTelem")
	void testRemoveLastTelem(String letter,SingleLinkedListImpl<String> listaModificada, SingleLinkedListImpl<String> list)  {
		try {
		String aux = list.removeLast(letter);
		assertEquals(aux,letter);
		assertEquals(listaModificada,list);
		}catch(EmptyCollectionException e1) {
			assertThrows(EmptyCollectionException.class, ()-> { 
				list.removeLast();
			});
		}catch(NoSuchElementException e2) {
			assertThrows(EmptyCollectionException.class, ()-> { 
				list.removeLast();
			});
		}
	}
	
	static Stream<Arguments> ArgumentosRemoveLastTelem(){
		
		SingleLinkedListImpl<String> lista = new SingleLinkedListImpl<String>("A","B","C");
		
		
				return Stream.of(
					Arguments.of("@",lista,lista0),
					Arguments.of("A",lista,lista1),
					Arguments.of("B",lista,lista2),
					Arguments.of("M",lista,lista3),
					Arguments.of("Y",lista,lista4),
					Arguments.of("Z",lista,lista5),
					Arguments.of("[",lista,lista6),
					Arguments.of("P",lista,lista1),
					Arguments.of("T",lista,listaVacia)
				);
	}
	
	// -----------------------------
	
	@DisplayName("Probando getAtPos()")
	@ParameterizedTest
	@MethodSource("ArgumentosGetAtPos")
	void testGetAtPos(String letter, SingleLinkedListImpl<String> s, int pos){
		try {
		assertEquals(letter,s.getAtPos(pos));
		} catch(IllegalArgumentException e) {
		assertThrows(IllegalArgumentException.class, ()-> { 
			s.getAtPos(pos);
			});
		}
	}
	
	static Stream<Arguments> ArgumentosGetAtPos(){
		
		return Stream.of(
					Arguments.of("@",lista0,4),
					Arguments.of("A",lista1,4),
					Arguments.of("B",lista2,4),
					Arguments.of("M",lista3,4),
					Arguments.of("Y",lista4,4),
					Arguments.of("Z",lista5,4),
					Arguments.of("[",lista6,4),
					Arguments.of("A",lista6,-4),
					Arguments.of("A",lista2,14)				
				);
	}
	
	//-----------------------------------
	
	@DisplayName("Probando isSubList()")
	@ParameterizedTest
	@MethodSource("ArgumentosIsSubList")
	void testIsSubList(int arg, SingleLinkedListImpl<String> list, AbstractSingleLinkedListImpl<String> sublist)  {
		int posicion = list.isSubList(sublist);
		assertEquals(posicion,arg);
	}
	
	static Stream<Arguments> ArgumentosIsSubList(){
		lista0 = new SingleLinkedListImpl<String>("A","B","C","@");
		lista1 = new SingleLinkedListImpl<String>("A","B","C","A");
		lista2 = new SingleLinkedListImpl<String>("A","B","C","B");
		lista3 = new SingleLinkedListImpl<String>("A","B","C","M");
		lista4 = new SingleLinkedListImpl<String>("A","B","C","Y");
		lista5 = new SingleLinkedListImpl<String>("A","B","C","Z");
		lista6 = new SingleLinkedListImpl<String>("A","B","C","[");
		listaVacia = new SingleLinkedListImpl<String>();
		
		AbstractSingleLinkedListImpl<String> s0 = new SingleLinkedListImpl<String>("B","C","@");
		AbstractSingleLinkedListImpl<String> s1 = new SingleLinkedListImpl<String>("B","C","A");
		AbstractSingleLinkedListImpl<String> s2 = new SingleLinkedListImpl<String>("B","C","B");
		AbstractSingleLinkedListImpl<String> s3 = new SingleLinkedListImpl<String>("B","C","M");
		AbstractSingleLinkedListImpl<String> s4 = new SingleLinkedListImpl<String>("B","C","Y");
		AbstractSingleLinkedListImpl<String> s5 = new SingleLinkedListImpl<String>("B","C","Z");
		AbstractSingleLinkedListImpl<String> s6 = new SingleLinkedListImpl<String>("B","C","[");
		AbstractSingleLinkedListImpl<String> s7 = new SingleLinkedListImpl<String>("T","O");

	
		return Stream.of(
					Arguments.of(2,lista0,s0),
					Arguments.of(2,lista1,s1),
					Arguments.of(2,lista2,s2),
					Arguments.of(2,lista3,s3),
					Arguments.of(2,lista4,s4),
					Arguments.of(2,lista5,s5),
					Arguments.of(2,lista6,s6),
					Arguments.of(0,lista0,listaVacia),
					Arguments.of(-1,lista1,s7)					
										
				);
	}
	
	
	
}
