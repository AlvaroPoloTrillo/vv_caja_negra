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
import com.cajanegra.SingleLinkedListImpl;

class TestAddMethods {
	
	
	private  static SingleLinkedListImpl<String> lista1 ;
	private  static SingleLinkedListImpl<String> listaVacia ;

	@BeforeEach
	public void setUp() {
		lista1 = new SingleLinkedListImpl<String>("A","B","C","D","E");
		listaVacia = new SingleLinkedListImpl<String>();
		
	}
	
	@DisplayName("Probando addFirst()")
	@ParameterizedTest
	@MethodSource("ArgumentosAddFirst")
	void testAddFirst(SingleLinkedListImpl<String> listaModificada,SingleLinkedListImpl<String> lista,String letter) {
		lista.addFirst(letter);
		assertEquals(listaModificada,lista);	
	}
	
	static Stream<Arguments> ArgumentosAddFirst(){
		
		SingleLinkedListImpl<String> s1 = new SingleLinkedListImpl<String>("@","A","B","C","D","E");
		SingleLinkedListImpl<String> s2 = new SingleLinkedListImpl<String>("A","A","B","C","D","E");
		SingleLinkedListImpl<String> s3 = new SingleLinkedListImpl<String>("B","A","B","C","D","E");
		SingleLinkedListImpl<String> s4 = new SingleLinkedListImpl<String>("M","A","B","C","D","E");
		SingleLinkedListImpl<String> s5 = new SingleLinkedListImpl<String>("Y","A","B","C","D","E");
		SingleLinkedListImpl<String> s6 = new SingleLinkedListImpl<String>("Z","A","B","C","D","E");
		SingleLinkedListImpl<String> s7 = new SingleLinkedListImpl<String>("[","A","B","C","D","E");


		return Stream.of(
					Arguments.of(s1,lista1,"@"),
					Arguments.of(s2,lista1,"A"),
					Arguments.of(s3,lista1,"B"),
					Arguments.of(s4,lista1,"M"),
					Arguments.of(s5,lista1,"Y"),
					Arguments.of(s6,lista1,"Z"),
					Arguments.of(s7,lista1,"[")
				);
	}
	
	//------------------------------
	
	@DisplayName("Probando addLast()")
	@ParameterizedTest
	@MethodSource("ArgumentosAddLast")
	void testAddLast(SingleLinkedListImpl<String> listaModificada, SingleLinkedListImpl<String> lista,String letter)  {
		lista.addLast(letter);
		assertEquals(listaModificada,lista);	
	}
	
	static Stream<Arguments> ArgumentosAddLast(){
		SingleLinkedListImpl<String> s1 = new SingleLinkedListImpl<String>("A","B","C","D","E","@");
		SingleLinkedListImpl<String> s2 = new SingleLinkedListImpl<String>("A","B","C","D","E","A");
		SingleLinkedListImpl<String> s3 = new SingleLinkedListImpl<String>("A","B","C","D","E","B");
		SingleLinkedListImpl<String> s4 = new SingleLinkedListImpl<String>("A","B","C","D","E","M");
		SingleLinkedListImpl<String> s5 = new SingleLinkedListImpl<String>("A","B","C","D","E","Y");
		SingleLinkedListImpl<String> s6 = new SingleLinkedListImpl<String>("A","B","C","D","E","Z");
		SingleLinkedListImpl<String> s7 = new SingleLinkedListImpl<String>("A","B","C","D","E","[");
		
		lista1 = new SingleLinkedListImpl<String>("A","B","C","D","E");
		listaVacia = new SingleLinkedListImpl<String>();
		

		return Stream.of(
				Arguments.of(s1,lista1,"@"),
				Arguments.of(s2,lista1,"A"),
				Arguments.of(s3,lista1,"B"),
				Arguments.of(s4,lista1,"M"),
				Arguments.of(s5,lista1,"Y"),
				Arguments.of(s6,lista1,"Z"),
				Arguments.of(s7,lista1,"[")		

				);
	}
	
	//-----------------------
	
	@DisplayName("Probando addAtPos()")
	@ParameterizedTest
	@MethodSource("ArgumentosAddAtPos")
	void testAddAtPos(SingleLinkedListImpl<String> listaModificada,SingleLinkedListImpl<String> lista,String letter,int pos)  {
		try {
		lista.addAtPos(letter,pos);
		}catch(IllegalArgumentException e) {
			assertThrows(IllegalArgumentException.class, ()-> { 
				lista.addAtPos(letter,pos);
				});	
		}
	}
	
