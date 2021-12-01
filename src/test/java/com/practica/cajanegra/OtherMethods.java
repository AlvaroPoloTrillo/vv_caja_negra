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
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import com.cajanegra.AbstractSingleLinkedListImpl;
import com.cajanegra.SingleLinkedListImpl;

class OtherMethods {

	private static SingleLinkedListImpl<String> lista0;
	private static SingleLinkedListImpl<String> lista1;
	private static SingleLinkedListImpl<String> lista2;
	private static SingleLinkedListImpl<String> lista3;
	private static SingleLinkedListImpl<String> lista4;
	private static SingleLinkedListImpl<String> lista5;
	private static SingleLinkedListImpl<String> lista6;

	private static SingleLinkedListImpl<String> listaVacia;

	// A PESAR DE LA LISTA CON @ NO ES UNA LISTA VALIDA EN NUESTRO RANGO (QUE NO
	// DEBERIA PASAR EL TEST) DE VALORES TENEMOS QUE PROBARLA PARA QUE SEA WORST
	// ROBUST

	@BeforeEach
	void setUp() {
		lista0 = new SingleLinkedListImpl<String>("A", "B", "C", "@");
		lista1 = new SingleLinkedListImpl<String>("A", "B", "C", "A");
		lista2 = new SingleLinkedListImpl<String>("A", "B", "C", "B");
		lista3 = new SingleLinkedListImpl<String>("A", "B", "C", "M");
		lista4 = new SingleLinkedListImpl<String>("A", "B", "C", "Y");
		lista5 = new SingleLinkedListImpl<String>("A", "B", "C", "Z");
		lista6 = new SingleLinkedListImpl<String>("A", "B", "C", "[");
		listaVacia = new SingleLinkedListImpl<String>();

	}

	@DisplayName("Probando IndexOf()")
	@ParameterizedTest
	@MethodSource("ArgumentosIndexOf")
	void testIndexOf(int num, SingleLinkedListImpl<String> list, String elem) {
		try {
			assertEquals(num, list.indexOf(elem));
		} catch (NoSuchElementException e) {
			assertThrows(NoSuchElementException.class, () -> {
				list.indexOf(elem);
			});
		}
	}

	static Stream<Arguments> ArgumentosIndexOf() {

		return Stream.of(Arguments.of(4, lista0, "@"), Arguments.of(1, lista1, "A"), Arguments.of(2, lista2, "B"),
				Arguments.of(4, lista3, "M"), Arguments.of(4, lista4, "Y"), Arguments.of(4, lista5, "Z"),
				Arguments.of(4, lista6, "["), Arguments.of(3, lista3, "T"));
	}

	// -----------------------------------------
	
	
	static Stream<Arguments> ArgumentosSize2() {
		
		lista1 = new SingleLinkedListImpl<String>("A", "B", "C", "A");
		listaVacia = new SingleLinkedListImpl<String>();
		
		return Stream.of(Arguments.of(4, lista1),
				Arguments.of(0, listaVacia)
		);
	}

	@DisplayName("Probando size2()")
	@ParameterizedTest
	@MethodSource("ArgumentosSize2")
	void testSize2(int tam, SingleLinkedListImpl<String> list) {
		assertEquals(tam, list.size());
	}

// -----------------------------

	@DisplayName("Probando toString()")
	@ParameterizedTest
	@MethodSource("ArgumentosToString")
	void PruebatoString(String l, SingleLinkedListImpl<String> list) {
		assertEquals(l, list.toString());
	}

	static Stream<Arguments> ArgumentosToString() {

		return Stream.of(Arguments.of("[A, B, C, A]", lista1), Arguments.of("[]", listaVacia));
	}

	// -----------------------------

	@DisplayName("Probando isEmpty()")
	@ParameterizedTest
	@MethodSource("ArgumentosIsEmpty")
	void testIsEmpty(boolean valor, SingleLinkedListImpl<String> list) {
		assertEquals(valor, list.isEmpty());
	}

	static Stream<Arguments> ArgumentosIsEmpty() {

		return Stream.of(Arguments.of(false, lista1), Arguments.of(true, listaVacia));
	}

	// ---------------------------------

	@DisplayName("Probando reverse()")
	@ParameterizedTest
	@MethodSource("ArgumentosReverse")
	void testReverse(SingleLinkedListImpl<String> listaInvertida, SingleLinkedListImpl<String> lista) {

		assertEquals(listaInvertida.toString(), lista.reverse().toString());
	}

	static Stream<Arguments> ArgumentosReverse() {

		SingleLinkedListImpl<String> lista0I = new SingleLinkedListImpl<String>("@", "C", "B", "A");
		SingleLinkedListImpl<String> lista1I = new SingleLinkedListImpl<String>("A", "C", "B", "A");
		SingleLinkedListImpl<String> lista2I = new SingleLinkedListImpl<String>("B", "C", "B", "A");
		SingleLinkedListImpl<String> lista3I = new SingleLinkedListImpl<String>("M", "C", "B", "A");
		SingleLinkedListImpl<String> lista4I = new SingleLinkedListImpl<String>("Y", "C", "B", "A");
		SingleLinkedListImpl<String> lista5I = new SingleLinkedListImpl<String>("Z", "C", "B", "A");
		SingleLinkedListImpl<String> lista6I = new SingleLinkedListImpl<String>("[", "C", "B", "A");
		SingleLinkedListImpl<String> listaVacia2 = new SingleLinkedListImpl<String>();

		return Stream.of(Arguments.of(lista0I, lista0), Arguments.of(lista1I, lista1), Arguments.of(lista2I, lista2),
				Arguments.of(lista3I, lista3), Arguments.of(lista4I, lista4), Arguments.of(lista5I, lista5),
				Arguments.of(lista6I, lista6), Arguments.of(listaVacia2, listaVacia));
	}

}