	static Stream<Arguments> ArgumentosAddAtPos(){
		SingleLinkedListImpl<String> s1 = new SingleLinkedListImpl<String>("A","B","C","@","D","E");
		SingleLinkedListImpl<String> s2 = new SingleLinkedListImpl<String>("A","B","C","A","D","E");
		SingleLinkedListImpl<String> s3 = new SingleLinkedListImpl<String>("A","B","C","B","D","E");
		SingleLinkedListImpl<String> s4 = new SingleLinkedListImpl<String>("A","B","C","M","D","E");
		SingleLinkedListImpl<String> s5 = new SingleLinkedListImpl<String>("A","B","C","Y","D","E");
		SingleLinkedListImpl<String> s6 = new SingleLinkedListImpl<String>("A","B","C","Z","D","E");
		SingleLinkedListImpl<String> s7 = new SingleLinkedListImpl<String>("A","B","C","[","D","E");
		SingleLinkedListImpl<String> s8 = new SingleLinkedListImpl<String>("A","B","C","D","E","A");
		
		//LA PARTE QUE PODEMOS CONTROLAR ES LA DE LA EXCEPCIÓN
		//PREGUNTAR SI DEBERÍA DEJAR INSERTAR LAS @ 

		return Stream.of(
					Arguments.of(s1,lista1,"@",4),
					Arguments.of(s2,lista1,"A",4),
					Arguments.of(s3,lista1,"B",4),
					Arguments.of(s4,lista1,"M",4),
					Arguments.of(s5,lista1,"Y",4),
					Arguments.of(s6,lista1,"Z",4),
					Arguments.of(s7,lista1,"[",4),
					Arguments.of(s2,lista1,"A",-4),
					// ¿HACER LOS VALORES LIMITES DE POS ? O 0 Y <1 SE CONTEMPLA COMO UN UNICO CASO DE PRUEBA?
					Arguments.of(s8,lista1,"A",13)
					
				);
	}
	
//--------------------------------------
	
	@DisplayName("Probando addNTimes()")
	@ParameterizedTest
	@MethodSource("ArgumentosAddNTimes")
	void testAddNTimes(int num,SingleLinkedListImpl<String> listaModificada, SingleLinkedListImpl<String> list,String elem)  {
		try {
		list.addNTimes(elem,num);
		assertEquals(listaModificada,list);
		}catch(IllegalArgumentException  e) {
			assertThrows(NoSuchElementException .class, ()-> { 
				list.addNTimes(elem,num);
			});
		}
	}
	
	static Stream<Arguments> ArgumentosAddNTimes(){
		
		AbstractSingleLinkedListImpl<String> s1 = new SingleLinkedListImpl<String>("A","B","C","D","E","@");
		AbstractSingleLinkedListImpl<String> s2 = new SingleLinkedListImpl<String>("A","B","C","D","E","A","A");
		AbstractSingleLinkedListImpl<String> s3 = new SingleLinkedListImpl<String>("A","B","C","D","E","B","B");
		AbstractSingleLinkedListImpl<String> s4 = new SingleLinkedListImpl<String>("A","B","C","D","E","M","M");
		AbstractSingleLinkedListImpl<String> s5 = new SingleLinkedListImpl<String>("A","B","C","D","E","Y","Y");
		AbstractSingleLinkedListImpl<String> s6 = new SingleLinkedListImpl<String>("A","B","C","D","E","Z","Z");
		AbstractSingleLinkedListImpl<String> s7 = new SingleLinkedListImpl<String>("A","B","C","D","E","[","[");

		return Stream.of(
					
				Arguments.of(1,s1,lista1,"@"),
				Arguments.of(2,s2,lista1,"A"),
				Arguments.of(2,s3,lista1,"B"),
				Arguments.of(2,s4,lista1,"M"),
				Arguments.of(2,s5,lista1,"Y"),
				Arguments.of(2,s6,lista1,"Z"),
				Arguments.of(2,s7,lista1,"["),
				Arguments.of(0,s2,lista1,"Z")
				);
	}
	
	
	
	
	
	
	
	
	
	
}
